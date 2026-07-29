package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class s extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.y[] f37556a;

    public s(gm.f0 f0Var) {
        this.f37556a = new zn.y[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            this.f37556a[i10] = zn.y.B(f0Var.K(i10));
        }
    }

    public s(zn.y yVar) {
        this.f37556a = new zn.y[]{yVar};
    }

    public s(zn.y[] yVarArr) {
        this.f37556a = k0.b(yVarArr);
    }

    public static s y(n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static s z(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f37556a);
    }

    public zn.y[] x() {
        return k0.b(this.f37556a);
    }
}
