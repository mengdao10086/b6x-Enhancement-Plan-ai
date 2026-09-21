package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Accept;
import com.example.waspwingtempctrl.ConfigStore.Assessment;
import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个配置键的行：switch / int / multi / path 四种 type 共用一份绑定逻辑。
 *
 * <p>键的 label / desc / 单位 / 范围 / 依赖全部来自 {@link KeyMeta}（背后是 assets/params.json），
 * 本类不手抄任何键定义，也不自己解析 params.json。
 *
 * <h3>形态（配合 {@link FlowWrapLayout}）</h3>
 * <ul>
 *   <li>每个键整行独占（向容器声明 fullLine）：参数之间不并排。</li>
 *   <li>第一行 = 参数名 + 输入框（输入框靠行尾，参数名留左，见 {@code item_config_row.xml}）；
 *       键内多个字段的输入框宽度按内容实测、再按控制区可用宽分配（见 {@link #refitFieldWidths}），
 *       放不下由键内的 {@code config_key_control} 换行。</li>
 *   <li>multi 键带 {@code fields[].bool} 的字段渲染成开关（值只有 0/1），其余字段仍是输入框。</li>
 *   <li>path 型键：输入框吃掉控制区剩余宽，文本放不下时显示右半段（布局就绪后由
 *       {@link #applyPathScroll} 摆放），并在本次启动内记住编辑时滚到的位置（见 {@link #PATH_SCROLL_X}）。</li>
 * </ul>
 *
 * <h3>什么时候落盘（三条规则）</h3>
 * <ul>
 *   <li><b>switch</b>：值只有 0/1，切换即完整 → 立即排入防抖队列。</li>
 *   <li><b>int / multi</b>：每次输入都排入防抖队列（写入前先 {@link ConfigStore#assess} 钳制，
 *       所以磁盘上不会出现越界值）；失焦时把钳制后的值回写控件并提示"原值 → 钳制后"。</li>
 *   <li><b>path / 护栏键</b>：<b>只在失焦/提交时落盘</b>。半截路径会被 C 端当成真路径去 open()；
 *       护栏键的中间态越界会让 C 端整组拒绝。这两类写坏值的代价都高于"少一次即时保存"。</li>
 * </ul>
 *
 * <h3>护栏键（PID_KI_DYN_*）不写坏值</h3>
 * {@link ConfigStore#isGuardrailValidated} 为 true 的键，若 {@link ConfigStore#daemonAccepts}
 * 判定 C 端不接受，则<b>不落盘</b>，行内显示拒绝原因，控件保留用户输入以便其修改。
 * 理由：写进去 C 端也不认，只会造成"界面显示 X、守护进程用 Y"的假象。
 *
 * <p>"未生效"的标注只做在分组卡头一次（见 {@link ConfigGroupBinder}），行内只压暗不重复标注。
 */
final class ConfigKeyRow {

    /** 量输入框内容宽时多带的尾串：对应"两个小写字符"的余量（小写字母最宽也不过如此）。 */
    private static final String CONTENT_WIDTH_TAIL = "aa";

    /**
     * path 键的横向显示位置（键名 → {@code scrollX}），进程内存活。
     *
     * <p>为什么放在静态表里而不是行对象上：要求是"本次启动内保持"，而行对象随页面视图重建，
     * 存字段上会被重建清掉。键数上限就是定义里的键数（53），不担心增长。
     */
    private static final Map<String, Integer> PATH_SCROLL_X = new HashMap<>();

    /** 行与外界的交互面（由 ConfigFormFragment / UiSettingsFragment 实现）。 */
    interface Host {
        @NonNull
        ConfigStore store();

        @NonNull
        ConfigWriteQueue queue();

        /** 磁盘上的值（"值未变不写"的判定基准）。 */
        @Nullable
        Value diskValue(String key);

        /** 叠加待写项后的当前有效值（依赖徽标判定用）。 */
        @Nullable
        Value effectiveValue(String key);

        /** 待写项变了（立即刷新依赖徽标，不等落盘）。 */
        void onPendingChange();

        /** 人话反馈（Snackbar）。 */
        void notifyUser(String message, boolean error);
    }

    /**
     * 一个输入字段：值里的一个整数/一段路径文本，或一个布尔子开关 —— 二者互斥，
     * 由定义里的 {@code fields[].bool} 决定（见 {@link ConfigStore.FieldMeta#bool}）。
     */
    private static final class Field {
        /** 字段布局的根（item_config_field）：宽度回写要同时改它与其内的输入框。 */
        final View root;
        final TextInputEditText input;
        /** 承载 {@link #input} 的 OutlinedBox；宽度实测后回写到它的 LayoutParams。布尔字段为 null。 */
        final TextInputLayout layout;
        final MaterialSwitch toggle;

        Field(@NonNull View root, @Nullable TextInputEditText input, @Nullable TextInputLayout layout,
              @Nullable MaterialSwitch toggle) {
            this.root = root;
            this.input = input;
            this.layout = layout;
            this.toggle = toggle;
        }

        /** 该字段当前值；输入框"还没输完"时返回 null（开关永远有完整值）。 */
        @Nullable
        Integer value() {
            if (toggle != null) {
                return toggle.isChecked() ? 1 : 0;
            }
            return parseInt(textOf(input));
        }

        /** 控件里现有的文本；布尔字段没有文本，返回 null。 */
        @Nullable
        String text() {
            return input == null ? null : textOf(input);
        }

        void setValue(int value) {
            if (toggle != null) {
                toggle.setChecked(value != 0);
            } else {
                input.setText(String.valueOf(value));
            }
        }

        void setValue(String text) {
            input.setText(text);
        }
    }

    private final KeyMeta meta;
    private final Host host;
    private final View root;
    private final LinearLayout control;
    private final TextView labelView;
    private final TextView descView;
    private final TextView noteView;
    private final TextView statusView;
    private final MaterialSwitch toggle;
    private final List<Field> fields = new ArrayList<>();
    /** 挂到行级的字段说明行（单字段键才有，见 {@link #buildNumberField}）：它不在控制区里，压暗要单独处理。 */
    private final List<TextView> rowLevelCaptions = new ArrayList<>();
    private final float dimAlpha;

    /** 控制区内字段之间的间距 = FlowWrapLayout 的列距（固定 @dimen/space_m），只用来做宽度预算。 */
    private final int fieldGap;
    /** 数值字段宽度的自适应区间（@dimen/config_field_min_width / config_field_max_width）。 */
    private final int fieldMinWidth;
    private final int fieldMaxWidth;

    /** 控制区首次布局后的实际可用宽；0 = 还没量到（此时字段宽只按内容定）。 */
    private int controlAvail;

    /** true 时忽略控件回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressChange;

    /**
     * @param groupShowsUiOnly 本组卡头已经挂出「界面自用，守护进程不读取」时传 true：
     *                         该标注整组只出现一次，行内不再重复
     */
    static ConfigKeyRow create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                               @NonNull KeyMeta meta, @NonNull ConfigKeyRow.Host host,
                               boolean groupShowsUiOnly) {
        View root = inflater.inflate(R.layout.item_config_row, parent, false);
        if (parent instanceof FlowWrapLayout) {
            // 每个键整行独占：参数之间不并排（并排只发生在键内部的字段之间）。
            // 键行铺满行宽还有两个前提：控制区靠行尾、多字段键的内部换行有确定的可用宽。
            ((FlowWrapLayout) parent).setFullLine(root, true);
        }
        return new ConfigKeyRow(inflater, root, meta, host, groupShowsUiOnly);
    }

    private ConfigKeyRow(LayoutInflater inflater, View root, KeyMeta meta, Host host,
                         boolean groupShowsUiOnly) {
        this.root = root;
        this.meta = meta;
        this.host = host;
        this.dimAlpha = readDimAlpha(root.getResources());
        Resources res = root.getResources();
        fieldGap = res.getDimensionPixelSize(R.dimen.space_m);
        fieldMinWidth = res.getDimensionPixelSize(R.dimen.config_field_min_width);
        fieldMaxWidth = res.getDimensionPixelSize(R.dimen.config_field_max_width);

        control = root.findViewById(R.id.config_key_control);
        labelView = root.findViewById(R.id.config_key_label);
        descView = root.findViewById(R.id.config_key_desc);
        noteView = root.findViewById(R.id.config_key_note);
        statusView = root.findViewById(R.id.config_key_status);
        toggle = root.findViewById(R.id.config_key_switch);

        labelView.setText(meta.label);
        if (meta.desc.isEmpty()) {
            descView.setVisibility(View.GONE);
        } else {
            descView.setText(meta.desc);
        }

        List<String> rowNotes = new ArrayList<>();
        if (!meta.daemonConsumes && !groupShowsUiOnly) {
            // 组内所有键都不被守护进程读取时，这句在卡头标一次（见 ConfigGroupBinder），行内不再重复
            rowNotes.add(root.getContext().getString(R.string.config_ui_only));
        }
        if (meta.guardrail && !meta.rangeNote.isEmpty()) {
            // 护栏键的跨字段约束与"整组拒绝"语义来自定义本身（rangeNote），不是界面编的
            rowNotes.add(meta.rangeNote);
        }
        if (!rowNotes.isEmpty()) {
            noteView.setText(TextUtils.join(" ｜ ", rowNotes));
            noteView.setVisibility(View.VISIBLE);
        }

        if (meta.isSwitch()) {
            toggle.setVisibility(View.VISIBLE);
            toggle.setOnCheckedChangeListener((button, checked) -> {
                if (suppressChange) {
                    return;
                }
                commitSwitch(toggle, meta, host);
            });
        } else {
            prepareControlArea(inflater);
        }
    }

    /**
     * 控制区（输入框容器）的准备：撤掉占位 Space 的 weight、建字段、挂"宽度按实际可用宽重算"的回调。
     *
     * <p>控制区自己带 {@code 0dp + weight=1}（见 item_config_row.xml）：框架按 weight 分配前会先把参数名
     * 与那 8dp 外边距从行宽里扣掉，控制区拿到的才是真实可用宽。占位 Space 的 weight 不撤，两者会对半分。
     */
    private void prepareControlArea(LayoutInflater inflater) {
        View spacer = root.findViewById(R.id.config_key_spacer);
        ((LinearLayout.LayoutParams) spacer.getLayoutParams()).weight = 0;
        spacer.requestLayout();

        buildFields(inflater);
        control.setVisibility(View.VISIBLE);
        // 控制区的宽由行内 weight 给出，首次布局后才知道实际可用宽；字段宽此时要按它重算一次
        control.addOnLayoutChangeListener((v, left, top, right, bottom,
                                           oldLeft, oldTop, oldRight, oldBottom) -> {
            int avail = control.getWidth() - control.getPaddingStart() - control.getPaddingEnd();
            if (avail <= 0 || avail == controlAvail) {
                return;
            }
            controlAvail = avail;
            refitFieldWidths();
        });
    }

    @NonNull
    View view() {
        return root;
    }

    @NonNull
    String key() {
        return meta.key;
    }

    // ==================== 控件构建 ====================

    private void buildFields(LayoutInflater inflater) {
        int count = meta.isMulti() ? meta.fieldCount() : 1;
        for (int i = 0; i < count; i++) {
            View fieldView = inflater.inflate(R.layout.item_config_field, control, false);
            // inflate 的第三参 false = 不挂到父容器，必须自己 addView：
            // 否则控件被创建、绑好监听后就被丢掉，行内只剩标签没有输入框。
            control.addView(fieldView);
            // 字段之间的间距由外层流式容器的行距/列距给，本行不再各加一截 topMargin

            if (isBoolField(i)) {
                buildBoolField(fieldView, i);
            } else {
                buildNumberField(fieldView, i);
            }
        }
        // 宽度必须在首次测量前定下来：外层流式容器按子视图的 LayoutParams 宽排布，早于首次测量
        // （此时控件已 inflate、hint 已设，量出来的才是最终宽度）
        refitFieldWidths();
    }

    /** 定义里 {@code fields[i].bool} 为 true 的字段用开关渲染（值只有 0/1）。 */
    private boolean isBoolField(int index) {
        return meta.isMulti() && meta.fields.get(index).bool;
    }

    /** 布尔字段：字段名 + 开关。宽度同样自适应（字段名宽度决定），高度与输入框同一行居中。 */
    private void buildBoolField(View fieldView, int index) {
        FieldMeta fieldMeta = meta.fields.get(index);
        View row = fieldView.findViewById(R.id.config_field_switch_row);
        row.setVisibility(View.VISIBLE);
        TextView label = fieldView.findViewById(R.id.config_field_switch_label);
        if (isPlaceholderLabel(fieldView.getContext(), fieldMeta.label)) {
            // 定义里的占位词（见 strings_config.xml）与右边的开关控件本身重复，不再渲染
            label.setVisibility(View.GONE);
        } else {
            label.setText(fieldMeta.label);
        }
        MaterialSwitch boolSwitch = fieldView.findViewById(R.id.config_field_switch);
        boolSwitch.setOnCheckedChangeListener((button, checked) -> {
            if (suppressChange) {
                return;
            }
            commitBoolField();
        });
        // 数值字段的输入框与范围说明都不适用：0/1 的"范围 0~1"是噪音
        fieldView.findViewById(R.id.config_field_layout).setVisibility(View.GONE);
        fields.add(new Field(fieldView, null, null, boolSwitch));
    }

    /** bool 字段的 label 是占位词时不显示标签：它只说"这里是个开关"，而右边就是开关。 */
    private static boolean isPlaceholderLabel(@NonNull Context context, @NonNull String label) {
        return label.equals(context.getString(R.string.config_bool_label_placeholder));
    }

    /** 数值/路径字段：宽度由 {@link #refitFieldWidths} 按内容与可用宽分配，高度统一 @dimen/field_height。 */
    private void buildNumberField(View fieldView, int index) {
        TextInputLayout layout = fieldView.findViewById(R.id.config_field_layout);
        TextInputEditText input = fieldView.findViewById(R.id.config_field_input);
        TextView note = fieldView.findViewById(R.id.config_field_note);

        String hint;
        String unit;
        String unitNote;
        if (meta.isMulti()) {
            FieldMeta fieldMeta = meta.fields.get(index);
            hint = fieldMeta.label;
            unit = fieldMeta.unit == null ? "" : fieldMeta.unit;
            // ConfigStore.FieldMeta 没有解析 params.json 的字段级 unitNote，
            // 界面不自行读 assets（I1/I3 边界），故多值字段只显示 unit 能拿到的部分。
            unitNote = "";
        } else {
            hint = control.getContext().getString(
                    meta.isPath() ? R.string.config_hint_path : R.string.config_hint_value);
            unit = meta.unit;
            unitNote = meta.unitNote;
        }
        layout.setHint(hint);
        if (meta.isPath()) {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        String caption = joinParts(joinParts(unit, rangeText(index)), unitNote);
        if (caption.isEmpty()) {
            note.setVisibility(View.GONE);
        } else {
            note.setText(caption);
            if (!meta.isMulti()) {
                // 单字段键：说明行挂到行级、按整行宽折行。留在字段里只能按框宽折——框宽可能只有 72dp，
                // 长说明折 4~5 行把整块顶高（挂行级后同样内容 1~2 行）。多字段键不能这么挂：
                // 说明一旦离开自己的输入框，就分不清属于哪个字段。
                ((ViewGroup) fieldView).removeView(note);
                ((ViewGroup) root).addView(note, 1);
                rowLevelCaptions.add(note);
            }
        }

        Field field = new Field(fieldView, input, layout, null);

        input.addTextChangedListener(new Watcher());
        if (meta.isPath()) {
            // 布局驱动重试摆放横向位置：只 post 一次会撞上"setText 当帧 mLayout 仍为 null"
            // （启动/重进页面时必现），这里每次布局后再试，布局就绪即摆好
            input.addOnLayoutChangeListener((v, left, top, right, bottom,
                                             oldLeft, oldTop, oldRight, oldBottom) -> applyPathScroll());
        }
        input.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                return;
            }
            if (meta.isPath()) {
                // 编辑结束：记下滚到的位置（本次启动内有效）。必须在 commit 之前取，
                // commit 会回填值、把显示位置带回左边
                PATH_SCROLL_X.put(meta.key, input.getScrollX());
            }
            commit(true);
        });
        input.setOnEditorActionListener((v, actionId, event) -> {
            v.clearFocus();
            return true;
        });
        fields.add(field);
    }

    /**
     * 按控制区的实际可用宽重新分配所有字段的宽度（建行后、首次布局后、值回填后各算一次）。
     *
     * <p><b>数值字段</b>：目标宽 = {@link #naturalFieldWidth} 量出的自然宽（已钳进 [下限, 上限]）。
     * 若「目标宽合计 + 布尔字段宽 + 字段间距」超过可用宽，就从最宽的开始往下削、削到下限为止：
     * 宽框的 hint 被省略号截断，好过整个字段被挤到下一行（多字段键会退化成"每个字段独占一行"）。
     * 削到下限仍放不下就不再硬挤，交给流式容器换行——那时一行的字段数已是它能容纳的上限。
     *
     * <p><b>path 字段</b>：{@code MATCH_PARENT} 吃掉控制区剩余宽。路径长度不可控（默认日志路径 58 字符
     * 在 16sp 下约 570dp，而可用宽约 304dp），定宽会顶出屏幕——文字是居中的，被裁掉的是两端。
     *
     * <p>字段根与输入框写同一个值：根是 wrap_content 容器，只改框会让根按旧宽测量；流式容器的
     * 换行判据读的也正是字段根的实测宽。
     */
    private void refitFieldWidths() {
        if (fields.isEmpty()) {
            return;
        }
        if (meta.isPath()) {
            writeWidth(fields.get(0), ViewGroup.LayoutParams.MATCH_PARENT);
            return;
        }
        int count = fields.size();
        int[] target = new int[count];
        int total = fieldGap * Math.max(0, count - 1) + fixedFieldWidth();
        for (int i = 0; i < count; i++) {
            if (fields.get(i).layout == null) {
                continue;                       // 布尔字段：宽度由字段名与开关决定，不参与分配
            }
            target[i] = naturalFieldWidth(fields.get(i));
            total += target[i];
        }
        // 削峰只在实际可用宽已知时做；未知（还没布局过）就用自然宽，布局回调里会重算
        int excess = controlAvail > 0 ? total - controlAvail : 0;
        int floor = controlAvail > 0 ? Math.min(fieldMinWidth, controlAvail) : fieldMinWidth;
        while (excess > 0) {
            int widest = -1;
            for (int i = 0; i < count; i++) {
                if (fields.get(i).layout == null || target[i] <= floor) {
                    continue;
                }
                if (widest < 0 || target[i] > target[widest]) {
                    widest = i;
                }
            }
            if (widest < 0) {
                break;                          // 都到下限了：剩下的交给流式容器换行
            }
            int cut = Math.min(excess, target[widest] - floor);
            target[widest] -= cut;
            excess -= cut;
        }
        for (int i = 0; i < count; i++) {
            if (fields.get(i).layout != null) {
                writeWidth(fields.get(i), target[i]);
            }
        }
    }

    /**
     * 回写字段宽。宽没变就什么都不做：{@link #applyValue} 回填会走到这里，
     * 否则形成"回填 → 重写宽 → 再布局 → 再回填"的空转。
     *
     * <p>直接改 LayoutParams 不会自己触发重测，故宽真的变了要显式请求。
     */
    private static void writeWidth(Field field, int width) {
        if (field.root.getLayoutParams().width == width
                && field.layout.getLayoutParams().width == width) {
            return;
        }
        field.root.getLayoutParams().width = width;
        field.layout.getLayoutParams().width = width;
        field.layout.requestLayout();
    }

    /** 布尔字段（wrap_content，宽由字段名与开关决定）占走的宽度合计。 */
    private int fixedFieldWidth() {
        int total = 0;
        for (Field field : fields) {
            if (field.layout == null && field.root.getVisibility() != View.GONE) {
                total += field.root.getMeasuredWidth();
            }
        }
        return total;
    }

    /**
     * 输入框的自然宽度 = max(说明宽, 内容宽 + {@value #CONTENT_WIDTH_TAIL} 的宽度)，再钳进 [下限, 上限]。
     * path 键不走这里（它按 MATCH_PARENT 吃掉控制区剩余宽，见 {@link #refitFieldWidths}）。
     *
     * <p><b>为什么说明要单独量</b>：Material 的 TextInputLayout 不参与说明的测宽
     * （{@code onMeasure} 就是 {@code LinearLayout.onMeasure}，框宽只由 EditText 自己撑出来），
     * 说明只是"画"在框里/框顶，画不下就自己打省略号——量 {@code text=""} 的框量不到说明，
     * 说明经常被截成"每周…"。故这里按说明文字自己算一次（见 {@link #measureHintWidth}），
     * 与内容宽取大者。
     *
     * <p><b>为什么要量两次</b>：说明与内容不会同时占位，同一份控件量不出这两个宽度，
     * 只能各量一次取大者。内容里多带两个小写字符，是给"再多敲一位"留出可见余量。
     *
     * <p><b>为什么不按当前值实时算</b>：值一变宽度就跟着变，边输边跳——旧 WebUI 的
     * "改参不被撑宽"就是这个意思。宽度只在建行与值回填（{@link #applyValue}）时定。
     */
    private int naturalFieldWidth(Field field) {
        String text = field.text();
        CharSequence hint = field.layout.getHint();
        String hintText = hint == null ? "" : hint.toString();

        // 量宽要临时改写输入框文本，必须屏蔽回调（否则等于程序化了用户输入），量完恢复原文本。
        // suppressChange 存旧值再恢复：调用方（applyValue 的循环）可能已开着抑制，不能一把关掉。
        boolean previous = suppressChange;
        suppressChange = true;
        // 光标位置也要原样放回：重算宽度会在用户正打字时发生（控制区宽变），而 setText 会把光标带回开头
        int selectionStart = field.input.getSelectionStart();
        int selectionEnd = field.input.getSelectionEnd();
        int hintWidth = hintText.isEmpty() ? 0 : measureHintWidth(field, hintText);
        int contentWidth;
        try {
            contentWidth = measureWithText(field, text + CONTENT_WIDTH_TAIL);
        } finally {
            field.input.setText(text);
            if (selectionStart >= 0) {
                field.input.setSelection(Math.min(selectionStart, text.length()),
                        Math.min(Math.max(selectionEnd, selectionStart), text.length()));
            }
            suppressChange = previous;
        }
        int width = Math.max(hintWidth, contentWidth);
        return Math.max(fieldMinWidth, Math.min(width, fieldMaxWidth));
    }

    /**
     * 说明文字所需的框宽 = 说明文字宽 + 输入框左右内边距。
     *
     * <p>用输入框自己的画笔量文字（占位说明用的就是它的字号与字重，见
     * {@code TextInputLayout#setEditText}），而不是"把说明写进输入框再量框"——数字型输入框带
     * 数字过滤器，程序化写进去的非数字文本未必留得住，量出来可能是个空框。
     * 内边距取输入框当前值（就是 item_config_field.xml 里写的那两个），
     * 因为说明的可用宽正是"框宽 − 内边距"。
     */
    private static int measureHintWidth(Field field, String hintText) {
        TextPaint paint = field.input.getPaint();
        return (int) Math.ceil(paint.measureText(hintText))
                + field.input.getPaddingStart() + field.input.getPaddingEnd();
    }

    /** 把 {@code text} 临时写进输入框，让 OutlinedBox 自己量一次宽（内边距与浮起 hint 由它处理）。 */
    private static int measureWithText(Field field, String text) {
        field.input.setText(text);
        field.layout.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        return field.layout.getMeasuredWidth();
    }

    /** 值回填后重算一次宽：值比 hint 长时框要跟着变宽。文本真的变了才重算，免得无谓重排。 */
    private void remeasureIfTextChanged(Field field, @Nullable String before) {
        if (field.layout == null || TextUtils.equals(before, field.text())) {
            return;
        }
        // 一个字段变宽会改同行其它字段的分额，故整键重算，不是只算这一个
        refitFieldWidths();
    }

    /**
     * 把 path 输入框的横向显示位置摆到「上次编辑结束时滚到的位置」，没有记录时摆到最右
     * （路径放不下时显示右半段——看得见文件名比看得见 <code>/storage/emulated/0/…</code> 有用）。
     *
     * <p>摆放时机由 {@link #buildNumberField} 注册的布局回调负责（每次布局后都会再来一次）；
     * 这里补一次 post，兜住"布局已经好了、不会再变"的情形。
     */
    private void restorePathScroll() {
        if (!meta.isPath() || fields.isEmpty()) {
            return;
        }
        fields.get(0).input.post(this::applyPathScroll);
    }

    /**
     * path 输入框非聚焦时把横向位置摆到目标位置：能滚多远由 {@code Layout} 的首行右沿与视图宽决定，
     * 布局还没算出来（{@code mLayout} 为 null、视图宽为 0）就等下一次布局回调，摆到即停。
     *
     * <p>摆放位置按"记得的位置"与"能滚的上限"取小，换了更短的路径也不会滚过头留白。
     * 聚焦时不动：编辑中位置归用户与光标跟随，抢过来会看不见刚敲的字。
     *
     * <p><b>上限为什么不取 {@code Layout#getWidth()}</b>：开了 {@code scrollHorizontally} 的输入框，
     * TextView 传给 Layout 的宽是"无上限"（{@code want = VERY_WIDE = 1MB}，见 {@code TextView#onMeasure}），
     * Layout 的宽因此恒为 1MB、与文本多长无关，文本只占这个宽的中段——拿 1MB 算上限，摆出来的位置
     * 落在文本右侧的大片空白里，框里一个字都画不出来（看着就是个空框）。故上限取 {@link Layout#getLineRight}
     * （"该行横向滚动该露出的最右位置"，TextView 自己摆光标用的也是它）减视图宽：文本右端正好贴住框右沿。
     */
    private void applyPathScroll() {
        if (!meta.isPath() || fields.isEmpty()) {
            return;
        }
        TextInputEditText input = fields.get(0).input;
        if (input.isFocused()) {
            return;
        }
        Layout layout = input.getLayout();
        int viewWidth = input.getWidth();
        if (layout == null || viewWidth <= 0) {
            return;
        }
        Integer remembered = PATH_SCROLL_X.get(meta.key);
        int maxScroll = Math.max(0, (int) Math.ceil(layout.getLineRight(0)) - viewWidth);
        int target = remembered == null ? maxScroll : Math.min(remembered, maxScroll);
        if (input.getScrollX() != target) {
            input.scrollTo(target, 0);
        }
    }

    /**
     * 取"未生效"压暗透明度。
     *
     * <p>aapt2 把 {@code <item type="dimen" format="float">} 编译成 <b>float 值</b>（不是 dp 的
     * dimension），所以 {@code getDimension()} 取不到；而 {@code Resources.getFloat()} 要
     * API 29（本模块 minSdk 25），故按 API 1 的 {@code getValue()} + {@link TypedValue} 读。
     */
    private static float readDimAlpha(Resources resources) {
        TypedValue value = new TypedValue();
        resources.getValue(R.dimen.config_dim_alpha, value, true);
        if (value.type == TypedValue.TYPE_FLOAT) {
            return value.getFloat();
        }
        return resources.getDimension(R.dimen.config_dim_alpha);
    }

    /** 第 {@code index} 个字段的取值范围文案（来自 {@link KeyMeta#min(int)}/{@link KeyMeta#max(int)}）。 */
    private String rangeText(int index) {
        if (meta.isPath()) {
            return "";
        }
        Integer min = meta.min(index);
        Integer max = meta.max(index);
        if (min == null || max == null) {
            return "";
        }
        return control.getContext().getString(R.string.config_range,
                String.valueOf(min), String.valueOf(max));
    }

    /** 两段说明拼一行（如"RPM/周期 ｜ 无量纲倍率"）。 */
    private static String joinParts(String first, String second) {
        String a = first == null ? "" : first;
        String b = second == null ? "" : second;
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        return a + " ｜ " + b;
    }

    // ==================== 值 ⇄ 控件 ====================

    /**
     * 把值写进控件。程序化回填不该触发写入，故屏蔽回调；
     * 文本真的变了才重算输入框宽度（值比 hint 长时框要跟着变宽）。
     */
    void applyValue(@Nullable Value value) {
        if (value == null) {
            return;
        }
        suppressChange = true;
        try {
            if (meta.isSwitch()) {
                toggle.setChecked(value.intAt(0) != 0);
            } else if (meta.isPath()) {
                Field field = fields.get(0);
                String before = field.text();
                field.setValue(value.text());
                // 光标钉到末尾：setText 会把光标置 0（ArrowKeyMovementMethod.initialize → Selection.setSelection(text, 0)），
                // 而框架随后在自己的 pre-draw 里按"把光标摆进可视区"（bringPointIntoView(getSelectionEnd())）摆一次——
                // 光标留在 0 就摆到路径左段，与本类 applyPathScroll 摆的右段各摆一端（两处各写一次，谁后写谁赢）。
                // 钉末尾后两处同值：路径放不下时一律显示右半段（文件名）。
                // 聚焦中不钉：本方法在切页回来、静默刷新时都会被调，编辑中把光标拽到末尾会打断正在输入的人。
                // 有 PATH_SCROLL_X 记忆值时仍以记忆值为准（见 applyPathScroll）——这里定的只是没有记忆值、
                // 或框架自己兜底时的落点，不等于"忽略记忆值"。
                if (!field.input.isFocused()) {
                    field.input.setSelection(field.text().length());
                }
                remeasureIfTextChanged(field, before);
                restorePathScroll();
            } else {
                for (int i = 0; i < fields.size(); i++) {
                    Field field = fields.get(i);
                    String before = field.text();
                    field.setValue(value.intAt(i));
                    remeasureIfTextChanged(field, before);
                }
            }
        } finally {
            suppressChange = false;
        }
    }

    /**
     * 读控件当前值。
     *
     * @return {@code null} 表示"还没输完"，此时一律不写盘（空串/不可解析/空路径）
     */
    @Nullable
    private Value readInputs() {
        return readInputs(false);
    }

    /**
     * 读控件当前值。
     *
     * @param fallbackForUnparsed true 时把"还没输完"的输入框退回当前有效值（再退一步是定义默认值），
     *                            使布尔开关单独切换也能写出整键；false 时一个字段没输完就整键不写
     */
    @Nullable
    private Value readInputs(boolean fallbackForUnparsed) {
        if (meta.isPath()) {
            String text = textOf(fields.get(0).input).trim();
            return text.isEmpty() ? null : Value.ofText(text);
        }
        Value current = fallbackForUnparsed ? host.effectiveValue(meta.key) : null;
        int count = fields.size();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            Integer parsed = fields.get(i).value();
            if (parsed == null && !fallbackForUnparsed) {
                return null;
            }
            numbers[i] = parsed != null ? parsed
                    : (current != null && current.size() > i
                            ? current.intAt(i) : meta.fields.get(i).defaultValue);
        }
        return Value.ofNumbers(numbers);
    }

    private void restoreInputs() {
        applyValue(host.diskValue(meta.key));
    }

    private static String textOf(TextInputEditText input) {
        Editable editable = input.getText();
        return editable == null ? "" : editable.toString();
    }

    /** 宽松解析：空串/非数字返回 null（由调用方按"还没输完"处理），超 int 范围时按边界取值。 */
    @Nullable
    private static Integer parseInt(String text) {
        String trimmed = text == null ? "" : text.trim();
        if (trimmed.isEmpty()) {
            return null;
        }
        try {
            long parsed = Long.parseLong(trimmed);
            if (parsed > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (parsed < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) parsed;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final class Watcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            commit(false);
        }
    }

    // ==================== 提交 ====================

    private void commit(boolean fromBlur) {
        if (suppressChange || meta.isSwitch()) {
            return;
        }
        if (!fromBlur && (meta.isPath() || meta.guardrail)) {
            // 输入过程中不落盘：半截路径会被 C 端当真路径去 open()，
            // 护栏键的中间态越界会让 C 端整组拒绝并保留旧值
            return;
        }

        Value raw = readInputs();
        if (raw == null) {
            if (fromBlur) {
                restoreInputs();
                setStatus(control.getContext().getString(R.string.config_input_restored),
                        R.color.state_warn);
            }
            return;
        }

        Assessment assessment = host.store().assess(meta.key, raw);
        Value ui = assessment.uiValue;

        if (meta.guardrail) {
            Accept accept = host.store().daemonAccepts(meta.key, ui);
            if (!accept.accepted) {
                // 不落盘：写进去 C 端也不认，只会造成"界面显示 X、守护进程用 Y"的假象
                if (fromBlur) {
                    String message = control.getContext()
                            .getString(R.string.config_guardrail_rejected, accept.describe());
                    setStatus(message, R.color.state_error);
                    host.notifyUser(message, true);
                }
                return;
            }
            if (fromBlur && accept.degraded) {
                setStatus(accept.describe(), R.color.state_warn);
            }
        }

        if (fromBlur) {
            applyValue(ui);
            if (assessment.changedByClamp && !ui.format().equals(raw.format())) {
                String message = control.getContext().getString(
                        R.string.config_clamped, raw.format(), ui.format());
                setStatus(message, R.color.state_warn);
                host.notifyUser(message, false);
            } else if (meta.isPath() && !assessment.notes.isEmpty()) {
                setStatus(control.getContext().getString(R.string.config_path_note,
                        TextUtils.join("；", assessment.notes)), R.color.state_warn);
            } else if (!meta.guardrail) {
                hideStatus();
            }
        }

        Value onDisk = host.diskValue(meta.key);
        if (onDisk != null && ui.equals(onDisk)) {
            // 值未变则不写：连 mtime 都不碰，避免无谓触发 C 端重载
            host.queue().cancel(meta.key);
            host.onPendingChange();
            return;
        }
        host.queue().schedule(meta.key, ui);
        host.onPendingChange();
    }

    /**
     * 布尔子开关的提交：0/1 只有两个完整状态，切换即排入防抖队列（与整键 switch 同语义）。
     *
     * <p>写的是整键：同一键里数字字段取输入框当前值，输到一半时回退到当前有效值，
     * 绝不把"没输完"当成 0 写下去。
     */
    private void commitBoolField() {
        if (suppressChange || meta.isPath()) {
            return;
        }
        Value raw = readInputs(true);
        if (raw == null) {
            return;
        }
        Value ui = host.store().assess(meta.key, raw).uiValue;
        Value onDisk = host.diskValue(meta.key);
        if (onDisk != null && ui.equals(onDisk)) {
            host.queue().cancel(meta.key);
        } else {
            host.queue().schedule(meta.key, ui);
        }
        host.onPendingChange();
    }

    /** 开关的提交：0/1 只有两个完整状态，切换即排入防抖队列。 */
    static void commitSwitch(@NonNull MaterialSwitch toggle, @NonNull KeyMeta meta,
                             @NonNull Host host) {
        int target = toggle.isChecked() ? 1 : 0;
        Value effective = host.effectiveValue(meta.key);
        if (effective != null && effective.intAt(0) == target) {
            // 程序化回填/重复设置同一值 → 不写
            return;
        }
        Value value = Value.ofInt(target);
        Value onDisk = host.diskValue(meta.key);
        if (onDisk != null && value.equals(onDisk)) {
            host.queue().cancel(meta.key);
        } else {
            host.queue().schedule(meta.key, value);
        }
        host.onPendingChange();
    }

    // ==================== 依赖状态 ====================

    /**
     * 依 {@code requires} 压暗本行。
     *
     * <p>依赖键名取自 {@link KeyMeta#requires}，本类不硬编码任何键名；任一依赖键当前值
     * （取整数值，文件缺失时用定义默认值）为 0 即视为未生效。
     * "未生效"的徽标由 {@link ConfigGroupBinder} 在分组卡头显示一次，故本方法只压暗并回报状态。
     *
     * @return true 表示本行当前未生效（供分组卡头汇总）
     */
    boolean refreshDependencyState() {
        boolean unsatisfied = false;
        for (String dependency : meta.requires) {
            Value value = host.effectiveValue(dependency);
            if (value == null || value.intAt(0) == 0) {
                unsatisfied = true;
                break;
            }
        }
        float alpha = unsatisfied ? dimAlpha : 1f;
        labelView.setAlpha(alpha);
        descView.setAlpha(alpha);
        control.setAlpha(alpha);
        noteView.setAlpha(alpha);
        // 挂到行级的字段说明行不在控制区里，压暗要单独来一遍（否则它比周围亮）
        for (TextView caption : rowLevelCaptions) {
            caption.setAlpha(alpha);
        }
        return unsatisfied;
    }

    // ==================== 状态文字 ====================

    /** 落盘结果反馈（人话来自 {@link ConfigStore.WriteResult#describe()}）。 */
    void setResultStatus(String message, boolean ok) {
        setStatus(message, ok ? R.color.state_ok : R.color.state_error);
    }

    private void setStatus(String message, int colorRes) {
        statusView.setText(message);
        statusView.setTextColor(ContextCompat.getColor(control.getContext(), colorRes));
        statusView.setVisibility(View.VISIBLE);
    }

    private void hideStatus() {
        statusView.setVisibility(View.GONE);
    }
}
