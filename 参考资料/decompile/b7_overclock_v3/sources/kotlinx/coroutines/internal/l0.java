package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.q2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
public abstract class l0<S extends l0<S>> extends f<S> implements q2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38811d = AtomicIntegerFieldUpdater.newUpdater(l0.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public final long f38812c;

    @hk.v
    private volatile int cleanedAndPointers;

    public l0(long j10, @yt.l S s10, int i10) {
        super(s10);
        this.f38812c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    @Override // kotlinx.coroutines.internal.f
    public boolean h() {
        return f38811d.get(this) == p() && !i();
    }

    public final boolean o() {
        return f38811d.addAndGet(this, -65536) == p() && !i();
    }

    public abstract int p();

    public abstract void q(int i10, @yt.l Throwable th2, @yt.k CoroutineContext coroutineContext);

    public final void r() {
        if (f38811d.incrementAndGet(this) == p()) {
            l();
        }
    }

    public final boolean s() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38811d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (!(i10 != p() || i())) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
