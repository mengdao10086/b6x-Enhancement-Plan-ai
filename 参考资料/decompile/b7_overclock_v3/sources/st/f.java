package st;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class f extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f50521a;

    public f(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.f50521a = outputStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 > 0) {
            this.f50521a.write(i10);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("Unsupported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (i12 > 0) {
            this.f50521a.write(bArr, i10, i12);
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
