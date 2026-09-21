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
 * <h3>为什么需要它</h3>
 * 曲线的画布下沿拖柄要「纵向拖动改画布高、横向滑动照旧翻页」，而按下时
 * {@code requestDisallowInterceptTouchEvent(true)} 做不到这件事：那个开关是沿父链一路设上去的，
 * 一旦按下就设，外层 ViewPager2 的横向拦截也被一并封掉（横向再也翻不了页）；而等到手指走起来
 * 才设又已经太晚——同一帧里 {@link ScrollView#onInterceptTouchEvent} 先于子视图的
 * {@code onTouchEvent} 判定，纵向那一抖早就被它当成"用户在滚页面"把事件流接管了。
 *
 * <p>所以改成由本类在<b>按下那一刻</b>判定「这一下是不是落在指定的子视图上」，是则本次手势
 * 全程不接管：
 * <ul>
 *   <li>纵向 → 没人跟拖柄抢，拖柄照常收到全部 MOVE；</li>
 *   <li>横向 → 本类不接管，但外层 ViewPager2 的横向拦截不受影响（它照常能收到完整事件流），翻页照旧。</li>
 * </ul>
 * 代价是：从该子视图上开始的纵向拖动不再滚动页面（这是"让给拖柄"的必然含义）。
 *
 * <p>没指定子视图（{@link #setVerticalDragCaptor} 没被调用）时，本类与普通 {@code ScrollView} 完全一致。
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
