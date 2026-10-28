package com.example.waspwingtempctrl;

import android.os.SystemClock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * 启动耗时的<b>旁路记账</b>：进程级几张静态槽位，量出"启动那一刻各段各花了多少毫秒"，供诊断区展示
 * （真机排障用，不参与任何判断，也不影响任何逻辑）。
 *
 * <p>口径（原点 / 每槽首写胜出 / 计时贴干活处）、放主包的理由、开销论证与各槽位判读，
 * 见 {@code app/逻辑说明.md} §5.3。
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
    /**
     * 建表<b>首屏段</b>：建各分组的卡头 + 摆正组头开关与卡头徽标 + 参数区露出（默认折叠的页面在这一段
     * 末尾就置「就绪」——建表两段的里程碑之一）。
     */
    public static final int FORM_BUILD_HEAD = 5;
    /** 建表<b>可见后段</b>：建各行与全部字段 + 值上屏 + 自检 + 诊断（与首屏段的拆并口径见 {@code app/逻辑说明.md} §5.3）。 */
    public static final int FORM_BUILD_ROWS = 6;
    // ---- 建表内部的 8 个累计槽（见 {@link #accBegin}/{@link #accEnd}）：只在建表的主线程上写 ----
    /** 累计：控件制造（inflate + 构造 + LayoutParams 样式解析）。 */
    public static final int FORM_SUB_INFLATE = 7;
    /** 累计：说明画笔与外观取值（{@code new Paint} + {@code obtainStyledAttributes}）。 */
    public static final int FORM_SUB_PAINT = 8;
    /** 累计：文本实测宽（{@code measureText}）。 */
    public static final int FORM_SUB_MEASURE = 9;
    /** 累计：值回填（{@code setText}/{@code setChecked}/写宽）。 */
    public static final int FORM_SUB_FILL = 10;
    /** 累计：挂载（{@code addView}/{@code addToTail}）。 */
    public static final int FORM_SUB_ATTACH = 11;
    /** 累计：徽标（组内压暗 + 卡头「未生效」）。 */
    public static final int FORM_SUB_BADGE = 12;
    /** 累计：键渲染自检（拼那一行自检文本并上屏）。 */
    public static final int FORM_SUB_SELFCHECK = 13;
    /**
     * 累计：提交诊断（把上屏请求交给诊断区；重活在它自己的后台线程上）。
     *
     * <p>诊断区收起时这一项≈0：收起态下只登记"欠一次刷新"，不上屏（见 {@code ConfigDiagnostics}）。
     */
    public static final int FORM_SUB_DIAG_SUBMIT = 14;
    /** 累计槽个数（{@link #FORM_SUB_INFLATE} 起连续 {@code SUB_COUNT} 个）。 */
    private static final int SUB_COUNT = 8;

    // ---- 时间点 ----
    /** 时间点：{@code onCreate} 返回（壳与页容器建完）。 */
    public static final int MARK_ONCREATE_END = 15;
    /** 时间点：落页判定算完、放行主线程（{@code countDown}）那一刻。 */
    public static final int MARK_LANDING_WAKE = 16;
    /** 时间点：页面区第一次绘制之前。 */
    public static final int MARK_FIRST_DRAW = 17;
    /** 时间点：主线程进 {@code awaitLanding} 那一刻（与"判定放行"相减即 onCreate 里白等的那段）。 */
    public static final int MARK_LANDING_AWAIT = 18;
    /** 时间点：第一页的视图建好。 */
    public static final int MARK_PAGE_VIEW_1 = 19;
    /** 时间点：第三页（最后一页）的视图建好。 */
    public static final int MARK_PAGE_VIEW_ALL = 20;
    /** 时间点：首份快照到位（{@code onSnapshotReady} 进主线程）。 */
    public static final int MARK_FORM_DATA = 21;
    /** 时间点：首轮 {@code onPageSelected}。 */
    public static final int MARK_PAGE_SELECTED = 22;
    /** 时间点：参数区<b>露出之后</b>的第一次 pre-draw（与建表两段接缝相减的读法见 {@code app/逻辑说明.md} §5.3）。 */
    public static final int MARK_AFTER_BUILD_FRAME = 23;
    /** 时间点：曲线首次上数据完成。 */
    public static final int MARK_CHART_DATA = 24;
    /** 时间点：诊断正文上屏（收起态下不上屏，故通常为"—"；展开那一刻才有值）。 */
    public static final int MARK_DIAG_APPLY = 25;
    // ---- 预制造（B）的埋点：2 个累计计数 + 6 个成因 ----
    // 全部只记账，不改变任何既有分支；判读口径见 app/逻辑说明.md §5.3。

    /** 累计计数：取件命中（{@code ViewSource} 从池子里拿到了件）。 */
    public static final int PRE_HIT = 26;
    /** 累计计数：现场 inflate 的次数（没走预制造件那一路，含本页压根没启用预制造时）。 */
    public static final int PRE_MISS = 27;
    /** 时间点：后台备料抛了异常（{@code ConfigPreInflater.produce} 那个静默 catch）。 */
    public static final int MARK_PRE_FAIL = 28;
    /** 时间点：后台备料早退（配置定义尚未就绪）。 */
    public static final int MARK_PRE_NOT_READY = 29;
    /** 时间点：取预制造器时进程级实例还是 {@code null}（压根没提交过预制造）。 */
    public static final int MARK_PRE_NO_INSTANCE = 30;
    /** 时间点：预制造器已关门（剩余件被丢光，{@code ViewSource.release()} 之后）。 */
    public static final int MARK_PRE_CLOSED = 31;
    /** 时间点：预制造器归属的上下文不是本页那一个（件属于上一个 Activity，跨页复用）。 */
    public static final int MARK_PRE_OWNER_MISMATCH = 32;
    /** 时间点：预制造闸门已置位（本轮不是进程内第一次打开，备料不会重跑）。 */
    public static final int MARK_PRE_ALREADY_STARTED = 33;
    // ---- 建表首读那趟后台任务的两端（只服务"数据到位为什么晚"这一个问题，见 app/逻辑说明.md §5.3） ----

    /** 时间点：快照读取开工（快路与降级路同记，只包住读文件本身）。 */
    public static final int MARK_CFG_IO_BEGIN = 34;
    /** 时间点：快照读取算完、即将回主线程那一刻。 */
    public static final int MARK_CFG_IO_DONE = 35;
    // ---- 未命中构成：按布局 id 各一个累计计数（把"缺的是哪几种件"一次定死，见 app/逻辑说明.md §5.3） ----

    /** 未命中计数：分组卡。 */
    public static final int MISS_GROUP = 36;
    /** 未命中计数：键行。 */
    public static final int MISS_ROW = 37;
    /** 未命中计数：开关行的开关。 */
    public static final int MISS_KEY_SWITCH = 38;
    /** 未命中计数：枚举组。 */
    public static final int MISS_ENUM_GROUP = 39;
    /** 未命中计数：枚举按钮。 */
    public static final int MISS_ENUM_BUTTON = 40;
    /** 未命中计数：字段开关。 */
    public static final int MISS_FIELD_SWITCH = 41;
    /** 未命中计数：字段。 */
    public static final int MISS_FIELD = 42;
    // ---- 备料"结构性缺件 vs 没赶上"的判据（见 app/逻辑说明.md §5.3）：两个数字快照 ----

    /**
     * 数字快照：段二<b>开跑那一刻</b>池子里已经取走了多少件（即 {@link #PRE_HIT} 的当前值）。
     *
     * <p>用法：`126 − 本槽` = 段二开跑前就缺的件数（结构性）；`未命中 − 上面这个数` = 段二期间
     * 备料还没赶上的件数（竞态）。两个数加起来即"没赶上"那一类的全部。
     */
    public static final int POOL_AT_ROWS_BEGIN = 43;
    /** 数字快照：段二<b>收尾那一刻</b>的同一读数（正常应等于"命中"总数）。 */
    public static final int POOL_AT_ROWS_END = 44;

    private static final int SLOTS = 45;
    private static final long UNSET = -1L;

    /** 每槽两个 long：{@code [i*2]} = 该段起点的偏移（"时间点"槽只用它）、{@code [i*2+1]} = 该段耗时。 */
    private static final AtomicLongArray VALUES = new AtomicLongArray(SLOTS * 2);

    /** 计时原点（{@code uptimeMillis}）；{@code 0} = 还没定。 */
    private static final AtomicLong ORIGIN = new AtomicLong();

    /**
     * 累计槽的进行态：{@code [i]} = 首次计入时刻（相对原点；{@code -1} = 没计入过）与各次计入的毫秒合计。
     * 普通 {@code long[]}（只建表主线程写、无需同步；{@link #accFlush} 才用 CAS）——理由见 {@code app/逻辑说明.md} §5.3。
     */
    private static final long[] ACC_FIRST = new long[SUB_COUNT];
    private static final long[] ACC_MS = new long[SUB_COUNT];

    static {
        for (int i = 0; i < SLOTS * 2; i++) {
            VALUES.set(i, UNSET);
        }
        accReset();
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

    /**
     * 记一个<b>数字快照</b>（首次写入胜出）：把一个"此刻的读数"存进某个槽，用来切"事情发生时它是多少"。
     *
     * <p>与 {@link #mark} 同为一次 CAS，只是存的是调用方给的数而不是现在时刻。两种用法见
     * {@link #POOL_AT_ROWS_BEGIN}（段二开跑那一刻池子里已备多少件）。
     */
    public static void markValue(int slot, long value) {
        VALUES.compareAndSet(slot * 2, UNSET, value);
    }

    /** 记一个"某计数槽此刻的读数"（见 {@link #POOL_AT_ROWS_BEGIN}）：没记过该计数槽就记 0。 */
    public static void markCount(int slot, int counterSlot) {
        markValue(slot, Math.max(0L, VALUES.get(counterSlot * 2 + 1)));
    }

    /**
     * 累加一个计数槽（"每来一次加一"，与 {@link #mark} 的"只记第一次"相反）。
     *
     * <p>计数写在槽位的<b>耗时格</b>上（起点格留空，由 {@link #counter(int)} 读）：先从 {@code UNSET}
     * 归零，再自增，故展示出来的就是真实次数，而"一次都没发生"仍显示 {@code 0}（不是"—"）。
     * 两次 {@link AtomicLongArray} 操作，无锁、无 IO、无抛点。
     */
    public static void count(int slot) {
        int cell = slot * 2 + 1;
        VALUES.compareAndSet(cell, UNSET, 0L);
        VALUES.incrementAndGet(cell);
    }

    // ==================== 建表细分的累计槽 ====================
    // 与 span/mark 的"一段只记一次"不同，建表内部的一类活会被做上很多次（134 次 inflate 就是 134 次
    // accBegin/accEnd），故这里先在一块普通长整数组上累加，建表末行一次性写进展示槽位。整条链只在主线程上跑。

    /**
     * 开始计入某累计槽（**只在建表的主线程上调**）；首次计入时顺手记下"这一类的第一笔活从哪一刻开始"。
     *
     * @param slot {@link #FORM_SUB_INFLATE} 起连续的 6 个之一
     * @return 起点（{@code uptimeMillis}），原样交给 {@link #accEnd}
     */
    public static long accBegin(int slot) {
        int index = slot - FORM_SUB_INFLATE;
        if (ACC_FIRST[index] < 0) {
            ACC_FIRST[index] = now();
        }
        return SystemClock.uptimeMillis();
    }

    /** 结束计入：把 {@code startUptime} 到此刻的毫秒数累加进该槽（只与 {@link #accBegin} 配对使用）。 */
    public static void accEnd(int slot, long startUptime) {
        ACC_MS[slot - FORM_SUB_INFLATE] += SystemClock.uptimeMillis() - startUptime;
    }

    /** 清零全部累计槽（每轮建表开头调一次）。 */
    public static void accReset() {
        for (int i = 0; i < SUB_COUNT; i++) {
            ACC_FIRST[i] = -1L;
            ACC_MS[i] = 0L;
        }
    }

    /**
     * 把累计槽写进展示槽位（每轮建表收尾调一次）：沿用"首次写入胜出"，没计入过的槽留空。
     * 为何写在建表末行而非每次 {@link #accEnd} 之后，见 {@code app/逻辑说明.md} §5.3。
     */
    public static void accFlush() {
        for (int i = 0; i < SUB_COUNT; i++) {
            if (ACC_FIRST[i] < 0) {
                continue;
            }
            int base = (FORM_SUB_INFLATE + i) * 2;
            if (VALUES.compareAndSet(base, UNSET, ACC_FIRST[i])) {
                VALUES.compareAndSet(base + 1, UNSET, ACC_MS[i]);
            }
        }
    }

    // ==================== 展示（只读访问器） ====================

    /** 展示层只读访问：槽位原始值（{@code -1} = 未记录）。 */
    public static long slot(int index) {
        return VALUES.get(index);
    }

    /** 槽位总数（时间点/计数/区间共用一维数组）。 */
    public static int slotCount() {
        return SLOTS;
    }

    /** 建表细分累计槽个数。 */
    public static int subCount() {
        return SUB_COUNT;
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
