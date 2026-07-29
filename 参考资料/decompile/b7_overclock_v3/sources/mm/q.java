package mm;

import gm.i1;
import gm.n1;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.z f41377c;

    public q(gm.f0 f0Var) {
        if (f0Var.size() < 2) {
            throw new IllegalArgumentException("Truncated Sequence Found");
        }
        this.f41375a = (gm.y) f0Var.K(0);
        this.f41376b = zn.b.z(f0Var.K(1));
        if (f0Var.size() > 2) {
            this.f41377c = gm.z.H((gm.n0) f0Var.K(2), false);
        }
    }

    public q(gm.y yVar, zn.b bVar, gm.z zVar) {
        this.f41375a = yVar;
        this.f41376b = bVar;
        this.f41377c = zVar;
    }

    public static q A(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41375a);
        iVar.a(this.f41376b);
        gm.z zVar = this.f41377c;
        if (zVar != null) {
            iVar.a(new n1(false, 0, (gm.h) zVar));
        }
        return new i1(iVar);
    }

    public zn.b x() {
        return this.f41376b;
    }

    public gm.y y() {
        return this.f41375a;
    }

    public gm.z z() {
        return this.f41377c;
    }
}
