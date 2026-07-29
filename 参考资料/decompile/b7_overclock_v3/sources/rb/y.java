package rb;

import hd.p0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f48399i = 20000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48404e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f48400a = new p0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f48405f = ya.g.f56663b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f48406g = ya.g.f56663b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f48407h = ya.g.f56663b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hd.c0 f48401b = new hd.c0();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(hd.c0 c0Var) {
        int iE = c0Var.e();
        if (c0Var.a() < 9) {
            return ya.g.f56663b;
        }
        byte[] bArr = new byte[9];
        c0Var.k(bArr, 0, 9);
        c0Var.S(iE);
        return !a(bArr) ? ya.g.f56663b : m(bArr);
    }

    public static long m(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(hb.l lVar) {
        this.f48401b.P(u0.f31159f);
        this.f48402c = true;
        lVar.n();
        return 0;
    }

    public long c() {
        return this.f48407h;
    }

    public p0 d() {
        return this.f48400a;
    }

    public boolean e() {
        return this.f48402c;
    }

    public final int f(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public int g(hb.l lVar, hb.z zVar) throws IOException {
        if (!this.f48404e) {
            return j(lVar, zVar);
        }
        if (this.f48406g == ya.g.f56663b) {
            return b(lVar);
        }
        if (!this.f48403d) {
            return h(lVar, zVar);
        }
        long j10 = this.f48405f;
        if (j10 == ya.g.f56663b) {
            return b(lVar);
        }
        this.f48407h = this.f48400a.b(this.f48406g) - this.f48400a.b(j10);
        return b(lVar);
    }

    public final int h(hb.l lVar, hb.z zVar) throws IOException {
        int iMin = (int) Math.min(com.google.android.exoplayer2.audio.j.f16899v, lVar.getLength());
        long j10 = 0;
        if (lVar.getPosition() != j10) {
            zVar.f30930a = j10;
            return 1;
        }
        this.f48401b.O(iMin);
        lVar.n();
        lVar.t(this.f48401b.d(), 0, iMin);
        this.f48405f = i(this.f48401b);
        this.f48403d = true;
        return 0;
    }

    public final long i(hd.c0 c0Var) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF - 3; iE++) {
            if (f(c0Var.d(), iE) == 442) {
                c0Var.S(iE + 4);
                long jL = l(c0Var);
                if (jL != ya.g.f56663b) {
                    return jL;
                }
            }
        }
        return ya.g.f56663b;
    }

    public final int j(hb.l lVar, hb.z zVar) throws IOException {
        long length = lVar.getLength();
        int iMin = (int) Math.min(com.google.android.exoplayer2.audio.j.f16899v, length);
        long j10 = length - ((long) iMin);
        if (lVar.getPosition() != j10) {
            zVar.f30930a = j10;
            return 1;
        }
        this.f48401b.O(iMin);
        lVar.n();
        lVar.t(this.f48401b.d(), 0, iMin);
        this.f48406g = k(this.f48401b);
        this.f48404e = true;
        return 0;
    }

    public final long k(hd.c0 c0Var) {
        int iE = c0Var.e();
        for (int iF = c0Var.f() - 4; iF >= iE; iF--) {
            if (f(c0Var.d(), iF) == 442) {
                c0Var.S(iF + 4);
                long jL = l(c0Var);
                if (jL != ya.g.f56663b) {
                    return jL;
                }
            }
        }
        return ya.g.f56663b;
    }
}
