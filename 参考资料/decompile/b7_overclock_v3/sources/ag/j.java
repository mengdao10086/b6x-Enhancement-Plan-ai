package ag;

import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f669a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f670b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f671c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f672d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f673e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f674f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public static m f675g = new k();

    public static void a(@n0 g gVar) {
        f675g.a((g) n.a(gVar));
    }

    public static void b() {
        f675g.k();
    }

    public static void c(@p0 Object obj) {
        f675g.n(obj);
    }

    public static void d(@n0 String str, @p0 Object... objArr) {
        f675g.b(str, objArr);
    }

    public static void e(@n0 String str, @p0 Object... objArr) {
        f675g.m(null, str, objArr);
    }

    public static void f(@p0 Throwable th2, @n0 String str, @p0 Object... objArr) {
        f675g.m(th2, str, objArr);
    }

    public static void g(@n0 String str, @p0 Object... objArr) {
        f675g.l(str, objArr);
    }

    public static void h(@p0 String str) {
        f675g.i(str);
    }

    public static void i(int i10, @p0 String str, @p0 String str2, @p0 Throwable th2) {
        f675g.j(i10, str, str2, th2);
    }

    public static void j(@n0 m mVar) {
        f675g = (m) n.a(mVar);
    }

    public static m k(@p0 String str) {
        return f675g.c(str);
    }

    public static void l(@n0 String str, @p0 Object... objArr) {
        f675g.d(str, objArr);
    }

    public static void m(@n0 String str, @p0 Object... objArr) {
        f675g.g(str, objArr);
    }

    public static void n(@n0 String str, @p0 Object... objArr) {
        f675g.h(str, objArr);
    }

    public static void o(@p0 String str) {
        f675g.f(str);
    }
}
