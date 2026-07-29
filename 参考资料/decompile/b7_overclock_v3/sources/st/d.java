package st;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes6.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f50515b;

    public d(InputStream inputStream, int i10) {
        this.f50515b = inputStream;
        this.f50514a = i10;
    }

    public static GZIPInputStream a(InputStream inputStream, int i10) throws IOException {
        return new GZIPInputStream(new d(inputStream, i10));
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return Math.min(this.f50515b.available(), this.f50514a);
    }

    public int c() {
        return this.f50514a;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f50514a <= 0) {
            return -1;
        }
        int i10 = this.f50515b.read();
        if (i10 != -1) {
            this.f50514a--;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return 0L;
        }
        long jSkip = this.f50515b.skip(Math.min(this.f50514a, j10));
        if (jSkip > 0) {
            this.f50514a = (int) (((long) this.f50514a) - jSkip);
        }
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f50514a;
        if (i12 <= 0) {
            return -1;
        }
        int i13 = this.f50515b.read(bArr, i10, Math.min(i12, i11));
        if (i13 > 0) {
            this.f50514a -= i13;
        }
        return i13;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
