package com.example.waspwingtempctrl.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import java.util.WeakHashMap;

/**
 * 界面动效的统一口径：曲线、时长模型与无障碍门控只有这一处。
 *
 * <p><b>曲线（两条，按用途分家）</b>：<b>面板高度及随之同步的展开箭头</b>（{@link #animateHeight} 的展开/收起、
 * {@link #beginLayoutChange} 的内容驱动高度变化、{@link #rotate(View, float, long)} 的角度旋转）用
 * {@link SlowEndsCurve}——{@code y = t − (强度/2π)·sin(2πt)}，两端慢、中段稳，强度由界面参数喂入
 * （见 {@link #setAnimTuning(float, long, float)}）。箭头必须与
 * 它所在面板<b>同曲线同时长</b>：只同时长不换曲线时，强 ease-out 会在四分之一处就把 90° 转完 78%，
 * 剩下四分之三的时间箭头原地等面板。{@code StatusFragment} 状态卡的<b>交叉淡入</b>用 {@link #EASE_OUT}
 * ——强 ease-out，照抄 Web 侧 {@code cubic-bezier(0.23, 1, 0.32, 1)}；透明度这类"瞬时状态切换"要前倾、快到位。
 * 不用平台内置曲线（太弱）。
 *
 * <p><b>时长模型（逻辑 2：起步时间 + 按位移递增，两个值可调）</b>：
 * {@code 时长 = (位移(dp) ÷ 速率 + 起步ms) ÷ 2}。<b>公式来历</b>：把「纯按位移递增」与「固定起步」
 * 取平均——{@code (位移(dp) ÷ 3.2 + 240) / 2}，兼顾短窗口（纯递增下 30dp 只有约 9ms，一闪而过）与
 * 长窗口。时长与曲线都由界面参数喂入（见 {@link #setAnimTuning(float, long, float)}，默认
 * 3.2 dp/ms · 240ms · 强度 0.63）。
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
     * 默认强度。由界面参数 {@code UI_ANIM_TUNING}（值形如 {@code 32 240 63}）喂入——速率
     * {@code 32 ÷ 10 = 3.2} dp/ms、起步 {@code 240} ms、强度 {@code 63 ÷ 100 = 0.63}。<b>公式来历</b>：
     * 把「纯按位移递增」与「固定起步」取平均——{@code (位移(dp) ÷ 3.2 + 240) / 2}。
     */
    private static final float DEFAULT_RATE_DP_PER_MS = 3.2f;
    private static final long DEFAULT_START_MS = 240L;
    private static final float DEFAULT_EASE_STRENGTH = 0.63f;

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
     * 强 ease-out，照抄 cubic-bezier(0.23, 1, 0.32, 1)；先建一次复用。用于<b>状态卡交叉淡入</b>
     * （由 {@link #easeOut()} 供 {@code StatusFragment} 的透明度补间）——这类"瞬时状态切换"要前倾、快到位。
     * <b>箭头旋转不走这条</b>：箭头与面板同步，必须同用 {@link #panelCurve}（见类注释）。
     */
    private static final Interpolator EASE_OUT = new PathInterpolator(0.23f, 1f, 0.32f, 1f);

    /**
     * 面板高度类与展开箭头共用的曲线形状：{@code y = t − (强度/2π)·sin(2πt)}。强度由界面参数喂入
     * （{@link #panelCurve}），本类只管形状——<b>强度 0</b> = 匀速直线；<b>强度越大</b>两端越慢、中段越快
     * （三点斜率 {@code 1−强度 → 1+强度 → 1−强度}，天然左右对称）。强度 ≤1 时斜率恒 ≥0，故永不回退、不越界。
     * 默认强度 0.63 等效「时间/进度」锚点 {@code t=0.10→y≈0.041}、{@code t=0.25→y≈0.150}。
     * 用于<b>面板高度类</b>补间（{@link #animateHeight(View, boolean)} 与
     * {@link #beginLayoutChange(ViewGroup, float)} 里的尺寸变化）与<b>展开箭头旋转</b>
     * （{@link #rotate(View, float, long)}）——大位移用强 ease-out 会前倾过猛（25% 时间走完约 78% 位移）。
     * 箭头与所在面板<b>同曲线同时长</b>才锁得死，故箭头也用这条；状态卡交叉淡入仍用 {@link #EASE_OUT}。
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

    /** 状态卡交叉淡入的透明度曲线（强 ease-out）；箭头旋转不走这条（它用 {@link #panelCurve} 那条）。 */
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

    private static float scale(Context context, String key) {
        return Settings.Global.getFloat(context.getContentResolver(), key, 1f);
    }
}
