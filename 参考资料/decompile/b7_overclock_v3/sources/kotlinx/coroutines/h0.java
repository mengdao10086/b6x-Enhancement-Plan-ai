package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
public final class h0 {
    @yt.k
    public static final <T> Object a(@yt.l Object obj, @yt.k kotlin.coroutines.c<? super T> cVar) {
        if (obj instanceof c0) {
            Result.a aVar = Result.f37633a;
            return Result.b(kotlin.u0.a(((c0) obj).f38294a));
        }
        Result.a aVar2 = Result.f37633a;
        return Result.b(obj);
    }

    @yt.l
    public static final <T> Object b(@yt.k Object obj, @yt.l ik.l<? super Throwable, kotlin.z1> lVar) {
        Throwable thF = Result.f(obj);
        return thF == null ? lVar != null ? new d0(obj, lVar) : obj : new c0(thF, false, 2, null);
    }

    @yt.l
    public static final <T> Object c(@yt.k Object obj, @yt.k o<?> oVar) {
        Throwable thF = Result.f(obj);
        return thF == null ? obj : new c0(thF, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, ik.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
