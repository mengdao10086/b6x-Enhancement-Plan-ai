package androidx.work;

import androidx.work.ListenableWorker;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
@d0(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CoroutineWorker$startWork$1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public int label;
    public final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, kotlin.coroutines.c<? super CoroutineWorker$startWork$1> cVar) {
        super(2, cVar);
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new CoroutineWorker$startWork$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u0.n(obj);
                CoroutineWorker coroutineWorker = this.this$0;
                this.label = 1;
                obj = coroutineWorker.y(this);
                if (obj == objH) {
                    return objH;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
            }
            this.this$0.D().p((ListenableWorker.a) obj);
        } catch (Throwable th2) {
            this.this$0.D().q(th2);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((CoroutineWorker$startWork$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
