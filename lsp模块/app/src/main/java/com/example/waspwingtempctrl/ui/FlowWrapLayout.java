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
 * <h3>整行子视图</h3>
 * {@link #setFullLine} 标记的子视图独占一行且铺满行宽（键行用它让"参数名 + 右侧开关"占满一行，
 * 开关才能贴到行尾）；{@link #setBreakBefore} 标记的子视图只<b>另起一行</b>、宽度仍按自己的
 * LayoutParams 量（曲线页图例用它把"冷端℃ / CPU℃"两条可选温度传感器固定排到第二行，
 * 不让它们随各项自然宽随机掉行）。放不下时的换行判定只看<b>外边距盒子</b>的宽度，
 * 不读子视图内部结构。
 *
 * <p>仅按 LTR 排布（界面无镜像语言需求）。列距固定用标尺 {@code space_m}——参数名到卡片
 * 左侧内边距（同为 12dp）一致；行距缺省同 {@code space_m}，可由调用方用 {@code app:flowRowGap}
 * 单独指定（曲线页图例要把行距压到远小于列距，又不动列距，见 fragment_chart.xml）。
 */
public final class FlowWrapLayout extends LinearLayout {

    /** 独占一行且铺满行宽的子视图。 */
    private final List<View> fullLine = new ArrayList<>();

    /** 之前强制换行、但不铺满行宽的子视图。 */
    private final List<View> breakBefore = new ArrayList<>();

    private final int hGap;
    /** 行距（上下两行之间）。缺省 = 列距，可被 XML 属性 app:flowRowGap 覆盖。 */
    private final int vGap;

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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int rowLimit = rowLimit(widthMeasureSpec);

        int rowWidth = 0;
        int rowHeight = 0;
        int contentWidth = 0;
        int contentHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            measureChild(child, lp, rowLimit);
            int childWidth = outerWidth(child, lp);
            int childHeight = outerHeight(child, lp);
            if (rowWidth > 0 && wraps(child, rowWidth, childWidth, rowLimit)) {
                contentWidth = Math.max(contentWidth, rowWidth);
                contentHeight += rowHeight + vGap;
                rowWidth = 0;
                rowHeight = 0;
            }
            rowWidth += (rowWidth > 0 ? hGap : 0) + childWidth;
            rowHeight = Math.max(rowHeight, childHeight);
        }
        contentWidth = Math.max(contentWidth, rowWidth);
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
        int rowLimit = Math.max(0, right - left - getPaddingLeft() - getPaddingRight());
        List<View> row = new ArrayList<>();
        int y = getPaddingTop();
        int rowWidth = 0;
        int rowHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = outerWidth(child, lp);
            if (rowWidth > 0 && wraps(child, rowWidth, childWidth, rowLimit)) {
                y = layoutRow(row, y, rowHeight);
                row.clear();
                rowWidth = 0;
                rowHeight = 0;
            }
            row.add(child);
            rowWidth += (rowWidth > 0 ? hGap : 0) + childWidth;
            rowHeight = Math.max(rowHeight, outerHeight(child, lp));
        }
        layoutRow(row, y, rowHeight);
    }

    /** 摆放一行（已确认不换行），返回下一行的起始 y：行内各子视图按行高垂直居中。 */
    private int layoutRow(List<View> row, int y, int rowHeight) {
        int x = getPaddingLeft();
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

    /** 本行已放 {@code rowWidth} 时，{@code childWidth} 是否放不下 —— 独占行/另起行者一律另起一行。 */
    private boolean wraps(View child, int rowWidth, int childWidth, int rowLimit) {
        return fullLine.contains(child) || breakBefore.contains(child)
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

    /**
     * 量一个子视图：独占行者给定宽（铺满行宽），其余按自己的 LayoutParams 量
     * （wrap_content 者拿到的上限是本行可用宽，故其内部若也是流式容器会自行换行）。
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
