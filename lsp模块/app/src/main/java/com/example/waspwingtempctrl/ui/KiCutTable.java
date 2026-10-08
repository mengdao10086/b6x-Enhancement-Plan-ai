package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

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
 * <p>与 C 端逐条对齐的几点：点按冷值<b>稳定升序</b>且<b>同冷值保留先出现者</b>；单簇点数上限 32；
 * 曲线为<b>纯折线</b>（无平滑）；单点簇整簇恒定；端点外平推；多簇取最小；无有效簇恒为 {@link #NEUTRAL}。
 * 输出为 <b>float</b>（与 C 端同为 32 位浮点）。
 */
public final class KiCutTable {

    /** 倍率 ×100 口径下「不削」的值，也是无有效簇时的恒返回值（同时也是新增点的默认倍率）。 */
    public static final int NEUTRAL = 100;

    /** 单簇点数上限（与 {@code KI_CUT_MAX_POINTS} 一致）。 */
    private static final int MAX_POINTS = 32;

    /** 曲线图的取值轴：升倍率 / 降倍率 / KDP 倍率（三轴均为 ×100 口径）。 */
    public static final int AXIS_UP = 0;
    public static final int AXIS_DN = 1;
    public static final int AXIS_KDP = 2;

    /** 一个控制点：冷值（档位）+ KDP 倍率 + 升倍率 + 降倍率（三个倍率均 ×100 口径）。 */
    public static final class Point {
        public final int cold;
        public final int kdp;
        public final int up;
        public final int dn;

        public Point(int cold, int kdp, int up, int dn) {
            this.cold = cold;
            this.kdp = kdp;
            this.up = up;
            this.dn = dn;
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

    // ==================== 行编解码 ====================

    /**
     * 一行文本 → 一个簇：按非数字分隔取出整数，每四个一组（冷值,KDP,升,降）；末尾不足四个的整组丢弃。
     * 空串 / 无数字 → 空簇。
     */
    @NonNull
    public static Cluster parseLine(@NonNull String line) {
        List<Integer> nums = parseInts(line);
        Cluster cluster = new Cluster();
        for (int i = 0; i + 4 <= nums.size(); i += 4) {
            cluster.points.add(new Point(
                    nums.get(i), nums.get(i + 1), nums.get(i + 2), nums.get(i + 3)));
        }
        return cluster;
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

    /** 一个簇 → 一行落盘文本（`冷值,KDP,升,降,…`）。 */
    @NonNull
    public static String formatRow(@NonNull Cluster cluster) {
        StringBuilder sb = new StringBuilder();
        for (Point p : cluster.points) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(p.cold).append(',').append(p.kdp).append(',').append(p.up).append(',')
                    .append(p.dn);
        }
        return sb.toString();
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

    /** 逐字符取整数（容忍逗号/空格/换行等分隔符与正负号）。 */
    @NonNull
    private static List<Integer> parseInts(@NonNull String s) {
        List<Integer> out = new ArrayList<>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            boolean digit = c >= '0' && c <= '9';
            boolean sign = (c == '-' || c == '+') && i + 1 < len
                    && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9';
            if (!digit && !sign) {
                i++;
                continue;
            }
            int start = i;
            if (!digit) {
                i++;
            }
            while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                i++;
            }
            try {
                out.add(Integer.parseInt(s.substring(start, i)));
            } catch (NumberFormatException ignored) {
                // 超出 int 范围的单值直接跳过（口径与 C 端逐 token 解析同向）
            }
        }
        return out;
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
     * 一个簇的曲线：点按冷值稳定升序、同冷值保留先出现者；折线插值（范围外平推）。
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

        /** 折线取值：{@code x} 在两端外取端点值，其间按相邻控制点线性插值。 */
        private static float lerp(Point[] pts, int n, int x, int axis) {
            if (x <= pts[0].cold) {
                return axisValue(pts[0], axis);
            }
            if (x >= pts[n - 1].cold) {
                return axisValue(pts[n - 1], axis);
            }
            for (int i = 1; i < n; i++) {
                if (x <= pts[i].cold) {
                    float t = (float) (x - pts[i - 1].cold) / (float) (pts[i].cold - pts[i - 1].cold);
                    float y0 = axisValue(pts[i - 1], axis);
                    return y0 + t * (axisValue(pts[i], axis) - y0);
                }
            }
            return axisValue(pts[n - 1], axis);
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
