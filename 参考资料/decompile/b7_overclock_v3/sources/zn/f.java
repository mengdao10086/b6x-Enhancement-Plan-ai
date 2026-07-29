package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f58718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f58719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f58720c;

    public f(gm.f0 f0Var) {
        if (f0Var.size() == 3) {
            this.f58718a = g.C(f0Var.K(0));
            this.f58719b = b.z(f0Var.K(1));
            this.f58720c = gm.u1.S(f0Var.K(2));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public f(g gVar, b bVar, gm.u1 u1Var) {
        this.f58718a = gVar;
        this.f58719b = bVar;
        this.f58720c = u1Var;
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(gm.f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f58720c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f58718a);
        iVar.a(this.f58719b);
        iVar.a(this.f58720c);
        return new j2(iVar);
    }

    public g x() {
        return this.f58718a;
    }

    public b z() {
        return this.f58719b;
    }
}
