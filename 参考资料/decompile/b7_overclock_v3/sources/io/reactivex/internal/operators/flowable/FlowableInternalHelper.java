package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableInternalHelper {

    public enum RequestMax implements dj.g<bu.e> {
        INSTANCE;

        @Override // dj.g
        public void accept(bu.e eVar) throws Exception {
            eVar.request(Long.MAX_VALUE);
        }
    }

    public static final class a<T> implements Callable<cj.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.j<T> f33275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33276b;

        public a(xi.j<T> jVar, int i10) {
            this.f33275a = jVar;
            this.f33276b = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cj.a<T> call() {
            return this.f33275a.Y4(this.f33276b);
        }
    }

    public static final class b<T> implements Callable<cj.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.j<T> f33277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f33279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TimeUnit f33280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final xi.h0 f33281e;

        public b(xi.j<T> jVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f33277a = jVar;
            this.f33278b = i10;
            this.f33279c = j10;
            this.f33280d = timeUnit;
            this.f33281e = h0Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cj.a<T> call() {
            return this.f33277a.a5(this.f33278b, this.f33279c, this.f33280d, this.f33281e);
        }
    }

    public static final class c<T, U> implements dj.o<T, bu.c<U>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends Iterable<? extends U>> f33282a;

        public c(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f33282a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bu.c<U> apply(T t10) throws Exception {
            return new FlowableFromIterable((Iterable) io.reactivex.internal.functions.a.g(this.f33282a.apply(t10), "The mapper returned a null Iterable"));
        }
    }

    public static final class d<U, R, T> implements dj.o<U, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends R> f33283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f33284b;

        public d(dj.c<? super T, ? super U, ? extends R> cVar, T t10) {
            this.f33283a = cVar;
            this.f33284b = t10;
        }

        @Override // dj.o
        public R apply(U u6) throws Exception {
            return this.f33283a.apply(this.f33284b, u6);
        }
    }

    public static final class e<T, R, U> implements dj.o<T, bu.c<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends R> f33285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends bu.c<? extends U>> f33286b;

        public e(dj.c<? super T, ? super U, ? extends R> cVar, dj.o<? super T, ? extends bu.c<? extends U>> oVar) {
            this.f33285a = cVar;
            this.f33286b = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bu.c<R> apply(T t10) throws Exception {
            return new q0((bu.c) io.reactivex.internal.functions.a.g(this.f33286b.apply(t10), "The mapper returned a null Publisher"), new d(this.f33285a, t10));
        }
    }

    public static final class f<T, U> implements dj.o<T, bu.c<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends bu.c<U>> f33287a;

        public f(dj.o<? super T, ? extends bu.c<U>> oVar) {
            this.f33287a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bu.c<T> apply(T t10) throws Exception {
            return new e1((bu.c) io.reactivex.internal.functions.a.g(this.f33287a.apply(t10), "The itemDelay returned a null Publisher"), 1L).K3(Functions.n(t10)).A1(t10);
        }
    }

    public static final class g<T> implements Callable<cj.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.j<T> f33288a;

        public g(xi.j<T> jVar) {
            this.f33288a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cj.a<T> call() {
            return this.f33288a.X4();
        }
    }

    public static final class h<T, R> implements dj.o<xi.j<T>, bu.c<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super xi.j<T>, ? extends bu.c<R>> f33289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.h0 f33290b;

        public h(dj.o<? super xi.j<T>, ? extends bu.c<R>> oVar, xi.h0 h0Var) {
            this.f33289a = oVar;
            this.f33290b = h0Var;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bu.c<R> apply(xi.j<T> jVar) throws Exception {
            return xi.j.Y2((bu.c) io.reactivex.internal.functions.a.g(this.f33289a.apply(jVar), "The selector returned a null Publisher")).l4(this.f33290b);
        }
    }

    public static final class i<T, S> implements dj.c<S, xi.i<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.b<S, xi.i<T>> f33291a;

        public i(dj.b<S, xi.i<T>> bVar) {
            this.f33291a = bVar;
        }

        @Override // dj.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s10, xi.i<T> iVar) throws Exception {
            this.f33291a.a(s10, iVar);
            return s10;
        }
    }

    public static final class j<T, S> implements dj.c<S, xi.i<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.g<xi.i<T>> f33292a;

        public j(dj.g<xi.i<T>> gVar) {
            this.f33292a = gVar;
        }

        @Override // dj.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s10, xi.i<T> iVar) throws Exception {
            this.f33292a.accept(iVar);
            return s10;
        }
    }

    public static final class k<T> implements dj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<T> f33293a;

        public k(bu.d<T> dVar) {
            this.f33293a = dVar;
        }

        @Override // dj.a
        public void run() throws Exception {
            this.f33293a.onComplete();
        }
    }

    public static final class l<T> implements dj.g<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<T> f33294a;

        public l(bu.d<T> dVar) {
            this.f33294a = dVar;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) throws Exception {
            this.f33294a.onError(th2);
        }
    }

    public static final class m<T> implements dj.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<T> f33295a;

        public m(bu.d<T> dVar) {
            this.f33295a = dVar;
        }

        @Override // dj.g
        public void accept(T t10) throws Exception {
            this.f33295a.onNext(t10);
        }
    }

    public static final class n<T> implements Callable<cj.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.j<T> f33296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f33298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xi.h0 f33299d;

        public n(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f33296a = jVar;
            this.f33297b = j10;
            this.f33298c = timeUnit;
            this.f33299d = h0Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public cj.a<T> call() {
            return this.f33296a.d5(this.f33297b, this.f33298c, this.f33299d);
        }
    }

    public static final class o<T, R> implements dj.o<List<bu.c<? extends T>>, bu.c<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super Object[], ? extends R> f33300a;

        public o(dj.o<? super Object[], ? extends R> oVar) {
            this.f33300a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public bu.c<? extends R> apply(List<bu.c<? extends T>> list) {
            return xi.j.H8(list, this.f33300a, false, xi.j.Y());
        }
    }

    public FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> dj.o<T, bu.c<U>> a(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T, U, R> dj.o<T, bu.c<R>> b(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> dj.o<T, bu.c<T>> c(dj.o<? super T, ? extends bu.c<U>> oVar) {
        return new f(oVar);
    }

    public static <T> Callable<cj.a<T>> d(xi.j<T> jVar) {
        return new g(jVar);
    }

    public static <T> Callable<cj.a<T>> e(xi.j<T> jVar, int i10) {
        return new a(jVar, i10);
    }

    public static <T> Callable<cj.a<T>> f(xi.j<T> jVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return new b(jVar, i10, j10, timeUnit, h0Var);
    }

    public static <T> Callable<cj.a<T>> g(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return new n(jVar, j10, timeUnit, h0Var);
    }

    public static <T, R> dj.o<xi.j<T>, bu.c<R>> h(dj.o<? super xi.j<T>, ? extends bu.c<R>> oVar, xi.h0 h0Var) {
        return new h(oVar, h0Var);
    }

    public static <T, S> dj.c<S, xi.i<T>, S> i(dj.b<S, xi.i<T>> bVar) {
        return new i(bVar);
    }

    public static <T, S> dj.c<S, xi.i<T>, S> j(dj.g<xi.i<T>> gVar) {
        return new j(gVar);
    }

    public static <T> dj.a k(bu.d<T> dVar) {
        return new k(dVar);
    }

    public static <T> dj.g<Throwable> l(bu.d<T> dVar) {
        return new l(dVar);
    }

    public static <T> dj.g<T> m(bu.d<T> dVar) {
        return new m(dVar);
    }

    public static <T, R> dj.o<List<bu.c<? extends T>>, bu.c<? extends R>> n(dj.o<? super Object[], ? extends R> oVar) {
        return new o(oVar);
    }
}
