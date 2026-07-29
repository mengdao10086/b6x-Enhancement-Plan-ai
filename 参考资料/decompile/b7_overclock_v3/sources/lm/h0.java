package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f39903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public om.c f39904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.o f39905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f39906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.z f39907e;

    public h0(gm.f0 f0Var) {
        this.f39903a = a0.x(f0Var.K(0));
        this.f39904b = om.c.y(f0Var.K(1));
        this.f39905c = gm.o.M(f0Var.K(2));
        this.f39906d = gm.o.M(f0Var.K(3));
        if (f0Var.size() > 4) {
            this.f39907e = zn.z.G(f0Var.K(4));
        }
    }

    public static h0 A(Object obj) {
        if (obj instanceof h0) {
            return (h0) obj;
        }
        if (obj != null) {
            return new h0(gm.f0.J(obj));
        }
        return null;
    }

    public a0 B() {
        return this.f39903a;
    }

    public gm.o C() {
        return this.f39905c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f39903a);
        iVar.a(this.f39904b);
        iVar.a(this.f39905c);
        iVar.a(this.f39906d);
        zn.z zVar = this.f39907e;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public gm.o x() {
        return this.f39906d;
    }

    public om.c y() {
        return this.f39904b;
    }

    public zn.z z() {
        return this.f39907e;
    }
}
