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
 * <h3>为什么需要它</h3>
 * 目标观感是「底栏背景一直铺到屏幕底、条目仍留在手势条之上」。把 {@code navigationBarColor}
 * 设成透明还不够：窗口不铺满时那条带子不归 app 画，系统还会按
 * {@code enforceNavigationBarContrast} 给透明底压一层对比遮罩，看上去就是"底栏下面还有一条
 * 灰带"。所以先 {@link WindowCompat#setDecorFitsSystemWindows} 关掉"窗口自动让位"，再自己把这
 * 几处内边距补上。
 *
 * <h3>谁吃哪段内边距</h3>
 * <ul>
 *   <li>顶/左/右 → 页面根：与原来的 {@code android:fitsSystemWindows="true"} 等价（标题栏仍留在
 *       状态栏之下）。</li>
 *   <li>底 → 有底栏时给底栏（高度 = 基准内容高 + 系统条高，底部内边距同样取后者），
 *       于是底栏背景铺到屏幕底、条目仍在系统条之上；没有底栏的页面（设置页）直接给页面根。</li>
 *   <li>键盘弹起时（键盘比系统手势条高）窗口整体上移：底部内边距给页面根、底栏回到基准高，
 *       于是底栏正好贴在键盘上沿之上，不会被键盘挡住。</li>
 * </ul>
 *
 * <h3>为什么要顶掉底栏自带的 inset 监听</h3>
 * BottomNavigationView 在自己的构造函数里就注册了一个 inset 监听，它把
 * {@code getSystemWindowInsetBottom()}（键盘弹起时就是键盘高度）无条件写进底栏自身的
 * paddingBottom；而 material 是通过 {@link ViewCompat#setOnApplyWindowInsetsListener} 注册的，
 * 属覆盖式注册。故本类在 {@link #apply} 里给底栏换上一个"原样返回 insets"的监听把它顶掉，
 * 让底栏几何只由本类那套绝对赋值独占负责——否则底栏会被反复压低（成因见
 * {@link BottomBarLayout} 的注释）。
 *
 * <h3>与键盘的关系</h3>
 * 关掉窗口自动让位后，系统不再替 app 为键盘缩窗口，故这里显式要求
 * {@link WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}（默认值在多页容器里会被选成
 * adjustPan，那会把键盘高度从 inset 里吞掉），再由上面的键盘内边距把"缩窗口"补回来——
 * 观感与改造前的 adjustResize 一致。
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
     * 底栏几何的持有者：{@code height = 基准内容高 + inset}、{@code paddingBottom = inset}，
     * 两者都是绝对赋值，不是叠加。
     *
     * <p>幂等的关键在于：基准内容高只在首次调用时量一次（XML 定高 − 当时的底部内边距；底栏自身
     * 没有别的底部内边距——{@code itemPaddingTop/Bottom} 是作用在菜单视图上的，故这里即 XML 定高），
     * 之后恒用该值。旧写法每次都用「当前 height − 当前 paddingBottom」重新反推，等于把上一次写进去的
     * inset 也当成了内容高的一部分；而 material 的 inset 监听又会在两次调用之间把键盘高度塞进
     * paddingBottom，反推值随之逐次下漂甚至变负——这正是"每拉起一次输入法，底栏就被压低一次，
     * 直到几乎看不见"的成因。
     *
     * <p>只量一次之后：连续调用 N 次算出的 height/paddingBottom 完全一致（值未变时还会直接返回，
     * 不触发多余布局）；键盘弹起时 inset = 0 → 回到基准高，收起后又是 基准高 + 系统条高，
     * 与初始状态逐值相同。
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
