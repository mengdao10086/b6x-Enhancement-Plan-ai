package iq;

import gm.f0;
import gm.f2;
import gm.h;
import gm.j2;
import gm.t;
import gm.y;
import gm.z;
import java.io.IOException;
import rn.d;
import xr.q;
import xr.r;
import xr.s;
import xr.t1;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static t1 a(y yVar, byte[] bArr) {
        f0 f0VarJ = f0.J(bArr);
        if (yVar.C(d.H)) {
            return new t1(0, new s(new q(0, new f2(org.bouncycastle.util.b.b(32, t.I(f0VarJ.K(0)).K()))), new f2(org.bouncycastle.util.b.b(32, t.I(f0VarJ.K(1)).K()))));
        }
        if (yVar.C(tn.b.f51379u)) {
            return new t1(1, new s(new q(0, new f2(org.bouncycastle.util.b.b(32, t.I(f0VarJ.K(0)).K()))), new f2(org.bouncycastle.util.b.b(32, t.I(f0VarJ.K(1)).K()))));
        }
        if (yVar.C(tn.b.f51383y)) {
            return new t1(3, new xr.t(new r(0, new f2(org.bouncycastle.util.b.b(48, t.I(f0VarJ.K(0)).K()))), new f2(org.bouncycastle.util.b.b(48, t.I(f0VarJ.K(1)).K()))));
        }
        throw new IllegalArgumentException("unknown curveID");
    }

    public static byte[] b(t1 t1Var) {
        byte[] bArrJ;
        z zVarA;
        if (t1Var.y() == 0 || t1Var.y() == 1) {
            s sVarY = s.y(t1Var.A());
            bArrJ = z.I(sVarY.z().B()).J();
            zVarA = sVarY.A();
        } else {
            xr.t tVarX = xr.t.x(t1Var.A());
            bArrJ = z.I(tVarX.y().B()).J();
            zVarA = tVarX.z();
        }
        try {
            return new j2(new h[]{new t(org.bouncycastle.util.b.i(bArrJ)), new t(org.bouncycastle.util.b.i(zVarA.J()))}).getEncoded();
        } catch (IOException unused) {
            throw new RuntimeException("der encoding r & s");
        }
    }
}
