package kt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f39244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f39245b;

    public d(InputStream inputStream, OutputStream outputStream) {
        this.f39244a = inputStream;
        this.f39245b = outputStream;
    }

    public OutputStream a() {
        return this.f39245b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f39244a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f39244a.close();
        this.f39245b.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i10 = this.f39244a.read();
        if (i10 >= 0) {
            this.f39245b.write(i10);
        }
        return i10;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f39244a.read(bArr, i10, i11);
        if (i12 > 0) {
            this.f39245b.write(bArr, i10, i12);
        }
        return i12;
    }
}
