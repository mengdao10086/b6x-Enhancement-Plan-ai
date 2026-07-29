package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class b extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f58666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f58667b;

    public b(gm.f0 f0Var) {
        if (f0Var.size() >= 1 && f0Var.size() <= 2) {
            this.f58666a = gm.y.N(f0Var.K(0));
            this.f58667b = f0Var.size() == 2 ? f0Var.K(1) : null;
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public b(gm.y yVar) {
        this.f58666a = yVar;
    }

    public b(gm.y yVar, gm.h hVar) {
        this.f58666a = yVar;
        this.f58667b = hVar;
    }

    public static b y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(gm.f0.J(obj));
        }
        return null;
    }

    public gm.h A() {
        return this.f58667b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58666a);
        gm.h hVar = this.f58667b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f58666a;
    }
}
