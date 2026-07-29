package gp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f29916a;

    public f(a0 a0Var) {
        this.f29916a = a0Var;
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f29916a.d()];
        this.f29916a.c(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f29916a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f29916a.update(bArr, i10, i11);
    }
}
