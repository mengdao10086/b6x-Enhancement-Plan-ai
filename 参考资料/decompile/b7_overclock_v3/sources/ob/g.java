package ob;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.common.base.Function;
import g.p0;
import hb.a0;
import hb.d0;
import hb.z;
import hd.c0;
import hd.t;
import hd.u0;
import hd.w;
import hd.y;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import ob.a;

/* JADX INFO: loaded from: classes3.dex */
public class g implements hb.k {
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 16;
    public static final String Q = "FragmentedMp4Extractor";
    public static final int R = 1936025959;
    public static final int U = 100;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 3;
    public static final int Z = 4;
    public long A;
    public long B;

    @p0
    public c C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public hb.m H;
    public d0[] I;
    public d0[] J;
    public boolean K;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final o f43151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Format> f43152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SparseArray<c> f43153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f43154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f43155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f43156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f43157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f43158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public final hd.p0 f43159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final wb.b f43160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f43161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayDeque<a.C0485a> f43162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayDeque<b> f43163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public final d0 f43164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f43165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f43166t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f43167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f43168v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public c0 f43169w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f43170x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f43171y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f43172z;
    public static final hb.q L = new hb.q() { // from class: ob.f
        @Override // hb.q
        public final hb.k[] a() {
            return g.m();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };
    public static final byte[] S = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final Format T = new Format.b().e0(w.f31219x0).E();

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f43173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43174b;

        public b(long j10, int i10) {
            this.f43173a = j10;
            this.f43174b = i10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f43175m = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f43176a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r f43179d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ob.c f43180e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f43181f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f43182g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f43183h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f43184i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f43187l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f43177b = new q();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f43178c = new c0();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final c0 f43185j = new c0(1);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final c0 f43186k = new c0();

        public c(d0 d0Var, r rVar, ob.c cVar) {
            this.f43176a = d0Var;
            this.f43179d = rVar;
            this.f43180e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i10 = !this.f43187l ? this.f43179d.f43317g[this.f43181f] : this.f43177b.f43303l[this.f43181f] ? 1 : 0;
            return g() != null ? i10 | 1073741824 : i10;
        }

        public long d() {
            return !this.f43187l ? this.f43179d.f43313c[this.f43181f] : this.f43177b.f43298g[this.f43183h];
        }

        public long e() {
            return !this.f43187l ? this.f43179d.f43316f[this.f43181f] : this.f43177b.c(this.f43181f);
        }

        public int f() {
            return !this.f43187l ? this.f43179d.f43314d[this.f43181f] : this.f43177b.f43300i[this.f43181f];
        }

        @p0
        public p g() {
            if (!this.f43187l) {
                return null;
            }
            int i10 = ((ob.c) u0.k(this.f43177b.f43292a)).f43137a;
            p pVarB = this.f43177b.f43306o;
            if (pVarB == null) {
                pVarB = this.f43179d.f43311a.b(i10);
            }
            if (pVarB == null || !pVarB.f43287a) {
                return null;
            }
            return pVarB;
        }

        public boolean h() {
            this.f43181f++;
            if (!this.f43187l) {
                return false;
            }
            int i10 = this.f43182g + 1;
            this.f43182g = i10;
            int[] iArr = this.f43177b.f43299h;
            int i11 = this.f43183h;
            if (i10 != iArr[i11]) {
                return true;
            }
            this.f43183h = i11 + 1;
            this.f43182g = 0;
            return false;
        }

        public int i(int i10, int i11) {
            c0 c0Var;
            p pVarG = g();
            if (pVarG == null) {
                return 0;
            }
            int length = pVarG.f43290d;
            if (length != 0) {
                c0Var = this.f43177b.f43307p;
            } else {
                byte[] bArr = (byte[]) u0.k(pVarG.f43291e);
                this.f43186k.Q(bArr, bArr.length);
                c0 c0Var2 = this.f43186k;
                length = bArr.length;
                c0Var = c0Var2;
            }
            boolean zG = this.f43177b.g(this.f43181f);
            boolean z10 = zG || i11 != 0;
            this.f43185j.d()[0] = (byte) ((z10 ? 128 : 0) | length);
            this.f43185j.S(0);
            this.f43176a.c(this.f43185j, 1, 1);
            this.f43176a.c(c0Var, length, 1);
            if (!z10) {
                return length + 1;
            }
            if (!zG) {
                this.f43178c.O(8);
                byte[] bArrD = this.f43178c.d();
                bArrD[0] = 0;
                bArrD[1] = 1;
                bArrD[2] = (byte) ((i11 >> 8) & 255);
                bArrD[3] = (byte) (i11 & 255);
                bArrD[4] = (byte) ((i10 >> 24) & 255);
                bArrD[5] = (byte) ((i10 >> 16) & 255);
                bArrD[6] = (byte) ((i10 >> 8) & 255);
                bArrD[7] = (byte) (i10 & 255);
                this.f43176a.c(this.f43178c, 8, 1);
                return length + 1 + 8;
            }
            c0 c0Var3 = this.f43177b.f43307p;
            int iM = c0Var3.M();
            c0Var3.T(-2);
            int i12 = (iM * 6) + 2;
            if (i11 != 0) {
                this.f43178c.O(i12);
                byte[] bArrD2 = this.f43178c.d();
                c0Var3.k(bArrD2, 0, i12);
                int i13 = (((bArrD2[2] & 255) << 8) | (bArrD2[3] & 255)) + i11;
                bArrD2[2] = (byte) ((i13 >> 8) & 255);
                bArrD2[3] = (byte) (i13 & 255);
                c0Var3 = this.f43178c;
            }
            this.f43176a.c(c0Var3, i12, 1);
            return length + 1 + i12;
        }

        public void j(r rVar, ob.c cVar) {
            this.f43179d = rVar;
            this.f43180e = cVar;
            this.f43176a.f(rVar.f43311a.f43280f);
            k();
        }

        public void k() {
            this.f43177b.f();
            this.f43181f = 0;
            this.f43183h = 0;
            this.f43182g = 0;
            this.f43184i = 0;
            this.f43187l = false;
        }

        public void l(long j10) {
            int i10 = this.f43181f;
            while (true) {
                q qVar = this.f43177b;
                if (i10 >= qVar.f43297f || qVar.c(i10) >= j10) {
                    return;
                }
                if (this.f43177b.f43303l[i10]) {
                    this.f43184i = i10;
                }
                i10++;
            }
        }

        public void m() {
            p pVarG = g();
            if (pVarG == null) {
                return;
            }
            c0 c0Var = this.f43177b.f43307p;
            int i10 = pVarG.f43290d;
            if (i10 != 0) {
                c0Var.T(i10);
            }
            if (this.f43177b.g(this.f43181f)) {
                c0Var.T(c0Var.M() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            p pVarB = this.f43179d.f43311a.b(((ob.c) u0.k(this.f43177b.f43292a)).f43137a);
            this.f43176a.f(this.f43179d.f43311a.f43280f.a().L(drmInitData.e(pVarB != null ? pVarB.f43288b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    public static void A(c0 c0Var, q qVar) throws ParserException {
        z(c0Var, 0, qVar);
    }

    public static Pair<Long, hb.e> B(c0 c0Var, long j10) throws ParserException {
        long jL;
        long jL2;
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        c0Var.T(4);
        long jI = c0Var.I();
        if (iC == 0) {
            jL = c0Var.I();
            jL2 = c0Var.I();
        } else {
            jL = c0Var.L();
            jL2 = c0Var.L();
        }
        long j11 = jL;
        long j12 = j10 + jL2;
        long jH1 = u0.h1(j11, 1000000L, jI);
        c0Var.T(2);
        int iM = c0Var.M();
        int[] iArr = new int[iM];
        long[] jArr = new long[iM];
        long[] jArr2 = new long[iM];
        long[] jArr3 = new long[iM];
        long j13 = j11;
        long j14 = jH1;
        int i10 = 0;
        while (i10 < iM) {
            int iO = c0Var.o();
            if ((iO & Integer.MIN_VALUE) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long jI2 = c0Var.I();
            iArr[i10] = iO & Integer.MAX_VALUE;
            jArr[i10] = j12;
            jArr3[i10] = j14;
            long j15 = j13 + jI2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i11 = iM;
            int[] iArr2 = iArr;
            long jH12 = u0.h1(j15, 1000000L, jI);
            jArr4[i10] = jH12 - jArr5[i10];
            c0Var.T(4);
            j12 += (long) iArr2[i10];
            i10++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iM = i11;
            j13 = j15;
            j14 = jH12;
        }
        return Pair.create(Long.valueOf(jH1), new hb.e(iArr, jArr, jArr2, jArr3));
    }

    public static long C(c0 c0Var) {
        c0Var.S(8);
        return ob.a.c(c0Var.o()) == 1 ? c0Var.L() : c0Var.I();
    }

    @p0
    public static c D(c0 c0Var, SparseArray<c> sparseArray) {
        c0Var.S(8);
        int iB = ob.a.b(c0Var.o());
        c cVarK = k(sparseArray, c0Var.o());
        if (cVarK == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jL = c0Var.L();
            q qVar = cVarK.f43177b;
            qVar.f43294c = jL;
            qVar.f43295d = jL;
        }
        ob.c cVar = cVarK.f43180e;
        cVarK.f43177b.f43292a = new ob.c((iB & 2) != 0 ? c0Var.o() - 1 : cVar.f43137a, (iB & 8) != 0 ? c0Var.o() : cVar.f43138b, (iB & 16) != 0 ? c0Var.o() : cVar.f43139c, (iB & 32) != 0 ? c0Var.o() : cVar.f43140d);
        return cVarK;
    }

    public static void E(a.C0485a c0485a, SparseArray<c> sparseArray, int i10, byte[] bArr) throws ParserException {
        c cVarD = D(((a.b) hd.a.g(c0485a.h(ob.a.T))).f43100s1, sparseArray);
        if (cVarD == null) {
            return;
        }
        q qVar = cVarD.f43177b;
        long j10 = qVar.f43309r;
        boolean z10 = qVar.f43310s;
        cVarD.k();
        cVarD.f43187l = true;
        a.b bVarH = c0485a.h(ob.a.S);
        if (bVarH == null || (i10 & 2) != 0) {
            qVar.f43309r = j10;
            qVar.f43310s = z10;
        } else {
            qVar.f43309r = C(bVarH.f43100s1);
            qVar.f43310s = true;
        }
        H(c0485a, cVarD, i10);
        p pVarB = cVarD.f43179d.f43311a.b(((ob.c) hd.a.g(qVar.f43292a)).f43137a);
        a.b bVarH2 = c0485a.h(ob.a.f43091x0);
        if (bVarH2 != null) {
            x((p) hd.a.g(pVarB), bVarH2.f43100s1, qVar);
        }
        a.b bVarH3 = c0485a.h(ob.a.f43093y0);
        if (bVarH3 != null) {
            w(bVarH3.f43100s1, qVar);
        }
        a.b bVarH4 = c0485a.h(ob.a.C0);
        if (bVarH4 != null) {
            A(bVarH4.f43100s1, qVar);
        }
        y(c0485a, pVarB != null ? pVarB.f43288b : null, qVar);
        int size = c0485a.f43098t1.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = c0485a.f43098t1.get(i11);
            if (bVar.f43096a == 1970628964) {
                I(bVar.f43100s1, qVar, bArr);
            }
        }
    }

    public static Pair<Integer, ob.c> F(c0 c0Var) {
        c0Var.S(12);
        return Pair.create(Integer.valueOf(c0Var.o()), new ob.c(c0Var.o() - 1, c0Var.o(), c0Var.o(), c0Var.o()));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int G(ob.g.c r36, int r37, int r38, hd.c0 r39, int r40) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.g.G(ob.g$c, int, int, hd.c0, int):int");
    }

    public static void H(a.C0485a c0485a, c cVar, int i10) throws ParserException {
        List<a.b> list = c0485a.f43098t1;
        int size = list.size();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            a.b bVar = list.get(i13);
            if (bVar.f43096a == 1953658222) {
                c0 c0Var = bVar.f43100s1;
                c0Var.S(12);
                int iK = c0Var.K();
                if (iK > 0) {
                    i12 += iK;
                    i11++;
                }
            }
        }
        cVar.f43183h = 0;
        cVar.f43182g = 0;
        cVar.f43181f = 0;
        cVar.f43177b.e(i11, i12);
        int i14 = 0;
        int iG = 0;
        for (int i15 = 0; i15 < size; i15++) {
            a.b bVar2 = list.get(i15);
            if (bVar2.f43096a == 1953658222) {
                iG = G(cVar, i14, i10, bVar2.f43100s1, iG);
                i14++;
            }
        }
    }

    public static void I(c0 c0Var, q qVar, byte[] bArr) throws ParserException {
        c0Var.S(8);
        c0Var.k(bArr, 0, 16);
        if (Arrays.equals(bArr, S)) {
            z(c0Var, 16, qVar);
        }
    }

    public static boolean O(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1836019558 || i10 == 1953653094 || i10 == 1836475768 || i10 == 1701082227;
    }

    public static boolean P(int i10) {
        return i10 == 1751411826 || i10 == 1835296868 || i10 == 1836476516 || i10 == 1936286840 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1668576371 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1937011571 || i10 == 1952867444 || i10 == 1952868452 || i10 == 1953196132 || i10 == 1953654136 || i10 == 1953658222 || i10 == 1886614376 || i10 == 1935763834 || i10 == 1935763823 || i10 == 1936027235 || i10 == 1970628964 || i10 == 1935828848 || i10 == 1936158820 || i10 == 1701606260 || i10 == 1835362404 || i10 == 1701671783;
    }

    public static int d(int i10) throws ParserException {
        if (i10 >= 0) {
            return i10;
        }
        throw new ParserException("Unexpected negative value: " + i10);
    }

    @p0
    public static DrmInitData h(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            a.b bVar = list.get(i10);
            if (bVar.f43096a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrD = bVar.f43100s1.d();
                UUID uuidF = l.f(bArrD);
                if (uuidF == null) {
                    t.n(Q, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, w.f31182f, bArrD));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @p0
    public static c j(SparseArray<c> sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            c cVarValueAt = sparseArray.valueAt(i10);
            if ((cVarValueAt.f43187l || cVarValueAt.f43181f != cVarValueAt.f43179d.f43312b) && (!cVarValueAt.f43187l || cVarValueAt.f43183h != cVarValueAt.f43177b.f43296e)) {
                long jD = cVarValueAt.d();
                if (jD < j10) {
                    cVar = cVarValueAt;
                    j10 = jD;
                }
            }
        }
        return cVar;
    }

    @p0
    public static c k(SparseArray<c> sparseArray, int i10) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i10);
    }

    public static /* synthetic */ hb.k[] m() {
        return new hb.k[]{new g()};
    }

    public static long u(c0 c0Var) {
        c0Var.S(8);
        return ob.a.c(c0Var.o()) == 0 ? c0Var.I() : c0Var.L();
    }

    public static void v(a.C0485a c0485a, SparseArray<c> sparseArray, int i10, byte[] bArr) throws ParserException {
        int size = c0485a.f43099u1.size();
        for (int i11 = 0; i11 < size; i11++) {
            a.C0485a c0485a2 = c0485a.f43099u1.get(i11);
            if (c0485a2.f43096a == 1953653094) {
                E(c0485a2, sparseArray, i10, bArr);
            }
        }
    }

    public static void w(c0 c0Var, q qVar) throws ParserException {
        c0Var.S(8);
        int iO = c0Var.o();
        if ((ob.a.b(iO) & 1) == 1) {
            c0Var.T(8);
        }
        int iK = c0Var.K();
        if (iK == 1) {
            qVar.f43295d += ob.a.c(iO) == 0 ? c0Var.I() : c0Var.L();
        } else {
            throw new ParserException("Unexpected saio entry count: " + iK);
        }
    }

    public static void x(p pVar, c0 c0Var, q qVar) throws ParserException {
        int i10;
        int i11 = pVar.f43290d;
        c0Var.S(8);
        if ((ob.a.b(c0Var.o()) & 1) == 1) {
            c0Var.T(8);
        }
        int iG = c0Var.G();
        int iK = c0Var.K();
        if (iK > qVar.f43297f) {
            throw new ParserException("Saiz sample count " + iK + " is greater than fragment sample count" + qVar.f43297f);
        }
        if (iG == 0) {
            boolean[] zArr = qVar.f43305n;
            i10 = 0;
            for (int i12 = 0; i12 < iK; i12++) {
                int iG2 = c0Var.G();
                i10 += iG2;
                zArr[i12] = iG2 > i11;
            }
        } else {
            i10 = (iG * iK) + 0;
            Arrays.fill(qVar.f43305n, 0, iK, iG > i11);
        }
        Arrays.fill(qVar.f43305n, iK, qVar.f43297f, false);
        if (i10 > 0) {
            qVar.d(i10);
        }
    }

    public static void y(a.C0485a c0485a, @p0 String str, q qVar) throws ParserException {
        byte[] bArr = null;
        c0 c0Var = null;
        c0 c0Var2 = null;
        for (int i10 = 0; i10 < c0485a.f43098t1.size(); i10++) {
            a.b bVar = c0485a.f43098t1.get(i10);
            c0 c0Var3 = bVar.f43100s1;
            int i11 = bVar.f43096a;
            if (i11 == 1935828848) {
                c0Var3.S(12);
                if (c0Var3.o() == 1936025959) {
                    c0Var = c0Var3;
                }
            } else if (i11 == 1936158820) {
                c0Var3.S(12);
                if (c0Var3.o() == 1936025959) {
                    c0Var2 = c0Var3;
                }
            }
        }
        if (c0Var == null || c0Var2 == null) {
            return;
        }
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        c0Var.T(4);
        if (iC == 1) {
            c0Var.T(4);
        }
        if (c0Var.o() != 1) {
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
        c0Var2.S(8);
        int iC2 = ob.a.c(c0Var2.o());
        c0Var2.T(4);
        if (iC2 == 1) {
            if (c0Var2.I() == 0) {
                throw new ParserException("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            c0Var2.T(4);
        }
        if (c0Var2.I() != 1) {
            throw new ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        c0Var2.T(1);
        int iG = c0Var2.G();
        int i12 = (iG & 240) >> 4;
        int i13 = iG & 15;
        boolean z10 = c0Var2.G() == 1;
        if (z10) {
            int iG2 = c0Var2.G();
            byte[] bArr2 = new byte[16];
            c0Var2.k(bArr2, 0, 16);
            if (iG2 == 0) {
                int iG3 = c0Var2.G();
                bArr = new byte[iG3];
                c0Var2.k(bArr, 0, iG3);
            }
            qVar.f43304m = true;
            qVar.f43306o = new p(z10, str, iG2, bArr2, i12, i13, bArr);
        }
    }

    public static void z(c0 c0Var, int i10, q qVar) throws ParserException {
        c0Var.S(i10 + 8);
        int iB = ob.a.b(c0Var.o());
        if ((iB & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (iB & 2) != 0;
        int iK = c0Var.K();
        if (iK == 0) {
            Arrays.fill(qVar.f43305n, 0, qVar.f43297f, false);
            return;
        }
        if (iK == qVar.f43297f) {
            Arrays.fill(qVar.f43305n, 0, iK, z10);
            qVar.d(c0Var.a());
            qVar.b(c0Var);
        } else {
            throw new ParserException("Senc sample count " + iK + " is different from fragment sample count" + qVar.f43297f);
        }
    }

    public final void J(long j10) throws ParserException {
        while (!this.f43162p.isEmpty() && this.f43162p.peek().f43097s1 == j10) {
            o(this.f43162p.pop());
        }
        e();
    }

    public final boolean K(hb.l lVar) throws IOException {
        if (this.f43168v == 0) {
            if (!lVar.e(this.f43161o.d(), 0, 8, true)) {
                return false;
            }
            this.f43168v = 8;
            this.f43161o.S(0);
            this.f43167u = this.f43161o.I();
            this.f43166t = this.f43161o.o();
        }
        long j10 = this.f43167u;
        if (j10 == 1) {
            lVar.readFully(this.f43161o.d(), 8, 8);
            this.f43168v += 8;
            this.f43167u = this.f43161o.L();
        } else if (j10 == 0) {
            long length = lVar.getLength();
            if (length == -1 && !this.f43162p.isEmpty()) {
                length = this.f43162p.peek().f43097s1;
            }
            if (length != -1) {
                this.f43167u = (length - lVar.getPosition()) + ((long) this.f43168v);
            }
        }
        if (this.f43167u < this.f43168v) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        long position = lVar.getPosition() - ((long) this.f43168v);
        int i10 = this.f43166t;
        if ((i10 == 1836019558 || i10 == 1835295092) && !this.K) {
            this.H.o(new a0.b(this.A, position));
            this.K = true;
        }
        if (this.f43166t == 1836019558) {
            int size = this.f43153g.size();
            for (int i11 = 0; i11 < size; i11++) {
                q qVar = this.f43153g.valueAt(i11).f43177b;
                qVar.f43293b = position;
                qVar.f43295d = position;
                qVar.f43294c = position;
            }
        }
        int i12 = this.f43166t;
        if (i12 == 1835295092) {
            this.C = null;
            this.f43170x = position + this.f43167u;
            this.f43165s = 2;
            return true;
        }
        if (O(i12)) {
            long position2 = (lVar.getPosition() + this.f43167u) - 8;
            this.f43162p.push(new a.C0485a(this.f43166t, position2));
            if (this.f43167u == this.f43168v) {
                J(position2);
            } else {
                e();
            }
        } else if (P(this.f43166t)) {
            if (this.f43168v != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            long j11 = this.f43167u;
            if (j11 > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            c0 c0Var = new c0((int) j11);
            System.arraycopy(this.f43161o.d(), 0, c0Var.d(), 0, 8);
            this.f43169w = c0Var;
            this.f43165s = 1;
        } else {
            if (this.f43167u > 2147483647L) {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f43169w = null;
            this.f43165s = 1;
        }
        return true;
    }

    public final void L(hb.l lVar) throws IOException {
        int i10 = ((int) this.f43167u) - this.f43168v;
        c0 c0Var = this.f43169w;
        if (c0Var != null) {
            lVar.readFully(c0Var.d(), 8, i10);
            q(new a.b(this.f43166t, c0Var), lVar.getPosition());
        } else {
            lVar.o(i10);
        }
        J(lVar.getPosition());
    }

    public final void M(hb.l lVar) throws IOException {
        int size = this.f43153g.size();
        c cVarValueAt = null;
        long j10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            q qVar = this.f43153g.valueAt(i10).f43177b;
            if (qVar.f43308q) {
                long j11 = qVar.f43295d;
                if (j11 < j10) {
                    cVarValueAt = this.f43153g.valueAt(i10);
                    j10 = j11;
                }
            }
        }
        if (cVarValueAt == null) {
            this.f43165s = 3;
            return;
        }
        int position = (int) (j10 - lVar.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        lVar.o(position);
        cVarValueAt.f43177b.a(lVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean N(hb.l lVar) throws IOException {
        int iE;
        c cVarJ = this.C;
        if (cVarJ == null) {
            cVarJ = j(this.f43153g);
            if (cVarJ == null) {
                int position = (int) (this.f43170x - lVar.getPosition());
                if (position < 0) {
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                lVar.o(position);
                e();
                return false;
            }
            int iD = (int) (cVarJ.d() - lVar.getPosition());
            if (iD < 0) {
                t.n(Q, "Ignoring negative offset to sample data.");
                iD = 0;
            }
            lVar.o(iD);
            this.C = cVarJ;
        }
        int i10 = 4;
        int i11 = 1;
        if (this.f43165s == 3) {
            int iF = cVarJ.f();
            this.D = iF;
            if (cVarJ.f43181f < cVarJ.f43184i) {
                lVar.o(iF);
                cVarJ.m();
                if (!cVarJ.h()) {
                    this.C = null;
                }
                this.f43165s = 3;
                return true;
            }
            if (cVarJ.f43179d.f43311a.f43281g == 1) {
                this.D = iF - 8;
                lVar.o(8);
            }
            if (w.M.equals(cVarJ.f43179d.f43311a.f43280f.f16699l)) {
                this.E = cVarJ.i(this.D, 7);
                ab.c.a(this.D, this.f43158l);
                cVarJ.f43176a.d(this.f43158l, 7);
                this.E += 7;
            } else {
                this.E = cVarJ.i(this.D, 0);
            }
            this.D += this.E;
            this.f43165s = 4;
            this.F = 0;
        }
        o oVar = cVarJ.f43179d.f43311a;
        d0 d0Var = cVarJ.f43176a;
        long jE = cVarJ.e();
        hd.p0 p0Var = this.f43159m;
        if (p0Var != null) {
            jE = p0Var.a(jE);
        }
        long j10 = jE;
        if (oVar.f43284j == 0) {
            while (true) {
                int i12 = this.E;
                int i13 = this.D;
                if (i12 >= i13) {
                    break;
                }
                this.E += d0Var.e(lVar, i13 - i12, false);
            }
        } else {
            byte[] bArrD = this.f43155i.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i14 = oVar.f43284j;
            int i15 = i14 + 1;
            int i16 = 4 - i14;
            while (this.E < this.D) {
                int i17 = this.F;
                if (i17 == 0) {
                    lVar.readFully(bArrD, i16, i15);
                    this.f43155i.S(0);
                    int iO = this.f43155i.o();
                    if (iO < i11) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.F = iO - 1;
                    this.f43154h.S(0);
                    d0Var.d(this.f43154h, i10);
                    d0Var.d(this.f43155i, i11);
                    this.G = this.J.length > 0 && y.g(oVar.f43280f.f16699l, bArrD[i10]);
                    this.E += 5;
                    this.D += i16;
                } else {
                    if (this.G) {
                        this.f43156j.O(i17);
                        lVar.readFully(this.f43156j.d(), 0, this.F);
                        d0Var.d(this.f43156j, this.F);
                        iE = this.F;
                        int iK = y.k(this.f43156j.d(), this.f43156j.f());
                        this.f43156j.S(w.f31192k.equals(oVar.f43280f.f16699l) ? 1 : 0);
                        this.f43156j.R(iK);
                        hb.d.a(j10, this.f43156j, this.J);
                    } else {
                        iE = d0Var.e(lVar, i17, false);
                    }
                    this.E += iE;
                    this.F -= iE;
                    i10 = 4;
                    i11 = 1;
                }
            }
        }
        int iC = cVarJ.c();
        p pVarG = cVarJ.g();
        d0Var.a(j10, iC, this.D, 0, pVarG != null ? pVarG.f43289c : null);
        t(j10);
        if (!cVarJ.h()) {
            this.C = null;
        }
        this.f43165s = 3;
        return true;
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        int size = this.f43153g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f43153g.valueAt(i10).k();
        }
        this.f43163q.clear();
        this.f43171y = 0;
        this.f43172z = j11;
        this.f43162p.clear();
        e();
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.H = mVar;
        e();
        l();
        o oVar = this.f43151e;
        if (oVar != null) {
            this.f43153g.put(0, new c(mVar.d(0, oVar.f43276b), new r(this.f43151e, new long[0], new int[0], 0, new long[0], new int[0], 0L), new ob.c(0, 0, 0, 0)));
            this.H.k();
        }
    }

    public final void e() {
        this.f43165s = 0;
        this.f43168v = 0;
    }

    @Override // hb.k
    public int f(hb.l lVar, z zVar) throws IOException {
        while (true) {
            int i10 = this.f43165s;
            if (i10 != 0) {
                if (i10 == 1) {
                    L(lVar);
                } else if (i10 == 2) {
                    M(lVar);
                } else if (N(lVar)) {
                    return 0;
                }
            } else if (!K(lVar)) {
                return -1;
            }
        }
    }

    public final ob.c g(SparseArray<ob.c> sparseArray, int i10) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (ob.c) hd.a.g(sparseArray.get(i10));
    }

    @Override // hb.k
    public boolean i(hb.l lVar) throws IOException {
        return n.b(lVar);
    }

    public final void l() {
        int i10;
        d0[] d0VarArr = new d0[2];
        this.I = d0VarArr;
        d0 d0Var = this.f43164r;
        int i11 = 0;
        if (d0Var != null) {
            d0VarArr[0] = d0Var;
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i12 = 100;
        if ((this.f43150d & 4) != 0) {
            d0VarArr[i10] = this.H.d(100, 5);
            i10++;
            i12 = 101;
        }
        d0[] d0VarArr2 = (d0[]) u0.V0(this.I, i10);
        this.I = d0VarArr2;
        for (d0 d0Var2 : d0VarArr2) {
            d0Var2.f(T);
        }
        this.J = new d0[this.f43152f.size()];
        while (i11 < this.J.length) {
            d0 d0VarD = this.H.d(i12, 3);
            d0VarD.f(this.f43152f.get(i11));
            this.J[i11] = d0VarD;
            i11++;
            i12++;
        }
    }

    @p0
    public o n(@p0 o oVar) {
        return oVar;
    }

    public final void o(a.C0485a c0485a) throws ParserException {
        int i10 = c0485a.f43096a;
        if (i10 == 1836019574) {
            s(c0485a);
        } else if (i10 == 1836019558) {
            r(c0485a);
        } else {
            if (this.f43162p.isEmpty()) {
                return;
            }
            this.f43162p.peek().d(c0485a);
        }
    }

    public final void p(c0 c0Var) {
        long jH1;
        String str;
        long jH12;
        String str2;
        long jI;
        long jA;
        if (this.I.length == 0) {
            return;
        }
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        if (iC == 0) {
            String str3 = (String) hd.a.g(c0Var.A());
            String str4 = (String) hd.a.g(c0Var.A());
            long jI2 = c0Var.I();
            jH1 = u0.h1(c0Var.I(), 1000000L, jI2);
            long j10 = this.B;
            long j11 = j10 != ya.g.f56663b ? j10 + jH1 : -9223372036854775807L;
            str = str3;
            jH12 = u0.h1(c0Var.I(), 1000L, jI2);
            str2 = str4;
            jI = c0Var.I();
            jA = j11;
        } else {
            if (iC != 1) {
                t.n(Q, "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jI3 = c0Var.I();
            jA = u0.h1(c0Var.L(), 1000000L, jI3);
            long jH13 = u0.h1(c0Var.I(), 1000L, jI3);
            long jI4 = c0Var.I();
            str = (String) hd.a.g(c0Var.A());
            jH12 = jH13;
            jI = jI4;
            str2 = (String) hd.a.g(c0Var.A());
            jH1 = -9223372036854775807L;
        }
        byte[] bArr = new byte[c0Var.a()];
        c0Var.k(bArr, 0, c0Var.a());
        c0 c0Var2 = new c0(this.f43160n.a(new EventMessage(str, str2, jH12, jI, bArr)));
        int iA = c0Var2.a();
        for (d0 d0Var : this.I) {
            c0Var2.S(0);
            d0Var.d(c0Var2, iA);
        }
        if (jA == ya.g.f56663b) {
            this.f43163q.addLast(new b(jH1, iA));
            this.f43171y += iA;
            return;
        }
        hd.p0 p0Var = this.f43159m;
        if (p0Var != null) {
            jA = p0Var.a(jA);
        }
        for (d0 d0Var2 : this.I) {
            d0Var2.a(jA, 1, iA, 0, null);
        }
    }

    public final void q(a.b bVar, long j10) throws ParserException {
        if (!this.f43162p.isEmpty()) {
            this.f43162p.peek().e(bVar);
            return;
        }
        int i10 = bVar.f43096a;
        if (i10 != 1936286840) {
            if (i10 == 1701671783) {
                p(bVar.f43100s1);
            }
        } else {
            Pair<Long, hb.e> pairB = B(bVar.f43100s1, j10);
            this.B = ((Long) pairB.first).longValue();
            this.H.o((a0) pairB.second);
            this.K = true;
        }
    }

    public final void r(a.C0485a c0485a) throws ParserException {
        v(c0485a, this.f43153g, this.f43150d, this.f43157k);
        DrmInitData drmInitDataH = h(c0485a.f43098t1);
        if (drmInitDataH != null) {
            int size = this.f43153g.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f43153g.valueAt(i10).n(drmInitDataH);
            }
        }
        if (this.f43172z != ya.g.f56663b) {
            int size2 = this.f43153g.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f43153g.valueAt(i11).l(this.f43172z);
            }
            this.f43172z = ya.g.f56663b;
        }
    }

    @Override // hb.k
    public void release() {
    }

    public final void s(a.C0485a c0485a) throws ParserException {
        int i10 = 0;
        hd.a.j(this.f43151e == null, "Unexpected moov box.");
        DrmInitData drmInitDataH = h(c0485a.f43098t1);
        a.C0485a c0485a2 = (a.C0485a) hd.a.g(c0485a.g(ob.a.f43048h0));
        SparseArray<ob.c> sparseArray = new SparseArray<>();
        int size = c0485a2.f43098t1.size();
        long jU = -9223372036854775807L;
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = c0485a2.f43098t1.get(i11);
            int i12 = bVar.f43096a;
            if (i12 == 1953654136) {
                Pair<Integer, ob.c> pairF = F(bVar.f43100s1);
                sparseArray.put(((Integer) pairF.first).intValue(), (ob.c) pairF.second);
            } else if (i12 == 1835362404) {
                jU = u(bVar.f43100s1);
            }
        }
        List<r> listZ = ob.b.z(c0485a, new hb.w(), jU, drmInitDataH, (this.f43150d & 16) != 0, false, new Function() { // from class: ob.e
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.f43148a.n((o) obj);
            }
        });
        int size2 = listZ.size();
        if (this.f43153g.size() != 0) {
            hd.a.i(this.f43153g.size() == size2);
            while (i10 < size2) {
                r rVar = listZ.get(i10);
                o oVar = rVar.f43311a;
                this.f43153g.get(oVar.f43275a).j(rVar, g(sparseArray, oVar.f43275a));
                i10++;
            }
            return;
        }
        while (i10 < size2) {
            r rVar2 = listZ.get(i10);
            o oVar2 = rVar2.f43311a;
            this.f43153g.put(oVar2.f43275a, new c(this.H.d(i10, oVar2.f43276b), rVar2, g(sparseArray, oVar2.f43275a)));
            this.A = Math.max(this.A, oVar2.f43279e);
            i10++;
        }
        this.H.k();
    }

    public final void t(long j10) {
        while (!this.f43163q.isEmpty()) {
            b bVarRemoveFirst = this.f43163q.removeFirst();
            this.f43171y -= bVarRemoveFirst.f43174b;
            long jA = bVarRemoveFirst.f43173a + j10;
            hd.p0 p0Var = this.f43159m;
            if (p0Var != null) {
                jA = p0Var.a(jA);
            }
            for (d0 d0Var : this.I) {
                d0Var.a(jA, 1, bVarRemoveFirst.f43174b, this.f43171y, null);
            }
        }
    }

    public g(int i10) {
        this(i10, null);
    }

    public g(int i10, @p0 hd.p0 p0Var) {
        this(i10, p0Var, null, Collections.emptyList());
    }

    public g(int i10, @p0 hd.p0 p0Var, @p0 o oVar) {
        this(i10, p0Var, oVar, Collections.emptyList());
    }

    public g(int i10, @p0 hd.p0 p0Var, @p0 o oVar, List<Format> list) {
        this(i10, p0Var, oVar, list, null);
    }

    public g(int i10, @p0 hd.p0 p0Var, @p0 o oVar, List<Format> list, @p0 d0 d0Var) {
        this.f43150d = i10;
        this.f43159m = p0Var;
        this.f43151e = oVar;
        this.f43152f = Collections.unmodifiableList(list);
        this.f43164r = d0Var;
        this.f43160n = new wb.b();
        this.f43161o = new c0(16);
        this.f43154h = new c0(y.f31231b);
        this.f43155i = new c0(5);
        this.f43156j = new c0();
        byte[] bArr = new byte[16];
        this.f43157k = bArr;
        this.f43158l = new c0(bArr);
        this.f43162p = new ArrayDeque<>();
        this.f43163q = new ArrayDeque<>();
        this.f43153g = new SparseArray<>();
        this.A = ya.g.f56663b;
        this.f43172z = ya.g.f56663b;
        this.B = ya.g.f56663b;
        this.H = hb.m.f30892t2;
        this.I = new d0[0];
        this.J = new d0[0];
    }
}
