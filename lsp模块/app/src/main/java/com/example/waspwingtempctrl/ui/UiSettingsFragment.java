package com.example.waspwingtempctrl.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.ConfigStore.WriteResult;
import com.example.waspwingtempctrl.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置页（顶栏设置按钮 → {@code SettingsActivity} 挂载）：只渲染 {@code params.json} 里
 * {@code webui} 组（「[4] 界面」）的那几个键。
 *
 * <h3>为什么单独一页</h3>
 * 这几个键是"曲线怎么画、界面怎么显示"的自用参数（{@code daemonConsumes=false}），
 * 与配置页那些会被守护进程读取的运维参数不是一类东西；搬到设置页后配置页只剩要调的参数。
 * 本页不重复实现表单：键行、开关、落盘规则全部复用 {@link ConfigKeyRow} /
 * {@link ConfigGroupBinder} / {@link ConfigWriteQueue}，只是宿主换成这里（{@link ConfigKeyRow.Host}）。
 * <b>本页的键数也是配置页键渲染自检的一个分项</b>，故键清单只由 {@link #webuiKeys} 给出，
 * 自检与渲染同源，不会各写一份数字。
 *
 * <h3>布局</h3>
 * 页面本身只是「@dimen/page_padding 内边距 + 重置栏 + 一张分组卡」，没有单独的布局文件：
 * 分组卡由 {@link ConfigGroupBinder} 从 {@code item_config_group.xml} 生成，重置栏是
 * {@link ConfigResetBar}（自带布局），页面壳在 {@link #onCreateView} 里直接搭。
 * 重置栏按分组整体恢复出厂值，故放在参数卡之前——先能整体回退，再逐项微调。
 *
 * <p>边界同配置页（I3）：只经 {@link ConfigStore} 读写 {@code profile.conf}，不自己解析 assets。
 */
public class UiSettingsFragment extends Fragment implements ConfigResetBar.Host {

    /** 本页承载的分组 id（对应 {@code params.json} 的 {@code groups[].id}）。 */
    private static final String SETTINGS_GROUP_ID = "webui";

    private ConfigStore store;
    private ConfigWriteQueue queue;
    private ExecutorService io;
    private Handler main;

    /** 磁盘上（或最近一次读取时）的值："值未变不写"的判定基准。仅主线程访问。 */
    private final Map<String, Value> diskValues = new LinkedHashMap<>();
    private final List<ConfigKeyRow> rows = new ArrayList<>();
    private final List<ConfigGroupBinder> groups = new ArrayList<>();

    private View rootView;
    private boolean viewAlive;

    /** 该分组是否由本页承载（配置页据此跳过它，并把它的键算进键渲染自检）。 */
    static boolean isSettingsGroup(@NonNull GroupMeta group) {
        return SETTINGS_GROUP_ID.equals(group.id);
    }

    /**
     * 分组标题去掉段标编号（「[4] 界面」→「界面」）。
     *
     * <p>编号是给 {@code profile.conf} 的段标对齐用的，定义里必须留着
     * （{@code check_params.py} 断言分组标题带「[N]」，且 profile.conf 段标由它派生）；
     * 但显示时它只是噪音，故剥掉。<b>本页卡头与重置栏按钮共用这一份实现</b>
     * （见 {@link ConfigResetBar}），显示口径只有一处。
     */
    static String stripSectionNumber(@NonNull String title) {
        return title.replaceFirst("^\\[\\d+\\]\\s*", "");
    }

    /**
     * 本页要渲染的键（按定义顺序，不含 role=master 的键——{@code group.keys} 本就不含）。
     * 空列表表示定义里没有这个分组（定义被改坏或换版本），此时页面给出空态而不是静默留白。
     */
    @NonNull
    static List<KeyMeta> webuiKeys(@NonNull ConfigStore store) {
        for (GroupMeta group : store.groups()) {
            if (!isSettingsGroup(group)) {
                continue;
            }
            List<KeyMeta> keys = new ArrayList<>();
            for (String key : group.keys) {
                KeyMeta meta = store.key(key);
                if (meta != null) {
                    keys.add(meta);
                }
            }
            return Collections.unmodifiableList(keys);
        }
        return Collections.emptyList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        store = ConfigStore.get(requireContext());
        io = Executors.newSingleThreadExecutor();
        main = new Handler(Looper.getMainLooper());
        queue = new ConfigWriteQueue(store, io, main, this::onWriteResult);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ScrollView scroll = new ScrollView(inflater.getContext());
        scroll.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scroll.setFillViewport(true);
        // 常显 + 可按住拖动：与配置页同一套（本页内容通常不满一屏，滚动条只在放不下时出现）
        scroll.setScrollbarFadingEnabled(false);
        ScrollbarDrag.attach(scroll);

        LinearLayout content = new LinearLayout(inflater.getContext());
        content.setOrientation(LinearLayout.VERTICAL);
        int padding = getResources().getDimensionPixelSize(R.dimen.page_padding);
        content.setPadding(padding, padding, padding, padding);
        scroll.addView(content);
        rootView = scroll;
        viewAlive = true;

        if (!store.definitionsLoaded()) {
            // 与配置页同口径：不给静默空白，直接把诊断串摆出来
            TextView error = new TextView(inflater.getContext());
            error.setText(store.describeState());
            error.setTextAppearance(inflater.getContext(),
                    R.style.TextAppearance_B6XTempCtrl_Mono);
            error.setTextIsSelectable(true);
            content.addView(error);
            return scroll;
        }

        // 重置栏在参数卡之前。它不放键行（只有按钮），故配置页的键渲染自检不受影响
        //（自检数的是 ConfigKeyRow 与设置页键，见 ConfigFormFragment）。
        content.addView(ConfigResetBar.create(inflater, content, this).view());

        buildForm(inflater, content);
        reloadAsync();
        return scroll;
    }

    // ==================== 构建表单（结构来自 ConfigStore） ====================

    private void buildForm(LayoutInflater inflater, LinearLayout content) {
        rows.clear();
        groups.clear();

        List<KeyMeta> keyMetas = webuiKeys(store);
        if (keyMetas.isEmpty()) {
            TextView empty = new TextView(inflater.getContext());
            empty.setText(R.string.config_settings_empty);
            empty.setTextAppearance(inflater.getContext(), R.style.TextAppearance_B6XTempCtrl_Caption);
            content.addView(empty);
            return;
        }
        // 先用定义默认值铺底：读取完成前不出现空控件（文件缺失时 C 端与界面都用默认值）
        for (KeyMeta meta : keyMetas) {
            diskValues.put(meta.key, meta.defaultValue);
        }
        for (GroupMeta group : store.groups()) {
            if (!isSettingsGroup(group)) {
                continue;
            }
            KeyMeta master = group.master == null ? null : store.key(group.master);
            ConfigGroupBinder binder = ConfigGroupBinder.create(inflater, content,
                    stripSectionNumber(group.title), master, keyMetas, this);
            content.addView(binder.card());
            groups.add(binder);
            rows.addAll(binder.rows());
            // 本页只有这一组：默认展开，否则进页面先看到一张折叠的卡
            binder.setExpanded(true);
        }
        for (ConfigKeyRow row : rows) {
            row.applyValue(diskValues.get(row.key()));
        }
        refreshAllBadges();
    }

    // ==================== 读盘 ====================

    private void reloadAsync() {
        if (!store.definitionsLoaded() || io.isShutdown()) {
            return;
        }
        io.execute(() -> {
            final Snapshot snapshot = store.read();
            main.post(() -> {
                if (viewAlive) {
                    applySnapshot(snapshot);
                }
            });
        });
    }

    private void applySnapshot(Snapshot snapshot) {
        diskValues.clear();
        diskValues.putAll(snapshot.values);
        for (ConfigKeyRow row : rows) {
            row.applyValue(snapshot.get(row.key()));
        }
        refreshAllBadges();
    }

    private void refreshAllBadges() {
        for (ConfigGroupBinder group : groups) {
            group.refreshBadges();
        }
    }

    // ==================== 写盘结果 ====================

    private void onWriteResult(WriteResult result, Map<String, Value> written) {
        if (!viewAlive) {
            return;
        }
        if (result.ok) {
            diskValues.putAll(written);
        }
        List<String> labels = new ArrayList<>();
        for (String key : written.keySet()) {
            KeyMeta meta = store.key(key);
            labels.add(meta == null ? key : meta.label);
        }
        String message = TextUtils.join("、", labels) + "：" + result.describe();
        for (ConfigKeyRow row : rows) {
            if (written.containsKey(row.key())) {
                row.setResultStatus(message, result.ok);
            }
        }
        if (!result.ok) {
            notifyUser(message, true);
        }
        refreshAllBadges();
    }

    // ========== 键行与重置栏共用的服务面（ConfigResetBar.Host 继承 ConfigKeyRow.Host） ==========

    @NonNull
    @Override
    public ConfigStore store() {
        return store;
    }

    @NonNull
    @Override
    public ConfigWriteQueue queue() {
        return queue;
    }

    @Nullable
    @Override
    public Value diskValue(String key) {
        return diskValues.get(key);
    }

    @Nullable
    @Override
    public Value effectiveValue(String key) {
        Value pending = queue.pendingValue(key);
        return pending != null ? pending : diskValues.get(key);
    }

    @Override
    public void onPendingChange() {
        refreshAllBadges();
    }

    @Override
    public void notifyUser(String message, boolean error) {
        if (!viewAlive || rootView == null) {
            return;
        }
        Snackbar.make(rootView, message, error ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
    }

    // ==================== ConfigResetBar.Host：按分组重置 ====================

    /**
     * 用户已确认重置某组：先冲刷待写队列，再按出厂值一次原子写盘。
     *
     * <p><b>为什么必须先冲刷</b>：待写队列里若还压着同一页的改动，稍后它自己的冲刷会把重置值
     * 覆盖回旧值——C 端 {@code st_mtime} 只有秒级精度，补写一次也未必触发重载（见
     * {@link ConfigWriteQueue}）。冲刷与重置都排在<b>本页同一个单线程 executor</b> 上，
     * 先冲刷后重置的顺序由它保证，不需要额外同步。
     *
     * <p>重置值走 {@link ConfigStore#setAll}：整组合成一次 rename；逐键 {@code set()} 会多次
     * 触碰 mtime，可能换来一轮"部分生效"的重载。
     */
    @Override
    public void onResetConfirmed(@NonNull String label, @NonNull Map<String, Value> factoryValues) {
        if (!viewAlive || io.isShutdown()) {
            return;
        }
        queue.flushNow();
        io.execute(() -> {
            final WriteResult result = store.setAll(factoryValues);
            main.post(() -> {
                if (viewAlive) {
                    applyReset(label, factoryValues, result);
                }
            });
        });
    }

    /**
     * 重置结果落地（主线程）：把本页那些属于该组的键重刷成出厂值，并给出反馈。
     *
     * <p>本页只承载 {@code webui} 组，重置别的组时一个键都匹配不上——这是对的：别的组的键
     * 不在本页显示，其显示是否陈旧由配置页自己重读时解决（它每次可见都重读）。
     *
     * <p>成功不必逐行标状态：控件里的值本身已经变了，同一句贴在每一行上是噪音；
     * 失败要留在行上（Snackbar 一闪而过）。
     */
    private void applyReset(@NonNull String label, @NonNull Map<String, Value> factoryValues,
                            @NonNull WriteResult result) {
        if (result.ok) {
            for (ConfigKeyRow row : rows) {
                Value value = factoryValues.get(row.key());
                if (value != null) {
                    diskValues.put(row.key(), value);
                    row.applyValue(value);
                }
            }
            refreshAllBadges();
        }
        final String message = result.ok
                ? (result.changed ? getString(R.string.config_reset_done, label)
                        : getString(R.string.config_reset_no_change, label))
                : getString(R.string.config_reset_failed, label, result.error);
        if (!result.ok) {
            for (ConfigKeyRow row : rows) {
                if (factoryValues.containsKey(row.key())) {
                    row.setResultStatus(message, false);
                }
            }
        }
        notifyUser(message, !result.ok);
    }

    // ==================== 生命周期：不丢改动 ====================

    @Override
    public void onPause() {
        super.onPause();
        queue.flushNow();
    }

    @Override
    public void onDestroyView() {
        viewAlive = false;
        queue.flushNow();
        queue.detach();
        rows.clear();
        groups.clear();
        rootView = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        queue.flushNow();
        io.shutdown();
        super.onDestroy();
    }
}
