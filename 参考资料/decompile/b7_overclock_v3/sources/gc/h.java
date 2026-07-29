package gc;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import ec.d0;
import g.p0;
import gc.i;
import hd.t;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ya.s0;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public class h<T extends i> implements d0, s, Loader.b<e>, Loader.f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f29174x = "ChunkSampleStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f29176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Format[] f29177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f29178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f29179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s.a<h<T>> f29180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m.a f29181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f29182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Loader f29183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f29184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<gc.a> f29185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<gc.a> f29186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r f29187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r[] f29188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f29189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public e f29190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Format f29191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public b<T> f29192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f29193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f29194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f29195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public gc.a f29196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f29197w;

    public final class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<T> f29198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f29199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f29200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f29201d;

        public a(h<T> hVar, r rVar, int i10) {
            this.f29198a = hVar;
            this.f29199b = rVar;
            this.f29200c = i10;
        }

        @Override // ec.d0
        public void a() {
        }

        public final void b() {
            if (this.f29201d) {
                return;
            }
            h.this.f29181g.i(h.this.f29176b[this.f29200c], h.this.f29177c[this.f29200c], 0, null, h.this.f29194t);
            this.f29201d = true;
        }

        public void c() {
            hd.a.i(h.this.f29178d[this.f29200c]);
            h.this.f29178d[this.f29200c] = false;
        }

        @Override // ec.d0
        public boolean d() {
            return !h.this.I() && this.f29199b.K(h.this.f29197w);
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            if (h.this.I()) {
                return -3;
            }
            if (h.this.f29196v != null && h.this.f29196v.i(this.f29200c + 1) <= this.f29199b.C()) {
                return -3;
            }
            b();
            return this.f29199b.S(s0Var, decoderInputBuffer, z10, h.this.f29197w);
        }

        @Override // ec.d0
        public int o(long j10) {
            if (h.this.I()) {
                return 0;
            }
            int iE = this.f29199b.E(j10, h.this.f29197w);
            if (h.this.f29196v != null) {
                iE = Math.min(iE, h.this.f29196v.i(this.f29200c + 1) - this.f29199b.C());
            }
            this.f29199b.e0(iE);
            if (iE > 0) {
                b();
            }
            return iE;
        }
    }

    public interface b<T extends i> {
        void d(h<T> hVar);
    }

    public h(int i10, @p0 int[] iArr, @p0 Format[] formatArr, T t10, s.a<h<T>> aVar, ed.b bVar, long j10, com.google.android.exoplayer2.drm.c cVar, b.a aVar2, com.google.android.exoplayer2.upstream.j jVar, m.a aVar3) {
        this.f29175a = i10;
        int i11 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f29176b = iArr;
        this.f29177c = formatArr == null ? new Format[0] : formatArr;
        this.f29179e = t10;
        this.f29180f = aVar;
        this.f29181g = aVar3;
        this.f29182h = jVar;
        this.f29183i = new Loader("Loader:ChunkSampleStream");
        this.f29184j = new g();
        ArrayList<gc.a> arrayList = new ArrayList<>();
        this.f29185k = arrayList;
        this.f29186l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f29188n = new r[length];
        this.f29178d = new boolean[length];
        int i12 = length + 1;
        int[] iArr2 = new int[i12];
        r[] rVarArr = new r[i12];
        r rVarJ = r.j(bVar, (Looper) hd.a.g(Looper.myLooper()), cVar, aVar2);
        this.f29187m = rVarJ;
        iArr2[0] = i10;
        rVarArr[0] = rVarJ;
        while (i11 < length) {
            r rVarK = r.k(bVar);
            this.f29188n[i11] = rVarK;
            int i13 = i11 + 1;
            rVarArr[i13] = rVarK;
            iArr2[i13] = this.f29176b[i11];
            i11 = i13;
        }
        this.f29189o = new c(iArr2, rVarArr);
        this.f29193s = j10;
        this.f29194t = j10;
    }

    public final void B(int i10) {
        int iMin = Math.min(O(i10, 0), this.f29195u);
        if (iMin > 0) {
            u0.f1(this.f29185k, 0, iMin);
            this.f29195u -= iMin;
        }
    }

    public final void C(int i10) {
        hd.a.i(!this.f29183i.k());
        int size = this.f29185k.size();
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (!G(i10)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        long j10 = F().f29170h;
        gc.a aVarD = D(i10);
        if (this.f29185k.isEmpty()) {
            this.f29193s = this.f29194t;
        }
        this.f29197w = false;
        this.f29181g.D(this.f29175a, aVarD.f29169g, j10);
    }

    public final gc.a D(int i10) {
        gc.a aVar = this.f29185k.get(i10);
        ArrayList<gc.a> arrayList = this.f29185k;
        u0.f1(arrayList, i10, arrayList.size());
        this.f29195u = Math.max(this.f29195u, this.f29185k.size());
        int i11 = 0;
        this.f29187m.u(aVar.i(0));
        while (true) {
            r[] rVarArr = this.f29188n;
            if (i11 >= rVarArr.length) {
                return aVar;
            }
            r rVar = rVarArr[i11];
            i11++;
            rVar.u(aVar.i(i11));
        }
    }

    public T E() {
        return this.f29179e;
    }

    public final gc.a F() {
        return this.f29185k.get(r0.size() - 1);
    }

    public final boolean G(int i10) {
        int iC;
        gc.a aVar = this.f29185k.get(i10);
        if (this.f29187m.C() > aVar.i(0)) {
            return true;
        }
        int i11 = 0;
        do {
            r[] rVarArr = this.f29188n;
            if (i11 >= rVarArr.length) {
                return false;
            }
            iC = rVarArr[i11].C();
            i11++;
        } while (iC <= aVar.i(i11));
        return true;
    }

    public final boolean H(e eVar) {
        return eVar instanceof gc.a;
    }

    public boolean I() {
        return this.f29193s != ya.g.f56663b;
    }

    public final void J() {
        int iO = O(this.f29187m.C(), this.f29195u - 1);
        while (true) {
            int i10 = this.f29195u;
            if (i10 > iO) {
                return;
            }
            this.f29195u = i10 + 1;
            K(i10);
        }
    }

    public final void K(int i10) {
        gc.a aVar = this.f29185k.get(i10);
        Format format = aVar.f29166d;
        if (!format.equals(this.f29191q)) {
            this.f29181g.i(this.f29175a, format, aVar.f29167e, aVar.f29168f, aVar.f29169g);
        }
        this.f29191q = format;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void i(e eVar, long j10, long j11, boolean z10) {
        this.f29190p = null;
        this.f29196v = null;
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, eVar.a());
        this.f29182h.d(eVar.f29163a);
        this.f29181g.r(jVar, eVar.f29165c, this.f29175a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        if (z10) {
            return;
        }
        if (I()) {
            R();
        } else if (H(eVar)) {
            D(this.f29185k.size() - 1);
            if (this.f29185k.isEmpty()) {
                this.f29193s = this.f29194t;
            }
        }
        this.f29180f.i(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void l(e eVar, long j10, long j11) {
        this.f29190p = null;
        this.f29179e.d(eVar);
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, eVar.a());
        this.f29182h.d(eVar.f29163a);
        this.f29181g.u(jVar, eVar.f29165c, this.f29175a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        this.f29180f.i(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public Loader.c t(e eVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c cVarI;
        long jA = eVar.a();
        boolean zH = H(eVar);
        int size = this.f29185k.size() - 1;
        boolean z10 = (jA != 0 && zH && G(size)) ? false : true;
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, jA);
        j.a aVar = new j.a(jVar, new ec.k(eVar.f29165c, this.f29175a, eVar.f29166d, eVar.f29167e, eVar.f29168f, ya.g.d(eVar.f29169g), ya.g.d(eVar.f29170h)), iOException, i10);
        if (!this.f29179e.h(eVar, z10, iOException, z10 ? this.f29182h.e(aVar) : -9223372036854775807L)) {
            cVarI = null;
        } else if (z10) {
            cVarI = Loader.f19041j;
            if (zH) {
                hd.a.i(D(size) == eVar);
                if (this.f29185k.isEmpty()) {
                    this.f29193s = this.f29194t;
                }
            }
        } else {
            t.n(f29174x, "Ignoring attempt to cancel non-cancelable load.");
            cVarI = null;
        }
        if (cVarI == null) {
            long jA2 = this.f29182h.a(aVar);
            cVarI = jA2 != ya.g.f56663b ? Loader.i(false, jA2) : Loader.f19042k;
        }
        boolean z11 = !cVarI.c();
        this.f29181g.w(jVar, eVar.f29165c, this.f29175a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h, iOException, z11);
        if (z11) {
            this.f29190p = null;
            this.f29182h.d(eVar.f29163a);
            this.f29180f.i(this);
        }
        return cVarI;
    }

    public final int O(int i10, int i11) {
        do {
            i11++;
            if (i11 >= this.f29185k.size()) {
                return this.f29185k.size() - 1;
            }
        } while (this.f29185k.get(i11).i(0) <= i10);
        return i11 - 1;
    }

    public void P() {
        Q(null);
    }

    public void Q(@p0 b<T> bVar) {
        this.f29192r = bVar;
        this.f29187m.R();
        for (r rVar : this.f29188n) {
            rVar.R();
        }
        this.f29183i.m(this);
    }

    public final void R() {
        this.f29187m.V();
        for (r rVar : this.f29188n) {
            rVar.V();
        }
    }

    public void S(long j10) {
        boolean Z;
        this.f29194t = j10;
        if (I()) {
            this.f29193s = j10;
            return;
        }
        gc.a aVar = null;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f29185k.size()) {
                break;
            }
            gc.a aVar2 = this.f29185k.get(i11);
            long j11 = aVar2.f29169g;
            if (j11 == j10 && aVar2.f29136k == ya.g.f56663b) {
                aVar = aVar2;
                break;
            } else if (j11 > j10) {
                break;
            } else {
                i11++;
            }
        }
        if (aVar != null) {
            Z = this.f29187m.Y(aVar.i(0));
        } else {
            Z = this.f29187m.Z(j10, j10 < b());
        }
        if (Z) {
            this.f29195u = O(this.f29187m.C(), 0);
            r[] rVarArr = this.f29188n;
            int length = rVarArr.length;
            while (i10 < length) {
                rVarArr[i10].Z(j10, true);
                i10++;
            }
            return;
        }
        this.f29193s = j10;
        this.f29197w = false;
        this.f29185k.clear();
        this.f29195u = 0;
        if (!this.f29183i.k()) {
            this.f29183i.h();
            R();
            return;
        }
        this.f29187m.q();
        r[] rVarArr2 = this.f29188n;
        int length2 = rVarArr2.length;
        while (i10 < length2) {
            rVarArr2[i10].q();
            i10++;
        }
        this.f29183i.g();
    }

    public h<T>.a T(long j10, int i10) {
        for (int i11 = 0; i11 < this.f29188n.length; i11++) {
            if (this.f29176b[i11] == i10) {
                hd.a.i(!this.f29178d[i11]);
                this.f29178d[i11] = true;
                this.f29188n[i11].Z(j10, true);
                return new a(this, this.f29188n[i11], i11);
            }
        }
        throw new IllegalStateException();
    }

    @Override // ec.d0
    public void a() throws IOException {
        this.f29183i.a();
        this.f29187m.M();
        if (this.f29183i.k()) {
            return;
        }
        this.f29179e.a();
    }

    @Override // com.google.android.exoplayer2.source.s
    public long b() {
        if (I()) {
            return this.f29193s;
        }
        if (this.f29197w) {
            return Long.MIN_VALUE;
        }
        return F().f29170h;
    }

    public long c(long j10, t1 t1Var) {
        return this.f29179e.c(j10, t1Var);
    }

    @Override // ec.d0
    public boolean d() {
        return !I() && this.f29187m.K(this.f29197w);
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        List<gc.a> listEmptyList;
        long j11;
        if (this.f29197w || this.f29183i.k() || this.f29183i.j()) {
            return false;
        }
        boolean zI = I();
        if (zI) {
            listEmptyList = Collections.emptyList();
            j11 = this.f29193s;
        } else {
            listEmptyList = this.f29186l;
            j11 = F().f29170h;
        }
        this.f29179e.j(j10, j11, listEmptyList, this.f29184j);
        g gVar = this.f29184j;
        boolean z10 = gVar.f29173b;
        e eVar = gVar.f29172a;
        gVar.a();
        if (z10) {
            this.f29193s = ya.g.f56663b;
            this.f29197w = true;
            return true;
        }
        if (eVar == null) {
            return false;
        }
        this.f29190p = eVar;
        if (H(eVar)) {
            gc.a aVar = (gc.a) eVar;
            if (zI) {
                long j12 = aVar.f29169g;
                long j13 = this.f29193s;
                if (j12 != j13) {
                    this.f29187m.b0(j13);
                    for (r rVar : this.f29188n) {
                        rVar.b0(this.f29193s);
                    }
                }
                this.f29193s = ya.g.f56663b;
            }
            aVar.k(this.f29189o);
            this.f29185k.add(aVar);
        } else if (eVar instanceof l) {
            ((l) eVar).g(this.f29189o);
        }
        this.f29181g.A(new ec.j(eVar.f29163a, eVar.f29164b, this.f29183i.n(eVar, this, this.f29182h.f(eVar.f29165c))), eVar.f29165c, this.f29175a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.s
    public long f() {
        if (this.f29197w) {
            return Long.MIN_VALUE;
        }
        if (I()) {
            return this.f29193s;
        }
        long jMax = this.f29194t;
        gc.a aVarF = F();
        if (!aVarF.h()) {
            if (this.f29185k.size() > 1) {
                aVarF = this.f29185k.get(r2.size() - 2);
            } else {
                aVarF = null;
            }
        }
        if (aVarF != null) {
            jMax = Math.max(jMax, aVarF.f29170h);
        }
        return Math.max(jMax, this.f29187m.z());
    }

    @Override // com.google.android.exoplayer2.source.s
    public void g(long j10) {
        if (this.f29183i.j() || I()) {
            return;
        }
        if (!this.f29183i.k()) {
            int i10 = this.f29179e.i(j10, this.f29186l);
            if (i10 < this.f29185k.size()) {
                C(i10);
                return;
            }
            return;
        }
        e eVar = (e) hd.a.g(this.f29190p);
        if (!(H(eVar) && G(this.f29185k.size() - 1)) && this.f29179e.e(j10, eVar, this.f29186l)) {
            this.f29183i.g();
            if (H(eVar)) {
                this.f29196v = (gc.a) eVar;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void h() {
        this.f29187m.T();
        for (r rVar : this.f29188n) {
            rVar.T();
        }
        this.f29179e.release();
        b<T> bVar = this.f29192r;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f29183i.k();
    }

    @Override // ec.d0
    public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        if (I()) {
            return -3;
        }
        gc.a aVar = this.f29196v;
        if (aVar != null && aVar.i(0) <= this.f29187m.C()) {
            return -3;
        }
        J();
        return this.f29187m.S(s0Var, decoderInputBuffer, z10, this.f29197w);
    }

    @Override // ec.d0
    public int o(long j10) {
        if (I()) {
            return 0;
        }
        int iE = this.f29187m.E(j10, this.f29197w);
        gc.a aVar = this.f29196v;
        if (aVar != null) {
            iE = Math.min(iE, aVar.i(0) - this.f29187m.C());
        }
        this.f29187m.e0(iE);
        J();
        return iE;
    }

    public void u(long j10, boolean z10) {
        if (I()) {
            return;
        }
        int iX = this.f29187m.x();
        this.f29187m.p(j10, z10, true);
        int iX2 = this.f29187m.x();
        if (iX2 > iX) {
            long jY = this.f29187m.y();
            int i10 = 0;
            while (true) {
                r[] rVarArr = this.f29188n;
                if (i10 >= rVarArr.length) {
                    break;
                }
                rVarArr[i10].p(jY, z10, this.f29178d[i10]);
                i10++;
            }
        }
        B(iX2);
    }
}
