package mp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public interface a {
    String a();

    int b(byte[] bArr, int i10);

    int c(byte[] bArr) throws InvalidCipherTextException;

    void d(SecureRandom secureRandom) throws IllegalArgumentException;
}
