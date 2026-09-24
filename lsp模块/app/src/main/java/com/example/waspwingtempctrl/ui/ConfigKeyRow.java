package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Assessment;
import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个配置键的行：switch / int / multi / path 四种 type 各由一个 {@link Renderer} 渲染，
 * 行骨架（参数名 + 键内控件 + 行级文本）与落盘规则四型共用。
 *
 * <p>键的 label / desc / 单位 / 范围 / 依赖全部来自 {@link KeyMeta}（背后是 assets/params.json），
 * 本类不手抄任何键定义，也不自己解析 params.json。
 *
 * <h3>形态（配合 {@link WrapRowLayout}）</h3>
 * <p>行根是 {@link WrapRowLayout}，子视图分三类，换行全部由容器按这三类标记排（本类不自己算行宽、
 * 不自己判换行）：
 * <ul>
 *   <li><b>参数名</b>（leading）：左起第一段，宽由内容定。</li>
 *   <li><b>键内控件</b>（trailing）：输入框（int / path）、各字段（multi）、开关（switch）——
 *       整段贴行尾，本行剩余宽放不下时整段移到下一行，整行还放不下才在段内折行。</li>
 *   <li><b>行级文本</b>（fullLine）：说明 / 备注 / 状态，以及单值键从字段里挪出来的单位-范围说明，
 *       各自独占一行、按整行宽折行。</li>
 * </ul>
 * 行内垂直居中由容器给（参数名与同一行最高的控件对齐），本类不再自己算盒高与墨迹位移。
 *
 * <h3>字段宽</h3>
 * <p>数值字段的宽 = max(说明文字宽, 当前值文字宽, 最小宽)：值用输入框正文的画笔量，说明用
 * material 渲染它的那档字号量（见 {@link #hintPaint}、{@link #measuredFieldWidth}），
 * 只在建行与值回填/提交时算，不随每次按键重排——
 * 边输边撑宽会让整行跳（值长了框自己横向滚）。
 * path 字段不按内容定宽：它吃满行尾，路径长度不可控，定宽会顶出屏幕。
 *
 * <h3>什么时候落盘（三条规则）</h3>
 * <ul>
 *   <li><b>switch</b>：值只有 0/1，切换即完整 → 立即排入防抖队列。</li>
 *   <li><b>int / multi</b>：每次输入都排入防抖队列（写入前先 {@link ConfigStore#assess} 钳制，
 *       所以磁盘上不会出现越界值）；失焦时把钳制后的值回写控件并提示"原值 → 钳制后"。</li>
 *   <li><b>path</b>：<b>只在失焦/提交时落盘</b>。半截路径会被 C 端当成真路径去 open()，
 *       写坏值的代价高于"少一次即时保存"。</li>
 * </ul>
 *
 * <p>"未生效"的标注只做在分组卡头一次（见 {@link ConfigGroupBinder}），行内只压暗不重复标注。
 */
final class ConfigKeyRow {

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
        /** 承载 {@link #input} 的 OutlinedBox；宽度回写也要改它的 LayoutParams。布尔字段为 null。 */
        final TextInputLayout layout;
        final MaterialSwitch toggle;

        Field(@NonNull View root, @Nullable TextInputEditText input, @Nullable TextInputLayout layout,
              @Nullable MaterialSwitch toggle) {
            this.root = root;
            this.input = input;
            this.layout = layout;
            this.toggle = toggle;
        }

        /** 布尔字段：只有开关、没有输入框，宽度与说明都不适用。 */
        boolean isBool() {
            return layout == null;
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
    private final WrapRowLayout root;
    private final TextView labelView;
    private final TextView descView;
    private final TextView noteView;
    private final TextView statusView;
    /** 整键开关（switch 型键用；其它类型不显示）。 */
    private final MaterialSwitch switchView;
    private final Renderer renderer;
    /** 挂到行级的字段说明行（单值键才有）：它不在尾段里，压暗要单独处理。 */
    private final List<TextView> rowCaptions = new ArrayList<>();
    /** 键内控件的插入位（下标 0 恒是参数名，尾段依次排在它后面、行级文本之前）。 */
    private int tailCount;
    private final float dimAlpha;
    /** 说明的防截断安全量（@dimen/config_hint_slack）：见 {@link #measuredFieldWidth}。 */
    private final int hintFitGuard;
    /** 数值字段的最小宽：见 {@link #measuredFieldWidth}。 */
    private final int minFieldWidth;

    /** true 时忽略控件回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressChange;

    /**
     * @param groupShowsUiOnly 本组卡头已经挂出「界面自用，守护进程不读取」时传 true：
     *                         该标注整组只出现一次，行内不再重复
     */
    static ConfigKeyRow create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                               @NonNull KeyMeta meta, @NonNull ConfigKeyRow.Host host,
                               boolean groupShowsUiOnly) {
        // 行"整行独占"由 item_config_row.xml 根标签上的 app:wrapFullLine 声明（父容器读它当标记），
        // 键内换行交给同一个容器，本类不再向容器声明任何几何。
        WrapRowLayout root = (WrapRowLayout) inflater.inflate(R.layout.item_config_row, parent, false);
        return new ConfigKeyRow(inflater, root, meta, host, groupShowsUiOnly);
    }

    private ConfigKeyRow(LayoutInflater inflater, WrapRowLayout root, KeyMeta meta, Host host,
                         boolean groupShowsUiOnly) {
        this.root = root;
        this.meta = meta;
        this.host = host;
        Resources res = root.getResources();
        dimAlpha = readDimAlpha(res);
        hintFitGuard = res.getDimensionPixelSize(R.dimen.config_hint_slack);
        minFieldWidth = res.getDimensionPixelSize(R.dimen.row_min_height);

        labelView = root.findViewById(R.id.config_key_label);
        descView = root.findViewById(R.id.config_key_desc);
        noteView = root.findViewById(R.id.config_key_note);
        statusView = root.findViewById(R.id.config_key_status);
        switchView = root.findViewById(R.id.config_key_switch);

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
        if (!rowNotes.isEmpty()) {
            noteView.setText(TextUtils.join(" ｜ ", rowNotes));
            noteView.setVisibility(View.VISIBLE);
        }

        renderer = createRenderer();
        renderer.build(inflater);
        alignLabelToInputBox();
    }

    /**
     * 多值键参数名的竖直对齐：字段根比输入框高（下方挂着单位/范围说明行）时，按整行居中会把参数名
     * 带到说明行那一带；改为把它的垂直中心钉在行顶之下"输入框半高"处——行顶即首个字段根顶、
     * 输入框就在字段根顶部，于是参数名中心与首个输入框的框心重合。
     *
     * <p><b>只标多值键</b>，且首个字段必须是输入框型：单值键的说明已挂到行级（见 {@link #placeCaption}），
     * 行高就是输入框高，行内居中本来就对；开关键那行只有开关，居中即对齐开关中心；
     * 首个字段是布尔字段的多值键同理（布尔字段根只有开关、没有输入框与说明行），居中才是对的。
     */
    private void alignLabelToInputBox() {
        if (!meta.isMulti() || meta.fields.get(0).bool) {
            return;
        }
        int boxHalfHeight = root.getResources().getDimensionPixelSize(R.dimen.field_height) / 2;
        root.setVerticalCenterAt(labelView, boxHalfHeight);
    }

    /** 按定义里的 type 选渲染器：一处判断，四种 type 各一份实现（定义里只有这四种，int 是其余情况）。 */
    private Renderer createRenderer() {
        if (meta.isSwitch()) {
            return new SwitchRenderer();
        }
        if (meta.isPath()) {
            return new PathRenderer();
        }
        if (meta.isMulti()) {
            return new MultiRenderer();
        }
        return new IntRenderer();
    }

    @NonNull
    View view() {
        return root;
    }

    @NonNull
    String key() {
        return meta.key;
    }

    // ==================== 四型渲染器 ====================

    /** 键内的渲染面：四种 type 各一份实现，行骨架只按它要控件与值。 */
    private interface Renderer {

        /** 建键内控件并挂到行骨架上（键内控件标 trailing，行级文本标 fullLine）。 */
        void build(@NonNull LayoutInflater inflater);

        /** 程序化回填（不触发写入），并按新值重算一次字段宽。 */
        void applyValue(@NonNull Value value);

        /** 读控件当前值；{@code null} 表示"还没输完"，此时一律不写盘。 */
        @Nullable
        Value read(boolean fallbackForUnparsed);

        /** 边输边落盘？false = 只在失焦/提交时落盘（path：半截路径不写）。 */
        boolean writesWhileTyping();

        /** 跟随依赖压暗的键内控件。 */
        @NonNull
        List<View> dimTargets();
    }

    /** switch 型键：0/1 只有两个完整状态，切换即排入防抖队列（见 {@link #commitSwitch}）。 */
    private final class SwitchRenderer implements Renderer {

        @Override
        public void build(@NonNull LayoutInflater inflater) {
            // 开关是尾段成员：标记写在 item_config_row.xml 的 app:wrapTrailing 上（它与键行同属 XML，
            // 由容器在 inflate 时读出）。动态建出来的字段才需要 setTrailing（见 #addToTail）。
            switchView.setVisibility(View.VISIBLE);
            switchView.setOnCheckedChangeListener((button, checked) -> {
                if (suppressChange) {
                    return;
                }
                commitSwitch(switchView, meta, host);
            });
        }

        @Override
        public void applyValue(@NonNull Value value) {
            suppressChange = true;
            try {
                switchView.setChecked(value.intAt(0) != 0);
            } finally {
                suppressChange = false;
            }
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            // 开关键没有输入框，值由开关本身给、切换即整体提交：不走"读控件"这条路径
            return null;
        }

        @Override
        public boolean writesWhileTyping() {
            return false;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return Collections.singletonList(switchView);
        }
    }

    /** int 型键：一个数值字段；单位 / 范围 / 单位说明挂到行级，按整行宽折行。 */
    private final class IntRenderer implements Renderer {

        private final List<Field> fields = new ArrayList<>();

        @Override
        public void build(@NonNull LayoutInflater inflater) {
            String caption = joinParts(joinParts(meta.unit, rangeText(0)), meta.unitNote);
            fields.add(addNumberField(inflater,
                    root.getContext().getString(R.string.config_hint_value), caption, true));
        }

        @Override
        public void applyValue(@NonNull Value value) {
            applyFieldValues(fields, value);
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            return readFieldValues(fields, fallbackForUnparsed);
        }

        @Override
        public boolean writesWhileTyping() {
            return true;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return fieldDimTargets(fields);
        }
    }

    /** multi 型键：每个字段一个控件（定义里 bool 的字段渲染成开关），说明留在各自字段里跟着自己的框。 */
    private final class MultiRenderer implements Renderer {

        private final List<Field> fields = new ArrayList<>();

        @Override
        public void build(@NonNull LayoutInflater inflater) {
            for (int i = 0; i < meta.fieldCount(); i++) {
                FieldMeta fieldMeta = meta.fields.get(i);
                if (fieldMeta.bool) {
                    fields.add(addBoolField(inflater, fieldMeta));
                    continue;
                }
                // ConfigStore.FieldMeta 没有解析 params.json 的字段级 unitNote，界面不自行读 assets
                // （I1/I3 边界），故多值字段只显示 unit 能拿到的部分。
                fields.add(addNumberField(inflater, fieldMeta.label,
                        joinParts(fieldMeta.unit, rangeText(i)), false));
            }
        }

        @Override
        public void applyValue(@NonNull Value value) {
            applyFieldValues(fields, value);
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            return readFieldValues(fields, fallbackForUnparsed);
        }

        @Override
        public boolean writesWhileTyping() {
            return true;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return fieldDimTargets(fields);
        }
    }

    // ==================== int / multi 共用的字段逻辑 ====================

    /**
     * 把值写进各字段（屏蔽回调，程序化回填不该被当成用户改动），并按新值重算一次字段宽：
     * 值比说明长时框要跟着变宽、比说明短时收回来——只在回填/提交时算，不随每次按键重排。
     */
    private void applyFieldValues(@NonNull List<Field> fields, @NonNull Value value) {
        suppressChange = true;
        try {
            for (int i = 0; i < fields.size(); i++) {
                fields.get(i).setValue(value.intAt(i));
            }
        } finally {
            suppressChange = false;
        }
        for (Field field : fields) {
            if (!field.isBool()) {
                writeWidth(field, measuredFieldWidth(field));
            }
        }
    }

    /**
     * 读各字段的当前值。
     *
     * @param fallbackForUnparsed true 时把"还没输完"的输入框退回当前有效值（再退一步是定义默认值），
     *                            使布尔开关单独切换也能写出整键；false 时一个字段没输完就整键不写
     * @return {@code null} 表示"还没输完"，此时一律不写盘（空串 / 不可解析）
     */
    @Nullable
    private Value readFieldValues(@NonNull List<Field> fields, boolean fallbackForUnparsed) {
        Value current = fallbackForUnparsed ? host.effectiveValue(meta.key) : null;
        int[] numbers = new int[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
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

    /** 跟随依赖压暗的字段控件（布尔字段的开关也在内）。 */
    @NonNull
    private static List<View> fieldDimTargets(@NonNull List<Field> fields) {
        List<View> targets = new ArrayList<>(fields.size());
        for (Field field : fields) {
            targets.add(field.root);
        }
        return targets;
    }

    /** path 型键：单行文本输入框吃满行尾，编辑中不落盘、失焦才排入队列。 */
    private final class PathRenderer implements Renderer {

        private Field field;

        @Override
        public void build(@NonNull LayoutInflater inflater) {
            field = addField(inflater, root.getContext().getString(R.string.config_hint_path),
                    "", false, true);
            // 不按说明/内容定宽：路径长度不可控（默认日志路径 58 字符在 16sp 下约 570dp），
            // 定宽会顶出屏幕，而文字在框里居中、被裁掉的是两端。吃满行尾，放不下由输入框自己横向滚。
            writeWidth(field, ViewGroup.LayoutParams.MATCH_PARENT);
        }

        @Override
        public void applyValue(@NonNull Value value) {
            String path = value.text();
            suppressChange = true;
            try {
                field.setValue(path);
                if (!field.input.isFocused()) {
                    // 光标钉到末尾：setText 会把光标置 0（ArrowKeyMovementMethod.initialize →
                    // Selection.setSelection(text, 0)），而框架随后在自己的 pre-draw 里按"把光标摆进
                    // 可视区"（bringPointIntoView(getSelectionEnd())）摆一次——光标留在 0 就摆到路径左段。
                    // 钉末尾后与下面的 applyPathScroll 同值：路径放不下时一律显示右半段（文件名）。
                    // 聚焦中不钉：本方法在切页回来、静默刷新时都会被调，编辑中拽光标会打断正在输入的人。
                    field.input.setSelection(path.length());
                }
            } finally {
                suppressChange = false;
            }
            field.input.post(this::applyPathScroll);
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            String text = textOf(field.input).trim();
            return text.isEmpty() ? null : Value.ofText(text);
        }

        @Override
        public boolean writesWhileTyping() {
            return false;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return Collections.singletonList(field.root);
        }

        /**
         * 把输入框的横向位置摆到最右端（路径放不下时显示右半段——看得见文件名比看得见
         * {@code /storage/emulated/0/…} 有用）。
         *
         * <p><b>上限为什么不取 {@link Layout#getWidth()}</b>：开了 {@code scrollHorizontally} 的输入框，
         * TextView 传给 Layout 的宽是"无上限"（{@code want = VERY_WIDE = 1MB}，见 {@code TextView#onMeasure}），
         * Layout 的宽因此恒为 1MB、与文本多长无关，文本只占这个宽的中段——拿 1MB 算上限，摆出来的位置
         * 落在文本右侧的大片空白里，框里一个字都画不出来（看着就是个空框）。故上限取
         * {@link Layout#getLineRight}（"该行横向滚动该露出的最右位置"，TextView 自己摆光标用的也是它）
         * 减视图宽：文本右端正好贴住框右沿。
         *
         * <p>摆放时机：值回填后 post 一次。布局还没算出来（{@code mLayout} 为 null、视图宽为 0）就等下一次
         * 回填（切页回来、落盘后的静默刷新都会再来）——新结构不再挂 layout 回调反复重试，故首帧这一次
         * 可能落空、输入框停在路径左段，此时靠上面"光标钉末尾"让框架自己把可视区摆到右段。
         * 聚焦时不动：编辑中位置归用户与光标跟随。
         */
        private void applyPathScroll() {
            TextInputEditText input = field.input;
            if (input.isFocused()) {
                return;
            }
            Layout layout = input.getLayout();
            int viewWidth = input.getWidth();
            if (layout == null || viewWidth <= 0) {
                return;
            }
            int target = Math.max(0, (int) Math.ceil(layout.getLineRight(0)) - viewWidth);
            if (input.getScrollX() != target) {
                input.scrollTo(target, 0);
            }
        }
    }

    // ==================== 键内控件：建、说明落位、量宽 ====================

    /** int / multi 的数值字段：说明 + 单位/范围说明，每次输入都排入防抖队列（失焦时钳制回写）。 */
    private Field addNumberField(@NonNull LayoutInflater inflater, @NonNull String hint,
                                 @NonNull String caption, boolean hoistCaption) {
        Field field = addField(inflater, hint, caption, hoistCaption, false);
        field.input.addTextChangedListener(new Watcher());
        return field;
    }

    /** 布尔字段（multi 键里值为 0/1 的字段）：字段名 + 开关。 */
    private Field addBoolField(@NonNull LayoutInflater inflater, @NonNull FieldMeta fieldMeta) {
        View fieldView = inflater.inflate(R.layout.item_config_field, root, false);
        addToTail(fieldView);

        View switchRow = fieldView.findViewById(R.id.config_field_switch_row);
        switchRow.setVisibility(View.VISIBLE);
        TextView fieldLabel = fieldView.findViewById(R.id.config_field_switch_label);
        if (isPlaceholderLabel(fieldLabel.getContext(), fieldMeta.label)) {
            // 定义里的占位词（见 strings_config.xml）与右边的开关控件本身重复，不再渲染
            fieldLabel.setVisibility(View.GONE);
        } else {
            fieldLabel.setText(fieldMeta.label);
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
        return new Field(fieldView, null, null, boolSwitch);
    }

    /**
     * 建一个输入型字段并挂进尾段。
     *
     * @param hint         输入框的说明（浮起提示），也是字段宽的下限之一
     * @param caption      输入框下方的单位/范围说明；空串 = 不挂
     * @param hoistCaption true = 说明行挂到行级（单值键：框宽只由说明与内容定，可能只有 50dp 宽，
     *                     长说明留在框里要折四五行的独立一列，挂行级后同样内容一两行）
     * @param path         true = 路径输入框（单行文本；失焦才落盘）
     */
    private Field addField(@NonNull LayoutInflater inflater, @NonNull String hint,
                           @NonNull String caption, boolean hoistCaption, boolean path) {
        View fieldView = inflater.inflate(R.layout.item_config_field, root, false);
        addToTail(fieldView);

        TextInputLayout layout = fieldView.findViewById(R.id.config_field_layout);
        TextInputEditText input = fieldView.findViewById(R.id.config_field_input);
        TextView captionView = fieldView.findViewById(R.id.config_field_note);
        layout.setHint(hint);
        if (path) {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        placeCaption(fieldView, captionView, caption, hoistCaption);

        // 失焦即提交：钳制后的值回写控件并落盘（path 的落盘时机也只有这一处）
        input.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                commit(true);
            }
        });
        input.setOnEditorActionListener((v, actionId, event) -> {
            v.clearFocus();
            return true;
        });
        return new Field(fieldView, input, layout, null);
    }

    /** 把键内控件挂到行骨架上：参数名之后、行级文本之前，并标 trailing（与参数名同行的尾段）。 */
    private void addToTail(@NonNull View child) {
        root.addView(child, ++tailCount);
        root.setTrailing(child, true);
    }

    /**
     * 字段说明（单位 / 范围）的落位。
     *
     * <p>多值键：留在自己的字段里，跟着自己的输入框——说明一旦离开框就分不清属于哪个字段。
     * 单值键：挂到行级并按整行宽折行（理由见 {@link #addField} 的 hoistCaption）。
     */
    private void placeCaption(@NonNull View fieldView, @NonNull TextView captionView,
                              @NonNull String caption, boolean hoist) {
        if (caption.isEmpty()) {
            captionView.setVisibility(View.GONE);
            return;
        }
        captionView.setText(caption);
        if (!hoist) {
            return;
        }
        ((ViewGroup) fieldView).removeView(captionView);
        // 插在行级文本的最前面（其后是说明 / 备注 / 状态）：段中插一个非 trailing 的视图会把尾段断成两截
        root.addView(captionView, root.indexOfChild(descView));
        root.setFullLine(captionView, true);
        // 行距由容器的行距给：item_config_field 里那个 topMargin 是"留在字段里"那一路要的
        ViewGroup.LayoutParams lp = captionView.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) lp).topMargin = 0;
        }
        rowCaptions.add(captionView);
    }

    /**
     * 数值字段的宽 = max(说明文字宽, 当前值文字宽, 最小宽)，三者都已含输入框的左右内边距。
     *
     * <p><b>说明为什么按画笔量</b>：Material 的 TextInputLayout 不参与说明测宽
     * （{@code onMeasure} 就是 {@code LinearLayout.onMeasure}，框宽只由 EditText 自己撑出来），
     * 说明只是"画"在框里，画不下就自己打省略号——量一个空框量不到说明，说明经常被截成"每周…"。
     * 量用的是<b>渲染说明的那档字号</b>（见 {@link #hintPaint}：说明是 12sp，
     * 不是输入框正文的 16sp），而不是"把说明临时写进输入框再量框"：
     * 数字型输入框带数字过滤器，非数字文本未必留得住。
     * <b>值</b>用输入框正文的画笔量，同样只量文本，不再"临时改写控件文本再量一次"
     * ——那会打断正在输入的人（文本暂改、光标回跳）。
     *
     * <p><b>末尾那 {@link #hintFitGuard}（1dp）不是余量而是安全量</b>：material 判"说明装不装得下"
     * 用的是「说明可用宽 &lt; 文字实测宽」（拿 {@code paint.measureText} 的浮点值和整数宽比），
     * 框宽贴到 0 余量时一个像素的误差（字距取整、量宽取不取 ceil、字号缩放）就会判成装不下并打上省略号。
     * 留 1dp 把这条临界推开：宁可宽 1dp，也不要说明变成"最高转…"。
     * 这条临界与字号无关（两侧随字号等比缩），且 material 量说明用的是同一个 {@code measureText}
     * （同样的字距、同样的取整规则）——故把字号改小只会更宽裕，不会把这条临界推到不利的一侧。
     *
     * <p><b>最小宽</b>取最小可点目标 @dimen/row_min_height(48dp)：说明与值都很短的键（如 hint "数值" +
     * 值 "0"）不至于缩成一条点不准的窄框。只与说明和内容有关的"无上限"一侧不设钳制：
     * 装不下由容器换行，不为了塞进一行把说明截断。
     */
    private int measuredFieldWidth(@NonNull Field field) {
        Paint valuePaint = field.input.getPaint();
        CharSequence hint = field.layout.getHint();
        int hintWidth = hint == null ? 0 : textWidth(hintPaint(field), hint.toString());
        String value = field.text();
        int valueWidth = value == null ? 0 : textWidth(valuePaint, value);
        int content = Math.max(hintWidth, valueWidth) + hintFitGuard
                + field.input.getPaddingStart() + field.input.getPaddingEnd();
        return Math.max(content, minFieldWidth);
    }

    /** 文本实测宽（向上取整：不足一个像素的余量在中间被吃掉，说明就会打上省略号）。 */
    private static int textWidth(@NonNull Paint paint, @NonNull String text) {
        return (int) Math.ceil(paint.measureText(text));
    }

    /**
     * material 渲染浮起说明用的样式：与 item_config_field.xml 里 TextInputLayout 的 style 必须同源
     * ——说明的字号/字距只挂在这条样式链上（它把 {@code hintTextAppearance} 指到
     * {@code ?attr/textAppearanceBodySmall}），主题上并没有这个项；换样式要两处一起换。
     */
    private static final int HINT_TEXT_STYLE =
            com.google.android.material.R.style.Widget_Material3_TextInputLayout_OutlinedBox;
    /** 从 {@link #HINT_TEXT_STYLE} 里找说明外观的资源 id（{@code hintTextAppearance}）。 */
    private static final int[] HINT_APPEARANCE_ATTR =
            {com.google.android.material.R.attr.hintTextAppearance};
    /** 从说明外观里找的两项：字号、字距（下标 0 / 1，见 {@link #hintPaint}）。 */
    private static final int[] HINT_APPEARANCE_VALUES =
            {android.R.attr.textSize, android.R.attr.letterSpacing};

    /**
     * 量说明文字用的画笔：把输入框自己的画笔（正文 @dimen/config_field_text_size 16sp）复制一份，
     * 再按 material 实际渲染浮起说明用的那档字号与字距改过来——控件自己的 Paint 不动。
     *
     * <p><b>为什么要换字号</b>：说明由 material 的 {@code CollapsingTextHelper} 画，用的是
     * {@code hintTextAppearance}（M3 的 OutlinedBox 样式 = {@code ?attr/textAppearanceBodySmall}，
     * 12sp + letterSpacing 0.0333），与输入框正文的 16sp 不是同一档。拿正文画笔量说明，框会恒比
     * 说明宽出约 1/3，多出来的余量整片堆在右侧（说明在框内左对齐、只有"值"居中，见
     * item_config_field.xml）；字段建行即回填，说明恒处于浮起档，这 1/3 从来没有被用上过。
     *
     * <p><b>为什么字距要一并施加</b>：material 量/画说明的那份 TextPaint 带着说明外观的
     * letterSpacing（{@code CollapsingTextHelper} 的 collapsedLetterSpacing），说明够长时这 0.0333em
     * 约值 3% 的宽度；漏掉它就是把说明量窄，那才是新的截断隐患。
     * 字体不用管：外观里的 fontFamily 就是 sans-serif（m3_ref_typeface_plain_regular），
     * 与输入框的默认字体同一种。
     *
     * <p><b>兜底</b>：样式上取不到 {@code hintTextAppearance}（material 改了这套样式）或读不出字号时，
     * 原样返回那份拷贝——按正文画笔量，即改前的口径，不比改前差（框偏宽，但不会截断说明）。
     */
    private static Paint hintPaint(@NonNull Field field) {
        Paint paint = new Paint(field.input.getPaint());
        Context context = field.layout.getContext();
        TypedArray style = context.obtainStyledAttributes(HINT_TEXT_STYLE, HINT_APPEARANCE_ATTR);
        int appearanceRes;
        try {
            appearanceRes = style.getResourceId(0, 0);
        } finally {
            style.recycle();
        }
        if (appearanceRes == 0) {
            return paint;
        }
        TypedArray appearance = context.obtainStyledAttributes(appearanceRes, HINT_APPEARANCE_VALUES);
        try {
            float textSize = appearance.getDimension(0, 0f);
            if (textSize <= 0f) {
                return paint;
            }
            paint.setTextSize(textSize);
            paint.setLetterSpacing(appearance.getFloat(1, 0f));
        } finally {
            appearance.recycle();
        }
        return paint;
    }

    /**
     * 回写字段宽：字段根与输入框写同一个值（根是 wrap_content 容器，只改框会让根按旧宽测量，
     * 容器的换行判据读的正是整个字段根的宽）。宽没变就什么都不做——值回填会走到这里，
     * 否则形成"回填 → 重写宽 → 再布局 → 再回填"的空转。
     */
    private static void writeWidth(@NonNull Field field, int width) {
        if (field.root.getLayoutParams().width == width
                && field.layout.getLayoutParams().width == width) {
            return;
        }
        field.root.getLayoutParams().width = width;
        field.layout.getLayoutParams().width = width;
        field.layout.requestLayout();
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
        Integer min = meta.min(index);
        Integer max = meta.max(index);
        if (min == null || max == null) {
            return "";
        }
        return root.getContext().getString(R.string.config_range,
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

    /** bool 字段的 label 是占位词时不显示标签：它只说"这里是个开关"，而右边就是开关。 */
    private static boolean isPlaceholderLabel(@NonNull Context context, @NonNull String label) {
        return label.equals(context.getString(R.string.config_bool_label_placeholder));
    }

    // ==================== 值 ⇄ 控件 ====================

    /** 把值写进控件。程序化回填不触发写入；各型渲染器顺带按新值重算字段宽（见 {@link Renderer}）。 */
    void applyValue(@Nullable Value value) {
        if (value == null) {
            return;
        }
        renderer.applyValue(value);
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

    /** int / multi 的输入框每变一次就排入防抖队列（失焦才是"提交"，见 {@link #commit}）。 */
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
        if (suppressChange) {
            return;
        }
        if (!fromBlur && !renderer.writesWhileTyping()) {
            // 输入过程中不落盘：半截路径会被 C 端当真路径去 open()
            return;
        }

        Value raw = renderer.read(false);
        if (raw == null) {
            if (fromBlur) {
                restoreInputs();
                setStatus(root.getContext().getString(R.string.config_input_restored),
                        R.color.state_warn);
            }
            return;
        }

        Assessment assessment = host.store().assess(meta.key, raw);
        Value ui = assessment.uiValue;

        if (fromBlur) {
            applyValue(ui);
            if (assessment.changedByClamp && !ui.format().equals(raw.format())) {
                String message = root.getContext().getString(
                        R.string.config_clamped, raw.format(), ui.format());
                setStatus(message, R.color.state_warn);
                host.notifyUser(message, false);
            } else if (meta.isPath() && !assessment.notes.isEmpty()) {
                setStatus(root.getContext().getString(R.string.config_path_note,
                        TextUtils.join("；", assessment.notes)), R.color.state_warn);
            } else {
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
        if (suppressChange) {
            return;
        }
        Value raw = renderer.read(true);
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
     * 依 {@code requires} 压暗本行（参数名、键内控件、行级文本，含从字段里挪出来的说明行）。
     *
     * <p>依赖键名取自 {@link KeyMeta#requires}，本类不硬编码任何键名；判据见
     * {@link #dependencyUnsatisfied()}。
     * "未生效"的徽标由 {@link ConfigGroupBinder} 在分组卡头显示一次，故本方法只压暗并回报状态。
     *
     * @return true 表示本行当前未生效（供分组卡头汇总）
     */
    boolean refreshDependencyState() {
        boolean unsatisfied = dependencyUnsatisfied();
        float alpha = unsatisfied ? dimAlpha : 1f;
        labelView.setAlpha(alpha);
        descView.setAlpha(alpha);
        noteView.setAlpha(alpha);
        for (View target : renderer.dimTargets()) {
            target.setAlpha(alpha);
        }
        // 挂到行级的字段说明行不在尾段里，压暗要单独来一遍（否则它比周围亮）
        for (TextView caption : rowCaptions) {
            caption.setAlpha(alpha);
        }
        return unsatisfied;
    }

    /**
     * 本键的依赖是否未满足：{@code requires} 里任一键的当前值（取整数值，文件缺失时用定义默认值）
     * 为 0 或取不到值，即为未满足。
     */
    private boolean dependencyUnsatisfied() {
        for (String dependency : meta.requires) {
            Value value = host.effectiveValue(dependency);
            if (value == null || value.intAt(0) == 0) {
                return true;
            }
        }
        return false;
    }

    // ==================== 状态文字 ====================

    /** 落盘结果反馈（人话来自 {@link ConfigStore.WriteResult#describe()}）。 */
    void setResultStatus(String message, boolean ok) {
        setStatus(message, ok ? R.color.state_ok : R.color.state_error);
    }

    private void setStatus(String message, int colorRes) {
        statusView.setText(message);
        statusView.setTextColor(ContextCompat.getColor(root.getContext(), colorRes));
        statusView.setVisibility(View.VISIBLE);
    }

    private void hideStatus() {
        statusView.setVisibility(View.GONE);
    }
}
