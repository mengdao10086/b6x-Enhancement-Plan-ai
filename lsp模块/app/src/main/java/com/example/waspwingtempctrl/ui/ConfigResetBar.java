package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数重置栏：按分组把参数恢复成<b>出厂值</b>（{@code factory}，不是定义默认值 {@code default}）。
 * 本类只出界面与确认，落盘归宿主（见 {@link Host#onResetConfirmed}）；重置一组 = 组内键 + 组头总开关。
 * 设计理由与按钮顺序口径见 app 逻辑说明.md §6.4。
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

    /**
     * 本栏按钮的<b>展示顺序</b>（group id）。<b>与定义里的组顺序不同，是有意为之</b>（理由见
     * app 逻辑说明.md §6.4）。表外的组由 {@link #orderedGroups} 追加到末尾；表里已失效的 id 静默跳过。
     */
    private static final List<String> DISPLAY_ORDER =
            Collections.unmodifiableList(Arrays.asList("debug", "perf", "webui", "sysfs", "launch"));

    private final Host host;
    private final View card;
    /** 按钮容器（view_config_reset_bar.xml 的 config_reset_buttons）：按钮都是普通子视图，不必声明任何换行标记。 */
    private final WrapRowLayout buttons;

    static ConfigResetBar create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                                 @NonNull Host host) {
        return new ConfigResetBar(inflater.inflate(R.layout.view_config_reset_bar, parent, false),
                host);
    }

    private ConfigResetBar(View card, Host host) {
        this.card = card;
        this.host = host;
        buttons = card.findViewById(R.id.config_reset_buttons);
        // 一个分组一个按钮：按钮数量与组名都来自定义，本类只定展示顺序（见 DISPLAY_ORDER），
        // 不写死这 5 个分组，按钮文案也不写死（组标题正在被改，硬编码就会与定义分家）
        for (GroupMeta group : orderedGroups(host.store().groups())) {
            buttons.addView(buildButton(group));
        }
    }

    @NonNull
    View view() {
        return card;
    }

    /**
     * 取要出按钮的分组，按 {@link #DISPLAY_ORDER} 排；表外的一律追加到末尾。
     * 两级降级都不报错、也不留空按钮（口径见 app 逻辑说明.md §6.4）。
     */
    @NonNull
    private static List<GroupMeta> orderedGroups(@NonNull List<GroupMeta> groups) {
        Map<String, GroupMeta> remaining = new LinkedHashMap<>();
        for (GroupMeta group : groups) {
            remaining.put(group.id, group);
        }
        List<GroupMeta> ordered = new ArrayList<>(groups.size());
        for (String id : DISPLAY_ORDER) {
            // remove 一并覆盖"表里重复写了同一个 id"：第二次取到 null，不会出两个按钮
            GroupMeta group = remaining.remove(id);
            if (group != null) {
                ordered.add(group);
            }
        }
        ordered.addAll(remaining.values());
        return ordered;
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
        // 点弹窗外部即取消（AppCompat AlertDialog 默认不随点外触摸取消，须显式设置）；
        // 取消 = 什么都不做，重置只在肯定按钮里发生
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.config_reset_dialog_title, label))
                .setMessage(R.string.config_reset_dialog_message)
                .setPositiveButton(R.string.config_reset_confirm,
                        (d, which) -> host.onResetConfirmed(label, factoryValues(group)))
                .setNegativeButton(R.string.config_reset_cancel, null)
                .create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
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
