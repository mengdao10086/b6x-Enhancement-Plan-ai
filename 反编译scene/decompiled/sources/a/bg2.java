package a;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class bg2 implements qf2, bd2, jg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5704a = AtomicReferenceFieldUpdater.newUpdater(bg2.class, Object.class, "_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    public bg2(boolean z) {
        this._state = z ? cg2.f399b : cg2.f398a;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException w0(bg2 bg2Var, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return bg2Var.v0(th, str);
    }

    public final Object A0(Object obj, Object obj2) {
        return !(obj instanceof jf2) ? cg2.f5791a : ((!(obj instanceof ue2) && !(obj instanceof wf2)) || (obj instanceof ad2) || (obj2 instanceof gd2)) ? B0((jf2) obj, obj2) : y0((jf2) obj, obj2) ? obj2 : cg2.c;
    }

    public final Object B0(jf2 jf2Var, Object obj) throws Throwable {
        gg2 gg2VarY = Y(jf2Var);
        if (gg2VarY == null) {
            return cg2.c;
        }
        zf2 zf2Var = (zf2) (!(jf2Var instanceof zf2) ? null : jf2Var);
        if (zf2Var == null) {
            zf2Var = new zf2(gg2VarY, false, null);
        }
        synchronized (zf2Var) {
            if (zf2Var.h()) {
                return cg2.f5791a;
            }
            zf2Var.k(true);
            if (zf2Var != jf2Var && !f5704a.compareAndSet(this, jf2Var, zf2Var)) {
                return cg2.c;
            }
            if (be2.a() && !(!zf2Var.i())) {
                throw new AssertionError();
            }
            boolean zG = zf2Var.g();
            gd2 gd2Var = (gd2) (!(obj instanceof gd2) ? null : obj);
            if (gd2Var != null) {
                zf2Var.b(gd2Var.f999a);
            }
            Throwable thF = true ^ zG ? zf2Var.f() : null;
            m42 m42Var = m42.f6769a;
            if (thF != null) {
                k0(gg2VarY, thF);
            }
            ad2 ad2VarS = S(jf2Var);
            return (ad2VarS == null || !C0(zf2Var, ad2VarS, obj)) ? R(zf2Var, obj) : cg2.b;
        }
    }

    public final boolean C(Object obj, gg2 gg2Var, wf2<?> wf2Var) {
        int iU;
        ag2 ag2Var = new ag2(wf2Var, wf2Var, this, obj);
        do {
            iU = gg2Var.p().u(wf2Var, gg2Var, ag2Var);
            if (iU == 1) {
                return true;
            }
        } while (iU != 2);
        return false;
    }

    public final boolean C0(zf2 zf2Var, ad2 ad2Var, Object obj) {
        while (of2.d(ad2Var.f5596a, false, false, new yf2(this, zf2Var, ad2Var, obj), 1, null) == hg2.f6312a) {
            ad2Var = j0(ad2Var);
            if (ad2Var == null) {
                return false;
            }
        }
        return true;
    }

    public final void D(Throwable th, List<? extends Throwable> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable thK = !be2.d() ? th : ki2.k(th);
        for (Throwable thK2 : list) {
            if (be2.d()) {
                thK2 = ki2.k(thK2);
            }
            if (thK2 != th && thK2 != thK && !(thK2 instanceof CancellationException) && setNewSetFromMap.add(thK2)) {
                x32.a(th, thK2);
            }
        }
    }

    public void E(Object obj) {
    }

    public final Object F(b62<Object> b62Var) throws Throwable {
        Object objA0;
        do {
            objA0 = a0();
            if (!(objA0 instanceof jf2)) {
                if (!(objA0 instanceof gd2)) {
                    return cg2.h(objA0);
                }
                Throwable th = ((gd2) objA0).f999a;
                if (be2.d() && (b62Var instanceof w62)) {
                    throw ki2.j(th, (w62) b62Var);
                }
                throw th;
            }
        } while (t0(objA0) < 0);
        return G(b62Var);
    }

    public final /* synthetic */ Object G(b62<Object> b62Var) {
        xf2 xf2Var = new xf2(q62.b(b62Var), this);
        wc2.a(xf2Var, k(new kg2(this, xf2Var)));
        Object objZ = xf2Var.z();
        if (objZ == r62.c()) {
            z62.c(b62Var);
        }
        return objZ;
    }

    public final boolean H(Throwable th) {
        return I(th);
    }

    public final boolean I(Object obj) throws Throwable {
        Object objF0 = cg2.f5791a;
        if (X() && (objF0 = K(obj)) == cg2.b) {
            return true;
        }
        if (objF0 == cg2.f5791a) {
            objF0 = f0(obj);
        }
        if (objF0 == cg2.f5791a || objF0 == cg2.b) {
            return true;
        }
        if (objF0 == cg2.d) {
            return false;
        }
        E(objF0);
        return true;
    }

    public void J(Throwable th) throws Throwable {
        I(th);
    }

    public final Object K(Object obj) {
        Object objA0;
        do {
            Object objA02 = a0();
            if (!(objA02 instanceof jf2) || ((objA02 instanceof zf2) && ((zf2) objA02).h())) {
                return cg2.f5791a;
            }
            objA0 = A0(objA02, new gd2(Q(obj), false, 2, null));
        } while (objA0 == cg2.c);
        return objA0;
    }

    public final boolean L(Throwable th) {
        if (e0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        zc2 zc2VarZ = Z();
        return (zc2VarZ == null || zc2VarZ == hg2.f6312a) ? z : zc2VarZ.e(th) || z;
    }

    public String M() {
        return "Job was cancelled";
    }

    public boolean N(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return I(th) && W();
    }

    public final void O(jf2 jf2Var, Object obj) throws Throwable {
        zc2 zc2VarZ = Z();
        if (zc2VarZ != null) {
            zc2VarZ.b();
            s0(hg2.f6312a);
        }
        if (!(obj instanceof gd2)) {
            obj = null;
        }
        gd2 gd2Var = (gd2) obj;
        Throwable th = gd2Var != null ? gd2Var.f999a : null;
        if (!(jf2Var instanceof wf2)) {
            gg2 gg2VarC = jf2Var.c();
            if (gg2VarC != null) {
                l0(gg2VarC, th);
                return;
            }
            return;
        }
        try {
            ((wf2) jf2Var).v(th);
        } catch (Throwable th2) {
            c0(new jd2("Exception in completion handler " + jf2Var + " for " + this, th2));
        }
    }

    public final void P(zf2 zf2Var, ad2 ad2Var, Object obj) {
        if (be2.a()) {
            if (!(a0() == zf2Var)) {
                throw new AssertionError();
            }
        }
        ad2 ad2VarJ0 = j0(ad2Var);
        if (ad2VarJ0 == null || !C0(zf2Var, ad2VarJ0, obj)) {
            E(R(zf2Var, obj));
        }
    }

    public final Throwable Q(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new rf2(M(), null, this);
        }
        if (obj != null) {
            return ((jg2) obj).x();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public final Object R(zf2 zf2Var, Object obj) throws Throwable {
        boolean zG;
        Throwable thV;
        boolean z = true;
        if (be2.a()) {
            if (!(a0() == zf2Var)) {
                throw new AssertionError();
            }
        }
        if (be2.a() && !(!zf2Var.i())) {
            throw new AssertionError();
        }
        if (be2.a() && !zf2Var.h()) {
            throw new AssertionError();
        }
        gd2 gd2Var = (gd2) (!(obj instanceof gd2) ? null : obj);
        Throwable th = gd2Var != null ? gd2Var.f999a : null;
        synchronized (zf2Var) {
            zG = zf2Var.g();
            List<Throwable> listJ = zf2Var.j(th);
            thV = V(zf2Var, listJ);
            if (thV != null) {
                D(thV, listJ);
            }
        }
        if (thV != null && thV != th) {
            obj = new gd2(thV, false, 2, null);
        }
        if (thV != null) {
            if (!L(thV) && !b0(thV)) {
                z = false;
            }
            if (z) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((gd2) obj).b();
            }
        }
        if (!zG) {
            m0(thV);
        }
        n0(obj);
        boolean zCompareAndSet = f5704a.compareAndSet(this, zf2Var, cg2.g(obj));
        if (be2.a() && !zCompareAndSet) {
            throw new AssertionError();
        }
        O(zf2Var, obj);
        return obj;
    }

    public final ad2 S(jf2 jf2Var) {
        ad2 ad2Var = (ad2) (!(jf2Var instanceof ad2) ? null : jf2Var);
        if (ad2Var != null) {
            return ad2Var;
        }
        gg2 gg2VarC = jf2Var.c();
        if (gg2VarC != null) {
            return j0(gg2VarC);
        }
        return null;
    }

    public final Object T() throws Throwable {
        Object objA0 = a0();
        if (!(!(objA0 instanceof jf2))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objA0 instanceof gd2) {
            throw ((gd2) objA0).f999a;
        }
        return cg2.h(objA0);
    }

    public final Throwable U(Object obj) {
        if (!(obj instanceof gd2)) {
            obj = null;
        }
        gd2 gd2Var = (gd2) obj;
        if (gd2Var != null) {
            return gd2Var.f999a;
        }
        return null;
    }

    public final Throwable V(zf2 zf2Var, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (zf2Var.g()) {
                return new rf2(M(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof tg2) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof tg2)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean W() {
        return true;
    }

    public boolean X() {
        return false;
    }

    public final gg2 Y(jf2 jf2Var) {
        gg2 gg2VarC = jf2Var.c();
        if (gg2VarC != null) {
            return gg2VarC;
        }
        if (jf2Var instanceof ue2) {
            return new gg2();
        }
        if (jf2Var instanceof wf2) {
            q0((wf2) jf2Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + jf2Var).toString());
    }

    public final zc2 Z() {
        return (zc2) this._parentHandle;
    }

    @Override // a.qf2
    public boolean a() {
        Object objA0 = a0();
        return (objA0 instanceof jf2) && ((jf2) objA0).a();
    }

    public final Object a0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof hi2)) {
                return obj;
            }
            ((hi2) obj).c(this);
        }
    }

    public boolean b0(Throwable th) {
        return false;
    }

    public void c0(Throwable th) throws Throwable {
        throw th;
    }

    public final void d0(qf2 qf2Var) {
        if (be2.a()) {
            if (!(Z() == null)) {
                throw new AssertionError();
            }
        }
        if (qf2Var == null) {
            s0(hg2.f6312a);
            return;
        }
        qf2Var.n();
        zc2 zc2VarU = qf2Var.u(this);
        s0(zc2VarU);
        if (g()) {
            zc2VarU.b();
            s0(hg2.f6312a);
        }
    }

    public boolean e0() {
        return false;
    }

    public final Object f0(Object obj) throws Throwable {
        Throwable thQ = null;
        while (true) {
            Object objA0 = a0();
            if (objA0 instanceof zf2) {
                synchronized (objA0) {
                    if (((zf2) objA0).i()) {
                        return cg2.d;
                    }
                    boolean zG = ((zf2) objA0).g();
                    if (obj != null || !zG) {
                        if (thQ == null) {
                            thQ = Q(obj);
                        }
                        ((zf2) objA0).b(thQ);
                    }
                    Throwable thF = zG ^ true ? ((zf2) objA0).f() : null;
                    if (thF != null) {
                        k0(((zf2) objA0).c(), thF);
                    }
                    return cg2.f5791a;
                }
            }
            if (!(objA0 instanceof jf2)) {
                return cg2.d;
            }
            if (thQ == null) {
                thQ = Q(obj);
            }
            jf2 jf2Var = (jf2) objA0;
            if (!jf2Var.a()) {
                Object objA02 = A0(objA0, new gd2(thQ, false, 2, null));
                if (objA02 == cg2.f5791a) {
                    throw new IllegalStateException(("Cannot happen in " + objA0).toString());
                }
                if (objA02 != cg2.c) {
                    return objA02;
                }
            } else if (z0(jf2Var, thQ)) {
                return cg2.f5791a;
            }
        }
    }

    @Override // a.l62
    public <R> R fold(R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        return (R) of2.b(this, r, k82Var);
    }

    public final boolean g() {
        return !(a0() instanceof jf2);
    }

    public final Object g0(Object obj) {
        Object objA0;
        do {
            objA0 = A0(a0(), obj);
            if (objA0 == cg2.f5791a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, U(obj));
            }
        } while (objA0 == cg2.c);
        return objA0;
    }

    @Override // a.i62, a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        return (E) of2.c(this, j62Var);
    }

    @Override // a.i62
    public final j62<?> getKey() {
        return qf2.f7209a;
    }

    public final wf2<?> h0(g82<? super Throwable, m42> g82Var, boolean z) {
        if (z) {
            sf2 sf2Var = (sf2) (g82Var instanceof sf2 ? g82Var : null);
            if (sf2Var != null) {
                if (be2.a()) {
                    if (!(sf2Var.f7784a == this)) {
                        throw new AssertionError();
                    }
                }
                if (sf2Var != null) {
                    return sf2Var;
                }
            }
            return new mf2(this, g82Var);
        }
        wf2<?> wf2Var = (wf2) (g82Var instanceof wf2 ? g82Var : null);
        if (wf2Var != null) {
            if (be2.a()) {
                if (!(wf2Var.f7784a == this && !(wf2Var instanceof sf2))) {
                    throw new AssertionError();
                }
            }
            if (wf2Var != null) {
                return wf2Var;
            }
        }
        return new nf2(this, g82Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0081 A[SYNTHETIC] */
    @Override // a.qf2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.re2 i(boolean r8, boolean r9, a.g82<? super java.lang.Throwable, a.m42> r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r7.a0()
            boolean r3 = r2 instanceof a.ue2
            if (r3 == 0) goto L27
            r3 = r2
            a.ue2 r3 = (a.ue2) r3
            boolean r4 = r3.a()
            if (r4 == 0) goto L23
            if (r1 == 0) goto L16
            goto L1a
        L16:
            a.wf2 r1 = r7.h0(r10, r8)
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = a.bg2.f5704a
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L2
            return r1
        L23:
            r7.p0(r3)
            goto L2
        L27:
            boolean r3 = r2 instanceof a.jf2
            if (r3 == 0) goto L95
            r3 = r2
            a.jf2 r3 = (a.jf2) r3
            a.gg2 r3 = r3.c()
            if (r3 != 0) goto L44
            if (r2 == 0) goto L3c
            a.wf2 r2 = (a.wf2) r2
            r7.q0(r2)
            goto L2
        L3c:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>"
            r8.<init>(r9)
            throw r8
        L44:
            a.hg2 r4 = a.hg2.f6312a
            if (r8 == 0) goto L7e
            boolean r5 = r2 instanceof a.zf2
            if (r5 == 0) goto L7e
            monitor-enter(r2)
            r5 = r2
            a.zf2 r5 = (a.zf2) r5     // Catch: java.lang.Throwable -> L7b
            java.lang.Throwable r5 = r5.f()     // Catch: java.lang.Throwable -> L7b
            if (r5 == 0) goto L63
            boolean r6 = r10 instanceof a.ad2     // Catch: java.lang.Throwable -> L7b
            if (r6 == 0) goto L77
            r6 = r2
            a.zf2 r6 = (a.zf2) r6     // Catch: java.lang.Throwable -> L7b
            boolean r6 = r6.h()     // Catch: java.lang.Throwable -> L7b
            if (r6 != 0) goto L77
        L63:
            if (r1 == 0) goto L66
            goto L6a
        L66:
            a.wf2 r1 = r7.h0(r10, r8)     // Catch: java.lang.Throwable -> L7b
        L6a:
            boolean r4 = r7.C(r2, r3, r1)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L72
            monitor-exit(r2)
            goto L2
        L72:
            if (r5 != 0) goto L76
            monitor-exit(r2)
            return r1
        L76:
            r4 = r1
        L77:
            a.m42 r6 = a.m42.f6769a     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r2)
            goto L7f
        L7b:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L7e:
            r5 = r0
        L7f:
            if (r5 == 0) goto L87
            if (r9 == 0) goto L86
            r10.f(r5)
        L86:
            return r4
        L87:
            if (r1 == 0) goto L8a
            goto L8e
        L8a:
            a.wf2 r1 = r7.h0(r10, r8)
        L8e:
            boolean r2 = r7.C(r2, r3, r1)
            if (r2 == 0) goto L2
            return r1
        L95:
            if (r9 == 0) goto La5
            boolean r8 = r2 instanceof a.gd2
            if (r8 != 0) goto L9c
            r2 = r0
        L9c:
            a.gd2 r2 = (a.gd2) r2
            if (r2 == 0) goto La2
            java.lang.Throwable r0 = r2.f999a
        La2:
            r10.f(r0)
        La5:
            a.hg2 r8 = a.hg2.f6312a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bg2.i(boolean, boolean, a.g82):a.re2");
    }

    public String i0() {
        return ce2.a(this);
    }

    @Override // a.bd2
    public final void j(jg2 jg2Var) throws Throwable {
        I(jg2Var);
    }

    public final ad2 j0(zh2 zh2Var) {
        while (zh2Var.q()) {
            zh2Var = zh2Var.p();
        }
        while (true) {
            zh2Var = zh2Var.o();
            if (!zh2Var.q()) {
                if (zh2Var instanceof ad2) {
                    return (ad2) zh2Var;
                }
                if (zh2Var instanceof gg2) {
                    return null;
                }
            }
        }
    }

    @Override // a.qf2
    public final re2 k(g82<? super Throwable, m42> g82Var) {
        return i(false, true, g82Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k0(a.gg2 r7, java.lang.Throwable r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.m0(r8)
            java.lang.Object r0 = r7.n()
            if (r0 == 0) goto L56
            a.zh2 r0 = (a.zh2) r0
            r1 = 0
        Lc:
            boolean r2 = a.f92.a(r0, r7)
            r2 = r2 ^ 1
            if (r2 == 0) goto L4d
            boolean r2 = r0 instanceof a.sf2
            if (r2 == 0) goto L48
            r2 = r0
            a.wf2 r2 = (a.wf2) r2
            r2.v(r8)     // Catch: java.lang.Throwable -> L1f
            goto L48
        L1f:
            r3 = move-exception
            if (r1 == 0) goto L28
            a.x32.a(r1, r3)
            if (r1 == 0) goto L28
            goto L48
        L28:
            a.jd2 r1 = new a.jd2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception in completion handler "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " for "
            r4.append(r2)
            r4.append(r6)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r3)
            a.m42 r2 = a.m42.f6769a
        L48:
            a.zh2 r0 = r0.o()
            goto Lc
        L4d:
            if (r1 == 0) goto L52
            r6.c0(r1)
        L52:
            r6.L(r8)
            return
        L56:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bg2.k0(a.gg2, java.lang.Throwable):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(a.gg2 r7, java.lang.Throwable r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r7.n()
            if (r0 == 0) goto L50
            a.zh2 r0 = (a.zh2) r0
            r1 = 0
        L9:
            boolean r2 = a.f92.a(r0, r7)
            r2 = r2 ^ 1
            if (r2 == 0) goto L4a
            boolean r2 = r0 instanceof a.wf2
            if (r2 == 0) goto L45
            r2 = r0
            a.wf2 r2 = (a.wf2) r2
            r2.v(r8)     // Catch: java.lang.Throwable -> L1c
            goto L45
        L1c:
            r3 = move-exception
            if (r1 == 0) goto L25
            a.x32.a(r1, r3)
            if (r1 == 0) goto L25
            goto L45
        L25:
            a.jd2 r1 = new a.jd2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception in completion handler "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " for "
            r4.append(r2)
            r4.append(r6)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r3)
            a.m42 r2 = a.m42.f6769a
        L45:
            a.zh2 r0 = r0.o()
            goto L9
        L4a:
            if (r1 == 0) goto L4f
            r6.c0(r1)
        L4f:
            return
        L50:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bg2.l0(a.gg2, java.lang.Throwable):void");
    }

    @Override // a.qf2
    public final CancellationException m() {
        Object objA0 = a0();
        if (!(objA0 instanceof zf2)) {
            if (objA0 instanceof jf2) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objA0 instanceof gd2) {
                return w0(this, ((gd2) objA0).f999a, null, 1, null);
            }
            return new rf2(ce2.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((zf2) objA0).f();
        if (thF != null) {
            CancellationException cancellationExceptionV0 = v0(thF, ce2.a(this) + " is cancelling");
            if (cancellationExceptionV0 != null) {
                return cancellationExceptionV0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public void m0(Throwable th) {
    }

    @Override // a.l62
    public l62 minusKey(j62<?> j62Var) {
        return of2.e(this, j62Var);
    }

    @Override // a.qf2
    public final boolean n() {
        int iT0;
        do {
            iT0 = t0(a0());
            if (iT0 == 0) {
                return false;
            }
        } while (iT0 != 1);
        return true;
    }

    public void n0(Object obj) {
    }

    public void o0() {
    }

    public final void p0(ue2 ue2Var) {
        gg2 gg2Var = new gg2();
        Object if2Var = gg2Var;
        if (!ue2Var.a()) {
            if2Var = new if2(gg2Var);
        }
        f5704a.compareAndSet(this, ue2Var, if2Var);
    }

    @Override // a.l62
    public l62 plus(l62 l62Var) {
        return of2.f(this, l62Var);
    }

    @Override // a.qf2
    public void q(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new rf2(M(), null, this);
        }
        J(cancellationException);
    }

    public final void q0(wf2<?> wf2Var) {
        wf2Var.j(new gg2());
        f5704a.compareAndSet(this, wf2Var, wf2Var.o());
    }

    public final void r0(wf2<?> wf2Var) {
        Object objA0;
        do {
            objA0 = a0();
            if (!(objA0 instanceof wf2)) {
                if (!(objA0 instanceof jf2) || ((jf2) objA0).c() == null) {
                    return;
                }
                wf2Var.r();
                return;
            }
            if (objA0 != wf2Var) {
                return;
            }
        } while (!f5704a.compareAndSet(this, objA0, cg2.f399b));
    }

    public final void s0(zc2 zc2Var) {
        this._parentHandle = zc2Var;
    }

    public final int t0(Object obj) {
        if (obj instanceof ue2) {
            if (((ue2) obj).a()) {
                return 0;
            }
            if (!f5704a.compareAndSet(this, obj, cg2.f399b)) {
                return -1;
            }
            o0();
            return 1;
        }
        if (!(obj instanceof if2)) {
            return 0;
        }
        if (!f5704a.compareAndSet(this, obj, ((if2) obj).c())) {
            return -1;
        }
        o0();
        return 1;
    }

    public String toString() {
        return x0() + '@' + ce2.b(this);
    }

    @Override // a.qf2
    public final zc2 u(bd2 bd2Var) {
        re2 re2VarD = of2.d(this, true, false, new ad2(this, bd2Var), 2, null);
        if (re2VarD != null) {
            return (zc2) re2VarD;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public final String u0(Object obj) {
        if (!(obj instanceof zf2)) {
            return obj instanceof jf2 ? ((jf2) obj).a() ? "Active" : "New" : obj instanceof gd2 ? "Cancelled" : "Completed";
        }
        zf2 zf2Var = (zf2) obj;
        return zf2Var.g() ? "Cancelling" : zf2Var.h() ? "Completing" : "Active";
    }

    public final CancellationException v0(Throwable th, String str) {
        CancellationException rf2Var = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (rf2Var == null) {
            if (str == null) {
                str = M();
            }
            rf2Var = new rf2(str, th, this);
        }
        return rf2Var;
    }

    @Override // a.jg2
    public CancellationException x() {
        Throwable thF;
        Object objA0 = a0();
        if (objA0 instanceof zf2) {
            thF = ((zf2) objA0).f();
        } else if (objA0 instanceof gd2) {
            thF = ((gd2) objA0).f999a;
        } else {
            if (objA0 instanceof jf2) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objA0).toString());
            }
            thF = null;
        }
        CancellationException cancellationException = (CancellationException) (thF instanceof CancellationException ? thF : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        return new rf2("Parent job is " + u0(objA0), thF, this);
    }

    public final String x0() {
        return i0() + '{' + u0(a0()) + '}';
    }

    public final boolean y0(jf2 jf2Var, Object obj) throws Throwable {
        if (be2.a()) {
            if (!((jf2Var instanceof ue2) || (jf2Var instanceof wf2))) {
                throw new AssertionError();
            }
        }
        if (be2.a() && !(!(obj instanceof gd2))) {
            throw new AssertionError();
        }
        if (!f5704a.compareAndSet(this, jf2Var, cg2.g(obj))) {
            return false;
        }
        m0(null);
        n0(obj);
        O(jf2Var, obj);
        return true;
    }

    public final boolean z0(jf2 jf2Var, Throwable th) throws Throwable {
        if (be2.a() && !(!(jf2Var instanceof zf2))) {
            throw new AssertionError();
        }
        if (be2.a() && !jf2Var.a()) {
            throw new AssertionError();
        }
        gg2 gg2VarY = Y(jf2Var);
        if (gg2VarY == null) {
            return false;
        }
        if (!f5704a.compareAndSet(this, jf2Var, new zf2(gg2VarY, false, th))) {
            return false;
        }
        k0(gg2VarY, th);
        return true;
    }
}
