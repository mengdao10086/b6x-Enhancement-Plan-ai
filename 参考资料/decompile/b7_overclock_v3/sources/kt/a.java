package kt;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f39240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f39241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39242c;

    public a(OutputStream outputStream) {
        this.f39240a = outputStream;
        this.f39241b = new byte[4096];
    }

    public a(OutputStream outputStream, int i10) {
        this.f39240a = outputStream;
        this.f39241b = new byte[i10];
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.f39240a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f39240a.write(this.f39241b, 0, this.f39242c);
        this.f39242c = 0;
        org.bouncycastle.util.a.d0(this.f39241b, (byte) 0);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f39241b;
        int i11 = this.f39242c;
        int i12 = i11 + 1;
        this.f39242c = i12;
        bArr[i11] = (byte) i10;
        if (i12 == bArr.length) {
            flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = this.f39241b;
        int length = bArr3.length;
        int i12 = this.f39242c;
        if (i11 < length - i12) {
            System.arraycopy(bArr, i10, bArr3, i12, i11);
        } else {
            int length2 = bArr3.length - i12;
            System.arraycopy(bArr, i10, bArr3, i12, length2);
            this.f39242c += length2;
            flush();
            int length3 = i10 + length2;
            i11 -= length2;
            while (true) {
                bArr2 = this.f39241b;
                if (i11 < bArr2.length) {
                    break;
                }
                this.f39240a.write(bArr, length3, bArr2.length);
                byte[] bArr4 = this.f39241b;
                length3 += bArr4.length;
                i11 -= bArr4.length;
            }
            if (i11 <= 0) {
                return;
            } else {
                System.arraycopy(bArr, length3, bArr2, this.f39242c, i11);
            }
        }
        this.f39242c += i11;
    }
}
