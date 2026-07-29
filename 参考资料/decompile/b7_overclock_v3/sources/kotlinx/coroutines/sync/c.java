package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.internal.l0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
public final class c extends l0<c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final AtomicReferenceArray f39069e;

    public c(long j10, @l c cVar, int i10) {
        super(j10, cVar, i10);
        this.f39069e = new AtomicReferenceArray(SemaphoreKt.f39068f);
    }

    @Override // kotlinx.coroutines.internal.l0
    public int p() {
        return SemaphoreKt.f39068f;
    }

    @Override // kotlinx.coroutines.internal.l0
    public void q(int i10, @l Throwable th2, @k CoroutineContext coroutineContext) {
        v().set(i10, SemaphoreKt.f39067e);
        r();
    }

    public final boolean t(int i10, @l Object obj, @l Object obj2) {
        return v().compareAndSet(i10, obj, obj2);
    }

    @k
    public String toString() {
        return "SemaphoreSegment[id=" + this.f38812c + ", hashCode=" + hashCode() + ']';
    }

    @l
    public final Object u(int i10) {
        return v().get(i10);
    }

    @k
    public final AtomicReferenceArray v() {
        return this.f39069e;
    }

    @l
    public final Object w(int i10, @l Object obj) {
        return v().getAndSet(i10, obj);
    }

    public final void x(int i10, @l Object obj) {
        v().set(i10, obj);
    }
}
