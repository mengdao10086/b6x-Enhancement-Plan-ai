package pn;

import gm.f0;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f46769a;

    public k(f0 f0Var) {
        this.f46769a = zn.b.z(f0Var);
    }

    public k(gm.y yVar) {
        this.f46769a = new zn.b(yVar);
    }

    public k(gm.y yVar, gm.h hVar) {
        this.f46769a = new zn.b(yVar, hVar);
    }

    public static k y(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f46769a.b();
    }

    public gm.y x() {
        return this.f46769a.x();
    }

    public gm.h z() {
        return this.f46769a.A();
    }
}
