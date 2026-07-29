package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import ed.z;
import g.i1;
import g.p0;
import hd.u0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends c<Void> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f18138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f18139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final x1.c f18140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x1.b f18141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f18142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public i f18143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18146r;

    public static final class a extends ec.i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Object f18147e = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final Object f18148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final Object f18149d;

        public a(x1 x1Var, @p0 Object obj, @p0 Object obj2) {
            super(x1Var);
            this.f18148c = obj;
            this.f18149d = obj2;
        }

        public static a v(v0 v0Var) {
            return new a(new b(v0Var), x1.c.f57238r, f18147e);
        }

        public static a w(x1 x1Var, @p0 Object obj, @p0 Object obj2) {
            return new a(x1Var, obj, obj2);
        }

        @Override // ec.i, ya.x1
        public int b(Object obj) {
            Object obj2;
            x1 x1Var = this.f26836b;
            if (f18147e.equals(obj) && (obj2 = this.f18149d) != null) {
                obj = obj2;
            }
            return x1Var.b(obj);
        }

        @Override // ec.i, ya.x1
        public x1.b g(int i10, x1.b bVar, boolean z10) {
            this.f26836b.g(i10, bVar, z10);
            if (u0.c(bVar.f57233b, this.f18149d) && z10) {
                bVar.f57233b = f18147e;
            }
            return bVar;
        }

        @Override // ec.i, ya.x1
        public Object m(int i10) {
            Object objM = this.f26836b.m(i10);
            return u0.c(objM, this.f18149d) ? f18147e : objM;
        }

        @Override // ec.i, ya.x1
        public x1.c o(int i10, x1.c cVar, long j10) {
            this.f26836b.o(i10, cVar, j10);
            if (u0.c(cVar.f57240a, this.f18148c)) {
                cVar.f57240a = x1.c.f57238r;
            }
            return cVar;
        }

        public a u(x1 x1Var) {
            return new a(x1Var, this.f18148c, this.f18149d);
        }

        public x1 x() {
            return this.f26836b;
        }
    }

    @i1
    public static final class b extends x1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v0 f18150b;

        public b(v0 v0Var) {
            this.f18150b = v0Var;
        }

        @Override // ya.x1
        public int b(Object obj) {
            return obj == a.f18147e ? 0 : -1;
        }

        @Override // ya.x1
        public x1.b g(int i10, x1.b bVar, boolean z10) {
            return bVar.p(z10 ? 0 : null, z10 ? a.f18147e : null, 0, ya.g.f56663b, 0L);
        }

        @Override // ya.x1
        public int i() {
            return 1;
        }

        @Override // ya.x1
        public Object m(int i10) {
            return a.f18147e;
        }

        @Override // ya.x1
        public x1.c o(int i10, x1.c cVar, long j10) {
            cVar.i(x1.c.f57238r, this.f18150b, null, ya.g.f56663b, ya.g.f56663b, ya.g.f56663b, false, true, null, 0L, ya.g.f56663b, 0, 0, 0L);
            cVar.f57251l = true;
            return cVar;
        }

        @Override // ya.x1
        public int q() {
            return 1;
        }
    }

    public j(l lVar, boolean z10) {
        this.f18138j = lVar;
        this.f18139k = z10 && lVar.o();
        this.f18140l = new x1.c();
        this.f18141m = new x1.b();
        x1 x1VarQ = lVar.q();
        if (x1VarQ == null) {
            this.f18142n = a.v(lVar.j());
        } else {
            this.f18142n = a.w(x1VarQ, null, null);
            this.f18146r = true;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        if (this.f18139k) {
            return;
        }
        this.f18144p = true;
        N(null, this.f18138j);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void E() {
        this.f18145q = false;
        this.f18144p = false;
        super.E();
    }

    @Override // com.google.android.exoplayer2.source.l
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public i a(l.a aVar, ed.b bVar, long j10) {
        i iVar = new i(aVar, bVar, j10);
        iVar.y(this.f18138j);
        if (this.f18145q) {
            iVar.d(aVar.a(R(aVar.f26856a)));
        } else {
            this.f18143o = iVar;
            if (!this.f18144p) {
                this.f18144p = true;
                N(null, this.f18138j);
            }
        }
        return iVar;
    }

    public final Object Q(Object obj) {
        return (this.f18142n.f18149d == null || !this.f18142n.f18149d.equals(obj)) ? obj : a.f18147e;
    }

    public final Object R(Object obj) {
        return (this.f18142n.f18149d == null || !obj.equals(a.f18147e)) ? obj : this.f18142n.f18149d;
    }

    @Override // com.google.android.exoplayer2.source.c
    @p0
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public l.a I(Void r12, l.a aVar) {
        return aVar.a(Q(aVar.f26856a));
    }

    public x1 T() {
        return this.f18142n;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(java.lang.Void r13, com.google.android.exoplayer2.source.l r14, ya.x1 r15) {
        /*
            r12 = this;
            boolean r13 = r12.f18145q
            if (r13 == 0) goto L19
            com.google.android.exoplayer2.source.j$a r13 = r12.f18142n
            com.google.android.exoplayer2.source.j$a r13 = r13.u(r15)
            r12.f18142n = r13
            com.google.android.exoplayer2.source.i r13 = r12.f18143o
            if (r13 == 0) goto Lae
            long r13 = r13.h()
            r12.V(r13)
            goto Lae
        L19:
            boolean r13 = r15.r()
            if (r13 == 0) goto L36
            boolean r13 = r12.f18146r
            if (r13 == 0) goto L2a
            com.google.android.exoplayer2.source.j$a r13 = r12.f18142n
            com.google.android.exoplayer2.source.j$a r13 = r13.u(r15)
            goto L32
        L2a:
            java.lang.Object r13 = ya.x1.c.f57238r
            java.lang.Object r14 = com.google.android.exoplayer2.source.j.a.f18147e
            com.google.android.exoplayer2.source.j$a r13 = com.google.android.exoplayer2.source.j.a.w(r15, r13, r14)
        L32:
            r12.f18142n = r13
            goto Lae
        L36:
            ya.x1$c r13 = r12.f18140l
            r14 = 0
            r15.n(r14, r13)
            ya.x1$c r13 = r12.f18140l
            long r0 = r13.c()
            ya.x1$c r13 = r12.f18140l
            java.lang.Object r13 = r13.f57240a
            com.google.android.exoplayer2.source.i r2 = r12.f18143o
            if (r2 == 0) goto L74
            long r2 = r2.o()
            com.google.android.exoplayer2.source.j$a r4 = r12.f18142n
            com.google.android.exoplayer2.source.i r5 = r12.f18143o
            com.google.android.exoplayer2.source.l$a r5 = r5.f18129a
            java.lang.Object r5 = r5.f26856a
            ya.x1$b r6 = r12.f18141m
            r4.h(r5, r6)
            ya.x1$b r4 = r12.f18141m
            long r4 = r4.n()
            long r4 = r4 + r2
            com.google.android.exoplayer2.source.j$a r2 = r12.f18142n
            ya.x1$c r3 = r12.f18140l
            ya.x1$c r14 = r2.n(r14, r3)
            long r2 = r14.c()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L74
            r10 = r4
            goto L75
        L74:
            r10 = r0
        L75:
            ya.x1$c r7 = r12.f18140l
            ya.x1$b r8 = r12.f18141m
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.j(r7, r8, r9, r10)
            java.lang.Object r0 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r1 = r14.longValue()
            boolean r14 = r12.f18146r
            if (r14 == 0) goto L94
            com.google.android.exoplayer2.source.j$a r13 = r12.f18142n
            com.google.android.exoplayer2.source.j$a r13 = r13.u(r15)
            goto L98
        L94:
            com.google.android.exoplayer2.source.j$a r13 = com.google.android.exoplayer2.source.j.a.w(r15, r13, r0)
        L98:
            r12.f18142n = r13
            com.google.android.exoplayer2.source.i r13 = r12.f18143o
            if (r13 == 0) goto Lae
            r12.V(r1)
            com.google.android.exoplayer2.source.l$a r13 = r13.f18129a
            java.lang.Object r14 = r13.f26856a
            java.lang.Object r14 = r12.R(r14)
            com.google.android.exoplayer2.source.l$a r13 = r13.a(r14)
            goto Laf
        Lae:
            r13 = 0
        Laf:
            r14 = 1
            r12.f18146r = r14
            r12.f18145q = r14
            com.google.android.exoplayer2.source.j$a r14 = r12.f18142n
            r12.D(r14)
            if (r13 == 0) goto Lc6
            com.google.android.exoplayer2.source.i r14 = r12.f18143o
            java.lang.Object r14 = hd.a.g(r14)
            com.google.android.exoplayer2.source.i r14 = (com.google.android.exoplayer2.source.i) r14
            r14.d(r13)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.j.L(java.lang.Void, com.google.android.exoplayer2.source.l, ya.x1):void");
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void V(long j10) {
        i iVar = this.f18143o;
        int iB = this.f18142n.b(iVar.f18129a.f26856a);
        if (iB == -1) {
            return;
        }
        long j11 = this.f18142n.f(iB, this.f18141m).f57235d;
        if (j11 != ya.g.f56663b && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        iVar.w(j10);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return this.f18138j.h();
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f18138j.j();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.l
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        ((i) kVar).x();
        if (kVar == this.f18143o) {
            this.f18143o = null;
        }
    }
}
