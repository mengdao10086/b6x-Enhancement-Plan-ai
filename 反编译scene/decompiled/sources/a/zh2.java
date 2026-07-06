package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8073a = AtomicReferenceFieldUpdater.newUpdater(zh2.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(zh2.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(zh2.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    public final boolean j(zh2 zh2Var) {
        b.lazySet(zh2Var, this);
        f8073a.lazySet(zh2Var, this);
        while (n() == this) {
            if (f8073a.compareAndSet(this, this, zh2Var)) {
                zh2Var.m(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (a.zh2.f8073a.compareAndSet(r3, r2, ((a.ii2) r4).f6418a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.zh2 k(a.hi2 r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            a.zh2 r0 = (a.zh2) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = a.zh2.b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.q()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof a.hi2
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            a.hi2 r0 = (a.hi2) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            a.hi2 r4 = (a.hi2) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof a.ii2
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a.zh2.f8073a
            a.ii2 r4 = (a.ii2) r4
            a.zh2 r4 = r4.f6418a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            a.zh2 r2 = (a.zh2) r2
            goto L7
        L52:
            if (r4 == 0) goto L59
            a.zh2 r4 = (a.zh2) r4
            r3 = r2
            r2 = r4
            goto L7
        L59:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.zh2.k(a.hi2):a.zh2");
    }

    public final zh2 l(zh2 zh2Var) {
        while (zh2Var.q()) {
            zh2Var = (zh2) zh2Var._prev;
        }
        return zh2Var;
    }

    public final void m(zh2 zh2Var) {
        zh2 zh2Var2;
        do {
            zh2Var2 = (zh2) zh2Var._prev;
            if (n() != zh2Var) {
                return;
            }
        } while (!b.compareAndSet(zh2Var, zh2Var2, this));
        if (q()) {
            zh2Var.k(null);
        }
    }

    public final Object n() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof hi2)) {
                return obj;
            }
            ((hi2) obj).c(this);
        }
    }

    public final zh2 o() {
        return xh2.b(n());
    }

    public final zh2 p() {
        zh2 zh2VarK = k(null);
        return zh2VarK != null ? zh2VarK : l((zh2) this._prev);
    }

    public boolean q() {
        return n() instanceof ii2;
    }

    public boolean r() {
        return s() == null;
    }

    public final zh2 s() {
        Object objN;
        zh2 zh2Var;
        do {
            objN = n();
            if (objN instanceof ii2) {
                return ((ii2) objN).f6418a;
            }
            if (objN == this) {
                return (zh2) objN;
            }
            if (objN == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            zh2Var = (zh2) objN;
        } while (!f8073a.compareAndSet(this, objN, zh2Var.t()));
        zh2Var.k(null);
        return null;
    }

    public final ii2 t() {
        ii2 ii2Var = (ii2) this._removedRef;
        if (ii2Var != null) {
            return ii2Var;
        }
        ii2 ii2Var2 = new ii2(this);
        c.lazySet(this, ii2Var2);
        return ii2Var2;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    public final int u(zh2 zh2Var, zh2 zh2Var2, yh2 yh2Var) {
        b.lazySet(zh2Var, this);
        f8073a.lazySet(zh2Var, zh2Var2);
        yh2Var.f7985a = zh2Var2;
        if (f8073a.compareAndSet(this, zh2Var2, yh2Var)) {
            return yh2Var.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
