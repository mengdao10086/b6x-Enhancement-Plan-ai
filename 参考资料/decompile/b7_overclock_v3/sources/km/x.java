package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f37568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f37569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f37570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final om.g f37571d;

    public x(gm.f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() != 4 && f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37568a = c.z(f0Var.K(0));
        this.f37569b = b.z(f0Var.K(1));
        if (f0Var.size() == 4) {
            this.f37570c = gm.f.J(f0Var.K(2)).L();
            hVarK = f0Var.K(3);
        } else {
            this.f37570c = true;
            hVarK = f0Var.K(2);
        }
        this.f37571d = om.g.y(hVarK);
    }

    public x(c cVar, b bVar, boolean z10, om.g gVar) {
        this.f37568a = cVar;
        this.f37569b = bVar;
        this.f37570c = z10;
        this.f37571d = gVar;
    }

    public static x z(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(gm.f0.J(obj));
        }
        return null;
    }

    public c A() {
        return this.f37568a;
    }

    public boolean B() {
        return this.f37570c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f37568a);
        iVar.a(this.f37569b);
        boolean z10 = this.f37570c;
        if (!z10) {
            iVar.a(gm.f.K(z10));
        }
        iVar.a(this.f37571d);
        return new j2(iVar);
    }

    public b x() {
        return this.f37569b;
    }

    public om.g y() {
        return this.f37571d;
    }
}
