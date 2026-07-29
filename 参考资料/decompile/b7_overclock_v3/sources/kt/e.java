package kt;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f39246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OutputStream f39247b;

    public e(OutputStream outputStream, OutputStream outputStream2) {
        this.f39246a = outputStream;
        this.f39247b = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f39246a.close();
        this.f39247b.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f39246a.flush();
        this.f39247b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f39246a.write(i10);
        this.f39247b.write(i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f39246a.write(bArr);
        this.f39247b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f39246a.write(bArr, i10, i11);
        this.f39247b.write(bArr, i10, i11);
    }
}
