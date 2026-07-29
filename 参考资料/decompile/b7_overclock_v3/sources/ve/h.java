package ve;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53134h = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f53135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53139g;

    public h(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f53135c = bArr;
        this.f53136d = i10;
        this.f53137e = i11;
        this.f53138f = i12;
        this.f53139g = i13;
        if (z10) {
            n(i14, i15);
        }
    }

    @Override // ve.e
    public e a(int i10, int i11, int i12, int i13) {
        return new h(this.f53135c, this.f53136d, this.f53137e, this.f53138f + i10, this.f53139g + i11, i12, i13, false);
    }

    @Override // ve.e
    public byte[] c() {
        int iE = e();
        int iB = b();
        int i10 = this.f53136d;
        if (iE == i10 && iB == this.f53137e) {
            return this.f53135c;
        }
        int i11 = iE * iB;
        byte[] bArr = new byte[i11];
        int i12 = (this.f53139g * i10) + this.f53138f;
        if (iE == i10) {
            System.arraycopy(this.f53135c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iB; i13++) {
            System.arraycopy(this.f53135c, i12, bArr, i13 * iE, iE);
            i12 += this.f53136d;
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
        System.arraycopy(this.f53135c, ((i10 + this.f53139g) * this.f53136d) + this.f53138f, bArr, 0, iE);
        return bArr;
    }

    @Override // ve.e
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int iE = e() / 2;
        int iB = b() / 2;
        int[] iArr = new int[iE * iB];
        byte[] bArr = this.f53135c;
        int i10 = (this.f53139g * this.f53136d) + this.f53138f;
        for (int i11 = 0; i11 < iB; i11++) {
            int i12 = i11 * iE;
            for (int i13 = 0; i13 < iE; i13++) {
                iArr[i12 + i13] = ((bArr[(i13 * 2) + i10] & 255) * 65793) | (-16777216);
            }
            i10 += this.f53136d * 2;
        }
        return iArr;
    }

    public final void n(int i10, int i11) {
        byte[] bArr = this.f53135c;
        int i12 = (this.f53139g * this.f53136d) + this.f53138f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f53136d;
        }
    }
}
