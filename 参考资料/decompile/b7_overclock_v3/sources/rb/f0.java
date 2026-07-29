package rb;

import hd.p0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48006a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f48011f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f48007b = new p0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f48012g = ya.g.f56663b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f48013h = ya.g.f56663b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f48014i = ya.g.f56663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hd.c0 f48008c = new hd.c0();

    public f0(int i10) {
        this.f48006a = i10;
    }

    public final int a(hb.l lVar) {
        this.f48008c.P(u0.f31159f);
        this.f48009d = true;
        lVar.n();
        return 0;
    }

    public long b() {
        return this.f48014i;
    }

    public p0 c() {
        return this.f48007b;
    }

    public boolean d() {
        return this.f48009d;
    }

    public int e(hb.l lVar, hb.z zVar, int i10) throws IOException {
        if (i10 <= 0) {
            return a(lVar);
        }
        if (!this.f48011f) {
            return h(lVar, zVar, i10);
        }
        if (this.f48013h == ya.g.f56663b) {
            return a(lVar);
        }
        if (!this.f48010e) {
            return f(lVar, zVar, i10);
        }
        long j10 = this.f48012g;
        if (j10 == ya.g.f56663b) {
            return a(lVar);
        }
        this.f48014i = this.f48007b.b(this.f48013h) - this.f48007b.b(j10);
        return a(lVar);
    }

    public final int f(hb.l lVar, hb.z zVar, int i10) throws IOException {
        int iMin = (int) Math.min(this.f48006a, lVar.getLength());
        long j10 = 0;
        if (lVar.getPosition() != j10) {
            zVar.f30930a = j10;
            return 1;
        }
        this.f48008c.O(iMin);
        lVar.n();
        lVar.t(this.f48008c.d(), 0, iMin);
        this.f48012g = g(this.f48008c, i10);
        this.f48010e = true;
        return 0;
    }

    public final long g(hd.c0 c0Var, int i10) {
        int iF = c0Var.f();
        for (int iE = c0Var.e(); iE < iF; iE++) {
            if (c0Var.d()[iE] == 71) {
                long jB = j0.b(c0Var, iE, i10);
                if (jB != ya.g.f56663b) {
                    return jB;
                }
            }
        }
        return ya.g.f56663b;
    }

    public final int h(hb.l lVar, hb.z zVar, int i10) throws IOException {
        long length = lVar.getLength();
        int iMin = (int) Math.min(this.f48006a, length);
        long j10 = length - ((long) iMin);
        if (lVar.getPosition() != j10) {
            zVar.f30930a = j10;
            return 1;
        }
        this.f48008c.O(iMin);
        lVar.n();
        lVar.t(this.f48008c.d(), 0, iMin);
        this.f48013h = i(this.f48008c, i10);
        this.f48011f = true;
        return 0;
    }

    public final long i(hd.c0 c0Var, int i10) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (true) {
            iF--;
            if (iF < iE) {
                return ya.g.f56663b;
            }
            if (c0Var.d()[iF] == 71) {
                long jB = j0.b(c0Var, iF, i10);
                if (jB != ya.g.f56663b) {
                    return jB;
                }
            }
        }
    }
}
