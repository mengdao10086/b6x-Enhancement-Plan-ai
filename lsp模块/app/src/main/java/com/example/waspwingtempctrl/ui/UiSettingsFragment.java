package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置页（顶栏设置按钮 → {@code SettingsActivity} 挂载）：渲染 {@code params.json} 里所有归本页的
 * 分组（「界面」组与「控制」组，卡片顺序随定义），每组一张卡。本页不重复实现表单——键行/开关/落盘规则
 * 全在共用的 {@link ConfigFormController} 与 {@link ConfigKeyRow}/{@link ConfigGroupBinder}/
 * {@link ConfigWriteQueue} 里，本页只提供自己的壳、错误位、重置栏与「su 诊断」动作行；键清单只由
 * {@link #settingsKeys} 给出（自检与渲染同源）。边界同配置页（I3）：只经 {@link ConfigStore} 读写
 * {@code profile.conf}，不自己解析 assets。设计理由见 app 逻辑说明.md §9.3。
 */
public class UiSettingsFragment extends Fragment
        implements ConfigResetBar.Host, ConfigFormController.Page {

    /** 「界面」组 id（对应 {@code params.json} 的 {@code groups[].id}）。 */
    private static final String UI_GROUP_ID = "webui";
    /** 「控制」组 id：本页在这一组的卡末追加非表单的「su 诊断」动作行。 */
    private static final String CONTROL_GROUP_ID = "control";

    /** 表单数据流（与配置页共用的一份实现）。 */
    private ConfigFormController form;

    /** 页面根视图（Snackbar 落点）；视图销毁后置空。 */
    private View rootView;
    /** 页面内容容器：表单与重置栏都挂这里，建满前藏着（视图销毁后置空）。 */
    private LinearLayout contentBox;

    /** su 诊断的后台线程；随页面销毁关闭（`su` 往返不能占主线程）。 */
    private ExecutorService probeExecutor;
    /** 探测回主线程序上屏（页面销毁时清掉未派发的回调）。 */
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    /** 同一时刻只跑一趟探测：按钮再点只忽略，不叠第二次 su 往返。 */
    private boolean probing;

    /** 该分组是否由本页承载（配置页据此跳过它，并把它的键算进键渲染自检）。 */
    static boolean isSettingsGroup(@NonNull GroupMeta group) {
        return UI_GROUP_ID.equals(group.id) || CONTROL_GROUP_ID.equals(group.id);
    }

    /**
     * 分组标题去掉段标编号（「[4] 界面」→「界面」）：编号是给 {@code profile.conf} 段标对齐用的，
     * 显示时只是噪音。<b>本页卡头与重置栏按钮共用这一份实现</b>。见 app 逻辑说明.md §6.4。
     */
    static String stripSectionNumber(@NonNull String title) {
        return title.replaceFirst("^\\[\\d+\\]\\s*", "");
    }

    /**
     * 本页要渲染的键（按定义顺序，跨所有归本页的分组；不含 role=master 的键——{@code group.keys} 本就不含）。
     * 空列表表示定义里没有可渲染的分组（定义被改坏或换版本），此时页面给出空态而不是静默留白。
     */
    @NonNull
    static List<KeyMeta> settingsKeys(@NonNull ConfigStore store) {
        List<KeyMeta> keys = new ArrayList<>();
        for (GroupMeta group : store.groups()) {
            if (!isSettingsGroup(group)) {
                continue;
            }
            for (String key : group.keys) {
                KeyMeta meta = store.key(key);
                if (meta != null) {
                    keys.add(meta);
                }
            }
        }
        return keys.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(keys);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 建表一律现场 inflate：本页按需打开、不在启动链上，且是另一个 Activity 的上下文（预制造件不该跨页取用）
        form = new ConfigFormController(this, requireContext().getApplicationContext(), null);
        // 与首帧并行：定义到位即建卡（不等首份快照），快照到达后补值（见 app 逻辑说明.md §5.2）
        form.start();
        // su 诊断按需跑一趟（点动作行才起线程），无 I/O 排队需求，故独用一根
        probeExecutor = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "ww-settings-diag");
            thread.setDaemon(true);
            return thread;
        });
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextCopy.installPathSelection(view);
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

    /**
     * 键行建满之后：在「控制」组卡末追加非表单的「su 诊断」动作行。
     * 动作行自身带 {@code app:wrapFullLine}，由卡内的流式容器按整行铺开。
     */
    @Override
    public void onGroupRowsBuilt(@NonNull GroupMeta group, @NonNull ViewGroup body) {
        if (!CONTROL_GROUP_ID.equals(group.id)) {
            return;
        }
        View row = getLayoutInflater().inflate(R.layout.view_settings_action_row, body, false);
        row.setOnClickListener(v -> runSuDiagnostics());
        body.addView(row);
    }

    @NonNull
    @Override
    public String groupTitle(@NonNull GroupMeta group) {
        return stripSectionNumber(group.title);
    }

    @Override
    public boolean expandsByDefault() {
        return true;   // 本页分组少且都是自用项：默认全展开，否则进页面先看到一排折叠的卡
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
     * 建满之后的收尾：定义里没有可渲染的分组时给空态提示，然后把重置栏追加到参数卡之后
     * （先调参数、再整组回退，空态提示须留在它上面）。它不放键行（只有按钮），
     * 故配置页的键渲染自检不受影响。
     */
    @Override
    public void onFormBuilt(int groupCount, boolean rebuilding) {
        LayoutInflater inflater = getLayoutInflater();
        if (groupCount == 0) {
            TextView empty = new TextView(inflater.getContext());
            empty.setText(R.string.config_settings_empty);
            empty.setTextAppearance(inflater.getContext(),
                    R.style.TextAppearance_B6XTempCtrl_Caption);
            TextCopy.copyOnLongPress(empty);
            contentBox.addView(empty);
        }
        contentBox.addView(ConfigResetBar.create(inflater, contentBox, this).view());
        // 首轮不播淡入：这一轮控制器会等首份快照铺满才露（见 revealBuiltForm），一次就是终态；
        // 视图重建后的那一轮才淡入（控制器在本回调之后才把内容容器置为可见）
        if (rebuilding) {
            Motion.revealFadeIn(contentBox);
        }
    }

    /** 一参版是接口要求：控制器已统一走两参版，这里按"重建"语义转发。 */
    @Override
    public void onFormBuilt(int groupCount) {
        onFormBuilt(groupCount, true);
    }

    /**
     * 建表的"可见后段"失败：本页各分组都默认展开（见 {@code ConfigFormController} 的说明），
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

    // ==================== 非表单动作行：su 诊断 ====================

    /**
     * 点「su 诊断」：后台跑一趟 {@link DeployDiagnostics#build}（部署状态 + 配置状态 + root 诊断，
     * 底层是 core 的 {@link com.example.waspwingtempctrl.Deployer#probe()} 与
     * {@link com.example.waspwingtempctrl.RootShell#buildDiagnostics()}），回主线程弹一段可长按选中的文本。
     * 不写配置、不动守护进程，只读探测。
     */
    private void runSuDiagnostics() {
        if (probing || !isAdded()) {
            return;   // 已经有一趟在跑：不叠第二次 su 往返
        }
        final Context app = requireContext().getApplicationContext();
        probing = true;
        notifyUser(getString(R.string.config_settings_su_diag_busy), false);
        probeExecutor.execute(() -> {
            String text;
            try {
                text = DeployDiagnostics.build(app);
            } catch (Throwable t) {
                text = app.getString(R.string.config_settings_su_diag_failed, t.toString());
            }
            final String result = text;
            mainHandler.post(() -> {
                probing = false;
                if (!isAdded() || rootView == null) {
                    return;   // 页面已销毁：结果不再上屏
                }
                AlertDialog dialog = new AlertDialog.Builder(requireContext())
                        .setTitle(R.string.config_settings_su_diag_dialog_title)
                        .setMessage(result)
                        .setPositiveButton(R.string.config_settings_su_diag_close, null)
                        .create();
                dialog.setCanceledOnTouchOutside(true);
                TextCopy.makeMessageSelectable(dialog);
                dialog.show();
            });
        });
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
        mainHandler.removeCallbacksAndMessages(null);   // 探测结果不再落到已销毁的页面
        probeExecutor.shutdownNow();
        super.onDestroy();
    }
}
