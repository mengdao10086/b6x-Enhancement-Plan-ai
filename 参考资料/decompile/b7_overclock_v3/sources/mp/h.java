package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class h implements a {
    @Override // mp.a
    public String a() {
        return "ZeroByte";
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        while (i10 < bArr.length) {
            bArr[i10] = 0;
            i10++;
        }
        return length;
    }

    @Override // mp.a
    public int c(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        while (length > 0 && bArr[length - 1] == 0) {
            length--;
        }
        return bArr.length - length;
    }

    @Override // mp.a
    public void d(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
