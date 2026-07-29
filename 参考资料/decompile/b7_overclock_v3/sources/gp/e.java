package gp;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class e extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f29915a;

    public e(InputStream inputStream, a0 a0Var) {
        super(inputStream);
        this.f29915a = a0Var;
    }

    public a0 a() {
        return this.f29915a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 >= 0) {
            this.f29915a.update((byte) i10);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (i12 >= 0) {
            this.f29915a.update(bArr, i10, i12);
        }
        return i12;
    }
}
