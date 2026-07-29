package pn;

import gm.f0;
import gm.j2;
import java.math.BigInteger;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.d f46770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f46771b;

    public l(f0 f0Var) {
        this.f46770a = xn.d.A(f0Var.K(0));
        this.f46771b = (gm.t) f0Var.K(1);
    }

    public l(xn.d dVar, BigInteger bigInteger) {
        this.f46770a = dVar;
        this.f46771b = new gm.t(bigInteger);
    }

    public l(w1 w1Var, gm.t tVar) {
        this.f46770a = xn.d.A(w1Var.b());
        this.f46771b = tVar;
    }

    public l(w1 w1Var, BigInteger bigInteger) {
        this.f46770a = xn.d.A(w1Var.b());
        this.f46771b = new gm.t(bigInteger);
    }

    public static l y(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46770a);
        iVar.a(this.f46771b);
        return new j2(iVar);
    }

    public gm.t x() {
        return this.f46771b;
    }

    public xn.d z() {
        return this.f46770a;
    }
}
