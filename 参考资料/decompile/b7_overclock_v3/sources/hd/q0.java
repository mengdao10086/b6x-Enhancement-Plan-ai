package hd;

import android.os.Trace;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    public static void a(String str) {
        if (u0.f31154a >= 18) {
            b(str);
        }
    }

    @g.v0(18)
    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (u0.f31154a >= 18) {
            d();
        }
    }

    @g.v0(18)
    public static void d() {
        Trace.endSection();
    }
}
