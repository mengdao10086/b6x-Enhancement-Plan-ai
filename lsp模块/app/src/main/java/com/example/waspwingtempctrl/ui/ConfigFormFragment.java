package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.ConfigStore.WriteResult;
import com.example.waspwingtempctrl.PageAware;
import com.example.waspwingtempctrl.R;
import com.google.android.material.snackbar.Snackbar;

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
 * 配置 + 曲线合并页（页签「配置 · 曲线」）：由 {@link ConfigStore}（背后是 assets/params.json）
 * <b>动态生成</b>原生 Material 表单。
 *
 * <h3>结构</h3>
 * 自上而下三段（见 {@code fragment_config.xml}）：曲线区（{@link ChartFragment} 作为子
 * Fragment 挂在 {@code config_chart_container}，曲线自己不再单独占一个页签）→ 参数区
 * （分组卡片，键行由 {@link FlowWrapLayout} 流式排列）→ 诊断区。曲线把「数据文件信息」经
 * {@link ChartFragment.Host} 交给本页，渲染在诊断折叠体内（原曲线页顶部的那条信息条），
 * 键渲染自检同样在折叠体内，默认都不可见。
 *
 * <p>{@code webui} 组（「[4] 界面」）不由本页渲染：它在顶栏设置按钮打开的独立设置页
 * （{@link UiSettingsFragment}）里，但自检口径仍要把它算进来（见 {@link #renderSelfCheck}）。
 *
 * <h3>边界（I3）</h3>
 * 界面读写 {@code profile.conf} 只经 {@link ConfigStore}，不自己拼 shell、不直接碰文件、
 * 不自己解析 assets/params.json。分组、键、label、desc、单位、范围、依赖全部来自
 * {@code groups() / keys() / key(String)}。
 *
 * <h3>交互</h3>
 * 折叠分组 + 组头总开关 + "未生效"徽标（每组建一校）+ min/max 钳制 + 改即存防抖
 * （{@link ConfigWriteQueue}）。所有文件 I/O 在单线程 executor 上，主线程只做渲染。
 *
 * <h3>生命周期</h3>
 * 外壳用 ViewPager2 切页，<b>页面生命周期不再随切页暂停/恢复</b>（非当前页被压到 STARTED，
 * 不派发 {@code onPause}，也没有 hide/show 的 {@code onHiddenChanged}）：
 * 故 {@link #onPageVisible(boolean)} 在离开本页时冲刷待写项、停掉曲线区刷新，回到本页时重新读盘；
 * {@link #onPause()} 与 {@link #onDestroyView()} 也各自冲刷一次，不丢改动。
 *
 * <h3>懒建（冷启动不在本页时一次都不建）</h3>
 * 表单与参数定义都不在 {@code onCreate} / {@code onCreateView} 里做：外壳 {@code offscreenPageLimit}
 * 让三页的视图都会建，若在 {@code onCreateView} 里无条件建表单，冷启动（落在别的页）也要付
 * 4 张分组卡 + 44 个键行 + 64 个字段框，外加 {@code assets/params.json}（45KB / 1634 行）的主线程读取。
 * 现在两件事都推迟到<b>真正用得上</b>时：
 * <ul>
 *   <li>定义：{@link #prewarmStoreAsync()} 在后台线程先调 {@link ConfigStore#get}（预热），
 *       主线程只收回调（{@link #onStoreReady}）；</li>
 *   <li>表单：{@link #buildFormIfNeeded()} 在「视图已建 + 本页可见 + 定义已就绪」三个条件齐了
 *       才建（首次可见），组内键行再由 {@link ConfigGroupBinder} 在<b>本组展开时</b>建。</li>
 * </ul>
 * 预热失败不静默：{@code definitionsLoaded()==false} 走 {@link #showErrorCard}（诊断串），
 * 预热本身抛异常（如 OOM）也照样上屏说明，不停在空表单上。
 */
public class ConfigFormFragment extends Fragment
        implements ConfigKeyRow.Host, ChartFragment.Host, PageAware {

    /** 曲线区（子 Fragment）的 tag。 */
    private static final String TAG_CHART = "config_chart";

    /** 参数定义单例；预热完成后（主线程回调）才非空，见 {@link #prewarmStoreAsync()}。 */
    private ConfigStore store;
    /** 防抖写队列；与 store 同时就位（队列要持有 store）。 */
    private ConfigWriteQueue queue;
    /** 诊断区；需要 store 与页面根视图都在，故定义就绪后补建（见 {@link #ensureDiagnostics()}）。 */
    private ConfigDiagnostics diagnostics;
    private ExecutorService io;
    private Handler main;

    /** 磁盘上（或最近一次读取时）的值："值未变不写"的判定基准。仅主线程访问。 */
    private final Map<String, Value> diskValues = new LinkedHashMap<>();
    private final List<ConfigGroupBinder> groups = new ArrayList<>();

    private ScrollView scroll;
    private LinearLayout groupContainer;
    private TextView errorText;
    private View errorCard;
    private TextView selfCheckView;
    /** 诊断信息头部：数据文件信息（由曲线区回调填充）。 */
    private TextView dataFileView;
    /** 页面根视图：建诊断区要用（视图销毁后置空）。 */
    private View pageRoot;
    /** 曲线区（子 Fragment）；页面视图销毁后置空。 */
    private ChartFragment chart;

    private boolean viewAlive;
    /** 本页是否是当前页（外壳广播，见 {@link #onPageVisible}）。 */
    private boolean pageVisible;
    /** 表单是否已建（懒建标记；视图重建后复位）。 */
    private boolean formBuilt;
    /** 预热抛异常的原因（非空表示定义加载阶段就抛了，界面须如实说明而不是停在空表单）。 */
    private String loadFailure;
    /** 键渲染自检的三个分项（口径见 renderSelfCheck）。 */
    private int renderedRowCount;
    private int renderedSettingsCount;
    private int renderedMasterCount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        io = Executors.newSingleThreadExecutor();
        main = new Handler(Looper.getMainLooper());
        prewarmStoreAsync();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_config, container, false);
        scroll = root.findViewById(R.id.config_scroll);
        errorCard = root.findViewById(R.id.config_error_card);
        errorText = root.findViewById(R.id.config_error_text);
        groupContainer = root.findViewById(R.id.config_group_container);
        selfCheckView = root.findViewById(R.id.config_diag_selfcheck);
        dataFileView = root.findViewById(R.id.config_diag_datafile_text);
        pageRoot = root;
        viewAlive = true;
        // 滚动条常显（fadeScrollbars=false）+ 加粗到 scrollbar_size，按住即可拖动
        ScrollbarDrag.attach(scroll);
        ensureChartFragment();
        ensureDiagnostics();
        if (loadFailure != null) {
            // 预热就抛了：视图建好后第一件事就是如实说明（见 prewarmStoreAsync 的失败路径）
            showErrorCard(loadFailure);
        } else if (pageVisible) {
            // 本页就是当前页（视图建得比可见性广播晚）：此刻就能建，不必等下一次广播
            buildFormIfNeeded();
        }
        return root;
    }

    // ==================== 参数定义：后台预热 ====================

    /**
     * 预热参数定义：{@code assets/params.json} 的读 + 解析 + 建 53 个 KeyMeta 全在后台线程做完，
     * 主线程随后的 {@link ConfigStore#get} 立即拿到单例（冷启动首帧不再付这份开销）。
     *
     * <p>单例是双检锁的：这里先跑，别处（曲线区的后台线程等）再调就只剩一次 volatile 读。
     * 失败不吞：读/解析失败由 {@link ConfigStore} 记进 loadError，走
     * {@code definitionsLoaded()==false} 的错误卡；真正的异常（如 OOM）在这里兜底上报。
     */
    private void prewarmStoreAsync() {
        final Context app = requireContext().getApplicationContext();
        io.execute(() -> {
            try {
                final ConfigStore loaded = ConfigStore.get(app);
                main.post(() -> onStoreReady(loaded));
            } catch (Throwable t) {
                main.post(() -> onStoreFailed(t));
            }
        });
    }

    /** 定义就绪（主线程）：建写队列与诊断区，条件齐了就建表单。 */
    private void onStoreReady(@NonNull ConfigStore loaded) {
        if (io.isShutdown()) {
            return;   // 页面已销毁：结果丢弃（单例仍已就位，别的页面直接受益）
        }
        store = loaded;
        queue = new ConfigWriteQueue(store, io, main, this::onWriteResult);
        ensureDiagnostics();
        buildFormIfNeeded();
    }

    /** 预热抛异常（主线程）：如实上屏，不停在空表单。 */
    private void onStoreFailed(@NonNull Throwable t) {
        loadFailure = "参数定义加载失败：" + t;
        if (viewAlive) {
            showErrorCard(loadFailure);
        }
    }

    /** 诊断区（它要 store 与页面根视图都在）：定义就绪后补建，视图重建后再补一次。 */
    private void ensureDiagnostics() {
        if (diagnostics == null && pageRoot != null && store != null) {
            diagnostics = new ConfigDiagnostics(pageRoot, store, io, main);
        }
    }

    // ==================== 表单：首次真正可见时才建 ====================

    /**
     * 首次真正可见时建表单（懒建）：三个前置条件缺一不可——视图已建、本页可见、定义已就绪；
     * 任一不满足就什么都不做，由 {@link #onCreateView} / {@link #onStoreReady} /
     * {@link #onPageVisible} 三处各自补齐。建完随即读一次盘（见 {@link #reloadAsync()}）。
     *
     * @return true = 本次调用真的建了表单（调用方不必再读一次盘）
     */
    private boolean buildFormIfNeeded() {
        if (formBuilt || !viewAlive || !pageVisible || store == null) {
            return false;
        }
        formBuilt = true;
        buildForm(getLayoutInflater());
        reloadAsync();
        return true;
    }

    /**
     * 挂上曲线区（子 Fragment）。
     *
     * <p>宿主在事务提交前接上：子页第一次回调就有落点；页面重建（config change / 进程恢复）
     * 时 {@code getChildFragmentManager()} 里已有恢复出来的实例，只重新接宿主，不重复添加。
     * 用异步 {@code commit()}：本方法在父页的 onCreateView 里跑，此时子 FragmentManager
     * 可能正在派发自己的状态，{@code commitNow()} 会抛"already executing transactions"。
     */
    private void ensureChartFragment() {
        FragmentManager cfm = getChildFragmentManager();
        for (Fragment existing : cfm.getFragments()) {
            if (existing instanceof ChartFragment) {
                chart = (ChartFragment) existing;
                chart.setHost(this);
                return;
            }
        }
        chart = new ChartFragment();
        chart.setHost(this);
        cfm.beginTransaction().replace(R.id.config_chart_container, chart, TAG_CHART).commit();
    }

    // ==================== 构建表单（结构来自 ConfigStore） ====================

    private void buildForm(LayoutInflater inflater) {
        groups.clear();

        if (!store.definitionsLoaded()) {
            // 不给静默空列表：明确说明定义加载失败，并把诊断串（含失败原因）摆出来
            showErrorCard(store.describeState());
            return;
        }
        errorCard.setVisibility(View.GONE);
        groupContainer.setVisibility(View.VISIBLE);

        // 先用定义默认值铺底：读取完成前不出现空控件（文件缺失时 C 端与界面都用默认值）
        for (KeyMeta meta : store.keys()) {
            diskValues.put(meta.key, meta.defaultValue);
        }

        Set<String> covered = new LinkedHashSet<>();
        for (GroupMeta group : store.groups()) {
            if (UiSettingsFragment.isSettingsGroup(group)) {
                // 「[4] 界面」组的键在独立设置页渲染（顶栏设置按钮进入），本页不重复给入口。
                // 仍要记进 covered：否则下面的"未分组兜底"会把它们当孤儿键又列一遍。
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
            ConfigGroupBinder binder = ConfigGroupBinder.create(inflater, groupContainer,
                    group.title, master, keyMetas, this);
            groupContainer.addView(binder.card());
            groups.add(binder);
        }

        // 兜底：params.json 里没被任何分组列到的键也要能编辑（否则界面比定义少键还看不出来）
        List<KeyMeta> orphans = new ArrayList<>();
        for (KeyMeta meta : store.keys()) {
            if (!covered.contains(meta.key)) {
                orphans.add(meta);
            }
        }
        if (!orphans.isEmpty()) {
            ConfigGroupBinder binder = ConfigGroupBinder.create(inflater, groupContainer,
                    getString(R.string.config_group_ungrouped), null, orphans, this);
            groupContainer.addView(binder.card());
            groups.add(binder);
        }

        // 自检口径：一个定义键算"有可编辑入口"，当且仅当它是本页键行、设置页的键，或某个分组的
        // 组头开关（role=master 的键不由键行承载，由 ConfigGroupBinder 渲染成组头开关）。
        // 用去重集合计数：同名键被两个分组重复列出时也不虚增。
        // 键行按分组懒建（展开才建），故这里数的是各分组"将要建"的键（ConfigGroupBinder#rowKeys），
        // 不是已建的行——折叠态下列全建好才数得对，同时又不失去"每个键都有入口"的检查意义。
        // 设置页键数取自 UiSettingsFragment.webuiKeys()——那是设置页真正渲染的那一份，不另写数字。
        Set<String> rowKeys = new LinkedHashSet<>();
        for (ConfigGroupBinder group : groups) {
            rowKeys.addAll(group.rowKeys());
        }
        Set<String> masterKeys = new LinkedHashSet<>();
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                masterKeys.add(masterKey);
            }
        }
        renderedRowCount = rowKeys.size();
        renderedSettingsCount = UiSettingsFragment.webuiKeys(store).size();
        renderedMasterCount = masterKeys.size();

        // 键行的值不在这里铺：行由分组懒建，建起来时各自用 host.diskValue() 回填（见
        // ConfigGroupBinder#buildRows）。组头开关属于卡头，此刻已建，故这里回填。
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(diskValues.get(masterKey));
            }
        }
        refreshAllBadges();
    }

    /** 当前已建的键行（懒建：折叠组的行还没建，故每次现取，不缓存）。 */
    @NonNull
    private List<ConfigKeyRow> builtRows() {
        List<ConfigKeyRow> all = new ArrayList<>();
        for (ConfigGroupBinder group : groups) {
            all.addAll(group.rows());
        }
        return all;
    }

    /** 错误卡：把原因摆出来，参数区与自检区让位（定义没到位就没有可编辑的键）。 */
    private void showErrorCard(@NonNull String text) {
        errorCard.setVisibility(View.VISIBLE);
        errorText.setText(text);
        groupContainer.setVisibility(View.GONE);
        selfCheckView.setVisibility(View.GONE);
    }

    // ==================== 读盘 ====================

    private void reloadAsync() {
        if (!viewAlive || store == null) {
            return;   // 视图不在或定义还没就绪：此刻读了也没处上屏
        }
        if (!store.definitionsLoaded()) {
            diagnostics.refresh();
            return;
        }
        submit(() -> {
            final Snapshot snapshot = store.read();
            main.post(() -> {
                if (viewAlive) {
                    applySnapshot(snapshot);
                }
            });
        });
    }

    private void applySnapshot(Snapshot snapshot) {
        diskValues.clear();
        diskValues.putAll(snapshot.values);
        for (ConfigKeyRow row : builtRows()) {
            row.applyValue(snapshot.get(row.key()));
        }
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(snapshot.get(masterKey));
            }
        }
        refreshAllBadges();
        renderSelfCheck(snapshot);
        // 复用刚读到的快照：诊断串里的"未定义键/提示"与 mtime 同源，不再多读一次 profile.conf
        diagnostics.refresh(snapshot);
    }

    /** 冲刷待写队列（定义还没就绪时队列尚未建，无待写项可冲）。 */
    private void flushQueue() {
        if (queue != null) {
            queue.flushNow();
        }
    }

    /**
     * 键渲染自检：<b>每个定义键都要有可编辑入口</b>——本页键行（role=setting）、设置页的键
     * （{@code webui} 组）或组头开关（role=master）。顺带把未定义键与读取提示摆出来。
     *
     * <p>口径说明：{@code params.json} 里 role=master 的键（总开关）不出现在任何
     * {@code group.keys} 里，它们是分组卡头上的开关；{@code webui} 组的键在本页不渲染，
     * 故只数本页键行会恒少于定义数。键行按分组懒建，三个分项都在建表单时一次算定
     * （键行数取各分组"将要建"的键，见 {@link ConfigGroupBinder#rowKeys()}），
     * 故未展开的组也计得进、且不会因展开先后而变。
     * 自检文本渲染在诊断区（折叠体内），默认不可见。
     */
    private void renderSelfCheck(Snapshot snapshot) {
        int defined = store.keyCount();
        StringBuilder sb = new StringBuilder();
        if (renderedRowCount + renderedSettingsCount + renderedMasterCount == defined) {
            sb.append(getString(R.string.config_diag_render_ok,
                    renderedRowCount, renderedSettingsCount, renderedMasterCount, defined));
        } else {
            sb.append(getString(R.string.config_diag_render_mismatch,
                    renderedRowCount, renderedSettingsCount, renderedMasterCount, defined));
        }
        if (!snapshot.unknownKeys.isEmpty()) {
            sb.append('\n').append(getString(R.string.config_unknown_keys,
                    TextUtils.join(", ", snapshot.unknownKeys)));
        }
        for (String note : snapshot.notes) {
            sb.append('\n').append(note);
        }
        selfCheckView.setText(sb);
        selfCheckView.setVisibility(View.VISIBLE);
    }

    private void submit(Runnable task) {
        if (io.isShutdown()) {
            return;
        }
        try {
            io.execute(task);
        } catch (RejectedExecutionException ignored) {
            // 页面已销毁，等待中的读盘任务直接丢弃
        }
    }

    private void refreshAllBadges() {
        for (ConfigGroupBinder group : groups) {
            group.refreshBadges();
        }
    }

    // ==================== 写盘结果 ====================

    private void onWriteResult(WriteResult result, Map<String, Value> written) {
        if (!viewAlive) {
            return;
        }
        if (result.ok) {
            diskValues.putAll(written);
        }
        List<String> labels = new ArrayList<>();
        for (String key : written.keySet()) {
            KeyMeta meta = store.key(key);
            labels.add(meta == null ? key : meta.label);
        }
        String message = TextUtils.join("、", labels) + "：" + result.describe();
        for (ConfigKeyRow row : builtRows()) {
            if (written.containsKey(row.key())) {
                row.setResultStatus(message, result.ok);
            }
        }
        if (!result.ok) {
            notifyUser(message, true);
        }
        refreshAllBadges();
        diagnostics.refresh();
    }

    // ==================== ConfigKeyRow.Host ====================
    // store/queue 在"定义就绪"（onStoreReady）时一起就位，而键行只在定义就绪后才建
    // （buildFormIfNeeded 的前置条件），故下面两个 getter 被调用时必非 null。

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
        refreshAllBadges();
    }

    @Override
    public void notifyUser(String message, boolean error) {
        if (!viewAlive || scroll == null) {
            return;
        }
        Snackbar.make(scroll, message, error ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }

    // ==================== ChartFragment.Host ====================

    /**
     * 曲线区的「数据文件信息」上屏位置：诊断信息头部（曲线卡内不再重复）。
     * 本页不做任何加工，原文照贴；读取失败时的诊断正文也在其中。
     */
    @Override
    public void onChartInfo(@NonNull String text) {
        if (dataFileView != null) {
            dataFileView.setText(text);
        }
    }

    // ==================== 生命周期：不丢改动 ====================

    @Override
    public void onPause() {
        super.onPause();
        flushQueue();
    }

    @Override
    public void onPageVisible(boolean visible) {
        // 曲线区是子 Fragment，父页不可见不会传播到子级，刷新停/启必须在这里转达
        if (chart != null) {
            chart.setPageHidden(!visible);
        }
        pageVisible = visible;
        if (visible) {
            if (!buildFormIfNeeded()) {
                // 已建：回到本页重读盘（配置可能被 C 端或部署流程改过）。
                // 本次刚建的话，上面那次已含首读，不必再读一次。
                reloadAsync();
            }
        } else {
            // 生命周期不随切页暂停（onPause 不会来），故在这里也冲刷一次
            flushQueue();
        }
    }

    @Override
    public void onDestroyView() {
        viewAlive = false;
        if (queue != null) {
            queue.flushNow();
            queue.detach();
        }
        if (diagnostics != null) {
            diagnostics.release();
        }
        diagnostics = null;
        groups.clear();
        // 视图没了：表单要等下次可见重建（懒建标记与页面根视图一并复位）
        formBuilt = false;
        scroll = null;
        groupContainer = null;
        errorCard = null;
        errorText = null;
        selfCheckView = null;
        dataFileView = null;
        pageRoot = null;
        chart = null;   // 子 Fragment 实例仍在（视图随本页一起销毁），只是不再从这里驱动它
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        flushQueue();
        io.shutdown();
        super.onDestroy();
    }
}
