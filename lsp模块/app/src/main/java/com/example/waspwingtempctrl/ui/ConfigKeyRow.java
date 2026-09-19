package com.example.waspwingtempctrl.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.InputType;
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
import java.util.List;

/**
 * 一个配置键的行：switch / int / multi / path 四种 type 共用一份绑定逻辑。
 *
 * <p>键的 label / desc / 单位 / 范围 / 依赖全部来自 {@link KeyMeta}（背后是 assets/params.json），
 * 本类不手抄任何键定义，也不自己解析 params.json。
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
 */
final class ConfigKeyRow {

    /** 行与外界的交互面（由 ConfigFormFragment 实现）。 */
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

    /** 一个输入字段：一个 TextInputEditText 对应值里的一个整数/一段路径文本。 */
    private static final class Field {
        final TextInputEditText input;

        Field(TextInputEditText input) {
            this.input = input;
        }
    }

    private final KeyMeta meta;
    private final Host host;
    private final View root;
    private final View dimContainer;
    private final LinearLayout control;
    private final TextView labelView;
    private final TextView descView;
    private final TextView badgeView;
    private final TextView noteView;
    private final TextView statusView;
    private final MaterialSwitch toggle;
    private final List<Field> fields = new ArrayList<>();
    private final float dimAlpha;

    /** true 时忽略控件回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressChange;

    static ConfigKeyRow create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                               @NonNull KeyMeta meta, @NonNull Host host) {
        View root = inflater.inflate(R.layout.item_config_row, parent, false);
        return new ConfigKeyRow(inflater, root, meta, host);
    }

    private ConfigKeyRow(LayoutInflater inflater, View root, KeyMeta meta, Host host) {
        this.root = root;
        this.meta = meta;
        this.host = host;
        this.dimAlpha = readDimAlpha(root.getResources());

        dimContainer = root.findViewById(R.id.config_key_dim);
        control = root.findViewById(R.id.config_key_control);
        labelView = root.findViewById(R.id.config_key_label);
        descView = root.findViewById(R.id.config_key_desc);
        badgeView = root.findViewById(R.id.config_key_badge);
        noteView = root.findViewById(R.id.config_key_note);
        statusView = root.findViewById(R.id.config_key_status);
        toggle = root.findViewById(R.id.config_key_switch);

        labelView.setText(meta.label);
        if (meta.desc.isEmpty()) {
            descView.setVisibility(View.GONE);
        } else {
            descView.setText(meta.desc);
        }
        badgeView.setContentDescription(root.getContext().getString(R.string.config_badge_inactive_desc));

        List<String> rowNotes = new ArrayList<>();
        if (!meta.daemonConsumes) {
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
            buildFields(inflater);
            control.setVisibility(View.VISIBLE);
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

    /** 分组容器里第一行不画分隔线（组头和它之间已有分隔线）。 */
    void setDividerVisible(boolean visible) {
        root.findViewById(R.id.config_key_divider).setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    // ==================== 控件构建 ====================

    private void buildFields(LayoutInflater inflater) {
        int count = meta.isMulti() ? meta.fieldCount() : 1;
        for (int i = 0; i < count; i++) {
            View fieldView = inflater.inflate(R.layout.item_config_field, control, false);
            if (i > 0) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) fieldView.getLayoutParams();
                params.topMargin = control.getResources().getDimensionPixelSize(R.dimen.space_s);
                fieldView.setLayoutParams(params);
            }
            TextInputLayout layout = fieldView.findViewById(R.id.config_field_layout);
            TextInputEditText input = fieldView.findViewById(R.id.config_field_input);
            TextView note = fieldView.findViewById(R.id.config_field_note);

            String hint;
            String unit;
            String unitNote;
            if (meta.isMulti()) {
                FieldMeta fieldMeta = meta.fields.get(i);
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
            String caption = joinParts(joinParts(unit, rangeText(i)), unitNote);
            if (caption.isEmpty()) {
                note.setVisibility(View.GONE);
            } else {
                note.setText(caption);
            }

            input.addTextChangedListener(new Watcher());
            input.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    commit(true);
                }
            });
            input.setOnEditorActionListener((v, actionId, event) -> {
                v.clearFocus();
                return true;
            });
            fields.add(new Field(input));
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

    /** 把值写进控件。程序化回填不该触发写入，故屏蔽回调。 */
    void applyValue(@Nullable Value value) {
        if (value == null) {
            return;
        }
        suppressChange = true;
        try {
            if (meta.isSwitch()) {
                toggle.setChecked(value.intAt(0) != 0);
            } else if (meta.isPath()) {
                fields.get(0).input.setText(value.text());
            } else {
                for (int i = 0; i < fields.size(); i++) {
                    fields.get(i).input.setText(String.valueOf(value.intAt(i)));
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
        if (meta.isPath()) {
            String text = textOf(fields.get(0).input).trim();
            return text.isEmpty() ? null : Value.ofText(text);
        }
        int count = fields.size();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            Integer parsed = parseInt(textOf(fields.get(i).input));
            if (parsed == null) {
                return null;
            }
            numbers[i] = parsed;
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

    // ==================== 依赖徽标 ====================

    /**
     * 依 {@code requires} 刷新"未生效"徽标与压暗。
     *
     * <p>依赖键名取自 {@link KeyMeta#requires}，本类不硬编码任何键名；任一依赖键当前值
     * （取整数值，文件缺失时用定义默认值）为 0 即视为未生效。
     */
    void refreshDependencyState() {
        boolean unsatisfied = false;
        List<String> missing = new ArrayList<>();
        for (String dependency : meta.requires) {
            Value value = host.effectiveValue(dependency);
            if (value == null || value.intAt(0) == 0) {
                missing.add(dependency);
                unsatisfied = true;
            }
        }
        badgeView.setVisibility(unsatisfied ? View.VISIBLE : View.GONE);
        float alpha = unsatisfied ? dimAlpha : 1f;
        dimContainer.setAlpha(alpha);
        control.setAlpha(alpha);
        noteView.setAlpha(alpha);
        if (unsatisfied) {
            badgeView.setContentDescription(
                    control.getContext().getString(R.string.config_badge_inactive_desc)
                            + "：" + describeMissing(missing));
        } else {
            badgeView.setContentDescription(
                    control.getContext().getString(R.string.config_badge_inactive_desc));
        }
    }

    private String describeMissing(List<String> missing) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < missing.size(); i++) {
            if (i > 0) {
                sb.append("、");
            }
            KeyMeta dependency = host.store().key(missing.get(i));
            sb.append(dependency == null ? missing.get(i) : dependency.label);
        }
        return sb.toString();
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
