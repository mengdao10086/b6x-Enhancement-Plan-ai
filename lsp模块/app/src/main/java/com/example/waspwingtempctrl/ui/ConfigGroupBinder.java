package com.example.waspwingtempctrl.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;
import com.google.android.material.materialswitch.MaterialSwitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个分组卡片：卡头（标题 + "未生效"徽标 + 组头开关 + 展开箭头）+ 分隔线 + 键行容器。
 *
 * <p>组头开关即 {@code role=master} 的键（<b>也是普通键</b>，改它同样走"改即存"），走
 * {@link ConfigKeyRow#commitSwitch}；master 为 null 的组（"未分组"兜底组、设置页的 {@code webui} 组）
 * 卡头不放开关键。两个"整组一句话"的标注（未生效 / 界面自用）都只在卡头出现一次。
 * <b>键行全建、展开只切可见性</b>：行由 {@link #buildRows()} 一次建满，{@link #setExpanded} 只切可见性，
 * 展开从不现场建控件。设计理由见 app 逻辑说明.md §6.1。
 */
final class ConfigGroupBinder {

    /** 展开态的箭头旋转角：图标指向右，顺时针 90° 即指向下（收起态不转）。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    private final View card;
    /** 键行容器（item_config_group.xml）：本类只用它的 addView 与 setVisibility。 */
    private final WrapRowLayout body;
    private final TextView titleView;
    private final TextView badgeView;
    private final TextView uiBadgeView;
    private final ImageView arrowView;
    private final View divider;
    private final MaterialSwitch masterSwitch;
    private final KeyMeta masterMeta;
    /** 建本组键行所需（见 {@link #buildRows()}）：取视图的来源（预制造优先，取不到现场 inflate）。 */
    private final ViewSource views;
    private final ConfigKeyRow.Host host;
    private final List<KeyMeta> keyMetas;
    /** 本组的键行，与 {@link #keyMetas} 一一对应（构造时建满）。 */
    private final List<ConfigKeyRow> rows = new ArrayList<>();
    /** 组内有键「界面自用」（daemonConsumes=false）：卡头标一次，行内不再逐条重复。 */
    private final boolean uiOnly;

    private boolean expanded;

    /** true 时忽略组头开关回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressMaster;

    static ConfigGroupBinder create(@NonNull ViewGroup parent, @NonNull String title,
                                    @Nullable KeyMeta masterMeta, @NonNull List<KeyMeta> keyMetas,
                                    @NonNull ConfigKeyRow.Host host, @NonNull ViewSource views) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
        View card = views.inflate(R.layout.item_config_group, parent);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
        return new ConfigGroupBinder(card, title, masterMeta, keyMetas, host, views);
    }

    private ConfigGroupBinder(View card, String title, KeyMeta masterMeta,
                              List<KeyMeta> keyMetas, ConfigKeyRow.Host host, ViewSource views) {
        this.card = card;
        this.masterMeta = masterMeta;
        this.views = views;
        this.host = host;
        this.keyMetas = keyMetas;
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

        // "有任一"键界面自用（daemonConsumes=false）就在卡头标一次，行内不再重复；
        // 判据是"有任一"而非"全部"——界面组里 UI_BACK_HIDE 是要被 C 端读的（见 app 逻辑说明.md §6.1）
        boolean hasUiOnly = false;
        for (KeyMeta keyMeta : keyMetas) {
            if (!keyMeta.daemonConsumes) {
                hasUiOnly = true;
                break;
            }
        }
        uiOnly = hasUiOnly;
        uiBadgeView.setVisibility(hasUiOnly ? View.VISIBLE : View.GONE);

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

    /**
     * 本组键行的键名（= 定义里本组的键，逐个对应）：配置页的键渲染自检
     * （见 {@code ConfigFormFragment#renderSelfCheck}）用它数可编辑入口。
     */
    @NonNull
    List<String> rowKeys() {
        List<String> keys = new ArrayList<>(keyMetas.size());
        for (KeyMeta meta : keyMetas) {
            keys.add(meta.key);
        }
        return keys;
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

    /**
     * 刷新组内各行的压暗，并把"有键未生效"汇总成卡头上的一枚徽标。
     *
     * <p><b>行没"建全"时不能走这条路</b>（判据是行数与键数不等，不是"行表为空"）：按不完整的行表算出的
     * "未生效 0 个"会把卡头徽标错误隐藏，而那枚徽标在收起态是<b>唯一</b>可见的依赖提示。故没建全就转走
     * 同源判据的另一条路（{@link #refreshHeaderBadge}）。见 app 逻辑说明.md §6.1。
     */
    void refreshBadges() {
        if (rows.size() != keyMetas.size()) {   // 行与键一一对应，不等即没建全
            refreshHeaderBadge();
            return;
        }
        int unsatisfied = 0;
        for (ConfigKeyRow row : rows) {
            if (row.refreshDependencyState()) {
                unsatisfied++;
            }
        }
        setBadge(unsatisfied);
    }

    /**
     * 只刷卡头徽标（<b>行还没建时的那条路</b>）：判据与行内压暗同源（{@link ConfigKeyRow#isUnsatisfied}），
     * 直接问 store 的当前值、不经过行。用于"先建卡头、行稍后再建"的时序（见 §5.2）。见 app 逻辑说明.md §6.1。
     */
    void refreshHeaderBadge() {
        int unsatisfied = 0;
        for (KeyMeta meta : keyMetas) {
            if (ConfigKeyRow.isUnsatisfied(meta, host)) {
                unsatisfied++;
            }
        }
        setBadge(unsatisfied);
    }

    /** 卡头那枚「未生效」徽标：可见性与无障碍描述两处一起改（两条刷新路共用这一处落点）。 */
    private void setBadge(int unsatisfied) {
        badgeView.setVisibility(unsatisfied > 0 ? View.VISIBLE : View.GONE);
        if (unsatisfied > 0) {
            badgeView.setContentDescription(card.getContext().getString(
                    R.string.config_group_badge_desc, unsatisfied));
        }
    }

    /**
     * 展开/折叠本组：<b>只切可见性</b>（行由 {@link #buildRows()} 建满，本方法与建控件无关）。
     *
     * <p>构造时默认折叠（长列表先看分组名），设置页只此一组故由调用方改为默认展开。
     */
    void setExpanded(boolean value) {
        expanded = value;
        body.setVisibility(value ? View.VISIBLE : View.GONE);
        divider.setVisibility(value ? View.VISIBLE : View.GONE);
        // 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下
        arrowView.setRotation(value ? ARROW_EXPANDED_ROTATION : 0f);
        arrowView.setContentDescription(card.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
    }

    /**
     * 建本组键行（收起态也留着；由 {@code ConfigFormController} 在建表时调一次）。
     *
     * <p><b>这里不铺值、也不刷徽标</b>：行建起来之后一定紧跟一次
     * {@code ConfigFormController.applySnapshot}（建行与上屏是同一次调用里相邻的两行），值、组头开关、
     * 徽标、压暗由它一次铺满——原先"建行时铺一遍、上屏时又铺一遍"是同一份值的两遍（字段宽与说明画笔
     * 那一段尤其贵）。
     */
    void buildRows() {
        for (KeyMeta meta : keyMetas) {
            ConfigKeyRow row = ConfigKeyRow.create(body, meta, host, uiOnly, views);
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_ATTACH);
            body.addView(row.view());
            StartupTiming.accEnd(StartupTiming.FORM_SUB_ATTACH, startedAt);
            rows.add(row);
        }
    }
}
