package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数重置栏：按分组把参数恢复成<b>出厂值</b>（{@code factory}，不是定义默认值 {@code default}）。
 *
 * <h3>职责边界：本类只出界面与确认，落盘归宿主</h3>
 * 分组清单、组内键、出厂值全部取自 {@link ConfigStore}（本类不手抄任何分组名或键名）；
 * 真正的写入由宿主完成（{@link Host#onResetConfirmed}）——重置必须"先冲刷待写队列，
 * 再借页面的落盘线程一次原子写入，最后重刷本页"，这三件事都握在页面手上（队列与线程都是页面的），
 * 组件不另起第二条写入口。
 *
 * <h3>重置一组 = 组内键 + 组头总开关</h3>
 * 组键清单含 {@link GroupMeta#master}：总开关为 0 时整组不生效，漏掉它等于"重置了却没生效"。
 * master 为 null 的组（设置页的 {@code webui} 组）自然跳过。
 *
 * <h3>按钮文案去掉段标编号</h3>
 * 与设置页卡头同一口径（复用 {@link UiSettingsFragment#stripSectionNumber}）：编号是给
 * {@code profile.conf} 段标对齐用的，摆在按钮上只是噪音。
 */
final class ConfigResetBar {

    /**
     * 重置栏与页面的交互面：键行那套服务（{@code store/queue/notifyUser}…）原样复用同一份
     * {@link ConfigKeyRow.Host}，不另立一份重复的接口。
     */
    interface Host extends ConfigKeyRow.Host {
        /**
         * 用户已确认重置某组（主线程）。宿主负责：<b>先冲刷待写队列</b> → 按出厂值一次原子写盘
         * → 重刷本页值与徽标 → 给出成败反馈。
         *
         * @param label         显示用组名（已去段标编号，仅用于反馈文案）
         * @param factoryValues 该组的键 → 出厂值（含组头总开关；定义里查不到的键与无出厂值的键已剔除）
         */
        void onResetConfirmed(@NonNull String label, @NonNull Map<String, Value> factoryValues);
    }

    private final Host host;
    private final View card;
    private final LinearLayout buttons;

    static ConfigResetBar create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                                 @NonNull Host host) {
        return new ConfigResetBar(inflater.inflate(R.layout.view_config_reset_bar, parent, false),
                host);
    }

    private ConfigResetBar(View card, Host host) {
        this.card = card;
        this.host = host;
        buttons = card.findViewById(R.id.config_reset_buttons);
        // 每个分组一个按钮：分组数量与组名都来自定义，本类不写死这 5 个
        for (GroupMeta group : host.store().groups()) {
            buttons.addView(buildButton(group));
        }
    }

    @NonNull
    View view() {
        return card;
    }

    private MaterialButton buildButton(GroupMeta group) {
        Context context = card.getContext();
        String label = UiSettingsFragment.stripSectionNumber(group.title);
        MaterialButton button = (MaterialButton) LayoutInflater.from(context)
                .inflate(R.layout.item_config_reset_button, buttons, false);
        button.setText(label);
        button.setOnClickListener(v -> confirm(group, label));
        return button;
    }

    /** 确认后才动手：重置不可撤销，且会连带把该组的组头总开关一起改掉。 */
    private void confirm(GroupMeta group, String label) {
        Context context = card.getContext();
        new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.config_reset_dialog_title, label))
                .setMessage(R.string.config_reset_dialog_message)
                .setPositiveButton(R.string.config_reset_confirm,
                        (dialog, which) -> host.onResetConfirmed(label, factoryValues(group)))
                .setNegativeButton(R.string.config_reset_cancel, null)
                .show();
    }

    /**
     * 该组的键 → 出厂值，含组头总开关。
     *
     * <p>定义里查不到的键、没有出厂值的键都<b>跳过</b>：宁可少写一个键，也不拿默认值冒充出厂值。
     * 整组都取不到时返回空表，由宿主按"没有可写入的键"给出的失败反馈收尾。
     */
    @NonNull
    private Map<String, Value> factoryValues(@NonNull GroupMeta group) {
        List<String> keys = new ArrayList<>(group.keys);
        if (group.master != null) {
            keys.add(group.master);
        }
        Map<String, Value> values = new LinkedHashMap<>();
        for (String key : keys) {
            KeyMeta meta = host.store().key(key);
            if (meta != null && meta.factoryValue != null) {
                values.put(key, meta.factoryValue);
            }
        }
        return values;
    }
}
