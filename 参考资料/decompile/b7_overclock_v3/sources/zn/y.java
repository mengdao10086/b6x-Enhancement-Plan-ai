package zn;

import gm.f2;
import gm.j2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f59083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f59084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.z f59085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.y f59057d = new gm.y("2.5.29.9").O();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gm.y f59058e = new gm.y("2.5.29.14").O();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final gm.y f59059f = new gm.y("2.5.29.15").O();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gm.y f59060g = new gm.y("2.5.29.16").O();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.y f59061h = new gm.y("2.5.29.17").O();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final gm.y f59062i = new gm.y("2.5.29.18").O();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gm.y f59063j = new gm.y("2.5.29.19").O();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gm.y f59064k = new gm.y("2.5.29.20").O();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gm.y f59067l = new gm.y("2.5.29.21").O();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final gm.y f59068m = new gm.y("2.5.29.23").O();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final gm.y f59069n = new gm.y("2.5.29.24").O();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final gm.y f59070o = new gm.y("2.5.29.27").O();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final gm.y f59071p = new gm.y("2.5.29.28").O();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final gm.y f59072q = new gm.y("2.5.29.29").O();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final gm.y f59073r = new gm.y("2.5.29.30").O();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final gm.y f59074s = new gm.y("2.5.29.31").O();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final gm.y f59075t = new gm.y("2.5.29.32").O();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final gm.y f59076u = new gm.y("2.5.29.33").O();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final gm.y f59077v = new gm.y("2.5.29.35").O();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final gm.y f59079w = new gm.y("2.5.29.36").O();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final gm.y f59080x = new gm.y("2.5.29.37").O();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final gm.y f59081y = new gm.y("2.5.29.46").O();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final gm.y f59082z = new gm.y("2.5.29.54").O();
    public static final gm.y A = new gm.y("1.3.6.1.5.5.7.1.1").O();
    public static final gm.y B = new gm.y("1.3.6.1.5.5.7.1.11").O();
    public static final gm.y C = new gm.y("1.3.6.1.5.5.7.1.12").O();
    public static final gm.y D = new gm.y("1.3.6.1.5.5.7.1.2").O();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final gm.y f59065k0 = new gm.y("1.3.6.1.5.5.7.1.3").O();
    public static final gm.y K0 = new gm.y("1.3.6.1.5.5.7.1.4").O();

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final gm.y f59066k1 = new gm.y("2.5.29.56").O();

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final gm.y f59078v1 = new gm.y("2.5.29.55").O();
    public static final gm.y C1 = new gm.y("2.5.29.60").O();

    public y(gm.f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() == 2) {
            this.f59083a = gm.y.N(f0Var.K(0));
            this.f59084b = false;
            hVarK = f0Var.K(1);
        } else {
            if (f0Var.size() != 3) {
                throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
            }
            this.f59083a = gm.y.N(f0Var.K(0));
            this.f59084b = gm.f.J(f0Var.K(1)).L();
            hVarK = f0Var.K(2);
        }
        this.f59085c = gm.z.I(hVarK);
    }

    public y(gm.y yVar, gm.f fVar, gm.z zVar) {
        this(yVar, fVar.L(), zVar);
    }

    public y(gm.y yVar, boolean z10, gm.z zVar) {
        this.f59083a = yVar;
        this.f59084b = z10;
        this.f59085c = zVar;
    }

    public y(gm.y yVar, boolean z10, byte[] bArr) {
        this(yVar, z10, new f2(bArr));
    }

    public static y B(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj != null) {
            return new y(gm.f0.J(obj));
        }
        return null;
    }

    public static gm.c0 x(y yVar) throws IllegalArgumentException {
        try {
            return gm.c0.D(yVar.A().J());
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't convert extension: " + e10);
        }
    }

    public static y y(gm.y yVar, boolean z10, gm.h hVar) throws IOException {
        return new y(yVar, z10, hVar.b().getEncoded());
    }

    public gm.z A() {
        return this.f59085c;
    }

    public gm.h C() {
        return x(this);
    }

    public boolean D() {
        return this.f59084b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f59083a);
        if (this.f59084b) {
            iVar.a(gm.f.K(true));
        }
        iVar.a(this.f59085c);
        return new j2(iVar);
    }

    @Override // gm.w
    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return yVar.z().C(z()) && yVar.A().C(A()) && yVar.D() == D();
    }

    @Override // gm.w
    public int hashCode() {
        return D() ? A().hashCode() ^ z().hashCode() : ~(A().hashCode() ^ z().hashCode());
    }

    public gm.y z() {
        return this.f59083a;
    }
}
