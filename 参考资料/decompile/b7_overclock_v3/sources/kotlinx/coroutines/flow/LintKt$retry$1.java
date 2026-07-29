package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nLint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Lint.kt\nkotlinx/coroutines/flow/LintKt$retry$1\n*L\n1#1,193:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LintKt$retry$1 extends SuspendLambda implements ik.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> {
    public int label;

    public LintKt$retry$1(kotlin.coroutines.c<? super LintKt$retry$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new LintKt$retry$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        return zj.a.a(true);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k Throwable th2, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        return ((LintKt$retry$1) M(th2, cVar)).q0(z1.f38230a);
    }
}
