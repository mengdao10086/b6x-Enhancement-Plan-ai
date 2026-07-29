package kj;

import bj.f;
import bu.d;
import dj.c;
import dj.e;
import dj.g;
import dj.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import xi.g0;
import xi.h0;
import xi.i0;
import xi.j;
import xi.l0;
import xi.q;
import xi.t;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @f
    public static volatile g<? super Throwable> f37388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @f
    public static volatile o<? super Runnable, ? extends Runnable> f37389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @f
    public static volatile o<? super Callable<h0>, ? extends h0> f37390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @f
    public static volatile o<? super Callable<h0>, ? extends h0> f37391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @f
    public static volatile o<? super Callable<h0>, ? extends h0> f37392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @f
    public static volatile o<? super Callable<h0>, ? extends h0> f37393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @f
    public static volatile o<? super h0, ? extends h0> f37394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @f
    public static volatile o<? super h0, ? extends h0> f37395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @f
    public static volatile o<? super h0, ? extends h0> f37396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @f
    public static volatile o<? super h0, ? extends h0> f37397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @f
    public static volatile o<? super j, ? extends j> f37398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @f
    public static volatile o<? super cj.a, ? extends cj.a> f37399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @f
    public static volatile o<? super z, ? extends z> f37400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @f
    public static volatile o<? super ij.a, ? extends ij.a> f37401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @f
    public static volatile o<? super q, ? extends q> f37402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @f
    public static volatile o<? super i0, ? extends i0> f37403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @f
    public static volatile o<? super xi.a, ? extends xi.a> f37404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @f
    public static volatile o<? super jj.a, ? extends jj.a> f37405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @f
    public static volatile c<? super j, ? super d, ? extends d> f37406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @f
    public static volatile c<? super q, ? super t, ? extends t> f37407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @f
    public static volatile c<? super z, ? super g0, ? extends g0> f37408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @f
    public static volatile c<? super i0, ? super l0, ? extends l0> f37409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @f
    public static volatile c<? super xi.a, ? super xi.d, ? extends xi.d> f37410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @f
    public static volatile e f37411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile boolean f37412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile boolean f37413z;

    public a() {
        throw new IllegalStateException("No instances!");
    }

    @f
    public static c<? super z, ? super g0, ? extends g0> A() {
        return f37408u;
    }

    public static void A0(@f c<? super q, t, ? extends t> cVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37407t = cVar;
    }

    @f
    public static o<? super jj.a, ? extends jj.a> B() {
        return f37405r;
    }

    public static void B0(@f o<? super z, ? extends z> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37400m = oVar;
    }

    @f
    public static o<? super i0, ? extends i0> C() {
        return f37403p;
    }

    public static void C0(@f c<? super z, ? super g0, ? extends g0> cVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37408u = cVar;
    }

    @f
    public static c<? super i0, ? super l0, ? extends l0> D() {
        return f37409v;
    }

    public static void D0(@f o<? super jj.a, ? extends jj.a> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37405r = oVar;
    }

    @f
    public static o<? super Runnable, ? extends Runnable> E() {
        return f37389b;
    }

    public static void E0(@f o<? super i0, ? extends i0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37403p = oVar;
    }

    @f
    public static o<? super h0, ? extends h0> F() {
        return f37395h;
    }

    public static void F0(@f c<? super i0, ? super l0, ? extends l0> cVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37409v = cVar;
    }

    @bj.e
    public static h0 G(@bj.e Callable<h0> callable) {
        io.reactivex.internal.functions.a.g(callable, "Scheduler Callable can't be null");
        o<? super Callable<h0>, ? extends h0> oVar = f37390c;
        return oVar == null ? d(callable) : c(oVar, callable);
    }

    public static void G0(@f o<? super Runnable, ? extends Runnable> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37389b = oVar;
    }

    @bj.e
    public static h0 H(@bj.e Callable<h0> callable) {
        io.reactivex.internal.functions.a.g(callable, "Scheduler Callable can't be null");
        o<? super Callable<h0>, ? extends h0> oVar = f37392e;
        return oVar == null ? d(callable) : c(oVar, callable);
    }

    public static void H0(@f o<? super h0, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37395h = oVar;
    }

    @bj.e
    public static h0 I(@bj.e Callable<h0> callable) {
        io.reactivex.internal.functions.a.g(callable, "Scheduler Callable can't be null");
        o<? super Callable<h0>, ? extends h0> oVar = f37393f;
        return oVar == null ? d(callable) : c(oVar, callable);
    }

    public static void I0(@bj.e Throwable th2) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
    }

    @bj.e
    public static h0 J(@bj.e Callable<h0> callable) {
        io.reactivex.internal.functions.a.g(callable, "Scheduler Callable can't be null");
        o<? super Callable<h0>, ? extends h0> oVar = f37391d;
        return oVar == null ? d(callable) : c(oVar, callable);
    }

    public static void J0() {
        f37412y = false;
    }

    public static boolean K(Throwable th2) {
        return (th2 instanceof OnErrorNotImplementedException) || (th2 instanceof MissingBackpressureException) || (th2 instanceof IllegalStateException) || (th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException) || (th2 instanceof CompositeException);
    }

    public static boolean L() {
        return f37413z;
    }

    public static boolean M() {
        return f37412y;
    }

    public static void N() {
        f37412y = true;
    }

    @bj.e
    public static <T> cj.a<T> O(@bj.e cj.a<T> aVar) {
        o<? super cj.a, ? extends cj.a> oVar = f37399l;
        return oVar != null ? (cj.a) b(oVar, aVar) : aVar;
    }

    @bj.e
    public static <T> ij.a<T> P(@bj.e ij.a<T> aVar) {
        o<? super ij.a, ? extends ij.a> oVar = f37401n;
        return oVar != null ? (ij.a) b(oVar, aVar) : aVar;
    }

    @bj.e
    public static <T> jj.a<T> Q(@bj.e jj.a<T> aVar) {
        o<? super jj.a, ? extends jj.a> oVar = f37405r;
        return oVar != null ? (jj.a) b(oVar, aVar) : aVar;
    }

    @bj.e
    public static xi.a R(@bj.e xi.a aVar) {
        o<? super xi.a, ? extends xi.a> oVar = f37404q;
        return oVar != null ? (xi.a) b(oVar, aVar) : aVar;
    }

    @bj.e
    public static <T> j<T> S(@bj.e j<T> jVar) {
        o<? super j, ? extends j> oVar = f37398k;
        return oVar != null ? (j) b(oVar, jVar) : jVar;
    }

    @bj.e
    public static <T> q<T> T(@bj.e q<T> qVar) {
        o<? super q, ? extends q> oVar = f37402o;
        return oVar != null ? (q) b(oVar, qVar) : qVar;
    }

    @bj.e
    public static <T> z<T> U(@bj.e z<T> zVar) {
        o<? super z, ? extends z> oVar = f37400m;
        return oVar != null ? (z) b(oVar, zVar) : zVar;
    }

    @bj.e
    public static <T> i0<T> V(@bj.e i0<T> i0Var) {
        o<? super i0, ? extends i0> oVar = f37403p;
        return oVar != null ? (i0) b(oVar, i0Var) : i0Var;
    }

    public static boolean W() {
        e eVar = f37411x;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.e
    public static h0 X(@bj.e h0 h0Var) {
        o<? super h0, ? extends h0> oVar = f37394g;
        return oVar == null ? h0Var : (h0) b(oVar, h0Var);
    }

    public static void Y(@bj.e Throwable th2) {
        g<? super Throwable> gVar = f37388a;
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!K(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (gVar != null) {
            try {
                gVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                I0(th3);
            }
        }
        th2.printStackTrace();
        I0(th2);
    }

    @bj.e
    public static h0 Z(@bj.e h0 h0Var) {
        o<? super h0, ? extends h0> oVar = f37396i;
        return oVar == null ? h0Var : (h0) b(oVar, h0Var);
    }

    @bj.e
    public static <T, U, R> R a(@bj.e c<T, U, R> cVar, @bj.e T t10, @bj.e U u6) {
        try {
            return cVar.apply(t10, u6);
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.e
    public static h0 a0(@bj.e h0 h0Var) {
        o<? super h0, ? extends h0> oVar = f37397j;
        return oVar == null ? h0Var : (h0) b(oVar, h0Var);
    }

    @bj.e
    public static <T, R> R b(@bj.e o<T, R> oVar, @bj.e T t10) {
        try {
            return oVar.apply(t10);
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.e
    public static Runnable b0(@bj.e Runnable runnable) {
        io.reactivex.internal.functions.a.g(runnable, "run is null");
        o<? super Runnable, ? extends Runnable> oVar = f37389b;
        return oVar == null ? runnable : (Runnable) b(oVar, runnable);
    }

    @bj.e
    public static h0 c(@bj.e o<? super Callable<h0>, ? extends h0> oVar, Callable<h0> callable) {
        return (h0) io.reactivex.internal.functions.a.g(b(oVar, callable), "Scheduler Callable result can't be null");
    }

    @bj.e
    public static h0 c0(@bj.e h0 h0Var) {
        o<? super h0, ? extends h0> oVar = f37395h;
        return oVar == null ? h0Var : (h0) b(oVar, h0Var);
    }

    @bj.e
    public static h0 d(@bj.e Callable<h0> callable) {
        try {
            return (h0) io.reactivex.internal.functions.a.g(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.e
    public static <T> d<? super T> d0(@bj.e j<T> jVar, @bj.e d<? super T> dVar) {
        c<? super j, ? super d, ? extends d> cVar = f37406s;
        return cVar != null ? (d) a(cVar, jVar, dVar) : dVar;
    }

    @bj.e
    public static h0 e(@bj.e ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.a((ThreadFactory) io.reactivex.internal.functions.a.g(threadFactory, "threadFactory is null"));
    }

    @bj.e
    public static xi.d e0(@bj.e xi.a aVar, @bj.e xi.d dVar) {
        c<? super xi.a, ? super xi.d, ? extends xi.d> cVar = f37410w;
        return cVar != null ? (xi.d) a(cVar, aVar, dVar) : dVar;
    }

    @bj.e
    public static h0 f(@bj.e ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.e((ThreadFactory) io.reactivex.internal.functions.a.g(threadFactory, "threadFactory is null"));
    }

    @bj.e
    public static <T> t<? super T> f0(@bj.e q<T> qVar, @bj.e t<? super T> tVar) {
        c<? super q, ? super t, ? extends t> cVar = f37407t;
        return cVar != null ? (t) a(cVar, qVar, tVar) : tVar;
    }

    @bj.e
    public static h0 g(@bj.e ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.f((ThreadFactory) io.reactivex.internal.functions.a.g(threadFactory, "threadFactory is null"));
    }

    @bj.e
    public static <T> g0<? super T> g0(@bj.e z<T> zVar, @bj.e g0<? super T> g0Var) {
        c<? super z, ? super g0, ? extends g0> cVar = f37408u;
        return cVar != null ? (g0) a(cVar, zVar, g0Var) : g0Var;
    }

    @bj.e
    public static h0 h(@bj.e ThreadFactory threadFactory) {
        return new k((ThreadFactory) io.reactivex.internal.functions.a.g(threadFactory, "threadFactory is null"));
    }

    @bj.e
    public static <T> l0<? super T> h0(@bj.e i0<T> i0Var, @bj.e l0<? super T> l0Var) {
        c<? super i0, ? super l0, ? extends l0> cVar = f37409v;
        return cVar != null ? (l0) a(cVar, i0Var, l0Var) : l0Var;
    }

    @f
    public static o<? super h0, ? extends h0> i() {
        return f37394g;
    }

    public static void i0() {
        k0(null);
        G0(null);
        j0(null);
        m0(null);
        q0(null);
        n0(null);
        H0(null);
        p0(null);
        r0(null);
        o0(null);
        x0(null);
        y0(null);
        B0(null);
        C0(null);
        E0(null);
        F0(null);
        t0(null);
        u0(null);
        v0(null);
        w0(null);
        z0(null);
        A0(null);
        D0(null);
        l0(false);
        s0(null);
    }

    @f
    public static g<? super Throwable> j() {
        return f37388a;
    }

    public static void j0(@f o<? super h0, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37394g = oVar;
    }

    @f
    public static o<? super Callable<h0>, ? extends h0> k() {
        return f37390c;
    }

    public static void k0(@f g<? super Throwable> gVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37388a = gVar;
    }

    @f
    public static o<? super Callable<h0>, ? extends h0> l() {
        return f37392e;
    }

    public static void l0(boolean z10) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37413z = z10;
    }

    @f
    public static o<? super Callable<h0>, ? extends h0> m() {
        return f37393f;
    }

    public static void m0(@f o<? super Callable<h0>, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37390c = oVar;
    }

    @f
    public static o<? super Callable<h0>, ? extends h0> n() {
        return f37391d;
    }

    public static void n0(@f o<? super Callable<h0>, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37392e = oVar;
    }

    @f
    public static o<? super h0, ? extends h0> o() {
        return f37396i;
    }

    public static void o0(@f o<? super Callable<h0>, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37393f = oVar;
    }

    @f
    public static o<? super h0, ? extends h0> p() {
        return f37397j;
    }

    public static void p0(@f o<? super Callable<h0>, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37391d = oVar;
    }

    @f
    public static e q() {
        return f37411x;
    }

    public static void q0(@f o<? super h0, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37396i = oVar;
    }

    @f
    public static o<? super xi.a, ? extends xi.a> r() {
        return f37404q;
    }

    public static void r0(@f o<? super h0, ? extends h0> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37397j = oVar;
    }

    @f
    public static c<? super xi.a, ? super xi.d, ? extends xi.d> s() {
        return f37410w;
    }

    public static void s0(@f e eVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37411x = eVar;
    }

    @f
    public static o<? super cj.a, ? extends cj.a> t() {
        return f37399l;
    }

    public static void t0(@f o<? super xi.a, ? extends xi.a> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37404q = oVar;
    }

    @f
    public static o<? super ij.a, ? extends ij.a> u() {
        return f37401n;
    }

    public static void u0(@f c<? super xi.a, ? super xi.d, ? extends xi.d> cVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37410w = cVar;
    }

    @f
    public static o<? super j, ? extends j> v() {
        return f37398k;
    }

    public static void v0(@f o<? super cj.a, ? extends cj.a> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37399l = oVar;
    }

    @f
    public static c<? super j, ? super d, ? extends d> w() {
        return f37406s;
    }

    public static void w0(@f o<? super ij.a, ? extends ij.a> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37401n = oVar;
    }

    @f
    public static o<? super q, ? extends q> x() {
        return f37402o;
    }

    public static void x0(@f o<? super j, ? extends j> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37398k = oVar;
    }

    @f
    public static c<? super q, ? super t, ? extends t> y() {
        return f37407t;
    }

    public static void y0(@f c<? super j, ? super d, ? extends d> cVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37406s = cVar;
    }

    @f
    public static o<? super z, ? extends z> z() {
        return f37400m;
    }

    public static void z0(@f o<? super q, ? extends q> oVar) {
        if (f37412y) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f37402o = oVar;
    }
}
