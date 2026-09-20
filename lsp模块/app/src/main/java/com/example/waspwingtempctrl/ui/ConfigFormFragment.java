package com.example.waspwingtempctrl.ui;

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
 * 外壳用 add/hide/show 切页，<b>被隐藏的 Fragment 生命周期仍是 RESUMED</b>：
 * 故 {@link #onHiddenChanged(boolean)} 在隐藏时冲刷待写项、停掉曲线区刷新，回到本页时重新读盘；
 * {@link #onPause()} 与 {@link #onDestroyView()} 也各自冲刷一次，不丢改动。
 */
public class ConfigFormFragment extends Fragment
        implements ConfigKeyRow.Host, ChartFragment.Host {

    /** 曲线区（子 Fragment）的 tag。 */
    private static final String TAG_CHART = "config_chart";

    private ConfigStore store;
    private ConfigWriteQueue queue;
    private ConfigDiagnostics diagnostics;
    private ExecutorService io;
    private Handler main;

    /** 磁盘上（或最近一次读取时）的值："值未变不写"的判定基准。仅主线程访问。 */
    private final Map<String, Value> diskValues = new LinkedHashMap<>();
    private final List<ConfigKeyRow> rows = new ArrayList<>();
    private final List<ConfigGroupBinder> groups = new ArrayList<>();

    private ScrollView scroll;
    private LinearLayout groupContainer;
    private TextView errorText;
    private View errorCard;
    private TextView selfCheckView;
    /** 诊断信息头部：数据文件信息（由曲线区回调填充）。 */
    private TextView dataFileView;
    /** 曲线区（子 Fragment）；页面视图销毁后置空。 */
    private ChartFragment chart;

    private boolean viewAlive;
    /** 键渲染自检的三个分项（口径见 renderSelfCheck）。 */
    private int renderedRowCount;
    private int renderedSettingsCount;
    private int renderedMasterCount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        store = ConfigStore.get(requireContext());
        io = Executors.newSingleThreadExecutor();
        main = new Handler(Looper.getMainLooper());
        queue = new ConfigWriteQueue(store, io, main, this::onWriteResult);
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
        diagnostics = new ConfigDiagnostics(root, store, io, main);
        viewAlive = true;
        // 滚动条常显（fadeScrollbars=false）+ 加粗到 scrollbar_size，按住即可拖动
        ScrollbarDrag.attach(scroll);
        ensureChartFragment();
        buildForm(inflater);
        reloadAsync();
        return root;
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
        rows.clear();
        groups.clear();

        if (!store.definitionsLoaded()) {
            // 不给静默空列表：明确说明定义加载失败，并把诊断串（含失败原因）摆出来
            errorCard.setVisibility(View.VISIBLE);
            errorText.setText(store.describeState());
            groupContainer.setVisibility(View.GONE);
            selfCheckView.setVisibility(View.GONE);
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
            rows.addAll(binder.rows());
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
            rows.addAll(binder.rows());
        }

        // 自检口径：一个定义键算"有可编辑入口"，当且仅当它是本页键行、设置页的键，或某个分组的
        // 组头开关（role=master 的键不由键行承载，由 ConfigGroupBinder 渲染成组头开关）。
        // 用去重集合计数：同名键被两个分组重复列出时也不虚增。
        // 设置页键数取自 UiSettingsFragment.webuiKeys()——那是设置页真正渲染的那一份，不另写数字。
        Set<String> rowKeys = new LinkedHashSet<>();
        for (ConfigKeyRow row : rows) {
            rowKeys.add(row.key());
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

        for (ConfigKeyRow row : rows) {
            row.applyValue(diskValues.get(row.key()));
        }
        for (ConfigGroupBinder group : groups) {
            String masterKey = group.masterKey();
            if (masterKey != null) {
                group.applyMasterValue(diskValues.get(masterKey));
            }
        }
        refreshAllBadges();
    }

    // ==================== 读盘 ====================

    private void reloadAsync() {
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
        for (ConfigKeyRow row : rows) {
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
        diagnostics.refresh();
    }

    /**
     * 键渲染自检：<b>每个定义键都要有可编辑入口</b>——本页键行（role=setting）、设置页的键
     * （{@code webui} 组）或组头开关（role=master）。顺带把未定义键与读取提示摆出来。
     *
     * <p>口径说明：{@code params.json} 里 role=master 的键（总开关）不出现在任何
     * {@code group.keys} 里，它们是分组卡头上的开关；{@code webui} 组的键在本页不渲染，
     * 故只数本页键行会恒少于定义数。自检文本渲染在诊断区（折叠体内），默认不可见。
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
        for (ConfigKeyRow row : rows) {
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
        queue.flushNow();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        // 曲线区是子 Fragment，父页的 hide() 不会传播到子级，刷新停/启必须在这里转达
        if (chart != null) {
            chart.setPageHidden(hidden);
        }
        if (hidden) {
            // 被隐藏的 Fragment 生命周期仍是 RESUMED（onPause 不会来），故在这里也冲刷一次
            queue.flushNow();
        } else {
            // 回到本页：配置可能被 C 端或部署流程改过，重新读盘
            reloadAsync();
        }
    }

    @Override
    public void onDestroyView() {
        viewAlive = false;
        queue.flushNow();
        queue.detach();
        if (diagnostics != null) {
            diagnostics.release();
        }
        diagnostics = null;
        rows.clear();
        groups.clear();
        scroll = null;
        groupContainer = null;
        errorCard = null;
        errorText = null;
        selfCheckView = null;
        dataFileView = null;
        chart = null;   // 子 Fragment 实例仍在（视图随本页一起销毁），只是不再从这里驱动它
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        queue.flushNow();
        io.shutdown();
        super.onDestroy();
    }
}
