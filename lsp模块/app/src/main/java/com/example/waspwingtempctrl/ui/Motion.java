package com.example.waspwingtempctrl.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import java.util.WeakHashMap;

/**
 * 界面动效的统一口径：曲线、时长模型、速度倍率与无障碍门控三件事只有这一处。
 *
 * <p><b>曲线</b>：{@link #EASE_OUT} 是 Android 对 Web 侧
 * {@code cubic-bezier(0.23, 1, 0.32, 1)} 的照抄（{@link PathInterpolator} 与 cubic-bezier 同义），
 * 进入/退出类 UI 过渡一律用它；不用平台内置曲线（太弱），也不用 ease-in。
 *
 * <p><b>时长模型（逻辑 2：时长随位移量）</b>：不再用固定时长，而是「每 dp 位移对应固定时长」——
 * {@link #MS_PER_DP} 为基准速率，按位移算出原始时长后钳到 {@code [MIN_DISTANCE_MS, MAX_DISTANCE_MS]}
 * 防极端尺寸；这样大窗口多花一点、小窗口少花一点，观感上「展开速度」一致。箭头这类位移恒定的动画
 * 在本模型下退化为常量（{@link #DURATION_STATE_MS}），仍走同一套钳制与倍率。
 *
 * <p><b>速度倍率</b>：{@link #setSpeedMultiplier(float)} 叠一层用户可调的速度倍率（2× = 时长减半，
 * 0.5× = 时长加倍），与平台上自动施加的系统动画缩放相互独立（本类是额外那一层，倍率层之后再做一次
 * 硬钳制 {@code [HARD_MIN_MS, HARD_MAX_MS]} 兜底）。倍率由 app 启动路径读界面参数后喂入，非法值退回 1.0。
 *
 * <p><b>无障碍</b>：系统「动画时长缩放」关掉时，{@link #enabled(Context)} 为假，调用方须降级为
 * 瞬间完成——这是 Web 侧 {@code prefers-reduced-motion} 在本平台的对应物：动效更少更温和，
 * 而非全无（只去掉运动，信息照常呈现）。API 26+ 用
 * {@link ValueAnimator#areAnimatorsEnabled()}；API 25 退化为读
 * {@link Settings.Global#ANIMATOR_DURATION_SCALE}；另读
 * {@link Settings.Global#TRANSITION_ANIMATION_SCALE} 覆盖 {@code TransitionManager} 路径。
 */
public final class Motion {

    /** 逻辑 2 的基准速率：每 dp 位移对应的时长（毫秒）。 */
    private static final float MS_PER_DP = 1.5f;

    /** 位移类时长的下限：位移再小也不快于此（防"一闪而过"）。 */
    private static final long MIN_DISTANCE_MS = 120L;

    /** 位移类时长的上限：位移再大也不慢于此（落在 UI 动效 300ms 预算内，防极端尺寸拖沓）。 */
    private static final long MAX_DISTANCE_MS = 300L;

    /** 倍率层之后的硬钳制：任何倍率下都不越出，作为最终兜底。 */
    private static final long HARD_MIN_MS = 60L;
    private static final long HARD_MAX_MS = 600L;

    /** 位移恒定类（展开箭头 0↔90°）的基准时长：200ms（比原先的 150ms 慢三分之一）。 */
    private static final long DURATION_STATE_MS = 200L;

    /** 强 ease-out，照抄 cubic-bezier(0.23, 1, 0.32, 1)；先建一次复用。 */
    private static final Interpolator EASE_OUT = new PathInterpolator(0.23f, 1f, 0.32f, 1f);

    /** 速度倍率（叠在平台上自动施加的系统缩放之外）。启动时由 app 读界面参数喂入；默认 1.0。 */
    private static volatile float speedMultiplier = 1f;

    /** 正在跑的折叠体高度补间，按 content 视图记账：下一次调用据此先取消（打断即换向，不排队）。 */
    private static final WeakHashMap<View, ValueAnimator> HEIGHT_ANIMS = new WeakHashMap<>();

    private Motion() {
    }

    /**
     * 设置速度倍率（叠在系统动画缩放之外的额外一层）：2× = 时长减半，0.5× = 时长加倍。
     * <b>{@code ≤0} 或 {@code NaN} 一律退回 1.0</b>（冻结接口，另一个包依赖此签名）。
     */
    public static void setSpeedMultiplier(float speed) {
        speedMultiplier = (speed > 0f && !Float.isNaN(speed)) ? speed : 1f;
    }

    /** 进入/退出类 UI 过渡的曲线（强 ease-out）。 */
    static Interpolator easeOut() {
        return EASE_OUT;
    }

    /**
     * 系统是否允许播放动效（动画/过渡时长缩放均不为 0）。取不到设置时按"允许"处理——
     * 宁可有动画，不误关。
     */
    static boolean enabled(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (!ValueAnimator.areAnimatorsEnabled()) {
                    return false;
                }
            } else if (scale(context, Settings.Global.ANIMATOR_DURATION_SCALE) == 0f) {
                return false;
            }
            return scale(context, Settings.Global.TRANSITION_ANIMATION_SCALE) != 0f;
        } catch (Throwable t) {
            return true;
        }
    }

    /**
     * 位移量（像素）对应的时长：px → dp × {@link #MS_PER_DP} → 钳 {@code [MIN,MAX]} → ÷ 倍率 → 硬钳。
     */
    static long durationForPixels(Context context, float pixels) {
        float density = 1f;
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
            if (density <= 0f) {
                density = 1f;
            }
        }
        long base = clamp(Math.round(pixels / density * MS_PER_DP), MIN_DISTANCE_MS, MAX_DISTANCE_MS);
        return scaled(base);
    }

    /** 位移恒定类（箭头）的时长：常量过同一套钳制与倍率。 */
    static long durationForState() {
        return scaled(clamp(DURATION_STATE_MS, MIN_DISTANCE_MS, MAX_DISTANCE_MS));
    }

    /** 先钳位移区间、再除倍率、最后硬钳：三段只有这一处。 */
    private static long scaled(long base) {
        float speed = speedMultiplier;
        if (speed <= 0f || Float.isNaN(speed)) {
            speed = 1f;
        }
        return clamp(Math.round(base / speed), HARD_MIN_MS, HARD_MAX_MS);
    }

    private static long clamp(long value, long min, long max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * 把视图转到给定角度：系统允许动效时平滑转过去（可被下一次调用打断并从当前位置接着转）；
     * 关掉动效时直接落位。箭头位移恒定，时长走 {@link #durationForState()}。
     */
    static void rotate(View view, float degrees) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        if (!enabled(view.getContext()) || view.getRotation() == degrees) {
            view.setRotation(degrees);
            return;
        }
        view.animate().rotation(degrees)
                .setDuration(durationForState())
                .setInterpolator(EASE_OUT)
                .start();
    }

    /**
     * 展开/收起一个 {@code wrap_content} 容器：按逻辑 2 的时长逐帧改其高度。
     *
     * <p>打断即换向——同一次调用先取消本视图在跑的高度补间，再从**当前高度**接着动，连点不排队、不卡住。
     * 系统关掉动效、或视图尚未布局（各构造器里的初始折叠）时直接落位。
     *
     * @param expand true = 展开（量出内容高并从当前高度长过去）；false = 收起（收到 0 再置 {@code GONE}）
     */
    static void animateHeight(View content, boolean expand) {
        if (content == null) {
            return;
        }
        final ValueAnimator running = HEIGHT_ANIMS.remove(content);
        if (running != null) {
            // 先摘账再取消：旧动画的 onAnimationEnd 会因对不上号而空跑，不会误置最终态
            running.cancel();
        }
        final ViewGroup.LayoutParams lp = content.getLayoutParams();
        if (lp == null) {
            content.setVisibility(expand ? View.VISIBLE : View.GONE);
            return;
        }
        boolean animate = enabled(content.getContext()) && content.isLaidOut();
        // 起点取"当前真实高"：可见时优先用动画中的 lp.height（打断时的中间值），否则用已布局高度
        int from = content.getVisibility() == View.VISIBLE
                ? (lp.height >= 0 ? lp.height : content.getHeight()) : 0;
        int to;
        if (expand) {
            content.setVisibility(View.VISIBLE);
            to = measureHeight(content);
            if (from > to) {
                from = to;   // 打断换向时夹一下，避免从比目标还高的位置往回缩
            }
        } else {
            to = 0;
        }
        if (!animate || from == to) {
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            content.setVisibility(expand ? View.VISIBLE : View.GONE);
            content.requestLayout();
            return;
        }
        final ValueAnimator anim = ValueAnimator.ofInt(from, to);
        anim.setDuration(durationForPixels(content.getContext(), Math.abs(to - from)));
        anim.setInterpolator(EASE_OUT);
        anim.addUpdateListener(a -> {
            lp.height = (int) (Integer) a.getAnimatedValue();
            content.requestLayout();
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (HEIGHT_ANIMS.get(content) != anim) {
                    return;   // 已被新一次调用取代：不作收尾
                }
                HEIGHT_ANIMS.remove(content);
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                if (!expand) {
                    content.setVisibility(View.GONE);
                }
                content.requestLayout();
            }
        });
        HEIGHT_ANIMS.put(content, anim);
        lp.height = from;
        anim.start();
    }

    /**
     * 量出容器在 {@code wrap_content} 下的完整高（展开前的预判）。
     *
     * <p><b>绕开"GONE 下测量为 0"的经典坑</b>：调用前须已置 {@code VISIBLE}；这里用
     * {@code height=UNSPECIFIED} 直接测内容，不受当前 {@code lp.height}（可能为 0 或动画中间值）影响。
     */
    private static int measureHeight(View content) {
        ViewGroup.LayoutParams lp = content.getLayoutParams();
        int oldHeight = lp != null ? lp.height : ViewGroup.LayoutParams.WRAP_CONTENT;
        int width = content.getWidth();
        if (width <= 0 && content.getParent() instanceof View) {
            View parent = (View) content.getParent();
            width = parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight();
        }
        if (width <= 0) {
            width = content.getResources().getDisplayMetrics().widthPixels;
        }
        if (lp != null) {
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        content.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int measured = content.getMeasuredHeight();
        if (lp != null) {
            lp.height = oldHeight;
        }
        return measured;
    }

    /**
     * 预测把 {@code target} 文本换给 {@code view} 后的高度（不改视图最终状态：测完即还原）。
     * 用于内容驱动的高度变化（状态卡换字）按时长模型补间——位移量在改动前无法直接得知。
     */
    static int measureTextHeight(TextView view, CharSequence target) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        if (width <= 0) {
            return view.getHeight();
        }
        CharSequence old = view.getText();
        view.setText(target);
        view.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int measured = view.getMeasuredHeight();
        view.setText(old);
        return measured;
    }

    /**
     * 开一段带逻辑 2 时长的布局过渡：调用方先调本方法、随后再改可见性/内容，平台会把边界变化按
     * 算出的时长补间过去。系统关掉动效时不动（调用方直接改状态即可）。
     */
    static void beginLayoutChange(ViewGroup root, float deltaPx) {
        if (root == null || !enabled(root.getContext())) {
            return;
        }
        AutoTransition transition = new AutoTransition();
        transition.setDuration(durationForPixels(root.getContext(), Math.abs(deltaPx)));
        transition.setInterpolator(EASE_OUT);
        TransitionManager.beginDelayedTransition(root, transition);
    }

    private static float scale(Context context, String key) {
        return Settings.Global.getFloat(context.getContentResolver(), key, 1f);
    }
}
