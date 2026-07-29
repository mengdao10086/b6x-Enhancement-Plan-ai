package xi;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.a1;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.l1;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i0<T> implements o0<T> {
    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> A(m0<T> m0Var) {
        io.reactivex.internal.functions.a.g(m0Var, "source is null");
        return kj.a.V(new SingleCreate(m0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> A0(bu.c<? extends o0<? extends T>> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.d0(cVar, SingleInternalHelper.c(), true, Integer.MAX_VALUE, j.Y()));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, U> i0<T> A1(Callable<U> callable, dj.o<? super U, ? extends o0<? extends T>> oVar, dj.g<? super U> gVar, boolean z10) {
        io.reactivex.internal.functions.a.g(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.g(oVar, "singleFunction is null");
        io.reactivex.internal.functions.a.g(gVar, "disposer is null");
        return kj.a.V(new SingleUsing(callable, oVar, gVar, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> B(Callable<? extends o0<? extends T>> callable) {
        io.reactivex.internal.functions.a.g(callable, "singleSupplier is null");
        return kj.a.V(new io.reactivex.internal.operators.single.c(callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> B0(Iterable<? extends o0<? extends T>> iterable) {
        return A0(j.X2(iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> B1(o0<T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "source is null");
        return o0Var instanceof i0 ? kj.a.V((i0) o0Var) : kj.a.V(new io.reactivex.internal.operators.single.r(o0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> C0(o0<? extends T> o0Var, o0<? extends T> o0Var2) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        return A0(j.R2(o0Var, o0Var2));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> i0<R> C1(Iterable<? extends o0<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.V(new io.reactivex.internal.operators.single.z(iterable, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> D0(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        return A0(j.R2(o0Var, o0Var2, o0Var3));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, R> i0<R> D1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, dj.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        return L1(Functions.x(cVar), o0Var, o0Var2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> E0(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3, o0<? extends T> o0Var4) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        return A0(j.R2(o0Var, o0Var2, o0Var3, o0Var4));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, R> i0<R> E1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        return L1(Functions.y(hVar), o0Var, o0Var2, o0Var3);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, R> i0<R> F1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        return L1(Functions.z(iVar), o0Var, o0Var2, o0Var3, o0Var4);
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<T> G0() {
        return kj.a.V(io.reactivex.internal.operators.single.x.f35084a);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, R> i0<R> G1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, o0<? extends T5> o0Var5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(o0Var5, "source5 is null");
        return L1(Functions.A(jVar), o0Var, o0Var2, o0Var3, o0Var4, o0Var5);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, R> i0<R> H1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, o0<? extends T5> o0Var5, o0<? extends T6> o0Var6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(o0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(o0Var6, "source6 is null");
        return L1(Functions.B(kVar), o0Var, o0Var2, o0Var3, o0Var4, o0Var5, o0Var6);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, R> i0<R> I1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, o0<? extends T5> o0Var5, o0<? extends T6> o0Var6, o0<? extends T7> o0Var7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(o0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(o0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(o0Var7, "source7 is null");
        return L1(Functions.C(lVar), o0Var, o0Var2, o0Var3, o0Var4, o0Var5, o0Var6, o0Var7);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> i0<R> J1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, o0<? extends T5> o0Var5, o0<? extends T6> o0Var6, o0<? extends T7> o0Var7, o0<? extends T8> o0Var8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(o0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(o0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(o0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(o0Var8, "source8 is null");
        return L1(Functions.D(mVar), o0Var, o0Var2, o0Var3, o0Var4, o0Var5, o0Var6, o0Var7, o0Var8);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> i0<R> K1(o0<? extends T1> o0Var, o0<? extends T2> o0Var2, o0<? extends T3> o0Var3, o0<? extends T4> o0Var4, o0<? extends T5> o0Var5, o0<? extends T6> o0Var6, o0<? extends T7> o0Var7, o0<? extends T8> o0Var8, o0<? extends T9> o0Var9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        io.reactivex.internal.functions.a.g(o0Var5, "source5 is null");
        io.reactivex.internal.functions.a.g(o0Var6, "source6 is null");
        io.reactivex.internal.functions.a.g(o0Var7, "source7 is null");
        io.reactivex.internal.functions.a.g(o0Var8, "source8 is null");
        io.reactivex.internal.functions.a.g(o0Var9, "source9 is null");
        return L1(Functions.E(nVar), o0Var, o0Var2, o0Var3, o0Var4, o0Var5, o0Var6, o0Var7, o0Var8, o0Var9);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T, R> i0<R> L1(dj.o<? super Object[], ? extends R> oVar, o0<? extends T>... o0VarArr) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(o0VarArr, "sources is null");
        return o0VarArr.length == 0 ? X(new NoSuchElementException()) : kj.a.V(new SingleZipArray(o0VarArr, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<Boolean> W(o0<? extends T> o0Var, o0<? extends T> o0Var2) {
        io.reactivex.internal.functions.a.g(o0Var, "first is null");
        io.reactivex.internal.functions.a.g(o0Var2, "second is null");
        return kj.a.V(new io.reactivex.internal.operators.single.n(o0Var, o0Var2));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> X(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "exception is null");
        return Y(Functions.m(th2));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> Y(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.g(callable, "errorSupplier is null");
        return kj.a.V(new io.reactivex.internal.operators.single.o(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> e(Iterable<? extends o0<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.V(new io.reactivex.internal.operators.single.a(null, iterable));
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<T> f(o0<? extends T>... o0VarArr) {
        return o0VarArr.length == 0 ? Y(SingleInternalHelper.a()) : o0VarArr.length == 1 ? B1(o0VarArr[0]) : kj.a.V(new io.reactivex.internal.operators.single.a(o0VarArr, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> h0(Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.g(callable, "callable is null");
        return kj.a.V(new io.reactivex.internal.operators.single.p(callable));
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<T> i0(Future<? extends T> future) {
        return w1(j.T2(future));
    }

    @bj.c
    @bj.g("none")
    public static <T> i0<T> j0(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        return w1(j.U2(future, j10, timeUnit));
    }

    @bj.c
    @bj.g(bj.g.A)
    public static <T> i0<T> k0(Future<? extends T> future, long j10, TimeUnit timeUnit, h0 h0Var) {
        return w1(j.V2(future, j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    public static <T> i0<T> l0(Future<? extends T> future, h0 h0Var) {
        return w1(j.W2(future, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> m(bu.c<? extends o0<? extends T>> cVar) {
        return n(cVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> m0(e0<? extends T> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "observableSource is null");
        return kj.a.V(new l1(e0Var, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> n(bu.c<? extends o0<? extends T>> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new io.reactivex.internal.operators.flowable.n(cVar, SingleInternalHelper.c(), i10, ErrorMode.IMMEDIATE));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public static <T> i0<T> n0(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "publisher is null");
        return kj.a.V(new io.reactivex.internal.operators.single.q(cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> o(Iterable<? extends o0<? extends T>> iterable) {
        return m(j.X2(iterable));
    }

    @bj.c
    @bj.g(bj.g.B)
    public static i0<Long> o1(long j10, TimeUnit timeUnit) {
        return p1(j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> p(o0<? extends T> o0Var, o0<? extends T> o0Var2) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        return m(j.R2(o0Var, o0Var2));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public static i0<Long> p1(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new SingleTimer(j10, timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> q(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        return m(j.R2(o0Var, o0Var2, o0Var3));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> q0(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return kj.a.V(new io.reactivex.internal.operators.single.t(t10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> r(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3, o0<? extends T> o0Var4) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        return m(j.R2(o0Var, o0Var2, o0Var3, o0Var4));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> z<T> s(e0<? extends o0<? extends T>> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "sources is null");
        return kj.a.U(new ObservableConcatMap(e0Var, SingleInternalHelper.d(), 2, ErrorMode.IMMEDIATE));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> t(o0<? extends T>... o0VarArr) {
        return kj.a.S(new FlowableConcatMap(j.R2(o0VarArr), SingleInternalHelper.c(), 2, ErrorMode.BOUNDARY));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> u(o0<? extends T>... o0VarArr) {
        return j.R2(o0VarArr).a1(SingleInternalHelper.c());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> u0(bu.c<? extends o0<? extends T>> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.d0(cVar, SingleInternalHelper.c(), false, Integer.MAX_VALUE, j.Y()));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> v(bu.c<? extends o0<? extends T>> cVar) {
        return j.Y2(cVar).a1(SingleInternalHelper.c());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> v0(Iterable<? extends o0<? extends T>> iterable) {
        return u0(j.X2(iterable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> w(Iterable<? extends o0<? extends T>> iterable) {
        return j.X2(iterable).a1(SingleInternalHelper.c());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> w0(o0<? extends T> o0Var, o0<? extends T> o0Var2) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        return u0(j.R2(o0Var, o0Var2));
    }

    public static <T> i0<T> w1(j<T> jVar) {
        return kj.a.V(new a1(jVar, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> x0(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        return u0(j.R2(o0Var, o0Var2, o0Var3));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> x1(o0<T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "onSubscribe is null");
        if (o0Var instanceof i0) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return kj.a.V(new io.reactivex.internal.operators.single.r(o0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> y0(o0<? extends T> o0Var, o0<? extends T> o0Var2, o0<? extends T> o0Var3, o0<? extends T> o0Var4) {
        io.reactivex.internal.functions.a.g(o0Var, "source1 is null");
        io.reactivex.internal.functions.a.g(o0Var2, "source2 is null");
        io.reactivex.internal.functions.a.g(o0Var3, "source3 is null");
        io.reactivex.internal.functions.a.g(o0Var4, "source4 is null");
        return u0(j.R2(o0Var, o0Var2, o0Var3, o0Var4));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public static <T> i0<T> z0(o0<? extends o0<? extends T>> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "source is null");
        return kj.a.V(new SingleFlatMap(o0Var, Functions.k()));
    }

    @bj.c
    @bj.g("none")
    public static <T, U> i0<T> z1(Callable<U> callable, dj.o<? super U, ? extends o0<? extends T>> oVar, dj.g<? super U> gVar) {
        return A1(callable, oVar, gVar, true);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final i0<T> C(long j10, TimeUnit timeUnit) {
        return E(j10, timeUnit, lj.b.a(), false);
    }

    @bj.c
    @bj.g(bj.g.A)
    public final i0<T> D(long j10, TimeUnit timeUnit, h0 h0Var) {
        return E(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final i0<T> E(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new io.reactivex.internal.operators.single.d(this, j10, timeUnit, h0Var, z10));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final i0<T> F(long j10, TimeUnit timeUnit, boolean z10) {
        return E(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> F0(o0<? extends T> o0Var) {
        return w0(this, o0Var);
    }

    @bj.c
    @bj.g(bj.g.B)
    public final i0<T> G(long j10, TimeUnit timeUnit) {
        return H(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g(bj.g.A)
    public final i0<T> H(long j10, TimeUnit timeUnit, h0 h0Var) {
        return K(z.Q6(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final i0<T> H0(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new SingleObserveOn(this, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> i0<T> I(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.V(new SingleDelayWithPublisher(this, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> I0(dj.o<? super Throwable, ? extends o0<? extends T>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "resumeFunctionInCaseOfError is null");
        return kj.a.V(new SingleResumeNext(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> J(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.V(new SingleDelayWithCompletable(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> J0(i0<? extends T> i0Var) {
        io.reactivex.internal.functions.a.g(i0Var, "resumeSingleInCaseOfError is null");
        return I0(Functions.n(i0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> i0<T> K(e0<U> e0Var) {
        io.reactivex.internal.functions.a.g(e0Var, "other is null");
        return kj.a.V(new SingleDelayWithObservable(this, e0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> K0(dj.o<Throwable, ? extends T> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "resumeFunction is null");
        return kj.a.V(new io.reactivex.internal.operators.single.y(this, oVar, null));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> i0<T> L(o0<U> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.V(new SingleDelayWithSingle(this, o0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> L0(T t10) {
        io.reactivex.internal.functions.a.g(t10, "value is null");
        return kj.a.V(new io.reactivex.internal.operators.single.y(this, null, t10));
    }

    @bj.g("none")
    @bj.d
    @bj.c
    @bj.e
    public final <R> q<R> M(dj.o<? super T, y<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return kj.a.T(new io.reactivex.internal.operators.single.e(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> M0() {
        return kj.a.V(new io.reactivex.internal.operators.single.f(this));
    }

    @bj.c
    @bj.g("none")
    public final <U, R> i0<R> M1(o0<U> o0Var, dj.c<? super T, ? super U, ? extends R> cVar) {
        return D1(this, o0Var, cVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> N(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onAfterSuccess is null");
        return kj.a.V(new io.reactivex.internal.operators.single.g(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> N0() {
        return s1().T4();
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> O(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onAfterTerminate is null");
        return kj.a.V(new io.reactivex.internal.operators.single.h(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> O0(long j10) {
        return s1().U4(j10);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> P(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return kj.a.V(new SingleDoFinally(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> P0(dj.e eVar) {
        return s1().V4(eVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> Q(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onDispose is null");
        return kj.a.V(new SingleDoOnDispose(this, aVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Q0(dj.o<? super j<Object>, ? extends bu.c<?>> oVar) {
        return s1().W4(oVar);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> R(dj.g<? super Throwable> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onError is null");
        return kj.a.V(new io.reactivex.internal.operators.single.i(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> R0() {
        return w1(s1().n5());
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> S(dj.b<? super T, ? super Throwable> bVar) {
        io.reactivex.internal.functions.a.g(bVar, "onEvent is null");
        return kj.a.V(new io.reactivex.internal.operators.single.j(this, bVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> S0(long j10) {
        return w1(s1().o5(j10));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> T(dj.g<? super io.reactivex.disposables.b> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        return kj.a.V(new io.reactivex.internal.operators.single.k(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> T0(long j10, dj.r<? super Throwable> rVar) {
        return w1(s1().p5(j10, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> U(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSuccess is null");
        return kj.a.V(new io.reactivex.internal.operators.single.l(this, gVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> U0(dj.d<? super Integer, ? super Throwable> dVar) {
        return w1(s1().q5(dVar));
    }

    @bj.g("none")
    @bj.d
    @bj.c
    @bj.e
    public final i0<T> V(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onTerminate is null");
        return kj.a.V(new io.reactivex.internal.operators.single.m(this, aVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> V0(dj.r<? super Throwable> rVar) {
        return w1(s1().r5(rVar));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> W0(dj.o<? super j<Throwable>, ? extends bu.c<?>> oVar) {
        return w1(s1().t5(oVar));
    }

    @bj.g("none")
    public final io.reactivex.disposables.b X0() {
        return a1(Functions.h(), Functions.f32984f);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final io.reactivex.disposables.b Y0(dj.b<? super T, ? super Throwable> bVar) {
        io.reactivex.internal.functions.a.g(bVar, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(bVar);
        a(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final q<T> Z(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.T(new io.reactivex.internal.operators.maybe.n(this, rVar));
    }

    @bj.c
    @bj.g("none")
    public final io.reactivex.disposables.b Z0(dj.g<? super T> gVar) {
        return a1(gVar, Functions.f32984f);
    }

    @Override // xi.o0
    @bj.g("none")
    public final void a(l0<? super T> l0Var) {
        io.reactivex.internal.functions.a.g(l0Var, "observer is null");
        l0<? super T> l0VarH0 = kj.a.h0(this, l0Var);
        io.reactivex.internal.functions.a.g(l0VarH0, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b1(l0VarH0);
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
    public final <R> i0<R> a0(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.V(new SingleFlatMap(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final io.reactivex.disposables.b a1(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        io.reactivex.internal.functions.a.g(gVar, "onSuccess is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(gVar, gVar2);
        a(consumerSingleObserver);
        return consumerSingleObserver;
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final a b0(dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new SingleFlatMapCompletable(this, oVar));
    }

    public abstract void b1(@bj.e l0<? super T> l0Var);

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> q<R> c0(dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.T(new SingleFlatMapMaybe(this, oVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final i0<T> c1(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new SingleSubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> z<R> d0(dj.o<? super T, ? extends e0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new SingleFlatMapObservable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    public final <E extends l0<? super T>> E d1(E e10) {
        a(e10);
        return e10;
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> e0(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new SingleFlatMapPublisher(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <E> i0<T> e1(bu.c<E> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.V(new SingleTakeUntil(this, cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<U> f0(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new SingleFlatMapIterableFlowable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> f1(g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return e1(new io.reactivex.internal.operators.completable.y(gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<T> g(o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return f(this, o0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> z<U> g0(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.U(new SingleFlatMapIterableObservable(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <E> i0<T> g1(o0<? extends E> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return e1(new SingleToFlowable(o0Var));
    }

    @bj.c
    @bj.g("none")
    public final <R> R h(@bj.e j0<T, ? extends R> j0Var) {
        return (R) ((j0) io.reactivex.internal.functions.a.g(j0Var, "converter is null")).e(this);
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> h1() {
        TestObserver<T> testObserver = new TestObserver<>();
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final T i() {
        gj.f fVar = new gj.f();
        a(fVar);
        return (T) fVar.b();
    }

    @bj.c
    @bj.g("none")
    public final TestObserver<T> i1(boolean z10) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z10) {
            testObserver.cancel();
        }
        a(testObserver);
        return testObserver;
    }

    @bj.c
    @bj.g("none")
    public final i0<T> j() {
        return kj.a.V(new SingleCache(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    public final i0<T> j1(long j10, TimeUnit timeUnit) {
        return n1(j10, timeUnit, lj.b.a(), null);
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <U> i0<U> k(Class<? extends U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return (i0<U>) s0(Functions.e(cls));
    }

    @bj.c
    @bj.g(bj.g.A)
    public final i0<T> k1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return n1(j10, timeUnit, h0Var, null);
    }

    @bj.c
    @bj.g("none")
    public final <R> i0<R> l(p0<? super T, ? extends R> p0Var) {
        return B1(((p0) io.reactivex.internal.functions.a.g(p0Var, "transformer is null")).e(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final i0<T> l1(long j10, TimeUnit timeUnit, h0 h0Var, o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return n1(j10, timeUnit, h0Var, o0Var);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.e
    public final i0<T> m1(long j10, TimeUnit timeUnit, o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return n1(j10, timeUnit, lj.b.a(), o0Var);
    }

    public final i0<T> n1(long j10, TimeUnit timeUnit, h0 h0Var, o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new SingleTimeout(this, j10, timeUnit, h0Var, o0Var));
    }

    @bj.c
    @bj.g("none")
    public final i0<T> o0() {
        return kj.a.V(new io.reactivex.internal.operators.single.s(this));
    }

    @bj.c
    @bj.g("none")
    public final a p0() {
        return kj.a.R(new io.reactivex.internal.operators.completable.n(this));
    }

    @bj.c
    @bj.g("none")
    public final <R> R q1(dj.o<? super i0<T>, R> oVar) {
        try {
            return (R) ((dj.o) io.reactivex.internal.functions.a.g(oVar, "convert is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> i0<R> r0(n0<? extends R, ? super T> n0Var) {
        io.reactivex.internal.functions.a.g(n0Var, "lift is null");
        return kj.a.V(new io.reactivex.internal.operators.single.u(this, n0Var));
    }

    @bj.c
    @bj.g("none")
    @Deprecated
    public final a r1() {
        return kj.a.R(new io.reactivex.internal.operators.completable.n(this));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final <R> i0<R> s0(dj.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.V(new io.reactivex.internal.operators.single.v(this, oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> s1() {
        return this instanceof fj.b ? ((fj.b) this).d() : kj.a.S(new SingleToFlowable(this));
    }

    @bj.d
    @bj.c
    @bj.g("none")
    public final i0<y<T>> t0() {
        return kj.a.V(new io.reactivex.internal.operators.single.w(this));
    }

    @bj.c
    @bj.g("none")
    public final Future<T> t1() {
        return (Future) d1(new gj.i());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final q<T> u1() {
        return this instanceof fj.c ? ((fj.c) this).c() : kj.a.T(new io.reactivex.internal.operators.maybe.u(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    public final z<T> v1() {
        return this instanceof fj.d ? ((fj.d) this).b() : kj.a.U(new SingleToObservable(this));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> x(o0<? extends T> o0Var) {
        return p(this, o0Var);
    }

    @bj.c
    @bj.g("none")
    public final i0<Boolean> y(Object obj) {
        return z(obj, io.reactivex.internal.functions.a.d());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.e
    public final i0<T> y1(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.V(new SingleUnsubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.e
    public final i0<Boolean> z(Object obj, dj.d<Object, Object> dVar) {
        io.reactivex.internal.functions.a.g(obj, "value is null");
        io.reactivex.internal.functions.a.g(dVar, "comparer is null");
        return kj.a.V(new io.reactivex.internal.operators.single.b(this, obj, dVar));
    }
}
