package kotlinx.coroutines.sync;

import hk.v;
import ik.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.internal.m0;
import kotlinx.coroutines.m3;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;
import kotlinx.coroutines.selects.j;
import xc.d;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
public class SemaphoreImpl implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final AtomicReferenceFieldUpdater f39054c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, d.f55085o);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final AtomicLongFieldUpdater f39055d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final AtomicReferenceFieldUpdater f39056e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final AtomicLongFieldUpdater f39057f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final AtomicIntegerFieldUpdater f39058g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    @v
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final l<Throwable, z1> f39060b;

    @v
    private volatile long deqIdx;

    @v
    private volatile long enqIdx;

    @yt.l
    @v
    private volatile Object head;

    @yt.l
    @v
    private volatile Object tail;

    public SemaphoreImpl(int i10, int i11) {
        this.f39059a = i10;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
        }
        if (!(i11 >= 0 && i11 <= i10)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        c cVar = new c(0L, null, 2);
        this.head = cVar;
        this.tail = cVar;
        this._availablePermits = i10 - i11;
        this.f39060b = new l<Throwable, z1>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            {
                super(1);
            }

            public final void b(@k Throwable th2) {
                this.this$0.release();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
    }

    public static /* synthetic */ Object n(SemaphoreImpl semaphoreImpl, kotlin.coroutines.c<? super z1> cVar) {
        if (semaphoreImpl.r() > 0) {
            return z1.f38230a;
        }
        Object objO = semaphoreImpl.o(cVar);
        return objO == yj.b.h() ? objO : z1.f38230a;
    }

    @Override // kotlinx.coroutines.sync.b
    public int a() {
        return Math.max(f39058g.get(this), 0);
    }

    @Override // kotlinx.coroutines.sync.b
    @yt.l
    public Object d(@k kotlin.coroutines.c<? super z1> cVar) {
        return n(this, cVar);
    }

    @Override // kotlinx.coroutines.sync.b
    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f39058g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f39059a) {
                q();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final <W> void l(W w10, l<? super W, Boolean> lVar, l<? super W, z1> lVar2) {
        while (r() <= 0) {
            if (lVar.i(w10).booleanValue()) {
                return;
            }
        }
        lVar2.i(w10);
    }

    public final void m(@k o<? super z1> oVar) {
        while (r() <= 0) {
            f0.n(oVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (p((m3) oVar)) {
                return;
            }
        }
        oVar.R(z1.f38230a, this.f39060b);
    }

    public final Object o(kotlin.coroutines.c<? super z1> cVar) {
        p pVarB = r.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            if (!p(pVarB)) {
                m(pVarB);
            }
            Object objC = pVarB.C();
            if (objC == yj.b.h()) {
                f.c(cVar);
            }
            return objC == yj.b.h() ? objC : z1.f38230a;
        } catch (Throwable th2) {
            pVarB.U();
            throw th2;
        }
    }

    public final boolean p(m3 m3Var) {
        Object objG;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f39056e;
        c cVar = (c) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f39057f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.f39061c;
        long j10 = andIncrement / ((long) SemaphoreKt.f39068f);
        do {
            objG = e.g(cVar, j10, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (m0.h(objG)) {
                break;
            }
            l0 l0VarF = m0.f(objG);
            while (true) {
                l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                if (l0Var.f38812c >= l0VarF.f38812c) {
                    break;
                }
                if (!l0VarF.s()) {
                    z10 = false;
                    break;
                }
                if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, l0VarF)) {
                    if (l0Var.o()) {
                        l0Var.l();
                    }
                } else if (l0VarF.o()) {
                    l0VarF.l();
                }
            }
            z10 = true;
        } while (!z10);
        c cVar2 = (c) m0.f(objG);
        int i10 = (int) (andIncrement % ((long) SemaphoreKt.f39068f));
        if (cVar2.v().compareAndSet(i10, null, m3Var)) {
            m3Var.g(cVar2, i10);
            return true;
        }
        if (!cVar2.v().compareAndSet(i10, SemaphoreKt.f39064b, SemaphoreKt.f39065c)) {
            return false;
        }
        if (m3Var instanceof o) {
            f0.n(m3Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((o) m3Var).R(z1.f38230a, this.f39060b);
            return true;
        }
        if (m3Var instanceof j) {
            ((j) m3Var).r(z1.f38230a);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + m3Var).toString());
    }

    public final void q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f39058g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.f39059a;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    public final int r() {
        int andDecrement;
        do {
            andDecrement = f39058g.getAndDecrement(this);
        } while (andDecrement > this.f39059a);
        return andDecrement;
    }

    @Override // kotlinx.coroutines.sync.b
    public void release() {
        do {
            int andIncrement = f39058g.getAndIncrement(this);
            if (andIncrement >= this.f39059a) {
                q();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f39059a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!u());
    }

    public final void s(@k j<?> jVar, @yt.l Object obj) {
        while (r() <= 0) {
            f0.n(jVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (p((m3) jVar)) {
                return;
            }
        }
        jVar.r(z1.f38230a);
    }

    public final boolean t(Object obj) {
        if (!(obj instanceof o)) {
            if (obj instanceof j) {
                return ((j) obj).n(this, z1.f38230a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        o oVar = (o) obj;
        Object objW = oVar.w(z1.f38230a, null, this.f39060b);
        if (objW == null) {
            return false;
        }
        oVar.l0(objW);
        return true;
    }

    public final boolean u() {
        Object objG;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f39054c;
        c cVar = (c) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f39055d.getAndIncrement(this);
        long j10 = andIncrement / ((long) SemaphoreKt.f39068f);
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.f39062c;
        do {
            objG = e.g(cVar, j10, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (m0.h(objG)) {
                break;
            }
            l0 l0VarF = m0.f(objG);
            while (true) {
                l0 l0Var = (l0) atomicReferenceFieldUpdater.get(this);
                if (l0Var.f38812c >= l0VarF.f38812c) {
                    break;
                }
                if (!l0VarF.s()) {
                    z10 = false;
                    break;
                }
                if (al.o.a(atomicReferenceFieldUpdater, this, l0Var, l0VarF)) {
                    if (l0Var.o()) {
                        l0Var.l();
                    }
                } else if (l0VarF.o()) {
                    l0VarF.l();
                }
            }
            z10 = true;
        } while (!z10);
        c cVar2 = (c) m0.f(objG);
        cVar2.b();
        if (cVar2.f38812c > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) SemaphoreKt.f39068f));
        Object andSet = cVar2.v().getAndSet(i10, SemaphoreKt.f39064b);
        if (andSet != null) {
            if (andSet == SemaphoreKt.f39067e) {
                return false;
            }
            return t(andSet);
        }
        int i11 = SemaphoreKt.f39063a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (cVar2.v().get(i10) == SemaphoreKt.f39065c) {
                return true;
            }
        }
        return !cVar2.v().compareAndSet(i10, SemaphoreKt.f39064b, SemaphoreKt.f39066d);
    }
}
