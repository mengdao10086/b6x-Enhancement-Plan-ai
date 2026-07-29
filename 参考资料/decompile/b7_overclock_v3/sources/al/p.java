package al;

import hk.v;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n90#2:256\n90#2:257\n90#2:258\n90#2:261\n90#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f760b = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f761c = AtomicIntegerFieldUpdater.newUpdater(p.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f762d = AtomicIntegerFieldUpdater.newUpdater(p.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f763e = AtomicIntegerFieldUpdater.newUpdater(p.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final AtomicReferenceArray<i> f764a = new AtomicReferenceArray<>(128);

    @v
    private volatile int blockingTasksInBuffer;

    @v
    private volatile int consumerIndex;

    @yt.l
    @v
    private volatile Object lastScheduledTask;

    @v
    private volatile int producerIndex;

    public static /* synthetic */ i b(p pVar, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return pVar.a(iVar, z10);
    }

    @yt.l
    public final i a(@yt.k i iVar, boolean z10) {
        if (z10) {
            return c(iVar);
        }
        i iVar2 = (i) f760b.getAndSet(this, iVar);
        if (iVar2 == null) {
            return null;
        }
        return c(iVar2);
    }

    public final i c(i iVar) {
        if (e() == 127) {
            return iVar;
        }
        if (iVar.f746b.M0() == 1) {
            f763e.incrementAndGet(this);
        }
        int i10 = f761c.get(this) & 127;
        while (this.f764a.get(i10) != null) {
            Thread.yield();
        }
        this.f764a.lazySet(i10, iVar);
        f761c.incrementAndGet(this);
        return null;
    }

    public final void d(i iVar) {
        if (iVar != null) {
            if (iVar.f746b.M0() == 1) {
                f763e.decrementAndGet(this);
            }
        }
    }

    public final int e() {
        return f761c.get(this) - f762d.get(this);
    }

    public final int f() {
        return f760b.get(this) != null ? e() + 1 : e();
    }

    public final void g(@yt.k d dVar) {
        i iVar = (i) f760b.getAndSet(this, null);
        if (iVar != null) {
            dVar.a(iVar);
        }
        while (l(dVar)) {
        }
    }

    @yt.l
    public final i h() {
        i iVar = (i) f760b.getAndSet(this, null);
        return iVar == null ? j() : iVar;
    }

    @yt.l
    public final i i() {
        return m(true);
    }

    public final i j() {
        i andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f762d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f761c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f764a.getAndSet(i11, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    @yt.l
    public final i k() {
        return m(false);
    }

    public final boolean l(d dVar) {
        i iVarJ = j();
        if (iVarJ == null) {
            return false;
        }
        dVar.a(iVarJ);
        return true;
    }

    public final i m(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        i iVar;
        do {
            atomicReferenceFieldUpdater = f760b;
            iVar = (i) atomicReferenceFieldUpdater.get(this);
            if (iVar != null) {
                if ((iVar.f746b.M0() == 1) == z10) {
                }
            }
            int i10 = f762d.get(this);
            int i11 = f761c.get(this);
            while (i10 != i11) {
                if (z10 && f763e.get(this) == 0) {
                    return null;
                }
                i11--;
                i iVarO = o(i11, z10);
                if (iVarO != null) {
                    return iVarO;
                }
            }
            return null;
        } while (!o.a(atomicReferenceFieldUpdater, this, iVar, null));
        return iVar;
    }

    public final i n(int i10) {
        int i11 = f762d.get(this);
        int i12 = f761c.get(this);
        boolean z10 = i10 == 1;
        while (i11 != i12) {
            if (z10 && f763e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            i iVarO = o(i11, z10);
            if (iVarO != null) {
                return iVarO;
            }
            i11 = i13;
        }
        return null;
    }

    public final i o(int i10, boolean z10) {
        int i11 = i10 & 127;
        i iVar = this.f764a.get(i11);
        if (iVar != null) {
            if ((iVar.f746b.M0() == 1) == z10 && this.f764a.compareAndSet(i11, iVar, null)) {
                if (z10) {
                    f763e.decrementAndGet(this);
                }
                return iVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long p(int i10, @yt.k Ref.ObjectRef<i> objectRef) {
        T tJ = i10 == 3 ? j() : n(i10);
        if (tJ == 0) {
            return q(i10, objectRef);
        }
        objectRef.element = tJ;
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, al.i, java.lang.Object] */
    public final long q(int i10, Ref.ObjectRef<i> objectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = f760b;
            r12 = (i) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            if (((r12.f746b.M0() == 1 ? 1 : 2) & i10) == 0) {
                return -2L;
            }
            long jA = m.f754f.a() - r12.f745a;
            long j10 = m.f750b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!o.a(atomicReferenceFieldUpdater, this, r12, null));
        objectRef.element = r12;
        return -1L;
    }
}
