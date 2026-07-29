package io.reactivex.internal.queue;

import bj.f;
import fj.n;
import io.reactivex.internal.util.l;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements n<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f35096i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f35097j = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray<Object> f35102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f35103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray<Object> f35104g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f35098a = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f35105h = new AtomicLong();

    public a(int i10) {
        int iB = l.b(Math.max(8, i10));
        int i11 = iB - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iB + 1);
        this.f35102e = atomicReferenceArray;
        this.f35101d = i11;
        a(iB);
        this.f35104g = atomicReferenceArray;
        this.f35103f = i11;
        this.f35100c = i11 - 1;
        t(0L);
    }

    public static int b(int i10) {
        return i10;
    }

    public static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    public static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    public static void r(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    public final void a(int i10) {
        this.f35099b = Math.min(i10 / 4, f35096i);
    }

    @Override // fj.o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f35105h.get();
    }

    public final long e() {
        return this.f35098a.get();
    }

    public final long g() {
        return this.f35105h.get();
    }

    @Override // fj.o
    public boolean isEmpty() {
        return k() == g();
    }

    public final AtomicReferenceArray<Object> j(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        int iB = b(i10);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, iB);
        r(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    public final long k() {
        return this.f35098a.get();
    }

    public final T m(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f35104g = atomicReferenceArray;
        return (T) h(atomicReferenceArray, c(j10, i10));
    }

    public final T n(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f35104g = atomicReferenceArray;
        int iC = c(j10, i10);
        T t10 = (T) h(atomicReferenceArray, iC);
        if (t10 != null) {
            r(atomicReferenceArray, iC, null);
            q(j10 + 1);
        }
        return t10;
    }

    public final void o(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t10, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f35102e = atomicReferenceArray2;
        this.f35100c = (j11 + j10) - 1;
        r(atomicReferenceArray2, i10, t10);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, i10, f35097j);
        t(j10 + 1);
    }

    @Override // fj.o
    public boolean offer(T t10) {
        Objects.requireNonNull(t10, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f35102e;
        long jE = e();
        int i10 = this.f35101d;
        int iC = c(jE, i10);
        if (jE < this.f35100c) {
            return u(atomicReferenceArray, t10, jE, iC);
        }
        long j10 = ((long) this.f35099b) + jE;
        if (h(atomicReferenceArray, c(j10, i10)) == null) {
            this.f35100c = j10 - 1;
            return u(atomicReferenceArray, t10, jE, iC);
        }
        if (h(atomicReferenceArray, c(1 + jE, i10)) == null) {
            return u(atomicReferenceArray, t10, jE, iC);
        }
        o(atomicReferenceArray, jE, iC, t10, i10);
        return true;
    }

    public int p() {
        long jG = g();
        while (true) {
            long jK = k();
            long jG2 = g();
            if (jG == jG2) {
                return (int) (jK - jG2);
            }
            jG = jG2;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f35104g;
        long jD = d();
        int i10 = this.f35103f;
        T t10 = (T) h(atomicReferenceArray, c(jD, i10));
        return t10 == f35097j ? m(j(atomicReferenceArray, i10 + 1), jD, i10) : t10;
    }

    @Override // fj.n, fj.o
    @f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f35104g;
        long jD = d();
        int i10 = this.f35103f;
        int iC = c(jD, i10);
        T t10 = (T) h(atomicReferenceArray, iC);
        boolean z10 = t10 == f35097j;
        if (t10 == null || z10) {
            if (z10) {
                return n(j(atomicReferenceArray, i10 + 1), jD, i10);
            }
            return null;
        }
        r(atomicReferenceArray, iC, null);
        q(jD + 1);
        return t10;
    }

    public final void q(long j10) {
        this.f35105h.lazySet(j10);
    }

    public final void s(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        r(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    public final void t(long j10) {
        this.f35098a.lazySet(j10);
    }

    public final boolean u(AtomicReferenceArray<Object> atomicReferenceArray, T t10, long j10, int i10) {
        r(atomicReferenceArray, i10, t10);
        t(j10 + 1);
        return true;
    }

    @Override // fj.o
    public boolean offer(T t10, T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f35102e;
        long jK = k();
        int i10 = this.f35101d;
        long j10 = 2 + jK;
        if (h(atomicReferenceArray, c(j10, i10)) == null) {
            int iC = c(jK, i10);
            r(atomicReferenceArray, iC + 1, t11);
            r(atomicReferenceArray, iC, t10);
            t(j10);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f35102e = atomicReferenceArray2;
        int iC2 = c(jK, i10);
        r(atomicReferenceArray2, iC2 + 1, t11);
        r(atomicReferenceArray2, iC2, t10);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, iC2, f35097j);
        t(j10);
        return true;
    }
}
