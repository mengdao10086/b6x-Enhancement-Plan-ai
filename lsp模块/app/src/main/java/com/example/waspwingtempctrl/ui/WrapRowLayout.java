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
 *   <li><b>leading</b>（缺省）：从行左界起依次排，列距 {@code wrapColGap}，放不下换行。</li>
 *   <li><b>trailing</b>：连续的一串 trailing 构成「尾段」，每行都贴本行<b>行尾（右界）</b>对齐。
 *       分配按「换行偏好顺序」逐档尝试，取第一个可行的（详见 {@link #placeTailRun}）：
 *       ①全部字段与参数名同行 → ②全部字段占一整行（参数名独占一行）→ ③同行放得下的先放、
 *       其余占一整行 → ④占两整行 → ⑤同行 + 两整行，依此类推。
 *       一句话：<b>能用整行解决就不混排，混排只在连整行都放不下时才用</b>。</li>
 *   <li><b>fullLine</b>：独占一行且铺满可用宽（measure 用 {@code EXACTLY}），不与其他子视图同行。</li>
 * </ul>
 * 另有 {@code breakBefore}：在其之前强制换行（对 trailing 者，本串尾段就此断开、另起一串）。
 * 行距 {@code wrapRowGap}（缺省 = 列距）。行内一律垂直居中，唯一例外是
 * {@link #setVerticalCenterAt} 标记过的子视图（垂直中心钉在行顶之下固定偏移处）。
 *
 * <h3>标记存在子视图自己的 LayoutParams 上</h3>
 * 这些标记是子视图 {@link LayoutParams} 的字段，<b>容器不持有任何子视图引用</b>（不另建
 * {@code List<View>}/{@code Map}）——因此 {@code removeAllViews()} 之后不残留任何标记，
 * 重新添加即从零开始。标记也可直接写在子标签的 {@code app:} 属性上：
 * {@code inflate(xml, parent, false)} 走 {@code parent.generateLayoutParams(attrs)}，由本容器读出。
 *
 * <h3>为什么不引第三方</h3>
 * FlexboxLayout 为浏览器级的 flex 语义（收缩/增长/基线/顺序）付成本，本容器只需要上面几条规则，
 * 百来行的排布即可覆盖；调用方量级（每页几十个）也不需要虚拟化。
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

        /** 本子视图之前强制换行。 */
        boolean breakBefore;

        /**
         * 垂直中心在本行行顶之下多少像素处，{@link #VERTICAL_CENTER_UNSET} = 未标记（按行高居中）。
         * 只由 {@link #setVerticalCenterAt} 施加，无 XML 属性。
         */
        int verticalCenterAt = VERTICAL_CENTER_UNSET;

        /** 由子标签的 {@code app:} 属性读出标记（{@code inflate(xml, parent, false)} 走这条路）。 */
        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WrapRowLayout_Layout);
            trailing = a.getBoolean(R.styleable.WrapRowLayout_Layout_wrapTrailing, false);
            fullLine = a.getBoolean(R.styleable.WrapRowLayout_Layout_wrapFullLine, false);
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
            breakBefore = source.breakBefore;
            verticalCenterAt = source.verticalCenterAt;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(@NonNull MarginLayoutParams source) {
            super(source);
        }
    }

    /** 列距（同一行内相邻子视图之间，含尾段内部）。 */
    private final int colGap;

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
     * <p>只改这一个子视图的纵向落点；同行其他子视图的位置不动。行高按<b>占用下沿</b>
     * {@code offsetPx + 高/2} 与其余子视图一起取最大（见 {@link #occupiedHeight}）——标记项可能比本行
     * 原行高更低，行高不跟着算就会盖住下一行。落点可以为负（子视图上沿越出行顶），不钳位；
     * 向上越出的部分不为它加高，也不平移本行。
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
                measureChild(child, lp, pass.rowLimit);
            }
            if (lp.fullLine) {
                flushRow(pass);
                placeFullLine(pass, child, lp);
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
     * ——<b>能用整行解决就不混排，混排只在连整行都放不下时才用</b>：
     * <ol>
     *   <li>全部字段与参数名同行；</li>
     *   <li>全部字段占一整行（参数名独占一行）；</li>
     *   <li>参数名同行放得下的先放，其余占一整行；</li>
     *   <li>全部字段占两整行；</li>
     *   <li>同行放得下的先放，其余占两整行。</li>
     * </ol>
     * 依此类推（k 整行 → 同行 + k 整行）。每一行（含与参数名同行的那一段）都贴行右界。
     * 返回下一个待处理子视图的下标。
     *
     * <p>段内再声明 {@code breakBefore} 者另起一串（本段到此为止）：强制换行对每个子视图都算数；
     * 段首声明 {@code breakBefore} 时本段不与参数名同行。
     */
    private int placeTailRun(Pass pass, int start, LayoutParams first) {
        if (pass.rowClosed) {
            flushRow(pass);     // 同理：上一串尾段已收掉本行，这一串另起一行
        }
        int end = collectTail(pass, start);
        if (pass.rowEnd == pass.rowStart) {
            // 本行没有参数名可同行：整段占本行一行，放不下才折行
            placeTailWholeOrWrapped(pass, start, end);
            pass.rowClosed = true;
            return end;
        }
        // 能与本行参数名同行的最大前缀（段首 breakBefore 者一项都不与之同行）
        int fit = first.breakBefore ? 0 : tailPrefixFit(pass, pass.rowWidth, start, end);
        // 判"放几项"一律用可见项数：区间内夹着的 GONE 兄弟不占宽、不落位，
        // 而 collectTail 会把它们收进区间，用下标差（end - start）会恒大于 fit，第①档于是永不命中
        int visible = visibleCount(start, end);
        if (fit == visible) {                            // ① 全部字段与参数名同行
            placeTailOnRow(pass, start, end);
            pass.rowClosed = true;
            return end;
        }
        // 同行那一段的边界 = 第 fit 个可见项之后的下标（口径同 visibleCount；GONE 不进这一段）
        int beside = fit > 0 ? endOfVisiblePrefix(start, end, fit) : start;
        for (int lines = 1; lines <= visible; lines++) {
            if (tailLineEnds(pass, start, end).length <= lines) {
                // ②④⑥…：参数名独占一行，全部字段切成 ≤ lines 整行（能用整行解决就不混排）
                flushRow(pass);
                placeTailLines(pass, start, end);
                pass.rowClosed = true;
                return end;
            }
            if (beside > start && tailLineEnds(pass, beside, end).length <= lines) {
                // ③⑤⑦…：同行放得下的先放，其余切成 ≤ lines 整行
                placeTailOnRow(pass, start, beside);
                placeTailLines(pass, beside, end);
                pass.rowClosed = true;
                return end;
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
        if (tailWidthOf(start, end) <= pass.rowLimit) {
            placeTailOnRow(pass, start, end);
        } else {
            placeTailLines(pass, start, end);
        }
    }

    /** 把尾段区间 {@code [from,to)} 整体贴本行行右界摆下（与同行的参数名并排，或本行空着）。 */
    private void placeTailOnRow(Pass pass, int from, int to) {
        pass.tailStart = from;
        pass.tailEnd = to;
        pass.tailWidth = tailWidthOf(from, to);
        pass.tailHeight = tailHeightOf(from, to);
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
     * <p>尾段区间由 {@link #collectTail} 收集，而它<b>会把 GONE 的子视图也收进区间</b>（GONE 分支
     * 在标记判定之前），因此下标差 {@code to - from} 并不等于"区间里有几项要摆"。凡是要与
     * {@link #tailPrefixFit}（逐项前缀累加，只数可见项）比大小的地方，都走这一个数。
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
     * <b>"要几行"的判定与真摆放共用这一份切分</b>——否则"判可行"与"实际切"又会分家。
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

    /** 尾段区间 {@code [from,to)} 的宽（含段内列距与各成员外边距）。 */
    private int tailWidthOf(int from, int to) {
        int width = 0;
        for (int i = from; i < to; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            width += (width > 0 ? colGap : 0) + outerWidth(child, lp);
        }
        return width;
    }

    /** 尾段区间 {@code [from,to)} 的高（各成员占用高取最大，见 {@link #occupiedHeight}）。 */
    private int tailHeightOf(int from, int to) {
        int height = 0;
        for (int i = from; i < to; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            height = Math.max(height, occupiedHeight(child, lp));
        }
        return height;
    }

    /** 尾段的每一行都贴行右界摆放（切分口径见 {@link #tailLineEnds}）。 */
    private void placeTailLines(Pass pass, int start, int end) {
        int lineStart = start;
        for (int lineEnd : tailLineEnds(pass, start, end)) {
            int lineWidth = tailWidthOf(lineStart, lineEnd);
            int lineHeight = tailHeightOf(lineStart, lineEnd);
            if (lineWidth > 0) {                      // 只有 GONE 的"行"不占高度
                if (pass.place) {
                    layoutTail(pass, lineStart, lineEnd, lineWidth, lineHeight);
                }
                pass.bottom = pass.y + lineHeight;
                pass.contentWidth = Math.max(pass.contentWidth, lineWidth);
                pass.y += lineHeight + rowGap;
            }
            lineStart = lineEnd;
        }
    }

    /**
     * fullLine 子视图：独占一行且铺满可用宽。它自己就是整行，纵向落点仍复用 {@link #placeChild}
     * （未标记者等价于"行顶 + 上外边距"，标记过的照 {@code verticalCenterAt} 落点）。
     */
    private void placeFullLine(Pass pass, View child, LayoutParams lp) {
        int height = occupiedHeight(child, lp);
        if (pass.place) {
            placeChild(child, lp, getPaddingLeft(), pass.y, height);
        }
        pass.bottom = pass.y + height;
        pass.contentWidth = Math.max(pass.contentWidth, outerWidth(child, lp));
        pass.y += height + rowGap;
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
                layoutLeading(pass, height);
                layoutTail(pass, pass.tailStart, pass.tailEnd, pass.tailWidth, height);
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

    /** 摆当前行的 leading 子视图：从行左界起依次排。 */
    private void layoutLeading(Pass pass, int rowHeight) {
        int x = getPaddingLeft();
        boolean first = true;
        for (int i = pass.rowStart; i < pass.rowEnd; i++) {
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

    /** 摆尾段的一行：整体右对齐（贴行尾，不越过行左界）。 */
    private void layoutTail(Pass pass, int start, int end, int lineWidth, int rowHeight) {
        int x = Math.max(getPaddingLeft(), pass.rowRight - lineWidth);
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
     * <p><b>唯一口径</b>：判"能否同行"（{@link #placeTailRun}、{@link #tailPrefixFit}）、
     * 量"本行有多宽"（{@link #flushRow}）都走这一个数，杜绝再次分家——曾出现判据用
     * "两段 + 列距"而测量期用"两段取较大"，wrap_content 容器于是自报宽偏小（比并排所需小），
     * 落位后（它的行宽就是自报宽）判据必然为真：尾段折到第二行，而高度只按一行算 → 第二行被裁。
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
     * <p>未标记者 = 自身高 + 上下外边距。已标记者 = 它占据的<b>下沿</b>
     * {@code offsetPx + 高/2}（= 行顶到它下沿的距离）——标记只钉垂直中心、落点可越出本行下沿，
     * 行高必须按这个下沿算，否则它会盖住下一行。
     *
     * <p>下沿为负（子视图整体落在本行上方）时按 0 计：<b>有意不为越出上方的部分加高，也不平移本行</b>
     * ——向上越出是调用方自己给的偏移，容器不代它兜底（下方越出则必须兜，否则会相碰）。
     */
    private static int occupiedHeight(View child, LayoutParams lp) {
        if (lp.verticalCenterAt == LayoutParams.VERTICAL_CENTER_UNSET) {
            return outerHeight(child, lp);
        }
        return Math.max(0, lp.verticalCenterAt + child.getMeasuredHeight() / 2);
    }

    /**
     * 一趟排布的进行态。只活在一次 {@link #onMeasure}/{@link #onLayout} 内（局部对象），
     * 因此容器本身<b>不持有任何子视图引用</b>：{@code removeAllViews()} 之后不残留任何标记。
     * 行与尾段都用<b>子视图下标区间</b>表示，连临时的 {@code List} 都不需要。
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
