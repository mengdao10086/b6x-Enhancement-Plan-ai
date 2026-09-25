package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 设置页（顶栏设置按钮 → {@code SettingsActivity} 挂载）：只渲染 {@code params.json} 里
 * {@code webui} 组（「[4] 界面」）的那几个键。
 *
 * <h3>为什么单独一页</h3>
 * 这几个键是"曲线怎么画、界面怎么显示"的自用参数（{@code daemonConsumes=false}），
 * 与配置页那些会被守护进程读取的运维参数不是一类东西；搬到设置页后配置页只剩要调的参数。
 * 本页不重复实现表单：键行、开关、落盘规则全在本页与配置页共用的
 * {@link ConfigFormController} 与 {@link ConfigKeyRow} / {@link ConfigGroupBinder} /
 * {@link ConfigWriteQueue} 里，本页只提供自己的壳、错误位与重置栏。
 * <b>本页的键数也是配置页键渲染自检的一个分项</b>，故键清单只由 {@link #webuiKeys} 给出，
 * 自检与渲染同源，不会各写一份数字。
 *
 * <h3>布局</h3>
 * 页面本身只是「@dimen/page_padding 内边距 + 一张分组卡 + 重置栏」，没有单独的布局文件：
 * 分组卡由 {@link ConfigGroupBinder} 从 {@code item_config_group.xml} 生成，重置栏是
 * {@link ConfigResetBar}（自带布局），页面壳在 {@link #onCreateView} 里直接搭。
 * 重置栏按分组整体恢复出厂值，故放在参数卡之后——先调参数、再整组回退，
 * 且表单的空态提示（无分组卡时）也在它上面。
 *
 * <p>边界同配置页（I3）：只经 {@link ConfigStore} 读写 {@code profile.conf}，不自己解析 assets。
 *
 * <h3>加载：与预读并行，建完才出现</h3>
 * 定义与首份快照在后台读（{@link ConfigFormController#start()}，{@code onCreate} 即起），读完
 * 主线程一次把卡与键行建满、值也上屏，{@link #onFormBuilt} 里再追加重置栏，最后才让内容露面；
 * 在那之前内容容器一直是 {@code GONE}，故打开本页不会看到"先空、再逐段冒出来"的一闪。
 */
public class UiSettingsFragment extends Fragment
        implements ConfigResetBar.Host, ConfigFormController.Page {

    /** 本页承载的分组 id（对应 {@code params.json} 的 {@code groups[].id}）。 */
    private static final String SETTINGS_GROUP_ID = "webui";

    /** 表单数据流（与配置页共用的一份实现）。 */
    private ConfigFormController form;

    /** 页面根视图（Snackbar 落点）；视图销毁后置空。 */
    private View rootView;
    /** 页面内容容器：表单与重置栏都挂这里，建满前藏着（视图销毁后置空）。 */
    private LinearLayout contentBox;

    /** 该分组是否由本页承载（配置页据此跳过它，并把它的键算进键渲染自检）。 */
    static boolean isSettingsGroup(@NonNull GroupMeta group) {
        return SETTINGS_GROUP_ID.equals(group.id);
    }

    /**
     * 分组标题去掉段标编号（「[4] 界面」→「界面」）。
     *
     * <p>编号是给 {@code profile.conf} 的段标对齐用的，定义里必须留着
     * （{@code check_params.py} 断言分组标题带「[N]」，且 profile.conf 段标由它派生）；
     * 但显示时它只是噪音，故剥掉。<b>本页卡头与重置栏按钮共用这一份实现</b>
     * （见 {@link ConfigResetBar}），显示口径只有一处。
     */
    static String stripSectionNumber(@NonNull String title) {
        return title.replaceFirst("^\\[\\d+\\]\\s*", "");
    }

    /**
     * 本页要渲染的键（按定义顺序，不含 role=master 的键——{@code group.keys} 本就不含）。
     * 空列表表示定义里没有这个分组（定义被改坏或换版本），此时页面给出空态而不是静默留白。
     */
    @NonNull
    static List<KeyMeta> webuiKeys(@NonNull ConfigStore store) {
        for (GroupMeta group : store.groups()) {
            if (!isSettingsGroup(group)) {
                continue;
            }
            List<KeyMeta> keys = new ArrayList<>();
            for (String key : group.keys) {
                KeyMeta meta = store.key(key);
                if (meta != null) {
                    keys.add(meta);
                }
            }
            return Collections.unmodifiableList(keys);
        }
        return Collections.emptyList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 建表一律现场 inflate：本页按需打开、不在启动链上，且它是另一个 Activity 的上下文——
        // 启动期那份预制造件（为配置页准备的，带的是配置页 Activity 的上下文）不该跨页取用
        form = new ConfigFormController(this, requireContext().getApplicationContext(), null);
        // 与首帧并行：定义与首份快照在后台读，读完主线程一次建满（建满之前内容不露面）
        form.start();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ScrollView scroll = new ScrollView(inflater.getContext());
        scroll.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scroll.setFillViewport(true);
        // 常显 + 可按住拖动：与配置页同一套（本页内容通常不满一屏，滚动条只在放不下时出现）
        scroll.setScrollbarFadingEnabled(false);
        ScrollbarDrag.attach(scroll);

        LinearLayout content = new LinearLayout(inflater.getContext());
        content.setOrientation(LinearLayout.VERTICAL);
        int padding = getResources().getDimensionPixelSize(R.dimen.page_padding);
        content.setPadding(padding, padding, padding, padding);
        // 建完才出现：内容（参数卡 + 重置栏）由控制器建满并上屏后才露；错误串自己会把它露出来
        content.setVisibility(View.GONE);
        scroll.addView(content);
        rootView = scroll;
        contentBox = content;

        form.attachView(scroll);
        return scroll;
    }

    // ========== 键行与重置栏共用的服务面（ConfigResetBar.Host 继承 ConfigKeyRow.Host） ==========
    // 数据全在控制器手上，这里只把契约转发过去；notifyUser 同时满足 ConfigKeyRow.Host 与
    // ConfigFormController.Page 两处要求（同一个语义：本页的人话反馈），故只有这一份实现。

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
        if (rootView == null) {
            return;
        }
        Snackbar.make(rootView, message, error ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }

    // ==================== ConfigResetBar.Host：按分组重置 ====================

    /**
     * 用户已确认重置某组：冲刷待写、按出厂值一次原子写盘、回写本页值，全在控制器里
     * （见 {@link ConfigFormController#resetGroup}，那里的注释说明为什么必须先冲刷待写队列）。
     */
    @Override
    public void onResetConfirmed(@NonNull String label, @NonNull Map<String, Value> factoryValues) {
        form.resetGroup(label, factoryValues);
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
        return contentBox;
    }

    @Override
    public boolean rendersGroup(@NonNull GroupMeta group) {
        return isSettingsGroup(group);
    }

    @NonNull
    @Override
    public String groupTitle(@NonNull GroupMeta group) {
        return stripSectionNumber(group.title);
    }

    @Override
    public boolean expandsByDefault() {
        return true;   // 本页只有这一组：默认展开，否则进页面先看到一张折叠的卡
    }

    @Override
    public boolean showsUngroupedGroup() {
        return false;   // 未归组的键由配置页的兜底卡承载，本页不重复给入口
    }

    @Override
    public boolean hasDiagnostics() {
        return false;   // 诊断折叠体只在配置页的布局里
    }

    /** 定义没到位（加载失败或预热抛异常）：与配置页同口径，不给静默空白。 */
    @Override
    public void showDefinitionError(@NonNull String message) {
        Context context = requireContext();
        TextView error = new TextView(context);
        error.setText(message);
        error.setTextAppearance(context, R.style.TextAppearance_B6XTempCtrl_Mono);
        error.setTextIsSelectable(true);
        contentBox.addView(error);
        contentBox.setVisibility(View.VISIBLE);
    }

    /**
     * 建满之后的收尾：定义里没有本组（或本组的键一个都对不上）时给空态提示，
     * 然后把重置栏追加到参数卡之后——进页面要看的是参数本身，整组回退是调完再退的收尾动作；
     * 且空态提示须留在它上面，故等表单铺完再追加。它与上方卡的间隙由该卡自带的上间距给出
     * （{@code view_config_reset_bar.xml}，与分组卡同一标尺），此处不再补。
     * 它不放键行（只有按钮），故配置页的键渲染自检不受影响。
     */
    @Override
    public void onFormBuilt(int groupCount) {
        LayoutInflater inflater = getLayoutInflater();
        if (groupCount == 0) {
            TextView empty = new TextView(inflater.getContext());
            empty.setText(R.string.config_settings_empty);
            empty.setTextAppearance(inflater.getContext(),
                    R.style.TextAppearance_B6XTempCtrl_Caption);
            contentBox.addView(empty);
        }
        contentBox.addView(ConfigResetBar.create(inflater, contentBox, this).view());
    }

    /**
     * 建表的"可见后段"失败：本页不分段（只有一组且默认展开，见 {@code ConfigFormController} 的说明），
     * 故这一段失败时参数区还没露出来——把失败原因摆进内容容器并让它可见，同样不给静默空白。
     */
    @Override
    public void showPartialBuildFailure(@NonNull String message) {
        if (contentBox == null) {
            return;   // 视图已销毁：无处可放
        }
        Context context = contentBox.getContext();
        TextView failure = new TextView(context);
        failure.setText(message);
        failure.setTextAppearance(context, R.style.TextAppearance_B6XTempCtrl_Mono);
        failure.setTextIsSelectable(true);
        contentBox.addView(failure);
        contentBox.setVisibility(View.VISIBLE);
    }

    /** 本页没有随快照变的自检/诊断块（曲线上屏在配置页）。 */
    @Override
    public void onValuesApplied(@NonNull Snapshot snapshot) {
    }

    // ==================== 生命周期：不丢改动 ====================

    @Override
    public void onPause() {
        super.onPause();
        form.flush();
    }

    @Override
    public void onDestroyView() {
        form.detachView();
        contentBox = null;
        rootView = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        form.shutdown();
        super.onDestroy();
    }
}
