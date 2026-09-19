package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志行适配器：一行一个 {@link TextView}，颜色按 {@link LogLine.Level} 取日志分级色。
 *
 * <p>颜色在构造时一次性解析（主线程、有 Context），bind 时只做一次 {@code setTextColor}，
 * 不在滚动路径上解析资源。
 */
final class LogListAdapter extends RecyclerView.Adapter<LogListAdapter.LineHolder> {

    private final List<LogLine> items = new ArrayList<>();
    /** 下标同 {@link LogLine.Level#ordinal()}。 */
    private final int[] levelColors = new int[LogLine.Level.values().length];

    LogListAdapter(@NonNull Context context) {
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

    /** 整批替换（后台线程已解析好的行）。 */
    void submit(@NonNull List<LogLine> lines) {
        items.clear();
        items.addAll(lines);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_log_line, parent, false);
        return new LineHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder holder, int position) {
        LogLine line = items.get(position);
        holder.text.setText(line.text);
        holder.text.setTextColor(levelColors[line.level.ordinal()]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static final class LineHolder extends RecyclerView.ViewHolder {
        final TextView text;

        LineHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.log_line_text);
        }
    }
}
