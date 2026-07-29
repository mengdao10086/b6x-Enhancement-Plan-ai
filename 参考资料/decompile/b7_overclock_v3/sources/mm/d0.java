package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n0 f41299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f41300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f41301d;

    public d0(gm.f0 f0Var) {
        this.f41298a = (gm.t) f0Var.K(0);
        this.f41299b = n0.y(f0Var.K(1));
        this.f41300c = zn.b.z(f0Var.K(2));
        this.f41301d = (gm.z) f0Var.K(3);
    }

    public d0(n0 n0Var, zn.b bVar, gm.z zVar) {
        this.f41298a = n0Var.b() instanceof gm.n0 ? new gm.t(2L) : new gm.t(0L);
        this.f41299b = n0Var;
        this.f41300c = bVar;
        this.f41301d = zVar;
    }

    public static d0 y(Object obj) {
        if (obj instanceof d0) {
            return (d0) obj;
        }
        if (obj != null) {
            return new d0(gm.f0.J(obj));
        }
        return null;
    }

    public n0 A() {
        return this.f41299b;
    }

    public gm.t B() {
        return this.f41298a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f41298a);
        iVar.a(this.f41299b);
        iVar.a(this.f41300c);
        iVar.a(this.f41301d);
        return new j2(iVar);
    }

    public gm.z x() {
        return this.f41301d;
    }

    public zn.b z() {
        return this.f41300c;
    }
}
