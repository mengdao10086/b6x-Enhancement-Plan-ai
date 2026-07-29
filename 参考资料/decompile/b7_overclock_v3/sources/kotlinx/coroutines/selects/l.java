package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlin.jvm.internal.c0;
import kotlin.s0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes5.dex */
public final class l {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void c(o<? super T> oVar, T t10) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) oVar.b().c(CoroutineDispatcher.f38234b);
        if (coroutineDispatcher != null) {
            oVar.O(coroutineDispatcher, t10);
        } else {
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(t10));
        }
    }

    public static final void d(o<?> oVar, Throwable th2) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) oVar.b().c(CoroutineDispatcher.f38234b);
        if (coroutineDispatcher != null) {
            oVar.K(coroutineDispatcher, th2);
        } else {
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(u0.a(th2)));
        }
    }

    @yt.l
    @s0
    public static final <R> Object e(@yt.k ik.l<? super b<? super R>, z1> lVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(cVar);
        try {
            lVar.i(selectBuilderImpl);
        } catch (Throwable th2) {
            selectBuilderImpl.q0(th2);
        }
        Object objN0 = selectBuilderImpl.n0();
        if (objN0 == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objN0;
    }

    @s0
    public static final <R> Object f(ik.l<? super b<? super R>, z1> lVar, kotlin.coroutines.c<? super R> cVar) {
        c0.e(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(cVar);
        try {
            lVar.i(selectBuilderImpl);
        } catch (Throwable th2) {
            selectBuilderImpl.q0(th2);
        }
        Object objN0 = selectBuilderImpl.n0();
        if (objN0 == yj.b.h()) {
            zj.f.c(cVar);
        }
        c0.e(1);
        return objN0;
    }

    @yt.l
    @s0
    public static final <R> Object g(@yt.k ik.l<? super b<? super R>, z1> lVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(cVar);
        try {
            lVar.i(unbiasedSelectBuilderImpl);
        } catch (Throwable th2) {
            unbiasedSelectBuilderImpl.s0(th2);
        }
        Object objU0 = unbiasedSelectBuilderImpl.u0();
        if (objU0 == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objU0;
    }

    @s0
    public static final <R> Object h(ik.l<? super b<? super R>, z1> lVar, kotlin.coroutines.c<? super R> cVar) {
        c0.e(0);
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(cVar);
        try {
            lVar.i(unbiasedSelectBuilderImpl);
        } catch (Throwable th2) {
            unbiasedSelectBuilderImpl.s0(th2);
        }
        Object objU0 = unbiasedSelectBuilderImpl.u0();
        if (objU0 == yj.b.h()) {
            zj.f.c(cVar);
        }
        c0.e(1);
        return objU0;
    }
}
