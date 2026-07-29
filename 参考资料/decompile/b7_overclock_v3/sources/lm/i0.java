package lm;

import gm.j2;
import zn.u1;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public om.g f39911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.z f39912b;

    public i0(gm.f0 f0Var) {
        this.f39911a = om.g.y(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f39912b = zn.z.G(f0Var.K(1));
        }
    }

    public i0(om.g gVar) {
        this.f39911a = gVar;
    }

    public i0(om.g gVar, u1 u1Var) {
        this.f39911a = gVar;
        this.f39912b = zn.z.G(u1Var.b());
    }

    public i0(om.g gVar, zn.z zVar) {
        this.f39911a = gVar;
        this.f39912b = zVar;
    }

    public static i0 z(Object obj) {
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
        iVar.a(this.f39911a);
        zn.z zVar = this.f39912b;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public om.g x() {
        return this.f39911a;
    }

    public zn.z y() {
        return this.f39912b;
    }
}
