package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.GroupMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 控件预制造：配置定义一到位，就用一根后台线程把建表要 inflate 的控件先造出来放着，主线程建表时按布局
 * 取用（见 {@link ViewSource}）——把"134 次 inflate、约 580 个 View 构造"里最贵的那一段从主线程挪到
 * 后台空档里。与 {@code ww-preload} / {@code ww-chart-warmup} 同族。主线程<b>绝不</b>等预制造：取不到就
 * 现场造，故它只削收益、不添风险。
 *
 * <p><b>⚠️ 加主题属性前先读：</b>本类与主线程共用同一个 AppCompat 视图工厂（{@code cloneInContext} 按引用
 * 复制 {@code mFactory2}），该工厂内有<b>无同步</b>的共享可变状态。当前安全是<b>布局属性决定的</b>：只在
 * {@code item_config_*} 里加一行 {@code android:theme}/{@code app:theme} 就会点亮那处竞争。真到那天要么
 * 别加，要么先把预制造挪到首帧之后。
 *
 * <p>为何不必 attach / measure、与 {@code AsyncLayoutInflater} 的差异、共享层的逐个核查、备料口径
 * （只备配置页会取的件、合计 126）等设计论证，见 app 逻辑说明.md §6.2。
 */
public final class ConfigPreInflater {

    /** 预制造线程：进程级一个。 */
    private static final ExecutorService WORKER = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-preinflate");
        thread.setDaemon(true);
        return thread;
    });

    /** 提交闸门：进程级只跑一次（判定、曲线预热之后的第三件事，见 {@code SetupActivity}）。 */
    private static final AtomicBoolean STARTED = new AtomicBoolean();

    /** 进程级唯一实例；{@code null} = 没启动过（页面据此走"全部现场造"）。 */
    @Nullable
    private static volatile ConfigPreInflater instance;

    /** 造好的件：布局 id → 件队列（后台线程放、主线程取）。 */
    private final Map<Integer, Queue<View>> pool = new ConcurrentHashMap<>();

    /** 这批件是用谁的上下文造的（按<b>引用</b>比对本页的上下文，见 {@link #get(Context)}）。 */
    private final Context owner;

    /**
     * 池子已关门（{@link #clearLeftovers()} 置位，主线程写、后台线程读）：保证"release 之后池子必空"。
     * 见 app 逻辑说明.md §6.2。
     */
    private volatile boolean closed;

    private ConfigPreInflater(@NonNull Context owner) {
        this.owner = owner;
    }

    /**
     * 提交一次预制造（进程级只跑一次）。<b>先判闸门、再克隆</b> inflater（第二次起的调用注定被丢弃）；
     * LayoutInflater 不能跨线程共用，克隆出的那份<b>只许后台那一根线程使用</b>。见 app 逻辑说明.md §6.2。
     *
     * @param app          应用上下文：只用于取配置定义单例
     * @param ownerContext 这批件所属的上下文（就是那个 Activity）：既是克隆 inflater 的来源，也是
     *                     {@link #get(Context)} 的身份凭据。必须来自一个<b>已装好视图工厂</b>的
     *                     inflater（否则 {@code <TextView>} 造出来的是基类而不是 {@code MaterialTextView}）
     */
    public static void start(@NonNull Context app, @NonNull Context ownerContext) {
        if (!STARTED.compareAndSet(false, true)) {
            StartupTiming.mark(StartupTiming.MARK_PRE_ALREADY_STARTED);   // 记账（旁路）：本轮不是进程内第一次打开
            return;
        }
        ConfigPreInflater pre = new ConfigPreInflater(ownerContext);
        instance = pre;   // 先发布再提交：页面可能在预制造还没跑完时就来取件（取不到即现场造）
        LayoutInflater preInflater = LayoutInflater.from(ownerContext).cloneInContext(ownerContext);
        WORKER.execute(() -> pre.produce(app, preInflater));
    }

    /**
     * 进程级那一份；没启动过、已经丢掉剩余件、或<b>归属的上下文不是本页这一个</b>时为 {@code null}
     * （调用方据此走"全部现场造"）。<b>为什么必须比身份</b>：这些件握着 {@code ownerContext} 造出来，
     * 页面重建后照旧取用会把上一个 Activity 的控件挂上新视图树。见 app 逻辑说明.md §6.2。
     */
    @Nullable
    static ConfigPreInflater get(@NonNull Context ownerContext) {
        ConfigPreInflater pre = instance;
        if (pre == null) {
            StartupTiming.mark(StartupTiming.MARK_PRE_NO_INSTANCE);   // 记账（旁路）：压根没提交过
            return null;
        }
        if (pre.closed) {
            StartupTiming.mark(StartupTiming.MARK_PRE_CLOSED);   // 记账（旁路）：剩余件已被丢光
            return null;
        }
        if (pre.owner != ownerContext) {
            StartupTiming.mark(StartupTiming.MARK_PRE_OWNER_MISMATCH);   // 记账（旁路）：件属于上一个页面
            return null;
        }
        return pre;
    }

    /** 取一件预制造好的件（主线程调）；没有就返回 {@code null}，调用方现场 inflate。 */
    @Nullable
    View take(int layoutId) {
        Queue<View> queue = pool.get(layoutId);
        return queue == null ? null : queue.poll();
    }

    /**
     * 丢掉没用上的剩余件并<b>关门</b>（建表收尾与页面销毁各调一次，见 {@link ViewSource#release()}）：
     * 留下的件握着它的 Context，留着就是把那个 Activity 钉在静态引用上。关门与清空必须一起做，否则
     * 清空之后后台还会往里放。见 app 逻辑说明.md §6.2。
     */
    void clearLeftovers() {
        closed = true;
        pool.clear();
    }

    /** 备料（后台线程跑一遍）。任何意外都直接放弃：池子里有几件算几件，其余由主线程现场造。 */
    private void produce(@NonNull Context app, @NonNull LayoutInflater inflater) {
        try {
            ConfigStore store = ConfigStore.get(app);   // 可能要等预热线程把这份单例构造完（见 start 的说明）
            if (!store.definitionsLoaded()) {
                StartupTiming.mark(StartupTiming.MARK_PRE_NOT_READY);   // 记账（旁路）：定义还没就绪
                return;
            }
            produceAll(inflater, store);
        } catch (Throwable ignored) {
            // 预制造只是优化：失败即"什么都没造"，主线程照旧自己 inflate
            StartupTiming.mark(StartupTiming.MARK_PRE_FAIL);   // 记账（旁路）：静默吞掉的那一次
        }
    }

    /** 按定义备料：本页会取的每张分组卡、每个键（不含总开关键）的键内控件各一份。 */
    private void produceAll(@NonNull LayoutInflater inflater, @NonNull ConfigStore store) {
        // 空壳父容器：只为生成 LayoutParams（见类注释的〈不 attach〉）。类型必须与真正接收这些件的容器
        // 同类型——卡进页面的内容容器（LinearLayout），键行与字段进流式行容器（WrapRowLayout）。
        ViewGroup cardParent = new LinearLayout(inflater.getContext());
        ViewGroup rowParent = new WrapRowLayout(inflater.getContext());
        // 只备本页会取的件（设置页不取池子，见类注释的〈备料口径〉）：
        //   ① 只在设置页渲染的那一组——它的卡与它那些键的件都不备；
        //   ② 总开关键——它只以卡头开关的形态出现（在 item_config_group 里），不出行、也没有键内控件。
        final Set<String> masterKeys = new LinkedHashSet<>();
        final Set<String> settingsOnlyKeys = new LinkedHashSet<>();
        for (GroupMeta group : store.groups()) {
            if (group.master != null) {
                masterKeys.add(group.master);
            }
            if (UiSettingsFragment.isSettingsGroup(group)) {
                settingsOnlyKeys.addAll(group.keys);
                continue;
            }
            put(inflater, R.layout.item_config_group, cardParent);
        }
        for (KeyMeta meta : store.keys()) {
            if (masterKeys.contains(meta.key) || settingsOnlyKeys.contains(meta.key)) {
                continue;
            }
            produceKey(inflater, rowParent, meta);
        }
    }

    /**
     * 备一个键的键内控件。
     *
     * <p><b>清单与 {@code ConfigKeyRow} 五个 {@code Renderer#build} 的 inflate 一一对应</b>
     * （定义里只有 switch / enum / path / multi / int 五种 type）：加一种 type 时这里要跟着加一条。
     */
    private void produceKey(@NonNull LayoutInflater inflater, @NonNull ViewGroup rowParent,
                            @NonNull KeyMeta meta) {
        put(inflater, R.layout.item_config_row, rowParent);
        if (meta.isSwitch()) {
            put(inflater, R.layout.item_config_key_switch, rowParent);
            return;
        }
        if (meta.isEnum()) {
            // 分段开关的按钮要挂在它自己那个组里，故组本身要留着当父容器（与消费侧同构）
            View enumGroup = inflater.inflate(R.layout.item_config_enum_group, rowParent, false);
            put(enumGroup, R.layout.item_config_enum_group);
            for (int i = 0; i < meta.options.size(); i++) {
                put(inflater, R.layout.item_chart_window_button, (ViewGroup) enumGroup);
            }
            return;
        }
        if (meta.isMulti()) {
            for (int i = 0; i < meta.fieldCount(); i++) {
                put(inflater, meta.fields.get(i).bool
                        ? R.layout.item_config_field_switch : R.layout.item_config_field, rowParent);
            }
            return;
        }
        put(inflater, R.layout.item_config_field, rowParent);   // int 与 path 共用这一份字段布局
    }

    /** 造一件放进池子。 */
    private void put(@NonNull LayoutInflater inflater, int layoutId, @NonNull ViewGroup parent) {
        put(inflater.inflate(layoutId, parent, false), layoutId);
    }

    /** 把一件已造好的件放进池子（enum 组要留着自己当父容器，故与"现场造一件"分成两个入口）。 */
    private void put(@NonNull View view, int layoutId) {
        if (closed) {
            return;   // 已经 release 过了：放进去也没人取
        }
        pool.computeIfAbsent(layoutId, id -> new ConcurrentLinkedQueue<>()).add(view);
        if (closed) {
            // 与 clearLeftovers 竞争：补一刀，让"release 之后池子必空"在任何交错下都成立（见 app 逻辑说明.md §6.2）
            pool.clear();
        }
    }
}
