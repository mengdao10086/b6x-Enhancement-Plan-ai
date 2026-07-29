package v4;

import g.n0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class k extends FilterInputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f52690b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f52691c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f52692a;

    public k(@n0 InputStream inputStream) {
        super(inputStream);
        this.f52692a = Integer.MIN_VALUE;
    }

    public final long a(long j10) {
        int i10 = this.f52692a;
        if (i10 == 0) {
            return -1L;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i10 = this.f52692a;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    public final void c(long j10) {
        int i10 = this.f52692a;
        if (i10 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.f52692a = (int) (((long) i10) - j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        super.mark(i10);
        this.f52692a = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i10 = super.read();
        c(1L);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f52692a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long jA = a(j10);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        c(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@n0 byte[] bArr, int i10, int i11) throws IOException {
        int iA = (int) a(i11);
        if (iA == -1) {
            return -1;
        }
        int i12 = super.read(bArr, i10, iA);
        c(i12);
        return i12;
    }
}
