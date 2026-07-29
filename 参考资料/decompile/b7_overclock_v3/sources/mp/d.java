package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import zr.i;

/* JADX INFO: loaded from: classes5.dex */
public class d implements a {
    @Override // mp.a
    public String a() {
        return i.f59664j;
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length) {
            bArr[i10] = length;
            i10++;
        }
        return length;
    }

    @Override // mp.a
    public int c(byte[] bArr) throws InvalidCipherTextException {
        int i10 = bArr[bArr.length - 1] & 255;
        byte b10 = (byte) i10;
        boolean z10 = (i10 > bArr.length) | (i10 == 0);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            z10 |= (bArr.length - i11 <= i10) & (bArr[i11] != b10);
        }
        if (z10) {
            throw new InvalidCipherTextException("pad block corrupted");
        }
        return i10;
    }

    @Override // mp.a
    public void d(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
