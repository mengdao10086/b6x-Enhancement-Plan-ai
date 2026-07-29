package op;

import java.io.IOException;
import java.io.InputStream;
import np.c;
import np.g0;
import np.m0;
import org.bouncycastle.crypto.z;

/* JADX INFO: loaded from: classes5.dex */
public class b implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f44387a;

    public b(g0 g0Var) {
        this.f44387a = g0Var;
    }

    @Override // org.bouncycastle.crypto.z
    public c a(InputStream inputStream) throws IOException {
        byte[] bArr;
        int i10 = inputStream.read();
        if (i10 == 0) {
            throw new IOException("Sender's public key invalid.");
        }
        if (i10 == 2 || i10 == 3) {
            bArr = new byte[((this.f44387a.a().v() + 7) / 8) + 1];
        } else {
            if (i10 != 4 && i10 != 6 && i10 != 7) {
                throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(i10, 16));
            }
            bArr = new byte[(((this.f44387a.a().v() + 7) / 8) * 2) + 1];
        }
        bArr[0] = (byte) i10;
        kt.c.h(inputStream, bArr, 1, bArr.length - 1);
        return new m0(this.f44387a.a().k(bArr), this.f44387a);
    }
}
