package a;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class di2<E> {
    public volatile Object _next = null;
    public volatile long _state = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicReferenceArray f573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f574a;
    public final int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bi2 f5905a = new bi2(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final li2 f569a = new li2("REMOVE_FROZEN");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f571a = AtomicReferenceFieldUpdater.newUpdater(di2.class, Object.class, "_next");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicLongFieldUpdater f570a = AtomicLongFieldUpdater.newUpdater(di2.class, "_state");

    public di2(int i, boolean z) {
        this.b = i;
        this.f574a = z;
        this.f572a = i - 1;
        this.f573a = new AtomicReferenceArray(this.b);
        if (!(this.f572a <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((this.b & this.f572a) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            a.bi2 r13 = a.di2.f5905a
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r9 = (int) r4
            int r10 = r12.f572a
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L2e
            return r5
        L2e:
            boolean r1 = r12.f574a
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f573a
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4d
            int r1 = r12.b
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L4c
            int r9 = r9 - r0
            r0 = r9 & r4
            int r1 = r1 >> 1
            if (r0 <= r1) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = a.di2.f570a
            a.bi2 r4 = a.di2.f5905a
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f573a
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L72
            goto L7d
        L72:
            a.di2 r0 = r0.i()
            a.di2 r0 = r0.e(r9, r13)
            if (r0 == 0) goto L7d
            goto L68
        L7d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.di2.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final di2<E> b(long j) {
        di2<E> di2Var = new di2<>(this.b * 2, this.f574a);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f572a;
            if ((i & i3) == (i2 & i3)) {
                di2Var._state = f5905a.d(j, 1152921504606846976L);
                return di2Var;
            }
            Object ci2Var = this.f573a.get(i3 & i);
            if (ci2Var == null) {
                ci2Var = new ci2(i);
            }
            di2Var.f573a.set(di2Var.f572a & i, ci2Var);
            i++;
        }
    }

    public final di2<E> c(long j) {
        while (true) {
            di2<E> di2Var = (di2) this._next;
            if (di2Var != null) {
                return di2Var;
            }
            f571a.compareAndSet(this, null, b(j));
        }
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f570a.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final di2<E> e(int i, E e) {
        Object obj = this.f573a.get(this.f572a & i);
        if (!(obj instanceof ci2) || ((ci2) obj).f5798a != i) {
            return null;
        }
        this.f573a.set(i & this.f572a, e);
        return this;
    }

    public final int f() {
        long j = this._state;
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f570a.compareAndSet(this, j, j2));
        return j2;
    }

    public final di2<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return f569a;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = this.f572a;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i & i2)) {
                return null;
            }
            Object obj = this.f573a.get(i2 & i);
            if (obj == null) {
                if (this.f574a) {
                    return null;
                }
            } else {
                if (obj instanceof ci2) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                if (f570a.compareAndSet(this, j, f5905a.b(j, i3))) {
                    this.f573a.set(this.f572a & i, null);
                    return obj;
                }
                if (this.f574a) {
                    di2<E> di2VarK = this;
                    do {
                        di2VarK = di2VarK.k(i, i3);
                    } while (di2VarK != null);
                    return obj;
                }
            }
        }
    }

    public final di2<E> k(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            i3 = (int) ((1073741823 & j) >> 0);
            if (be2.a()) {
                if (!(i3 == i)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!f570a.compareAndSet(this, j, f5905a.b(j, i2)));
        this.f573a.set(this.f572a & i3, null);
        return null;
    }
}
