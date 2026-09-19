package com.example.waspwingtempctrl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.waspwingtempctrl.ui.ChartFragment;
import com.example.waspwingtempctrl.ui.ConfigFormFragment;
import com.example.waspwingtempctrl.ui.LogFragment;
import com.example.waspwingtempctrl.ui.StatusFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * 应用外壳：工具栏 + 四个页签（状态 / 配置 / 曲线 / 日志）+ 页面容器。
 *
 * <p>本类<b>不含任何业务</b>：部署动作在 {@link StatusFragment}（I5 边界在那里），配置在
 * {@code ConfigFormFragment}，曲线在 {@code ChartFragment}，日志在 {@code LogFragment}。
 *
 * <p><b>为什么在 onCreate 里 setTheme</b>：{@code AndroidManifest.xml} 本轮冻结、不许加
 * {@code android:theme}，而 {@link AppCompatActivity} 要求 AppCompat/Material 主题。故在
 * {@code super.onCreate()} 之前手动应用 {@code R.style.Theme_B6XTempCtrl}。
 * 代价：onCreate 之前的一瞬仍是系统默认窗口背景（无碍）。
 *
 * <p>页面用 add/hide/show 切换（不用 ViewPager、不引 Navigation 组件）：
 * <b>被隐藏的 Fragment 生命周期仍是 RESUMED</b>，故页面若要起定时器/重绘，必须实现
 * {@code onHiddenChanged()} 并在其中停启——曲线页与日志页都依赖这一点。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";
    private static final String[] TAGS = {"status", "config", "chart", "log"};

    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题。
        setTheme(R.style.Theme_B6XTempCtrl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        tabs = findViewById(R.id.tab_layout);
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
            }
        });

        int index = savedInstanceState == null ? 0 : savedInstanceState.getInt(KEY_TAB, 0);
        TabLayout.Tab tab = tabs.getTabAt(index < 0 || index >= TAGS.length ? 0 : index);
        if (tab != null) {
            tab.select();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tabs != null) {
            outState.putInt(KEY_TAB, tabs.getSelectedTabPosition());
        }
    }

    /** 显示第 {@code index} 页，隐藏其余页；首次访问时按需创建。 */
    private void showPage(int index) {
        FragmentManager fm = getSupportFragmentManager();
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
        tx.commit();
    }

    private Fragment create(int index) {
        switch (index) {
            case 0:
                return new StatusFragment();
            case 1:
                return new ConfigFormFragment();
            case 2:
                return new ChartFragment();
            default:
                return new LogFragment();
        }
    }
}
