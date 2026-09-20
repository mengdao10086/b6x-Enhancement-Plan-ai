package com.example.waspwingtempctrl.ui;

import android.view.MotionEvent;
import android.view.View;

/**
 * 给任意可垂直滚动的 View 接上「按住滚动条拖动」。
 *
 * <p><b>为什么必须自己实现</b>：Android 框架的滚动条只有绘制能力，没有触摸拖动实现——
 * {@code androidx.recyclerview.widget.ScrollbarHelper} 全文只有滚动量计算
 * （{@code computeScrollOffset/Extent/Range}），零触摸代码；框架另有一套
 * {@code fastScrollEnabled} API 专做这件事，正说明默认滚动条不响应拖动。
 *
 * <p>挂在视图的 {@code OnTouchListener} 上（不是包一层容器，故不影响现有层次）：
 * <ul>
 *   <li>命中区 = 右边缘一条窄带（滚动条宽度 + 8dp，且不小于 20dp）：细滚动条也能按住；</li>
 *   <li>按下点落在滑块上 → 按「抓着滑块拖动」算；落在轨道空白处 → 滑块先跟到手指再拖；</li>
 *   <li>拖动映射成按比例的滚动位置，用 {@code scrollBy} 落地——它对 {@code ScrollView} 与
 *       {@code RecyclerView} 都有效（后者走 {@code scrollByInternal}，直接 {@code scrollTo} 无效）。</li>
 * </ul>
 *
 * <p>不命中的触摸一律返回 false，正常滚动、点击、长按全部照旧。
 *
 * <p>代价（真机需确认）：右边缘窄带内的普通拖拽会被吃掉；系统手势导航若占用了最外侧边缘，
 * 实际可按住的区域会从窄带内侧开始。
 */
public final class ScrollbarDrag {

    /** 命中区在「滚动条宽度」之外额外放宽的量。 */
    private static final int EXTRA_HIT_DP = 8;
    /** 滑块长度与命中区的下限：滚动条极窄时也要看得见、按得住。 */
    private static final int MIN_THUMB_DP = 20;

    private ScrollbarDrag() {
    }

    /**
     * 给视图接上拖动。可重复调用（后一次覆盖前一次）。
     *
     * @param view 可垂直滚动的视图（ScrollView / RecyclerView 均可）
     */
    public static void attach(final View view) {
        if (view == null) {
            return;
        }
        final float density = view.getResources().getDisplayMetrics().density;
        // 命中区宽度（px）：滚动条宽度 + 8dp，且不小于 20dp（getVerticalScrollbarWidth 已是 px）
        final float hitWidth = Math.max(MIN_THUMB_DP * density,
                EXTRA_HIT_DP * density + view.getVerticalScrollbarWidth());

        view.setOnTouchListener(new View.OnTouchListener() {
            /** 手指按下点相对滑块顶端的偏移；按下时不在滑块上则取滑块中点（滑块跟到手指）。 */
            private float grabOffset;
            private boolean dragging;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        if (event.getX() < v.getWidth() - hitWidth) {
                            return false;   // 不在滚动条窄带内：完全放行
                        }
                        Track track = new Track(v, density);
                        if (track.usable <= 0f) {
                            return false;   // 无滚动余量（内容不满一屏）：没有可拖的东西
                        }
                        grabOffset = track.grabOffsetAt(event.getY());
                        dragging = true;
                        v.scrollBy(0, track.offsetAt(event.getY(), grabOffset) - v.computeVerticalScrollOffset());
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        if (!dragging) {
                            return false;
                        }
                        Track moved = new Track(v, density);
                        v.scrollBy(0, moved.offsetAt(event.getY(), grabOffset) - v.computeVerticalScrollOffset());
                        return true;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        if (!dragging) {
                            return false;
                        }
                        dragging = false;
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    /** 一条滚动条轨道的几何量：按当前滚动状态现算，不缓存（拖动中每秒都在变）。 */
    private static final class Track {
        /** 轨道顶端（= 视图上内边距，滚动条画在内边距带里）。 */
        private final float top;
        /** 轨道长度。 */
        private final float length;
        /** 滑块长度（按 range 比例，且有下限）。 */
        private final float thumbLen;
        /** 滑块可走的行程 = 轨道长 − 滑块长。 */
        private final float usable;
        /** 可滚动余量 = range − extent。 */
        private final float maxOffset;
        /** 当前滚动位置在行程上的比例 0~1。 */
        private final float frac;

        Track(View v, float density) {
            int range = v.computeVerticalScrollRange();
            int extent = v.computeVerticalScrollExtent();
            this.top = v.getPaddingTop();
            this.length = v.getHeight() - v.getPaddingTop() - v.getPaddingBottom();
            this.thumbLen = Math.min(length,
                    range <= 0 ? length : Math.max(MIN_THUMB_DP * density, length * extent / (float) range));
            this.usable = length - thumbLen;
            this.maxOffset = Math.max(0f, range - extent);
            this.frac = maxOffset <= 0f ? 0f : v.computeVerticalScrollOffset() / maxOffset;
        }

        /** 滑块顶端在视图里的 y。 */
        private float thumbTop() {
            return top + frac * usable;
        }

        /** 手指按下点相对滑块顶端的偏移；不在滑块上时取滑块中点（滑块跟到手指）。 */
        float grabOffsetAt(float fingerY) {
            float dy = fingerY - top;
            return (dy >= thumbTop() && dy <= thumbTop() + thumbLen) ? dy - thumbTop() : thumbLen / 2f;
        }

        /** 手指位置换算出的目标滚动位置（未钳制到视图自身的边界，由 scrollBy 收口）。 */
        int offsetAt(float fingerY, float grabOffset) {
            float f = (fingerY - top - grabOffset) / usable;
            if (f < 0f) {
                f = 0f;
            } else if (f > 1f) {
                f = 1f;
            }
            return Math.round(f * maxOffset);
        }
    }
}
