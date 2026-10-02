package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.Deployer;
import com.example.waspwingtempctrl.PageAware;
import com.example.waspwingtempctrl.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 状态页：部署状态 / 一键部署 / 卸载部署 / 拉起daemon / 停止daemon / su 诊断。
 *
 * <p><b>调用边界（I5 的另一半）</b>：本类只调 {@link Deployer} 的
 * {@code probe() / deploy() / uninstall() / startDaemon() / stopDaemon() / buildDiagnostics() /
 * ensureRoot() / updateScript()}，不拼 shell、不碰文件、不绕过 {@code Deployer}。
 * {@link Deployer} 的方法都阻塞，故一律放后台线程；结果回主线程渲染。
 *
 * <p>刷新两条路径（消闪烁）、首次探测的时机、忙态与代号纪律、部署请求的武装与去重、
 * 部署后自动接拉起：均见 {@code app/逻辑说明.md} §8.1。
 */
public class StatusFragment extends Fragment implements PageAware {

    /**
     * 一次性落盘标记的 prefs 文件名与键都定义在 {@link Deployer}（跨包收口，键名只有一处）——
     * 见 {@code app/逻辑说明.md} §2.5 与 §8.1。
     */

    /** 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下（同配置页分组卡头）。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    /** 待弹的部署请求（探测阶段判定、主线程回调消费）：不弹。 */
    private static final int PROMPT_NONE = 0;
    /** 待弹：设备上的二进制与 APK 内不一致（已部署过）。 */
    private static final int PROMPT_HASH_MISMATCH = 1;
    /** 待弹：从没部署过（设备上没有二进制）。 */
    private static final int PROMPT_NOT_DEPLOYED = 2;
    /** 待弹：二进制就位且内容一致，但守护进程没在跑。 */
    private static final int PROMPT_NOT_RUNNING = 3;

    /**
     * 三种「待弹」情形的去重标记前缀（各占 {@link Deployer#KEY_HASH_PROMPTED_MD5} 的一个前缀，
     * 同一 APK 每种最多问一次）——设计见 {@code app/逻辑说明.md} §8.1。
     */
    private static final String MARK_NOT_DEPLOYED = "notdeployed:";
    private static final String MARK_HASH_MISMATCH = "hash:";
    private static final String MARK_NOT_RUNNING = "notrunning:";

    /** 静默刷新的最小间隔：30 秒内的重复触发不再跑 su 探测（该路径会顺带自动重推脚本）。 */
    private static final long PROBE_MIN_INTERVAL_MS = 30_000L;
    /** 手动刷新时文本淡出时长（退出比进入快，见 {@link #swapStatusTextAnimated}）。 */
    private static final long FADE_OUT_MS = 100L;
    /** 手动刷新时文本淡入时长。 */
    private static final long FADE_IN_MS = 150L;

    /**
     * 版本行的成品文案（`status_info_version` 已格式化）；null = 尚未从 PMS 读到。
     * 进程内版本不会变，故读一次就够——读它要 binder IPC（`getPackageInfo`），只在后台做。
     */
    private static volatile String versionLine;

    private TextView statusView;
    /** 换字交叉淡入的"旧文本"层（{@code status_text_stack} 内的装饰层，默认 GONE）。 */
    private TextView statusOutgoingView;
    private TextView infoView;
    private TextView logView;
    /** 操作记录的正文容器（自适应高、无内部滚动，同诊断卡）；展开/收起切的是它的可见性。 */
    private View logBody;
    /** 操作记录的落盘归档（私有目录 oplog/ 子目录，本会话一个文件；见 {@link OpLog}）。 */
    private OpLog archive;
    /** 「归档在哪/几份」提示行：布局里的静态控件，随展开体一起显隐（见 {@code fragment_status.xml}）。 */
    private TextView archiveHintView;
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
    /** 后台任务里置位、主线程回调读取：这次要弹哪种部署请求（{@link #PROMPT_NONE} = 不弹）。 */
    private volatile int pendingPrompt = PROMPT_NONE;
    /** 后台任务里置位、主线程回调读取：自动更新开着且内容不一致 → 静默重新部署（不弹窗）。 */
    private volatile boolean autoDeployPending;
    /** 用户在本页点过「停止daemon」（主线程写、后台探测读）：仅用于抑制「守护进程没在跑」那条提示。 */
    private boolean daemonStoppedByUser;
    /** 后台任务里置位、主线程回调读取：本次部署<b>盘面是否已就位</b>（据此决定要不要接着自动拉起）。 */
    private volatile boolean deployPlaced;
    /** 后台任务里置位、主线程回调读取：本次部署整体是否失败（据此清掉一次性标记，允许下次自动重试）。 */
    private volatile boolean deployFailed;
    /** 上次探测的开始时刻（手动与静默共用）；静默刷新据此节流。内存态，进程重启即失效。 */
    private long lastProbeAtMs;
    /** 淡入淡出代号：每次新动画递增，回调里对不上号即作废（连续刷新时两段动画不交叠）。 */
    private int fadeGeneration;
    /** 动作代号：每次起跑自增，收尾复位忙态时对不上号即作废（同 {@link #fadeGeneration} 的手法）。见 {@code app/逻辑说明.md} §8.1。 */
    private int actionGeneration;

    /** 主线程 Handler：只在「拿不到 Activity」的收尾路径上用（那一刻不能借 Activity 回主线程）。见 {@code app/逻辑说明.md} §8.1。 */
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** 是否有动作在跑（结果还没回到主线程）；为 true 时拒绝并发触发。见 {@code app/逻辑说明.md} §8.1。 */
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
        statusOutgoingView = view.findViewById(R.id.status_text_outgoing);
        infoView = view.findViewById(R.id.info_text);
        logView = view.findViewById(R.id.action_log_text);
        logBody = view.findViewById(R.id.action_log_body);
        arrowView = view.findViewById(R.id.action_log_arrow);
        progress = view.findViewById(R.id.status_progress);
        contentRoot = view.findViewById(R.id.status_content);

        view.findViewById(R.id.action_log_header).setOnClickListener(
                v -> setLogExpanded(!logExpanded));
        setLogExpanded(false);

        // 操作记录归档：每进程起一次会话（淘汰旧归档 + 记住起点）；
        // 提示行是展开体内的静态控件（布局已建），此处只取引用
        archive = OpLog.get(requireContext().getFilesDir());
        archive.beginSession();
        archiveHintView = view.findViewById(R.id.action_log_archive_hint);
        refreshArchiveHint();

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

        // 首次探测（含那一次 root 尝试）在这里起跑，不留给 onResume —— 冷启动时本页已被建出来
        // （三页一并建，见类注释），故"进 app"就等于这一行；firstProbeDone 挡住视图重建时的重入。
        // 紧随其后的 onResume 只剩静默刷新，并被 30 秒节流挡下（runAsync 起跑即记账）。
        if (!firstProbeDone) {
            firstProbeDone = true;
            firstProbe();
        }
    }

    @Override
    public void onPageVisible(boolean visible) {
        // 非当前页只是被压到 STARTED（不派发 onPause），故这里不做刷新：
        // 刷新由 onViewCreated（首次探测）与 onResume（其后，已节流）负责；这里只把在跑的淡入淡出收掉。
        if (!visible) {
            cancelFade();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 首次探测已由 onViewCreated 起跑（含那一次 root 尝试，见那里的注释），这里只剩静默刷新：
        // 外壳每切回本页都会派发 onResume，走静默路径（不写记录、不碰文本、不做动画），
        // 手动路径的动画/记录不该被切页触发；冷启动时刚探过，会被 30 秒节流挡下，不会多跑一趟 su。
        refreshStatus(false);
    }

    @Override
    public void onDestroyView() {
        actionRunning = false;
        // 先收掉动画并复位透明度：回调里判空就返回，不给已销毁的视图留半透明残影
        cancelFade();
        statusView = null;
        statusOutgoingView = null;
        infoView = null;
        logView = null;
        logBody = null;
        archiveHintView = null;
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
     * 探测部署状态；脚本哈希不一致且 su 可用时自动重推脚本（重推会连带重启守护进程），再复探一次。
     *
     * <p>副作用两条：①按最终状态武装部署请求；②顺手刷新「同步清单」（见 {@link Deployer#writeSyncManifestIfNeeded()}）。
     * 详与理由见 {@code app/逻辑说明.md} §8.1。
     *
     * @return 可直接上屏的文本
     */
    private String probeAndAutoFixScript(Context app) {
        final Deployer deployer = Deployer.get(app);
        Deployer.Status status = deployer.probe();
        final String head;
        // su 不可用时不尝试（否则每次进页面都白撞一次授权框）
        if (status.suOk && status.scriptPresent && !status.scriptHashOk) {
            // 三选一，判据取自紧随其后的那次 probe（更晚、更权威，且不额外增加 su 往返）——见 app/逻辑说明.md §8.1
            Deployer.Result r = deployer.updateScript();
            status = deployer.probe();
            int res;
            if (!r.ok) {
                res = R.string.status_script_autofix_failed;
            } else if (!status.daemonRunning) {
                res = R.string.status_script_autofixed_no_daemon;
            } else {
                res = R.string.status_script_autofixed;
            }
            head = app.getString(res) + "\n\n";
        } else {
            head = "";
        }
        // 同步清单只在这一处刷新：它是"APK 换了"才会变的东西，顺路做掉即可（失败才占一行）
        final String manifestNote = deployer.writeSyncManifestIfNeeded();
        armDeployPrompt(app, status);
        rememberDeployedBinMd5(app, status);
        // 顺手记下本次探测的 root 可用性：落页判定下次冷启动据此判"root 尚未取得"（见 app/逻辑说明.md §5.1）
        Deployer.rememberRootState(app, status.suOk);
        return head + (manifestNote == null ? "" : manifestNote + "\n") + status.describe();
    }

    /**
     * 探测确认设备上二进制与 APK 内一致时，把设备侧 md5 落盘 —— 这是「需要重新部署」判定的缓存，
     * 供下次冷启动落页用（判据互补与不重叠见 {@code app/逻辑说明.md} §8.1 与 §2.1）。
     */
    private static void rememberDeployedBinMd5(Context app, Deployer.Status status) {
        if (status.binExists && status.binHashOk) {
            Deployer.rememberDeployedBinMd5(app, status.binMd5);
        }
    }

    /**
     * 部署：直接上屏 {@link Deployer#deploy()} 自己带回的状态（不再补一次 probe），随后按
     * {@link Deployer.Result#placementsOk} 决定要不要自动「点」一次拉起daemon；部署失败时清掉一次性去重标记。
     * 判据与理由见 {@code app/逻辑说明.md} §8.1 与 §2.2。
     */
    private void deploy() {
        daemonStoppedByUser = false;   // 部署结束会接着拉起（见本方法的 after 回调）
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_deploy), () -> {
            Deployer.Result result = Deployer.get(app).deploy();
            deployPlaced = result.placementsOk;
            deployFailed = !result.ok;
            return result.status != null ? result.status.describe() : result.describe();
        }, false, true, () -> {
            if (deployPlaced) {
                startDaemon();
            }
            if (deployFailed) {
                clearPromptMark();
            }
        });
    }

    /**
     * 清掉「本 APK 版本已经自动装过 / 已经问过」的一次性去重标记（{@link Deployer#KEY_HASH_PROMPTED_MD5}），
     * <b>只在部署失败时调</b>；「反复」的边界见 {@code app/逻辑说明.md} §8.1。
     */
    private void clearPromptMark() {
        Context context = getContext();
        if (context == null) {
            return;   // 已 detach：不改标记，下次进页面探测会重新判定
        }
        context.getApplicationContext()
                .getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE)
                .edit().remove(Deployer.KEY_HASH_PROMPTED_MD5).apply();
    }

    private void uninstall() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_uninstall),
                () -> Deployer.get(app).uninstall().describe(), false, true);
    }

    private void startDaemon() {
        daemonStoppedByUser = false;   // 用户明确要拉起：把「刚停过」的抑制位清掉
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_start),
                () -> Deployer.get(app).startDaemon().describe(), false, true);
    }

    private void stopDaemon() {
        // 「没在跑」那条提示的抑制位：刚点过停止就别马上再问"要不要拉起来"（见 armDeployPrompt）
        daemonStoppedByUser = true;
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
        showDismissOnOutside(new AlertDialog.Builder(requireContext())
                .setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(confirmRes, (d, w) -> action.run())
                .setNegativeButton(R.string.status_dialog_cancel, null)
                .create());
    }

    /**
     * 统一弹窗口径：点弹窗外部即取消（AppCompat {@code AlertDialog} 默认不随点外触摸取消，须显式设置）。
     * 取消一律"什么都不做"——动作只挂在肯定按钮上，取消不触发任何动作。
     */
    private static void showDismissOnOutside(AlertDialog dialog) {
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
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
     * @param busyText 忙态文案。<b>不进状态区</b>（理由见 {@code app/逻辑说明.md} §8.1），
     *                 只在手动路径下作为「操作记录」的一条
     * @param asDialog true 时结果弹对话框（诊断类文本较长，状态区放不下）
     * @param manual   true = 用户主动触发：写操作记录 + 结果文本淡入淡出（含高度补间）；
     *                 false = 非手动刷新：不写记录、不碰文本（结果先比后写）、不做动画
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
     *
     * <p>忙态与占用位的收尾只有一处（{@link #finishAction}），三条收尾路径都必须走它 —— 见
     * {@code app/逻辑说明.md} §8.1。
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
        final int generation = ++actionGeneration;
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
                // 拿不到 Activity（视图已随宿主分离/重建）：也必须在主线程把忙态与占用位放开。
                // 早退什么都不做的话，进度条会一直转、且此后本页每次点击都被守卫挡下（永久"忙"）。
                // 走静态 Handler：此刻不能借 Activity 回主线程；finishAction 按代号判定，不碰别人的忙态。
                MAIN.post(() -> finishAction(generation));
                return;
            }
            activity.runOnUiThread(() -> {
                if (!isAdded() || statusView == null) {
                    // 视图已没了：至少把占用位放开（进度条随视图一起消失，由 onDestroyView 收尾）
                    finishAction(generation);
                    return;
                }
                // 结果已回到主线程：本动作到此结束，先放掉占用——紧接着要接的那一段（after）
                // 才不会被守卫挡在门外
                finishAction(generation);
                if (manual) {
                    appendLog(result);
                }
                if (asDialog || isFailure) {
                    showDismissOnOutside(new AlertDialog.Builder(appContext)
                            .setTitle(isFailure ? R.string.status_dialog_failed
                                    : R.string.status_dialog_diag)
                            .setMessage(result)
                            .setPositiveButton(R.string.status_dialog_close, null)
                            .create());
                } else if (manual) {
                    swapStatusTextAnimated(result);
                } else if (!result.contentEquals(statusView.getText())) {
                    // 先比后写：内容没变就一个字都不动，连重绘都省掉
                    statusView.setText(result);
                }
                if (rootJustGranted) {
                    rootJustGranted = false;
                    // 刚拿到授权：这一支优先于「自动更新」的静默部署，同批武装的另一条请求就地作废
                    // （见 app/逻辑说明.md §8.1）
                    pendingPrompt = PROMPT_NONE;
                    showDeployPrompt();
                } else if (autoDeployPending) {
                    autoDeployPending = false;
                    // 「自动更新」开着且设备上的内容旧了：不弹窗，直接重装（写进操作记录，
                    // 让用户能看出"刚才自动做了什么"）。deploy() 结束会自己接着拉起守护进程。
                    appendLog(getString(R.string.status_auto_deploy_log));
                    deploy();
                } else if (pendingPrompt != PROMPT_NONE) {
                    final int kind = pendingPrompt;
                    pendingPrompt = PROMPT_NONE;
                    if (kind == PROMPT_HASH_MISMATCH) {
                        showHashMismatchPrompt();
                    } else if (kind == PROMPT_NOT_DEPLOYED) {
                        showNotDeployedPrompt();
                    } else {
                        showNotRunningPrompt();
                    }
                }
                if (after != null) {
                    after.run();
                }
            });
        }, "ww-deploy");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 收尾复位：放掉占用位并关掉进度条，只在代号未变时动。<b>三条收尾路径都必须走它</b>
     * （正常上屏、视图已销毁、以及拿不到 Activity，见 {@link #runAsync}）。必须在主线程调。
     * 理由见 {@code app/逻辑说明.md} §8.1。
     */
    private void finishAction(int generation) {
        if (generation != actionGeneration) {
            return;
        }
        actionRunning = false;
        setBusy(false);
    }

    private interface Task {
        String run() throws Exception;
    }

    /**
     * 判定这次探测要不要弹部署请求（三种情形，互斥、按 {@link #PROMPT_HASH_MISMATCH} →
     * {@link #PROMPT_NOT_DEPLOYED} → {@link #PROMPT_NOT_RUNNING} 的优先级取一条），或（自动更新
     * 开着时）改为静默重新部署。三情形、su 可用前提、自动更新分工、去重与唯一例外见
     * {@code app/逻辑说明.md} §8.1。
     */
    private void armDeployPrompt(Context app, Deployer.Status status) {
        pendingPrompt = PROMPT_NONE;   // 每次探测重新判定，不留上一次的残留
        autoDeployPending = false;
        if (!status.suOk || status.binExpectedMd5.isEmpty()) {
            return;
        }
        final int kind;
        final String mark;
        if (!status.binExists) {
            kind = PROMPT_NOT_DEPLOYED;
            mark = MARK_NOT_DEPLOYED + status.binExpectedMd5;
        } else if (!status.binHashOk) {
            kind = PROMPT_HASH_MISMATCH;
            mark = MARK_HASH_MISMATCH + status.binExpectedMd5;
        } else if (!status.daemonRunning) {
            if (daemonStoppedByUser) {
                return;   // 用户刚点过「停止daemon」：别马上又问"要不要拉起来"
            }
            kind = PROMPT_NOT_RUNNING;
            mark = MARK_NOT_RUNNING + status.binMd5;
        } else {
            return;
        }
        final SharedPreferences prefs =
                app.getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
        if (mark.equals(prefs.getString(Deployer.KEY_HASH_PROMPTED_MD5, null))) {
            return;
        }
        prefs.edit().putString(Deployer.KEY_HASH_PROMPTED_MD5, mark).apply();
        if (kind == PROMPT_HASH_MISMATCH && Deployer.isAutoUpdateEnabled(app)) {
            autoDeployPending = true;
            return;
        }
        pendingPrompt = kind;
    }

    // ==================== 操作记录折叠 ====================

    private void setLogExpanded(boolean value) {
        logExpanded = value;
        if (value) {
            // 展开时先重算一次（本会话首条记录落盘后份数会变）：正文定下来再量高动画，终点才是最终实高
            refreshArchiveHint();
        }
        if (logBody != null) {
            // 切的是正文容器（自适应高、无内部滚动）；展开/收起按逻辑 2 做高度补间
            // （系统关动画或宽度不可知时由 Motion 直接落位）
            Motion.animateHeight(logBody, value);
        }
        if (arrowView != null) {
            // 200ms ease-out 转过去（系统关动画时由 Motion 直落）；无障碍描述即时切换，不等动画
            Motion.rotate(arrowView, value ? ARROW_EXPANDED_ROTATION : 0f);
            arrowView.setContentDescription(getString(value
                    ? R.string.config_action_collapse : R.string.config_action_expand));
        }
    }

    // ==================== 渲染小工具 ====================

    /**
     * 忙态指示：所有刷新路径（手动与静默）都开它——它是刷新唯一的反馈。只切
     * {@code VISIBLE}/{@code INVISIBLE}、绝不用 {@code GONE}（进度条常占位，理由见
     * {@code app/逻辑说明.md} §8.1）。
     */
    private void setBusy(boolean busy) {
        if (progress != null) {
            progress.setVisibility(busy ? View.VISIBLE : View.INVISIBLE);
        }
    }

    /**
     * 手动刷新的结果上屏：<b>业务上屏零延迟</b>——新文本立刻写上去（不再等淡出结束），视觉上做
     * 「旧文本淡出、新文本淡入」的交叉淡入（旧的在下、新的在上叠放，时长沿用 100/150ms，均强 ease-out）。
     * 高度变化按逻辑 2 的时长补间（位移量由换字前预测）。代号保证串行、<b>打断不丢结果</b>（打断后
     * 当前文本即最新结果）；系统关掉动画时直接上屏。见 {@code app/逻辑说明.md} §8.1。
     */
    private void swapStatusTextAnimated(final String text) {
        final TextView view = statusView;
        final TextView outgoing = statusOutgoingView;
        if (view == null || !isAdded()) {
            return;
        }
        if (outgoing == null || !Motion.enabled(view.getContext())) {
            // 系统关掉动画（或叠放层缺失）：直接换文本，信息先可读
            cancelFade();
            view.setAlpha(1f);
            view.setText(text);
            return;
        }
        final int generation = ++fadeGeneration;
        final ViewGroup root = contentRoot;
        view.animate().cancel();
        outgoing.animate().cancel();
        // 旧的 = 上一次换字的落点（打断时即当前可见的那段）；预测换字后的高度差用于补间时长
        final CharSequence old = view.getText();
        final int oldHeight = view.getHeight();
        final int newHeight = Motion.measureTextHeight(view, text);
        outgoing.setText(old);
        outgoing.setAlpha(1f);
        outgoing.setVisibility(View.VISIBLE);
        if (newHeight > oldHeight) {
            // 新文本更高：先开一段过渡，再把新文本写上去（卡片平滑长高）
            Motion.beginLayoutChange(root, newHeight - oldHeight);
        }
        // 业务上屏：立即，不等动画
        view.setText(text);
        view.setAlpha(0f);
        view.animate().alpha(1f).setDuration(FADE_IN_MS).setInterpolator(Motion.easeOut()).start();
        outgoing.animate().alpha(0f).setDuration(FADE_OUT_MS).setInterpolator(Motion.easeOut())
                .withEndAction(() -> {
            if (generation != fadeGeneration) {
                return;   // 已被新一次换字 / cancelFade 接管：叠放层归它们管，这里什么都不动
            }
            if (statusOutgoingView == null || !isAdded()) {
                return;   // 视图已销毁，无处收尾（onDestroyView 已复位）
            }
            if (newHeight < oldHeight) {
                // 新文本更矮：旧文本退了再收（此刻新文本已不透明，收缩平滑）
                Motion.beginLayoutChange(root, oldHeight - newHeight);
            }
            outgoing.setVisibility(View.GONE);
            outgoing.setAlpha(1f);
        }).start();
    }

    /** 作废在跑的淡入淡出、复位两层文本的透明度并收起叠放层（离开本页 / 视图销毁时收尾）。 */
    private void cancelFade() {
        fadeGeneration++;
        if (statusView != null) {
            statusView.animate().cancel();
            statusView.setAlpha(1f);
        }
        if (statusOutgoingView != null) {
            statusOutgoingView.animate().cancel();
            statusOutgoingView.setAlpha(1f);
            statusOutgoingView.setVisibility(View.GONE);
        }
    }

    /** 二进制与 APK 内不一致：请求重新部署（去重见 {@link #armDeployPrompt}）。 */
    private void showHashMismatchPrompt() {
        showDeployRequestPrompt(R.string.status_hash_title, R.string.status_hash_message,
                R.string.status_action_deploy, this::deploy);
    }

    /** 从没部署过：请求一键部署（**不自动装** —— 用户此前从没同意过部署）。 */
    private void showNotDeployedPrompt() {
        showDeployRequestPrompt(R.string.status_notdeployed_title, R.string.status_notdeployed_message,
                R.string.status_action_deploy, this::deploy);
    }

    /** 二进制就位但进程没在跑：请求拉起（动作是"拉起 daemon"，不是重装一遍）。 */
    private void showNotRunningPrompt() {
        showDeployRequestPrompt(R.string.status_notrunning_title, R.string.status_notrunning_message,
                R.string.status_action_start, this::startDaemon);
    }

    /**
     * 三条部署请求共用的对话框：标题/正文/肯定按钮文案 + 肯定动作各不同，其余一致。
     *
     * <p>否定按钮一律「稍后」（不动作）；去重标记已在探测阶段落盘，故点「稍后」不会下次又问。
     */
    private void showDeployRequestPrompt(int titleRes, int messageRes, int confirmRes, Runnable action) {
        if (!isAdded()) {
            return;
        }
        showDismissOnOutside(new AlertDialog.Builder(requireContext())
                .setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(confirmRes, (d, w) -> action.run())
                .setNegativeButton(R.string.status_root_later, null)
                .create());
    }

    /** 追加一条操作记录，带秒级时间戳（新的在上），并同步落盘归档（写通，杀进程不丢）。 */
    private void appendLog(String text) {
        if (logView == null) {
            return;
        }
        String line = "[" + TIME_FMT.format(new Date()) + "] " + text;
        String old = logView.getText().toString();
        String merged = line + "\n\n" + old;
        if (merged.length() > 8000) {
            merged = merged.substring(0, 8000) + "\n…（已截断）";
        }
        logView.setText(merged);
        if (archive != null) {
            archive.append(line);
            // 落盘后立刻重算：折叠态下份数/占用不再停在进页面时的旧值。
            // 代价可控——OpLog.snapshot() 是 O(1)（进页面时缓存既有归档基数，本会话文件只按当前长度累加），不做目录扫描。
            refreshArchiveHint();
        }
    }

    /** 刷新归档提示行（进入本页、展开操作记录时各刷一次）。 */
    private void refreshArchiveHint() {
        if (archiveHintView == null || archive == null) {
            return;
        }
        OpLog.Info info = archive.snapshot();
        final String text;
        if (!info.available) {
            text = getString(R.string.status_archive_hint_unavailable, info.reason);
        } else if (info.count == 0) {
            text = getString(R.string.status_archive_hint_none, info.dir.getAbsolutePath());
        } else {
            text = getString(R.string.status_archive_hint,
                    info.dir.getAbsolutePath(), info.count, formatBytes(info.bytes));
        }
        // 文本没变就不动视图：逐条刷新时避免无谓的重排
        if (!text.contentEquals(archiveHintView.getText())) {
            archiveHintView.setText(text);
        }
    }

    /** 归档占用的人话格式（<1 KB 给字节数，其余一位小数 KB）。 */
    private static String formatBytes(long bytes) {
        if (bytes < 1024L) {
            return bytes + " B";
        }
        return String.format(Locale.US, "%.1f KB", bytes / 1024.0);
    }

    /** 拿到 root 后问是否立即部署（文案见 strings.xml；不需要则不打扰）。 */
    private void showDeployPrompt() {
        if (!isAdded()) {
            return;
        }
        showDismissOnOutside(new AlertDialog.Builder(requireContext())
                .setTitle(R.string.status_root_ok_title)
                .setMessage(R.string.status_root_ok_message)
                .setPositiveButton(R.string.status_action_deploy, (d, w) -> deploy())
                .setNegativeButton(R.string.status_root_later, null)
                .create());
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
