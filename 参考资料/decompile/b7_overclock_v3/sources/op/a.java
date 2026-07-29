package op;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import np.c;
import np.q;
import np.s;
import org.bouncycastle.crypto.z;

/* JADX INFO: loaded from: classes5.dex */
public class a implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f44386a;

    public a(q qVar) {
        this.f44386a = qVar;
    }

    @Override // org.bouncycastle.crypto.z
    public c a(InputStream inputStream) throws IOException {
        int iBitLength = (this.f44386a.f().bitLength() + 7) / 8;
        byte[] bArr = new byte[iBitLength];
        kt.c.h(inputStream, bArr, 0, iBitLength);
        return new s(new BigInteger(1, bArr), this.f44386a);
    }
}
