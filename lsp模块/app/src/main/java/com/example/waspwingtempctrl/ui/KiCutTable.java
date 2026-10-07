package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * KI 分段倍率表的纯模型与求值（<b>无 Android 依赖</b>，可在桌面 JVM 上直接跑）。
 *
 * <p>落盘口径（一行一簇、行内三元组重复）与求值算法（逐簇折线 → 双向 EMA → 控制点残差回补 → 跨簇取最小）
 * 的唯一权威是 C 端 {@code daemon/ki_cut.h}；本类是与它<b>逐值对齐</b>的界面侧重算实现（对照
 * {@code 参数定义/ki_cut_golden.json}），只服务编辑器预览与曲线图，<b>不参与落盘</b>（落盘的是原始数字）。
 *
 * <p>与 C 端逐条对齐的几点：点按冷值<b>稳定升序</b>且<b>同冷值保留先出现者</b>；单簇点数上限 32；
 * 采样跨度上限 256（超了退回折线）；{@code smooth} 为 0 或 100 视为关闭平滑；单点簇整簇恒定；
 * 端点外平推；多簇取最小；无有效簇恒为 {@link #NEUTRAL}。输出为 <b>float</b>（与 C 端同为 32 位浮点）。
 */
public final class KiCutTable {

    /** 倍率 ×100 口径下「不削」的值，也是无有效簇时的恒返回值（同时也是新增点的默认倍率）。 */
    public static final int NEUTRAL = 100;

    /** 单簇点数上限（与 {@code KI_CUT_MAX_POINTS} 一致）。 */
    private static final int MAX_POINTS = 32;
    /** 采样格点上限（与 {@code KI_CUT_SPAN_MAX} 一致；冷值 0~255，跨度 ≤ 256）。 */
    private static final int SPAN_MAX = 256;

    /** 一个控制点：冷值（档位）+ 升倍率 + 降倍率（升/降均为 ×100 口径）。 */
    public static final class Point {
        public final int cold;
        public final int up;
        public final int dn;

        public Point(int cold, int up, int dn) {
            this.cold = cold;
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
     * 一行文本 → 一个簇：按非数字分隔取出整数，每三个一组（冷值,升,降）；末尾不足三个的整组丢弃。
     * 空串 / 无数字 → 空簇。
     */
    @NonNull
    public static Cluster parseLine(@NonNull String line) {
        List<Integer> nums = parseInts(line);
        Cluster cluster = new Cluster();
        for (int i = 0; i + 3 <= nums.size(); i += 3) {
            cluster.points.add(new Point(nums.get(i), nums.get(i + 1), nums.get(i + 2)));
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

    /** 一个簇 → 一行落盘文本（`冷值,升,降,…`）。 */
    @NonNull
    public static String formatRow(@NonNull Cluster cluster) {
        StringBuilder sb = new StringBuilder();
        for (Point p : cluster.points) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(p.cold).append(',').append(p.up).append(',').append(p.dn);
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
    public static float[] evaluate(@NonNull List<Cluster> clusters, int cold, int smooth) {
        float up = NEUTRAL;
        float dn = NEUTRAL;
        boolean used = false;
        for (Cluster cluster : clusters) {
            if (cluster.isEmpty()) {
                continue;
            }
            Curve curve = Curve.of(cluster, smooth);
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
     * @param up true = 升倍率那条，false = 降倍率那条
     */
    @NonNull
    public static float[] minCurve(@NonNull List<Cluster> clusters, int smooth, int xMax,
                                   boolean up) {
        List<Curve> curves = new ArrayList<>();
        for (Cluster cluster : clusters) {
            if (!cluster.isEmpty()) {
                curves.add(Curve.of(cluster, smooth));
            }
        }
        float[] out = new float[Math.max(0, xMax) + 1];
        for (int x = 0; x < out.length; x++) {
            float v = NEUTRAL;
            boolean used = false;
            for (Curve curve : curves) {
                float cv = up ? curve.up(x) : curve.dn(x);
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
     * <p><b>零分配护栏</b>：折线分支（含跨度越界 / smooth 关 / 单点）<b>不按跨度分配数组</b>，只保留
     * 排好序的 {@link Point}[]，在 {@link #up(int)}/{@link #dn(int)} 里按需插值；只有平滑分支预计算
     * 数组，且分配前必须被跨度上界 {@link #SPAN_MAX} 挡住。冷值被改成极值（如 ±2e9）时跨度会溢出
     * 甚至为负，护栏一律退回折线、绝不分配，避免 OOM / NegativeArraySizeException。
     */
    private static final class Curve {

        /** 排序去重后的控制点（长度 = 去重后点数）。 */
        private final Point[] pts;
        private final int n;
        private final int xMin;
        /** 平滑分支预计算的整条曲线（长度 = span）；折线分支为 null（按需插值、零分配）。 */
        private final float[] upArr;
        private final float[] dnArr;

        private Curve(Point[] pts, int n, float[] upArr, float[] dnArr) {
            this.pts = pts;
            this.n = n;
            this.xMin = pts[0].cold;
            this.upArr = upArr;
            this.dnArr = dnArr;
        }

        static Curve of(@NonNull Cluster cluster, int smooth) {
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
            n = m;
            int xMin = pts[0].cold;
            int xMax = pts[n - 1].cold;
            // 跨度护栏：仅当落在 [1, SPAN_MAX] 内才走预计算平滑分支；越界 / 溢出（含为负）一律退回折线
            long spanL = (long) xMax - (long) xMin + 1L;
            boolean smoothing = n >= 2 && smooth > 0 && smooth < 100
                    && spanL >= 1L && spanL <= SPAN_MAX;
            if (!smoothing) {
                return new Curve(pts, n, null, null);
            }
            int span = (int) spanL;
            return new Curve(pts, n, build(pts, n, xMin, span, 0, smooth),
                    build(pts, n, xMin, span, 1, smooth));
        }

        /** 取 {@code x} 处的值：平滑分支查预计算数组（范围外平推）；折线分支按需插值（零分配）。 */
        float up(int x) {
            return valueAt(x, 0);
        }

        float dn(int x) {
            return valueAt(x, 1);
        }

        private float valueAt(int x, int axis) {
            float[] arr = axis != 0 ? dnArr : upArr;
            if (arr == null) {
                return lerp(pts, n, x, axis);
            }
            long idx = (long) x - (long) xMin;
            if (idx < 0L) {
                idx = 0L;
            } else if (idx > arr.length - 1L) {
                idx = arr.length - 1L;
            }
            return arr[(int) idx];
        }

        /** 在整数格上产出整条曲线（长度 = span）。{@code axis}：0=升，1=降。仅平滑分支调用。 */
        private static float[] build(Point[] pts, int n, int xMin, int span, int axis, int smoothPct) {
            float[] s = new float[span];
            for (int k = 0; k < span; k++) {
                s[k] = lerp(pts, n, xMin + k, axis);
            }
            float a = smoothPct / 100f;
            float[] f = new float[span];
            f[0] = s[0];
            for (int k = 1; k < span; k++) {
                f[k] = a * s[k] + (1f - a) * f[k - 1];
            }
            float[] b = new float[span];
            b[span - 1] = f[span - 1];
            for (int k = span - 2; k >= 0; k--) {
                b[k] = a * f[k] + (1f - a) * b[k + 1];
            }
            // 控制点残差 r_i = y_i − B(x_i)；网格上相邻控制点间线性回补（两端外取端值残差）
            float[] residual = new float[n];
            for (int i = 0; i < n; i++) {
                residual[i] = value(pts[i], axis) - b[pts[i].cold - xMin];
            }
            float[] out = new float[span];
            for (int k = 0; k < span; k++) {
                out[k] = b[k] + lerpResidual(pts, n, residual, xMin + k);
            }
            return out;
        }

        /** 折线取值：{@code x} 在两端外取端点值，其间按相邻控制点线性插值。 */
        private static float lerp(Point[] pts, int n, int x, int axis) {
            if (x <= pts[0].cold) {
                return value(pts[0], axis);
            }
            if (x >= pts[n - 1].cold) {
                return value(pts[n - 1], axis);
            }
            for (int i = 1; i < n; i++) {
                if (x <= pts[i].cold) {
                    float t = (float) (x - pts[i - 1].cold) / (float) (pts[i].cold - pts[i - 1].cold);
                    float y0 = value(pts[i - 1], axis);
                    return y0 + t * (value(pts[i], axis) - y0);
                }
            }
            return value(pts[n - 1], axis);
        }

        /** 控制点残差的线性回补：{@code x} 在两端外取端点残差。 */
        private static float lerpResidual(Point[] pts, int n, float[] residual, int x) {
            if (x <= pts[0].cold) {
                return residual[0];
            }
            if (x >= pts[n - 1].cold) {
                return residual[n - 1];
            }
            for (int i = 1; i < n; i++) {
                if (x <= pts[i].cold) {
                    float t = (float) (x - pts[i - 1].cold) / (float) (pts[i].cold - pts[i - 1].cold);
                    float r0 = residual[i - 1];
                    return r0 + t * (residual[i] - r0);
                }
            }
            return residual[n - 1];
        }

        private static float value(Point p, int axis) {
            return axis != 0 ? p.dn : p.up;
        }
    }
}
