package com.example.waspwingtempctrl;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * 应用外壳：标题栏（标题 + 右侧设置按钮）+ 页面容器 + 底部页签栏（状态 / 配置 · 曲线 / 日志）。
 *
 * <p>本类<b>不含任何业务</b>：部署动作在 {@link StatusFragment}（I5 边界在那里），配置与曲线
 * 在 {@code ConfigFormFragment}（曲线是它的子 Fragment），日志在 {@code LogFragment}，
 * 界面参数（原「[4] 界面」组）在 {@link SettingsActivity}。
 *
 * <p><b>为什么在 onCreate 里 setTheme</b>：{@code AndroidManifest.xml} 无 {@code android:theme}，
 * 而 {@link AppCompatActivity} 要求 AppCompat/Material 主题。故在 {@code super.onCreate()}
 * 之前手动应用 {@code R.style.Theme_B6XTempCtrl}。代价：onCreate 之前的一瞬仍是系统默认窗口背景（无碍）。
 *
 * <p><b>页签数量与顺序必须与 {@link #TAGS} / {@link #MENU_IDS} 一一对应</b>（同为 3 个、同序），
 * 菜单顺序声明在 {@code res/menu/menu_bottom.xml}。不一致会让选中项与要挂的页面错位：底栏的
 * 首项在布局里就被自动选中，对它再 {@code setSelectedItemId()} 不会派发选中回调，
 * 页面可能一直不挂载——首屏空白正是这么来的。
 *
 * <p><b>切页</b>：add/hide/show（不用 ViewPager、不引 Navigation 组件）——
 * <b>被隐藏的 Fragment 生命周期仍是 RESUMED</b>，故页面若要起定时器/重绘，必须实现
 * {@code onHiddenChanged()} 并在其中停启；曲线区（配置页的子 Fragment）另由配置页转达。
 * 页签点击与左右滑动都汇到 {@link #selectPage(int)}；横向滑动用 {@link GestureDetector}
 * 在触摸分发链上旁路观察，<b>不消费事件</b>，不影响列表/滚动视图自己的滑动。
 *
 * <p><b>切页转场</b>：{@link #animateIn} 手写（Fragment 自带的 {@code setCustomAnimations}
 * 对 hide/show 无效，理由见该方法注释）。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";

    /**
     * 页签与页面一一对应，顺序必须与 {@code res/menu/menu_bottom.xml} 的菜单项顺序一致。
     */
    private static final String[] TAGS = {"status", "config", "log"};

    /** 底栏菜单项 id，顺序与 {@link #TAGS} 一一对应。 */
    private static final int[] MENU_IDS = {R.id.tab_status, R.id.tab_config, R.id.tab_log};

    /** 认定一次左右滑的最小横向位移（dp）。 */
    private static final int SWIPE_MIN_DP = 24;

    /** 切页转场时长（ms）。 */
    private static final long PAGE_ANIM_MS = 180L;

    /** 转场位移量占页面宽度的比例。 */
    private static final float PAGE_ANIM_SHIFT = 0.25f;

    private BottomNavigationView nav;
    private FrameLayout pageContainer;
    private GestureDetector gestures;

    /** 当前页序号（-1 = 尚未挂过任何页）：滑动切页的起点与转场方向都取它。 */
    private int currentIndex = -1;

    /** 本次手势是否起始于页面容器内（标题栏/底栏上的滑动不算切页）。 */
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
        nav = findViewById(R.id.bottom_nav);
        swipeMinPx = SWIPE_MIN_DP * getResources().getDisplayMetrics().density;
        gestures = new GestureDetector(this, new SwipeListener());

        nav.setOnItemSelectedListener(item -> {
            showPage(indexOf(item.getItemId()));
            return true;
        });
        nav.setOnItemReselectedListener(item -> {
            // 首项在布局里就被自动选中，之后点它只走到这里；showPage 幂等，兜一次避免"选中但没挂上"。
            showPage(indexOf(item.getItemId()));
        });

        // 界面参数（原「[4] 界面」组）的入口：标题栏右侧设置按钮
        findViewById(R.id.action_settings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));

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
        if (nav != null) {
            outState.putInt(KEY_TAB, Math.max(0, indexOf(nav.getSelectedItemId())));
        }
    }

    // ==================== 页签 ====================

    /** 菜单项 id → 页序号；不属于本菜单时返回 -1。 */
    private static int indexOf(int itemId) {
        for (int i = 0; i < MENU_IDS.length; i++) {
            if (MENU_IDS[i] == itemId) {
                return i;
            }
        }
        return -1;
    }

    /** 切到第 {@code index} 页并同步底栏选中项（底栏点击与滑动切页共用）。 */
    private void selectPage(int index) {
        if (index < 0 || index >= TAGS.length) {
            return;
        }
        if (nav != null && nav.getSelectedItemId() != MENU_IDS[index]) {
            nav.setSelectedItemId(MENU_IDS[index]);   // 触发选中回调 → showPage(index)
        }
        // 该项已在选中态时 setSelectedItemId 不派发选中回调（首项就是这样）：
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
        final int from = currentIndex;
        commitNow(tx);
        currentIndex = index;
        animateIn(target, from, index);
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

    // ==================== 切页转场 ====================

    /**
     * 手写转场：新页从切换方向平移 1/4 屏宽并淡入（约 180ms）。
     *
     * <p><b>为什么不用 Fragment 自带动画</b>：{@code setCustomAnimations} 的文档与源码只覆盖
     * add/attach（进入）与 remove/detach（退出），参数说明写的就是"being added or attached"
     * 与"being removed or detached"；hide/show 路径只做 {@code mView.setVisibility}。
     * 本外壳是 add/hide/show 结构 ⇒ 自带动画不会生效。
     *
     * <p>只动进入页：旧页被新页整屏盖住，它被瞬时隐藏看不出来。
     * 首屏（{@code from < 0}）不做转场——冷启动让它直接出现，免得"开屏先飘一下"。
     *
     * @param target 刚显示的那一页（{@code commitNow} 之后其视图已就位）
     * @param from   切换前的页序号（-1 = 首屏）
     * @param to     切换后的页序号
     */
    private void animateIn(Fragment target, int from, int to) {
        if (from < 0 || from == to) {
            return;
        }
        View view = target == null ? null : target.getView();
        if (view == null) {
            return;
        }
        float shift = pageContainer.getWidth() * PAGE_ANIM_SHIFT * (to > from ? 1f : -1f);
        view.setAlpha(0f);
        view.setTranslationX(shift);
        view.animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(PAGE_ANIM_MS)
                .setInterpolator(new DecelerateInterpolator())
                .start();
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
            int current = currentIndex < 0 ? 0 : currentIndex;
            selectPage(dx < 0f ? current + 1 : current - 1);
            return true;
        }
    }
}
