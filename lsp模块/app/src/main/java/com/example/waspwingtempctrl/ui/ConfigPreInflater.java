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

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 控件预制造：配置定义一到位，就用一根后台线程把建表要 inflate 的控件先造出来放着，主线程建表时按布局
 * 取用（见 {@link ViewSource}）——把"134 次 inflate、约 580 个 View 构造"里最贵的那一段从主线程挪到
 * 后台空档里，建表耗时、以及"参数区露面"的时间随之提前。与 {@code ww-preload} / {@code ww-chart-warmup}
 * 同族：同是启动期一次的后台线程，做完即闲。
 *
 * <h3>它凭什么可以不在主线程造（论证）</h3>
 * <ul>
 *   <li><b>不 attach</b>：造出来的件没有任何父容器——{@link #put} 走的是
 *       {@code inflate(layout, 空壳父容器, false)}，第三个参数为 false 时 inflate 只借父容器生成
 *       {@code LayoutParams}，<b>不会</b>把件加进去。故这些件不在任何视图树上。</li>
 *   <li><b>不 measure、不 layout、不绘制</b>：本类只调 {@code inflate}，不碰任何测量/排布/绘制入口。</li>
 *   <li><b>不读主线程的视图</b>：造的全是全新控件，不访问页面上任何已 attach 的视图或它的测量结果。</li>
 *   <li><b>不依赖机型时序</b>：主线程取件时件没造完就<b>现场自己造</b>（{@link ViewSource#inflate} 的
 *       兜底路），生产与消费之间没有任何等待、没有握手、没有超时判断。故"后台被限流"只会把收益削成
 *       零，不会退回比改前更差，也不会拖慢任何一步。主线程<b>绝不</b>等预制造——它只问一句"造好了没"。</li>
 *   <li><b>本类自己的共享可变状态只有一处</b>：交接面是 {@link #pool}，放/取各是一次队列操作；队列自身的
 *       同步即完成了"全新构造的控件"向主线程的安全发布（这是把它做成队列而不是普通 Map 的原因）。
 *       注意这不等于"与主线程什么都没有共享"——inflater 那一侧另有一层，见下。</li>
 * </ul>
 *
 * <h3>与官方 AsyncLayoutInflater 的关系（<b>不要</b>拿"官方也这么干"当依据）</h3>
 * 官方那条路<b>不覆盖</b>本类做的事，两处关键差异：
 * <ul>
 *   <li>它的 {@code BasicInflater} 源码注释写明 <i>"This inflater does not support setting a
 *       LayoutInflater.Factory nor Factory2"</i>，而且它是 {@code new BasicInflater(context)}
 *       （{@code super(context)}，<b>没有工厂</b>）——故它<b>不会</b>与主线程并发进入
 *       {@code androidx.appcompat.app.AppCompatViewInflater}。AndroidX 直到
 *       {@code asynclayoutinflater 1.1.0}（2025-04）才补上 {@code AsyncAppCompatFactory} 让异步
 *       inflate 能造出 AppCompat/Material 控件。</li>
 *   <li>它的 {@code InflateThread} 是普通 {@code Thread} + {@code LinkedBlockingQueue}，
 *       <b>没有 Looper</b>（不是"带 Looper 的线程"）。</li>
 * </ul>
 *
 * <h3>本类比官方那条路多出来的一层共享（以及它为什么当前不构成竞争）</h3>
 * inflater 由 {@link LayoutInflater#cloneInContext} 克隆而来，而 cloneInContext 会<b>按引用复制</b>
 * {@code mFactory2} —— 于是后台线程与主线程<b>共用同一个 AppCompat 视图工厂</b>
 * （{@code AppCompatDelegateImpl} / {@code AppCompatViewInflater}）。该工厂里有<b>无同步</b>的共享
 * 可变状态：{@code AppCompatViewInflater.mConstructorArgs}（在 {@code createViewFromTag} 里逐次改写）
 * 与静态的 {@code sConstructorMap}。
 *
 * <p><b>但这条路径对本模块当前不可达</b>：{@code createViewFromTag} 只在"标签名不在 AppCompat 那 14 个
 * 已知名内"<b>且</b>该标签带 {@code android:theme}/{@code app:theme}（{@code themifyContext} 因此换了
 * 一个 Context）时才被调用。本模块 {@code res/layout} 下 17 个 layout <b>没有任何一处</b>带主题属性
 * （只有 {@code xmlns:app} 命名空间声明），故那条分支不会被走到；落回框架
 * {@code LayoutInflater.onCreateView} 的 {@code LinearLayout} 用的是<b>每个 inflater 各自的</b>
 * {@code mConstructorArgs}，且整个 inflate 包在它自己的 {@code synchronized} 里。
 *
 * <p><b>⚠️ 警告（加主题属性前先读这句）</b>：上面那条"安全"是<b>布局属性决定的，不是 API 保证的</b>。
 * 将来在本类预制造的任何一个 layout（{@code item_config_*}）里加一行 {@code android:theme} 或
 * {@code app:theme}，就会点亮那处无同步的共享写（两根线程同时改 {@code mConstructorArgs}）。
 * 真到那天，要么别加，要么先把预制造挪到首帧之后（与主线程的 inflate 错开）。
 *
 * <p>其余共享面已逐个核过：{@code AppCompatDelegateImpl.createView} 不写任何字段；
 * {@code ResourceManagerInternal} / {@code AppCompatDrawableManager} 的可变缓存全部
 * {@code synchronized}。{@code Resources.Theme} 的线程安全官方<b>没有</b>文档保证，本类依赖的是
 * native {@code AssetManager.applyStyle} 取 {@code ScopedLock} 带来的串行化——属"旁证支持、无文档
 * 承诺"，真机上只能靠长跑观察（见方案文件的未验证项）。
 *
 * <p>本类不引入 {@code asynclayoutinflater} 那条依赖（见 build.gradle.kts 的依赖口径）：本类要处理的
 * parent/attach 语义与它一样，收益不抵依赖；且本类允许"没造完就不造"，而它没有这个档位。
 *
 * <h3>备料口径：宁多不少，错也不错在正确性上</h3>
 * 按定义<b>全量</b>备料，不模仿页面的取舍规则（哪一页渲染哪几个组）：多备的件没人取、只是白造
 * （后台线程的空档，代价近零），少备的件由主线程现场 inflate。这条口径换来的是一个关键性质——
 * {@link #produceKey} 里那份"每个键要哪几种控件"的清单<b>与消费侧对不上时不会造出错视图，只会少省一点</b>。
 * 故这份清单不必与 {@code ConfigFormController} 的分组/兜底逻辑同步（也不必复制它）。
 *
 * <p>唯一的"必须对得上"是<b>父容器的类型</b>：{@link #produceAll} 里那两个空壳父容器要与真正接收这些件的
 * 容器同类型（卡片进内容容器、键行与字段进流式行容器），否则生成的 {@code LayoutParams} 类型不对。
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
     * 池子已关门（{@link #clearLeftovers()} 置位，主线程写、后台线程读）。
     *
     * <p>它保证的是"release 之后池子必空"：本方法与后台的 {@link #put} 之间没有先后约束，
     * 清空之后后台可能又放进几件，而那几件就再也没人清了。
     */
    private volatile boolean closed;

    private ConfigPreInflater(@NonNull Context owner) {
        this.owner = owner;
    }

    /**
     * 提交一次预制造（进程级只跑一次）。
     *
     * <p>提交点在 {@code SetupActivity#preInflate}（{@code super.onCreate()} 之后）：先用
     * {@code ownerContext} 那一份 inflater {@code cloneInContext(ownerContext)} 出一份给后台线程专用，
     * 且<b>只许那一根线程使用</b>——LayoutInflater 不能跨线程共用。
     * <b>先判闸门、再克隆</b>：第二次起的调用注定被丢弃，不该白克隆一个 inflater。
     *
     * @param app          应用上下文：只用于取配置定义单例（那一步可能要等预热线程把它构造完）
     * @param ownerContext 这批件所属的上下文（就是那个 Activity）：既用于克隆 inflater，也是
     *                     {@link #get(Context)} 的身份凭据。它必须来自一个<b>已装好视图工厂</b>的
     *                     inflater（否则 {@code <TextView>} 造出来的是基类而不是
     *                     {@code MaterialTextView}，预制造件与现场造的不是同一种控件）
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
     * （调用方据此走"全部现场造"）。
     *
     * <p><b>为什么必须比身份</b>：{@link #STARTED} 与 {@link #instance} 都是进程级且永不重置，而这些件
     * 是握着 {@code ownerContext} 造出来的。页面重建（Activity 重建 / 配置变更）后若照旧取用，新视图树
     * 就会挂上一批<b>属于上一个 Activity</b> 的控件：既拿到过期的 Context 与主题，又把那个已经销毁的
     * Activity 钉在新视图树上。故身份对不上即视为"本页没有预制造件"（代价只是这一轮全部现场造，
     * 与不做预制造时逐字一致）。
     *
     * <p>返回 {@code null} 的三个成因各记一个时间点（只用于诊断区展示，见 {@link StartupTiming}），
     * 三者互斥且不影响这里的判断结果。
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
     * 丢掉没用上的剩余件并<b>关门</b>（建表收尾与页面销毁各调一次，见 {@link ViewSource#release()}）。
     *
     * <p>预制造只服务启动那一轮：留下的件不会再有人取，而每个件都握着它的 Context，
     * 留着就是把那个 Activity（连同它的窗口）钉在静态引用上。
     *
     * <p>关门（{@link #closed}）与真正的清空必须一起做：本方法与后台的 {@link #produce} 之间没有先后
     * 约束，只清不关的话，清空之后后台还会往里放。
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

    /** 按定义全量备料：每张分组卡、每个键的键内控件各一份。 */
    private void produceAll(@NonNull LayoutInflater inflater, @NonNull ConfigStore store) {
        // 空壳父容器：只为生成 LayoutParams（见类注释的〈不 attach〉）。类型必须与真正接收这些件的容器
        // 同类型——卡进页面的内容容器（LinearLayout），键行与字段进流式行容器（WrapRowLayout）。
        ViewGroup cardParent = new LinearLayout(inflater.getContext());
        ViewGroup rowParent = new WrapRowLayout(inflater.getContext());
        for (int i = 0; i < store.groups().size(); i++) {
            put(inflater, R.layout.item_config_group, cardParent);
        }
        // 键按定义全量（含 role=master 的那些：它们本该渲染成组头开关而不是行，多备的件没人取）
        for (KeyMeta meta : store.keys()) {
            produceKey(inflater, rowParent, meta);
        }
    }

    /**
     * 备一个键的键内控件。
     *
     * <p><b>这一份清单与 {@code ConfigKeyRow} 五个 {@code Renderer#build} 的 inflate 一一对应</b>
     * （定义里只有 switch / enum / path / multi / int 五种 type）：加一种 type 时这里要跟着加一条。
     * 对不上不影响正确性（见类注释的〈备料口径〉），只是省下的那一段少一点。
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
            // 与 clearLeftovers 竞争：它可能在上面的判断之后、add 之前清空并关门——那样这一件就留在了
            // 空池子里（再没人清）。补一刀，让"release 之后池子必空"这条不变量在任何交错下都成立
            pool.clear();
        }
    }
}
