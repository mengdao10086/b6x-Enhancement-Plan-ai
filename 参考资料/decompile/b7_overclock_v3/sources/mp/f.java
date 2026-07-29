package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class f implements a {
    @Override // mp.a
    public String a() {
        return "TBC";
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        int i11 = 255;
        if (i10 <= 0 ? (bArr[bArr.length - 1] & 1) != 0 : (bArr[i10 - 1] & 1) != 0) {
            i11 = 0;
        }
        byte b10 = (byte) i11;
        while (i10 < bArr.length) {
            bArr[i10] = b10;
            i10++;
        }
        return length;
    }

    @Override // mp.a
    public int c(byte[] bArr) throws InvalidCipherTextException {
        byte b10 = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        while (length > 0 && bArr[length - 1] == b10) {
            length--;
        }
        return bArr.length - length;
    }

    @Override // mp.a
    public void d(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
