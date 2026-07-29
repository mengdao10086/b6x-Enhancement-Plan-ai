package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37567b;

    public w(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37566a = a.z(f0Var.K(0));
        this.f37567b = gm.f0.J(f0Var.K(1));
    }

    public w(a aVar, gm.f0 f0Var) {
        this.f37566a = aVar;
        this.f37567b = f0Var;
    }

    public static w y(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj != null) {
            return new w(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f37566a);
        iVar.a(this.f37567b);
        return new j2(iVar);
    }

    public a[] x() {
        a[] aVarArr = new a[this.f37567b.size()];
        for (int i10 = 0; i10 != this.f37567b.size(); i10++) {
            aVarArr[i10] = a.z(this.f37567b.K(i10));
        }
        return aVarArr;
    }

    public a z() {
        return this.f37566a;
    }
}
