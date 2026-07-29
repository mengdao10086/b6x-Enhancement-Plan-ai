package xi;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.a1;
import io.reactivex.internal.operators.flowable.b1;
import io.reactivex.internal.operators.flowable.c1;
import io.reactivex.internal.operators.flowable.d1;
import io.reactivex.internal.operators.flowable.f1;
import io.reactivex.internal.operators.flowable.g1;
import io.reactivex.internal.operators.flowable.h1;
import io.reactivex.internal.operators.flowable.i1;
import io.reactivex.internal.operators.flowable.j1;
import io.reactivex.internal.operators.flowable.k1;
import io.reactivex.internal.operators.flowable.l1;
import io.reactivex.internal.operators.flowable.r0;
import io.reactivex.internal.operators.flowable.t0;
import io.reactivex.internal.operators.flowable.u0;
import io.reactivex.internal.operators.flowable.v0;
import io.reactivex.internal.operators.flowable.w0;
import io.reactivex.internal.operators.flowable.x0;
import io.reactivex.internal.operators.flowable.y0;
import io.reactivex.internal.operators.flowable.z0;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.subscribers.TestSubscriber;
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
public abstract class j<T> implements bu.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f55352a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> A0(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return E0(cVar, cVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> A3(T t10, T t11, T t12, T t13, T t14, T t15) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        return R2(t10, t11, t12, t13, t14, t15);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> A6(bu.c<? extends bu.c<? extends T>> cVar) {
        return Y2(cVar).p6(Functions.k());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, R> j<R> A8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return G8(Functions.y(hVar), false, Y(), cVar, cVar2, cVar3);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> B0(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return E0(cVar, cVar2, cVar3);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> B1(Callable<? extends bu.c<? extends T>> callable) {
        io.reactivex.internal.functions.a.g(callable, "supplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.p(callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> B3(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        return R2(t10, t11, t12, t13, t14, t15, t16);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> B6(bu.c<? extends bu.c<? extends T>> cVar, int i10) {
        return Y2(cVar).q6(Functions.k(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, R> j<R> B8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, dj.c<? super T1, ? super T2, ? extends R> cVar3) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return G8(Functions.x(cVar3), false, Y(), cVar, cVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> C0(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3, bu.c<? extends T> cVar4) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return E0(cVar, cVar2, cVar3, cVar4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> C3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        io.reactivex.internal.functions.a.g(t17, "item8 is null");
        return R2(t10, t11, t12, t13, t14, t15, t16, t17);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> C6(bu.c<? extends bu.c<? extends T>> cVar) {
        return D6(cVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, R> j<R> C8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, dj.c<? super T1, ? super T2, ? extends R> cVar3, boolean z10) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return G8(Functions.x(cVar3), z10, Y(), cVar, cVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> D0(Iterable<? extends bu.c<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return X2(iterable).Z0(Functions.k(), 2, false);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> D3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        io.reactivex.internal.functions.a.g(t15, "item6 is null");
        io.reactivex.internal.functions.a.g(t16, "item7 is null");
        io.reactivex.internal.functions.a.g(t17, "item8 is null");
        io.reactivex.internal.functions.a.g(t18, "item9 is null");
        return R2(t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> D6(bu.c<? extends bu.c<? extends T>> cVar, int i10) {
        return Y2(cVar).v6(Functions.k(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, R> j<R> D8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, dj.c<? super T1, ? super T2, ? extends R> cVar3, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return G8(Functions.x(cVar3), z10, i10, cVar, cVar2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> E0(bu.c<? extends T>... cVarArr) {
        return cVarArr.length == 0 ? k2() : cVarArr.length == 1 ? Y2(cVarArr[0]) : kj.a.S(new FlowableConcatArray(cVarArr, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> E3(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
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
        return R2(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> i0<Boolean> E5(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
        return H5(cVar, cVar2, io.reactivex.internal.functions.a.d(), Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> E8(bu.c<? extends bu.c<? extends T>> cVar, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        return Y2(cVar).C7().e0(FlowableInternalHelper.n(oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> F0(bu.c<? extends T>... cVarArr) {
        return cVarArr.length == 0 ? k2() : cVarArr.length == 1 ? Y2(cVarArr[0]) : kj.a.S(new FlowableConcatArray(cVarArr, true));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> i0<Boolean> F5(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, int i10) {
        return H5(cVar, cVar2, io.reactivex.internal.functions.a.d(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> F8(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.S(new FlowableZip(null, iterable, oVar, Y(), false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> G0(int i10, int i11, bu.c<? extends T>... cVarArr) {
        io.reactivex.internal.functions.a.g(cVarArr, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.S(new FlowableConcatMapEager(new FlowableFromArray(cVarArr), Functions.k(), i10, i11, ErrorMode.IMMEDIATE));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> i0<Boolean> G5(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, dj.d<? super T, ? super T> dVar) {
        return H5(cVar, cVar2, dVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> G8(dj.o<? super Object[], ? extends R> oVar, boolean z10, int i10, bu.c<? extends T>... cVarArr) {
        if (cVarArr.length == 0) {
            return k2();
        }
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableZip(cVarArr, null, oVar, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> H0(bu.c<? extends T>... cVarArr) {
        return G0(Y(), Y(), cVarArr);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> i0<Boolean> H5(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, dj.d<? super T, ? super T> dVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(dVar, "isEqual is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.V(new FlowableSequenceEqualSingle(cVar, cVar2, dVar, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> H8(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "zipper is null");
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableZip(null, iterable, oVar, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> I0(int i10, int i11, bu.c<? extends T>... cVarArr) {
        return R2(cVarArr).c1(Functions.k(), i10, i11, true);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> J0(bu.c<? extends T>... cVarArr) {
        return I0(Y(), Y(), cVarArr);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> K0(bu.c<? extends bu.c<? extends T>> cVar) {
        return L0(cVar, Y(), true);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> L0(bu.c<? extends bu.c<? extends T>> cVar, int i10, boolean z10) {
        return Y2(cVar).Z0(Functions.k(), i10, z10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> M0(Iterable<? extends bu.c<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return X2(iterable).Y0(Functions.k());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> M3(bu.c<? extends bu.c<? extends T>> cVar) {
        return N3(cVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> N0(bu.c<? extends bu.c<? extends T>> cVar) {
        return O0(cVar, Y(), Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> N3(bu.c<? extends bu.c<? extends T>> cVar, int i10) {
        return Y2(cVar).s2(Functions.k(), i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static j<Integer> N4(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        }
        if (i11 == 0) {
            return k2();
        }
        if (i11 == 1) {
            return v3(Integer.valueOf(i10));
        }
        if (((long) i10) + ((long) (i11 - 1)) <= 2147483647L) {
            return kj.a.S(new FlowableRange(i10, i11));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> O0(bu.c<? extends bu.c<? extends T>> cVar, int i10, int i11) {
        io.reactivex.internal.functions.a.g(cVar, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.S(new io.reactivex.internal.operators.flowable.m(cVar, Functions.k(), i10, i11, ErrorMode.IMMEDIATE));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> O3(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return R2(cVar, cVar2).B2(Functions.k(), false, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static j<Long> O4(long j10, long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        }
        if (j11 == 0) {
            return k2();
        }
        if (j11 == 1) {
            return v3(Long.valueOf(j10));
        }
        long j12 = (j11 - 1) + j10;
        if (j10 <= 0 || j12 >= 0) {
            return kj.a.S(new FlowableRangeLong(j10, j11));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> P0(Iterable<? extends bu.c<? extends T>> iterable) {
        return Q0(iterable, Y(), Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> P3(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return R2(cVar, cVar2, cVar3).B2(Functions.k(), false, 3);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> Q0(Iterable<? extends bu.c<? extends T>> iterable, int i10, int i11) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.S(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.k(), i10, i11, ErrorMode.IMMEDIATE));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> Q3(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3, bu.c<? extends T> cVar4) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return R2(cVar, cVar2, cVar3, cVar4).B2(Functions.k(), false, 4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> R2(T... tArr) {
        io.reactivex.internal.functions.a.g(tArr, "items is null");
        return tArr.length == 0 ? k2() : tArr.length == 1 ? v3(tArr[0]) : kj.a.S(new FlowableFromArray(tArr));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> R3(Iterable<? extends bu.c<? extends T>> iterable) {
        return X2(iterable).r2(Functions.k());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.NONE)
    @bj.c
    @bj.e
    public static <T> j<T> R7(bu.c<T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "onSubscribe is null");
        if (cVar instanceof j) {
            throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return kj.a.S(new io.reactivex.internal.operators.flowable.h0(cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> S2(Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.g(callable, "supplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.e0(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> S3(Iterable<? extends bu.c<? extends T>> iterable, int i10) {
        return X2(iterable).s2(Functions.k(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> T2(Future<? extends T> future) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.f0(future, 0L, null));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> T3(Iterable<? extends bu.c<? extends T>> iterable, int i10, int i11) {
        return X2(iterable).C2(Functions.k(), false, i10, i11);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public static <T, D> j<T> T7(Callable<? extends D> callable, dj.o<? super D, ? extends bu.c<? extends T>> oVar, dj.g<? super D> gVar) {
        return U7(callable, oVar, gVar, true);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> U2(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.g(future, "future is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.f0(future, j10, timeUnit));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> U3(int i10, int i11, bu.c<? extends T>... cVarArr) {
        return R2(cVarArr).C2(Functions.k(), false, i10, i11);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T, D> j<T> U7(Callable<? extends D> callable, dj.o<? super D, ? extends bu.c<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        io.reactivex.internal.functions.a.g(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.g(oVar, "sourceSupplier is null");
        io.reactivex.internal.functions.a.g(gVar, "resourceDisposer is null");
        return kj.a.S(new FlowableUsing(callable, oVar, gVar, z10));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> V2(Future<? extends T> future, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return U2(future, j10, timeUnit).l6(h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> V3(bu.c<? extends T>... cVarArr) {
        return R2(cVarArr).s2(Functions.k(), cVarArr.length);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> W2(Future<? extends T> future, h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return T2(future).l6(h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> W3(int i10, int i11, bu.c<? extends T>... cVarArr) {
        return R2(cVarArr).C2(Functions.k(), true, i10, i11);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> X2(Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "source is null");
        return kj.a.S(new FlowableFromIterable(iterable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> X3(bu.c<? extends T>... cVarArr) {
        return R2(cVarArr).B2(Functions.k(), true, cVarArr.length);
    }

    public static int Y() {
        return f55352a;
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> Y2(bu.c<? extends T> cVar) {
        if (cVar instanceof j) {
            return kj.a.S((j) cVar);
        }
        io.reactivex.internal.functions.a.g(cVar, "source is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.h0(cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> Y3(bu.c<? extends bu.c<? extends T>> cVar) {
        return Z3(cVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> Z2(dj.g<i<T>> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "generator is null");
        return d3(Functions.u(), FlowableInternalHelper.j(gVar), Functions.h());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> Z3(bu.c<? extends bu.c<? extends T>> cVar, int i10) {
        return Y2(cVar).B2(Functions.k(), true, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, S> j<T> a3(Callable<S> callable, dj.b<S, i<T>> bVar) {
        io.reactivex.internal.functions.a.g(bVar, "generator is null");
        return d3(callable, FlowableInternalHelper.i(bVar), Functions.h());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> a4(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return R2(cVar, cVar2).B2(Functions.k(), true, 2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, S> j<T> b3(Callable<S> callable, dj.b<S, i<T>> bVar, dj.g<? super S> gVar) {
        io.reactivex.internal.functions.a.g(bVar, "generator is null");
        return d3(callable, FlowableInternalHelper.i(bVar), gVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> b4(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return R2(cVar, cVar2, cVar3).B2(Functions.k(), true, 3);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, S> j<T> c3(Callable<S> callable, dj.c<S, i<T>, S> cVar) {
        return d3(callable, cVar, Functions.h());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> c4(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, bu.c<? extends T> cVar3, bu.c<? extends T> cVar4) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return R2(cVar, cVar2, cVar3, cVar4).B2(Functions.k(), true, 4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, S> j<T> d3(Callable<S> callable, dj.c<S, i<T>, S> cVar, dj.g<? super S> gVar) {
        io.reactivex.internal.functions.a.g(callable, "initialState is null");
        io.reactivex.internal.functions.a.g(cVar, "generator is null");
        io.reactivex.internal.functions.a.g(gVar, "disposeState is null");
        return kj.a.S(new FlowableGenerate(callable, cVar, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> d4(Iterable<? extends bu.c<? extends T>> iterable) {
        return X2(iterable).A2(Functions.k(), true);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> j<R> e0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, bu.c<? extends T8> cVar8, bu.c<? extends T9> cVar9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(cVar8, "source8 is null");
        io.reactivex.internal.functions.a.g(cVar9, "source9 is null");
        return m0(Functions.E(nVar), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> e4(Iterable<? extends bu.c<? extends T>> iterable, int i10) {
        return X2(iterable).B2(Functions.k(), true, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> f(Iterable<? extends bu.c<? extends T>> iterable) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        return kj.a.S(new FlowableAmb(null, iterable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> j<R> f0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, bu.c<? extends T8> cVar8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(cVar8, "source8 is null");
        return m0(Functions.D(mVar), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> f4(Iterable<? extends bu.c<? extends T>> iterable, int i10, int i11) {
        return X2(iterable).C2(Functions.k(), true, i10, i11);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> g(bu.c<? extends T>... cVarArr) {
        io.reactivex.internal.functions.a.g(cVarArr, "sources is null");
        int length = cVarArr.length;
        return length == 0 ? k2() : length == 1 ? Y2(cVarArr[0]) : kj.a.S(new FlowableAmb(cVarArr, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, R> j<R> g0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        return m0(Functions.C(lVar), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, R> j<R> h0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        return m0(Functions.B(kVar), cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, R> j<R> i0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        return m0(Functions.A(jVar), cVar, cVar2, cVar3, cVar4, cVar5);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, R> j<R> j0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return m0(Functions.z(iVar), cVar, cVar2, cVar3, cVar4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, R> j<R> k0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, dj.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return m0(Functions.y(hVar), cVar, cVar2, cVar3);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public static <T> j<T> k2() {
        return kj.a.S(io.reactivex.internal.operators.flowable.a0.f33525b);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public static <T> j<T> k4() {
        return kj.a.S(r0.f33740b);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T1, T2, R> j<R> l0(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, dj.c<? super T1, ? super T2, ? extends R> cVar3) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return m0(Functions.x(cVar3), cVar, cVar2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> l2(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "throwable is null");
        return m2(Functions.m(th2));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> m0(dj.o<? super Object[], ? extends R> oVar, bu.c<? extends T>... cVarArr) {
        return q0(cVarArr, oVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public static <T> j<T> m2(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.g(callable, "supplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.b0(callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> n0(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        return o0(iterable, oVar, Y());
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public static j<Long> n3(long j10, long j11, TimeUnit timeUnit) {
        return o3(j10, j11, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> o0(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableCombineLatest((Iterable) iterable, (dj.o) oVar, i10, false));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public static j<Long> o3(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableInterval(Math.max(0L, j10), Math.max(0L, j11), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> p0(bu.c<? extends T>[] cVarArr, dj.o<? super Object[], ? extends R> oVar) {
        return q0(cVarArr, oVar, Y());
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public static j<Long> p3(long j10, TimeUnit timeUnit) {
        return o3(j10, j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> q0(bu.c<? extends T>[] cVarArr, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(cVarArr, "sources is null");
        if (cVarArr.length == 0) {
            return k2();
        }
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableCombineLatest((bu.c[]) cVarArr, (dj.o) oVar, i10, false));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public static j<Long> q3(long j10, TimeUnit timeUnit, h0 h0Var) {
        return o3(j10, j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> r0(dj.o<? super Object[], ? extends R> oVar, int i10, bu.c<? extends T>... cVarArr) {
        return w0(cVarArr, oVar, i10);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public static j<Long> r3(long j10, long j11, long j12, long j13, TimeUnit timeUnit) {
        return s3(j10, j11, j12, j13, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> s0(dj.o<? super Object[], ? extends R> oVar, bu.c<? extends T>... cVarArr) {
        return w0(cVarArr, oVar, Y());
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public static j<Long> s3(long j10, long j11, long j12, long j13, TimeUnit timeUnit, h0 h0Var) {
        if (j11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        }
        if (j11 == 0) {
            return k2().D1(j12, timeUnit, h0Var);
        }
        long j14 = j10 + (j11 - 1);
        if (j10 > 0 && j14 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableIntervalRange(j10, j14, Math.max(0L, j12), Math.max(0L, j13), timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> t0(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar) {
        return u0(iterable, oVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> u0(Iterable<? extends bu.c<? extends T>> iterable, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(iterable, "sources is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableCombineLatest((Iterable) iterable, (dj.o) oVar, i10, true));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public static j<Long> u7(long j10, TimeUnit timeUnit) {
        return v7(j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> j<R> u8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, bu.c<? extends T8> cVar8, bu.c<? extends T9> cVar9, dj.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(cVar8, "source8 is null");
        io.reactivex.internal.functions.a.g(cVar9, "source9 is null");
        return G8(Functions.E(nVar), false, Y(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T, R> j<R> v0(bu.c<? extends T>[] cVarArr, dj.o<? super Object[], ? extends R> oVar) {
        return w0(cVarArr, oVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> v3(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.l0(t10));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public static j<Long> v7(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableTimer(Math.max(0L, j10), timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> j<R> v8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, bu.c<? extends T8> cVar8, dj.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        io.reactivex.internal.functions.a.g(cVar8, "source8 is null");
        return G8(Functions.D(mVar), false, Y(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T, R> j<R> w0(bu.c<? extends T>[] cVarArr, dj.o<? super Object[], ? extends R> oVar, int i10) {
        io.reactivex.internal.functions.a.g(cVarArr, "sources is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return cVarArr.length == 0 ? k2() : kj.a.S(new FlowableCombineLatest((bu.c[]) cVarArr, (dj.o) oVar, i10, true));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    @bj.c
    @bj.e
    public static <T> j<T> w1(m<T> mVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.functions.a.g(mVar, "source is null");
        io.reactivex.internal.functions.a.g(backpressureStrategy, "mode is null");
        return kj.a.S(new FlowableCreate(mVar, backpressureStrategy));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> w3(T t10, T t11) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        return R2(t10, t11);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, T7, R> j<R> w8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, bu.c<? extends T7> cVar7, dj.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        io.reactivex.internal.functions.a.g(cVar7, "source7 is null");
        return G8(Functions.C(lVar), false, Y(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> x3(T t10, T t11, T t12) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        return R2(t10, t11, t12);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, T6, R> j<R> x8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, bu.c<? extends T6> cVar6, dj.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        io.reactivex.internal.functions.a.g(cVar6, "source6 is null");
        return G8(Functions.B(kVar), false, Y(), cVar, cVar2, cVar3, cVar4, cVar5, cVar6);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> y0(bu.c<? extends bu.c<? extends T>> cVar) {
        return z0(cVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> y3(T t10, T t11, T t12, T t13) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        return R2(t10, t11, t12, t13);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, T5, R> j<R> y8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, bu.c<? extends T5> cVar5, dj.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        io.reactivex.internal.functions.a.g(cVar5, "source5 is null");
        return G8(Functions.A(jVar), false, Y(), cVar, cVar2, cVar3, cVar4, cVar5);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public static <T> j<T> z0(bu.c<? extends bu.c<? extends T>> cVar, int i10) {
        return Y2(cVar).S0(Functions.k(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T> j<T> z3(T t10, T t11, T t12, T t13, T t14) {
        io.reactivex.internal.functions.a.g(t10, "item1 is null");
        io.reactivex.internal.functions.a.g(t11, "item2 is null");
        io.reactivex.internal.functions.a.g(t12, "item3 is null");
        io.reactivex.internal.functions.a.g(t13, "item4 is null");
        io.reactivex.internal.functions.a.g(t14, "item5 is null");
        return R2(t10, t11, t12, t13, t14);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public static <T1, T2, T3, T4, R> j<R> z8(bu.c<? extends T1> cVar, bu.c<? extends T2> cVar2, bu.c<? extends T3> cVar3, bu.c<? extends T4> cVar4, dj.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return G8(Functions.z(iVar), false, Y(), cVar, cVar2, cVar3, cVar4);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final void A(dj.g<? super T> gVar, int i10) {
        io.reactivex.internal.operators.flowable.h.d(this, gVar, Functions.f32984f, Functions.f32981c, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> A1(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return o6(v3(t10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> A2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10) {
        return C2(oVar, z10, Y(), Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> A4(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "next is null");
        return B4(Functions.n(cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <U> j<T> A5(bu.c<U> cVar, boolean z10) {
        io.reactivex.internal.functions.a.g(cVar, "sampler is null");
        return kj.a.S(new FlowableSamplePublisher(this, cVar, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final <R> R A7(dj.o<? super j<T>, R> oVar) {
        try {
            return (R) ((dj.o) io.reactivex.internal.functions.a.g(oVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final void B(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        io.reactivex.internal.operators.flowable.h.c(this, gVar, gVar2, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> B2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10, int i10) {
        return C2(oVar, z10, i10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> B4(dj.o<? super Throwable, ? extends bu.c<? extends T>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "resumeFunction is null");
        return kj.a.S(new FlowableOnErrorNext(this, oVar, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> B5(dj.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "accumulator is null");
        return kj.a.S(new x0(this, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final Future<T> B7() {
        return (Future) n6(new hj.f());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final void C(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, int i10) {
        io.reactivex.internal.operators.flowable.h.d(this, gVar, gVar2, Functions.f32981c, i10);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final j<T> C1(long j10, TimeUnit timeUnit) {
        return E1(j10, timeUnit, lj.b.a(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> C2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "bufferSize");
        if (!(this instanceof fj.m)) {
            return kj.a.S(new FlowableFlatMap(this, oVar, z10, i10, i11));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? k2() : w0.a(objCall, oVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> C4(dj.o<? super Throwable, ? extends T> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "valueSupplier is null");
        return kj.a.S(new FlowableOnErrorReturn(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> C5(R r10, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(r10, "initialValue is null");
        return D5(Functions.m(r10), cVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<List<T>> C7() {
        return kj.a.V(new i1(this));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final void D(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        io.reactivex.internal.operators.flowable.h.c(this, gVar, gVar2, aVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> D1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return E1(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final a D2(dj.o<? super T, ? extends g> oVar) {
        return E2(oVar, false, Integer.MAX_VALUE);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> D4(T t10) {
        io.reactivex.internal.functions.a.g(t10, "item is null");
        return C4(Functions.n(t10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> D5(Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.g(cVar, "accumulator is null");
        return kj.a.S(new FlowableScanSeed(this, callable, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<List<T>> D7(int i10) {
        io.reactivex.internal.functions.a.h(i10, "capacityHint");
        return kj.a.V(new i1(this, Functions.f(i10)));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final void E(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, int i10) {
        io.reactivex.internal.operators.flowable.h.d(this, gVar, gVar2, aVar, i10);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> E1(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.q(this, Math.max(0L, j10), timeUnit, h0Var, z10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final a E2(dj.o<? super T, ? extends g> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.R(new FlowableFlatMapCompletableCompletable(this, oVar, z10, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> E4(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "next is null");
        return kj.a.S(new FlowableOnErrorNext(this, Functions.n(cVar), true));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final j<T> E6(long j10) {
        if (j10 >= 0) {
            return kj.a.S(new FlowableTake(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <U extends Collection<? super T>> i0<U> E7(Callable<U> callable) {
        io.reactivex.internal.functions.a.g(callable, "collectionSupplier is null");
        return kj.a.V(new i1(this, callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<List<T>> F(int i10) {
        return G(i10, i10);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final j<T> F1(long j10, TimeUnit timeUnit, boolean z10) {
        return E1(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U> j<U> F2(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return G2(oVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<T> F3(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem");
        return kj.a.V(new io.reactivex.internal.operators.flowable.n0(this, t10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> F4() {
        return kj.a.S(new io.reactivex.internal.operators.flowable.s(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> F6(long j10, TimeUnit timeUnit) {
        return Q6(u7(j10, timeUnit));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <K> i0<Map<K, T>> F7(dj.o<? super T, ? extends K> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        return (i0<Map<K, T>>) c0(HashMapSupplier.asCallable(), Functions.F(oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<List<T>> G(int i10, int i11) {
        return (j<List<T>>) H(i10, i11, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, V> j<T> G1(bu.c<U> cVar, dj.o<? super T, ? extends bu.c<V>> oVar) {
        return K1(cVar).H1(oVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<U> G2(dj.o<? super T, ? extends Iterable<? extends U>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableFlattenIterable(this, oVar, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final q<T> G3() {
        return kj.a.T(new io.reactivex.internal.operators.flowable.m0(this));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final jj.a<T> G4() {
        return jj.a.y(this);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> G6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return Q6(v7(j10, timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <K, V> i0<Map<K, V>> G7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        return (i0<Map<K, V>>) c0(HashMapSupplier.asCallable(), Functions.G(oVar, oVar2));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U extends Collection<? super T>> j<U> H(int i10, int i11, Callable<U> callable) {
        io.reactivex.internal.functions.a.h(i10, uh.a.C);
        io.reactivex.internal.functions.a.h(i11, com.google.android.material.timepicker.d.C2);
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.S(new FlowableBuffer(this, i10, i11, callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<T> H1(dj.o<? super T, ? extends bu.c<U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "itemDelayIndicator is null");
        return (j<T>) r2(FlowableInternalHelper.c(oVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, V> j<V> H2(dj.o<? super T, ? extends Iterable<? extends U>> oVar, dj.c<? super T, ? super U, ? extends V> cVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return (j<V>) x2(FlowableInternalHelper.a(oVar), cVar, false, Y(), Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<T> H3() {
        return kj.a.V(new io.reactivex.internal.operators.flowable.n0(this, null));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final jj.a<T> H4(int i10) {
        io.reactivex.internal.functions.a.h(i10, "parallelism");
        return jj.a.z(this, i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> H6(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? kj.a.S(new io.reactivex.internal.operators.flowable.j0(this)) : i10 == 1 ? kj.a.S(new FlowableTakeLastOne(this)) : kj.a.S(new FlowableTakeLast(this, i10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <K, V> i0<Map<K, V>> H7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        return (i0<Map<K, V>>) c0(callable, Functions.G(oVar, oVar2));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U extends Collection<? super T>> j<U> I(int i10, Callable<U> callable) {
        return H(i10, i10, callable);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final j<T> I1(long j10, TimeUnit timeUnit) {
        return J1(j10, timeUnit, lj.b.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, V> j<V> I2(dj.o<? super T, ? extends Iterable<? extends U>> oVar, dj.c<? super T, ? super U, ? extends V> cVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "resultSelector is null");
        return (j<V>) x2(FlowableInternalHelper.a(oVar), cVar, false, Y(), i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    @bj.c
    @bj.e
    public final <R> j<R> I3(n<? extends R, ? super T> nVar) {
        io.reactivex.internal.functions.a.g(nVar, "lifter is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.o0(this, nVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final jj.a<T> I4(int i10, int i11) {
        io.reactivex.internal.functions.a.h(i10, "parallelism");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return jj.a.A(this, i10, i11);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> I5() {
        return kj.a.S(new y0(this));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> I6(long j10, long j11, TimeUnit timeUnit) {
        return K6(j10, j11, timeUnit, lj.b.a(), false, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <K> i0<Map<K, Collection<T>>> I7(dj.o<? super T, ? extends K> oVar) {
        return (i0<Map<K, Collection<T>>>) L7(oVar, Functions.k(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, R> j<R> I8(bu.c<? extends U> cVar, dj.c<? super T, ? super U, ? extends R> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return B8(this, cVar, cVar2);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> J(long j10, long j11, TimeUnit timeUnit) {
        return (j<List<T>>) L(j10, j11, timeUnit, lj.b.a(), ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> J1(long j10, TimeUnit timeUnit, h0 h0Var) {
        return K1(v7(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <R> j<R> J2(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return K2(oVar, false, Integer.MAX_VALUE);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final j<T> J3(long j10) {
        if (j10 >= 0) {
            return kj.a.S(new FlowableLimit(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> J4() {
        return K4(Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> J5() {
        return J4().S8();
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> J6(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return K6(j10, j11, timeUnit, h0Var, false, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <K, V> i0<Map<K, Collection<V>>> J7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        return L7(oVar, oVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> J8(bu.c<? extends U> cVar, dj.c<? super T, ? super U, ? extends R> cVar2, boolean z10) {
        return C8(this, cVar, cVar2, z10);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> K(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return (j<List<T>>) L(j10, j11, timeUnit, h0Var, ArrayListSupplier.asCallable());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<T> K1(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "subscriptionIndicator is null");
        return kj.a.S(new FlowableDelaySubscriptionOther(this, cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> K2(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.S(new FlowableFlatMapMaybe(this, oVar, z10, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <R> j<R> K3(dj.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.p0(this, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> K4(int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return FlowablePublish.Y8(this, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<T> K5(T t10) {
        io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
        return kj.a.V(new a1(this, t10));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> K6(long j10, long j11, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        if (j10 >= 0) {
            return kj.a.S(new FlowableTakeLastTimed(this, j10, j11, timeUnit, h0Var, i10, z10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <K, V> i0<Map<K, Collection<V>>> K7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return L7(oVar, oVar2, callable, ArrayListSupplier.asFunction());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> K8(bu.c<? extends U> cVar, dj.c<? super T, ? super U, ? extends R> cVar2, boolean z10, int i10) {
        return D8(this, cVar, cVar2, z10, i10);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <U extends Collection<? super T>> j<U> L(long j10, long j11, TimeUnit timeUnit, h0 h0Var, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.k(this, j10, j11, timeUnit, h0Var, callable, Integer.MAX_VALUE, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @Deprecated
    @bj.c
    public final <T2> j<T2> L1() {
        return kj.a.S(new io.reactivex.internal.operators.flowable.r(this, Functions.k()));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final <R> j<R> L2(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return M2(oVar, false, Integer.MAX_VALUE);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<y<T>> L3() {
        return kj.a.S(new FlowableMaterialize(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> L4(dj.o<? super j<T>, ? extends bu.c<R>> oVar) {
        return M4(oVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final q<T> L5() {
        return kj.a.T(new z0(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final j<T> L6(long j10, TimeUnit timeUnit) {
        return O6(j10, timeUnit, lj.b.a(), false, Y());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <K, V> i0<Map<K, Collection<V>>> L7(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, dj.o<? super K, ? extends Collection<? super V>> oVar3) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.g(callable, "mapSupplier is null");
        io.reactivex.internal.functions.a.g(oVar3, "collectionFactory is null");
        return (i0<Map<K, Collection<V>>>) c0(callable, Functions.H(oVar, oVar2, oVar3));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, R> j<R> L8(Iterable<U> iterable, dj.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(iterable, "other is null");
        io.reactivex.internal.functions.a.g(cVar, "zipper is null");
        return kj.a.S(new l1(this, iterable, cVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> M(long j10, TimeUnit timeUnit) {
        return P(j10, timeUnit, lj.b.a(), Integer.MAX_VALUE);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.d
    @bj.c
    @bj.e
    public final <R> j<R> M1(dj.o<? super T, y<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.r(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> M2(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        return kj.a.S(new FlowableFlatMapSingle(this, oVar, z10, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> M4(dj.o<? super j<T>, ? extends bu.c<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowablePublishMulticast(this, oVar, i10, false));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<T> M5() {
        return kj.a.V(new a1(this, null));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> M6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return O6(j10, timeUnit, h0Var, false, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final z<T> M7() {
        return kj.a.U(new io.reactivex.internal.operators.observable.n0(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> N(long j10, TimeUnit timeUnit, int i10) {
        return P(j10, timeUnit, lj.b.a(), i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> N1() {
        return P1(Functions.k(), Functions.g());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.NONE)
    public final io.reactivex.disposables.b N2(dj.g<? super T> gVar) {
        return f6(gVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> N5(long j10) {
        return j10 <= 0 ? kj.a.S(this) : kj.a.S(new b1(this, j10));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> N6(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return O6(j10, timeUnit, h0Var, z10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<List<T>> N7() {
        return P7(Functions.p());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> O(long j10, TimeUnit timeUnit, h0 h0Var) {
        return (j<List<T>>) Q(j10, timeUnit, h0Var, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K> j<T> O1(dj.o<? super T, K> oVar) {
        return P1(oVar, Functions.g());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.NONE)
    public final io.reactivex.disposables.b O2(dj.r<? super T> rVar) {
        return Q2(rVar, Functions.f32984f, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> O5(long j10, TimeUnit timeUnit) {
        return W5(u7(j10, timeUnit));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> O6(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        return K6(Long.MAX_VALUE, j10, timeUnit, h0Var, z10, i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<List<T>> O7(int i10) {
        return Q7(Functions.p(), i10);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<List<T>> P(long j10, TimeUnit timeUnit, h0 h0Var, int i10) {
        return (j<List<T>>) Q(j10, timeUnit, h0Var, i10, ArrayListSupplier.asCallable(), false);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K> j<T> P1(dj.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(callable, "collectionSupplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.t(this, oVar, callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.NONE)
    public final io.reactivex.disposables.b P2(dj.r<? super T> rVar, dj.g<? super Throwable> gVar) {
        return Q2(rVar, gVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> P4(int i10) {
        return n4(io.reactivex.internal.schedulers.c.f35165c, true, i10);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> P5(long j10, TimeUnit timeUnit, h0 h0Var) {
        return W5(v7(j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final j<T> P6(long j10, TimeUnit timeUnit, boolean z10) {
        return O6(j10, timeUnit, lj.b.a(), z10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<List<T>> P7(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        return (i0<List<T>>) C7().s0(Functions.o(comparator));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final <U extends Collection<? super T>> j<U> Q(long j10, TimeUnit timeUnit, h0 h0Var, int i10, Callable<U> callable, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        io.reactivex.internal.functions.a.h(i10, uh.a.C);
        return kj.a.S(new io.reactivex.internal.operators.flowable.k(this, j10, j10, timeUnit, h0Var, callable, i10, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Q1() {
        return S1(Functions.k());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.NONE)
    @bj.c
    @bj.e
    public final io.reactivex.disposables.b Q2(dj.r<? super T> rVar, dj.g<? super Throwable> gVar, dj.a aVar) {
        io.reactivex.internal.functions.a.g(rVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(rVar, gVar, aVar);
        j6(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final q<T> Q4(dj.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.T(new t0(this, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Q5(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? kj.a.S(this) : kj.a.S(new FlowableSkipLast(this, i10));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <U> j<T> Q6(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.S(new FlowableTakeUntil(this, cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<List<T>> Q7(Comparator<? super T> comparator, int i10) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        return (i0<List<T>>) D7(i10).s0(Functions.o(comparator));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B> j<List<T>> R(bu.c<B> cVar) {
        return (j<List<T>>) T(cVar, ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> R0(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return S0(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> R1(dj.d<? super T, ? super T> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "comparer is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.u(this, Functions.k(), dVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> i0<R> R4(R r10, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(r10, "seed is null");
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.V(new u0(this, r10, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> R5(long j10, TimeUnit timeUnit) {
        return U5(j10, timeUnit, lj.b.a(), false, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> R6(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "stopPredicate is null");
        return kj.a.S(new f1(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B> j<List<T>> S(bu.c<B> cVar, int i10) {
        io.reactivex.internal.functions.a.h(i10, "initialCapacity");
        return (j<List<T>>) T(cVar, Functions.f(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> S0(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        if (!(this instanceof fj.m)) {
            return kj.a.S(new FlowableConcatMap(this, oVar, i10, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? k2() : w0.a(objCall, oVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K> j<T> S1(dj.o<? super T, K> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.u(this, oVar, io.reactivex.internal.functions.a.d()));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> i0<R> S4(Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.g(cVar, "reducer is null");
        return kj.a.V(new v0(this, callable, cVar));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> S5(long j10, TimeUnit timeUnit, h0 h0Var) {
        return U5(j10, timeUnit, h0Var, false, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> S6(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.S(new g1(this, rVar));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> S7(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableUnsubscribeOn(this, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B, U extends Collection<? super T>> j<U> T(bu.c<B> cVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(cVar, "boundaryIndicator is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.j(this, cVar, callable));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final a T0(dj.o<? super T, ? extends g> oVar) {
        return U0(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> T1(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onAfterNext is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.v(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> T4() {
        return U4(Long.MAX_VALUE);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> T5(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return U5(j10, timeUnit, h0Var, z10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final TestSubscriber<T> T6() {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>();
        j6(testSubscriber);
        return testSubscriber;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B> j<List<T>> U(Callable<? extends bu.c<B>> callable) {
        return (j<List<T>>) V(callable, ArrayListSupplier.asCallable());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final a U0(dj.o<? super T, ? extends g> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.R(new FlowableConcatMapCompletable(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> U1(dj.a aVar) {
        return a2(Functions.h(), Functions.h(), Functions.f32981c, aVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> U4(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? k2() : kj.a.S(new FlowableRepeat(this, j10));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final j<T> U5(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableSkipLastTimed(this, j10, timeUnit, h0Var, i10 << 1, z10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final TestSubscriber<T> U6(long j10) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j10);
        j6(testSubscriber);
        return testSubscriber;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B, U extends Collection<? super T>> j<U> V(Callable<? extends bu.c<B>> callable, Callable<U> callable2) {
        io.reactivex.internal.functions.a.g(callable, "boundaryIndicatorSupplier is null");
        io.reactivex.internal.functions.a.g(callable2, "bufferSupplier is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.i(this, callable, callable2));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final a V0(dj.o<? super T, ? extends g> oVar) {
        return X0(oVar, true, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> V1(dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onFinally is null");
        return kj.a.S(new FlowableDoFinally(this, aVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> V4(dj.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "stop is null");
        return kj.a.S(new FlowableRepeatUntil(this, eVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> V5(long j10, TimeUnit timeUnit, boolean z10) {
        return U5(j10, timeUnit, lj.b.a(), z10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final TestSubscriber<T> V6(long j10, boolean z10) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j10);
        if (z10) {
            testSubscriber.cancel();
        }
        j6(testSubscriber);
        return testSubscriber;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<j<T>> V7(long j10) {
        return X7(j10, j10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <TOpening, TClosing> j<List<T>> W(j<? extends TOpening> jVar, dj.o<? super TOpening, ? extends bu.c<? extends TClosing>> oVar) {
        return (j<List<T>>) X(jVar, oVar, ArrayListSupplier.asCallable());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final a W0(dj.o<? super T, ? extends g> oVar, boolean z10) {
        return X0(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> W1(dj.a aVar) {
        return c2(Functions.h(), Functions.f32985g, aVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> W4(dj.o<? super j<Object>, ? extends bu.c<?>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "handler is null");
        return kj.a.S(new FlowableRepeatWhen(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<T> W5(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.S(new FlowableSkipUntil(this, cVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> W6(long j10, TimeUnit timeUnit) {
        return X6(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<j<T>> W7(long j10, long j11) {
        return X7(j10, j11, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <TOpening, TClosing, U extends Collection<? super T>> j<U> X(j<? extends TOpening> jVar, dj.o<? super TOpening, ? extends bu.c<? extends TClosing>> oVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.g(jVar, "openingIndicator is null");
        io.reactivex.internal.functions.a.g(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.g(callable, "bufferSupplier is null");
        return kj.a.S(new FlowableBufferBoundary(this, jVar, oVar, callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final a X0(dj.o<? super T, ? extends g> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.R(new FlowableConcatMapCompletable(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> X1(dj.a aVar) {
        return a2(Functions.h(), Functions.h(), aVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> X4() {
        return FlowableReplay.c9(this);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> X5(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.S(new c1(this, rVar));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<T> X6(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableThrottleFirstTimed(this, j10, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<j<T>> X7(long j10, long j11, int i10) {
        io.reactivex.internal.functions.a.i(j11, com.google.android.material.timepicker.d.C2);
        io.reactivex.internal.functions.a.i(j10, uh.a.C);
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableWindow(this, j10, j11, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> Y0(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return Z0(oVar, 2, true);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> Y1(bu.d<? super T> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "subscriber is null");
        return a2(FlowableInternalHelper.m(dVar), FlowableInternalHelper.l(dVar), FlowableInternalHelper.k(dVar), Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> Y4(int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return FlowableReplay.Y8(this, i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Y5() {
        return C7().s1().K3(Functions.o(Functions.p())).F2(Functions.k());
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> Y6(long j10, TimeUnit timeUnit) {
        return v5(j10, timeUnit);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> Y7(long j10, long j11, TimeUnit timeUnit) {
        return a8(j10, j11, timeUnit, lj.b.a(), Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> Z() {
        return a0(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> Z0(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        if (!(this instanceof fj.m)) {
            return kj.a.S(new FlowableConcatMap(this, oVar, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? k2() : w0.a(objCall, oVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> Z1(dj.g<? super y<T>> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNotification is null");
        return a2(Functions.t(gVar), Functions.s(gVar), Functions.r(gVar), Functions.f32981c);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> Z4(int i10, long j10, TimeUnit timeUnit) {
        return a5(i10, j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> Z5(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.g(comparator, "sortFunction");
        return C7().s1().K3(Functions.o(comparator)).F2(Functions.k());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> Z6(long j10, TimeUnit timeUnit, h0 h0Var) {
        return w5(j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> Z7(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return a8(j10, j11, timeUnit, h0Var, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<Boolean> a(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.V(new io.reactivex.internal.operators.flowable.e(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> a0(int i10) {
        io.reactivex.internal.functions.a.h(i10, "initialCapacity");
        return kj.a.S(new FlowableCache(this, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> a1(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return b1(oVar, Y(), Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> a2(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.g(aVar2, "onAfterTerminate is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.w(this, gVar, gVar2, aVar, aVar2));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> a5(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return FlowableReplay.a9(this, j10, timeUnit, h0Var, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> a6(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return E0(cVar, this);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> a7(long j10, TimeUnit timeUnit) {
        return c7(j10, timeUnit, lj.b.a(), false);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<j<T>> a8(long j10, long j11, TimeUnit timeUnit, h0 h0Var, int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.i(j10, "timespan");
        io.reactivex.internal.functions.a.i(j11, "timeskip");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        return kj.a.S(new k1(this, j10, j11, timeUnit, h0Var, Long.MAX_VALUE, i10, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <U> j<U> b0(Class<U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return (j<U>) K3(Functions.e(cls));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> b1(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.S(new FlowableConcatMapEager(this, oVar, i10, i11, ErrorMode.IMMEDIATE));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> b2(dj.g<? super Throwable> gVar) {
        dj.g<? super T> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return a2(gVarH, gVar, aVar, aVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> b5(int i10, h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.e9(Y4(i10), h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> b6(Iterable<? extends T> iterable) {
        return E0(X2(iterable), this);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> b7(long j10, TimeUnit timeUnit, h0 h0Var) {
        return c7(j10, timeUnit, h0Var, false);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> b8(long j10, TimeUnit timeUnit) {
        return g8(j10, timeUnit, lj.b.a(), Long.MAX_VALUE, false);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> i0<U> c0(Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.g(callable, "initialItemSupplier is null");
        io.reactivex.internal.functions.a.g(bVar, "collector is null");
        return kj.a.V(new io.reactivex.internal.operators.flowable.l(this, callable, bVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> c1(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, int i11, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.S(new FlowableConcatMapEager(this, oVar, i10, i11, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> c2(dj.g<? super bu.e> gVar, dj.q qVar, dj.a aVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.g(qVar, "onRequest is null");
        io.reactivex.internal.functions.a.g(aVar, "onCancel is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.x(this, gVar, qVar, aVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> c5(long j10, TimeUnit timeUnit) {
        return d5(j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> c6(T t10) {
        io.reactivex.internal.functions.a.g(t10, "value is null");
        return E0(v3(t10), this);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<T> c7(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableThrottleLatest(this, j10, timeUnit, h0Var, z10));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> c8(long j10, TimeUnit timeUnit, long j11) {
        return g8(j10, timeUnit, lj.b.a(), j11, false);
    }

    @Override // bu.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final void d(bu.d<? super T> dVar) {
        if (dVar instanceof o) {
            j6((o) dVar);
        } else {
            io.reactivex.internal.functions.a.g(dVar, "s is null");
            j6(new StrictSubscriber(dVar));
        }
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <U> i0<U> d0(U u6, dj.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.g(u6, "initialItem is null");
        return c0(Functions.m(u6), bVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> d1(dj.o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10) {
        return c1(oVar, Y(), Y(), z10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> d2(dj.g<? super T> gVar) {
        dj.g<? super Throwable> gVarH = Functions.h();
        dj.a aVar = Functions.f32981c;
        return a2(gVar, gVarH, aVar, aVar);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> d5(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.Z8(this, j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> d6(T... tArr) {
        j jVarR2 = R2(tArr);
        return jVarR2 == k2() ? kj.a.S(this) : E0(jVarR2, this);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> d7(long j10, TimeUnit timeUnit, boolean z10) {
        return c7(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> d8(long j10, TimeUnit timeUnit, long j11, boolean z10) {
        return g8(j10, timeUnit, lj.b.a(), j11, z10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U> j<U> e1(dj.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return f1(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> e2(dj.q qVar) {
        return c2(Functions.h(), qVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K> j<cj.b<K, T>> e3(dj.o<? super T, ? extends K> oVar) {
        return (j<cj.b<K, T>>) h3(oVar, Functions.k(), false, Y());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final cj.a<T> e5(h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.e9(X4(), h0Var);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final io.reactivex.disposables.b e6() {
        return i6(Functions.h(), Functions.f32984f, Functions.f32981c, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> e7(long j10, TimeUnit timeUnit) {
        return x1(j10, timeUnit);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> e8(long j10, TimeUnit timeUnit, h0 h0Var) {
        return g8(j10, timeUnit, h0Var, Long.MAX_VALUE, false);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U> j<U> f1(dj.o<? super T, ? extends Iterable<? extends U>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowableFlattenIterable(this, oVar, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> f2(dj.g<? super bu.e> gVar) {
        return c2(gVar, Functions.f32985g, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K, V> j<cj.b<K, V>> f3(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        return h3(oVar, oVar2, false, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> f5(dj.o<? super j<T>, ? extends bu.c<R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        return FlowableReplay.d9(FlowableInternalHelper.d(this), oVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final io.reactivex.disposables.b f6(dj.g<? super T> gVar) {
        return i6(gVar, Functions.f32984f, Functions.f32981c, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> f7(long j10, TimeUnit timeUnit, h0 h0Var) {
        return y1(j10, timeUnit, h0Var);
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> f8(long j10, TimeUnit timeUnit, h0 h0Var, long j11) {
        return g8(j10, timeUnit, h0Var, j11, false);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> g1(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return h1(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> g2(dj.a aVar) {
        return a2(Functions.h(), Functions.a(aVar), aVar, Functions.f32981c);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K, V> j<cj.b<K, V>> g3(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, boolean z10) {
        return h3(oVar, oVar2, z10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> g4(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return O3(this, cVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> g5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return FlowableReplay.d9(FlowableInternalHelper.e(this, i10), oVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final io.reactivex.disposables.b g6(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2) {
        return i6(gVar, gVar2, Functions.f32981c, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> g7() {
        return i7(TimeUnit.MILLISECONDS, lj.b.a());
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    public final j<j<T>> g8(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10) {
        return h8(j10, timeUnit, h0Var, j11, z10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> h(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return g(this, cVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> h1(dj.o<? super T, ? extends w<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowableConcatMapMaybe(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final q<T> h2(long j10) {
        if (j10 >= 0) {
            return kj.a.T(new io.reactivex.internal.operators.flowable.y(this, j10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <K, V> j<cj.b<K, V>> h3(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableGroupBy(this, oVar, oVar2, i10, z10, null));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> h4(@bj.e g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.S(new FlowableMergeWithCompletable(this, gVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> h5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, int i10, long j10, TimeUnit timeUnit) {
        return i5(oVar, i10, j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final io.reactivex.disposables.b h6(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar) {
        return i6(gVar, gVar2, aVar, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> h7(TimeUnit timeUnit) {
        return i7(timeUnit, lj.b.a());
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<j<T>> h8(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10, int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.i(j11, uh.a.C);
        return kj.a.S(new k1(this, j10, j10, timeUnit, h0Var, j11, i10, z10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<Boolean> i(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.V(new io.reactivex.internal.operators.flowable.f(this, rVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> i1(dj.o<? super T, ? extends w<? extends R>> oVar) {
        return k1(oVar, true, 2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<T> i2(long j10, T t10) {
        if (j10 >= 0) {
            io.reactivex.internal.functions.a.g(t10, "defaultItem is null");
            return kj.a.V(new io.reactivex.internal.operators.flowable.z(this, j10, t10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <K, V> j<cj.b<K, V>> i3(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, boolean z10, int i10, dj.o<? super dj.g<Object>, ? extends Map<K, Object>> oVar3) {
        io.reactivex.internal.functions.a.g(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.g(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(oVar3, "evictingMapFactory is null");
        return kj.a.S(new FlowableGroupBy(this, oVar, oVar2, i10, z10, oVar3));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> i4(@bj.e w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.S(new FlowableMergeWithMaybe(this, wVar));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> i5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.d9(FlowableInternalHelper.f(this, i10, j10, timeUnit, h0Var), oVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    @bj.c
    @bj.e
    public final io.reactivex.disposables.b i6(dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.g<? super bu.e> gVar3) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(gVar2, "onError is null");
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.g(gVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(gVar, gVar2, aVar, gVar3);
        j6(lambdaSubscriber);
        return lambdaSubscriber;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> i7(TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new h1(this, timeUnit, h0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B> j<j<T>> i8(bu.c<B> cVar) {
        return j8(cVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final <R> R j(@bj.e k<T, ? extends R> kVar) {
        return (R) ((k) io.reactivex.internal.functions.a.g(kVar, "converter is null")).a(this);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> j1(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
        return k1(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<T> j2(long j10) {
        if (j10 >= 0) {
            return kj.a.V(new io.reactivex.internal.operators.flowable.z(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <K> j<cj.b<K, T>> j3(dj.o<? super T, ? extends K> oVar, boolean z10) {
        return (j<cj.b<K, T>>) h3(oVar, Functions.k(), z10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> j4(@bj.e o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.S(new FlowableMergeWithSingle(this, o0Var));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> j5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, int i10, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return FlowableReplay.d9(FlowableInternalHelper.e(this, i10), FlowableInternalHelper.h(oVar, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final void j6(o<? super T> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "s is null");
        try {
            bu.d<? super T> dVarD0 = kj.a.d0(this, oVar);
            io.reactivex.internal.functions.a.g(dVarD0, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            k6(dVarD0);
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
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> j7(h0 h0Var) {
        return i7(TimeUnit.MILLISECONDS, h0Var);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <B> j<j<T>> j8(bu.c<B> cVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "boundaryIndicator is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableWindowBoundary(this, cVar, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T k() {
        hj.d dVar = new hj.d();
        j6(dVar);
        T tA = dVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> k1(dj.o<? super T, ? extends w<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowableConcatMapMaybe(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <TRight, TLeftEnd, TRightEnd, R> j<R> k3(bu.c<? extends TRight> cVar, dj.o<? super T, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super T, ? super j<TRight>, ? extends R> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        io.reactivex.internal.functions.a.g(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.g(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.g(cVar2, "resultSelector is null");
        return kj.a.S(new FlowableGroupJoin(this, cVar, oVar, oVar2, cVar2));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> k5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, long j10, TimeUnit timeUnit) {
        return l5(oVar, j10, timeUnit, lj.b.a());
    }

    public abstract void k6(bu.d<? super T> dVar);

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> k7(long j10, TimeUnit timeUnit) {
        return s7(j10, timeUnit, null, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <U, V> j<j<T>> k8(bu.c<U> cVar, dj.o<? super U, ? extends bu.c<V>> oVar) {
        return l8(cVar, oVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T l(T t10) {
        hj.d dVar = new hj.d();
        j6(dVar);
        T tA = dVar.a();
        return tA != null ? tA : t10;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> l1(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return m1(oVar, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> l3() {
        return kj.a.S(new io.reactivex.internal.operators.flowable.i0(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> l4(h0 h0Var) {
        return n4(h0Var, false, Y());
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> l5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.d9(FlowableInternalHelper.g(this, j10, timeUnit, h0Var), oVar);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> l6(@bj.e h0 h0Var) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return m6(h0Var, !(this instanceof FlowableCreate));
    }

    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> l7(long j10, TimeUnit timeUnit, bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return s7(j10, timeUnit, cVar, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <U, V> j<j<T>> l8(bu.c<U> cVar, dj.o<? super U, ? extends bu.c<V>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(cVar, "openingIndicator is null");
        io.reactivex.internal.functions.a.g(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new j1(this, cVar, oVar, i10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> m1(dj.o<? super T, ? extends o0<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowableConcatMapSingle(this, oVar, ErrorMode.IMMEDIATE, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final a m3() {
        return kj.a.R(new io.reactivex.internal.operators.flowable.k0(this));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    public final j<T> m4(h0 h0Var, boolean z10) {
        return n4(h0Var, z10, Y());
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> m5(dj.o<? super j<T>, ? extends bu.c<R>> oVar, h0 h0Var) {
        io.reactivex.internal.functions.a.g(oVar, "selector is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return FlowableReplay.d9(FlowableInternalHelper.d(this), FlowableInternalHelper.h(oVar, h0Var));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> m6(@bj.e h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableSubscribeOn(this, h0Var, z10));
    }

    @bj.c
    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> m7(long j10, TimeUnit timeUnit, h0 h0Var) {
        return s7(j10, timeUnit, null, h0Var);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final <B> j<j<T>> m8(Callable<? extends bu.c<B>> callable) {
        return n8(callable, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final void n(dj.g<? super T> gVar) {
        Iterator<T> it2 = o().iterator();
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
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> n1(dj.o<? super T, ? extends o0<? extends R>> oVar) {
        return p1(oVar, true, 2);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<T> n2(dj.r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate is null");
        return kj.a.S(new io.reactivex.internal.operators.flowable.c0(this, rVar));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> n4(h0 h0Var, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableObserveOn(this, h0Var, z10, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> n5() {
        return p5(Long.MAX_VALUE, Functions.c());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final <E extends bu.d<? super T>> E n6(E e10) {
        d(e10);
        return e10;
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> n7(long j10, TimeUnit timeUnit, h0 h0Var, bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return s7(j10, timeUnit, cVar, h0Var);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <B> j<j<T>> n8(Callable<? extends bu.c<B>> callable, int i10) {
        io.reactivex.internal.functions.a.g(callable, "boundaryIndicatorSupplier is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return kj.a.S(new FlowableWindowBoundarySupplier(this, callable, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final Iterable<T> o() {
        return p(Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> o1(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
        return p1(oVar, z10, 2);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final i0<T> o2(T t10) {
        return i2(0L, t10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <U> j<U> o4(Class<U> cls) {
        io.reactivex.internal.functions.a.g(cls, "clazz is null");
        return n2(Functions.l(cls)).b0(cls);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> o5(long j10) {
        return p5(j10, Functions.c());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> o6(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return kj.a.S(new d1(this, cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <U, V> j<T> o7(bu.c<U> cVar, dj.o<? super T, ? extends bu.c<V>> oVar) {
        io.reactivex.internal.functions.a.g(cVar, "firstTimeoutIndicator is null");
        return t7(cVar, oVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <T1, T2, T3, T4, R> j<R> o8(bu.c<T1> cVar, bu.c<T2> cVar2, bu.c<T3> cVar3, bu.c<T4> cVar4, dj.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        io.reactivex.internal.functions.a.g(cVar4, "source4 is null");
        return t8(new bu.c[]{cVar, cVar2, cVar3, cVar4}, Functions.A(jVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final Iterable<T> p(int i10) {
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        return new BlockingFlowableIterable(this, i10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> p1(dj.o<? super T, ? extends o0<? extends R>> oVar, boolean z10, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new FlowableConcatMapSingle(this, oVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final q<T> p2() {
        return h2(0L);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> p4() {
        return t4(Y(), false, true);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> p5(long j10, dj.r<? super Throwable> rVar) {
        if (j10 >= 0) {
            io.reactivex.internal.functions.a.g(rVar, "predicate is null");
            return kj.a.S(new FlowableRetryPredicate(this, j10, rVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> p6(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return q6(oVar, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, V> j<T> p7(bu.c<U> cVar, dj.o<? super T, ? extends bu.c<V>> oVar, bu.c<? extends T> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "firstTimeoutSelector is null");
        io.reactivex.internal.functions.a.g(cVar2, "other is null");
        return t7(cVar, oVar, cVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <T1, T2, T3, R> j<R> p8(bu.c<T1> cVar, bu.c<T2> cVar2, bu.c<T3> cVar3, dj.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        io.reactivex.internal.functions.a.g(cVar3, "source3 is null");
        return t8(new bu.c[]{cVar, cVar2, cVar3}, Functions.z(iVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T q() {
        hj.e eVar = new hj.e();
        j6(eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> q1(bu.c<? extends T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        return A0(this, cVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final i0<T> q2() {
        return j2(0L);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final j<T> q4(int i10) {
        return t4(i10, false, false);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> q5(dj.d<? super Integer, ? super Throwable> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "predicate is null");
        return kj.a.S(new FlowableRetryBiPredicate(this, dVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> q6(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
        return r6(oVar, i10, false);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final <V> j<T> q7(dj.o<? super T, ? extends bu.c<V>> oVar) {
        return t7(null, oVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <T1, T2, R> j<R> q8(bu.c<T1> cVar, bu.c<T2> cVar2, dj.h<? super T, ? super T1, ? super T2, R> hVar) {
        io.reactivex.internal.functions.a.g(cVar, "source1 is null");
        io.reactivex.internal.functions.a.g(cVar2, "source2 is null");
        return t8(new bu.c[]{cVar, cVar2}, Functions.y(hVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T r(T t10) {
        hj.e eVar = new hj.e();
        j6(eVar);
        T tA = eVar.a();
        return tA != null ? tA : t10;
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<T> r1(@bj.e g gVar) {
        io.reactivex.internal.functions.a.g(gVar, "other is null");
        return kj.a.S(new FlowableConcatWithCompletable(this, gVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> r2(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return C2(oVar, false, Y(), Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final j<T> r4(int i10, dj.a aVar) {
        return u4(i10, false, false, aVar);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> r5(dj.r<? super Throwable> rVar) {
        return p5(Long.MAX_VALUE, rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> j<R> r6(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "bufferSize");
        if (!(this instanceof fj.m)) {
            return kj.a.S(new FlowableSwitchMap(this, oVar, i10, z10));
        }
        Object objCall = ((fj.m) this).call();
        return objCall == null ? k2() : w0.a(objCall, oVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <V> j<T> r7(dj.o<? super T, ? extends bu.c<V>> oVar, j<? extends T> jVar) {
        io.reactivex.internal.functions.a.g(jVar, "other is null");
        return t7(null, oVar, jVar);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <U, R> j<R> r8(bu.c<? extends U> cVar, dj.c<? super T, ? super U, ? extends R> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        io.reactivex.internal.functions.a.g(cVar2, "combiner is null");
        return kj.a.S(new FlowableWithLatestFrom(this, cVar2, cVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final Iterable<T> s() {
        return new io.reactivex.internal.operators.flowable.b(this);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> s1(@bj.e w<? extends T> wVar) {
        io.reactivex.internal.functions.a.g(wVar, "other is null");
        return kj.a.S(new FlowableConcatWithMaybe(this, wVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <R> j<R> s2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
        return C2(oVar, false, i10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    public final j<T> s4(int i10, boolean z10) {
        return t4(i10, z10, false);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> s5(dj.e eVar) {
        io.reactivex.internal.functions.a.g(eVar, "stop is null");
        return p5(Long.MAX_VALUE, Functions.v(eVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final a s6(@bj.e dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new FlowableSwitchMapCompletable(this, oVar, false));
    }

    public final j<T> s7(long j10, TimeUnit timeUnit, bu.c<? extends T> cVar, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "timeUnit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableTimeoutTimed(this, j10, timeUnit, h0Var, cVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <R> j<R> s8(Iterable<? extends bu.c<?>> iterable, dj.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.g(iterable, "others is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        return kj.a.S(new FlowableWithLatestFromMany(this, iterable, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final Iterable<T> t(T t10) {
        return new io.reactivex.internal.operators.flowable.c(this, t10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> t1(@bj.e o0<? extends T> o0Var) {
        io.reactivex.internal.functions.a.g(o0Var, "other is null");
        return kj.a.S(new FlowableConcatWithSingle(this, o0Var));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> t2(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar) {
        return x2(oVar, cVar, false, Y(), Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<Boolean> t3() {
        return a(Functions.b());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final j<T> t4(int i10, boolean z10, boolean z11) {
        io.reactivex.internal.functions.a.h(i10, "capacity");
        return kj.a.S(new FlowableOnBackpressureBuffer(this, i10, z11, z10, Functions.f32981c));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final j<T> t5(dj.o<? super j<Throwable>, ? extends bu.c<?>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "handler is null");
        return kj.a.S(new FlowableRetryWhen(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final a t6(@bj.e dj.o<? super T, ? extends g> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.R(new FlowableSwitchMapCompletable(this, oVar, true));
    }

    public final <U, V> j<T> t7(bu.c<U> cVar, dj.o<? super T, ? extends bu.c<V>> oVar, bu.c<? extends T> cVar2) {
        io.reactivex.internal.functions.a.g(oVar, "itemTimeoutIndicator is null");
        return kj.a.S(new FlowableTimeout(this, cVar, oVar, cVar2));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final <R> j<R> t8(bu.c<?>[] cVarArr, dj.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.g(cVarArr, "others is null");
        io.reactivex.internal.functions.a.g(oVar, "combiner is null");
        return kj.a.S(new FlowableWithLatestFromMany(this, cVarArr, oVar));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final Iterable<T> u() {
        return new io.reactivex.internal.operators.flowable.d(this);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final i0<Boolean> u1(Object obj) {
        io.reactivex.internal.functions.a.g(obj, "item is null");
        return i(Functions.i(obj));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> u2(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, int i10) {
        return x2(oVar, cVar, false, i10, Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <TRight, TLeftEnd, TRightEnd, R> j<R> u3(bu.c<? extends TRight> cVar, dj.o<? super T, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super T, ? super TRight, ? extends R> cVar2) {
        io.reactivex.internal.functions.a.g(cVar, "other is null");
        io.reactivex.internal.functions.a.g(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.g(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.g(cVar2, "resultSelector is null");
        return kj.a.S(new FlowableJoin(this, cVar, oVar, oVar2, cVar2));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    @bj.c
    @bj.e
    public final j<T> u4(int i10, boolean z10, boolean z11, dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onOverflow is null");
        io.reactivex.internal.functions.a.h(i10, "capacity");
        return kj.a.S(new FlowableOnBackpressureBuffer(this, i10, z11, z10, aVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final void u5(bu.d<? super T> dVar) {
        io.reactivex.internal.functions.a.g(dVar, "s is null");
        if (dVar instanceof io.reactivex.subscribers.d) {
            j6((io.reactivex.subscribers.d) dVar);
        } else {
            j6(new io.reactivex.subscribers.d(dVar));
        }
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final <R> j<R> u6(dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        return v6(oVar, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T v() {
        return M5().i();
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final i0<Long> v1() {
        return kj.a.V(new io.reactivex.internal.operators.flowable.o(this));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> v2(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return x2(oVar, cVar, z10, Y(), Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    @bj.c
    @bj.e
    public final j<T> v4(long j10, dj.a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        io.reactivex.internal.functions.a.g(backpressureOverflowStrategy, "overflowStrategy is null");
        io.reactivex.internal.functions.a.i(j10, "capacity");
        return kj.a.S(new FlowableOnBackpressureBufferStrategy(this, j10, aVar, backpressureOverflowStrategy));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> v5(long j10, TimeUnit timeUnit) {
        return w5(j10, timeUnit, lj.b.a());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final <R> j<R> v6(dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
        return r6(oVar, i10, true);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final T w(T t10) {
        return K5(t10).i();
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final <U, R> j<R> w2(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return x2(oVar, cVar, z10, i10, Y());
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> w4(boolean z10) {
        return t4(Y(), z10, true);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<T> w5(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableSampleTimed(this, j10, timeUnit, h0Var, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> w6(@bj.e dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new FlowableSwitchMapMaybe(this, oVar, false));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> w7() {
        return y7(TimeUnit.MILLISECONDS, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final void x() {
        io.reactivex.internal.operators.flowable.h.a(this);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final <R> j<R> x0(p<? super T, ? extends R> pVar) {
        return Y2(((p) io.reactivex.internal.functions.a.g(pVar, "composer is null")).a(this));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> x1(long j10, TimeUnit timeUnit) {
        return y1(j10, timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <U, R> j<R> x2(dj.o<? super T, ? extends bu.c<? extends U>> oVar, dj.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.g(cVar, "combiner is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "bufferSize");
        return C2(FlowableInternalHelper.b(oVar, cVar), z10, i10, i11);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> x4() {
        return kj.a.S(new FlowableOnBackpressureDrop(this));
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<T> x5(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableSampleTimed(this, j10, timeUnit, h0Var, z10));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> x6(@bj.e dj.o<? super T, ? extends w<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new FlowableSwitchMapMaybe(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> x7(TimeUnit timeUnit) {
        return y7(timeUnit, lj.b.a());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.SPECIAL)
    public final void y(bu.d<? super T> dVar) {
        io.reactivex.internal.operators.flowable.h.b(this, dVar);
    }

    @bj.g(bj.g.A)
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final j<T> y1(long j10, TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return kj.a.S(new FlowableDebounceTimed(this, j10, timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> y2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, dj.o<? super Throwable, ? extends bu.c<? extends R>> oVar2, Callable<? extends bu.c<? extends R>> callable) {
        io.reactivex.internal.functions.a.g(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.g(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.g(callable, "onCompleteSupplier is null");
        return M3(new FlowableMapNotification(this, oVar, oVar2, callable));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final j<T> y4(dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onDrop is null");
        return kj.a.S(new FlowableOnBackpressureDrop(this, gVar));
    }

    @bj.c
    @bj.g(bj.g.B)
    @bj.a(BackpressureKind.ERROR)
    public final j<T> y5(long j10, TimeUnit timeUnit, boolean z10) {
        return x5(j10, timeUnit, lj.b.a(), z10);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> y6(@bj.e dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new FlowableSwitchMapSingle(this, oVar, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    @bj.c
    @bj.e
    public final j<lj.d<T>> y7(TimeUnit timeUnit, h0 h0Var) {
        io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.g(h0Var, "scheduler is null");
        return (j<lj.d<T>>) K3(Functions.w(timeUnit, h0Var));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final void z(dj.g<? super T> gVar) {
        io.reactivex.internal.operators.flowable.h.c(this, gVar, Functions.f32984f, Functions.f32981c);
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <U> j<T> z1(dj.o<? super T, ? extends bu.c<U>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "debounceIndicator is null");
        return kj.a.S(new FlowableDebounce(this, oVar));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @bj.e
    public final <R> j<R> z2(dj.o<? super T, ? extends bu.c<? extends R>> oVar, dj.o<Throwable, ? extends bu.c<? extends R>> oVar2, Callable<? extends bu.c<? extends R>> callable, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.g(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.g(callable, "onCompleteSupplier is null");
        return N3(new FlowableMapNotification(this, oVar, oVar2, callable), i10);
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    public final j<T> z4() {
        return kj.a.S(new FlowableOnBackpressureLatest(this));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.ERROR)
    @bj.c
    @bj.e
    public final <U> j<T> z5(bu.c<U> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "sampler is null");
        return kj.a.S(new FlowableSamplePublisher(this, cVar, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.UNBOUNDED_IN)
    @bj.c
    @bj.e
    public final <R> j<R> z6(@bj.e dj.o<? super T, ? extends o0<? extends R>> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        return kj.a.S(new FlowableSwitchMapSingle(this, oVar, true));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.PASS_THROUGH)
    public final j<lj.d<T>> z7(h0 h0Var) {
        return y7(TimeUnit.MILLISECONDS, h0Var);
    }
}
