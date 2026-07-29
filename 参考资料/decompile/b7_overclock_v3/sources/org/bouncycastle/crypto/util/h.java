package org.bouncycastle.crypto.util;

import gm.y;
import java.io.IOException;
import np.b0;
import np.e2;
import np.k0;
import np.m0;
import np.p0;
import np.z;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44738a = "ssh-rsa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f44739b = "ecdsa";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f44740c = "ssh-ed25519";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f44741d = "ssh-dss";

    public static byte[] a(np.c cVar) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("cipherParameters was null.");
        }
        if (cVar instanceof e2) {
            if (cVar.c()) {
                throw new IllegalArgumentException("RSAKeyParamaters was for encryption");
            }
            e2 e2Var = (e2) cVar;
            p pVar = new p();
            pVar.h(f44738a);
            pVar.e(e2Var.d());
            pVar.e(e2Var.e());
            return pVar.a();
        }
        if (cVar instanceof m0) {
            p pVar2 = new p();
            m0 m0Var = (m0) cVar;
            String strE = SSHNamedCurves.e(m0Var.d());
            if (strE == null) {
                throw new IllegalArgumentException("unable to derive ssh curve name for " + m0Var.d().a().getClass().getName());
            }
            pVar2.h("ecdsa-sha2-" + strE);
            pVar2.h(strE);
            pVar2.f(m0Var.e().l(false));
            return pVar2.a();
        }
        if (cVar instanceof b0) {
            b0 b0Var = (b0) cVar;
            z zVarD = b0Var.d();
            p pVar3 = new p();
            pVar3.h(f44741d);
            pVar3.e(zVarD.b());
            pVar3.e(zVarD.c());
            pVar3.e(zVarD.a());
            pVar3.e(b0Var.e());
            return pVar3.a();
        }
        if (cVar instanceof p0) {
            p pVar4 = new p();
            pVar4.h(f44740c);
            pVar4.f(((p0) cVar).getEncoded());
            return pVar4.a();
        }
        throw new IllegalArgumentException("unable to convert " + cVar.getClass().getName() + " to private key");
    }

    public static np.c b(o oVar) {
        np.c p0Var;
        np.c m0Var;
        String strG = oVar.g();
        if (f44738a.equals(strG)) {
            p0Var = new e2(false, oVar.c(), oVar.c());
        } else {
            if (f44741d.equals(strG)) {
                m0Var = new b0(oVar.c(), new z(oVar.c(), oVar.c(), oVar.c()));
            } else if (strG.startsWith(f44739b)) {
                String strG2 = oVar.g();
                y yVarB = SSHNamedCurves.b(strG2);
                co.l lVarF = SSHNamedCurves.f(yVarB);
                if (lVarF == null) {
                    throw new IllegalStateException("unable to find curve for " + strG + " using curve name " + strG2);
                }
                m0Var = new m0(lVarF.y().k(oVar.d()), new k0(yVarB, lVarF));
            } else if (f44740c.equals(strG)) {
                byte[] bArrD = oVar.d();
                if (bArrD.length != 32) {
                    throw new IllegalStateException("public key value of wrong length");
                }
                p0Var = new p0(bArrD, 0);
            } else {
                p0Var = null;
            }
            p0Var = m0Var;
        }
        if (p0Var == null) {
            throw new IllegalArgumentException("unable to parse key");
        }
        if (oVar.b()) {
            throw new IllegalArgumentException("decoded key has trailing data");
        }
        return p0Var;
    }

    public static np.c c(byte[] bArr) {
        return b(new o(bArr));
    }
}
