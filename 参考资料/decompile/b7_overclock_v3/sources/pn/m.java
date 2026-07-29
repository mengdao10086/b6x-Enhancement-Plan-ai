package pn;

import gm.f0;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f46772a;

    public m(f0 f0Var) {
        this.f46772a = zn.b.z(f0Var);
    }

    public m(gm.y yVar, gm.h hVar) {
        this.f46772a = new zn.b(yVar, hVar);
    }

    public static m y(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f46772a.b();
    }

    public gm.y x() {
        return this.f46772a.x();
    }

    public gm.h z() {
        return this.f46772a.A();
    }
}
