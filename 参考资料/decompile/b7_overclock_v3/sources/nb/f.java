package nb;

import ab.x;
import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import g.p0;
import hb.d0;
import hb.k;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.w;
import hb.z;
import hd.c0;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import nb.g;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import zb.b;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements k {
    public static final int A = 4;
    public static final int C = 131072;
    public static final int D = 32768;
    public static final int E = 10;
    public static final int F = -128000;
    public static final int G = 1483304551;
    public static final int H = 1231971951;
    public static final int I = 1447187017;
    public static final int J = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f42029y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f42030z = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f42032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f42033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x.a f42034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f42035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final hb.x f42036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d0 f42037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f42038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d0 f42039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d0 f42040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f42041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Metadata f42042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f42043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f42044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f42045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f42046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g f42047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f42048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f42049v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f42050w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final q f42028x = new q() { // from class: nb.d
        @Override // hb.q
        public final k[] a() {
            return f.o();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };
    public static final b.a B = new b.a() { // from class: nb.e
        @Override // zb.b.a
        public final boolean a(int i10, int i11, int i12, int i13, int i14) {
            return f.p(i10, i11, i12, i13, i14);
        }
    };

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public f() {
        this(0);
    }

    public static long l(@p0 Metadata metadata) {
        if (metadata == null) {
            return ya.g.f56663b;
        }
        int iG = metadata.g();
        for (int i10 = 0; i10 < iG; i10++) {
            Metadata.Entry entryE = metadata.e(i10);
            if (entryE instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entryE;
                if (textInformationFrame.f17304a.equals("TLEN")) {
                    return ya.g.c(Long.parseLong(textInformationFrame.f17319c));
                }
            }
        }
        return ya.g.f56663b;
    }

    public static int m(c0 c0Var, int i10) {
        if (c0Var.f() >= i10 + 4) {
            c0Var.S(i10);
            int iO = c0Var.o();
            if (iO == 1483304551 || iO == 1231971951) {
                return iO;
            }
        }
        if (c0Var.f() < 40) {
            return 0;
        }
        c0Var.S(36);
        if (c0Var.o() == 1447187017) {
            return I;
        }
        return 0;
    }

    public static boolean n(int i10, long j10) {
        return ((long) (i10 & F)) == (j10 & (-128000));
    }

    public static /* synthetic */ k[] o() {
        return new k[]{new f()};
    }

    public static /* synthetic */ boolean p(int i10, int i11, int i12, int i13, int i14) {
        return (i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2)) || (i11 == 77 && i12 == 76 && i13 == 76 && (i14 == 84 || i10 == 2));
    }

    @p0
    public static c q(@p0 Metadata metadata, long j10) {
        if (metadata == null) {
            return null;
        }
        int iG = metadata.g();
        for (int i10 = 0; i10 < iG; i10++) {
            Metadata.Entry entryE = metadata.e(i10);
            if (entryE instanceof MlltFrame) {
                return c.b(j10, (MlltFrame) entryE, l(metadata));
            }
        }
        return null;
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f42041n = 0;
        this.f42043p = ya.g.f56663b;
        this.f42044q = 0L;
        this.f42046s = 0;
        this.f42050w = j11;
        g gVar = this.f42047t;
        if (!(gVar instanceof b) || ((b) gVar).b(j11)) {
            return;
        }
        this.f42049v = true;
        this.f42040m = this.f42037j;
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f42038k = mVar;
        d0 d0VarD = mVar.d(0, 1);
        this.f42039l = d0VarD;
        this.f42040m = d0VarD;
        this.f42038k.k();
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    public final void e() {
        hd.a.k(this.f42039l);
        u0.k(this.f42038k);
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        e();
        int iT = t(lVar);
        if (iT == -1 && (this.f42047t instanceof b)) {
            long jH = h(this.f42044q);
            if (this.f42047t.h() != jH) {
                ((b) this.f42047t).f(jH);
                this.f42038k.o(this.f42047t);
            }
        }
        return iT;
    }

    public final g g(l lVar) throws IOException {
        long jL;
        long j10;
        long jH;
        long jD;
        g gVarR = r(lVar);
        c cVarQ = q(this.f42042o, lVar.getPosition());
        if (this.f42048u) {
            return new g.a();
        }
        if ((this.f42031d & 2) != 0) {
            if (cVarQ != null) {
                jH = cVarQ.h();
                jD = cVarQ.d();
            } else if (gVarR != null) {
                jH = gVarR.h();
                jD = gVarR.d();
            } else {
                jL = l(this.f42042o);
                j10 = -1;
                gVarR = new b(jL, lVar.getPosition(), j10);
            }
            j10 = jD;
            jL = jH;
            gVarR = new b(jL, lVar.getPosition(), j10);
        } else if (cVarQ != null) {
            gVarR = cVarQ;
        } else if (gVarR == null) {
            gVarR = null;
        }
        return (gVarR == null || !(gVarR.e() || (this.f42031d & 1) == 0)) ? k(lVar) : gVarR;
    }

    public final long h(long j10) {
        return this.f42043p + ((j10 * 1000000) / ((long) this.f42034g.f520d));
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        return v(lVar, true);
    }

    public void j() {
        this.f42048u = true;
    }

    public final g k(l lVar) throws IOException {
        lVar.t(this.f42033f.d(), 0, 4);
        this.f42033f.S(0);
        this.f42034g.a(this.f42033f.o());
        return new nb.a(lVar.getLength(), lVar.getPosition(), this.f42034g);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final nb.g r(hb.l r11) throws java.io.IOException {
        /*
            r10 = this;
            hd.c0 r5 = new hd.c0
            ab.x$a r0 = r10.f42034g
            int r0 = r0.f519c
            r5.<init>(r0)
            byte[] r0 = r5.d()
            ab.x$a r1 = r10.f42034g
            int r1 = r1.f519c
            r6 = 0
            r11.t(r0, r6, r1)
            ab.x$a r0 = r10.f42034g
            int r1 = r0.f517a
            r2 = 1
            r1 = r1 & r2
            r3 = 21
            if (r1 == 0) goto L28
            int r0 = r0.f521e
            if (r0 == r2) goto L2c
            r3 = 36
            r7 = 36
            goto L33
        L28:
            int r0 = r0.f521e
            if (r0 == r2) goto L2f
        L2c:
            r7 = 21
            goto L33
        L2f:
            r3 = 13
            r7 = 13
        L33:
            int r8 = m(r5, r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L62
            if (r8 != r9) goto L42
            goto L62
        L42:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L5d
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            ab.x$a r4 = r10.f42034g
            nb.h r0 = nb.h.b(r0, r2, r4, r5)
            ab.x$a r1 = r10.f42034g
            int r1 = r1.f519c
            r11.o(r1)
            goto Lb2
        L5d:
            r0 = 0
            r11.n()
            goto Lb2
        L62:
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            ab.x$a r4 = r10.f42034g
            nb.i r0 = nb.i.b(r0, r2, r4, r5)
            if (r0 == 0) goto L9c
            hb.w r1 = r10.f42035h
            boolean r1 = r1.a()
            if (r1 != 0) goto L9c
            r11.n()
            int r7 = r7 + 141
            r11.j(r7)
            hd.c0 r1 = r10.f42033f
            byte[] r1 = r1.d()
            r2 = 3
            r11.t(r1, r6, r2)
            hd.c0 r1 = r10.f42033f
            r1.S(r6)
            hb.w r1 = r10.f42035h
            hd.c0 r2 = r10.f42033f
            int r2 = r2.J()
            r1.d(r2)
        L9c:
            ab.x$a r1 = r10.f42034g
            int r1 = r1.f519c
            r11.o(r1)
            if (r0 == 0) goto Lb2
            boolean r1 = r0.e()
            if (r1 != 0) goto Lb2
            if (r8 != r9) goto Lb2
            nb.g r11 = r10.k(r11)
            return r11
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.f.r(hb.l):nb.g");
    }

    @Override // hb.k
    public void release() {
    }

    public final boolean s(l lVar) throws IOException {
        g gVar = this.f42047t;
        if (gVar != null) {
            long jD = gVar.d();
            if (jD != -1 && lVar.i() > jD - 4) {
                return true;
            }
        }
        try {
            return !lVar.h(this.f42033f.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    public final int t(l lVar) throws IOException {
        if (this.f42041n == 0) {
            try {
                v(lVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f42047t == null) {
            g gVarG = g(lVar);
            this.f42047t = gVarG;
            this.f42038k.o(gVarG);
            this.f42040m.f(new Format.b().e0(this.f42034g.f518b).W(4096).H(this.f42034g.f521e).f0(this.f42034g.f520d).M(this.f42035h.f30923a).N(this.f42035h.f30924b).X((this.f42031d & 4) != 0 ? null : this.f42042o).E());
            this.f42045r = lVar.getPosition();
        } else if (this.f42045r != 0) {
            long position = lVar.getPosition();
            long j10 = this.f42045r;
            if (position < j10) {
                lVar.o((int) (j10 - position));
            }
        }
        return u(lVar);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    public final int u(l lVar) throws IOException {
        if (this.f42046s == 0) {
            lVar.n();
            if (s(lVar)) {
                return -1;
            }
            this.f42033f.S(0);
            int iO = this.f42033f.o();
            if (!n(iO, this.f42041n) || x.j(iO) == -1) {
                lVar.o(1);
                this.f42041n = 0;
                return 0;
            }
            this.f42034g.a(iO);
            if (this.f42043p == ya.g.f56663b) {
                this.f42043p = this.f42047t.a(lVar.getPosition());
                if (this.f42032e != ya.g.f56663b) {
                    this.f42043p += this.f42032e - this.f42047t.a(0L);
                }
            }
            x.a aVar = this.f42034g;
            this.f42046s = aVar.f519c;
            g gVar = this.f42047t;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(h(this.f42044q + ((long) aVar.f523g)), lVar.getPosition() + ((long) this.f42034g.f519c));
                if (this.f42049v && bVar.b(this.f42050w)) {
                    this.f42049v = false;
                    this.f42040m = this.f42039l;
                }
            }
        }
        int iE = this.f42040m.e(lVar, this.f42046s, true);
        if (iE == -1) {
            return -1;
        }
        int i10 = this.f42046s - iE;
        this.f42046s = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f42040m.a(h(this.f42044q), 1, this.f42034g.f519c, 0, null);
        this.f42044q += (long) this.f42034g.f523g;
        this.f42046s = 0;
        return 0;
    }

    public final boolean v(l lVar, boolean z10) throws IOException {
        int i10;
        int i11;
        int iJ;
        int i12 = z10 ? 32768 : 131072;
        lVar.n();
        if (lVar.getPosition() == 0) {
            Metadata metadataA = this.f42036i.a(lVar, (this.f42031d & 4) == 0 ? null : B);
            this.f42042o = metadataA;
            if (metadataA != null) {
                this.f42035h.c(metadataA);
            }
            i11 = (int) lVar.i();
            if (!z10) {
                lVar.o(i11);
            }
            i10 = 0;
        } else {
            i10 = 0;
            i11 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (!s(lVar)) {
                this.f42033f.S(0);
                int iO = this.f42033f.o();
                if ((i10 == 0 || n(iO, i10)) && (iJ = x.j(iO)) != -1) {
                    i13++;
                    if (i13 != 1) {
                        if (i13 == 4) {
                            break;
                        }
                    } else {
                        this.f42034g.a(iO);
                        i10 = iO;
                    }
                    lVar.j(iJ - 4);
                } else {
                    int i15 = i14 + 1;
                    if (i14 == i12) {
                        if (z10) {
                            return false;
                        }
                        throw new ParserException("Searched too many bytes.");
                    }
                    if (z10) {
                        lVar.n();
                        lVar.j(i11 + i15);
                    } else {
                        lVar.o(1);
                    }
                    i14 = i15;
                    i10 = 0;
                    i13 = 0;
                }
            } else if (i13 <= 0) {
                throw new EOFException();
            }
        }
        if (z10) {
            lVar.o(i11 + i14);
        } else {
            lVar.n();
        }
        this.f42041n = i10;
        return true;
    }

    public f(int i10) {
        this(i10, ya.g.f56663b);
    }

    public f(int i10, long j10) {
        this.f42031d = i10;
        this.f42032e = j10;
        this.f42033f = new c0(10);
        this.f42034g = new x.a();
        this.f42035h = new w();
        this.f42043p = ya.g.f56663b;
        this.f42036i = new hb.x();
        hb.j jVar = new hb.j();
        this.f42037j = jVar;
        this.f42040m = jVar;
    }
}
