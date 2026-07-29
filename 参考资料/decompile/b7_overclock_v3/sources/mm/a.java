package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h0 f41271b;

    public a(gm.f0 f0Var) {
        this.f41270a = (gm.y) f0Var.K(0);
        this.f41271b = (gm.h0) f0Var.K(1);
    }

    public a(gm.y yVar, gm.h0 h0Var) {
        this.f41270a = yVar;
        this.f41271b = h0Var;
    }

    public static a A(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41270a);
        iVar.a(this.f41271b);
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f41270a;
    }

    public gm.h0 y() {
        return this.f41271b;
    }

    public gm.h[] z() {
        return this.f41271b.O();
    }
}
