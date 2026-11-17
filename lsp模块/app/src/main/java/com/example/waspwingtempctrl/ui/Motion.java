package com.example.waspwingtempctrl.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * 界面动效的统一口径：曲线、时长模型与无障碍门控只有这一处。
 *
 * <p><b>曲线（三条，按用途分家）</b>：<b>面板高度及随之同步的展开箭头</b>（{@link #animateHeight} 的展开/收起、
 * {@link #beginLayoutChange} 的内容驱动高度变化、{@link #rotate(View, float, long)} 的角度旋转）用
 * {@link SlowEndsCurve}——{@code y = t − (强度/2π)·sin(2πt)}，两端慢、中段稳，强度由界面参数喂入
 * （见 {@link #setAnimTuning(float, long, float)}）。箭头必须与
 * 它所在面板<b>同曲线同时长</b>：只同时长不换曲线时，强 ease-out 会在四分之一处就把 90° 转完 78%，
 * 剩下四分之三的时间箭头原地等面板。{@link #EASE_OUT} 是强 ease-out，照抄 Web 侧
 * {@code cubic-bezier(0.23, 1, 0.32, 1)}，用于选择器压暗、表单首次露面这类"瞬时状态切换"——要前倾、快到位。
 * 而 {@link #crossFade}（含状态页「部署状态」换字）的交叉淡化用 {@link #FADE_CURVE}（线性）——
 * 新旧两层同时起止、互补覆盖，线性推进才不会在切换瞬间再叠一层"前快后慢"的观感差。
 * 其余动画不用平台内置曲线（太弱）。
 *
 * <p><b>时长模型（逻辑 2：起步时间 + 按位移递增，两个值可调）</b>：
 * {@code 时长 = (位移(dp) ÷ 速率 + 起步ms) ÷ 2}。<b>公式来历</b>：把「纯按位移递增」与「固定起步」
 * 取平均——{@code (位移(dp) ÷ 3.2 + 240) / 2}，兼顾短窗口（纯递增下 30dp 只有约 9ms，一闪而过）与
 * 长窗口。时长与曲线都由界面参数喂入（见 {@link #setAnimTuning(float, long, float)}，默认
 * 3.2 dp/ms · 240ms · 强度 0.60）。
 * <b>上界护栏 {@link #HARD_MAX_MS}</b>（600ms）默认参数下位移 > 3072dp 才咬到；另有一道<b>帧数下限</b>
 * {@link #MIN_FRAMES}（折算见 {@link #minFramesMs(Context)}）——**默认参数下最小 120ms，它从不生效，
 * 保留作安全网**。箭头这类位移恒定的动画<b>不套用本公式</b>：其时长直接取自同一次
 * {@link #animateHeight} 的返回值（见 {@link #rotate(View, float, long)}）。
 *
 * <p><b>与系统动画缩放的关系</b>：上述时长与平台上自动施加的系统动画缩放相互独立（本类是额外那一层，
 * 之后再压一道上限 {@link #HARD_MAX_MS} 与一道 {@link #MIN_FRAMES} 帧下限兜底）；参数由 app 启动路径
 * 读界面参数后喂入，非法值分别退回各自的默认值。
 *
 * <p><b>无障碍</b>：系统「动画时长缩放」关掉时，{@link #enabled(Context)} 为假，调用方须降级为
 * 瞬间完成——这是 Web 侧 {@code prefers-reduced-motion} 在本平台的对应物：动效更少更温和，
 * 而非全无（只去掉运动，信息照常呈现）。API 26+ 用
 * {@link ValueAnimator#areAnimatorsEnabled()}；API 25 退化为读
 * {@link Settings.Global#ANIMATOR_DURATION_SCALE}；另读
 * {@link Settings.Global#TRANSITION_ANIMATION_SCALE} 覆盖 {@code TransitionManager} 路径。
 */
public final class Motion {

    /**
     * 时长公式 {@code 时长 = (位移(dp) ÷ 速率 + 起步ms) ÷ 2} 的两个默认值（速率单位 dp/ms）与面板曲线的
     * 默认强度。由界面参数 {@code UI_ANIM_TUNING}（值形如 {@code 32 240 60}）喂入——速率
     * {@code 32 ÷ 10 = 3.2} dp/ms、起步 {@code 240} ms、强度 {@code 60 ÷ 100 = 0.60}。<b>公式来历</b>：
     * 把「纯按位移递增」与「固定起步」取平均——{@code (位移(dp) ÷ 3.2 + 240) / 2}。
     */
    private static final float DEFAULT_RATE_DP_PER_MS = 3.2f;
    private static final long DEFAULT_START_MS = 240L;
    private static final float DEFAULT_EASE_STRENGTH = 0.60f;

    /** 速率（dp/ms）：界面参数 {@code UI_ANIM_TUNING} 第 1 值 ÷ 10；非法值退回 {@link #DEFAULT_RATE_DP_PER_MS}。 */
    private static volatile float rateDpPerMs = DEFAULT_RATE_DP_PER_MS;

    /** 起步时间（毫秒）：界面参数 {@code UI_ANIM_TUNING} 第 2 值；非法值退回 {@link #DEFAULT_START_MS}。 */
    private static volatile long startMs = DEFAULT_START_MS;

    /**
     * 面板高度与展开箭头共用的曲线：强度取自界面参数 {@code UI_ANIM_TUNING} 第 3 值 ÷ 100
     * （见 {@link #setAnimTuning(float, long, float)}）。只在启动时整体换新，故一次动画读到的必是完整一条。
     */
    private static volatile Interpolator panelCurve = new SlowEndsCurve(DEFAULT_EASE_STRENGTH);

    /**
     * 时长<b>上限</b>护栏（毫秒）：只有算出的时长超过它才咬到——默认参数下位移 > 3072dp 才够得着
     * （{@code (3072 ÷ 3.2 + 240) ÷ 2 = 600}），现实里只有「操作记录」拉满那种超长体。保留的理由：
     * 超长体若仍按位移线性放大，动画会长到拖沓；这一道只做"防极端"，不参与日常观感。
     */
    private static final long HARD_MAX_MS = 600L;

    /**
     * 动画时长的<b>帧数下限</b>：再短的位移也至少走这么多帧，避免"不足一帧 = 直接到位"。
     * 折算见 {@link #minFramesMs(Context)}——帧长按设备实际刷新率取（不是写死 16.7ms）。
     */
    private static final int MIN_FRAMES = 2;

    /** 取不到刷新率时的缺省（Hz）：按 60Hz 折算下限，绝不因此抛异常。 */
    private static final float FALLBACK_REFRESH_HZ = 60f;

    /**
     * 强 ease-out，照抄 cubic-bezier(0.23, 1, 0.32, 1)；先建一次复用。用于<b>单层透明度过渡</b>
     * （选择器压暗、模式元素淡入、表单首次露面等，见 {@link #easeOut()}）——这类"瞬时状态切换"要前倾、快到位。
     * <b>交叉淡化与箭头旋转都不走这条</b>：前者用 {@link #FADE_CURVE}，后者与面板同步、用 {@link #panelCurve}。
     */
    private static final Interpolator EASE_OUT = new PathInterpolator(0.23f, 1f, 0.32f, 1f);

    /**
     * 面板高度类与展开箭头共用的曲线形状：{@code y = t − (强度/2π)·sin(2πt)}。强度由界面参数喂入
     * （{@link #panelCurve}），本类只管形状——<b>强度 0</b> = 匀速直线；<b>强度越大</b>两端越慢、中段越快
     * （三点斜率 {@code 1−强度 → 1+强度 → 1−强度}，天然左右对称）。强度 ≤1 时斜率恒 ≥0，故永不回退、不越界。
     * 默认强度 0.60 等效「时间/进度」锚点 {@code t=0.10→y≈0.044}、{@code t=0.25→y≈0.155}。
     * 用于<b>面板高度类</b>补间（{@link #animateHeight(View, boolean)} 与
     * {@link #beginLayoutChange(ViewGroup, float)} 里的尺寸变化）与<b>展开箭头旋转</b>
     * （{@link #rotate(View, float, long)}）——大位移用强 ease-out 会前倾过猛（25% 时间走完约 78% 位移）。
     * 箭头与所在面板<b>同曲线同时长</b>才锁得死，故箭头也用这条；交叉淡化不走这条，走 {@link #FADE_CURVE}。
     */
    private static final class SlowEndsCurve implements Interpolator {

        private final float strength;

        SlowEndsCurve(float strength) {
            this.strength = strength;
        }

        @Override
        public float getInterpolation(float input) {
            return (float) (input - strength / (2 * Math.PI) * Math.sin(2 * Math.PI * input));
        }
    }

    /** 正在跑的折叠体高度补间，按 content 视图记账：下一次调用据此先取消（打断即换向，不排队）。 */
    private static final WeakHashMap<View, ValueAnimator> HEIGHT_ANIMS = new WeakHashMap<>();

    private Motion() {
    }

    /**
     * 设置时长公式的两个值（{@code 时长 = (位移(dp) ÷ 速率 + 起步ms) ÷ 2}）与面板曲线的强度。
     * <b>非法值分别退回各自的默认值</b>（{@code ≤0/NaN} 的速率 → {@link #DEFAULT_RATE_DP_PER_MS}；
     * 负数的起步 → {@link #DEFAULT_START_MS}；{@code NaN} 或不在 {@code [0, 1]} 的强度 →
     * {@link #DEFAULT_EASE_STRENGTH}——<b>老配置只有两个值时走的正是这一条</b>）。启动时由 app 读界面参数
     * {@code UI_ANIM_TUNING} 喂入。
     *
     * @param rateDpPerMs 速率（dp/ms，{@code UI_ANIM_TUNING} 第 1 值 ÷ 10）
     * @param startMs 起步时间（毫秒，{@code UI_ANIM_TUNING} 第 2 值）
     * @param easeStrength 两端减速强度（0~1，{@code UI_ANIM_TUNING} 第 3 值 ÷ 100；0 = 匀速直线）
     */
    public static void setAnimTuning(float rateDpPerMs, long startMs, float easeStrength) {
        Motion.rateDpPerMs = (rateDpPerMs > 0f && !Float.isNaN(rateDpPerMs))
                ? rateDpPerMs : DEFAULT_RATE_DP_PER_MS;
        Motion.startMs = startMs >= 0L ? startMs : DEFAULT_START_MS;
        Motion.panelCurve = new SlowEndsCurve(easeStrength >= 0f && easeStrength <= 1f
                ? easeStrength : DEFAULT_EASE_STRENGTH);
    }

    /** 单层透明度过渡的曲线（强 ease-out，选择器压暗/模式元素淡入等复用）；交叉淡化不走这条（用 {@link #FADE_CURVE}）。 */
    static Interpolator easeOut() {
        return EASE_OUT;
    }

    /**
     * 与面板高度补间同曲线（{@link #panelCurve}，含界面参数喂入的强度）：供需要「跟随面板」的元素
     * （如分组卡展开时那条分隔线的淡入淡出）复用时序与曲线，做到与面板同步、不另设曲线。只读访问器，
     * 不改动曲线本身。
     */
    static Interpolator panelInterpolator() {
        return panelCurve;
    }

    /** 表单首次露面淡入的时长（ms）与起始下移（dp）。 */
    private static final long REVEAL_MS = 150L;
    private static final float REVEAL_TRANSLATE_DP = 6f;

    /**
     * 交叉淡入淡出的三段时长（毫秒）：新层淡入 {@link #FADE_IN_MS}、旧层淡出 {@link #FADE_OUT_MS}，
     * 两者在 t=0 同时起播、t=325ms 同时结束（延迟 {@link #FADE_OUT_DELAY_MS} 恒为 0，保留常量
     * 供调用方与派生时长复用）。两层互补覆盖，连续刷新时合成不透明度始终不低于单层，无中间空档。
     */
    static final long FADE_IN_MS = 325L;
    static final long FADE_OUT_MS = 325L;
    static final long FADE_OUT_DELAY_MS = 0L;

    /**
     * 交叉淡化的专用曲线：线性（{@link LinearInterpolator}）。alpha 与模糊半径共用同一条归一化
     * 进度；<b>只用于 {@link #crossFade}</b>，其它动画仍走 {@link #EASE_OUT} / {@link #panelCurve}。
     */
    private static final Interpolator FADE_CURVE = new LinearInterpolator();

    /**
     * 交叉淡化叠加的模糊上限（dp）：旧层随淡出由清晰变模糊、新层由模糊变清晰，用以掩盖切换闪烁。
     * 只做保守的柔化，强度不是重点；半径按 {@link #BLUR_STEPS} 档量化，只在跨档时重设效果，
     * 避免逐帧重做离屏滤波。需要 API 31 的 {@code RenderEffect}，不具备时静默退回纯 alpha。
     */
    private static final float FADE_BLUR_DP = 6f;

    /** 模糊半径的量化档数：每段淡化最多重设这么多次效果，其余帧只改 alpha。 */
    private static final int BLUR_STEPS = 4;

    /**
     * 允许叠加模糊的最大面积（占屏幕面积比例）：超过即退回纯 alpha。全屏层（如日志列表整张）
     * 每帧离屏滤波代价高，宁可只淡不糊。
     */
    private static final float BLUR_MAX_SCREEN_FRACTION = 0.30f;

    /**
     * 同时交叉淡化：旧内容先在视图原位置留成一张快照层淡出，新内容在它下方同步淡入。
     *
     * <p><b>同时起止</b>：新层从 0 淡到 1、旧层从 1 淡到 0，两层都在 t=0 起播、t=325ms 结束
     * （{@link #FADE_OUT_DELAY_MS} = 0），同用线性的 {@link #FADE_CURVE}。两层互补覆盖，
     * 合成不透明度始终不低于单层，没有「先退完再进」造成的中间空档。
     *
     * <p><b>业务内容零延迟</b>：{@code swap} 立即执行，动画只是视觉层；视图容器换内容后按新旧两帧
     * 同时淡化。旧层用 {@link View#draw(Canvas)} 抓成位图、经父容器的 {@link ViewGroup#getOverlay()}
     * 叠在原位——不参与触摸命中，不会挡住淡变期间的点击。
     *
     * <p><b>模糊辅助（API 31+）</b>：旧层淡出的同时由清晰变模糊，新层淡入时由模糊变清晰，半径与
     * alpha 走同一条 {@link #FADE_CURVE} 同步推进（旧层 0 → {@link #FADE_BLUR_DP}dp，新层反向），
     * 用以掩盖切换瞬间的闪烁。半径按 {@link #BLUR_STEPS} 档量化，只在跨档时重设
     * {@code RenderEffect}；旧层快照一次录进 {@code RenderNode}，之后逐帧只改节点 alpha。
     * 无 {@code RenderEffect}（低版本 / 软件渲染）或面积超过屏幕
     * {@link #BLUR_MAX_SCREEN_FRACTION}（如整张列表）时静默退回纯 alpha，不崩、不逐帧重滤波。
     *
     * <p>系统关掉动效、或没有可淡的视图时直接执行 {@code swap}，并把 alpha 复位为 1，
     * 不留半透明残影。重复调用会先收掉上一轮（取消动画、移除快照层），不叠加残影。
     *
     * @param swap    换内容（立即执行）
     * @param targets 参与淡入淡出的视图（旧内容按各自当前外观抓快照；GONE / 未量出尺寸的跳过抓取，
     *                但仍参与淡入）
     */
    static void crossFade(@Nullable Runnable swap, @Nullable View... targets) {
        if (swap == null) {
            return;
        }
        List<View> views = new ArrayList<>();
        if (targets != null) {
            for (View v : targets) {
                if (v != null && !views.contains(v)) {
                    views.add(v);
                }
            }
        }
        if (views.isEmpty()) {
            swap.run();
            return;
        }
        for (View v : views) {
            CrossFadeRun running = CROSS_FADES.remove(v);
            if (running != null) {
                running.finish();
            }
            v.animate().cancel();
        }
        if (!enabled(views.get(0).getContext())) {
            for (View v : views) {
                v.setAlpha(1f);
            }
            swap.run();
            return;
        }
        CrossFadeRun run = new CrossFadeRun();
        run.views.addAll(views);
        for (View v : views) {
            CROSS_FADES.put(v, run);
            captureLayer(v, run);
        }
        for (View v : views) {
            v.setAlpha(0f);   // 新内容先透明，避免换内容的瞬间以不透明状态闪一帧
        }
        try {
            swap.run();
        } finally {
            for (View v : views) {
                startFadeIn(v, run);
            }
            for (FadeLayer layer : run.layers) {
                ValueAnimator fade = ValueAnimator.ofInt(255, 0);
                fade.setDuration(FADE_OUT_MS);
                fade.setStartDelay(FADE_OUT_DELAY_MS);
                fade.setInterpolator(FADE_CURVE);
                final float maxBlurPx = layer.maxBlurPx();
                fade.addUpdateListener(a -> {
                    int value = (Integer) a.getAnimatedValue();
                    layer.setAlpha(value);
                    // 与 alpha 同一条曲线、同一拍：越淡越糊，消失时正好最糊
                    layer.setBlurRadius(maxBlurPx * (1f - value / 255f));
                });
                run.anims.add(fade);
                fade.start();
            }
            MAIN.postDelayed(run, FADE_OUT_DELAY_MS + FADE_OUT_MS + 16L);
        }
    }

    /**
     * 新内容淡入：alpha 与模糊同曲线（{@link #FADE_CURVE}，线性）、同起止——半径由
     * {@link #FADE_BLUR_DP}dp 降到 0，视觉上从模糊变清晰。半径量化后只在跨档时施加；不满足
     * {@link #blurAllowed(View)} 时只播 alpha。模糊动画单独记账，随 {@link CrossFadeRun#finish()}
     * 一起取消并清效果。
     */
    private static void startFadeIn(View v, CrossFadeRun run) {
        v.animate().alpha(1f).setDuration(FADE_IN_MS).setInterpolator(FADE_CURVE).start();
        if (!blurAllowed(v)) {
            return;
        }
        final float maxPx = blurRadiusPx(v.getContext());
        final float[] lastPx = {maxPx};
        applyViewBlur(v, maxPx);   // 首帧就带模糊，避免先清晰露一下
        ValueAnimator blur = ValueAnimator.ofFloat(1f, 0f);
        blur.setDuration(FADE_IN_MS);
        blur.setInterpolator(FADE_CURVE);
        blur.addUpdateListener(a -> {
            float q = quantizeBlur(maxPx * (Float) a.getAnimatedValue(), maxPx);
            if (q != lastPx[0]) {
                lastPx[0] = q;
                applyViewBlur(v, q);
            }
        });
        blur.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                applyViewBlur(v, 0f);   // 结束/取消都摘掉效果，视图恢复普通合成
            }
        });
        run.anims.add(blur);
        blur.start();
    }

    /** 交叉淡化所用模糊半径上限（像素）：按屏幕密度把 {@link #FADE_BLUR_DP} 换算成像素。 */
    private static float blurRadiusPx(Context context) {
        float density = 1f;
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
            if (density <= 0f) {
                density = 1f;
            }
        }
        return FADE_BLUR_DP * density;
    }

    /**
     * 该视图能否承受离屏模糊：API 31+、已量出尺寸、且面积不超过屏幕的
     * {@link #BLUR_MAX_SCREEN_FRACTION}。任一不满足即退回纯 alpha——稳定与低开销优先。
     */
    private static boolean blurAllowed(View v) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return false;
        }
        int w = v.getWidth();
        int h = v.getHeight();
        if (w <= 0 || h <= 0) {
            return false;
        }
        DisplayMetrics dm = v.getResources().getDisplayMetrics();
        long screen = (long) dm.widthPixels * dm.heightPixels;
        return screen > 0L && (long) w * h <= (long) (screen * BLUR_MAX_SCREEN_FRACTION);
    }

    /** 半径按 {@link #BLUR_STEPS} 档量化：同一档内不重设效果，把离屏滤波次数压到每段动画 ≤ 档数。 */
    private static float quantizeBlur(float radiusPx, float maxPx) {
        if (maxPx <= 0f) {
            return 0f;
        }
        float step = maxPx / BLUR_STEPS;
        return Math.round(radiusPx / step) * step;
    }

    /** 给目标视图施加（或清除）模糊；任何异常都吞掉并按"无效果"处理，绝不把异常抛给业务。 */
    private static void applyViewBlur(View v, float radiusPx) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return;
        }
        try {
            BlurSupport.setViewBlur(v, radiusPx);
        } catch (Throwable t) {
            try {
                BlurSupport.setViewBlur(v, 0f);
            } catch (Throwable ignored) {
                // 效果 API 在该设备不可用：保持纯 alpha
            }
        }
    }

    /** 主线程收尾用的 handler：快照层与动画的清理不依赖某个视图是否还挂在窗口上。 */
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** 每个参与视图 → 本轮交叉淡化的运行态；重复调用据此先收掉上一轮。 */
    private static final WeakHashMap<View, CrossFadeRun> CROSS_FADES = new WeakHashMap<>();

    /** 一轮同时交叉淡化的运行态：快照层、动画与收尾。 */
    private static final class CrossFadeRun implements Runnable {
        final List<View> views = new ArrayList<>();
        final List<ViewGroup> hosts = new ArrayList<>();
        final List<FadeLayer> layers = new ArrayList<>();
        final List<Bitmap> bitmaps = new ArrayList<>();
        final List<Animator> anims = new ArrayList<>();
        boolean done;

        @Override
        public void run() {
            finish();
        }

        /** 收尾：取消动画、把快照层从父容器 overlay 移除并回收位图，视图 alpha 复位为 1。 */
        void finish() {
            if (done) {
                return;
            }
            done = true;
            MAIN.removeCallbacks(this);
            for (Animator a : anims) {
                a.cancel();
            }
            anims.clear();
            for (int i = 0; i < layers.size(); i++) {
                ViewGroup host = i < hosts.size() ? hosts.get(i) : null;
                FadeLayer layer = layers.get(i);
                if (host != null) {
                    host.getOverlay().remove(layer);
                }
                layer.release();
                Bitmap bmp = i < bitmaps.size() ? bitmaps.get(i) : null;
                if (bmp != null && !bmp.isRecycled()) {
                    bmp.recycle();
                }
            }
            layers.clear();
            hosts.clear();
            bitmaps.clear();
            for (View v : views) {
                if (CROSS_FADES.get(v) == this) {
                    CROSS_FADES.remove(v);
                }
                v.animate().cancel();
                v.setAlpha(1f);
                applyViewBlur(v, 0f);   // 取消即摘效果，不留模糊残影
            }
            views.clear();
        }
    }

    /** 把一个视图的当前外观抓成位图，作为快照层加到父容器的 overlay（坐标与视图原位一致）。 */
    private static void captureLayer(View v, CrossFadeRun run) {
        if (v.getVisibility() != View.VISIBLE || v.getWidth() <= 0 || v.getHeight() <= 0) {
            return;
        }
        ViewParent parent = v.getParent();
        if (!(parent instanceof ViewGroup)) {
            return;
        }
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
            v.draw(new Canvas(bitmap));
        } catch (Throwable t) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return;   // 抓不到快照（极端视图/内存不足）：本轮退化为「新内容淡入」，不抛给业务
        }
        float maxBlurPx = blurAllowed(v) ? blurRadiusPx(v.getContext()) : 0f;
        // 带模糊的子类只在 API 31+ 实例化：低版本连类都不会加载
        FadeLayer layer = maxBlurPx > 0f && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
                ? new BlurFadeLayer(bitmap, maxBlurPx)
                : new FadeLayer(bitmap, maxBlurPx);
        layer.setBounds(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        layer.setAlpha(255);
        ViewGroup host = (ViewGroup) parent;
        host.getOverlay().add(layer);
        run.hosts.add(host);
        run.layers.add(layer);
        run.bitmaps.add(bitmap);
    }

    /**
     * 旧内容快照层（退化实现）：直接按 alpha 画位图，行为与原先的 {@code BitmapDrawable} 一致。
     * 本类<b>不引用任何 API 31 类型</b>；带模糊的版本见 {@link BlurFadeLayer}，低版本根本不加载它。
     */
    private static class FadeLayer extends Drawable {

        final Bitmap bitmap;
        final float maxBlurPx;
        final Paint paint = new Paint();
        int alpha = 255;

        FadeLayer(Bitmap bitmap, float maxBlurPx) {
            this.bitmap = bitmap;
            this.maxBlurPx = maxBlurPx;
        }

        float maxBlurPx() {
            return maxBlurPx;
        }

        /** 无效果时的退化实现：只靠 alpha（本类无模糊可施加）。 */
        void setBlurRadius(float radiusPx) {
        }

        /** 收尾钩子：退化实现无事可做（位图由调用方统一回收）。 */
        void release() {
        }

        @Override
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            if (bitmap.isRecycled() || bounds.isEmpty()) {
                return;
            }
            paint.setAlpha(alpha);
            canvas.drawBitmap(bitmap, null, bounds, paint);
        }

        @Override
        public void setAlpha(int alpha) {
            this.alpha = alpha;
            invalidateSelf();
        }

        @Override
        public int getAlpha() {
            return alpha;
        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            paint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }
    }

    /**
     * 带模糊的快照层（仅 API 31+ 实例化）：位图一次录进 {@link RenderNode}，之后逐帧只改节点
     * alpha；模糊只改节点效果，不重录内容。同一量化档内系统可复用离屏层，不重复滤波。
     * 录音失败或画布非硬件加速时自动走 {@link FadeLayer} 的直接绘制。
     */
    private static final class BlurFadeLayer extends FadeLayer {

        private RenderNode node;
        private float appliedBlurPx = -1f;

        BlurFadeLayer(Bitmap bitmap, float maxBlurPx) {
            super(bitmap, maxBlurPx);
            try {
                node = BlurSupport.record(bitmap);
                appliedBlurPx = 0f;
            } catch (Throwable t) {
                node = null;   // 极端尺寸/内存不足：退化为直接画位图
            }
        }

        @Override
        void setBlurRadius(float radiusPx) {
            if (node == null) {
                return;
            }
            float q = quantizeBlur(radiusPx, maxBlurPx);
            if (q == appliedBlurPx) {
                return;
            }
            appliedBlurPx = q;
            try {
                BlurSupport.setNodeBlur(node, q);
            } catch (Throwable t) {
                node = null;   // 效果不可用：本层退回直接画位图（alpha 照常）
            }
        }

        @Override
        void release() {
            if (node != null) {
                try {
                    BlurSupport.setNodeBlur(node, 0f);
                    node.discardDisplayList();   // 先放掉对位图的引用，调用方随后回收
                } catch (Throwable ignored) {
                    // 节点即将丢弃，忽略
                }
                node = null;
            }
        }

        @Override
        public void draw(Canvas canvas) {
            if (node == null || !canvas.isHardwareAccelerated()) {
                super.draw(canvas);
                return;
            }
            Rect bounds = getBounds();
            if (bitmap.isRecycled() || bounds.isEmpty()) {
                return;
            }
            node.setAlpha(alpha / 255f);
            canvas.save();
            canvas.translate(bounds.left, bounds.top);
            canvas.drawRenderNode(node);
            canvas.restore();
        }
    }

    /**
     * API 31+ 的效果实现集中在这一个嵌套类：类只在实际执行时加载，低版本不会触碰
     * {@link RenderEffect} / {@link RenderNode}，避免类校验期引用不可用类型。
     */
    private static final class BlurSupport {

        private BlurSupport() {
        }

        static void setViewBlur(View v, float radiusPx) {
            v.setRenderEffect(radiusPx >= 1f
                    ? RenderEffect.createBlurEffect(radiusPx, radiusPx, Shader.TileMode.CLAMP)
                    : null);
        }

        /** 把位图一次录进节点：之后只改 alpha / 效果，不重录内容。 */
        static RenderNode record(Bitmap bitmap) {
            int w = bitmap.getWidth();
            int h = bitmap.getHeight();
            RenderNode node = new RenderNode("motionCrossFade");
            node.setPosition(0, 0, w, h);
            RecordingCanvas canvas = node.beginRecording(w, h);
            canvas.drawBitmap(bitmap, 0f, 0f, null);
            node.endRecording();
            return node;
        }

        static void setNodeBlur(RenderNode node, float radiusPx) {
            node.setRenderEffect(radiusPx >= 1f
                    ? RenderEffect.createBlurEffect(radiusPx, radiusPx, Shader.TileMode.CLAMP)
                    : null);
        }
    }

    /** 未选中项的选择器按钮压到该透明度；与日志页来源选择器一致。 */
    private static final float SELECTED_DIM_ALPHA = 0.55f;

    /**
     * 选择器压暗/恢复的过渡时长。原本借用交叉淡入的时长（270ms），交叉淡化改成 325ms 后
     * 单独定值，避免顺带改变选择器手感；曲线仍用 {@link #EASE_OUT}。
     */
    private static final long SELECTED_FADE_MS = 270L;

    /**
     * 选择器（{@link android.widget.RadioButton} 式的单选按钮组、Material 的
     * {@code MaterialButtonToggleGroup} 等任意 ViewGroup）：选中项不透明、未选中项压到
     * {@link #SELECTED_DIM_ALPHA}，过渡时长与曲线同 {@link #SELECTED_FADE_MS} / {@link #EASE_OUT}。
     *
     * <p>日志页来源选择器（daemon / LSPosed）、曲线页窗口档位与配置页 enum 选择器共用这一处口径，
     * 不各自写一套。
     *
     * @param group     按钮组（子项即选项）
     * @param checkedId 当前选中项的 id；{@link View#NO_ID} = 无选中项（全部压暗）
     * @param animate   false = 首帧直接落位（页面打开时不自己播一段动画）
     */
    static void syncSelectedAlpha(@Nullable ViewGroup group, int checkedId, boolean animate) {
        if (group == null) {
            return;
        }
        for (int i = 0; i < group.getChildCount(); i++) {
            View child = group.getChildAt(i);
            if (child == null) {
                continue;
            }
            boolean selected = checkedId != View.NO_ID && child.getId() == checkedId;
            if (animate) {
                animateSelected(child, selected);
            } else {
                child.animate().cancel();
                child.setAlpha(selected ? 1f : SELECTED_DIM_ALPHA);
            }
        }
    }

    /** 选中态切换的过渡：选中项恢复不透明、未选中项压到 55%，时长 {@link #SELECTED_FADE_MS} + {@link #EASE_OUT}。 */
    private static void animateSelected(@Nullable View view, boolean selected) {
        if (view == null) {
            return;
        }
        float target = selected ? 1f : SELECTED_DIM_ALPHA;
        if (!enabled(view.getContext())) {
            view.setAlpha(target);
            return;
        }
        view.animate().alpha(target).setDuration(SELECTED_FADE_MS).setInterpolator(EASE_OUT).start();
    }

    /**
     * 表单首次露面的入场：容器从「透明 + 下移 {@link #REVEAL_TRANSLATE_DP}dp」淡入到位
     * （{@link #REVEAL_MS}ms，强 ease-out）。<b>只动 alpha / translationY，不改布局</b>，故「建满一次露出」
     * 的口径不变——每一帧露出的都是建满的完整表单，只是半透明，绝不出现半成品。
     *
     * <p>系统关掉动效时不做任何事（容器保持默认可见态，等价于直接露面）。调用时机：{@code onFormBuilt}
     * 里设初始态（此刻容器尚未被置为可见），补间延到下一帧再起——那时其宿主已把它置为可见。
     */
    static void revealFadeIn(View container) {
        if (container == null || !enabled(container.getContext())) {
            return;
        }
        float d = container.getResources().getDisplayMetrics().density;
        container.setAlpha(0f);
        container.setTranslationY(REVEAL_TRANSLATE_DP * d);
        container.post(() -> container.animate().alpha(1f).translationY(0f)
                .setDuration(REVEAL_MS).setInterpolator(EASE_OUT).start());
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
     * 位移量（像素）对应的时长：{@code round((位移dp ÷ 速率 + 起步ms) ÷ 2)} → 上限
     * {@link #HARD_MAX_MS} → 帧数下限 {@link #MIN_FRAMES}。
     */
    static long durationForPixels(Context context, float pixels) {
        float density = 1f;
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
            if (density <= 0f) {
                density = 1f;
            }
        }
        double dp = pixels / density;
        long base = Math.round((dp / rateDpPerMs + startMs) / 2.0);
        return clampDuration(base, context);
    }

    /** 只此一处：压上限 {@link #HARD_MAX_MS}，再压 {@link #MIN_FRAMES} 帧下限（默认参数下后者从不咬到）。 */
    private static long clampDuration(long ms, Context context) {
        return Math.max(Math.min(ms, HARD_MAX_MS), minFramesMs(context));
    }

    /**
     * {@link #MIN_FRAMES} 帧对应的毫秒数：{@code round(MIN_FRAMES × 1000 / 刷新率)}。
     * 刷新率取设备实际值（API 30+ 走 {@link Context#getDisplay()}，更低版本走
     * {@link WindowManager#getDefaultDisplay()}）；<b>取不到或值异常（≤0）退回 60Hz</b>，任何异常都吞掉。
     */
    private static long minFramesMs(Context context) {
        float hz = FALLBACK_REFRESH_HZ;
        if (context != null) {
            try {
                Display display = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    display = context.getDisplay();
                } else {
                    Object service = context.getSystemService(Context.WINDOW_SERVICE);
                    if (service instanceof WindowManager) {
                        display = ((WindowManager) service).getDefaultDisplay();
                    }
                }
                if (display != null) {
                    float rate = display.getRefreshRate();
                    if (rate > 0f && !Float.isNaN(rate)) {
                        hz = rate;
                    }
                }
            } catch (Throwable t) {
                hz = FALLBACK_REFRESH_HZ;
            }
        }
        return Math.round(MIN_FRAMES * 1000f / hz);
    }

    /**
     * 把视图转到给定角度，时长由调用方给出（<b>不另设常量</b>）：三个展开箭头都用同一次
     * {@link #animateHeight} 的返回值驱动，与所在面板同生共灭——面板走动画就是同一时长，
     * 面板直接落位（系统关动效 / {@code from == to}，此时 {@code durationMs < 0}）箭头也直接落位。
     * 系统关动效、时长非法（{@code ≤0}）或已在目标角时直接落位。曲线用 {@link #panelCurve}——与面板那条
     * 相同，故任一时刻的角度进度与面板的高度进度<b>逐点相等</b>（换用强 ease-out 会让箭头在四分之一处
     * 就转完 78%、剩下时间原地等面板）。
     *
     * @param durationMs 与所在面板同一次的动画时长（毫秒）；{@code <0} = 该面板本次未走动画
     */
    static void rotate(View view, float degrees, long durationMs) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        if (!enabled(view.getContext()) || durationMs <= 0L || view.getRotation() == degrees) {
            view.setRotation(degrees);
            return;
        }
        view.animate().rotation(degrees)
                .setDuration(durationMs)
                .setInterpolator(panelCurve)
                .start();
    }

    /** 展开态的箭头旋转角：图标指向右，顺时针 90° 即指向下（收起态不转，复位指右）。各可展开条共用这一处口径。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    /**
     * 展开/收起的「展开箭头」同步：以面板同一次返回的 {@code durationMs} 把箭头转到展开角
     * （{@link #ARROW_EXPANDED_ROTATION}）或复位，并同步无障碍描述（展开 = 可收起、收起 = 可展开）。
     *
     * <p>把「角度选择 + 旋转 + 换无障碍描述」这三步收敛到一处，角度/时长/曲线口径逐位沿用
     * {@link #rotate(View, float, long)}（与所在面板同曲线同时长），本方法不新增任何动效常量。
     * 面板本体的量高/补间仍由调用方负责（各处的正文准备时序不同），本方法只做与面板同生共灭的
     * 箭头那一段，须在拿到 {@link #animateHeight(View, boolean)} 的返回值之后调用。
     *
     * @param arrow 展开箭头视图（{@code null} 时什么都不做）
     * @param expanded true = 展开（转 90° 指向下）；false = 收起（复位指右）
     * @param durationMs 与所在面板同一次的动画时长（毫秒）；{@code <0} = 该面板本次未走动画，箭头直接落位
     */
    static void syncExpandArrow(ImageView arrow, boolean expanded, long durationMs) {
        if (arrow == null) {
            return;
        }
        rotate(arrow, expanded ? ARROW_EXPANDED_ROTATION : 0f, durationMs);
        arrow.setContentDescription(arrow.getContext().getString(
                expanded ? R.string.config_action_collapse : R.string.config_action_expand));
    }

    /**
     * 展开/收起一个 {@code wrap_content} 容器：按逻辑 2 的时长逐帧改其高度。
     *
     * <p><b>两向同一把尺子</b>：终点都取"实高"——收起读已布局实高，展开在**最终宽度**上量自然高
     * （{@code GONE} 折叠体无已布局高度，量宽与最终宽一致时量到的高即实高）。<b>不再用"是否已排版"
     * 作门</b>：{@code GONE} 子视图永不参与父容器排版，那道门会让首次展开恒为"直接落位"（零动画）。
     *
     * <p>打断即换向——同一次调用先取消本视图在跑的高度补间，再从**当前高度**接着动，连点不排队、不卡住。
     * 系统关掉动效、或展开时宽度不可知（父容器尚未排版，只能退回屏幕宽）时直接落位。
     *
     * @param expand true = 展开（量出内容高并从当前高度长过去）；false = 收起（收到 0 再置 {@code GONE}）
     * @return 本次动画的时长（毫秒）；<b>本次直接落位（未走动画）时返回 {@code -1}</b>——调用方据此驱动
     *         同一次交互里的箭头，做到"面板动画＝箭头动画、面板落位＝箭头落位"
     */
    static long animateHeight(View content, boolean expand) {
        if (content == null) {
            return -1L;
        }
        final ValueAnimator running = HEIGHT_ANIMS.remove(content);
        if (running != null) {
            // 先摘账再取消：旧动画的 onAnimationEnd 会因对不上号而空跑，不会误置最终态
            running.cancel();
        }
        final ViewGroup.LayoutParams lp = content.getLayoutParams();
        if (lp == null) {
            content.setVisibility(expand ? View.VISIBLE : View.GONE);
            return -1L;
        }
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
        // 起点/终点都定下来才判能不能动画。展开必须有"量得出的最终宽"：量不到宽时只能退回屏幕宽，
        // 那量出来的高不是实高（末尾会跳），宁可直接落位也不按错高动画；收起不用量目标（恒为 0）。
        boolean animate = enabled(content.getContext())
                && (!expand || widthKnown(content))
                && from != to;
        if (!animate) {
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            content.setVisibility(expand ? View.VISIBLE : View.GONE);
            content.requestLayout();
            return -1L;   // 本次未走动画
        }
        final ValueAnimator anim = ValueAnimator.ofInt(from, to);
        final long duration = durationForPixels(content.getContext(), Math.abs(to - from));
        anim.setDuration(duration);
        anim.setInterpolator(panelCurve);
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
        return duration;
    }

    /**
     * 已知起点/终点高度时的高度补间（用于"原地换文本后行高变化"这类内容驱动场景）。
     *
     * <p>与 {@link #animateHeight(View, boolean)} 并列、共用同一张 {@link #HEIGHT_ANIMS} 记账表：
     * 同一个视图上两种补间可互相取消，连点不排队。过程：先把高度钉到 {@code fromPx} 并请求重排，
     * 再逐帧改到 {@code toPx}，结束时还原 {@code WRAP_CONTENT}。时长与曲线沿用面板那套口径
     * （{@link #durationForPixels(Context, float)} + {@link #panelCurve}），箭头据此与行高同生共灭。
     *
     * <p><b>不满足补间条件时直接返回 {@code -1}、不设置动画高度</b>：系统关动效、起点不可用
     * （{@code fromPx <= 0}）、终点不可用（{@code toPx <= 0}）、或两者相等。本次没有动画，
     * 故把高度还原为 {@code WRAP_CONTENT}（若此前被钉在中间高，不能留在那里）。
     *
     * @return 本次动画时长（毫秒）；直接落位时返回 {@code -1}
     */
    static long animateHeightChange(View content, int fromPx, int toPx) {
        return animateHeightChange(content, fromPx, toPx, -1L);
    }

    /**
     * 同上，另可指定显式时长：用于需要与另一条动画（如状态卡换字的交叉淡变）同起同止的场景。
     *
     * @param durationMs 动画时长（毫秒）；{@code <= 0} 时退回按位移定时长
     *                   （{@link #durationForPixels(Context, float)}）
     */
    static long animateHeightChange(View content, int fromPx, int toPx, long durationMs) {
        if (content == null) {
            return -1L;
        }
        final ValueAnimator running = HEIGHT_ANIMS.remove(content);
        if (running != null) {
            // 先摘账再取消：旧动画的 onAnimationEnd 会因对不上号而空跑，不会误置最终态
            running.cancel();
        }
        final ViewGroup.LayoutParams lp = content.getLayoutParams();
        if (lp == null) {
            return -1L;
        }
        if (fromPx <= 0 || toPx <= 0 || fromPx == toPx || !enabled(content.getContext())) {
            // 本次不补间：还原自然高（可能被 keepHeight 等路径钉住，不能留下中间/固定高）
            if (lp.height != ViewGroup.LayoutParams.WRAP_CONTENT) {
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                content.requestLayout();
            }
            return -1L;
        }
        final ValueAnimator anim = ValueAnimator.ofInt(fromPx, toPx);
        final long duration = durationMs > 0L
                ? durationMs : durationForPixels(content.getContext(), Math.abs(toPx - fromPx));
        anim.setDuration(duration);
        anim.setInterpolator(panelCurve);
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
                content.requestLayout();
            }
        });
        HEIGHT_ANIMS.put(content, anim);
        lp.height = fromPx;
        content.requestLayout();
        anim.start();
        return duration;
    }

    /**
     * 量出容器在 {@code wrap_content} 下的完整高——展开时它就是**最终实高**（在最终宽度上量）。
     *
     * <p><b>绕开"GONE 下测量为 0"的经典坑</b>：调用前须已置 {@code VISIBLE}；这里用
     * {@code height=UNSPECIFIED} 直接测内容，不受当前 {@code lp.height}（可能为 0 或动画中间值）影响。
     * 量宽见 {@link #measuredWidthFor(View)}——若最终宽不可知（只能退回屏幕宽），量出的高不是实高，
     * {@link #animateHeight(View, boolean)} 会因此放弃动画、直接落位。
     */
    private static int measureHeight(View content) {
        ViewGroup.LayoutParams lp = content.getLayoutParams();
        int oldHeight = lp != null ? lp.height : ViewGroup.LayoutParams.WRAP_CONTENT;
        int width = measuredWidthFor(content);
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
     * 量高该用的宽：孩子填满父宽（{@code match_parent}）时优先"父内容宽"（扣掉折叠体自身左右外边距），
     * 否则用"已布局实宽"，最后才退回屏幕宽。<b>屏幕宽是兜底、不是实宽</b>——按它量出的换行会与最终
     * 不符，故 {@link #widthKnown(View)} 不认它。
     *
     * <p><b>为什么父宽优先</b>：自身宽是上次排版留下的值，{@code GONE} 期间父宽若变了它就是陈旧的；
     * 父内容宽则永远是这一趟的最终宽。对不填满父宽的孩子"父内容宽"不成立，故先看
     * {@link #fillsParentWidth(View)}。
     */
    private static int measuredWidthFor(View content) {
        if (fillsParentWidth(content)) {
            int fromParent = widthFromParent(content);
            if (fromParent > 0) {
                return fromParent;
            }
        }
        int width = content.getWidth();
        if (width > 0) {
            return width;
        }
        int fromParent = widthFromParent(content);
        if (fromParent > 0) {
            return fromParent;
        }
        return content.getResources().getDisplayMetrics().widthPixels;
    }

    /** 孩子是否按"填满父内容宽"排版（{@code match_parent}）——只有这种孩子，"父内容宽"才是它的最终宽。 */
    private static boolean fillsParentWidth(View content) {
        ViewGroup.LayoutParams lp = content.getLayoutParams();
        return lp != null && lp.width == ViewGroup.LayoutParams.MATCH_PARENT;
    }

    /**
     * 展开能不能按"实高"计时：宽度必须来自实宽（自身已布局宽或父内容宽），不能来自屏幕宽兜底。
     * 三者（自身宽 / 父宽−内边距 / 屏幕宽）里前两个都准，最后一个不准——它的到来意味着父容器
     * 尚未排版，此刻量出的高不是最终高。见 {@link #measuredWidthFor(View)}。
     */
    private static boolean widthKnown(View content) {
        return content.getWidth() > 0 || widthFromParent(content) > 0;
    }

    /** 折叠体的最终可用宽（父内容宽扣掉它自身的左右外边距）；父不是 View 或尚未排版时返回 ≤0。 */
    private static int widthFromParent(View content) {
        ViewParent parent = content.getParent();
        if (!(parent instanceof View)) {
            return 0;
        }
        View p = (View) parent;
        return p.getWidth() - p.getPaddingLeft() - p.getPaddingRight()
                - horizontalMarginsOf(content);
    }

    /** 折叠体自身的左右外边距（量宽时须扣掉，否则宽会偏大、换行与最终不符）。 */
    private static int horizontalMarginsOf(View content) {
        ViewGroup.LayoutParams lp = content.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) lp;
            return mlp.leftMargin + mlp.rightMargin;
        }
        return 0;
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
     *
     * <p>用平台自带的 {@code android.transition}（{@link AutoTransition} + {@link TransitionManager}，
     * API 19+，minSdk 25 满足）：过渡语义为边界变化 + 淡入淡出。本类的曲线（{@link SlowEndsCurve}，
     * 实现 {@link Interpolator}）经 API 22+ 的 {@code Interpolator extends TimeInterpolator} 直接喂入
     * {@link android.transition.Transition#setInterpolator}。
     */
    static void beginLayoutChange(ViewGroup root, float deltaPx) {
        if (root == null || !enabled(root.getContext())) {
            return;
        }
        AutoTransition transition = new AutoTransition();
        transition.setDuration(durationForPixels(root.getContext(), Math.abs(deltaPx)));
        transition.setInterpolator(panelCurve);
        TransitionManager.beginDelayedTransition(root, transition);
    }

    /**
     * 中止某视图在跑的高度补间并还原 {@code WRAP_CONTENT}（不留下钉死的中间高度）。
     * 用于换字动画离屏/销毁时的收尾：{@link #animateHeightChange} 的 onAnimationEnd 只认
     * {@link #HEIGHT_ANIMS} 里的当前 animator，先摘账再取消即可让它空跑、由本方法统一落位。
     */
    static void cancelHeightChange(View content) {
        if (content == null) {
            return;
        }
        final ValueAnimator running = HEIGHT_ANIMS.remove(content);
        if (running != null) {
            running.cancel();
        }
        final ViewGroup.LayoutParams lp = content.getLayoutParams();
        if (lp != null) {
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            content.requestLayout();
        }
    }

    private static float scale(Context context, String key) {
        return Settings.Global.getFloat(context.getContentResolver(), key, 1f);
    }
}
