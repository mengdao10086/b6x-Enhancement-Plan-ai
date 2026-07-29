package org.bouncycastle.crypto.util;

import gm.d2;
import gm.f2;
import gm.t;
import gm.u;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import np.b0;
import np.e2;
import np.g0;
import np.h0;
import np.k0;
import np.m0;
import np.n2;
import np.p0;
import np.q2;
import np.s0;
import pn.s;
import pn.z;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f44768a;

    static {
        HashSet hashSet = new HashSet(5);
        f44768a = hashSet;
        hashSet.add(qm.a.f47474x);
        f44768a.add(qm.a.f47475y);
        f44768a.add(qm.a.f47476z);
        f44768a.add(qm.a.A);
        f44768a.add(qm.a.B);
    }

    public static c1 a(np.c cVar) throws IOException {
        co.j jVar;
        y yVar;
        if (cVar instanceof e2) {
            e2 e2Var = (e2) cVar;
            return new c1(new zn.b(s.f46854x3, d2.f29657b), new z(e2Var.e(), e2Var.d()));
        }
        if (cVar instanceof b0) {
            b0 b0Var = (b0) cVar;
            np.z zVarD = b0Var.d();
            return new c1(new zn.b(co.r.W0, zVarD != null ? new zn.s(zVarD.b(), zVarD.c(), zVarD.a()) : null), new t(b0Var.e()));
        }
        if (!(cVar instanceof m0)) {
            if (cVar instanceof q2) {
                return new c1(new zn.b(tm.a.f51339c), ((q2) cVar).getEncoded());
            }
            if (cVar instanceof n2) {
                return new c1(new zn.b(tm.a.f51338b), ((n2) cVar).getEncoded());
            }
            if (cVar instanceof s0) {
                return new c1(new zn.b(tm.a.f51341e), ((s0) cVar).getEncoded());
            }
            if (cVar instanceof p0) {
                return new c1(new zn.b(tm.a.f51340d), ((p0) cVar).getEncoded());
            }
            throw new IOException("key parameters not recognized");
        }
        m0 m0Var = (m0) cVar;
        g0 g0VarD = m0Var.d();
        if (g0VarD == null) {
            jVar = new co.j((u) d2.f29657b);
        } else {
            if (g0VarD instanceof h0) {
                h0 h0Var = (h0) g0VarD;
                BigInteger bigIntegerV = m0Var.e().f().v();
                BigInteger bigIntegerV2 = m0Var.e().g().v();
                qm.g gVar = new qm.g(h0Var.m(), h0Var.k());
                int i10 = 32;
                int i11 = 64;
                if (f44768a.contains(h0Var.m())) {
                    yVar = qm.a.f47463m;
                } else {
                    if (bigIntegerV.bitLength() > 256) {
                        yVar = qn.a.f47518h;
                        i10 = 64;
                        i11 = 128;
                    } else {
                        yVar = qn.a.f47517g;
                    }
                }
                byte[] bArr = new byte[i11];
                int i12 = i11 / 2;
                b(bArr, i12, 0, bigIntegerV);
                b(bArr, i12, i10, bigIntegerV2);
                try {
                    return new c1(new zn.b(yVar, gVar), new f2(bArr));
                } catch (IOException unused) {
                    return null;
                }
            }
            jVar = g0VarD instanceof k0 ? new co.j(((k0) g0VarD).j()) : new co.j(new co.l(g0VarD.a(), new co.n(g0VarD.b(), false), g0VarD.e(), g0VarD.c(), g0VarD.f()));
        }
        return new c1(new zn.b(co.r.f11174l0, jVar), m0Var.e().l(false));
    }

    public static void b(byte[] bArr, int i10, int i11, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(byteArray, 0, bArr2, i10 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i12 = 0; i12 != i10; i12++) {
            bArr[i11 + i12] = byteArray[(byteArray.length - 1) - i12];
        }
    }
}
