package org.bouncycastle.crypto.util;

import gm.c0;
import gm.f0;
import gm.s;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import np.a0;
import np.f2;
import np.g0;
import np.h0;
import np.k0;
import np.l0;
import np.m2;
import np.o0;
import np.p2;
import np.r0;
import np.v0;
import np.w0;
import np.z;
import pn.u;
import pn.x;
import zn.z1;

/* JADX INFO: loaded from: classes5.dex */
public class l {
    public static np.c a(InputStream inputStream) throws IOException {
        return b(u.z(new s(inputStream).n()));
    }

    public static np.c b(u uVar) throws IOException {
        BigInteger bigIntegerK;
        h0 h0Var;
        g0 g0Var;
        zn.b bVarB = uVar.B();
        y yVarX = bVarB.x();
        if (yVarX.C(pn.s.f46854x3) || yVarX.C(pn.s.G3) || yVarX.C(z1.f59124r7)) {
            x xVarB = x.B(uVar.G());
            return new f2(xVarB.C(), xVarB.G(), xVarB.F(), xVarB.D(), xVarB.E(), xVarB.y(), xVarB.z(), xVarB.x());
        }
        h0 h0Var2 = null;
        z zVar = null;
        if (yVarX.C(pn.s.O3)) {
            pn.h hVarY = pn.h.y(bVarB.A());
            t tVar = (t) uVar.G();
            BigInteger bigIntegerZ = hVarY.z();
            return new np.r(tVar.K(), new np.q(hVarY.A(), hVarY.x(), null, bigIntegerZ == null ? 0 : bigIntegerZ.intValue()));
        }
        if (yVarX.C(on.b.f44368l)) {
            on.a aVarY = on.a.y(bVarB.A());
            return new w0(((t) uVar.G()).K(), new v0(aVarY.z(), aVarY.x()));
        }
        if (yVarX.C(co.r.W0)) {
            t tVar2 = (t) uVar.G();
            gm.h hVarA = bVarB.A();
            if (hVarA != null) {
                zn.s sVarZ = zn.s.z(hVarA.b());
                zVar = new z(sVarZ.A(), sVarZ.B(), sVarZ.x());
            }
            return new a0(tVar2.K(), zVar);
        }
        if (yVarX.C(co.r.f11174l0)) {
            co.j jVarY = co.j.y(bVarB.A());
            boolean zB = jVarY.B();
            c0 c0VarZ = jVarY.z();
            if (zB) {
                y yVar = (y) c0VarZ;
                co.l lVarK = ap.a.k(yVar);
                if (lVarK == null) {
                    lVarK = co.e.c(yVar);
                }
                g0Var = new k0(yVar, lVarK);
            } else {
                co.l lVarD = co.l.D(c0VarZ);
                g0Var = new g0(lVarD.y(), lVarD.B(), lVarD.E(), lVarD.C(), lVarD.F());
            }
            return new l0(rn.a.x(uVar.G()).y(), g0Var);
        }
        if (yVarX.C(tm.a.f51338b)) {
            return new m2(d(uVar));
        }
        if (yVarX.C(tm.a.f51339c)) {
            return new p2(d(uVar));
        }
        if (yVarX.C(tm.a.f51340d)) {
            return new o0(d(uVar));
        }
        if (yVarX.C(tm.a.f51341e)) {
            return new r0(d(uVar));
        }
        if (!yVarX.C(qm.a.f47463m) && !yVarX.C(qn.a.f47518h) && !yVarX.C(qn.a.f47517g)) {
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        gm.h hVarA2 = bVarB.A();
        qm.g gVarA = qm.g.A(hVarA2);
        c0 c0VarB = hVarA2.b();
        if ((c0VarB instanceof f0) && (f0.J(c0VarB).size() == 2 || f0.J(c0VarB).size() == 3)) {
            h0Var = new h0(new k0(gVarA.B(), qm.b.g(gVarA.B())), gVarA.B(), gVarA.x(), gVarA.y());
            gm.z zVarA = uVar.A();
            if (zVarA.J().length == 32 || zVarA.J().length == 64) {
                bigIntegerK = new BigInteger(1, org.bouncycastle.util.a.L0(zVarA.J()));
            } else {
                gm.h hVarG = uVar.G();
                bigIntegerK = hVarG instanceof t ? t.I(hVarG).J() : new BigInteger(1, org.bouncycastle.util.a.L0(gm.z.I(hVarG).J()));
            }
        } else {
            co.j jVarY2 = co.j.y(bVarB.A());
            if (jVarY2.B()) {
                y yVarN = y.N(jVarY2.z());
                h0Var2 = new h0(new k0(yVarN, co.e.c(yVarN)), gVarA.B(), gVarA.x(), gVarA.y());
            } else if (!jVarY2.A()) {
                h0Var2 = new h0(new k0(yVarX, co.l.D(jVarY2.z())), gVarA.B(), gVarA.x(), gVarA.y());
            }
            gm.h hVarG2 = uVar.G();
            bigIntegerK = hVarG2 instanceof t ? t.I(hVarG2).K() : rn.a.x(hVarG2).y();
            h0Var = h0Var2;
        }
        return new l0(bigIntegerK, new h0(h0Var, gVarA.B(), gVarA.x(), gVarA.y()));
    }

    public static np.c c(byte[] bArr) throws IOException {
        return b(u.z(c0.D(bArr)));
    }

    public static byte[] d(u uVar) throws IOException {
        return gm.z.I(uVar.G()).J();
    }
}
