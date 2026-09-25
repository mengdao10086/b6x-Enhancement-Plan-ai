package com.example.waspwingtempctrl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 建表取视图的<b>唯一入口</b>：先问预制造器要（见 {@link ConfigPreInflater}），要不到才现场 inflate。
 *
 * <p>两条路造出来的是同一种控件：同一份布局、同一个带视图工厂的 inflater 上下文、同一类型的父容器
 * （预制造时用同类型的空壳父容器生成 LayoutParams，见 {@link ConfigPreInflater#produceAll}），
 * 故"取到预制造件"与"现场造"在功能与像素上没有区别，只差那一段 inflate 花在哪根线程上。
 *
 * <p><b>取不到是常态而非异常</b>：预制造没赶上、件数不够、本页压根不启用预制造（设置页传 null），
 * 都走"现场造"这一路，行为与不做预制造时逐字一致。故调用方不需要为本类写任何降级分支——
 * 这是"预制造与消费不要求数量一致"这条不变量的落点（见 {@link ConfigPreInflater} 的〈备料口径〉）。
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

    /** 取一份布局为 {@code layoutId} 的视图；{@code parent} 只用于生成 LayoutParams（不 attach）。 */
    @NonNull
    View inflate(int layoutId, @NonNull ViewGroup parent) {
        if (preInflater != null) {
            View preMade = preInflater.take(layoutId);
            if (preMade != null) {
                return preMade;
            }
        }
        return inflater.inflate(layoutId, parent, false);
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
