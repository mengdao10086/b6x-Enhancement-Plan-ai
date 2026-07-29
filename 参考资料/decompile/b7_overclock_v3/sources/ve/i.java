package ve;

import w.w;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f53140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53144g;

    public i(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f53141d = i10;
        this.f53142e = i11;
        this.f53143f = 0;
        this.f53144g = 0;
        int i12 = i10 * i11;
        this.f53140c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.f53140c[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & w.g.f53779r)) + (i14 & 255)) / 4);
        }
    }

    @Override // ve.e
    public e a(int i10, int i11, int i12, int i13) {
        return new i(this.f53140c, this.f53141d, this.f53142e, this.f53143f + i10, this.f53144g + i11, i12, i13);
    }

    @Override // ve.e
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i10 = this.f53141d;
        if (iE == i10 && iB == this.f53142e) {
            return this.f53140c;
        }
        int i11 = iE * iB;
        byte[] bArr = new byte[i11];
        int i12 = (this.f53144g * i10) + this.f53143f;
        if (iE == i10) {
            System.arraycopy(this.f53140c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iB; i13++) {
            System.arraycopy(this.f53140c, i12, bArr, i13 * iE, iE);
            i12 += this.f53141d;
        }
        return bArr;
    }

    @Override // ve.e
    public byte[] d(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= b()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int iE = e();
        if (bArr == null || bArr.length < iE) {
            bArr = new byte[iE];
        }
        System.arraycopy(this.f53140c, ((i10 + this.f53144g) * this.f53141d) + this.f53143f, bArr, 0, iE);
        return bArr;
    }

    @Override // ve.e
    public boolean g() {
        return true;
    }

    public i(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 <= i10 && i15 + i13 <= i11) {
            this.f53140c = bArr;
            this.f53141d = i10;
            this.f53142e = i11;
            this.f53143f = i12;
            this.f53144g = i13;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
