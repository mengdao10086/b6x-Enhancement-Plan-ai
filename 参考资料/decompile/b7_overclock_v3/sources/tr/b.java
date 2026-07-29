package tr;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import jt.d;

/* JADX INFO: loaded from: classes6.dex */
public class b extends FilterOutputStream {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f51615d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f51616e = 54;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f51617f = 74;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f51618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f51619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51620c;

    public b(OutputStream outputStream) {
        super(outputStream);
        this.f51618a = new byte[54];
        byte[] bArr = new byte[74];
        this.f51619b = bArr;
        this.f51620c = 0;
        bArr[72] = 13;
        bArr[73] = 10;
    }

    public final void a(byte[] bArr, int i10) throws IOException {
        f51615d.g(bArr, i10, 54, this.f51619b, 0);
        ((FilterOutputStream) this).out.write(this.f51619b, 0, 74);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i10 = this.f51620c;
        if (i10 > 0) {
            int iG = f51615d.g(this.f51618a, 0, i10, this.f51619b, 0);
            this.f51620c = 0;
            byte[] bArr = this.f51619b;
            int i11 = iG + 1;
            bArr[iG] = 13;
            bArr[i11] = 10;
            ((FilterOutputStream) this).out.write(bArr, 0, i11 + 1);
        }
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f51618a;
        int i11 = this.f51620c;
        int i12 = i11 + 1;
        this.f51620c = i12;
        bArr[i11] = (byte) i10;
        if (i12 == 54) {
            a(bArr, 0);
            this.f51620c = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f51620c;
        int i14 = 54 - i13;
        if (i11 < i14) {
            System.arraycopy(bArr, i10, this.f51618a, i13, i11);
            this.f51620c += i11;
            return;
        }
        if (i13 > 0) {
            System.arraycopy(bArr, i10, this.f51618a, i13, i14);
            i12 = i14 + 0;
            a(this.f51618a, 0);
        } else {
            i12 = 0;
        }
        while (true) {
            int i15 = i11 - i12;
            if (i15 < 54) {
                System.arraycopy(bArr, i10 + i12, this.f51618a, 0, i15);
                this.f51620c = i15;
                return;
            } else {
                a(bArr, i10 + i12);
                i12 += 54;
            }
        }
    }
}
