package gp;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f29913a;

    public c(InputStream inputStream, s sVar) {
        super(inputStream);
        this.f29913a = sVar;
    }

    public s a() {
        return this.f29913a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 >= 0) {
            this.f29913a.update((byte) i10);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (i12 > 0) {
            this.f29913a.update(bArr, i10, i12);
        }
        return i12;
    }
}
