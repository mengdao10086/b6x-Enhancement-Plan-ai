package qm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f47498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f47499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f47500c;

    public g(f0 f0Var) {
        this.f47498a = (y) f0Var.K(0);
        this.f47499b = (y) f0Var.K(1);
        if (f0Var.size() > 2) {
            this.f47500c = (y) f0Var.K(2);
        }
    }

    public g(y yVar, y yVar2) {
        this.f47498a = yVar;
        this.f47499b = yVar2;
        this.f47500c = null;
    }

    public g(y yVar, y yVar2, y yVar3) {
        this.f47498a = yVar;
        this.f47499b = yVar2;
        this.f47500c = yVar3;
    }

    public static g A(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public static g z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    public y B() {
        return this.f47498a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f47498a);
        iVar.a(this.f47499b);
        y yVar = this.f47500c;
        if (yVar != null) {
            iVar.a(yVar);
        }
        return new j2(iVar);
    }

    public y x() {
        return this.f47499b;
    }

    public y y() {
        return this.f47500c;
    }
}
