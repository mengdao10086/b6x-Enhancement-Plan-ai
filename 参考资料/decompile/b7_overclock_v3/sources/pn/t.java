package pn;

import gm.f0;
import gm.i1;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f46863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f46864b;

    public t(f0 f0Var) {
        this.f46864b = null;
        if (!gm.t.I(f0Var.K(0)).L(3)) {
            throw new IllegalArgumentException("wrong version for PFX PDU");
        }
        this.f46863a = g.z(f0Var.K(1));
        if (f0Var.size() == 3) {
            this.f46864b = n.x(f0Var.K(2));
        }
    }

    public t(g gVar, n nVar) {
        this.f46863a = gVar;
        this.f46864b = nVar;
    }

    public static t y(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(new gm.t(3L));
        iVar.a(this.f46863a);
        n nVar = this.f46864b;
        if (nVar != null) {
            iVar.a(nVar);
        }
        return new i1(iVar);
    }

    public g x() {
        return this.f46863a;
    }

    public n z() {
        return this.f46864b;
    }
}
