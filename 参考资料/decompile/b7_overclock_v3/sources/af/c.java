package af;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f588c;

    public c(byte[] bArr) {
        this.f586a = bArr;
    }

    public int a() {
        return ((this.f586a.length - this.f587b) * 8) - this.f588c;
    }

    public int b() {
        return this.f588c;
    }

    public int c() {
        return this.f587b;
    }

    public int d(int i10) {
        if (i10 < 1 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f588c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int iMin = Math.min(i10, i13);
            int i14 = i13 - iMin;
            byte[] bArr = this.f586a;
            int i15 = this.f587b;
            int i16 = (((255 >> (8 - iMin)) << i14) & bArr[i15]) >> i14;
            i10 -= iMin;
            int i17 = this.f588c + iMin;
            this.f588c = i17;
            if (i17 == 8) {
                this.f588c = 0;
                this.f587b = i15 + 1;
            }
            i12 = i16;
        }
        if (i10 <= 0) {
            return i12;
        }
        while (i10 >= 8) {
            int i18 = i12 << 8;
            byte[] bArr2 = this.f586a;
            int i19 = this.f587b;
            i12 = (bArr2[i19] & 255) | i18;
            this.f587b = i19 + 1;
            i10 -= 8;
        }
        if (i10 <= 0) {
            return i12;
        }
        int i20 = 8 - i10;
        int i21 = (i12 << i10) | ((((255 >> i20) << i20) & this.f586a[this.f587b]) >> i20);
        this.f588c += i10;
        return i21;
    }
}
