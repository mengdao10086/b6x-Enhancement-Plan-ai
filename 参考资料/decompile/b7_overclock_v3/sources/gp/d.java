package gp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class d extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f29914a;

    public d(s sVar) {
        this.f29914a = sVar;
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f29914a.h()];
        this.f29914a.c(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f29914a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f29914a.update(bArr, i10, i11);
    }
}
