package zk;

import ik.l;
import ik.p;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.w0;
import kotlin.u0;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.k0;
import kotlinx.coroutines.j2;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
public final class b {
    public static final <T> void a(@k l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> cVar) {
        c cVarA = f.a(cVar);
        try {
            CoroutineContext coroutineContextB = cVar.b();
            Object objC = ThreadContextKt.c(coroutineContextB, null);
            try {
                Object objI = ((l) w0.q(lVar, 1)).i(cVarA);
                if (objI != yj.b.h()) {
                    Result.a aVar = Result.f37633a;
                    cVarA.x(Result.b(objI));
                }
            } finally {
                ThreadContextKt.a(coroutineContextB, objC);
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            cVarA.x(Result.b(u0.a(th2)));
        }
    }

    public static final <R, T> void b(@k p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, @k c<? super T> cVar) {
        c cVarA = f.a(cVar);
        try {
            CoroutineContext coroutineContextB = cVar.b();
            Object objC = ThreadContextKt.c(coroutineContextB, null);
            try {
                Object objR0 = ((p) w0.q(pVar, 2)).r0(r10, cVarA);
                if (objR0 != yj.b.h()) {
                    Result.a aVar = Result.f37633a;
                    cVarA.x(Result.b(objR0));
                }
            } finally {
                ThreadContextKt.a(coroutineContextB, objC);
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            cVarA.x(Result.b(u0.a(th2)));
        }
    }

    public static final <T> void c(@k l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> cVar) {
        c cVarA = f.a(cVar);
        try {
            Object objI = ((l) w0.q(lVar, 1)).i(cVarA);
            if (objI != yj.b.h()) {
                Result.a aVar = Result.f37633a;
                cVarA.x(Result.b(objI));
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            cVarA.x(Result.b(u0.a(th2)));
        }
    }

    public static final <T> void d(c<? super T> cVar, l<? super c<? super T>, ? extends Object> lVar) {
        c cVarA = f.a(cVar);
        try {
            Object objI = lVar.i(cVarA);
            if (objI != yj.b.h()) {
                Result.a aVar = Result.f37633a;
                cVarA.x(Result.b(objI));
            }
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            cVarA.x(Result.b(u0.a(th2)));
        }
    }

    @yt.l
    public static final <T, R> Object e(@k k0<? super T> k0Var, R r10, @k p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object c0Var;
        Object objX0;
        try {
            c0Var = ((p) w0.q(pVar, 2)).r0(r10, k0Var);
        } catch (Throwable th2) {
            c0Var = new c0(th2, false, 2, null);
        }
        if (c0Var != yj.b.h() && (objX0 = k0Var.X0(c0Var)) != j2.f38877b) {
            if (objX0 instanceof c0) {
                throw ((c0) objX0).f38294a;
            }
            return j2.h(objX0);
        }
        return yj.b.h();
    }

    @yt.l
    public static final <T, R> Object f(@k k0<? super T> k0Var, R r10, @k p<? super R, ? super c<? super T>, ? extends Object> pVar) throws Throwable {
        Object c0Var;
        Object objX0;
        try {
            c0Var = ((p) w0.q(pVar, 2)).r0(r10, k0Var);
        } catch (Throwable th2) {
            c0Var = new c0(th2, false, 2, null);
        }
        if (c0Var != yj.b.h() && (objX0 = k0Var.X0(c0Var)) != j2.f38877b) {
            if (objX0 instanceof c0) {
                Throwable th3 = ((c0) objX0).f38294a;
                if (((th3 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th3).f38264a == k0Var) ? false : true) {
                    throw th3;
                }
                if (c0Var instanceof c0) {
                    throw ((c0) c0Var).f38294a;
                }
            } else {
                c0Var = j2.h(objX0);
            }
            return c0Var;
        }
        return yj.b.h();
    }

    public static final <T> Object g(k0<? super T> k0Var, l<? super Throwable, Boolean> lVar, ik.a<? extends Object> aVar) throws Throwable {
        Object c0Var;
        Object objX0;
        try {
            c0Var = aVar.o();
        } catch (Throwable th2) {
            c0Var = new c0(th2, false, 2, null);
        }
        if (c0Var != yj.b.h() && (objX0 = k0Var.X0(c0Var)) != j2.f38877b) {
            if (!(objX0 instanceof c0)) {
                return j2.h(objX0);
            }
            c0 c0Var2 = (c0) objX0;
            if (lVar.i(c0Var2.f38294a).booleanValue()) {
                throw c0Var2.f38294a;
            }
            if (c0Var instanceof c0) {
                throw ((c0) c0Var).f38294a;
            }
            return c0Var;
        }
        return yj.b.h();
    }
}
