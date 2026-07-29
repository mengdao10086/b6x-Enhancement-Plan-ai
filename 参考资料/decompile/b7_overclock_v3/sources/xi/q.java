package xi;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q<T> implements w<T> {
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> A0(Iterable<? extends w<? extends T>> iterable) {
        return y0(j.X2(iterable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> B0(w<? extends T> wVar, w<? extends T> wVar2) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        return F0(wVar, wVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> C0(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        return F0(wVar, wVar2, wVar3);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> D(u<T> uVar) {
        io.reactivex.internal.functions.a.g(uVar, "onSubscribe is null");
        return kj.a.T(new MaybeCreate(uVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> D0(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3, w<? extends T> wVar4) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        return F0(wVar, wVar2, wVar3, wVar4);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> E0(w<? extends w<? extends T>> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "source is null");
        return kj.a.T(new MaybeFlatten(wVar, Functions.k()));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> F(Callable<? extends w<? extends T>> callable) {
        io.reactivex.internal.functions.a.g(callable, "maybeSupplier is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.e(callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> F0(w<? extends T>... wVarArr) {
        io.reactivex.internal.functions.a.g(wVarArr, "sources is null");
        return wVarArr.length == 0 ? j.k2() : wVarArr.length == 1 ? kj.a.S(new MaybeToFlowable(wVarArr[0])) : kj.a.S(new MaybeMergeArray(wVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> G0(w<? extends T>... wVarArr) {
        return wVarArr.length == 0 ? j.k2() : j.R2(wVarArr).B2(MaybeToPublisher.instance(), true, wVarArr.length);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> H0(bu.c<? extends w<? extends T>> cVar) {
        return I0(cVar, Integer.MAX_VALUE);
    }

    @bj.c
    @bj.g(bj.g.B)
    public static q<Long> H1(long j10, TimeUnit timeUnit) {
        return I1(j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> I0(bu.c<? extends w<? extends T>> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "source is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.S(new io.reactivex.internal.operators.flowable.d0(cVar, MaybeToPublisher.instance(), true, i10, 1));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static q<Long> I1(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.T(new MaybeTimer(Math.max(0L, j10), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> J0(Iterable<? extends w<? extends T>> iterable) {
        return j.X2(iterable).A2(MaybeToPublisher.instance(), true);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> K0(w<? extends T> wVar, w<? extends T> wVar2) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        return G0(wVar, wVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> L0(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        return G0(wVar, wVar2, wVar3);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> M0(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3, w<? extends T> wVar4) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        return G0(wVar, wVar2, wVar3, wVar4);
    }

    @bj.c
    @bj.g("none")
    public static <T> q<T> O0() {
        return kj.a.T(io.reactivex.internal.operators.maybe.e0.f33937a);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> O1(w<T> wVar) {
        if (wVar instanceof q) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        io.reactivex.internal.functions.a.g(wVar, "onSubscribe is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.j0(wVar));
    }

    @bj.c
    @bj.g("none")
    public static <T, D> q<T> Q1(Callable<? extends D> callable, dj.o<? super D, ? extends w<? extends T>> oVar, dj.g<? super D> gVar) {
        return R1(callable, oVar, gVar, true);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, D> q<T> R1(Callable<? extends D> callable, dj.o<? super D, ? extends w<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        io.reactivex.internal.functions.a.g(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.g(oVar, "sourceSupplier is null");
        io.reactivex.internal.functions.a.g(gVar, "disposer is null");
        return kj.a.T(new MaybeUsing(callable, oVar, gVar, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> S1(w<T> wVar) {
        if (wVar instanceof q) {
            return kj.a.T((q) wVar);
        }
        io.reactivex.internal.functions.a.g(wVar, "onSubscribe is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.j0(wVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> q<R> T1(Iterable<? extends w<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.k0(iterable, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, R> q<R> U1(w<? extends T1> wVar, w<? extends T2> wVar2, dj.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        return c2(Functions.x(cVar), wVar, wVar2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, R> q<R> V1(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        return c2(Functions.y(hVar), wVar, wVar2, wVar3);
    }

    @bj.c
    @bj.g("none")
    public static <T> q<T> W() {
        return kj.a.T(io.reactivex.internal.operators.maybe.j.f33974a);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, R> q<R> W1(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        return c2(Functions.z(iVar), wVar, wVar2, wVar3, wVar4);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> X(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "exception is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.k(th2));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, R> q<R> X1(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, w<? extends T5> wVar5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(wVar5, "source5 is null");
        return c2(Functions.A(jVar), wVar, wVar2, wVar3, wVar4, wVar5);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> Y(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.g(callable, "errorSupplier is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.l(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, R> q<R> Y1(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, w<? extends T5> wVar5, w<? extends T6> wVar6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(wVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(wVar6, "source6 is null");
        return c2(Functions.B(kVar), wVar, wVar2, wVar3, wVar4, wVar5, wVar6);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, R> q<R> Z1(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, w<? extends T5> wVar5, w<? extends T6> wVar6, w<? extends T7> wVar7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(wVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(wVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(wVar7, "source7 is null");
        return c2(Functions.C(lVar), wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> q<R> a2(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, w<? extends T5> wVar5, w<? extends T6> wVar6, w<? extends T7> wVar7, w<? extends T8> wVar8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(wVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(wVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(wVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(wVar8, "source8 is null");
        return c2(Functions.D(mVar), wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar8);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> q<R> b2(w<? extends T1> wVar, w<? extends T2> wVar2, w<? extends T3> wVar3, w<? extends T4> wVar4, w<? extends T5> wVar5, w<? extends T6> wVar6, w<? extends T7> wVar7, w<? extends T8> wVar8, w<? extends T9> wVar9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(wVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(wVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(wVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(wVar8, "source8 is null");
        io.reactivex.internal.functions.a.g(wVar9, "source9 is null");
        return c2(Functions.E(nVar), wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar8, wVar9);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> c(Iterable<? extends w<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.b(null, iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> q<R> c2(dj.o<? super Object[], ? extends R> oVar, w<? extends T>... wVarArr) {
        io.reactivex.internal.functions.a.g(wVarArr, "sources is null");
        if (wVarArr.length == 0) {
            return W();
        }
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        return kj.a.T(new MaybeZipArray(wVarArr, oVar));
    }

    @bj.c
    @bj.g("none")
    public static <T> q<T> e(w<? extends T>... wVarArr) {
        return wVarArr.length == 0 ? W() : wVarArr.length == 1 ? S1(wVarArr[0]) : kj.a.T(new io.reactivex.internal.operators.maybe.b(wVarArr, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> k0(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "run is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.p(aVar));
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<Boolean> k1(w<? extends T> wVar, w<? extends T> wVar2) {
        return l1(wVar, wVar2, io.reactivex.internal.functions.a.d());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> l0(@bj.e Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.g(callable, "callable is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.q(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<Boolean> l1(w<? extends T> wVar, w<? extends T> wVar2, dj.d<? super T, ? super T> dVar) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(dVar, "isEqual is null");
        return kj.a.V(new MaybeEqualSingle(wVar, wVar2, dVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> m(bu.c<? extends w<? extends T>> cVar) {
        return n(cVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> m0(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "completableSource is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.r(gVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> n(bu.c<? extends w<? extends T>> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new io.reactivex.internal.operators.flowable.n(cVar, MaybeToPublisher.instance(), i10, ErrorMode.IMMEDIATE));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> n0(Future<? extends T> future) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.s(future, 0L, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> o(Iterable<? extends w<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.S(new MaybeConcatIterable(iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> o0(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.s(future, j10, timeUnit));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> p(w<? extends T> wVar, w<? extends T> wVar2) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        return s(wVar, wVar2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> p0(Runnable runnable) {
        io.reactivex.internal.functions.a.g(runnable, "run is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.t(runnable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> q(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        return s(wVar, wVar2, wVar3);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> q0(o0<T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "singleSource is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.u(o0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> r(w<? extends T> wVar, w<? extends T> wVar2, w<? extends T> wVar3, w<? extends T> wVar4) {
        io.reactivex.internal.functions.a.g(wVar, "source1 is null");
        io.reactivex.internal.functions.a.g(wVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(wVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(wVar4, "source4 is null");
        return s(wVar, wVar2, wVar3, wVar4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> s(w<? extends T>... wVarArr) {
        io.reactivex.internal.functions.a.g(wVarArr, "sources is null");
        return wVarArr.length == 0 ? j.k2() : wVarArr.length == 1 ? kj.a.S(new MaybeToFlowable(wVarArr[0])) : kj.a.S(new MaybeConcatArray(wVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> t(w<? extends T>... wVarArr) {
        return wVarArr.length == 0 ? j.k2() : wVarArr.length == 1 ? kj.a.S(new MaybeToFlowable(wVarArr[0])) : kj.a.S(new MaybeConcatArrayDelayError(wVarArr));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> u(w<? extends T>... wVarArr) {
        return j.R2(wVarArr).a1(MaybeToPublisher.instance());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> q<T> u0(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.a0(t10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> v(bu.c<? extends w<? extends T>> cVar) {
        return j.Y2(cVar).Y0(MaybeToPublisher.instance());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> w(Iterable<? extends w<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return j.X2(iterable).Y0(MaybeToPublisher.instance());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> x(bu.c<? extends w<? extends T>> cVar) {
        return j.Y2(cVar).a1(MaybeToPublisher.instance());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> y(Iterable<? extends w<? extends T>> iterable) {
        return j.X2(iterable).a1(MaybeToPublisher.instance());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> y0(bu.c<? extends w<? extends T>> cVar) {
        return z0(cVar, Integer.MAX_VALUE);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> z0(bu.c<? extends w<? extends T>> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "source is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.S(new io.reactivex.internal.operators.flowable.d0(cVar, MaybeToPublisher.instance(), false, i10, 1));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> A(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return p(this, wVar);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.e
    public final q<T> A1(long j10, TimeUnit timeUnit, w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "fallback is null");
        return C1(j10, timeUnit, lj.b.a(), wVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<Boolean> B(Object obj) {
        io.reactivex.internal.functions.a.g(obj, "item is null");
        return kj.a.V(new io.reactivex.internal.operators.maybe.c(this, obj));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final q<T> B1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return F1(I1(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final i0<Long> C() {
        return kj.a.V(new io.reactivex.internal.operators.maybe.d(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final q<T> C1(long j10, TimeUnit timeUnit, h0 h0Var, w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "fallback is null");
        return G1(I1(j10, timeUnit, h0Var), wVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> q<T> D1(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "timeoutIndicator is null");
        return kj.a.T(new MaybeTimeoutPublisher(this, cVar, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> E(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return t1(u0(t10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> q<T> E1(bu.c<U> cVar, w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(cVar, "timeoutIndicator is null");
        io.reactivex.internal.functions.a.g(wVar, "fallback is null");
        return kj.a.T(new MaybeTimeoutPublisher(this, cVar, wVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> q<T> F1(w<U> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "timeoutIndicator is null");
        return kj.a.T(new MaybeTimeoutMaybe(this, wVar, null));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final q<T> G(long j10, TimeUnit timeUnit) {
        return H(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> q<T> G1(w<U> wVar, w<? extends T> wVar2) {
        io.reactivex.internal.functions.a.g(wVar, "timeoutIndicator is null");
        io.reactivex.internal.functions.a.g(wVar2, "fallback is null");
        return kj.a.T(new MaybeTimeoutMaybe(this, wVar, wVar2));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final q<T> H(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.T(new MaybeDelay(this, Math.max(0L, j10), timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U, V> q<T> I(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "delayIndicator is null");
        return kj.a.T(new MaybeDelayOtherPublisher(this, cVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final q<T> J(long j10, TimeUnit timeUnit) {
        return K(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> R J1(dj.o<? super q<T>, R> oVar) {
        try {
            return (R) ((dj.o) io.reactivex.internal.functions.a.g(oVar, "convert is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.c
    @bj.g(bj.g.A)
    public final q<T> K(long j10, TimeUnit timeUnit, h0 h0Var) {
        return L(j.v7(j10, timeUnit, h0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> K1() {
        return this instanceof fj.b ? ((fj.b) this).d() : kj.a.S(new MaybeToFlowable(this));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> q<T> L(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "subscriptionIndicator is null");
        return kj.a.T(new MaybeDelaySubscriptionOtherPublisher(this, cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final z<T> L1() {
        return this instanceof fj.d ? ((fj.d) this).b() : kj.a.U(new MaybeToObservable(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> M(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onAfterSuccess is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.g(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> M1() {
        return kj.a.V(new io.reactivex.internal.operators.maybe.i0(this, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> N(dj.a aVar) {
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVarH, gVarH2, gVarH3, aVar2, (dj.a) io.reactivex.internal.functions.a.g(aVar, "onAfterTerminate is null"), aVar2));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> N0(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return B0(this, wVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> N1(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultValue is null");
        return kj.a.V(new io.reactivex.internal.operators.maybe.i0(this, t10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> O(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return kj.a.T(new MaybeDoFinally(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> P(dj.a aVar) {
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = (dj.a) io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        dj.a aVar3 = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVarH, gVarH2, gVarH3, aVar2, aVar3, aVar3));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final q<T> P0(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.T(new MaybeObserveOn(this, h0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final q<T> P1(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.T(new MaybeUnsubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> Q(dj.a aVar) {
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVarH, gVarH2, gVarH3, aVar2, aVar2, (dj.a) io.reactivex.internal.functions.a.g(aVar, "onDispose is null")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> q<U> Q0(Class<U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return Z(Functions.l(cls)).k(cls);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> R(dj.g<? super Throwable> gVar) {
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVar2 = (dj.g) io.reactivex.internal.functions.a.g(gVar, "onError is null");
        dj.a aVar = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVarH, gVarH2, gVar2, aVar, aVar, aVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> R0() {
        return S0(Functions.c());
    }

    @bj.c
    @bj.g("none")
    public final q<T> S(dj.b<? super T, ? super Throwable> bVar) {
        io.reactivex.internal.functions.a.g(bVar, "onEvent is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.h(this, bVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> S0(dj.r<? super Throwable> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.f0(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> T(dj.g<? super io.reactivex.disposables.b> gVar) {
        dj.g gVar2 = (dj.g) io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVar2, gVarH, gVarH2, aVar, aVar, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> T0(dj.o<? super Throwable, ? extends w<? extends T>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "resumeFunction is null");
        return kj.a.T(new MaybeOnErrorNext(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> U(dj.g<? super T> gVar) {
        dj.g gVarH = Functions.h();
        dj.g gVar2 = (dj.g) io.reactivex.internal.functions.a.g(gVar, "onSuccess is null");
        dj.g gVarH2 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.T(new io.reactivex.internal.operators.maybe.h0(this, gVarH, gVar2, gVarH2, aVar, aVar, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> U0(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "next is null");
        return T0(Functions.n(wVar));
    }

    @bj.g("none")
    @bj.d
    @bj.c
    @bj.e
    public final q<T> V(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onTerminate is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.i(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> V0(dj.o<? super Throwable, ? extends T> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "valueSupplier is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.g0(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> W0(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return V0(Functions.n(t10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> X0(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "next is null");
        return kj.a.T(new MaybeOnErrorNext(this, Functions.n(wVar), false));
    }

    @bj.c
    @bj.g("none")
    public final q<T> Y0() {
        return kj.a.T(new io.reactivex.internal.operators.maybe.f(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> Z(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.m(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Z0() {
        return a1(Long.MAX_VALUE);
    }

    @Override // xi.w
    @bj.g("none")
    public final void a(t<? super T> tVar) {
        io.reactivex.internal.functions.a.g(tVar, "observer is null");
        t<? super T> tVarF0 = kj.a.f0(this, tVar);
        io.reactivex.internal.functions.a.g(tVarF0, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            q1(tVarF0);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> a0(dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.T(new MaybeFlatten(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> a1(long j10) {
        return K1().U4(j10);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U, R> q<R> b0(dj.o<? super T, ? extends w<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return kj.a.T(new MaybeFlatMapBiSelector(this, oVar, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> b1(dj.e eVar) {
        return K1().V4(eVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> c0(dj.o<? super T, ? extends w<? extends R>> oVar, dj.o<? super Throwable, ? extends w<? extends R>> oVar2, Callable<? extends w<? extends R>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "onSuccessMapper is null");
        io.reactivex.internal.functions.a.g(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.g(callable, "onCompleteSupplier is null");
        return kj.a.T(new MaybeFlatMapNotification(this, oVar, oVar2, callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> c1(dj.o<? super j<Object>, ? extends bu.c<?>> oVar) {
        return K1().W4(oVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a d0(dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new MaybeFlatMapCompletable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> d1() {
        return f1(Long.MAX_VALUE, Functions.c());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U, R> q<R> d2(w<? extends U> wVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return U1(this, wVar, cVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> z<R> e0(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new MaybeFlatMapObservable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> e1(long j10) {
        return f1(j10, Functions.c());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> f(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return e(this, wVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> f0(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new MaybeFlatMapPublisher(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> f1(long j10, dj.r<? super Throwable> rVar) {
        return K1().p5(j10, rVar).L5();
    }

    @bj.c
    @bj.g("none")
    public final <R> R g(@bj.e r<T, ? extends R> rVar) {
        return (R) ((r) io.reactivex.internal.functions.a.g(rVar, "converter is null")).b(this);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> i0<R> g0(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.V(new MaybeFlatMapSingle(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> g1(dj.d<? super Integer, ? super Throwable> dVar) {
        return K1().q5(dVar).L5();
    }

    @bj.c
    @bj.g("none")
    public final T h() {
        gj.f fVar = new gj.f();
        a(fVar);
        return (T) fVar.b();
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> h0(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.T(new MaybeFlatMapSingleElement(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> h1(dj.r<? super Throwable> rVar) {
        return f1(Long.MAX_VALUE, rVar);
    }

    @bj.c
    @bj.g("none")
    public final T i(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultValue is null");
        gj.f fVar = new gj.f();
        a(fVar);
        return (T) fVar.c(t10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<U> i0(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new MaybeFlatMapIterableFlowable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> i1(dj.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "stop is null");
        return f1(Long.MAX_VALUE, Functions.v(eVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> j() {
        return kj.a.T(new MaybeCache(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> z<U> j0(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new io.reactivex.internal.operators.maybe.o(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final q<T> j1(dj.o<? super j<Throwable>, ? extends bu.c<?>> oVar) {
        return K1().t5(oVar).L5();
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> q<U> k(Class<? extends U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return (q<U>) w0(Functions.e(cls));
    }

    @bj.c
    @bj.g("none")
    public final <R> q<R> l(x<? super T, ? extends R> xVar) {
        return S1(((x) io.reactivex.internal.functions.a.g(xVar, "transformer is null")).b(this));
    }

    @bj.g("none")
    public final io.reactivex.disposables.b m1() {
        return p1(Functions.h(), Functions.f32984f, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b n1(dj.g<? super T> gVar) {
        return p1(gVar, Functions.f32984f, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b o1(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        return p1(gVar, gVar2, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final io.reactivex.disposables.b p1(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSuccess is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        return (io.reactivex.disposables.b) s1(new MaybeCallbackObserver(gVar, gVar2, aVar));
    }

    public abstract void q1(t<? super T> tVar);

    @bj.c
    @bj.g("none")
    public final q<T> r0() {
        return kj.a.T(new io.reactivex.internal.operators.maybe.v(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final q<T> r1(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.T(new MaybeSubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    public final a s0() {
        return kj.a.R(new io.reactivex.internal.operators.maybe.x(this));
    }

    @bj.c
    @bj.g("none")
    public final <E extends t<? super T>> E s1(E e10) {
        a(e10);
        return e10;
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> t0() {
        return kj.a.V(new io.reactivex.internal.operators.maybe.z(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> t1(w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.T(new MaybeSwitchIfEmpty(this, wVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> u1(o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.V(new MaybeSwitchIfEmptySingle(this, o0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> v0(v<? extends R, ? super T> vVar) {
        io.reactivex.internal.functions.a.g(vVar, "lift is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.b0(this, vVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> q<T> v1(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.T(new MaybeTakeUntilPublisher(this, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> w0(dj.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.c0(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> q<T> w1(w<U> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.T(new MaybeTakeUntilMaybe(this, wVar));
    }

    @bj.d
    @bj.c
    @bj.g("none")
    public final i0<y<T>> x0() {
        return kj.a.V(new io.reactivex.internal.operators.maybe.d0(this));
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> x1() {
        TestObserver<T> testObserver = new TestObserver<>();
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> y1(boolean z10) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z10) {
            testObserver.cancel();
        }
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> z(dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.T(new MaybeFlatten(this, oVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final q<T> z1(long j10, TimeUnit timeUnit) {
        return B1(j10, timeUnit, lj.b.a());
    }
}
