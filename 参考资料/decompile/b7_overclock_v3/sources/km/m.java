package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f37533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.y f37534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.h f37535c;

    public m(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37533a = c.z(f0Var.K(0));
        this.f37534b = gm.y.N(f0Var.K(1));
        this.f37535c = f0Var.K(2);
    }

    public m(c cVar, gm.y yVar, gm.h hVar) {
        this.f37533a = cVar;
        this.f37534b = yVar;
        this.f37535c = hVar;
    }

    public static m A(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37533a);
        iVar.a(this.f37534b);
        iVar.a(this.f37535c);
        return new j2(iVar);
    }

    public c x() {
        return this.f37533a;
    }

    public gm.h y() {
        return this.f37535c;
    }

    public gm.y z() {
        return this.f37534b;
    }
}
