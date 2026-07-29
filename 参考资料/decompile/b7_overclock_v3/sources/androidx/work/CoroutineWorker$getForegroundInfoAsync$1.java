package androidx.work;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
@d0(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ JobListenableFuture<g> $jobFuture;
    public Object L$0;
    public int label;
    public final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<g> jobListenableFuture, CoroutineWorker coroutineWorker, kotlin.coroutines.c<? super CoroutineWorker$getForegroundInfoAsync$1> cVar) {
        super(2, cVar);
        this.$jobFuture = jobListenableFuture;
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.$jobFuture, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        JobListenableFuture jobListenableFuture;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            JobListenableFuture<g> jobListenableFuture2 = this.$jobFuture;
            CoroutineWorker coroutineWorker = this.this$0;
            this.L$0 = jobListenableFuture2;
            this.label = 1;
            Object objB = coroutineWorker.B(this);
            if (objB == objH) {
                return objH;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = objB;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jobListenableFuture = (JobListenableFuture) this.L$0;
            u0.n(obj);
        }
        jobListenableFuture.b(obj);
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
