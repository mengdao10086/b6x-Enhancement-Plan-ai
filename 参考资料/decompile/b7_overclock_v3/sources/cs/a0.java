package cs;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f25876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f25877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25878c = 0;

    public a0(OutputStream outputStream, int i10) {
        this.f25876a = outputStream;
        this.f25877b = new byte[i10];
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25877b);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        int i11 = this.f25878c;
        byte[] bArr = this.f25877b;
        if (i11 != bArr.length) {
            this.f25878c = i11 + 1;
            bArr[i11] = (byte) i10;
            return;
        }
        byte b10 = bArr[0];
        System.arraycopy(bArr, 1, bArr, 0, bArr.length - 1);
        byte[] bArr2 = this.f25877b;
        bArr2[bArr2.length - 1] = (byte) i10;
        this.f25876a.write(b10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        byte[] bArr2 = this.f25877b;
        if (i11 < bArr2.length) {
            for (int i12 = 0; i12 != i11; i12++) {
                write(bArr[i10 + i12]);
            }
        } else {
            this.f25876a.write(bArr2, 0, this.f25878c);
            byte[] bArr3 = this.f25877b;
            this.f25878c = bArr3.length;
            System.arraycopy(bArr, (i10 + i11) - bArr3.length, bArr3, 0, bArr3.length);
            this.f25876a.write(bArr, i10, i11 - this.f25877b.length);
        }
    }
}
