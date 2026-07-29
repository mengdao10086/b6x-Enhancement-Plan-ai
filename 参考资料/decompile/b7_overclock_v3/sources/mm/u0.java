package mm;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class u0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f41414a;

    public u0(gm.c0 c0Var) {
        this.f41414a = c0Var;
    }

    public u0(gm.z zVar) {
        this.f41414a = new n2(false, 0, (gm.h) zVar);
    }

    public u0(y yVar) {
        this.f41414a = yVar;
    }

    public static u0 y(Object obj) {
        if (obj == null || (obj instanceof u0)) {
            return (u0) obj;
        }
        if (obj instanceof y) {
            return new u0((y) obj);
        }
        if (obj instanceof gm.z) {
            return new u0((gm.z) obj);
        }
        if (obj instanceof gm.c0) {
            return new u0((gm.c0) obj);
        }
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41414a.b();
    }

    public gm.h x() {
        gm.h hVar = this.f41414a;
        return hVar instanceof gm.n0 ? gm.z.H((gm.n0) hVar, false) : hVar;
    }

    public boolean z() {
        return this.f41414a instanceof gm.n0;
    }
}
