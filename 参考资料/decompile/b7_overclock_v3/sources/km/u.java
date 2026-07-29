package km;

import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class u extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b0 f37561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f37562b;

    public u(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37561a = zn.b0.z(f0Var.K(0));
        this.f37562b = gm.t.I(f0Var.K(1)).K();
    }

    public u(zn.b0 b0Var, BigInteger bigInteger) {
        this.f37561a = b0Var;
        this.f37562b = bigInteger;
    }

    public static u x(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj != null) {
            return new u(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f37561a);
        iVar.a(new gm.t(this.f37562b));
        return new j2(iVar);
    }

    public zn.b0 y() {
        return this.f37561a;
    }

    public BigInteger z() {
        return this.f37562b;
    }
}
