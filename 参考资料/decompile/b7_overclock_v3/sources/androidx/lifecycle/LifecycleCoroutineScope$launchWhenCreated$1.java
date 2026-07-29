package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleCoroutineScope$launchWhenCreated$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> $block;
    public int label;
    public final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleCoroutineScope$launchWhenCreated$1(LifecycleCoroutineScope lifecycleCoroutineScope, ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super LifecycleCoroutineScope$launchWhenCreated$1> cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new LifecycleCoroutineScope$launchWhenCreated$1(this.this$0, this.$block, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            Lifecycle lifecycleH = this.this$0.h();
            ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.a(lifecycleH, pVar, this) == objH) {
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
        return ((LifecycleCoroutineScope$launchWhenCreated$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
