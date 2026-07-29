package xi;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements g {
    @bj.c
    @bj.g("none")
    @bj.e
    public static a A(Callable<? extends g> callable) {
        io.reactivex.internal.functions.a.g(callable, "completableSupplier");
        return kj.a.R(new io.reactivex.internal.operators.completable.b(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a P(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "error is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.g(th2));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a Q(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.g(callable, "errorSupplier is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.h(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a R(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "run is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.i(aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a S(Callable<?> callable) {
        io.reactivex.internal.functions.a.g(callable, "callable is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.j(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a T(Future<?> future) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return R(Functions.j(future));
    }

    @bj.c
    @bj.g(bj.g.B)
    public static a T0(long j10, TimeUnit timeUnit) {
        return U0(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> a U(w<T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "maybe is null");
        return kj.a.R(new io.reactivex.internal.operators.maybe.x(wVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static a U0(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new CompletableTimer(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> a V(e0<T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "observable is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.k(e0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public static <T> a W(bu.c<T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "publisher is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.l(cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a X(Runnable runnable) {
        io.reactivex.internal.functions.a.g(runnable, "run is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.m(runnable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> a Y(o0<T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "single is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.n(o0Var));
    }

    public static NullPointerException Y0(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public static a c0(bu.c<? extends g> cVar) {
        return f0(cVar, Integer.MAX_VALUE, false);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a c1(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "source is null");
        if (gVar instanceof a) {
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return kj.a.R(new io.reactivex.internal.operators.completable.o(gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static a d0(bu.c<? extends g> cVar, int i10) {
        return f0(cVar, i10, false);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a e(Iterable<? extends g> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.a(null, iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a e0(Iterable<? extends g> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.R(new CompletableMergeIterable(iterable));
    }

    @bj.c
    @bj.g("none")
    public static <R> a e1(Callable<R> callable, dj.o<? super R, ? extends g> oVar, dj.g<? super R> gVar) {
        return f1(callable, oVar, gVar, true);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a f(g... gVarArr) {
        io.reactivex.internal.functions.a.g(gVarArr, "sources is null");
        return gVarArr.length == 0 ? s() : gVarArr.length == 1 ? g1(gVarArr[0]) : kj.a.R(new io.reactivex.internal.operators.completable.a(gVarArr, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static a f0(bu.c<? extends g> cVar, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.R(new CompletableMerge(cVar, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <R> a f1(Callable<R> callable, dj.o<? super R, ? extends g> oVar, dj.g<? super R> gVar, boolean z10) {
        io.reactivex.internal.functions.a.g(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.g(oVar, "completableFunction is null");
        io.reactivex.internal.functions.a.g(gVar, "disposer is null");
        return kj.a.R(new CompletableUsing(callable, oVar, gVar, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a g0(g... gVarArr) {
        io.reactivex.internal.functions.a.g(gVarArr, "sources is null");
        return gVarArr.length == 0 ? s() : gVarArr.length == 1 ? g1(gVarArr[0]) : kj.a.R(new CompletableMergeArray(gVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a g1(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "source is null");
        return gVar instanceof a ? kj.a.R((a) gVar) : kj.a.R(new io.reactivex.internal.operators.completable.o(gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a h0(g... gVarArr) {
        io.reactivex.internal.functions.a.g(gVarArr, "sources is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.s(gVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public static a i0(bu.c<? extends g> cVar) {
        return f0(cVar, Integer.MAX_VALUE, true);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static a j0(bu.c<? extends g> cVar, int i10) {
        return f0(cVar, i10, true);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a k0(Iterable<? extends g> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.t(iterable));
    }

    @bj.c
    @bj.g("none")
    public static a m0() {
        return kj.a.R(io.reactivex.internal.operators.completable.u.f33122a);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a s() {
        return kj.a.R(io.reactivex.internal.operators.completable.f.f33096a);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static a u(bu.c<? extends g> cVar) {
        return v(cVar, 2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static a v(bu.c<? extends g> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.R(new CompletableConcat(cVar, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a w(Iterable<? extends g> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.R(new CompletableConcatIterable(iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a x(g... gVarArr) {
        io.reactivex.internal.functions.a.g(gVarArr, "sources is null");
        return gVarArr.length == 0 ? s() : gVarArr.length == 1 ? g1(gVarArr[0]) : kj.a.R(new CompletableConcatArray(gVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static a z(e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "source is null");
        return kj.a.R(new CompletableCreate(eVar));
    }

    @bj.c
    @bj.g("none")
    public final a A0(dj.r<? super Throwable> rVar) {
        return W(W0().r5(rVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final a B(long j10, TimeUnit timeUnit) {
        return D(j10, timeUnit, lj.b.a(), false);
    }

    @bj.c
    @bj.g("none")
    public final a B0(dj.o<? super j<Throwable>, ? extends bu.c<?>> oVar) {
        return W(W0().t5(oVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final a C(long j10, TimeUnit timeUnit, h0 h0Var) {
        return D(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a C0(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return x(gVar, this);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a D(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new CompletableDelay(this, j10, timeUnit, h0Var, z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <T> j<T> D0(bu.c<T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return W0().a6(cVar);
    }

    @bj.d
    @bj.c
    @bj.g(bj.g.B)
    public final a E(long j10, TimeUnit timeUnit) {
        return F(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> z<T> E0(z<T> zVar) {
        io.reactivex.internal.functions.a.g(zVar, "other is null");
        return zVar.n1(Z0());
    }

    @bj.d
    @bj.c
    @bj.g(bj.g.A)
    public final a F(long j10, TimeUnit timeUnit, h0 h0Var) {
        return U0(j10, timeUnit, h0Var).h(this);
    }

    @bj.g("none")
    public final io.reactivex.disposables.b F0() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @bj.c
    @bj.g("none")
    public final a G(dj.a aVar) {
        dj.g<? super io.reactivex.disposables.b> gVarH = Functions.h();
        dj.g<? super Throwable> gVarH2 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return M(gVarH, gVarH2, aVar2, aVar2, aVar, aVar2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final io.reactivex.disposables.b G0(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a H(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return kj.a.R(new CompletableDoFinally(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final io.reactivex.disposables.b H0(dj.a aVar, dj.g<? super Throwable> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(gVar, aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @bj.c
    @bj.g("none")
    public final a I(dj.a aVar) {
        dj.g<? super io.reactivex.disposables.b> gVarH = Functions.h();
        dj.g<? super Throwable> gVarH2 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return M(gVarH, gVarH2, aVar, aVar2, aVar2, aVar2);
    }

    public abstract void I0(d dVar);

    @bj.c
    @bj.g("none")
    public final a J(dj.a aVar) {
        dj.g<? super io.reactivex.disposables.b> gVarH = Functions.h();
        dj.g<? super Throwable> gVarH2 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return M(gVarH, gVarH2, aVar2, aVar2, aVar2, aVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a J0(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new CompletableSubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final a K(dj.g<? super Throwable> gVar) {
        dj.g<? super io.reactivex.disposables.b> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return M(gVarH, gVar, aVar, aVar, aVar, aVar);
    }

    @bj.c
    @bj.g("none")
    public final <E extends d> E K0(E e10) {
        a(e10);
        return e10;
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a L(dj.g<? super Throwable> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onEvent is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.e(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a L0(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.R(new CompletableTakeUntilCompletable(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a M(dj.g<? super io.reactivex.disposables.b> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2, dj.a aVar3, dj.a aVar4) {
        io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.g(aVar2, "onTerminate is null");
        io.reactivex.internal.functions.a.g(aVar3, "onAfterTerminate is null");
        io.reactivex.internal.functions.a.g(aVar4, "onDispose is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.w(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<Void> M0() {
        TestObserver<Void> testObserver = new TestObserver<>();
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final a N(dj.g<? super io.reactivex.disposables.b> gVar) {
        dj.g<? super Throwable> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return M(gVar, gVarH, aVar, aVar, aVar, aVar);
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<Void> N0(boolean z10) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z10) {
            testObserver.cancel();
        }
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final a O(dj.a aVar) {
        dj.g<? super io.reactivex.disposables.b> gVarH = Functions.h();
        dj.g<? super Throwable> gVarH2 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return M(gVarH, gVarH2, aVar2, aVar, aVar2, aVar2);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final a O0(long j10, TimeUnit timeUnit) {
        return S0(j10, timeUnit, lj.b.a(), null);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.e
    public final a P0(long j10, TimeUnit timeUnit, g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return S0(j10, timeUnit, lj.b.a(), gVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final a Q0(long j10, TimeUnit timeUnit, h0 h0Var) {
        return S0(j10, timeUnit, h0Var, null);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a R0(long j10, TimeUnit timeUnit, h0 h0Var, g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return S0(j10, timeUnit, h0Var, gVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a S0(long j10, TimeUnit timeUnit, h0 h0Var, g gVar) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.x(this, j10, timeUnit, h0Var, gVar));
    }

    @bj.c
    @bj.g("none")
    public final <U> U V0(dj.o<? super a, U> oVar) {
        try {
            return (U) ((dj.o) io.reactivex.internal.functions.a.g(oVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <T> j<T> W0() {
        return this instanceof fj.b ? ((fj.b) this).d() : kj.a.S(new io.reactivex.internal.operators.completable.y(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <T> q<T> X0() {
        return this instanceof fj.c ? ((fj.c) this).c() : kj.a.T(new io.reactivex.internal.operators.maybe.r(this));
    }

    @bj.c
    @bj.g("none")
    public final a Z() {
        return kj.a.R(new io.reactivex.internal.operators.completable.p(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <T> z<T> Z0() {
        return this instanceof fj.d ? ((fj.d) this).b() : kj.a.U(new io.reactivex.internal.operators.completable.z(this));
    }

    @Override // xi.g
    @bj.g("none")
    public final void a(d dVar) {
        io.reactivex.internal.functions.a.g(dVar, "observer is null");
        try {
            d dVarE0 = kj.a.e0(this, dVar);
            io.reactivex.internal.functions.a.g(dVarE0, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            I0(dVarE0);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
            throw Y0(th2);
        }
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a a0(f fVar) {
        io.reactivex.internal.functions.a.g(fVar, "onLift is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.q(this, fVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> i0<T> a1(Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.g(callable, "completionValueSupplier is null");
        return kj.a.V(new io.reactivex.internal.operators.completable.a0(this, callable, null));
    }

    @bj.d
    @bj.c
    @bj.g("none")
    public final <T> i0<y<T>> b0() {
        return kj.a.V(new io.reactivex.internal.operators.completable.r(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> i0<T> b1(T t10) {
        io.reactivex.internal.functions.a.g(t10, "completionValue is null");
        return kj.a.V(new io.reactivex.internal.operators.completable.a0(this, null, t10));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a d1(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.d(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a g(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return f(this, gVar);
    }

    @bj.c
    @bj.g("none")
    public final a h(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "next is null");
        return kj.a.R(new CompletableAndThenCompletable(this, gVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <T> j<T> i(bu.c<T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "next is null");
        return kj.a.S(new CompletableAndThenPublisher(this, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> q<T> j(w<T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "next is null");
        return kj.a.T(new MaybeDelayWithCompletable(wVar, this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> z<T> k(e0<T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "next is null");
        return kj.a.U(new CompletableAndThenObservable(this, e0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <T> i0<T> l(o0<T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "next is null");
        return kj.a.V(new SingleDelayWithCompletable(o0Var, this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a l0(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return g0(this, gVar);
    }

    @bj.c
    @bj.g("none")
    public final <R> R m(@bj.e b<? extends R> bVar) {
        return (R) ((b) io.reactivex.internal.functions.a.g(bVar, "converter is null")).d(this);
    }

    @bj.g("none")
    public final void n() {
        gj.f fVar = new gj.f();
        a(fVar);
        fVar.b();
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final a n0(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.R(new CompletableObserveOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final boolean o(long j10, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        gj.f fVar = new gj.f();
        a(fVar);
        return fVar.a(j10, timeUnit);
    }

    @bj.c
    @bj.g("none")
    public final a o0() {
        return p0(Functions.c());
    }

    @bj.c
    @bj.g("none")
    @bj.f
    public final Throwable p() {
        gj.f fVar = new gj.f();
        a(fVar);
        return fVar.d();
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a p0(dj.r<? super Throwable> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.R(new io.reactivex.internal.operators.completable.v(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.f
    public final Throwable q(long j10, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        gj.f fVar = new gj.f();
        a(fVar);
        return fVar.e(j10, timeUnit);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a q0(dj.o<? super Throwable, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "errorMapper is null");
        return kj.a.R(new CompletableResumeNext(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final a r() {
        return kj.a.R(new CompletableCache(this));
    }

    @bj.c
    @bj.g("none")
    public final a r0() {
        return kj.a.R(new io.reactivex.internal.operators.completable.c(this));
    }

    @bj.c
    @bj.g("none")
    public final a s0() {
        return W(W0().T4());
    }

    @bj.c
    @bj.g("none")
    public final a t(h hVar) {
        return g1(((h) io.reactivex.internal.functions.a.g(hVar, "transformer is null")).d(this));
    }

    @bj.c
    @bj.g("none")
    public final a t0(long j10) {
        return W(W0().U4(j10));
    }

    @bj.c
    @bj.g("none")
    public final a u0(dj.e eVar) {
        return W(W0().V4(eVar));
    }

    @bj.c
    @bj.g("none")
    public final a v0(dj.o<? super j<Object>, ? extends bu.c<?>> oVar) {
        return W(W0().W4(oVar));
    }

    @bj.c
    @bj.g("none")
    public final a w0() {
        return W(W0().n5());
    }

    @bj.c
    @bj.g("none")
    public final a x0(long j10) {
        return W(W0().o5(j10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a y(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.R(new CompletableAndThenCompletable(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final a y0(long j10, dj.r<? super Throwable> rVar) {
        return W(W0().p5(j10, rVar));
    }

    @bj.c
    @bj.g("none")
    public final a z0(dj.d<? super Integer, ? super Throwable> dVar) {
        return W(W0().q5(dVar));
    }
}
