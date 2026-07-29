package tr;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okio.w0;

/* JADX INFO: loaded from: classes6.dex */
public class a extends InputStream {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f51611d = new byte[128];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f51612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f51613b = new int[3];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51614c = 3;

    static {
        for (int i10 = 65; i10 <= 90; i10++) {
            f51611d[i10] = (byte) (i10 - 65);
        }
        for (int i11 = 97; i11 <= 122; i11++) {
            f51611d[i11] = (byte) ((i11 - 97) + 26);
        }
        for (int i12 = 48; i12 <= 57; i12++) {
            f51611d[i12] = (byte) ((i12 - 48) + 52);
        }
        byte[] bArr = f51611d;
        bArr[43] = 62;
        bArr[47] = w0.f44229a;
    }

    public a(InputStream inputStream) {
        this.f51612a = inputStream;
    }

    public final int a(int i10, int i11, int i12, int i13, int[] iArr) throws EOFException {
        if (i13 < 0) {
            throw new EOFException("unexpected end of file in armored stream.");
        }
        if (i12 == 61) {
            byte[] bArr = f51611d;
            iArr[2] = (((bArr[i10] & 255) << 2) | ((bArr[i11] & 255) >> 4)) & 255;
            return 2;
        }
        if (i13 == 61) {
            byte[] bArr2 = f51611d;
            byte b10 = bArr2[i10];
            byte b11 = bArr2[i11];
            byte b12 = bArr2[i12];
            iArr[1] = ((b10 << 2) | (b11 >> 4)) & 255;
            iArr[2] = ((b11 << 4) | (b12 >> 2)) & 255;
            return 1;
        }
        byte[] bArr3 = f51611d;
        byte b13 = bArr3[i10];
        byte b14 = bArr3[i11];
        byte b15 = bArr3[i12];
        byte b16 = bArr3[i13];
        iArr[0] = ((b13 << 2) | (b14 >> 4)) & 255;
        iArr[1] = ((b14 << 4) | (b15 >> 2)) & 255;
        iArr[2] = ((b15 << 6) | b16) & 255;
        return 0;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return 0;
    }

    public final int c() throws IOException {
        while (true) {
            int i10 = this.f51612a.read();
            if (i10 != 9 && i10 != 32) {
                return i10;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f51612a.close();
    }

    public final int d() throws IOException {
        while (true) {
            int i10 = this.f51612a.read();
            if (i10 != 9 && i10 != 10 && i10 != 13 && i10 != 32) {
                return i10;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f51614c > 2) {
            int iD = d();
            if (iD < 0) {
                return -1;
            }
            this.f51614c = a(iD, c(), c(), c(), this.f51613b);
        }
        int[] iArr = this.f51613b;
        int i10 = this.f51614c;
        this.f51614c = i10 + 1;
        return iArr[i10];
    }
}
