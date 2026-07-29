package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class z {
    @yt.k
    public static final <T> x<T> a(T t10) {
        y yVar = new y(null);
        yVar.u1(t10);
        return yVar;
    }

    @yt.k
    public static final <T> x<T> b(@yt.l c2 c2Var) {
        return new y(c2Var);
    }

    public static /* synthetic */ x c(c2 c2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c2Var = null;
        }
        return b(c2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@yt.k x<T> xVar, @yt.k Object obj) {
        Throwable thF = Result.f(obj);
        return thF == null ? xVar.u1(obj) : xVar.l(thF);
    }
}
