package androidx.lifecycle;

import kotlinx.coroutines.b3;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f6271a = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @yt.k
    public static final kotlinx.coroutines.o0 a(@yt.k x0 x0Var) {
        kotlin.jvm.internal.f0.p(x0Var, "<this>");
        kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) x0Var.d(f6271a);
        if (o0Var != null) {
            return o0Var;
        }
        Object objF = x0Var.f(f6271a, new e(b3.c(null, 1, null).L(kotlinx.coroutines.d1.e().o2())));
        kotlin.jvm.internal.f0.o(objF, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (kotlinx.coroutines.o0) objF;
    }
}
