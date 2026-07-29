package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import ed.u;
import ed.z;
import g.p0;
import gc.e;
import gc.j;
import gc.l;
import gc.m;
import gc.n;
import gc.p;
import hb.d0;
import hb.k;
import hc.f;
import hc.g;
import hd.u0;
import hd.w;
import ic.h;
import ic.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f17702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f17704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final d.c f17707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b[] f17708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.android.exoplayer2.trackselection.b f17709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ic.b f17710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public IOException f17712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17713m;

    public static final class a implements a.InterfaceC0184a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f17714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17715b;

        public a(a.InterfaceC0197a interfaceC0197a) {
            this(interfaceC0197a, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0184a
        public com.google.android.exoplayer2.source.dash.a a(u uVar, ic.b bVar, int i10, int[] iArr, com.google.android.exoplayer2.trackselection.b bVar2, int i11, long j10, boolean z10, List<Format> list, @p0 d.c cVar, @p0 z zVar) {
            com.google.android.exoplayer2.upstream.a aVarA = this.f17714a.a();
            if (zVar != null) {
                aVarA.d(zVar);
            }
            return new c(uVar, bVar, i10, iArr, bVar2, i11, aVarA, j10, this.f17715b, z10, list, cVar);
        }

        public a(a.InterfaceC0197a interfaceC0197a, int i10) {
            this.f17714a = interfaceC0197a;
            this.f17715b = i10;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    public static final class C0186c extends gc.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f17721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f17722f;

        public C0186c(b bVar, long j10, long j11, long j12) {
            super(j10, j11);
            this.f17721e = bVar;
            this.f17722f = j12;
        }

        @Override // gc.n
        public long a() {
            e();
            return this.f17721e.k(f());
        }

        @Override // gc.n
        public com.google.android.exoplayer2.upstream.b c() {
            e();
            long jF = f();
            return f.a(this.f17721e.f17717b, this.f17721e.l(jF), this.f17721e.m(jF, this.f17722f) ? 0 : 8);
        }

        @Override // gc.n
        public long d() {
            e();
            return this.f17721e.i(f());
        }
    }

    public c(u uVar, ic.b bVar, int i10, int[] iArr, com.google.android.exoplayer2.trackselection.b bVar2, int i11, com.google.android.exoplayer2.upstream.a aVar, long j10, int i12, boolean z10, List<Format> list, @p0 d.c cVar) {
        this.f17701a = uVar;
        this.f17710j = bVar;
        this.f17702b = iArr;
        this.f17709i = bVar2;
        this.f17703c = i11;
        this.f17704d = aVar;
        this.f17711k = i10;
        this.f17705e = j10;
        this.f17706f = i12;
        this.f17707g = cVar;
        long jG = bVar.g(i10);
        ArrayList<i> arrayListM = m();
        this.f17708h = new b[bVar2.length()];
        for (int i13 = 0; i13 < this.f17708h.length; i13++) {
            this.f17708h[i13] = new b(jG, i11, arrayListM.get(bVar2.c(i13)), z10, list, cVar);
        }
    }

    @Override // gc.i
    public void a() throws IOException {
        IOException iOException = this.f17712l;
        if (iOException != null) {
            throw iOException;
        }
        this.f17701a.a();
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void b(com.google.android.exoplayer2.trackselection.b bVar) {
        this.f17709i = bVar;
    }

    @Override // gc.i
    public long c(long j10, t1 t1Var) {
        for (b bVar : this.f17708h) {
            if (bVar.f17718c != null) {
                long j11 = bVar.j(j10);
                long jK = bVar.k(j11);
                int iH = bVar.h();
                return t1Var.a(j10, jK, (jK >= j10 || (iH != -1 && j11 >= (bVar.f() + ((long) iH)) - 1)) ? jK : bVar.k(j11 + 1));
            }
        }
        return j10;
    }

    @Override // gc.i
    public void d(e eVar) {
        hb.e eVarE;
        if (eVar instanceof l) {
            int iD = this.f17709i.d(((l) eVar).f29166d);
            b bVar = this.f17708h[iD];
            if (bVar.f17718c == null && (eVarE = bVar.f17716a.e()) != null) {
                this.f17708h[iD] = bVar.c(new g(eVarE, bVar.f17717b.f32084e));
            }
        }
        d.c cVar = this.f17707g;
        if (cVar != null) {
            cVar.i(eVar);
        }
    }

    @Override // gc.i
    public boolean e(long j10, e eVar, List<? extends m> list) {
        if (this.f17712l != null) {
            return false;
        }
        return this.f17709i.h(j10, eVar, list);
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void g(ic.b bVar, int i10) {
        try {
            this.f17710j = bVar;
            this.f17711k = i10;
            long jG = bVar.g(i10);
            ArrayList<i> arrayListM = m();
            for (int i11 = 0; i11 < this.f17708h.length; i11++) {
                i iVar = arrayListM.get(this.f17709i.c(i11));
                b[] bVarArr = this.f17708h;
                bVarArr[i11] = bVarArr[i11].b(jG, iVar);
            }
        } catch (BehindLiveWindowException e10) {
            this.f17712l = e10;
        }
    }

    @Override // gc.i
    public boolean h(e eVar, boolean z10, Exception exc, long j10) {
        b bVar;
        int iH;
        if (!z10) {
            return false;
        }
        d.c cVar = this.f17707g;
        if (cVar != null && cVar.j(eVar)) {
            return true;
        }
        if (!this.f17710j.f32035d && (eVar instanceof m) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (iH = (bVar = this.f17708h[this.f17709i.d(eVar.f29166d)]).h()) != -1 && iH != 0) {
            if (((m) eVar).g() > (bVar.f() + ((long) iH)) - 1) {
                this.f17713m = true;
                return true;
            }
        }
        if (j10 == ya.g.f56663b) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.b bVar2 = this.f17709i;
        return bVar2.j(bVar2.d(eVar.f29166d), j10);
    }

    @Override // gc.i
    public int i(long j10, List<? extends m> list) {
        return (this.f17712l != null || this.f17709i.length() < 2) ? list.size() : this.f17709i.n(j10, list);
    }

    @Override // gc.i
    public void j(long j10, long j11, List<? extends m> list, gc.g gVar) {
        int i10;
        int i11;
        n[] nVarArr;
        long j12;
        long j13;
        if (this.f17712l != null) {
            return;
        }
        long j14 = j11 - j10;
        long jC = ya.g.c(this.f17710j.f32032a) + ya.g.c(this.f17710j.d(this.f17711k).f32067b) + j11;
        d.c cVar = this.f17707g;
        if (cVar == null || !cVar.h(jC)) {
            long jC2 = ya.g.c(u0.j0(this.f17705e));
            long jL = l(jC2);
            m mVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f17709i.length();
            n[] nVarArr2 = new n[length];
            int i12 = 0;
            while (i12 < length) {
                b bVar = this.f17708h[i12];
                if (bVar.f17718c == null) {
                    nVarArr2[i12] = n.f29217a;
                    i10 = i12;
                    i11 = length;
                    nVarArr = nVarArr2;
                    j12 = j14;
                    j13 = jC2;
                } else {
                    long jE = bVar.e(jC2);
                    long jG = bVar.g(jC2);
                    i10 = i12;
                    i11 = length;
                    nVarArr = nVarArr2;
                    j12 = j14;
                    j13 = jC2;
                    long jN = n(bVar, mVar, j11, jE, jG);
                    if (jN < jE) {
                        nVarArr[i10] = n.f29217a;
                    } else {
                        nVarArr[i10] = new C0186c(bVar, jN, jG, jL);
                    }
                }
                i12 = i10 + 1;
                jC2 = j13;
                nVarArr2 = nVarArr;
                length = i11;
                j14 = j12;
            }
            long j15 = j14;
            long j16 = jC2;
            this.f17709i.m(j10, j15, k(j16, j10), list, nVarArr2);
            b bVar2 = this.f17708h[this.f17709i.i()];
            gc.f fVar = bVar2.f17716a;
            if (fVar != null) {
                i iVar = bVar2.f17717b;
                h hVarN = fVar.b() == null ? iVar.n() : null;
                h hVarM = bVar2.f17718c == null ? iVar.m() : null;
                if (hVarN != null || hVarM != null) {
                    gVar.f29172a = o(bVar2, this.f17704d, this.f17709i.p(), this.f17709i.q(), this.f17709i.s(), hVarN, hVarM);
                    return;
                }
            }
            long j17 = bVar2.f17719d;
            long j18 = ya.g.f56663b;
            boolean z10 = j17 != ya.g.f56663b;
            if (bVar2.h() == 0) {
                gVar.f29173b = z10;
                return;
            }
            long jE2 = bVar2.e(j16);
            long jG2 = bVar2.g(j16);
            boolean z11 = z10;
            long jN2 = n(bVar2, mVar, j11, jE2, jG2);
            if (jN2 < jE2) {
                this.f17712l = new BehindLiveWindowException();
                return;
            }
            if (jN2 > jG2 || (this.f17713m && jN2 >= jG2)) {
                gVar.f29173b = z11;
                return;
            }
            if (z11 && bVar2.k(jN2) >= j17) {
                gVar.f29173b = true;
                return;
            }
            int iMin = (int) Math.min(this.f17706f, (jG2 - jN2) + 1);
            if (j17 != ya.g.f56663b) {
                while (iMin > 1 && bVar2.k((((long) iMin) + jN2) - 1) >= j17) {
                    iMin--;
                }
            }
            int i13 = iMin;
            if (list.isEmpty()) {
                j18 = j11;
            }
            gVar.f29172a = p(bVar2, this.f17704d, this.f17703c, this.f17709i.p(), this.f17709i.q(), this.f17709i.s(), jN2, i13, j18, jL);
        }
    }

    public final long k(long j10, long j11) {
        if (!this.f17710j.f32035d) {
            return ya.g.f56663b;
        }
        return Math.max(0L, Math.min(l(j10), this.f17708h[0].i(this.f17708h[0].g(j10))) - j11);
    }

    public final long l(long j10) {
        ic.b bVar = this.f17710j;
        long j11 = bVar.f32032a;
        return j11 == ya.g.f56663b ? ya.g.f56663b : j10 - ya.g.c(j11 + bVar.d(this.f17711k).f32067b);
    }

    public final ArrayList<i> m() {
        List<ic.a> list = this.f17710j.d(this.f17711k).f32068c;
        ArrayList<i> arrayList = new ArrayList<>();
        for (int i10 : this.f17702b) {
            arrayList.addAll(list.get(i10).f32028c);
        }
        return arrayList;
    }

    public final long n(b bVar, @p0 m mVar, long j10, long j11, long j12) {
        return mVar != null ? mVar.g() : u0.u(bVar.j(j10), j11, j12);
    }

    public e o(b bVar, com.google.android.exoplayer2.upstream.a aVar, Format format, int i10, Object obj, h hVar, h hVar2) {
        i iVar = bVar.f17717b;
        if (hVar == null || (hVar2 = hVar.a(hVar2, iVar.f32083d)) != null) {
            hVar = hVar2;
        }
        return new l(aVar, f.a(iVar, hVar, 0), format, i10, obj, bVar.f17716a);
    }

    public e p(b bVar, com.google.android.exoplayer2.upstream.a aVar, int i10, Format format, int i11, Object obj, long j10, int i12, long j11, long j12) {
        i iVar = bVar.f17717b;
        long jK = bVar.k(j10);
        h hVarL = bVar.l(j10);
        String str = iVar.f32083d;
        if (bVar.f17716a == null) {
            return new p(aVar, f.a(iVar, hVarL, bVar.m(j10, j12) ? 0 : 8), format, i11, obj, jK, bVar.i(j10), j10, i10, format);
        }
        int i13 = 1;
        int i14 = 1;
        while (i13 < i12) {
            h hVarA = hVarL.a(bVar.l(((long) i13) + j10), str);
            if (hVarA == null) {
                break;
            }
            i14++;
            i13++;
            hVarL = hVarA;
        }
        long j13 = (((long) i14) + j10) - 1;
        long jI = bVar.i(j13);
        long j14 = bVar.f17719d;
        return new j(aVar, f.a(iVar, hVarL, bVar.m(j13, j12) ? 0 : 8), format, i11, obj, jK, jI, j11, (j14 == ya.g.f56663b || j14 > jI) ? -9223372036854775807L : j14, j10, i14, -iVar.f32084e, bVar.f17716a);
    }

    @Override // gc.i
    public void release() {
        for (b bVar : this.f17708h) {
            gc.f fVar = bVar.f17716a;
            if (fVar != null) {
                fVar.release();
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final gc.f f17716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f17717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final hc.e f17718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f17720e;

        public b(long j10, int i10, i iVar, boolean z10, List<Format> list, @p0 d0 d0Var) {
            this(j10, iVar, d(i10, iVar, z10, list, d0Var), 0L, iVar.l());
        }

        @p0
        public static gc.f d(int i10, i iVar, boolean z10, List<Format> list, @p0 d0 d0Var) {
            k gVar;
            String str = iVar.f32082c.f16697k;
            if (w.r(str)) {
                if (!w.f31209s0.equals(str)) {
                    return null;
                }
                gVar = new qb.a(iVar.f32082c);
            } else if (w.q(str)) {
                gVar = new mb.e(1);
            } else {
                gVar = new ob.g(z10 ? 4 : 0, null, null, list, d0Var);
            }
            return new gc.d(gVar, i10, iVar.f32082c);
        }

        @g.j
        public b b(long j10, i iVar) throws BehindLiveWindowException {
            long jF;
            hc.e eVarL = this.f17717b.l();
            hc.e eVarL2 = iVar.l();
            if (eVarL == null) {
                return new b(j10, iVar, this.f17716a, this.f17720e, eVarL);
            }
            if (!eVarL.g()) {
                return new b(j10, iVar, this.f17716a, this.f17720e, eVarL2);
            }
            int i10 = eVarL.i(j10);
            if (i10 == 0) {
                return new b(j10, iVar, this.f17716a, this.f17720e, eVarL2);
            }
            long jH = eVarL.h();
            long jA = eVarL.a(jH);
            long j11 = (((long) i10) + jH) - 1;
            long jA2 = eVarL.a(j11) + eVarL.b(j11, j10);
            long jH2 = eVarL2.h();
            long jA3 = eVarL2.a(jH2);
            long j12 = this.f17720e;
            if (jA2 == jA3) {
                jF = j12 + ((j11 + 1) - jH2);
            } else {
                if (jA2 < jA3) {
                    throw new BehindLiveWindowException();
                }
                jF = jA3 < jA ? j12 - (eVarL2.f(jA, j10) - jH) : (eVarL.f(jA3, j10) - jH2) + j12;
            }
            return new b(j10, iVar, this.f17716a, jF, eVarL2);
        }

        @g.j
        public b c(hc.e eVar) {
            return new b(this.f17719d, this.f17717b, this.f17716a, this.f17720e, eVar);
        }

        public long e(long j10) {
            return this.f17718c.c(this.f17719d, j10) + this.f17720e;
        }

        public long f() {
            return this.f17718c.h() + this.f17720e;
        }

        public long g(long j10) {
            return (e(j10) + ((long) this.f17718c.j(this.f17719d, j10))) - 1;
        }

        public int h() {
            return this.f17718c.i(this.f17719d);
        }

        public long i(long j10) {
            return k(j10) + this.f17718c.b(j10 - this.f17720e, this.f17719d);
        }

        public long j(long j10) {
            return this.f17718c.f(j10, this.f17719d) + this.f17720e;
        }

        public long k(long j10) {
            return this.f17718c.a(j10 - this.f17720e);
        }

        public h l(long j10) {
            return this.f17718c.e(j10 - this.f17720e);
        }

        public boolean m(long j10, long j11) {
            return j11 == ya.g.f56663b || i(j10) <= j11;
        }

        public b(long j10, i iVar, @p0 gc.f fVar, long j11, @p0 hc.e eVar) {
            this.f17719d = j10;
            this.f17717b = iVar;
            this.f17720e = j11;
            this.f17716a = fVar;
            this.f17718c = eVar;
        }
    }
}
