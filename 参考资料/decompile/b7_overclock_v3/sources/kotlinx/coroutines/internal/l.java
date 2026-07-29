package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.e3;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.k3;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,315:1\n295#1,5:323\n300#1,12:329\n312#1:385\n299#1:387\n300#1,12:389\n312#1:418\n215#2,7:316\n222#2:344\n241#2,8:345\n223#2:353\n253#2:354\n254#2,2:365\n256#2:369\n225#2:370\n227#2:386\n1#3:328\n1#3:388\n1#3:419\n198#4,3:341\n201#4,14:371\n198#4,17:401\n198#4,17:420\n107#5,10:355\n118#5,2:367\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n280#1:323,5\n280#1:329,12\n280#1:385\n285#1:387\n285#1:389,12\n285#1:418\n280#1:316,7\n280#1:344\n280#1:345,8\n280#1:353\n280#1:354\n280#1:365,2\n280#1:369\n280#1:370\n280#1:386\n280#1:328\n285#1:388\n280#1:341,3\n280#1:371,14\n285#1:401,17\n311#1:420,17\n280#1:355,10\n280#1:367,2\n*E\n"})
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final o0 f38809a = new o0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final o0 f38810b = new o0("REUSABLE_CLAIMED");

    public static final boolean b(k<?> kVar, Object obj, int i10, boolean z10, ik.a<z1> aVar) {
        k1 k1VarB = e3.f38471a.b();
        if (z10 && k1VarB.v2()) {
            return false;
        }
        if (k1VarB.u2()) {
            kVar.f38806f = obj;
            kVar.f38266c = i10;
            k1VarB.p2(kVar);
            return true;
        }
        k1VarB.r2(true);
        try {
            aVar.o();
            do {
            } while (k1VarB.x2());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th2) {
            try {
                kVar.i(th2, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th3) {
                kotlin.jvm.internal.c0.d(1);
                k1VarB.m2(true);
                kotlin.jvm.internal.c0.c(1);
                throw th3;
            }
        }
        k1VarB.m2(true);
        kotlin.jvm.internal.c0.c(1);
        return false;
    }

    public static /* synthetic */ boolean c(k kVar, Object obj, int i10, boolean z10, ik.a aVar, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        k1 k1VarB = e3.f38471a.b();
        if (z10 && k1VarB.v2()) {
            return false;
        }
        if (k1VarB.u2()) {
            kVar.f38806f = obj;
            kVar.f38266c = i10;
            k1VarB.p2(kVar);
            return true;
        }
        k1VarB.r2(true);
        try {
            aVar.o();
            do {
            } while (k1VarB.x2());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th2) {
            try {
                kVar.i(th2, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th3) {
                kotlin.jvm.internal.c0.d(1);
                k1VarB.m2(true);
                kotlin.jvm.internal.c0.c(1);
                throw th3;
            }
        }
        k1VarB.m2(true);
        kotlin.jvm.internal.c0.c(1);
        return false;
    }

    /* JADX WARN: Finally extract failed */
    @y1
    public static final <T> void d(@yt.k kotlin.coroutines.c<? super T> cVar, @yt.k Object obj, @yt.l ik.l<? super Throwable, z1> lVar) {
        boolean z10;
        if (!(cVar instanceof k)) {
            cVar.x(obj);
            return;
        }
        k kVar = (k) cVar;
        Object objB = kotlinx.coroutines.h0.b(obj, lVar);
        if (kVar.f38804d.j2(kVar.b())) {
            kVar.f38806f = objB;
            kVar.f38266c = 1;
            kVar.f38804d.h2(kVar.b(), kVar);
            return;
        }
        k1 k1VarB = e3.f38471a.b();
        if (k1VarB.u2()) {
            kVar.f38806f = objB;
            kVar.f38266c = 1;
            k1VarB.p2(kVar);
            return;
        }
        k1VarB.r2(true);
        try {
            c2 c2Var = (c2) kVar.b().c(c2.f38296x2);
            if (c2Var == null || c2Var.isActive()) {
                z10 = false;
            } else {
                CancellationException cancellationExceptionZ = c2Var.Z();
                kVar.c(objB, cancellationExceptionZ);
                Result.a aVar = Result.f37633a;
                kVar.x(Result.b(kotlin.u0.a(cancellationExceptionZ)));
                z10 = true;
            }
            if (!z10) {
                kotlin.coroutines.c<T> cVar2 = kVar.f38805e;
                Object obj2 = kVar.f38807g;
                CoroutineContext coroutineContextB = cVar2.b();
                Object objC = ThreadContextKt.c(coroutineContextB, obj2);
                k3<?> k3VarG = objC != ThreadContextKt.f38768a ? CoroutineContextKt.g(cVar2, coroutineContextB, objC) : null;
                try {
                    kVar.f38805e.x(obj);
                    z1 z1Var = z1.f38230a;
                    if (k3VarG == null || k3VarG.J1()) {
                        ThreadContextKt.a(coroutineContextB, objC);
                    }
                } catch (Throwable th2) {
                    if (k3VarG == null || k3VarG.J1()) {
                        ThreadContextKt.a(coroutineContextB, objC);
                    }
                    throw th2;
                }
            }
            while (k1VarB.x2()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void e(kotlin.coroutines.c cVar, Object obj, ik.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        d(cVar, obj, lVar);
    }

    public static final boolean f(@yt.k k<? super z1> kVar) {
        z1 z1Var = z1.f38230a;
        k1 k1VarB = e3.f38471a.b();
        if (k1VarB.v2()) {
            return false;
        }
        if (k1VarB.u2()) {
            kVar.f38806f = z1Var;
            kVar.f38266c = 1;
            k1VarB.p2(kVar);
            return true;
        }
        k1VarB.r2(true);
        try {
            kVar.run();
            do {
            } while (k1VarB.x2());
        } finally {
            try {
            } finally {
            }
        }
        return false;
    }
}
