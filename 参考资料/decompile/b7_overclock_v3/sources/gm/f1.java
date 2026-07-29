package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class f1 extends d1 {

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f29684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f29685b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h2 f29686c;

        public a(byte[] bArr) {
            this.f29684a = bArr;
            this.f29686c = new h2(f1.this.f29761a);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i10 = this.f29685b;
            if (i10 != 0) {
                f2.L(this.f29686c, true, this.f29684a, 0, i10);
            }
            this.f29686c.e();
            f1.this.b();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            byte[] bArr = this.f29684a;
            int i11 = this.f29685b;
            int i12 = i11 + 1;
            this.f29685b = i12;
            bArr[i11] = (byte) i10;
            if (i12 == bArr.length) {
                f2.L(this.f29686c, true, bArr, 0, bArr.length);
                this.f29685b = 0;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            int i12;
            byte[] bArr2 = this.f29684a;
            int length = bArr2.length;
            int i13 = this.f29685b;
            int i14 = length - i13;
            if (i11 < i14) {
                System.arraycopy(bArr, i10, bArr2, i13, i11);
                this.f29685b += i11;
                return;
            }
            if (i13 > 0) {
                System.arraycopy(bArr, i10, bArr2, i13, i14);
                i12 = i14 + 0;
                f2.L(this.f29686c, true, this.f29684a, 0, length);
            } else {
                i12 = 0;
            }
            while (true) {
                int i15 = i11 - i12;
                if (i15 < length) {
                    System.arraycopy(bArr, i10 + i12, this.f29684a, 0, i15);
                    this.f29685b = i15;
                    return;
                } else {
                    f2.L(this.f29686c, true, bArr, i10 + i12, length);
                    i12 += length;
                }
            }
        }
    }

    public f1(OutputStream outputStream) throws IOException {
        super(outputStream);
        c(36);
    }

    public f1(OutputStream outputStream, int i10, boolean z10) throws IOException {
        super(outputStream, i10, z10);
        c(36);
    }

    public OutputStream e() {
        return f(new byte[1000]);
    }

    public OutputStream f(byte[] bArr) {
        return new a(bArr);
    }
}
