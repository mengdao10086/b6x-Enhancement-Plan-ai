package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v5 f7658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final PorterDuff.Mode f3232a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d8 f3233a;

    public static synchronized v5 b() {
        if (f7658a == null) {
            h();
        }
        return f7658a;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return d8.l(i, mode);
    }

    public static synchronized void h() {
        if (f7658a == null) {
            v5 v5Var = new v5();
            f7658a = v5Var;
            v5Var.f3233a = d8.h();
            f7658a.f3233a.u(new u5());
        }
    }

    public static void i(Drawable drawable, m8 m8Var, int[] iArr) {
        d8.w(drawable, m8Var, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.f3233a.j(context, i);
    }

    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.f3233a.k(context, i, z);
    }

    public synchronized ColorStateList f(Context context, int i) {
        return this.f3233a.m(context, i);
    }

    public synchronized void g(Context context) {
        this.f3233a.s(context);
    }
}
