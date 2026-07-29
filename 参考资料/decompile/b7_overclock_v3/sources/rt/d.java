package rt;

import dm.g;
import java.util.zip.Checksum;
import kotlin.v1;

/* JADX INFO: loaded from: classes6.dex */
public class d implements Checksum {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static pt.b f49188f = pt.b.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49189g = -862048943;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49190h = 461845907;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49195e;

    public d() {
        this.f49191a = 0;
    }

    public final void f(int i10) {
        int i11 = i10 * f49189g;
        int i12 = (((i11 >>> 17) | (i11 << 15)) * f49190h) ^ this.f49192b;
        this.f49192b = (((i12 >>> 19) | (i12 << 13)) * 5) - 430675100;
    }

    public void g(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int i10 = this.f49192b;
        if (this.f49195e > 0) {
            int i11 = this.f49194d * f49189g;
            i10 ^= ((i11 >>> 17) | (i11 << 15)) * f49190h;
        }
        int i12 = i10 ^ this.f49193c;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return ((long) (i14 ^ (i14 >>> 16))) & 4294967295L;
    }

    public void h(boolean z10) {
        update(z10 ? 1 : 0);
    }

    public void i(double d10) {
        m(Double.doubleToLongBits(d10));
    }

    public void j(float f10) {
        k(Float.floatToIntBits(f10));
    }

    public void k(int i10) {
        int i11 = this.f49195e;
        if (i11 == 0) {
            f(i10);
        } else if (i11 == 1) {
            int i12 = this.f49194d | ((16777215 & i10) << 8);
            this.f49194d = i12;
            f(i12);
            this.f49194d = i10 >>> 24;
        } else if (i11 == 2) {
            int i13 = this.f49194d | ((65535 & i10) << 16);
            this.f49194d = i13;
            f(i13);
            this.f49194d = i10 >>> 16;
        } else if (i11 == 3) {
            int i14 = this.f49194d | ((i10 & 255) << 24);
            this.f49194d = i14;
            f(i14);
            this.f49194d = i10 >>> 8;
        }
        this.f49193c += 4;
    }

    public void l(int... iArr) {
        int i10 = 0;
        if (this.f49195e != 0) {
            int length = iArr.length;
            while (i10 < length) {
                k(iArr[i10]);
                i10++;
            }
            return;
        }
        int length2 = iArr.length;
        while (i10 < length2) {
            f(iArr[i10]);
            i10++;
        }
        this.f49193c += iArr.length * 4;
    }

    public void m(long j10) {
        int i10 = this.f49195e;
        if (i10 == 0) {
            f((int) ((-1) & j10));
            f((int) (j10 >>> 32));
        } else if (i10 == 1) {
            int i11 = (int) (((long) this.f49194d) | ((16777215 & j10) << 8));
            this.f49194d = i11;
            f(i11);
            f((int) ((-1) & (j10 >>> 24)));
            this.f49194d = (int) (j10 >>> 56);
        } else if (i10 == 2) {
            int i12 = (int) (((long) this.f49194d) | ((g.f26388t & j10) << 16));
            this.f49194d = i12;
            f(i12);
            f((int) ((-1) & (j10 >>> 16)));
            this.f49194d = (int) (j10 >>> 48);
        } else if (i10 == 3) {
            int i13 = (int) (((255 & j10) << 24) | ((long) this.f49194d));
            this.f49194d = i13;
            f(i13);
            f((int) ((-1) & (j10 >>> 8)));
            this.f49194d = (int) (j10 >>> 40);
        }
        this.f49193c += 8;
    }

    public void n(long... jArr) {
        int i10 = 0;
        if (this.f49195e != 0) {
            int length = jArr.length;
            while (i10 < length) {
                m(jArr[i10]);
                i10++;
            }
            return;
        }
        int length2 = jArr.length;
        while (i10 < length2) {
            long j10 = jArr[i10];
            f((int) ((-1) & j10));
            f((int) (j10 >>> 32));
            i10++;
        }
        this.f49193c += jArr.length * 8;
    }

    public void o(short s10) {
        int i10 = this.f49195e;
        if (i10 == 0) {
            this.f49194d = s10 & v1.f38215d;
            this.f49195e = 2;
        } else if (i10 == 1) {
            this.f49194d = ((s10 & v1.f38215d) << 8) | this.f49194d;
            this.f49195e = 3;
        } else if (i10 == 2) {
            int i11 = ((s10 & v1.f38215d) << 16) | this.f49194d;
            this.f49194d = i11;
            f(i11);
            this.f49195e = 0;
        } else if (i10 == 3) {
            int i12 = this.f49194d | ((s10 & 255) << 24);
            this.f49194d = i12;
            f(i12);
            this.f49194d = (s10 >> 8) & 255;
            this.f49195e = 1;
        }
        this.f49193c += 2;
    }

    public void p(short... sArr) {
        int i10;
        int length = sArr.length;
        int i11 = 0;
        if (length <= 0 || !((i10 = this.f49195e) == 0 || i10 == 2)) {
            int length2 = sArr.length;
            while (i11 < length2) {
                o(sArr[i11]);
                i11++;
            }
            return;
        }
        if (i10 == 2) {
            int i12 = this.f49194d | ((sArr[0] & v1.f38215d) << 16);
            this.f49194d = i12;
            f(i12);
            this.f49195e = 0;
            length--;
            i11 = 1;
        }
        int i13 = (length & (-2)) + i11;
        while (i11 < i13) {
            f((sArr[i11] & v1.f38215d) | ((sArr[i11 + 1] & v1.f38215d) << 16));
            i11 += 2;
        }
        if (i13 < sArr.length) {
            this.f49194d = sArr[i13] & v1.f38215d;
            this.f49195e = 2;
        }
        this.f49193c += sArr.length * 2;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.f49192b = this.f49191a;
        this.f49193c = 0;
        this.f49195e = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int i10) {
        int i11 = this.f49195e;
        if (i11 == 0) {
            this.f49194d = i10 & 255;
            this.f49195e = 1;
        } else if (i11 == 1) {
            this.f49194d = ((i10 & 255) << 8) | this.f49194d;
            this.f49195e = 2;
        } else if (i11 == 2) {
            this.f49194d = ((i10 & 255) << 16) | this.f49194d;
            this.f49195e = 3;
        } else if (i11 == 3) {
            int i12 = ((i10 & 255) << 24) | this.f49194d;
            this.f49194d = i12;
            f(i12);
            this.f49195e = 0;
        }
        this.f49193c++;
    }

    public d(int i10) {
        this.f49191a = i10;
        this.f49192b = i10;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i10, int i11) {
        while (this.f49195e != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        int i12 = i11 & 3;
        int i13 = (i11 + i10) - i12;
        for (int i14 = i10; i14 < i13; i14 += 4) {
            f(f49188f.d(bArr, i14));
        }
        this.f49193c += i13 - i10;
        for (int i15 = 0; i15 < i12; i15++) {
            update(bArr[i13 + i15]);
        }
    }
}
