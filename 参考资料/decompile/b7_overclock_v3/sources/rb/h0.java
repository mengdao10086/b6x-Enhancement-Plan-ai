package rb;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import hb.a0;
import hd.p0;
import hd.u0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements hb.k {
    public static final int A = 188;
    public static final int B = 112800;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 15;
    public static final int F = 17;
    public static final int G = 129;
    public static final int H = 138;
    public static final int I = 130;
    public static final int J = 135;
    public static final int K = 172;
    public static final int L = 2;
    public static final int M = 16;
    public static final int N = 27;
    public static final int O = 36;
    public static final int P = 21;
    public static final int Q = 134;
    public static final int R = 89;
    public static final int S = 257;
    public static final int T = 71;
    public static final int U = 0;
    public static final int V = 8192;
    public static final long W = 1094921523;
    public static final long X = 1161904947;
    public static final long Y = 1094921524;
    public static final long Z = 1212503619;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f48034a0 = 9400;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f48035b0 = 5;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final hb.q f48036w = new hb.q() { // from class: rb.g0
        @Override // hb.q
        public final hb.k[] a() {
            return h0.w();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f48037x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f48038y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f48039z = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f48041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<p0> f48042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hd.c0 f48043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseIntArray f48044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i0.c f48045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseArray<i0> f48046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseBooleanArray f48047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SparseBooleanArray f48048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f0 f48049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e0 f48050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public hb.m f48051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f48052p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f48053q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f48054r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f48055s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i0 f48056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f48057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f48058v;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hd.b0 f48059a = new hd.b0(new byte[4]);

        public b() {
        }

        @Override // rb.b0
        public void b(p0 p0Var, hb.m mVar, i0.e eVar) {
        }

        @Override // rb.b0
        public void c(hd.c0 c0Var) {
            if (c0Var.G() == 0 && (c0Var.G() & 128) != 0) {
                c0Var.T(6);
                int iA = c0Var.a() / 4;
                for (int i10 = 0; i10 < iA; i10++) {
                    c0Var.i(this.f48059a, 4);
                    int iH = this.f48059a.h(16);
                    this.f48059a.s(3);
                    if (iH == 0) {
                        this.f48059a.s(13);
                    } else {
                        int iH2 = this.f48059a.h(13);
                        if (h0.this.f48046j.get(iH2) == null) {
                            h0.this.f48046j.put(iH2, new c0(h0.this.new c(iH2)));
                            h0.k(h0.this);
                        }
                    }
                }
                if (h0.this.f48040d != 2) {
                    h0.this.f48046j.remove(0);
                }
            }
        }
    }

    public class c implements b0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f48061f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f48062g = 10;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f48063h = 106;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f48064i = 111;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f48065j = 122;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f48066k = 123;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f48067l = 127;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f48068m = 89;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f48069n = 21;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hd.b0 f48070a = new hd.b0(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<i0> f48071b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseIntArray f48072c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f48073d;

        public c(int i10) {
            this.f48073d = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final rb.i0.b a(hd.c0 r14, int r15) {
            /*
                Method dump skipped, instruction units count: 209
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: rb.h0.c.a(hd.c0, int):rb.i0$b");
        }

        @Override // rb.b0
        public void b(p0 p0Var, hb.m mVar, i0.e eVar) {
        }

        @Override // rb.b0
        public void c(hd.c0 c0Var) {
            p0 p0Var;
            if (c0Var.G() != 2) {
                return;
            }
            if (h0.this.f48040d == 1 || h0.this.f48040d == 2 || h0.this.f48052p == 1) {
                p0Var = (p0) h0.this.f48042f.get(0);
            } else {
                p0Var = new p0(((p0) h0.this.f48042f.get(0)).c());
                h0.this.f48042f.add(p0Var);
            }
            if ((c0Var.G() & 128) == 0) {
                return;
            }
            c0Var.T(1);
            int iM = c0Var.M();
            int i10 = 3;
            c0Var.T(3);
            c0Var.i(this.f48070a, 2);
            this.f48070a.s(3);
            int i11 = 13;
            h0.this.f48058v = this.f48070a.h(13);
            c0Var.i(this.f48070a, 2);
            int i12 = 4;
            this.f48070a.s(4);
            c0Var.T(this.f48070a.h(12));
            if (h0.this.f48040d == 2 && h0.this.f48056t == null) {
                i0.b bVar = new i0.b(21, null, null, u0.f31159f);
                h0 h0Var = h0.this;
                h0Var.f48056t = h0Var.f48045i.b(21, bVar);
                h0.this.f48056t.b(p0Var, h0.this.f48051o, new i0.e(iM, 21, 8192));
            }
            this.f48071b.clear();
            this.f48072c.clear();
            int iA = c0Var.a();
            while (iA > 0) {
                c0Var.i(this.f48070a, 5);
                int iH = this.f48070a.h(8);
                this.f48070a.s(i10);
                int iH2 = this.f48070a.h(i11);
                this.f48070a.s(i12);
                int iH3 = this.f48070a.h(12);
                i0.b bVarA = a(c0Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarA.f48107a;
                }
                iA -= iH3 + 5;
                int i13 = h0.this.f48040d == 2 ? iH : iH2;
                if (!h0.this.f48047k.get(i13)) {
                    i0 i0VarB = (h0.this.f48040d == 2 && iH == 21) ? h0.this.f48056t : h0.this.f48045i.b(iH, bVarA);
                    if (h0.this.f48040d != 2 || iH2 < this.f48072c.get(i13, 8192)) {
                        this.f48072c.put(i13, iH2);
                        this.f48071b.put(i13, i0VarB);
                    }
                }
                i10 = 3;
                i12 = 4;
                i11 = 13;
            }
            int size = this.f48072c.size();
            for (int i14 = 0; i14 < size; i14++) {
                int iKeyAt = this.f48072c.keyAt(i14);
                int iValueAt = this.f48072c.valueAt(i14);
                h0.this.f48047k.put(iKeyAt, true);
                h0.this.f48048l.put(iValueAt, true);
                i0 i0VarValueAt = this.f48071b.valueAt(i14);
                if (i0VarValueAt != null) {
                    if (i0VarValueAt != h0.this.f48056t) {
                        i0VarValueAt.b(p0Var, h0.this.f48051o, new i0.e(iM, iKeyAt, 8192));
                    }
                    h0.this.f48046j.put(iValueAt, i0VarValueAt);
                }
            }
            if (h0.this.f48040d == 2) {
                if (h0.this.f48053q) {
                    return;
                }
                h0.this.f48051o.k();
                h0.this.f48052p = 0;
                h0.this.f48053q = true;
                return;
            }
            h0.this.f48046j.remove(this.f48073d);
            h0 h0Var2 = h0.this;
            h0Var2.f48052p = h0Var2.f48040d == 1 ? 0 : h0.this.f48052p - 1;
            if (h0.this.f48052p == 0) {
                h0.this.f48051o.k();
                h0.this.f48053q = true;
            }
        }
    }

    public h0() {
        this(0);
    }

    public static /* synthetic */ int k(h0 h0Var) {
        int i10 = h0Var.f48052p;
        h0Var.f48052p = i10 + 1;
        return i10;
    }

    public static /* synthetic */ hb.k[] w() {
        return new hb.k[]{new h0()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        e0 e0Var;
        hd.a.i(this.f48040d != 2);
        int size = this.f48042f.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0 p0Var = this.f48042f.get(i10);
            if ((p0Var.e() == ya.g.f56663b) || (p0Var.e() != 0 && p0Var.c() != j11)) {
                p0Var.g(j11);
            }
        }
        if (j11 != 0 && (e0Var = this.f48050n) != null) {
            e0Var.h(j11);
        }
        this.f48043g.O(0);
        this.f48044h.clear();
        for (int i11 = 0; i11 < this.f48046j.size(); i11++) {
            this.f48046j.valueAt(i11).a();
        }
        this.f48057u = 0;
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f48051o = mVar;
    }

    @Override // hb.k
    public int f(hb.l lVar, hb.z zVar) throws IOException {
        long length = lVar.getLength();
        if (this.f48053q) {
            if (((length == -1 || this.f48040d == 2) ? false : true) && !this.f48049m.d()) {
                return this.f48049m.e(lVar, zVar, this.f48058v);
            }
            x(length);
            if (this.f48055s) {
                this.f48055s = false;
                b(0L, 0L);
                if (lVar.getPosition() != 0) {
                    zVar.f30930a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f48050n;
            if (e0Var != null && e0Var.d()) {
                return this.f48050n.c(lVar, zVar);
            }
        }
        if (!u(lVar)) {
            return -1;
        }
        int iV = v();
        int iF = this.f48043g.f();
        if (iV > iF) {
            return 0;
        }
        int iO = this.f48043g.o();
        if ((8388608 & iO) != 0) {
            this.f48043g.S(iV);
            return 0;
        }
        int i10 = ((4194304 & iO) != 0 ? 1 : 0) | 0;
        int i11 = (2096896 & iO) >> 8;
        boolean z10 = (iO & 32) != 0;
        i0 i0Var = (iO & 16) != 0 ? this.f48046j.get(i11) : null;
        if (i0Var == null) {
            this.f48043g.S(iV);
            return 0;
        }
        if (this.f48040d != 2) {
            int i12 = iO & 15;
            int i13 = this.f48044h.get(i11, i12 - 1);
            this.f48044h.put(i11, i12);
            if (i13 == i12) {
                this.f48043g.S(iV);
                return 0;
            }
            if (i12 != ((i13 + 1) & 15)) {
                i0Var.a();
            }
        }
        if (z10) {
            int iG = this.f48043g.G();
            i10 |= (this.f48043g.G() & 64) != 0 ? 2 : 0;
            this.f48043g.T(iG - 1);
        }
        boolean z11 = this.f48053q;
        if (z(i11)) {
            this.f48043g.R(iV);
            i0Var.c(this.f48043g, i10);
            this.f48043g.R(iF);
        }
        if (this.f48040d != 2 && !z11 && this.f48053q && length != -1) {
            this.f48055s = true;
        }
        this.f48043g.S(iV);
        return 0;
    }

    @Override // hb.k
    public boolean i(hb.l lVar) throws IOException {
        boolean z10;
        byte[] bArrD = this.f48043g.d();
        lVar.t(bArrD, 0, e0.f47985g);
        for (int i10 = 0; i10 < 188; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    z10 = true;
                    break;
                }
                if (bArrD[(i11 * 188) + i10] != 71) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                lVar.o(i10);
                return true;
            }
        }
        return false;
    }

    @Override // hb.k
    public void release() {
    }

    public final boolean u(hb.l lVar) throws IOException {
        byte[] bArrD = this.f48043g.d();
        if (9400 - this.f48043g.e() < 188) {
            int iA = this.f48043g.a();
            if (iA > 0) {
                System.arraycopy(bArrD, this.f48043g.e(), bArrD, 0, iA);
            }
            this.f48043g.Q(bArrD, iA);
        }
        while (this.f48043g.a() < 188) {
            int iF = this.f48043g.f();
            int i10 = lVar.read(bArrD, iF, 9400 - iF);
            if (i10 == -1) {
                return false;
            }
            this.f48043g.R(iF + i10);
        }
        return true;
    }

    public final int v() throws ParserException {
        int iE = this.f48043g.e();
        int iF = this.f48043g.f();
        int iA = j0.a(this.f48043g.d(), iE, iF);
        this.f48043g.S(iA);
        int i10 = iA + 188;
        if (i10 > iF) {
            int i11 = this.f48057u + (iA - iE);
            this.f48057u = i11;
            if (this.f48040d == 2 && i11 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.f48057u = 0;
        }
        return i10;
    }

    public final void x(long j10) {
        if (this.f48054r) {
            return;
        }
        this.f48054r = true;
        if (this.f48049m.b() == ya.g.f56663b) {
            this.f48051o.o(new a0.b(this.f48049m.b()));
            return;
        }
        e0 e0Var = new e0(this.f48049m.c(), this.f48049m.b(), j10, this.f48058v, this.f48041e);
        this.f48050n = e0Var;
        this.f48051o.o(e0Var.b());
    }

    public final void y() {
        this.f48047k.clear();
        this.f48046j.clear();
        SparseArray<i0> sparseArrayA = this.f48045i.a();
        int size = sparseArrayA.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f48046j.put(sparseArrayA.keyAt(i10), sparseArrayA.valueAt(i10));
        }
        this.f48046j.put(0, new c0(new b()));
        this.f48056t = null;
    }

    public final boolean z(int i10) {
        return this.f48040d == 2 || this.f48053q || !this.f48048l.get(i10, false);
    }

    public h0(int i10) {
        this(1, i10, B);
    }

    public h0(int i10, int i11, int i12) {
        this(i10, new p0(0L), new j(i11), i12);
    }

    public h0(int i10, p0 p0Var, i0.c cVar) {
        this(i10, p0Var, cVar, B);
    }

    public h0(int i10, p0 p0Var, i0.c cVar, int i11) {
        this.f48045i = (i0.c) hd.a.g(cVar);
        this.f48041e = i11;
        this.f48040d = i10;
        if (i10 != 1 && i10 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f48042f = arrayList;
            arrayList.add(p0Var);
        } else {
            this.f48042f = Collections.singletonList(p0Var);
        }
        this.f48043g = new hd.c0(new byte[f48034a0], 0);
        this.f48047k = new SparseBooleanArray();
        this.f48048l = new SparseBooleanArray();
        this.f48046j = new SparseArray<>();
        this.f48044h = new SparseIntArray();
        this.f48049m = new f0(i11);
        this.f48058v = -1;
        y();
    }
}
