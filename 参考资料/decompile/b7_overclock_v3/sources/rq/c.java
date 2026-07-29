package rq;

import java.math.BigInteger;
import np.b1;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.h;

/* JADX INFO: loaded from: classes7.dex */
public class c {
    public static String a(BigInteger bigInteger, b1 b1Var) {
        return new h(org.bouncycastle.util.a.C(bigInteger.toByteArray(), b1Var.b().toByteArray(), b1Var.a().toByteArray())).toString();
    }

    public static String b(String str, BigInteger bigInteger, b1 b1Var) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        BigInteger bigIntegerModPow = b1Var.a().modPow(bigInteger, b1Var.b());
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(a(bigIntegerModPow, b1Var));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("                  Y: ");
        stringBuffer.append(bigIntegerModPow.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }

    public static String c(String str, BigInteger bigInteger, b1 b1Var) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(a(bigInteger, b1Var));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("                 Y: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
