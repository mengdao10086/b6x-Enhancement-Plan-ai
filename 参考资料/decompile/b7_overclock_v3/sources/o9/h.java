package o9;

import hk.m;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final h f42970a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42971b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42972c = 11;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42973d = 13;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42974e = 14;

    @m
    public static final int a(int i10) {
        if (i10 == 1) {
            return 10;
        }
        if (i10 == 2) {
            return 14;
        }
        if (i10 != 4) {
            return i10 != 6 ? 10 : 13;
        }
        return 11;
    }

    @m
    @k
    public static final String b(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 6 ? i10 != 11 ? "" : "固定摇杆模式" : "指向性模式" : "视角模式" : "按键模式" : "摇杆模式";
    }
}
