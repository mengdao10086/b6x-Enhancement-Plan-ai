package co;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class q {
    public int a(ir.e eVar) {
        return (eVar.v() + 7) / 8;
    }

    public int b(ir.f fVar) {
        return (fVar.g() + 7) / 8;
    }

    public byte[] c(BigInteger bigInteger, int i10) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i10 < byteArray.length) {
            byte[] bArr = new byte[i10];
            System.arraycopy(byteArray, byteArray.length - i10, bArr, 0, i10);
            return bArr;
        }
        if (i10 <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(byteArray, 0, bArr2, i10 - byteArray.length, byteArray.length);
        return bArr2;
    }
}
