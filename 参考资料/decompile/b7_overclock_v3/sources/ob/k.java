package ob;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.common.base.Function;
import g.p0;
import hb.a0;
import hb.b0;
import hb.d0;
import hb.z;
import hd.c0;
import hd.u0;
import hd.w;
import hd.y;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ob.a;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements hb.k, a0 {
    public static final hb.q B = new hb.q() { // from class: ob.j
        @Override // hb.q
        public final hb.k[] a() {
            return k.r();
        }

        @Override // hb.q
        public /* synthetic */ hb.k[] b(Uri uri, Map map) {
            return hb.p.a(this, uri, map);
        }
    };
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 4;
    public static final int F = 0;
    public static final int G = 1;
    public static final int H = 2;
    public static final int I = 3;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final long M = 262144;
    public static final long N = 10485760;

    @p0
    public MotionPhotoMetadata A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f43217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f43218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f43219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f43220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayDeque<a.C0485a> f43221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f43222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Metadata.Entry> f43223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f43224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f43225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f43226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f43227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public c0 f43228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f43229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f43230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f43231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f43232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public hb.m f43233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b[] f43234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long[][] f43235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f43236x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f43237y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f43238z;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f43239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f43240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d0 f43241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f43242d;

        public b(o oVar, r rVar, d0 d0Var) {
            this.f43239a = oVar;
            this.f43240b = rVar;
            this.f43241c = d0Var;
        }
    }

    public k() {
        this(0);
    }

    public static boolean D(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1701082227 || i10 == 1835365473;
    }

    public static boolean E(int i10) {
        return i10 == 1835296868 || i10 == 1836476516 || i10 == 1751411826 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1937011571 || i10 == 1668576371 || i10 == 1701606260 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1953196132 || i10 == 1718909296 || i10 == 1969517665 || i10 == 1801812339 || i10 == 1768715124;
    }

    public static int l(int i10) {
        if (i10 != 1751476579) {
            return i10 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] m(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            jArr[i10] = new long[bVarArr[i10].f43240b.f43312b];
            jArr2[i10] = bVarArr[i10].f43240b.f43316f[0];
        }
        long j10 = 0;
        int i11 = 0;
        while (i11 < bVarArr.length) {
            long j11 = Long.MAX_VALUE;
            int i12 = -1;
            for (int i13 = 0; i13 < bVarArr.length; i13++) {
                if (!zArr[i13] && jArr2[i13] <= j11) {
                    j11 = jArr2[i13];
                    i12 = i13;
                }
            }
            int i14 = iArr[i12];
            jArr[i12][i14] = j10;
            j10 += (long) bVarArr[i12].f43240b.f43314d[i14];
            int i15 = i14 + 1;
            iArr[i12] = i15;
            if (i15 < jArr[i12].length) {
                jArr2[i12] = bVarArr[i12].f43240b.f43316f[i15];
            } else {
                zArr[i12] = true;
                i11++;
            }
        }
        return jArr;
    }

    public static int o(r rVar, long j10) {
        int iA = rVar.a(j10);
        return iA == -1 ? rVar.b(j10) : iA;
    }

    public static /* synthetic */ o q(o oVar) {
        return oVar;
    }

    public static /* synthetic */ hb.k[] r() {
        return new hb.k[]{new k()};
    }

    public static long s(r rVar, long j10, long j11) {
        int iO = o(rVar, j10);
        return iO == -1 ? j11 : Math.min(rVar.f43313c[iO], j11);
    }

    public static int w(c0 c0Var) {
        c0Var.S(8);
        int iL = l(c0Var.o());
        if (iL != 0) {
            return iL;
        }
        c0Var.T(4);
        while (c0Var.a() > 0) {
            int iL2 = l(c0Var.o());
            if (iL2 != 0) {
                return iL2;
            }
        }
        return 0;
    }

    public final boolean A(hb.l lVar, z zVar) throws IOException {
        boolean z10;
        long j10 = this.f43226n - ((long) this.f43227o);
        long position = lVar.getPosition() + j10;
        c0 c0Var = this.f43228p;
        if (c0Var != null) {
            lVar.readFully(c0Var.d(), this.f43227o, (int) j10);
            if (this.f43225m == 1718909296) {
                this.f43238z = w(c0Var);
            } else if (!this.f43221i.isEmpty()) {
                this.f43221i.peek().e(new a.b(this.f43225m, c0Var));
            }
        } else {
            if (j10 >= 262144) {
                zVar.f30930a = lVar.getPosition() + j10;
                z10 = true;
                u(position);
                return (z10 || this.f43224l == 2) ? false : true;
            }
            lVar.o((int) j10);
        }
        z10 = false;
        u(position);
        if (z10) {
        }
    }

    public final int B(hb.l lVar, z zVar) throws IOException {
        long position = lVar.getPosition();
        if (this.f43229q == -1) {
            int iP = p(position);
            this.f43229q = iP;
            if (iP == -1) {
                return -1;
            }
        }
        b bVar = ((b[]) u0.k(this.f43234v))[this.f43229q];
        d0 d0Var = bVar.f43241c;
        int i10 = bVar.f43242d;
        r rVar = bVar.f43240b;
        long j10 = rVar.f43313c[i10];
        int i11 = rVar.f43314d[i10];
        long j11 = (j10 - position) + ((long) this.f43230r);
        if (j11 < 0 || j11 >= 262144) {
            zVar.f30930a = j10;
            return 1;
        }
        if (bVar.f43239a.f43281g == 1) {
            j11 += 8;
            i11 -= 8;
        }
        lVar.o((int) j11);
        o oVar = bVar.f43239a;
        if (oVar.f43284j == 0) {
            if (w.M.equals(oVar.f43280f.f16699l)) {
                if (this.f43231s == 0) {
                    ab.c.a(i11, this.f43219g);
                    d0Var.d(this.f43219g, 7);
                    this.f43231s += 7;
                }
                i11 += 7;
            }
            while (true) {
                int i12 = this.f43231s;
                if (i12 >= i11) {
                    break;
                }
                int iE = d0Var.e(lVar, i11 - i12, false);
                this.f43230r += iE;
                this.f43231s += iE;
                this.f43232t -= iE;
            }
        } else {
            byte[] bArrD = this.f43218f.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i13 = bVar.f43239a.f43284j;
            int i14 = 4 - i13;
            while (this.f43231s < i11) {
                int i15 = this.f43232t;
                if (i15 == 0) {
                    lVar.readFully(bArrD, i14, i13);
                    this.f43230r += i13;
                    this.f43218f.S(0);
                    int iO = this.f43218f.o();
                    if (iO < 0) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.f43232t = iO;
                    this.f43217e.S(0);
                    d0Var.d(this.f43217e, 4);
                    this.f43231s += 4;
                    i11 += i14;
                } else {
                    int iE2 = d0Var.e(lVar, i15, false);
                    this.f43230r += iE2;
                    this.f43231s += iE2;
                    this.f43232t -= iE2;
                }
            }
        }
        r rVar2 = bVar.f43240b;
        d0Var.a(rVar2.f43316f[i10], rVar2.f43317g[i10], i11, 0, null);
        bVar.f43242d++;
        this.f43229q = -1;
        this.f43230r = 0;
        this.f43231s = 0;
        this.f43232t = 0;
        return 0;
    }

    public final int C(hb.l lVar, z zVar) throws IOException {
        int iC = this.f43222j.c(lVar, zVar, this.f43223k);
        if (iC == 1 && zVar.f30930a == 0) {
            n();
        }
        return iC;
    }

    @RequiresNonNull({"tracks"})
    public final void F(long j10) {
        for (b bVar : this.f43234v) {
            r rVar = bVar.f43240b;
            int iA = rVar.a(j10);
            if (iA == -1) {
                iA = rVar.b(j10);
            }
            bVar.f43242d = iA;
        }
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f43221i.clear();
        this.f43227o = 0;
        this.f43229q = -1;
        this.f43230r = 0;
        this.f43231s = 0;
        this.f43232t = 0;
        if (j10 != 0) {
            if (this.f43234v != null) {
                F(j11);
            }
        } else if (this.f43224l != 3) {
            n();
        } else {
            this.f43222j.g();
            this.f43223k.clear();
        }
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f43233u = mVar;
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.k
    public int f(hb.l lVar, z zVar) throws IOException {
        while (true) {
            int i10 = this.f43224l;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        return B(lVar, zVar);
                    }
                    if (i10 == 3) {
                        return C(lVar, zVar);
                    }
                    throw new IllegalStateException();
                }
                if (A(lVar, zVar)) {
                    return 1;
                }
            } else if (!z(lVar)) {
                return -1;
            }
        }
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        long j11;
        long jS;
        long j12;
        long j13;
        int iB;
        if (((b[]) hd.a.g(this.f43234v)).length == 0) {
            return new a0.a(b0.f30804c);
        }
        int i10 = this.f43236x;
        if (i10 != -1) {
            r rVar = this.f43234v[i10].f43240b;
            int iO = o(rVar, j10);
            if (iO == -1) {
                return new a0.a(b0.f30804c);
            }
            long j14 = rVar.f43316f[iO];
            j11 = rVar.f43313c[iO];
            if (j14 >= j10 || iO >= rVar.f43312b - 1 || (iB = rVar.b(j10)) == -1 || iB == iO) {
                j13 = -1;
                j12 = -9223372036854775807L;
            } else {
                j12 = rVar.f43316f[iB];
                j13 = rVar.f43313c[iB];
            }
            jS = j13;
            j10 = j14;
        } else {
            j11 = Long.MAX_VALUE;
            jS = -1;
            j12 = -9223372036854775807L;
        }
        int i11 = 0;
        while (true) {
            b[] bVarArr = this.f43234v;
            if (i11 >= bVarArr.length) {
                break;
            }
            if (i11 != this.f43236x) {
                r rVar2 = bVarArr[i11].f43240b;
                long jS2 = s(rVar2, j10, j11);
                if (j12 != ya.g.f56663b) {
                    jS = s(rVar2, j12, jS);
                }
                j11 = jS2;
            }
            i11++;
        }
        b0 b0Var = new b0(j10, j11);
        return j12 == ya.g.f56663b ? new a0.a(b0Var) : new a0.a(b0Var, new b0(j12, jS));
    }

    @Override // hb.a0
    public long h() {
        return this.f43237y;
    }

    @Override // hb.k
    public boolean i(hb.l lVar) throws IOException {
        return n.e(lVar, (this.f43216d & 2) != 0);
    }

    public final void n() {
        this.f43224l = 0;
        this.f43227o = 0;
    }

    public final int p(long j10) {
        int i10 = -1;
        int i11 = -1;
        long j11 = Long.MAX_VALUE;
        boolean z10 = true;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        for (int i12 = 0; i12 < ((b[]) u0.k(this.f43234v)).length; i12++) {
            b bVar = this.f43234v[i12];
            int i13 = bVar.f43242d;
            r rVar = bVar.f43240b;
            if (i13 != rVar.f43312b) {
                long j14 = rVar.f43313c[i13];
                long j15 = ((long[][]) u0.k(this.f43235w))[i12][i13];
                long j16 = j14 - j10;
                boolean z12 = j16 < 0 || j16 >= 262144;
                if ((!z12 && z11) || (z12 == z11 && j16 < j13)) {
                    z11 = z12;
                    j13 = j16;
                    i11 = i12;
                    j12 = j15;
                }
                if (j15 < j11) {
                    z10 = z12;
                    i10 = i12;
                    j11 = j15;
                }
            }
        }
        return (j11 == Long.MAX_VALUE || !z10 || j12 < j11 + N) ? i11 : i10;
    }

    @Override // hb.k
    public void release() {
    }

    public final void t(hb.l lVar) throws IOException {
        this.f43219g.O(8);
        lVar.t(this.f43219g.d(), 0, 8);
        ob.b.d(this.f43219g);
        lVar.o(this.f43219g.e());
        lVar.n();
    }

    public final void u(long j10) throws ParserException {
        while (!this.f43221i.isEmpty() && this.f43221i.peek().f43097s1 == j10) {
            a.C0485a c0485aPop = this.f43221i.pop();
            if (c0485aPop.f43096a == 1836019574) {
                x(c0485aPop);
                this.f43221i.clear();
                this.f43224l = 2;
            } else if (!this.f43221i.isEmpty()) {
                this.f43221i.peek().d(c0485aPop);
            }
        }
        if (this.f43224l != 2) {
            n();
        }
    }

    public final void v() {
        if (this.f43238z != 2 || (this.f43216d & 2) == 0) {
            return;
        }
        hb.m mVar = (hb.m) hd.a.g(this.f43233u);
        mVar.d(0, 4).f(new Format.b().X(this.A == null ? null : new Metadata(this.A)).E());
        mVar.k();
        mVar.o(new a0.b(ya.g.f56663b));
    }

    public final void x(a.C0485a c0485a) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        ArrayList arrayList;
        List<r> list;
        int i10;
        int i11;
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = this.f43238z == 1;
        hb.w wVar = new hb.w();
        a.b bVarH = c0485a.h(ob.a.V0);
        if (bVarH != null) {
            Pair<Metadata, Metadata> pairA = ob.b.A(bVarH);
            Metadata metadata3 = (Metadata) pairA.first;
            Metadata metadata4 = (Metadata) pairA.second;
            if (metadata3 != null) {
                wVar.c(metadata3);
            }
            metadata = metadata4;
            metadata2 = metadata3;
        } else {
            metadata = null;
            metadata2 = null;
        }
        a.C0485a c0485aG = c0485a.g(1835365473);
        Metadata metadataM = c0485aG != null ? ob.b.m(c0485aG) : null;
        List<r> listZ = ob.b.z(c0485a, wVar, ya.g.f56663b, null, (this.f43216d & 1) != 0, z10, new Function() { // from class: ob.i
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return k.q((o) obj);
            }
        });
        hb.m mVar = (hb.m) hd.a.g(this.f43233u);
        int size = listZ.size();
        int i12 = 0;
        int size2 = -1;
        long j10 = ya.g.f56663b;
        while (i12 < size) {
            r rVar = listZ.get(i12);
            if (rVar.f43312b == 0) {
                list = listZ;
                i10 = size;
                arrayList = arrayList2;
            } else {
                o oVar = rVar.f43311a;
                int i13 = size2;
                arrayList = arrayList2;
                long j11 = oVar.f43279e;
                if (j11 == ya.g.f56663b) {
                    j11 = rVar.f43318h;
                }
                long jMax = Math.max(j10, j11);
                list = listZ;
                i10 = size;
                b bVar = new b(oVar, rVar, mVar.d(i12, oVar.f43276b));
                int i14 = rVar.f43315e + 30;
                Format.b bVarA = oVar.f43280f.a();
                bVarA.W(i14);
                if (oVar.f43276b == 2 && j11 > 0 && (i11 = rVar.f43312b) > 1) {
                    bVarA.P(i11 / (j11 / 1000000.0f));
                }
                h.k(oVar.f43276b, wVar, bVarA);
                int i15 = oVar.f43276b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata;
                metadataArr[1] = this.f43223k.isEmpty() ? null : new Metadata(this.f43223k);
                h.l(i15, metadata2, metadataM, bVarA, metadataArr);
                bVar.f43241c.f(bVarA.E());
                size2 = (oVar.f43276b == 2 && i13 == -1) ? arrayList.size() : i13;
                arrayList.add(bVar);
                j10 = jMax;
            }
            i12++;
            arrayList2 = arrayList;
            listZ = list;
            size = i10;
        }
        this.f43236x = size2;
        this.f43237y = j10;
        b[] bVarArr = (b[]) arrayList2.toArray(new b[0]);
        this.f43234v = bVarArr;
        this.f43235w = m(bVarArr);
        mVar.k();
        mVar.o(this);
    }

    public final void y(long j10) {
        if (this.f43225m == 1836086884) {
            int i10 = this.f43227o;
            this.A = new MotionPhotoMetadata(0L, j10, ya.g.f56663b, j10 + ((long) i10), this.f43226n - ((long) i10));
        }
    }

    public final boolean z(hb.l lVar) throws IOException {
        a.C0485a c0485aPeek;
        if (this.f43227o == 0) {
            if (!lVar.e(this.f43220h.d(), 0, 8, true)) {
                v();
                return false;
            }
            this.f43227o = 8;
            this.f43220h.S(0);
            this.f43226n = this.f43220h.I();
            this.f43225m = this.f43220h.o();
        }
        long j10 = this.f43226n;
        if (j10 == 1) {
            lVar.readFully(this.f43220h.d(), 8, 8);
            this.f43227o += 8;
            this.f43226n = this.f43220h.L();
        } else if (j10 == 0) {
            long length = lVar.getLength();
            if (length == -1 && (c0485aPeek = this.f43221i.peek()) != null) {
                length = c0485aPeek.f43097s1;
            }
            if (length != -1) {
                this.f43226n = (length - lVar.getPosition()) + ((long) this.f43227o);
            }
        }
        if (this.f43226n < this.f43227o) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (D(this.f43225m)) {
            long position = lVar.getPosition();
            long j11 = this.f43226n;
            int i10 = this.f43227o;
            long j12 = (position + j11) - ((long) i10);
            if (j11 != i10 && this.f43225m == 1835365473) {
                t(lVar);
            }
            this.f43221i.push(new a.C0485a(this.f43225m, j12));
            if (this.f43226n == this.f43227o) {
                u(j12);
            } else {
                n();
            }
        } else if (E(this.f43225m)) {
            hd.a.i(this.f43227o == 8);
            hd.a.i(this.f43226n <= 2147483647L);
            c0 c0Var = new c0((int) this.f43226n);
            System.arraycopy(this.f43220h.d(), 0, c0Var.d(), 0, 8);
            this.f43228p = c0Var;
            this.f43224l = 1;
        } else {
            y(lVar.getPosition() - ((long) this.f43227o));
            this.f43228p = null;
            this.f43224l = 1;
        }
        return true;
    }

    public k(int i10) {
        this.f43216d = i10;
        this.f43224l = (i10 & 4) != 0 ? 3 : 0;
        this.f43222j = new m();
        this.f43223k = new ArrayList();
        this.f43220h = new c0(16);
        this.f43221i = new ArrayDeque<>();
        this.f43217e = new c0(y.f31231b);
        this.f43218f = new c0(4);
        this.f43219g = new c0();
        this.f43229q = -1;
    }
}
