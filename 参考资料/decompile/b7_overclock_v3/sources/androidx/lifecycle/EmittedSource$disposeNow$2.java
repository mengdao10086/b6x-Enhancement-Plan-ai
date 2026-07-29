package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EmittedSource$disposeNow$2 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public int label;
    public final /* synthetic */ EmittedSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmittedSource$disposeNow$2(EmittedSource emittedSource, kotlin.coroutines.c<? super EmittedSource$disposeNow$2> cVar) {
        super(2, cVar);
        this.this$0 = emittedSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new EmittedSource$disposeNow$2(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.u0.n(obj);
        this.this$0.c();
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((EmittedSource$disposeNow$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
