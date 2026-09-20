package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.Deployer;
import com.example.waspwingtempctrl.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 状态页：部署状态 / 一键部署 / 卸载部署 / 拉起守护进程 / su 诊断。
 *
 * <p>逻辑与线 C 接线时完全一致，只是从 Activity 挪进 Fragment、并套上 Material 外观：
 * <b>I5 调用边界原样保留</b> —— 本类只调 {@link Deployer} 的
 * {@code probe() / deploy() / uninstall() / startDaemon() / buildDiagnostics() / ensureRoot() /
 * updateScript()}，不拼 shell、不碰文件、不绕过 {@code Deployer}。
 *
 * <p>{@link Deployer} 的方法都阻塞，故一律放后台线程；结果回主线程渲染。
 *
 * <p><b>首次启动的 root 尝试</b>：{@code root_tried} 标记落盘，只试一次；被拒或失败都不再
 * 自动重试（否则每次冷启动都弹系统授权框）。成功则弹窗问是否立即一键部署。
 *
 * <p><b>脚本自动纠正</b>：{@code service.d} 脚本是纯文本、可无损重推，故探测到它与 APK 内
 * 资源哈希不一致时自动重推一次（<b>不动二进制</b> —— 重推二进制要重启守护进程，代价高得多，
 * 那种情况仍走用户手动「一键部署」）。
 */
public class StatusFragment extends Fragment {

    /** 首次启动 root 尝试的一次性标记。 */
    private static final String PREFS_ROOT = "root_probe";
    private static final String KEY_ROOT_TRIED = "root_tried";

    private TextView statusView;
    private TextView infoView;
    private TextView logView;
    private TextView arrowView;
    private View progress;

    /** 操作记录是否展开（默认收起）。 */
    private boolean logExpanded;
    /** 本实例是否已做过「首次探测（含 root 尝试）」。 */
    private boolean firstProbeDone;
    /** 后台任务里置位、主线程回调读取：本次刚拿到 root 授权，需弹部署确认。 */
    private volatile boolean rootJustGranted;

    /** 当前在跑的后台动作；非 null 且存活时拒绝并发触发。 */
    private Thread worker;

    private static final SimpleDateFormat TIME_FMT =
            new SimpleDateFormat("HH:mm:ss", Locale.US);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        statusView = view.findViewById(R.id.status_text);
        infoView = view.findViewById(R.id.info_text);
        logView = view.findViewById(R.id.action_log_text);
        arrowView = view.findViewById(R.id.action_log_arrow);
        progress = view.findViewById(R.id.status_progress);

        view.findViewById(R.id.action_log_header).setOnClickListener(
                v -> setLogExpanded(!logExpanded));
        setLogExpanded(false);

        infoView.setText(buildInfo());

        view.findViewById(R.id.btn_refresh).setOnClickListener(v -> refreshStatus());
        view.findViewById(R.id.btn_deploy).setOnClickListener(v -> deploy());
        view.findViewById(R.id.btn_uninstall).setOnClickListener(v -> uninstall());
        view.findViewById(R.id.btn_start).setOnClickListener(v -> startDaemon());
        view.findViewById(R.id.btn_diag).setOnClickListener(v -> showDiagnostics());

        // 滚动条常显 + 加粗（见 fragment_status.xml），这里才接得上"按住滚动条拖动"
        ScrollbarDrag.attach(view.findViewById(R.id.status_scroll));
    }

    @Override
    public void onResume() {
        super.onResume();
        // 第一次进来连带做一次 root 尝试，之后只刷新状态（避免每次回前台都弹授权框）
        if (firstProbeDone) {
            refreshStatus();
        } else {
            firstProbeDone = true;
            firstProbe();
        }
    }

    @Override
    public void onDestroyView() {
        worker = null;
        statusView = null;
        infoView = null;
        logView = null;
        arrowView = null;
        progress = null;
        super.onDestroyView();
    }

    // ==================== 动作（全部在后台线程） ====================

    // context 一律在主线程取出后捕获进闭包：后台线程里再调 requireContext() 会在已 detach 时抛异常。

    /** 首次探测：先试一次 root（只此一次），再探部署状态。 */
    private void firstProbe() {
        final Context app = requireContext().getApplicationContext();
        final SharedPreferences prefs = app.getSharedPreferences(PREFS_ROOT, Context.MODE_PRIVATE);
        final boolean needRoot = !prefs.getBoolean(KEY_ROOT_TRIED, false);
        if (needRoot) {
            // 先落标记再尝试：被拒/失败都不再自动重试
            prefs.edit().putBoolean(KEY_ROOT_TRIED, true).apply();
        }
        runAsync(getString(R.string.status_busy_probe), () -> {
            StringBuilder sb = new StringBuilder();
            if (needRoot) {
                rootJustGranted = Deployer.get(app).ensureRoot();
                sb.append(app.getString(rootJustGranted
                        ? R.string.status_root_ok_log : R.string.status_root_fail_log)).append("\n\n");
            }
            sb.append(probeAndAutoFixScript(app));
            return sb.toString();
        });
    }

    private void refreshStatus() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_probe), () -> probeAndAutoFixScript(app));
    }

    /**
     * 探测部署状态；脚本哈希不一致且 su 可用时自动重推脚本，再复探一次。
     *
     * @return 可直接上屏的文本
     */
    private String probeAndAutoFixScript(Context app) {
        final Deployer deployer = Deployer.get(app);
        final Deployer.Status status = deployer.probe();
        // su 不可用时不尝试（否则每次进页面都白撞一次授权框）
        if (!status.suOk || !status.scriptPresent || status.scriptHashOk) {
            return status.describe();
        }
        final String head = app.getString(deployer.updateScript().ok
                ? R.string.status_script_autofixed : R.string.status_script_autofix_failed);
        return head + "\n\n" + deployer.probe().describe();
    }

    /**
     * 部署：跑完部署动作后<b>重新探测</b>，把探测结果上屏——不再把部署动作日志（含步骤列表）
     * 灌进状态区：部署成没成看状态文本就够，步骤细节在「诊断信息」里。
     */
    private void deploy() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_deploy), () -> {
            Deployer deployer = Deployer.get(app);
            deployer.deploy();
            return deployer.probe().describe();
        });
    }

    private void uninstall() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_uninstall),
                () -> Deployer.get(app).uninstall().describe());
    }

    private void startDaemon() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_start),
                () -> Deployer.get(app).startDaemon().describe());
    }

    private void showDiagnostics() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_diag),
                () -> Deployer.get(app).buildDiagnostics(), true);
    }

    private void runAsync(final String busyText, final Task task) {
        runAsync(busyText, task, false);
    }

    /**
     * 后台跑一次阻塞任务，把结果写进状态区。
     *
     * @param asDialog true 时结果弹对话框（诊断类文本较长，状态区放不下）
     */
    private void runAsync(final String busyText, final Task task, final boolean asDialog) {
        if (worker != null && worker.isAlive()) {
            appendLog(getString(R.string.status_busy_other));
            return;
        }
        final Context appContext = requireContext().getApplicationContext();
        statusView.setText(busyText);
        setBusy(true);
        appendLog(busyText);
        Thread thread = new Thread(() -> {
            String text;
            boolean failed = false;
            try {
                text = task.run();
            } catch (Throwable t) {
                text = "出错：" + t;
                failed = true;
            }
            final String result = text;
            final boolean isFailure = failed;
            android.app.Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(() -> {
                if (!isAdded() || statusView == null) {
                    return;
                }
                setBusy(false);
                appendLog(result);
                if (asDialog || isFailure) {
                    new AlertDialog.Builder(appContext)
                            .setTitle(isFailure ? R.string.status_dialog_failed
                                    : R.string.status_dialog_diag)
                            .setMessage(result)
                            .setPositiveButton(R.string.status_dialog_close, null)
                            .show();
                } else {
                    statusView.setText(result);
                }
                if (rootJustGranted) {
                    rootJustGranted = false;
                    // 刚拿到授权：状态区已显示"root 可用"，这里只问要不要顺势部署
                    showDeployPrompt();
                }
            });
        }, "ww-deploy");
        thread.setDaemon(true);
        worker = thread;
        thread.start();
    }

    private interface Task {
        String run() throws Exception;
    }

    // ==================== 操作记录折叠 ====================

    private void setLogExpanded(boolean value) {
        logExpanded = value;
        if (logView != null) {
            logView.setVisibility(value ? View.VISIBLE : View.GONE);
        }
        if (arrowView != null) {
            arrowView.setText(value
                    ? R.string.config_arrow_expanded : R.string.config_arrow_collapsed);
            arrowView.setContentDescription(getString(value
                    ? R.string.config_action_collapse : R.string.config_action_expand));
        }
    }

    // ==================== 渲染小工具 ====================

    private void setBusy(boolean busy) {
        if (progress != null) {
            progress.setVisibility(busy ? View.VISIBLE : View.GONE);
        }
    }

    /** 追加一条操作记录，带秒级时间戳（新的在上）。 */
    private void appendLog(String text) {
        if (logView == null) {
            return;
        }
        String old = logView.getText().toString();
        String merged = "[" + TIME_FMT.format(new Date()) + "] " + text + "\n\n" + old;
        if (merged.length() > 8000) {
            merged = merged.substring(0, 8000) + "\n…（已截断）";
        }
        logView.setText(merged);
    }

    /** 拿到 root 后问是否立即部署（文案见 strings.xml；不需要则不打扰）。 */
    private void showDeployPrompt() {
        if (!isAdded()) {
            return;
        }
        new AlertDialog.Builder(requireContext())
                .setTitle(R.string.status_root_ok_title)
                .setMessage(R.string.status_root_ok_message)
                .setPositiveButton(R.string.status_action_deploy, (d, w) -> deploy())
                .setNegativeButton(R.string.status_root_later, null)
                .show();
    }

    /** 设备与版本：不显示本应用包名，版本按「模块版本」标注，不显示 targetSdk。 */
    private String buildInfo() {
        String versionName = "?";
        long versionCode = -1;
        try {
            PackageInfo info = requireContext().getPackageManager()
                    .getPackageInfo(requireContext().getPackageName(), 0);
            versionName = info.versionName;
            versionCode = Build.VERSION.SDK_INT >= 28 ? info.getLongVersionCode() : info.versionCode;
        } catch (Exception ignored) {
            // 保持占位符
        }
        return getString(R.string.status_info_version, versionName, versionCode)
                + "\n" + getString(R.string.status_info_device, Build.MANUFACTURER, Build.MODEL)
                + "\n" + getString(R.string.status_info_android, Build.VERSION.RELEASE,
                Build.VERSION.SDK_INT);
    }
}
