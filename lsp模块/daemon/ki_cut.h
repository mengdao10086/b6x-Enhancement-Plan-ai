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
 *   4. 多簇逐轴取**离各簇候选平均值最近**的那一簇的值（「重合」处不再一律取最小）；并列取更小倍率
 *      （与旧「取最小」在 2 簇时逐位一致）；无有效簇 → KI_CUT_NONE。
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
 * 等距判定容差：`|d1-d2|` 落在浮点舍入噪声内即视为等距。
 * 必要性见「两簇恒等距」：2 簇时两候选到均值数学上等距，但 float32 下 `m-v1` 与 `v2-m` 各自舍入，
 * 差值可达 ~几 ulp（实测 1.9e-6），精确比较会**反过来选中较大值**。eps=1e-3 远超该噪声（值域 0~200，
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

/**
 * 多簇求值：各簇分别求值后，逐轴取**离各簇候选平均值最近**的那一簇的值（「重合」处不再一律取最小）；
 * 等距取更小倍率。无有效簇 → 三轴均 KI_CUT_NONE。返回有效簇数。
 */
static int ki_cut_eval(const KiCutCluster *cs, int ncl, int cold,
                       float *kdp, float *up, float *dn) {
    // 第一遍：各轴候选之和与簇数（求平均值）
    float sk = 0.0f, su = 0.0f, sd = 0.0f;
    int used = 0;
    for (int i = 0; i < ncl; i++) {
        float ck, cu, cd;
        if (!ki_cut_cluster_eval(cs[i].pts, cs[i].n, cold, &ck, &cu, &cd)) continue;
        sk += ck; su += cu; sd += cd;
        used++;
    }
    if (used == 0) {
        *kdp = (float)KI_CUT_NONE;
        *up  = (float)KI_CUT_NONE;
        *dn  = (float)KI_CUT_NONE;
        return 0;
    }
    float mk = sk / (float)used, mu = su / (float)used, md = sd / (float)used;
    // 第二遍：逐轴取离均值最近者（等距取更小）
    float bk = 0.0f, bu = 0.0f, bd = 0.0f;
    int first = 1;
    for (int i = 0; i < ncl; i++) {
        float ck, cu, cd;
        if (!ki_cut_cluster_eval(cs[i].pts, cs[i].n, cold, &ck, &cu, &cd)) continue;
        if (first) { bk = ck; bu = cu; bd = cd; first = 0; continue; }
        bk = ki_cut_nearer(bk, ck, mk);
        bu = ki_cut_nearer(bu, cu, mu);
        bd = ki_cut_nearer(bd, cd, md);
    }
    *kdp = bk;
    *up  = bu;
    *dn  = bd;
    return used;
}

#endif  /* KI_CUT_H */
