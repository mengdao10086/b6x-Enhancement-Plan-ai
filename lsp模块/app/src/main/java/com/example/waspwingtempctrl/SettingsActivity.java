package com.example.waspwingtempctrl;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.waspwingtempctrl.ui.EdgeToEdge;
import com.example.waspwingtempctrl.ui.UiSettingsFragment;

/**
 * 设置页外壳：顶栏设置按钮点进来的独立页面，内容只有 {@link UiSettingsFragment}
 * （{@code params.json} 里 {@code webui} 组——标题 {@code [4] 界面}——那几个界面自用参数）。
 *
 * <p><b>本类不含业务</b>：读、改、落盘全在 Fragment 里，返回键只结束本页（设置页是独立页面，
 * 不退到主界面，主界面由它自己的页签状态恢复）。
 *
 * <p>{@code setTheme} 必须在 {@code super.onCreate()} 之前，理由见 {@code app/逻辑说明.md} §5.4。
 */
public class SettingsActivity extends AppCompatActivity {

    /** 内容 Fragment 的 tag（重建时按 tag 找回，不重复添加）。 */
    private static final String TAG_UI_SETTINGS = "ui_settings";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题
        setTheme(R.style.Theme_B6XTempCtrl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // 本页没有铺到屏幕底的栏，底部内边距归页面根（与外壳同一套让位算法，见 ui/EdgeToEdge）
        EdgeToEdge.apply(this, findViewById(R.id.settings_root), null);

        View back = findViewById(R.id.settings_back);
        // 走返回派发链而不是 finish()：系统手势返回、预测性返回与按钮返回同一条路径
        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        // 重建（旋转/进程恢复）时 FragmentManager 会自己恢复，重复 add 会叠出两份表单
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.settings_container, new UiSettingsFragment(), TAG_UI_SETTINGS)
                    .commit();
        }
    }
}
