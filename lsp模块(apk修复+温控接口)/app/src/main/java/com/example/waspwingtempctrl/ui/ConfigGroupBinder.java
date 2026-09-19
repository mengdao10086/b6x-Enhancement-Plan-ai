package com.example.waspwingtempctrl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * 一个分组卡片：卡头（标题 + 组头开关 + 展开箭头）+ 键行容器。
 *
 * <p>组头开关就是 {@code role=master} 的那个键（<b>也是普通键</b>，改它同样走"改即存"），
 * 故绑定逻辑与行内开关完全共用 {@link ConfigKeyRow#commitSwitch}。
 * {@code webui} 组 master 为 null，卡头不放开关键。
 *
 * <p>默认全部折叠：本页 5 组 52 键，全展开时长列表滚到目标键要翻很久；折叠态一屏能看清全部
 * 分组与总开关，先开总开关再进组的顺序也更贴合参数之间的依赖关系。
 */
final class ConfigGroupBinder {

    private final View card;
    private final LinearLayout body;
    private final TextView titleView;
    private final TextView arrowView;
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

        for (int i = 0; i < keyMetas.size(); i++) {
            ConfigKeyRow row = ConfigKeyRow.create(inflater, body, keyMetas.get(i), host);
            row.setDividerVisible(i > 0);
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

    void refreshBadges() {
        for (ConfigKeyRow row : rows) {
            row.refreshDependencyState();
        }
    }

    private void setExpanded(boolean value) {
        expanded = value;
        body.setVisibility(value ? View.VISIBLE : View.GONE);
        divider.setVisibility(value ? View.VISIBLE : View.GONE);
        arrowView.setText(value ? R.string.config_arrow_expanded : R.string.config_arrow_collapsed);
        arrowView.setContentDescription(card.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
    }
}
