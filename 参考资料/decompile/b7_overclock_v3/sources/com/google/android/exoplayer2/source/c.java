package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import ed.z;
import g.p0;
import hd.r0;
import hd.u0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<T, b> f17571g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Handler f17572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public z f17573i;

    public final class a implements m, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @r0
        public final T f17574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m.a f17575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b.a f17576c;

        public a(@r0 T t10) {
            this.f17575b = c.this.x(null);
            this.f17576c = c.this.v(null);
            this.f17574a = t10;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i10, @p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f17576c.i();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void E(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
            if (a(i10, aVar)) {
                this.f17575b.y(jVar, b(kVar), iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void H(int i10, @p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f17576c.k();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void I(int i10, @p0 l.a aVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f17575b.j(b(kVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void J(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f17575b.B(jVar, b(kVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void M(int i10, @p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f17576c.h();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void N(int i10, @p0 l.a aVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f17575b.E(b(kVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void T(int i10, @p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f17576c.m();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void U(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f17575b.s(jVar, b(kVar));
            }
        }

        public final boolean a(int i10, @p0 l.a aVar) {
            l.a aVarI;
            if (aVar != null) {
                aVarI = c.this.I(this.f17574a, aVar);
                if (aVarI == null) {
                    return false;
                }
            } else {
                aVarI = null;
            }
            int iK = c.this.K(this.f17574a, i10);
            m.a aVar2 = this.f17575b;
            if (aVar2.f18151a != iK || !u0.c(aVar2.f18152b, aVarI)) {
                this.f17575b = c.this.w(iK, aVarI, 0L);
            }
            b.a aVar3 = this.f17576c;
            if (aVar3.f17052a == iK && u0.c(aVar3.f17053b, aVarI)) {
                return true;
            }
            this.f17576c = c.this.u(iK, aVarI);
            return true;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void a0(int i10, @p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f17576c.j();
            }
        }

        public final ec.k b(ec.k kVar) {
            long J = c.this.J(this.f17574a, kVar.f26850f);
            long J2 = c.this.J(this.f17574a, kVar.f26851g);
            return (J == kVar.f26850f && J2 == kVar.f26851g) ? kVar : new ec.k(kVar.f26845a, kVar.f26846b, kVar.f26847c, kVar.f26848d, kVar.f26849e, J, J2);
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void q(int i10, @p0 l.a aVar, Exception exc) {
            if (a(i10, aVar)) {
                this.f17576c.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void u(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f17575b.v(jVar, b(kVar));
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f17578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l.b f17579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m f17580c;

        public b(l lVar, l.b bVar, m mVar) {
            this.f17578a = lVar;
            this.f17579b = bVar;
            this.f17580c = mVar;
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @g.i
    public void A() {
        for (b bVar : this.f17571g.values()) {
            bVar.f17578a.r(bVar.f17579b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @g.i
    public void C(@p0 z zVar) {
        this.f17573i = zVar;
        this.f17572h = u0.z();
    }

    @Override // com.google.android.exoplayer2.source.a
    @g.i
    public void E() {
        for (b bVar : this.f17571g.values()) {
            bVar.f17578a.b(bVar.f17579b);
            bVar.f17578a.e(bVar.f17580c);
        }
        this.f17571g.clear();
    }

    public final void G(@r0 T t10) {
        b bVar = (b) hd.a.g(this.f17571g.get(t10));
        bVar.f17578a.f(bVar.f17579b);
    }

    public final void H(@r0 T t10) {
        b bVar = (b) hd.a.g(this.f17571g.get(t10));
        bVar.f17578a.r(bVar.f17579b);
    }

    @p0
    public l.a I(@r0 T t10, l.a aVar) {
        return aVar;
    }

    public long J(@r0 T t10, long j10) {
        return j10;
    }

    public int K(@r0 T t10, int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public abstract void L(@r0 T t10, l lVar, x1 x1Var);

    public final void N(@r0 final T t10, l lVar) {
        hd.a.a(!this.f17571g.containsKey(t10));
        l.b bVar = new l.b() { // from class: ec.b
            @Override // com.google.android.exoplayer2.source.l.b
            public final void b(com.google.android.exoplayer2.source.l lVar2, x1 x1Var) {
                this.f26815a.L(t10, lVar2, x1Var);
            }
        };
        a aVar = new a(t10);
        this.f17571g.put(t10, new b(lVar, bVar, aVar));
        lVar.d((Handler) hd.a.g(this.f17572h), aVar);
        lVar.k((Handler) hd.a.g(this.f17572h), aVar);
        lVar.s(bVar, this.f17573i);
        if (B()) {
            return;
        }
        lVar.f(bVar);
    }

    public final void O(@r0 T t10) {
        b bVar = (b) hd.a.g(this.f17571g.remove(t10));
        bVar.f17578a.b(bVar.f17579b);
        bVar.f17578a.e(bVar.f17580c);
    }

    @Override // com.google.android.exoplayer2.source.l
    @g.i
    public void n() throws IOException {
        Iterator<b> it2 = this.f17571g.values().iterator();
        while (it2.hasNext()) {
            it2.next().f17578a.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @g.i
    public void z() {
        for (b bVar : this.f17571g.values()) {
            bVar.f17578a.f(bVar.f17579b);
        }
    }
}
