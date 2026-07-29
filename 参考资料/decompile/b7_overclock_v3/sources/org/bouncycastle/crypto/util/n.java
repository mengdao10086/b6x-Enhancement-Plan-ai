package org.bouncycastle.crypto.util;

import gm.c0;
import gm.f2;
import gm.t;
import gm.y;
import ir.e;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import np.b0;
import np.e2;
import np.g0;
import np.h0;
import np.k0;
import np.m0;
import np.n2;
import np.p0;
import np.q2;
import np.s;
import np.s0;
import np.v;
import np.v0;
import np.x0;
import np.z;
import zn.c1;
import zn.z1;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f44756a;

    public static class b extends m {
        public b() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            pn.h hVarY = pn.h.y(c1Var.x().A());
            t tVar = (t) c1Var.D();
            BigInteger bigIntegerZ = hVarY.z();
            return new s(tVar.K(), new np.q(hVarY.A(), hVarY.x(), null, bigIntegerZ == null ? 0 : bigIntegerZ.intValue()));
        }
    }

    public static class c extends m {
        public c() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            BigInteger bigIntegerZ = co.b.y(c1Var.D()).z();
            co.d dVarZ = co.d.z(c1Var.x().A());
            BigInteger bigIntegerC = dVarZ.C();
            BigInteger bigIntegerX = dVarZ.x();
            BigInteger bigIntegerD = dVarZ.D();
            BigInteger bigIntegerA = dVarZ.A() != null ? dVarZ.A() : null;
            co.h hVarE = dVarZ.E();
            return new s(bigIntegerZ, new np.q(bigIntegerC, bigIntegerX, bigIntegerD, bigIntegerA, hVarE != null ? new v(hVarE.A(), hVarE.z().intValue()) : null));
        }
    }

    public static class d extends m {
        public d() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            z zVar;
            t tVar = (t) c1Var.D();
            gm.h hVarA = c1Var.x().A();
            if (hVarA != null) {
                zn.s sVarZ = zn.s.z(hVarA.b());
                zVar = new z(sVarZ.A(), sVarZ.B(), sVarZ.x());
            } else {
                zVar = null;
            }
            return new b0(tVar.K(), zVar);
        }
    }

    public static class e extends m {
        public e() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            g0 g0Var;
            zn.b bVarX = c1Var.x();
            y yVarX = bVarX.x();
            vn.d dVarA = vn.d.A(bVarX.A());
            try {
                byte[] bArrP = org.bouncycastle.util.a.p(((gm.z) c1Var.D()).J());
                y yVar = vn.g.f53268b;
                if (yVarX.C(yVar)) {
                    b(bArrP);
                }
                if (dVarA.C()) {
                    g0Var = vn.c.a(dVarA.B());
                } else {
                    vn.b bVarZ = dVarA.z();
                    byte[] bArrY = bVarZ.y();
                    if (yVarX.C(yVar)) {
                        b(bArrY);
                    }
                    BigInteger bigInteger = new BigInteger(1, bArrY);
                    vn.a aVarZ = bVarZ.z();
                    e.C0401e c0401e = new e.C0401e(aVarZ.B(), aVarZ.y(), aVarZ.z(), aVarZ.A(), bVarZ.x(), bigInteger);
                    byte[] bArrA = bVarZ.A();
                    if (yVarX.C(yVar)) {
                        b(bArrA);
                    }
                    g0Var = new g0(c0401e, vn.e.a(c0401e, bArrA), bVarZ.C());
                }
                return new m0(vn.e.a(g0Var.a(), bArrP), g0Var);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering DSTU public key");
            }
        }

        public final void b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length / 2; i10++) {
                byte b10 = bArr[i10];
                bArr[i10] = bArr[(bArr.length - 1) - i10];
                bArr[(bArr.length - 1) - i10] = b10;
            }
        }
    }

    public static class f extends m {
        public f() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            g0 g0Var;
            co.j jVarY = co.j.y(c1Var.x().A());
            if (jVarY.B()) {
                y yVar = (y) jVarY.z();
                co.l lVarK = ap.a.k(yVar);
                if (lVarK == null) {
                    lVarK = co.e.c(yVar);
                }
                g0Var = new k0(yVar, lVarK);
            } else {
                g0Var = jVarY.A() ? (g0) obj : new g0(co.l.D(jVarY.z()));
            }
            byte[] bArrH = c1Var.C().H();
            gm.z f2Var = new f2(bArrH);
            if (bArrH[0] == 4 && bArrH[1] == bArrH.length - 2 && ((bArrH[2] == 2 || bArrH[2] == 3) && new co.q().a(g0Var.a()) >= bArrH.length - 3)) {
                try {
                    f2Var = (gm.z) c0.D(bArrH);
                } catch (IOException unused) {
                    throw new IllegalArgumentException("error recovering public key");
                }
            }
            return new m0(new co.n(g0Var.a(), f2Var).x(), g0Var);
        }
    }

    public static class g extends m {
        public g() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            return new p0(n.f(c1Var, obj));
        }
    }

    public static class h extends m {
        public h() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            return new s0(n.f(c1Var, obj));
        }
    }

    public static class i extends m {
        public i() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            on.a aVarY = on.a.y(c1Var.x().A());
            return new x0(((t) c1Var.D()).K(), new v0(aVarY.z(), aVarY.x()));
        }
    }

    public static class j extends m {
        public j() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            qm.g gVarA = qm.g.A(c1Var.x().A());
            y yVarB = gVarA.B();
            h0 h0Var = new h0(new k0(yVarB, qm.b.g(yVarB)), yVarB, gVarA.x(), gVarA.y());
            try {
                byte[] bArrJ = ((gm.z) c1Var.D()).J();
                if (bArrJ.length != 64) {
                    throw new IllegalArgumentException("invalid length for GOST3410_2001 public key");
                }
                byte[] bArr = new byte[65];
                bArr[0] = 4;
                for (int i10 = 1; i10 <= 32; i10++) {
                    bArr[i10] = bArrJ[32 - i10];
                    bArr[i10 + 32] = bArrJ[64 - i10];
                }
                return new m0(h0Var.a().k(bArr), h0Var);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering GOST3410_2001 public key");
            }
        }
    }

    public static class k extends m {
        public k() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            zn.b bVarX = c1Var.x();
            y yVarX = bVarX.x();
            qm.g gVarA = qm.g.A(bVarX.A());
            y yVarB = gVarA.B();
            h0 h0Var = new h0(new k0(yVarB, qm.b.g(yVarB)), yVarB, gVarA.x(), gVarA.y());
            try {
                gm.z zVar = (gm.z) c1Var.D();
                int i10 = yVarX.C(qn.a.f47518h) ? 64 : 32;
                int i11 = i10 * 2;
                byte[] bArrJ = zVar.J();
                if (bArrJ.length != i11) {
                    throw new IllegalArgumentException("invalid length for GOST3410_2012 public key");
                }
                byte[] bArr = new byte[i11 + 1];
                bArr[0] = 4;
                for (int i12 = 1; i12 <= i10; i12++) {
                    bArr[i12] = bArrJ[i10 - i12];
                    bArr[i12 + i10] = bArrJ[i11 - i12];
                }
                return new m0(h0Var.a().k(bArr), h0Var);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering GOST3410_2012 public key");
            }
        }
    }

    public static class l extends m {
        public l() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) throws IOException {
            pn.z zVarY = pn.z.y(c1Var.D());
            return new e2(false, zVarY.z(), zVarY.A());
        }
    }

    public static abstract class m {
        public m() {
        }

        public abstract np.c a(c1 c1Var, Object obj) throws IOException;
    }

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.n$n, reason: collision with other inner class name */
    public static class C0503n extends m {
        public C0503n() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            return new n2(n.f(c1Var, obj));
        }
    }

    public static class o extends m {
        public o() {
            super();
        }

        @Override // org.bouncycastle.crypto.util.n.m
        public np.c a(c1 c1Var, Object obj) {
            return new q2(n.f(c1Var, obj));
        }
    }

    static {
        HashMap map = new HashMap();
        f44756a = map;
        map.put(pn.s.f46854x3, new l());
        f44756a.put(pn.s.G3, new l());
        f44756a.put(z1.f59124r7, new l());
        f44756a.put(co.r.f11161d1, new c());
        f44756a.put(pn.s.O3, new b());
        f44756a.put(co.r.W0, new d());
        f44756a.put(on.b.f44366j, new d());
        f44756a.put(on.b.f44368l, new i());
        f44756a.put(co.r.f11174l0, new f());
        f44756a.put(qm.a.f47463m, new j());
        f44756a.put(qn.a.f47517g, new k());
        f44756a.put(qn.a.f47518h, new k());
        f44756a.put(vn.g.f53269c, new e());
        f44756a.put(vn.g.f53268b, new e());
        f44756a.put(tm.a.f51338b, new C0503n());
        f44756a.put(tm.a.f51339c, new o());
        f44756a.put(tm.a.f51340d, new g());
        f44756a.put(tm.a.f51341e, new h());
    }

    public static np.c b(InputStream inputStream) throws IOException {
        return c(c1.A(new gm.s(inputStream).n()));
    }

    public static np.c c(c1 c1Var) throws IOException {
        return d(c1Var, null);
    }

    public static np.c d(c1 c1Var, Object obj) throws IOException {
        zn.b bVarX = c1Var.x();
        m mVar = (m) f44756a.get(bVarX.x());
        if (mVar != null) {
            return mVar.a(c1Var, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + bVarX.x());
    }

    public static np.c e(byte[] bArr) throws IOException {
        return c(c1.A(c0.D(bArr)));
    }

    public static byte[] f(c1 c1Var, Object obj) {
        return c1Var.C().L();
    }
}
