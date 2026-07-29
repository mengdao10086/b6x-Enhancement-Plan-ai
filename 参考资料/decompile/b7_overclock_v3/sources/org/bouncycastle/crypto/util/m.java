package org.bouncycastle.crypto.util;

import gm.d2;
import gm.h0;
import gm.t;
import gm.u1;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import np.a0;
import np.e2;
import np.f2;
import np.g0;
import np.k0;
import np.l0;
import np.m2;
import np.o0;
import np.p2;
import np.r0;
import np.z;
import pn.s;
import pn.u;
import pn.x;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f44755a;

    static {
        HashSet hashSet = new HashSet(5);
        f44755a = hashSet;
        hashSet.add(qm.a.f47474x);
        f44755a.add(qm.a.f47475y);
        f44755a.add(qm.a.f47476z);
        f44755a.add(qm.a.A);
        f44755a.add(qm.a.B);
    }

    public static u a(np.c cVar) throws IOException {
        return b(cVar, null);
    }

    public static u b(np.c cVar, h0 h0Var) throws IOException {
        int iBitLength;
        co.j jVar;
        BigInteger bigIntegerE;
        y yVar;
        if (cVar instanceof e2) {
            f2 f2Var = (f2) cVar;
            return new u(new zn.b(s.f46854x3, d2.f29657b), new x(f2Var.e(), f2Var.j(), f2Var.d(), f2Var.i(), f2Var.k(), f2Var.g(), f2Var.h(), f2Var.l()), h0Var);
        }
        if (cVar instanceof a0) {
            a0 a0Var = (a0) cVar;
            z zVarD = a0Var.d();
            return new u(new zn.b(co.r.W0, new zn.s(zVarD.b(), zVarD.c(), zVarD.a())), new t(a0Var.e()), h0Var);
        }
        if (!(cVar instanceof l0)) {
            if (cVar instanceof p2) {
                p2 p2Var = (p2) cVar;
                return new u(new zn.b(tm.a.f51339c), new gm.f2(p2Var.getEncoded()), h0Var, p2Var.e().getEncoded());
            }
            if (cVar instanceof m2) {
                m2 m2Var = (m2) cVar;
                return new u(new zn.b(tm.a.f51338b), new gm.f2(m2Var.getEncoded()), h0Var, m2Var.e().getEncoded());
            }
            if (cVar instanceof r0) {
                r0 r0Var = (r0) cVar;
                return new u(new zn.b(tm.a.f51341e), new gm.f2(r0Var.getEncoded()), h0Var, r0Var.e().getEncoded());
            }
            if (!(cVar instanceof o0)) {
                throw new IOException("key parameters not recognized");
            }
            o0 o0Var = (o0) cVar;
            return new u(new zn.b(tm.a.f51340d), new gm.f2(o0Var.getEncoded()), h0Var, o0Var.e().getEncoded());
        }
        l0 l0Var = (l0) cVar;
        g0 g0VarD = l0Var.d();
        if (g0VarD == null) {
            jVar = new co.j((gm.u) d2.f29657b);
            bigIntegerE = l0Var.e();
        } else {
            if (g0VarD instanceof np.h0) {
                np.h0 h0Var2 = (np.h0) g0VarD;
                qm.g gVar = new qm.g(h0Var2.m(), h0Var2.k(), h0Var2.l());
                if (f44755a.contains(gVar.B())) {
                    yVar = qm.a.f47463m;
                } else {
                    boolean z10 = l0Var.e().bitLength() > 256;
                    y yVar2 = z10 ? qn.a.f47518h : qn.a.f47517g;
                    i = z10 ? 64 : 32;
                    yVar = yVar2;
                }
                byte[] bArr = new byte[i];
                c(bArr, i, 0, l0Var.e());
                return new u(new zn.b(yVar, gVar), new gm.f2(bArr));
            }
            if (!(g0VarD instanceof k0)) {
                co.j jVar2 = new co.j(new co.l(g0VarD.a(), new co.n(g0VarD.b(), false), g0VarD.e(), g0VarD.c(), g0VarD.f()));
                iBitLength = g0VarD.e().bitLength();
                jVar = jVar2;
                return new u(new zn.b(co.r.f11174l0, jVar), new rn.a(iBitLength, l0Var.e(), new u1(new ir.k().a(g0VarD.b(), l0Var.e()).l(false)), jVar), h0Var);
            }
            jVar = new co.j(((k0) g0VarD).j());
            bigIntegerE = g0VarD.e();
        }
        iBitLength = bigIntegerE.bitLength();
        return new u(new zn.b(co.r.f11174l0, jVar), new rn.a(iBitLength, l0Var.e(), new u1(new ir.k().a(g0VarD.b(), l0Var.e()).l(false)), jVar), h0Var);
    }

    public static void c(byte[] bArr, int i10, int i11, BigInteger bigInteger) {
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
