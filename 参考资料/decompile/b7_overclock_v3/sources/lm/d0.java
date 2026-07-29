package lm;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39887a;

    public d0(gm.f0 f0Var) {
        this.f39887a = f0Var;
    }

    public static d0 x(Object obj) {
        if (obj instanceof d0) {
            return (d0) obj;
        }
        if (obj != null) {
            return new d0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39887a;
    }

    public gm.t[] y() {
        int size = this.f39887a.size();
        gm.t[] tVarArr = new gm.t[size];
        for (int i10 = 0; i10 != size; i10++) {
            tVarArr[i10] = gm.t.I(this.f39887a.K(i10));
        }
        return tVarArr;
    }
}
