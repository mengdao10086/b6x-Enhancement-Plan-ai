package com.example.waspwingtempctrl.ui;

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

/**
 * 状态页：部署状态 / 一键部署 / 卸载部署 / 拉起守护进程 / su 诊断。
 *
 * <p>逻辑与线 C 接线时完全一致，只是从 Activity 挪进 Fragment、并套上 Material 外观：
 * <b>I5 调用边界原样保留</b> —— 本类只调 {@link Deployer} 的
 * {@code probe() / deploy() / uninstall() / startDaemon() / buildDiagnostics()}，
 * 不拼 shell、不碰文件、不绕过 {@code Deployer}。
 *
 * <p>{@link Deployer} 的方法都阻塞，故一律放后台线程；结果回主线程渲染。
 */
public class StatusFragment extends Fragment {

    private TextView statusView;
    private TextView infoView;
    private TextView logView;
    private View progress;

    /** 当前在跑的后台动作；非 null 且存活时拒绝并发触发。 */
    private Thread worker;

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
        progress = view.findViewById(R.id.status_progress);

        infoView.setText(buildInfo());

        view.findViewById(R.id.btn_refresh).setOnClickListener(v -> refreshStatus());
        view.findViewById(R.id.btn_deploy).setOnClickListener(v -> deploy());
        view.findViewById(R.id.btn_uninstall).setOnClickListener(v -> uninstall());
        view.findViewById(R.id.btn_start).setOnClickListener(v -> startDaemon());
        view.findViewById(R.id.btn_diag).setOnClickListener(v -> showDiagnostics());
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshStatus();
    }

    @Override
    public void onDestroyView() {
        worker = null;
        statusView = null;
        infoView = null;
        logView = null;
        progress = null;
        super.onDestroyView();
    }

    // ==================== 动作（全部在后台线程） ====================

    // context 一律在主线程取出后捕获进闭包：后台线程里再调 requireContext() 会在已 detach 时抛异常。

    private void refreshStatus() {
        final android.content.Context ctx = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_probe),
                () -> Deployer.get(ctx).probe().describe());
    }

    private void deploy() {
        final android.content.Context ctx = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_deploy),
                () -> Deployer.get(ctx).deploy().describe());
    }

    private void uninstall() {
        final android.content.Context ctx = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_uninstall),
                () -> Deployer.get(ctx).uninstall().describe());
    }

    private void startDaemon() {
        final android.content.Context ctx = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_start),
                () -> Deployer.get(ctx).startDaemon().describe());
    }

    private void showDiagnostics() {
        final android.content.Context ctx = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_diag),
                () -> Deployer.get(ctx).buildDiagnostics(), true);
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
        final android.content.Context appContext = requireContext().getApplicationContext();
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
            });
        }, "ww-deploy");
        thread.setDaemon(true);
        worker = thread;
        thread.start();
    }

    private interface Task {
        String run() throws Exception;
    }

    // ==================== 渲染小工具 ====================

    private void setBusy(boolean busy) {
        if (progress != null) {
            progress.setVisibility(busy ? View.VISIBLE : View.GONE);
        }
    }

    private void appendLog(String text) {
        if (logView == null) {
            return;
        }
        String old = logView.getText().toString();
        String merged = text + "\n\n" + old;
        if (merged.length() > 8000) {
            merged = merged.substring(0, 8000) + "\n…（已截断）";
        }
        logView.setText(merged);
    }

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
        return "包名: " + requireContext().getPackageName()
                + "\n版本: " + versionName + " (" + versionCode + ")"
                + "\n设备: " + Build.MANUFACTURER + " " + Build.MODEL
                + "\nAndroid: " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ")"
                + "\ntargetSdk: " + requireContext().getApplicationInfo().targetSdkVersion;
    }
}
