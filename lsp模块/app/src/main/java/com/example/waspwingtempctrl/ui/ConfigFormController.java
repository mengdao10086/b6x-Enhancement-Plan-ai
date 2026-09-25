package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * <h3>加载策略：与预读并行，建完才出现</h3>
 * 建表单要读 {@code assets/params.json}（45KB）+ {@code profile.conf}，两件事都慢，<b>都放到后台</b>：
 * <ul>
 *   <li>{@link #start()}（{@code onCreate} 调）把「{@code ConfigStore.get} + 首读盘」排上后台线程，
 *       与壳的 inflate / 首帧并行；</li>
 *   <li>读完回主线程<b>一次建满</b>（{@link #buildForm}：卡与键行一起，{@link ConfigGroupBinder}
 *       已不懒建），随即把快照上屏（值、组头开关、徽标、自检、诊断一次对齐），<b>最后才让卡片容器露面</b>。</li>
 * </ul>
 * 故不存在"半成品"：容器在露面之前一直是 {@link View#GONE}——要么整块参数区建好摆出来，
 * 要么（定义没到位）走 {@link Page#showDefinitionError} 如实报错。<b>没有</b>逐组补齐的入口，
 * 也没有"可见才建"的门控：页面视图一建就建，展开/收起只切可见性（不再现场 inflate + 测量）。
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
         * {@code GONE}），控制器建满并上屏后才露出（见 {@link #buildIfNeeded}）。
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

    ConfigFormController(@NonNull Page page, @NonNull Context appContext) {
        this.page = page;
        this.appContext = appContext;
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
        submit(() -> {
            try {
                final ConfigStore loaded = ConfigStore.get(appContext);
                final boolean defined = loaded.definitionsLoaded();
                final Snapshot snapshot = defined ? loaded.read() : null;
                // 定义没到位时把诊断串也在后台算出来：它内部还要读一次盘，不能留到主线程上做
                final String failure = defined ? null : loaded.describeState();
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

    // ==================== 建表：一次建满，建完才露 ====================

    /**
     * 把本页的表单一次建满（预热与首读都回来、视图也在时才做，只做一次）。三条路：
     * 定义没到位 → 如实报错；数据没回来 → 什么都不做，等 {@link #onLoaded}；
     * 都齐了 → 建卡、建行、上屏、露出。
     *
     * <p>露出的时机是本方法的最后一行：值、组头开关、徽标、自检、诊断全对齐之后才把容器
     * 置为可见，故页面不会出现"半张表"。
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
            return;
        }
        if (store == null || loadedSnapshot == null) {
            return;   // 预热与首读还没回来
        }
        built = true;
        everSettled = true;
        // 记账（旁路）：主线程建表那一段（建卡建行 + 值上屏 + 自检/诊断对齐 + 参数区露出）
        long startedAt = StartupTiming.now();
        buildForm(loadedSnapshot);
        applySnapshot(loadedSnapshot);   // 值、组头开关、徽标、自检、诊断一次对齐
        page.onFormBuilt(groups.size());
        page.cardContainer().setVisibility(View.VISIBLE);   // 都对齐了才露：不出现半成品
        StartupTiming.span(StartupTiming.FORM_BUILD, startedAt);
    }

    /**
     * 建表：本页该渲染的分组一次建满（{@link ConfigGroupBinder} 已不懒建，键行随卡一起建）。
     * 值不在这里铺：行建起来时各自用 {@link ConfigKeyRow.Host#diskValue} 回填，而此刻
     * {@link #diskValues} 已是快照真值（见下），故不存在"先默认值再回填"的一跳。
     */
    private void buildForm(@NonNull Snapshot snapshot) {
        groups.clear();
        final LayoutInflater inflater = page.formInflater();
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
            addGroup(inflater, container, page.groupTitle(group), master, keyMetas);
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
                addGroup(inflater, container,
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
    private void addGroup(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                          @NonNull String title, @Nullable KeyMeta master,
                          @NonNull List<KeyMeta> keyMetas) {
        if (keyMetas.isEmpty() && master == null) {
            return;
        }
        ConfigGroupBinder binder = ConfigGroupBinder.create(inflater, container, title, master,
                keyMetas, this);
        container.addView(binder.card());
        groups.add(binder);
        binder.setExpanded(page.expandsByDefault());
    }

    /** 本页键行的键数（各分组整组的键，含「未分组」兜底组）：键渲染自检的分项之一。 */
    int rowKeyCount() {
        int count = 0;
        for (ConfigGroupBinder group : groups) {
            count += group.rowKeys().size();
        }
        return count;
    }

    /** 本页组头开关数：键渲染自检的分项之一。 */
    int masterKeyCount() {
        int count = 0;
        for (ConfigGroupBinder group : groups) {
            if (group.masterKey() != null) {
                count++;
            }
        }
        return count;
    }

    /** 本页各分组的键行（不懒建后即整组的行）。 */
    @NonNull
    private List<ConfigKeyRow> rows() {
        List<ConfigKeyRow> all = new ArrayList<>();
        for (ConfigGroupBinder group : groups) {
            all.addAll(group.rows());
        }
        return all;
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

    /** 一份快照上屏：值、组头开关、徽标都对齐后，交给页面（自检）与诊断区。 */
    private void applySnapshot(@NonNull Snapshot snapshot) {
        diskValues.clear();
        diskValues.putAll(snapshot.values);
        for (ConfigKeyRow row : rows()) {
            row.applyValue(snapshot.get(row.key()));
        }
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(snapshot.get(masterKey));
            }
        }
        refreshBadges();
        page.onValuesApplied(snapshot);
        if (diagnostics != null) {
            // 复用刚读到的快照：诊断串里的"未定义键/提示"与 mtime 同源，不再多读一次 profile.conf
            diagnostics.refresh(snapshot);
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
     * 页面视图已建（{@code onCreateView} 调）：接管诊断区，并在预热已回来的情况下立刻建满。
     * 页面壳自己先藏着卡片容器（见 {@link Page#cardContainer()}），本类只在建满后露出。
     */
    void attachView(@NonNull View root) {
        pageRoot = root;
        viewAlive = true;
        ensureDiagnostics();
        final boolean rebuild = everSettled;   // 先取：本次是"再来一遍"还是头一次
        buildIfNeeded();
        if (rebuild) {
            // 视图重建（配置变更 / 进程恢复）：预热那份快照可能已旧，重建后补读一次
            reloadAsync();
        }
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
        built = false;
        pageRoot = null;
    }

    /** 页面销毁（{@code onDestroy} 调）：冲刷待写并关掉后台线程。 */
    void shutdown() {
        flush();
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
