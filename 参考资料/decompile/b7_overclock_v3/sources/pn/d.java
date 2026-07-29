package pn;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f46744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f46745b;

    public d(f0 f0Var) {
        this.f46744a = gm.y.N(f0Var.K(0));
        this.f46745b = n0.T(f0Var.K(1)).U();
    }

    public d(gm.y yVar, gm.h hVar) {
        this.f46744a = yVar;
        this.f46745b = hVar;
    }

    public static d z(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46744a);
        iVar.a(new n2(0, this.f46745b));
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f46744a;
    }

    public gm.h y() {
        return this.f46745b;
    }
}
