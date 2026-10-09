/* ================================================================
 * ki_cut.h — 「PID 分段倍率表」求值算法（无外部依赖，纯 C）
 * ================================================================
 *
 * 定位：本头是求值算法的**唯一实现处**，被两处共用——
 *   · tempctrl.c（守护进程，NDK 编译）；
 *   · 参数定义/check_params.py 在 CI 上现写现编的对拍程序（host gcc），
 *     用 参数定义/ki_cut_golden.json 的期望值校验本实现（跨端一致性对拍）。
 * 因两处共用，本头不 include 任何头文件、不依赖 libc/libm（只用四则运算与 float）。
 *
 * 算法（与 参数定义/params.def.json 的 PID_CUT 定义、逻辑说明.md 同源）：
 *   1. 点按冷值升序；同一冷值保留**先出现者**。
 *   2. 每点三轴独立：KDP 倍率 / 升倍率 / 降倍率。某轴标记为「留空」（skip 位）时，该点在该轴上
 *      **不作为控制点**——从该轴的控制点序列中剔除，折线由相邻的两个未留空控制点直接连线。
 *   3. 折线 L(x)（逐轴）：在该轴控制点序列内相邻点线性插值；x ≤ 该轴最小冷值取首点、x ≥ 最大冷值
 *      取末点（两端平推）；该轴一个控制点都没有 → 该轴恒为 KI_CUT_NONE（100 = 不削）。
 *   4. 多簇**逐轴独立**：先取该轴上各簇「有效控制点覆盖范围」的并集区间；参照值 M ＝ 该区间内、
 *      各簇在**自身覆盖范围**内所有整数冷值处候选值的总体平均（每个整数冷值算一次、无候选处不计）。
 *      对每个冷值取候选里 |v-M| 最小者；并列（含浮点舍入噪声）取更小倍率。该轴只有 1 个候选时直通
 *      （不受 M 影响）。某簇在该轴上全留空 = 无候选，不参与 M 也不进入取舍；该轴无任何候选 → KI_CUT_NONE。
 * 倍率口径：×100（100 = 不削，0 = 完全压死）。
 */
#ifndef KI_CUT_H
#define KI_CUT_H

#define KI_CUT_MAX_POINTS 32   /* 单簇最多配置点数（去重后） */
#define KI_CUT_NONE       100  /* 无有效簇时的倍率（×100 = 不削） */

/* 该点在某轴上「留空」（不作为控制点）的标记位；KDP / 升 / 降各一位 */
#define KI_CUT_SKIP_KDP 1u
#define KI_CUT_SKIP_UP  2u
#define KI_CUT_SKIP_DN  4u

/* 一个配置点：冷值 + KDP / 升 / 降三轴倍率（均 ×100，0~200）+ 各轴留空标记 */
typedef struct {
    int cold;
    int kdp;
    int up;
    int dn;
    unsigned char skip;   /* KI_CUT_SKIP_* 的按位或；0 = 三轴都作为控制点 */
} KiCutPoint;

/* 一个簇：点数 + 点数组（求值内部会复制并按冷值排序，不改动入参） */
typedef struct {
    const KiCutPoint *pts;
    int n;
} KiCutCluster;

/** 取某轴的值：axis 0=kdp 1=up 2=dn */
static int ki_cut_pick(const KiCutPoint *p, int axis) {
    return (axis == 0) ? p->kdp : (axis == 1 ? p->up : p->dn);
}

/** 某点在某轴上是否「留空」（不作为控制点）：axis 0=kdp 1=up 2=dn */
static int ki_cut_is_skipped(const KiCutPoint *p, int axis) {
    unsigned char bit = (axis == 0) ? KI_CUT_SKIP_KDP
                                    : (axis == 1 ? KI_CUT_SKIP_UP : KI_CUT_SKIP_DN);
    return (p->skip & bit) != 0;
}

/**
 * 折线取值：在该轴**未留空**的控制点序列内，x ≤ 首点冷值取首点、x ≥ 末点冷值取末点、其间线性插值。
 * 该轴无任何控制点（全部留空）→ 返回 KI_CUT_NONE（不削）。axis: 0=kdp 1=up 2=dn
 */
static float ki_cut_lerp(const KiCutPoint *p, int n, int x, int axis) {
    int first = -1, last = -1;
    for (int i = 0; i < n; i++) {
        if (ki_cut_is_skipped(&p[i], axis)) continue;
        if (first < 0) first = i;
        last = i;
    }
    if (first < 0) return (float)KI_CUT_NONE;                  /* 该轴无控制点：全程不削 */
    if (x <= p[first].cold) return (float)ki_cut_pick(&p[first], axis);
    if (x >= p[last].cold)  return (float)ki_cut_pick(&p[last], axis);
    int prev = first;
    for (int i = first + 1; i <= last; i++) {
        if (ki_cut_is_skipped(&p[i], axis)) continue;
        if (x <= p[i].cold) {
            float t = (float)(x - p[prev].cold) / (float)(p[i].cold - p[prev].cold);
            float y0 = (float)ki_cut_pick(&p[prev], axis);
            float y1 = (float)ki_cut_pick(&p[i], axis);
            return y0 + t * (y1 - y0);
        }
        prev = i;
    }
    return (float)ki_cut_pick(&p[last], axis);                 /* 理论不可达（x 已在 [first,last] 内） */
}

/** 就地规范化：稳定升序排序（同冷值保持原始先后），同一冷值只保留先出现者。返回去重后点数 */
static int ki_cut_normalize(KiCutPoint *p, int n) {
    for (int i = 1; i < n; i++) {           /* 稳定插入排序 */
        KiCutPoint key = p[i];
        int j = i - 1;
        while (j >= 0 && p[j].cold > key.cold) { p[j + 1] = p[j]; j--; }
        p[j + 1] = key;
    }
    int m = 0;
    for (int i = 0; i < n; i++) {
        if (m > 0 && p[i].cold == p[m - 1].cold) continue;   /* 同冷值：保留先出现者 */
        p[m++] = p[i];
    }
    return m;
}

/**
 * 等距判定容差：`|d1-d2|` 落在浮点舍入噪声内即视为等距。float32 下两候选到同一参照值 M 的距离
 * 可达数 ulp 偏差，精确比较会漏判而**反过来选中较大倍率**；eps=1e-3 远超该噪声（值域 0~200、
 * 舍入误差 ≤ ~1e-4）、又远小于任何有意义的倍率差（判据容差 0.05）。
 */
#define KI_CUT_TIE_EPS 1.0e-3f

/**
 * 取「离 target 更近」者；**等距（含浮点舍入噪声）时取「更小」倍率**（= 更保守、削减更大）。
 * 两条相加/相减顺序固定，保证与 Java 镜像逐位一致。
 */
static float ki_cut_nearer(float cur, float cand, float target) {
    float dc = cur  - target; if (dc < 0.0f) dc = -dc;
    float dn = cand - target; if (dn < 0.0f) dn = -dn;
    float diff = (dc > dn) ? (dc - dn) : (dn - dc);
    if (diff <= KI_CUT_TIE_EPS) return (cand < cur) ? cand : cur;   // 等距（含舍入）→ 取更小
    return (dn < dc) ? cand : cur;
}

/** 该轴上「未留空控制点」的首/末下标。无控制点（全留空）→ 返回 0（该轴无候选）；否则返回 1 并写出 first/last。 */
static int ki_cut_axis_span(const KiCutPoint *p, int n, int axis, int *first, int *last) {
    int f = -1, l = -1;
    for (int i = 0; i < n; i++) {
        if (ki_cut_is_skipped(&p[i], axis)) continue;
        if (f < 0) f = i;
        l = i;
    }
    if (f < 0) return 0;
    *first = f; *last = l;
    return 1;
}

/**
 * 该轴在**自身覆盖区间**（首/末未留空控制点冷值之间）内所有整数冷值上候选值之和，及整数冷值个数。
 * 折线在整数冷值上求和用梯形公式（对线性段精确）：Σ_{a..b} 线性值 = (b-a+1)·(v_a+v_b)/2，段间公共端点
 * 减去一次。**不按跨度迭代**——冷值被写成极值（如 ±2e9）时也不会退化成 O(span) 死循环。
 */
static void ki_cut_axis_intra(const KiCutPoint *p, int n, int axis,
                              float *out_sum, float *out_cnt) {
    int idx[KI_CUT_MAX_POINTS];
    int m = 0;
    for (int i = 0; i < n; i++)
        if (!ki_cut_is_skipped(&p[i], axis)) idx[m++] = i;
    float lo = (float)p[idx[0]].cold;
    float hi = (float)p[idx[m - 1]].cold;
    *out_cnt = hi - lo + 1.0f;
    if (m == 1) { *out_sum = (float)ki_cut_pick(&p[idx[0]], axis); return; }
    float s = 0.0f;
    for (int j = 0; j + 1 < m; j++) {
        float ca = (float)p[idx[j]].cold,     cb = (float)p[idx[j + 1]].cold;
        float va = (float)ki_cut_pick(&p[idx[j]], axis);
        float vb = (float)ki_cut_pick(&p[idx[j + 1]], axis);
        s += (cb - ca + 1.0f) * (va + vb) / 2.0f;
    }
    for (int j = 1; j + 1 < m; j++) s -= (float)ki_cut_pick(&p[idx[j]], axis);
    *out_sum = s;
}

/**
 * 单轴多簇求值。参照值 M ＝ 各参评簇（该轴有控制点的簇）**自身覆盖区间**内整数冷值候选值的总体
 * 平均（无候选处不计；全留空簇不参评）。逐冷值取候选里离 M 最近者（并列取更小）；只有一个候选时
 * 恒取它（= 直通，与 M 无关）；无候选簇 → KI_CUT_NONE。float32 运算顺序固定，与 Java 镜像逐位一致。
 */
static float ki_cut_axis_eval(const KiCutCluster *cs, int ncl, int cold, int axis) {
    float num = 0.0f, cnt = 0.0f;   // M 的分子/分母：各参评簇覆盖区间内候选值总和 / 整数冷值总数
    int np = 0;
    for (int i = 0; i < ncl; i++) {
        int n = cs[i].n;
        if (n < 1) continue;
        if (n > KI_CUT_MAX_POINTS) n = KI_CUT_MAX_POINTS;
        KiCutPoint pts[KI_CUT_MAX_POINTS];
        for (int k = 0; k < n; k++) pts[k] = cs[i].pts[k];
        n = ki_cut_normalize(pts, n);
        int first, last;
        if (!ki_cut_axis_span(pts, n, axis, &first, &last)) continue;   // 该轴全留空：无候选，不参评
        float s, c;
        ki_cut_axis_intra(pts, n, axis, &s, &c);
        num += s; cnt += c; np++;
    }
    if (np == 0) return (float)KI_CUT_NONE;
    float m = num / cnt;
    float best = 0.0f;
    int first_cand = 1;
    for (int i = 0; i < ncl; i++) {
        int n = cs[i].n;
        if (n < 1) continue;
        if (n > KI_CUT_MAX_POINTS) n = KI_CUT_MAX_POINTS;
        KiCutPoint pts[KI_CUT_MAX_POINTS];
        for (int k = 0; k < n; k++) pts[k] = cs[i].pts[k];
        n = ki_cut_normalize(pts, n);
        int first, last;
        if (!ki_cut_axis_span(pts, n, axis, &first, &last)) continue;
        float v = ki_cut_lerp(pts, n, cold, axis);
        if (first_cand) { best = v; first_cand = 0; continue; }
        best = ki_cut_nearer(best, v, m);
    }
    return best;
}

/**
 * 多簇求值：三轴各自按 ki_cut_axis_eval 求值（逐轴独立）。返回**非空簇数**（供诊断日志的「簇=N」）。
 * 无任何非空簇 → 三轴均 KI_CUT_NONE。
 */
static int ki_cut_eval(const KiCutCluster *cs, int ncl, int cold,
                       float *kdp, float *up, float *dn) {
    int used = 0;
    for (int i = 0; i < ncl; i++) if (cs[i].n >= 1) used++;
    *kdp = ki_cut_axis_eval(cs, ncl, cold, 0);
    *up  = ki_cut_axis_eval(cs, ncl, cold, 1);
    *dn  = ki_cut_axis_eval(cs, ncl, cold, 2);
    return used;
}

#endif  /* KI_CUT_H */
