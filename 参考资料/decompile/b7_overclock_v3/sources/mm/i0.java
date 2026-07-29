package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f41337b;

    public i0(gm.f0 f0Var) {
        this.f41336a = (gm.y) f0Var.K(0);
        this.f41337b = f0Var.K(1);
    }

    public i0(gm.y yVar, gm.h hVar) {
        this.f41336a = yVar;
        this.f41337b = hVar;
    }

    public static i0 x(Object obj) {
        if (obj instanceof i0) {
            return (i0) obj;
        }
        if (obj != null) {
            return new i0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41336a);
        iVar.a(this.f41337b);
        return new j2(iVar);
    }

    public gm.h y() {
        return this.f41337b;
    }

    public gm.y z() {
        return this.f41336a;
    }
}
