package lq;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes7.dex */
public class g extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Signature f40124a;

    public g(Signature signature) {
        this.f40124a = signature;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        try {
            this.f40124a.update((byte) i10);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.f40124a.update(bArr);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        try {
            this.f40124a.update(bArr, i10, i11);
        } catch (SignatureException e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
