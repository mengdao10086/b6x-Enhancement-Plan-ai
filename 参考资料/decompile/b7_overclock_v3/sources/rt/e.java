package rt;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class e implements a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static pt.b f49196k = pt.b.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f49197l = -8663945395140668459L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f49198m = 5545529020109919103L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f49199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f49200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f49201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f49204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f49205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f49207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f49208j;

    public e() {
        this.f49199a = 0L;
    }

    @Override // rt.a
    public byte[] a() {
        g();
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = (byte) (255 & (this.f49208j >>> (56 - (i10 * 8))));
        }
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11 + 8] = (byte) ((this.f49207i >>> (56 - (i11 * 8))) & 255);
        }
        return bArr;
    }

    @Override // rt.a
    public BigInteger b() {
        return new BigInteger(1, a());
    }

    @Override // rt.a
    public long c() {
        g();
        return this.f49208j;
    }

    @Override // rt.a
    public String d() {
        g();
        return i(this.f49208j) + i(this.f49207i);
    }

    @Override // rt.a
    public byte[] e() {
        g();
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 8; i10++) {
            bArr[i10] = (byte) (255 & (this.f49207i >>> (i10 * 8)));
        }
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11 + 8] = (byte) ((this.f49208j >>> (i11 * 8)) & 255);
        }
        return bArr;
    }

    public final void f(long j10, long j11) {
        long jRotateLeft = (Long.rotateLeft(j10 * f49197l, 31) * f49198m) ^ this.f49200b;
        this.f49200b = jRotateLeft;
        this.f49200b = ((Long.rotateLeft(jRotateLeft, 27) + this.f49201c) * 5) + 1390208809;
        long jRotateLeft2 = (Long.rotateLeft(j11 * f49198m, 33) * f49197l) ^ this.f49201c;
        this.f49201c = jRotateLeft2;
        this.f49201c = ((Long.rotateLeft(jRotateLeft2, 31) + this.f49200b) * 5) + 944331445;
    }

    public final void g() {
        if (this.f49206h) {
            return;
        }
        this.f49206h = true;
        this.f49207i = this.f49200b;
        this.f49208j = this.f49201c;
        int i10 = this.f49203e;
        if (i10 > 0) {
            if (i10 > 8) {
                this.f49208j = (Long.rotateLeft(this.f49205g * f49198m, 33) * f49197l) ^ this.f49208j;
            }
            this.f49207i = (Long.rotateLeft(this.f49204f * f49197l, 31) * f49198m) ^ this.f49207i;
        }
        long j10 = this.f49207i;
        int i11 = this.f49202d;
        long j11 = j10 ^ ((long) i11);
        long j12 = this.f49208j ^ ((long) i11);
        long j13 = j11 + j12;
        this.f49207i = j13;
        this.f49208j = j12 + j13;
        this.f49207i = h(j13);
        long jH = h(this.f49208j);
        long j14 = this.f49207i + jH;
        this.f49207i = j14;
        this.f49208j = jH + j14;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        g();
        return this.f49207i;
    }

    public final long h(long j10) {
        long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
        long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
        return j12 ^ (j12 >>> 33);
    }

    public final String i(long j10) {
        String hexString = Long.toHexString(j10);
        while (hexString.length() < 16) {
            hexString = '0' + hexString;
        }
        return hexString;
    }

    public void j(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void k(long j10) {
        l(Long.reverseBytes(j10));
    }

    public void l(long j10) {
        this.f49206h = false;
        int i10 = this.f49203e;
        if (i10 == 0) {
            this.f49204f = j10;
        } else {
            if (i10 != 8) {
                throw new IllegalStateException("Cannot mix long with other alignments than 8: " + this.f49203e);
            }
            this.f49205g = j10;
        }
        int i11 = i10 + 8;
        this.f49203e = i11;
        if (i11 == 16) {
            f(this.f49204f, this.f49205g);
            this.f49203e = 0;
        }
        this.f49202d += 8;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        long j10 = this.f49199a;
        this.f49201c = j10;
        this.f49200b = j10;
        this.f49202d = 0;
        this.f49203e = 0;
        this.f49206h = false;
        this.f49205g = 0L;
        this.f49204f = 0L;
        this.f49208j = 0L;
        this.f49207i = 0L;
    }

    @Override // java.util.zip.Checksum
    public void update(int i10) {
        this.f49206h = false;
        int i11 = this.f49203e;
        switch (i11) {
            case 0:
                this.f49204f = i10 & 255;
                break;
            case 1:
                this.f49204f |= (long) ((i10 & 255) << 8);
                break;
            case 2:
                this.f49204f |= (long) ((i10 & 255) << 16);
                break;
            case 3:
                this.f49204f |= (((long) i10) & 255) << 24;
                break;
            case 4:
                this.f49204f |= (255 & ((long) i10)) << 32;
                break;
            case 5:
                this.f49204f |= (((long) i10) & 255) << 40;
                break;
            case 6:
                this.f49204f = ((255 & ((long) i10)) << 48) | this.f49204f;
                break;
            case 7:
                this.f49204f |= (((long) i10) & 255) << 56;
                break;
            case 8:
                this.f49205g = i10 & 255;
                break;
            case 9:
                this.f49205g |= (long) ((i10 & 255) << 8);
                break;
            case 10:
                this.f49205g |= (long) ((i10 & 255) << 16);
                break;
            case 11:
                this.f49205g |= (((long) i10) & 255) << 24;
                break;
            case 12:
                this.f49205g |= (255 & ((long) i10)) << 32;
                break;
            case 13:
                this.f49205g |= (((long) i10) & 255) << 40;
                break;
            case 14:
                this.f49205g = ((255 & ((long) i10)) << 48) | this.f49205g;
                break;
            case 15:
                this.f49205g |= (((long) i10) & 255) << 56;
                break;
        }
        int i12 = i11 + 1;
        this.f49203e = i12;
        if (i12 == 16) {
            f(this.f49204f, this.f49205g);
            this.f49203e = 0;
        }
        this.f49202d++;
    }

    public e(int i10) {
        long j10 = ((long) i10) & 4294967295L;
        this.f49199a = j10;
        this.f49201c = j10;
        this.f49200b = j10;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i10, int i11) {
        this.f49206h = false;
        while (this.f49203e != 0 && i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        int i12 = i11 & 15;
        int i13 = (i11 + i10) - i12;
        for (int i14 = i10; i14 < i13; i14 += 16) {
            f(f49196k.g(bArr, i14), f49196k.g(bArr, i14 + 8));
        }
        this.f49202d += i13 - i10;
        for (int i15 = 0; i15 < i12; i15++) {
            update(bArr[i13 + i15]);
        }
    }
}
