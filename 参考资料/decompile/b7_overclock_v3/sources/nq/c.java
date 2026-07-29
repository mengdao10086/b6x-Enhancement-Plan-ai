package nq;

import java.math.BigInteger;
import np.q;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.h;

/* JADX INFO: loaded from: classes7.dex */
public class c {
    public static String a(BigInteger bigInteger, q qVar) {
        return new h(org.bouncycastle.util.a.C(bigInteger.toByteArray(), qVar.f().toByteArray(), qVar.b().toByteArray())).toString();
    }

    public static String b(String str, BigInteger bigInteger, q qVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        BigInteger bigIntegerModPow = qVar.b().modPow(bigInteger, qVar.f());
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(a(bigIntegerModPow, qVar));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("              Y: ");
        stringBuffer.append(bigIntegerModPow.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }

    public static String c(String str, BigInteger bigInteger, q qVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(a(bigInteger, qVar));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("             Y: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
