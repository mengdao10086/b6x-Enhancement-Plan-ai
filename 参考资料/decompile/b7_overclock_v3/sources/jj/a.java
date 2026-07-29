package jj;

import bj.e;
import bu.d;
import dj.o;
import dj.q;
import dj.r;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.operators.parallel.f;
import io.reactivex.internal.operators.parallel.g;
import io.reactivex.internal.operators.parallel.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.i;
import io.reactivex.parallel.ParallelFailureHandling;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import xi.h0;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> {
    @bj.c
    @e
    public static <T> a<T> A(@e bu.c<? extends T> cVar, int i10, int i11) {
        io.reactivex.internal.functions.a.g(cVar, "source");
        io.reactivex.internal.functions.a.h(i10, "parallelism");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.Q(new ParallelFromPublisher(cVar, i10, i11));
    }

    @bj.c
    @e
    public static <T> a<T> B(@e bu.c<T>... cVarArr) {
        if (cVarArr.length != 0) {
            return kj.a.Q(new f(cVarArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @bj.c
    public static <T> a<T> y(@e bu.c<? extends T> cVar) {
        return A(cVar, Runtime.getRuntime().availableProcessors(), j.Y());
    }

    @bj.c
    public static <T> a<T> z(@e bu.c<? extends T> cVar, int i10) {
        return A(cVar, i10, j.Y());
    }

    @bj.c
    @e
    public final <R> a<R> C(@e o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper");
        return kj.a.Q(new g(this, oVar));
    }

    @bj.c
    @e
    public final <R> a<R> D(@e o<? super T, ? extends R> oVar, @e dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        io.reactivex.internal.functions.a.g(oVar, "mapper");
        io.reactivex.internal.functions.a.g(cVar, "errorHandler is null");
        return kj.a.Q(new h(this, oVar, cVar));
    }

    @bj.c
    @e
    public final <R> a<R> E(@e o<? super T, ? extends R> oVar, @e ParallelFailureHandling parallelFailureHandling) {
        io.reactivex.internal.functions.a.g(oVar, "mapper");
        io.reactivex.internal.functions.a.g(parallelFailureHandling, "errorHandler is null");
        return kj.a.Q(new h(this, oVar, parallelFailureHandling));
    }

    public abstract int F();

    @bj.c
    @e
    public final <R> a<R> G(@e Callable<R> callable, @e dj.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.g(callable, "initialSupplier");
        io.reactivex.internal.functions.a.g(cVar, "reducer");
        return kj.a.Q(new ParallelReduce(this, callable, cVar));
    }

    @bj.c
    @e
    public final j<T> H(@e dj.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "reducer");
        return kj.a.S(new ParallelReduceFull(this, cVar));
    }

    @bj.c
    @e
    public final a<T> I(@e h0 h0Var) {
        return J(h0Var, j.Y());
    }

    @bj.c
    @e
    public final a<T> J(@e h0 h0Var, int i10) {
        io.reactivex.internal.functions.a.g(h0Var, "scheduler");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.Q(new ParallelRunOn(this, h0Var, i10));
    }

    @bj.c
    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    public final j<T> K() {
        return L(j.Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @e
    public final j<T> L(int i10) {
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new ParallelJoin(this, i10, false));
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @e
    public final j<T> M() {
        return N(j.Y());
    }

    @bj.g("none")
    @bj.a(BackpressureKind.FULL)
    @bj.c
    @e
    public final j<T> N(int i10) {
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.S(new ParallelJoin(this, i10, true));
    }

    @bj.c
    @e
    public final j<T> O(@e Comparator<? super T> comparator) {
        return P(comparator, 16);
    }

    @bj.c
    @e
    public final j<T> P(@e Comparator<? super T> comparator, int i10) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        io.reactivex.internal.functions.a.h(i10, "capacityHint");
        return kj.a.S(new ParallelSortedJoin(G(Functions.f((i10 / F()) + 1), ListAddBiConsumer.instance()).C(new io.reactivex.internal.util.o(comparator)), comparator));
    }

    public abstract void Q(@e d<? super T>[] dVarArr);

    @bj.c
    @e
    public final <U> U R(@e o<? super a<T>, U> oVar) {
        try {
            return (U) ((o) io.reactivex.internal.functions.a.g(oVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw ExceptionHelper.f(th2);
        }
    }

    @bj.c
    @e
    public final j<List<T>> S(@e Comparator<? super T> comparator) {
        return T(comparator, 16);
    }

    @bj.c
    @e
    public final j<List<T>> T(@e Comparator<? super T> comparator, int i10) {
        io.reactivex.internal.functions.a.g(comparator, "comparator is null");
        io.reactivex.internal.functions.a.h(i10, "capacityHint");
        return kj.a.S(G(Functions.f((i10 / F()) + 1), ListAddBiConsumer.instance()).C(new io.reactivex.internal.util.o(comparator)).H(new i(comparator)));
    }

    public final boolean U(@e d<?>[] dVarArr) {
        int iF = F();
        if (dVarArr.length == iF) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + iF + ", subscribers = " + dVarArr.length);
        for (d<?> dVar : dVarArr) {
            EmptySubscription.error(illegalArgumentException, dVar);
        }
        return false;
    }

    @bj.c
    @e
    public final <R> R a(@e b<T, R> bVar) {
        return (R) ((b) io.reactivex.internal.functions.a.g(bVar, "converter is null")).a(this);
    }

    @bj.c
    @e
    public final <C> a<C> b(@e Callable<? extends C> callable, @e dj.b<? super C, ? super T> bVar) {
        io.reactivex.internal.functions.a.g(callable, "collectionSupplier is null");
        io.reactivex.internal.functions.a.g(bVar, "collector is null");
        return kj.a.Q(new ParallelCollect(this, callable, bVar));
    }

    @bj.c
    @e
    public final <U> a<U> c(@e c<T, U> cVar) {
        return kj.a.Q(((c) io.reactivex.internal.functions.a.g(cVar, "composer is null")).a(this));
    }

    @bj.c
    @e
    public final <R> a<R> d(@e o<? super T, ? extends bu.c<? extends R>> oVar) {
        return e(oVar, 2);
    }

    @bj.c
    @e
    public final <R> a<R> e(@e o<? super T, ? extends bu.c<? extends R>> oVar, int i10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.a(this, oVar, i10, ErrorMode.IMMEDIATE));
    }

    @bj.c
    @e
    public final <R> a<R> f(@e o<? super T, ? extends bu.c<? extends R>> oVar, int i10, boolean z10) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "prefetch");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.a(this, oVar, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @bj.c
    @e
    public final <R> a<R> g(@e o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10) {
        return f(oVar, 2, z10);
    }

    @bj.c
    @e
    public final a<T> h(@e dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onAfterNext is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVar, gVarH2, aVar, aVar, Functions.h(), Functions.f32985g, aVar));
    }

    @bj.c
    @e
    public final a<T> i(@e dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onAfterTerminate is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVarH3, aVar2, aVar, Functions.h(), Functions.f32985g, aVar2));
    }

    @bj.c
    @e
    public final a<T> j(@e dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onCancel is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVarH3, aVar2, aVar2, Functions.h(), Functions.f32985g, aVar));
    }

    @bj.c
    @e
    public final a<T> k(@e dj.a aVar) {
        io.reactivex.internal.functions.a.g(aVar, "onComplete is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar2 = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVarH3, aVar, aVar2, Functions.h(), Functions.f32985g, aVar2));
    }

    @bj.c
    @e
    public final a<T> l(@e dj.g<Throwable> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onError is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVar, aVar, aVar, Functions.h(), Functions.f32985g, aVar));
    }

    @bj.c
    @e
    public final a<T> m(@e dj.g<? super T> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVar, gVarH, gVarH2, aVar, aVar, Functions.h(), Functions.f32985g, aVar));
    }

    @bj.c
    @e
    public final a<T> n(@e dj.g<? super T> gVar, @e dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(cVar, "errorHandler is null");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.b(this, gVar, cVar));
    }

    @bj.c
    @e
    public final a<T> o(@e dj.g<? super T> gVar, @e ParallelFailureHandling parallelFailureHandling) {
        io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        io.reactivex.internal.functions.a.g(parallelFailureHandling, "errorHandler is null");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.b(this, gVar, parallelFailureHandling));
    }

    @bj.c
    @e
    public final a<T> p(@e q qVar) {
        io.reactivex.internal.functions.a.g(qVar, "onRequest is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVarH3, aVar, aVar, Functions.h(), qVar, aVar));
    }

    @bj.c
    @e
    public final a<T> q(@e dj.g<? super bu.e> gVar) {
        io.reactivex.internal.functions.a.g(gVar, "onSubscribe is null");
        dj.g gVarH = Functions.h();
        dj.g gVarH2 = Functions.h();
        dj.g gVarH3 = Functions.h();
        dj.a aVar = Functions.f32981c;
        return kj.a.Q(new io.reactivex.internal.operators.parallel.i(this, gVarH, gVarH2, gVarH3, aVar, aVar, gVar, Functions.f32985g, aVar));
    }

    @bj.c
    public final a<T> r(@e r<? super T> rVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.c(this, rVar));
    }

    @bj.c
    public final a<T> s(@e r<? super T> rVar, @e dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        io.reactivex.internal.functions.a.g(rVar, "predicate");
        io.reactivex.internal.functions.a.g(cVar, "errorHandler is null");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.d(this, rVar, cVar));
    }

    @bj.c
    public final a<T> t(@e r<? super T> rVar, @e ParallelFailureHandling parallelFailureHandling) {
        io.reactivex.internal.functions.a.g(rVar, "predicate");
        io.reactivex.internal.functions.a.g(parallelFailureHandling, "errorHandler is null");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.d(this, rVar, parallelFailureHandling));
    }

    @bj.c
    @e
    public final <R> a<R> u(@e o<? super T, ? extends bu.c<? extends R>> oVar) {
        return x(oVar, false, Integer.MAX_VALUE, j.Y());
    }

    @bj.c
    @e
    public final <R> a<R> v(@e o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10) {
        return x(oVar, z10, Integer.MAX_VALUE, j.Y());
    }

    @bj.c
    @e
    public final <R> a<R> w(@e o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10, int i10) {
        return x(oVar, z10, i10, j.Y());
    }

    @bj.c
    @e
    public final <R> a<R> x(@e o<? super T, ? extends bu.c<? extends R>> oVar, boolean z10, int i10, int i11) {
        io.reactivex.internal.functions.a.g(oVar, "mapper is null");
        io.reactivex.internal.functions.a.h(i10, "maxConcurrency");
        io.reactivex.internal.functions.a.h(i11, "prefetch");
        return kj.a.Q(new io.reactivex.internal.operators.parallel.e(this, oVar, z10, i10, i11));
    }
}
