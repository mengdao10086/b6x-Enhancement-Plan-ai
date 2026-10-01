package com.example.waspwingtempctrl.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/**
 * 界面动效的统一口径：曲线、时长与无障碍门控三件事只有这一处。
 *
 * <p><b>曲线</b>：{@link #EASE_OUT} 是 Android 对 Web 侧
 * {@code cubic-bezier(0.23, 1, 0.32, 1)} 的照抄（{@link PathInterpolator} 与 cubic-bezier 同义），
 * 进入/退出类 UI 过渡一律用它；不用平台内置曲线（太弱），也不用 ease-in。
 *
 * <p><b>无障碍</b>：系统「动画时长缩放」关掉时，{@link #enabled(Context)} 为假，调用方须降级为
 * 瞬间完成——这是 Web 侧 {@code prefers-reduced-motion} 在本平台的对应物：动效更少更温和，
 * 而非全无（只去掉运动，信息照常呈现）。API 26+ 用
 * {@link ValueAnimator#areAnimatorsEnabled()}；API 25 退化为读
 * {@link Settings.Global#ANIMATOR_DURATION_SCALE}；另读
 * {@link Settings.Global#TRANSITION_ANIMATION_SCALE} 覆盖 {@code TransitionManager} 路径。
 */
final class Motion {

    /** 状态类过渡（展开箭头等）时长：150ms，落在 UI 动效 300ms 预算内。 */
    static final long DURATION_STATE_MS = 150L;

    /** 强 ease-out，照抄 cubic-bezier(0.23, 1, 0.32, 1)；先建一次复用。 */
    private static final Interpolator EASE_OUT = new PathInterpolator(0.23f, 1f, 0.32f, 1f);

    private Motion() {
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
     * 把视图转到给定角度：系统允许动效时 150ms ease-out 平滑转过去（可被下一次调用打断并
     * 从当前位置接着转）；关掉动效时直接落位。
     */
    static void rotate(View view, float degrees) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        if (!enabled(view.getContext())) {
            view.setRotation(degrees);
            return;
        }
        view.animate().rotation(degrees)
                .setDuration(DURATION_STATE_MS)
                .setInterpolator(EASE_OUT)
                .start();
    }

    private static float scale(Context context, String key) {
        return Settings.Global.getFloat(context.getContentResolver(), key, 1f);
    }
}
