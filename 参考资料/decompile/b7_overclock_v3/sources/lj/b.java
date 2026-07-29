package lj;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.schedulers.l;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @bj.e
    public static final h0 f39801a = kj.a.J(new h());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @bj.e
    public static final h0 f39802b = kj.a.G(new CallableC0444b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @bj.e
    public static final h0 f39803c = kj.a.H(new c());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @bj.e
    public static final h0 f39804d = l.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @bj.e
    public static final h0 f39805e = kj.a.I(new f());

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f39806a = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: renamed from: lj.b$b, reason: collision with other inner class name */
    public static final class CallableC0444b implements Callable<h0> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 call() throws Exception {
            return a.f39806a;
        }
    }

    public static final class c implements Callable<h0> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 call() throws Exception {
            return d.f39807a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f39807a = new io.reactivex.internal.schedulers.e();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f39808a = new io.reactivex.internal.schedulers.f();
    }

    public static final class f implements Callable<h0> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 call() throws Exception {
            return e.f39808a;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f39809a = new k();
    }

    public static final class h implements Callable<h0> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 call() throws Exception {
            return g.f39809a;
        }
    }

    public b() {
        throw new IllegalStateException("No instances!");
    }

    @bj.e
    public static h0 a() {
        return kj.a.X(f39802b);
    }

    @bj.e
    public static h0 b(@bj.e Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    @bj.d
    @bj.e
    public static h0 c(@bj.e Executor executor, boolean z10) {
        return new ExecutorScheduler(executor, z10);
    }

    @bj.e
    public static h0 d() {
        return kj.a.Z(f39803c);
    }

    @bj.e
    public static h0 e() {
        return kj.a.a0(f39805e);
    }

    public static void f() {
        a().i();
        d().i();
        e().i();
        g().i();
        i().i();
        j.d();
    }

    @bj.e
    public static h0 g() {
        return kj.a.c0(f39801a);
    }

    public static void h() {
        a().j();
        d().j();
        e().j();
        g().j();
        i().j();
        j.e();
    }

    @bj.e
    public static h0 i() {
        return f39804d;
    }
}
