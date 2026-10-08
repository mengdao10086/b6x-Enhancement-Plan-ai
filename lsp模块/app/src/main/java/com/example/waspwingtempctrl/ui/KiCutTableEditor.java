package com.example.waspwingtempctrl.ui;

import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 分段倍率表的编辑器：以「簇」为块（{@code item_ki_cut_cluster.xml}），块内以「点」为行
 * （{@code item_ki_cut_point.xml}，每点四个数字：冷值 / KDP 倍率 / 升倍率 / 降倍率）。支持增删簇与增删点。
 *
 * <p><b>数据是「值 = 多行文本」</b>（每行一簇、行内四元组重复，见 {@link KiCutTable}）：本类只管把
 * 文本渲染成控件、把控件读回文本；落盘与算法都在别处（{@link com.example.waspwingtempctrl.ConfigStore}
 * 与 {@link KiCutTable}）。点行里四个框的浮起说明直接取定义 {@code rowFields[].label}，不在界面另抄一份；
 * 且<b>只有整张表的第一个点行带说明</b>（第 1 簇第 1 点），其余行不带 hint。
 *
 * <p><b>不打扰正在编辑的用户</b>：{@link #setClusters} 先与控件当前内容比对，一致就什么都不做
 * （同 {@code ConfigKeyRow} 的 setTextIfChanged 口径）——否则每次快照上屏都会重建控件、把光标顶掉。
 * 增删簇/点只在用户点击那一刻重建（那时重建正是预期）。
 */
final class KiCutTableEditor {

    /** 与宿主的交互面：任何一次改动（编辑、增删、失焦）都要重绘曲线并排入写盘。 */
    interface Listener {

        /** 编辑事件类型（决定曲线重算与写盘的时机）。 */
        enum EditKind {
            /** 框内文本变化（编辑中）：曲线按 1 秒防抖重算；写盘仍走 1200ms 防抖队列。 */
            TYPING,
            /** 增删簇/点（值完整）：曲线立刻重算；写盘仍走防抖队列。 */
            STRUCTURAL,
            /** 失焦提交：取消未触发的定时器，收敛后立刻重算曲线并立刻写盘。 */
            COMMIT
        }

        /** 用户改了表（编辑数字、增删簇/点，或失焦提交）。 */
        void onEdited(@NonNull EditKind kind);

        /** 一句人话反馈（命中上限之类）。 */
        void notifyUser(@NonNull String message);
    }

    /** 簇数上限（须与 daemon 的 {@code KI_CUT_MAX_CLUSTERS} 一致——超出部分守护进程会整行忽略）。 */
    static final int MAX_CLUSTERS = 8;
    /** 每簇点数上限。 */
    static final int MAX_POINTS = 32;

    private final KeyMeta meta;
    private final Listener listener;
    private final LayoutInflater inflater;
    private final LinearLayout clustersBox;
    private final List<ClusterBlock> blocks = new ArrayList<>();

    /** true 时忽略控件回调：程序化回填不该被当成用户改动作业。 */
    private boolean suppress;

    KiCutTableEditor(@NonNull KeyMeta meta, @NonNull View root, @NonNull Listener listener) {
        this.meta = meta;
        this.listener = listener;
        this.inflater = LayoutInflater.from(root.getContext());
        this.clustersBox = root.findViewById(R.id.ki_cut_clusters);
    }

    // ==================== 值 ⇄ 控件 ====================

    /**
     * 控件当前内容（每行一簇），<b>逐字段按 {@code rowFields} 的 min/max 收敛</b>：交给曲线预览与
     * 写盘的值恒落在参数定义的值域内，避免「预览/落盘 ≠ daemon（daemon 解析时逐字段钳位）」的背离。
     * <b>显示仍是原文</b>——输入框只在失焦时才纠正（见 {@link #clampOnBlur}）。
     */
    @NonNull
    List<KiCutTable.Cluster> getClusters() {
        return collect(true);
    }

    /** 控件当前内容，<b>不收敛</b>：增删簇/点重建控件时用，保留用户正在输入的原文。 */
    @NonNull
    private List<KiCutTable.Cluster> getClustersRaw() {
        return collect(false);
    }

    private List<KiCutTable.Cluster> collect(boolean clamp) {
        List<KiCutTable.Cluster> out = new ArrayList<>(blocks.size());
        for (ClusterBlock block : blocks) {
            KiCutTable.Cluster cluster = new KiCutTable.Cluster();
            for (PointRow row : block.rows) {
                int cold = parseInt(row.cold, 0);
                int kdp = parseInt(row.kdp, KiCutTable.NEUTRAL);
                int up = parseInt(row.up, KiCutTable.NEUTRAL);
                int dn = parseInt(row.dn, KiCutTable.NEUTRAL);
                // 倍率框为空 = 该轴留空（该点在该轴不作为控制点）：置 skip 位，写回时空 token 原样保留
                int skip = 0;
                if (isEmpty(row.kdp)) {
                    skip |= KiCutTable.SKIP_KDP;
                }
                if (isEmpty(row.up)) {
                    skip |= KiCutTable.SKIP_UP;
                }
                if (isEmpty(row.dn)) {
                    skip |= KiCutTable.SKIP_DN;
                }
                if (clamp) {
                    cold = clampField(cold, 0);
                    kdp = clampField(kdp, 1);
                    up = clampField(up, 2);
                    dn = clampField(dn, 3);
                }
                cluster.points.add(new KiCutTable.Point(cold, kdp, up, dn, skip));
            }
            out.add(cluster);
        }
        return out;
    }

    /** 按 {@code rowFields[idx]} 的 min/max 收敛一个字段（无该字段定义时不收敛）。 */
    private int clampField(int value, int idx) {
        Integer min = limit(idx, true);
        Integer max = limit(idx, false);
        if (min != null && value < min) {
            return min;
        }
        if (max != null && value > max) {
            return max;
        }
        return value;
    }

    /** 控件当前内容 → 落盘/落值文本（多行）。 */
    @NonNull
    String getValueText() {
        return KiCutTable.formatRows(getClusters());
    }

    /**
     * 把一份簇表写进控件。<b>与控件当前内容一致就什么都不做</b>（不重建、不动光标）；
     * 不一致才整表重建（外部重置、切页补读等）。
     */
    void setClusters(@NonNull List<KiCutTable.Cluster> clusters) {
        if (KiCutTable.formatRows(clusters).equals(getValueText())) {
            return;
        }
        rebuild(clusters);
    }

    private void rebuild(@NonNull List<KiCutTable.Cluster> clusters) {
        suppress = true;
        try {
            clustersBox.removeAllViews();
            blocks.clear();
            for (KiCutTable.Cluster cluster : clusters) {
                addClusterBlock(cluster);
            }
            refreshTitles();
            refreshButtons();
        } finally {
            suppress = false;
        }
    }

    // ==================== 增删 ====================

    /** 在 {@code afterIndex} 簇之后插入一个新簇（其后的簇整体下移，行序同步）。 */
    private void onAddCluster(int afterIndex) {
        if (blocks.size() >= MAX_CLUSTERS) {
            listener.notifyUser(clustersBox.getContext().getString(
                    R.string.config_ki_cut_limit_cluster, MAX_CLUSTERS));
            return;
        }
        List<KiCutTable.Cluster> model = getClustersRaw();
        KiCutTable.Cluster fresh = new KiCutTable.Cluster();
        fresh.points.add(newDefaultPoint());
        int at = Math.max(0, Math.min(afterIndex, model.size()));
        model.add(at, fresh);
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    private void onDeleteCluster(int index) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size() || model.size() <= 1) {
            return;   // 至少留一簇：全删会让配置里没有 KI_CUT_N 行，重读时又回落到出厂行
        }
        model.remove(index);
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    private void onAddPoint(int index) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size()) {
            return;
        }
        if (model.get(index).points.size() >= MAX_POINTS) {
            listener.notifyUser(clustersBox.getContext().getString(
                    R.string.config_ki_cut_limit_point, MAX_POINTS));
            return;
        }
        model.get(index).points.add(newDefaultPoint());
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    private void onDeletePoint(int index, int rowIndex) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size()) {
            return;
        }
        List<KiCutTable.Point> points = model.get(index).points;
        if (rowIndex < 0 || rowIndex >= points.size() || points.size() <= 1) {
            return;   // 每簇至少留一个点
        }
        points.remove(rowIndex);
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    /** 新增点的初值：冷值取定义下限（取不到为 0），KDP/升/降都是 100（不削），三轴均非留空。 */
    private KiCutTable.Point newDefaultPoint() {
        return new KiCutTable.Point(minOf(0, 0), KiCutTable.NEUTRAL, KiCutTable.NEUTRAL,
                KiCutTable.NEUTRAL, 0);
    }

    // ==================== 建块 ====================

    private void addClusterBlock(@NonNull KiCutTable.Cluster cluster) {
        View view = inflater.inflate(R.layout.item_ki_cut_cluster, clustersBox, false);
        ClusterBlock block = new ClusterBlock(view);
        boolean firstCluster = blocks.isEmpty();
        blocks.add(block);
        block.deleteButton.setOnClickListener(v -> onDeleteCluster(indexOf(block)));
        block.addPointButton.setOnClickListener(v -> onAddPoint(indexOf(block)));
        // 「添加簇」在每个簇块底部：新簇插在本块之后（不是追加到末尾），其后各簇整体下移
        block.addClusterButton.setOnClickListener(v -> onAddCluster(indexOf(block) + 1));
        for (KiCutTable.Point point : cluster.points) {
            addPointRow(block, point, firstCluster && block.rows.isEmpty());
        }
        clustersBox.addView(view);
    }

    private void addPointRow(@NonNull ClusterBlock block, @NonNull KiCutTable.Point point,
                             boolean showHints) {
        View view = inflater.inflate(R.layout.item_ki_cut_point, block.pointsBox, false);
        PointRow row = new PointRow(view);
        row.cold.setText(String.valueOf(point.cold));
        // 留空轴渲染成空框（与「空 = 留空」一一对应），非留空轴渲染数值
        row.kdp.setText(KiCutTable.isSkipped(point, KiCutTable.AXIS_KDP) ? "" : String.valueOf(point.kdp));
        row.up.setText(KiCutTable.isSkipped(point, KiCutTable.AXIS_UP) ? "" : String.valueOf(point.up));
        row.dn.setText(KiCutTable.isSkipped(point, KiCutTable.AXIS_DN) ? "" : String.valueOf(point.dn));
        applyHints(row, showHints);
        row.cold.addTextChangedListener(watcher());
        row.kdp.addTextChangedListener(watcher());
        row.up.addTextChangedListener(watcher());
        row.dn.addTextChangedListener(watcher());
        row.deleteButton.setOnClickListener(v -> onDeletePoint(indexOf(block), block.rows.indexOf(row)));
        // 失焦才把数字收敛进定义范围（越界/空值都钳回来），免得把非法值写进配置；
        // 聚焦时不动——否则刚点进框就把内容改掉、光标跳位。收敛后交给宿主：取消防抖定时器、
        // 立刻重算曲线并立刻写盘（见 Listener.EditKind.COMMIT）。
        row.cold.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                if (!isEmpty(row.cold)) {
                    clampOnBlur(row.cold, 0);
                }
                // 冷值必填：留空时**不补值、不写盘**，只发 COMMIT——commit 里 read() 见空冷值返回 null，
                // 于是走 restoreInputs() 还原磁盘原值并提示「已恢复」，绝不把空冷值补成下限悄悄写盘。
                listener.onEdited(Listener.EditKind.COMMIT);
            }
        });
        row.kdp.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                clampOnBlur(row.kdp, 1);
                listener.onEdited(Listener.EditKind.COMMIT);
            }
        });
        row.up.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                clampOnBlur(row.up, 2);
                listener.onEdited(Listener.EditKind.COMMIT);
            }
        });
        row.dn.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                clampOnBlur(row.dn, 3);
                listener.onEdited(Listener.EditKind.COMMIT);
            }
        });
        block.rows.add(row);
        block.pointsBox.addView(view);
    }

    /**
     * 四个框的浮起说明取定义里的 {@code rowFields[i].label}（定义没写就不设，不另抄一份文案）。
     * <b>只有整张表的第一个点行</b>才带说明；其余行不设，OutlinedBox 无 hint 时渲染成普通圆角描边、无缺口。
     */
    private void applyHints(@NonNull PointRow row, boolean show) {
        if (!show || meta.rowFields == null) {
            return;
        }
        TextInputLayout[] boxes = {row.coldBox, row.kdpBox, row.upBox, row.dnBox};
        for (int i = 0; i < boxes.length && i < meta.rowFields.size(); i++) {
            FieldMeta field = meta.rowFields.get(i);
            boxes[i].setHint(field.label);
        }
    }

    private void refreshTitles() {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).title.setText(clustersBox.getContext()
                    .getString(R.string.config_ki_cut_cluster_title, i + 1));
        }
    }

    /** 触底按钮置灰：只剩一簇/一点时不能删；到上限时不能再加（「添加簇」按钮每个簇块各一枚）。 */
    private void refreshButtons() {
        boolean multiCluster = blocks.size() > 1;
        boolean canAddCluster = blocks.size() < MAX_CLUSTERS;
        for (ClusterBlock block : blocks) {
            block.deleteButton.setEnabled(multiCluster);
            block.addClusterButton.setEnabled(canAddCluster);
            block.addPointButton.setEnabled(block.rows.size() < MAX_POINTS);
            boolean multiPoint = block.rows.size() > 1;
            for (PointRow row : block.rows) {
                row.deleteButton.setEnabled(multiPoint);
            }
        }
    }

    private int indexOf(@NonNull ClusterBlock block) {
        return blocks.indexOf(block);
    }

    // ==================== 输入处理 ====================

    private TextWatcher watcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!suppress) {
                    listener.onEdited(Listener.EditKind.TYPING);
                }
            }
        };
    }

    /**
     * 是否有<b>冷值框</b>为空（编辑中的半截态）：有则曲线不重算、配置也不写盘（见 {@link Listener}）。
     *
     * <p>倍率框为空是<b>合法值</b>（该轴留空），不算半截态——故此处只看冷值（冷值必填）。
     */
    boolean hasEmptyCold() {
        for (ClusterBlock block : blocks) {
            for (PointRow row : block.rows) {
                if (isEmpty(row.cold)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isEmpty(@NonNull EditText field) {
        Editable editable = field.getText();
        return editable == null || editable.toString().trim().isEmpty();
    }

    /**
     * 失焦处理：可留空字段（{@code rowFields[idx].allowEmpty}）留空时保持为空（合法值，不补值）；
     * 其余字段留空或越界时收敛回 {@code rowFields[idx]} 的 min/max（冷值留空按下限补）。
     */
    private void clampOnBlur(@NonNull EditText field, int idx) {
        if (isEmpty(field)) {
            if (allowEmpty(idx)) {
                return;   // 倍率可留空：保持为空，不补 0 / 不补 min
            }
        }
        int fallback = idx == 0 ? 0 : KiCutTable.NEUTRAL;
        int value = parseInt(field, fallback);
        Integer min = limit(idx, true);
        Integer max = limit(idx, false);
        if (min != null && value < min) {
            value = min;
        }
        if (max != null && value > max) {
            value = max;
        }
        if (!String.valueOf(value).contentEquals(field.getText())) {
            field.setText(String.valueOf(value));
        }
    }

    /** {@code rowFields[idx].allowEmpty}（定义没写或非表键时为 false）。 */
    private boolean allowEmpty(int idx) {
        if (meta.rowFields == null || idx >= meta.rowFields.size()) {
            return false;
        }
        return meta.rowFields.get(idx).allowEmpty;
    }

    @Nullable
    private Integer limit(int idx, boolean min) {
        if (meta.rowFields == null || idx >= meta.rowFields.size()) {
            return null;
        }
        return min ? meta.rowFields.get(idx).min : meta.rowFields.get(idx).max;
    }

    private int minOf(int idx, int fallback) {
        Integer min = limit(idx, true);
        return min != null ? min : fallback;
    }

    /** 宽松解析：空/非数字取回退值（编辑中的中间态不落盘，见 {@link #getClusters}）。 */
    private static int parseInt(@NonNull EditText field, int fallback) {
        Editable editable = field.getText();
        String text = editable == null ? "" : editable.toString().trim();
        if (TextUtils.isEmpty(text)) {
            return fallback;
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    /** 一个点行（四个数字框 + 删除）。 */
    private final class PointRow {
        final View view;
        final EditText cold;
        final EditText kdp;
        final EditText up;
        final EditText dn;
        final TextInputLayout coldBox;
        final TextInputLayout kdpBox;
        final TextInputLayout upBox;
        final TextInputLayout dnBox;
        final View deleteButton;

        PointRow(View view) {
            this.view = view;
            this.cold = view.findViewById(R.id.ki_cut_cold);
            this.kdp = view.findViewById(R.id.ki_cut_kdp);
            this.up = view.findViewById(R.id.ki_cut_up);
            this.dn = view.findViewById(R.id.ki_cut_dn);
            this.coldBox = view.findViewById(R.id.ki_cut_cold_box);
            this.kdpBox = view.findViewById(R.id.ki_cut_kdp_box);
            this.upBox = view.findViewById(R.id.ki_cut_up_box);
            this.dnBox = view.findViewById(R.id.ki_cut_dn_box);
            this.deleteButton = view.findViewById(R.id.ki_cut_point_del);
            this.cold.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.kdp.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.up.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.dn.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }

    /** 一个簇块（表头 + 点行容器 + 底部行：添加点 / 添加簇）。 */
    private final class ClusterBlock {
        final View view;
        final TextView title;
        final LinearLayout pointsBox;
        final MaterialButton addPointButton;
        final MaterialButton addClusterButton;
        final MaterialButton deleteButton;
        final List<PointRow> rows = new ArrayList<>();

        ClusterBlock(View view) {
            this.view = view;
            this.title = view.findViewById(R.id.ki_cut_cluster_title);
            this.pointsBox = view.findViewById(R.id.ki_cut_cluster_points);
            this.addPointButton = view.findViewById(R.id.ki_cut_cluster_add_point);
            this.addClusterButton = view.findViewById(R.id.ki_cut_cluster_add_cluster);
            this.deleteButton = view.findViewById(R.id.ki_cut_cluster_del);
        }
    }
}
