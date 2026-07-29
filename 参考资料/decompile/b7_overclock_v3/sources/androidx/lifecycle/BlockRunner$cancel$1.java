package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class BlockRunner$cancel$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public int label;
    public final /* synthetic */ BlockRunner<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockRunner$cancel$1(BlockRunner<T> blockRunner, kotlin.coroutines.c<? super BlockRunner$cancel$1> cVar) {
        super(2, cVar);
        this.this$0 = blockRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new BlockRunner$cancel$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            long j10 = this.this$0.f6059c;
            this.label = 1;
            if (DelayKt.b(j10, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
        }
        if (!this.this$0.f6057a.h()) {
            c2 c2Var = this.this$0.f6062f;
            if (c2Var != null) {
                c2.a.b(c2Var, null, 1, null);
            }
            this.this$0.f6062f = null;
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((BlockRunner$cancel$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
