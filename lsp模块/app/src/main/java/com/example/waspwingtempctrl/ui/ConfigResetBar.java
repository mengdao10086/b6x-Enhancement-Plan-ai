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
import java.util.Arrays;
import java.util.Collections;
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
 *
 * <h3>按钮顺序</h3>
 * 用本栏自己的展示顺序（{@link #DISPLAY_ORDER}），<b>与定义里的组顺序不同</b>——理由见该常量。
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
     * 本栏按钮的<b>展示顺序</b>（group id）。它与参数定义里的组顺序<b>不同</b>，是有意为之：
     * 用户指定「界面」紧随「性能参数」（重置界面参数比重置 sysfs 路径更常用）；而定义里的组顺序
     * 决定 {@code profile.conf} 的段标顺序，不能为了本栏的观感去动它。
     *
     * <p>写成显式表，而不是"照定义顺序排一遍"：这个顺序是需求本身，不是巧合，也不是排序结果。
     * 表外的组由 {@link #orderedGroups} 追加到末尾；表里已失效的 id 静默跳过。
     *
     * <p>只列 id，不列组名：组标题正在被改（{@code [2] sysfs 路径与缩放} → {@code [2] 路径与缩放}
     * 等），按钮文案一律从 {@link GroupMeta#title} 取并去段标，不在这里手抄一遍。
     */
    private static final List<String> DISPLAY_ORDER =
            Collections.unmodifiableList(Arrays.asList("debug", "perf", "webui", "sysfs", "launch"));

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
     *
     * <p>两级降级都不报错、也不留空按钮：表里列了而定义里已删的 id 静默跳过；定义里有而表里
     * 没列的组追加到末尾（顺序退化为定义顺序）——将来定义新增分组时按钮一定会出现，
     * 不会因为忘了改这张表而少一个。
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
