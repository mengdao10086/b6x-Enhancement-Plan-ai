package mm;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class n0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f41364a;

    public n0(gm.c0 c0Var) {
        this.f41364a = c0Var;
    }

    public n0(gm.z zVar) {
        this.f41364a = new n2(false, 0, (gm.h) zVar);
    }

    public n0(y yVar) {
        this.f41364a = yVar;
    }

    public static n0 y(Object obj) {
        if (obj == null || (obj instanceof n0)) {
            return (n0) obj;
        }
        if (obj instanceof y) {
            return new n0((y) obj);
        }
        if (obj instanceof gm.z) {
            return new n0((gm.z) obj);
        }
        if (obj instanceof gm.c0) {
            return new n0((gm.c0) obj);
        }
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41364a.b();
    }

    public gm.h x() {
        gm.h hVar = this.f41364a;
        return hVar instanceof gm.n0 ? gm.z.H((gm.n0) hVar, false) : y.x(hVar);
    }

    public boolean z() {
        return this.f41364a instanceof gm.n0;
    }
}
