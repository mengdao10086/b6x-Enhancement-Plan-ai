package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 页面用的 ScrollView：允许把「从某个子视图上开始的纵向拖动」整个让给那个子视图。
 *
 * <p>由本类在<b>按下那一刻</b>判定「这一下是不是落在指定的子视图上」，是则本次手势全程不接管：纵向归该
 * 子视图（没人跟拖柄抢，拖柄照常收到全部 MOVE）、横向仍归外层 ViewPager2（本类不接管、它照常翻页）。
 * 代价是：从该子视图上开始的纵向拖动不再滚动页面。没指定子视图时与普通 {@code ScrollView} 完全一致。
 *
 * <p>为什么不能改用 {@code requestDisallowInterceptTouchEvent}，见 app/逻辑说明.md §7.6。
 */
public final class PageScrollView extends ScrollView {

    /** 本次手势是否落在"纵向让给谁"的子视图上（按下时判定一次，抬起时清掉）。 */
    private boolean captorGesture;
    /** 纵向拖动让给谁；null = 不让（等同普通 ScrollView）。 */
    @Nullable
    private View verticalDragCaptor;

    public PageScrollView(Context context) {
        super(context);
    }

    public PageScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PageScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /** 指定「纵向拖动让给它」的子视图；传 null 取消。 */
    public void setVerticalDragCaptor(@Nullable View captor) {
        verticalDragCaptor = captor;
    }

    /**
     * 把 {@code captor} 交给它所在的 {@link PageScrollView}（沿父链上溯查找）。
     *
     * <p>给调用方省掉"页面根是谁"：曲线区不知道自己被挂在哪个容器下，页面根本类不是
     * {@code PageScrollView} 时静默跳过（曲线区也可被别处挂载，那时行为与从前一致）。
     */
    public static void yieldVerticalDragTo(@NonNull View captor) {
        for (ViewParent parent = captor.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof PageScrollView) {
                ((PageScrollView) parent).setVerticalDragCaptor(captor);
                return;
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                captorGesture = isOnCaptor(ev);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                captorGesture = false;
                break;
            default:
                break;
        }
        if (captorGesture) {
            return false;   // 本次手势不接管：纵向归 captor，横向归外层 ViewPager2
        }
        return super.onInterceptTouchEvent(ev);
    }

    /** 按下点是否落在 captor 上：拿屏幕坐标比可见矩形，滚动与裁切都已算进去。 */
    private boolean isOnCaptor(MotionEvent down) {
        View captor = verticalDragCaptor;
        if (captor == null || captor.getVisibility() != VISIBLE) {
            return false;
        }
        Rect bounds = new Rect();
        return captor.getGlobalVisibleRect(bounds)
                && bounds.contains((int) down.getRawX(), (int) down.getRawY());
    }
}
