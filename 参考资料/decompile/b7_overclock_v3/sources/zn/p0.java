package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class p0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f58890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f58891b;

    public p0(gm.f0 f0Var) {
        this.f58890a = gm.y.N(f0Var.K(0));
        this.f58891b = gm.n0.T(f0Var.K(1)).U();
    }

    public p0(gm.y yVar, gm.h hVar) {
        this.f58890a = yVar;
        this.f58891b = hVar;
    }

    public static p0 x(Object obj) {
        if (obj instanceof p0) {
            return (p0) obj;
        }
        if (obj != null) {
            return new p0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58890a);
        iVar.a(new n2(true, 0, this.f58891b));
        return new j2(iVar);
    }

    public gm.y y() {
        return this.f58890a;
    }

    public gm.h z() {
        return this.f58891b;
    }
}
