package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.ConfigStore.WriteResult;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 配置表单的共用数据流：配置页（{@link ConfigFormFragment}）与设置页（{@link UiSettingsFragment}）
 * <b>只有这一份实现</b>。两页各自只留自己的壳与自己独有的块（曲线子页 + 诊断折叠体 / 重置栏），
 * 表单侧一律走这里：读快照铺底、建卡建行、把快照应用到已建行、写盘回执、冲刷待写、重置回写、
 * 诊断刷新。
 *
 * <h3>边界（I3）</h3>
 * 只经 {@link ConfigStore} 读写 {@code profile.conf}（不自己解析 assets、不自己写出厂配置），
 * 写盘一律经 {@link ConfigWriteQueue}（防抖语义不变），校验只经 {@link ConfigStore#assess}
 * （在各行的 {@link ConfigKeyRow} 里，本类不插手）。所有文件 I/O 都排在同一个单线程 executor 上，
 * 先后顺序即调用顺序；主线程只做渲染。
 *
 * <h3>加载策略：与预读并行，看得见的部分先出现</h3>
 * 建表单要读 {@code assets/params.json}（45KB）+ {@code profile.conf}，两件事都慢，<b>都放到后台</b>：
 * <ul>
 *   <li>{@link #start()}（{@code onCreate} 调）把「{@code ConfigStore.get} + 首读盘」排上后台线程，
 *       与壳的 inflate / 首帧并行；</li>
 *   <li>读完回主线程建表（见 {@link #buildIfNeeded}）：<b>段一</b>先建各组卡头并把它们的值摆正，
 *       随即让卡片容器露面（默认折叠的页在这里置「就绪」）；<b>段二</b>再建那几十行看不见的键行并上屏
 *       （值、组头开关、徽标、自检、诊断一次对齐），它在"真页面第一帧画完"之后才跑。</li>
 * </ul>
 * 故不存在"半成品"：容器在露面之前一直是 {@link View#GONE}，露面时<b>可见的那部分</b>已经摆好
 * （卡头、组头开关值、卡头徽标）——要么如此，要么（定义没到位）走 {@link Page#showDefinitionError}
 * 如实报错。<b>没有</b>逐组补齐的入口，也没有"可见才建"的门控：行在撤层后一次建满，
 * 展开/收起只切可见性（不在展开时现场 inflate + 测量，见 {@code ConfigGroupBinder#setExpanded}）。
 *
 * <p>视图重建（配置变更 / 进程恢复）时沿用预热那一份快照立刻重建，同时补读一次盘
 * （{@link #attachView}），避免用一份可能已旧的快照。
 */
final class ConfigFormController implements ConfigKeyRow.Host, ConfigWriteQueue.Callback {

    /**
     * 页面独有的部分：控制器只做两页共用的数据流，下面这些是两页真正的差异，各由自己的
     * Fragment 实现（页面把壳建好后把这些交给控制器即可）。
     */
    interface Page {

        @NonNull
        LayoutInflater formInflater();

        /**
         * 分组卡（设置页还有重置栏）的落点。页面负责把它<b>先藏着</b>（配置页由
         * {@code fragment_config.xml} 声明 {@code visibility="gone"}，设置页在自己搭的壳里置
         * {@code GONE}），控制器把<b>可见的那部分</b>摆好之后才露出（见 {@link #buildIfNeeded}）。
         */
        @NonNull
        ViewGroup cardContainer();

        /** 本页是否渲染该分组（配置页：除 {@code webui} 外全部；设置页：只有 {@code webui}）。 */
        boolean rendersGroup(@NonNull GroupMeta group);

        /** 卡头标题（设置页去掉段标编号）。 */
        @NonNull
        String groupTitle(@NonNull GroupMeta group);

        /** 建表时分组默认展开还是折叠。 */
        boolean expandsByDefault();

        /** 是否把没被任何分组列到的键兜底成一张「未分组」卡（配置页要，设置页不要）。 */
        boolean showsUngroupedGroup();

        /** 页面布局里是否有诊断折叠体（只有配置页有）。 */
        boolean hasDiagnostics();

        /** 定义没到位（加载失败，或预热本身抛异常）：用自己的错误位如实说明，不给静默空白。 */
        void showDefinitionError(@NonNull String message);

        /**
         * 建表的"可见后段"（建行那一段）失败：卡片与卡头已经露出来了，如实补一句失败原因
         * （不回退已露出的内容，也绝不静默留在半张表上）。
         */
        void showPartialBuildFailure(@NonNull String message);

        /**
         * 卡与行一次建满、值也已上屏（只来一次）：页面在这里收尾自己那一块
         * （设置页：空态提示与重置栏）。
         *
         * @param groupCount 本次建成的分组卡数（0 = 定义里本页该渲染的组没有可渲染的键）
         */
        void onFormBuilt(int groupCount);

        /** 每次快照上屏：页面在这里刷自己那块随快照变的东西（配置页：键渲染自检）。 */
        void onValuesApplied(@NonNull Snapshot snapshot);

        /** 人话反馈（Snackbar）。 */
        void notifyUser(@NonNull String message, boolean error);
    }

    private final Page page;
    /** 应用上下文：只为拿 {@link ConfigStore} 单例与读文件，故 {@code onCreate} 里就能拿到。 */
    private final Context appContext;
    /**
     * 建表取视图的来源：本页所有控件的唯一取处（预制造优先，取不到现场 inflate，见 {@link ViewSource}）。
     * 设置页传 {@code null} 预制造器 = 全部现场造——它按需打开、不在启动链上，且是另一个 Activity 的上下文。
     */
    private final ViewSource views;
    /** 所有后台 I/O（预热、读盘、写盘）都排在这一个线程上。 */
    private final ExecutorService io = Executors.newSingleThreadExecutor();
    private final Handler main = new Handler(Looper.getMainLooper());

    /** 参数定义单例；预热完成后（主线程回调）才非空，见 {@link #start()}。 */
    private ConfigStore store;
    /** 防抖写队列；与 store 同时就位（队列要持有 store）。 */
    private ConfigWriteQueue queue;
    /** 诊断折叠体（只有配置页有）。 */
    private ConfigDiagnostics diagnostics;

    /** 磁盘上（或最近一次读取时）的值："值未变不写"的判定基准。仅主线程访问。 */
    private final Map<String, Value> diskValues = new LinkedHashMap<>();
    private final List<ConfigGroupBinder> groups = new ArrayList<>();

    /**
     * 建表时一次算定的三件小账（见 {@link #indexBuiltForm()}）：本页各分组的行、键行键数、组头开关数。
     * 行与定义里的键一一对应，建表之后不再变（{@link #detachView()} 才清）。
     *
     * <p>原先这三件都是每次要的时候现算：{@link #rows()} 每次上屏都要遍历各分组并 {@code new} 一个
     * 列表，两个自检分项每次都要 O(键数) 重算 + 每组 {@code new} 一个 {@code ArrayList}。
     */
    private List<ConfigKeyRow> allRows = Collections.emptyList();
    private int builtRowKeyCount;
    private int builtMasterKeyCount;

    /**
     * 建表轮次：每建一轮 +1。段二的异步回调带着自己那一轮的号回来，轮次对不上就整个丢弃
     * （视图已重建 → 那一轮的行与值都不该再往新视图上铺）。
     */
    private int buildRound;
    /** 已经建完行的那一轮（0 = 还没建过）：段二的三条入口靠它幂等（pre-draw、兜底延时、展开页同步）。 */
    private int rowsPhaseRound;
    /** 视图重建时要补读一次盘（见 {@link #attachView}）：行建完之后才起读（见 {@link #buildRowsPhase}）。 */
    private boolean pendingReload;

    /** 页面根视图（建诊断区要用）；视图不在时为 null。 */
    private View pageRoot;
    private boolean viewAlive;

    /** 预热时读到的那一份快照：建表拿它铺底，故行一建起来就是真值。 */
    private Snapshot loadedSnapshot;
    /** 定义没到位的原因（非空 = 预热抛异常，或定义加载失败），界面须如实说明。 */
    private String failureText;
    /** 本次视图的内容已定：表单建满，或已把"定义没到位"如实上屏。 */
    private boolean built;
    /** 曾经定过一次（跨视图重建保持）：视图重建时那份预热快照可能已旧，要补读一次盘。 */
    private boolean everSettled;

    ConfigFormController(@NonNull Page page, @NonNull Context appContext,
                         @Nullable ConfigPreInflater preInflater) {
        this.page = page;
        this.appContext = appContext;
        this.views = new ViewSource(page.formInflater(), preInflater);
    }

    // ==================== 起步：预热与首读 ====================

    /**
     * 起后台预读（{@code onCreate} 调，与壳的 inflate / 首帧并行）：
     * {@code assets/params.json} 的读 + 解析 + 建 KeyMeta，以及首读 {@code profile.conf}
     * 都在后台串行做完，主线程随后一次建满。
     *
     * <p>单例是双检锁的：这里先跑，别处（曲线区的后台线程等）再调就只剩一次 volatile 读。
     * 失败不吞：读/解析失败由 {@link ConfigStore} 记进 loadError（走
     * {@code definitionsLoaded()==false} 的错误串），真正的异常（如 OOM）在这里兜底上报。
     */
    void start() {
        // 快路（就地在主线程取一次）：定义与快照都现成时，read() 走的是它自己的 memo——指纹（mtime+size）
        // 没变就直接返回上次那份快照，不读盘、不解析，成本≈一次 stat（判定线程在起 ~12 已经读过一次，
        // 故 memo 早就是热的）。就地取省掉"新起一根 io 线程 + 一次消息往返"：实测那一趟的调度代价是
        // 35~110ms，而它正是"数据到位 → 撤层 → 段二"整条链的起点（见方案文件 §2）。
        // 此刻视图还没有（本方法由页的 onCreate 调），onLoaded 只做"存字段 + 建写队列"：ensureDiagnostics
        // 与 buildIfNeeded 自己会因视图没建而跳过，建表仍由 attachView 触发，故快路不改变任何时序语义。
        try {
            final ConfigStore loaded = ConfigStore.get(appContext);
            if (loaded.definitionsLoaded()) {
                onLoaded(loaded, loaded.read(), null);
                return;
            }
        } catch (Throwable ignored) {
            // 取不到（或读失败）就落回下面那条后台路，语义与改前逐字一致
        }
        submit(() -> {
            StartupTiming.mark(StartupTiming.MARK_CFG_IO_BEGIN);   // 记账（旁路）：走的不是快路
            try {
                final ConfigStore loaded = ConfigStore.get(appContext);
                final boolean defined = loaded.definitionsLoaded();
                final Snapshot snapshot = defined ? loaded.read() : null;
                // 定义没到位时把诊断串也在后台算出来：它内部还要读一次盘，不能留到主线程上做
                final String failure = defined ? null : loaded.describeState();
                StartupTiming.mark(StartupTiming.MARK_CFG_IO_DONE);   // 记账（旁路）：即将回主线程
                main.post(() -> onLoaded(loaded, snapshot, failure));
            } catch (Throwable t) {
                main.post(() -> onLoadFailed(t));
            }
        });
    }

    /** 定义与首份快照就绪（主线程）：建写队列与诊断区；视图已建就直接建满。 */
    private void onLoaded(@NonNull ConfigStore loaded, @Nullable Snapshot snapshot,
                          @Nullable String failure) {
        if (io.isShutdown()) {
            return;   // 页面已销毁：结果丢弃（单例仍已就位，别的页面直接受益）
        }
        // 记账（旁路）：建表数据到位这一刻（与后面的"建表起点"相减，即"视图与数据谁在等谁"）
        StartupTiming.mark(StartupTiming.MARK_FORM_DATA);
        store = loaded;
        loadedSnapshot = snapshot;
        failureText = failure;
        queue = new ConfigWriteQueue(store, io, main, this);
        ensureDiagnostics();
        buildIfNeeded();
    }

    /** 预热抛异常（主线程）：如实上屏，不停在空表单上。 */
    private void onLoadFailed(@NonNull Throwable t) {
        failureText = "参数定义加载失败：" + t;
        buildIfNeeded();
    }

    /** 诊断区（它要 store 与页面根视图都在，且页面布局里有折叠体）。 */
    private void ensureDiagnostics() {
        if (diagnostics == null && pageRoot != null && store != null && page.hasDiagnostics()) {
            diagnostics = new ConfigDiagnostics(pageRoot, store, io, main);
        }
    }

    // ==================== 建表：卡头先露，行随后 ====================

    /** 段二兜底延时（毫秒）：pre-draw 迟迟不派发时，到点也把行建出来（见 {@link #scheduleRowsPhase}）。 */
    private static final long ROWS_PHASE_FALLBACK_MS = 1500L;

    /**
     * 把本页的表单建出来（预热与首读都回来、视图也在时才做，只做一次）。三条路：
     * 定义没到位 → 如实报错；数据没回来 → 什么都不做，等 {@link #onLoaded}；都齐了 → 建表。
     *
     * <p><b>建表分成两段</b>，分界点就是"用户看得见的部分"：
     * <ul>
     *   <li><b>段一</b>：各分组的<b>卡头</b>（标题、总开关、徽标、箭头）+ 组头开关值与卡头徽标。
     *       配置页默认全部折叠，此时用户能看到的每一样东西都已就位——故这一段末尾就把参数区露出来、
     *       置「就绪」。</li>
     *   <li><b>段二</b>：各行与全部字段 + 值上屏 + 自检 + 诊断（见 {@link #buildRowsPhase}）。
     *       这一段在"真页面第一帧画完"之后才跑（见 {@link #scheduleRowsPhase}）：用户等的是"看得见的
     *       界面"，而不是那几十行还折叠着的输入框，
     *       总工作量并没有减少，只是把它挪到了用户看不见的时候。</li>
     * </ul>
     *
     * <p><b>默认展开的页面不分段</b>（设置页只有一组且默认展开）：折叠体可见时先露卡头会露出一张
     * 空卡，那就成了"半张表"，故它的两段在同一趟里连着跑完再露出。<b>终点状态与改前一致</b>，过程有
     * 三处可指的差别（都幂等，不影响终态）：多跑一趟 {@link #applyHeaderValues}；
     * {@link #applySnapshot} 改取 {@link #effectiveValue}（首次建表时待写队列为空，与取快照等价）；
     * 补读盘（{@link #pendingReload}）从"紧随建表"挪到"段二收尾"。
     *
     * <p>不管哪条路，"行建完"与"值上屏"都是相邻两步（中间不插别的活）：建行时不各自铺值，
     * 值、徽标、压暗全由 {@link #applySnapshot} 一次铺满（见 {@link ConfigGroupBinder#buildRows}）。
     */
    private void buildIfNeeded() {
        if (built || !viewAlive) {
            return;   // 视图还没建：attachView 里补建
        }
        if (failureText != null) {
            // 预热抛异常 / 定义没加载成功：视图建好后第一件事就是如实说明（不留空表单）
            built = true;
            everSettled = true;
            page.showDefinitionError(failureText);
            if (diagnostics != null) {
                diagnostics.refresh();
            }
            reloadIfPending();   // 这条路上没有段二，视图重建那次补读在这里补上（改前是无条件补读）
            return;
        }
        if (store == null || loadedSnapshot == null) {
            return;   // 预热与首读还没回来
        }
        built = true;
        everSettled = true;
        // 记账（旁路）：建表这一段（首屏段 + 可见后段两笔），外加段内六个细分槽的累计
        // （见 StartupTiming 的 acc* 一族）
        long startedAt = StartupTiming.now();
        StartupTiming.accReset();
        ConfigKeyRow.resetHintStyle();   // 说明字号/字距的一轮缓存同样从零开始
        buildForm(loadedSnapshot);       // 段一：各分组卡头（可见结构）
        applyHeaderValues(loadedSnapshot);   // 组头开关值 + 卡头徽标（折叠态下看得见的两样值）
        // 本轮建表轮次：段二的异步回调带着它回来，对不上就整个丢弃（视图已重建）
        final int round = ++buildRound;
        if (page.expandsByDefault()) {
            // 默认展开的页（设置页）：折叠体可见，先露卡头会露出空卡 → 两段连着跑完再露
            StartupTiming.span(StartupTiming.FORM_BUILD_HEAD, startedAt);
            buildRowsPhase(round, loadedSnapshot);
            revealBuiltForm();
            return;
        }
        // 默认折叠的页（配置页）：可见的只有卡头，先把可见结构露出来并置「就绪」，
        // 看不见的行留到下一段（本趟 traversal 的 pre-draw 之后，见 scheduleRowsPhase）再建
        revealBuiltForm();
        StartupTiming.span(StartupTiming.FORM_BUILD_HEAD, startedAt);
        scheduleRowsPhase(round, loadedSnapshot);
    }

    /**
     * 段一的上屏：此时可见的只有卡头与组头开关，先把它们的值摆正（行、自检、诊断都留到段二）。
     *
     * <p>卡头徽标必须在这里算出来：折叠态下它是"本组有键未生效"的唯一提示，而那时刻行还不存在
     * （判据与行内压暗同源，见 {@link ConfigGroupBinder#refreshHeaderBadge}）。
     *
     * <p>顺序上它必须早于 {@link #revealBuiltForm()}：参数区一露出来，上面这些值就得已经是最终值，
     * 否则用户会看到"先空一下再跳成真值"。
     */
    private void applyHeaderValues(@NonNull Snapshot snapshot) {
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(snapshot.get(masterKey));
            }
            group.refreshHeaderBadge();
        }
    }

    /** 参数区露面并置「就绪」：容器可见 + 页面收尾（设置页在这里追加它的重置栏）+ 记账。 */
    private void revealBuiltForm() {
        page.onFormBuilt(groups.size());
        page.cardContainer().setVisibility(View.VISIBLE);   // 都摆好了才露：不出现半成品
        markAfterBuildFrame();
    }

    /**
     * 段二的起跑线：参数区根部的一次性 pre-draw（另配一条一次性的兜底延时，见下）。
     *
     * <p><b>为什么等这一趟 pre-draw</b>：段二是一段一两百毫秒<b>不中断</b>的主线程消息，它必须在
     * "真页面第一帧画完"之后才开跑——否则它会把那一帧整段推后，用户从（还没建好的）白页切到真界面的
     * 那一刻跟着晚。这条闸门<b>不能</b>改成"段一末尾直接 post"：在"段一落在首趟 traversal 之后"的形状里
     * （真机出现过：数据 267 那一轮），直接 post 会让首见时刻最晚推后一个段二（实测 115~245ms）。
     *
     * <p><b>为什么是队首投递而不是普通 post</b>：pre-draw 在 measure/layout 之后、绘制之前派发，
     * 这一趟画完就轮到队列里的消息；而普通 post 排在队<b>尾</b>——实测"本趟 pre-draw"到"段二真起跑"
     * 之间白等 <b>38~48ms</b>（排在它前面的是曲线子页的异步事务、曲线首次上数据，谁先谁后纯看运气）。
     * 段二要等的只有"这一帧画完"，故插到<b>队首</b>：本趟一结束就起跑，不早（不吃首帧）、不晚（不吃排队）。
     *
     * <p>（更早以前这里写的是"撤层那条监听器注册得更早、所以撤层那一帧会先到"：那条依据先随
     * "撤骨架改为就绪即撤"作废，骨架整套又于 2026-09-26 删除；闸门保留的理由是上面第一条。）
     *
     * <p><b>兜底那一次延时</b>：pre-draw 只在窗口绘制时派发。万一这一段窗口压根不绘制（极端情况），
     * 只挂 pre-draw 就会一直等不到。故另挂一次性延时（不轮询、不重试、跑过即废），到点也把行建出来。
     * 这与"不许等用户展开才建"是同一件事的两面：行必须在某个不依赖用户动作的时机建完，
     * 用户展开某组时它应当已经在了（展开只切可见性，从不现场建控件）。
     */
    private void scheduleRowsPhase(int round, @NonNull Snapshot snapshot) {
        final View anchor = page.cardContainer();
        final ViewTreeObserver observer = anchor.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (observer.isAlive()) {
                    observer.removeOnPreDrawListener(this);
                }
                // 队首投递（见方法注释）：取不到 Handler（视图未 attach）就退回普通 post，与改前一致
                Handler handler = anchor.getHandler();
                if (handler != null) {
                    handler.postAtFrontOfQueue(() -> buildRowsPhase(round, snapshot));
                } else {
                    anchor.post(() -> buildRowsPhase(round, snapshot));
                }
                return true;
            }
        });
        anchor.postDelayed(() -> buildRowsPhase(round, snapshot), ROWS_PHASE_FALLBACK_MS);
    }

    /**
     * 段二：建各行与全部字段，随后把值、组头开关、徽标、自检、诊断一次上屏。
     *
     * <p><b>幂等且只认自己那一轮</b>：同一个轮次只跑一次（{@link #rowsPhaseRound}），轮次对不上、
     * 视图已销毁或内容还没定（{@link #viewAlive} / {@link #built}）都整个丢弃——它可能由 pre-draw
     * 或兜底延时触发，两条路都可能晚到。
     *
     * <p><b>失败不回退已经露出的卡头</b>：如实说明"行没建全"（给一句人话，不把原始异常铺给用户），
     * 留着半张表也比整块不露更接近用户预期（改前这里是"整块不露"：异常会从建表一路抛出去）。
     */
    private void buildRowsPhase(int round, @NonNull Snapshot snapshot) {
        if (round != buildRound || round == rowsPhaseRound || !viewAlive || !built) {
            return;
        }
        rowsPhaseRound = round;
        // 记账（旁路）：段二开跑这一刻池子里已经取走了多少件 ⇒ 与"未命中"一起判
        // "段二起跑前就缺（结构性）"还是"段二期间没赶上（竞态）"（判读见方案 §3.2）
        StartupTiming.markCount(StartupTiming.POOL_AT_ROWS_BEGIN, StartupTiming.PRE_HIT);
        long startedAt = StartupTiming.now();
        try {
            for (ConfigGroupBinder group : groups) {
                group.buildRows();
            }
            indexBuiltForm();   // 行与自检分项一次算定（紧随其后的自检与上屏都要用）
            // 值、组头开关、徽标、自检、诊断一次对齐（其中"徽标 / 自检 / 诊断提交"三项各自计时，
            // 见 applySnapshot：拆分只为看清诊断自身占多少，口径见 StartupTiming 的 FORM_SUB_*）
            applySnapshot(snapshot);
        } catch (Throwable ignored) {
            // 用应用上下文取文案：失败路径上不该再去碰页面视图（万一异常正是视图侧抛的）。
            // 文案里不带原始异常（那会把类名与英文 message 铺给用户）；要排查就顺着"行没建全"这个
            // 现象去看建表链路上的改动，界面这边只给一句人话
            page.showPartialBuildFailure(appContext.getString(R.string.config_build_failed));
        }
        // 记账（旁路）：收尾这一刻的同一读数（正常应等于"命中"总数，见方案 §3.2 的判读表）
        StartupTiming.markCount(StartupTiming.POOL_AT_ROWS_END, StartupTiming.PRE_HIT);
        StartupTiming.span(StartupTiming.FORM_BUILD_ROWS, startedAt);
        StartupTiming.accFlush();
        views.release();   // 预制造件已用完：丢掉剩余件（见 ViewSource#release）
        reloadIfPending();
    }

    /**
     * 视图重建要补读一次盘（见 {@link #attachView}）：正常路在段二收尾起读（建表用的那份预热快照可能
     * 已旧，早读回来的新值会被那一趟建表整片盖掉）；定义没到位那条路没有段二，在 {@link #buildIfNeeded}
     * 的错误分支里补上。改前这里是 {@code attachView} 里的一句无条件补读，故两条路都必须补。
     */
    private void reloadIfPending() {
        if (pendingReload) {
            pendingReload = false;
            reloadAsync();
        }
    }

    /**
     * 记账（旁路）：建表结束后的第一次 pre-draw（一次性回调，记完即摘）。
     *
     * <p>用来切"撤占位层"之前那一小段：它与建表结束之间隔着一次 vsync 与一轮 measure/layout。
     * 挂在卡片容器上——它正是建表刚填满的那棵树。回调体里只有一次静态 mark 与一次摘除，无 IO、无锁。
     */
    private void markAfterBuildFrame() {
        final View anchor = page.cardContainer();
        final ViewTreeObserver observer = anchor.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                StartupTiming.mark(StartupTiming.MARK_AFTER_BUILD_FRAME);
                if (observer.isAlive()) {
                    observer.removeOnPreDrawListener(this);
                }
                return true;
            }
        });
    }

    /**
     * 建表<b>段一</b>：本页该渲染的分组各建一张卡（<b>只有卡头</b>，行由 {@link #buildRowsPhase} 补）。
     * 值不在这里铺：可见的两样（组头开关、卡头徽标）由 {@link #applyHeaderValues} 摆正，
     * 行与字段的值由 {@link #applySnapshot} 一次铺满。
     *
     * <p>{@link #diskValues} 在下面按快照铺底：卡头徽标判据、以及随后的用户交互（值未变不写）
     * 都以它为准。
     */
    private void buildForm(@NonNull Snapshot snapshot) {
        groups.clear();
        final ViewGroup container = page.cardContainer();
        // 快照为准铺底：read() 已把文件里缺失的键补成定义默认值，故每个定义键都有值
        diskValues.clear();
        diskValues.putAll(snapshot.values);

        Set<String> covered = new LinkedHashSet<>();
        for (GroupMeta group : store.groups()) {
            if (!page.rendersGroup(group)) {
                // 不归本页渲染的组：键仍要记进 covered，否则下面的"未分组兜底"会把它们当孤儿键又列一遍
                covered.addAll(group.keys);
                if (group.master != null) {
                    covered.add(group.master);
                }
                continue;
            }
            List<KeyMeta> keyMetas = new ArrayList<>();
            for (String key : group.keys) {
                KeyMeta meta = store.key(key);
                if (meta != null) {
                    keyMetas.add(meta);
                    covered.add(key);
                }
            }
            KeyMeta master = group.master == null ? null : store.key(group.master);
            if (master != null) {
                covered.add(master.key);
            }
            addGroup(container, page.groupTitle(group), master, keyMetas);
        }

        if (page.showsUngroupedGroup()) {
            // 兜底：params.json 里没被任何分组列到的键也要能编辑（否则界面比定义少键还看不出来）
            List<KeyMeta> orphans = new ArrayList<>();
            for (KeyMeta meta : store.keys()) {
                if (!covered.contains(meta.key)) {
                    orphans.add(meta);
                }
            }
            if (!orphans.isEmpty()) {
                addGroup(container,
                        container.getContext().getString(R.string.config_group_ungrouped),
                        null, orphans);
            }
        }
    }

    /**
     * 加一张分组卡。既没有键行、也没有组头开关的组不建卡：一张空卡没有任何可编辑入口，
     * 摆出来只是噪音（设置页的定义里没有本组时即走这条路，由
     * {@link Page#onFormBuilt} 给空态提示）。
     */
    private void addGroup(@NonNull ViewGroup container, @NonNull String title,
                          @Nullable KeyMeta master, @NonNull List<KeyMeta> keyMetas) {
        if (keyMetas.isEmpty() && master == null) {
            return;
        }
        ConfigGroupBinder binder = ConfigGroupBinder.create(container, title, master,
                keyMetas, this, views);
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_ATTACH);
        container.addView(binder.card());
        StartupTiming.accEnd(StartupTiming.FORM_SUB_ATTACH, startedAt);
        groups.add(binder);
        binder.setExpanded(page.expandsByDefault());
    }

    /**
     * 建表收尾的一次算定：本页的行与两个自检分项（见 {@link #allRows} / {@link #builtRowKeyCount}）。
     *
     * <p>这三件原先都是"每次要的时候现算"：{@link #rows()} 每次上屏都要遍历各分组再 {@code new} 一个
     * 列表，两个自检分项每次都要 O(键数) 重算、每组还要 {@code new} 一个 {@code ArrayList}。
     * 行与定义里的键一一对应，建完就不变，故算一次存着。
     */
    private void indexBuiltForm() {
        List<ConfigKeyRow> all = new ArrayList<>();
        int rowKeys = 0;
        int masterKeys = 0;
        for (ConfigGroupBinder group : groups) {
            all.addAll(group.rows());
            rowKeys += group.rowKeys().size();
            if (group.masterKey() != null) {
                masterKeys++;
            }
        }
        allRows = Collections.unmodifiableList(all);
        builtRowKeyCount = rowKeys;
        builtMasterKeyCount = masterKeys;
    }

    /** 本页键行的键数（各分组整组的键，含「未分组」兜底组）：键渲染自检的分项之一，建表时算定。 */
    int rowKeyCount() {
        return builtRowKeyCount;
    }

    /** 本页组头开关数：键渲染自检的分项之一，建表时算定。 */
    int masterKeyCount() {
        return builtMasterKeyCount;
    }

    /** 本页各分组的键行（不懒建后即整组的行；建表时算定的那一份，见 {@link #indexBuiltForm()}）。 */
    @NonNull
    private List<ConfigKeyRow> rows() {
        return allRows;
    }

    private void refreshBadges() {
        for (ConfigGroupBinder group : groups) {
            group.refreshBadges();
        }
    }

    // ==================== 读盘 ====================

    /**
     * 重读盘（切页回到本页、视图重建后）：读完在主线程序上屏。定义没到位时只刷诊断
     * （没有键行，刷值无从谈起）。
     */
    void reloadAsync() {
        if (!viewAlive || store == null || !built || io.isShutdown()) {
            return;   // 视图不在、内容没定或定义还没到位：此刻读了也没处上屏
        }
        if (!store.definitionsLoaded()) {
            if (diagnostics != null) {
                diagnostics.refresh();
            }
            return;
        }
        submit(() -> {
            final Snapshot snapshot = store.read();
            main.post(() -> {
                if (viewAlive && built) {
                    applySnapshot(snapshot);
                }
            });
        });
    }

    /**
     * 一份快照上屏：值、组头开关、徽标都对齐后，交给页面（自检）与诊断区。
     *
     * <p>写进控件的值取<b>当前有效值</b>（{@link ConfigKeyRow.Host#effectiveValue}：待写项优先、
     * 否则磁盘值）而不是快照本身：快照可能比用户刚做的改动旧，直接铺快照会把用户眼前的改动悄悄顶回去。
     * 这在段二那条路上尤其要守——参数区露面与行建好之间隔着约三百毫秒，用户完全可能在这段时间里
     * 拨过组头开关，而那一下改动此时还在待写队列里（磁盘值还没变）。
     * 待写项本身也是"已经过校验的最终值"（见 {@link ConfigWriteQueue}），故不存在铺进非法值的问题。
     */
    private void applySnapshot(@NonNull Snapshot snapshot) {
        diskValues.clear();
        diskValues.putAll(snapshot.values);
        for (ConfigKeyRow row : rows()) {
            row.applyValue(effectiveValue(row.key()));
        }
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(effectiveValue(masterKey));
            }
        }
        // 记账（旁路）：下面三件原先合成一个"自检对齐"槽，拆开才看得清诊断自身占多少（见方案 §3）
        long badgeAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_BADGE);
        refreshBadges();
        StartupTiming.accEnd(StartupTiming.FORM_SUB_BADGE, badgeAt);
        long selfCheckAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_SELFCHECK);
        page.onValuesApplied(snapshot);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_SELFCHECK, selfCheckAt);
        if (diagnostics != null) {
            // 复用刚读到的快照：诊断串里的"未定义键/提示"与 mtime 同源，不再多读一次 profile.conf
            long diagAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_DIAG_SUBMIT);
            diagnostics.refresh(snapshot);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_DIAG_SUBMIT, diagAt);
        }
    }

    private void submit(@NonNull Runnable task) {
        if (io.isShutdown()) {
            return;
        }
        try {
            io.execute(task);
        } catch (RejectedExecutionException ignored) {
            // 页面已销毁，等待中的读盘任务直接丢弃
        }
    }

    // ==================== 写盘结果 ====================

    @Override
    public void onWriteResult(@NonNull WriteResult result, @NonNull Map<String, Value> written) {
        if (!viewAlive) {
            return;
        }
        if (result.ok) {
            diskValues.putAll(written);
        }
        final String message = messageFor(result, written.keySet());
        for (ConfigKeyRow row : rows()) {
            if (written.containsKey(row.key())) {
                row.setResultStatus(message, result.ok);
            }
        }
        if (!result.ok) {
            page.notifyUser(message, true);   // 成功不必弹：值已经在控件里了
        }
        refreshBadges();
        if (diagnostics != null) {
            diagnostics.refresh();
        }
    }

    /** 写盘结果的人话文案：「键名、键名：结果」。 */
    @NonNull
    private String messageFor(@NonNull WriteResult result, @NonNull Set<String> keys) {
        List<String> labels = new ArrayList<>();
        for (String key : keys) {
            KeyMeta meta = store.key(key);
            labels.add(meta == null ? key : meta.label);
        }
        return TextUtils.join("、", labels) + "：" + result.describe();
    }

    // ==================== 重置回写（设置页的重置栏） ====================

    /**
     * 用户已确认重置某组：先冲刷待写队列，再按出厂值一次原子写盘。
     *
     * <p><b>为什么必须先冲刷</b>：待写队列里若还压着同一页的改动，稍后它自己的冲刷会把重置值
     * 覆盖回旧值——C 端 {@code st_mtime} 只有秒级精度，补写一次也未必触发重载（见
     * {@link ConfigWriteQueue}）。冲刷与重置都排在本控制器同一个单线程 executor 上，
     * 先冲刷后重置的顺序由它保证，不需要额外同步。
     *
     * <p>重置值走 {@link ConfigStore#setAll}：整组合成一次 rename；逐键 {@code set()} 会多次
     * 触碰 mtime，可能换来一轮"部分生效"的重载。
     */
    void resetGroup(@NonNull String label, @NonNull Map<String, Value> factoryValues) {
        if (!viewAlive || io.isShutdown()) {
            return;
        }
        flush();
        io.execute(() -> {
            final WriteResult result = store.setAll(factoryValues);
            main.post(() -> {
                if (viewAlive) {
                    applyReset(label, factoryValues, result);
                }
            });
        });
    }

    /**
     * 重置结果落地（主线程）：把本页那些属于该组的键重刷成出厂值，并给出反馈。
     *
     * <p>不属于本页的键一个都匹配不上——这是对的：别的组的键不在本页显示，其显示是否陈旧
     * 由配置页自己重读时解决（它每次可见都重读）。
     *
     * <p>成功不必逐行标状态：控件里的值本身已经变了，同一句贴在每一行上是噪音；
     * 失败要留在行上（Snackbar 一闪而过）。
     */
    private void applyReset(@NonNull String label, @NonNull Map<String, Value> factoryValues,
                            @NonNull WriteResult result) {
        if (result.ok) {
            for (ConfigKeyRow row : rows()) {
                Value value = factoryValues.get(row.key());
                if (value != null) {
                    diskValues.put(row.key(), value);
                    row.applyValue(value);
                }
            }
            refreshBadges();
        }
        final Context context = page.cardContainer().getContext();
        final String message = result.ok
                ? (result.changed
                        ? context.getString(R.string.config_reset_done, label)
                        : context.getString(R.string.config_reset_no_change, label))
                : context.getString(R.string.config_reset_failed, label, result.error);
        if (!result.ok) {
            for (ConfigKeyRow row : rows()) {
                if (factoryValues.containsKey(row.key())) {
                    row.setResultStatus(message, false);
                }
            }
        }
        page.notifyUser(message, !result.ok);
    }

    // ==================== 视图与生命周期 ====================

    /**
     * 页面视图已建（{@code onCreateView} 调）：接管诊断区，并在预热已回来的情况下立刻建出来。
     * 页面壳自己先藏着卡片容器（见 {@link Page#cardContainer()}），本类只在摆好之后露出。
     *
     * <p>视图重建（配置变更 / 进程恢复）时那份预热快照可能已旧，要补读一次盘（{@code rebuild}）——
     * 补读<b>等行建完之后再起</b>（{@link #pendingReload}）：建表用的还是那份旧快照，先读回来的新值
     * 会被随后那一趟建表整片盖掉（建表最后一步就是上屏）。
     */
    void attachView(@NonNull View root) {
        pageRoot = root;
        viewAlive = true;
        ensureDiagnostics();
        pendingReload = everSettled;   // 先取：本次是"再来一遍"还是头一次
        buildIfNeeded();
    }

    /** 页面视图销毁（{@code onDestroyView} 调）：冲刷待写、释放诊断区；下次视图重建再建满。 */
    void detachView() {
        viewAlive = false;
        if (queue != null) {
            queue.flushNow();
            queue.detach();
        }
        if (diagnostics != null) {
            diagnostics.release();
            diagnostics = null;
        }
        groups.clear();
        allRows = Collections.emptyList();   // 与 groups 同寿：行随视图一起没了
        builtRowKeyCount = 0;
        builtMasterKeyCount = 0;
        built = false;
        pageRoot = null;
    }

    /** 页面销毁（{@code onDestroy} 调）：冲刷待写、丢掉预制造剩余件并关掉后台线程。 */
    void shutdown() {
        flush();
        views.release();   // 视图没了，预制造件也不会再有人取（否则那些件会把 Activity 钉在池子里）
        io.shutdown();
    }

    /** 冲刷待写队列（定义还没到位时队列尚未建，无待写项可冲）。 */
    void flush() {
        if (queue != null) {
            queue.flushNow();
        }
    }

    /**
     * 外壳的页面可见性广播（{@link com.example.waspwingtempctrl.PageAware} 的落点）：
     * 回到本页重读盘（配置可能被 C 端或部署流程改过），离开本页冲刷待写
     * （切页不派发 {@code onPause}，不主动冲刷就会把改动留在内存里）。
     */
    void setPageVisible(boolean visible) {
        if (visible) {
            reloadAsync();
        } else {
            flush();
        }
    }

    // ==================== ConfigKeyRow.Host ====================
    // store/queue 在"定义就绪"（onLoaded）时一起就位，而键行只在定义就绪且首读回来后建
    // （buildIfNeeded 的前置条件），故下面两个 getter 被调用时必非 null。

    @NonNull
    @Override
    public ConfigStore store() {
        return store;
    }

    @NonNull
    @Override
    public ConfigWriteQueue queue() {
        return queue;
    }

    @Nullable
    @Override
    public Value diskValue(String key) {
        return diskValues.get(key);
    }

    @Nullable
    @Override
    public Value effectiveValue(String key) {
        Value pending = queue.pendingValue(key);
        return pending != null ? pending : diskValues.get(key);
    }

    @Override
    public void onPendingChange() {
        refreshBadges();
    }

    @Override
    public void notifyUser(@NonNull String message, boolean error) {
        page.notifyUser(message, error);
    }
}
