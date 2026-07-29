package pq;

import com.blankj.utilcode.util.i0;
import np.n2;
import np.p0;
import np.q2;
import np.s0;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.h;

/* JADX INFO: loaded from: classes7.dex */
public class e {
    public static String a(byte[] bArr) {
        return new h(bArr).toString();
    }

    public static boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return !b(bArr, bArr);
        }
        int i10 = 0;
        for (int i11 = 0; i11 != bArr.length; i11++) {
            i10 |= bArr[i11] ^ bArr2[i11];
        }
        return i10 == 0;
    }

    public static String c(String str, String str2, np.c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        byte[] encoded = cVar instanceof q2 ? ((q2) cVar).getEncoded() : cVar instanceof s0 ? ((s0) cVar).getEncoded() : cVar instanceof n2 ? ((n2) cVar).getEncoded() : ((p0) cVar).getEncoded();
        stringBuffer.append(str2);
        stringBuffer.append(i0.f11861z);
        stringBuffer.append(str);
        stringBuffer.append(" [");
        stringBuffer.append(a(encoded));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("    public data: ");
        stringBuffer.append(jt.h.j(encoded));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
