package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,270:1\n95#2,5:271\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n166#1:271,5\n*E\n"})
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38872a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38873b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38874c = 2;

    @yt.k
    public static final <T> u0<T> a(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, @yt.k CoroutineStart coroutineStart, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(o0Var, coroutineContext);
        v0 k2Var = coroutineStart.isLazy() ? new k2(coroutineContextE, pVar) : new v0(coroutineContextE, true);
        ((a) k2Var).I1(coroutineStart, k2Var, pVar);
        return (u0<T>) k2Var;
    }

    public static /* synthetic */ u0 b(o0 o0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(o0Var, coroutineContext, coroutineStart, pVar);
    }

    @yt.l
    public static final <T> Object c(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        return h.h(coroutineDispatcher, pVar, cVar);
    }

    public static final <T> Object d(CoroutineDispatcher coroutineDispatcher, ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super T> cVar) throws Throwable {
        kotlin.jvm.internal.c0.e(0);
        Object objH = h.h(coroutineDispatcher, pVar, cVar);
        kotlin.jvm.internal.c0.e(1);
        return objH;
    }

    @yt.k
    public static final c2 e(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext, @yt.k CoroutineStart coroutineStart, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super kotlin.z1>, ? extends Object> pVar) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(o0Var, coroutineContext);
        a l2Var = coroutineStart.isLazy() ? new l2(coroutineContextE, pVar) : new y2(coroutineContextE, true);
        l2Var.I1(coroutineStart, l2Var, pVar);
        return l2Var;
    }

    public static /* synthetic */ c2 f(o0 o0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, ik.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.d(o0Var, coroutineContext, coroutineStart, pVar);
    }

    @yt.l
    public static final <T> Object g(@yt.k CoroutineContext coroutineContext, @yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        Object objJ1;
        CoroutineContext coroutineContextB = cVar.b();
        CoroutineContext coroutineContextD = CoroutineContextKt.d(coroutineContextB, coroutineContext);
        f2.z(coroutineContextD);
        if (coroutineContextD == coroutineContextB) {
            kotlinx.coroutines.internal.k0 k0Var = new kotlinx.coroutines.internal.k0(coroutineContextD, cVar);
            objJ1 = zk.b.e(k0Var, k0Var, pVar);
        } else {
            d.b bVar = kotlin.coroutines.d.f37759u2;
            if (kotlin.jvm.internal.f0.g(coroutineContextD.c(bVar), coroutineContextB.c(bVar))) {
                k3 k3Var = new k3(coroutineContextD, cVar);
                CoroutineContext coroutineContextB2 = k3Var.b();
                Object objC = ThreadContextKt.c(coroutineContextB2, null);
                try {
                    Object objE = zk.b.e(k3Var, k3Var, pVar);
                    ThreadContextKt.a(coroutineContextB2, objC);
                    objJ1 = objE;
                } catch (Throwable th2) {
                    ThreadContextKt.a(coroutineContextB2, objC);
                    throw th2;
                }
            } else {
                z0 z0Var = new z0(coroutineContextD, cVar);
                zk.a.f(pVar, z0Var, z0Var, null, 4, null);
                objJ1 = z0Var.J1();
            }
        }
        if (objJ1 == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objJ1;
    }
}
