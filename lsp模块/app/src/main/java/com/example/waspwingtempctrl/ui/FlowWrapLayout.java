package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式（自动换行）容器：子视图按添加顺序从左到右排布，一行放不下就换行；
 * 同一行内各子视图按各自高度<b>垂直居中</b>。
 *
 * <h3>为什么自己写而不是引第三方</h3>
 * FlexboxLayout 为浏览器级的 flex 语义（收缩/增长/基线/顺序）付成本，本容器只需要
 * "依次摆放 + 放不下换行 + 行内居中"三条规则，六十来行即可覆盖；配置页键数量级（每页几十个）
 * 也不需要虚拟化。
 *
 * <h3>为什么继承 LinearLayout</h3>
 * onMeasure/onLayout 被整个替换，{@code orientation} 不参与计算。继承只为两件事：
 * 调用方（{@link ConfigGroupBinder}）的字段类型仍是 {@code LinearLayout}；
 * XML 里的 {@code layout_margin*} 仍按 {@link LinearLayout.LayoutParams}（即 MarginLayoutParams）解析。
 *
 * <h3>整行 / 另起一行 / 独占一行</h3>
 * {@link #setFullLine} 标记的子视图独占一行且铺满行宽（键行用它让"参数名 + 右侧开关"占满一行，
 * 开关才能贴到行尾）；{@link #setBreakBefore} 标记的子视图只<b>另起一行</b>、宽度仍按自己的
 * LayoutParams 量（曲线页图例用它把"冷端℃ / CPU℃"两条可选温度传感器固定排到第二行，
 * 不让它们随各项自然宽随机掉行）；{@link #setAloneInRow} 标记的子视图<b>前后都换行</b>、
 * 独自占一整行，但同样不铺满（配置页多值键的开关用它独占一行）。
 * 放不下时的换行判定只看<b>外边距盒子</b>的宽度，不读子视图内部结构。
 *
 * <h3>行内水平对齐与首行缩进</h3>
 * {@link #setRowAlign} 决定一行内容贴行左界还是贴行右界，缺省贴左界；{@link #setFirstRowIndent}
 * 只把<b>首行</b>的起点右移一段，并把首行的可用上限收窄同样多（换行判定与摆放都用它），
 * 第二行起回到整行宽。两者都只服务配置页键行"控制区的内容盒覆盖整行、首行让开参数名"
 * （见 {@code ConfigKeyRow#syncControlGeometry}）；不设时行为与加这两个能力之前一字不差——
 * 曲线页图例、参数重置栏、分组卡都依赖这个缺省。
 *
 * <p>仅按 LTR 排布（界面无镜像语言需求）。列距固定用标尺 {@code space_m}——参数名到卡片
 * 左侧内边距（同为 12dp）一致；行距缺省同 {@code space_m}，可由调用方用 {@code app:flowRowGap}
 * 单独指定（曲线页图例要把行距压到远小于列距，又不动列距，见 fragment_chart.xml）。
 */
public final class FlowWrapLayout extends LinearLayout {

    /** 行内水平对齐：贴行左界（缺省）。 */
    public static final int ROW_ALIGN_START = 0;
    /** 行内水平对齐：贴行右界（行内容整体靠右），且不越过行左界。 */
    public static final int ROW_ALIGN_END = 1;

    /** 独占一行且铺满行宽的子视图。 */
    private final List<View> fullLine = new ArrayList<>();

    /** 之前强制换行、但不铺满行宽的子视图。 */
    private final List<View> breakBefore = new ArrayList<>();

    /** 独占一整行的子视图：之前必换行、其后也必换行，宽度仍按自己的 LayoutParams 量。 */
    private final List<View> aloneInRow = new ArrayList<>();

    private final int hGap;
    /** 行距（上下两行之间）。缺省 = 列距，可被 XML 属性 app:flowRowGap 覆盖。 */
    private final int vGap;

    /** 行内水平对齐，缺省 {@link #ROW_ALIGN_START}。 */
    private int rowAlign = ROW_ALIGN_START;
    /** 首行起始缩进（像素），缺省 0。 */
    private int firstRowIndent;

    public FlowWrapLayout(Context context) {
        this(context, null);
    }

    public FlowWrapLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowWrapLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        hGap = context.getResources().getDimensionPixelSize(R.dimen.space_m);
        // 行距缺省与列距相同（配置页不设 flowRowGap，行为与加该属性前一字不差）
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.FlowWrapLayout, defStyleAttr, 0);
        vGap = a.getDimensionPixelSize(R.styleable.FlowWrapLayout_flowRowGap, hGap);
        a.recycle();
    }

    /** 标记子视图是否独占一行（铺满行宽）。须在子视图被测量前调用。 */
    public void setFullLine(@NonNull View child, boolean value) {
        fullLine.remove(child);
        if (value) {
            fullLine.add(child);
        }
        requestLayout();
    }

    /**
     * 标记子视图之前强制换行。与 {@link #setFullLine} 的区别：本方法<b>不</b>铺满行宽，
     * 子视图宽度仍按自己的 LayoutParams 量。须在子视图被测量前调用。
     *
     * <p>换行只在"本行已有内容"时判定（{@code rowWidth > 0}），故给本容器第一个子视图标记
     * 不产生任何效果——这正是要的语义：首项本来就在行首。
     */
    public void setBreakBefore(@NonNull View child, boolean value) {
        breakBefore.remove(child);
        if (value) {
            breakBefore.add(child);
        }
        requestLayout();
    }

    /**
     * 标记子视图是否独占一整行：它之前必换行、之后也必换行，宽度仍按自己的 LayoutParams 量
     * （与 {@link #setFullLine} 的区别正在于此——独占但不铺满）。
     *
     * <p>配置页多值键的开关用它在"本键字段会换行"时独占一行（见 {@code ConfigKeyRow}）。
     *
     * <p>状态没变直接返回：调用方在布局回调里按实测宽判定后调用本方法，无条件 requestLayout
     * 会自己触发自己（requestLayout → 重排 → 回调 → requestLayout）。
     */
    public void setAloneInRow(@NonNull View child, boolean value) {
        if (aloneInRow.contains(child) == value) {
            return;
        }
        if (value) {
            aloneInRow.add(child);
        } else {
            aloneInRow.remove(child);
        }
        requestLayout();
    }

    /**
     * 设置行内水平对齐（{@link #ROW_ALIGN_START} 缺省 / {@link #ROW_ALIGN_END}）。
     * 只影响每一行的起始 x，不影响测出来的自身尺寸。
     *
     * <p>状态没变直接返回：同上，调用方可能在布局回调里反复设同一个值。
     */
    public void setRowAlign(int align) {
        if (align != ROW_ALIGN_START && align != ROW_ALIGN_END) {
            return;
        }
        if (align == rowAlign) {
            return;
        }
        rowAlign = align;
        requestLayout();
    }

    /**
     * 设置首行缩进（像素，缺省 0）。
     *
     * <p>首行：起始 x = {@code paddingLeft + indent}，且该行的可用上限 = {@code rowLimit − indent}
     * （换行判定与摆放都用它）；第二行起：起始 x = {@code paddingLeft}、可用上限 = {@code rowLimit}
     * （整行宽）。配置页键行靠它把首行摆回"参数名右沿 + 间距"，同时把整行宽让给后续各行
     * （见 {@code ConfigKeyRow#syncControlGeometry}）。
     *
     * <p>状态没变直接返回，理由同 {@link #setAloneInRow}。
     */
    public void setFirstRowIndent(int indent) {
        int value = Math.max(0, indent);
        if (value == firstRowIndent) {
            return;
        }
        firstRowIndent = value;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int rowLimit = rowLimit(widthMeasureSpec);

        int limit = firstRowLimit(rowLimit);
        int rowIndent = firstRowIndent;
        int rowWidth = 0;
        int rowHeight = 0;
        boolean rowHasAlone = false;
        int contentWidth = 0;
        int contentHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            measureChild(child, lp, limit);
            int childWidth = outerWidth(child, lp);
            int childHeight = outerHeight(child, lp);
            if (rowWidth > 0
                    && startsNewRow(child, rowWidth, childWidth, limit, rowHasAlone)) {
                // 首行的右沿要算上缩进：内容盒是"缩进 + 行宽"那一段
                contentWidth = Math.max(contentWidth, rowIndent + rowWidth);
                contentHeight += rowHeight + vGap;
                limit = rowLimit;
                rowIndent = 0;
                rowWidth = 0;
                rowHeight = 0;
                rowHasAlone = false;
            }
            rowWidth += (rowWidth > 0 ? hGap : 0) + childWidth;
            rowHeight = Math.max(rowHeight, childHeight);
            rowHasAlone |= aloneInRow.contains(child);
        }
        contentWidth = Math.max(contentWidth, rowIndent + rowWidth);
        contentHeight += rowHeight;

        // 并进 suggested minimum：本类自己算尺寸，不并的话 minHeight/minWidth 会被当成死配置
        // （行高=内容高时，设了 minHeight 也不会撑开——"开关换行后那行要保底 36dp"就靠它）。
        setMeasuredDimension(
                resolveSizeAndState(
                        Math.max(contentWidth + getPaddingLeft() + getPaddingRight(),
                                getSuggestedMinimumWidth()),
                        widthMeasureSpec, 0),
                resolveSizeAndState(
                        Math.max(contentHeight + getPaddingTop() + getPaddingBottom(),
                                getSuggestedMinimumHeight()),
                        heightMeasureSpec, 0));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int rowLimit = Math.max(0, right - left - getPaddingLeft() - getPaddingRight());
        List<View> row = new ArrayList<>();
        int y = getPaddingTop();
        int limit = firstRowLimit(rowLimit);
        int rowIndent = firstRowIndent;
        int rowWidth = 0;
        int rowHeight = 0;
        boolean rowHasAlone = false;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = outerWidth(child, lp);
            if (rowWidth > 0
                    && startsNewRow(child, rowWidth, childWidth, limit, rowHasAlone)) {
                y = layoutRow(row, y, rowHeight, rowStartX(rowWidth, rowIndent, rowLimit));
                row.clear();
                limit = rowLimit;
                rowIndent = 0;
                rowWidth = 0;
                rowHeight = 0;
                rowHasAlone = false;
            }
            row.add(child);
            rowWidth += (rowWidth > 0 ? hGap : 0) + childWidth;
            rowHeight = Math.max(rowHeight, outerHeight(child, lp));
            rowHasAlone |= aloneInRow.contains(child);
        }
        layoutRow(row, y, rowHeight, rowStartX(rowWidth, rowIndent, rowLimit));
    }

    /**
     * 本行第一个子视图的落点 x。
     *
     * <p>{@link #ROW_ALIGN_START}：行左界 = {@code paddingLeft + 本行缩进}。
     * {@link #ROW_ALIGN_END}：行右界退回本行已用宽度 = {@code paddingLeft + rowLimit − rowWidth}，
     * 但不越回行左界——换行判定已保证行宽不超过"行上限 − 缩进"（首行）或行上限（其余行），
     * 越界只可能来自"单个子视图比整行还宽"这种极端情形，那时宁可让它从行左界起排、
     * 右端被父容器裁掉，也不要左端压到参数名上。
     *
     * @param rowWidth  本行已用宽度（含外边距与列距），与 onLayout 里累加出来的那个是同一个数
     * @param rowIndent 本行的缩进（只首行不为 0）
     */
    private int rowStartX(int rowWidth, int rowIndent, int rowLimit) {
        int rowLeft = getPaddingLeft() + rowIndent;
        if (rowAlign != ROW_ALIGN_END) {
            return rowLeft;
        }
        return Math.max(rowLeft, getPaddingLeft() + rowLimit - rowWidth);
    }

    /** 摆放一行（已确认不换行），返回下一行的起始 y：行内各子视图按行高垂直居中。 */
    private int layoutRow(List<View> row, int y, int rowHeight, int startX) {
        int x = startX;
        for (View child : row) {
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            int childLeft = x + lp.leftMargin;
            int childTop = y + lp.topMargin
                    + Math.max(0, (rowHeight - lp.topMargin - lp.bottomMargin - height) / 2);
            child.layout(childLeft, childTop, childLeft + width, childTop + height);
            x = childLeft + width + lp.rightMargin + hGap;
        }
        return y + rowHeight + vGap;
    }

    /**
     * 本行已放 {@code rowWidth} 时，{@code childWidth} 的子视图是否另起一行。
     *
     * <p>独占行者自身、以及紧跟在独占行者后面的那个（{@code rowHasAlone}）一律另起一行——
     * 两者合起来才是"独占一整行"。
     */
    private boolean startsNewRow(View child, int rowWidth, int childWidth, int rowLimit,
                                 boolean rowHasAlone) {
        return rowHasAlone || fullLine.contains(child) || breakBefore.contains(child)
                || aloneInRow.contains(child)
                || rowWidth + hGap + childWidth > rowLimit;
    }

    /** 单行的宽度上限（本容器的可用内容宽）。 */
    private int rowLimit(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if (mode == MeasureSpec.UNSPECIFIED) {
            return Integer.MAX_VALUE >> 1;
        }
        return Math.max(0, MeasureSpec.getSize(widthMeasureSpec)
                - getPaddingLeft() - getPaddingRight());
    }

    /** 首行的可用上限 = 整行上限 − 首行缩进（换行判定与摆放都用它）。 */
    private int firstRowLimit(int rowLimit) {
        return Math.max(0, rowLimit - firstRowIndent);
    }

    /**
     * 量一个子视图：独占行者给定宽（铺满行宽），其余按自己的 LayoutParams 量
     * （wrap_content / MATCH_PARENT 者拿到的上限是本行可用宽，故其内部若也是流式容器会自行换行）。
     *
     * <p>上限传的是<b>本行</b>的可用宽：首行被缩进吃掉一截，path 字段（MATCH_PARENT）要按首行宽量
     * 才能正好停在行右界。定宽子视图（配置页的数值框）给的是 EXACTLY 自己的宽，与上限无关。
     */
    private void measureChild(View child, MarginLayoutParams lp, int rowLimit) {
        int available = Math.max(0, rowLimit - lp.leftMargin - lp.rightMargin);
        int widthSpec = fullLine.contains(child)
                ? MeasureSpec.makeMeasureSpec(available, MeasureSpec.EXACTLY)
                : ViewGroup.getChildMeasureSpec(
                        MeasureSpec.makeMeasureSpec(available, MeasureSpec.AT_MOST), 0, lp.width);
        child.measure(widthSpec, ViewGroup.getChildMeasureSpec(
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, lp.height));
    }

    private static int outerWidth(View child, MarginLayoutParams lp) {
        return child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
    }

    private static int outerHeight(View child, MarginLayoutParams lp) {
        return child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
    }
}
