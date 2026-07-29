package on;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f44355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f44356b;

    public a(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f44355a = (t) enumerationL.nextElement();
        this.f44356b = (t) enumerationL.nextElement();
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f44355a = new t(bigInteger);
        this.f44356b = new t(bigInteger2);
    }

    public static a y(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f44355a);
        iVar.a(this.f44356b);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f44356b.J();
    }

    public BigInteger z() {
        return this.f44355a.J();
    }
}
