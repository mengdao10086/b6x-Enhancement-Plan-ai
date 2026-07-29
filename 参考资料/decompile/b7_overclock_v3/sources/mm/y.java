package mm;

import gm.j2;
import java.math.BigInteger;
import zn.r1;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.d f41432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f41433b;

    public y(gm.f0 f0Var) {
        this.f41432a = xn.d.A(f0Var.K(0));
        this.f41433b = (gm.t) f0Var.K(1);
    }

    public y(xn.d dVar, BigInteger bigInteger) {
        this.f41432a = dVar;
        this.f41433b = new gm.t(bigInteger);
    }

    public y(zn.o oVar) {
        this.f41432a = oVar.A();
        this.f41433b = oVar.B();
    }

    public y(r1 r1Var) {
        this.f41432a = r1Var.A();
        this.f41433b = r1Var.B();
    }

    public y(w1 w1Var, gm.t tVar) {
        this.f41432a = xn.d.A(w1Var);
        this.f41433b = tVar;
    }

    public y(w1 w1Var, BigInteger bigInteger) {
        this.f41432a = xn.d.A(w1Var);
        this.f41433b = new gm.t(bigInteger);
    }

    public static y x(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj != null) {
            return new y(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41432a);
        iVar.a(this.f41433b);
        return new j2(iVar);
    }

    public xn.d y() {
        return this.f41432a;
    }

    public gm.t z() {
        return this.f41433b;
    }
}
