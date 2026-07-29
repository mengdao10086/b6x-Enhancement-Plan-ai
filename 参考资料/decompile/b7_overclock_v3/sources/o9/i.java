package o9;

import hk.m;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final int A = 40;
    public static final int B = 41;
    public static final int C = 42;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final i f42975a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42976b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42977c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42978d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42979e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42980f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42981g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f42982h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f42983i = 15;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f42984j = 20;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f42985k = 21;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f42986l = 22;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f42987m = 23;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f42988n = 24;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f42989o = 25;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f42990p = 26;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f42991q = 27;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f42992r = 30;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f42993s = 31;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f42994t = 32;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f42995u = 33;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f42996v = 34;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f42997w = 35;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f42998x = 36;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f42999y = 50;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f43000z = 51;

    @m
    public static final int a(int i10) {
        if (i10 == 11) {
            return 5;
        }
        if (i10 == 15) {
            return 15;
        }
        if (i10 == 32) {
            return 32;
        }
        switch (i10) {
            case 2:
                return 33;
            case 3:
                return 11;
            case 4:
                return 31;
            case 5:
                return 20;
            case 6:
                return 21;
            case 7:
                return 22;
            case 8:
                return 23;
            default:
                switch (i10) {
                    case 24:
                        return 24;
                    case 25:
                        return 25;
                    case 26:
                        return 26;
                    case 27:
                        return 27;
                    default:
                        switch (i10) {
                            case 34:
                                return 34;
                            case 35:
                                return 35;
                            case 36:
                                return 36;
                            default:
                                return 1;
                        }
                }
        }
    }

    @m
    public static final int b(int i10) {
        if (i10 == 1) {
            return 30;
        }
        if (i10 == 2) {
            return 4;
        }
        if (i10 == 3) {
            return 3;
        }
        if (i10 != 5) {
            return i10 != 7 ? -1 : 2;
        }
        return 7;
    }

    @m
    @k
    public static final String c(int i10, int i11) {
        if (i10 == 11) {
            return "上/下车键";
        }
        if (i10 == 15) {
            return "体感常开";
        }
        if (i10 == 32) {
            return "飞鼠";
        }
        if (i10 == 51) {
            return "一键双击";
        }
        if (i10 == 20) {
            return "锁定视野";
        }
        if (i10 == 21) {
            return "延长视野";
        }
        switch (i10) {
            case 1:
                return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 5 ? i11 != 7 ? "" : "极速点击" : "松开点击" : "MOBA攻击键" : "取消技能" : "连续点击" : "普通点击";
            case 2:
                return "划屏";
            case 3:
                return "体感视角";
            case 4:
                return "体感射击";
            case 5:
                return "左摇杆关联";
            case 6:
                return "右摇杆关联";
            case 7:
                return "智能摇杆关联";
            case 8:
                return "查看地图";
            default:
                switch (i10) {
                    case 24:
                        return "轮盘关联";
                    case 25:
                        return "查看地图（轮盘）";
                    case 26:
                        return "轮盘滑动";
                    case 27:
                        return "鼠标关联";
                    default:
                        switch (i10) {
                            case 34:
                                return "辅助射击";
                            case 35:
                                return "体感视野";
                            case 36:
                                return "飞鼠（按住触发）";
                            default:
                                return "";
                        }
                }
        }
    }
}
