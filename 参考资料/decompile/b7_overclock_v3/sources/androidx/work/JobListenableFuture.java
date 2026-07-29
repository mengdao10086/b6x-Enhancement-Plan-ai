package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\t\u001a\u00020\b2\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\nH\u0096\u0001J\u0018\u0010\f\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ0\u0010\f\u001a\n \u0004*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0005\u001a\u00020\u000e2\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0003¢\u0006\u0004\b\f\u0010\u0010J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/work/JobListenableFuture;", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "p0", "Ljava/util/concurrent/Executor;", "p1", "Lkotlin/z1;", "addListener", "", CommonNetImpl.CANCEL, "get", "()Ljava/lang/Object;", "", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", CommonNetImpl.RESULT, "b", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/c2;", "a", "Lkotlinx/coroutines/c2;", "job", "Landroidx/work/impl/utils/futures/a;", "Landroidx/work/impl/utils/futures/a;", "underlying", "<init>", "(Lkotlinx/coroutines/c2;Landroidx/work/impl/utils/futures/a;)V", "work-runtime-ktx_release"}, k = 1, mv = {1, 5, 1})
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final c2 f8275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final androidx.work.impl.utils.futures.a<R> f8276b;

    public JobListenableFuture(@yt.k c2 job, @yt.k androidx.work.impl.utils.futures.a<R> underlying) {
        f0.p(job, "job");
        f0.p(underlying, "underlying");
        this.f8275a = job;
        this.f8276b = underlying;
        job.L1(new ik.l<Throwable, z1>(this) { // from class: androidx.work.JobListenableFuture.1
            public final /* synthetic */ JobListenableFuture<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(@yt.l Throwable th2) {
                if (th2 == null) {
                    if (!this.this$0.f8276b.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    if (th2 instanceof CancellationException) {
                        this.this$0.f8276b.cancel(true);
                        return;
                    }
                    androidx.work.impl.utils.futures.a aVar = this.this$0.f8276b;
                    Throwable cause = th2.getCause();
                    if (cause != null) {
                        th2 = cause;
                    }
                    aVar.q(th2);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f8276b.addListener(runnable, executor);
    }

    public final void b(R r10) {
        this.f8276b.p(r10);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.f8276b.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.f8276b.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, TimeUnit timeUnit) {
        return this.f8276b.get(j10, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f8276b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f8276b.isDone();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JobListenableFuture(c2 c2Var, androidx.work.impl.utils.futures.a aVar, int i10, kotlin.jvm.internal.u uVar) {
        if ((i10 & 2) != 0) {
            aVar = androidx.work.impl.utils.futures.a.u();
            f0.o(aVar, "create()");
        }
        this(c2Var, aVar);
    }
}
