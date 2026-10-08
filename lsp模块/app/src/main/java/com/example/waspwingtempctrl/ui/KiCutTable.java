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
 * （不补 0、不补 min）。<b>冷值必填</b>（横坐标，无留空）。
 *
 * <p>与 C 端逐条对齐的几点：点按冷值<b>稳定升序</b>且<b>同冷值保留先出现者</b>（与是否留空无关）；单簇点数上限 32；
 * 曲线为<b>纯折线</b>（无平滑）；单点簇整簇恒定；端点外平推；多簇取最小；无有效簇恒为 {@link #NEUTRAL}。
 * 输出为 <b>float</b>（与 C 端同为 32 位浮点，运算顺序亦逐位对齐）。
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
     * 一个控制点：冷值（档位）+ KDP 倍率 + 升倍率 + 降倍率（三个倍率均 ×100 口径）+ 各轴留空标记。
     * 留空轴上的 {@code kdp}/{@code up}/{@code dn} 值无意义（不参与该轴求值、写回时也输出为空）。
     */
    public static final class Point {
        public final int cold;
        public final int kdp;
        public final int up;
        public final int dn;
        /** {@link #SKIP_KDP} / {@link #SKIP_UP} / {@link #SKIP_DN} 的按位或；0 = 三轴都作为控制点。 */
        public final int skip;

        public Point(int cold, int kdp, int up, int dn, int skip) {
            this.cold = cold;
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
     * 段数非四元组整数倍 → 整行忽略；冷值留空或非整数 → 该点整点忽略；倍率段非空但非整数 → 整行忽略；
     * 倍率段留空 → 该轴跳过此点。空簇（无有效点）对求值无贡献（等效整行忽略）。
     */
    @NonNull
    public static Cluster parseLine(@NonNull String line) {
        Cluster cluster = new Cluster();
        String[] segs = line.split(",", -1);
        if (segs.length % 4 != 0) {
            return cluster;   // 段数非四元组整数倍：整行忽略
        }
        for (int i = 0; i < segs.length; i += 4) {
            Long cold = parseSegInt(segs[i]);
            if (cold == null) {
                continue;   // 冷值留空/非整数：整点忽略（冷值是横坐标，必填）
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
            cluster.points.add(new Point(cold.intValue(), rate[0], rate[1], rate[2], skip));
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

    /** 一个簇 → 一行落盘文本（{@code 冷值,KDP,升,降,…}）；留空字段原样输出为空 token。 */
    @NonNull
    public static String formatRow(@NonNull Cluster cluster) {
        StringBuilder sb = new StringBuilder();
        for (Point p : cluster.points) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(p.cold).append(',');
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
     * 一个冷值上的输出倍率：逐簇求值后取最小；无有效簇（点数为 0）时返回 {@link #NEUTRAL}。
     *
     * @return {@code {升倍率, 降倍率}}（×100 口径，未取整——与 C 端同为浮点）
     */
    @NonNull
    public static float[] evaluate(@NonNull List<Cluster> clusters, int cold) {
        float up = NEUTRAL;
        float dn = NEUTRAL;
        boolean used = false;
        for (Cluster cluster : clusters) {
            if (cluster.isEmpty()) {
                continue;
            }
            Curve curve = Curve.of(cluster);
            if (!used || curve.up(cold) < up) {
                up = curve.up(cold);
            }
            if (!used || curve.dn(cold) < dn) {
                dn = curve.dn(cold);
            }
            used = true;
        }
        return new float[]{up, dn};
    }

    /**
     * 曲线图上的一条线：{@code x = 0 … xMax} 逐格取所有簇的最小值。
     *
     * @param axis 取值轴，见 {@link #AXIS_UP} / {@link #AXIS_DN} / {@link #AXIS_KDP}
     */
    @NonNull
    public static float[] minCurve(@NonNull List<Cluster> clusters, int xMax, int axis) {
        List<Curve> curves = new ArrayList<>();
        for (Cluster cluster : clusters) {
            if (!cluster.isEmpty()) {
                curves.add(Curve.of(cluster));
            }
        }
        float[] out = new float[Math.max(0, xMax) + 1];
        for (int x = 0; x < out.length; x++) {
            float v = NEUTRAL;
            boolean used = false;
            for (Curve curve : curves) {
                float cv = curve.value(x, axis);
                if (!used || cv < v) {
                    v = cv;
                }
                used = true;
            }
            out[x] = v;
        }
        return out;
    }

    /**
     * 一个簇的曲线：点按冷值稳定升序、同冷值保留先出现者（与是否留空无关）；折线插值（范围外平推）；
     * 逐轴在<b>未留空</b>的控制点序列内插值，某轴无控制点 → 该轴恒为 {@link #NEUTRAL}。
     *
     * <p><b>零分配</b>：只保留排好序、去重后的 {@link Point}[]，在 {@link #up(int)}/{@link #dn(int)} 里
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

        static Curve of(@NonNull Cluster cluster) {
            int n = Math.min(cluster.points.size(), MAX_POINTS);
            Point[] pts = new Point[n];
            for (int i = 0; i < n; i++) {
                pts[i] = cluster.points.get(i);
            }
            // 稳定升序（Arrays.sort 走 TimSort，同值保持原先后），随后同冷值保留先出现者
            Arrays.sort(pts, new Comparator<Point>() {
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

        /** 取 {@code x} 处的值：折线按需插值（范围外平推到端点）。 */
        float up(int x) {
            return value(x, AXIS_UP);
        }

        float dn(int x) {
            return value(x, AXIS_DN);
        }

        /** 按取值轴取 {@code x} 处的值（升 / 降 / KDP）。 */
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
