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
 * 卡头不放开关键。**总开关也有「?」**（紧贴卡头标题右侧，复用 {@link ConfigKeyRow#attachHintIcon}）。
 * 两个"整组一句话"的标注（未生效 / 界面自用）都只在卡头出现一次。
 * <b>键行全建、展开只切可见性</b>：正常时行由 {@link #buildRows()} 一次建满，{@link #setExpanded} 只切可见性；
 * 若展开时全量建行还没跑到，则先补建一次再展开（{@link #ensureRowsBuilt()}），绝不展开空 body。
 * 设计理由见 app 逻辑说明.md §6.1。
 *
 * <p><b>两列</b>（目前只有「日志 &amp; 调试」组）：本类把该组的键行改标 `halfLine`（见
 * {@link WrapRowLayout#setHalfLine}），由容器逐行实测决定两项并排还是独占整行；行同时以紧凑几何建
 * （{@link ConfigKeyRow#create} 的 {@code compact}）。组样式由控制器按 {@code groups[].id} 传入。
 */
final class ConfigGroupBinder {

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
    /** 本组按键行两列排（组样式由控制器按组 id 决定；键数不足 2 时不生效）。 */
    private final boolean twoColumn;

    private boolean expanded;
    /** 行是否已建：buildRows 幂等；展开入口据此补建，保证任何时刻都不会展开空 body。 */
    private boolean rowsBuilt;

    /** true 时忽略组头开关回调：程序化回填值不该被当成用户改动作业。 */
    private boolean suppressMaster;

    static ConfigGroupBinder create(@NonNull ViewGroup parent, @NonNull String title,
                                    @Nullable KeyMeta masterMeta, @NonNull List<KeyMeta> keyMetas,
                                    @NonNull ConfigKeyRow.Host host, @NonNull ViewSource views,
                                    boolean twoColumn) {
        long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_INFLATE);
        View card = views.inflate(R.layout.item_config_group, parent);
        StartupTiming.accEnd(StartupTiming.FORM_SUB_INFLATE, startedAt);
        return new ConfigGroupBinder(card, title, masterMeta, keyMetas, host, views, twoColumn);
    }

    private ConfigGroupBinder(View card, String title, KeyMeta masterMeta,
                              List<KeyMeta> keyMetas, ConfigKeyRow.Host host, ViewSource views,
                              boolean twoColumn) {
        this.card = card;
        this.twoColumn = twoColumn;
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
            // 总开关的「?」紧贴标题右侧：item_config_group.xml 的标题宽已改 wrap_content，
            // 其后一枚 0dp 权重的 Space 把徽标 / 开关 / 箭头推到行尾，故 index 1 正好落在标题与 Space 之间。
            View header = card.findViewById(R.id.config_group_header);
            if (header instanceof ViewGroup) {
                ConfigKeyRow.attachHintIcon((ViewGroup) header, 1, masterMeta, false, true);
            }
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

        View groupHeader = card.findViewById(R.id.config_group_header);
        groupHeader.setOnClickListener(v -> setExpanded(!expanded));
        // 长按卡头复制标题：长按与点击挂在同一个 View 上，由框架按按压时长分流（长按后抬起不再触发展开）。
        // 不挂到内部标题 TextView 上——子控件会消费触摸，卡头的点击就收不到了。
        TextCopy.copyOnLongPress(groupHeader, titleView::getText);
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
     *
     * <p><b>组头总开关已关时</b>：组内所有行都按未生效处理（无差别压暗），徽标计数 = 本组行数
     * （行还没建时 = 键数）。总开关一开即回到按 {@code requires} 逐行判断。
     */
    void refreshBadges() {
        final boolean masterOff = groupOff();
        if (rows.size() != keyMetas.size()) {   // 行与键一一对应，不等即没建全
            if (masterOff) {
                setBadge(keyMetas.size());
            } else {
                refreshHeaderBadge();
            }
            return;
        }
        int unsatisfied = 0;
        for (ConfigKeyRow row : rows) {
            if (row.refreshDependencyState(masterOff)) {
                unsatisfied++;
            }
        }
        setBadge(unsatisfied);
    }

    /**
     * 只刷卡头徽标（<b>行还没建时的那条路</b>）：判据与行内压暗同源（{@link ConfigKeyRow#isUnsatisfied}），
     * 直接问 store 的当前值、不经过行。用于"先建卡头、行稍后再建"的时序（见 §5.2）。见 app 逻辑说明.md §6.1。
     *
     * <p>组头总开关已关时整组都算未生效：徽标计数直接取键数，不再逐条看 {@code requires}。
     */
    void refreshHeaderBadge() {
        if (groupOff()) {
            setBadge(keyMetas.size());
            return;
        }
        int unsatisfied = 0;
        for (KeyMeta meta : keyMetas) {
            if (ConfigKeyRow.isUnsatisfied(meta, host)) {
                unsatisfied++;
            }
        }
        setBadge(unsatisfied);
    }

    /** 本组总开关是否已关：有 master 且其当前有效值为 0（取不到值按未关处理）；master 为 null 的组恒为 false。 */
    private boolean groupOff() {
        if (masterMeta == null) {
            return false;
        }
        Value value = host.effectiveValue(masterMeta.key);
        return value != null && value.intAt(0) == 0;
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
     * 展开/折叠本组：正常情况下<b>只切可见性</b>（行由 {@link #buildRows()} 建满）；行还没建时先补建一次
     * （见 {@link #ensureRowsBuilt()}），保证任何时刻都不会展开空 body。
     *
     * <p>构造时默认折叠（长列表先看分组名），设置页只此一组故由调用方改为默认展开。
     */
    void setExpanded(boolean value) {
        expanded = value;
        if (value) {
            ensureRowsBuilt();
        }
        // 展开/收起按逻辑 2 做高度补间（系统关动画或宽度不可知时由 Motion 直接落位）；
        // 箭头用同一次返回的时长驱动——两者同生共灭，不另设箭头常量
        final long duration = Motion.animateHeight(body, value);
        // 分隔线随同一次面板时长与曲线淡入/淡出，与面板同步（面板直接落位 duration<0、或系统关动效时
        // 也直接落位，不另设常量）。收起补间的收尾里再置 GONE——此刻它已 alpha=0，收尾只是彻底移出让位
        if (duration >= 0 && Motion.enabled(card.getContext())) {
            divider.setVisibility(View.VISIBLE);
            divider.setAlpha(value ? 0f : 1f);
            divider.animate().alpha(value ? 1f : 0f).setDuration(duration)
                    .setInterpolator(Motion.panelInterpolator())
                    .withEndAction(() -> {
                        if (!value) {
                            divider.setVisibility(View.GONE);
                        }
                    }).start();
        } else {
            divider.animate().cancel();
            divider.setAlpha(1f);
            divider.setVisibility(value ? View.VISIBLE : View.GONE);
        }
        // 一副图标两种状态：展开转 90° 指向下、收起指右，走统一动效口径（角度/描述口径在 Motion.syncExpandArrow）
        Motion.syncExpandArrow(arrowView, value, duration);
    }

    /**
     * 建本组键行（收起态也留着；由 {@code ConfigFormController} 在建表时调一次，展开入口也可能先补建一次）。
     * <b>幂等</b>：{@link #rowsBuilt} 一旦立起就直接返回，重复调用不会重复建行。
     *
     * <p><b>这里不铺值、也不刷徽标</b>：行建起来之后一定紧跟一次
     * {@code ConfigFormController.applySnapshot}（建行与上屏是同一次调用里相邻的两行），值、组头开关、
     * 徽标、压暗由它一次铺满——原先"建行时铺一遍、上屏时又铺一遍"是同一份值的两遍（字段宽与说明画笔
     * 那一段尤其贵）。
     */
    void buildRows() {
        if (rowsBuilt) {
            return;   // 幂等：展开入口可能抢在全量建行之前补建过一次
        }
        rowsBuilt = true;   // 先立旗再建：中途异常也不会留下"半套行 + 再次建行"的叠加
        // 一键的组不排两列：半格左对齐只剩一个孤项，观感不如整行
        final boolean twoColumnRows = twoColumn && keyMetas.size() >= 2;
        for (KeyMeta meta : keyMetas) {
            ConfigKeyRow row = ConfigKeyRow.create(body, meta, host, uiOnly, views, twoColumnRows);
            long startedAt = StartupTiming.accBegin(StartupTiming.FORM_SUB_ATTACH);
            body.addView(row.view());
            StartupTiming.accEnd(StartupTiming.FORM_SUB_ATTACH, startedAt);
            if (twoColumnRows) {
                // 行 XML 里写着整行独占：先清掉，再改标半行（放不放得下由容器逐行实测）
                body.setFullLine(row.view(), false);
                body.setHalfLine(row.view(), true);
            }
            rows.add(row);
        }
    }

    /** 展开入口的兜底：行还没建就补建一次（{@link #buildRows()} 自身幂等，重复调用无副作用）。 */
    private void ensureRowsBuilt() {
        if (!rowsBuilt) {
            buildRows();
        }
    }
}
