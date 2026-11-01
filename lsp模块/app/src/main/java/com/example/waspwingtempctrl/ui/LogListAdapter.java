package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志行适配器：一行一个 {@link TextView}，颜色按 {@link LogLine.Level} 取日志分级色；
 * 另持有「整行选择区间」，bind 时按行是否落在区间内切换选中底色。
 *
 * <p>选择为什么不用系统能力：{@code textIsSelectable} 的选择止步于单个 TextView，也就是单行；
 * 跨行只能由列表自己记区间。列表仍保持 RecyclerView 虚拟化——3000 行一次性塞进单个 TextView
 * 排版会卡顿数秒，这里只 bind 屏幕上的十几行。
 *
 * <p>颜色在构造时一次性解析（主线程、有 Context），bind 时只做一次 {@code setTextColor}；
 * 选中底色走 {@code bg_log_line_selected} 选择器（主题色，明暗自动切换），bind 时只切 {@code selected} 状态。
 */
final class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.LineHolder> {

    /** 行手势回调。位置在事件发生时现取，不用 bind 时的旧下标。 */
    interface LineGestureListener {
        /** 短按：选择模式下把选择范围扩到该行；未在选择模式时无动作。 */
        void onLineClick(int position);

        /** 长按：进入选择模式并以此行为锚点。 */
        void onLineLongPress(int position);
    }

    private final List<LogLine> items = new ArrayList<>();
    /** 下标同 {@link LogLine.Level#ordinal()}。 */
    private final int[] levelColors = new int[LogLine.Level.values().length];

    @Nullable
    private LineGestureListener listener;

    /** 选择区间两端：均非 {@link RecyclerView#NO_POSITION} 即处于选择模式；锚点长按行，焦点最后点击行。 */
    private int selectionAnchor = RecyclerView.NO_POSITION;
    private int selectionFocus = RecyclerView.NO_POSITION;

    LogListAdapter(@NonNull Context context, @Nullable LineGestureListener listener) {
        this.listener = listener;
        levelColors[LogLine.Level.ERROR.ordinal()] =
                ContextCompat.getColor(context, R.color.log_level_error);
        levelColors[LogLine.Level.WARN.ordinal()] =
                ContextCompat.getColor(context, R.color.log_level_warn);
        levelColors[LogLine.Level.DEBUG.ordinal()] =
                ContextCompat.getColor(context, R.color.log_level_debug);
        levelColors[LogLine.Level.INFO.ordinal()] =
                ContextCompat.getColor(context, R.color.log_level_info);
        levelColors[LogLine.Level.PLAIN.ordinal()] =
                ContextCompat.getColor(context, R.color.app_on_surface);
    }

    /** 整批替换（后台线程已解析好的行）。选择模式下调用方必须阻止，否则区间会错位到新数据上。 */
    void submit(@NonNull List<LogLine> lines) {
        items.clear();
        items.addAll(lines);
        // 整批替换后必须重新按区间涂高亮：换出的行是新 View，旧的 selected 状态不跟随
        notifyDataSetChanged();
    }

    /** 断开手势回调（Fragment 销毁视图时调用，避免适配器反向持有 Fragment）。 */
    void clearGestureListener() {
        listener = null;
    }

    // ==================== 整行选择区间 ====================

    boolean isSelecting() {
        return selectionAnchor != RecyclerView.NO_POSITION;
    }

    /** 长按进入选择模式并把该行设为锚点；已在选择模式时重新以该行为锚点。 */
    void beginSelection(int position) {
        if (!isValidPosition(position)) {
            return;
        }
        selectionAnchor = position;
        selectionFocus = position;
        notifyDataSetChanged();
    }

    /** 把选择范围扩到「锚点行～该行」，方向不限。 */
    void extendSelectionTo(int position) {
        if (!isSelecting() || !isValidPosition(position) || position == selectionFocus) {
            return;
        }
        selectionFocus = position;
        notifyDataSetChanged();
    }

    /** 退出选择模式并清掉高亮。 */
    void clearSelection() {
        if (!isSelecting()) {
            return;
        }
        selectionAnchor = RecyclerView.NO_POSITION;
        selectionFocus = RecyclerView.NO_POSITION;
        notifyDataSetChanged();
    }

    /** 选中区间的整行文本，行间以 {@code \n} 连接；未选中时为空串。 */
    @NonNull
    String selectedText() {
        if (!isSelecting()) {
            return "";
        }
        int from = Math.min(selectionAnchor, selectionFocus);
        int to = Math.min(Math.max(selectionAnchor, selectionFocus), items.size() - 1);
        StringBuilder text = new StringBuilder();
        for (int i = from; i <= to; i++) {
            if (i > from) {
                text.append('\n');
            }
            text.append(items.get(i).text);
        }
        return text.toString();
    }

    private boolean isLineSelected(int position) {
        if (!isSelecting()) {
            return false;
        }
        return position >= Math.min(selectionAnchor, selectionFocus)
                && position <= Math.max(selectionAnchor, selectionFocus);
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < items.size();
    }

    // ==================== 列表 ====================

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_log_line, parent, false);
        return new LineHolder(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder holder, int position) {
        LogLine line = items.get(position);
        holder.text.setText(line.text);
        holder.text.setTextColor(levelColors[line.level.ordinal()]);
        holder.text.setSelected(isLineSelected(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void dispatchClick(@NonNull LineHolder holder) {
        int position = holder.getBindingAdapterPosition();
        if (position != RecyclerView.NO_POSITION && listener != null) {
            listener.onLineClick(position);
        }
    }

    private boolean dispatchLongPress(@NonNull LineHolder holder) {
        int position = holder.getBindingAdapterPosition();
        if (position == RecyclerView.NO_POSITION || listener == null) {
            return false;
        }
        listener.onLineLongPress(position);
        return true;
    }

    static final class LineHolder extends RecyclerView.ViewHolder {
        final TextView text;

        LineHolder(@NonNull View itemView, @NonNull LogListAdapter adapter) {
            super(itemView);
            text = itemView.findViewById(R.id.log_line_text);
            // 监听只在创建时挂一次：重复 bind 不产生新对象，位置靠 getBindingAdapterPosition 现取
            itemView.setOnClickListener(v -> adapter.dispatchClick(this));
            itemView.setOnLongClickListener(v -> adapter.dispatchLongPress(this));
        }
    }
}
