package gm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a2 extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29638d;

    public a2(OutputStream outputStream) {
        super(outputStream);
        this.f29636b = false;
    }

    public a2(OutputStream outputStream, int i10, boolean z10) {
        super(outputStream);
        this.f29636b = true;
        this.f29637c = z10;
        this.f29638d = i10;
    }

    public void b(int i10, byte[] bArr) throws IOException {
        if (!this.f29636b) {
            c(this.f29761a, i10, bArr);
            return;
        }
        int i11 = this.f29638d;
        int i12 = i11 | 128;
        if (this.f29637c) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            c(byteArrayOutputStream, i10, bArr);
            c(this.f29761a, i11 | 32 | 128, byteArrayOutputStream.toByteArray());
            return;
        }
        if ((i10 & 32) != 0) {
            c(this.f29761a, i12 | 32, bArr);
        } else {
            c(this.f29761a, i12, bArr);
        }
    }

    public void c(OutputStream outputStream, int i10, byte[] bArr) throws IOException {
        outputStream.write(i10);
        d(outputStream, bArr.length);
        outputStream.write(bArr);
    }

    public final void d(OutputStream outputStream, int i10) throws IOException {
        if (i10 <= 127) {
            outputStream.write((byte) i10);
            return;
        }
        int i11 = i10;
        int i12 = 1;
        while (true) {
            i11 >>>= 8;
            if (i11 == 0) {
                break;
            } else {
                i12++;
            }
        }
        outputStream.write((byte) (i12 | 128));
        for (int i13 = (i12 - 1) * 8; i13 >= 0; i13 -= 8) {
            outputStream.write((byte) (i10 >> i13));
        }
    }
}
