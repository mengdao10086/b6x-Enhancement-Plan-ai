package io.reactivex.internal.operators.observable;

import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableInternalHelper {

    public enum MapToInt implements dj.o<Object, Object> {
        INSTANCE;

        @Override // dj.o
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    public static final class a<T> implements Callable<ij.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.z<T> f34198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34199b;

        public a(xi.z<T> zVar, int i10) {
            this.f34198a = zVar;
            this.f34199b = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ij.a<T> call() {
            return this.f34198a.x4(this.f34199b);
        }
    }

    public static final class b<T> implements Callable<ij.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.z<T> f34200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TimeUnit f34203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final xi.h0 f34204e;

        public b(xi.z<T> zVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f34200a = zVar;
            this.f34201b = i10;
            this.f34202c = j10;
            this.f34203d = timeUnit;
            this.f34204e = h0Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ij.a<T> call() {
            return this.f34200a.z4(this.f34201b, this.f34202c, this.f34203d, this.f34204e);
        }
    }

    public static final class c<T, U> implements dj.o<T, xi.e0<U>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends Iterable<? extends U>> f34205a;

        public c(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f34205a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.e0<U> apply(T t10) throws Exception {
            return new m0((Iterable) io.reactivex.internal.functions.a.g(this.f34205a.apply(t10), "The mapper returned a null Iterable"));
        }
    }

    public static final class d<U, R, T> implements dj.o<U, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends R> f34206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f34207b;

        public d(dj.c<? super T, ? super U, ? extends R> cVar, T t10) {
            this.f34206a = cVar;
            this.f34207b = t10;
        }

        @Override // dj.o
        public R apply(U u6) throws Exception {
            return this.f34206a.apply(this.f34207b, u6);
        }
    }

    public static final class e<T, R, U> implements dj.o<T, xi.e0<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.c<? super T, ? super U, ? extends R> f34208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.e0<? extends U>> f34209b;

        public e(dj.c<? super T, ? super U, ? extends R> cVar, dj.o<? super T, ? extends xi.e0<? extends U>> oVar) {
            this.f34208a = cVar;
            this.f34209b = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.e0<R> apply(T t10) throws Exception {
            return new x0((xi.e0) io.reactivex.internal.functions.a.g(this.f34209b.apply(t10), "The mapper returned a null ObservableSource"), new d(this.f34208a, t10));
        }
    }

    public static final class f<T, U> implements dj.o<T, xi.e0<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.e0<U>> f34210a;

        public f(dj.o<? super T, ? extends xi.e0<U>> oVar) {
            this.f34210a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.e0<T> apply(T t10) throws Exception {
            return new q1((xi.e0) io.reactivex.internal.functions.a.g(this.f34210a.apply(t10), "The itemDelay returned a null ObservableSource"), 1L).A3(Functions.n(t10)).v1(t10);
        }
    }

    public static final class g<T> implements dj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<T> f34211a;

        public g(xi.g0<T> g0Var) {
            this.f34211a = g0Var;
        }

        @Override // dj.a
        public void run() throws Exception {
            this.f34211a.onComplete();
        }
    }

    public static final class h<T> implements dj.g<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<T> f34212a;

        public h(xi.g0<T> g0Var) {
            this.f34212a = g0Var;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) throws Exception {
            this.f34212a.onError(th2);
        }
    }

    public static final class i<T> implements dj.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<T> f34213a;

        public i(xi.g0<T> g0Var) {
            this.f34213a = g0Var;
        }

        @Override // dj.g
        public void accept(T t10) throws Exception {
            this.f34213a.onNext(t10);
        }
    }

    public static final class j<T> implements Callable<ij.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.z<T> f34214a;

        public j(xi.z<T> zVar) {
            this.f34214a = zVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ij.a<T> call() {
            return this.f34214a.w4();
        }
    }

    public static final class k<T, R> implements dj.o<xi.z<T>, xi.e0<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super xi.z<T>, ? extends xi.e0<R>> f34215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.h0 f34216b;

        public k(dj.o<? super xi.z<T>, ? extends xi.e0<R>> oVar, xi.h0 h0Var) {
            this.f34215a = oVar;
            this.f34216b = h0Var;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.e0<R> apply(xi.z<T> zVar) throws Exception {
            return xi.z.P7((xi.e0) io.reactivex.internal.functions.a.g(this.f34215a.apply(zVar), "The selector returned a null ObservableSource")).b4(this.f34216b);
        }
    }

    public static final class l<T, S> implements dj.c<S, xi.i<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.b<S, xi.i<T>> f34217a;

        public l(dj.b<S, xi.i<T>> bVar) {
            this.f34217a = bVar;
        }

        @Override // dj.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s10, xi.i<T> iVar) throws Exception {
            this.f34217a.a(s10, iVar);
            return s10;
        }
    }

    public static final class m<T, S> implements dj.c<S, xi.i<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.g<xi.i<T>> f34218a;

        public m(dj.g<xi.i<T>> gVar) {
            this.f34218a = gVar;
        }

        @Override // dj.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s10, xi.i<T> iVar) throws Exception {
            this.f34218a.accept(iVar);
            return s10;
        }
    }

    public static final class n<T> implements Callable<ij.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.z<T> f34219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f34221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final xi.h0 f34222d;

        public n(xi.z<T> zVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f34219a = zVar;
            this.f34220b = j10;
            this.f34221c = timeUnit;
            this.f34222d = h0Var;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ij.a<T> call() {
            return this.f34219a.C4(this.f34220b, this.f34221c, this.f34222d);
        }
    }

    public static final class o<T, R> implements dj.o<List<xi.e0<? extends T>>, xi.e0<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super Object[], ? extends R> f34223a;

        public o(dj.o<? super Object[], ? extends R> oVar) {
            this.f34223a = oVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.e0<? extends R> apply(List<xi.e0<? extends T>> list) {
            return xi.z.d8(list, this.f34223a, false, xi.z.U());
        }
    }

    public ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> dj.o<T, xi.e0<U>> a(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T, U, R> dj.o<T, xi.e0<R>> b(dj.o<? super T, ? extends xi.e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> dj.o<T, xi.e0<T>> c(dj.o<? super T, ? extends xi.e0<U>> oVar) {
        return new f(oVar);
    }

    public static <T> dj.a d(xi.g0<T> g0Var) {
        return new g(g0Var);
    }

    public static <T> dj.g<Throwable> e(xi.g0<T> g0Var) {
        return new h(g0Var);
    }

    public static <T> dj.g<T> f(xi.g0<T> g0Var) {
        return new i(g0Var);
    }

    public static <T> Callable<ij.a<T>> g(xi.z<T> zVar) {
        return new j(zVar);
    }

    public static <T> Callable<ij.a<T>> h(xi.z<T> zVar, int i10) {
        return new a(zVar, i10);
    }

    public static <T> Callable<ij.a<T>> i(xi.z<T> zVar, int i10, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return new b(zVar, i10, j10, timeUnit, h0Var);
    }

    public static <T> Callable<ij.a<T>> j(xi.z<T> zVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        return new n(zVar, j10, timeUnit, h0Var);
    }

    public static <T, R> dj.o<xi.z<T>, xi.e0<R>> k(dj.o<? super xi.z<T>, ? extends xi.e0<R>> oVar, xi.h0 h0Var) {
        return new k(oVar, h0Var);
    }

    public static <T, S> dj.c<S, xi.i<T>, S> l(dj.b<S, xi.i<T>> bVar) {
        return new l(bVar);
    }

    public static <T, S> dj.c<S, xi.i<T>, S> m(dj.g<xi.i<T>> gVar) {
        return new m(gVar);
    }

    public static <T, R> dj.o<List<xi.e0<? extends T>>, xi.e0<? extends R>> n(dj.o<? super Object[], ? extends R> oVar) {
        return new o(oVar);
    }
}
