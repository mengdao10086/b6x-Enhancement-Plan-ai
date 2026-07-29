package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,220:1\n198#1,17:238\n1#2:221\n253#3:222\n254#3,2:233\n256#3:237\n107#4,10:223\n118#4,2:235\n61#5,2:255\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n188#1:238,17\n176#1:222\n176#1:233,2\n176#1:237\n176#1:223,10\n176#1:235,2\n218#1:255,2\n*E\n"})
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38286a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38287b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38288c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38289d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38290e = -1;

    public static final <T> void a(@yt.k a1<? super T> a1Var, int i10) {
        kotlin.coroutines.c<? super T> cVarE = a1Var.e();
        boolean z10 = i10 == 4;
        if (z10 || !(cVarE instanceof kotlinx.coroutines.internal.k) || c(i10) != c(a1Var.f38266c)) {
            e(a1Var, cVarE, z10);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.k) cVarE).f38804d;
        CoroutineContext coroutineContextB = cVarE.b();
        if (coroutineDispatcher.j2(coroutineContextB)) {
            coroutineDispatcher.h2(coroutineContextB, a1Var);
        } else {
            f(a1Var);
        }
    }

    @kotlin.s0
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean d(int i10) {
        return i10 == 2;
    }

    public static final <T> void e(@yt.k a1<? super T> a1Var, @yt.k kotlin.coroutines.c<? super T> cVar, boolean z10) {
        Object objH;
        Object objJ = a1Var.j();
        Throwable thF = a1Var.f(objJ);
        if (thF != null) {
            Result.a aVar = Result.f37633a;
            objH = kotlin.u0.a(thF);
        } else {
            Result.a aVar2 = Result.f37633a;
            objH = a1Var.h(objJ);
        }
        Object objB = Result.b(objH);
        if (!z10) {
            cVar.x(objB);
            return;
        }
        kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) cVar;
        kotlin.coroutines.c<T> cVar2 = kVar.f38805e;
        Object obj = kVar.f38807g;
        CoroutineContext coroutineContextB = cVar2.b();
        Object objC = ThreadContextKt.c(coroutineContextB, obj);
        k3<?> k3VarG = objC != ThreadContextKt.f38768a ? CoroutineContextKt.g(cVar2, coroutineContextB, objC) : null;
        try {
            kVar.f38805e.x(objB);
            kotlin.z1 z1Var = kotlin.z1.f38230a;
        } finally {
            if (k3VarG == null || k3VarG.J1()) {
                ThreadContextKt.a(coroutineContextB, objC);
            }
        }
    }

    public static final void f(a1<?> a1Var) {
        k1 k1VarB = e3.f38471a.b();
        if (k1VarB.u2()) {
            k1VarB.p2(a1Var);
            return;
        }
        k1VarB.r2(true);
        try {
            e(a1Var, a1Var.e(), true);
            do {
            } while (k1VarB.x2());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void g(@yt.k kotlin.coroutines.c<?> cVar, @yt.k Throwable th2) {
        Result.a aVar = Result.f37633a;
        cVar.x(Result.b(kotlin.u0.a(th2)));
    }

    public static final void h(@yt.k a1<?> a1Var, @yt.k k1 k1Var, @yt.k ik.a<kotlin.z1> aVar) {
        k1Var.r2(true);
        try {
            aVar.o();
            do {
            } while (k1Var.x2());
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th2) {
            try {
                a1Var.i(th2, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th3) {
                kotlin.jvm.internal.c0.d(1);
                k1Var.m2(true);
                kotlin.jvm.internal.c0.c(1);
                throw th3;
            }
        }
        k1Var.m2(true);
        kotlin.jvm.internal.c0.c(1);
    }
}
