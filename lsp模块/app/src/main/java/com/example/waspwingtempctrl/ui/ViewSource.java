package com.example.waspwingtempctrl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;

/**
 * 建表取视图的<b>唯一入口</b>：先问预制造器要（见 {@link ConfigPreInflater}），要不到才现场 inflate ——
 * 两条路造出的是同一种控件（只差 inflate 花在哪根线程），<b>取不到是常态而非异常</b>。
 * 设计见 {@code app/逻辑说明.md} §6.2。
 */
final class ViewSource {

    /** 现场 inflate 用的 inflater（页面自己的那一份；只主线程用）。 */
    private final LayoutInflater inflater;
    /** 预制造器；{@code null} = 本页不启用预制造，一切现场造。 */
    @Nullable
    private final ConfigPreInflater preInflater;

    ViewSource(@NonNull LayoutInflater inflater, @Nullable ConfigPreInflater preInflater) {
        this.inflater = inflater;
        this.preInflater = preInflater;
    }

    /**
     * 取一份布局为 {@code layoutId} 的视图；{@code parent} 只用于生成 LayoutParams（不 attach）。
     *
     * <p>两个累计计数只服务诊断区展示（{@link StartupTiming}），不参与这里的任何判断，
     * 也不改变两条路各自的取件结果。
     */
    @NonNull
    View inflate(int layoutId, @NonNull ViewGroup parent) {
        if (preInflater != null) {
            View preMade = preInflater.take(layoutId);
            if (preMade != null) {
                StartupTiming.count(StartupTiming.PRE_HIT);   // 记账（旁路）：池子命中
                return preMade;
            }
        }
        StartupTiming.count(StartupTiming.PRE_MISS);   // 记账（旁路）：现场 inflate
        StartupTiming.count(missSlot(layoutId));       // 记账（旁路）：未命中构成（按布局 id）
        return inflater.inflate(layoutId, parent, false);
    }

    /**
     * 未命中计数落到哪个槽：按布局 id 分到 {@link StartupTiming} 的七个槽之一，只服务诊断区
     * 「缺的是哪几种件」这一问题（记账口径见 {@code app/逻辑说明.md} §5.3）。<b>写成 if/else 而不是
     * switch</b>：本工程的 R 字段不是编译期常量（{@code android.nonTransitiveRClass}），做不了
     * {@code case} 标签。认不出来（将来新增的布局）一律落到"字段"槽——记账口径的兜底，不参与取件路径。
     */
    private static int missSlot(int layoutId) {
        if (layoutId == R.layout.item_config_group) {
            return StartupTiming.MISS_GROUP;
        }
        if (layoutId == R.layout.item_config_row) {
            return StartupTiming.MISS_ROW;
        }
        if (layoutId == R.layout.item_config_key_switch) {
            return StartupTiming.MISS_KEY_SWITCH;
        }
        if (layoutId == R.layout.item_config_enum_group) {
            return StartupTiming.MISS_ENUM_GROUP;
        }
        if (layoutId == R.layout.item_chart_window_button) {
            return StartupTiming.MISS_ENUM_BUTTON;
        }
        if (layoutId == R.layout.item_config_field_switch) {
            return StartupTiming.MISS_FIELD_SWITCH;
        }
        return StartupTiming.MISS_FIELD;
    }

    /**
     * 预制造件已经用不上了：丢掉池子里的剩余件（建表收尾与页面销毁各调一次）。
     *
     * <p>不丢的话，池子里那些件会把它们的 Context（也就是那个 Activity）一直钉在静态引用上。
     */
    void release() {
        if (preInflater != null) {
            preInflater.clearLeftovers();
        }
    }
}
