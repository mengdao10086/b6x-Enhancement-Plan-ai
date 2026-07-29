package ds;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes6.dex */
public class t extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f26504a;

    public t(e0 e0Var) {
        this.f26504a = e0Var;
    }

    public byte[] a() throws CryptoException {
        return this.f26504a.e();
    }

    public boolean c(byte[] bArr) {
        return this.f26504a.d(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f26504a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f26504a.update(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f26504a.update(bArr, i10, i11);
    }
}
