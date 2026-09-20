package com.example.waspwingtempctrl;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.waspwingtempctrl.ui.ConfigFormFragment;
import com.example.waspwingtempctrl.ui.LogFragment;
import com.example.waspwingtempctrl.ui.StatusFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * 应用外壳：工具栏 + 三个页签（状态 / 配置 · 曲线 / 日志）+ 页面容器。
 *
 * <p>本类<b>不含任何业务</b>：部署动作在 {@link StatusFragment}（I5 边界在那里），配置与曲线
 * 在 {@code ConfigFormFragment}（曲线是它的子 Fragment），日志在 {@code LogFragment}。
 *
 * <p><b>为什么在 onCreate 里 setTheme</b>：{@code AndroidManifest.xml} 本轮冻结、不许加
 * {@code android:theme}，而 {@link AppCompatActivity} 要求 AppCompat/Material 主题。故在
 * {@code super.onCreate()} 之前手动应用 {@code R.style.Theme_B6XTempCtrl}。
 * 代价：onCreate 之前的一瞬仍是系统默认窗口背景（无碍）。
 *
 * <p><b>页签数量与顺序必须与 {@link #TAGS} 一一对应</b>（同为 3 个、同序），声明在
 * {@code activity_setup.xml}。不一致会让选中态页签与要挂的页面错位：页签被 TabLayout 自动
 * 选中后，对它再 {@code select()} 只派发 {@code onTabReselected}（{@code onTabSelected}
 * 不来），页面可能一直不挂载——首屏空白正是这么来的。
 *
 * <p><b>切页</b>：add/hide/show（不用 ViewPager、不引 Navigation 组件）——
 * <b>被隐藏的 Fragment 生命周期仍是 RESUMED</b>，故页面若要起定时器/重绘，必须实现
 * {@code onHiddenChanged()} 并在其中停启；曲线区（配置页的子 Fragment）另由配置页转达。
 * 页签点击与左右滑动都汇到 {@link #selectPage(int)}；横向滑动用 {@link GestureDetector}
 * 在触摸分发链上旁路观察，<b>不消费事件</b>，不影响列表/滚动视图自己的滑动。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";

    /**
     * 页签与页面一一对应，顺序必须与 {@code activity_setup.xml} 的 TabItem 顺序一致。
     */
    private static final String[] TAGS = {"status", "config", "log"};

    /** 认定一次左右滑的最小横向位移（dp）。 */
    private static final int SWIPE_MIN_DP = 24;

    private TabLayout tabs;
    private FrameLayout pageContainer;
    private GestureDetector gestures;

    /** 本次手势是否起始于页面容器内（工具栏/页签上的滑动不算切页）。 */
    private boolean swipeInPage;
    /** 横向滑动的判定阈值（px），按 density 换算。 */
    private float swipeMinPx;
    /** 页面容器在窗口中的位置，用于判断触点是否落在页面区内。 */
    private final int[] pageLocation = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题。
        setTheme(R.style.Theme_B6XTempCtrl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        pageContainer = findViewById(R.id.page_container);
        tabs = findViewById(R.id.tab_layout);
        swipeMinPx = SWIPE_MIN_DP * getResources().getDisplayMetrics().density;
        gestures = new GestureDetector(this, new SwipeListener());

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                showPage(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 首个页签在布局里就被 TabLayout 自动选中，此后对它 select() 只会走到这里
                // （onTabSelected 不来）；showPage 幂等，这里兜一次，避免"页签选中但页面没挂上"。
                showPage(tab.getPosition());
            }
        });

        int index = savedInstanceState == null ? 0 : savedInstanceState.getInt(KEY_TAB, 0);
        final int initial = index < 0 || index >= TAGS.length ? 0 : index;
        // 首屏提交等容器挂上窗口之后：容器此时才拿得到窗口令牌与真实尺寸，
        // 事务同步提交（commitNow）后页面视图在 onResume 之前就已就位。
        pageContainer.post(() -> {
            if (!isFinishing() && !isDestroyed()) {
                selectPage(initial);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tabs != null) {
            outState.putInt(KEY_TAB, tabs.getSelectedTabPosition());
        }
    }

    // ==================== 页签 ====================

    /** 切到第 {@code index} 页并同步页签（页签点击与滑动切页共用）。 */
    private void selectPage(int index) {
        if (index < 0 || index >= TAGS.length) {
            return;
        }
        TabLayout.Tab tab = tabs.getTabAt(index);
        if (tab != null && !tab.isSelected()) {
            tab.select();   // 触发 onTabSelected → showPage(index)
        }
        // 页签已在选中态时 select() 不会回调 onTabSelected（首个页签就是这样）：
        // 故这里必须自己兜底提交一次；showPage 幂等，重复调用无副作用。
        showPage(index);
    }

    /** 显示第 {@code index} 页，隐藏其余页；首次访问时按需创建。已在本页则直接返回（幂等）。 */
    private void showPage(int index) {
        if (index < 0 || index >= TAGS.length) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        Fragment target = fm.findFragmentByTag(TAGS[index]);
        if (target != null && !target.isHidden()) {
            return;
        }
        FragmentTransaction tx = fm.beginTransaction();
        for (int i = 0; i < TAGS.length; i++) {
            Fragment existing = fm.findFragmentByTag(TAGS[i]);
            if (i == index) {
                if (existing == null) {
                    tx.add(R.id.page_container, create(i), TAGS[i]);
                } else {
                    tx.show(existing);
                }
            } else if (existing != null) {
                tx.hide(existing);
            }
        }
        commitNow(tx);
    }

    /**
     * 同步提交：异步 {@code commit()} 会把"创建视图"推迟到下一次主循环消息，首帧就是空容器；
     * {@code commitNow()} 让页面视图在 {@code onResume} 之前就位（页面自己的 onResume 里发起的
     * 读盘/探测回调也就有落点）。状态已保存（后台被系统回收前）时退化为
     * {@code commitAllowingStateLoss}，不抛 IllegalStateException。
     */
    private void commitNow(FragmentTransaction tx) {
        if (getSupportFragmentManager().isStateSaved()) {
            tx.commitAllowingStateLoss();
            return;
        }
        tx.commitNow();
    }

    private Fragment create(int index) {
        switch (index) {
            case 0:
                return new StatusFragment();
            case 1:
                return new ConfigFormFragment();
            default:
                return new LogFragment();
        }
    }

    // ==================== 左右滑切页 ====================

    /**
     * 在 Activity 的触摸分发链上旁路观察手势：一律 {@code return super.dispatchTouchEvent(ev)}，
     * 不消费、不拦截，子视图（配置页的 ScrollView、日志列表、曲线画布）该滚还滚。
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (gestures != null) {
            if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
                swipeInPage = isInsidePage(ev.getX(), ev.getY());
            }
            if (swipeInPage) {
                gestures.onTouchEvent(ev);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /** 触点是否落在页面容器内（与 {@code dispatchTouchEvent} 同为窗口坐标）。 */
    private boolean isInsidePage(float x, float y) {
        if (pageContainer == null || pageContainer.getVisibility() != View.VISIBLE) {
            return false;
        }
        pageContainer.getLocationInWindow(pageLocation);
        int left = pageLocation[0];
        int top = pageLocation[1];
        return x >= left && x < left + pageContainer.getWidth()
                && y >= top && y < top + pageContainer.getHeight();
    }

    /** 只认"横向为主 + 位移够大"的快速滑动（竖向留给页面内的滚动）。 */
    private final class SwipeListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return true;   // 继续接收本次手势的后续事件
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2,
                               float velocityX, float velocityY) {
            if (e1 == null) {
                return false;
            }
            float dx = e2.getX() - e1.getX();
            float dy = e2.getY() - e1.getY();
            if (Math.abs(dx) < swipeMinPx || Math.abs(dx) < Math.abs(dy) * 1.5f) {
                return false;
            }
            int current = tabs == null ? 0 : tabs.getSelectedTabPosition();
            selectPage(dx < 0f ? current + 1 : current - 1);
            return true;
        }
    }
}
