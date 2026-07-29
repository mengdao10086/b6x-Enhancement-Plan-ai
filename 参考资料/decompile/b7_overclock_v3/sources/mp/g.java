package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f41550a = null;

    @Override // mp.a
    public String a() {
        return "X9.23";
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length - 1) {
            SecureRandom secureRandom = this.f41550a;
            if (secureRandom == null) {
                bArr[i10] = 0;
            } else {
                bArr[i10] = (byte) secureRandom.nextInt();
            }
            i10++;
        }
        bArr[i10] = length;
        return length;
    }

    @Override // mp.a
    public int c(byte[] bArr) throws InvalidCipherTextException {
        int i10 = bArr[bArr.length - 1] & 255;
        if (i10 <= bArr.length) {
            return i10;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    @Override // mp.a
    public void d(SecureRandom secureRandom) throws IllegalArgumentException {
        this.f41550a = secureRandom;
    }
}
