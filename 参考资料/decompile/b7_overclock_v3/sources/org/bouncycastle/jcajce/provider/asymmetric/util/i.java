package org.bouncycastle.jcajce.provider.asymmetric.util;

import gm.y;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;
import np.g0;
import np.k0;
import np.l0;
import np.m0;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Strings;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class i {

    public static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlgorithmParameterSpec f45057a;

        public a(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f45057a = algorithmParameterSpec;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return this.f45057a.getClass().getMethod("getName", new Class[0]).invoke(this.f45057a, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static int[] a(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else {
            if (iArr.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
                iArr2[0] = iArr[0];
                if (iArr[1] < iArr[2]) {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[1];
                }
            } else if (iArr[1] < iArr[2]) {
                iArr2[0] = iArr[1];
                if (iArr[0] < iArr[2]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[0];
                }
            } else {
                iArr2[0] = iArr[2];
                if (iArr[0] < iArr[1]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[1];
                } else {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[0];
                }
            }
        }
        return iArr2;
    }

    public static String b(ir.i iVar, gr.e eVar) {
        ir.e eVarA = eVar.a();
        return eVarA != null ? new org.bouncycastle.util.h(org.bouncycastle.util.a.D(iVar.l(false), eVarA.o().e(), eVarA.q().e(), eVar.b().l(false))).toString() : new org.bouncycastle.util.h(iVar.l(false)).toString();
    }

    public static np.c c(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            gr.e eVarB = eCPrivateKey.b();
            if (eVarB == null) {
                eVarB = BouncyCastleProvider.f45330c.b();
            }
            if (!(eCPrivateKey.b() instanceof gr.c)) {
                return new l0(eCPrivateKey.f0(), new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e()));
            }
            return new l0(eCPrivateKey.f0(), new k0(co.e.f(((gr.c) eCPrivateKey.b()).f()), eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e()));
        }
        if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            gr.e eVarG = h.g(eCPrivateKey2.getParams());
            return new l0(eCPrivateKey2.getS(), new g0(eVarG.a(), eVarG.b(), eVarG.d(), eVarG.c(), eVarG.e()));
        }
        try {
            byte[] encoded = privateKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC private key");
            }
            PrivateKey privateKeyO = BouncyCastleProvider.o(u.z(encoded));
            if (privateKeyO instanceof java.security.interfaces.ECPrivateKey) {
                return c(privateKeyO);
            }
            throw new InvalidKeyException("can't identify EC private key.");
        } catch (Exception e10) {
            throw new InvalidKeyException("cannot identify EC private key: " + e10.toString());
        }
    }

    public static np.c d(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            gr.e eVarB = eCPublicKey.b();
            return new m0(eCPublicKey.J0(), new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e()));
        }
        if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            gr.e eVarG = h.g(eCPublicKey2.getParams());
            return new m0(h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), new g0(eVarG.a(), eVarG.b(), eVarG.d(), eVarG.c(), eVarG.e()));
        }
        try {
            byte[] encoded = publicKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC public key");
            }
            PublicKey publicKeyP = BouncyCastleProvider.p(c1.A(encoded));
            if (publicKeyP instanceof java.security.interfaces.ECPublicKey) {
                return d(publicKeyP);
            }
            throw new InvalidKeyException("cannot identify EC public key.");
        } catch (Exception e10) {
            throw new InvalidKeyException("cannot identify EC public key: " + e10.toString());
        }
    }

    public static String e(y yVar) {
        return co.e.d(yVar);
    }

    public static g0 f(uq.c cVar, co.j jVar) {
        g0 g0Var;
        if (jVar.B()) {
            y yVarN = y.N(jVar.z());
            co.l lVarJ = j(yVarN);
            if (lVarJ == null) {
                lVarJ = (co.l) cVar.a().get(yVarN);
            }
            return new k0(yVarN, lVarJ);
        }
        if (jVar.A()) {
            gr.e eVarB = cVar.b();
            g0Var = new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e());
        } else {
            co.l lVarD = co.l.D(jVar.z());
            g0Var = new g0(lVarD.y(), lVarD.B(), lVarD.E(), lVarD.C(), lVarD.F());
        }
        return g0Var;
    }

    public static g0 g(uq.c cVar, gr.e eVar) {
        if (eVar instanceof gr.c) {
            gr.c cVar2 = (gr.c) eVar;
            return new k0(l(cVar2.f()), cVar2.a(), cVar2.b(), cVar2.d(), cVar2.c(), cVar2.e());
        }
        if (eVar != null) {
            return new g0(eVar.a(), eVar.b(), eVar.d(), eVar.c(), eVar.e());
        }
        gr.e eVarB = cVar.b();
        return new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c(), eVarB.e());
    }

    public static String h(AlgorithmParameterSpec algorithmParameterSpec) {
        return (String) AccessController.doPrivileged(new a(algorithmParameterSpec));
    }

    public static co.l i(String str) {
        co.l lVarJ = ap.a.j(str);
        return lVarJ == null ? co.e.b(str) : lVarJ;
    }

    public static co.l j(y yVar) {
        co.l lVarK = ap.a.k(yVar);
        return lVarK == null ? co.e.c(yVar) : lVarK;
    }

    public static y k(gr.e eVar) {
        Enumeration enumerationE = co.e.e();
        while (enumerationE.hasMoreElements()) {
            String str = (String) enumerationE.nextElement();
            co.l lVarB = co.e.b(str);
            if (lVarB.E().equals(eVar.d()) && lVarB.C().equals(eVar.c()) && lVarB.y().m(eVar.a()) && lVarB.B().e(eVar.b())) {
                return co.e.f(str);
            }
        }
        return null;
    }

    public static y l(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int iIndexOf = str.indexOf(32);
        if (iIndexOf > 0) {
            str = str.substring(iIndexOf + 1);
        }
        y yVarM = m(str);
        return yVarM != null ? yVarM : co.e.f(str);
    }

    public static y m(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt < '0' || cCharAt > '2') {
            return null;
        }
        try {
            return new y(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int n(uq.c cVar, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        gr.e eVarB = cVar.b();
        return eVarB == null ? bigInteger2.bitLength() : eVarB.d().bitLength();
    }

    public static String o(String str, BigInteger bigInteger, gr.e eVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        ir.i iVarB = new ir.k().a(eVar.b(), bigInteger).B();
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(b(iVarB, eVar));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("            X: ");
        stringBuffer.append(iVarB.f().v().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("            Y: ");
        stringBuffer.append(iVarB.g().v().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }

    public static String p(String str, ir.i iVar, gr.e eVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(b(iVar, eVar));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("            X: ");
        stringBuffer.append(iVar.f().v().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("            Y: ");
        stringBuffer.append(iVar.g().v().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
