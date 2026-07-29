package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InterruptibleKt$runInterruptible$2<T> extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super T>, Object> {
    public final /* synthetic */ ik.a<T> $block;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InterruptibleKt$runInterruptible$2(ik.a<? extends T> aVar, kotlin.coroutines.c<? super InterruptibleKt$runInterruptible$2> cVar) {
        super(2, cVar);
        this.$block = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.$block, cVar);
        interruptibleKt$runInterruptible$2.L$0 = obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.u0.n(obj);
        return InterruptibleKt.d(((o0) this.L$0).W(), this.$block);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super T> cVar) {
        return ((InterruptibleKt$runInterruptible$2) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
    }
}
