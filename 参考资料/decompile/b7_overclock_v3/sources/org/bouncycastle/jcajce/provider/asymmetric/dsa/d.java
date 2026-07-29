package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import co.r;
import gm.y;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import np.a0;
import np.z;
import org.bouncycastle.util.h;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y[] f44900a = {r.W0, on.b.f44366j, r.X0};

    public static String a(BigInteger bigInteger, DSAParams dSAParams) {
        return new h(org.bouncycastle.util.a.D(bigInteger.toByteArray(), dSAParams.getP().toByteArray(), dSAParams.getQ().toByteArray(), dSAParams.getG().toByteArray())).toString();
    }

    public static np.c b(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof DSAPrivateKey)) {
            throw new InvalidKeyException("can't identify DSA private key.");
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) privateKey;
        return new a0(dSAPrivateKey.getX(), new z(dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG()));
    }

    public static np.c c(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCDSAPublicKey) {
            return ((BCDSAPublicKey) publicKey).a();
        }
        if (publicKey instanceof DSAPublicKey) {
            return new BCDSAPublicKey((DSAPublicKey) publicKey).a();
        }
        try {
            return new BCDSAPublicKey(c1.A(publicKey.getEncoded())).a();
        } catch (Exception unused) {
            throw new InvalidKeyException("can't identify DSA public key: " + publicKey.getClass().getName());
        }
    }

    public static boolean d(y yVar) {
        int i10 = 0;
        while (true) {
            y[] yVarArr = f44900a;
            if (i10 == yVarArr.length) {
                return false;
            }
            if (yVar.C(yVarArr[i10])) {
                return true;
            }
            i10++;
        }
    }

    public static z e(DSAParams dSAParams) {
        if (dSAParams != null) {
            return new z(dSAParams.getP(), dSAParams.getQ(), dSAParams.getG());
        }
        return null;
    }
}
