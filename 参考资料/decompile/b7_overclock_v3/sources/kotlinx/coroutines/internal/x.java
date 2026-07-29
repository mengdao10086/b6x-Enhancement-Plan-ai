package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
public final class x<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38845h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38846i = 30;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38847j = 1073741823;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f38848k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f38849l = 1073741823;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38850m = 30;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f38851n = 1152921503533105152L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f38852o = 60;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f38853p = 1152921504606846976L;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f38854q = 61;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f38855r = 2305843009213693952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f38856s = 1024;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f38858u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f38859v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f38860w = 2;

    @yt.l
    @hk.v
    private volatile Object _next;

    @hk.v
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f38862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final AtomicReferenceArray f38864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f38842e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38843f = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final AtomicLongFieldUpdater f38844g = AtomicLongFieldUpdater.newUpdater(x.class, "_state");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final o0 f38857t = new o0("REMOVE_FROZEN");

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & x.f38855r) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return e(j10, x.f38849l) | (((long) i10) << 0);
        }

        public final long c(long j10, int i10) {
            return e(j10, x.f38851n) | (((long) i10) << 30);
        }

        public final <T> T d(long j10, @yt.k ik.p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.r0(Integer.valueOf((int) ((x.f38849l & j10) >> 0)), Integer.valueOf((int) ((j10 & x.f38851n) >> 30)));
        }

        public final long e(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        public final int f38865a;

        public b(int i10) {
            this.f38865a = i10;
        }
    }

    public x(int i10, boolean z10) {
        this.f38861a = i10;
        this.f38862b = z10;
        int i11 = i10 - 1;
        this.f38863c = i11;
        this.f38864d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(@yt.k E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.x.f38844g
        L2:
            long r3 = r0.get(r14)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L16
            kotlinx.coroutines.internal.x$a r15 = kotlinx.coroutines.internal.x.f38842e
            int r15 = r15.a(r3)
            return r15
        L16:
            kotlinx.coroutines.internal.x$a r1 = kotlinx.coroutines.internal.x.f38842e
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            r9 = 0
            long r5 = r5 >> r9
            int r2 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r10 = 30
            long r5 = r5 >> r10
            int r10 = (int) r5
            int r11 = r14.f38863c
            int r5 = r10 + 2
            r5 = r5 & r11
            r6 = r2 & r11
            r12 = 1
            if (r5 != r6) goto L34
            return r12
        L34:
            boolean r5 = r14.f38862b
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            if (r5 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r14.f38864d
            r13 = r10 & r11
            java.lang.Object r5 = r5.get(r13)
            if (r5 == 0) goto L53
            int r1 = r14.f38861a
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L52
            int r10 = r10 - r2
            r2 = r10 & r6
            int r1 = r1 >> 1
            if (r2 <= r1) goto L2
        L52:
            return r12
        L53:
            int r2 = r10 + 1
            r2 = r2 & r6
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = kotlinx.coroutines.internal.x.f38844g
            long r12 = r1.c(r3, r2)
            r1 = r5
            r2 = r14
            r5 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r14.f38864d
            r1 = r10 & r11
            r0.set(r1, r15)
            r0 = r14
        L6d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.x.f38844g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L84
            kotlinx.coroutines.internal.x r0 = r0.m()
            kotlinx.coroutines.internal.x r0 = r0.e(r10, r15)
            if (r0 != 0) goto L6d
        L84:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.x.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final x<E> b(long j10) {
        x<E> xVar = new x<>(this.f38861a * 2, this.f38862b);
        int i10 = (int) ((f38849l & j10) >> 0);
        int i11 = (int) ((f38851n & j10) >> 30);
        while (true) {
            int i12 = this.f38863c;
            if ((i10 & i12) == (i11 & i12)) {
                f38844g.set(xVar, f38842e.e(j10, f38853p));
                return xVar;
            }
            Object bVar = this.f38864d.get(i12 & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            xVar.f38864d.set(xVar.f38863c & i10, bVar);
            i10++;
        }
    }

    public final x<E> c(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38843f;
        while (true) {
            x<E> xVar = (x) atomicReferenceFieldUpdater.get(this);
            if (xVar != null) {
                return xVar;
            }
            al.o.a(f38843f, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38844g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & f38855r) != 0) {
                return true;
            }
            if ((f38853p & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j10 | f38855r));
        return true;
    }

    public final x<E> e(int i10, E e10) {
        Object obj = this.f38864d.get(this.f38863c & i10);
        if (!(obj instanceof b) || ((b) obj).f38865a != i10) {
            return null;
        }
        this.f38864d.set(i10 & this.f38863c, e10);
        return this;
    }

    public final int f() {
        long j10 = f38844g.get(this);
        return 1073741823 & (((int) ((j10 & f38851n) >> 30)) - ((int) ((f38849l & j10) >> 0)));
    }

    public final boolean g() {
        return (f38844g.get(this) & f38855r) != 0;
    }

    public final boolean h() {
        long j10 = f38844g.get(this);
        return ((int) ((f38849l & j10) >> 0)) == ((int) ((j10 & f38851n) >> 30));
    }

    public final void i(AtomicLongFieldUpdater atomicLongFieldUpdater, ik.l<? super Long, z1> lVar, Object obj) {
        while (true) {
            lVar.i(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    public final void j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @yt.k
    public final <R> List<R> k(@yt.k ik.l<? super E, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(this.f38861a);
        long j10 = f38844g.get(this);
        int i10 = (int) ((f38849l & j10) >> 0);
        int i11 = (int) ((j10 & f38851n) >> 30);
        while (true) {
            int i12 = this.f38863c;
            if ((i10 & i12) == (i11 & i12)) {
                return arrayList;
            }
            a0.b bVar = (Object) this.f38864d.get(i12 & i10);
            if (bVar != null && !(bVar instanceof b)) {
                arrayList.add(lVar.i(bVar));
            }
            i10++;
        }
    }

    public final long l() {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38844g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & f38853p) != 0) {
                return j10;
            }
            j11 = j10 | f38853p;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j11));
        return j11;
    }

    @yt.k
    public final x<E> m() {
        return c(l());
    }

    @yt.l
    public final Object n() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38844g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((f38853p & j10) != 0) {
                return f38857t;
            }
            a aVar = f38842e;
            int i10 = (int) ((f38849l & j10) >> 0);
            int i11 = (int) ((f38851n & j10) >> 30);
            int i12 = this.f38863c;
            if ((i11 & i12) == (i10 & i12)) {
                return null;
            }
            Object obj = this.f38864d.get(i12 & i10);
            if (obj == null) {
                if (this.f38862b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i13 = (i10 + 1) & 1073741823;
                if (f38844g.compareAndSet(this, j10, aVar.b(j10, i13))) {
                    this.f38864d.set(this.f38863c & i10, null);
                    return obj;
                }
                if (this.f38862b) {
                    x<E> xVarO = this;
                    do {
                        xVarO = xVarO.o(i10, i13);
                    } while (xVarO != null);
                    return obj;
                }
            }
        }
    }

    public final x<E> o(int i10, int i11) {
        long j10;
        a aVar;
        int i12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f38844g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            aVar = f38842e;
            i12 = (int) ((f38849l & j10) >> 0);
            if ((f38853p & j10) != 0) {
                return m();
            }
        } while (!f38844g.compareAndSet(this, j10, aVar.b(j10, i11)));
        this.f38864d.set(this.f38863c & i12, null);
        return null;
    }

    public final void p(AtomicLongFieldUpdater atomicLongFieldUpdater, ik.l<? super Long, Long> lVar, Object obj) {
        long j10;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lVar.i(Long.valueOf(j10)).longValue()));
    }

    public final long q(AtomicLongFieldUpdater atomicLongFieldUpdater, ik.l<? super Long, Long> lVar, Object obj) {
        long j10;
        Long lI;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
            lI = lVar.i(Long.valueOf(j10));
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, lI.longValue()));
        return lI.longValue();
    }
}
