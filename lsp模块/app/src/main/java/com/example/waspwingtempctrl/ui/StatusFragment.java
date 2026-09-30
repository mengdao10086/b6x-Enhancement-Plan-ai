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
 * 资源哈希不一致时自动重推一次。重推<b>会连带重启守护进程</b>（脚本与二进制是同一份部署产物，
 * 且脚本本身就是常驻的看门狗 shell，只换盘上文件它那一层仍跑旧映像）——见
 * {@link Deployer#updateScript()}。二进制不一致则代价高得多（要重装 + 重启），走
 * {@link #armDeployPrompt} 的判定：自动更新开着就直接重装，否则弹窗请求用户部署。
 *
 * <h3>刷新分两条路径（消闪烁）</h3>
 * 状态区是<b>单个 TextView</b>、卡片 {@code wrap_content}，一旦把约 8 行的结果换成 1 行忙文本，
 * 状态卡立刻变矮、其下两张卡整体上跳再回落 —— 这是"每次回状态页闪一下"的根因。故：
 * <ul>
 *   <li><b>静默路径</b>（首次探测在 {@code onViewCreated}、其余刷新在 {@code onResume}）：不碰状态区
 *       文本、不写操作记录、不做动画，结果先比后写（内容没变就一个字都不动）；30 秒内不重复跑 su 探测。</li>
 *   <li><b>手动路径</b>（用户点按钮）：写操作记录 + 结果文本淡出→换文本（带高度补间）→淡入。</li>
 * </ul>
 * <b>进度条两条路径都显示</b>（它是刷新唯一的反馈），且它在布局里常占位、可见性只影响绘制，
 * 故开关它不引起任何高度变化 —— 高度变化只来自手动路径的文本补间，那是要的效果而非闪烁。
 * 切页时外壳（{@code SetupActivity}）广播可见性，本类据此收掉在跑的动画（{@link PageAware}）。
 *
 * <p><b>首次探测（含那一次 root 尝试）为什么在 {@code onViewCreated} 而不在 {@code onResume}</b>：
 * 三页被外壳的 {@code FragmentStateAdapter} 在启动时一并建出来（{@code offscreenPageLimit = 2}），故
 * 本页的 {@code onViewCreated} 在冷启动那一刻就到了 —— 与"进 app"等价，首次滑到本页时结果通常已就绪，
 * 不必现场等一趟 su（原先挂在 {@code onResume}，那是 Activity 时代的接线：换成 ViewPager2 后非当前页
 * 只到 STARTED，等于"滑到才探"）。依赖：三页须仍在启动时全部建出来，将来改成懒加载就要挪回
 * {@code onResume}。
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

    /** 待弹的部署请求（探测阶段判定、主线程回调消费）：不弹。 */
    private static final int PROMPT_NONE = 0;
    /** 待弹：设备上的二进制与 APK 内不一致（已部署过）。 */
    private static final int PROMPT_HASH_MISMATCH = 1;
    /** 待弹：从没部署过（设备上没有二进制）。 */
    private static final int PROMPT_NOT_DEPLOYED = 2;
    /** 待弹：二进制就位且内容一致，但守护进程没在跑。 */
    private static final int PROMPT_NOT_RUNNING = 3;

    /**
     * 三种「待弹」情形的去重标记前缀。
     *
     * <p>都写进 {@link Deployer#KEY_HASH_PROMPTED_MD5} 这同一个键（值形如 {@code notdeployed:&lt;md5&gt;}）：
     * 每种情形各占一个前缀，故同一个 APK 版本里每种最多问一次；装了新 APK（指纹变了）会重新武装。
     * 沿用旧键是为了不给升级再加一个一次性标记 —— 旧值（裸 md5）与新格式对不上，
     * 升级后至多每个情形多问一次。
     */
    private static final String MARK_NOT_DEPLOYED = "notdeployed:";
    private static final String MARK_HASH_MISMATCH = "hash:";
    private static final String MARK_NOT_RUNNING = "notrunning:";

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
    /** 后台任务里置位、主线程回调读取：这次要弹哪种部署请求（{@link #PROMPT_NONE} = 不弹）。 */
    private volatile int pendingPrompt = PROMPT_NONE;
    /** 后台任务里置位、主线程回调读取：自动更新开着且内容不一致 → 静默重新部署（不弹窗）。 */
    private volatile boolean autoDeployPending;
    /**
     * 用户在本页点过「停止daemon」（主线程写、后台探测读）。
     *
     * <p>只用于抑制「守护进程没在跑」那条提示：刚停完马上又被问"要不要拉起来"很烦，
     * 而且看门狗会在下一轮 tick 自己把它拉回来。部署 / 拉起会把这一位清掉。
     */
    private boolean daemonStoppedByUser;
    /** 后台任务里置位、主线程回调读取：本次部署<b>盘面是否已就位</b>（据此决定要不要接着自动拉起）。 */
    private volatile boolean deployPlaced;
    /** 后台任务里置位、主线程回调读取：本次部署整体是否失败（据此清掉一次性标记，允许下次自动重试）。 */
    private volatile boolean deployFailed;
    /** 上次探测的开始时刻（手动与静默共用）；静默刷新据此节流。内存态，进程重启即失效。 */
    private long lastProbeAtMs;
    /** 淡入淡出代号：每次新动画递增，回调里对不上号即作废（连续刷新时两段动画不交叠）。 */
    private int fadeGeneration;
    /**
     * 动作代号：每次起跑自增，收尾复位忙态时对不上号即作废（同 {@link #fadeGeneration} 的手法）。
     *
     * <p>为什么需要：{@code onDestroyView} 会无条件放开占用位，若视图随即重建、期间又起了新动作，
     * 旧动作的收尾回调就会把<b>新动作</b>的忙态清掉（同时守卫短暂失效）。代号一变，旧回调只认
     * 自己那一次，不动别人的忙态。
     */
    private int actionGeneration;

    /**
     * 主线程 Handler：只在「拿不到 Activity」的收尾路径上用（那一刻不能借 Activity 回主线程）。
     * 类加载发生在主线程（Fragment 由外壳在主线程建出来），且 {@code new Handler(Looper)} 本身
     * 可在任意线程调用，故静态持有是安全的。
     */
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

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
     * 探测部署状态；脚本哈希不一致且 su 可用时自动重推脚本（重推会连带重启守护进程），再复探一次。
     *
     * <p>副作用两条：①按最终状态武装部署请求（三种情形见 {@link #armDeployPrompt}）；
     * ②顺手刷新「同步清单」（见 {@link Deployer#writeSyncManifestIfNeeded()}，脚本侧在没有可用
     * 解压工具时的降级来源；APK 没换时只是一次 stat）。两条无论走静默还是手动路径都执行 ——
     * 它们正是"探测才发现的事"，且同一个 APK 版本最多发作一次。
     *
     * @return 可直接上屏的文本
     */
    private String probeAndAutoFixScript(Context app) {
        final Deployer deployer = Deployer.get(app);
        Deployer.Status status = deployer.probe();
        final String head;
        // su 不可用时不尝试（否则每次进页面都白撞一次授权框）
        if (status.suOk && status.scriptPresent && !status.scriptHashOk) {
            // 三选一，判据取自**紧随其后的那次 probe**（更晚、更权威，且不额外增加 su 往返）：
            //   动作失败 → 失败文案；动作成功但探测显示守护进程没在跑 → 第三条文案
            //   （重推本身成功了，说"失败"不实；说"已自动重推脚本"又把"进程没起来"盖掉，同样与事实不符）；
            //   其余 → 成功文案。
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
        return head + (manifestNote == null ? "" : manifestNote + "\n") + status.describe();
    }

    /**
     * 探测确认设备上二进制与 APK 内一致时，把设备侧 md5 落盘 —— 这是「需要重新部署」判定的缓存，
     * 供下次冷启动落页用（见 {@link Deployer#needsRedeploy}）。
     *
     * <p>判据与提示判据互补、互不重叠：一致才记，不一致留给 {@link #armDeployPrompt} 的部署请求；
     * 没部署过（二进制不存在）时探测到的 md5 为空，{@link Deployer#rememberDeployedBinMd5} 会拒写。
     */
    private static void rememberDeployedBinMd5(Context app, Deployer.Status status) {
        if (status.binExists && status.binHashOk) {
            Deployer.rememberDeployedBinMd5(app, status.binMd5);
        }
    }

    /**
     * 部署：直接上屏 {@link Deployer#deploy()} 自己带回的状态——<b>不再补一次 probe</b>：
     * deploy 末尾已经探过一次并把结果放进 {@link Deployer.Result#status}，再探一次就是整整一轮
     * 多余的 su 往返 + 2 份资产 MD5（probe 的开销见 {@code Deployer}）。也不把部署动作日志
     * （含步骤列表）灌进状态区：部署成没成看状态文本就够，步骤细节在「诊断信息」里。
     * 早退失败（{@code status} 为 null）时退回动作描述——那里有失败原因与已走过的步骤。
     *
     * <p><b>随后自动「点」一次拉起daemon</b>（{@link #startDaemon()}）：{@link Deployer#deploy()}
     * 只把新二进制换到盘上，不重启进程它就一直跑旧映像。这一段是<b>独立的一份</b>——自己的忙态文案、
     * 自己的操作记录、自己的一次进度条起停，与手动点「拉起daemon」完全是同一条路径，
     * 不是把部署那一趟拉长。
     *
     * <p><b>接不接这一段的判据是「盘面是否已就位」（{@link Deployer.Result#placementsOk}），
     * 不是「部署是否整体成功」</b>：收尾自检是一次读回，会因 su 往返超时、或与设备侧另一个写者
     * （脚本的自动更新）撞窗而为假，那时盘上其实已经换了新二进制——只按整体成败决定，一次读回失败
     * 就会把旧映像永久留在设备上（旧进程照旧"运行中"，界面也看不出异常），且没有任何补偿。
     * 盘面真没就位时仍<b>不接</b>：那时重启旧映像没有意义。
     *
     * <p><b>部署失败时清掉一次性去重标记</b>（见 {@link #clearPromptMark()}）：不清就等于把
     * "下次进页面自动补上"这条路也一起封死——而失败恰恰是最需要再试一次的时候。
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
     * 清掉「本 APK 版本已经自动装过 / 已经问过」的一次性去重标记（{@link Deployer#KEY_HASH_PROMPTED_MD5}）。
     *
     * <p><b>只在部署失败时调</b>：标记是"这一版已经尝试过"的记录，失败却留着它，等于把"下次进页面
     * 自动补上"这条路也封死了。
     *
     * <p><b>边界（"反复"到哪一步为止）</b>：清一次只换来"下次进页面的一次动作"——部署类情形在自动
     * 更新开着时是静默重装一次、关着时是把确认框再弹一次；失败一次清一次，故一直失败就一直"每进一次
     * 页面动作一次"。不是自转的循环（每次都要用户再进页面，静默刷新另有
     * {@link #PROBE_MIN_INTERVAL_MS} 节流）；收敛条件是"盘面就位且进程在跑"——那时探测不武装任何
     * 请求，自然不再动作（见 {@link #armDeployPrompt}）。
     *
     * <p>读的是已加载过的 prefs（探测阶段读过同一份），写入走 {@code apply()} 异步落盘。
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
     *
     * <p><b>忙态与占用位的收尾只有一处</b>（{@link #finishAction}）：正常上屏、视图已销毁、
     * 以及<b>拿不到 Activity</b> 三条路都要走它——最后那条尤其不能省（那时进度条还在屏上，
     * 早退会把它永久留在"忙"上，此后本页所有动作都被守卫挡下）。
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
                    // 刚拿到授权：状态区已显示"root 可用"，这里只问要不要顺势部署。
                    // 这一支优先于「自动更新」的静默部署 —— 用户刚授权，给他一次明确的确认。
                    // 同一次探测武装的另一条请求就地作废：否则紧随其后的部署回调会把它当成
                    // 这次探测刚发现的再弹一遍（实测路径：首启授权→部署成功→又弹"尚未部署"）。
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
     * 收尾复位：放掉占用位并关掉进度条。<b>只在代号未变时动</b>——期间若已起了新动作
     * （视图销毁重建那条路），忙态归它管，本回调不得越俎代庖（否则会把新动作的进度条关掉、
     * 并让并发守卫短暂失效）。必须在主线程调。
     *
     * <p><b>三条收尾路径都必须走它</b>：正常上屏、视图已销毁、以及拿不到 Activity
     * （见 {@link #runAsync}）。少走一条就会留下"永久忙"——进度条一直转，且此后本页每次点击
     * 都被 {@code actionRunning} 守卫拒绝。
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
     * 判定这次探测要不要弹部署请求（三种情形），或（开关开着时）改为静默重新部署。
     *
     * <p><b>三种情形互斥，按此优先级取一条</b>：
     * <ol>
     *   <li>{@link #PROMPT_HASH_MISMATCH}：二进制在、内容与 APK 内不一致（原有行为）。</li>
     *   <li>{@link #PROMPT_NOT_DEPLOYED}：二进制不在 = 从没部署过。</li>
     *   <li>{@link #PROMPT_NOT_RUNNING}：二进制在且一致，但守护进程没在跑。</li>
     * </ol>
     *
     * <p><b>为什么三种都要 su 可用</b>：su 不通时 {@code probe()} 里 {@code binExists} 必为 false
     * （它来自同一趟 su 往返的输出），不加这一条会让未 root 的设备也弹一次部署请求
     * （去重标记只保证不重复问，第一次仍会弹；且 su 不通时点「一键部署」注定失败）。
     * 首启那次拿 root 的提示另有其路（见 {@link #firstProbe}）。
     * {@code binExpectedMd5} 为空＝APK 内资源缺失，同样无从判定。
     *
     * <p><b>「自动更新」开着时的分工</b>（见 {@link Deployer#isAutoUpdateEnabled}）：
     * 第 1 种属于"设备上的内容旧了"，正是开关的语义 → 不弹，改为在回调里静默重新部署
     * （{@link #autoDeployPending}）。第 2、3 种<b>永远只弹</b>：用户从没同意过部署（或刚主动停过
     * 进程），替他决定不合适；设备端脚本那一侧也是同一分工（从未部署过不自动装）。
     *
     * <p><b>去重</b>：把「情形前缀 + 该情形下的指纹」落盘，同一个值最多提示一次
     * （指纹取 APK 侧 expected md5 或设备侧 bin md5，都随 APK 更新而变 →
     * 装了新 APK 会重新武装；重装同一个 APK 不会重复打扰）。
     * <b>先落标记再动作</b>（同 {@code KEY_ROOT_TRIED}）：弹窗还没显示就已落盘，
     * 中途进程被杀也不会下次再弹。
     * <b>唯一例外</b>：部署失败时调用方会把标记清掉（见 {@link #deploy()} 的收尾与
     * {@link #clearPromptMark()}）——否则一次失败就等于把"自动重部署"这条路也一并停掉。
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
        new AlertDialog.Builder(requireContext())
                .setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(confirmRes, (d, w) -> action.run())
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
