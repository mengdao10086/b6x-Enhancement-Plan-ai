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
 *       那一次"。故进程内第二次进 Activity（暖启动）不会把这些数字刷成别的含义。<b>例外</b>是两个计数槽
 *       （{@link #count}）：它们就是"每来一次加一"，故报的是"到此刻为止一共几次"。</li>
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
 * 不阻塞</b>）或一次 volatile 读 + 一次减法；建表细分的累计槽（{@link #accBegin}/{@link #accEnd}）更轻
 * ——只在建表的主线程上对一块普通 {@code long[]} 做两次数组访问与一次加法，<b>无锁、无 CAS</b>，
 * 一整轮建表收尾才写一次展示槽位。全部记账<b>无 IO、不建线程、不轮询、不分配对象</b>
 * （只有 {@link #report()} 拼文本时分配一个 StringBuilder）。除两个计数槽外，每槽在进程内只可能被写
 * 一次，故竞争窗口只存在于启动那一瞬；计数槽会一直被写，但它每次只有两次原子数组操作，且只由主线程写。
 * 所有方法都<b>无抛点</b>（无 IO、无解析、无数组增长、无除零），故它在链上调用
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
    /**
     * 建表<b>首屏段</b>：建各分组的卡头 + 摆正组头开关与卡头徽标 + 参数区露出（默认折叠的页面在这一段
     * 末尾就置「就绪」，外壳据此撤骨架占位层）。
     */
    public static final int FORM_BUILD_HEAD = 5;
    /**
     * 建表<b>可见后段</b>：建各行与全部字段 + 值上屏 + 自检 + 诊断。
     *
     * <p>两段之和≈原先那一个"主线程建表"槽（总工作量没变），拆开是为了看清"用户实际等了多久"
     * （= 首屏段）与"用户不用等的活有多重"（= 可见后段）。
     */
    public static final int FORM_BUILD_ROWS = 6;

    // ---- 建表内部的 6 个累计槽（见 {@link #accBegin}/{@link #accEnd}）：只在建表的主线程上写 ----
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
    /** 累计：自检 + 徽标 + 诊断提交。 */
    public static final int FORM_SUB_ALIGN = 12;

    /** 累计槽个数（{@link #FORM_SUB_INFLATE} 起连续 {@code SUB_COUNT} 个）。 */
    private static final int SUB_COUNT = 6;

    // ---- 时间点 ----
    /** 时间点：{@code onCreate} 返回（壳与页容器建完）。 */
    public static final int MARK_ONCREATE_END = 13;
    /** 时间点：落页判定算完、放行主线程（{@code countDown}）那一刻。 */
    public static final int MARK_LANDING_WAKE = 14;
    /** 时间点：页面区第一次绘制之前。 */
    public static final int MARK_FIRST_DRAW = 15;
    /** 时间点：骨架占位层真被撤下那一刻（本次没挂过层就不记）。 */
    public static final int MARK_SKELETON_OFF = 16;
    /** 时间点：主线程进 {@code awaitLanding} 那一刻（与"判定放行"相减即 onCreate 里白等的那段）。 */
    public static final int MARK_LANDING_AWAIT = 17;
    /** 时间点：第一页的视图建好。 */
    public static final int MARK_PAGE_VIEW_1 = 18;
    /** 时间点：第三页（最后一页）的视图建好。 */
    public static final int MARK_PAGE_VIEW_ALL = 19;
    /** 时间点：建表数据到位（{@code onLoaded} 进主线程）。 */
    public static final int MARK_FORM_DATA = 20;
    /** 时间点：首轮 {@code onPageSelected}。 */
    public static final int MARK_PAGE_SELECTED = 21;
    /**
     * 时间点：参数区<b>露出之后</b>的第一次 pre-draw。
     *
     * <p>与 {@link #MARK_SKELETON_OFF} 相减即"露出到撤层之间"的那一段（vsync 与布局，还是队列里的
     * 别的活）。建表拆两段之后，露出点落在"建表·首屏"末尾，故本时间点仍与撤层同一帧或紧邻其前。
     */
    public static final int MARK_AFTER_BUILD_FRAME = 22;
    /** 时间点：曲线首次上数据完成。 */
    public static final int MARK_CHART_DATA = 23;
    /** 时间点：占位图真上屏。 */
    public static final int MARK_SKELETON_UP = 24;
    /** 时间点：诊断正文上屏。 */
    public static final int MARK_DIAG_APPLY = 25;

    // ---- 预制造（B）的埋点：2 个累计计数 + 6 个成因 + 1 个骨架首帧 ----
    // 全部只记账，不改变任何既有分支；判读口径见方案文件 §5 的那张表。

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
    /**
     * 时间点：骨架监听器第一次 pre-draw。
     *
     * <p>撤层不再有"画过一帧"的闸门，此点与 {@link #MARK_SKELETON_OFF} 相减，量的就是"骨架监听器
     * 第一趟到真撤层之间隔了几趟/多久"（用来确认两者之间没有多出来的 traversal）。
     */
    public static final int MARK_SKELETON_FIRST_PREDRAW = 34;

    private static final int SLOTS = 35;
    private static final long UNSET = -1L;

    /** 每槽两个 long：{@code [i*2]} = 该段起点的偏移（"时间点"槽只用它）、{@code [i*2+1]} = 该段耗时。 */
    private static final AtomicLongArray VALUES = new AtomicLongArray(SLOTS * 2);

    /** 计时原点（{@code uptimeMillis}）；{@code 0} = 还没定。 */
    private static final AtomicLong ORIGIN = new AtomicLong();

    /**
     * 累计槽的进行态：{@code [i]} = 该槽首次计入的时刻（相对原点；{@code -1} = 没计入过）、
     * 各次计入的毫秒合计。
     *
     * <p>普通 {@code long[]} 而非原子数组：<b>只有建表的主线程会写</b>（{@code accBegin}/{@code accEnd}/
     * {@code accReset}/{@code accFlush} 全部由建表那条链调用），故不需要任何同步；写进展示槽位的那一步
     * （{@link #accFlush}）才用 {@link AtomicLongArray} 的 CAS，读它的诊断区因此永远看到一份定值。
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
     *
     * <p>写在建表末行而不是每次 {@link #accEnd} 之后：一是省掉 134 次同步开销，二是这一轮建表没跑完时
     * 诊断区读到的仍是上一轮的定值（不出现"只填了一半"的中间态）。
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
            StringBuilder sb = new StringBuilder(720);
            sb.append("启动耗时（相对 onCreate 首行，ms）");
            sb.append("\n起 = 该段开始时距首行的毫秒数；后台各段并行，耗时不可相加");
            appendSpan(sb, "落页判定", LANDING);
            appendSpan(sb, "配置定义", DEF_LOAD);
            appendSpan(sb, "配置首份快照", SNAP_LOAD);
            appendSpan(sb, "曲线口径", CHART_CFG);
            appendSpan(sb, "曲线数据首读", CHART_DATA);
            appendSpan(sb, "建表·首屏", FORM_BUILD_HEAD);
            appendSpan(sb, "建表·可见后", FORM_BUILD_ROWS);
            appendSubs(sb);
            // 预制造（B）：命中/未命中看"池子里有没有件"，六个成因看"谁是死因"（判读口径见方案文件 §5）
            sb.append("\n预制造 · 命中 ").append(counter(PRE_HIT))
                    .append(" · 未命中 ").append(counter(PRE_MISS));
            sb.append("\n预制造 · 失败 ").append(moment(MARK_PRE_FAIL))
                    .append(" · 未就绪 ").append(moment(MARK_PRE_NOT_READY))
                    .append(" · 无实例 ").append(moment(MARK_PRE_NO_INSTANCE))
                    .append(" · 已关门 ").append(moment(MARK_PRE_CLOSED))
                    .append(" · 身份不符 ").append(moment(MARK_PRE_OWNER_MISMATCH))
                    .append(" · 已启动 ").append(moment(MARK_PRE_ALREADY_STARTED));
            sb.append("\n时间点 · 骨架首帧 ").append(moment(MARK_SKELETON_FIRST_PREDRAW));
            sb.append("\n时间点 · onCreate 结束 ").append(moment(MARK_ONCREATE_END))
                    .append(" · 判定放行 ").append(moment(MARK_LANDING_WAKE))
                    .append(" · 首帧 ").append(moment(MARK_FIRST_DRAW))
                    .append(" · 撤占位层 ").append(moment(MARK_SKELETON_OFF));
            sb.append("\n时间点 · 落页等待 ").append(moment(MARK_LANDING_AWAIT))
                    .append(" · 首页视图 ").append(moment(MARK_PAGE_VIEW_1))
                    .append(" · 三页视图 ").append(moment(MARK_PAGE_VIEW_ALL))
                    .append(" · 页面选中 ").append(moment(MARK_PAGE_SELECTED));
            sb.append("\n时间点 · 数据到位 ").append(moment(MARK_FORM_DATA))
                    .append(" · 建表后首帧 ").append(moment(MARK_AFTER_BUILD_FRAME))
                    .append(" · 曲线数据 ").append(moment(MARK_CHART_DATA))
                    .append(" · 骨架上屏 ").append(moment(MARK_SKELETON_UP))
                    .append(" · 诊断上屏 ").append(moment(MARK_DIAG_APPLY));
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

    /**
     * 建表细分的六项（每行三项，紧跟在两个建表段之后）+ 六项合计。
     *
     * <p>读法：<b>六项合计与"建表·首屏 + 建表·可见后"相减，差额就是没埋到点上的胶水代码</b>；
     * 某一项占比高就说明那一类活是瓶颈（判据见方案文件 §4.3）。一项都没计入过就整段不显示。
     */
    private static void appendSubs(StringBuilder sb) {
        if (!anySubRecorded()) {
            return;
        }
        sb.append("\n细分 · 控件制造 ").append(ms(FORM_SUB_INFLATE))
                .append(" · 说明画笔 ").append(ms(FORM_SUB_PAINT))
                .append(" · 文本实测宽 ").append(ms(FORM_SUB_MEASURE));
        sb.append("\n细分 · 值回填 ").append(ms(FORM_SUB_FILL))
                .append(" · 挂载 ").append(ms(FORM_SUB_ATTACH))
                .append(" · 自检对齐 ").append(ms(FORM_SUB_ALIGN));
        long sum = 0L;
        for (int i = 0; i < SUB_COUNT; i++) {
            // 合计必须与上面六项<b>同源</b>：两边都取已 flush 的展示槽位。取 ACC_MS 的话，
            // 第二轮建表（视图重建）会把它清零重算，而展示槽位是首次写入胜出 → 六项是上一轮、
            // 合计是这一轮，两个数永远对不上（诊断数字是本包的核心交付物，不能自相矛盾）
            sum += Math.max(0L, VALUES.get((FORM_SUB_INFLATE + i) * 2 + 1));
        }
        sb.append(" · 合计 ").append(sum);
    }

    /** 累计槽的耗时（累计槽只用"耗时"那一格，起点那一格不对它对外开放）。 */
    private static String ms(int slot) {
        return value(VALUES.get(slot * 2 + 1));
    }

    private static boolean anySubRecorded() {
        for (int i = 0; i < SUB_COUNT; i++) {
            if (VALUES.get((FORM_SUB_INFLATE + i) * 2) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static String moment(int slot) {
        return value(VALUES.get(slot * 2));
    }

    /** 计数槽的读数：没记过按 {@code 0} 显示（"一次都没发生"）。 */
    private static String counter(int slot) {
        return Long.toString(Math.max(0L, VALUES.get(slot * 2 + 1)));
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
