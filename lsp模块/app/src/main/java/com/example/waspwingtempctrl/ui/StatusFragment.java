package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.waspwingtempctrl.Deployer;
import com.example.waspwingtempctrl.PageAware;
import com.example.waspwingtempctrl.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 状态页：部署状态 / 一键部署 / 卸载部署 / 拉起daemon / 停止daemon / su 诊断。
 *
 * <p>逻辑与线 C 接线时完全一致，只是从 Activity 挪进 Fragment、并套上 Material 外观：
 * <b>I5 调用边界原样保留</b> —— 本类只调 {@link Deployer} 的
 * {@code probe() / deploy() / uninstall() / startDaemon() / stopDaemon() / buildDiagnostics() /
 * ensureRoot() / updateScript()}，不拼 shell、不碰文件、不绕过 {@code Deployer}。
 *
 * <p>{@link Deployer} 的方法都阻塞，故一律放后台线程；结果回主线程渲染。
 *
 * <p><b>首次启动的 root 尝试</b>：{@code root_tried} 标记落盘，只试一次；被拒或失败都不再
 * 自动重试（否则每次冷启动都弹系统授权框）。成功则弹窗问是否立即一键部署。
 *
 * <p><b>脚本自动纠正</b>：{@code service.d} 脚本是纯文本、可无损重推，故探测到它与 APK 内
 * 资源哈希不一致时自动重推一次（<b>不动二进制</b> —— 重推二进制要重启守护进程，代价高得多，
 * 那种情况改由弹窗请求用户部署，见 {@link #armHashMismatchPrompt}）。
 *
 * <h3>刷新分两条路径（消闪烁）</h3>
 * 状态区是<b>单个 TextView</b>、卡片 {@code wrap_content}，一旦把约 8 行的结果换成 1 行忙文本，
 * 状态卡立刻变矮、其下两张卡整体上跳再回落 —— 这是"每次回状态页闪一下"的根因。故：
 * <ul>
 *   <li><b>静默路径</b>（{@code onResume} / 首次探测）：不碰状态区文本、不写操作记录、不做动画，
 *       结果先比后写（内容没变就一个字都不动）；30 秒内不重复跑 su 探测。</li>
 *   <li><b>手动路径</b>（用户点按钮）：写操作记录 + 结果文本淡出→换文本（带高度补间）→淡入。</li>
 * </ul>
 * <b>进度条两条路径都显示</b>（它是刷新唯一的反馈），且它在布局里常占位、可见性只影响绘制，
 * 故开关它不引起任何高度变化 —— 高度变化只来自手动路径的文本补间，那是要的效果而非闪烁。
 * 切页时外壳（{@code SetupActivity}）广播可见性，本类据此收掉在跑的动画（{@link PageAware}）。
 */
public class StatusFragment extends Fragment implements PageAware {

    /**
     * 一次性落盘标记的 prefs 文件名与键都定义在 {@link Deployer}（跨包收口，键名只有一处）：
     * {@link Deployer#PREFS_ROOT_PROBE} 文件里放首次 root 尝试（{@link Deployer#KEY_ROOT_TRIED}）、
     * 哈希提示去重（{@link Deployer#KEY_HASH_PROMPTED_MD5}）与设备侧二进制 md5
     * （{@link Deployer#KEY_BIN_DEPLOYED_MD5}，本页只写不读）。
     */

    /** 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下（同配置页分组卡头）。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    /** 静默刷新的最小间隔：30 秒内的重复触发不再跑 su 探测（该路径会顺带自动重推脚本）。 */
    private static final long PROBE_MIN_INTERVAL_MS = 30_000L;
    /** 手动刷新时文本淡出 / 淡入各自的时长。 */
    private static final long FADE_MS = 150L;

    /**
     * 版本行的成品文案（`status_info_version` 已格式化）；null = 尚未从 PMS 读到。
     * 进程内版本不会变，故读一次就够——读它要 binder IPC（`getPackageInfo`），只在后台做。
     */
    private static volatile String versionLine;

    private TextView statusView;
    private TextView infoView;
    private TextView logView;
    /** 操作记录的正文容器（自适应高、无内部滚动，同诊断卡）；展开/收起切的是它的可见性。 */
    private View logBody;
    private ImageView arrowView;
    private View progress;
    /** 三张卡的共同父容器：文本行数变化时的高度补间在这个范围内做。 */
    private ViewGroup contentRoot;

    /** 操作记录是否展开（默认收起）。 */
    private boolean logExpanded;
    /** 本实例是否已做过「首次探测（含 root 尝试）」。 */
    private boolean firstProbeDone;
    /** 后台任务里置位、主线程回调读取：本次刚拿到 root 授权，需弹部署确认。 */
    private volatile boolean rootJustGranted;
    /** 后台任务里置位、主线程回调读取：二进制哈希不一致，且本 APK 版本尚未提示过。 */
    private volatile boolean hashMismatchPending;
    /** 后台任务里置位、主线程回调读取：本次部署判定是否成功（决定要不要接着自动拉起，见 {@link #deploy()}）。 */
    private volatile boolean deployOk;
    /** 上次探测的开始时刻（手动与静默共用）；静默刷新据此节流。内存态，进程重启即失效。 */
    private long lastProbeAtMs;
    /** 淡入淡出代号：每次新动画递增，回调里对不上号即作废（连续刷新时两段动画不交叠）。 */
    private int fadeGeneration;

    /**
     * 是否有动作在跑（结果还没回到主线程）；为 true 时拒绝并发触发。
     *
     * <p><b>为什么不是"那条线程还活着"</b>：结果上屏后紧接着还要接一段（部署→自动拉起，见
     * {@link #deploy()}），而那一刻线程刚 post 完、往往还没真正结束——按"线程存活"判会把该接的一段
     * 挡在门外。这里只管"本页同时只有一个动作"：主线程置位于开跑，结果上屏时清除。
     */
    private boolean actionRunning;

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
        logBody = view.findViewById(R.id.action_log_body);
        arrowView = view.findViewById(R.id.action_log_arrow);
        progress = view.findViewById(R.id.status_progress);
        contentRoot = view.findViewById(R.id.status_content);

        view.findViewById(R.id.action_log_header).setOnClickListener(
                v -> setLogExpanded(!logExpanded));
        setLogExpanded(false);

        infoView.setText(buildInfo());
        loadVersionLineAsync();

        // 手动路径：写操作记录 + 结果文本淡入淡出（静默路径不走这两处；进度条两条路径都走）
        view.findViewById(R.id.btn_refresh).setOnClickListener(v -> refreshStatus(true));
        view.findViewById(R.id.btn_deploy).setOnClickListener(v -> deploy());
        view.findViewById(R.id.btn_uninstall).setOnClickListener(v -> confirmUninstall());
        view.findViewById(R.id.btn_stop).setOnClickListener(v -> confirmStopDaemon());
        view.findViewById(R.id.btn_start).setOnClickListener(v -> startDaemon());
        view.findViewById(R.id.btn_diag).setOnClickListener(v -> showDiagnostics());

        // 滚动条常显 + 加粗（见 fragment_status.xml），这里才接得上"按住滚动条拖动"
        ScrollbarDrag.attach(view.findViewById(R.id.status_scroll));
        // 操作记录已是自适应高、无内部滚动（同诊断卡），故不再需要
        // PageScrollView.yieldVerticalDragTo：没有内层可滚动区，就不存在手势相争。
        // 页面根保持 PageScrollView（配置页的曲线拖柄仍在用它）。
    }

    @Override
    public void onPageVisible(boolean visible) {
        // 非当前页只是被压到 STARTED（不派发 onPause），故这里不做刷新：
        // 刷新统一由 onResume 那条（并已节流）；这里只把在跑的淡入淡出收掉。
        if (!visible) {
            cancelFade();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 第一次进来连带做一次 root 尝试，之后只刷新状态（避免每次回前台都弹授权框）。
        // 两条都走静默路径：外壳每切回本页都会派发 onResume，手动路径的动画/记录不该被它触发。
        if (firstProbeDone) {
            refreshStatus(false);
        } else {
            firstProbeDone = true;
            firstProbe();
        }
    }

    @Override
    public void onDestroyView() {
        actionRunning = false;
        // 先收掉动画并复位透明度：回调里判空就返回，不给已销毁的视图留半透明残影
        cancelFade();
        statusView = null;
        infoView = null;
        logView = null;
        logBody = null;
        arrowView = null;
        progress = null;
        contentRoot = null;
        super.onDestroyView();
    }

    // ==================== 动作（全部在后台线程） ====================

    // context 一律在主线程取出后捕获进闭包：后台线程里再调 requireContext() 会在已 detach 时抛异常。

    /** 首次探测：先试一次 root（只此一次），再探部署状态。静默路径（不写记录、不做动画）。 */
    private void firstProbe() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_probe), () -> {
            // prefs 首读要走磁盘（首次加载 XML），与 root 尝试一并放后台线程
            SharedPreferences prefs =
                    app.getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
            boolean needRoot = !prefs.getBoolean(Deployer.KEY_ROOT_TRIED, false);
            StringBuilder sb = new StringBuilder();
            if (needRoot) {
                // 先落标记再尝试：被拒/失败都不再自动重试
                prefs.edit().putBoolean(Deployer.KEY_ROOT_TRIED, true).apply();
                rootJustGranted = Deployer.get(app).ensureRoot();
                sb.append(app.getString(rootJustGranted
                        ? R.string.status_root_ok_log : R.string.status_root_fail_log)).append("\n\n");
            }
            sb.append(probeAndAutoFixScript(app));
            return sb.toString();
        }, false, false);
    }

    /**
     * 刷新部署状态。
     *
     * @param manual true = 用户点了「刷新状态」：写操作记录 + 结果淡入淡出；
     *               false = 非手动（{@code onResume}，外壳每次切回本页都会派发）：
     *               静默刷新（不写记录、不碰文本、不做动画），
     *               且 {@link #PROBE_MIN_INTERVAL_MS} 内的重复触发直接跳过
     */
    private void refreshStatus(boolean manual) {
        if (!manual && System.currentTimeMillis() - lastProbeAtMs < PROBE_MIN_INTERVAL_MS) {
            return;   // 刚探过：su 往返（含可能自动重推 service.d 脚本）不必再来一次
        }
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_probe),
                () -> probeAndAutoFixScript(app), false, manual);
    }

    /**
     * 探测部署状态；脚本哈希不一致且 su 可用时自动重推脚本，再复探一次。
     *
     * <p>副作用：末尾按最终状态武装「二进制哈希不一致」提示（见 {@link #armHashMismatchPrompt}）。
     * 无论走静默还是手动路径都执行 —— 该提示正是"探测才发现的事"，只在真正不一致时出现，
     * 且同一个 APK 版本最多一次。
     *
     * @return 可直接上屏的文本
     */
    private String probeAndAutoFixScript(Context app) {
        final Deployer deployer = Deployer.get(app);
        Deployer.Status status = deployer.probe();
        final String head;
        // su 不可用时不尝试（否则每次进页面都白撞一次授权框）
        if (status.suOk && status.scriptPresent && !status.scriptHashOk) {
            head = app.getString(deployer.updateScript().ok
                    ? R.string.status_script_autofixed : R.string.status_script_autofix_failed) + "\n\n";
            status = deployer.probe();
        } else {
            head = "";
        }
        armHashMismatchPrompt(app, status);
        rememberDeployedBinMd5(app, status);
        return head + status.describe();
    }

    /**
     * 探测确认设备上二进制与 APK 内一致时，把设备侧 md5 落盘 —— 这是「需要重新部署」判定的缓存，
     * 供下次冷启动落页用（见 {@link Deployer#needsRedeploy}）。
     *
     * <p>判据与提示判据互补、互不重叠：一致才记，不一致留给 {@link #armHashMismatchPrompt} 的部署请求；
     * 没部署过（二进制不存在）时探测到的 md5 为空，{@link Deployer#rememberDeployedBinMd5} 会拒写。
     */
    private static void rememberDeployedBinMd5(Context app, Deployer.Status status) {
        if (status.binExists && status.binHashOk) {
            Deployer.rememberDeployedBinMd5(app, status.binMd5);
        }
    }

    /**
     * 部署：跑完部署动作后<b>重新探测</b>，把探测结果上屏——不再把部署动作日志（含步骤列表）
     * 灌进状态区：部署成没成看状态文本就够，步骤细节在「诊断信息」里。
     *
     * <p><b>随后自动「点」一次拉起daemon</b>（{@link #startDaemon()}）：{@link Deployer#deploy()}
     * 只把新二进制换到盘上，不重启进程它就一直跑旧映像。这一段是<b>独立的一份</b>——自己的忙态文案、
     * 自己的操作记录、自己的一次进度条起停，与手动点「拉起daemon」完全是同一条路径，
     * 不是把部署那一趟拉长。
     * 部署判定失败（{@code ok=false}）时<b>不接</b>：盘上没换成功，重启旧映像没有意义。
     */
    private void deploy() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_deploy), () -> {
            Deployer deployer = Deployer.get(app);
            deployOk = deployer.deploy().ok;
            return deployer.probe().describe();
        }, false, true, () -> {
            if (deployOk) {
                startDaemon();
            }
        });
    }

    private void uninstall() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_uninstall),
                () -> Deployer.get(app).uninstall().describe(), false, true);
    }

    private void startDaemon() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_start),
                () -> Deployer.get(app).startDaemon().describe(), false, true);
    }

    private void stopDaemon() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_stop),
                () -> Deployer.get(app).stopDaemon().describe(), false, true);
    }

    private void showDiagnostics() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_diag),
                () -> Deployer.get(app).buildDiagnostics(), true, true);
    }

    // ==================== 破坏性动作的二次确认 ====================

    /**
     * 点「确认」才执行、点「取消」什么都不做。两个入口（卸载部署 / 停止daemon）都会让温控增强失效，
     * 且都是一次点击就落盘或杀进程，故都要先问一次。
     */
    private void confirmThen(int titleRes, int messageRes, int confirmRes, Runnable action) {
        if (!isAdded()) {
            return;
        }
        new AlertDialog.Builder(requireContext())
                .setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(confirmRes, (d, w) -> action.run())
                .setNegativeButton(R.string.status_dialog_cancel, null)
                .show();
    }

    /** 「卸载部署」的确认入口（动作本身见 {@link #uninstall()}）。 */
    private void confirmUninstall() {
        confirmThen(R.string.status_dialog_uninstall_title,
                R.string.status_dialog_uninstall_message,
                R.string.status_dialog_uninstall_confirm, this::uninstall);
    }

    /** 「停止daemon」的确认入口（动作本身见 {@link #stopDaemon()}）。 */
    private void confirmStopDaemon() {
        confirmThen(R.string.status_dialog_stop_title,
                R.string.status_dialog_stop_message,
                R.string.status_dialog_stop_confirm, this::stopDaemon);
    }

    /**
     * 后台跑一次阻塞任务，把结果写进状态区。
     *
     * @param busyText 忙态文案。<b>不进状态区</b>（把约 8 行的结果整段换成 1 行忙文本会让状态卡
     *                 高度塌陷、下面两张卡上跳再回落 —— 那是闪烁的根因），只在手动路径下
     *                 作为「操作记录」的一条
     * @param asDialog true 时结果弹对话框（诊断类文本较长，状态区放不下）
     * @param manual   true = 用户主动触发：写操作记录 + 结果文本淡入淡出（含高度补间）；
     *                 false = 非手动刷新：不写记录、不碰文本（结果先比后写）、不做动画。
     *                 进度条两条路径都显示，且因常占位而不引起任何高度变化
     */
    private void runAsync(final String busyText, final Task task, final boolean asDialog,
                          final boolean manual) {
        runAsync(busyText, task, asDialog, manual, null);
    }

    /**
     * 同上，另可指定"结果上屏之后接着跑的动作"。
     *
     * @param after 结果上屏、占用释放之后要接着跑的动作（部署→自动拉起就靠它）；null = 没有。
     *              它在主线程、与用户下一次点击同一时机被调用，故里面可以直接调
     *              {@link #startDaemon()} 这类动作入口，不必自己绕开并发守卫
     */
    private void runAsync(final String busyText, final Task task, final boolean asDialog,
                          final boolean manual, @Nullable final Runnable after) {
        if (actionRunning) {
            if (manual) {
                appendLog(getString(R.string.status_busy_other));
            }
            return;
        }
        actionRunning = true;
        final Context appContext = requireContext().getApplicationContext();
        lastProbeAtMs = System.currentTimeMillis();
        setBusy(true);
        if (manual) {
            appendLog(busyText);
        }
        Thread thread = new Thread(() -> {
            String text;
            boolean failed = false;
            try {
                text = task.run();
            } catch (Throwable t) {
                text = "出错：" + t;
                failed = true;
            }
            // contentEquals 不接受 null（任务实现一律不返回 null，这里只是兜底）
            final String result = text == null ? "" : text;
            final boolean isFailure = failed;
            android.app.Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(() -> {
                if (!isAdded() || statusView == null) {
                    return;
                }
                // 结果已回到主线程：本动作到此结束，先放掉占用——紧接着要接的那一段（after）
                // 才不会被守卫挡在门外
                actionRunning = false;
                setBusy(false);
                if (manual) {
                    appendLog(result);
                }
                if (asDialog || isFailure) {
                    new AlertDialog.Builder(appContext)
                            .setTitle(isFailure ? R.string.status_dialog_failed
                                    : R.string.status_dialog_diag)
                            .setMessage(result)
                            .setPositiveButton(R.string.status_dialog_close, null)
                            .show();
                } else if (manual) {
                    swapStatusTextAnimated(result);
                } else if (!result.contentEquals(statusView.getText())) {
                    // 先比后写：内容没变就一个字都不动，连重绘都省掉
                    statusView.setText(result);
                }
                if (rootJustGranted) {
                    rootJustGranted = false;
                    // 刚拿到授权：状态区已显示"root 可用"，这里只问要不要顺势部署
                    showDeployPrompt();
                } else if (hashMismatchPending) {
                    hashMismatchPending = false;
                    showHashMismatchPrompt();
                }
                if (after != null) {
                    after.run();
                }
            });
        }, "ww-deploy");
        thread.setDaemon(true);
        thread.start();
    }

    private interface Task {
        String run() throws Exception;
    }

    /**
     * 判定是否需要为「二进制哈希不一致」弹一次部署请求（已部署过但内容与 APK 内不符）。
     *
     * <p><b>判据</b>：设备上存在二进制（{@code binExists}）且哈希对不上（{@code !binHashOk}）。
     * 二进制不存在＝还没部署过，走「一键部署」即可，不在此处打扰；
     * {@code binExpectedMd5} 为空＝APK 内资源缺失，无从比对。
     *
     * <p><b>去重</b>：把 APK 侧的 {@code expectedMd5} 落盘，同一个值最多提示一次。
     * 故「装了新 APK」体现为 expected 变了 → 重新武装提示；重装同一个 APK 不会重复打扰。
     * 设备侧哈希被改坏（expected 未变）时，用户在第一次提示后没部署就不再弹——
     * 这是"每版本最多一次"的必然含义，状态区里仍逐次列出两个哈希供比对。
     *
     * <p><b>先落标记再动作</b>（同 {@link #KEY_ROOT_TRIED}）：弹窗还没显示就已落盘，
     * 中途进程被杀也不会下次再弹。
     */
    private void armHashMismatchPrompt(Context app, Deployer.Status status) {
        hashMismatchPending = false;   // 每次探测重新判定，不留上一次的残留
        if (!status.binExists || status.binHashOk || status.binExpectedMd5.isEmpty()) {
            return;
        }
        final SharedPreferences prefs =
                app.getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
        if (status.binExpectedMd5.equals(prefs.getString(Deployer.KEY_HASH_PROMPTED_MD5, null))) {
            return;
        }
        prefs.edit().putString(Deployer.KEY_HASH_PROMPTED_MD5, status.binExpectedMd5).apply();
        hashMismatchPending = true;
    }

    // ==================== 操作记录折叠 ====================

    private void setLogExpanded(boolean value) {
        logExpanded = value;
        if (logBody != null) {
            // 切的是正文容器（自适应高、无内部滚动）；展开与否决定这块高度占不占位
            logBody.setVisibility(value ? View.VISIBLE : View.GONE);
        }
        if (arrowView != null) {
            arrowView.setRotation(value ? ARROW_EXPANDED_ROTATION : 0f);
            arrowView.setContentDescription(getString(value
                    ? R.string.config_action_collapse : R.string.config_action_expand));
        }
    }

    // ==================== 渲染小工具 ====================

    /**
     * 忙态指示：所有刷新路径（手动与静默）都开它——它是刷新唯一的反馈。
     *
     * <p><b>为什么只切 {@code VISIBLE}/{@code INVISIBLE}、绝不用 {@code GONE}</b>：进度条在
     * 布局里是<b>常占位</b>的（{@code fragment_status.xml} 里初值即为 {@code invisible}），
     * 占的高度恒定不变，可见性只影响绘制。用 {@code GONE} 会让它参与测量，
     * 出现/消失就要改状态卡高度，下面两张卡跟着上下跳——那正是要消掉的现象。
     */
    private void setBusy(boolean busy) {
        if (progress != null) {
            progress.setVisibility(busy ? View.VISIBLE : View.INVISIBLE);
        }
    }

    /**
     * 手动刷新的结果上屏：文本淡出 → 换文本（顺带把高度变化补间）→ 淡入。
     *
     * <p><b>串行</b>：每次自增 {@link #fadeGeneration}，连点刷新不会让两段动画交叠。
     * 开头先复位 alpha，故中途打断也不残留半透明态。
     * <p><b>打断不丢结果</b>：淡出期间被打断（连点、切页）时只跳过动画与补间，
     * 文本照样上屏——否则这 150ms 里刷出来的结果会凭空消失。
     *
     * <p><b>只碰本页视图树</b>：窗口级设置（{@code softInputMode}）是 Activity 级的、
     * 由 {@code LogFragment} 的软键盘逻辑接管，此处一概不动。
     */
    private void swapStatusTextAnimated(final String text) {
        final TextView view = statusView;
        if (view == null || !isAdded()) {
            return;
        }
        final int generation = ++fadeGeneration;
        final ViewGroup root = contentRoot;
        view.animate().cancel();
        view.setAlpha(1f);
        view.animate().alpha(0f).setDuration(FADE_MS).withEndAction(() -> {
            if (statusView == null || !isAdded()) {
                return;   // 视图已销毁，无处上屏（onDestroyView 已复位）
            }
            final boolean interrupted = generation != fadeGeneration;
            if (!interrupted && root != null) {
                // 行数变化会改状态卡高度；不补间，下面两张卡就会"跳一下"
                TransitionManager.beginDelayedTransition(root, new AutoTransition());
            }
            statusView.setText(text);
            if (interrupted) {
                statusView.setAlpha(1f);
            } else {
                statusView.animate().alpha(1f).setDuration(FADE_MS).start();
            }
        }).start();
    }

    /** 作废在跑的淡入淡出并把文本复位到不透明（离开本页 / 视图销毁时收尾）。 */
    private void cancelFade() {
        fadeGeneration++;
        if (statusView != null) {
            statusView.animate().cancel();
            statusView.setAlpha(1f);
        }
    }

    /** 二进制哈希不一致：请求重新部署（去重见 {@link #armHashMismatchPrompt}）。 */
    private void showHashMismatchPrompt() {
        if (!isAdded()) {
            return;
        }
        new AlertDialog.Builder(requireContext())
                .setTitle(R.string.status_hash_title)
                .setMessage(R.string.status_hash_message)
                .setPositiveButton(R.string.status_action_deploy, (d, w) -> deploy())
                .setNegativeButton(R.string.status_root_later, null)
                .show();
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
        String cached = versionLine;
        return (cached != null ? cached : placeholderVersionLine(requireContext()))
                + "\n" + getString(R.string.status_info_device, Build.MANUFACTURER, Build.MODEL)
                + "\n" + getString(R.string.status_info_android, Build.VERSION.RELEASE,
                Build.VERSION.SDK_INT);
    }

    /**
     * 后台读一次版本行并缓存，读完回主线程补上。
     *
     * <p>{@code getPackageInfo} 是 binder IPC，主线程不碰；已有缓存则直接返回。补上的是同一行
     * 文本（占位符 → 真实版本号），行数不变，故不会引起卡片高度变化。
     */
    private void loadVersionLineAsync() {
        if (versionLine != null) {
            return;
        }
        final Context app = requireContext().getApplicationContext();
        Thread thread = new Thread(() -> {
            versionLine = readVersionLine(app);
            android.app.Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(() -> {
                if (!isAdded() || infoView == null) {
                    return;
                }
                infoView.setText(buildInfo());
            });
        }, "ww-version");
        thread.setDaemon(true);
        thread.start();
    }

    /** 读 versionName / versionCode 并格式化；读不到时给占位行。阻塞（binder IPC），只在后台调。 */
    private static String readVersionLine(Context app) {
        try {
            PackageInfo info = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
            String versionName = info.versionName;
            long versionCode = Build.VERSION.SDK_INT >= 28
                    ? info.getLongVersionCode() : info.versionCode;
            return app.getString(R.string.status_info_version, versionName, versionCode);
        } catch (Exception ignored) {
            return placeholderVersionLine(app);
        }
    }

    /** 版本行的占位形态（PMS 读不到 / 尚未读到）；与真实行同形，故补上真实值不改行数。 */
    private static String placeholderVersionLine(Context context) {
        return context.getString(R.string.status_info_version, "?", -1L);
    }
}
