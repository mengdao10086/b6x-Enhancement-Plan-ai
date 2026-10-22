package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.waspwingtempctrl.R;

import java.util.Arrays;

/**
 * 换行容器：全项目<b>唯一</b>的换行实现。子视图按添加顺序排布，一行放不下就换行；
 * 同一行内的子视图按各自高度<b>垂直居中</b>。
 *
 * <h3>三种子视图</h3>
 * <ul>
 *   <li><b>leading</b>（缺省）：从行左界起依次排，列距 {@code wrapColGap}（该 XML 属性当前全仓
 *       未被设置，列距恒取缺省 {@code @dimen/space_m}），放不下换行。</li>
 *   <li><b>trailing</b>：连续的一串 trailing 构成「尾段」，每行都贴本行<b>行尾（右界）</b>对齐；
 *       分配按「换行偏好顺序」逐档尝试（详见 {@link #placeTailRun}）——<b>能用整行解决就不混排，
 *       混排只在连整行都放不下时才用</b>（① ~ ⑤ 明细见 app/逻辑说明.md §7.7）。</li>
 *   <li><b>fullLine</b>：独占一行且铺满可用宽（measure 用 {@code EXACTLY}），不与其他子视图同行。</li>
 *   <li><b>halfLine</b>：两列流式。<b>先按可用宽量自然宽</b>：放得进半行就以半行宽参与 leading 排布
 *       （两项正好占满一行，第三项自动换行）；放不下就以整行宽独占一行。<b>逐行按实测判定</b>，
 *       故窄屏、长内容、系统字体放大只会让放不下的那一行退回整行，其余行仍是两列；
 *       旋转 / 分屏后每次 measure 重新判定。见 {@link #setHalfLine}。</li>
 * </ul>
 * 另有 {@code breakBefore}：在其之前强制换行（对 trailing 者，本串尾段就此断开、另起一串）。
 * <b>注</b>：尾段侧这两条 {@code breakBefore} 语义保留、但当前无调用方行使——{@code setBreakBefore}
 * 仅作用于 leading 成员，且无布局 XML 设 {@code wrapBreakBefore}。
 * 行距 {@code wrapRowGap}（缺省 = 列距）。行内一律垂直居中，唯一例外是
 * {@link #setVerticalCenterAt} 标记过的子视图（垂直中心钉在行顶之下固定偏移处）。
 *
 * <h3>标记存在子视图自己的 LayoutParams 上</h3>
 * 这些标记是子视图 {@link LayoutParams} 的字段，<b>容器不持有任何子视图引用</b>（不另建
 * {@code List<View>}/{@code Map}）——因此 {@code removeAllViews()} 之后不残留任何标记。
 * 标记也可直接写在子标签的 {@code app:} 属性上（{@code inflate(xml, parent, false)} 由本容器读出）。
 *
 * <h3>为什么不引第三方</h3>
 * 见 app/逻辑说明.md §7.7。
 *
 * <h3>量摆同源</h3>
 * 量（{@link #onMeasure}）与摆（{@link #onLayout}）走<b>同一个</b> {@link Pass}，
 * 换行判定只有一份，不会出现"量一套、摆另一套"。标记变化后由调用方 {@code requestLayout()} 即可，
 * 本类不在任何布局回调里回写状态。
 *
 * <p>仅按 LTR 排布（界面无镜像语言需求）。
 */
public final class WrapRowLayout extends ViewGroup {

    /**
     * 子视图的布局参数：宽高与外边距同 {@link MarginLayoutParams}，另加换行标记与垂直定位标记。
     * 标记存在这里（而不是容器里），是"容器不持子视图引用"的前提。
     */
    public static final class LayoutParams extends MarginLayoutParams {

        /** {@link #verticalCenterAt} 的"未标记"值：按行高居中（缺省语义）。 */
        static final int VERTICAL_CENTER_UNSET = -1;

        /** 本子视图属于尾段：与相邻的尾段成员一起贴行右界。 */
        boolean trailing;

        /** 本子视图独占一行且铺满可用宽。 */
        boolean fullLine;

        /** 本子视图参与「两列流式」：放得进半行用半行宽，放不下退回整行（见 {@link #setHalfLine}）。 */
        boolean halfLine;

        /** 本子视图之前强制换行。 */
        boolean breakBefore;

        /**
         * 垂直中心在本行行顶之下多少像素处，{@link #VERTICAL_CENTER_UNSET} = 未标记（按行高居中）。
         * 只由 {@link #setVerticalCenterAt} 施加，无 XML 属性。
         */
        int verticalCenterAt = VERTICAL_CENTER_UNSET;

        /** {@link #rowGapCap} 的"未设"值：按容器行距。 */
        static final int ROW_GAP_UNSET = -1;

        /**
         * 本行（作为父容器的子视图）希望被分配的<b>上下行距上限</b>：只收不放——父容器按
         * {@code min(容器行距, 本行上限, 相邻行上限)} 算这两行之间的间距。未设
         * （{@link #ROW_GAP_UNSET}）时行为与从前一致。只由 {@link #setRowGapCap} 施加，无 XML 属性。
         */
        int rowGapCap = ROW_GAP_UNSET;

        /**
         * 设本行的上下行距上限（像素，{@code -1} = 未设）。须在父容器测量前调用
         * （键行在挂进分组卡 body 之前由 {@code ConfigKeyRow} 施加）。
         */
        public void setRowGapCap(int px) {
            rowGapCap = px;
        }

        /** 由子标签的 {@code app:} 属性读出标记（{@code inflate(xml, parent, false)} 走这条路）。 */
        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WrapRowLayout_Layout);
            trailing = a.getBoolean(R.styleable.WrapRowLayout_Layout_wrapTrailing, false);
            fullLine = a.getBoolean(R.styleable.WrapRowLayout_Layout_wrapFullLine, false);
            halfLine = false;   // 无 XML 属性：只由 setHalfLine 施加
            breakBefore = a.getBoolean(R.styleable.WrapRowLayout_Layout_wrapBreakBefore, false);
            verticalCenterAt = VERTICAL_CENTER_UNSET;
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            verticalCenterAt = VERTICAL_CENTER_UNSET;
        }

        public LayoutParams(@NonNull LayoutParams source) {
            super(source);
            trailing = source.trailing;
            fullLine = source.fullLine;
            halfLine = source.halfLine;
            breakBefore = source.breakBefore;
            verticalCenterAt = source.verticalCenterAt;
            rowGapCap = source.rowGapCap;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(@NonNull MarginLayoutParams source) {
            super(source);
        }
    }

    /** 列距（同一行内相邻子视图之间，含尾段内部）。可由 {@link #setColGap} 在测量前改写。 */
    private int colGap;

    /** 行距（上下两行之间）。缺省 = 列距，可由 XML 属性 {@code app:wrapRowGap} 单独指定。 */
    private final int rowGap;

    public WrapRowLayout(Context context) {
        this(context, null);
    }

    public WrapRowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WrapRowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 缺省列距取标尺 space_m（12dp）：与参数名到卡片左侧内边距同一标尺，不写属性时行为与从前一致
        int defaultColGap = context.getResources().getDimensionPixelSize(R.dimen.space_m);
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.WrapRowLayout, defStyleAttr, 0);
        colGap = a.getDimensionPixelSize(R.styleable.WrapRowLayout_wrapColGap, defaultColGap);
        rowGap = a.getDimensionPixelSize(R.styleable.WrapRowLayout_wrapRowGap, colGap);
        a.recycle();
    }

    /** 标记子视图属于尾段（贴行右界）。须在子视图被测量前调用。 */
    public void setTrailing(@NonNull View child, boolean value) {
        LayoutParams lp = paramsOf(child);
        if (lp.trailing == value) {
            return;
        }
        lp.trailing = value;
        requestLayout();
    }

    /** 标记子视图独占一行且铺满可用宽。须在子视图被测量前调用。 */
    public void setFullLine(@NonNull View child, boolean value) {
        LayoutParams lp = paramsOf(child);
        if (lp.fullLine == value) {
            return;
        }
        lp.fullLine = value;
        requestLayout();
    }

    /**
     * 标记子视图参与「两列流式」（见类注释的 halfLine）：<b>放得进半行就用半行宽、放不下退回整行</b>，
     * 判据是子视图自己的自然宽与半行宽的实测比较，不做固定阈值判断。须在子视图被测量前调用；
     * 与 {@link #setFullLine} 互斥（同时为真时 halfLine 优先，fullLine 不再生效）。
     */
    public void setHalfLine(@NonNull View child, boolean value) {
        LayoutParams lp = paramsOf(child);
        if (lp.halfLine == value) {
            return;
        }
        lp.halfLine = value;
        requestLayout();
    }

    /**
     * 改本容器同一行内的列距（像素）。<b>只给「紧凑两列」的行用</b>（{@code ConfigKeyRow} 在
     * 建行时把自己的行根压低），须在子视图被测量前调用；行距 {@code rowGap} 不跟着改。
     */
    void setColGap(int px) {
        if (colGap == px) {
            return;
        }
        colGap = px;
        requestLayout();
    }

    /** 标记子视图之前强制换行。须在子视图被测量前调用。 */
    public void setBreakBefore(@NonNull View child, boolean value) {
        LayoutParams lp = paramsOf(child);
        if (lp.breakBefore == value) {
            return;
        }
        lp.breakBefore = value;
        requestLayout();
    }

    /**
     * 本子视图的垂直中心固定在本行行顶之下 offsetPx 处（不按行高居中）；未标记 -1 时行为不变。
     *
     * <p>只改这一个子视图的纵向落点；行高按<b>占用下沿</b>与其余子视图一起取最大（见 {@link #occupiedHeight}，
     * 否则会盖住下一行）；落点可为负、不钳位，向上越出的部分不为它加高、也不平移本行（见 app/逻辑说明.md §7.7）。
     */
    public void setVerticalCenterAt(@NonNull View child, int offsetPx) {
        LayoutParams lp = paramsOf(child);
        if (lp.verticalCenterAt == offsetPx) {
            return;
        }
        lp.verticalCenterAt = offsetPx;
        requestLayout();
    }

    /**
     * 取子视图的布局参数，必要时（尚无参数、或参数不是本类的）换成 {@link LayoutParams}。
     * 子视图尚未加入本容器时也能用（正是"先声明标记、后 addView"的用法）。
     */
    @NonNull
    private LayoutParams paramsOf(@NonNull View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params instanceof LayoutParams) {
            return (LayoutParams) params;
        }
        LayoutParams converted;
        if (params == null) {
            converted = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        } else if (params instanceof MarginLayoutParams) {
            converted = new LayoutParams((MarginLayoutParams) params);   // 带上原外边距
        } else {
            converted = new LayoutParams(params);
        }
        child.setLayoutParams(converted);
        return converted;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams params) {
        return params instanceof MarginLayoutParams
                ? new LayoutParams((MarginLayoutParams) params)
                : new LayoutParams(params);
    }

    /** 标记只能落在本类的 {@link LayoutParams} 上：外来参数一律换成它（addView 时自动替换）。 */
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams params) {
        return params instanceof LayoutParams;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int rowLimit = rowLimit(widthMeasureSpec);
        Pass pass = new Pass(false, rowLimit, getPaddingLeft() + rowLimit, getPaddingTop());
        run(pass);
        setMeasuredDimension(
                resolveSizeAndState(
                        Math.max(pass.contentWidth + getPaddingLeft() + getPaddingRight(),
                                getSuggestedMinimumWidth()),
                        widthMeasureSpec, 0),
                resolveSizeAndState(
                        Math.max(contentHeight(pass) + getPaddingTop() + getPaddingBottom(),
                                getSuggestedMinimumHeight()),
                        heightMeasureSpec, 0));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int rowLimit = Math.max(0, right - left - getPaddingLeft() - getPaddingRight());
        run(new Pass(true, rowLimit, getPaddingLeft() + rowLimit, getPaddingTop()));
    }

    /** 一趟排布：量在 {@link Pass#place} 为 false 时做，摆在其为 true 时做，换行判定两者共用。 */
    private void run(Pass pass) {
        final int count = getChildCount();
        int index = 0;
        while (index < count) {
            View child = getChildAt(index);
            if (child.getVisibility() == GONE) {
                index++;
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!pass.place) {
                if (lp.halfLine) {
                    measureHalfLineChild(child, lp, pass.rowLimit);
                } else {
                    measureChild(child, lp, pass.rowLimit);
                }
            }
            if (lp.halfLine) {
                // 半行：放得下就与本行已有的半格并排（leading 规则自带换行），放不下就独占整行。
                // 判据只看实测宽——measure 与 layout 两趟读到的是同一个结果。
                if (fitsHalf(child, pass.rowLimit)) {
                    placeLeading(pass, index, child, lp);
                } else {
                    flushRow(pass);
                    placeFullLine(pass, child, lp, index);
                }
                index++;
            } else if (lp.fullLine) {
                flushRow(pass);
                placeFullLine(pass, child, lp, index);
                index++;
            } else if (lp.trailing) {
                index = placeTailRun(pass, index, lp);
            } else {
                placeLeading(pass, index, child, lp);
                index++;
            }
        }
        flushRow(pass);
    }

    /** leading 子视图：从行左界起依次排，放不下或声明了 breakBefore 就换行。 */
    private void placeLeading(Pass pass, int index, View child, LayoutParams lp) {
        if (pass.rowClosed) {
            flushRow(pass);     // 本行已被尾段收尾：另起一行（缓冲已空、y 已前进，这里只清状态）
        }
        int outer = outerWidth(child, lp);
        if (pass.rowEnd > pass.rowStart
                && (lp.breakBefore || pass.rowWidth + colGap + outer > pass.rowLimit)) {
            flushRow(pass);
        }
        if (pass.rowEnd > pass.rowStart) {
            pass.rowWidth += colGap + outer;
        } else {
            pass.rowStart = index;
            pass.rowWidth = outer;
        }
        pass.rowEnd = index + 1;
        pass.rowHeight = Math.max(pass.rowHeight, occupiedHeight(child, lp));
    }

    /**
     * 尾段（从 {@code start} 起连续的一串 trailing）的分配：按「换行偏好顺序」逐档尝试，取第一个可行的
     * ——<b>能用整行解决就不混排，混排只在连整行都放不下时才用</b>（① ~ ⑤ 明细见 app/逻辑说明.md §7.7）。
     * 每一行（含与参数名同行的那一段）都贴行右界；返回下一个待处理子视图的下标。
     *
     * <p>段内再声明 {@code breakBefore} 者另起一串；段首声明 {@code breakBefore} 时本段不与参数名同行。
     * 两条尾段侧语义保留、但当前无调用方行使（{@code setBreakBefore} 仅作用于 leading，无 XML 设
     * {@code wrapBreakBefore}）。
     */
    private int placeTailRun(Pass pass, int start, LayoutParams first) {
        if (pass.rowClosed) {
            flushRow(pass);
        }
        int end = collectTail(pass, start);
        if (pass.rowEnd == pass.rowStart) {
            placeTailWholeOrWrapped(pass, start, end);
            pass.rowClosed = true;
            return end;
        }
        // 能与本行参数名同行的最大前缀（段首 breakBefore 者一项都不与之同行）
        int fit = first.breakBefore ? 0 : tailPrefixFit(pass, pass.rowWidth, start, end);
        // 判"放几项"一律用可见项数（GONE 会被收进区间，用下标差恒大于 fit、第①档永不命中，见 §7.7）
        int visible = visibleCount(start, end);
        if (fit == visible) {                            // ① 全部字段与参数名同行
            placeTailOnRow(pass, start, end);
            pass.rowClosed = true;
            return end;
        }
        // 同行那一段的边界 = 第 fit 个可见项之后的下标（口径同 visibleCount；GONE 不进这一段）
        int beside = fit > 0 ? endOfVisiblePrefix(start, end, fit) : start;
        // 切分只与区间有关、与 lines 无关：算一次即可
        int[] wholeEnds = tailLineEnds(pass, start, end);
        int[] besideEnds = null;
        for (int lines = 1; lines <= visible; lines++) {
            if (wholeEnds.length <= lines) {
                // ②④⑥…：参数名独占一行，全部字段切成 ≤ lines 整行（能用整行解决就不混排）
                flushRow(pass);
                placeTailLines(pass, start, end);
                pass.rowClosed = true;
                return end;
            }
            if (beside > start) {
                if (besideEnds == null) {
                    besideEnds = tailLineEnds(pass, beside, end);
                }
                if (besideEnds.length <= lines) {
                    // ③⑤⑦…：同行放得下的先放，其余切成 ≤ lines 整行
                    placeTailOnRow(pass, start, beside);
                    placeTailLines(pass, beside, end);
                    pass.rowClosed = true;
                    return end;
                }
            }
        }
        // lines 到项数时每项各占一行必可行，故上面必然已返回；这里只是兜底（同样不越界、不死循环）
        flushRow(pass);
        placeTailLines(pass, start, end);
        pass.rowClosed = true;
        return end;
    }

    /** 本行空着时的尾段：整段放得下就占本行一行（贴右界），否则段内贪婪折行。 */
    private void placeTailWholeOrWrapped(Pass pass, int start, int end) {
        measureTailSpan(pass, start, end);
        if (pass.tailWidth <= pass.rowLimit) {
            placeTailOnRow(pass, start, end);
        } else {
            placeTailLines(pass, start, end);
        }
    }

    /** 把尾段区间 {@code [from,to)} 整体贴本行行右界摆下（与同行的参数名并排，或本行空着）。 */
    private void placeTailOnRow(Pass pass, int from, int to) {
        pass.tailStart = from;
        pass.tailEnd = to;
        measureTailSpan(pass, from, to);
        flushRow(pass);
    }

    /** 收集从 {@code start} 起连续的一串 trailing（跳过 GONE；段内 breakBefore 另起一串），返回末尾下标。 */
    private int collectTail(Pass pass, int start) {
        final int count = getChildCount();
        int end = start;
        while (end < count) {
            View child = getChildAt(end);
            if (child.getVisibility() == GONE) {
                end++;
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!lp.trailing || lp.fullLine || (end > start && lp.breakBefore)) {
                break;
            }
            if (!pass.place && end > start) {      // 段首那个已在 run() 里量过
                measureChild(child, lp, pass.rowLimit);
            }
            end++;
        }
        return end;
    }

    /**
     * 区间 {@code [from,to)} 内可见子视图（{@code getVisibility() != GONE}）的个数。
     *
     * <p>{@link #collectTail} <b>会把 GONE 的子视图也收进区间</b>，故下标差 {@code to - from} 并不等于
     * "区间里有几项要摆"；凡要与 {@link #tailPrefixFit} 比大小的地方都走这一个数（见 app/逻辑说明.md §7.7）。
     */
    private int visibleCount(int from, int to) {
        int n = 0;
        for (int i = from; i < to; i++) {
            if (getChildAt(i).getVisibility() != GONE) {
                n++;
            }
        }
        return n;
    }

    /**
     * 区间 {@code [from,to)} 内<b>第 {@code count} 个可见子视图之后</b>的下标（{@code count == 0}
     * 时为 {@code from}）。即"前 {@code count} 个可见项"这一段的右侧边界，口径与
     * {@link #visibleCount} 同源；GONE 不进这一段（它既不占宽也不落位，留在后一段里被跳过）。
     */
    private int endOfVisiblePrefix(int from, int to, int count) {
        int seen = 0;
        int i = from;
        while (i < to && seen < count) {
            if (getChildAt(i).getVisibility() != GONE) {
                seen++;
            }
            i++;
        }
        return i;
    }

    /**
     * 尾段区间 {@code [from,to)} 能与本行参数名同行的最大前缀项数（0 = 一项都放不下）。
     * 口径与 {@link #sideBySideWidth} 同源——判"放得下"、量"本行多宽"、量"前缀几项"用的是同一个数。
     */
    private int tailPrefixFit(Pass pass, int leadingWidth, int from, int to) {
        int width = 0;
        int fit = 0;
        for (int i = from; i < to; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            width += (width > 0 ? colGap : 0) + outerWidth(child, lp);
            if (sideBySideWidth(leadingWidth, width) > pass.rowLimit) {
                break;
            }
            fit++;
        }
        return fit;
    }

    /**
     * 尾段贪婪切行：每行尽量多装（行宽 ≤ {@code pass.rowLimit}，且一行至少留一项），返回各行的结束下标。
     * <b>"要几行"的判定与真摆放共用这一份切分</b>，否则"判可行"与"实际切"又会分家（见 app/逻辑说明.md §7.7）。
     */
    private int[] tailLineEnds(Pass pass, int from, int to) {
        int[] ends = new int[Math.max(1, to - from)];
        int lines = 0;
        int lineStart = from;
        while (lineStart < to) {
            int lineEnd = lineStart;
            int lineWidth = 0;
            while (lineEnd < to) {
                View child = getChildAt(lineEnd);
                if (child.getVisibility() == GONE) {
                    lineEnd++;
                    continue;
                }
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                int candidate = lineWidth + (lineWidth > 0 ? colGap : 0) + outerWidth(child, lp);
                if (lineWidth > 0 && candidate > pass.rowLimit) {
                    break;      // 这一行到此为止；只在行非空时判，保证一行至少留一个（不会空转）
                }
                lineWidth = candidate;
                lineEnd++;
            }
            ends[lines++] = lineEnd;
            lineStart = lineEnd;
        }
        return Arrays.copyOf(ends, lines);
    }

    /**
     * 尾段区间 {@code [from,to)} 的宽与高，一次遍历同时算出：宽含段内列距与各成员外边距，
     * 高取各成员占用高最大（见 {@link #occupiedHeight}）；跳过 GONE。结果写入
     * {@link Pass#tailWidth} / {@link Pass#tailHeight}。
     */
    private void measureTailSpan(Pass pass, int from, int to) {
        int width = 0;
        int height = 0;
        for (int i = from; i < to; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            width += (width > 0 ? colGap : 0) + outerWidth(child, lp);
            height = Math.max(height, occupiedHeight(child, lp));
        }
        pass.tailWidth = width;
        pass.tailHeight = height;
    }

    /** 尾段的每一行都贴行右界摆放（切分口径见 {@link #tailLineEnds}）。 */
    private void placeTailLines(Pass pass, int start, int end) {
        int lineStart = start;
        for (int lineEnd : tailLineEnds(pass, start, end)) {
            // 量入 pass.tailWidth/Height：此处尾段缓冲为空（tailStart==tailEnd），这两个值只写不读
            measureTailSpan(pass, lineStart, lineEnd);
            if (pass.tailWidth > 0) {                     // 只有 GONE 的"行"不占高度
                if (pass.place) {
                    layoutSpan(pass, lineStart, lineEnd,
                            Math.max(getPaddingLeft(), pass.rowRight - pass.tailWidth),
                            pass.tailHeight);
                }
                pass.bottom = pass.y + pass.tailHeight;
                pass.contentWidth = Math.max(pass.contentWidth, pass.tailWidth);
                pass.y += pass.tailHeight + rowGap;
            }
            lineStart = lineEnd;
        }
    }

    /**
     * fullLine 子视图：独占一行且铺满可用宽。它自己就是整行，纵向落点仍复用 {@link #placeChild}
     * （未标记者等价于"行顶 + 上外边距"，标记过的照 {@code verticalCenterAt} 落点）。
     *
     * <p>本行之后的间距取 {@link #rowGapForRow}：键行（fullLine）可经
     * {@link LayoutParams#setRowGapCap} 把上下行距收窄（如开关行）。
     */
    private void placeFullLine(Pass pass, View child, LayoutParams lp, int index) {
        int height = occupiedHeight(child, lp);
        if (pass.place) {
            placeChild(child, lp, getPaddingLeft(), pass.y, height);
        }
        pass.bottom = pass.y + height;
        pass.contentWidth = Math.max(pass.contentWidth, outerWidth(child, lp));
        pass.y += height + rowGapForRow(lp, index);
    }

    /**
     * 本行与其下一行之间的行距 = {@code min(容器行距, 本行上限, 下一行上限)}，只收不放。
     * 取两侧的 min 才能让"只给开关行设上限"同时压掉它<b>上</b>（由上一行的这里算）与<b>下</b>两处间距。
     */
    private int rowGapForRow(LayoutParams lp, int index) {
        int gap = rowGap;
        if (lp.rowGapCap >= 0) {
            gap = Math.min(gap, lp.rowGapCap);
        }
        int next = rowGapCapOfNextRow(index + 1);
        if (next >= 0) {
            gap = Math.min(gap, next);
        }
        return gap;
    }

    /** 从 {@code index} 起跳过 GONE，取首个可见子视图的行距上限；没有则 {@link LayoutParams#ROW_GAP_UNSET}。 */
    private int rowGapCapOfNextRow(int index) {
        final int count = getChildCount();
        for (int i = index; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            return ((LayoutParams) child.getLayoutParams()).rowGapCap;
        }
        return LayoutParams.ROW_GAP_UNSET;
    }

    /**
     * 收掉本行：leading 贴行左界、尾段（若有）贴行右界，行内一律垂直居中。
     * 本行没有内容时只清状态（不动 y），故"空行"与"尾段另起一行"走的是同一条路。
     */
    private void flushRow(Pass pass) {
        boolean hasLeading = pass.rowEnd > pass.rowStart;
        boolean hasTail = pass.tailEnd > pass.tailStart;
        if (hasLeading || hasTail) {
            int height = Math.max(pass.rowHeight, pass.tailHeight);
            if (pass.place) {
                layoutSpan(pass, pass.rowStart, pass.rowEnd, getPaddingLeft(), height);
                layoutSpan(pass, pass.tailStart, pass.tailEnd,
                        Math.max(getPaddingLeft(), pass.rowRight - pass.tailWidth), height);
            }
            pass.bottom = pass.y + height;
            // 本行宽：两段同行时是"并排所需宽"（与判据同源），只有一段时就是那一段
            pass.contentWidth = Math.max(pass.contentWidth, hasLeading && hasTail
                    ? sideBySideWidth(pass.rowWidth, pass.tailWidth)
                    : (hasLeading ? pass.rowWidth : pass.tailWidth));
            pass.y += height + rowGap;
        }
        pass.rowStart = 0;
        pass.rowEnd = 0;
        pass.rowWidth = 0;
        pass.rowHeight = 0;
        pass.tailStart = 0;
        pass.tailEnd = 0;
        pass.tailWidth = 0;
        pass.tailHeight = 0;
        pass.rowClosed = false;
    }

    /**
     * 摆区间 {@code [start,end)} 内的子视图：从 {@code startX} 起依次排，相邻之间留一个列距，跳过 GONE。
     *
     * <p>leading 段传行左界 {@code getPaddingLeft()}；尾段传「行右界 − 段宽」= 贴行右界、不越行左界。
     */
    private void layoutSpan(Pass pass, int start, int end, int startX, int rowHeight) {
        int x = startX;
        boolean first = true;
        for (int i = start; i < end; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!first) {
                x += colGap;
            }
            x = placeChild(child, lp, x, pass.y, rowHeight);
            first = false;
        }
    }

    /**
     * 摆一个子视图（左沿 = 起点 + leftMargin），返回下一个的起点 x。
     *
     * <p>纵向：缺省按行高垂直居中（含外边距）；{@code verticalCenterAt} 已标记时改为
     * "垂直中心落在行顶之下 offsetPx"（不看行高，可为负、不钳位）。
     */
    private int placeChild(View child, LayoutParams lp, int x, int rowTop, int rowHeight) {
        int width = child.getMeasuredWidth();
        int height = child.getMeasuredHeight();
        int childLeft = x + lp.leftMargin;
        int childTop = lp.verticalCenterAt != LayoutParams.VERTICAL_CENTER_UNSET
                ? rowTop + lp.verticalCenterAt - height / 2
                : rowTop + lp.topMargin
                        + Math.max(0, (rowHeight - lp.topMargin - lp.bottomMargin - height) / 2);
        child.layout(childLeft, childTop, childLeft + width, childTop + height);
        return childLeft + width + lp.rightMargin;
    }

    /**
     * 量一个半行子视图：<b>先按可用宽量自然宽</b>（{@code AT_MOST}，与普通 leading 同一口径），
     * 再按「自然宽 ≤ 半行宽」二选一重量——放得下用半行宽、放不下用整行宽，两者都是 {@code EXACTLY}。
     * 重量一次是必须的：半行宽下子视图内部会按新宽重新折行，高度随之变化。
     */
    private void measureHalfLineChild(View child, LayoutParams lp, int rowLimit) {
        measureChild(child, lp, rowLimit);
        int width = fitsHalf(child, rowLimit) ? halfWidth(rowLimit) : rowLimit;
        int available = Math.max(0, width - lp.leftMargin - lp.rightMargin);
        child.measure(MeasureSpec.makeMeasureSpec(available, MeasureSpec.EXACTLY),
                ViewGroup.getChildMeasureSpec(
                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, lp.height));
    }

    /** 半行宽：两格 + 一个列距正好占满一行；不足半格时为 0（调用方据此退回整行）。 */
    private int halfWidth(int rowLimit) {
        return Math.max(0, (rowLimit - colGap) / 2);
    }

    /** 已量出的自然宽是否放得进半行（{@code 0} = 连半格都排不出来，一律退回整行）。 */
    private boolean fitsHalf(View child, int rowLimit) {
        int half = halfWidth(rowLimit);
        return half > 0 && child.getMeasuredWidth() <= half;
    }

    /**
     * 量一个子视图：fullLine 者给足整行宽（{@code EXACTLY}），其余的上限是本行可用宽（{@code AT_MOST}）；
     * 高度一律不限（子视图自己的 minHeight 由此生效）。上限已扣掉本子视图的左右外边距。
     */
    private static void measureChild(View child, LayoutParams lp, int rowLimit) {
        int available = Math.max(0, rowLimit - lp.leftMargin - lp.rightMargin);
        int widthSpec = lp.fullLine
                ? MeasureSpec.makeMeasureSpec(available, MeasureSpec.EXACTLY)
                : ViewGroup.getChildMeasureSpec(
                        MeasureSpec.makeMeasureSpec(available, MeasureSpec.AT_MOST), 0, lp.width);
        child.measure(widthSpec, ViewGroup.getChildMeasureSpec(
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, lp.height));
    }

    /** 单行的宽度上限（本容器的可用内容宽）。 */
    private int rowLimit(int widthMeasureSpec) {
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED) {
            return Integer.MAX_VALUE >> 1;
        }
        return Math.max(0, MeasureSpec.getSize(widthMeasureSpec)
                - getPaddingLeft() - getPaddingRight());
    }

    /** 内容高（最后一行的下沿减去上内边距）。 */
    private int contentHeight(Pass pass) {
        return Math.max(0, pass.bottom - getPaddingTop());
    }

    /**
     * "参数名段 + 尾段并排同行"所需的行宽 = 两段宽 + 一个列距。
     *
     * <p><b>唯一口径</b>：判"能否同行"与量"本行有多宽"都走这一个数，杜绝分家（踩坑史见 app/逻辑说明.md §7.7）。
     */
    private int sideBySideWidth(int leadingWidth, int tailWidth) {
        return leadingWidth + colGap + tailWidth;
    }

    private static int outerWidth(View child, MarginLayoutParams lp) {
        return child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
    }

    private static int outerHeight(View child, MarginLayoutParams lp) {
        return child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
    }

    /**
     * 子视图在本行里占用的高（行高按它取各子视图的最大值）。
     *
     * <p>未标记者 = 自身高 + 上下外边距；已标记者 = 它占据的<b>下沿</b> {@code offsetPx + 高/2}
     * （标记只钉垂直中心、落点可越出本行下沿，行高必须按下沿算否则会盖住下一行）。下沿为负时按 0 计——
     * <b>有意不为越出上方的部分加高、也不平移本行</b>（下方越出则必须兜）。见 app/逻辑说明.md §7.7。
     */
    private static int occupiedHeight(View child, LayoutParams lp) {
        if (lp.verticalCenterAt == LayoutParams.VERTICAL_CENTER_UNSET) {
            return outerHeight(child, lp);
        }
        return Math.max(0, lp.verticalCenterAt + child.getMeasuredHeight() / 2);
    }

    /**
     * 一趟排布的进行态。只活在一次 {@link #onMeasure}/{@link #onLayout} 内（局部对象），
     * 因此容器本身<b>不持有任何子视图引用</b>；行与尾段都用<b>子视图下标区间</b>表示，连临时的
     * {@code List} 都不需要（见 app/逻辑说明.md §7.7）。
     */
    private static final class Pass {

        /** true = 摆放（onLayout）；false = 只量（onMeasure）。 */
        final boolean place;

        /** 本行可用内容宽（不含内边距）。 */
        final int rowLimit;

        /** 行尾 x（右界）= 左内边距 + 可用内容宽。 */
        final int rowRight;

        /** 当前行的顶部 y。 */
        int y;

        /** 已摆出的最低沿（含上内边距）。 */
        int bottom;

        /** 内容宽 = 各行最右沿的最大值。 */
        int contentWidth;

        /** 当前行的 leading 子视图下标区间 [rowStart, rowEnd)。 */
        int rowStart;
        int rowEnd;

        /** 当前行 leading 部分已用宽（含列距与左右外边距）。 */
        int rowWidth;

        /** 当前行已见的最大外边距高。 */
        int rowHeight;

        /** 落在当前行的尾段区间 [tailStart, tailEnd)；空时两者相等。 */
        int tailStart;
        int tailEnd;
        int tailWidth;
        int tailHeight;

        /** 本行已由尾段收尾：其后再来子视图只能另起一行。为真时本行缓冲必为空。 */
        boolean rowClosed;

        Pass(boolean place, int rowLimit, int rowRight, int paddingTop) {
            this.place = place;
            this.rowLimit = rowLimit;
            this.rowRight = rowRight;
            this.y = paddingTop;
            this.bottom = paddingTop;
        }
    }
}
