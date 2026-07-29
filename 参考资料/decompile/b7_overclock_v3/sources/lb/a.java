package lb;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import g.p0;
import hb.a0;
import hb.k;
import hb.l;
import hb.m;
import hb.z;
import hd.c0;
import java.io.IOException;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {
    public static final int A = 1024;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f39523n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f39524o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f39525p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f39526q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f39527r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f39528s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f39529t = 6;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f39530u = 1165519206;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f39531v = 65496;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f39532w = 65498;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f39533x = 65504;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f39534y = 65505;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f39535z = "http://ns.adobe.com/xap/1.0/";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f39537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f39538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39540h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public MotionPhotoMetadata f39542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l f39543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f39544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public ob.k f39545m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f39536d = new c0(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f39541i = -1;

    @p0
    public static MotionPhotoMetadata e(String str, long j10) throws IOException {
        b bVarA;
        if (j10 == -1 || (bVarA = e.a(str)) == null) {
            return null;
        }
        return bVarA.a(j10);
    }

    public final void a(l lVar) throws IOException {
        this.f39536d.O(2);
        lVar.t(this.f39536d.d(), 0, 2);
        lVar.j(this.f39536d.M() - 2);
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        if (j10 == 0) {
            this.f39538f = 0;
            this.f39545m = null;
        } else if (this.f39538f == 5) {
            ((ob.k) hd.a.g(this.f39545m)).b(j10, j11);
        }
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f39537e = mVar;
    }

    public final void d() {
        g(new Metadata.Entry[0]);
        ((m) hd.a.g(this.f39537e)).k();
        this.f39537e.o(new a0.b(g.f56663b));
        this.f39538f = 6;
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        int i10 = this.f39538f;
        if (i10 == 0) {
            j(lVar);
            return 0;
        }
        if (i10 == 1) {
            l(lVar);
            return 0;
        }
        if (i10 == 2) {
            k(lVar);
            return 0;
        }
        if (i10 == 4) {
            long position = lVar.getPosition();
            long j10 = this.f39541i;
            if (position != j10) {
                zVar.f30930a = j10;
                return 1;
            }
            m(lVar);
            return 0;
        }
        if (i10 != 5) {
            if (i10 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f39544l == null || lVar != this.f39543k) {
            this.f39543k = lVar;
            this.f39544l = new c(lVar, this.f39541i);
        }
        int iF = ((ob.k) hd.a.g(this.f39545m)).f(this.f39544l, zVar);
        if (iF == 1) {
            zVar.f30930a += this.f39541i;
        }
        return iF;
    }

    public final void g(Metadata.Entry... entryArr) {
        ((m) hd.a.g(this.f39537e)).d(1024, 4).f(new Format.b().X(new Metadata(entryArr)).E());
    }

    public final int h(l lVar) throws IOException {
        this.f39536d.O(2);
        lVar.t(this.f39536d.d(), 0, 2);
        return this.f39536d.M();
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        if (h(lVar) != 65496) {
            return false;
        }
        int iH = h(lVar);
        this.f39539g = iH;
        if (iH == 65504) {
            a(lVar);
            this.f39539g = h(lVar);
        }
        if (this.f39539g != 65505) {
            return false;
        }
        lVar.j(2);
        this.f39536d.O(6);
        lVar.t(this.f39536d.d(), 0, 6);
        return this.f39536d.I() == f39530u && this.f39536d.M() == 0;
    }

    public final void j(l lVar) throws IOException {
        this.f39536d.O(2);
        lVar.readFully(this.f39536d.d(), 0, 2);
        int iM = this.f39536d.M();
        this.f39539g = iM;
        if (iM == 65498) {
            if (this.f39541i != -1) {
                this.f39538f = 4;
                return;
            } else {
                d();
                return;
            }
        }
        if ((iM < 65488 || iM > 65497) && iM != 65281) {
            this.f39538f = 1;
        }
    }

    public final void k(l lVar) throws IOException {
        String strA;
        if (this.f39539g == 65505) {
            c0 c0Var = new c0(this.f39540h);
            lVar.readFully(c0Var.d(), 0, this.f39540h);
            if (this.f39542j == null && f39535z.equals(c0Var.A()) && (strA = c0Var.A()) != null) {
                MotionPhotoMetadata motionPhotoMetadataE = e(strA, lVar.getLength());
                this.f39542j = motionPhotoMetadataE;
                if (motionPhotoMetadataE != null) {
                    this.f39541i = motionPhotoMetadataE.f17330d;
                }
            }
        } else {
            lVar.o(this.f39540h);
        }
        this.f39538f = 0;
    }

    public final void l(l lVar) throws IOException {
        this.f39536d.O(2);
        lVar.readFully(this.f39536d.d(), 0, 2);
        this.f39540h = this.f39536d.M() - 2;
        this.f39538f = 2;
    }

    public final void m(l lVar) throws IOException {
        if (!lVar.h(this.f39536d.d(), 0, 1, true)) {
            d();
            return;
        }
        lVar.n();
        if (this.f39545m == null) {
            this.f39545m = new ob.k();
        }
        c cVar = new c(lVar, this.f39541i);
        this.f39544l = cVar;
        if (!this.f39545m.i(cVar)) {
            d();
        } else {
            this.f39545m.c(new d(this.f39541i, (m) hd.a.g(this.f39537e)));
            n();
        }
    }

    public final void n() {
        g((Metadata.Entry) hd.a.g(this.f39542j));
        this.f39538f = 5;
    }

    @Override // hb.k
    public void release() {
        ob.k kVar = this.f39545m;
        if (kVar != null) {
            kVar.release();
        }
    }
}
