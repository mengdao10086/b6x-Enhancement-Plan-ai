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
 *   <li>底 → 有底栏时给底栏（高度 = 自身内容高 + 系统条高，底部内边距同样取后者），
 *       于是底栏背景铺到屏幕底、条目仍在系统条之上；没有底栏的页面（设置页）直接给页面根。</li>
 *   <li>键盘弹起时（键盘比系统手势条高）窗口整体上移：底部内边距给页面根、底栏不再垫那一条。</li>
 * </ul>
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
     *                  它的高度必须是定值（本类按"当前高 − 当前底部内边距"反推自身内容高，
     *                  故要求它自己没有别的底部内边距）；wrap_content 的话本类不动它。
     */
    public static void apply(@NonNull Activity activity, @NonNull View root,
                             @Nullable View bottomBar) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        // 键盘 inset 只在 adjustResize 下送达；adjustPan 会把它吞掉（见类注释）
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, windowInsets) -> {
            Insets bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = windowInsets.getInsets(WindowInsetsCompat.Type.ime());
            // 键盘比系统手势条高即认为键盘在：此时整页上移，底栏不再额外垫那一条
            boolean imeUp = ime.bottom > bars.bottom;
            if (bottomBar == null) {
                view.setPadding(bars.left, bars.top, bars.right, imeUp ? ime.bottom : bars.bottom);
            } else {
                view.setPadding(bars.left, bars.top, bars.right, imeUp ? ime.bottom : 0);
                applyBottomBarInset(bottomBar, imeUp ? 0 : bars.bottom);
            }
            return windowInsets;
        });
        ViewCompat.requestApplyInsets(root);
    }

    /**
     * 底栏：自身内容高恒定，底部再垫 {@code inset}。
     *
     * <p>自身内容高由「当前 LayoutParams 高 − 当前底部内边距」反推，故本方法可重复调用
     * （第二次进来算出的内容高与第一次相同，不会越垫越厚）。
     */
    private static void applyBottomBarInset(@NonNull View bottomBar, int inset) {
        ViewGroup.LayoutParams params = bottomBar.getLayoutParams();
        if (params == null || params.height <= 0) {
            // 高度不是定值（wrap_content/match_parent）：留空，免得把比例算坏
            return;
        }
        int contentHeight = params.height - bottomBar.getPaddingBottom();
        bottomBar.setPadding(bottomBar.getPaddingLeft(), bottomBar.getPaddingTop(),
                bottomBar.getPaddingRight(), inset);
        params.height = contentHeight + inset;
        bottomBar.setLayoutParams(params);
    }
}
