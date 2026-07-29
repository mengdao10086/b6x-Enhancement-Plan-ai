package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes5.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f41548a;

    @Override // mp.a
    public String a() {
        return "ISO10126-2";
    }

    @Override // mp.a
    public int b(byte[] bArr, int i10) {
        byte length = (byte) (bArr.length - i10);
        while (i10 < bArr.length - 1) {
            bArr[i10] = (byte) this.f41548a.nextInt();
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
        this.f41548a = n.g(secureRandom);
    }
}
