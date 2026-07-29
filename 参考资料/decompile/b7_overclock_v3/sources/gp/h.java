package gp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class h extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f29918a;

    public h(e0 e0Var) {
        this.f29918a = e0Var;
    }

    public e0 a() {
        return this.f29918a;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f29918a.update((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f29918a.update(bArr, i10, i11);
    }
}
