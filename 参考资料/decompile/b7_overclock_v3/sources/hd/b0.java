package hd;

import com.google.common.base.Charsets;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f30961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30964d;

    public b0() {
        this.f30961a = u0.f31159f;
    }

    public final void a() {
        int i10;
        int i11 = this.f30962b;
        a.i(i11 >= 0 && (i11 < (i10 = this.f30964d) || (i11 == i10 && this.f30963c == 0)));
    }

    public int b() {
        return ((this.f30964d - this.f30962b) * 8) - this.f30963c;
    }

    public void c() {
        if (this.f30963c == 0) {
            return;
        }
        this.f30963c = 0;
        this.f30962b++;
        a();
    }

    public int d() {
        a.i(this.f30963c == 0);
        return this.f30962b;
    }

    public int e() {
        return (this.f30962b * 8) + this.f30963c;
    }

    public void f(int i10, int i11) {
        if (i11 < 32) {
            i10 &= (1 << i11) - 1;
        }
        int iMin = Math.min(8 - this.f30963c, i11);
        int i12 = this.f30963c;
        int i13 = (8 - i12) - iMin;
        byte[] bArr = this.f30961a;
        int i14 = this.f30962b;
        bArr[i14] = (byte) (((65280 >> i12) | ((1 << i13) - 1)) & bArr[i14]);
        int i15 = i11 - iMin;
        bArr[i14] = (byte) (((i10 >>> i15) << i13) | bArr[i14]);
        int i16 = i14 + 1;
        while (i15 > 8) {
            this.f30961a[i16] = (byte) (i10 >>> (i15 - 8));
            i15 -= 8;
            i16++;
        }
        int i17 = 8 - i15;
        byte[] bArr2 = this.f30961a;
        bArr2[i16] = (byte) (bArr2[i16] & ((1 << i17) - 1));
        bArr2[i16] = (byte) (((i10 & ((1 << i15) - 1)) << i17) | bArr2[i16]);
        s(i11);
        a();
    }

    public boolean g() {
        boolean z10 = (this.f30961a[this.f30962b] & (128 >> this.f30963c)) != 0;
        r();
        return z10;
    }

    public int h(int i10) {
        int i11;
        if (i10 == 0) {
            return 0;
        }
        this.f30963c += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f30963c;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f30963c = i13;
            byte[] bArr = this.f30961a;
            int i14 = this.f30962b;
            this.f30962b = i14 + 1;
            i12 |= (bArr[i14] & 255) << i13;
        }
        byte[] bArr2 = this.f30961a;
        int i15 = this.f30962b;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f30963c = 0;
            this.f30962b = i15 + 1;
        }
        a();
        return i16;
    }

    public void i(byte[] bArr, int i10, int i11) {
        int i12 = (i11 >> 3) + i10;
        while (i10 < i12) {
            byte[] bArr2 = this.f30961a;
            int i13 = this.f30962b;
            int i14 = i13 + 1;
            this.f30962b = i14;
            byte b10 = bArr2[i13];
            int i15 = this.f30963c;
            bArr[i10] = (byte) (b10 << i15);
            bArr[i10] = (byte) (((255 & bArr2[i14]) >> (8 - i15)) | bArr[i10]);
            i10++;
        }
        int i16 = i11 & 7;
        if (i16 == 0) {
            return;
        }
        bArr[i12] = (byte) (bArr[i12] & (255 >> i16));
        int i17 = this.f30963c;
        if (i17 + i16 > 8) {
            int i18 = bArr[i12];
            byte[] bArr3 = this.f30961a;
            int i19 = this.f30962b;
            this.f30962b = i19 + 1;
            bArr[i12] = (byte) (i18 | ((bArr3[i19] & 255) << i17));
            this.f30963c = i17 - 8;
        }
        int i20 = this.f30963c + i16;
        this.f30963c = i20;
        byte[] bArr4 = this.f30961a;
        int i21 = this.f30962b;
        bArr[i12] = (byte) (((byte) (((255 & bArr4[i21]) >> (8 - i20)) << (8 - i16))) | bArr[i12]);
        if (i20 == 8) {
            this.f30963c = 0;
            this.f30962b = i21 + 1;
        }
        a();
    }

    public long j(int i10) {
        return i10 <= 32 ? u0.x1(h(i10)) : u0.v1(h(i10 - 32), h(32));
    }

    public void k(byte[] bArr, int i10, int i11) {
        a.i(this.f30963c == 0);
        System.arraycopy(this.f30961a, this.f30962b, bArr, i10, i11);
        this.f30962b += i11;
        a();
    }

    public String l(int i10) {
        return m(i10, Charsets.UTF_8);
    }

    public String m(int i10, Charset charset) {
        byte[] bArr = new byte[i10];
        k(bArr, 0, i10);
        return new String(bArr, charset);
    }

    public void n(c0 c0Var) {
        p(c0Var.d(), c0Var.f());
        q(c0Var.e() * 8);
    }

    public void o(byte[] bArr) {
        p(bArr, bArr.length);
    }

    public void p(byte[] bArr, int i10) {
        this.f30961a = bArr;
        this.f30962b = 0;
        this.f30963c = 0;
        this.f30964d = i10;
    }

    public void q(int i10) {
        int i11 = i10 / 8;
        this.f30962b = i11;
        this.f30963c = i10 - (i11 * 8);
        a();
    }

    public void r() {
        int i10 = this.f30963c + 1;
        this.f30963c = i10;
        if (i10 == 8) {
            this.f30963c = 0;
            this.f30962b++;
        }
        a();
    }

    public void s(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f30962b + i11;
        this.f30962b = i12;
        int i13 = this.f30963c + (i10 - (i11 * 8));
        this.f30963c = i13;
        if (i13 > 7) {
            this.f30962b = i12 + 1;
            this.f30963c = i13 - 8;
        }
        a();
    }

    public void t(int i10) {
        a.i(this.f30963c == 0);
        this.f30962b += i10;
        a();
    }

    public b0(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public b0(byte[] bArr, int i10) {
        this.f30961a = bArr;
        this.f30964d = i10;
    }
}
