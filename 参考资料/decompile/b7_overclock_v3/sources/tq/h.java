package tq;

import gm.y;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import np.e2;
import np.f2;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y[] f51609a = {s.f46854x3, z1.f59124r7, s.D3, s.G3};

    public static String a(BigInteger bigInteger) {
        return new org.bouncycastle.util.h(bigInteger.toByteArray(), 32).toString();
    }

    public static String b(BigInteger bigInteger) {
        return new org.bouncycastle.util.h(bigInteger.toByteArray()).toString();
    }

    public static e2 c(RSAPrivateKey rSAPrivateKey) {
        if (rSAPrivateKey instanceof BCRSAPrivateKey) {
            return ((BCRSAPrivateKey) rSAPrivateKey).a();
        }
        if (!(rSAPrivateKey instanceof RSAPrivateCrtKey)) {
            return new e2(true, rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rSAPrivateKey;
        return new f2(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
    }

    public static e2 d(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey instanceof BCRSAPublicKey ? ((BCRSAPublicKey) rSAPublicKey).a() : new e2(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }

    public static boolean e(y yVar) {
        int i10 = 0;
        while (true) {
            y[] yVarArr = f51609a;
            if (i10 == yVarArr.length) {
                return false;
            }
            if (yVar.C(yVarArr[i10])) {
                return true;
            }
            i10++;
        }
    }
}
