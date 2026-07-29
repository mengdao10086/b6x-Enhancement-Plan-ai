package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.t;
import ed.z;
import g.b0;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.google.android.exoplayer2.source.c<e> {
    public static final int A = 5;
    public static final v0 B = new v0.c().F(Uri.EMPTY).a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17581v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f17582w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f17583x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f17584y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f17585z = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @b0("this")
    public final List<e> f17586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @b0("this")
    public final Set<C0183d> f17587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    @b0("this")
    public Handler f17588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<e> f17589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IdentityHashMap<k, e> f17590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<Object, e> f17591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<e> f17592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f17593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f17594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f17595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Set<C0183d> f17596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public t f17597u;

    public static final class b extends ya.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f17598e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f17599f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int[] f17600g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f17601h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final x1[] f17602i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Object[] f17603j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final HashMap<Object, Integer> f17604k;

        public b(Collection<e> collection, t tVar, boolean z10) {
            super(z10, tVar);
            int size = collection.size();
            this.f17600g = new int[size];
            this.f17601h = new int[size];
            this.f17602i = new x1[size];
            this.f17603j = new Object[size];
            this.f17604k = new HashMap<>();
            int iQ = 0;
            int i10 = 0;
            int i11 = 0;
            for (e eVar : collection) {
                this.f17602i[i11] = eVar.f17607a.T();
                this.f17601h[i11] = iQ;
                this.f17600g[i11] = i10;
                iQ += this.f17602i[i11].q();
                i10 += this.f17602i[i11].i();
                Object[] objArr = this.f17603j;
                objArr[i11] = eVar.f17608b;
                this.f17604k.put(objArr[i11], Integer.valueOf(i11));
                i11++;
            }
            this.f17598e = iQ;
            this.f17599f = i10;
        }

        @Override // ya.a
        public int A(int i10) {
            return this.f17600g[i10];
        }

        @Override // ya.a
        public int B(int i10) {
            return this.f17601h[i10];
        }

        @Override // ya.a
        public x1 E(int i10) {
            return this.f17602i[i10];
        }

        @Override // ya.x1
        public int i() {
            return this.f17599f;
        }

        @Override // ya.x1
        public int q() {
            return this.f17598e;
        }

        @Override // ya.a
        public int t(Object obj) {
            Integer num = this.f17604k.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // ya.a
        public int u(int i10) {
            return u0.i(this.f17600g, i10 + 1, false, false);
        }

        @Override // ya.a
        public int v(int i10) {
            return u0.i(this.f17601h, i10 + 1, false, false);
        }

        @Override // ya.a
        public Object y(int i10) {
            return this.f17603j[i10];
        }
    }

    public static final class c extends com.google.android.exoplayer2.source.a {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.a
        public void C(@p0 z zVar) {
        }

        @Override // com.google.android.exoplayer2.source.a
        public void E() {
        }

        @Override // com.google.android.exoplayer2.source.l
        public k a(l.a aVar, ed.b bVar, long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.l
        public v0 j() {
            return d.B;
        }

        @Override // com.google.android.exoplayer2.source.l
        public void n() {
        }

        @Override // com.google.android.exoplayer2.source.l
        public void p(k kVar) {
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.d$d, reason: collision with other inner class name */
    public static final class C0183d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f17605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f17606b;

        public C0183d(Handler handler, Runnable runnable) {
            this.f17605a = handler;
            this.f17606b = runnable;
        }

        public void a() {
            this.f17605a.post(this.f17606b);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f17607a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17611e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17612f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<l.a> f17609c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17608b = new Object();

        public e(l lVar, boolean z10) {
            this.f17607a = new j(lVar, z10);
        }

        public void a(int i10, int i11) {
            this.f17610d = i10;
            this.f17611e = i11;
            this.f17612f = false;
            this.f17609c.clear();
        }
    }

    public static final class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final C0183d f17615c;

        public f(int i10, T t10, @p0 C0183d c0183d) {
            this.f17613a = i10;
            this.f17614b = t10;
            this.f17615c = c0183d;
        }
    }

    public d(l... lVarArr) {
        this(false, lVarArr);
    }

    public static Object j0(Object obj) {
        return ya.a.w(obj);
    }

    public static Object m0(Object obj) {
        return ya.a.x(obj);
    }

    public static Object n0(e eVar, Object obj) {
        return ya.a.z(eVar.f17608b, obj);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void A() {
    }

    public final void A0(int i10) {
        e eVarRemove = this.f17589m.remove(i10);
        this.f17591o.remove(eVarRemove.f17608b);
        e0(i10, -1, -eVarRemove.f17607a.T().q());
        eVarRemove.f17612f = true;
        s0(eVarRemove);
    }

    public synchronized void B0(int i10, int i11) {
        D0(i10, i11, null, null);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public synchronized void C(@p0 z zVar) {
        super.C(zVar);
        this.f17588l = new Handler(new Handler.Callback() { // from class: ec.e
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f26821a.r0(message);
            }
        });
        if (this.f17586j.isEmpty()) {
            K0();
        } else {
            this.f17597u = this.f17597u.e(0, this.f17586j.size());
            a0(0, this.f17586j);
            E0();
        }
    }

    public synchronized void C0(int i10, int i11, Handler handler, Runnable runnable) {
        D0(i10, i11, handler, runnable);
    }

    @b0("this")
    public final void D0(int i10, int i11, @p0 Handler handler, @p0 Runnable runnable) {
        hd.a.a((handler == null) == (runnable == null));
        Handler handler2 = this.f17588l;
        u0.f1(this.f17586j, i10, i11);
        if (handler2 != null) {
            handler2.obtainMessage(1, new f(i10, Integer.valueOf(i11), f0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public synchronized void E() {
        super.E();
        this.f17589m.clear();
        this.f17592p.clear();
        this.f17591o.clear();
        this.f17597u = this.f17597u.g();
        Handler handler = this.f17588l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f17588l = null;
        }
        this.f17595s = false;
        this.f17596t.clear();
        h0(this.f17587k);
    }

    public final void E0() {
        F0(null);
    }

    public final void F0(@p0 C0183d c0183d) {
        if (!this.f17595s) {
            o0().obtainMessage(4).sendToTarget();
            this.f17595s = true;
        }
        if (c0183d != null) {
            this.f17596t.add(c0183d);
        }
    }

    @b0("this")
    public final void G0(t tVar, @p0 Handler handler, @p0 Runnable runnable) {
        hd.a.a((handler == null) == (runnable == null));
        Handler handler2 = this.f17588l;
        if (handler2 != null) {
            int iP0 = p0();
            if (tVar.getLength() != iP0) {
                tVar = tVar.g().e(0, iP0);
            }
            handler2.obtainMessage(3, new f(0, tVar, f0(handler, runnable))).sendToTarget();
            return;
        }
        if (tVar.getLength() > 0) {
            tVar = tVar.g();
        }
        this.f17597u = tVar;
        if (runnable == null || handler == null) {
            return;
        }
        handler.post(runnable);
    }

    public synchronized void H0(t tVar) {
        G0(tVar, null, null);
    }

    public synchronized void I0(t tVar, Handler handler, Runnable runnable) {
        G0(tVar, handler, runnable);
    }

    public final void J0(e eVar, x1 x1Var) {
        if (eVar.f17610d + 1 < this.f17589m.size()) {
            int iQ = x1Var.q() - (this.f17589m.get(eVar.f17610d + 1).f17611e - eVar.f17611e);
            if (iQ != 0) {
                e0(eVar.f17610d + 1, 0, iQ);
            }
        }
        E0();
    }

    public final void K0() {
        this.f17595s = false;
        Set<C0183d> set = this.f17596t;
        this.f17596t = new HashSet();
        D(new b(this.f17589m, this.f17597u, this.f17593q));
        o0().obtainMessage(5, set).sendToTarget();
    }

    public synchronized void R(int i10, l lVar) {
        b0(i10, Collections.singletonList(lVar), null, null);
    }

    public synchronized void S(int i10, l lVar, Handler handler, Runnable runnable) {
        b0(i10, Collections.singletonList(lVar), handler, runnable);
    }

    public synchronized void T(l lVar) {
        R(this.f17586j.size(), lVar);
    }

    public synchronized void U(l lVar, Handler handler, Runnable runnable) {
        S(this.f17586j.size(), lVar, handler, runnable);
    }

    public final void V(int i10, e eVar) {
        if (i10 > 0) {
            e eVar2 = this.f17589m.get(i10 - 1);
            eVar.a(i10, eVar2.f17611e + eVar2.f17607a.T().q());
        } else {
            eVar.a(i10, 0);
        }
        e0(i10, 1, eVar.f17607a.T().q());
        this.f17589m.add(i10, eVar);
        this.f17591o.put(eVar.f17608b, eVar);
        N(eVar, eVar.f17607a);
        if (B() && this.f17590n.isEmpty()) {
            this.f17592p.add(eVar);
        } else {
            G(eVar);
        }
    }

    public synchronized void W(int i10, Collection<l> collection) {
        b0(i10, collection, null, null);
    }

    public synchronized void X(int i10, Collection<l> collection, Handler handler, Runnable runnable) {
        b0(i10, collection, handler, runnable);
    }

    public synchronized void Y(Collection<l> collection) {
        b0(this.f17586j.size(), collection, null, null);
    }

    public synchronized void Z(Collection<l> collection, Handler handler, Runnable runnable) {
        b0(this.f17586j.size(), collection, handler, runnable);
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        Object objM0 = m0(aVar.f26856a);
        l.a aVarA = aVar.a(j0(aVar.f26856a));
        e eVar = this.f17591o.get(objM0);
        if (eVar == null) {
            eVar = new e(new c(), this.f17594r);
            eVar.f17612f = true;
            N(eVar, eVar.f17607a);
        }
        i0(eVar);
        eVar.f17609c.add(aVarA);
        i iVarA = eVar.f17607a.a(aVarA, bVar, j10);
        this.f17590n.put(iVarA, eVar);
        g0();
        return iVarA;
    }

    public final void a0(int i10, Collection<e> collection) {
        Iterator<e> it2 = collection.iterator();
        while (it2.hasNext()) {
            V(i10, it2.next());
            i10++;
        }
    }

    @b0("this")
    public final void b0(int i10, Collection<l> collection, @p0 Handler handler, @p0 Runnable runnable) {
        hd.a.a((handler == null) == (runnable == null));
        Handler handler2 = this.f17588l;
        Iterator<l> it2 = collection.iterator();
        while (it2.hasNext()) {
            hd.a.g(it2.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<l> it3 = collection.iterator();
        while (it3.hasNext()) {
            arrayList.add(new e(it3.next(), this.f17594r));
        }
        this.f17586j.addAll(i10, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new f(i10, arrayList, f0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    public synchronized void c0() {
        B0(0, p0());
    }

    public synchronized void d0(Handler handler, Runnable runnable) {
        C0(0, p0(), handler, runnable);
    }

    public final void e0(int i10, int i11, int i12) {
        while (i10 < this.f17589m.size()) {
            e eVar = this.f17589m.get(i10);
            eVar.f17610d += i11;
            eVar.f17611e += i12;
            i10++;
        }
    }

    @p0
    @b0("this")
    public final C0183d f0(@p0 Handler handler, @p0 Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        C0183d c0183d = new C0183d(handler, runnable);
        this.f17587k.add(c0183d);
        return c0183d;
    }

    public final void g0() {
        Iterator<e> it2 = this.f17592p.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            if (next.f17609c.isEmpty()) {
                G(next);
                it2.remove();
            }
        }
    }

    public final synchronized void h0(Set<C0183d> set) {
        Iterator<C0183d> it2 = set.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.f17587k.removeAll(set);
    }

    public final void i0(e eVar) {
        this.f17592p.add(eVar);
        H(eVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return B;
    }

    @Override // com.google.android.exoplayer2.source.c
    @p0
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public l.a I(e eVar, l.a aVar) {
        for (int i10 = 0; i10 < eVar.f17609c.size(); i10++) {
            if (eVar.f17609c.get(i10).f26859d == aVar.f26859d) {
                return aVar.a(n0(eVar, aVar.f26856a));
            }
        }
        return null;
    }

    public synchronized l l0(int i10) {
        return this.f17586j.get(i10).f17607a;
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    public boolean o() {
        return false;
    }

    public final Handler o0() {
        return (Handler) hd.a.g(this.f17588l);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        e eVar = (e) hd.a.g(this.f17590n.remove(kVar));
        eVar.f17607a.p(kVar);
        eVar.f17609c.remove(((i) kVar).f18129a);
        if (!this.f17590n.isEmpty()) {
            g0();
        }
        s0(eVar);
    }

    public synchronized int p0() {
        return this.f17586j.size();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    public synchronized x1 q() {
        return new b(this.f17586j, this.f17597u.getLength() != this.f17586j.size() ? this.f17597u.g().e(0, this.f17586j.size()) : this.f17597u, this.f17593q);
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public int K(e eVar, int i10) {
        return i10 + eVar.f17611e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r0(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            f fVar = (f) u0.k(message.obj);
            this.f17597u = this.f17597u.e(fVar.f17613a, ((Collection) fVar.f17614b).size());
            a0(fVar.f17613a, (Collection) fVar.f17614b);
            F0(fVar.f17615c);
        } else if (i10 == 1) {
            f fVar2 = (f) u0.k(message.obj);
            int i11 = fVar2.f17613a;
            int iIntValue = ((Integer) fVar2.f17614b).intValue();
            if (i11 == 0 && iIntValue == this.f17597u.getLength()) {
                this.f17597u = this.f17597u.g();
            } else {
                this.f17597u = this.f17597u.a(i11, iIntValue);
            }
            for (int i12 = iIntValue - 1; i12 >= i11; i12--) {
                A0(i12);
            }
            F0(fVar2.f17615c);
        } else if (i10 == 2) {
            f fVar3 = (f) u0.k(message.obj);
            t tVar = this.f17597u;
            int i13 = fVar3.f17613a;
            t tVarA = tVar.a(i13, i13 + 1);
            this.f17597u = tVarA;
            this.f17597u = tVarA.e(((Integer) fVar3.f17614b).intValue(), 1);
            v0(fVar3.f17613a, ((Integer) fVar3.f17614b).intValue());
            F0(fVar3.f17615c);
        } else if (i10 == 3) {
            f fVar4 = (f) u0.k(message.obj);
            this.f17597u = (t) fVar4.f17614b;
            F0(fVar4.f17615c);
        } else if (i10 == 4) {
            K0();
        } else {
            if (i10 != 5) {
                throw new IllegalStateException();
            }
            h0((Set) u0.k(message.obj));
        }
        return true;
    }

    public final void s0(e eVar) {
        if (eVar.f17612f && eVar.f17609c.isEmpty()) {
            this.f17592p.remove(eVar);
            O(eVar);
        }
    }

    public synchronized void t0(int i10, int i11) {
        w0(i10, i11, null, null);
    }

    public synchronized void u0(int i10, int i11, Handler handler, Runnable runnable) {
        w0(i10, i11, handler, runnable);
    }

    public final void v0(int i10, int i11) {
        int iMin = Math.min(i10, i11);
        int iMax = Math.max(i10, i11);
        int iQ = this.f17589m.get(iMin).f17611e;
        List<e> list = this.f17589m;
        list.add(i11, list.remove(i10));
        while (iMin <= iMax) {
            e eVar = this.f17589m.get(iMin);
            eVar.f17610d = iMin;
            eVar.f17611e = iQ;
            iQ += eVar.f17607a.T().q();
            iMin++;
        }
    }

    @b0("this")
    public final void w0(int i10, int i11, @p0 Handler handler, @p0 Runnable runnable) {
        hd.a.a((handler == null) == (runnable == null));
        Handler handler2 = this.f17588l;
        List<e> list = this.f17586j;
        list.add(i11, list.remove(i10));
        if (handler2 != null) {
            handler2.obtainMessage(2, new f(i10, Integer.valueOf(i11), f0(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void L(e eVar, l lVar, x1 x1Var) {
        J0(eVar, x1Var);
    }

    public synchronized l y0(int i10) {
        l lVarL0;
        lVarL0 = l0(i10);
        D0(i10, i10 + 1, null, null);
        return lVarL0;
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void z() {
        super.z();
        this.f17592p.clear();
    }

    public synchronized l z0(int i10, Handler handler, Runnable runnable) {
        l lVarL0;
        lVarL0 = l0(i10);
        D0(i10, i10 + 1, handler, runnable);
        return lVarL0;
    }

    public d(boolean z10, l... lVarArr) {
        this(z10, new t.a(0), lVarArr);
    }

    public d(boolean z10, t tVar, l... lVarArr) {
        this(z10, false, tVar, lVarArr);
    }

    public d(boolean z10, boolean z11, t tVar, l... lVarArr) {
        for (l lVar : lVarArr) {
            hd.a.g(lVar);
        }
        this.f17597u = tVar.getLength() > 0 ? tVar.g() : tVar;
        this.f17590n = new IdentityHashMap<>();
        this.f17591o = new HashMap();
        this.f17586j = new ArrayList();
        this.f17589m = new ArrayList();
        this.f17596t = new HashSet();
        this.f17587k = new HashSet();
        this.f17592p = new HashSet();
        this.f17593q = z10;
        this.f17594r = z11;
        Y(Arrays.asList(lVarArr));
    }
}
