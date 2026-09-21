package com.example.waspwingtempctrl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.google.android.material.materialswitch.MaterialSwitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个分组卡片：卡头（标题 + "未生效"徽标 + 组头开关 + 展开箭头）+ 分隔线 + 键行容器。
 *
 * <p>组头开关就是 {@code role=master} 的那个键（<b>也是普通键</b>，改它同样走"改即存"），
 * 故绑定逻辑与行内开关完全共用 {@link ConfigKeyRow#commitSwitch}。master 为 null 的组
 * （"未分组"兜底组、设置页的 {@code webui} 组）卡头不放开关键。
 *
 * <p>"未生效"徽标只在本组卡头显示一次（行内不再逐键标注）：本组只要有一个键的依赖未满足就显示，
 * 并在组内逐行压暗，指向关系靠"压暗的行 + 组头一个徽标"表达，避免每行都挂一枚徽标。
 *
 * <p>"界面自用，守护进程不读取"同属"整组一句话"的标注，也只在卡头出现一次：本组只要有键的
 * {@code daemonConsumes} 为 false（设置页的界面组即如此）就在卡头显示，行内这些键不再逐条重复。
 *
 * <p>默认全部折叠：配置页 4 组 43 键（另加 4 个组头开关），全展开时长列表滚到目标键要翻很久；
 * 折叠态一屏能看清全部分组与总开关，先开总开关再进组的顺序也更贴合参数之间的依赖关系。
 * 「[4] 界面」那 6 个键在独立设置页（{@link UiSettingsFragment}），不在本页渲染。
 */
final class ConfigGroupBinder {

    /** 展开态的箭头旋转角：图标指向右，顺时针 90° 即指向下（收起态不转）。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    private final View card;
    private final LinearLayout body;
    private final TextView titleView;
    private final TextView badgeView;
    private final TextView uiBadgeView;
    private final ImageView arrowView;
    private final View divider;
    private final MaterialSwitch masterSwitch;
    private final KeyMeta masterMeta;
    private final List<ConfigKeyRow> rows = new ArrayList<>();

    private boolean expanded;

    /** true 时忽略组头开关回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressMaster;

    static ConfigGroupBinder create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent,
                                    @NonNull String title, @Nullable KeyMeta masterMeta,
                                    @NonNull List<KeyMeta> keyMetas, @NonNull ConfigKeyRow.Host host) {
        View card = inflater.inflate(R.layout.item_config_group, parent, false);
        return new ConfigGroupBinder(card, inflater, title, masterMeta, keyMetas, host);
    }

    private ConfigGroupBinder(View card, LayoutInflater inflater, String title, KeyMeta masterMeta,
                              List<KeyMeta> keyMetas, ConfigKeyRow.Host host) {
        this.card = card;
        this.masterMeta = masterMeta;
        body = card.findViewById(R.id.config_group_body);
        titleView = card.findViewById(R.id.config_group_title);
        badgeView = card.findViewById(R.id.config_group_badge);
        uiBadgeView = card.findViewById(R.id.config_group_ui_badge);
        arrowView = card.findViewById(R.id.config_group_arrow);
        divider = card.findViewById(R.id.config_group_divider);
        masterSwitch = card.findViewById(R.id.config_group_master);

        titleView.setText(title);

        if (masterMeta == null) {
            masterSwitch.setVisibility(View.GONE);
        } else {
            masterSwitch.setVisibility(View.VISIBLE);
            masterSwitch.setOnCheckedChangeListener((button, checked) -> {
                if (suppressMaster) {
                    return;
                }
                ConfigKeyRow.commitSwitch(masterSwitch, masterMeta, host);
            });
        }

        // 组里有"界面自用"的键（如设置页的界面组）→ 这句只在卡头标一次，行内不再重复。
        // 判据是"有任何一个键不被守护进程读取"而不是"全部都不被读取"：界面组里
        // UI_BACK_HIDE 是要被 C 端读的，按"全部"判就一次都标不出来。
        boolean hasUiOnly = false;
        for (KeyMeta keyMeta : keyMetas) {
            if (!keyMeta.daemonConsumes) {
                hasUiOnly = true;
                break;
            }
        }
        uiBadgeView.setVisibility(hasUiOnly ? View.VISIBLE : View.GONE);

        for (KeyMeta keyMeta : keyMetas) {
            ConfigKeyRow row = ConfigKeyRow.create(inflater, body, keyMeta, host, hasUiOnly);
            body.addView(row.view());
            rows.add(row);
        }

        card.findViewById(R.id.config_group_header).setOnClickListener(v -> setExpanded(!expanded));
        setExpanded(false);
    }

    @NonNull
    View card() {
        return card;
    }

    @NonNull
    List<ConfigKeyRow> rows() {
        return Collections.unmodifiableList(rows);
    }

    /** 组头开关的键名；本组没有总开关时为 null。 */
    @Nullable
    String masterKey() {
        return masterMeta == null ? null : masterMeta.key;
    }

    /** 程序化回填组头开关的值（不会触发写入）。 */
    void applyMasterValue(@Nullable Value value) {
        if (masterMeta == null || value == null) {
            return;
        }
        suppressMaster = true;
        try {
            masterSwitch.setChecked(value.intAt(0) != 0);
        } finally {
            suppressMaster = false;
        }
    }

    /** 刷新组内各行的压暗，并把"有键未生效"汇总成卡头上的一枚徽标。 */
    void refreshBadges() {
        int unsatisfied = 0;
        for (ConfigKeyRow row : rows) {
            if (row.refreshDependencyState()) {
                unsatisfied++;
            }
        }
        badgeView.setVisibility(unsatisfied > 0 ? View.VISIBLE : View.GONE);
        if (unsatisfied > 0) {
            badgeView.setContentDescription(card.getContext().getString(
                    R.string.config_group_badge_desc, unsatisfied));
        }
    }

    /** 展开/折叠本组。构造时默认折叠（长列表先看分组名），设置页只此一组故由调用方改为默认展开。 */
    void setExpanded(boolean value) {
        expanded = value;
        body.setVisibility(value ? View.VISIBLE : View.GONE);
        divider.setVisibility(value ? View.VISIBLE : View.GONE);
        // 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下
        arrowView.setRotation(value ? ARROW_EXPANDED_ROTATION : 0f);
        arrowView.setContentDescription(card.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
    }
}
