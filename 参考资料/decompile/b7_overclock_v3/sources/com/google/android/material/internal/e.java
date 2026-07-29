package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.core.view.f1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20414a = 128;

    public static void a(@n0 Window window, boolean z10) {
        b(window, z10, null, null);
    }

    public static void b(@n0 Window window, boolean z10, @g.l @p0 Integer num, @g.l @p0 Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int iB = vd.m.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(iB);
            }
            if (z12) {
                num2 = Integer.valueOf(iB);
            }
        }
        f1.c(window, !z10);
        int iD = d(window.getContext(), z10);
        int iC = c(window.getContext(), z10);
        window.setStatusBarColor(iD);
        window.setNavigationBarColor(iC);
        g(window, e(iD, vd.m.l(num.intValue())));
        f(window, e(iC, vd.m.l(num2.intValue())));
    }

    @TargetApi(21)
    public static int c(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 27) {
            return m0.g.B(vd.m.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return vd.m.b(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(21)
    public static int d(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 23) {
            return m0.g.B(vd.m.b(context, R.attr.statusBarColor, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return vd.m.b(context, R.attr.statusBarColor, -16777216);
    }

    public static boolean e(int i10, boolean z10) {
        return vd.m.l(i10) || (i10 == 0 && z10);
    }

    public static void f(@n0 Window window, boolean z10) {
        f1.a(window, window.getDecorView()).h(z10);
    }

    public static void g(@n0 Window window, boolean z10) {
        f1.a(window, window.getDecorView()).i(z10);
    }
}
