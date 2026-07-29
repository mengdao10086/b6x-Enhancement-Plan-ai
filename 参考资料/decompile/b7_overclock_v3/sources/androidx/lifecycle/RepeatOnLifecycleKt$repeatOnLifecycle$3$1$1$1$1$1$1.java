package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> $block;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> cVar) {
        super(2, cVar);
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.L$0;
            ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> pVar = this.$block;
            this.label = 1;
            if (pVar.r0(o0Var, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
