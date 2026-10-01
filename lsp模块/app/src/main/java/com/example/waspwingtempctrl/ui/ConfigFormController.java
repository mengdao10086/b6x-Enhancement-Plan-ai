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
 * <b>只有这一份实现</b>（读快照铺底、建卡建行、上屏、写盘回执、冲刷待写、重置回写、诊断刷新）。
 * 两页各自只留自己的壳与自己独有的块，见 {@link Page}。
 *
 * <p><b>边界（I3）</b>：只经 {@link ConfigStore} 读写 {@code profile.conf}，写盘一律经
 * {@link ConfigWriteQueue}（防抖语义见 app 逻辑说明.md §3.2），校验只经 {@link ConfigStore#assess}。
 * 所有文件 I/O 都排在同一个单线程 executor 上，先后顺序即调用顺序；主线程只做渲染。
 *
 * <p>加载与建表两段（段一卡头先露面、段二行随后）、露面闸门、视图重建补读的口径见
 * app 逻辑说明.md §5.2。
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
     * 行与定义里的键一一对应，建表之后不再变（{@link #detachView()} 才清）。原先这三件都是每次现算。
     * 见 app 逻辑说明.md §6.1。
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
     * 起后台预读（{@code onCreate} 调，与壳的 inflate / 首帧并行）：{@code assets/params.json} 的读 +
     * 解析 + 建 KeyMeta，以及首读 {@code profile.conf} 都在后台串行做完，主线程随后一次建满。
     * 失败不吞：读/解析失败由 {@link ConfigStore} 记进 loadError，真正的异常（如 OOM）在这里兜底上报。
     * 见 app 逻辑说明.md §5.2。
     */
    void start() {
        // 快路（就地在主线程取一次）：定义与快照都现成时 read() 走 memo，成本≈一次 stat。就地取省掉
        // "新起一根 io 线程 + 一次消息往返"（实测那一趟 35~110ms），它正是"数据到位 → 露面 → 段二"整条链的起点。
        // 此刻视图还没有，onLoaded 只做"存字段 + 建写队列"，建表仍由 attachView 触发，故快路不改变时序语义。
        try {
            final ConfigStore loaded = ConfigStore.get(appContext);
            if (loaded.definitionsLoaded()) {
                onLoaded(loaded, loaded.read(), null);
                return;
            }
        } catch (Throwable ignored) {
            // 取不到（或读失败）就落回下面那条后台路
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
     * 把本页的表单建出来（预热与首读都回来、视图也在时才做，只做一次）。三条路：定义没到位 → 如实报错；
     * 数据没回来 → 等 {@link #onLoaded}；都齐了 → 建表。<b>建表分两段</b>（段一卡头先露面、段二行随后）
     * 与"默认展开的页不分段"的口径见 app 逻辑说明.md §5.2。
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
            reloadIfPending();   // 这条路上没有段二，视图重建那次补读在这里补上
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
     * 段一的上屏：先把组头开关值与卡头徽标摆正（行、自检、诊断都留到段二）。徽标必须在这里算出
     * （折叠态下它是"本组有键未生效"的唯一提示，那时行还不存在）；顺序上必须早于
     * {@link #revealBuiltForm()}，否则用户会看到"先空一下再跳成真值"。见 app 逻辑说明.md §5.2。
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
     * 段二的起跑线：参数区根部的一次性 pre-draw（另配一条一次性的兜底延时）。
     *
     * <p><b>为什么等这一趟 pre-draw</b>：段二是一段一两百毫秒<b>不中断</b>的主线程消息，必须在"真页面
     * 第一帧画完"之后才开跑，否则它会把那一帧整段推后。<b>为什么是队首投递而不是普通 post</b>：pre-draw
     * 在 measure/layout 之后、绘制之前派发，本趟画完就轮到队列；普通 post 排在队尾，实测白等 38~48ms。
     * 口径见 app 逻辑说明.md §5.2。
     *
     * <p><b>兜底那一次延时</b>：pre-draw 只在窗口绘制时派发，万一这段窗口压根不绘制就等不到，故另挂
     * 一次性延时（不轮询、不重试、跑过即废），到点也把行建出来。
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
                // 队首投递（见方法注释）：取不到 Handler（视图未 attach）就退回普通 post
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
     * <p><b>幂等且只认自己那一轮</b>：轮次对不上、视图已销毁或内容还没定都整个丢弃（可能由 pre-draw
     * 或兜底延时触发，两条路都可能晚到）。<b>失败不回退已经露出的卡头</b>：如实说明"行没建全"，
     * 留着半张表也比整块不露更接近用户预期。见 app 逻辑说明.md §5.2。
     */
    private void buildRowsPhase(int round, @NonNull Snapshot snapshot) {
        if (round != buildRound || round == rowsPhaseRound || !viewAlive || !built) {
            return;
        }
        rowsPhaseRound = round;
        // 记账（旁路）：段二开跑这一刻池子里已经取走了多少件 ⇒ 与"未命中"一起判"结构性缺"还是"竞态"
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
            // 用应用上下文取文案：失败路径上不该再去碰页面视图；文案里不带原始异常（不把类名与英文播给用户）
            page.showPartialBuildFailure(appContext.getString(R.string.config_build_failed));
        }
        // 记账（旁路）：收尾这一刻的同一读数（正常应等于"命中"总数）
        StartupTiming.markCount(StartupTiming.POOL_AT_ROWS_END, StartupTiming.PRE_HIT);
        StartupTiming.span(StartupTiming.FORM_BUILD_ROWS, startedAt);
        StartupTiming.accFlush();
        views.release();   // 预制造件已用完：丢掉剩余件（见 ViewSource#release）
        reloadIfPending();
    }

    /**
     * 视图重建要补读一次盘（见 {@link #attachView}）：正常路在段二收尾起读（建表用的那份预热快照可能
     * 已旧，早读回来的新值会被那一趟建表整片盖掉）；定义没到位那条路没有段二，在 {@link #buildIfNeeded}
     * 的错误分支里补上。
     */
    private void reloadIfPending() {
        if (pendingReload) {
            pendingReload = false;
            reloadAsync();
        }
    }

    /**
     * 记账（旁路）：建表结束后的第一次 pre-draw（一次性回调，记完即摘），用来切"建表结束 → 首帧画完"
     * 那一小段（两者之间隔着一次 vsync 与一轮 measure/layout）。挂在卡片容器上——它正是建表刚填满的那棵树。
     * 见 app 逻辑说明.md §5.3。
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
     * 值不在这里铺（可见的两样由 {@link #applyHeaderValues} 摆正，行与字段的值由 {@link #applySnapshot}
     * 一次铺满）；{@link #diskValues} 在下面按快照铺底。
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
     * 建表收尾的一次算定：本页的行与两个自检分项（见 {@link #allRows}）。行与定义里的键一一对应，
     * 建完就不变，故算一次存着（原先都是每次现算）。见 app 逻辑说明.md §6.1。
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
     * <p>写进控件的值取<b>当前有效值</b>（{@link ConfigKeyRow.Host#effectiveValue}：待写项优先、否则磁盘值）
     * 而不是快照本身：快照可能比用户刚做的改动旧，直接铺会把用户眼前的改动悄悄顶回去。见 app 逻辑说明.md §6.1。
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
        // 记账（旁路）：下面三件原先合成一个"自检对齐"槽，拆开才看得清诊断自身占多少
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
        // 只在失败时出声：成功时值已经在控件里，绿色「已写入（替换 N 行…）」是噪音
        if (!result.ok) {
            final String message = messageFor(result, written.keySet());
            for (ConfigKeyRow row : rows()) {
                if (written.containsKey(row.key())) {
                    row.setErrorStatus(message);
                }
            }
            page.notifyUser(message, true);
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
     * 用户已确认重置某组：先冲刷待写队列，再按出厂值一次原子写盘（{@code setAll} 合成一次 rename）。
     * <b>为什么必须先冲刷</b>与为什么用 {@code setAll}，见 app 逻辑说明.md §6.3。
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
     * 重置结果落地（主线程）：把本页属于该组的键重刷成出厂值并给反馈。不属于本页的键匹配不上是对的
     * （其显示是否陈旧由配置页自己重读解决）。成功不必逐行标状态（值本身已变，同一句贴每行是噪音）；
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
                    row.setErrorStatus(message);
                }
            }
        }
        page.notifyUser(message, !result.ok);
    }

    // ==================== 视图与生命周期 ====================

    /**
     * 页面视图已建（{@code onCreateView} 调）：接管诊断区，预热已回来就立刻建出来。视图重建时那份预热
     * 快照可能已旧，要补读一次盘（{@link #pendingReload}），补读等行建完之后再起。见 app 逻辑说明.md §5.2。
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
     * 外壳的页面可见性广播（{@link com.example.waspwingtempctrl.PageAware} 的落点）：回到本页重读盘，
     * 离开本页冲刷待写（切页不派发 {@code onPause}，不主动冲刷就会把改动留在内存里）。见 §9.1。
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
