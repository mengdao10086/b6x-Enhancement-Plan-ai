package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/room/f3;", "Lkotlin/coroutines/CoroutineContext$a;", "Lkotlin/z1;", "b", "g", "Lkotlinx/coroutines/c2;", "a", "Lkotlinx/coroutines/c2;", "transactionThreadControlJob", "Lkotlin/coroutines/d;", "Lkotlin/coroutines/d;", "e", "()Lkotlin/coroutines/d;", "transactionDispatcher", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "key", "<init>", "(Lkotlinx/coroutines/c2;Lkotlin/coroutines/d;)V", "d", "room-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class f3 implements CoroutineContext.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f7376d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final kotlinx.coroutines.c2 f7377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.d f7378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final AtomicInteger f7379c;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/f3$a;", "Lkotlin/coroutines/CoroutineContext$b;", "Landroidx/room/f3;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements CoroutineContext.b<f3> {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public f3(@yt.k kotlinx.coroutines.c2 transactionThreadControlJob, @yt.k kotlin.coroutines.d transactionDispatcher) {
        kotlin.jvm.internal.f0.p(transactionThreadControlJob, "transactionThreadControlJob");
        kotlin.jvm.internal.f0.p(transactionDispatcher, "transactionDispatcher");
        this.f7377a = transactionThreadControlJob;
        this.f7378b = transactionDispatcher;
        this.f7379c = new AtomicInteger(0);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext L(@yt.k CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0431a.d(this, coroutineContext);
    }

    public final void b() {
        this.f7379c.incrementAndGet();
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0431a.b(this, bVar);
    }

    @yt.k
    public final kotlin.coroutines.d e() {
        return this.f7378b;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0431a.c(this, bVar);
    }

    public final void g() {
        int iDecrementAndGet = this.f7379c.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (iDecrementAndGet == 0) {
            c2.a.b(this.f7377a, null, 1, null);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @yt.k
    public CoroutineContext.b<f3> getKey() {
        return f7376d;
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0431a.a(this, r10, pVar);
    }
}
