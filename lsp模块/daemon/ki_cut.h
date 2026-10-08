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
 *   1. 簇内点按冷值升序；同一冷值保留**先出现者**。
 *   2. 折线 L(x)：簇内相邻点线性插值，低于最小冷值取首点值、高于最大冷值取末点值（两端平推）。
 *   3. 每点三轴：KDP 倍率 / 升倍率 / 降倍率，各自独立按折线求值（**无滤波**）。
 *   4. 多簇逐轴取**最小**倍率（倍率更小 = 削减更大）；无有效簇 → KI_CUT_NONE。
 * 倍率口径：×100（100 = 不削，0 = 完全压死）。
 */
#ifndef KI_CUT_H
#define KI_CUT_H

#define KI_CUT_MAX_POINTS 32   /* 单簇最多配置点数（去重后） */
#define KI_CUT_NONE       100  /* 无有效簇时的倍率（×100 = 不削） */

/* 一个配置点：冷值 + KDP / 升 / 降三轴倍率（均 ×100，0~200） */
typedef struct {
    int cold;
    int kdp;
    int up;
    int dn;
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

/** 折线取值：x ≤ 首点冷值取首点、x ≥ 末点冷值取末点、其间线性插值。axis: 0=kdp 1=up 2=dn */
static float ki_cut_lerp(const KiCutPoint *p, int n, int x, int axis) {
    if (x <= p[0].cold)     return (float)ki_cut_pick(&p[0], axis);
    if (x >= p[n - 1].cold) return (float)ki_cut_pick(&p[n - 1], axis);
    for (int i = 1; i < n; i++) {
        if (x <= p[i].cold) {
            float t = (float)(x - p[i - 1].cold) / (float)(p[i].cold - p[i - 1].cold);
            float y0 = (float)ki_cut_pick(&p[i - 1], axis);
            float y1 = (float)ki_cut_pick(&p[i], axis);
            return y0 + t * (y1 - y0);
        }
    }
    return (float)ki_cut_pick(&p[n - 1], axis);
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
 * 单簇求值。三轴各自按折线求值（无滤波）。n < 1 视为无效，返回 0（不改输出）；
 * 否则返回 1 并写入该簇的 KDP / 升 / 降倍率（×100）。单点簇整簇恒为该点值。
 */
static int ki_cut_cluster_eval(const KiCutPoint *in, int n, int cold,
                               float *kdp, float *up, float *dn) {
    if (n < 1) return 0;
    if (n > KI_CUT_MAX_POINTS) n = KI_CUT_MAX_POINTS;

    KiCutPoint pts[KI_CUT_MAX_POINTS];
    for (int i = 0; i < n; i++) pts[i] = in[i];
    n = ki_cut_normalize(pts, n);

    *kdp = ki_cut_lerp(pts, n, cold, 0);
    *up  = ki_cut_lerp(pts, n, cold, 1);
    *dn  = ki_cut_lerp(pts, n, cold, 2);
    return 1;
}

/**
 * 多簇求值：各簇分别求值后逐轴取**最小**倍率（倍率小 = 削减大）。无有效簇 → 三轴均 KI_CUT_NONE。
 * 返回有效簇数。
 */
static int ki_cut_eval(const KiCutCluster *cs, int ncl, int cold,
                       float *kdp, float *up, float *dn) {
    float mk = (float)KI_CUT_NONE, mu = (float)KI_CUT_NONE, md = (float)KI_CUT_NONE;
    int used = 0;
    for (int i = 0; i < ncl; i++) {
        float ck, cu, cd;
        if (!ki_cut_cluster_eval(cs[i].pts, cs[i].n, cold, &ck, &cu, &cd)) continue;
        if (used == 0 || ck < mk) mk = ck;
        if (used == 0 || cu < mu) mu = cu;
        if (used == 0 || cd < md) md = cd;
        used++;
    }
    *kdp = mk;
    *up  = mu;
    *dn  = md;
    return used;
}

#endif  /* KI_CUT_H */
