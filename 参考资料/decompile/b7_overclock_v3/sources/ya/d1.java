package ya;

import android.os.Handler;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f56604l = "MediaSourceList";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f56608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m.a f56609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b.a f56610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<c, b> f56611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<c> f56612h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.p0
    public ed.z f56615k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.android.exoplayer2.source.t f56613i = new t.a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<com.google.android.exoplayer2.source.k, c> f56606b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, c> f56607c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f56605a = new ArrayList();

    public final class a implements com.google.android.exoplayer2.source.m, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f56616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m.a f56617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b.a f56618c;

        public a(c cVar) {
            this.f56617b = d1.this.f56609e;
            this.f56618c = d1.this.f56610f;
            this.f56616a = cVar;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i10, @g.p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f56618c.i();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void E(int i10, @g.p0 l.a aVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
            if (a(i10, aVar)) {
                this.f56617b.y(jVar, kVar, iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void H(int i10, @g.p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f56618c.k();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void I(int i10, @g.p0 l.a aVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f56617b.j(kVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void J(int i10, @g.p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f56617b.B(jVar, kVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void M(int i10, @g.p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f56618c.h();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void N(int i10, @g.p0 l.a aVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f56617b.E(kVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void T(int i10, @g.p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f56618c.m();
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void U(int i10, @g.p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f56617b.s(jVar, kVar);
            }
        }

        public final boolean a(int i10, @g.p0 l.a aVar) {
            l.a aVarO;
            if (aVar != null) {
                aVarO = d1.o(this.f56616a, aVar);
                if (aVarO == null) {
                    return false;
                }
            } else {
                aVarO = null;
            }
            int iS = d1.s(this.f56616a, i10);
            m.a aVar2 = this.f56617b;
            if (aVar2.f18151a != iS || !hd.u0.c(aVar2.f18152b, aVarO)) {
                this.f56617b = d1.this.f56609e.F(iS, aVarO, 0L);
            }
            b.a aVar3 = this.f56618c;
            if (aVar3.f17052a == iS && hd.u0.c(aVar3.f17053b, aVarO)) {
                return true;
            }
            this.f56618c = d1.this.f56610f.u(iS, aVarO);
            return true;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void a0(int i10, @g.p0 l.a aVar) {
            if (a(i10, aVar)) {
                this.f56618c.j();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void q(int i10, @g.p0 l.a aVar, Exception exc) {
            if (a(i10, aVar)) {
                this.f56618c.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.m
        public void u(int i10, @g.p0 l.a aVar, ec.j jVar, ec.k kVar) {
            if (a(i10, aVar)) {
                this.f56617b.v(jVar, kVar);
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.l f56620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l.b f56621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.m f56622c;

        public b(com.google.android.exoplayer2.source.l lVar, l.b bVar, com.google.android.exoplayer2.source.m mVar) {
            this.f56620a = lVar;
            this.f56621b = bVar;
            this.f56622c = mVar;
        }
    }

    public static final class c implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.j f56623a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f56626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f56627e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<l.a> f56625c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f56624b = new Object();

        public c(com.google.android.exoplayer2.source.l lVar, boolean z10) {
            this.f56623a = new com.google.android.exoplayer2.source.j(lVar, z10);
        }

        @Override // ya.b1
        public Object a() {
            return this.f56624b;
        }

        @Override // ya.b1
        public x1 b() {
            return this.f56623a.T();
        }

        public void c(int i10) {
            this.f56626d = i10;
            this.f56627e = false;
            this.f56625c.clear();
        }
    }

    public interface d {
        void e();
    }

    public d1(d dVar, @g.p0 za.f1 f1Var, Handler handler) {
        this.f56608d = dVar;
        m.a aVar = new m.a();
        this.f56609e = aVar;
        b.a aVar2 = new b.a();
        this.f56610f = aVar2;
        this.f56611g = new HashMap<>();
        this.f56612h = new HashSet();
        if (f1Var != null) {
            aVar.g(handler, f1Var);
            aVar2.g(handler, f1Var);
        }
    }

    public static Object n(Object obj) {
        return ya.a.w(obj);
    }

    @g.p0
    public static l.a o(c cVar, l.a aVar) {
        for (int i10 = 0; i10 < cVar.f56625c.size(); i10++) {
            if (cVar.f56625c.get(i10).f26859d == aVar.f26859d) {
                return aVar.a(q(cVar, aVar.f26856a));
            }
        }
        return null;
    }

    public static Object p(Object obj) {
        return ya.a.x(obj);
    }

    public static Object q(c cVar, Object obj) {
        return ya.a.z(cVar.f56624b, obj);
    }

    public static int s(c cVar, int i10) {
        return i10 + cVar.f56626d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(com.google.android.exoplayer2.source.l lVar, x1 x1Var) {
        this.f56608d.e();
    }

    public void A() {
        for (b bVar : this.f56611g.values()) {
            try {
                bVar.f56620a.b(bVar.f56621b);
            } catch (RuntimeException e10) {
                hd.t.e(f56604l, "Failed to release child source.", e10);
            }
            bVar.f56620a.e(bVar.f56622c);
        }
        this.f56611g.clear();
        this.f56612h.clear();
        this.f56614j = false;
    }

    public void B(com.google.android.exoplayer2.source.k kVar) {
        c cVar = (c) hd.a.g(this.f56606b.remove(kVar));
        cVar.f56623a.p(kVar);
        cVar.f56625c.remove(((com.google.android.exoplayer2.source.i) kVar).f18129a);
        if (!this.f56606b.isEmpty()) {
            l();
        }
        v(cVar);
    }

    public x1 C(int i10, int i11, com.google.android.exoplayer2.source.t tVar) {
        hd.a.a(i10 >= 0 && i10 <= i11 && i11 <= r());
        this.f56613i = tVar;
        D(i10, i11);
        return j();
    }

    public final void D(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            c cVarRemove = this.f56605a.remove(i12);
            this.f56607c.remove(cVarRemove.f56624b);
            h(i12, -cVarRemove.f56623a.T().q());
            cVarRemove.f56627e = true;
            if (this.f56614j) {
                v(cVarRemove);
            }
        }
    }

    public x1 E(List<c> list, com.google.android.exoplayer2.source.t tVar) {
        D(0, this.f56605a.size());
        return f(this.f56605a.size(), list, tVar);
    }

    public x1 F(com.google.android.exoplayer2.source.t tVar) {
        int iR = r();
        if (tVar.getLength() != iR) {
            tVar = tVar.g().e(0, iR);
        }
        this.f56613i = tVar;
        return j();
    }

    public x1 f(int i10, List<c> list, com.google.android.exoplayer2.source.t tVar) {
        if (!list.isEmpty()) {
            this.f56613i = tVar;
            for (int i11 = i10; i11 < list.size() + i10; i11++) {
                c cVar = list.get(i11 - i10);
                if (i11 > 0) {
                    c cVar2 = this.f56605a.get(i11 - 1);
                    cVar.c(cVar2.f56626d + cVar2.f56623a.T().q());
                } else {
                    cVar.c(0);
                }
                h(i11, cVar.f56623a.T().q());
                this.f56605a.add(i11, cVar);
                this.f56607c.put(cVar.f56624b, cVar);
                if (this.f56614j) {
                    z(cVar);
                    if (this.f56606b.isEmpty()) {
                        this.f56612h.add(cVar);
                    } else {
                        k(cVar);
                    }
                }
            }
        }
        return j();
    }

    public x1 g(@g.p0 com.google.android.exoplayer2.source.t tVar) {
        if (tVar == null) {
            tVar = this.f56613i.g();
        }
        this.f56613i = tVar;
        D(0, r());
        return j();
    }

    public final void h(int i10, int i11) {
        while (i10 < this.f56605a.size()) {
            this.f56605a.get(i10).f56626d += i11;
            i10++;
        }
    }

    public com.google.android.exoplayer2.source.k i(l.a aVar, ed.b bVar, long j10) {
        Object objP = p(aVar.f26856a);
        l.a aVarA = aVar.a(n(aVar.f26856a));
        c cVar = (c) hd.a.g(this.f56607c.get(objP));
        m(cVar);
        cVar.f56625c.add(aVarA);
        com.google.android.exoplayer2.source.i iVarA = cVar.f56623a.a(aVarA, bVar, j10);
        this.f56606b.put(iVarA, cVar);
        l();
        return iVarA;
    }

    public x1 j() {
        if (this.f56605a.isEmpty()) {
            return x1.f57231a;
        }
        int iQ = 0;
        for (int i10 = 0; i10 < this.f56605a.size(); i10++) {
            c cVar = this.f56605a.get(i10);
            cVar.f56626d = iQ;
            iQ += cVar.f56623a.T().q();
        }
        return new m1(this.f56605a, this.f56613i);
    }

    public final void k(c cVar) {
        b bVar = this.f56611g.get(cVar);
        if (bVar != null) {
            bVar.f56620a.f(bVar.f56621b);
        }
    }

    public final void l() {
        Iterator<c> it2 = this.f56612h.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            if (next.f56625c.isEmpty()) {
                k(next);
                it2.remove();
            }
        }
    }

    public final void m(c cVar) {
        this.f56612h.add(cVar);
        b bVar = this.f56611g.get(cVar);
        if (bVar != null) {
            bVar.f56620a.r(bVar.f56621b);
        }
    }

    public int r() {
        return this.f56605a.size();
    }

    public boolean t() {
        return this.f56614j;
    }

    public final void v(c cVar) {
        if (cVar.f56627e && cVar.f56625c.isEmpty()) {
            b bVar = (b) hd.a.g(this.f56611g.remove(cVar));
            bVar.f56620a.b(bVar.f56621b);
            bVar.f56620a.e(bVar.f56622c);
            this.f56612h.remove(cVar);
        }
    }

    public x1 w(int i10, int i11, com.google.android.exoplayer2.source.t tVar) {
        return x(i10, i10 + 1, i11, tVar);
    }

    public x1 x(int i10, int i11, int i12, com.google.android.exoplayer2.source.t tVar) {
        hd.a.a(i10 >= 0 && i10 <= i11 && i11 <= r() && i12 >= 0);
        this.f56613i = tVar;
        if (i10 == i11 || i10 == i12) {
            return j();
        }
        int iMin = Math.min(i10, i12);
        int iMax = Math.max(((i11 - i10) + i12) - 1, i11 - 1);
        int iQ = this.f56605a.get(iMin).f56626d;
        hd.u0.Q0(this.f56605a, i10, i11, i12);
        while (iMin <= iMax) {
            c cVar = this.f56605a.get(iMin);
            cVar.f56626d = iQ;
            iQ += cVar.f56623a.T().q();
            iMin++;
        }
        return j();
    }

    public void y(@g.p0 ed.z zVar) {
        hd.a.i(!this.f56614j);
        this.f56615k = zVar;
        for (int i10 = 0; i10 < this.f56605a.size(); i10++) {
            c cVar = this.f56605a.get(i10);
            z(cVar);
            this.f56612h.add(cVar);
        }
        this.f56614j = true;
    }

    public final void z(c cVar) {
        com.google.android.exoplayer2.source.j jVar = cVar.f56623a;
        l.b bVar = new l.b() { // from class: ya.c1
            @Override // com.google.android.exoplayer2.source.l.b
            public final void b(com.google.android.exoplayer2.source.l lVar, x1 x1Var) {
                this.f56581a.u(lVar, x1Var);
            }
        };
        a aVar = new a(cVar);
        this.f56611g.put(cVar, new b(jVar, bVar, aVar));
        jVar.d(hd.u0.B(), aVar);
        jVar.k(hd.u0.B(), aVar);
        jVar.s(bVar, this.f56615k);
    }
}
