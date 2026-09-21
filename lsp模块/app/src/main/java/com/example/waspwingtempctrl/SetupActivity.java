package com.example.waspwingtempctrl;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.waspwingtempctrl.ui.ConfigFormFragment;
import com.example.waspwingtempctrl.ui.EdgeToEdge;
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
 * <p><b>页签数量与顺序必须与 {@link #MENU_IDS} 一一对应</b>（同为 3 个、同序），菜单顺序声明在
 * {@code res/menu/menu_bottom.xml}。
 *
 * <p><b>切页 = ViewPager2</b>：手指跟随滑动、松手 fling 吸附到最近页，都由它给（页面容器是
 * {@code androidx.viewpager2.widget.ViewPager2}）。三页由 {@link FragmentStateAdapter} 持有，
 * {@code offscreenPageLimit = 2} 让三页都留在 FragmentManager 里（页面状态与滚动位置保住）。
 *
 * <p>代价：<b>页面生命周期不再随切页变化</b>（非当前页被压到 STARTED，不派发 onPause，
 * 也没有 hide/show 的 onHiddenChanged）。需要在"离开本页"时停定时器/归还软键盘设置的页面，
 * 实现 {@link PageAware}，由本类在切页后广播可见性。页序号经 {@link #ARG_PAGE} 写进 Fragment
 * 的 arguments：进程恢复后重建的实例也照样能算出自己是第几页。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";

    /** 页序号参数名（写进各页 Fragment 的 arguments，可见性广播时反查用）。 */
    static final String ARG_PAGE = "ww_page";

    /** 底栏菜单项 id，顺序即页序，必须与 {@code res/menu/menu_bottom.xml} 一致。 */
    private static final int[] MENU_IDS = {R.id.tab_status, R.id.tab_config, R.id.tab_log};

    private BottomNavigationView nav;
    private ViewPager2 pager;

    /** 底栏与 pager 互相驱动时的防重入标记（两者任一变化都会回调对方）。 */
    private boolean syncing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题。
        setTheme(R.style.Theme_B6XTempCtrl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        pager = findViewById(R.id.page_pager);
        nav = findViewById(R.id.bottom_nav);
        // 下侧沉浸式：底栏背景铺到屏幕底，条目留在系统手势条之上（见 ui/EdgeToEdge）
        EdgeToEdge.apply(this, findViewById(R.id.setup_root), nav);
        pager.setAdapter(new PagesAdapter());
        pager.setOffscreenPageLimit(MENU_IDS.length - 1);

        nav.setOnItemSelectedListener(item -> {
            setPage(indexOf(item.getItemId()));
            return true;
        });

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // 底栏跟随滑动结果；此处改底栏会回调上面的监听器，故加防重入标记
                syncing = true;
                nav.setSelectedItemId(MENU_IDS[position]);
                syncing = false;
                broadcastVisibility();
            }
        });

        // 界面参数（原「[4] 界面」组）的入口：标题栏右侧设置按钮
        findViewById(R.id.action_settings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));

        int index = savedInstanceState == null ? 0 : savedInstanceState.getInt(KEY_TAB, 0);
        int initial = index < 0 || index >= MENU_IDS.length ? 0 : index;
        syncing = true;
        pager.setCurrentItem(initial, false);   // 不播放入场动画：冷启动直接落在上次那一页
        nav.setSelectedItemId(MENU_IDS[initial]);
        syncing = false;
        // 首帧之后再广播一次：此刻页面视图才建好（ViewPager2 在布局中创建页面）
        pager.post(this::broadcastVisibility);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 回前台或页面被系统重建后重发一次：页面自己记的可见性状态可能已经丢了
        broadcastVisibility();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (pager != null) {
            outState.putInt(KEY_TAB, pager.getCurrentItem());
        }
    }

    // ==================== 页签与翻页 ====================

    /** 菜单项 id → 页序号；不属于本菜单时返回 -1。 */
    private static int indexOf(int itemId) {
        for (int i = 0; i < MENU_IDS.length; i++) {
            if (MENU_IDS[i] == itemId) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 切到第 {@code index} 页（底栏点击用）。翻页动画即 ViewPager2 的平滑滚动，不再手写转场。
     * 防重入：底栏由 onPageSelected 反向同步时不回推，避免两者互相触发。
     */
    private void setPage(int index) {
        if (syncing || index < 0 || index >= MENU_IDS.length) {
            return;
        }
        if (pager.getCurrentItem() != index) {
            pager.setCurrentItem(index, true);
        }
    }

    /**
     * 广播页面可见性：只有当前页收 true。
     *
     * <p>遍历 FragmentManager 里的实例，而不是按页序号反查——FragmentStateAdapter 用内部 tag
     * （{@code "f" + itemId}）持有页面，依赖那条约定太脆；页序号由本类写进 arguments，故凡是
     * {@link PageAware} 的页面都能自己算出第几页（进程恢复后重建的实例也一样）。
     */
    private void broadcastVisibility() {
        int current = pager == null ? 0 : pager.getCurrentItem();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (!(fragment instanceof PageAware)) {
                continue;
            }
            Bundle args = fragment.getArguments();
            int page = args == null ? -1 : args.getInt(ARG_PAGE, -1);
            ((PageAware) fragment).onPageVisible(page == current);
        }
    }

    /** 三页一份：页序号 → Fragment。页序号顺手写进 arguments 供可见性广播反查。 */
    private final class PagesAdapter extends FragmentStateAdapter {

        PagesAdapter() {
            super(SetupActivity.this);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = create(position);
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return MENU_IDS.length;
        }
    }

    private static Fragment create(int index) {
        switch (index) {
            case 0:
                return new StatusFragment();
            case 1:
                return new ConfigFormFragment();
            default:
                return new LogFragment();
        }
    }
}
