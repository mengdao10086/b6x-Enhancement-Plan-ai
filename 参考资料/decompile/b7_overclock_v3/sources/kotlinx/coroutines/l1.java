package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
public abstract class l1 extends m1 implements w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38897f = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38898g = AtomicReferenceFieldUpdater.newUpdater(l1.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38899h = AtomicIntegerFieldUpdater.newUpdater(l1.class, "_isCompleted");

    @yt.l
    @hk.v
    private volatile Object _delayed;

    @hk.v
    private volatile int _isCompleted = 0;

    @yt.l
    @hk.v
    private volatile Object _queue;

    @kotlin.jvm.internal.t0({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final o<kotlin.z1> f38900c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, @yt.k o<? super kotlin.z1> oVar) {
            super(j10);
            this.f38900c = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f38900c.O(l1.this, kotlin.z1.f38230a);
        }

        @Override // kotlinx.coroutines.l1.c
        @yt.k
        public String toString() {
            return super.toString() + this.f38900c;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final Runnable f38902c;

        public b(long j10, @yt.k Runnable runnable) {
            super(j10);
            this.f38902c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f38902c.run();
        }

        @Override // kotlinx.coroutines.l1.c
        @yt.k
        public String toString() {
            return super.toString() + this.f38902c;
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    public static abstract class c implements Runnable, Comparable<c>, g1, kotlinx.coroutines.internal.y0 {

        @yt.l
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        public long f38903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38904b = -1;

        public c(long j10) {
            this.f38903a = j10;
        }

        @Override // kotlinx.coroutines.internal.y0
        public int S() {
            return this.f38904b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@yt.k c cVar) {
            long j10 = this.f38903a - cVar.f38903a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.g1
        public final void dispose() {
            synchronized (this) {
                Object obj = this._heap;
                if (obj == o1.f38914a) {
                    return;
                }
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null) {
                    dVar.k(this);
                }
                this._heap = o1.f38914a;
                kotlin.z1 z1Var = kotlin.z1.f38230a;
            }
        }

        public final int e(long j10, @yt.k d dVar, @yt.k l1 l1Var) {
            synchronized (this) {
                if (this._heap == o1.f38914a) {
                    return 2;
                }
                synchronized (dVar) {
                    c cVarF = dVar.f();
                    if (l1Var.n()) {
                        return 1;
                    }
                    if (cVarF == null) {
                        dVar.f38905c = j10;
                    } else {
                        long j11 = cVarF.f38903a;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - dVar.f38905c > 0) {
                            dVar.f38905c = j10;
                        }
                    }
                    long j12 = this.f38903a;
                    long j13 = dVar.f38905c;
                    if (j12 - j13 < 0) {
                        this.f38903a = j13;
                    }
                    dVar.a(this);
                    return 0;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.y0
        public void f(int i10) {
            this.f38904b = i10;
        }

        @Override // kotlinx.coroutines.internal.y0
        public void g(@yt.l kotlinx.coroutines.internal.x0<?> x0Var) {
            if (!(this._heap != o1.f38914a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = x0Var;
        }

        @Override // kotlinx.coroutines.internal.y0
        @yt.l
        public kotlinx.coroutines.internal.x0<?> h() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.x0) {
                return (kotlinx.coroutines.internal.x0) obj;
            }
            return null;
        }

        public final boolean i(long j10) {
            return j10 - this.f38903a >= 0;
        }

        @yt.k
        public String toString() {
            return "Delayed[nanos=" + this.f38903a + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.x0<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hk.e
        public long f38905c;

        public d(long j10) {
            this.f38905c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        return f38899h.get(this) != 0;
    }

    public final void D2() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38897f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (al.o.a(f38897f, this, null, o1.f38921h)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.x) {
                ((kotlinx.coroutines.internal.x) obj).d();
                return;
            } else {
                if (obj == o1.f38921h) {
                    return;
                }
                kotlinx.coroutines.internal.x xVar = new kotlinx.coroutines.internal.x(8, true);
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                xVar.a((Runnable) obj);
                if (al.o.a(f38897f, this, obj, xVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable E2() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38897f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.x) {
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.x xVar = (kotlinx.coroutines.internal.x) obj;
                Object objN = xVar.n();
                if (objN != kotlinx.coroutines.internal.x.f38857t) {
                    return (Runnable) objN;
                }
                al.o.a(f38897f, this, obj, xVar.m());
            } else {
                if (obj == o1.f38921h) {
                    return null;
                }
                if (al.o.a(f38897f, this, obj, null)) {
                    kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void F2(@yt.k Runnable runnable) {
        if (G2(runnable)) {
            B2();
        } else {
            s0.f38948i.F2(runnable);
        }
    }

    public final boolean G2(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38897f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (n()) {
                return false;
            }
            if (obj == null) {
                if (al.o.a(f38897f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.x) {
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.x xVar = (kotlinx.coroutines.internal.x) obj;
                int iA = xVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    al.o.a(f38897f, this, obj, xVar.m());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == o1.f38921h) {
                    return false;
                }
                kotlinx.coroutines.internal.x xVar2 = new kotlinx.coroutines.internal.x(8, true);
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                xVar2.a((Runnable) obj);
                xVar2.a(runnable);
                if (al.o.a(f38897f, this, obj, xVar2)) {
                    return true;
                }
            }
        }
    }

    public final void H2(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void I2() {
        c cVarN;
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        long jB = bVarB != null ? bVarB.b() : System.nanoTime();
        while (true) {
            d dVar = (d) f38898g.get(this);
            if (dVar == null || (cVarN = dVar.n()) == null) {
                return;
            } else {
                A2(jB, cVarN);
            }
        }
    }

    public final void J2() {
        f38897f.set(this, null);
        f38898g.set(this, null);
    }

    public final void K2(long j10, @yt.k c cVar) {
        int iL2 = L2(j10, cVar);
        if (iL2 == 0) {
            if (O2(cVar)) {
                B2();
            }
        } else if (iL2 == 1) {
            A2(j10, cVar);
        } else if (iL2 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int L2(long j10, c cVar) {
        if (n()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38898g;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            al.o.a(atomicReferenceFieldUpdater, this, null, new d(j10));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.f0.m(obj);
            dVar = (d) obj;
        }
        return cVar.e(j10, dVar, this);
    }

    @yt.k
    public final g1 M2(long j10, @yt.k Runnable runnable) {
        long jD = o1.d(j10);
        if (jD >= 4611686018427387903L) {
            return p2.f38929a;
        }
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        long jB = bVarB != null ? bVarB.b() : System.nanoTime();
        b bVar = new b(jD + jB, runnable);
        K2(jB, bVar);
        return bVar;
    }

    public final void N2(boolean z10) {
        f38899h.set(this, z10 ? 1 : 0);
    }

    public final boolean O2(c cVar) {
        d dVar = (d) f38898g.get(this);
        return (dVar != null ? dVar.i() : null) == cVar;
    }

    @Override // kotlinx.coroutines.w0
    @yt.k
    public g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
        return w0.a.b(this, j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        F2(runnable);
    }

    @Override // kotlinx.coroutines.w0
    public void i(long j10, @yt.k o<? super kotlin.z1> oVar) {
        long jD = o1.d(j10);
        if (jD < 4611686018427387903L) {
            kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
            long jB = bVarB != null ? bVarB.b() : System.nanoTime();
            a aVar = new a(jD + jB, oVar);
            K2(jB, aVar);
            r.a(oVar, aVar);
        }
    }

    @Override // kotlinx.coroutines.w0
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @yt.l
    public Object m1(long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return w0.a.a(this, j10, cVar);
    }

    @Override // kotlinx.coroutines.k1
    public long q2() {
        c cVarI;
        if (super.q2() == 0) {
            return 0L;
        }
        Object obj = f38897f.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.x)) {
                return obj == o1.f38921h ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.x) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) f38898g.get(this);
        if (dVar == null || (cVarI = dVar.i()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarI.f38903a;
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        return qk.v.v(j10 - (bVarB != null ? bVarB.b() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.k1
    public void shutdown() {
        e3.f38471a.c();
        N2(true);
        D2();
        while (w2() <= 0) {
        }
        I2();
    }

    @Override // kotlinx.coroutines.k1
    public boolean t2() {
        if (!v2()) {
            return false;
        }
        d dVar = (d) f38898g.get(this);
        if (dVar != null && !dVar.h()) {
            return false;
        }
        Object obj = f38897f.get(this);
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.x) {
                return ((kotlinx.coroutines.internal.x) obj).h();
            }
            if (obj != o1.f38921h) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.k1
    public long w2() {
        c cVarL;
        if (x2()) {
            return 0L;
        }
        d dVar = (d) f38898g.get(this);
        if (dVar != null && !dVar.h()) {
            kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
            long jB = bVarB != null ? bVarB.b() : System.nanoTime();
            do {
                synchronized (dVar) {
                    c cVarF = dVar.f();
                    if (cVarF != null) {
                        c cVar = cVarF;
                        cVarL = cVar.i(jB) ? G2(cVar) : false ? dVar.l(0) : null;
                    }
                }
            } while (cVarL != null);
        }
        Runnable runnableE2 = E2();
        if (runnableE2 == null) {
            return q2();
        }
        runnableE2.run();
        return 0L;
    }
}
