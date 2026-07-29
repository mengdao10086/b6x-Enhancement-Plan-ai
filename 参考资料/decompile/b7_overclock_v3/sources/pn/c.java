package pn;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f46736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f46737b;

    public c(f0 f0Var) {
        this.f46736a = (gm.y) f0Var.K(0);
        this.f46737b = ((n0) f0Var.K(1)).U();
    }

    public c(gm.y yVar, gm.h hVar) {
        this.f46736a = yVar;
        this.f46737b = hVar;
    }

    public static c z(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46736a);
        iVar.a(new n2(0, this.f46737b));
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f46736a;
    }

    public gm.h y() {
        return this.f46737b;
    }
}
