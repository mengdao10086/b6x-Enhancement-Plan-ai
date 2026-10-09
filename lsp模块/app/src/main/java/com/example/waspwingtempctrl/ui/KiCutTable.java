package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * KI 分段倍率表的纯模型与求值（<b>无 Android 依赖</b>，可在桌面 JVM 上直接跑）。
 *
 * <p>落盘口径（一行一簇、行内重复四元组）与求值算法（逐簇折线 → 跨簇取最小）的唯一权威是 C 端
 * {@code daemon/ki_cut.h}；本类是与它<b>逐值对齐</b>的界面侧重算实现（对照
 * {@code 参数定义/ki_cut_golden.json}），只服务编辑器预览与曲线图，<b>不参与落盘</b>（落盘的是原始数字）。
 *
 * <p><b>三个倍率字段可留空</b>（段内什么都不写 = 留空）：该点在该轴上<b>不作为控制点</b>，从该轴的控制点
 * 序列中剔除，折线由相邻两个未留空控制点直接连线；某侧没有相邻控制点则平推（沿用另一侧）；该轴一个控制点
 * 都不剩 → 该轴恒为 {@link #NEUTRAL}（100 = 不削）。三条轴互相独立。写回时留空字段原样输出为空 token
 * （不补 0、不补 min）。
 *
 * <p><b>冷值也可留空</b>（{@code Point.hasCold == false}）：该点为**占位行**（不参与任何轴的求值，整点不生效），
 * 仅在编辑与落盘之间<b>原样往返</b>（K2 的「新增一行、四个框全空」）。**冷值留空 ≠ 冷值填了非整数**：
 * 后者仍按旧口径丢弃该点。落盘哨兵形态：空值行或全占位行 → 该簇清空（= 全段不削），见 `tempctrl.c`。
 *
 * <p>与 C 端逐条对齐的几点：点按冷值<b>稳定升序</b>且<b>同冷值保留先出现者</b>（与是否留空无关）；单簇点数上限 32；
 * 曲线为<b>纯折线</b>（无平滑）；单点簇整簇恒定；端点外平推；**多簇逐轴取「离各簇候选平均值最近」者**
 * （等距取更小倍率）；无有效簇恒为 {@link #NEUTRAL}。输出为 <b>float</b>（与 C 端同为 32 位浮点，运算顺序亦逐位对齐）。
 */
public final class KiCutTable {

    /** 倍率 ×100 口径下「不削」的值，也是无有效簇（或某轴无控制点）时的恒返回值（同时是新增点的默认倍率）。 */
    public static final int NEUTRAL = 100;

    /** 单簇点数上限（与 {@code KI_CUT_MAX_POINTS} 一致）。 */
    private static final int MAX_POINTS = 32;

    /** 曲线图的取值轴：升倍率 / 降倍率 / KDP 倍率（三轴均为 ×100 口径）。 */
    public static final int AXIS_UP = 0;
    public static final int AXIS_DN = 1;
    public static final int AXIS_KDP = 2;

    /** 某点在某轴上「留空」（不作为该轴控制点）的标记位（与 C 端 {@code KI_CUT_SKIP_*} 一致）。 */
    public static final int SKIP_KDP = 1;
    public static final int SKIP_UP = 2;
    public static final int SKIP_DN = 4;

    /**
     * 一个控制点：冷值（档位）+ KDP 倍率 + 升倍率 + 降倍率（三个倍率均 ×100 口径）+ 各轴留空标记
     * + 冷值是否填了（{@link #hasCold}）。
     * 留空轴上的 {@code kdp}/{@code up}/{@code dn} 值无意义（不参与该轴求值、写回时也输出为空）。
     */
    public static final class Point {
        public final int cold;
        public final int kdp;
        public final int up;
        public final int dn;
        /** {@link #SKIP_KDP} / {@link #SKIP_UP} / {@link #SKIP_DN} 的按位或；0 = 三轴都作为控制点。 */
        public final int skip;
        /**
         * 冷值是否填写。{@code false} = **占位行**（冷值留空；整点不生效、不参与任何轴求值），
         * 只用于编辑与落盘之间原样往返。此时 {@link #cold} 的值无意义（恒 0）。
         */
        public final boolean hasCold;

        /** 兼容构造：冷值视为已填（既有调用点无需改动）。 */
        public Point(int cold, int kdp, int up, int dn, int skip) {
            this(cold, true, kdp, up, dn, skip);
        }

        public Point(int cold, boolean hasCold, int kdp, int up, int dn, int skip) {
            this.cold = cold;
            this.hasCold = hasCold;
            this.kdp = kdp;
            this.up = up;
            this.dn = dn;
            this.skip = skip;
        }
    }

    /** 一个簇：一组控制点（= 配置里的一行 {@code KI_CUT_<n>}）。 */
    public static final class Cluster {
        public final List<Point> points = new ArrayList<>();

        public Cluster() {
        }

        public Cluster(List<Point> initial) {
            points.addAll(initial);
        }

        public boolean isEmpty() {
            return points.isEmpty();
        }
    }

    private KiCutTable() {
    }

    /** 某点在某轴是否留空（不作为控制点）。axis 见 {@link #AXIS_UP} / {@link #AXIS_DN} / {@link #AXIS_KDP}。 */
    static boolean isSkipped(@NonNull Point p, int axis) {
        switch (axis) {
            case AXIS_KDP:
                return (p.skip & SKIP_KDP) != 0;
            case AXIS_DN:
                return (p.skip & SKIP_DN) != 0;
            case AXIS_UP:
            default:
                return (p.skip & SKIP_UP) != 0;
        }
    }

    /** 某轴对应的留空标记位（axis 见 {@link #AXIS_UP} 等）。 */
    private static int skipBit(int axis) {
        switch (axis) {
            case AXIS_KDP:
                return SKIP_KDP;
            case AXIS_DN:
                return SKIP_DN;
            case AXIS_UP:
            default:
                return SKIP_UP;
        }
    }

    // ==================== 行编解码 ====================

    /**
     * 一行文本 → 一个簇：按 {@code ','} 切分、<b>保留空段</b>，每四个一组
     * （{@code 冷值,KDP倍率,升倍率,降倍率}）；段内首尾空白剔除。<b>空段 = 该字段留空</b>。
     *
     * <p>与 daemon（{@code tempctrl.c: ki_cut_parse_row}）同口径：
     * 段数非四元组整数倍 → 整行忽略；倍率段非空但非整数 → 整行忽略；倍率段留空 → 该轴跳过此点。
     * <b>冷值留空</b> → 保留为**占位行**（{@code hasCold=false}，整点不生效，仅原样往返）；
     * <b>冷值填了但非整数</b> → 该点整点忽略（旧口径）。空簇（无有效点）对求值无贡献（等效整行忽略）。
     */
    @NonNull
    public static Cluster parseLine(@NonNull String line) {
        Cluster cluster = new Cluster();
        String[] segs = line.split(",", -1);
        if (segs.length % 4 != 0) {
            return cluster;   // 段数非四元组整数倍：整行忽略
        }
        for (int i = 0; i < segs.length; i += 4) {
            boolean coldBlank = segs[i].trim().isEmpty();
            Long cold = parseSegInt(segs[i]);
            if (!coldBlank && cold == null) {
                continue;   // 冷值非空但非整数：整点忽略（旧口径，与 C 端一致）
            }
            int skip = 0;
            int[] rate = new int[3];
            boolean bad = false;
            for (int a = 0; a < 3; a++) {
                String seg = segs[i + 1 + a].trim();
                if (seg.isEmpty()) {
                    skip |= skipBit(rateAxis(a));   // 留空：该轴跳过此点
                    rate[a] = NEUTRAL;
                    continue;
                }
                Long v = parseSegInt(seg);
                if (v == null) {
                    bad = true;
                    break;
                }
                rate[a] = v.intValue();
            }
            if (bad) {
                return new Cluster();   // 非空但非整数：整行忽略
            }
            if (coldBlank) {
                // 冷值留空 = 占位行：整点不生效，但保留占位以便编辑/落盘往返（含四字段全空的「新增行」）
                cluster.points.add(new Point(0, false, rate[0], rate[1], rate[2], skip));
            } else {
                cluster.points.add(new Point(cold.intValue(), rate[0], rate[1], rate[2], skip));
            }
        }
        return cluster;
    }

    /** 四元组内第 {@code a} 个倍率字段（0=KDP、1=升、2=降）对应的取值轴。 */
    private static int rateAxis(int a) {
        return a == 0 ? AXIS_KDP : (a == 1 ? AXIS_UP : AXIS_DN);
    }

    /** 多行（每行一个簇）→ 簇表；空白行跳过。 */
    @NonNull
    public static List<Cluster> parseRows(@NonNull List<String> lines) {
        List<Cluster> out = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            out.add(parseLine(line));
        }
        return out;
    }

    /** 一个簇 → 一行落盘文本（{@code 冷值,KDP,升,降,…}）；留空字段（含冷值）原样输出为空 token。 */
    @NonNull
    public static String formatRow(@NonNull Cluster cluster) {
        StringBuilder sb = new StringBuilder();
        for (Point p : cluster.points) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            if (p.hasCold) {
                sb.append(p.cold);
            }
            sb.append(',');
            appendField(sb, p, SKIP_KDP, p.kdp);
            sb.append(',');
            appendField(sb, p, SKIP_UP, p.up);
            sb.append(',');
            appendField(sb, p, SKIP_DN, p.dn);
        }
        return sb.toString();
    }

    /** 留空字段输出空 token（不补 0、不补 min）；否则输出数值。 */
    private static void appendField(StringBuilder sb, Point p, int bit, int value) {
        if ((p.skip & bit) == 0) {
            sb.append(value);
        }
    }

    /** 簇表 → 多行落盘文本（行号即簇号，从 1 起、连续）。 */
    @NonNull
    public static String formatRows(@NonNull List<Cluster> clusters) {
        StringBuilder sb = new StringBuilder();
        for (Cluster cluster : clusters) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(formatRow(cluster));
        }
        return sb.toString();
    }

    /** 一个段 → 整数（首尾空白剔除后须整段为合法整数，可带 +/-）；空段或非整数 → null。 */
    @Nullable
    private static Long parseSegInt(@NonNull String seg) {
        String s = seg.trim();
        if (s.isEmpty()) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(s));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // ==================== 求值 ====================

    /**
     * 一个冷值上的输出倍率：逐簇求值后逐轴取「离各簇候选平均值最近」者（等距取更小）；
     * 无有效簇时返回 {@link #NEUTRAL}。
     *
     * @return {@code {升倍率, 降倍率}}（×100 口径，未取整——与 C 端同为浮点）
     */
    @NonNull
    public static float[] evaluate(@NonNull List<Cluster> clusters, int cold) {
        List<Curve> cs = activeCurves(clusters);
        float[] upCand = new float[cs.size()];
        float[] dnCand = new float[cs.size()];
        for (int i = 0; i < cs.size(); i++) {
            upCand[i] = cs.get(i).value(cold, AXIS_UP);
            dnCand[i] = cs.get(i).value(cold, AXIS_DN);
        }
        return new float[]{pickByMean(upCand), pickByMean(dnCand)};
    }

    /** 有效簇（含 ≥1 个填了冷值的点）对应的曲线；占位行-only 的簇不算（与 C 端「清空该簇」一致）。 */
    @NonNull
    private static List<Curve> activeCurves(@NonNull List<Cluster> clusters) {
        List<Curve> curves = new ArrayList<>();
        for (Cluster cluster : clusters) {
            Curve c = Curve.of(cluster);
            if (!c.isEmpty()) {
                curves.add(c);
            }
        }
        return curves;
    }

    /**
     * 等距判定容差（与 C 端 {@code KI_CUT_TIE_EPS} 一致）。2 簇时两候选到均值数学上等距，但 float32 下
     * `mean-v1` 与 `v2-mean` 各自舍入、差值可达几 ulp（实测 1.9e-6），精确比较会**反过来选中较大值**；
     * 1e-3 远超该噪声、又远小于判据容差 0.05。
     */
    private static final float TIE_EPS = 1.0e-3f;

    /** 逐轴取「离各候选平均值最近」者；**等距（含浮点舍入噪声）取更小倍率**（2 簇时恒等于「取最小」）；无候选 → NEUTRAL。 */
    private static float pickByMean(@NonNull float[] cand) {
        if (cand.length == 0) {
            return NEUTRAL;
        }
        float sum = 0f;
        for (float v : cand) {
            sum += v;
        }
        float mean = sum / cand.length;
        float best = cand[0];
        for (int i = 1; i < cand.length; i++) {
            float d0 = Math.abs(best - mean);
            float d1 = Math.abs(cand[i] - mean);
            if (Math.abs(d0 - d1) <= TIE_EPS) {
                if (cand[i] < best) {
                    best = cand[i];     // 等距（含舍入噪声）→ 取更小
                }
            } else if (d1 < d0) {
                best = cand[i];
            }
        }
        return best;
    }

    /**
     * 曲线图上「实际生效」的一条线：{@code x = 0 … xMax} 逐格取该生效值（逐簇候选取离平均值最近者）。
     * 语义与 C 端 {@code ki_cut_eval} 逐位对齐。
     *
     * @param axis 取值轴，见 {@link #AXIS_UP} / {@link #AXIS_DN} / {@link #AXIS_KDP}
     */
    @NonNull
    public static float[] effectiveCurve(@NonNull List<Cluster> clusters, int xMax, int axis) {
        List<Curve> cs = activeCurves(clusters);
        float[] out = new float[Math.max(0, xMax) + 1];
        float[] sample = new float[3];
        for (int x = 0; x < out.length; x++) {
            axisSample(cs, x, axis, sample);
            out[x] = sample[0];
        }
        return out;
    }

    /** {@link #effectiveCurve} 的兼容别名（旧名如此；语义同为「生效曲线」）。 */
    @NonNull
    public static float[] minCurve(@NonNull List<Cluster> clusters, int xMax, int axis) {
        return effectiveCurve(clusters, xMax, axis);
    }

    /**
     * 「不生效候选」曲线：{@code x = 0 … xMax} 逐格给出该轴不生效候选里离生效值最近的那个值；
     * 该处没有不生效候选时 = {@link #effectiveCurve} 的值（与实线重合）。供 K2 画同色虚线。
     *
     * @param axis 取值轴，见 {@link #AXIS_UP} / {@link #AXIS_DN} / {@link #AXIS_KDP}
     */
    @NonNull
    public static float[] shadowCurve(@NonNull List<Cluster> clusters, int xMax, int axis) {
        List<Curve> cs = activeCurves(clusters);
        float[] out = new float[Math.max(0, xMax) + 1];
        float[] sample = new float[3];
        for (int x = 0; x < out.length; x++) {
            axisSample(cs, x, axis, sample);
            out[x] = sample[2];
        }
        return out;
    }

    /**
     * 该轴逐整数冷值处「是否存在不生效候选」（true = 该处画同色虚线）。粒度 = 逐整数冷值；
     * K2 若想画「段」，把连续 true 的极大区间并起来即可。
     *
     * @param axis 取值轴，见 {@link #AXIS_UP} / {@link #AXIS_DN} / {@link #AXIS_KDP}
     */
    @NonNull
    public static boolean[] inactiveMask(@NonNull List<Cluster> clusters, int xMax, int axis) {
        List<Curve> cs = activeCurves(clusters);
        boolean[] out = new boolean[Math.max(0, xMax) + 1];
        float[] sample = new float[3];
        for (int x = 0; x < out.length; x++) {
            axisSample(cs, x, axis, sample);
            out[x] = sample[1] != 0f;
        }
        return out;
    }

    /**
     * 逐轴逐 x 的采样：{@code out = {生效值, 是否有不生效候选(0/1), 最近的不生效候选值}}。
     * 生效值 = 各簇候选里离候选平均值最近者（等距取更小）；无候选簇 → NEUTRAL、无候选。
     */
    private static void axisSample(@NonNull List<Curve> cs, int x, int axis,
                                   @NonNull float[] out) {
        if (cs.isEmpty()) {
            out[0] = NEUTRAL;
            out[1] = 0f;
            out[2] = NEUTRAL;
            return;
        }
        float[] cand = new float[cs.size()];
        for (int i = 0; i < cs.size(); i++) {
            cand[i] = cs.get(i).value(x, axis);
        }
        out[0] = pickByMean(cand);
        float best = out[0];
        float shadow = best;
        boolean has = false;
        float bestD = 0f;
        for (float v : cand) {
            if (v == best) {
                continue;
            }
            float d = Math.abs(v - best);
            if (!has || d < bestD) {
                has = true;
                bestD = d;
                shadow = v;
            }
        }
        out[1] = has ? 1f : 0f;
        out[2] = shadow;
    }

    /**
     * 一个簇的曲线：<b>先剔除占位行（冷值留空）</b>，其余点按冷值稳定升序、同冷值保留先出现者（与是否留空无关）；
     * 折线插值（范围外平推）；逐轴在<b>未留空</b>的控制点序列内插值，某轴无控制点 → 该轴恒为 {@link #NEUTRAL}。
     *
     * <p><b>零分配</b>：只保留排好序、去重后的 {@link Point}[]，在 {@link #value(int, int)} 里
     * 按需插值——不按跨度分配数组，故冷值被改成极值（如 ±2e9）也不会 OOM / NegativeArraySizeException。
     */
    private static final class Curve {

        /** 排序去重后的控制点（长度 = 去重后点数）。 */
        private final Point[] pts;
        private final int n;

        private Curve(Point[] pts, int n) {
            this.pts = pts;
            this.n = n;
        }

        /** 有效控制点数为 0（该簇全是占位行）→ 不作候选、该轴恒 NEUTRAL。 */
        boolean isEmpty() {
            return n == 0;
        }

        static Curve of(@NonNull Cluster cluster) {
            Point[] pts = new Point[Math.min(cluster.points.size(), MAX_POINTS)];
            int n = 0;
            for (Point p : cluster.points) {
                if (!p.hasCold) {
                    continue;   // 占位行（冷值留空）：不参与任何轴
                }
                if (n >= MAX_POINTS) {
                    break;      // 与 C 端一致：只取前 MAX_POINTS 个有效点
                }
                pts[n++] = p;
            }
            // 稳定升序（Arrays.sort 走 TimSort，同值保持原先后），随后同冷值保留先出现者
            Arrays.sort(pts, 0, n, new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    return Integer.compare(a.cold, b.cold);
                }
            });
            int m = 0;
            for (int i = 0; i < n; i++) {
                if (m > 0 && pts[i].cold == pts[m - 1].cold) {
                    continue;
                }
                pts[m++] = pts[i];
            }
            return new Curve(pts, m);
        }

        /** 按取值轴取 {@code x} 处的值（升 / 降 / KDP）：折线按需插值（范围外平推到端点）。 */
        float value(int x, int axis) {
            return lerp(pts, n, x, axis);
        }

        /**
         * 折线取值：在该轴<b>未留空</b>的控制点序列内，{@code x} 在两端外取端点值，其间按相邻控制点线性插值。
         * 该轴无任何控制点（全部留空）→ 返回 {@link #NEUTRAL}（不削）。运算顺序与 C 端逐位一致。
         */
        private static float lerp(Point[] pts, int n, int x, int axis) {
            int first = -1;
            int last = -1;
            for (int i = 0; i < n; i++) {
                if (isSkipped(pts[i], axis)) {
                    continue;
                }
                if (first < 0) {
                    first = i;
                }
                last = i;
            }
            if (first < 0) {
                return NEUTRAL;   // 该轴无控制点：全程不削
            }
            if (x <= pts[first].cold) {
                return axisValue(pts[first], axis);
            }
            if (x >= pts[last].cold) {
                return axisValue(pts[last], axis);
            }
            int prev = first;
            for (int i = first + 1; i <= last; i++) {
                if (isSkipped(pts[i], axis)) {
                    continue;
                }
                if (x <= pts[i].cold) {
                    float t = (float) (x - pts[prev].cold) / (float) (pts[i].cold - pts[prev].cold);
                    float y0 = axisValue(pts[prev], axis);
                    return y0 + t * (axisValue(pts[i], axis) - y0);
                }
                prev = i;
            }
            return axisValue(pts[last], axis);
        }

        private static float axisValue(Point p, int axis) {
            switch (axis) {
                case AXIS_KDP:
                    return p.kdp;
                case AXIS_DN:
                    return p.dn;
                case AXIS_UP:
                default:
                    return p.up;
            }
        }
    }
}
