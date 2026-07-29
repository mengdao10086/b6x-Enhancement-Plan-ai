package com.blankj.utilcode.util;

import android.os.Vibrator;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Vibrator f11937a;

    public m1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @g.y0("android.permission.VIBRATE")
    public static void a() {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.cancel();
    }

    public static Vibrator b() {
        if (f11937a == null) {
            f11937a = (Vibrator) j1.a().getSystemService("vibrator");
        }
        return f11937a;
    }

    @g.y0("android.permission.VIBRATE")
    public static void c(long j10) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(j10);
    }

    @g.y0("android.permission.VIBRATE")
    public static void d(long[] jArr, int i10) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(jArr, i10);
    }
}
