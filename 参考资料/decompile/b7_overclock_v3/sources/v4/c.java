package v4;

import android.text.TextUtils;
import android.util.Log;
import g.n0;
import g.p0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52668c = "ContentLengthStream";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f52669d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f52670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f52671b;

    public c(@n0 InputStream inputStream, long j10) {
        super(inputStream);
        this.f52670a = j10;
    }

    @n0
    public static InputStream c(@n0 InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    @n0
    public static InputStream d(@n0 InputStream inputStream, @p0 String str) {
        return c(inputStream, f(str));
    }

    public static int f(@p0 String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable(f52668c, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to parse content length header: ");
                    sb2.append(str);
                }
            }
        }
        return -1;
    }

    public final int a(int i10) throws IOException {
        if (i10 >= 0) {
            this.f52671b += i10;
        } else if (this.f52670a - ((long) this.f52671b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f52670a + ", but read: " + this.f52671b);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f52670a - ((long) this.f52671b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i10;
        i10 = super.read();
        a(i10 >= 0 ? 1 : -1);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return a(super.read(bArr, i10, i11));
    }
}
