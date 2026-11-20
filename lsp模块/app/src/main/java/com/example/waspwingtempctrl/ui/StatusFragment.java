package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.Deployer;
import com.example.waspwingtempctrl.SetupActivity;
import com.example.waspwingtempctrl.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 状态页：部署状态 / 一键部署 / 卸载部署 / 拉起daemon / 刷新状态 / kill daemon。
 *
 * <p><b>调用边界（I5 的另一半）</b>：本类只调 {@link Deployer} 的
 * {@code probe() / deploy() / uninstall() / startDaemon() / stopDaemon() /
 * ensureRoot() / updateScript()}，不拼 shell、不碰文件、不绕过 {@code Deployer}。
 * {@link Deployer} 的方法都阻塞，故一律放后台线程；结果回主线程渲染。
 *
 * <p>刷新两条路径（消闪烁）、首次探测的时机、忙态与代号纪律、部署请求的武装与去重、
 * 部署后自动接拉起：均见 {@code app/逻辑说明.md} §8.1。
 */
public class StatusFragment extends Fragment implements SetupActivity.PageAware {

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
    /** 页面可见期间的周期静默复探间隔：及时反映控制 app 被杀等外部状态变化。 */
    private static final long PERIODIC_REFRESH_MS = 5_000L;
    /** 换字高度动画时长：与 {@link Motion#crossFade} 的旧层淡出终点对齐（0 + 325 = 325ms），高度与淡变同起同止。 */
    private static final long HEIGHT_SYNC_MS = Motion.FADE_OUT_DELAY_MS + Motion.FADE_OUT_MS;
    /** 部署/拉起结果在状态区的最短保留时长：在此期间周期扫描不覆盖状态文本。 */
    private static final long RESULT_HOLD_MS = 10_000L;
    /** 自动部署失败退避：首次 60 秒，逐次翻倍，上限 30 分钟（进程内；成功或 APK 变化时重置）。 */
    private static final long AUTO_DEPLOY_BACKOFF_BASE_MS = 60_000L;
    private static final long AUTO_DEPLOY_BACKOFF_MAX_MS = 30 * 60_000L;
    /** 静默探测失败写操作记录的最小间隔：避免 5 秒周期把同一异常反复刷进记录。 */
    private static final long SILENT_FAILURE_LOG_MIN_INTERVAL_MS = 60_000L;
    /** 部署状态文本的结论行前缀（须与 {@code Deployer.Status.summaryLine()} 保持一致）。 */
    private static final String DEPLOY_STATUS_PREFIX = "部署状态：";
    /** 动作期间按钮压暗后的透明度与渐变时长（压暗快、恢复稍慢）。 */
    private static final float BUTTON_DIM_ALPHA = 0.35f;
    private static final long BUTTON_DIM_MS = 160L;
    private static final long BUTTON_RESTORE_MS = 260L;

    /**
     * 版本行的成品文案（`status_info_version` 已格式化）；null = 尚未从 PMS 读到。
     * 进程内版本不会变，故读一次就够——读它要 binder IPC（`getPackageInfo`），只在后台做。
     */
    private static volatile String versionLine;

    /**
     * 「同步清单」本进程是否已<b>成功</b>刷新过：清单只随 APK 变化，成功一次即不再重复读盘；
     * 失败（返回非 null）不置位，下次探测仍会重试。与 {@link #versionLine} 同族，都是"进程内只做一次"。
     */
    private static volatile boolean syncManifestDone;

    /** 结论行的动态值（「已完成 / 正在检测」等）：换字动画只作用在这里。 */
    private TextView statusView;
    /** 结论行的静态标签（「部署状态：」）：只随结论行形态显隐，不参与动画。 */
    private TextView statusLabelView;
    /** 结论行容器（标签 + 动态值同行，基线对齐）。头部 font padding 由它承担。 */
    private View statusSummaryRow;
    /** 部署状态的明细块逐行容器：每行一个 TextView，只对内容变化的行播淡化+模糊。 */
    private LinearLayout statusDetailList;
    /** 探测提示（脚本自动重推 / 同步清单未刷新）：放在状态块下方，不参与行级动画。 */
    private TextView statusProbeNoticeView;
    /** 最近一次探测产生的提示文本；空串 = 不显示。后台线程写、主线程读。 */
    private volatile String probeNotices = "";
    /** 已挂载的明细行视图（按显示顺序，与 {@link #detailRowTexts} 一一对应）。 */
    private final List<TextView> detailRowViews = new ArrayList<>();
    /** 明细行当前上屏的原始文本（完整路径，不经「展示完整路径」开关裁剪）。 */
    private final List<String> detailRowTexts = new ArrayList<>();
    /** 拆分后补在整块头/尾的 font padding（像素）：结论行顶部固定用它，
     *  底部 padding 归明细块；明细为空时改由结论行承担，保证单行状态与拆分前等高。 */
    private int statusTopPad;
    private int statusBottomPad;
    /** 行触摸日志限频（真机确认 DOWN/UP 是否到达行视图）。 */
    private long lastRowTouchLogMs;
    /** 上次上屏时的「展示完整路径」开关；返页时若变了，重渲染行与提示。 */
    private boolean lastShowFullPath;
    private boolean showFullPathSeen;

    /** 日志标签：W 级，真机 MIUI 可抓（D 级会被过滤）。 */
    private static final String TAG = "StatusFragment";
    /** 状态文本的承载层：换字时用 {@link Motion#animateHeightChange} 补间它的高度（窗口展开/收起），
     *  同时是 {@link Motion#crossFade} 快照层的宿主。 */
    private ViewGroup statusStack;
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

    /**
     * 操作记录的文本模型：选中期间不往 {@link #logView} 写，但这里照常累积最新全文，
     * 选择一结束就补上（否则跳过的那几条记录会永久丢失）。
     */
    private String logText = "";
    /** 「部署状态」动态值临时替换前的原文（不含标签）；null = 当前没有待恢复的替换。 */
    @Nullable
    private String deployFirstLineBackup;
    /** 当前临时替换用的动态值（正在检测 / 部署中…，不含标签），与 backup 成对出现。 */
    @Nullable
    private String deployFirstLinePlaceholder;

    /** 操作记录是否展开（默认收起）。 */
    private boolean logExpanded;
    /** 本实例是否已起过「首次探测（含 root 尝试）」；由 {@link #firstProbeIfNeeded()} 置真。 */
    private boolean firstProbeDone;
    /** 后台任务里置位、主线程回调读取：本次刚拿到 root 授权，需弹部署确认。 */
    private volatile boolean rootJustGranted;
    /** 后台任务里置位、主线程回调读取：这次要弹哪种部署请求（{@link #PROMPT_NONE} = 不弹）。 */
    private volatile int pendingPrompt = PROMPT_NONE;
    /** 后台任务里置位、主线程回调读取：自动更新开着且内容不一致 → 静默重新部署（不弹窗）。 */
    private volatile boolean autoDeployPending;
    /** 用户在本页点过「kill daemon」（主线程写、后台探测读）：仅用于抑制「守护进程没在跑」那条提示。 */
    private boolean daemonStoppedByUser;
    /** 后台任务里置位、主线程回调读取：本次部署<b>盘面是否已就位</b>（据此决定要不要接着自动拉起）。 */
    private volatile boolean deployPlaced;
    /** 后台任务里置位、主线程回调读取：本次部署整体是否失败（据此清掉一次性标记，允许下次自动重试）。 */
    private volatile boolean deployFailed;
    /** 自动部署连续失败次数与退避截止时刻（进程级：视图/Activity 重建不重置，进程重启才清零）。 */
    private static volatile int autoDeployFailures;
    private static volatile long autoDeployBackoffUntilMs;
    /** 上次自动部署失败所针对的 APK 内二进制 md5；变了即重置退避（装新包不必等满窗口）。 */
    private static volatile String autoDeployFailedMd5 = "";
    /** 最近一次探测到的 APK 内二进制 md5（供部署失败时给退避定位版本）。 */
    private static volatile String lastProbeExpectedMd5 = "";
    /** 上次静默探测失败写入操作记录的时刻（仅主线程读写）。 */
    private long lastSilentFailureLogMs;
    /** 上次探测的开始时刻（手动与静默共用）；静默刷新据此节流。内存态，进程重启即失效。 */
    private long lastProbeAtMs;
    /** 部署/拉起结果上屏后的保留截止时刻（ms）：在此之前周期扫描不覆盖状态文本。 */
    private long statusHoldUntilMs;
    /** 上次写入 prefs 的 root 可用性；配合 {@link #rootOkSeen} 做到"值没变就不重复落盘"。 */
    private boolean lastRootOk;
    /** {@link #lastRootOk} 是否已取过值（false = 尚未取过，取过一次后置真）。 */
    private boolean rootOkSeen;
    /** 动作代号：每次起跑自增，收尾复位忙态时对不上号即作废。见 {@code app/逻辑说明.md} §8.1。 */
    private int actionGeneration;

    /** 主线程 Handler：只在「拿不到 Activity」的收尾路径上用（那一刻不能借 Activity 回主线程）。见 {@code app/逻辑说明.md} §8.1。 */
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** 是否有动作在跑（结果还没回到主线程）；为 true 时拒绝并发触发。见 {@code app/逻辑说明.md} §8.1。 */
    private boolean actionRunning;
    /** 动作期间是否已压暗按钮；收尾据此恢复，刷新/诊断等不压暗的动作为 false。 */
    private boolean actionDimmed;
    /** 进度条的两个独立占用方：动作与扫描，任一方在跑都显示（互不抢先关掉）。 */
    private boolean actionBusy;
    private boolean scanBusy;

    /** 状态页 5 个动作/刷新按钮：动作进行时统一禁用并压暗（扫描不压暗）。 */
    private final List<View> actionButtons = new ArrayList<>();

    // ========== 扫描协调器 ==========
    /** 同一时刻只跑一趟探测；扫描中再请求只挂监听，不新起。 */
    private boolean scanRunning;
    /** 本轮扫描是否有手动监听者（播动画 + 写结果记录）与静默监听者（只比后写）。 */
    private boolean scanManualPending;
    private boolean scanSilentPending;
    /** 扫描代号：视图销毁/重新起跑时递增，旧回调据此作废。 */
    private int scanGeneration;
    /** 页面可见期间的周期复探是否在运行（生命周期开关）。 */
    private boolean periodicActive;

    /**
     * 页面可见期间的周期静默复探：一拍只触发一次扫描，下一拍由扫描结束
     * （{@link #finishScan}）重置，故不会固定自调度、也不会在扫描进行中再起一趟。
     */
    private final Runnable periodicRefresh = new Runnable() {
        @Override
        public void run() {
            if (!isAdded() || statusView == null) {
                return;
            }
            if (actionRunning) {
                startPeriodicRefresh();   // 动作中让路，5 秒后再试
                return;
            }
            requestSilentRefresh();
        }
    };

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
        statusLabelView = view.findViewById(R.id.status_label_text);
        statusSummaryRow = view.findViewById(R.id.status_summary_row);
        statusDetailList = view.findViewById(R.id.status_detail_list);
        statusProbeNoticeView = view.findViewById(R.id.status_probe_notice);
        statusStack = view.findViewById(R.id.status_text_stack);
        // 结论行/明细行与拆分前的单 TextView 逐像素一致：关掉 includeFontPadding 后，
        // 按字体度量把上下 font padding 补回结论行顶部与明细块底部（行间不重复补）。
        applyStatusTextMetrics();
        // 整块长按复制全文：标签、动态值、提示与每一行共用同一份全文（行在创建时挂同一监听）。
        TextCopy.copyOnLongPress(statusLabelView, this::statusCopyText);
        TextCopy.copyOnLongPress(statusView, this::statusCopyText);
        TextCopy.copyOnLongPress(statusProbeNoticeView, () -> probeNotices);
        statusProbeNoticeView.setOnClickListener(v -> TextCopy.tapFirstPath(statusProbeNoticeView));
        // 启动预取：本页随 ViewPager2 一起在冷启动建页，这里只提交后台任务（进程级一次、失败静默）。
        DeployStatusCache.prefetch(requireContext());
        // 有缓存就先上内容（同一帧内替换，用户看不到骨架）；从未成功过才用预填充骨架。
        // 缓存陈旧也照常先显示，紧随其后的首探/周期刷新会交叉淡入覆盖。
        final String cachedStatus = DeployStatusCache.text();
        writeStatusText(cachedStatus != null ? cachedStatus : prefillText(), false, false);
        lastShowFullPath = PathDisplay.showFull(requireContext());
        showFullPathSeen = true;
        if (cachedStatus != null && !DeployStatusCache.isStale()) {
            // 缓存还新鲜：与静默刷新同一个 30 秒节流口径，避免紧接着再跑一趟 su
            lastProbeAtMs = DeployStatusCache.atMs();
        }
        infoView = view.findViewById(R.id.info_text);
        logView = view.findViewById(R.id.action_log_text);
        // 空串的 TextView 仍会量出一行高，会在归档提示下留出一段空行；无记录时让它退出布局
        logView.setVisibility(logText.isEmpty() ? View.GONE : View.VISIBLE);
        if (!logText.isEmpty()) {
            logView.setText(PathDisplay.format(view.getContext(), logText));
        }
        logBody = view.findViewById(R.id.action_log_body);
        arrowView = view.findViewById(R.id.action_log_arrow);
        progress = view.findViewById(R.id.status_progress);
        contentRoot = view.findViewById(R.id.status_content);

        View logHeader = view.findViewById(R.id.action_log_header);
        TextView logTitle = view.findViewById(R.id.action_log_title);
        logHeader.setOnClickListener(v -> setLogExpanded(!logExpanded));
        // 长按卡头复制标题：长按与点击挂在同一个 View 上，由框架按按压时长分流（长按后抬起不再触发展开）。
        // 箭头不消费触摸，点它照旧随卡头展开；这条既有行为不变
        TextCopy.copyOnLongPress(logHeader, logTitle::getText);
        setLogExpanded(false);

        // 操作记录归档：每进程起一次会话（淘汰旧归档 + 记住起点）；
        // 提示行是展开体内的静态控件（布局已建），此处只取引用
        archive = OpLog.get(requireContext().getFilesDir());
        archive.beginSession();
        archiveHintView = view.findViewById(R.id.action_log_archive_hint);
        refreshArchiveHint();

        infoView.setText(buildInfo());
        loadVersionLineAsync();

        // 动作期间统一压暗的 5 个按钮（扫描/刷新不压暗，见 runAsyncBlocking）
        actionButtons.clear();
        actionButtons.add(view.findViewById(R.id.btn_deploy));
        actionButtons.add(view.findViewById(R.id.btn_start));
        actionButtons.add(view.findViewById(R.id.btn_refresh));
        actionButtons.add(view.findViewById(R.id.btn_uninstall));
        actionButtons.add(view.findViewById(R.id.btn_stop));

        // 手动路径：写操作记录 + 结果文本淡入淡出（静默路径不走这两处；进度条两条路径都走）
        view.findViewById(R.id.btn_refresh).setOnClickListener(v -> refreshStatus(true));
        view.findViewById(R.id.btn_deploy).setOnClickListener(v -> deploy());
        view.findViewById(R.id.btn_uninstall).setOnClickListener(v -> confirmUninstall());
        view.findViewById(R.id.btn_stop).setOnClickListener(v -> confirmStopDaemon());
        view.findViewById(R.id.btn_start).setOnClickListener(v -> startDaemon());

        // 滚动条常显 + 加粗（见 fragment_status.xml），这里才接得上"按住滚动条拖动"
        ScrollbarDrag.attach(view.findViewById(R.id.status_scroll));

        // 路径长按整条选中（方案 B）：状态/设备信息/归档提示/操作记录等可选中文本统一安装（见 app/逻辑说明.md §9.4）
        TextCopy.installPathSelection(view);
        // 操作记录已是自适应高、无内部滚动（同诊断卡），故不再需要
        // PageScrollView.yieldVerticalDragTo：没有内层可滚动区，就不存在手势相争。
        // 页面根保持 PageScrollView（配置页的曲线拖柄仍在用它）。

        // 首次探测不在这里跑：本页首次可见时才探，见 firstProbeIfNeeded()。
    }

    @Override
    public void onPageVisible(boolean visible) {
        if (!visible) {
            // 离屏：收掉动画、周期复探与在跑的扫描（扫描结果不再上屏/弹窗）。
            cancelFade();
            stopPeriodicRefresh();
            invalidateScan();
            return;
        }
        firstProbeIfNeeded();
        startPeriodicRefresh();
    }

    @Override
    public void onResume() {
        super.onResume();
        // 从设置页返回时「展示完整路径」可能已变：骨架还在（尚未被探测结果替换）就换成长/短版本，
        // 已有结果则按新开关重渲染明细行与提示
        syncPrefillVariant();
        syncPathDisplayVariant();
        // 首次可见时先起首探（见 firstProbeIfNeeded），否则走静默刷新（不写记录、不播忙文本；
        // 结果到达仍走交叉淡入 + 高度补间）；手动路径的动画/记录不该被切页触发；静默刷新被 30 秒节流挡下。
        if (!firstProbeIfNeeded()) {
            refreshStatus(false);
        }
        startPeriodicRefresh();
    }

    /** 首次探测前的骨架文本：完整路径开关打开用长骨架，关闭用只含文件名的短骨架。 */
    private String prefillText() {
        return getString(PathDisplay.showFull(requireContext())
                ? R.string.status_deploy_prefill : R.string.status_deploy_prefill_short);
    }

    /**
     * 骨架还在屏幕上时按当前开关重选长短版本。探测结果到达后文本不再是任一骨架，这里就不动，
     * 避免覆盖真实状态；开关变化因此在「首次探测前 / 下次进页」都能生效。
     */
    private void syncPrefillVariant() {
        if (statusView == null || statusDetailList == null || !isAdded()) {
            return;
        }
        String current = fullStatusText();
        String longText = getString(R.string.status_deploy_prefill);
        String shortText = getString(R.string.status_deploy_prefill_short);
        if (!current.equals(longText) && !current.equals(shortText)) {
            return;
        }
        String want = PathDisplay.showFull(requireContext()) ? longText : shortText;
        if (!current.equals(want)) {
            writeStatusText(want, false, false);
        }
    }

    /**
     * 「展示完整路径」开关在设置页改动后，本页已上屏的行仍是旧裁剪结果。
     * 状态文本用原始完整路径比对（{@code detailRowTexts}），故内容不变时不会自己重渲染；
     * 这里在返页时检测开关变化并强制重渲染一次行与提示。
     */
    private void syncPathDisplayVariant() {
        if (statusView == null || statusDetailList == null || !isAdded()) {
            return;
        }
        final boolean showFull = PathDisplay.showFull(requireContext());
        if (!showFullPathSeen) {
            lastShowFullPath = showFull;
            showFullPathSeen = true;
            return;
        }
        if (showFull == lastShowFullPath) {
            return;
        }
        lastShowFullPath = showFull;
        // 行文本按原始完整路径保存，普通刷新会因「内容没变」跳过；这里逐行强制重走渲染链
        for (int i = 0; i < detailRowViews.size(); i++) {
            TextView row = detailRowViews.get(i);
            Motion.cancelCrossFade(row);   // 直替前收掉可能残留的快照层
            applyRowText(row, detailRowTexts.get(i));
        }
        updateProbeNoticeView(true);
    }

    @Override
    public void onPause() {
        // 宿主暂停：停掉周期复探并作废在跑的扫描，回前台时由 onResume 重新起拍。
        stopPeriodicRefresh();
        invalidateScan();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        stopPeriodicRefresh();
        // 作废在跑的扫描；旧回调按代号直接丢弃
        invalidateScan();
        actionBusy = false;
        actionRunning = false;
        actionDimmed = false;
        // 按钮可能正压暗/禁用：视图要销毁了，直接复位并清引用（不播动画）
        for (View b : actionButtons) {
            b.animate().cancel();
            b.setAlpha(1f);
            b.setEnabled(true);
        }
        actionButtons.clear();
        // 先收掉动画并复位透明度：回调里判空就返回，不给已销毁的视图留半透明残影
        cancelFade();
        for (TextView row : detailRowViews) {
            Motion.cancelCrossFade(row);   // 立刻回收行快照层，不留到 341ms 后
        }
        detailRowViews.clear();
        detailRowTexts.clear();
        statusView = null;
        statusLabelView = null;
        statusSummaryRow = null;
        statusDetailList = null;
        statusProbeNoticeView = null;
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

    /**
     * 本页首次可见时起跑首次探测（含那一次 root 尝试），只此一次。
     *
     * <p>触发点两个（{@code onResume} 与 {@code onPageVisible(true)}），用 {@link #firstProbeDone} 去重：
     * 谁先到谁跑，后来者不再跑。冷启动落页<b>不是</b>本页时两者都不触发，不为看不见的页面白跑 su。
     * 见 app/逻辑说明.md §8.1。
     *
     * @return true = 本次刚起跑了首次探测（调用方据此跳过紧随的静默刷新，避免多跑一趟 su）
     */
    private boolean firstProbeIfNeeded() {
        if (firstProbeDone) {
            return false;
        }
        firstProbeDone = true;
        firstProbe();
        return true;
    }

    /**
     * 首次探测：先试一次 root（只此一次），再探部署状态。静默路径（不写记录、不播忙文本）；
     * 结果到达按统一入口：内容变化才渲染并播行级动画。
     */
    private void firstProbe() {
        final Context app = requireContext().getApplicationContext();
        runAsync(getString(R.string.status_busy_probe), () -> {
            // prefs 首读要走磁盘（首次加载 XML），与 root 尝试一并放后台线程
            SharedPreferences prefs =
                    app.getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
            boolean needRoot = !prefs.getBoolean(Deployer.KEY_ROOT_TRIED, false);
            String rootNote = "";
            if (needRoot) {
                // 先落标记再尝试：被拒/失败都不再自动重试
                prefs.edit().putBoolean(Deployer.KEY_ROOT_TRIED, true).apply();
                rootJustGranted = Deployer.get(app).ensureRoot();
                rootNote = app.getString(rootJustGranted
                        ? R.string.status_root_ok_log : R.string.status_root_fail_log);
            }
            final String statusText = probeAndAutoFixScript(app);
            // 首探的 root 结论与探测提示同属「状态块下方的提示」，不再混进状态文本
            if (!rootNote.isEmpty()) {
                probeNotices = probeNotices.isEmpty()
                        ? rootNote : rootNote + '\n' + probeNotices;
            }
            return statusText;
        }, false, false);   // 首次探测：不写记录、不压暗；内容变化按统一口径播动画
    }

    /**
     * 刷新入口。
     *
     * @param manual true = 用户点了「刷新状态」：立即播「正在探测…」动画并写一条记录，
     *               再启动或复用扫描；false = onResume 的静默刷新（仍受 30 秒节流）。
     */
    private void refreshStatus(boolean manual) {
        if (manual) {
            requestManualRefresh();
            return;
        }
        if (System.currentTimeMillis() - lastProbeAtMs < PROBE_MIN_INTERVAL_MS) {
            return;   // 刚探过：su 往返（含可能自动重推 service.d 脚本）不必再来一次
        }
        if (actionRunning) {
            return;   // 动作中不插探测；5 秒周期会补
        }
        requestSilentRefresh();
    }

    /**
     * 手动刷新：动画与扫描并行——先把占位文案立即上屏，再挂监听并启动/复用扫描，
     * 结果到达才淡入结果。动作进行中仍按既有规则拒绝（不播动画、不压暗按钮）。
     *
     * <p>占位分两种：当前以 {@code 部署状态：} 开头时只替换结论行（行数不变，走交叉淡变）；
     * 否则回退整段「读取部署状态…」占位（只换字、钉住高度）。
     */
    private void requestManualRefresh() {
        if (!isAdded() || statusView == null) {
            return;
        }
        if (actionRunning) {
            appendLog(getString(R.string.status_busy_other));
            Toast.makeText(requireContext(), R.string.status_busy_other, Toast.LENGTH_SHORT).show();
            return;
        }
        appendLog(getString(R.string.status_busy_probe));
        if (!replaceDeployFirstLine(R.string.status_deploy_checking)) {
            // 非「部署状态：」形态（动作结果）：只换结论行、保留现有明细，
            // 避免清空明细却钉住旧高度，留出整块空白/黑块
            writeStatusText(withCurrentDetailRows(getString(R.string.status_busy_probe)), true, true);
        }
        scanManualPending = true;
        if (scanRunning) {
            // 复用的是进行中的静默扫描：这次是手动触发，进度条要亮
            scanBusy = true;
            updateBusy();
        }
        startScanIfNeeded();
    }

    /**
     * 当前结论行是「部署状态：…」形态时，只把<b>动态值</b>换成给定文案（正在检测 / 部署中…），
     * 静态标签与明细行原样保留。动态值独立成视图且不可选中，只对该视图播交叉淡变，
     * 不做高度动画，也不存在选区被清掉的问题。
     *
     * @param placeholderRes 临时首行文案（须以「部署状态：」开头）
     * @return true = 已走首行替换；false = 当前不是部署状态文本（调用方自行决定是否回退）
     */
    private boolean replaceDeployFirstLine(int placeholderRes) {
        final TextView view = statusView;
        if (view == null || statusLabelView == null
                || statusLabelView.getVisibility() != View.VISIBLE) {
            return false;
        }
        final String placeholder = getString(placeholderRes);
        if (!placeholder.startsWith(DEPLOY_STATUS_PREFIX)) {
            return false;   // 资源必须是带「部署状态：」前缀的临时首行
        }
        final String currentValue = view.getText().toString();
        final String placeholderValue = placeholder.substring(DEPLOY_STATUS_PREFIX.length());
        if (placeholderValue.equals(currentValue)) {
            return true;   // 已在该临时态：保留首次记下的原动态值，不重复覆盖
        }
        deployFirstLineBackup = currentValue;
        deployFirstLinePlaceholder = placeholderValue;
        writeDeployFirstLineValue(placeholderValue);
        return true;
    }

    /**
     * 只改结论动态值（明细行保留）：内容没变不写；变化与整段刷新同口径，走交叉淡变+模糊。
     */
    private void writeDeployFirstLineValue(String value) {
        final TextView view = statusView;
        if (view == null || TextUtils.equals(value, view.getText())) {
            return;
        }
        Motion.cancelHeightChange(statusStack);
        Motion.crossFade(() -> {
            if (statusView != null) {
                statusView.setText(value);
            }
        }, view);
    }

    /**
     * 扫描失败时恢复被临时替换的动态值（失败分支只弹对话框、不换文本，不能把值留在「正在检测」）。
     * 仅在动态值仍是该临时态时恢复，避免把过期备份写进已被其它结果覆盖的文本。
     */
    private void restoreDeployFirstLineIfNeeded() {
        final String backup = deployFirstLineBackup;
        final String placeholder = deployFirstLinePlaceholder;
        deployFirstLineBackup = null;
        deployFirstLinePlaceholder = null;
        final TextView view = statusView;
        if (backup == null || placeholder == null || view == null) {
            return;
        }
        if (!placeholder.equals(view.getText().toString())) {
            return;   // 临时态已被完整结果/动作文案覆盖，无需恢复
        }
        writeDeployFirstLineValue(backup);
    }

    /** 作废首行替换的备份（结果已整段覆盖时调用，避免过期备份被后续失败分支误用）。 */
    private void clearDeployFirstLineBackup() {
        deployFirstLineBackup = null;
        deployFirstLinePlaceholder = null;
    }

    /** 第一行结束位置（不含换行符）；无换行时返回整串长度。 */
    private static int firstLineEnd(String text) {
        final int newline = text.indexOf('\n');
        return newline < 0 ? text.length() : newline;
    }

    /** 把整段状态文本切成「结论行 + 明细块（不含开头换行）」；无换行时明细块为空串。 */
    private static String[] splitStatusText(String text) {
        final int end = firstLineEnd(text);
        return end < text.length()
                ? new String[]{text.substring(0, end), text.substring(end + 1)}
                : new String[]{text, ""};
    }

    /** 明细块切成行数组；空块返回空数组（末尾换行不产生空行）。 */
    private static List<String> splitDetailRows(String detail) {
        final List<String> rows = new ArrayList<>();
        if (detail != null && !detail.isEmpty()) {
            for (String line : detail.split("\n", -1)) {
                rows.add(line);
            }
        }
        return rows;
    }

    /** 当前「标签 + 动态值 + 明细行」拼回的整段文本（原始完整路径；用于「先比后写」与长按复制）。 */
    private String fullStatusText() {
        if (statusView == null) {
            return "";
        }
        final boolean hasLabel = statusLabelView != null
                && statusLabelView.getVisibility() == View.VISIBLE;
        final StringBuilder sb = new StringBuilder();
        if (hasLabel) {
            sb.append(DEPLOY_STATUS_PREFIX);
        }
        sb.append(statusView.getText());
        for (String row : detailRowTexts) {
            sb.append('\n').append(row);
        }
        return sb.toString();
    }

    /** 长按复制的整块全文：结论 + 明细（不含状态块下方的探测提示，提示行另行复制）。 */
    private CharSequence statusCopyText() {
        return fullStatusText();
    }

    /** 结论行 + 当前明细行（原始文本）拼回整段，供只换结论行的占位写入。 */
    private String withCurrentDetailRows(String conclusion) {
        final StringBuilder sb = new StringBuilder(conclusion);
        for (String row : detailRowTexts) {
            sb.append('\n').append(row);
        }
        return sb.toString();
    }

    /** 当前状态文本是否等于给定整段文本（只比字符，不比 span）。 */
    private boolean statusTextEquals(CharSequence value) {
        return TextUtils.equals(fullStatusText(), value);
    }

    /** 静默刷新：不写记录、不做动画；扫描中复用同一趟。 */
    private void requestSilentRefresh() {
        if (!isAdded() || statusView == null || actionRunning) {
            return;
        }
        scanSilentPending = true;
        startScanIfNeeded();
    }

    /** 启动一趟扫描；已在跑则只挂监听（结果由 {@link #finishScan} 统一分发）。 */
    private void startScanIfNeeded() {
        if (scanRunning) {
            return;
        }
        scanRunning = true;
        final int generation = ++scanGeneration;
        final Context app = requireContext().getApplicationContext();
        // 手动发起才允许自动重推脚本；周期/静默探测不做这个有副作用的动作。
        final boolean allowAutoFix = scanManualPending;
        lastProbeAtMs = System.currentTimeMillis();
        scanBusy = scanManualPending;   // 静默/周期扫描不闪进度条；手动扫描才显示
        updateBusy();
        Thread thread = new Thread(() -> {
            String text;
            boolean failed = false;
            try {
                text = probeAndAutoFixScript(app, allowAutoFix);
            } catch (Throwable t) {
                text = "出错：" + t;
                failed = true;
            }
            final String result = text == null ? "" : text;
            final boolean isFailure = failed;
            MAIN.post(() -> finishScan(generation, result, isFailure));
        }, "ww-probe");
        thread.setDaemon(true);
        thread.start();
    }

    /** 扫描收尾（主线程）：分发结果、应用探测副作用，并重置 5 秒周期计时。 */
    private void finishScan(int generation, String result, boolean failed) {
        if (generation != scanGeneration) {
            return;   // 视图已销毁或有更新的一趟：旧结果作废
        }
        scanRunning = false;
        scanBusy = false;
        updateBusy();
        final boolean manual = scanManualPending;
        final boolean silent = scanSilentPending;
        scanManualPending = false;
        scanSilentPending = false;
        if (periodicActive) {
            startPeriodicRefresh();   // 扫描结束重新计 5 秒，而不是固定自调度
        }
        if (!isAdded() || statusView == null) {
            return;
        }
        if (actionRunning) {
            // 动作正在上屏（如部署占位）：本次结果不覆盖它，只留手动记录；
            // 动作收尾后 5 秒周期会再探一次。
            if (manual) {
                appendLog(result);
                if (failed) {
                    // 失败弹窗走不到 renderScanResult，这里也要把临时结论行恢复
                    restoreDeployFirstLineIfNeeded();
                }
            }
        } else {
            renderScanResult(result, manual, silent, failed);
        }
        applyProbeSideEffects();
    }

    /** 把扫描结果分发给监听者：手动播动画并写记录；静默内容变化时播行级动画，无变化不碰视图。 */
    private void renderScanResult(String result, boolean manual, boolean silent, boolean failed) {
        if (manual) {
            appendLog(result);
            if (failed) {
                restoreDeployFirstLineIfNeeded();
                showDismissOnOutside(new AlertDialog.Builder(requireContext())
                        .setTitle(R.string.status_dialog_failed)
                        .setMessage(PathDisplay.format(requireContext(), result))
                        .setPositiveButton(R.string.status_dialog_close, null)
                        .create());
                return;
            }
            writeStatusText(result, false, true);
            return;
        }
        if (!silent || statusView == null) {
            return;
        }
        if (failed) {
            restoreDeployFirstLineIfNeeded();
            // 静默/周期探测失败不弹窗（否则每 5 秒叠一个）；限频写操作记录，状态区保持上次成功结果
            final long now = System.currentTimeMillis();
            if (now - lastSilentFailureLogMs >= SILENT_FAILURE_LOG_MIN_INTERVAL_MS) {
                lastSilentFailureLogMs = now;
                appendLog(result);
            }
            return;
        }
        // 状态文本可能没变，但提示是本次探测的新结果：两处分开，提示要独立刷新
        updateProbeNoticeView();
        if (System.currentTimeMillis() < statusHoldUntilMs) {
            return;   // 部署/拉起结果的保留期内：周期扫描不覆盖状态文本
        }
        // 内容真变化才走动画：只模糊变化处；无变化由统一入口直接返回，不碰视图
        writeStatusText(result, false, true);
    }

    /** 启动（或重置）周期静默复探：先摘掉旧的一拍，避免重复排队。 */
    private void startPeriodicRefresh() {
        periodicActive = true;
        MAIN.removeCallbacks(periodicRefresh);
        MAIN.postDelayed(periodicRefresh, PERIODIC_REFRESH_MS);
    }

    /** 停止周期静默复探（幂等）：离屏、暂停、视图销毁时调用。 */
    private void stopPeriodicRefresh() {
        periodicActive = false;
        MAIN.removeCallbacks(periodicRefresh);
    }

    /** 作废在跑的扫描（离屏/暂停/销毁）：旧回调按代号丢弃，监听与进度条一并清掉。 */
    private void invalidateScan() {
        scanGeneration++;
        scanRunning = false;
        scanManualPending = false;
        scanSilentPending = false;
        scanBusy = false;
        updateBusy();
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
        return probeAndAutoFixScript(app, true);
    }

    /**
     * 同上，{@code allowAutoFix} 控制脚本哈希不一致时要不要自动重推。
     * 5 秒周期复探传 false：探测与上屏照常，但不在每次复探里重启守护进程（自愈留给手动刷新/回页）。
     */
    private String probeAndAutoFixScript(Context app, boolean allowAutoFix) {
        final Deployer deployer = Deployer.get(app);
        Deployer.Status status = deployer.probe();
        lastProbeExpectedMd5 = status.binExpectedMd5;
        // 探测提示不拼进状态文本：脚本重推与同步清单各占一行，由状态块下方的独立视图显示
        final StringBuilder notices = new StringBuilder();
        // su 不可用时不尝试（否则每次进页面都白撞一次授权框）
        if (allowAutoFix && status.suOk && status.scriptPresent && !status.scriptHashOk) {
            // 三选一，判据取自紧随其后的那次 probe（更晚、更权威，且不额外增加 su 往返）——见 app/逻辑说明.md §8.1
            Deployer.Result r = deployer.updateScript();
            status = deployer.probe();
            lastProbeExpectedMd5 = status.binExpectedMd5;
            int res;
            if (!r.ok) {
                res = R.string.status_script_autofix_failed;
            } else if (!status.daemonRunning) {
                res = R.string.status_script_autofixed_no_daemon;
            } else {
                res = R.string.status_script_autofixed;
            }
            notices.append(app.getString(res));
        }
        // 同步清单只随 APK 变（进程存活期内 APK 不可能变）：成功刷新过就不再重复读盘，失败仍重试
        final String manifestNote;
        if (syncManifestDone) {
            manifestNote = null;
        } else {
            manifestNote = deployer.writeSyncManifestIfNeeded();
            if (manifestNote == null) {
                syncManifestDone = true;   // 成功（含"无需刷新"）：本进程不再重复
            }
        }
        if (manifestNote != null) {
            if (notices.length() > 0) {
                notices.append('\n');
            }
            notices.append(manifestNote);
        }
        probeNotices = notices.toString().trim();
        armDeployPrompt(app, status);
        rememberDeployedBinMd5(app, status);
        // 顺手记下本次探测的 root 可用性：落页判定下次冷启动据此判"root 尚未取得"（见 app/逻辑说明.md §5.1）。
        // 值没变就不重复落盘（首次先取盘上现值对一次，避免"首轮恰等于默认值 → 漏写"）。本方法在后台线程。
        if (!rootOkSeen) {
            lastRootOk = !Deployer.rootNotYetGranted(app);
            rootOkSeen = true;
        }
        if (status.suOk != lastRootOk) {
            Deployer.rememberRootState(app, status.suOk);
            lastRootOk = status.suOk;
        }
        // 兜底归一：源侧已保证 describe() 不产出末尾换行（见 app/逻辑说明.md §8.1），这里仍 trim 一次。
        // 「先比后写」的 contentEquals 与写入都用这一份，否则每 5 秒静默复探都会被判成变化。
        // 提示独立成 probeNotices，不进状态文本，故缓存也只存状态本身。
        final String result = status.describe().trim();
        // 回写进程内缓存：下次建页（含旋转/返回本页）直接拿它上屏，再后台刷新
        DeployStatusCache.store(result);
        return result;
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
     * 手动「一键部署」入口：与自动更新共用 {@link #runDeploy(boolean)}，不另写一份状态机。
     */
    private void deploy() {
        runDeploy(false);
    }

    /**
     * 部署的唯一实现：手动按钮与自动更新走同一条动作链——同一个 {@code runAsyncBlocking→runAsync}
     * 回调、同一组 {@code deployPlaced/deployFailed/actionGeneration/statusHoldUntilMs} 字段；
     * 部署成功后的拉起仍调用手动按钮的同一个 {@link #startDaemon()}，不复制其代码。
     * 自动路径只在成功回调里补一条「已自动重新部署」，失败不再提前写永久归档。
     * 开始即把忙态文案写进操作记录；当前文本是部署状态时只换结论行（行数不变）。
     */
    private void runDeploy(final boolean auto) {
        if (auto && System.currentTimeMillis() < autoDeployBackoffUntilMs) {
            return;   // 退避期内（含并发扫描刚武装的）不自动部署
        }
        daemonStoppedByUser = false;   // 部署结束会接着拉起（见本方法的 after 回调）
        final Context app = requireContext().getApplicationContext();
        final String busyText = getString(R.string.status_busy_deploy);
        // 上一次的结论不得残留：任务在赋值前抛异常时，失败分支会误判为成功
        deployPlaced = false;
        deployFailed = false;
        // 已有动作在跑时 runAsync 会直接返回（只写一条操作记录），此时不能换占位文案，否则会永久残留
        if (!actionRunning) {
            // 占位与结果统一走动画入口；动作进行中不覆盖现有状态
            replaceDeployFirstLine(R.string.status_deploy_busy);
        }
        runAsyncBlocking(busyText, () -> {
            try {
                Deployer.Result result = Deployer.get(app).deploy();
                deployPlaced = result.placementsOk;
                deployFailed = !result.ok;
                return result.status != null ? result.status.describe() : result.describe();
            } catch (Throwable t) {
                deployPlaced = false;
                deployFailed = true;
                if (t instanceof Exception) {
                    throw (Exception) t;
                }
                if (t instanceof Error) {
                    throw (Error) t;
                }
                throw new RuntimeException(t);
            }
        }, false, true, () -> {
            if (deployFailed) {
                // 失败恢复被替换的结论行；清一次性标记，允许下一轮重新判定
                restoreDeployFirstLineIfNeeded();
                clearPromptMark();
                if (Deployer.isAutoUpdateEnabled(app)) {
                    noteAutoDeployFailure();   // 手动失败也要退避，否则下一拍自动更新会立即重跑
                }
            } else {
                clearDeployFirstLineBackup();   // 结果已整段覆盖，备份作废
                resetAutoDeployBackoff();
                if (auto) {
                    // 成功后才写这条永久归档；失败不再留下「已重新部署」
                    appendLog(getString(R.string.status_auto_deploy_log));
                }
            }
            if (deployPlaced) {
                startDaemon(!auto);   // 与部署同源：仅用户触发时显示「正在拉起」占位
            }
        }, RESULT_HOLD_MS);
    }

    /** 记一次自动部署失败并设置指数退避：60s、120s、240s…上限 30 分钟。 */
    private void noteAutoDeployFailure() {
        final int failures = Math.min(autoDeployFailures + 1, 8);
        autoDeployFailures = failures;
        if (!lastProbeExpectedMd5.isEmpty()) {
            autoDeployFailedMd5 = lastProbeExpectedMd5;
        }
        final long delay = AUTO_DEPLOY_BACKOFF_BASE_MS << Math.min(failures - 1, 5);
        autoDeployBackoffUntilMs = System.currentTimeMillis()
                + Math.min(delay, AUTO_DEPLOY_BACKOFF_MAX_MS);
    }

    /** 成功部署（自动或手动）、检测到 APK md5 变化或进程重启时清空退避。 */
    private void resetAutoDeployBackoff() {
        autoDeployFailures = 0;
        autoDeployBackoffUntilMs = 0L;
        autoDeployFailedMd5 = "";
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
        runAsyncBlocking(getString(R.string.status_busy_uninstall),
                () -> Deployer.get(app).uninstall().describe(), false, true);
    }

    /** 用户入口（按钮 / 根可用提示 / 未运行提示）：状态区显示「正在拉起」，结果按实际内容刷新。 */
    private void startDaemon() {
        startDaemon(true);
    }

    /** @param userVisible true = 用户触发：先播「正在拉起」占位；自动部署链传 false */
    private void startDaemon(boolean userVisible) {
        daemonStoppedByUser = false;   // 用户明确要拉起：把「刚停过」的抑制位清掉
        final Context app = requireContext().getApplicationContext();
        if (userVisible && !actionRunning) {
            replaceDeployFirstLine(R.string.status_deploy_starting);
        }
        final Runnable restorePlaceholder =
                userVisible ? this::restoreDeployFirstLineIfNeeded : null;
        runAsyncBlocking(getString(R.string.status_busy_start),
                () -> Deployer.get(app).startDaemon().describe(), false, true,
                restorePlaceholder, RESULT_HOLD_MS);
    }

    private void stopDaemon() {
        // 「没在跑」那条提示的抑制位：刚点过停止就别马上再问"要不要拉起来"（见 armDeployPrompt）
        daemonStoppedByUser = true;
        final Context app = requireContext().getApplicationContext();
        runAsyncBlocking(getString(R.string.status_busy_stop),
                () -> Deployer.get(app).stopDaemon().describe(), false, true);
    }

    // ==================== 破坏性动作的二次确认 ====================

    /**
     * 点「确认」才执行、点「取消」什么都不做。两个入口（卸载部署 / kill daemon）
     * 都会中断或移除温控增强，且都是一次点击就落盘或杀进程，故都要先问一次。
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
        // 正文（含 su 诊断全文）可长按选中复制；必须在 show() 之前挂，onShow 里才取得到 message
        TextCopy.makeMessageSelectable(dialog);
        dialog.show();
    }

    /** 「卸载部署」的确认入口（动作本身见 {@link #uninstall()}）。 */
    private void confirmUninstall() {
        confirmThen(R.string.status_dialog_uninstall_title,
                R.string.status_dialog_uninstall_message,
                R.string.status_dialog_uninstall_confirm, this::uninstall);
    }

    /** 「kill daemon」的确认入口（动作本身见 {@link #stopDaemon()}）。 */
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
     * @param manual   true = 写操作记录；false = 非手动刷新不写记录
     */
    private void runAsync(final String busyText, final Task task, final boolean asDialog,
                          final boolean manual) {
        runAsync(busyText, task, asDialog, manual, null, false, 0L);
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
        runAsync(busyText, task, asDialog, manual, after, false, 0L);
    }

    /** 需要压暗全部按钮的动作（部署/卸载/拉起/kill daemon）。 */
    private void runAsyncBlocking(final String busyText, final Task task, final boolean asDialog,
                                  final boolean manual) {
        runAsync(busyText, task, asDialog, manual, null, true, 0L);
    }

    /** 同上，带 after（部署→自动拉起）。 */
    private void runAsyncBlocking(final String busyText, final Task task, final boolean asDialog,
                                  final boolean manual, @Nullable final Runnable after) {
        runAsync(busyText, task, asDialog, manual, after, true, 0L);
    }

    /**
     * 同上，并指定结果保留时长：部署/拉起的结果上屏后至少保留 {@code holdStatusMs}，
     * 期间的周期静默扫描不覆盖状态文本（手动刷新不受限）。
     */
    private void runAsyncBlocking(final String busyText, final Task task, final boolean asDialog,
                                  final boolean manual, @Nullable final Runnable after,
                                  final long holdStatusMs) {
        runAsync(busyText, task, asDialog, manual, after, true, holdStatusMs);
    }

    /**
     * 动作核心。{@code dimButtons} 为 true 时在起跑点禁用并压暗全部按钮、收尾恢复；
     * 扫描/刷新走 {@link #startScanIfNeeded()}，不经过这里、也不压暗按钮。
     */
    private void runAsync(final String busyText, final Task task, final boolean asDialog,
                          final boolean manual, @Nullable final Runnable after,
                          final boolean dimButtons, final long holdStatusMs) {
        if (actionRunning) {
            if (manual) {
                appendLog(getString(R.string.status_busy_other));
                Context context = getContext();
                if (context != null) {
                    Toast.makeText(context, R.string.status_busy_other, Toast.LENGTH_SHORT).show();
                }
            }
            return;
        }
        actionRunning = true;
        actionDimmed = dimButtons;
        if (dimButtons) {
            setButtonsBlocked(true);
        }
        final int generation = ++actionGeneration;
        lastProbeAtMs = System.currentTimeMillis();
        actionBusy = true;
        updateBusy();
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
            // contentEquals 不接受 null（任务实现一律不返回 null，这里只是兜底）；
            // 源侧已保证不产出末尾换行，此处仍归一作兜底，保证比对与写入是同一份文本（见 app/逻辑说明.md §8.1）
            final String result = text == null ? "" : text.trim();
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
                if (generation != actionGeneration) {
                    // 期间已起了新动作：旧结果与 after 整段丢弃，绝不覆盖新动作的状态
                    return;
                }
                if (!isAdded() || statusView == null) {
                    // 视图暂时不在：放开占用位；若动作未被新动作取代，after 仍要跑
                    // （部署后的拉起不能因为一次视图重建而丢）
                    finishAction(generation);
                    if (after != null && isAdded()) {
                        after.run();
                    }
                    return;
                }
                // 结果已回到主线程：本动作到此结束，先放掉占用——紧接着要接的那一段（after）
                // 才不会被守卫挡在门外
                finishAction(generation);
                if (manual) {
                    appendLog(result);
                }
                if (asDialog || isFailure) {
                    // 必须用宿主 Activity 的 Context 建弹窗：application context 没有窗口 token，
                    // AlertDialog.show() 会抛 BadTokenException（su 诊断等长文本动作闪退的根因）。
                    // 不 try/catch 吞掉：能走到这里说明本页已 attach，用错 Context 才是缺陷本身；
                    // 吞异常只会把「弹窗没出现」变成静默失败，掩盖真正的生命周期问题。
                    showDismissOnOutside(new AlertDialog.Builder(requireContext())
                            .setTitle(isFailure ? R.string.status_dialog_failed
                                    : R.string.status_dialog_diag)
                            .setMessage(PathDisplay.format(requireContext(), result))
                            .setPositiveButton(R.string.status_dialog_close, null)
                            .create());
                } else if (manual) {
                    writeStatusText(result, false, true);
                    if (holdStatusMs > 0) {
                        // 部署/拉起结果：到期前周期扫描不许覆盖
                        statusHoldUntilMs = System.currentTimeMillis() + holdStatusMs;
                    }
                } else {
                    // 状态文本可能没变，但提示是本次探测的新结果：提示独立刷新
                    updateProbeNoticeView();
                    writeStatusText(result, false, true);
                }
                if (after != null) {
                    after.run();
                }
                applyProbeSideEffects();
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
        actionBusy = false;
        updateBusy();
        if (actionDimmed) {
            actionDimmed = false;
            setButtonsBlocked(false);
        }
    }

    /**
     * 应用探测副作用（部署提示 / 自动更新 / 刚拿授权）。动作进行中时直接返回、把状态留在字段里，
     * 由动作收尾后的 {@code runAsync} 回调再调一次；避免提示与动作结果抢同一时机上屏。
     */
    private void applyProbeSideEffects() {
        if (actionRunning || !isAdded() || statusView == null) {
            return;
        }
        if (rootJustGranted) {
            rootJustGranted = false;
            // 刚拿到授权：这一支优先于「自动更新」的静默部署，同批武装的另一条请求就地作废
            // （见 app/逻辑说明.md §8.1）
            pendingPrompt = PROMPT_NONE;
            showDeployPrompt();
        } else if (autoDeployPending) {
            autoDeployPending = false;
            // 「自动更新」开着且设备上的内容旧了：不弹窗，走与手动部署完全相同的动作链；
            // 成功日志由 runDeploy 的成功回调补写，失败则进入退避。
            runDeploy(true);
        } else if (pendingPrompt != PROMPT_NONE) {
            final int kind = pendingPrompt;
            pendingPrompt = PROMPT_NONE;
            if (kind == PROMPT_HASH_MISMATCH) {
                showDeployRequest(R.string.status_hash_title, R.string.status_hash_message);
            } else if (kind == PROMPT_NOT_DEPLOYED) {
                showDeployRequest(R.string.status_notdeployed_title,
                        R.string.status_notdeployed_message);
            } else {
                showNotRunningPrompt();
            }
        }
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
                return;   // 用户刚点过「kill daemon」：别马上又问"要不要拉起来"
            }
            kind = PROMPT_NOT_RUNNING;
            mark = MARK_NOT_RUNNING + status.binMd5;
        } else {
            return;
        }
        final boolean auto = kind == PROMPT_HASH_MISMATCH && Deployer.isAutoUpdateEnabled(app);
        if (auto) {
            // 装新 APK 后 md5 变了必须立即重置，不能等满上一版的退避窗口
            if (!autoDeployFailedMd5.isEmpty()
                    && !status.binExpectedMd5.equals(autoDeployFailedMd5)) {
                resetAutoDeployBackoff();
            }
            if (System.currentTimeMillis() < autoDeployBackoffUntilMs) {
                return;   // 退避期内不武装、不写去重标记，下一拍自然跳过
            }
        }
        final SharedPreferences prefs =
                app.getSharedPreferences(Deployer.PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
        if (mark.equals(prefs.getString(Deployer.KEY_HASH_PROMPTED_MD5, null))) {
            return;
        }
        prefs.edit().putString(Deployer.KEY_HASH_PROMPTED_MD5, mark).apply();
        if (auto) {
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
        // 切的是正文容器（自适应高、无内部滚动）；展开/收起按逻辑 2 做高度补间
        // （系统关动画或宽度不可知时由 Motion 直接落位）；箭头用同一次返回的时长，两者同生共灭
        final long duration = logBody != null ? Motion.animateHeight(logBody, value) : -1L;
        if (arrowView != null) {
            // 时长来自上面那一次面板计算（面板直接落位时 duration<0，箭头也直接落位）
            Motion.rotate(arrowView, value ? ARROW_EXPANDED_ROTATION : 0f, duration);
            arrowView.setContentDescription(getString(value
                    ? R.string.config_action_collapse : R.string.config_action_expand));
        }
    }

    // ==================== 渲染小工具 ====================

    /**
     * 忙态指示：动作与扫描各自占一个位，任一方在跑就显示——互不抢先关掉对方的进度条。
     * 只切 {@code VISIBLE}/{@code INVISIBLE}、绝不用 {@code GONE}（进度条常占位，理由见
     * {@code app/逻辑说明.md} §8.1）。
     */
    private void updateBusy() {
        if (progress != null) {
            progress.setVisibility(actionBusy || scanBusy ? View.VISIBLE : View.INVISIBLE);
        }
    }

    /** 动作期间统一禁用并压暗全部按钮；收尾恢复可点并淡回不透明。扫描不调用这里。 */
    private void setButtonsBlocked(boolean blocked) {
        for (View b : actionButtons) {
            b.animate().cancel();
            b.setEnabled(!blocked);
            b.animate()
                    .alpha(blocked ? BUTTON_DIM_ALPHA : 1f)
                    .setDuration(blocked ? BUTTON_DIM_MS : BUTTON_RESTORE_MS)
                    .setInterpolator(Motion.easeOut())
                    .start();
        }
    }

    /**
     * 结论行与明细行对齐拆分前的单 TextView：全部关掉 {@code includeFontPadding}，
     * 再把这份 padding 按字体度量只补在整块的头尾——结论行容器（summary row）的顶部、
     * 明细块底部；明细为空时底部改由结论行容器承担。这样行高、行距、缩进与上下边界保持一致。
     */
    private void applyStatusTextMetrics() {
        if (statusView == null || statusLabelView == null
                || statusDetailList == null || statusSummaryRow == null) {
            return;
        }
        final Paint.FontMetricsInt fm = statusView.getPaint().getFontMetricsInt();
        statusTopPad = Math.max(0, fm.ascent - fm.top);
        statusBottomPad = Math.max(0, fm.bottom - fm.descent);
        statusLabelView.setIncludeFontPadding(false);
        statusView.setIncludeFontPadding(false);
        // 初态视作「无明细」：头部 padding 由结论行容器承担，明细块只承担尾部
        applySummaryBottomPad(false);
        statusDetailList.setPadding(0, 0, 0, statusBottomPad);
    }

    /** 结论行容器的量高把头部 font padding 算在内；底部 padding 只在没有明细行时承担。 */
    private void applySummaryBottomPad(boolean hasDetail) {
        if (statusSummaryRow == null) {
            return;
        }
        final int bottom = hasDetail ? 0 : statusBottomPad;
        statusSummaryRow.setPadding(0, statusTopPad, 0, bottom);
    }

    /**
     * 状态文本上屏。<b>业务上屏零延迟</b>——新文本立即写入，不等淡出结束。
     *
     * <p>部署状态拆成「静态标签 + 动态值」与「逐行明细」（每行一个 TextView）：
     * <b>只有动态值文本变化时</b>才对动态值播 {@link Motion#crossFade}（含模糊）；
     * 静态标签不参与淡化/模糊。明细行按位置逐行比对：内容没变不播动画，内容变了只对该行
     * 播 {@code crossFade}，新增行在高度补间把它露出时带模糊淡入，删除行直接移除。
     *
     * <p>{@code animated} 由调用点决定：除首次上屏/骨架切换外一律传 true，变化处播淡变+模糊；
     * 首次上屏传 false，<b>直接替换文本与高度</b>。系统关掉动画时 true 路径也直接换字。
     *
     * <p>行数/高度变化仍复用配置页那套 {@link Motion#animateHeightChange}
     * （{@code ValueAnimator} + panelCurve）：变更行与结论同拍启动；新增行按该曲线算出
     * 自己被露出的时刻再带模糊淡入，不等补间结束。
     *
     * @param keepHeight true = 本次只换字、不驱动高度：把当前高度钉住。
     *                   手动刷新的单行「正在探测…」占位用它，避免窗口先被占位压矮、结果到达再撑开；
     *                   结果到达的换字仍走 false，届时以钉住的高度为起点补间到结果高度。
     * @param animated   true = 内容变化处播交叉淡变（所有刷新与动作路径）；
     *                   false = 首次上屏/骨架切换，直替。
     */
    private void swapStatusTextAnimated(final String text, boolean keepHeight, boolean animated) {
        final TextView view = statusView;
        if (view == null || statusLabelView == null
                || statusDetailList == null || statusSummaryRow == null || !isAdded()) {
            return;
        }
        updateProbeNoticeView();   // 探测提示直接更新，不参与行级动画
        final String[] parts = splitStatusText(text);
        // 路径显示口径实时现取：结论与每一行各自裁剪
        final CharSequence shownConclusion = PathDisplay.format(view.getContext(), parts[0]);
        final List<String> rows = splitDetailRows(parts[1]);
        if (!animated) {
            swapStatusTextNow(shownConclusion, rows, keepHeight);
            return;
        }
        final int from = currentStatusStackHeight();
        final boolean animationsEnabled = Motion.enabled(view.getContext());
        final String shownValue = dynamicValue(shownConclusion.toString());
        final boolean valueChanged = !TextUtils.equals(shownValue, view.getText());
        final Runnable apply = () -> {
            List<TextView> addedRows = showStatusParts(shownConclusion, rows, true);
            applyStatusHeightAfterShow(keepHeight, from, animationsEnabled, addedRows);
        };
        if (!valueChanged) {
            // 结论动态值没变：只对内容变化的明细行播动画
            apply.run();
            return;
        }
        // 快照只覆盖结论动态值；明细行的淡变在 apply 内各自发起，同拍启动
        Motion.crossFade(apply, view);
    }

    /** 结论行去掉静态标签后的动态值（无标签时就是整行）。 */
    private static String dynamicValue(String conclusion) {
        return conclusion.startsWith(DEPLOY_STATUS_PREFIX)
                ? conclusion.substring(DEPLOY_STATUS_PREFIX.length()) : conclusion;
    }

    /**
     * 状态文案统一入口：先按现有行级模型比对，内容没变直接返回；有变化才渲染。
     * 首次上屏/骨架切换传 animate=false 直替，其余一律 animate=true。
     */
    private void writeStatusText(String text, boolean keepHeight, boolean animate) {
        if (statusTextEquals(text)) {
            return;
        }
        swapStatusTextAnimated(text, keepHeight, animate);
    }

    /**
     * 上屏后处理整体高度：keepHeight 钉住进入本次更新前的高度；否则补间到新自然高。
     * 新增行按「高度补间露出该行」的时刻带模糊淡入，不等到补间结束。
     */
    private void applyStatusHeightAfterShow(boolean keepHeight, int fromPx, boolean animationsEnabled,
                                            List<TextView> addedRows) {
        if (statusStack == null) {
            for (TextView row : addedRows) {
                fadeInWhenLaidOut(row);
            }
            return;
        }
        if (keepHeight) {
            // 只换字：钉住当前高度（可能正在补间，先记中间值再中止），不启动高度动画
            Motion.cancelHeightChange(statusStack);
            if (animationsEnabled && fromPx > 0) {
                ViewGroup.LayoutParams lp = statusStack.getLayoutParams();
                if (lp != null) {
                    lp.height = fromPx;
                }
            }
            for (TextView row : addedRows) {
                fadeInWhenLaidOut(row);
            }
            return;
        }
        final int toPx = measureStatusStackHeightNow();
        long duration = -1L;
        if (fromPx > 0 && toPx > 0) {
            duration = Motion.animateHeightChange(statusStack, fromPx, toPx, HEIGHT_SYNC_MS);
        } else {
            Motion.cancelHeightChange(statusStack);
        }
        scheduleAddedRowFades(addedRows, fromPx, toPx, duration);
    }

    /**
     * 新增行按高度补间的露出时刻淡入：行高用刚量到的 measuredHeight 反推，
     * 行顶一到可视区就起淡入，既不被裁剪遮掉，也不推迟到补间结束。
     * 没有高度补间时立即淡入。
     */
    private void scheduleAddedRowFades(List<TextView> rows, int fromPx, int toPx, long durationMs) {
        if (rows.isEmpty()) {
            return;
        }
        if (durationMs <= 0L || toPx <= fromPx) {
            for (TextView row : rows) {
                fadeInWhenLaidOut(row);
            }
            return;
        }
        final int delta = toPx - fromPx;
        int bottom = toPx - statusBottomPad;   // 明细列表末尾的底 padding 之后即最后一行底边
        for (int i = rows.size() - 1; i >= 0; i--) {
            final TextView row = rows.get(i);
            final int rowHeight = row.getMeasuredHeight();
            final int rowTop = bottom - rowHeight;
            bottom = rowTop;
            final long delay = Motion.revealDelayMs((rowTop - fromPx) / (float) delta, durationMs);
            if (delay <= 0L) {
                fadeInWhenLaidOut(row);
            } else {
                row.postDelayed(() -> {
                    if (statusDetailList != null && row.getParent() == statusDetailList) {
                        fadeInWhenLaidOut(row);
                    }
                }, delay);
            }
        }
    }

    /** 等行完成布局再带模糊淡入：模糊判据需要非零宽高，刚挂载的同帧量不到。 */
    private void fadeInWhenLaidOut(final TextView row) {
        if (row.getWidth() > 0 && row.getHeight() > 0) {
            Motion.fadeInBlurred(row);
            return;
        }
        row.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (v.getWidth() <= 0 || v.getHeight() <= 0) {
                    return;
                }
                v.removeOnLayoutChangeListener(this);
                if (statusDetailList != null && v.getParent() == statusDetailList) {
                    Motion.fadeInBlurred((TextView) v);
                }
            }
        });
    }

    /** 探测提示直接上屏/隐藏：有内容才显示，不参与行级动画。 */
    private void updateProbeNoticeView() {
        updateProbeNoticeView(false);
    }

    /** @param force true = 文本相同也重渲染（「展示完整路径」开关变化时强制换裁剪形态）。 */
    private void updateProbeNoticeView(boolean force) {
        if (statusProbeNoticeView == null) {
            return;
        }
        final String text = probeNotices;
        if (text != null && !text.isEmpty()) {
            if (force || !TextUtils.equals(text, statusProbeNoticeView.getText())) {
                applyRowText(statusProbeNoticeView, text);
            }
            statusProbeNoticeView.setVisibility(View.VISIBLE);
        } else {
            statusProbeNoticeView.setText("");
            statusProbeNoticeView.setVisibility(View.GONE);
        }
    }

    /**
     * 结论行按静态标签拆开：标签只随形态显隐、永远直替；动态值单独写。
     * 明细行交给 {@link #renderDetailRows(List, boolean)} 逐行 diff。
     *
     * @return 新增（挂载）的明细行，供高度展开到位后淡入；无新增时为空
     */
    private List<TextView> showStatusParts(CharSequence conclusion, List<String> rows,
                                           boolean animateRows) {
        if (statusView == null || statusLabelView == null || statusDetailList == null) {
            return new ArrayList<>();
        }
        final String head = conclusion == null ? "" : conclusion.toString();
        final boolean hasLabel = head.startsWith(DEPLOY_STATUS_PREFIX);
        final boolean hasRows = rows != null && !rows.isEmpty();
        applySummaryBottomPad(hasRows);
        if (hasLabel) {
            statusLabelView.setText(DEPLOY_STATUS_PREFIX);
            statusLabelView.setVisibility(View.VISIBLE);
            statusView.setText(head.substring(DEPLOY_STATUS_PREFIX.length()));
        } else {
            statusLabelView.setText("");
            statusLabelView.setVisibility(View.GONE);
            statusView.setText(head);
        }
        return renderDetailRows(rows == null ? new ArrayList<>() : rows, animateRows);
    }

    /**
     * 无动画直接换字（首次上屏/骨架切换）：先收掉可能残留的淡变与高度补间，再把文本与高度直接落位。
     * 高度语义与原路径一致：{@code keepHeight} 钉住当前高度；否则还原 {@code WRAP_CONTENT}，
     * 由新文本自然高度决定（无补间）。
     */
    private void swapStatusTextNow(CharSequence conclusion, List<String> rows, boolean keepHeight) {
        if (statusView == null || statusDetailList == null || statusSummaryRow == null) {
            return;
        }
        updateProbeNoticeView();   // 探测提示直接更新，不参与行级动画
        final int held = keepHeight ? currentStatusStackHeight() : 0;
        cancelFade();   // 取消可能继承自用户动作的 alpha/高度补间，并复位透明度
        if (held > 0 && statusStack != null) {
            ViewGroup.LayoutParams lp = statusStack.getLayoutParams();
            if (lp != null) {
                lp.height = held;
            }
        }
        showStatusParts(conclusion, rows, false);
    }

    /**
     * 明细行按位置逐行比对（新行数组 vs 上一帧行数组）：
     * 内容没变 → 不碰视图；内容变了 → 只对这几行播 {@link Motion#crossFade}；
     * 新增行 → 挂载前置透明，由调用方按露出时刻带模糊淡入；删除行 → 直接移除。
     *
     * @return 新增的行（{@code animateRows=false} 时为空）
     */
    private List<TextView> renderDetailRows(List<String> rows, boolean animateRows) {
        if (statusDetailList == null) {
            return new ArrayList<>();
        }
        final int common = Math.min(detailRowTexts.size(), rows.size());
        final List<TextView> changedViews = new ArrayList<>();
        final List<String> changedTexts = new ArrayList<>();
        for (int i = 0; i < common; i++) {
            if (!TextUtils.equals(detailRowTexts.get(i), rows.get(i))) {
                changedViews.add(detailRowViews.get(i));
                changedTexts.add(rows.get(i));
            }
        }
        // 删除多余旧行：直接移除
        for (int i = detailRowViews.size() - 1; i >= rows.size(); i--) {
            TextView removed = detailRowViews.remove(i);
            Motion.cancelCrossFade(removed);
            statusDetailList.removeView(removed);
            detailRowTexts.remove(i);
        }
        // 变化行：同一轮 crossFade 抓旧快照，再逐行换文本；只覆盖这几行
        if (animateRows && !changedViews.isEmpty()) {
            Motion.crossFade(() -> {
                for (int i = 0; i < changedViews.size(); i++) {
                    applyRowText(changedViews.get(i), changedTexts.get(i));
                }
            }, changedViews.toArray(new View[0]));
        } else {
            for (int i = 0; i < changedViews.size(); i++) {
                Motion.cancelCrossFade(changedViews.get(i));
                applyRowText(changedViews.get(i), changedTexts.get(i));
            }
        }
        for (int i = 0; i < common; i++) {
            detailRowTexts.set(i, rows.get(i));
        }
        // 新增行：挂载前置透明，由调用方按高度补间的露出时刻带模糊淡入，避免闪出一帧实心内容
        final List<TextView> addedRows = new ArrayList<>();
        for (int i = common; i < rows.size(); i++) {
            TextView row = createDetailRow(rows.get(i));
            if (animateRows) {
                row.setAlpha(0f);
            }
            detailRowViews.add(row);
            detailRowTexts.add(rows.get(i));
            statusDetailList.addView(row);
            addedRows.add(row);
        }
        statusDetailList.setVisibility(rows.isEmpty() ? View.GONE : View.VISIBLE);
        return animateRows ? addedRows : new ArrayList<>();
    }

    /** 新建一行（整行一个 TextView）：挂路径点击、长按整块复制与限频触摸日志。 */
    private TextView createDetailRow(String text) {
        TextView row = (TextView) LayoutInflater.from(statusDetailList.getContext())
                .inflate(R.layout.item_status_detail_row, statusDetailList, false);
        row.setIncludeFontPadding(false);
        row.setFocusable(false);
        row.setOnClickListener(v -> TextCopy.tapFirstPath(row));
        row.setOnTouchListener(this::logRowTouch);
        TextCopy.copyOnLongPress(row, this::statusCopyText);
        applyRowText(row, text);
        return row;
    }

    /**
     * 行文本统一渲染链：{@link PathDisplay#format}（完整路径裁剪 + PathTargetSpan）
     * → {@link TextCopy#withPathColors} → {@code setText}；有路径才可点。
     */
    private void applyRowText(TextView row, String raw) {
        CharSequence shown = PathDisplay.format(row.getContext(), raw);
        shown = TextCopy.withPathColors(row, shown);
        row.setText(shown);
        final boolean hasPath = TextCopy.hasPath(shown);
        TextCopy.refreshPathClickable(row, hasPath);
        // 静态自证：原始文本含路径的行必须确认渲染链补上了 span（无 span 也要留痕，不能静默）
        if (TextCopy.ABSOLUTE_PATH.matcher(raw).find()) {
            final int targetSpans = shown instanceof Spanned
                    ? ((Spanned) shown).getSpans(0, shown.length(),
                    TextCopy.PathTargetSpan.class).length : 0;
            Log.w(TAG, "row path: spanned=" + (shown instanceof Spanned)
                    + " targetSpans=" + targetSpans
                    + " hasPath=" + hasPath
                    + " clickable=" + row.isClickable()
                    + " first=" + TextCopy.firstPathText(shown) + " text=" + raw);
        }
    }

    /** 行触摸日志（限频 1s）：只观察 DOWN/UP，返回 false，不影响点击与页面滚动。 */
    private boolean logRowTouch(View v, MotionEvent event) {
        final int action = event.getActionMasked();
        if (action != MotionEvent.ACTION_DOWN && action != MotionEvent.ACTION_UP) {
            return false;
        }
        final long now = System.currentTimeMillis();
        if (now - lastRowTouchLogMs >= 1000L) {
            lastRowTouchLogMs = now;
            Log.w(TAG, "row touch " + (action == MotionEvent.ACTION_DOWN ? "DOWN" : "UP")
                    + " clickable=" + v.isClickable() + " text=" + ((TextView) v).getText());
        }
        return false;
    }

    /**
     * 叠放层当前自然高度（像素）：直接量已上屏的结论行容器 + 明细列表，再加结论行容器的
     * {@code marginTop}。宽度尚未排版时返回 -1（量不出真实换行，调用方据此放弃高度补间）。
     */
    private int measureStatusStackHeightNow() {
        if (statusSummaryRow == null) {
            return -1;
        }
        final int width = statusSummaryRow.getWidth() > 0
                ? statusSummaryRow.getWidth()
                : (statusStack == null ? 0 : statusStack.getWidth());
        if (width <= 0) {
            return -1;
        }
        statusSummaryRow.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int height = statusSummaryRow.getMeasuredHeight();
        if (statusDetailList != null && statusDetailList.getVisibility() == View.VISIBLE) {
            statusDetailList.measure(
                    View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            height += statusDetailList.getMeasuredHeight();
        }
        ViewGroup.LayoutParams lp = statusSummaryRow.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            height += ((ViewGroup.MarginLayoutParams) lp).topMargin;
        }
        return height;
    }

    /**
     * 叠放层当前高度：优先取 {@code lp.height}（高度补间进行中的中间值），否则取已布局实高。
     * 连续换字打断时以它为下一次补间的起点，避免从自然高重新起跳。
     */
    private int currentStatusStackHeight() {
        if (statusStack == null) {
            return 0;
        }
        ViewGroup.LayoutParams lp = statusStack.getLayoutParams();
        if (lp != null && lp.height > 0) {
            return lp.height;
        }
        return statusStack.getHeight();
    }

    /**
     * 中止高度补间并把承载层还原为 {@code WRAP_CONTENT}，同时让当前文本立即可读
     * （离开本页 / 视图销毁 / 直接改写文本前收尾）。
     * <p>{@link Motion#crossFade} 的快照层由它自己按 325ms（另加 16ms 收尾）退场并回收，这里不再介入；
     * 下次 {@code crossFade} 调用也会先收掉上一轮。
     */
    private void cancelFade() {
        if (statusView != null) {
            statusView.animate().cancel();
            statusView.setAlpha(1f);
        }
        Motion.cancelHeightChange(statusStack);
    }

    /**
     * 请求部署：「二进制与 APK 内不一致」与「从没部署过」两种情形共用——两者的动作都是「一键部署」、
     * 仅文案不同（去重见 {@link #armDeployPrompt}）。「从没部署过」这一支**不自动装**：用户此前从没
     * 同意过部署，只弹窗请求。第三种情形（进程没在跑）动作不同，见 {@link #showNotRunningPrompt()}。
     */
    private void showDeployRequest(int titleRes, int messageRes) {
        showDeployRequestPrompt(titleRes, messageRes, R.string.status_action_deploy,
                this::deploy);
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
        logText = line + "\n\n" + logText;
        if (logText.length() > 8000) {
            logText = logText.substring(0, 8000) + "\n…（已截断）";
        }
        // 正选中时不写视图（setText 会清掉选择与手柄），但模型照常累积，选择结束后补上
        if (TextCopy.isSelecting(logView)) {
            TextCopy.runWhenSelectionEnds(logView, this::flushPendingLog);
        } else {
            logView.setVisibility(View.VISIBLE);
            logView.setText(PathDisplay.format(requireContext(), logText));
        }
        if (archive != null) {
            archive.append(line);
            // 落盘后立刻重算：折叠态下份数/占用不再停在进页面时的旧值。
            // 代价可控——OpLog.snapshot() 是 O(1)（进页面时缓存既有归档基数，本会话文件只按当前长度累加），不做目录扫描。
            refreshArchiveHint();
        }
    }

    /** 选中结束后把操作记录的最新全文补进视图。 */
    private void flushPendingLog() {
        if (logView != null && !TextCopy.isSelecting(logView)) {
            logView.setText(PathDisplay.format(requireContext(), logText));
        }
    }

    /** 刷新归档提示行（进入本页、展开操作记录时各刷一次）。 */
    private void refreshArchiveHint() {
        if (archiveHintView == null || archive == null) {
            return;
        }
        if (TextCopy.isSelecting(archiveHintView)) {
            return;   // 选中期间不重写；选择结束后下一次刷新补上
        }
        OpLog.Info info = archive.snapshot();
        final String text;
        if (!info.available) {
            text = getString(R.string.status_archive_hint_unavailable, info.reason);
        } else if (info.count == 0) {
            text = getString(R.string.status_archive_hint_none, info.dir.getAbsolutePath());
        } else {
            text = getString(R.string.status_archive_hint,
                    info.dir.getAbsolutePath(), info.count,
                    formatArchiveUsage(info.bytes), OpLog.LIMIT_BYTES / 1024L);
        }
        CharSequence shown = PathDisplay.format(requireContext(), text);
        // 文本没变就不动视图：逐条刷新时避免无谓的重排
        if (!TextUtils.equals(shown, archiveHintView.getText())) {
            archiveHintView.setText(shown);
        }
    }

    /** 归档占用的数字部分（单位「KB」由提示行末尾统一给出，与上限共用）：始终一位小数。 */
    private static String formatArchiveUsage(long bytes) {
        return String.format(Locale.US, "%.1f", bytes / 1024.0);
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
     * 状态页承载的键数：供配置页的键渲染自检把「定义里有、由本页承载」算进可编辑入口
     * （见 app/逻辑说明.md §9.3）。
     *
     * <p>本页已不渲染任何参数键（「自动更新」迁往设置页），故恒为 0；
     * 方法保留是配置页自检的调用口径，待其另行迁移时再删。
     */
    static int statusPageKeyCount(@NonNull ConfigStore store) {
        return 0;
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
