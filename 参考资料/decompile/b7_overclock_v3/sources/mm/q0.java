package mm;

import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class q0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f41378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f41379b;

    public q0(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
        }
        this.f41378a = zn.b.z(f0Var.K(0));
        this.f41379b = gm.t.I(f0Var.K(1)).K();
    }

    public q0(zn.b bVar, int i10) {
        this.f41378a = bVar;
        this.f41379b = BigInteger.valueOf(i10);
    }

    public static q0 x(Object obj) {
        if (obj instanceof q0) {
            return (q0) obj;
        }
        if (obj != null) {
            return new q0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41378a);
        iVar.a(new gm.t(this.f41379b));
        return new j2(iVar);
    }

    public zn.b y() {
        return this.f41378a;
    }

    public BigInteger z() {
        return this.f41379b;
    }
}
