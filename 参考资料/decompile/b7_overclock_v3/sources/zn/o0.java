package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class o0 extends gm.w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58870e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58871f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58872g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.k f58873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.y f58874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f58875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.d f58876d;

    public o0(int i10, gm.y yVar, b bVar, byte[] bArr) {
        this.f58873a = new gm.k(i10);
        if (i10 == 2) {
            this.f58874b = yVar;
        }
        this.f58875c = bVar;
        this.f58876d = new gm.u1(bArr);
    }

    public o0(gm.f0 f0Var) {
        if (f0Var.size() > 4 || f0Var.size() < 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        int i10 = 0;
        this.f58873a = gm.k.I(f0Var.K(0));
        if (f0Var.size() == 4) {
            this.f58874b = gm.y.N(f0Var.K(1));
            i10 = 1;
        }
        this.f58875c = b.z(f0Var.K(i10 + 1));
        this.f58876d = gm.u1.S(f0Var.K(i10 + 2));
    }

    public static o0 A(Object obj) {
        if (obj instanceof o0) {
            return (o0) obj;
        }
        if (obj != null) {
            return new o0(gm.f0.J(obj));
        }
        return null;
    }

    public static o0 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public gm.d B() {
        return this.f58876d;
    }

    public gm.y C() {
        return this.f58874b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f58873a);
        gm.y yVar = this.f58874b;
        if (yVar != null) {
            iVar.a(yVar);
        }
        iVar.a(this.f58875c);
        iVar.a(this.f58876d);
        return new j2(iVar);
    }

    public b x() {
        return this.f58875c;
    }

    public gm.k y() {
        return this.f58873a;
    }
}
