package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * 下侧沉浸式：让窗口铺满整屏（含系统手势条/导航栏那一条带子），系统栏的让位由本类算。
 *
 * <p>为什么需要它、谁吃哪段内边距、为什么要顶掉底栏自带的 inset 监听、与键盘的关系——见
 * {@code app/逻辑说明.md} §9.2。
 *
 * <p>键盘一律"只覆盖、不顶起"：窗口 softInputMode 全局设成 {@code ADJUST_NOTHING}，让位算法
 * 不再有 IME 分支；被键盘挡住的输入框由本类内建的 {@link ImeReveal} 滚进可视区。
 */
public final class EdgeToEdge {

    private EdgeToEdge() {
    }

    /**
     * @param root      页面根（顶/左/右内边距归它）
     * @param bottomBar 要铺到屏幕底的那个栏（底栏），可为 null（没有这种栏时底部内边距归 root）。
     *                  它必须是定高（wrap_content/match_parent 时本类不动它）；XML 里声明的那个高度
     *                  被当作基准内容高，只在首次调用时量一次，之后不再反推（见 {@link BottomBarLayout}）。
     */
    public static void apply(@NonNull Activity activity, @NonNull View root,
                             @Nullable View bottomBar) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        // 键盘只覆盖、不顶起：整页不重排、底栏不上移。decorFits=false 下 adjust 值不影响 insets
        // 派发（见 app/逻辑说明.md §9.2），这里锁死"不缩窗、不平移"这条旧通路。
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        final BottomBarLayout bottomBarLayout = new BottomBarLayout();
        final ImeReveal imeReveal = new ImeReveal();
        if (bottomBar != null) {
            // 顶掉 material 自带的那个会改写 paddingBottom 的监听（见类注释）
            ViewCompat.setOnApplyWindowInsetsListener(bottomBar, (view, windowInsets) -> windowInsets);
        }
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, windowInsets) -> {
            Insets bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            // 让位只按 systemBars 算：键盘不参与重排
            if (bottomBar == null) {
                view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            } else {
                view.setPadding(bars.left, bars.top, bars.right, 0);
                bottomBarLayout.apply(bottomBar, bars.bottom);
            }
            // 复用这唯一一个 inset 监听驱动"聚焦滚进可视区"（另装监听会顶掉本让位监听）
            imeReveal.onInsets(view, windowInsets);
            return windowInsets;
        });
        ViewCompat.requestApplyInsets(root);
        // 键盘已弹起时焦点在输入框之间跳动，也要重新滚一次
        root.getViewTreeObserver().addOnGlobalFocusChangeListener((oldFocus, newFocus) -> {
            if (newFocus != null) {
                imeReveal.onFocusChanged(root);
            }
        });
    }

    /**
     * 底栏几何的持有者：{@code height = 基准内容高 + inset}、{@code paddingBottom = inset}，两者都是
     * 绝对赋值、不是叠加；基准内容高<b>只在首次调用时量一次</b>、之后恒用该值。旧写法为什么错见
     * {@code app/逻辑说明.md} §9.2。
     */
    private static final class BottomBarLayout {

        /** 基准内容高；负值表示还没量过。 */
        private int baseContentHeight = -1;

        void apply(@NonNull View bottomBar, int inset) {
            ViewGroup.LayoutParams params = bottomBar.getLayoutParams();
            if (params == null || params.height <= 0) {
                // 高度不是定值（wrap_content/match_parent）：留空，免得把比例算坏
                return;
            }
            if (baseContentHeight < 0) {
                baseContentHeight = params.height - bottomBar.getPaddingBottom();
            }
            int height = baseContentHeight + inset;
            if (params.height == height && bottomBar.getPaddingBottom() == inset) {
                // 与现状一致：不写回，也不触发多余的布局
                return;
            }
            bottomBar.setPadding(bottomBar.getPaddingLeft(), bottomBar.getPaddingTop(),
                    bottomBar.getPaddingRight(), inset);
            params.height = height;
            bottomBar.setLayoutParams(params);
        }
    }

    /**
     * "聚焦滚进可视区"兜底：键盘弹起时，若当前焦点所在的输入框被键盘挡住，就把<b>它所在的那个
     * 滚动区</b>往上滚一点让它露出来。只改滚动偏移、零 padding，因此无状态、无残留、无"必须成对"。
     *
     * <p>纯增量：读不到键盘高度（{@code ime.bottom <= bars.bottom}）就什么都不做，绝不退化回重排。
     */
    private static final class ImeReveal {

        /** 输入框与键盘之间要留的余量。 */
        private static final int MARGIN_DP = 16;

        /** 最近一次键盘高度（px，相对窗口底）；0 表示键盘不在。每个实例只服务一个 Activity 窗口，不跨页共享。 */
        private int lastImeBottom;

        /** inset 变化时调用：记下键盘高度，键盘在就滚一次。 */
        void onInsets(@NonNull View root, @NonNull WindowInsetsCompat insets) {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());
            lastImeBottom = ime.bottom > bars.bottom ? ime.bottom : 0;
            if (lastImeBottom > 0) {
                scheduleReveal(root);
            }
        }

        /** 焦点变化时调用：键盘在就按新焦点重滚一次。 */
        void onFocusChanged(@NonNull View root) {
            if (lastImeBottom > 0) {
                scheduleReveal(root);
            }
        }

        /** 延后一帧再算：滚动落点依赖布局完成时机。 */
        private void scheduleReveal(@NonNull View root) {
            root.post(() -> reveal(root));
        }

        private void reveal(@NonNull View root) {
            if (!root.isAttachedToWindow()) {
                return;
            }
            View focused = root.findFocus();
            if (focused == null) {
                return;
            }
            // 沿父链找滚动容器；找不到就 no-op（日志页搜索框在顶部、祖先链上没有滚动容器）
            ScrollView scroll = findScrollAncestor(focused);
            if (scroll == null) {
                return;
            }
            int[] rootLoc = new int[2];
            int[] focusLoc = new int[2];
            root.getLocationInWindow(rootLoc);
            focused.getLocationInWindow(focusLoc);
            int marginPx = Math.round(MARGIN_DP * root.getResources().getDisplayMetrics().density);
            // limit = 键盘上沿再往上留一个边距，即焦点底允许停留的最低位置；limit 内已含该边距
            int limit = rootLoc[1] + root.getHeight() - lastImeBottom - marginPx;
            int focusedBottom = focusLoc[1] + focused.getHeight();
            // 只补"超出 limit 的那一段"：滚完后焦点底落在 limit，即键盘上沿上方恰好一个边距
            int delta = focusedBottom - limit;
            if (delta > 0) {
                scroll.smoothScrollBy(0, delta);
            }
        }

        @Nullable
        private static ScrollView findScrollAncestor(@NonNull View view) {
            ViewParent parent = view.getParent();
            while (parent != null) {
                if (parent instanceof ScrollView) {
                    return (ScrollView) parent;
                }
                parent = parent.getParent();
            }
            return null;
        }
    }
}
