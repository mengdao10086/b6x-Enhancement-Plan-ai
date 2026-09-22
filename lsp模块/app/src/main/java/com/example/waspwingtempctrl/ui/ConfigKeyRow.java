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
 *       键内多个字段的输入框宽度按「说明宽 / 内容宽」实测取大者（见 {@link #naturalFieldWidth}），
 *       放不下由键内的 {@code config_key_control} 换行。控制区的内容盒覆盖整行宽、内容从行首起排
 *       （见 {@link #syncControlGeometry}），首行用缩进把字段摆回"参数名右沿 + 间距"，
 *       换行后的行才拿得到整行宽。</li>
 *   <li>multi 键带 {@code fields[].bool} 的字段渲染成开关（值只有 0/1），其余字段仍是输入框；
 *       本键字段会换行时，开关字段独占一行（见 {@link #setBoolFieldsAlone}）。</li>
 *   <li>参数名的竖直对齐：参数名盒默认与同一行第一个输入框同中心；对齐的是开关时（整键 switch、
 *       或控制区第一个字段是布尔字段）盒高改成该控件的实测高，输入框行则给参数名一个纯渲染的
 *       下移量（见 {@link #syncLabelBox}）。</li>
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
    /** 参数名盒（item_config_row.xml 里那个 FrameLayout）：高度与参数名的墨迹位置按它调，见 {@link #syncLabelBox}。 */
    private final View labelBox;
    /** 输入框容器（item_config_row.xml 里的 config_key_control）。类型就是 {@link FlowWrapLayout}：几何按它的能力调。 */
    private final FlowWrapLayout control;
    private final TextView labelView;
    private final TextView descView;
    private final TextView noteView;
    private final TextView statusView;
    private final MaterialSwitch toggle;
    private final List<Field> fields = new ArrayList<>();
    /** 挂到行级的字段说明行（单字段键才有，见 {@link #buildNumberField}）：它不在控制区里，压暗要单独处理。 */
    private final List<TextView> rowLevelCaptions = new ArrayList<>();
    private final float dimAlpha;

    /** 控制区内字段之间的间距 = FlowWrapLayout 的列距（固定 @dimen/space_m），只用来做换行模拟。 */
    private final int fieldGap;
    /** 说明宽末端的防截断安全量（@dimen/config_hint_slack），见 {@link #measureHintWidth}。 */
    private final int hintSlack;
    /** 参数名墨迹的下移量（@dimen/config_label_ink_shift），见 {@link #syncLabelBox}。 */
    private final int labelInkShift;
    /** 参数名盒到控制区的间距：读自 item_config_row.xml 的 layout_marginStart（@dimen/space_s）。 */
    private final int controlGap;

    /** 控制区的首行缩进 = 参数名盒实测宽 + {@link #controlGap}，同时写给容器（见 {@link #syncControlGeometry}）。 */
    private int firstRowIndent;

    /** 控制区内容盒的实际可用宽（= 整行宽）；0 = 还没量到（此时字段宽只按内容定）。 */
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
            // 键行铺满行宽是控制区几何的前提——控制区的宽要等于整行宽（见 syncControlGeometry），
            // 多字段键的内部换行也才有确定的可用宽。
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
        hintSlack = res.getDimensionPixelSize(R.dimen.config_hint_slack);
        labelInkShift = res.getDimensionPixelSize(R.dimen.config_label_ink_shift);

        control = root.findViewById(R.id.config_key_control);
        labelBox = root.findViewById(R.id.config_key_label_box);
        // 控制区到参数名的间距在任何改写前抓一次：syncControlGeometry 会把 marginStart 改成负值
        controlGap = ((ViewGroup.MarginLayoutParams) control.getLayoutParams()).getMarginStart();
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
        // 参数名盒的高与墨迹位置要读对齐控件的实测高（开关 48dp、输入框 36dp），只有布局后才知道
        root.addOnLayoutChangeListener((v, left, top, right, bottom,
                                        oldLeft, oldTop, oldRight, oldBottom) -> syncLabelBox());
        syncLabelBox();
    }

    /**
     * 控制区（输入框容器）的准备：撤掉占位 Space 的 weight、建字段、挂"几何与字段宽重算"的回调。
     *
     * <p>控制区自己带 {@code 0dp + weight=1}（见 item_config_row.xml）只作首帧兜底，
     * 真正定下宽度与起点的是 {@link #syncControlGeometry}。占位 Space 的 weight 不撤，
     * 两者在首帧会各分一半剩余宽。
     *
     * <p>行内靠右对齐也在建字段时定下（见 {@link FlowWrapLayout#setRowAlign}）：数字框整组贴行右界，
     * 与开关键里开关贴行尾的观感一致。只有本键的控制区这么设，容器的缺省仍是贴左界。
     */
    private void prepareControlArea(LayoutInflater inflater) {
        View spacer = root.findViewById(R.id.config_key_spacer);
        ((LinearLayout.LayoutParams) spacer.getLayoutParams()).weight = 0;
        spacer.requestLayout();

        buildFields(inflater);
        control.setVisibility(View.VISIBLE);
        control.setRowAlign(FlowWrapLayout.ROW_ALIGN_END);
        // 控制区的宽与起点由 syncControlGeometry 在首次布局后定下来，字段宽此时要按可用宽重算一次
        control.addOnLayoutChangeListener((v, left, top, right, bottom,
                                           oldLeft, oldTop, oldRight, oldBottom) -> {
            boolean indentChanged = syncControlGeometry();
            int avail = control.getWidth() - control.getPaddingStart() - control.getPaddingEnd();
            if (avail <= 0 || (avail == controlAvail && !indentChanged)) {
                return;
            }
            controlAvail = avail;
            refitFieldWidths();
        });
    }

    /**
     * 让控制区的内容盒覆盖整行宽、内容从行首起排。
     *
     * <p>行内结构是 [参数名盒][0 宽占位 Space][控制区(0dp + weight=1)][开关]，
     * 控制区按 weight 拿到的是「行宽 − 参数名 − {@link #controlGap}」，起点在参数名右沿 + 间距；
     * 这段宽在"本键字段要换行"时不够用（换行后的行只能用同一段窄宽）。做法两条：
     * <ul>
     *   <li>{@code layout_marginStart = −参数名盒实测宽}：LinearLayout 在按 weight 分配前会把
     *       {@code mTotalLength} 加上这个（负的）外边距，摆放时又 {@code childLeft += leftMargin}，
     *       一减一加之后控制区的左边界回到行首（参数名右沿 + 间距 − 参数名宽 = 行首）。</li>
     *   <li>{@code layout_width = 行宽}（= 键行根的实测宽）：只靠负外边距不够——父行是 AT_MOST 测量，
     *       LinearLayout 会把自身宽收敛到内容宽，于是控制区内容比整行窄时就只拿到内容那么宽，
     *       换行后的行仍然只有内容宽。把宽写成行宽后超额空间归零，weight 分到的份额为 0，
     *       控制区的宽就是行宽。</li>
     * </ul>
     *
     * <p><b>首行落点与从前一致</b>：控制区内容盒的起点从「参数名右沿 + 间距」左移到行首，
     * 同时给容器 {@code setFirstRowIndent(参数名宽 + 间距)}，首行的第一个字段仍落在
     * 「参数名右沿 + 间距」上；第二行起才用上整行宽。
     *
     * <p><b>负外边距不是官方支持的用法</b>，风险边界是"首行缩进正好抵消它"：首行的内容从缩进处起排，
     * 不会压到参数名；控制区自己的盒子是透明的（只有它的子视图会画），越过参数名那一段不产生绘制。
     * 本方法每次布局后跑一遍，参数名宽（随字号 / 语言变）一变就跟着更新；算出来的值没变就什么都不做，
     * 免得布局回调自己触发自己。
     *
     * @return 首行缩进是否变了（变了要重算字段宽：首行可用宽随之变）
     */
    private boolean syncControlGeometry() {
        int labelWidth = labelBox.getMeasuredWidth();
        int rowWidth = root.getWidth();
        if (labelWidth <= 0 || rowWidth <= 0) {
            return false;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) control.getLayoutParams();
        if (lp.width != rowWidth || lp.getMarginStart() != -labelWidth) {
            lp.width = rowWidth;
            lp.setMarginStart(-labelWidth);
            // setMarginStart 只记下相对外边距、把结算推给下一次布局前的方向解析，而 LinearLayout
            // 摆放时读的是解析后的 leftMargin。本容器按 LTR 排（见 FlowWrapLayout），这里就把结算结果
            // 写实，免得解析没跟上时控制区还停在参数名右沿、首行又被缩进推 参数名宽 + 间距。
            // 后续解析（setMarginStart 置了待解析标志）算出的仍是这个值，重复无害。
            lp.leftMargin = -labelWidth;
            control.requestLayout();
        }
        int indent = labelWidth + controlGap;
        if (indent == firstRowIndent) {
            return false;
        }
        firstRowIndent = indent;
        control.setFirstRowIndent(indent);
        return true;
    }

    /**
     * 参数名盒的高度与参数名墨迹的位置（每次行布局后跑一遍，值没变就什么都不做）。
     *
     * <p><b>高度</b>：参数名盒缺省 @dimen/field_height(36dp)、盒内垂直居中、盒在行内贴顶，
     * 于是参数名的中心与「同一行第一个输入框」的中心重合（见 item_config_row.xml）。
     * 开关型键没有输入框，与参数名对齐的是开关本身，而开关的实测高是 48dp（M3 最小高）：
     * 盒高仍是 36dp、盒又贴顶时，参数名中心比开关中心高 (48 − 36) / 2 = 6dp。故：
     * <ul>
     *   <li>整键 switch：盒高 = 开关实测高；</li>
     *   <li>控制区第一个字段是布尔字段：盒高 = 该字段根的实测高（布尔字段根只有开关单元格、
     *       没有下方说明行）；</li>
     *   <li>其余（含 path）：盒高保持 36dp，改用下面的渲染位移。</li>
     * </ul>
     *
     * <p><b>墨迹位置</b>：其余键与参数名对齐的是输入框（OutlinedBox 36dp），但输入框的正文落点
     * 比框的几何中心低 1.5dp（上下内边距不对称，算式见 @dimen/config_field_pad_top），
     * 参数名盒的中心却仍在几何中心上，实测差 3dp 上下（去掉说明后量 36dp 框的上下边框之间 101px，
     * 参数名墨迹中心比其正中间高 11px；用开关墨迹定标——scale 0.75 后 24dp = 84px——得
     * 1dp ≈ 3.5px，11px ≈ 3.1dp，两行分别量得 11.0px / 10.5px）。用 {@code setTranslationY} 补：
     * 纯渲染位移，不改盒高、不参与测量，免得把行高撑大 3dp（改内边距或外边距都会）。
     *
     * <p>盒高改的是 LayoutParams，不 {@code requestLayout} 不会重排；两处都只在值真的变了才写，
     * 否则布局回调里的回写会无限触发自己。
     */
    private void syncLabelBox() {
        View anchor = null;
        if (meta.isSwitch()) {
            // 开关键：与参数名对齐的就是开关本身
            anchor = toggle;
        } else if (!fields.isEmpty() && fields.get(0).layout == null) {
            // 控制区第一个字段是布尔字段：对齐的是那个字段根（只有开关单元格，没有说明行）
            anchor = fields.get(0).root;
        }
        int height = anchor == null ? 0 : anchor.getMeasuredHeight();
        ViewGroup.LayoutParams lp = labelBox.getLayoutParams();
        if (height > 0 && lp.height != height) {
            lp.height = height;
            labelBox.requestLayout();
        }
        // 盒高跟着对齐控件走时，盒中心已与控件中心重合，不再需要位移
        float shift = anchor == null ? labelInkShift : 0f;
        if (labelView.getTranslationY() != shift) {
            labelView.setTranslationY(shift);
        }
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

    /** 数值/路径字段：宽度由 {@link #refitFieldWidths} 按说明与内容实测，高度统一 @dimen/field_height。 */
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
     * 按最终宽度重算所有字段的宽度（建行后、首次布局后、值回填后各算一次），
     * 并据此判定布尔字段要不要独占一行（见 {@link #setBoolFieldsAlone}）。
     *
     * <p><b>数值字段</b>：宽 = {@link #naturalFieldWidth}（说明宽与内容宽的较大者）。
     * 宽度不再与可用宽相关——从前那套"超额就从最宽的往下削、每个字段守住自己那道地板"已去掉：
     * 框宽只由说明与内容决定，一行装不下就交给流式容器换行，不会为了塞进一行把说明截成省略号。
     * 唯一与可用宽有关的是下面那道安全钳制。
     *
     * <p><b>安全钳制</b>：说明或值特别长时框会越出行右边界被父容器裁掉，故把每段宽度钳到
     * {@link #firstRowAvail}（首行可用宽）。首行是各行里最窄的一条（缩进占掉参数名宽 + 间距），
     * 钳到它即可保证任何一行都不越界。
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
            return;                             // path 键只有一个字段、没有布尔字段，不涉及独占行
        }
        int limit = firstRowAvail();
        // 第一行装填模拟：数值字段用它刚写下的宽，布尔字段只能取实测宽（wrap_content）
        int used = 0;
        boolean first = true;
        for (Field field : fields) {
            int width;
            if (field.layout == null) {
                width = field.root.getMeasuredWidth();      // 布尔字段：不参与分配
            } else {
                width = naturalFieldWidth(field);
                if (limit > 0) {
                    width = Math.min(width, limit);
                }
                writeWidth(field, width);
            }
            used += (first ? 0 : fieldGap) + width;
            first = false;
        }
        setBoolFieldsAlone(controlAvail > 0 && firstRowIndent + used > controlAvail);
    }

    /**
     * 首行可用宽 = 控制区内容宽 − 首行缩进。
     *
     * <p>控制区的宽等于整行宽（见 {@link #syncControlGeometry}），故它同时也是"换行后各行能用到的宽"；
     * 首行被缩进吃掉一段，是各行里最窄的。
     *
     * @return 0 表示可用宽还不知道（控制区还没布局过），此时不钳
     */
    private int firstRowAvail() {
        if (controlAvail <= 0) {
            return 0;
        }
        return Math.max(0, controlAvail - firstRowIndent);
    }

    /**
     * 多值键的开关（布尔字段）在本键字段会换行时独占一行。
     *
     * <p>判定见 {@link #refitFieldWidths}：首行缩进 + Σ字段宽 + 字段间距 &gt; 控制区内容宽，
     * 就是流式容器会把字段挤到第二行（与 {@link FlowWrapLayout} 的换行判据同一口径）。
     * 理由：开关与数字框同行时，数字框被挤走后那一行只剩开关，独占一行则本键的开关一律落在行首、
     * 数字框整组从下一行起排，与"参数名 + 右侧开关"的其它键观感一致。
     */
    private void setBoolFieldsAlone(boolean alone) {
        for (Field field : fields) {
            if (field.layout == null) {
                control.setAloneInRow(field.root, alone);
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

    /**
     * 输入框的自然宽度 = max(说明宽, 内容宽)。两者都已含输入框的左右内边距，故这里既不再加余量，
     * 也不再有下限与上限（{@code config_field_min_width} / {@code config_field_max_width} 已删）。
     * path 键不走这里（它按 MATCH_PARENT 吃掉控制区剩余宽，见 {@link #refitFieldWidths}）。
     *
     * <p><b>为什么说明要单独量</b>：Material 的 TextInputLayout 不参与说明的测宽
     * （{@code onMeasure} 就是 {@code LinearLayout.onMeasure}，框宽只由 EditText 自己撑出来），
     * 说明只是"画"在框里/框顶，画不下就自己打省略号——量 {@code text=""} 的框量不到说明，
     * 说明经常被截成"每周…"。故这里按说明文字自己算一次（见 {@link #measureHintWidth}），
     * 与内容宽取大者。
     *
     * <p><b>为什么要量两次</b>：说明与内容不会同时占位，同一份控件量不出这两个宽度，
     * 只能各量一次取大者。内容宽不再多带尾串（从前带 "aa" 是给"再多敲一位"留可见余量，
     * 但那让每个框都白宽一截）：宽度只认说明与内容本身，说明那一侧另有 {@link #hintSlack}
     * 的防截断安全量。
     *
     * <p><b>为什么不按当前值实时算</b>：值一变宽度就跟着变，边输边跳——旧 WebUI 的
     * "改参不被撑宽"就是这个意思。宽度只在建行与值回填（{@link #applyValue}）时定。
     */
    private int naturalFieldWidth(Field field) {
        CharSequence hint = field.layout.getHint();
        int hintWidth = hint == null ? 0 : measureHintWidth(field, hint.toString());
        String text = field.text();

        // 量宽要临时改写输入框文本，必须屏蔽回调（否则等于程序化了用户输入），量完恢复原文本。
        // suppressChange 存旧值再恢复：调用方（applyValue 的循环）可能已开着抑制，不能一把关掉。
        boolean previous = suppressChange;
        suppressChange = true;
        // 光标位置也要原样放回：重算宽度会在用户正打字时发生（控制区宽变），而 setText 会把光标带回开头
        int selectionStart = field.input.getSelectionStart();
        int selectionEnd = field.input.getSelectionEnd();
        int contentWidth;
        try {
            contentWidth = measureWithText(field, text);
        } finally {
            field.input.setText(text);
            if (selectionStart >= 0) {
                field.input.setSelection(Math.min(selectionStart, text.length()),
                        Math.min(Math.max(selectionEnd, selectionStart), text.length()));
            }
            suppressChange = previous;
        }
        return Math.max(hintWidth, contentWidth);
    }

    /**
     * 说明文字所需的框宽 = 说明文字宽 + {@link #hintSlack} + 输入框左右内边距。
     *
     * <p>用输入框自己的画笔量文字（占位说明用的就是它的字号与字重，见
     * {@code TextInputLayout#setEditText}），而不是"把说明写进输入框再量框"——数字型输入框带
     * 数字过滤器，程序化写进去的非数字文本未必留得住，量出来可能是个空框。
     * 内边距取输入框当前值（就是 item_config_field.xml 里写的那两个），
     * 因为说明的可用宽正是"框宽 − 内边距"。
     *
     * <p><b>末尾那 {@link #hintSlack}（1dp）不是余量而是安全量</b>：material 判"说明装不装得下"
     * 用的是「说明可用宽 &lt; 文字实测宽」（拿 {@code paint.measureText} 的浮点值和整数宽比），
     * 框宽贴到 0 余量时一个像素的误差（字距取整、这里取不取 {@code ceil}、字号缩放）就会判成装不下
     * 并打上省略号。留 1dp 把这条临界推开：宁可宽 1dp，也不要说明变成"最高转…"。
     */
    private int measureHintWidth(Field field, String hintText) {
        TextPaint paint = field.input.getPaint();
        return (int) Math.ceil(paint.measureText(hintText)) + hintSlack
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
        // 一个字段变宽会改整键的排布（是否换行、布尔字段要不要独占一行），故整键重算，不是只算这一个
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
