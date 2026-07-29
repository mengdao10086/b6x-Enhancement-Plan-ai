package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements a {
    @Override // mp.a
    public String a() {
        return "ISO7816-4";
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        bArr[i10] = -128;
        while (true) {
            i10++;
            if (i10 >= bArr.length) {
                return length;
            }
            bArr[i10] = 0;
        }
    }

    @Override // mp.a
    public int c(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length - 1;
        while (length > 0 && bArr[length] == 0) {
            length--;
        }
        if (bArr[length] == -128) {
            return bArr.length - length;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    @Override // mp.a
    public void d(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
