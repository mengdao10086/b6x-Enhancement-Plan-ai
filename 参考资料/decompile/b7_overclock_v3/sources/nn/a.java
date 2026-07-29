package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f42243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f42244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u1 f42245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f42246d;

    public a(f0 f0Var) {
        this.f42243a = l.y(f0Var.K(0));
        this.f42244b = zn.b.z(f0Var.K(1));
        this.f42245c = (u1) f0Var.K(2);
        if (f0Var.size() > 3) {
            this.f42246d = f0.I((n0) f0Var.K(3), true);
        }
    }

    public a(l lVar, zn.b bVar, u1 u1Var, f0 f0Var) {
        this.f42243a = lVar;
        this.f42244b = bVar;
        this.f42245c = u1Var;
        this.f42246d = f0Var;
    }

    public static a y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public u1 A() {
        return this.f42245c;
    }

    public zn.b B() {
        return this.f42244b;
    }

    public l C() {
        return this.f42243a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f42243a);
        iVar.a(this.f42244b);
        iVar.a(this.f42245c);
        f0 f0Var = this.f42246d;
        if (f0Var != null) {
            iVar.a(new n2(true, 0, (gm.h) f0Var));
        }
        return new j2(iVar);
    }

    public f0 x() {
        return this.f42246d;
    }
}
