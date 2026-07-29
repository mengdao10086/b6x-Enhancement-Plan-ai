package lm;

import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f39937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public om.c f39938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f39939c;

    public q(gm.f0 f0Var) {
        int size = f0Var.size() - 1;
        this.f39939c = gm.d.K(f0Var.K(size));
        for (int i10 = size - 1; i10 >= 0; i10--) {
            n0 n0Var = (n0) f0Var.K(i10);
            if (n0Var.q() == 0) {
                this.f39937a = zn.b.y(n0Var, true);
            } else {
                this.f39938b = om.c.x(n0Var, true);
            }
        }
    }

    public q(zn.b bVar, om.c cVar, u1 u1Var) {
        this.f39937a = bVar;
        this.f39938b = cVar;
        this.f39939c = u1Var;
    }

    public q(zn.b bVar, om.c cVar, byte[] bArr) {
        this(bVar, cVar, new u1(bArr));
    }

    public static q B(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(gm.f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f39939c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        x(iVar, 0, this.f39937a);
        x(iVar, 1, this.f39938b);
        iVar.a(this.f39939c);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public om.c y() {
        return this.f39938b;
    }

    public zn.b z() {
        return this.f39937a;
    }
}
