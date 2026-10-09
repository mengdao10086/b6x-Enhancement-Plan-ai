package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Assessment;
import com.example.waspwingtempctrl.ConfigStore.ConfText;
import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.OptionMeta;
import com.example.waspwingtempctrl.ConfigStore.UiNote;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 一个配置键的行：switch / int / multi / path / enum / table 六种 type 各由一个 {@link Renderer} 渲染，
 * 行骨架（参数名 + 键内控件 + 行级文本）与落盘规则六型共用。键的 label / desc / 单位 / 范围 / 依赖 /
 * 取值域全部来自 {@link KeyMeta}（背后是 assets/params.json），本类不手抄任何键定义。
 *
 * <p>形态（配合 {@link WrapRowLayout}：参数名 lead、键内控件 trailing、行级文本 fullLine）、
 * 字段宽、说明画笔、落盘四条规则、"未生效"只压暗不重复标注等详见 app 逻辑说明.md §6.1。
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
        /** 字段布局的根（数值 / 路径字段 item_config_field，布尔字段 item_config_field_switch）：
         *  宽度回写要同时改它与其内的输入框。 */
        final View root;
        final TextInputEditText input;
        /** 承载 {@link #input} 的 OutlinedBox；宽度回写也要改它的 LayoutParams。布尔字段为 null。 */
        final TextInputLayout layout;
        final MaterialSwitch toggle;
        /** 说明文字的实测宽（见 {@link #measuredFieldWidth}）：只与说明文本/字号有关，值变了不影响；-1=还没量过。 */
        private int hintWidth = -1;

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

        /** 写值：<b>文本没变就不写回控件</b>（见 {@link #setTextIfChanged}）。 */
        void setValue(int value) {
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_FILL);
            if (toggle != null) {
                toggle.setChecked(value != 0);
            } else {
                setTextIfChanged(input, String.valueOf(value));
            }
            StartupTiming.accEnd(StartupTiming.FORM_SUB_FILL, startedAt);
        }

        /** 写值（路径文本）：同样只在文本真的变了才写回。 */
        void setValue(String text) {
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_FILL);
            setTextIfChanged(input, text);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_FILL, startedAt);
        }

        /**
         * 文本与控件里的一致就什么都不做（{@code TextView.setText} 对同文不短路：照样换 CharSequence、
         * 复位光标并请求重排）。见 app 逻辑说明.md §6.1。
         */
        private static void setTextIfChanged(@NonNull TextInputEditText input, @NonNull String text) {
            if (!text.contentEquals(input.getText())) {
                input.setText(text);
            }
        }
    }

    private final KeyMeta meta;
    private final Host host;
    /** 取视图的来源（预制造优先，取不到现场 inflate）：本类所有控件的唯一取处，见 {@link ViewSource}。 */
    private final ViewSource views;
    private final WrapRowLayout root;
    private final TextView labelView;
    private final TextView descView;
    private final TextView noteView;
    private final TextView statusView;
    /**
     * 整键开关（switch 型键用）：由 {@link SwitchRenderer#build} 建出后挂上尾段
     * （见 item_config_key_switch.xml），非 switch 型键恒 null——它们的行不白建这个控件。
     */
    @Nullable
    private MaterialSwitch switchView;
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

    /** 本行的字段是否走「无浮起说明」那一套几何（int / path）——由 {@link #applyNoHintBoxGeometry} 置位。 */
    private boolean noHintBox;

    /** 本行的字段是否吃满整行（path 的框）——此时参数名与框不在同一行，{@link #alignLabelToField} 不钉框体中心。 */
    private boolean fieldFillsRow;

    /** true 时忽略控件回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressChange;

    /**
     * @param groupShowsUiOnly 本组卡头已经挂出「界面自用，守护进程不读取」时传 true：
     *                         该标注整组只出现一次，行内不再重复
     */
    static ConfigKeyRow create(@NonNull ViewGroup parent, @NonNull KeyMeta meta,
                               @NonNull ConfigKeyRow.Host host, boolean groupShowsUiOnly,
                               @NonNull ViewSource views) {
        // 行"整行独占"由 item_config_row.xml 根标签上的 app:wrapFullLine 声明（父容器读它当标记），
        // 键内换行交给同一个容器，本类不再向容器声明任何几何。
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
        WrapRowLayout root = (WrapRowLayout) views.inflate(R.layout.item_config_row, parent);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
        return new ConfigKeyRow(root, meta, host, groupShowsUiOnly, views);
    }

    private ConfigKeyRow(WrapRowLayout root, KeyMeta meta, Host host, boolean groupShowsUiOnly,
                         ViewSource views) {
        this.root = root;
        this.meta = meta;
        this.host = host;
        this.views = views;
        Resources res = root.getResources();
        dimAlpha = readDimAlpha(res);
        hintFitGuard = res.getDimensionPixelSize(R.dimen.config_hint_slack);
        minFieldWidth = res.getDimensionPixelSize(R.dimen.row_min_height);

        labelView = root.findViewById(R.id.config_key_label);
        descView = root.findViewById(R.id.config_key_desc);
        noteView = root.findViewById(R.id.config_key_note);
        statusView = root.findViewById(R.id.config_key_status);
        // switchView 不在这里取：它由 SwitchRenderer 按需建出（见该类 build）

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
        renderer.build();
        alignLabelToField();
        applySwitchRowGap();
    }

    /**
     * 参数名的竖直对齐：<b>与控件本体的竖直中点对齐，不再考虑浮起说明的高度</b>。
     *
     * <p>有输入框的行（int / multi 数值；参数名与框<b>同行</b>）：把名字的垂直中心钉到框体的几何中点——
     * 框高 = 无 hint 时 {@code @dimen/config_field_nohint_height}(30dp)、有 hint 时 {@code @dimen/field_height}(36dp)；
     * 框顶 = 行顶 + 无 hint 时的 {@code @dimen/config_field_nohint_top_gap}(1dp)（见 {@link #applyNoHintBoxGeometry}）。
     * hint 在不在都不进这个算式：hint 只把框内可视描边下压 ≈7dp，不改控件本身的位置。
     *
     * <p>path 的框吃满整行、独占一行，参数名在它<b>上一行</b>（与框不同行，见 {@link #fieldFillsRow}）——
     * 按行高居中并整体下移 {@code @dimen/config_label_shift}（原 {@code shiftLabelInNonSwitchRow} 的口径，逐值不变）。
     * <b>enum 行不再下移</b>：它的分段开关是 {@code wrap_content} 的控件、与参数名同行，两者都按行高居中即
     * 同心对齐（原先多下移 3dp 正是「默认页面」那一行低一截的原因）。开关行（{@link KeyMeta#isSwitch()}）、
     * 表行、以及首字段为布尔的 multi 不参与对齐。
     */
    private void alignLabelToField() {
        if (meta.isSwitch() || meta.isTable() || (meta.isMulti() && meta.fields.get(0).bool)) {
            return;
        }
        if (fieldFillsRow) {
            labelView.setTranslationY(
                    root.getResources().getDimensionPixelSize(R.dimen.config_label_shift));
            return;
        }
        if (meta.isEnum()) {
            // 分段开关与参数名同行、都按行高居中 → 同心对齐；不再额外下移（见方法注释）
            return;
        }
        int boxTop = noHintBox
                ? root.getResources().getDimensionPixelSize(R.dimen.config_field_nohint_top_gap) : 0;
        int boxHalf = root.getResources().getDimensionPixelSize(
                noHintBox ? R.dimen.config_field_nohint_height : R.dimen.field_height) / 2;
        root.setVerticalCenterAt(labelView, boxTop + boxHalf);
    }

    /**
     * 开关行的上下行距减半：把本行的行距上限写进它在分组卡 body 里的
     * {@link WrapRowLayout.LayoutParams}（{@code setRowGapCap}）。须在挂进 body 之前施加——本构造正是
     * 那一刻（{@code create()} 只 inflate、不 attach，随后由 {@code ConfigGroupBinder} addView）。
     *
     * <p>判定一律用 {@link KeyMeta#isSwitch()}（六型里的 switch 型；multi 里的布尔子字段不算，仍 6dp）。
     * 取 min 的对称压缩由容器完成，故这里只写本行的上限。取值见 @dimen/config_switch_row_gap。
     */
    private void applySwitchRowGap() {
        if (!meta.isSwitch()) {
            return;
        }
        if (root.getLayoutParams() instanceof WrapRowLayout.LayoutParams) {
            ((WrapRowLayout.LayoutParams) root.getLayoutParams()).setRowGapCap(
                    root.getResources().getDimensionPixelSize(R.dimen.config_switch_row_gap));
            root.requestLayout();
        }
    }

    /** 按定义里的 type 选渲染器：一处判断，六种 type 各一份实现（定义里只有这六种，int 是其余情况）。 */
    private Renderer createRenderer() {
        if (meta.isTable()) {
            return new TableRenderer();
        }
        if (meta.isSwitch()) {
            return new SwitchRenderer();
        }
        if (meta.isEnum()) {
            return new EnumRenderer();
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

    // ==================== 六型渲染器 ====================

    /** 键内的渲染面：六种 type 各一份实现，行骨架只按它要控件与值。 */
    private interface Renderer {

        /** 建键内控件并挂到行骨架上（键内控件标 trailing，行级文本标 fullLine）。 */
        void build();

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
        public void build() {
            // 开关是尾段成员，与输入框 / 字段走同一条路：按需建出（item_config_key_switch.xml）后
            // 挂上并标 trailing（见 #addToTail）——非 switch 型的键行因此不再白建一个 MaterialSwitch
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
            View switchRoot = views.inflate(R.layout.item_config_key_switch, root);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
            addToTail(switchRoot);
            switchView = switchRoot.findViewById(R.id.config_key_switch);
            switchView.setVisibility(View.VISIBLE);
            addHintIcon();
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

    /**
     * enum 型键：取值域是定义里的 {@code options}（文本的闭合集合），渲染成多选一的分段开关
     * （{@link MaterialButtonToggleGroup} + {@link MaterialButton}，与曲线页顶部窗口档位同源，复用
     * {@code item_chart_window_button.xml}）。文案取 {@link OptionMeta#label}、取值取 {@link OptionMeta#value}。
     * 磁盘值不在可选项内时<b>一项都不选中</b>。见 app 逻辑说明.md §6.1。
     */
    private final class EnumRenderer implements Renderer {

        private MaterialButtonToggleGroup group;
        /** 按钮 id → 该按钮代表的取值；单选下它就是"当前选中项"的取值表。 */
        private final Map<Integer, String> valueOfButton = new LinkedHashMap<>();

        @Override
        public void build() {
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
            group = (MaterialButtonToggleGroup) views.inflate(R.layout.item_config_enum_group, root);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
            addToTail(group);
            for (OptionMeta option : meta.options) {
                startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
                MaterialButton button = (MaterialButton) views.inflate(
                        R.layout.item_chart_window_button, group);
                StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
                // 按钮的 id 是"取值 ↔ 控件"的唯一纽带（组按 id 报选中项）
                button.setId(View.generateViewId());
                button.setText(option.label);
                valueOfButton.put(button.getId(), option.value);
                group.addView(button);
            }
            group.addOnButtonCheckedListener((toggleGroup, checkedId, isChecked) -> {
                if (suppressChange || !isChecked) {
                    return;
                }
                commitOption(valueOfButton.get(checkedId));
            });
        }

        @Override
        public void applyValue(@NonNull Value value) {
            int id = buttonIdOf(value.text());
            if (id == View.NO_ID) {
                // 取值不在表里：一项都不选中（见类注释），等用户点选
                return;
            }
            suppressChange = true;
            try {
                group.check(id);
            } finally {
                suppressChange = false;
            }
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            String option = valueOfButton.get(group.getCheckedButtonId());
            return option == null ? null : Value.ofText(option);
        }

        @Override
        public boolean writesWhileTyping() {
            return false;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return Collections.singletonList(group);
        }

        /** 取值 → 按钮 id；取值不在定义的可选项内时返回 {@link View#NO_ID}。 */
        private int buttonIdOf(@NonNull String value) {
            for (Map.Entry<Integer, String> entry : valueOfButton.entrySet()) {
                if (entry.getValue().equals(value)) {
                    return entry.getKey();
                }
            }
            return View.NO_ID;
        }
    }

    /** int 型键：一个数值字段；单位 / 范围 / 单位说明挂到行级，按整行宽折行。 */
    private final class IntRenderer implements Renderer {

        private final List<Field> fields = new ArrayList<>();

        @Override
        public void build() {
            String caption = joinParts(joinParts(meta.unit, rangeText(0)), meta.unitNote);
            // 数值字段不设浮起说明：hint「数值」不含信息（空 hint 走 addField 的不设说明分支）
            fields.add(addNumberField("", caption, true));
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
        public void build() {
            for (int i = 0; i < meta.fieldCount(); i++) {
                FieldMeta fieldMeta = meta.fields.get(i);
                if (fieldMeta.bool) {
                    fields.add(addBoolField(fieldMeta));
                    continue;
                }
                // ConfigStore.FieldMeta 没有字段级 unitNote，界面不自行读 assets（I1/I3 边界）
                // 故多值字段只显示 unit 能拿到的部分。
                fields.add(addNumberField(fieldMeta.label,
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
     * 把值写进各字段（屏蔽回调），并按新值重算一次字段宽（只在回填/提交时算，不随每次按键重排）。
     * 见 app 逻辑说明.md §6.1。
     *
     * <p><b>值里没有第 i 个字段时（老配置的行比字段少，如某键后来加过字段）</b>：按本键定义里的默认值
     * 回填，<b>不是 0</b>——否则界面显示 0，用户随手保存一次就把那一项悄悄改写成 0。
     */
    private void applyFieldValues(@NonNull List<Field> fields, @NonNull Value value) {
        suppressChange = true;
        try {
            for (int i = 0; i < fields.size(); i++) {
                int filled = i < value.size() ? value.intAt(i) : meta.defaultValue.intAt(i);
                fields.get(i).setValue(filled);   // 记账在 Field.setValue（值回填槽）
            }
        } finally {
            suppressChange = false;
        }
        for (Field field : fields) {
            if (field.isBool()) {
                continue;
            }
            // 先量宽、再写宽：两段各自成窗、互不嵌套，避免同一段时间被两个细分槽各记一次（合计虚高）
            int width = measuredFieldWidth(field);
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_FILL);
            writeWidth(field, width);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_FILL, startedAt);
        }
    }

    /**
     * 读各字段的当前值。
     *
     * @param fallbackForUnparsed true 时把"还没输完"的输入框退回当前有效值（再退一步是定义默认值），
     *                            使布尔开关单独切换也能写出整键；false 时一个字段没输完就整键不写
     * @return {@code null} 表示"还没输完"，此时一律不写盘
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
        public void build() {
            // 路径字段不设浮起说明：hint「路径」不含信息（空 hint 走 addField 的不设说明分支）
            field = addField("", "", false, true);
            // 不按内容定宽：路径长度不可控（默认日志路径 58 字符约 570dp），定宽会顶出屏幕；
            // 吃满行尾，放不下由输入框自己横向滚
            writeWidth(field, ViewGroup.LayoutParams.MATCH_PARENT);
            fieldFillsRow = true;   // 框独占一行：参数名在其上一行，见 alignLabelToField
        }

        @Override
        public void applyValue(@NonNull Value value) {
            String path = value.text();
            suppressChange = true;
            try {
                field.setValue(path);
                if (!field.input.isFocused()) {
                    // 光标钉到末尾：setText 会把光标置 0，框架随后按"把光标摆进可视区"摆一次，
                    // 留在 0 就摆到路径左段；钉末尾后一律显示右半段（文件名）。聚焦中不钉（编辑中拽光标会打断输入）
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
         * 把路径值摆进框里：把文本行的右沿对到<b>内容右沿</b>（框宽去掉左右内边距），放不下时
         * 自动只露右半段（文件名）。布局还没算出来就等下一次回填；聚焦时不动。
         *
         * <p><b>为什么右沿要对"内容右沿"而不是"框右沿"</b>：{@code scrollTo} 的距离由
         * {@code getLineRight(0)}（文本行右沿）减去目标右沿得来；减<b>框宽</b>会把整段文本多推
         * {@code paddingStart + paddingEnd}（= 16dp）出去，值尾正好挂在框右边线之外。短值（如
         * {@code c0} 约 16dp 宽）被推出大半、只剩首个字符的左半边（"偏右 / 半个字"由此而来）；
         * 长路径则表现为最后几个字符溢出到框外。改减<b>内容宽</b>即归位。见 app 逻辑说明.md §6.1。
         *
         * <p><b>为什么不做"放得下就不滚"（{@code target=0}）</b>：开了 scrollHorizontally 的输入框
         * 交给 Layout 的排版宽是 ~1MB，文本按 {@code textAlignment} 在这片虚拟宽里对齐，故
         * {@code scrollX=0} 落在虚拟宽的最左端、框里一个字都画不出；要露出文本，{@code scrollX} 必须
         * 算到"行右沿 − 内容宽"这个量级。故短值、长值同一算式：短值右沿对齐后整段值完整可见，落点也
         * 与数值框（框架自己把光标带进可视区）一致。
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
            int content = viewWidth - input.getPaddingStart() - input.getPaddingEnd();
            if (content <= 0) {
                return;
            }
            int target = Math.max(0, (int) Math.ceil(layout.getLineRight(0)) - content);
            if (input.getScrollX() != target) {
                input.scrollTo(target, 0);
            }
        }
    }

    /**
     * 表型键（{@code type:"table"}）：簇/点编辑器（{@link KiCutTableEditor}）+ 表下方实时倍率曲线
     * （{@link KiCutChartView}）。值是<b>多行文本</b>（每行一簇），读写都经编辑器；写盘走既有防抖队列，
     * 「值未变不写」与「待写值优先」两套语义原样复用（{@link #commit}）。
     *
     * <p>「当前冷值」的红虚线由 1Hz 的轻量取数刷新（{@link KiCutData#targetCold}），
     * 只在视图可见时读；取不到就不画线，绝不画一个假位置。
     */
    private final class TableRenderer implements Renderer {

        /** 「当前冷值」（红虚线位置）的刷新周期（与数据文件写入节奏同档）。 */
        private static final long TARGET_REFRESH_MS = 1000L;
        /** 编辑中曲线重算的防抖窗口：框内文本停 1 秒才重算（写盘仍走 {@link ConfigWriteQueue} 的 1200ms）。 */
        private static final long REDRAW_DEBOUNCE_MS = 1000L;

        private View block;
        private KiCutTableEditor editor;
        private KiCutChartView chart;
        private int targetCold = -1;

        private final Handler ticker = new Handler(Looper.getMainLooper());
        private final Runnable tick = new Runnable() {
            @Override
            public void run() {
                refreshTargetCold(false);
                ticker.postDelayed(this, TARGET_REFRESH_MS);
            }
        };
        /** 编辑中曲线重算的防抖任务；到点时再查一次「冷值框是否为空」，为空则放弃（见 {@link KiCutTableEditor#hasEmptyCold}）。 */
        private final Runnable redrawTask = new Runnable() {
            @Override
            public void run() {
                if (editor != null && !editor.hasEmptyCold()) {
                    redrawChart();
                }
            }
        };

        @Override
        public void build() {
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
            block = views.inflate(R.layout.item_config_ki_cut, root);
            StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
            addFullLine(block);
            chart = block.findViewById(R.id.ki_cut_chart);
            editor = new KiCutTableEditor(meta, block, new KiCutTableEditor.Listener() {
                @Override
                public void onEdited(@NonNull KiCutTableEditor.Listener.EditKind kind) {
                    if (suppressChange) {
                        return;
                    }
                    switch (kind) {
                        case TYPING:
                            // 编辑中：冷值框为空 → 曲线不重算、配置也不写盘；否则曲线按 1 秒防抖，
                            // 写盘仍走队列的 1200ms 防抖（倍率框为空是合法值，走此正常分支）
                            if (editor.hasEmptyCold()) {
                                cancelRedraw();
                                commit(false);
                            } else {
                                scheduleRedraw();
                                commit(false);
                            }
                            break;
                        case STRUCTURAL:
                            // 增删簇/点：值完整，曲线立刻重算；写盘仍走防抖
                            redrawChart();
                            commit(false);
                            break;
                        case COMMIT:
                            // 失焦：取消未触发的定时器，收敛后立刻重算曲线并立刻写盘
                            // （写盘的"立刻"由 commit(true) 内部的 flushNow 完成，见 ConfigKeyRow#commit）
                            cancelRedraw();
                            redrawChart();
                            commit(true);
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void notifyUser(String message) {
                    host.notifyUser(message, false);
                }
            });
            // 视图在窗口上才起取数：切页/收起/页面销毁时停掉，省下每秒一次的读盘
            block.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    ticker.removeCallbacks(tick);
                    ticker.post(tick);
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    ticker.removeCallbacks(tick);
                    ticker.removeCallbacks(redrawTask);   // 编辑防抖任务随视图一起取消，不对已销毁视图重算
                }
            });
        }

        @Override
        public void applyValue(@NonNull Value value) {
            editor.setClusters(KiCutTable.parseRows(ConfText.splitLines(value.text())));
            refreshTargetCold(true);
            redrawChart();
        }

        @Override
        @Nullable
        public Value read(boolean fallbackForUnparsed) {
            if (!fallbackForUnparsed && editor.hasEmptyCold()) {
                // 冷值框为空 = 编辑中的半截态：不写盘（曲线也不重算，见 onEdited 的 TYPING 分支）
                return null;
            }
            // 否则表随时有完整值（编辑器把非法输入收敛进定义范围）
            return Value.ofText(editor.getValueText());
        }

        @Override
        public boolean writesWhileTyping() {
            return true;
        }

        @Override
        @NonNull
        public List<View> dimTargets() {
            return Collections.singletonList(block);
        }

        /** 依「当前冷值」的当前值重绘曲线。冷值框为空（编辑中的半截态）时不重算，保留上一次的曲线。 */
        private void redrawChart() {
            if (chart == null || block == null || editor == null) {
                return;
            }
            if (editor.hasEmptyCold()) {
                return;
            }
            Context context = block.getContext();
            int coldMax = KiCutData.coldMax(context);
            List<KiCutTable.Cluster> clusters = editor.getClusters();
            chart.setCurves(KiCutChartView.Series.of(clusters, coldMax, KiCutTable.AXIS_UP),
                    KiCutChartView.Series.of(clusters, coldMax, KiCutTable.AXIS_DN),
                    KiCutChartView.Series.of(clusters, coldMax, KiCutTable.AXIS_KDP),
                    coldMax, targetCold, xTicksOf(clusters, coldMax));
        }

        /**
         * 横轴刻度 = 表里各点的冷值 ∪ {coldMax}，去重升序、<b>不抽稀</b>（允许重叠）。
         * 不补 0：曲线本身仍按 0…coldMax 绘制（范围不变），只是 0 处不再画刻度——
         * 若某点的冷值恰是 0，它作为<b>点值</b>自然仍在集合里。超上限的冷值不过滤，交给控件
         * {@code gridX} 钳到右沿。
         */
        @NonNull
        private int[] xTicksOf(@NonNull List<KiCutTable.Cluster> clusters, int coldMax) {
            TreeSet<Integer> ticks = new TreeSet<>();
            ticks.add(coldMax);
            for (KiCutTable.Cluster cluster : clusters) {
                for (KiCutTable.Point point : cluster.points) {
                    ticks.add(point.cold);
                }
            }
            int[] out = new int[ticks.size()];
            int i = 0;
            for (int value : ticks) {
                out[i++] = value;
            }
            return out;
        }

        /** 排一次编辑中的曲线重算（1 秒防抖，重置窗口）。 */
        private void scheduleRedraw() {
            ticker.removeCallbacks(redrawTask);
            ticker.postDelayed(redrawTask, REDRAW_DEBOUNCE_MS);
        }

        /** 取消未触发的曲线重算（失焦提交、或框变空时调）。 */
        private void cancelRedraw() {
            ticker.removeCallbacks(redrawTask);
        }

        /** 读一次「当前冷值」；只有值真的变了（或首次）才重绘。视图不可见时跳过读盘。 */
        private void refreshTargetCold(boolean force) {
            if (block == null || !block.isShown()) {
                return;
            }
            int value = KiCutData.targetCold(block.getContext());
            if (force || value != targetCold) {
                targetCold = value;
                redrawChart();
            }
        }
    }

    // ==================== 键内控件：建、说明落位、量宽 ====================

    /** int / multi 的数值字段：说明 + 单位/范围说明，每次输入都排入防抖队列（失焦时钳制回写）。 */
    private Field addNumberField(@NonNull String hint, @NonNull String caption,
                                 boolean hoistCaption) {
        Field field = addField(hint, caption, hoistCaption, false);
        field.input.addTextChangedListener(new Watcher());
        return field;
    }

    /** 布尔字段（multi 键里值为 0/1 的字段）：字段名 + 开关，取布尔那份字段布局。 */
    private Field addBoolField(@NonNull FieldMeta fieldMeta) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
        View fieldView = views.inflate(R.layout.item_config_field_switch, root);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
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
        // 字段根里只有字段名与开关：没有输入框，宽度回写与单位-范围说明都不适用（input / layout 传 null）
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
    private Field addField(@NonNull String hint, @NonNull String caption,
                           boolean hoistCaption, boolean path) {
        // 数值 / 路径字段取数值那一份字段布局，布尔字段走 addBoolField（两份见 item_config_field*.xml）
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
        View fieldView = views.inflate(R.layout.item_config_field, root);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
        addToTail(fieldView);

        TextInputLayout layout = fieldView.findViewById(R.id.config_field_layout);
        TextInputEditText input = fieldView.findViewById(R.id.config_field_input);
        TextView captionView = fieldView.findViewById(R.id.config_field_note);
        if (hint.isEmpty()) {
            // 无信息字段（int/path）不设浮起说明。setHintEnabled(false) 让 material 的
            // calculateLabelMarginTop() 恒返回 0 → 内层 inputFrame 的 topMargin（OUTLINE 下 =
            // 折叠说明行高/2 ≈7dp）归零 → 框顶回到行顶、框高回到 field_height（这正是"删 hint 后
            // 压掉半个 hint 字高"）。只 setHint(null) 不保证触发 margin 重算，故必须显式关掉。
            layout.setHint(null);
            layout.setHintEnabled(false);
            applyNoHintBoxGeometry(input, layout);
        } else {
            layout.setHint(hint);
        }
        if (path) {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        placeCaption(fieldView, captionView, caption, hoistCaption);

        // 失焦即提交（钳制后的值回写控件并落盘；path 的落盘时机也只有这一处）；获焦即弹参数说明浮窗
        input.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                showHint(fieldView);
            } else {
                commit(true);
                HintOverlay.dismissFor(meta.key);
            }
        });
        input.setOnEditorActionListener((v, actionId, event) -> {
            v.clearFocus();
            return true;
        });
        return new Field(fieldView, input, layout, null);
    }

    /**
     * 无浮起说明的框（int / path）的竖直几何：<b>比有说明的框矮 {@code @dimen/config_field_nohint_height}(30dp)</b>、
     * <b>正文上下等距</b>、框顶与行上界留 {@code @dimen/config_field_nohint_top_gap}(1dp)。由 {@link #addField}
     * 只在空 hint（= 无说明的 int/path）时调用——<b>有 hint 的字段（multi / enum / 表点行）不走这里</b>，
     * 仍用 {@code @dimen/field_height}(36dp) 与 {@code item_config_field.xml} 那套上下不对称内边距，
     * 几何逐值不变。
     *
     * <p>框高从 36dp 压到 30dp（−6dp）：无说明的框不需要给浮起说明留位，行高随之从 ≈37dp 降到 ≈31dp。
     * 上下内边距取与下边同档的 {@code @dimen/config_field_pad_nohint}(2dp)：两者之和 = 4dp，
     * 内容区可用高 = 30 − 4 = 26dp（正文行盒 16sp≈18.75dp 仍居得下）；正文在内容区里居中即框的几何中心，
     * 到上下边框因此等距。算式见 {@code item_config_field.xml} 顶部注释。
     */
    private void applyNoHintBoxGeometry(@NonNull TextInputEditText input,
                                        @NonNull TextInputLayout layout) {
        int pad = root.getResources().getDimensionPixelSize(R.dimen.config_field_pad_nohint);
        input.setPaddingRelative(input.getPaddingStart(), pad, input.getPaddingEnd(), pad);
        noHintBox = true;
        ViewGroup.LayoutParams lp = layout.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) lp;
            mlp.topMargin = root.getResources().getDimensionPixelSize(R.dimen.config_field_nohint_top_gap);
            // 压 6dp：无说明的框不给浮起说明留位，比有说明的框矮一档（@dimen/config_field_nohint_height）
            mlp.height = root.getResources().getDimensionPixelSize(R.dimen.config_field_nohint_height);
            layout.requestLayout();
        }
    }

    /** 把键内控件挂到行骨架上：参数名之后、行级文本之前，并标 trailing（与参数名同行的尾段）。 */
    private void addToTail(@NonNull View child) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_ATTACH);
        root.addView(child, ++tailCount);
        root.setTrailing(child, true);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_ATTACH, startedAt);
    }

    /**
     * 挂一个整行独占的键内控件（表型键的表与曲线图）：排在参数名与其余行级文本之后、按整行宽排版。
     * 与 {@link #addToTail} 的区别是不标 trailing——表是个大块，不该与参数名挤在同一行。
     */
    private void addFullLine(@NonNull View child) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_ATTACH);
        root.addView(child);
        root.setFullLine(child, true);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_ATTACH, startedAt);
    }

    /**
     * 字段说明（单位 / 范围）的落位：多值键留在自己的字段里（说明一旦离开框就分不清属于哪个字段），
     * 单值键挂到行级并按整行宽折行。见 app 逻辑说明.md §6.1。
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
     * 数值字段的宽 = max(说明文字宽, 当前值文字宽, 最小宽)，三者都已含输入框左右内边距。
     * 说明按渲染它的那档字号量（见 {@link #hintPaint}，含字距），末尾 1dp（{@link #hintFitGuard}）是
     * 防省略号的<b>安全量</b>而非余量；说明宽按字段缓存（{@link Field#hintWidth}）；最小宽取
     * @dimen/row_min_height(48dp)，"无上限"一侧不设钳制。见 app 逻辑说明.md §6.1。
     */
    private int measuredFieldWidth(@NonNull Field field) {
        // 说明宽按字段缓存（见 Field#hintWidth）：它只与说明文本和说明字号有关，值怎么变都不影响；
        // 一轮建表要量两遍（建行一遍、上屏一遍），缓存后第二遍只剩"值宽"这一项要实测
        if (field.hintWidth < 0) {
            CharSequence hint = field.layout.getHint();
            field.hintWidth = hint == null ? 0 : measuredTextWidth(hintPaint(field), hint.toString());
        }
        Paint valuePaint = field.input.getPaint();
        String value = field.text();
        int valueWidth = value == null ? 0 : measuredTextWidth(valuePaint, value);
        int content = Math.max(field.hintWidth, valueWidth) + hintFitGuard
                + field.input.getPaddingStart() + field.input.getPaddingEnd();
        return Math.max(content, minFieldWidth);
    }

    /**
     * 文本实测宽，并记账（{@link StartupTiming#FORM_SUB_MEASURE}）。
     *
     * <p>画笔由调用方先备好再传进来（而不是在这里取）：{@link #hintPaint} 自己另记一个槽，
     * 放进本窗口里会让同一段时间被两个细分槽各记一次。
     */
    private static int measuredTextWidth(@NonNull Paint paint, @NonNull String text) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_MEASURE);
        int width = textWidth(paint, text);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_MEASURE, startedAt);
        return width;
    }

    /** 文本实测宽（向上取整：不足一个像素的余量在中间被吃掉，说明就会打上省略号）。 */
    private static int textWidth(@NonNull Paint paint, @NonNull String text) {
        return (int) Math.ceil(paint.measureText(text));
    }

    /**
     * material 渲染浮起说明用的样式：与 item_config_field.xml 里 TextInputLayout 的 style 必须同源
     * （说明的字号/字距只挂在这条样式链上）。换样式要两处一起换。见 app 逻辑说明.md §6.1。
     */
    private static final int HINT_TEXT_STYLE =
            com.google.android.material.R.style.Widget_Material3_TextInputLayout_OutlinedBox;
    /** 从 {@link #HINT_TEXT_STYLE} 里找说明外观的资源 id（{@code hintTextAppearance}）。 */
    private static final int[] HINT_APPEARANCE_ATTR =
            {com.google.android.material.R.attr.hintTextAppearance};
    /** 从说明外观里找的两项：字号、字距（下标 0 / 1，见 {@link #hintPaint}）。 */
    private static final int[] HINT_APPEARANCE_VALUES =
            {android.R.attr.textSize, android.R.attr.letterSpacing};

    /** 说明外观的失效键（密度 × 字体缩放）；{@code -1} = 还没取过。见 {@link #ensureHintStyle}。 */
    private static int hintStyleKey = -1;
    /** 说明的字号：{@code 0} = 取不到，按输入框正文那份画笔量。 */
    private static float hintStyleSize;
    /** 说明的字距。 */
    private static float hintStyleSpacing;

    /**
     * 量说明用的那把画笔（<b>复用一份</b>）。复用安全：{@link #hintPaint} 每次先 {@code set} 成输入框
     * 正文画笔再改字号字距（{@code set} 是拷贝），控件自己的 Paint 不动；只许当场量一次，不可留存。
     */
    private static final Paint HINT_PAINT = new Paint();

    /**
     * 取"说明用多大字号、多少字距"，<b>一轮建表只走一次样式链</b>（原先每字段每次量宽走两趟
     * {@code obtainStyledAttributes}，64 字段×2 遍=256 次）。失效键取"密度 + 字体缩放"；
     * {@link #resetHintStyle()} 另在建表开头清一次，故每轮最多取一次。见 app 逻辑说明.md §6.1。
     */
    private static void ensureHintStyle(@NonNull Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int key = configuration.densityDpi * 31 + Float.floatToIntBits(configuration.fontScale);
        if (key == hintStyleKey) {
            return;
        }
        hintStyleKey = key;
        hintStyleSize = 0f;
        hintStyleSpacing = 0f;
        TypedArray style = context.obtainStyledAttributes(HINT_TEXT_STYLE, HINT_APPEARANCE_ATTR);
        int appearanceRes;
        try {
            appearanceRes = style.getResourceId(0, 0);
        } finally {
            style.recycle();
        }
        if (appearanceRes == 0) {
            return;
        }
        TypedArray appearance = context.obtainStyledAttributes(appearanceRes, HINT_APPEARANCE_VALUES);
        try {
            float textSize = appearance.getDimension(0, 0f);
            if (textSize <= 0f) {
                return;
            }
            hintStyleSize = textSize;
            hintStyleSpacing = appearance.getFloat(1, 0f);
        } finally {
            appearance.recycle();
        }
    }

    /** 丢掉说明外观的缓存（每轮建表开头调一次，与 {@link StartupTiming#accReset()} 同级）。 */
    static void resetHintStyle() {
        hintStyleKey = -1;
    }

    /**
     * 量说明文字用的画笔：把输入框自己的画笔（正文 16sp）复制一份，再按 material 实际渲染浮起说明的
     * 那档字号与字距（12sp + letterSpacing 0.0333）改过来——控件自己的 Paint 不动。样式上取不到
     * {@code hintTextAppearance} 时按正文画笔量（框偏宽但不会截断）。见 app 逻辑说明.md §6.1。
     *
     * <p>返回值是共用的那一份（见 {@link #HINT_PAINT}）：<b>只许当场量一次</b>，不可留存、不可跨字段。
     */
    private static Paint hintPaint(@NonNull Field field) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_PAINT);
        ensureHintStyle(field.layout.getContext());
        HINT_PAINT.set(field.input.getPaint());
        if (hintStyleSize > 0f) {
            HINT_PAINT.setTextSize(hintStyleSize);
            HINT_PAINT.setLetterSpacing(hintStyleSpacing);
        }
        // 记账（旁路）：说明画笔与外观取值这一类的耗时（配色链那一步已随缓存降到每轮一次）
        StartupTiming.accEnd(StartupTiming.FORM_SUB_PAINT, startedAt);
        return HINT_PAINT;
    }

    /**
     * 回写字段宽：字段根与输入框写同一个值（容器换行判据读的是字段根宽）。宽没变就什么都不做——
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
     * 取"未生效"压暗透明度。aapt2 把 {@code <item type="dimen" format="float">} 编成 <b>float 值</b>，
     * {@code getDimension()} 取不到；{@code getFloat()} 要 API 29（minSdk 25），故按 {@code getValue()} 读。
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
            // （这条理由对"空框不写盘"同样成立：半截值别送给 C 端）
            return;
        }

        Value raw = renderer.read(false);
        if (raw == null) {
            if (fromBlur) {
                restoreInputs();
                setStatus(root.getContext().getString(R.string.config_input_restored),
                        R.color.state_warn);
            } else {
                // 空框（"还没输完"）不写盘：顺手撤掉可能已排入的旧待写值，免得它踩着 1200ms 窗口写出去
                host.queue().cancel(meta.key);
                host.onPendingChange();
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
        if (fromBlur) {
            // 失焦立刻写：提交后触发一次冲刷（冲刷"全部"待写键——见 app 逻辑说明.md §3.2 的口径与理由）
            host.queue().flushNow();
        }
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

    /**
     * 分段开关的提交：选中项即完整取值，点选即排入防抖队列。选中值恒在取值域内，故不再过
     * {@link ConfigStore#assess}（其 enum 支路是给"别的调用方递进来的值"兜底的）。见 app 逻辑说明.md §6.1。
     */
    private void commitOption(@Nullable String value) {
        if (suppressChange || value == null) {
            return;
        }
        Value effective = host.effectiveValue(meta.key);
        if (effective != null && value.equals(effective.text())) {
            // 程序化回填/重复选中同一项 → 不写
            return;
        }
        Value next = Value.ofText(value);
        Value onDisk = host.diskValue(meta.key);
        if (onDisk != null && next.equals(onDisk)) {
            host.queue().cancel(meta.key);
        } else {
            host.queue().schedule(meta.key, next);
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
     * 键名取自 {@link KeyMeta#requires}，判据见 {@link #isUnsatisfied}；"未生效"徽标由
     * {@link ConfigGroupBinder} 在分组卡头显示一次，故本方法只压暗并回报状态。
     *
     * @return true 表示本行当前未生效（供分组卡头汇总）
     */
    boolean refreshDependencyState() {
        boolean unsatisfied = isUnsatisfied(meta, host);
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
        // 末尾挂一步：整行显隐由独立判据决定（见 refreshHiddenState），不参与上面的"未生效"结论
        refreshHiddenState();
        return unsatisfied;
    }

    /**
     * 依 {@code hiddenWhen} 整行显隐：这些键中<b>任一</b>当前值为 1 时收起本行（{@link View#GONE}），否则恢复显示。
     *
     * <p><b>与 {@code requires} 的压暗是两件事</b>：压暗表示"未生效但仍在"，本方法表示"当前语境下整行无意义"。
     * 判据取不到值一律按<b>不隐藏</b>——与 {@link #isUnsatisfied} 的"取不到即未满足"刻意相反：定义写错时宁可
     * 多显示一行，也不能把默认该显示的键藏起来。
     *
     * <p>本方法只切可见性：不改压暗、不改「未生效」徽标计数。当前唯一使用者是 {@code UI_DEPLOY_ENTRY}
     * （其 {@code requires} 为空，故徽标不受影响）。
     */
    void refreshHiddenState() {
        for (String dependency : meta.hiddenWhen) {
            Value value = host.effectiveValue(dependency);
            if (value != null && value.intAt(0) != 0) {
                root.setVisibility(View.GONE);
                return;
            }
        }
        root.setVisibility(View.VISIBLE);
    }

    /**
     * 某个键的依赖是否未满足：{@code requires} 里任一键当前值（取整数值，文件缺失时用定义默认值）为 0
     * 或取不到，即为未满足。
     *
     * <p><b>判据只有这一份</b>：行内压暗（{@link #refreshDependencyState()}）与分组卡头那枚「未生效」
     * 徽标都调它。见 app 逻辑说明.md §6.1。
     */
    static boolean isUnsatisfied(@NonNull KeyMeta meta, @NonNull Host host) {
        for (String dependency : meta.requires) {
            Value value = host.effectiveValue(dependency);
            if (value == null || value.intAt(0) == 0) {
                return true;
            }
        }
        return false;
    }

    // ==================== 状态文字 ====================

    /** 落盘**失败**反馈（人话来自 {@link ConfigStore.WriteResult#describe()}）；成功不出声，见 ConfigFormController。 */
    void setErrorStatus(String message) {
        setStatus(message, R.color.state_error);
    }

    private void setStatus(String message, int colorRes) {
        statusView.setText(message);
        statusView.setTextColor(ContextCompat.getColor(root.getContext(), colorRes));
        statusView.setVisibility(View.VISIBLE);
    }

    private void hideStatus() {
        statusView.setVisibility(View.GONE);
    }

    // ==================== 参数说明浮窗 ====================

    /**
     * 开关行标题后的「?」：点了走与输入框获焦<b>完全相同</b>的说明浮窗（见 {@link HintOverlay}）。
     * 作为 leading 子视图插在参数名之后（此刻尾段的开关已在 index 1，插在它前面 → 落在标题右侧、
     * 开关左侧）；不标 trailing，故与标题同行。无新 drawable：用「?」字符 + 边框水波纹。
     */
    private void addHintIcon() {
        Resources res = root.getResources();
        TextView icon = new TextView(root.getContext());
        int box = res.getDimensionPixelSize(R.dimen.config_hint_icon_size);
        icon.setLayoutParams(new ViewGroup.LayoutParams(box, box));
        icon.setText(R.string.config_hint_icon);
        icon.setTextSize(TypedValue.COMPLEX_UNIT_PX, res.getDimension(R.dimen.text_body));
        icon.setGravity(Gravity.CENTER);
        icon.setContentDescription(root.getContext().getString(R.string.config_hint_action));
        icon.setTextColor(ContextCompat.getColor(root.getContext(), R.color.app_on_surface_variant));
        TypedValue ripple = new TypedValue();
        if (root.getContext().getTheme().resolveAttribute(
                android.R.attr.selectableItemBackgroundBorderless, ripple, true)) {
            icon.setBackgroundResource(ripple.resourceId);
        }
        icon.setClickable(true);
        icon.setOnClickListener(v -> showHint(icon));
        root.addView(icon, 1);
        ViewGroup.LayoutParams lp = icon.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) lp).setMarginStart(
                    res.getDimensionPixelSize(R.dimen.space_xs));
        }
    }

    /** 弹参数说明浮窗（锚在触发控件上）。取不到 Activity 时安全跳过，几何与其它功能不受影响。 */
    private void showHint(@NonNull View anchor) {
        Activity activity = activityOf(anchor.getContext());
        if (activity != null) {
            HintOverlay.show(activity, meta, anchor);
        }
    }

    /** 沿 {@link ContextWrapper} 链上溯 Activity（浮层要挂到它的内容根上）；取不到返回 null。 */
    @Nullable
    private static Activity activityOf(@NonNull Context context) {
        Context c = context;
        while (c instanceof ContextWrapper) {
            if (c instanceof Activity) {
                return (Activity) c;
            }
            c = ((ContextWrapper) c).getBaseContext();
        }
        return null;
    }

    /** 说明浮窗的一段：小标题（可为空）+ 正文。 */
    private static final class HintSection {
        final String title;
        final String text;

        HintSection(String title, String text) {
            this.title = title;
            this.text = text;
        }
    }

    /**
     * 参数说明浮窗：点输入框（获焦）或开关行的「?」时，在 Activity 内容根（{@code android.R.id.content}）
     * 上叠一层全屏浮层（压暗 + 说明卡）并渐入。
     *
     * <p>「不影响任何操作」的准确含义是——<b>只有触摸「说明窗口以外」的区域才放行</b>：
     * <ul>
     *   <li>落在<b>说明卡上</b>（含卡内滚动 / 点击）：由卡<b>正常消费</b>，保持显示；</li>
     *   <li>落在<b>触发控件</b>（输入框 /「?」）上：放行（事件落到下面的真实控件），保持显示；</li>
     *   <li>落在<b>别处</b>（含从别处起滑）：放行<b>并</b>渐隐——渐隐与这次操作并行，不吞掉它。</li>
     * </ul>
     * 键盘是另一个窗口，本浮层收不到它的触摸，点键盘不受影响。
     *
     * <p>「放行」靠本浮层在卡片以外<b>不消费</b>触摸（{@link ViewGroup} 会把事件继续派给兄弟子视图）——
     * 这也是不采用 {@code PopupWindow} 的原因：窗外的触摸会被它消费后再消失，下层拿不到这次手势。
     *
     * <p>定位在<b>首次绘制之前</b>完成：挂上去时卡 {@code alpha=0}（不可见），量好尺寸、摆到锚点旁之后
     * 才开始入场动画——绝不让人看到"从左上角闪一下再跳过去"。退场是淡出动画（{@code alpha→0}，结束
     * 之后才 {@code removeView}），不是瞬时消失。
     *
     * <p>实例在进程内至多一个（同一时刻只有一页在操作）；由 {@link #show} 复用/重建，{@link #hide()}
     * 淡出后移除。取不到内容根/锚点时不挂浮层（安全退化）。浮层不请求焦点、不动既有键盘逻辑。
     */
    private static final class HintOverlay {

        /** 入/退场时长（ms），均 ≤300：入场强 ease-out，退场 ease-out。 */
        private static final int IN_MS = 220;
        private static final int OUT_MS = 150;
        /** 入场位移（dp）：从下往上 8dp 浮起；起始缩放 0.98（不从 0 起）。 */
        private static final float IN_TRANSLATE_DP = 8f;
        private static final float IN_SCALE = 0.98f;
        /** 卡宽 = 屏幕宽 × 此比例（4/5）。 */
        private static final float WIDTH_FRACTION = 0.8f;
        /** 卡高上限 = 屏幕高 × 此比例（1/4）；超出由卡内 ScrollView 承接滚动。 */
        private static final float MAX_HEIGHT_FRACTION = 0.25f;

        private static HintOverlay current;

        private final ViewGroup host;
        private final FrameLayout overlay;
        private final View scrim;
        private final View card;
        private final TextView titleView;
        private final LinearLayout bodyView;
        private final ViewTreeObserver.OnScrollChangedListener scrollListener = this::reposition;

        private String key = "";
        private View anchor;
        private ScrollView scrollView;
        private boolean showing;

        /**
         * 弹浮窗：同内容根则复用、换根则重建。{@code activity} 的 {@code android.R.id.content}
         * 取不到即安全跳过。
         */
        static void show(@NonNull Activity activity, @NonNull KeyMeta meta, @NonNull View anchor) {
            ViewGroup host = activity.findViewById(android.R.id.content);
            if (host == null) {
                return;
            }
            if (current == null || current.host != host) {
                if (current != null) {
                    current.removeNow();
                }
                current = new HintOverlay(host, activity);
            }
            current.bind(meta, anchor);
        }

        /** 触发它的那个输入框失焦时收起（键不符则不动）——键盘收起等场景由这里兜底。 */
        static void dismissFor(@NonNull String key) {
            if (current != null && current.showing && key.equals(current.key)) {
                current.hide();
            }
        }

        private HintOverlay(@NonNull ViewGroup host, @NonNull Context context) {
            this.host = host;
            overlay = new FrameLayout(context);
            overlay.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            // 不聚焦、不抢焦点：否则会打断既有键盘/焦点行为
            overlay.setClickable(false);
            overlay.setFocusable(false);
            overlay.setFocusableInTouchMode(false);

            scrim = new View(context);
            scrim.setLayoutParams(new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            scrim.setBackgroundColor(ContextCompat.getColor(context, R.color.config_scrim));
            scrim.setAlpha(0f);
            overlay.addView(scrim);

            card = LayoutInflater.from(context).inflate(R.layout.item_config_hint_popup, overlay, false);
            card.setAlpha(0f);   // 定位完成前完全透明：绝不让人看到中间位置
            overlay.addView(card);
            titleView = card.findViewById(R.id.config_hint_title);
            bodyView = card.findViewById(R.id.config_hint_body);

            overlay.setOnTouchListener(this::onTouch);
            overlay.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    if (current == HintOverlay.this) {
                        unregisterScroll();
                        current = null;
                    }
                }
            });
            host.addView(overlay);
        }

        /** 绑定内容与锚点：换键则换文本，随后重定位（首帧前）并渐入。被再次唤起时先取消上一次动画。 */
        private void bind(@NonNull KeyMeta meta, @NonNull View anchor) {
            // 抢占上一次未完成的入/退场：先取消，免得旧退场的收尾把新浮层移除
            card.animate().cancel();
            scrim.animate().cancel();
            this.key = meta.key;
            this.anchor = anchor;
            titleView.setText(meta.label);
            bodyView.removeAllViews();
            Context ctx = card.getContext();
            List<HintSection> sections = hintSections(meta, ctx);
            for (int i = 0; i < sections.size(); i++) {
                addSection(ctx, sections.get(i), i == 0);
            }
            registerScroll(anchor);
            card.setAlpha(0f);   // 新内容在定位完成前同样不可见
            showing = true;
            overlay.post(this::layoutAndShow);
        }

        /**
         * 触摸分发：只在按下时判定落点。<b>卡片本体正常消费</b>（返回 true，含卡内滚动/点击）；
         * 触发控件上放行、不消失；别处放行并渐隐——返回 false 即「未消费」，事件继续派给下面的
         * 真实视图，原操作照常。注意：卡内（ScrollView/子控件）自己会消费，通常根本到不了这里，
         * 这一支只是"卡内空白处也当卡本体"的兜底。
         */
        private boolean onTouch(View v, MotionEvent ev) {
            if (ev.getActionMasked() != MotionEvent.ACTION_DOWN) {
                return false;
            }
            if (hit(card, ev)) {
                return true;
            }
            if (anchor != null && hit(anchor, ev)) {
                return false;
            }
            hide();
            return false;
        }

        /** 事件坐标落点（窗口坐标）是否在 {@code view} 的窗口矩形内。 */
        private static boolean hit(@NonNull View view, @NonNull MotionEvent ev) {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return false;
            }
            int[] loc = new int[2];
            view.getLocationInWindow(loc);
            float x = ev.getRawX();
            float y = ev.getRawY();
            return x >= loc[0] && x < loc[0] + view.getWidth()
                    && y >= loc[1] && y < loc[1] + view.getHeight();
        }

        /**
         * 摆好后再渐入（首次/换键用；滚动跟随只重定位、不再渐入）。若此刻浮层尺寸还没量出来，就
         * 下一帧再试——期间卡 {@code alpha=0}，用户看不到任何中间位置。
         */
        private void layoutAndShow() {
            if (overlay.getParent() == null || anchor == null) {
                return;
            }
            if (overlay.getWidth() <= 0 || overlay.getHeight() <= 0) {
                overlay.post(this::layoutAndShow);
                return;
            }
            if (reposition()) {
                animateIn();
            }
        }

        /**
         * 量卡、就近锚定（默认贴锚点上方，放不下翻到下方）并摆好：卡宽 = 屏宽 4/5（固定），
         * 卡高 = min(内容自然高, 屏高 1/4)——超出由卡内 ScrollView 承接滚动。返回是否成功摆放。
         */
        private boolean reposition() {
            if (overlay.getParent() == null || anchor == null) {
                return false;
            }
            Resources res = card.getResources();
            int lo = res.getDimensionPixelSize(R.dimen.config_hint_popup_margin);
            int maxW = Math.max(0, Math.round(overlay.getWidth() * WIDTH_FRACTION));
            int maxH = Math.max(0, Math.round(overlay.getHeight() * MAX_HEIGHT_FRACTION));
            // 宽按 EXACTLY 量（固定 4/5 屏宽）；高 UNSPECIFIED 量出自然高后再封"1/4 屏高"的顶
            card.measure(
                    View.MeasureSpec.makeMeasureSpec(maxW, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            int ch = Math.min(card.getMeasuredHeight(), maxH);

            int[] aLoc = new int[2];
            int[] rLoc = new int[2];
            anchor.getLocationInWindow(aLoc);
            overlay.getLocationInWindow(rLoc);
            int ax = aLoc[0] - rLoc[0];
            int ay = aLoc[1] - rLoc[1];
            int offset = res.getDimensionPixelSize(R.dimen.config_hint_popup_offset);
            int left = clamp(ax, lo, Math.max(lo, overlay.getWidth() - lo - maxW));
            int above = ay - offset - ch;
            int top = above >= lo ? above : (ay + anchor.getHeight() + offset);
            top = clamp(top, lo, Math.max(lo, overlay.getHeight() - lo - ch));

            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) card.getLayoutParams();
            lp.width = maxW;
            lp.height = Math.max(0, ch);
            lp.leftMargin = left;
            lp.topMargin = top;
            card.setLayoutParams(lp);
            return true;
        }

        /** 渐入：只动 alpha / translationY / 一次性 scale，强 ease-out。 */
        private void animateIn() {
            float d = overlay.getResources().getDisplayMetrics().density;
            PathInterpolator easeOut = new PathInterpolator(0.05f, 0.7f, 0.1f, 1f);
            card.setAlpha(0f);
            card.setTranslationY(IN_TRANSLATE_DP * d);
            card.setScaleX(IN_SCALE);
            card.setScaleY(IN_SCALE);
            // withEndAction(null)：清掉可能残留的退场收尾（快速"渐隐后又被重新唤起"时，旧收尾会误删浮层）
            card.animate().alpha(1f).translationY(0f).scaleX(1f).scaleY(1f)
                    .setDuration(IN_MS).setInterpolator(easeOut).withEndAction(null).start();
            scrim.animate().alpha(1f).setDuration(IN_MS).setInterpolator(easeOut).start();
        }

        /** 渐隐并移除（与正在进行的手势并行，不阻塞、不吞事件）。 */
        private void hide() {
            if (!showing) {
                return;
            }
            showing = false;
            PathInterpolator easeOut = new PathInterpolator(0.05f, 0.7f, 0.1f, 1f);
            // 收尾先复核 showing：期间若又被 bind() 唤起，就不该把它移除
            card.animate().alpha(0f).setDuration(OUT_MS).setInterpolator(easeOut)
                    .withEndAction(() -> {
                        if (!showing) {
                            remove();
                        }
                    }).start();
            scrim.animate().alpha(0f).setDuration(OUT_MS).setInterpolator(easeOut).start();
        }

        private void remove() {
            unregisterScroll();
            host.removeView(overlay);
            if (current == this) {
                current = null;
            }
        }

        /** 立即移除（换内容根时用，不走退场动画）。 */
        private void removeNow() {
            showing = false;
            unregisterScroll();
            host.removeView(overlay);
            if (current == this) {
                current = null;
            }
        }

        /** 页面滚动（含键盘弹起时的 {@code ImeReveal} 平滑滚动）时跟随重定位。 */
        private void registerScroll(@NonNull View anchor) {
            if (scrollView != null) {
                return;
            }
            ViewParent p = anchor.getParent();
            while (p != null && !(p instanceof ScrollView)) {
                p = p.getParent();
            }
            if (!(p instanceof ScrollView)) {
                return;
            }
            scrollView = (ScrollView) p;
            scrollView.getViewTreeObserver().addOnScrollChangedListener(scrollListener);
        }

        private void unregisterScroll() {
            if (scrollView != null) {
                scrollView.getViewTreeObserver().removeOnScrollChangedListener(scrollListener);
                scrollView = null;
            }
        }

        private void addSection(@NonNull Context ctx, @NonNull HintSection section, boolean first) {
            Resources res = ctx.getResources();
            if (!section.title.isEmpty()) {
                TextView st = new TextView(ctx);
                st.setText(section.title);
                st.setTextAppearance(ctx, R.style.TextAppearance_B6XTempCtrl_Caption);
                st.setTextColor(ContextCompat.getColor(ctx, R.color.brand_primary));
                LinearLayout.LayoutParams slp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                slp.topMargin = first ? 0 : res.getDimensionPixelSize(R.dimen.space_s);
                st.setLayoutParams(slp);
                bodyView.addView(st);
            }
            TextView bt = new TextView(ctx);
            bt.setText(section.text);
            bt.setTextColor(ContextCompat.getColor(ctx, R.color.app_on_surface));
            LinearLayout.LayoutParams blp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            blp.topMargin = section.title.isEmpty()
                    ? (first ? 0 : res.getDimensionPixelSize(R.dimen.space_s))
                    : res.getDimensionPixelSize(R.dimen.space_xs);
            bt.setLayoutParams(blp);
            bodyView.addView(bt);
        }

        /**
         * 浮窗内容：优先用参数定义侧给的 {@code uiNote}（有序的「小标题 + 正文」块）；
         * 缺失/为空时回退到既有字段拼装（作用 = desc；填写指导 = 取值/范围/单位/默认/生效条件/界面自用）。
         * 回退是必需的：K1 未落地 {@code uiNote} 时浮窗不能空白。
         */
        private static List<HintSection> hintSections(@NonNull KeyMeta meta, @NonNull Context ctx) {
            List<HintSection> out = new ArrayList<>();
            if (meta.uiNote != null && !meta.uiNote.isEmpty()) {
                for (UiNote note : meta.uiNote) {
                    out.add(new HintSection(note.title, note.text));
                }
                return out;
            }
            if (!meta.desc.isEmpty()) {
                out.add(new HintSection(ctx.getString(R.string.config_hint_section_desc), meta.desc));
            }
            String guide = fallbackGuide(meta, ctx);
            if (!guide.isEmpty()) {
                out.add(new HintSection(ctx.getString(R.string.config_hint_section_fill), guide));
            }
            return out;
        }

        /** 回退用的「填写指导」：把既有字段拼成一段多行文本。 */
        private static String fallbackGuide(@NonNull KeyMeta meta, @NonNull Context ctx) {
            List<String> parts = new ArrayList<>();
            if (meta.isEnum()) {
                List<String> values = new ArrayList<>();
                for (OptionMeta option : meta.options) {
                    values.add(option.label);
                }
                if (!values.isEmpty()) {
                    parts.add(ctx.getString(R.string.config_hint_values, TextUtils.join(" / ", values)));
                }
            } else if (meta.isPath()) {
                parts.add(ctx.getString(R.string.config_hint_path_type));
            } else if (meta.isSwitch()) {
                parts.add(ctx.getString(R.string.config_hint_switch_type));
            } else if (meta.isMulti()) {
                if (meta.fields != null) {
                    List<String> fields = new ArrayList<>();
                    for (FieldMeta field : meta.fields) {
                        fields.add(field.min != null && field.max != null
                                ? field.label + " " + field.min + "~" + field.max : field.label);
                    }
                    parts.add(ctx.getString(R.string.config_hint_values, TextUtils.join("；", fields)));
                }
            } else {
                Integer min = meta.min(0);
                Integer max = meta.max(0);
                if (min != null && max != null) {
                    parts.add(ctx.getString(R.string.config_range,
                            String.valueOf(min), String.valueOf(max)));
                }
            }
            if (!meta.unit.isEmpty()) {
                parts.add(meta.unit);
            }
            if (!meta.unitNote.isEmpty()) {
                parts.add(meta.unitNote);
            }
            parts.add(ctx.getString(R.string.config_hint_default, meta.defaultValue.format()));
            if (!meta.requires.isEmpty()) {
                parts.add(ctx.getString(R.string.config_hint_requires,
                        TextUtils.join("、", meta.requires)));
            }
            if (!meta.daemonConsumes) {
                parts.add(ctx.getString(R.string.config_ui_only));
            }
            return TextUtils.join("\n", parts);
        }

        private static int clamp(int value, int lo, int hi) {
            return value < lo ? lo : (value > hi ? hi : value);
        }
    }
}
