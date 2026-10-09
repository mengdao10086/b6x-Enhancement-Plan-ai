package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 分段倍率表的编辑器：以「簇」为块（{@code item_ki_cut_cluster.xml}），块内以「点」为行
 * （{@code item_ki_cut_point.xml}，每点四个数字：冷值 / KDP 倍率 / 升倍率 / 降倍率）。支持增删簇、增删点、
 * 拆分簇。
 *
 * <p><b>数据是「值 = 多行文本」</b>（每行一簇、行内四元组重复，见 {@link KiCutTable}）：本类只管把
 * 文本渲染成控件、把控件读回文本；落盘与算法都在别处（{@link com.example.waspwingtempctrl.ConfigStore}
 * 与 {@link KiCutTable}）。点行里四个框的浮起说明直接取定义 {@code rowFields[].label}，不在界面另抄一份；
 * 且<b>只有整张表的第一个点行带说明</b>（第 1 簇第 1 点），其余行不带 hint。
 *
 * <p><b>不打扰正在编辑的用户</b>：{@link #setClusters} 先与控件当前内容比对，一致就什么都不做
 * （同 {@code ConfigKeyRow} 的 setTextIfChanged 口径）——否则每次快照上屏都会重建控件、把光标顶掉。
 * 增删簇/点/拆分只在用户点击那一刻重建（那时重建正是预期）。
 *
 * <p><b>每簇行间与首尾的高亮横线</b>（{@code item_ki_cut_insert_line.xml}）是真实兄弟视图，与点行不重叠，
 * 故触摸天然无冲突。<b>横线默认隐藏</b>，只有进入两种模式之一才显示：
 * <ul>
 *   <li><b>插入态</b>（点「添加点」）：点线＝在该处插入一条「四元组全空」的新行（不再直接追加到末尾）；</li>
 *   <li><b>拆分态</b>（点「拆分簇」）：点线＝在此常规拆分，点行本身＝该行由上下两簇共享。</li>
 * </ul>
 * 两种模式互斥；再点同一按钮、点表内空白处、或发生增删/拆分即退出。整表在 0 簇时显示「还没有簇」空态与「添加簇」。
 */
final class KiCutTableEditor {

    /** 与宿主的交互面：任何一次改动（编辑、增删、拆分、失焦）都要重绘曲线并排入写盘。 */
    interface Listener {

        /** 编辑事件类型（决定曲线重算与写盘的时机）。 */
        enum EditKind {
            /** 框内文本变化（编辑中）：曲线按 1 秒防抖重算；写盘仍走 1200ms 防抖队列。 */
            TYPING,
            /** 增删簇/点、拆分（值完整）：曲线立刻重算；写盘仍走防抖队列。 */
            STRUCTURAL,
            /** 失焦提交：取消未触发的定时器，收敛后立刻重算曲线并立刻写盘。 */
            COMMIT
        }

        /** 用户改了表（编辑数字、增删簇/点、拆分，或失焦提交）。 */
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
    private final View emptyState;
    private final List<ClusterBlock> blocks = new ArrayList<>();

    /** true 时忽略控件回调：程序化回填不该被当成用户改动作业。 */
    private boolean suppress;

    /** 「插入态」所在簇的下标（-1 = 无）：此时本簇的行间横线显示，点线在该处插一行全空行。 */
    private int insertModeIndex = -1;
    /** 「拆分态」所在簇的下标（-1 = 无）：此时本簇的横线改色显示、点行＝共享拆分。两种模式互斥。 */
    private int splitModeIndex = -1;

    /** 整张「PID 分段倍率表」块（含曲线）：用于判定「点表内 / 表外」。 */
    private final View tableRoot;
    /** 模式态铺在整页内容根上的透明观察层：点表外即退出该模式；永不消费事件（见 {@link #showCaptureLayer()}）。 */
    @Nullable
    private View captureLayer;

    KiCutTableEditor(@NonNull KeyMeta meta, @NonNull View root, @NonNull Listener listener) {
        this.meta = meta;
        this.listener = listener;
        this.inflater = LayoutInflater.from(root.getContext());
        this.tableRoot = root;
        this.clustersBox = root.findViewById(R.id.ki_cut_clusters);
        this.emptyState = root.findViewById(R.id.ki_cut_empty_state);
        View emptyAdd = root.findViewById(R.id.ki_cut_empty_add);
        if (emptyAdd != null) {
            // 删到 0 簇后没任何簇块（「添加簇」按钮原本挂在每个簇块底部），故空态自带一枚补回入口
            emptyAdd.setOnClickListener(v -> onAddCluster(0));
        }
        // 视图被移除时保证观察层不残留
        clustersBox.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                hideCaptureLayer();
            }
        });
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

    /** 控件当前内容，<b>不收敛</b>：增删簇/点、拆分前取一次现状再重建时用，保留用户正在输入的原文。 */
    @NonNull
    private List<KiCutTable.Cluster> getClustersRaw() {
        return collect(false);
    }

    private List<KiCutTable.Cluster> collect(boolean clamp) {
        List<KiCutTable.Cluster> out = new ArrayList<>(blocks.size());
        for (ClusterBlock block : blocks) {
            KiCutTable.Cluster cluster = new KiCutTable.Cluster();
            for (PointRow row : block.rows) {
                // 冷值框为空 = 占位行（{@code hasCold=false}，整点不生效，仅原样往返），冷值不参与求值
                boolean hasCold = !isEmpty(row.cold);
                int cold = hasCold ? parseInt(row.cold, 0) : 0;
                if (clamp && hasCold) {
                    cold = clampField(cold, 0);
                }
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
                    kdp = clampField(kdp, 1);
                    up = clampField(up, 2);
                    dn = clampField(dn, 3);
                }
                cluster.points.add(new KiCutTable.Point(cold, hasCold, kdp, up, dn, skip));
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
            // 模式按下标保留（插入态在插入后仍留在本簇，便于连续插行）；越界即退出
            if (insertModeIndex >= blocks.size()) {
                insertModeIndex = -1;
            }
            if (splitModeIndex >= blocks.size()) {
                splitModeIndex = -1;
            }
            refreshTitles();
            refreshButtons();
            applyModeVisuals();
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

    /** 删一个簇：先弹窗确认（不可撤销），确认后才真的删。允许删到 0 簇（＝全段全 100）。 */
    private void onDeleteCluster(int index) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size()) {
            return;
        }
        Context context = clustersBox.getContext();
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.config_ki_cut_del_cluster_confirm_title)
                .setMessage(R.string.config_ki_cut_del_cluster_confirm_message)
                .setPositiveButton(R.string.config_ki_cut_del_cluster_confirm_ok,
                        (d, which) -> deleteClusterNow(index))
                .setNegativeButton(R.string.config_ki_cut_del_cluster_confirm_cancel, null)
                .create();
        // 点弹窗外部即取消（AppCompat AlertDialog 默认不随点外触摸取消，须显式设置）
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    private void deleteClusterNow(int index) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size()) {
            return;   // 确认期间表已变（外部重置等）：放弃，不删错
        }
        model.remove(index);
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    /** 点「添加点」：只切换本簇的插入态（显示行间横线），不再直接追加行——点某条横线才在该处插入。 */
    private void onInsertToggle(@NonNull ClusterBlock block) {
        int index = indexOf(block);
        insertModeIndex = (insertModeIndex == index) ? -1 : index;
        splitModeIndex = -1;   // 两种模式互斥
        applyModeVisuals();
    }

    private void onDeletePoint(int index, int rowIndex) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (index < 0 || index >= model.size()) {
            return;
        }
        List<KiCutTable.Point> points = model.get(index).points;
        if (rowIndex < 0 || rowIndex >= points.size()) {
            return;
        }
        if (points.size() == 1) {
            // 删掉最后一个点 = 删除整簇（复用既有删除簇路径：确认弹窗 + 「删到 0 簇」的处理）
            onDeleteCluster(index);
            return;
        }
        points.remove(rowIndex);
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    /** 新增点的初值：冷值取定义下限（取不到为 0），KDP/升/降都是 100（不削），三轴均非留空。 */
    private KiCutTable.Point newDefaultPoint() {
        return new KiCutTable.Point(minOf(0, 0), true, KiCutTable.NEUTRAL, KiCutTable.NEUTRAL,
                KiCutTable.NEUTRAL, 0);
    }

    /** 高亮横线插入的新行：四元组全空（冷值留空＝占位行，三条倍率置留空），渲染成四个空框。 */
    private static KiCutTable.Point blankPoint() {
        return new KiCutTable.Point(0, false, KiCutTable.NEUTRAL, KiCutTable.NEUTRAL,
                KiCutTable.NEUTRAL, KiCutTable.SKIP_KDP | KiCutTable.SKIP_UP | KiCutTable.SKIP_DN);
    }

    /** 在某簇 {@code at} 位置插入一条全空行（横线常态点击）。 */
    private void insertBlankRow(int clusterIndex, int at) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (clusterIndex < 0 || clusterIndex >= model.size()) {
            return;
        }
        List<KiCutTable.Point> points = model.get(clusterIndex).points;
        if (points.size() >= MAX_POINTS) {
            listener.notifyUser(clustersBox.getContext().getString(
                    R.string.config_ki_cut_limit_point, MAX_POINTS));
            return;
        }
        points.add(Math.max(0, Math.min(at, points.size())), blankPoint());
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    // ==================== 拆分簇 ====================

    /** 点「拆分簇」：在本簇的拆分态与常态之间切换（同一时刻只有一个簇处于某一种模式）。 */
    private void onSplitToggle(@NonNull ClusterBlock block) {
        int index = indexOf(block);
        splitModeIndex = (splitModeIndex == index) ? -1 : index;
        insertModeIndex = -1;   // 两种模式互斥
        applyModeVisuals();
    }

    /** 退出插入/拆分态（点表内空白处、或重建后下标越界时）。 */
    private void exitModes() {
        if (insertModeIndex < 0 && splitModeIndex < 0) {
            return;
        }
        insertModeIndex = -1;
        splitModeIndex = -1;
        applyModeVisuals();
    }

    /**
     * 模式视觉：<b>横线默认隐藏</b>，只有处于插入/拆分态的簇才显示——插入态横线用常态色（开关绿）、
     * 点线＝在该处插入；拆分态横线改色（红）、点线＝在此拆分，且该簇点行的命中层可见（点行＝共享拆分）。
     * 块底提示按模式改文案。
     */
    private void applyModeVisuals() {
        Context context = clustersBox.getContext();
        for (int i = 0; i < blocks.size(); i++) {
            ClusterBlock block = blocks.get(i);
            boolean inserting = i == insertModeIndex;
            boolean splitting = i == splitModeIndex;
            boolean active = inserting || splitting;
            int lineColor = context.getColor(
                    splitting ? R.color.ki_cut_insert_line_split : R.color.ki_cut_insert_line);
            for (int j = 0; j < block.lines.size(); j++) {
                View holder = block.lines.get(j);
                boolean edge = j == 0 || j == block.lines.size() - 1;
                // 拆分态首尾线无意义（会把簇切成空的一侧），隐藏掉；其余按是否处于模式决定显隐
                holder.setVisibility(active && !(splitting && edge) ? View.VISIBLE : View.GONE);
                View bar = holder.findViewById(R.id.ki_cut_line_bar);
                if (bar != null) {
                    bar.setBackgroundColor(lineColor);
                }
                holder.setContentDescription(context.getString(
                        splitting ? R.string.config_ki_cut_split_line : R.string.config_ki_cut_insert_line));
            }
            // 压缩＝横线占用的高度：模式态框压到 30dp（+ 线净占 6dp = 常态行高 36dp）；列名不关，压缩靠框高变矮
            int boxHeight = context.getResources().getDimensionPixelSize(active
                    ? R.dimen.ki_cut_point_height_compact : R.dimen.ki_cut_point_height);
            for (PointRow row : block.rows) {
                row.hit.setVisibility(splitting ? View.VISIBLE : View.GONE);
                // 拆分态该行可点＝共享拆分；其余时候命中层不可见，此描述不起作用
                row.hit.setContentDescription(context.getString(R.string.config_ki_cut_split_row));
                row.applyHeight(boxHeight);
            }
            block.modeHint.setVisibility(active ? View.VISIBLE : View.GONE);
            block.modeHint.setText(splitting
                    ? R.string.config_ki_cut_split_hint : R.string.config_ki_cut_insert_hint);
        }
        syncCaptureLayer();
    }

    // ==================== 点表外退出模式 ====================

    /** 有模式则铺观察层、无模式则撤走；幂等。 */
    private void syncCaptureLayer() {
        if (insertModeIndex >= 0 || splitModeIndex >= 0) {
            showCaptureLayer();
        } else {
            hideCaptureLayer();
        }
    }

    /**
     * 在整页内容根（{@code android.R.id.content}）上叠一层全屏透明观察层：它<b>永不消费事件</b>
     * （{@code onTouch} 恒返回 false），只在按下时判断「是否落在倍率表之外」——是则退出模式（<b>不吞那次点击</b>，
     * 事件照常落到下面的控件）。故「点表内」不会误退出，「点表外」等效再点一次按钮。找不到宿主 Activity 时静默跳过。
     */
    private void showCaptureLayer() {
        if (captureLayer != null) {
            return;
        }
        Activity activity = activityOf(clustersBox.getContext());
        if (activity == null) {
            return;
        }
        ViewGroup content = activity.findViewById(android.R.id.content);
        if (content == null) {
            return;
        }
        View layer = new View(activity);
        layer.setOnTouchListener((v, event) -> {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN && !insideTable(event)) {
                // 退出会撤掉本层，故延后到本次触摸派发之外执行
                clustersBox.post(this::exitModes);
            }
            return false;   // 不消费：点表内照常落到输入框/按钮，点表外也照常落到下面的控件
        });
        content.addView(layer, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        captureLayer = layer;
    }

    private void hideCaptureLayer() {
        View layer = captureLayer;
        if (layer == null) {
            return;
        }
        captureLayer = null;
        ViewParent parent = layer.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(layer);
        }
    }

    /** 触点是否落在整张倍率表块内（含曲线）。 */
    private boolean insideTable(@NonNull MotionEvent event) {
        int[] loc = new int[2];
        tableRoot.getLocationOnScreen(loc);
        float x = event.getRawX();
        float y = event.getRawY();
        return x >= loc[0] && x < loc[0] + tableRoot.getWidth()
                && y >= loc[1] && y < loc[1] + tableRoot.getHeight();
    }

    @Nullable
    private static Activity activityOf(@Nullable Context context) {
        Context c = context;
        while (c instanceof ContextWrapper) {
            if (c instanceof Activity) {
                return (Activity) c;
            }
            c = ((ContextWrapper) c).getBaseContext();
        }
        return null;
    }

    /** 点横线：插入态＝在该处插一行；拆分态＝在此常规拆分。 */
    private void onLineClicked(@NonNull ClusterBlock block, int at) {
        int index = indexOf(block);
        if (index == splitModeIndex) {
            // 常规拆分：上簇 = 该线以上的点，下簇 = 该线以下的点
            splitCluster(index, at, at);
        } else if (index == insertModeIndex) {
            insertBlankRow(index, at);
        }
    }

    /** 点行：拆分态下＝该行同属上下两簇（共享行）。 */
    private void onRowClicked(@NonNull ClusterBlock block, int rowIndex) {
        if (indexOf(block) == splitModeIndex) {
            // 共享拆分：上簇 = [0..row]，下簇 = [row..n-1]，该行两簇各一份
            splitCluster(indexOf(block), rowIndex + 1, rowIndex);
        }
    }

    /**
     * 把某簇切成两簇：上簇取 {@code points[0,upperEnd)}、下簇取 {@code points[lowerStart,n)}；两者都要非空，
     * 且切后簇数不超上限。
     */
    private void splitCluster(int clusterIndex, int upperEnd, int lowerStart) {
        List<KiCutTable.Cluster> model = getClustersRaw();
        if (clusterIndex < 0 || clusterIndex >= model.size()) {
            return;
        }
        List<KiCutTable.Point> points = model.get(clusterIndex).points;
        int n = points.size();
        if (upperEnd <= 0 || upperEnd > n || lowerStart < 0 || lowerStart >= n) {
            return;   // 会让某一侧没有点：拒绝
        }
        if (blocks.size() >= MAX_CLUSTERS) {
            listener.notifyUser(clustersBox.getContext().getString(
                    R.string.config_ki_cut_limit_cluster, MAX_CLUSTERS));
            return;
        }
        KiCutTable.Cluster upper = new KiCutTable.Cluster();
        upper.points.addAll(points.subList(0, upperEnd));
        KiCutTable.Cluster lower = new KiCutTable.Cluster();
        lower.points.addAll(points.subList(lowerStart, n));
        model.set(clusterIndex, upper);
        model.add(clusterIndex + 1, lower);
        splitModeIndex = -1;   // 拆分已完成，退出拆分态（插入态不在此列，其下标已越界也会被 rebuild 清掉）
        rebuild(model);
        listener.onEdited(Listener.EditKind.STRUCTURAL);
    }

    // ==================== 建块 ====================

    private void addClusterBlock(@NonNull KiCutTable.Cluster cluster) {
        View view = inflater.inflate(R.layout.item_ki_cut_cluster, clustersBox, false);
        ClusterBlock block = new ClusterBlock(view);
        boolean firstCluster = blocks.isEmpty();
        blocks.add(block);
        block.deleteClusterButton.setOnClickListener(v -> onDeleteCluster(indexOf(block)));
        // 「添加点」＝进入/退出插入态（不再直接追加行）
        block.addPointButton.setOnClickListener(v -> onInsertToggle(block));
        // 「添加簇」在每个簇块底部：新簇插在本块之后（不是追加到末尾），其后各簇整体下移
        block.addClusterButton.setOnClickListener(v -> onAddCluster(indexOf(block) + 1));
        block.splitClusterButton.setOnClickListener(v -> onSplitToggle(block));
        for (KiCutTable.Point point : cluster.points) {
            addInsertLine(block);   // 行之前一条
            addPointRow(block, point, firstCluster && block.rows.isEmpty());
        }
        addInsertLine(block);       // 末行之后一条
        applyLineMargins(block);    // 全部横线到位后统一定位（要知道首/末）
        clustersBox.addView(view);
    }

    /**
     * 追加一条可点高亮横线（其插入位置 = 当前行数，即它落在已有各行之下、下一条行之上）。
     * 外观（线粗、上下留白）由 {@code item_ki_cut_insert_line.xml} 给；<b>纵向位置</b>则由
     * {@link #applyLineMargins} 在全部横线到位后统一算（首/中/末三种口径）。
     */
    private void addInsertLine(@NonNull ClusterBlock block) {
        View holder = inflater.inflate(R.layout.item_ki_cut_insert_line, block.pointsBox, false);
        int at = block.rows.size();
        holder.setOnClickListener(v -> onLineClicked(block, at));
        block.lines.add(holder);
        block.pointsBox.addView(holder);
    }

    /**
     * 给本簇各条横线定位：<b>净占用恒 = 「常态行高 − 模式态框高」</b>（36−30 = 6dp），故「框 + 线」逐行与常态等高、
     * 整表总高不变。三条横线的上下口径不同，各自用外边距把 4dp 的线挪到视觉正中：
     * <ul>
     *   <li><b>中间</b>（行与行之间）：框体顶部有 ≈7dp 浮起说明留白，两框的「框体」之间其实是 7dp＋6dp 槽 = 13dp，
     *       故整体下移约半个留白（{@code ki_cut_insert_line_shift}）才落在两框正中；</li>
     *   <li><b>首条</b>（首行之上）：下方紧挨第 1 行的浮起列名（列名骑在框顶、向上伸出约 7dp），
     *       故不跟中间那条一起下移、且再抬到槽顶，给列名让出完整空间；</li>
     *   <li><b>末条</b>（末行之下）：下方是动作行（无框、无留白），按 6dp 槽本身居中即可。</li>
     * </ul>
     */
    private void applyLineMargins(@NonNull ClusterBlock block) {
        android.content.res.Resources res = clustersBox.getResources();
        int gap = res.getDimensionPixelSize(R.dimen.ki_cut_insert_line_gap);          // 线槽上下透明留白
        int thickness = res.getDimensionPixelSize(R.dimen.ki_cut_insert_line_thickness);
        int net = res.getDimensionPixelSize(R.dimen.ki_cut_point_height)
                - res.getDimensionPixelSize(R.dimen.ki_cut_point_height_compact);      // 横线净占用高（= 框的压缩量）
        int shift = res.getDimensionPixelSize(R.dimen.ki_cut_insert_line_shift);       // 中间条的下移量
        int wrap = 2 * gap + thickness;                                                // 线槽自身高（= padding + 线）
        int last = block.lines.size() - 1;
        for (int j = 0; j <= last; j++) {
            View holder = block.lines.get(j);
            ViewGroup.LayoutParams p = holder.getLayoutParams();
            if (!(p instanceof LinearLayout.LayoutParams)) {
                continue;
            }
            // 线的落点 = topMargin + gap（线槽内的上留白）；目标是让 4dp 的线落在期望处：
            int desiredTop = (j == 0) ? 0                         // 首条：抬到槽顶，给第 1 行列名让位
                    : (j == last) ? (net - thickness) / 2         // 末条：在 6dp 槽内居中
                    : shift;                                      // 中间：下移半个留白，落在两框正中
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) p;
            lp.topMargin = desiredTop - gap;
            lp.bottomMargin = net - wrap - lp.topMargin;          // 保证净占用恰为 net，逐行等高
            holder.setLayoutParams(lp);
        }
    }

    private void addPointRow(@NonNull ClusterBlock block, @NonNull KiCutTable.Point point,
                             boolean showHints) {
        View view = inflater.inflate(R.layout.item_ki_cut_point, block.pointsBox, false);
        PointRow row = new PointRow(view);
        // 冷值留空（占位行）渲染成空框，其余渲染数值
        row.cold.setText(point.hasCold ? String.valueOf(point.cold) : "");
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
        // 拆分态下点行＝共享拆分：命中层只在拆分态可见，故与输入框无触摸冲突
        row.hit.setOnClickListener(v -> onRowClicked(block, block.rows.indexOf(row)));
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

    /**
     * 刷新按钮与空态：「添加簇」「拆分簇」到上限时置灰（拆分还要求本簇至少两个点）；
     * 「添加点」到 32 点时置灰（它是插入态的模式按钮）；删除簇与删除点恒可用（删最后一个点＝删该簇，
     * 允许一直删到 0 簇）。0 簇时显示空态与补回入口。
     */
    private void refreshButtons() {
        boolean canAddCluster = blocks.size() < MAX_CLUSTERS;
        for (ClusterBlock block : blocks) {
            block.addClusterButton.setEnabled(canAddCluster);
            block.splitClusterButton.setEnabled(canAddCluster && block.rows.size() >= 2);
            block.addPointButton.setEnabled(block.rows.size() < MAX_POINTS);
        }
        if (emptyState != null) {
            emptyState.setVisibility(blocks.isEmpty() ? View.VISIBLE : View.GONE);
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
     * 是否存在<b>半截态</b>行：冷值框为空、<b>但至少填了一个倍率框</b>。
     *
     * <p>供宿主决定「编辑中是否重算曲线/写盘」（冷值必填）。<b>「四个框全空」不算半截态</b>——那是一整行
     * 「留空」（各倍率均不生效，语义见 {@link KiCutTable}），属于合法值；只有「冷值空、倍率有值」才是
     * 打到一半的中间态（防打字清空冷值的那一刻被误存）。
     */
    boolean hasEmptyCold() {
        for (ClusterBlock block : blocks) {
            for (PointRow row : block.rows) {
                if (isEmpty(row.cold) && !(isEmpty(row.kdp) && isEmpty(row.up) && isEmpty(row.dn))) {
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

    /** 一个点行（四个数字框 + 删除 + 拆分态命中层）。 */
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
        /** 覆盖整行的透明命中层：仅拆分态可见，让「点行＝共享拆分」不被输入框抢走触摸。 */
        final View hit;
        /** 四个框（改动高度/列名的统一入口）。 */
        final TextInputLayout[] boxes;

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
            this.hit = view.findViewById(R.id.ki_cut_point_hit);
            this.boxes = new TextInputLayout[]{coldBox, kdpBox, upBox, dnBox};
            this.cold.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.kdp.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.up.setInputType(InputType.TYPE_CLASS_NUMBER);
            this.dn.setInputType(InputType.TYPE_CLASS_NUMBER);
        }

        /**
         * 常态/模式态切换：四个框与删除按钮一并改成 {@code boxHeight}（常态 36dp、模式态 30dp）。
         *
         * <p><b>不动浮起列名</b>：列名两种模式都保持显示（{@code setHintEnabled} 一开一关反而会把
         * hint 挪进 EditText、退出后回不来）。压缩靠「框高 30dp 仍装得下列名 + 16sp 数字」——框体顶部
         * 那段 ≈7dp 留白两态都在，故常态绘制框 29dp、模式态 23dp，压缩一眼看得出；若关掉列名，
         * 绘制框反而从 29dp 变满高 30dp，看上去「没压缩」。
         */
        void applyHeight(int boxHeight) {
            for (TextInputLayout box : boxes) {
                setHeight(box, boxHeight);
            }
            setHeight(deleteButton, boxHeight);
        }

        private void setHeight(@NonNull View v, int height) {
            ViewGroup.LayoutParams lp = v.getLayoutParams();
            if (lp != null && lp.height != height) {
                lp.height = height;
                v.setLayoutParams(lp);
            }
        }
    }

    /** 一个簇块（表头「簇 N」+ 模式提示同一行 + 点行/横线容器 + 底部行：添加点 / 添加簇 / 拆分簇 / 删除簇）。 */
    private final class ClusterBlock {
        final View view;
        final TextView title;
        final LinearLayout pointsBox;
        final MaterialButton addPointButton;
        final MaterialButton addClusterButton;
        final MaterialButton splitClusterButton;
        final MaterialButton deleteClusterButton;
        /** 模式态提示，紧跟在「簇 N」标题之后同一行（文案按模式切，非模式态 GONE 不占高）。 */
        final TextView modeHint;
        final List<PointRow> rows = new ArrayList<>();
        /** 本簇的插入横线，顺序即位置（长度恒为 rows.size()+1）；默认隐藏，仅模式中显示。 */
        final List<View> lines = new ArrayList<>();

        ClusterBlock(View view) {
            this.view = view;
            this.title = view.findViewById(R.id.ki_cut_cluster_title);
            this.pointsBox = view.findViewById(R.id.ki_cut_cluster_points);
            this.addPointButton = view.findViewById(R.id.ki_cut_cluster_add_point);
            this.addClusterButton = view.findViewById(R.id.ki_cut_cluster_add_cluster);
            this.splitClusterButton = view.findViewById(R.id.ki_cut_cluster_split);
            this.deleteClusterButton = view.findViewById(R.id.ki_cut_cluster_del);
            this.modeHint = view.findViewById(R.id.ki_cut_split_hint);
        }
    }
}
