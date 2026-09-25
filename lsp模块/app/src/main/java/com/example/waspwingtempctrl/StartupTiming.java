package com.example.waspwingtempctrl;

import android.os.SystemClock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * 启动耗时的<b>旁路记账</b>：进程级几张静态槽位，量出"启动那一刻各段各花了多少毫秒"，供诊断区展示
 * （真机排障用，不参与任何判断，也不影响任何逻辑）。
 *
 * <h3>口径</h3>
 * <ul>
 *   <li><b>原点</b> = {@link #begin()} 被调的那一刻（{@code SetupActivity.onCreate} 首行）。故所有数字都是
 *       "相对 onCreate 首行"的毫秒数，同一进程内可比，跨启动也可比；但<b>不能</b>与 logcat 的
 *       {@code Displayed} 之类直接相减（那些从进程 fork 起算）。</li>
 *   <li><b>每槽只记第一次</b>（首次写入胜出，见 {@link #span}/{@link #mark}）：报文说的就是"本次进程冷启动
 *       那一次"。故进程内第二次进 Activity（暖启动）不会把这些数字刷成别的含义。</li>
 *   <li><b>计时贴在"干活的地方"</b>：并行之后同一份活可能由这根线程干、也可能由那根干（谁先到谁干，
 *       后到的命中缓存），若在"调用的地方"计时，先干的那条会把耗时算走、后到的只报 0——数字随调度翻脸。
 *       故各调用方把计时点放在真正读盘/解析的那几行上。</li>
 * </ul>
 *
 * <h3>为什么放在主包</h3>
 * 记账点既在 {@link ConfigStore}（核心）也在 {@code ui} 各页里：放主包则两边一致地
 * {@code import com.example.waspwingtempctrl.StartupTiming}，方向是 {@code ui → 主包}（既有约定）；
 * 若放 {@code ui} 包，就会多出一条"核心反向依赖界面包"的边。
 *
 * <h3>开销</h3>
 * 每个记账点只有一到两次 {@code CAS}（记一段是"起点 + 耗时"两次；失败即放弃，<b>不重试、不自旋、
 * 不阻塞</b>）或一次 volatile 读 + 一次减法，<b>无 IO、无锁、不建线程、不轮询、不分配对象</b>
 * （只有 {@link #report()} 拼文本时分配一个 StringBuilder）。每槽在进程内只可能被写一次，故竞争窗口
 * 只存在于启动那一瞬。所有方法都<b>无抛点</b>（无 IO、无解析、无数组增长、无除零），故它在链上调用
 * 不可能改变原有逻辑。
 */
public final class StartupTiming {

    // ==================== 槽位（顺序即展示顺序） ====================

    /** 落页判定（预热线程，含资产哈希与定义加载）。 */
    public static final int LANDING = 0;
    /** 配置定义加载（读 assets/params.json + 建键表，谁先构造 ConfigStore 谁记）。 */
    public static final int DEF_LOAD = 1;
    /** 配置首份快照读取（profile.conf 真读盘那一次）。 */
    public static final int SNAP_LOAD = 2;
    /** 曲线口径首次加载（ChartLoader 预热或曲线页自读，先真加载者记）。 */
    public static final int CHART_CFG = 3;
    /** 曲线数据首次读取 + 解析（真读盘那一次）。 */
    public static final int CHART_DATA = 4;
    /** 主线程建表与首屏对齐（建卡建行 → 值上屏 → 诊断对齐 → 参数区露出）。 */
    public static final int FORM_BUILD = 5;
    /** 时间点：{@code onCreate} 返回（壳与页容器建完）。 */
    public static final int MARK_ONCREATE_END = 6;
    /** 时间点：落页判定算完、放行主线程（{@code countDown}）那一刻。 */
    public static final int MARK_LANDING_WAKE = 7;
    /** 时间点：页面区第一次绘制之前。 */
    public static final int MARK_FIRST_DRAW = 8;
    /** 时间点：骨架占位层真被撤下那一刻（本次没挂过层就不记）。 */
    public static final int MARK_SKELETON_OFF = 9;

    private static final int SLOTS = 10;
    private static final long UNSET = -1L;

    /** 每槽两个 long：{@code [i*2]} = 该段起点的偏移（"时间点"槽只用它）、{@code [i*2+1]} = 该段耗时。 */
    private static final AtomicLongArray VALUES = new AtomicLongArray(SLOTS * 2);

    /** 计时原点（{@code uptimeMillis}）；{@code 0} = 还没定。 */
    private static final AtomicLong ORIGIN = new AtomicLong();

    static {
        for (int i = 0; i < SLOTS * 2; i++) {
            VALUES.set(i, UNSET);
        }
    }

    private StartupTiming() {
    }

    // ==================== 记账 ====================

    /** 定原点（幂等）：{@code SetupActivity.onCreate} 首行调，越早越准。 */
    public static void begin() {
        origin();
    }

    /** 当前时刻相对原点的毫秒数（尚无原点则就地定一个，故任何入口先到都不会产出垃圾数）。 */
    public static long now() {
        return SystemClock.uptimeMillis() - origin();
    }

    /**
     * 记一段：{@code startMs} 由调用方在开工前用 {@link #now()} 取好，这里再取一次现在作为终点。
     *
     * <p><b>首次写入胜出</b>：该槽已被记过就整个放弃（连起点带耗时一起），不覆盖也不重试——
     * 报文只认"本次进程冷启动那一次"。
     */
    public static void span(int slot, long startMs) {
        int base = slot * 2;
        if (VALUES.compareAndSet(base, UNSET, startMs)) {
            VALUES.compareAndSet(base + 1, UNSET, now() - startMs);
        }
    }

    /** 记一个时间点（首次写入胜出）。 */
    public static void mark(int slot) {
        VALUES.compareAndSet(slot * 2, UNSET, now());
    }

    // ==================== 展示 ====================

    /**
     * 拼展示文本（多行，不带前后空行；调用方自己接在既有文本之后）。
     *
     * <p>一个槽都没记过就返回空串（调用方据此不追加）。整体套 try/catch：本方法只用于展示，
     * 任何意外都不该冒泡出去。
     */
    public static String report() {
        try {
            if (!anyRecorded()) {
                return "";
            }
            StringBuilder sb = new StringBuilder(360);
            sb.append("启动耗时（相对 onCreate 首行，ms）");
            sb.append("\n起 = 该段开始时距首行的毫秒数；后台各段并行，耗时不可相加");
            appendSpan(sb, "落页判定", LANDING);
            appendSpan(sb, "配置定义", DEF_LOAD);
            appendSpan(sb, "配置首份快照", SNAP_LOAD);
            appendSpan(sb, "曲线口径", CHART_CFG);
            appendSpan(sb, "曲线数据首读", CHART_DATA);
            appendSpan(sb, "主线程建表", FORM_BUILD);
            sb.append("\n时间点 · onCreate 结束 ").append(moment(MARK_ONCREATE_END))
                    .append(" · 判定放行 ").append(moment(MARK_LANDING_WAKE))
                    .append(" · 首帧 ").append(moment(MARK_FIRST_DRAW))
                    .append(" · 撤占位层 ").append(moment(MARK_SKELETON_OFF));
            return sb.toString();
        } catch (Throwable t) {
            return "";
        }
    }

    private static void appendSpan(StringBuilder sb, String label, int slot) {
        sb.append('\n').append(label)
                .append(" · 起 ").append(value(VALUES.get(slot * 2)))
                .append(" · 耗时 ").append(value(VALUES.get(slot * 2 + 1)));
    }

    private static String moment(int slot) {
        return value(VALUES.get(slot * 2));
    }

    private static String value(long v) {
        return v < 0 ? "—" : Long.toString(v);
    }

    private static boolean anyRecorded() {
        for (int i = 0; i < SLOTS * 2; i++) {
            if (VALUES.get(i) >= 0) {
                return true;
            }
        }
        return false;
    }

    /** 取原点（没有就地定一个）：{@code compareAndSet} 只可能成功一次，故"最先到的那次"即原点。 */
    private static long origin() {
        long o = ORIGIN.get();
        if (o != 0) {
            return o;
        }
        ORIGIN.compareAndSet(0, SystemClock.uptimeMillis());
        return ORIGIN.get();
    }
}
