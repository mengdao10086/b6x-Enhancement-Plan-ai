/* ================================================================
 * ki_cut.h — 「KI 分段倍率表」求值算法（无外部依赖，纯 C）
 * ================================================================
 *
 * 定位：本头是求值算法的**唯一实现处**，被两处共用——
 *   · tempctrl.c（守护进程，NDK 编译）；
 *   · 参数定义/check_params.py 在 CI 上现写现编的对拍程序（host gcc），
 *     用 参数定义/ki_cut_golden.json 的期望值校验本实现（跨端一致性对拍）。
 * 因两处共用，本头不 include 任何头文件、不依赖 libc/libm（只用四则运算与 float）。
 *
 * 算法（与 参数定义/params.def.json 的 KI_CUT / KI_CUT_SMOOTH 定义、逻辑说明.md 同源）：
 *   1. 簇内点按冷值升序；同一冷值保留**先出现者**。
 *   2. 折线 L(x)：簇内相邻点线性插值，低于最小冷值取首点值、高于最大冷值取末点值（两端平推）。
 *   3. 平滑（smooth ∉ {0,100} 且簇内点数 ≥ 2）：在 [xmin,xmax] 整数格点上采样 L，
 *      正向 EMA 一遍 → 反向 EMA 一遍（零相位）；再按配置点残差线性回补，
 *      保证每个配置点上严格取回原值。单点簇整簇恒为该点值。
 *   4. 多簇取**最小**倍率（倍率更小 = 削减更大）；无有效簇 → KI_CUT_NONE。
 * 倍率口径：×100（100 = 不削，0 = 完全压死）。
 */
#ifndef KI_CUT_H
#define KI_CUT_H

#define KI_CUT_MAX_POINTS 32   /* 单簇最多配置点数（去重后） */
#define KI_CUT_SPAN_MAX   256  /* 采样格点上限（冷值 0~255，跨度 ≤ 256） */
#define KI_CUT_NONE       100  /* 无有效簇时的倍率（×100 = 不削） */

/* 一个配置点：冷值 + 该点的升/降倍率（均 ×100，0~200） */
typedef struct {
    int cold;
    int up;
    int dn;
} KiCutPoint;

/* 一个簇：点数 + 点数组（求值内部会复制并按冷值排序，不改动入参） */
typedef struct {
    const KiCutPoint *pts;
    int n;
} KiCutCluster;

/** 折线取值：x ≤ 首点冷值取首点、x ≥ 末点冷值取末点、其间线性插值。axis: 0=up 1=dn */
static float ki_cut_lerp(const KiCutPoint *p, int n, int x, int axis) {
    int ax = axis ? 1 : 0;
    if (x <= p[0].cold)        return (float)(ax ? p[0].dn : p[0].up);
    if (x >= p[n - 1].cold)    return (float)(ax ? p[n - 1].dn : p[n - 1].up);
    for (int i = 1; i < n; i++) {
        if (x <= p[i].cold) {
            float t = (float)(x - p[i - 1].cold) / (float)(p[i].cold - p[i - 1].cold);
            float y0 = (float)(ax ? p[i - 1].dn : p[i - 1].up);
            float y1 = (float)(ax ? p[i].dn : p[i].up);
            return y0 + t * (y1 - y0);
        }
    }
    return (float)(ax ? p[n - 1].dn : p[n - 1].up);
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

/** 平滑后单轴取值：零相位双向 EMA + 配置点残差线性回补（配置点上严格取回原值） */
static float ki_cut_smooth_axis(const KiCutPoint *p, int n, int smooth, int x, int axis) {
    int ax  = axis ? 1 : 0;
    int xmin = p[0].cold, xmax = p[n - 1].cold;
    int span = xmax - xmin + 1;
    float L[KI_CUT_SPAN_MAX], F[KI_CUT_SPAN_MAX], B[KI_CUT_SPAN_MAX], R[KI_CUT_SPAN_MAX];

    for (int k = 0; k < span; k++) L[k] = ki_cut_lerp(p, n, xmin + k, axis);

    float a = (float)smooth / 100.0f;
    F[0] = L[0];                                       /* 正向 EMA */
    for (int k = 1; k < span; k++)          F[k] = a * L[k] + (1.0f - a) * F[k - 1];
    B[span - 1] = F[span - 1];                         /* 反向 EMA（零相位） */
    for (int k = span - 2; k >= 0; k--)     B[k] = a * F[k] + (1.0f - a) * B[k + 1];

    /* 残差 r_i = y_i − B(x_i)，网格上相邻配置点间线性回补（两端外取端值残差） */
    int ci = 1;
    for (int k = 0; k < span; k++) {
        int gx = xmin + k;
        float r;
        if (gx <= p[0].cold) {
            r = (float)(ax ? p[0].dn : p[0].up) - B[0];
        } else if (gx >= p[n - 1].cold) {
            r = (float)(ax ? p[n - 1].dn : p[n - 1].up) - B[span - 1];
        } else {
            while (ci < n - 1 && gx > p[ci].cold) ci++;
            float t  = (float)(gx - p[ci - 1].cold) / (float)(p[ci].cold - p[ci - 1].cold);
            float r0 = (float)(ax ? p[ci - 1].dn : p[ci - 1].up) - B[p[ci - 1].cold - xmin];
            float r1 = (float)(ax ? p[ci].dn : p[ci].up) - B[p[ci].cold - xmin];
            r = r0 + t * (r1 - r0);
        }
        R[k] = r;
    }

    int idx = (x < xmin) ? 0 : (x > xmax ? span - 1 : x - xmin);   /* 范围外平推到端值 */
    return B[idx] + R[idx];
}

/**
 * 单簇求值。smooth ∈ [0,100]，0 或 100 = 关闭平滑（直接取折线值）。
 * n < 1 视为无效，返回 0（不改 *up/*dn）；否则返回 1 并写入该簇的升/降倍率（×100）。
 */
static int ki_cut_cluster_eval(const KiCutPoint *in, int n, int smooth, int cold,
                               float *up, float *dn) {
    if (n < 1) return 0;
    if (n > KI_CUT_MAX_POINTS) n = KI_CUT_MAX_POINTS;

    KiCutPoint pts[KI_CUT_MAX_POINTS];
    for (int i = 0; i < n; i++) pts[i] = in[i];
    n = ki_cut_normalize(pts, n);

    int xmin = pts[0].cold, xmax = pts[n - 1].cold;
    if (n == 1 || smooth <= 0 || smooth >= 100 || xmax - xmin + 1 > KI_CUT_SPAN_MAX) {
        *up = ki_cut_lerp(pts, n, cold, 0);      /* 单点：整簇恒定；其余：折线 */
        *dn = ki_cut_lerp(pts, n, cold, 1);
        return 1;
    }
    *up = ki_cut_smooth_axis(pts, n, smooth, cold, 0);
    *dn = ki_cut_smooth_axis(pts, n, smooth, cold, 1);
    return 1;
}

/**
 * 多簇求值：各簇分别求值后取**最小**倍率（倍率小 = 削减大）。无有效簇 → *up = *dn = KI_CUT_NONE。
 * 返回有效簇数。
 */
static int ki_cut_eval(const KiCutCluster *cs, int ncl, int smooth, int cold,
                       float *up, float *dn) {
    float mu = (float)KI_CUT_NONE, md = (float)KI_CUT_NONE;
    int used = 0;
    for (int i = 0; i < ncl; i++) {
        float cu, cd;
        if (!ki_cut_cluster_eval(cs[i].pts, cs[i].n, smooth, cold, &cu, &cd)) continue;
        if (used == 0 || cu < mu) mu = cu;
        if (used == 0 || cd < md) md = cd;
        used++;
    }
    *up = mu;
    *dn = md;
    return used;
}

#endif  /* KI_CUT_H */
