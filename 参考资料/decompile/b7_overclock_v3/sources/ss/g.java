package ss;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f50441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h[] f50442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i[] f50443c;

    public g(int i10, int i11, int i12, int i13, int i14, int i15, byte[] bArr) {
        byte[] bArr2 = new byte[i10];
        this.f50441a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.f50442b = new h[i11];
        int i16 = i10;
        for (int i17 = 0; i17 != i11; i17++) {
            byte[] bArr3 = new byte[i10];
            System.arraycopy(bArr, i16, bArr3, 0, i10);
            i16 += i10;
            byte[][] bArr4 = new byte[i12][];
            for (int i18 = 0; i18 != i12; i18++) {
                bArr4[i18] = new byte[i10];
                System.arraycopy(bArr, i16, bArr4[i18], 0, i10);
                i16 += i10;
            }
            this.f50442b[i17] = new h(bArr3, bArr4);
        }
        this.f50443c = new i[i13];
        for (int i19 = 0; i19 != i13; i19++) {
            int i20 = i15 * i10;
            byte[] bArr5 = new byte[i20];
            System.arraycopy(bArr, i16, bArr5, 0, i20);
            i16 += i20;
            byte[][] bArr6 = new byte[i14][];
            for (int i21 = 0; i21 != i14; i21++) {
                bArr6[i21] = new byte[i10];
                System.arraycopy(bArr, i16, bArr6[i21], 0, i10);
                i16 += i10;
            }
            this.f50443c[i19] = new i(bArr5, bArr6);
        }
        if (i16 != bArr.length) {
            throw new IllegalArgumentException("signature wrong length");
        }
    }

    public byte[] a() {
        return this.f50441a;
    }

    public h[] b() {
        return this.f50442b;
    }

    public i[] c() {
        return this.f50443c;
    }
}
