package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.f0 f37545a;

    public o(gm.f0 f0Var) {
        if (f0Var.size() != 1) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37545a = gm.f0.J(f0Var.K(0));
    }

    public o(d dVar) {
        this.f37545a = new j2(dVar);
    }

    public o(d[] dVarArr) {
        this.f37545a = new j2(dVarArr);
    }

    public static o y(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f37545a);
    }

    public d[] x() {
        d[] dVarArr = new d[this.f37545a.size()];
        for (int i10 = 0; i10 != this.f37545a.size(); i10++) {
            dVarArr[i10] = d.z(this.f37545a.K(i10));
        }
        return dVarArr;
    }
}
