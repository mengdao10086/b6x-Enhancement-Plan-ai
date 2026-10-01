package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

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
        // 键盘 inset 只在 adjustResize 下送达；adjustPan 会把它吞掉（见类注释）
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        final BottomBarLayout bottomBarLayout = new BottomBarLayout();
        if (bottomBar != null) {
            // 顶掉 material 自带的那个会改写 paddingBottom 的监听（见类注释）
            ViewCompat.setOnApplyWindowInsetsListener(bottomBar, (view, windowInsets) -> windowInsets);
        }
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, windowInsets) -> {
            Insets bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = windowInsets.getInsets(WindowInsetsCompat.Type.ime());
            // 键盘比系统手势条高即认为键盘在：此时整页上移，底栏不再额外垫那一条
            boolean imeUp = ime.bottom > bars.bottom;
            if (bottomBar == null) {
                view.setPadding(bars.left, bars.top, bars.right, imeUp ? ime.bottom : bars.bottom);
            } else {
                view.setPadding(bars.left, bars.top, bars.right, imeUp ? ime.bottom : 0);
                bottomBarLayout.apply(bottomBar, imeUp ? 0 : bars.bottom);
            }
            return windowInsets;
        });
        ViewCompat.requestApplyInsets(root);
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
}
