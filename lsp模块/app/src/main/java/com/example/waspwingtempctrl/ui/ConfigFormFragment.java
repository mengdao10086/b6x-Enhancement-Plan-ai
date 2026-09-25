package com.example.waspwingtempctrl.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.PageAware;
import com.example.waspwingtempctrl.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * 配置 + 曲线合并页（页签「配置 · 曲线」）：由 {@link ConfigStore}（背后是 assets/params.json）
 * <b>动态生成</b>原生 Material 表单。
 *
 * <h3>结构</h3>
 * 自上而下三段（见 {@code fragment_config.xml}）：曲线区（{@link ChartFragment} 作为子
 * Fragment 挂在 {@code config_chart_container}，曲线自己不再单独占一个页签）→ 参数区
 * （分组卡片，键行由 {@link WrapRowLayout} 流式排列）→ 诊断区。曲线把「数据文件信息」经
 * {@link ChartFragment.Host} 交给本页，渲染在诊断折叠体内（原曲线页顶部的那条信息条），
 * 键渲染自检同样在折叠体内，默认都不可见。
 *
 * <p>{@code webui} 组（「[4] 界面」）不由本页渲染：它在顶栏设置按钮打开的独立设置页
 * （{@link UiSettingsFragment}）里，但自检口径仍要把它算进来（见 {@link #renderSelfCheck}）。
 *
 * <h3>职责：本页只管壳与自己独有的块</h3>
 * 表单数据流（读快照、建卡建行、上屏、写盘回执、冲刷、诊断刷新）<b>只有一份实现</b>，在
 * {@link ConfigFormController} 里，与设置页共用；本页只做控制器不做的事：挂曲线子页、摆诊断
 * 折叠体里的内容（数据文件信息条 + 键渲染自检）、把用户反馈落到本页的 Snackbar 上。
 *
 * <h3>加载：与预读并行，建完才出现</h3>
 * 定义与首份快照在后台读（{@link ConfigFormController#start()}，{@code onCreate} 即起），读完
 * 主线程一次把卡与键行建满、值也上屏，最后才让参数区露面；在那之前
 * {@code config_group_container} 一直是 {@code gone}（布局里就是这么定的），故打开本页不会看到
 * "先空、再逐组冒出来"的一闪。展开/收起只切可见性，不再现场 inflate + 测量。
 *
 * <h3>边界（I3）</h3>
 * 界面读写 {@code profile.conf} 只经 {@link ConfigStore}，不自己拼 shell、不直接碰文件、
 * 不自己解析 assets/params.json。
 *
 * <h3>生命周期</h3>
 * 外壳用 ViewPager2 切页，<b>页面生命周期不再随切页暂停/恢复</b>（非当前页被压到 STARTED，
 * 不派发 {@code onPause}，也没有 hide/show 的 {@code onHiddenChanged}）：
 * 故 {@link #onPageVisible(boolean)} 在离开本页时冲刷待写项、停掉曲线区刷新，回到本页时重新读盘；
 * {@link #onPause()} 与 {@link #onDestroyView()} 也各自冲刷一次，不丢改动。
 */
public class ConfigFormFragment extends Fragment
        implements ConfigKeyRow.Host, ConfigFormController.Page, ChartFragment.Host, PageAware {

    /** 曲线区（子 Fragment）的 tag。 */
    private static final String TAG_CHART = "config_chart";

    /** 表单数据流（与设置页共用的一份实现）。 */
    private ConfigFormController form;

    /** 页面根视图（Snackbar 落点、诊断区建点）；视图销毁后置空。 */
    private View pageRoot;
    private ViewGroup groupContainer;
    private View errorCard;
    private TextView errorText;
    private TextView selfCheckView;
    /** 诊断信息头部：数据文件信息（由曲线区回调填充）。 */
    private TextView dataFileView;
    /** 曲线区（子 Fragment）；页面视图销毁后置空。 */
    private ChartFragment chart;

    /**
     * 本视图的内容是否已定（表单建满，或已把"定义没到位"如实上屏）。
     *
     * <p>这是外壳判定本页「就绪」的唯一依据（见 {@link #isStructureReady()}）：它表达的是
     * <b>结构已建好</b>，不是"数据已绑满"——建成与上屏是同一次主线程操作（见
     * {@link ConfigFormController} 的 {@code buildIfNeeded}）。
     */
    private boolean structureReady;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        form = new ConfigFormController(this, requireContext().getApplicationContext());
        // 与首帧并行：定义与首份快照在后台读，读完主线程一次建满（建满之前参数区不露面）
        form.start();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_config, container, false);
        pageRoot = root;
        groupContainer = root.findViewById(R.id.config_group_container);
        errorCard = root.findViewById(R.id.config_error_card);
        errorText = root.findViewById(R.id.config_error_text);
        selfCheckView = root.findViewById(R.id.config_diag_selfcheck);
        dataFileView = root.findViewById(R.id.config_diag_datafile_text);
        // 滚动条常显（fadeScrollbars=false）+ 加粗到 scrollbar_size，按住即可拖动
        ScrollbarDrag.attach(root);
        ensureChartFragment();
        // 壳已建好：交给控制器（参数区在建满前保持 gone，见 ConfigFormController）
        form.attachView(root);
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

    // ========== 键行宿主（ConfigKeyRow.Host）：数据全在控制器手上，这里只转发 ==========
    // notifyUser 同时满足 ConfigKeyRow.Host 与 ConfigFormController.Page 两处要求（同一个语义：
    // 本页的人话反馈），故只有这一份实现。

    @NonNull
    @Override
    public ConfigStore store() {
        return form.store();
    }

    @NonNull
    @Override
    public ConfigWriteQueue queue() {
        return form.queue();
    }

    @Nullable
    @Override
    public Value diskValue(String key) {
        return form.diskValue(key);
    }

    @Nullable
    @Override
    public Value effectiveValue(String key) {
        return form.effectiveValue(key);
    }

    @Override
    public void onPendingChange() {
        form.onPendingChange();
    }

    @Override
    public void notifyUser(@NonNull String message, boolean error) {
        if (pageRoot == null) {
            return;
        }
        Snackbar.make(pageRoot, message, error ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }

    // ========== 页面（ConfigFormController.Page）：本页独有的部分 ==========

    @NonNull
    @Override
    public LayoutInflater formInflater() {
        return getLayoutInflater();
    }

    @NonNull
    @Override
    public ViewGroup cardContainer() {
        return groupContainer;
    }

    @Override
    public boolean rendersGroup(@NonNull GroupMeta group) {
        // 「[4] 界面」组的键在独立设置页渲染（顶栏设置按钮进入），本页不重复给入口
        return !UiSettingsFragment.isSettingsGroup(group);
    }

    @NonNull
    @Override
    public String groupTitle(@NonNull GroupMeta group) {
        return group.title;
    }

    @Override
    public boolean expandsByDefault() {
        return false;   // 本页组多键多：折叠态一屏能看清全部组与总开关
    }

    @Override
    public boolean showsUngroupedGroup() {
        return true;   // params.json 里没被任何分组列到的键也要能编辑
    }

    @Override
    public boolean hasDiagnostics() {
        return true;
    }

    /**
     * 定义没到位（加载失败或预热抛异常）：错误卡摆在参数区的位置——那里没有可编辑的键，
     * 诊断串（含失败原因）一并摆出来，不给静默空列表。
     *
     * <p>这条路<b>不会</b>经过 {@link #onFormBuilt}（见 {@code ConfigFormController.buildIfNeeded}
     * 的分支），而它同样是本页内容的终态（此后不会再有任何东西建出来），故在这里一并置「就绪」——
     * 否则外壳的骨架占位层要一直等到硬上界才撤。
     */
    @Override
    public void showDefinitionError(@NonNull String message) {
        errorCard.setVisibility(View.VISIBLE);
        errorText.setText(message);
        selfCheckView.setVisibility(View.GONE);
        structureReady = true;
    }

    /**
     * 表单建满（本页内容的终态之一）：置「就绪」。
     *
     * <p>配置页没有别的建表后收尾动作（曲线子页与诊断折叠体在 {@code onCreateView} 里已挂好），
     * 这里只为外壳的骨架占位层留一个准信：此刻起本页的结构不会再变（见 {@link #isStructureReady()}）。
     */
    @Override
    public void onFormBuilt(int groupCount) {
        structureReady = true;
    }

    /**
     * 本页结构是否已就绪（＝「已建好、尚无具体数据」的那个状态）。
     *
     * <p>给外壳用：状态页、日志页的结构就是 inflate 出来的，视图一有即就绪；本页的表单是读完定义
     * 后在主线程异步建出来的，只有建完（或把"定义没到位"如实上屏）才算就绪。外壳据此撤骨架占位层、
     * 并决定何时截这套骨架图。
     *
     * <p>调在 {@code onDestroyView} 里复位：视图重建后要重新建成才算就绪（那条路上
     * {@link ConfigFormController} 也会 {@code detachView} 后重建，两者同寿）。
     */
    public boolean isStructureReady() {
        return structureReady;
    }

    @Override
    public void onValuesApplied(@NonNull Snapshot snapshot) {
        renderSelfCheck(snapshot);
    }

    /**
     * 键渲染自检：<b>每个定义键都要有可编辑入口</b>——本页键行（role=setting）、设置页的键
     * （{@code webui} 组）或组头开关（role=master）。顺带把未定义键与读取提示摆出来。
     *
     * <p>口径说明：{@code params.json} 里 role=master 的键（总开关）不出现在任何
     * {@code group.keys} 里，它们是分组卡头上的开关；{@code webui} 组的键在本页不渲染，
     * 故只数本页键行会恒少于定义数。三个分项在建表时一次算定（键行数取各分组"整组"的键，
     * 见 {@link ConfigFormController#rowKeyCount()}），不会因展开先后而变。
     * 自检文本渲染在诊断区（折叠体内），默认不可见。
     */
    private void renderSelfCheck(Snapshot snapshot) {
        ConfigStore store = form.store();
        int renderedRowCount = form.rowKeyCount();
        int renderedMasterCount = form.masterKeyCount();
        // 设置页键数取自 UiSettingsFragment.webuiKeys()——那是设置页真正渲染的那一份，不另写数字
        int renderedSettingsCount = UiSettingsFragment.webuiKeys(store).size();
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
        form.flush();
    }

    @Override
    public void onPageVisible(boolean visible) {
        // 曲线区是子 Fragment，父页不可见不会传播到子级，刷新停/启必须在这里转达
        if (chart != null) {
            chart.setPageHidden(!visible);
        }
        form.setPageVisible(visible);
    }

    @Override
    public void onDestroyView() {
        form.detachView();
        pageRoot = null;
        groupContainer = null;
        errorCard = null;
        errorText = null;
        selfCheckView = null;
        dataFileView = null;
        chart = null;   // 子 Fragment 实例仍在（视图随本页一起销毁），只是不再从这里驱动它
        structureReady = false;   // 控制器的 built 也在这里复位（detachView）：重建后要重新建成才算就绪
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        form.shutdown();
        super.onDestroy();
    }
}
