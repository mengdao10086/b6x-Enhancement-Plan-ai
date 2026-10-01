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
 * <p>自上而下三段（见 {@code fragment_config.xml}）：曲线区（{@link ChartFragment} 子 Fragment）→
 * 参数区（分组卡片，键行由 {@link WrapRowLayout} 流式排列）→ 诊断区。本页只管壳与自己独有的块
 * （挂曲线子页、摆诊断折叠体里的内容、把用户反馈落到 Snackbar）；表单数据流只有一份实现，在
 * {@link ConfigFormController} 里、与设置页共用。{@code webui} 组不由本页渲染（见
 * {@link UiSettingsFragment}），但自检口径仍要把它算进来（见 {@link #renderSelfCheck}）。
 *
 * <p><b>边界（I3）</b>：界面读写 {@code profile.conf} 只经 {@link ConfigStore}，不自己拼 shell、
 * 不直接碰文件、不自己解析 assets/params.json。
 *
 * <p>加载两段、露面闸门与展开/收起只切可见性的口径见 app 逻辑说明.md §5.2 与 §6.1；
 * 生命周期（ViewPager2 切页不派发 {@code onPause}，靠 {@link #onPageVisible}）见 §9.1。
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预制造器（启动期那根后台线程造的键行控件，见 ConfigPreInflater）：本页吃它，取不到就现场造。
        // 传本页上下文当身份凭据：Activity 换了一个就不再取用（否则会挂上属于上一个 Activity 的件）
        form = new ConfigFormController(this, requireContext().getApplicationContext(),
                ConfigPreInflater.get(requireContext()));
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
     * 挂上曲线区（子 Fragment）。页面重建时 {@code getChildFragmentManager()} 里已有恢复出来的实例，
     * 只重新接宿主、不重复添加。用异步 {@code commit()}：本方法在父页的 onCreateView 里跑，
     * {@code commitNow()} 会抛"already executing transactions"。
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
     * 定义没到位（加载失败或预热抛异常）：错误卡摆在参数区的位置，诊断串（含失败原因）一并摆出来，
     * 不给静默空列表。这条路<b>不会</b>经过 {@link #onFormBuilt}，但同样是本页内容的终态。
     */
    @Override
    public void showDefinitionError(@NonNull String message) {
        errorCard.setVisibility(View.VISIBLE);
        errorText.setText(message);
        selfCheckView.setVisibility(View.GONE);
    }

    /**
     * 参数区露面（本页内容的终态之一）：调用点在"可见结构已就位"那一刻（见 app 逻辑说明.md §5.2）。
     * 本页没有别的建表后收尾动作（曲线子页与诊断折叠体在 {@code onCreateView} 里已挂好），故不做任何事。
     */
    @Override
    public void onFormBuilt(int groupCount) {
        // 本页无需在此做事
    }

    /**
     * 建表的"可见后段"失败：用参数区末尾那张错误卡（与"定义没到位"共用一处落点）补一句实话，
     * 失败原因<b>不需要用户展开任何东西就能看见</b>。不回退已露出的卡头：留着半张表比整块不露
     * 更接近用户预期，也留住了"哪些键存在"这个信息。
     */
    @Override
    public void showPartialBuildFailure(@NonNull String message) {
        if (errorCard == null) {
            return;   // 视图已销毁：无处可放，也不该再碰视图
        }
        errorCard.setVisibility(View.VISIBLE);
        errorText.setText(message);
    }

    @Override
    public void onValuesApplied(@NonNull Snapshot snapshot) {
        renderSelfCheck(snapshot);
    }

    /**
     * 键渲染自检：<b>每个定义键都要有可编辑入口</b>——本页键行（role=setting）、设置页的键
     * （{@code webui} 组）或组头开关（role=master）；顺带把未定义键与读取提示摆出来。三个分项在建表时
     * 一次算定（见 {@link ConfigFormController#rowKeyCount()}），不会因展开先后而变。见 app 逻辑说明.md §6.1。
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
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        form.shutdown();
        super.onDestroy();
    }
}
