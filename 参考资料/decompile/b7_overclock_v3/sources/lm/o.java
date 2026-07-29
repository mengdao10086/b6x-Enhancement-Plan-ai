package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f39931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f39932b;

    public o(gm.f0 f0Var) {
        this.f39931a = gm.y.N(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f39932b = f0Var.K(1);
        }
    }

    public o(gm.y yVar) {
        this.f39931a = yVar;
        this.f39932b = null;
    }

    public o(gm.y yVar, gm.h hVar) {
        this.f39931a = yVar;
        this.f39932b = hVar;
    }

    public static o z(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f39931a);
        gm.h hVar = this.f39932b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f39931a;
    }

    public gm.h y() {
        return this.f39932b;
    }
}
