package lm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.z f39940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f39941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f39942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f39943d;

    public r(gm.f0 f0Var) {
        this.f39940a = gm.z.I(f0Var.K(0));
        this.f39941b = zn.b.z(f0Var.K(1));
        this.f39942c = gm.t.I(f0Var.K(2));
        this.f39943d = zn.b.z(f0Var.K(3));
    }

    public r(gm.z zVar, zn.b bVar, gm.t tVar, zn.b bVar2) {
        this.f39940a = zVar;
        this.f39941b = bVar;
        this.f39942c = tVar;
        this.f39943d = bVar2;
    }

    public r(byte[] bArr, zn.b bVar, int i10, zn.b bVar2) {
        this(new f2(bArr), bVar, new gm.t(i10), bVar2);
    }

    public static r x(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f39941b;
    }

    public gm.z B() {
        return this.f39940a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f39940a);
        iVar.a(this.f39941b);
        iVar.a(this.f39942c);
        iVar.a(this.f39943d);
        return new j2(iVar);
    }

    public gm.t y() {
        return this.f39942c;
    }

    public zn.b z() {
        return this.f39943d;
    }
}
