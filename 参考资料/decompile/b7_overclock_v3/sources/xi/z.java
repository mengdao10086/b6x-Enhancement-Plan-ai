package xi;

import io.reactivex.BackpressureStrategy;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.a1;
import io.reactivex.internal.operators.observable.b1;
import io.reactivex.internal.operators.observable.c1;
import io.reactivex.internal.operators.observable.e1;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.h1;
import io.reactivex.internal.operators.observable.i1;
import io.reactivex.internal.operators.observable.j1;
import io.reactivex.internal.operators.observable.k1;
import io.reactivex.internal.operators.observable.l1;
import io.reactivex.internal.operators.observable.m1;
import io.reactivex.internal.operators.observable.n1;
import io.reactivex.internal.operators.observable.o1;
import io.reactivex.internal.operators.observable.p1;
import io.reactivex.internal.operators.observable.q0;
import io.reactivex.internal.operators.observable.q1;
import io.reactivex.internal.operators.observable.r0;
import io.reactivex.internal.operators.observable.r1;
import io.reactivex.internal.operators.observable.s0;
import io.reactivex.internal.operators.observable.s1;
import io.reactivex.internal.operators.observable.t0;
import io.reactivex.internal.operators.observable.t1;
import io.reactivex.internal.operators.observable.u0;
import io.reactivex.internal.operators.observable.u1;
import io.reactivex.internal.operators.observable.v0;
import io.reactivex.internal.operators.observable.v1;
import io.reactivex.internal.operators.observable.w0;
import io.reactivex.internal.operators.observable.w1;
import io.reactivex.internal.operators.observable.x0;
import io.reactivex.internal.operators.observable.x1;
import io.reactivex.internal.operators.observable.y0;
import io.reactivex.internal.operators.observable.y1;
import io.reactivex.internal.operators.observable.z0;
import io.reactivex.internal.operators.observable.z1;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z<T> implements e0<T> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55355a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f55355a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55355a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55355a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55355a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> A0(e0<? extends T>... e0VarArr) {
        return e0VarArr.length == 0 ? e2() : e0VarArr.length == 1 ? P7(e0VarArr[0]) : G0(J2(e0VarArr));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> B0(int i10, int i11, e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).X0(Functions.k(), i10, i11, false);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> C0(e0<? extends T>... e0VarArr) {
        return B0(U(), U(), e0VarArr);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> C3(Iterable<? extends e0<? extends T>> iterable) {
        return P2(iterable).l2(Functions.k());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> D0(int i10, int i11, e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).X0(Functions.k(), i10, i11, true);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> D3(Iterable<? extends e0<? extends T>> iterable, int i10) {
        return P2(iterable).m2(Functions.k(), i10);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> E0(e0<? extends T>... e0VarArr) {
        return D0(U(), U(), e0VarArr);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> E3(Iterable<? extends e0<? extends T>> iterable, int i10, int i11) {
        return P2(iterable).w2(Functions.k(), false, i10, i11);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> F0(Iterable<? extends e0<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return G0(P2(iterable));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> F3(e0<? extends e0<? extends T>> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        return kj.a.U(new ObservableFlatMap(e0Var, Functions.k(), false, Integer.MAX_VALUE, U()));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> G0(e0<? extends e0<? extends T>> e0Var) {
        return H0(e0Var, U(), true);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> G3(e0<? extends e0<? extends T>> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.U(new ObservableFlatMap(e0Var, Functions.k(), false, i10, U()));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> H0(e0<? extends e0<? extends T>> e0Var, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch is null");
        return kj.a.U(new ObservableConcatMap(e0Var, Functions.k(), i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> H3(e0<? extends T> e0Var, e0<? extends T> e0Var2) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return J2(e0Var, e0Var2).v2(Functions.k(), false, 2);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> I0(Iterable<? extends e0<? extends T>> iterable) {
        return J0(iterable, U(), U());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> I3(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        return J2(e0Var, e0Var2, e0Var3).v2(Functions.k(), false, 3);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> J0(Iterable<? extends e0<? extends T>> iterable, int i10, int i11) {
        return P2(iterable).X0(Functions.k(), i10, i11, false);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> J2(T... tArr) {
        io.reactivex.internal.functions.a.g(tArr, "items is null");
        return tArr.length == 0 ? e2() : tArr.length == 1 ? m3(tArr[0]) : kj.a.U(new io.reactivex.internal.operators.observable.j0(tArr));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> J3(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3, e0<? extends T> e0Var4) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        return J2(e0Var, e0Var2, e0Var3, e0Var4).v2(Functions.k(), false, 4);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> K0(e0<? extends e0<? extends T>> e0Var) {
        return L0(e0Var, U(), U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> K2(Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.g(callable, "supplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.k0(callable));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> K3(int i10, int i11, e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).w2(Functions.k(), false, i10, i11);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> L0(e0<? extends e0<? extends T>> e0Var, int i10, int i11) {
        return P7(e0Var).W0(Functions.k(), i10, i11);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> L2(Future<? extends T> future) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.l0(future, 0L, null));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> L3(e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).m2(Functions.k(), e0VarArr.length);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> M2(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.l0(future, j10, timeUnit));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> M3(int i10, int i11, e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).w2(Functions.k(), true, i10, i11);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static <T> z<T> N2(Future<? extends T> future, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return M2(future, j10, timeUnit).J5(h0Var);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> N3(e0<? extends T>... e0VarArr) {
        return J2(e0VarArr).v2(Functions.k(), true, e0VarArr.length);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static <T> z<T> O2(Future<? extends T> future, h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return L2(future).J5(h0Var);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> O3(Iterable<? extends e0<? extends T>> iterable) {
        return P2(iterable).u2(Functions.k(), true);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> P2(Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "source is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.m0(iterable));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> P3(Iterable<? extends e0<? extends T>> iterable, int i10) {
        return P2(iterable).v2(Functions.k(), true, i10);
    }

    @bj.c
    @bj.g(bj.g.B)
    public static z<Long> P6(long j10, TimeUnit timeUnit) {
        return Q6(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> P7(e0<T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "source is null");
        return e0Var instanceof z ? kj.a.U((z) e0Var) : kj.a.U(new io.reactivex.internal.operators.observable.o0(e0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public static <T> z<T> Q2(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "publisher is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.n0(cVar));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> Q3(Iterable<? extends e0<? extends T>> iterable, int i10, int i11) {
        return P2(iterable).w2(Functions.k(), true, i10, i11);
    }

    @bj.c
    @bj.g(bj.g.A)
    public static z<Long> Q6(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableTimer(Math.max(j10, 0L), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> Q7(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.U(new ObservableZip(null, iterable, oVar, U(), false));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> R2(dj.g<i<T>> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "generator is null");
        return V2(Functions.u(), ObservableInternalHelper.m(gVar), Functions.h());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> R3(e0<? extends e0<? extends T>> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        return kj.a.U(new ObservableFlatMap(e0Var, Functions.k(), true, Integer.MAX_VALUE, U()));
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> R7(e0<? extends e0<? extends T>> e0Var, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        return kj.a.U(new v1(e0Var, 16).l2(ObservableInternalHelper.n(oVar)));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, S> z<T> S2(Callable<S> callable, dj.b<S, i<T>> bVar) {
        io.reactivex.internal.functions.a.g(bVar, "generator is null");
        return V2(callable, ObservableInternalHelper.l(bVar), Functions.h());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> S3(e0<? extends e0<? extends T>> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.U(new ObservableFlatMap(e0Var, Functions.k(), true, i10, U()));
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, R> z<R> S7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, dj.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return c8(Functions.x(cVar), false, U(), e0Var, e0Var2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, S> z<T> T2(Callable<S> callable, dj.b<S, i<T>> bVar, dj.g<? super S> gVar) {
        io.reactivex.internal.functions.a.g(bVar, "generator is null");
        return V2(callable, ObservableInternalHelper.l(bVar), gVar);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> T3(e0<? extends T> e0Var, e0<? extends T> e0Var2) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return J2(e0Var, e0Var2).v2(Functions.k(), true, 2);
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, R> z<R> T7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, dj.c<? super T1, ? super T2, ? extends R> cVar, boolean z10) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return c8(Functions.x(cVar), z10, U(), e0Var, e0Var2);
    }

    public static int U() {
        return j.Y();
    }

    @bj.c
    @bj.g("none")
    public static <T, S> z<T> U2(Callable<S> callable, dj.c<S, i<T>, S> cVar) {
        return V2(callable, cVar, Functions.h());
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> U3(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        return J2(e0Var, e0Var2, e0Var3).v2(Functions.k(), true, 3);
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, R> z<R> U7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, dj.c<? super T1, ? super T2, ? extends R> cVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return c8(Functions.x(cVar), z10, i10, e0Var, e0Var2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, S> z<T> V2(Callable<S> callable, dj.c<S, i<T>, S> cVar, dj.g<? super S> gVar) {
        io.reactivex.internal.functions.a.g(callable, "initialState is null");
        io.reactivex.internal.functions.a.g(cVar, "generator is null");
        io.reactivex.internal.functions.a.g(gVar, "disposeState is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.p0(callable, cVar, gVar));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> V3(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3, e0<? extends T> e0Var4) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        return J2(e0Var, e0Var2, e0Var3, e0Var4).v2(Functions.k(), true, 4);
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, R> z<R> V7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        return c8(Functions.y(hVar), false, U(), e0Var, e0Var2, e0Var3);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> W5(e0<? extends e0<? extends T>> e0Var) {
        return X5(e0Var, U());
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, R> z<R> W7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        return c8(Functions.z(iVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> X5(e0<? extends e0<? extends T>> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableSwitchMap(e0Var, Functions.k(), i10, false));
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, T5, R> z<R> X7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        return c8(Functions.A(jVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> Y5(e0<? extends e0<? extends T>> e0Var) {
        return Z5(e0Var, U());
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, T5, T6, R> z<R> Y7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        return c8(Functions.B(kVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> Z5(e0<? extends e0<? extends T>> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableSwitchMap(e0Var, Functions.k(), i10, true));
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> z<R> Z7(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        return c8(Functions.C(lVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7);
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> a0(dj.o<? super Object[], ? extends R> oVar, int i10, e0<? extends T>... e0VarArr) {
        return m0(e0VarArr, oVar, i10);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> a4() {
        return kj.a.U(a1.f34433a);
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> z<R> a8(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, e0<? extends T8> e0Var8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(e0Var8, "source8 is null");
        return c8(Functions.D(mVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8);
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> b0(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        return c0(iterable, oVar, U());
    }

    @bj.c
    @bj.g("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> z<R> b8(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, e0<? extends T8> e0Var8, e0<? extends T9> e0Var9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(e0Var8, "source8 is null");
        io.reactivex.internal.functions.a.g(e0Var9, "source9 is null");
        return c8(Functions.E(nVar), false, U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8, e0Var9);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> z<R> c0(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableCombineLatest(null, iterable, oVar, i10 << 1, false));
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> c8(dj.o<? super Object[], ? extends R> oVar, boolean z10, int i10, e0<? extends T>... e0VarArr) {
        if (e0VarArr.length == 0) {
            return e2();
        }
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableZip(e0VarArr, null, oVar, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, R> z<R> d0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, dj.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return a0(Functions.x(cVar), U(), e0Var, e0Var2);
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<Boolean> d5(e0<? extends T> e0Var, e0<? extends T> e0Var2) {
        return g5(e0Var, e0Var2, io.reactivex.internal.functions.a.d(), U());
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> d8(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableZip(null, iterable, oVar, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, R> z<R> e0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        return a0(Functions.y(hVar), U(), e0Var, e0Var2, e0Var3);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> e2() {
        return kj.a.U(io.reactivex.internal.operators.observable.f0.f34511a);
    }

    @bj.c
    @bj.g(bj.g.B)
    public static z<Long> e3(long j10, long j11, TimeUnit timeUnit) {
        return f3(j10, j11, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<Boolean> e5(e0<? extends T> e0Var, e0<? extends T> e0Var2, int i10) {
        return g5(e0Var, e0Var2, io.reactivex.internal.functions.a.d(), i10);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> f(Iterable<? extends e0<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.U(new ObservableAmb(null, iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, R> z<R> f0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        return a0(Functions.z(iVar), U(), e0Var, e0Var2, e0Var3, e0Var4);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> f2(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "exception is null");
        return g2(Functions.m(th2));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static z<Long> f3(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableInterval(Math.max(0L, j10), Math.max(0L, j11), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<Boolean> f5(e0<? extends T> e0Var, e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar) {
        return g5(e0Var, e0Var2, dVar, U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> g(e0<? extends T>... e0VarArr) {
        io.reactivex.internal.functions.a.g(e0VarArr, "sources is null");
        int length = e0VarArr.length;
        return length == 0 ? e2() : length == 1 ? P7(e0VarArr[0]) : kj.a.U(new ObservableAmb(e0VarArr, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, R> z<R> g0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        return a0(Functions.A(jVar), U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> g2(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.g(callable, "errorSupplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.g0(callable));
    }

    @bj.c
    @bj.g(bj.g.B)
    public static z<Long> g3(long j10, TimeUnit timeUnit) {
        return f3(j10, j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<Boolean> g5(e0<? extends T> e0Var, e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(dVar, "isEqual is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.V(new ObservableSequenceEqualSingle(e0Var, e0Var2, dVar, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, R> z<R> h0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        return a0(Functions.B(kVar), U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6);
    }

    @bj.c
    @bj.g(bj.g.A)
    public static z<Long> h3(long j10, TimeUnit timeUnit, h0 h0Var) {
        return f3(j10, j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, R> z<R> i0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        return a0(Functions.C(lVar), U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7);
    }

    @bj.c
    @bj.g(bj.g.B)
    public static z<Long> i3(long j10, long j11, long j12, long j13, TimeUnit timeUnit) {
        return j3(j10, j11, j12, j13, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> z<R> j0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, e0<? extends T8> e0Var8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(e0Var8, "source8 is null");
        return a0(Functions.D(mVar), U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static z<Long> j3(long j10, long j11, long j12, long j13, TimeUnit timeUnit, h0 h0Var) {
        if (j11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        }
        if (j11 == 0) {
            return e2().y1(j12, timeUnit, h0Var);
        }
        long j14 = j10 + (j11 - 1);
        if (j10 > 0 && j14 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableIntervalRange(j10, j14, Math.max(0L, j12), Math.max(0L, j13), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> z<R> k0(e0<? extends T1> e0Var, e0<? extends T2> e0Var2, e0<? extends T3> e0Var3, e0<? extends T4> e0Var4, e0<? extends T5> e0Var5, e0<? extends T6> e0Var6, e0<? extends T7> e0Var7, e0<? extends T8> e0Var8, e0<? extends T9> e0Var9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(e0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(e0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(e0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(e0Var8, "source8 is null");
        io.reactivex.internal.functions.a.g(e0Var9, "source9 is null");
        return a0(Functions.E(nVar), U(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8, e0Var9);
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> l0(e0<? extends T>[] e0VarArr, dj.o<? super Object[], ? extends R> oVar) {
        return m0(e0VarArr, oVar, U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> z<R> m0(e0<? extends T>[] e0VarArr, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(e0VarArr, "sources is null");
        if (e0VarArr.length == 0) {
            return e2();
        }
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableCombineLatest(e0VarArr, null, oVar, i10 << 1, false));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> m3(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return kj.a.U(new t0(t10));
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> m7(e0<T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "onSubscribe is null");
        if (e0Var instanceof z) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return kj.a.U(new io.reactivex.internal.operators.observable.o0(e0Var));
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> n0(dj.o<? super Object[], ? extends R> oVar, int i10, e0<? extends T>... e0VarArr) {
        return r0(e0VarArr, oVar, i10);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> n3(T t10, T t11) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        return J2(t10, t11);
    }

    @bj.c
    @bj.g("none")
    public static z<Integer> n4(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        }
        if (i11 == 0) {
            return e2();
        }
        if (i11 == 1) {
            return m3(Integer.valueOf(i10));
        }
        if (((long) i10) + ((long) (i11 - 1)) <= 2147483647L) {
            return kj.a.U(new ObservableRange(i10, i11));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> o0(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        return p0(iterable, oVar, U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> o3(T t10, T t11, T t12) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        return J2(t10, t11, t12);
    }

    @bj.c
    @bj.g("none")
    public static z<Long> o4(long j10, long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        }
        if (j11 == 0) {
            return e2();
        }
        if (j11 == 1) {
            return m3(Long.valueOf(j10));
        }
        long j12 = (j11 - 1) + j10;
        if (j10 <= 0 || j12 >= 0) {
            return kj.a.U(new ObservableRangeLong(j10, j11));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    @bj.c
    @bj.g("none")
    public static <T, D> z<T> o7(Callable<? extends D> callable, dj.o<? super D, ? extends e0<? extends T>> oVar, dj.g<? super D> gVar) {
        return p7(callable, oVar, gVar, true);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> z<R> p0(Iterable<? extends e0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableCombineLatest(null, iterable, oVar, i10 << 1, true));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> p3(T t10, T t11, T t12, T t13) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        return J2(t10, t11, t12, t13);
    }

    @bj.c
    @bj.g("none")
    public static <T, D> z<T> p7(Callable<? extends D> callable, dj.o<? super D, ? extends e0<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        io.reactivex.internal.functions.a.g(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.g(oVar, "sourceSupplier is null");
        io.reactivex.internal.functions.a.g(gVar, "disposer is null");
        return kj.a.U(new ObservableUsing(callable, oVar, gVar, z10));
    }

    @bj.c
    @bj.g("none")
    public static <T, R> z<R> q0(e0<? extends T>[] e0VarArr, dj.o<? super Object[], ? extends R> oVar) {
        return r0(e0VarArr, oVar, U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> q3(T t10, T t11, T t12, T t13, T t14) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        return J2(t10, t11, t12, t13, t14);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> z<R> r0(e0<? extends T>[] e0VarArr, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        return e0VarArr.length == 0 ? e2() : kj.a.U(new ObservableCombineLatest(e0VarArr, null, oVar, i10 << 1, true));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> r1(c0<T> c0Var) {
        io.reactivex.internal.functions.a.g(c0Var, "source is null");
        return kj.a.U(new ObservableCreate(c0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> r3(T t10, T t11, T t12, T t13, T t14, T t15) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        return J2(t10, t11, t12, t13, t14, t15);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> s3(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        return J2(t10, t11, t12, t13, t14, t15, t16);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> t0(Iterable<? extends e0<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return P2(iterable).U0(Functions.k(), U(), false);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> t3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        io.reactivex.internal.functions.a.g(t17, "item8 is null");
        return J2(t10, t11, t12, t13, t14, t15, t16, t17);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> u0(e0<? extends e0<? extends T>> e0Var) {
        return v0(e0Var, U());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> u3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        io.reactivex.internal.functions.a.g(t17, "item8 is null");
        io.reactivex.internal.functions.a.g(t18, "item9 is null");
        return J2(t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> v0(e0<? extends e0<? extends T>> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableConcatMap(e0Var, Functions.k(), i10, ErrorMode.IMMEDIATE));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> v3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        io.reactivex.internal.functions.a.g(t17, "item8 is null");
        io.reactivex.internal.functions.a.g(t18, "item9 is null");
        io.reactivex.internal.functions.a.g(t19, "item10 is null");
        return J2(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> w0(e0<? extends T> e0Var, e0<? extends T> e0Var2) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        return z0(e0Var, e0Var2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> w1(Callable<? extends e0<? extends T>> callable) {
        io.reactivex.internal.functions.a.g(callable, "supplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.s(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> x0(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        return z0(e0Var, e0Var2, e0Var3);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> y0(e0<? extends T> e0Var, e0<? extends T> e0Var2, e0<? extends T> e0Var3, e0<? extends T> e0Var4) {
        io.reactivex.internal.functions.a.g(e0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "source4 is null");
        return z0(e0Var, e0Var2, e0Var3, e0Var4);
    }

    @bj.c
    @bj.g("none")
    public static <T> z<T> z0(e0<? extends T>... e0VarArr) {
        return e0VarArr.length == 0 ? e2() : e0VarArr.length == 1 ? P7(e0VarArr[0]) : kj.a.U(new ObservableConcatMap(J2(e0VarArr), Functions.k(), U(), ErrorMode.BOUNDARY));
    }

    @bj.g("none")
    public final void A(g0<? super T> g0Var) {
        io.reactivex.internal.operators.observable.j.c(this, g0Var);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> A1(long j10, TimeUnit timeUnit, boolean z10) {
        return z1(j10, timeUnit, lj.b.a(), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <U, V> z<V> A2(dj.o<? super T, ? extends Iterable<? extends U>> oVar, dj.c<? super T, ? super U, ? extends V> cVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return (z<V>) r2(ObservableInternalHelper.a(oVar), cVar, false, U(), U());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> A3(dj.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new x0(this, oVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final ij.a<T> A4(int i10, h0 h0Var) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return ObservableReplay.A8(x4(i10), h0Var);
    }

    @bj.c
    @bj.g("none")
    public final z<T> A5(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return z0(m3(t10), this);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> A6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return t1(j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> A7(long j10, TimeUnit timeUnit, h0 h0Var, long j11) {
        return B7(j10, timeUnit, h0Var, j11, false);
    }

    @bj.c
    @bj.g("none")
    public final z<List<T>> B(int i10) {
        return C(i10, i10);
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> B1(dj.o<? super T, ? extends e0<U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "itemDelay is null");
        return (z<T>) l2(ObservableInternalHelper.c(oVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> B2(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return C2(oVar, false);
    }

    @bj.c
    @bj.g("none")
    public final z<y<T>> B3() {
        return kj.a.U(new z0(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final ij.a<T> B4(long j10, TimeUnit timeUnit) {
        return C4(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final z<T> B5(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return z0(e0Var, this);
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> B6() {
        return D6(TimeUnit.MILLISECONDS, lj.b.a());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> B7(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10) {
        return C7(j10, timeUnit, h0Var, j11, z10, U());
    }

    @bj.c
    @bj.g("none")
    public final z<List<T>> C(int i10, int i11) {
        return (z<List<T>>) D(i10, i11, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <U, V> z<T> C1(e0<U> e0Var, dj.o<? super T, ? extends e0<V>> oVar) {
        return F1(e0Var).B1(oVar);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> C2(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableFlatMapMaybe(this, oVar, z10));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final ij.a<T> C4(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.v8(this, j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g("none")
    public final z<T> C5(T... tArr) {
        z zVarJ2 = J2(tArr);
        return zVarJ2 == e2() ? kj.a.U(this) : z0(zVarJ2, this);
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> C6(TimeUnit timeUnit) {
        return D6(timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> C7(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10, int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.i(j11, uh.a.C);
        return kj.a.U(new y1(this, j10, j10, timeUnit, h0Var, j11, i10, z10));
    }

    @bj.c
    @bj.g("none")
    public final <U extends Collection<? super T>> z<U> D(int i10, int i11, Callable<U> callable) {
        io.reactivex.internal.functions.a.h(i10, uh.a.C);
        io.reactivex.internal.functions.a.h(i11, com.google.android.material.timepicker.d.C2);
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.U(new ObservableBuffer(this, i10, i11, callable));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> D1(long j10, TimeUnit timeUnit) {
        return E1(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> D2(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return E2(oVar, false);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final ij.a<T> D4(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.A8(w4(), h0Var);
    }

    @bj.g("none")
    public final io.reactivex.disposables.b D5() {
        return H5(Functions.h(), Functions.f32984f, Functions.f32981c, Functions.h());
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> D6(TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new u1(this, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final <B> z<z<T>> D7(Callable<? extends e0<B>> callable) {
        return E7(callable, U());
    }

    @bj.c
    @bj.g("none")
    public final <U extends Collection<? super T>> z<U> E(int i10, Callable<U> callable) {
        return D(i10, i10, callable);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> E1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return F1(Q6(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> E2(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableFlatMapSingle(this, oVar, z10));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> E4(dj.o<? super z<T>, ? extends e0<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return ObservableReplay.z8(ObservableInternalHelper.g(this), oVar);
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b E5(dj.g<? super T> gVar) {
        return H5(gVar, Functions.f32984f, Functions.f32981c, Functions.h());
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> E6(h0 h0Var) {
        return D6(TimeUnit.MILLISECONDS, h0Var);
    }

    @bj.c
    @bj.g("none")
    public final <B> z<z<T>> E7(Callable<? extends e0<B>> callable, int i10) {
        io.reactivex.internal.functions.a.g(callable, "boundary is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableWindowBoundarySupplier(this, callable, i10));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<List<T>> F(long j10, long j11, TimeUnit timeUnit) {
        return (z<List<T>>) H(j10, j11, timeUnit, lj.b.a(), ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> F1(e0<U> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.u(this, e0Var));
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b F2(dj.g<? super T> gVar) {
        return E5(gVar);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> F4(dj.o<? super z<T>, ? extends e0<R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return ObservableReplay.z8(ObservableInternalHelper.h(this, i10), oVar);
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b F5(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        return H5(gVar, gVar2, Functions.f32981c, Functions.h());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> F6(long j10, TimeUnit timeUnit) {
        return N6(j10, timeUnit, null, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <B> z<z<T>> F7(e0<B> e0Var) {
        return G7(e0Var, U());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<List<T>> G(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return (z<List<T>>) H(j10, j11, timeUnit, h0Var, ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    @Deprecated
    public final <T2> z<T2> G1() {
        return kj.a.U(new io.reactivex.internal.operators.observable.v(this, Functions.k()));
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b G2(dj.r<? super T> rVar) {
        return I2(rVar, Functions.f32984f, Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final <R> z<R> G4(dj.o<? super z<T>, ? extends e0<R>> oVar, int i10, long j10, TimeUnit timeUnit) {
        return H4(oVar, i10, j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b G5(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        return H5(gVar, gVar2, aVar, Functions.h());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> G6(long j10, TimeUnit timeUnit, e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return N6(j10, timeUnit, e0Var, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <B> z<z<T>> G7(e0<B> e0Var, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "boundary is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableWindowBoundary(this, e0Var, i10));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <U extends Collection<? super T>> z<U> H(long j10, long j11, TimeUnit timeUnit, h0 h0Var, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.m(this, j10, j11, timeUnit, h0Var, callable, Integer.MAX_VALUE, false));
    }

    @bj.d
    @bj.c
    @bj.g("none")
    public final <R> z<R> H1(dj.o<? super T, y<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.v(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b H2(dj.r<? super T> rVar, dj.g<? super Throwable> gVar) {
        return I2(rVar, gVar, Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <R> z<R> H4(dj.o<? super z<T>, ? extends e0<R>> oVar, int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.z8(ObservableInternalHelper.i(this, i10, j10, timeUnit, h0Var), oVar);
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b H5(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.g<? super io.reactivex.disposables.b> gVar3) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.g(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        c(lambdaObserver);
        return lambdaObserver;
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> H6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return N6(j10, timeUnit, null, h0Var);
    }

    @bj.c
    @bj.g("none")
    public final <U, V> z<z<T>> H7(e0<U> e0Var, dj.o<? super U, ? extends e0<V>> oVar) {
        return I7(e0Var, oVar, U());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<List<T>> I(long j10, TimeUnit timeUnit) {
        return L(j10, timeUnit, lj.b.a(), Integer.MAX_VALUE);
    }

    @bj.c
    @bj.g("none")
    public final z<T> I1() {
        return K1(Functions.k(), Functions.g());
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b I2(dj.r<? super T> rVar, dj.g<? super Throwable> gVar, dj.a aVar) {
        io.reactivex.internal.functions.a.g(rVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(rVar, gVar, aVar);
        c(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <R> z<R> I4(dj.o<? super z<T>, ? extends e0<R>> oVar, int i10, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return ObservableReplay.z8(ObservableInternalHelper.h(this, i10), ObservableInternalHelper.k(oVar, h0Var));
    }

    public abstract void I5(g0<? super T> g0Var);

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> I6(long j10, TimeUnit timeUnit, h0 h0Var, e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return N6(j10, timeUnit, e0Var, h0Var);
    }

    @bj.c
    @bj.g("none")
    public final <U, V> z<z<T>> I7(e0<U> e0Var, dj.o<? super U, ? extends e0<V>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(e0Var, "openingIndicator is null");
        io.reactivex.internal.functions.a.g(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new x1(this, e0Var, oVar, i10));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<List<T>> J(long j10, TimeUnit timeUnit, int i10) {
        return L(j10, timeUnit, lj.b.a(), i10);
    }

    @bj.c
    @bj.g("none")
    public final <K> z<T> J1(dj.o<? super T, K> oVar) {
        return K1(oVar, Functions.g());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final <R> z<R> J4(dj.o<? super z<T>, ? extends e0<R>> oVar, long j10, TimeUnit timeUnit) {
        return K4(oVar, j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> J5(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableSubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final <V> z<T> J6(dj.o<? super T, ? extends e0<V>> oVar) {
        return O6(null, oVar, null);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> J7(Iterable<? extends e0<?>> iterable, dj.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.g(iterable, "others is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        return kj.a.U(new ObservableWithLatestFromMany(this, iterable, oVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<List<T>> K(long j10, TimeUnit timeUnit, h0 h0Var) {
        return (z<List<T>>) M(j10, timeUnit, h0Var, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @bj.c
    @bj.g("none")
    public final <K> z<T> K1(dj.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(callable, "collectionSupplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.x(this, oVar, callable));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <R> z<R> K4(dj.o<? super z<T>, ? extends e0<R>> oVar, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.z8(ObservableInternalHelper.j(this, j10, timeUnit, h0Var), oVar);
    }

    @bj.c
    @bj.g("none")
    public final <E extends g0<? super T>> E K5(E e10) {
        c(e10);
        return e10;
    }

    @bj.c
    @bj.g("none")
    public final <V> z<T> K6(dj.o<? super T, ? extends e0<V>> oVar, e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return O6(null, oVar, e0Var);
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> K7(e0<? extends U> e0Var, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        io.reactivex.internal.functions.a.g(cVar, "combiner is null");
        return kj.a.U(new ObservableWithLatestFrom(this, cVar, e0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<List<T>> L(long j10, TimeUnit timeUnit, h0 h0Var, int i10) {
        return (z<List<T>>) M(j10, timeUnit, h0Var, i10, ArrayListSupplier.asCallable(), false);
    }

    @bj.c
    @bj.g("none")
    public final z<T> L1() {
        return N1(Functions.k());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <R> z<R> L4(dj.o<? super z<T>, ? extends e0<R>> oVar, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.z8(ObservableInternalHelper.g(this), ObservableInternalHelper.k(oVar, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final z<T> L5(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return kj.a.U(new p1(this, e0Var));
    }

    @bj.c
    @bj.g("none")
    public final <U, V> z<T> L6(e0<U> e0Var, dj.o<? super T, ? extends e0<V>> oVar) {
        io.reactivex.internal.functions.a.g(e0Var, "firstTimeoutIndicator is null");
        return O6(e0Var, oVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <T1, T2, R> z<R> L7(e0<T1> e0Var, e0<T2> e0Var2, dj.h<? super T, ? super T1, ? super T2, R> hVar) {
        io.reactivex.internal.functions.a.g(e0Var, "o1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "o2 is null");
        io.reactivex.internal.functions.a.g(hVar, "combiner is null");
        return O7(new e0[]{e0Var, e0Var2}, Functions.y(hVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final <U extends Collection<? super T>> z<U> M(long j10, TimeUnit timeUnit, h0 h0Var, int i10, Callable<U> callable, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        io.reactivex.internal.functions.a.h(i10, uh.a.C);
        return kj.a.U(new io.reactivex.internal.operators.observable.m(this, j10, j10, timeUnit, h0Var, callable, i10, z10));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> M0(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return N0(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    public final z<T> M1(dj.d<? super T, ? super T> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "comparer is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.y(this, Functions.k(), dVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> M4() {
        return O4(Long.MAX_VALUE, Functions.c());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> M5(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return N5(oVar, U());
    }

    @bj.c
    @bj.g("none")
    public final <U, V> z<T> M6(e0<U> e0Var, dj.o<? super T, ? extends e0<V>> oVar, e0<? extends T> e0Var2) {
        io.reactivex.internal.functions.a.g(e0Var, "firstTimeoutIndicator is null");
        io.reactivex.internal.functions.a.g(e0Var2, "other is null");
        return O6(e0Var, oVar, e0Var2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <T1, T2, T3, R> z<R> M7(e0<T1> e0Var, e0<T2> e0Var2, e0<T3> e0Var3, dj.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        io.reactivex.internal.functions.a.g(e0Var, "o1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "o2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "o3 is null");
        io.reactivex.internal.functions.a.g(iVar, "combiner is null");
        return O7(new e0[]{e0Var, e0Var2, e0Var3}, Functions.z(iVar));
    }

    @bj.c
    @bj.g("none")
    public final <B> z<List<T>> N(Callable<? extends e0<B>> callable) {
        return (z<List<T>>) O(callable, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <R> z<R> N0(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        if (!(this instanceof fj.m)) {
            return kj.a.U(new ObservableConcatMap(this, oVar, i10, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? e2() : ObservableScalarXMap.a(objCall, oVar);
    }

    @bj.c
    @bj.g("none")
    public final <K> z<T> N1(dj.o<? super T, K> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.y(this, oVar, io.reactivex.internal.functions.a.d()));
    }

    @bj.c
    @bj.g("none")
    public final z<T> N4(long j10) {
        return O4(j10, Functions.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <R> z<R> N5(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        if (!(this instanceof fj.m)) {
            return kj.a.U(new ObservableSwitchMap(this, oVar, i10, false));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? e2() : ObservableScalarXMap.a(objCall, oVar);
    }

    public final z<T> N6(long j10, TimeUnit timeUnit, e0<? extends T> e0Var, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "timeUnit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableTimeoutTimed(this, j10, timeUnit, h0Var, e0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <T1, T2, T3, T4, R> z<R> N7(e0<T1> e0Var, e0<T2> e0Var2, e0<T3> e0Var3, e0<T4> e0Var4, dj.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        io.reactivex.internal.functions.a.g(e0Var, "o1 is null");
        io.reactivex.internal.functions.a.g(e0Var2, "o2 is null");
        io.reactivex.internal.functions.a.g(e0Var3, "o3 is null");
        io.reactivex.internal.functions.a.g(e0Var4, "o4 is null");
        io.reactivex.internal.functions.a.g(jVar, "combiner is null");
        return O7(new e0[]{e0Var, e0Var2, e0Var3, e0Var4}, Functions.A(jVar));
    }

    @bj.c
    @bj.g("none")
    public final <B, U extends Collection<? super T>> z<U> O(Callable<? extends e0<B>> callable, Callable<U> callable2) {
        io.reactivex.internal.functions.a.g(callable, "boundarySupplier is null");
        io.reactivex.internal.functions.a.g(callable2, "bufferSupplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.k(this, callable, callable2));
    }

    @bj.c
    @bj.g("none")
    public final xi.a O0(dj.o<? super T, ? extends g> oVar) {
        return P0(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    public final z<T> O1(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onAfterNext is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.z(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> O4(long j10, dj.r<? super Throwable> rVar) {
        if (j10 >= 0) {
            io.reactivex.internal.functions.a.g(rVar, "predicate is null");
            return kj.a.U(new ObservableRetryPredicate(this, j10, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final xi.a O5(@bj.e dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new ObservableSwitchMapCompletable(this, oVar, false));
    }

    public final <U, V> z<T> O6(e0<U> e0Var, dj.o<? super T, ? extends e0<V>> oVar, e0<? extends T> e0Var2) {
        io.reactivex.internal.functions.a.g(oVar, "itemTimeoutIndicator is null");
        return kj.a.U(new ObservableTimeout(this, e0Var, oVar, e0Var2));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> O7(e0<?>[] e0VarArr, dj.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.g(e0VarArr, "others is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        return kj.a.U(new ObservableWithLatestFromMany(this, e0VarArr, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <B> z<List<T>> P(e0<B> e0Var) {
        return (z<List<T>>) T(e0Var, ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    public final xi.a P0(dj.o<? super T, ? extends g> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "capacityHint");
        return kj.a.R(new ObservableConcatMapCompletable(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> P1(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return U1(Functions.h(), Functions.h(), Functions.f32981c, aVar);
    }

    @bj.c
    @bj.g("none")
    public final z<T> P4(dj.d<? super Integer, ? super Throwable> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "predicate is null");
        return kj.a.U(new ObservableRetryBiPredicate(this, dVar));
    }

    @bj.c
    @bj.g("none")
    public final xi.a P5(@bj.e dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new ObservableSwitchMapCompletable(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    public final <B> z<List<T>> Q(e0<B> e0Var, int i10) {
        io.reactivex.internal.functions.a.h(i10, "initialCapacity");
        return (z<List<T>>) T(e0Var, Functions.f(i10));
    }

    @bj.c
    @bj.g("none")
    public final xi.a Q0(dj.o<? super T, ? extends g> oVar) {
        return S0(oVar, true, 2);
    }

    @bj.c
    @bj.g("none")
    public final z<T> Q1(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return kj.a.U(new ObservableDoFinally(this, aVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> Q4(dj.r<? super Throwable> rVar) {
        return O4(Long.MAX_VALUE, rVar);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> Q5(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return R5(oVar, U());
    }

    @bj.c
    @bj.g("none")
    public final <TOpening, TClosing> z<List<T>> R(e0<? extends TOpening> e0Var, dj.o<? super TOpening, ? extends e0<? extends TClosing>> oVar) {
        return (z<List<T>>) S(e0Var, oVar, ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    public final xi.a R0(dj.o<? super T, ? extends g> oVar, boolean z10) {
        return S0(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    public final z<T> R1(dj.a aVar) {
        return U1(Functions.h(), Functions.h(), aVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    public final z<T> R4(dj.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "stop is null");
        return O4(Long.MAX_VALUE, Functions.v(eVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <R> z<R> R5(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        if (!(this instanceof fj.m)) {
            return kj.a.U(new ObservableSwitchMap(this, oVar, i10, true));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? e2() : ObservableScalarXMap.a(objCall, oVar);
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> R6() {
        return T6(TimeUnit.MILLISECONDS, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> z<U> S(e0<? extends TOpening> e0Var, dj.o<? super TOpening, ? extends e0<? extends TClosing>> oVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(e0Var, "openingIndicator is null");
        io.reactivex.internal.functions.a.g(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.U(new ObservableBufferBoundary(this, e0Var, oVar, callable));
    }

    @bj.c
    @bj.g("none")
    public final xi.a S0(dj.o<? super T, ? extends g> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.R(new ObservableConcatMapCompletable(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> S1(dj.a aVar) {
        return X1(Functions.h(), aVar);
    }

    @bj.c
    @bj.g("none")
    public final z<T> S4(dj.o<? super z<Throwable>, ? extends e0<?>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "handler is null");
        return kj.a.U(new ObservableRetryWhen(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> S5(@bj.e dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableSwitchMapMaybe(this, oVar, false));
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> S6(TimeUnit timeUnit) {
        return T6(timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <B, U extends Collection<? super T>> z<U> T(e0<B> e0Var, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(e0Var, "boundary is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.l(this, e0Var, callable));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> T0(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return U0(oVar, U(), true);
    }

    @bj.c
    @bj.g("none")
    public final z<T> T1(dj.g<? super y<T>> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNotification is null");
        return U1(Functions.t(gVar), Functions.s(gVar), Functions.r(gVar), Functions.f32981c);
    }

    @bj.g("none")
    public final void T4(g0<? super T> g0Var) {
        io.reactivex.internal.functions.a.g(g0Var, "observer is null");
        if (g0Var instanceof io.reactivex.observers.k) {
            c(g0Var);
        } else {
            c(new io.reactivex.observers.k(g0Var));
        }
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> T5(@bj.e dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableSwitchMapMaybe(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> T6(TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return (z<lj.d<T>>) A3(Functions.w(timeUnit, h0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <R> z<R> U0(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        if (!(this instanceof fj.m)) {
            return kj.a.U(new ObservableConcatMap(this, oVar, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? e2() : ObservableScalarXMap.a(objCall, oVar);
    }

    @bj.c
    @bj.g("none")
    public final z<T> U1(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.g(aVar2, "onAfterTerminate is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.a0(this, gVar, gVar2, aVar, aVar2));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> U4(long j10, TimeUnit timeUnit) {
        return V4(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> z<R> U5(@bj.e dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableSwitchMapSingle(this, oVar, false));
    }

    @bj.c
    @bj.g("none")
    public final z<lj.d<T>> U6(h0 h0Var) {
        return T6(TimeUnit.MILLISECONDS, h0Var);
    }

    @bj.c
    @bj.g("none")
    public final z<T> V() {
        return W(16);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> V0(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return W0(oVar, Integer.MAX_VALUE, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> V1(g0<? super T> g0Var) {
        io.reactivex.internal.functions.a.g(g0Var, "observer is null");
        return U1(ObservableInternalHelper.f(g0Var), ObservableInternalHelper.e(g0Var), ObservableInternalHelper.d(g0Var), Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> V4(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableSampleTimed(this, j10, timeUnit, h0Var, false));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> z<R> V5(@bj.e dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new ObservableSwitchMapSingle(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    public final <R> R V6(dj.o<? super z<T>, R> oVar) {
        try {
            return (R) ((dj.o) io.reactivex.internal.functions.a.g(oVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.c
    @bj.g("none")
    public final z<T> W(int i10) {
        io.reactivex.internal.functions.a.h(i10, "initialCapacity");
        return kj.a.U(new ObservableCache(this, i10));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> W0(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.U(new ObservableConcatMapEager(this, oVar, ErrorMode.IMMEDIATE, i10, i11));
    }

    @bj.c
    @bj.g("none")
    public final z<T> W1(dj.g<? super Throwable> gVar) {
        dj.g<? super T> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return U1(gVarH, gVar, aVar, aVar);
    }

    @bj.c
    @bj.g("none")
    public final <K> z<ij.b<K, T>> W2(dj.o<? super T, ? extends K> oVar) {
        return (z<ij.b<K, T>>) Z2(oVar, Functions.k(), false, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> W3(@bj.e g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.U(new ObservableMergeWithCompletable(this, gVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> W4(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableSampleTimed(this, j10, timeUnit, h0Var, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final j<T> W6(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.g0 g0Var = new io.reactivex.internal.operators.flowable.g0(this);
        int i10 = a.f55355a[backpressureStrategy.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? g0Var.p4() : kj.a.S(new FlowableOnBackpressureError(g0Var)) : g0Var : g0Var.z4() : g0Var.x4();
    }

    @bj.c
    @bj.g("none")
    public final <U> z<U> X(Class<U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return (z<U>) A3(Functions.e(cls));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> X0(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10, int i11, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.U(new ObservableConcatMapEager(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10, i11));
    }

    @bj.c
    @bj.g("none")
    public final z<T> X1(dj.g<? super io.reactivex.disposables.b> gVar, dj.a aVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.g(aVar, "onDispose is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.b0(this, gVar, aVar));
    }

    @bj.c
    @bj.g("none")
    public final <K, V> z<ij.b<K, V>> X2(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        return Z2(oVar, oVar2, false, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> X3(@bj.e w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.U(new ObservableMergeWithMaybe(this, wVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> X4(long j10, TimeUnit timeUnit, boolean z10) {
        return W4(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.c
    @bj.g("none")
    public final Future<T> X6() {
        return (Future) K5(new gj.h());
    }

    @bj.c
    @bj.g("none")
    public final <U> i0<U> Y(Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.g(callable, "initialValueSupplier is null");
        io.reactivex.internal.functions.a.g(bVar, "collector is null");
        return kj.a.V(new io.reactivex.internal.operators.observable.o(this, callable, bVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> Y0(dj.o<? super T, ? extends e0<? extends R>> oVar, boolean z10) {
        return X0(oVar, Integer.MAX_VALUE, U(), z10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> Y1(dj.g<? super T> gVar) {
        dj.g<? super Throwable> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return U1(gVar, gVarH, aVar, aVar);
    }

    @bj.c
    @bj.g("none")
    public final <K, V> z<ij.b<K, V>> Y2(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, boolean z10) {
        return Z2(oVar, oVar2, z10, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> Y3(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return H3(this, e0Var);
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> Y4(e0<U> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "sampler is null");
        return kj.a.U(new ObservableSampleWithObservable(this, e0Var, false));
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> Y6() {
        return Z6(16);
    }

    @bj.c
    @bj.g("none")
    public final <U> i0<U> Z(U u6, dj.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.g(u6, "initialValue is null");
        return Y(Functions.m(u6), bVar);
    }

    @bj.c
    @bj.g("none")
    public final <U> z<U> Z0(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.i0(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> Z1(dj.g<? super io.reactivex.disposables.b> gVar) {
        return X1(gVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    public final <K, V> z<ij.b<K, V>> Z2(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableGroupBy(this, oVar, oVar2, i10, z10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> Z3(@bj.e o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.U(new ObservableMergeWithSingle(this, o0Var));
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> Z4(e0<U> e0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(e0Var, "sampler is null");
        return kj.a.U(new ObservableSampleWithObservable(this, e0Var, z10));
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> Z6(int i10) {
        io.reactivex.internal.functions.a.h(i10, "capacityHint");
        return kj.a.V(new w1(this, i10));
    }

    @bj.c
    @bj.g("none")
    public final <U> z<U> a1(dj.o<? super T, ? extends Iterable<? extends U>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return (z<U>) N0(ObservableInternalHelper.a(oVar), i10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> a2(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onTerminate is null");
        return U1(Functions.h(), Functions.a(aVar), aVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    public final <K> z<ij.b<K, T>> a3(dj.o<? super T, ? extends K> oVar, boolean z10) {
        return (z<ij.b<K, T>>) Z2(oVar, Functions.k(), z10, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> a5(dj.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "accumulator is null");
        return kj.a.U(new h1(this, cVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> a6(long j10) {
        if (j10 >= 0) {
            return kj.a.U(new q1(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final <U extends Collection<? super T>> i0<U> a7(Callable<U> callable) {
        io.reactivex.internal.functions.a.g(callable, "collectionSupplier is null");
        return kj.a.V(new w1(this, callable));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> b1(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return c1(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    public final q<T> b2(long j10) {
        if (j10 >= 0) {
            return kj.a.T(new io.reactivex.internal.operators.observable.d0(this, j10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final <TRight, TLeftEnd, TRightEnd, R> z<R> b3(e0<? extends TRight> e0Var, dj.o<? super T, ? extends e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends e0<TRightEnd>> oVar2, dj.c<? super T, ? super z<TRight>, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        io.reactivex.internal.functions.a.g(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.g(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return kj.a.U(new ObservableGroupJoin(this, e0Var, oVar, oVar2, cVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> b4(h0 h0Var) {
        return d4(h0Var, false, U());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> b5(R r10, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(r10, "initialValue is null");
        return c5(Functions.m(r10), cVar);
    }

    @bj.c
    @bj.g("none")
    public final z<T> b6(long j10, TimeUnit timeUnit) {
        return n6(P6(j10, timeUnit));
    }

    @bj.c
    @bj.g("none")
    public final <K> i0<Map<K, T>> b7(dj.o<? super T, ? extends K> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        return (i0<Map<K, T>>) Y(HashMapSupplier.asCallable(), Functions.F(oVar));
    }

    @Override // xi.e0
    @bj.g("none")
    public final void c(g0<? super T> g0Var) {
        io.reactivex.internal.functions.a.g(g0Var, "observer is null");
        try {
            g0<? super T> g0VarG0 = kj.a.g0(this, g0Var);
            io.reactivex.internal.functions.a.g(g0VarG0, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            I5(g0VarG0);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            kj.a.Y(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> c1(dj.o<? super T, ? extends w<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableConcatMapMaybe(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> c2(long j10, T t10) {
        if (j10 >= 0) {
            io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
            return kj.a.V(new io.reactivex.internal.operators.observable.e0(this, j10, t10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> c3() {
        return kj.a.U(new q0(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> c4(h0 h0Var, boolean z10) {
        return d4(h0Var, z10, U());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> c5(Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.g(cVar, "accumulator is null");
        return kj.a.U(new i1(this, callable, cVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> c6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return n6(Q6(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final <K, V> i0<Map<K, V>> c7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        return (i0<Map<K, V>>) Y(HashMapSupplier.asCallable(), Functions.G(oVar, oVar2));
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> d(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.V(new io.reactivex.internal.operators.observable.f(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> d1(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return f1(oVar, true, 2);
    }

    @bj.c
    @bj.g("none")
    public final i0<T> d2(long j10) {
        if (j10 >= 0) {
            return kj.a.V(new io.reactivex.internal.operators.observable.e0(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final xi.a d3() {
        return kj.a.R(new s0(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> d4(h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableObserveOn(this, h0Var, z10, i10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> d6(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? kj.a.U(new r0(this)) : i10 == 1 ? kj.a.U(new r1(this)) : kj.a.U(new ObservableTakeLast(this, i10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <K, V> i0<Map<K, V>> d7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.g(callable, "mapSupplier is null");
        return (i0<Map<K, V>>) Y(callable, Functions.G(oVar, oVar2));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> e1(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
        return f1(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    public final <U> z<U> e4(Class<U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return h2(Functions.l(cls)).X(cls);
    }

    @bj.c
    @bj.g(bj.g.E)
    public final z<T> e6(long j10, long j11, TimeUnit timeUnit) {
        return g6(j10, j11, timeUnit, lj.b.i(), false, U());
    }

    @bj.c
    @bj.g("none")
    public final <K> i0<Map<K, Collection<T>>> e7(dj.o<? super T, ? extends K> oVar) {
        return (i0<Map<K, Collection<T>>>) h7(oVar, Functions.k(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> e8(Iterable<U> iterable, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(iterable, "other is null");
        io.reactivex.internal.functions.a.g(cVar, "zipper is null");
        return kj.a.U(new z1(this, iterable, cVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> f1(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableConcatMapMaybe(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> f4(dj.o<? super Throwable, ? extends e0<? extends T>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "resumeFunction is null");
        return kj.a.U(new b1(this, oVar, false));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> f6(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return g6(j10, j11, timeUnit, h0Var, false, U());
    }

    @bj.c
    @bj.g("none")
    public final <K, V> i0<Map<K, Collection<V>>> f7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        return h7(oVar, oVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> f8(e0<? extends U> e0Var, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return S7(this, e0Var, cVar);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> g1(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return h1(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    public final z<T> g4(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "next is null");
        return f4(Functions.n(e0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> g6(long j10, long j11, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        if (j10 >= 0) {
            return kj.a.U(new ObservableTakeLastTimed(this, j10, j11, timeUnit, h0Var, i10, z10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    public final <K, V> i0<Map<K, Collection<V>>> g7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return h7(oVar, oVar2, callable, ArrayListSupplier.asFunction());
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> g8(e0<? extends U> e0Var, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return T7(this, e0Var, cVar, z10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> h(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return g(this, e0Var);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> h1(dj.o<? super T, ? extends o0<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableConcatMapSingle(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> h2(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.h0(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> h4(dj.o<? super Throwable, ? extends T> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "valueSupplier is null");
        return kj.a.U(new c1(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> h5() {
        return kj.a.U(new j1(this));
    }

    @bj.c
    @bj.g(bj.g.E)
    public final z<T> h6(long j10, TimeUnit timeUnit) {
        return k6(j10, timeUnit, lj.b.i(), false, U());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <K, V> i0<Map<K, Collection<V>>> h7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, dj.o<? super K, ? extends Collection<? super V>> oVar3) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.g(callable, "mapSupplier is null");
        io.reactivex.internal.functions.a.g(oVar3, "collectionFactory is null");
        return (i0<Map<K, Collection<V>>>) Y(callable, Functions.H(oVar, oVar2, oVar3));
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> h8(e0<? extends U> e0Var, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return U7(this, e0Var, cVar, z10, i10);
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> i(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.V(new io.reactivex.internal.operators.observable.h(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> i1(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return k1(oVar, true, 2);
    }

    @bj.c
    @bj.g("none")
    public final i0<T> i2(T t10) {
        return c2(0L, t10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> i4(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return h4(Functions.n(t10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> i5() {
        return l4().o8();
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> i6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return k6(j10, timeUnit, h0Var, false, U());
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> i7() {
        return k7(Functions.q());
    }

    @bj.c
    @bj.g("none")
    public final <R> R j(@bj.e a0<T, ? extends R> a0Var) {
        return (R) ((a0) io.reactivex.internal.functions.a.g(a0Var, "converter is null")).c(this);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> j1(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
        return k1(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    public final q<T> j2() {
        return b2(0L);
    }

    @bj.c
    @bj.g("none")
    public final z<T> j4(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "next is null");
        return kj.a.U(new b1(this, Functions.n(e0Var), true));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> j5(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return kj.a.V(new l1(this, t10));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> j6(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return k6(j10, timeUnit, h0Var, z10, U());
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> j7(int i10) {
        return l7(Functions.q(), i10);
    }

    @bj.c
    @bj.g("none")
    public final T k() {
        gj.d dVar = new gj.d();
        c(dVar);
        T tA = dVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> k1(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.U(new ObservableConcatMapSingle(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> k2() {
        return d2(0L);
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> k3() {
        return d(Functions.b());
    }

    @bj.c
    @bj.g("none")
    public final z<T> k4() {
        return kj.a.U(new io.reactivex.internal.operators.observable.w(this));
    }

    @bj.c
    @bj.g("none")
    public final q<T> k5() {
        return kj.a.T(new k1(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> k6(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        return g6(Long.MAX_VALUE, j10, timeUnit, h0Var, z10, i10);
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> k7(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        return (i0<List<T>>) Y6().s0(Functions.o(comparator));
    }

    @bj.c
    @bj.g("none")
    public final T l(T t10) {
        gj.d dVar = new gj.d();
        c(dVar);
        T tA = dVar.a();
        return tA != null ? tA : t10;
    }

    @bj.c
    @bj.g("none")
    public final z<T> l1(@bj.e g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.U(new ObservableConcatWithCompletable(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> l2(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        return u2(oVar, false);
    }

    @bj.c
    @bj.g("none")
    public final <TRight, TLeftEnd, TRightEnd, R> z<R> l3(e0<? extends TRight> e0Var, dj.o<? super T, ? extends e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends e0<TRightEnd>> oVar2, dj.c<? super T, ? super TRight, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        io.reactivex.internal.functions.a.g(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.g(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return kj.a.U(new ObservableJoin(this, e0Var, oVar, oVar2, cVar));
    }

    @bj.c
    @bj.g("none")
    public final ij.a<T> l4() {
        return ObservablePublish.u8(this);
    }

    @bj.c
    @bj.g("none")
    public final i0<T> l5() {
        return kj.a.V(new l1(this, null));
    }

    @bj.c
    @bj.g(bj.g.E)
    public final z<T> l6(long j10, TimeUnit timeUnit, boolean z10) {
        return k6(j10, timeUnit, lj.b.i(), z10, U());
    }

    @bj.c
    @bj.g("none")
    public final i0<List<T>> l7(Comparator<? super T> comparator, int i10) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        return (i0<List<T>>) Z6(i10).s0(Functions.o(comparator));
    }

    @bj.g("none")
    public final void m(dj.g<? super T> gVar) {
        Iterator<T> it2 = n().iterator();
        while (it2.hasNext()) {
            try {
                gVar.accept(it2.next());
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                ((io.reactivex.disposables.b) it2).dispose();
                throw ExceptionHelper.f(th2);
            }
        }
    }

    @bj.c
    @bj.g("none")
    public final z<T> m1(@bj.e w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.U(new ObservableConcatWithMaybe(this, wVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> m2(dj.o<? super T, ? extends e0<? extends R>> oVar, int i10) {
        return w2(oVar, false, i10, U());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> m4(dj.o<? super z<T>, ? extends e0<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return kj.a.U(new ObservablePublishSelector(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> m5(long j10) {
        return j10 <= 0 ? kj.a.U(this) : kj.a.U(new m1(this, j10));
    }

    @bj.c
    @bj.g("none")
    public final z<T> m6(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "stopPredicate is null");
        return kj.a.U(new s1(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final Iterable<T> n() {
        return o(U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> n1(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return w0(this, e0Var);
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> n2(dj.o<? super T, ? extends e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        return r2(oVar, cVar, false, U(), U());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> n5(long j10, TimeUnit timeUnit) {
        return v5(P6(j10, timeUnit));
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> n6(e0<U> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return kj.a.U(new ObservableTakeUntil(this, e0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> n7(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableUnsubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final Iterable<T> o(int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return new BlockingObservableIterable(this, i10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> o1(@bj.e o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.U(new ObservableConcatWithSingle(this, o0Var));
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> o2(dj.o<? super T, ? extends e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, int i10) {
        return r2(oVar, cVar, false, i10, U());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> o5(long j10, TimeUnit timeUnit, h0 h0Var) {
        return v5(Q6(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final z<T> o6(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.U(new t1(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final T p() {
        gj.e eVar = new gj.e();
        c(eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> p1(Object obj) {
        io.reactivex.internal.functions.a.g(obj, "element is null");
        return i(Functions.i(obj));
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> p2(dj.o<? super T, ? extends e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return r2(oVar, cVar, z10, U(), U());
    }

    @bj.c
    @bj.g("none")
    public final q<T> p4(dj.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.T(new e1(this, cVar));
    }

    @bj.c
    @bj.g("none")
    public final z<T> p5(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? kj.a.U(this) : kj.a.U(new ObservableSkipLast(this, i10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> p6() {
        TestObserver<T> testObserver = new TestObserver<>();
        c(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final T q(T t10) {
        gj.e eVar = new gj.e();
        c(eVar);
        T tA = eVar.a();
        return tA != null ? tA : t10;
    }

    @bj.c
    @bj.g("none")
    public final i0<Long> q1() {
        return kj.a.V(new io.reactivex.internal.operators.observable.q(this));
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> q2(dj.o<? super T, ? extends e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return r2(oVar, cVar, z10, i10, U());
    }

    @bj.c
    @bj.g("none")
    public final <R> i0<R> q4(R r10, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(r10, "seed is null");
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.V(new f1(this, r10, cVar));
    }

    @bj.c
    @bj.g(bj.g.E)
    public final z<T> q5(long j10, TimeUnit timeUnit) {
        return t5(j10, timeUnit, lj.b.i(), false, U());
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> q6(boolean z10) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z10) {
            testObserver.dispose();
        }
        c(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final z<z<T>> q7(long j10) {
        return s7(j10, j10, U());
    }

    @bj.c
    @bj.g("none")
    public final Iterable<T> r() {
        return new io.reactivex.internal.operators.observable.b(this);
    }

    @bj.c
    @bj.g("none")
    public final <U, R> z<R> r2(dj.o<? super T, ? extends e0<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "combiner is null");
        return w2(ObservableInternalHelper.b(oVar, cVar), z10, i10, i11);
    }

    @bj.c
    @bj.g("none")
    public final <R> i0<R> r4(Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.V(new g1(this, callable, cVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> r5(long j10, TimeUnit timeUnit, h0 h0Var) {
        return t5(j10, timeUnit, h0Var, false, U());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> r6(long j10, TimeUnit timeUnit) {
        return s6(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final z<z<T>> r7(long j10, long j11) {
        return s7(j10, j11, U());
    }

    @bj.c
    @bj.g("none")
    public final Iterable<T> s(T t10) {
        return new io.reactivex.internal.operators.observable.c(this, t10);
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> s0(f0<? super T, ? extends R> f0Var) {
        return P7(((f0) io.reactivex.internal.functions.a.g(f0Var, "composer is null")).c(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> s1(long j10, TimeUnit timeUnit) {
        return t1(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> s2(dj.o<? super T, ? extends e0<? extends R>> oVar, dj.o<? super Throwable, ? extends e0<? extends R>> oVar2, Callable<? extends e0<? extends R>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.g(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.g(callable, "onCompleteSupplier is null");
        return F3(new y0(this, oVar, oVar2, callable));
    }

    @bj.c
    @bj.g("none")
    public final z<T> s4() {
        return t4(Long.MAX_VALUE);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> s5(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return t5(j10, timeUnit, h0Var, z10, U());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> s6(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableThrottleFirstTimed(this, j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final z<z<T>> s7(long j10, long j11, int i10) {
        io.reactivex.internal.functions.a.i(j10, uh.a.C);
        io.reactivex.internal.functions.a.i(j11, com.google.android.material.timepicker.d.C2);
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableWindow(this, j10, j11, i10));
    }

    @bj.c
    @bj.g("none")
    public final Iterable<T> t() {
        return new io.reactivex.internal.operators.observable.d(this);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> t1(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableDebounceTimed(this, j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> t2(dj.o<? super T, ? extends e0<? extends R>> oVar, dj.o<Throwable, ? extends e0<? extends R>> oVar2, Callable<? extends e0<? extends R>> callable, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.g(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.g(callable, "onCompleteSupplier is null");
        return G3(new y0(this, oVar, oVar2, callable), i10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> t4(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? e2() : kj.a.U(new ObservableRepeat(this, j10));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> t5(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.U(new ObservableSkipLastTimed(this, j10, timeUnit, h0Var, i10 << 1, z10));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> t6(long j10, TimeUnit timeUnit) {
        return U4(j10, timeUnit);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<z<T>> t7(long j10, long j11, TimeUnit timeUnit) {
        return v7(j10, j11, timeUnit, lj.b.a(), U());
    }

    @bj.c
    @bj.g("none")
    public final T u() {
        T tH = k5().h();
        if (tH != null) {
            return tH;
        }
        throw new NoSuchElementException();
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> u1(dj.o<? super T, ? extends e0<U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "debounceSelector is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.r(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> u2(dj.o<? super T, ? extends e0<? extends R>> oVar, boolean z10) {
        return v2(oVar, z10, Integer.MAX_VALUE);
    }

    @bj.c
    @bj.g("none")
    public final z<T> u4(dj.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "stop is null");
        return kj.a.U(new ObservableRepeatUntil(this, eVar));
    }

    @bj.c
    @bj.g(bj.g.E)
    public final z<T> u5(long j10, TimeUnit timeUnit, boolean z10) {
        return t5(j10, timeUnit, lj.b.i(), z10, U());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> u6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return V4(j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> u7(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return v7(j10, j11, timeUnit, h0Var, U());
    }

    @bj.c
    @bj.g("none")
    public final T v(T t10) {
        return j5(t10).i();
    }

    @bj.c
    @bj.g("none")
    public final z<T> v1(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return L5(m3(t10));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> v2(dj.o<? super T, ? extends e0<? extends R>> oVar, boolean z10, int i10) {
        return w2(oVar, z10, i10, U());
    }

    @bj.c
    @bj.g("none")
    public final z<T> v4(dj.o<? super z<Object>, ? extends e0<?>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "handler is null");
        return kj.a.U(new ObservableRepeatWhen(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <U> z<T> v5(e0<U> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return kj.a.U(new n1(this, e0Var));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> v6(long j10, TimeUnit timeUnit) {
        return x6(j10, timeUnit, lj.b.a(), false);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> v7(long j10, long j11, TimeUnit timeUnit, h0 h0Var, int i10) {
        io.reactivex.internal.functions.a.i(j10, "timespan");
        io.reactivex.internal.functions.a.i(j11, "timeskip");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        return kj.a.U(new y1(this, j10, j11, timeUnit, h0Var, Long.MAX_VALUE, i10, false));
    }

    @bj.g("none")
    public final void w() {
        io.reactivex.internal.operators.observable.j.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final <R> z<R> w2(dj.o<? super T, ? extends e0<? extends R>> oVar, boolean z10, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "bufferSize");
        if (!(this instanceof fj.m)) {
            return kj.a.U(new ObservableFlatMap(this, oVar, z10, i10, i11));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? e2() : ObservableScalarXMap.a(objCall, oVar);
    }

    @bj.c
    @bj.g("none")
    public final i0<T> w3(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return kj.a.V(new v0(this, t10));
    }

    @bj.c
    @bj.g("none")
    public final ij.a<T> w4() {
        return ObservableReplay.y8(this);
    }

    @bj.c
    @bj.g("none")
    public final z<T> w5(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.U(new o1(this, rVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> w6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return x6(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<z<T>> w7(long j10, TimeUnit timeUnit) {
        return B7(j10, timeUnit, lj.b.a(), Long.MAX_VALUE, false);
    }

    @bj.g("none")
    public final void x(dj.g<? super T> gVar) {
        io.reactivex.internal.operators.observable.j.b(this, gVar, Functions.f32984f, Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> x1(long j10, TimeUnit timeUnit) {
        return z1(j10, timeUnit, lj.b.a(), false);
    }

    @bj.c
    @bj.g("none")
    public final xi.a x2(dj.o<? super T, ? extends g> oVar) {
        return y2(oVar, false);
    }

    @bj.c
    @bj.g("none")
    public final q<T> x3() {
        return kj.a.T(new u0(this));
    }

    @bj.c
    @bj.g("none")
    public final ij.a<T> x4(int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return ObservableReplay.u8(this, i10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> x5() {
        return Y6().v1().A3(Functions.o(Functions.p())).z2(Functions.k());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> x6(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new ObservableThrottleLatest(this, j10, timeUnit, h0Var, z10));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<z<T>> x7(long j10, TimeUnit timeUnit, long j11) {
        return B7(j10, timeUnit, lj.b.a(), j11, false);
    }

    @bj.g("none")
    public final void y(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        io.reactivex.internal.operators.observable.j.b(this, gVar, gVar2, Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> y1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return z1(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g("none")
    public final xi.a y2(dj.o<? super T, ? extends g> oVar, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new ObservableFlatMapCompletableCompletable(this, oVar, z10));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> y3() {
        return kj.a.V(new v0(this, null));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final ij.a<T> y4(int i10, long j10, TimeUnit timeUnit) {
        return z4(i10, j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    public final z<T> y5(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.g(comparator, "sortFunction is null");
        return Y6().v1().A3(Functions.o(comparator)).z2(Functions.k());
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> y6(long j10, TimeUnit timeUnit, boolean z10) {
        return x6(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<z<T>> y7(long j10, TimeUnit timeUnit, long j11, boolean z10) {
        return B7(j10, timeUnit, lj.b.a(), j11, z10);
    }

    @bj.g("none")
    public final void z(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        io.reactivex.internal.operators.observable.j.b(this, gVar, gVar2, aVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<T> z1(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.t(this, j10, timeUnit, h0Var, z10));
    }

    @bj.c
    @bj.g("none")
    public final <U> z<U> z2(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new io.reactivex.internal.operators.observable.i0(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <R> z<R> z3(d0<? extends R, ? super T> d0Var) {
        io.reactivex.internal.functions.a.g(d0Var, "lifter is null");
        return kj.a.U(new w0(this, d0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final ij.a<T> z4(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return ObservableReplay.w8(this, j10, timeUnit, h0Var, i10);
    }

    @bj.c
    @bj.g("none")
    public final z<T> z5(Iterable<? extends T> iterable) {
        return z0(P2(iterable), this);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final z<T> z6(long j10, TimeUnit timeUnit) {
        return s1(j10, timeUnit);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final z<z<T>> z7(long j10, TimeUnit timeUnit, h0 h0Var) {
        return B7(j10, timeUnit, h0Var, Long.MAX_VALUE, false);
    }
}
