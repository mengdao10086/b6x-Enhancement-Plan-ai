package com.android.motionelf.tools;

import com.blankj.utilcode.util.x0;
import com.flydigi.device_manager.ui.detail.waspwing.b6.t;
import o5.h;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11377b;

    public static int a() {
        b();
        return f11377b;
    }

    public static void b() {
        int i10;
        if (f11377b == 0 || f11376a == 0) {
            boolean zN = h.n();
            int iE = t.J7;
            if (zN) {
                i10 = t.J7;
                iE = 2242;
            } else if (h.q() || h.v() || h.z() || h.y() || h.x()) {
                i10 = 2280;
            } else if (h.s() || h.r()) {
                i10 = 2340;
            } else if (h.w() || h.u() || h.t()) {
                i10 = ge.e.f29293w;
                iE = 720;
            } else {
                int iG = x0.g();
                iE = x0.e();
                i10 = iG;
            }
            f11376a = Math.max(iE, i10);
            f11377b = Math.min(iE, i10);
        }
    }

    public static float c() {
        b();
        return f11376a / f11377b;
    }

    public static int d() {
        b();
        return f11376a;
    }
}
