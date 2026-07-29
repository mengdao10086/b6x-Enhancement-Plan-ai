package com.blankj.utilcode.util;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w0 f12017a;

    public static String A(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.q(str);
    }

    public static String B(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return C(str, str2, m());
    }

    public static String C(@g.n0 String str, String str2, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.r(str, str2);
    }

    public static Set<String> D(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return E(str, m());
    }

    public static Set<String> E(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.s(str);
    }

    public static Set<String> F(@g.n0 String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return G(str, set, m());
    }

    public static Set<String> G(@g.n0 String str, Set<String> set, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.t(str, set);
    }

    public static void H(@g.n0 String str, float f10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        I(str, f10, m());
    }

    public static void I(@g.n0 String str, float f10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.v(str, f10);
    }

    public static void J(@g.n0 String str, float f10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        K(str, f10, z10, m());
    }

    public static void K(@g.n0 String str, float f10, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.w(str, f10, z10);
    }

    public static void L(@g.n0 String str, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        M(str, i10, m());
    }

    public static void M(@g.n0 String str, int i10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.x(str, i10);
    }

    public static void N(@g.n0 String str, int i10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        O(str, i10, z10, m());
    }

    public static void O(@g.n0 String str, int i10, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.y(str, i10, z10);
    }

    public static void P(@g.n0 String str, long j10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Q(str, j10, m());
    }

    public static void Q(@g.n0 String str, long j10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.z(str, j10);
    }

    public static void R(@g.n0 String str, long j10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        S(str, j10, z10, m());
    }

    public static void S(@g.n0 String str, long j10, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.A(str, j10, z10);
    }

    public static void T(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        U(str, str2, m());
    }

    public static void U(@g.n0 String str, String str2, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.B(str, str2);
    }

    public static void V(@g.n0 String str, String str2, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        W(str, str2, z10, m());
    }

    public static void W(@g.n0 String str, String str2, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.C(str, str2, z10);
    }

    public static void X(@g.n0 String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Y(str, set, m());
    }

    public static void Y(@g.n0 String str, Set<String> set, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.D(str, set);
    }

    public static void Z(@g.n0 String str, Set<String> set, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a0(str, set, z10, m());
    }

    public static void a() {
        b(m());
    }

    public static void a0(@g.n0 String str, Set<String> set, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.E(str, set, z10);
    }

    public static void b(@g.n0 w0 w0Var) {
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.a();
    }

    public static void b0(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        c0(str, z10, m());
    }

    public static void c(boolean z10) {
        d(z10, m());
    }

    public static void c0(@g.n0 String str, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.F(str, z10);
    }

    public static void d(boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.b(z10);
    }

    public static void d0(@g.n0 String str, boolean z10, boolean z11) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        e0(str, z10, z11, m());
    }

    public static boolean e(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(str, m());
    }

    public static void e0(@g.n0 String str, boolean z10, boolean z11, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.G(str, z10, z11);
    }

    public static boolean f(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.c(str);
    }

    public static void f0(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        g0(str, m());
    }

    public static Map<String, ?> g() {
        return h(m());
    }

    public static void g0(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.H(str);
    }

    public static Map<String, ?> h(@g.n0 w0 w0Var) {
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.d();
    }

    public static void h0(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i0(str, z10, m());
    }

    public static boolean i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(str, m());
    }

    public static void i0(@g.n0 String str, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w0Var.I(str, z10);
    }

    public static boolean j(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.e(str);
    }

    public static void j0(w0 w0Var) {
        f12017a = w0Var;
    }

    public static boolean k(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return l(str, z10, m());
    }

    public static boolean l(@g.n0 String str, boolean z10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.f(str, z10);
    }

    public static w0 m() {
        w0 w0Var = f12017a;
        return w0Var != null ? w0Var : w0.i();
    }

    public static float n(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return q(str, m());
    }

    public static float o(@g.n0 String str, float f10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return p(str, f10, m());
    }

    public static float p(@g.n0 String str, float f10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.h(str, f10);
    }

    public static float q(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.g(str);
    }

    public static int r(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return u(str, m());
    }

    public static int s(@g.n0 String str, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(str, i10, m());
    }

    public static int t(@g.n0 String str, int i10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.n(str, i10);
    }

    public static int u(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.m(str);
    }

    public static long v(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return y(str, m());
    }

    public static long w(@g.n0 String str, long j10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return x(str, j10, m());
    }

    public static long x(@g.n0 String str, long j10, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.p(str, j10);
    }

    public static long y(@g.n0 String str, @g.n0 w0 w0Var) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(w0Var, "Argument 'spUtils' of type SPUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return w0Var.o(str);
    }

    public static String z(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return A(str, m());
    }
}
