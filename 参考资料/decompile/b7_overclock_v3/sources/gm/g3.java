package gm;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class g3 extends l3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f29693e = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29695d;

    public g3(InputStream inputStream, int i10, int i11) {
        super(inputStream, i11);
        if (i10 <= 0) {
            if (i10 < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            c(true);
        }
        this.f29694c = i10;
        this.f29695d = i10;
    }

    public int d() {
        return this.f29695d;
    }

    public void f(byte[] bArr) throws IOException {
        int i10 = this.f29695d;
        if (i10 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i10 == 0) {
            return;
        }
        int iA = a();
        int i11 = this.f29695d;
        if (i11 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f29695d + " >= " + iA);
        }
        int iH = i11 - kt.c.h(this.f29738a, bArr, 0, bArr.length);
        this.f29695d = iH;
        if (iH == 0) {
            c(true);
            return;
        }
        throw new EOFException("DEF length " + this.f29694c + " object truncated by " + this.f29695d);
    }

    public byte[] h() throws IOException {
        if (this.f29695d == 0) {
            return f29693e;
        }
        int iA = a();
        int i10 = this.f29695d;
        if (i10 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f29695d + " >= " + iA);
        }
        byte[] bArr = new byte[i10];
        int iH = i10 - kt.c.h(this.f29738a, bArr, 0, i10);
        this.f29695d = iH;
        if (iH == 0) {
            c(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.f29694c + " object truncated by " + this.f29695d);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f29695d == 0) {
            return -1;
        }
        int i10 = this.f29738a.read();
        if (i10 >= 0) {
            int i11 = this.f29695d - 1;
            this.f29695d = i11;
            if (i11 == 0) {
                c(true);
            }
            return i10;
        }
        throw new EOFException("DEF length " + this.f29694c + " object truncated by " + this.f29695d);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f29695d;
        if (i12 == 0) {
            return -1;
        }
        int i13 = this.f29738a.read(bArr, i10, Math.min(i11, i12));
        if (i13 >= 0) {
            int i14 = this.f29695d - i13;
            this.f29695d = i14;
            if (i14 == 0) {
                c(true);
            }
            return i13;
        }
        throw new EOFException("DEF length " + this.f29694c + " object truncated by " + this.f29695d);
    }
}
