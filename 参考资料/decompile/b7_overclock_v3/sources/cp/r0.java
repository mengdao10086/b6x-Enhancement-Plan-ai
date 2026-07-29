package cp;

import np.b2;

/* JADX INFO: loaded from: classes5.dex */
public class r0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25614d = -1209970333;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25615e = -1640531527;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25616a = 12;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25617b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25618c;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof b2) {
            b2 b2Var = (b2) kVar;
            this.f25616a = b2Var.b();
            j(b2Var.a());
        } else {
            if (!(kVar instanceof np.n1)) {
                throw new IllegalArgumentException("invalid parameter passed to RC532 init - " + kVar.getClass().getName());
            }
            j(((np.n1) kVar).a());
        }
        this.f25618c = z10;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "RC5-32";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        return this.f25618c ? g(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11);
    }

    public final int e(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        for (int i12 = this.f25616a; i12 >= 1; i12--) {
            int i13 = i12 * 2;
            iE2 = i(iE2 - this.f25617b[i13 + 1], iE) ^ iE;
            iE = i(iE - this.f25617b[i13], iE2) ^ iE2;
        }
        k(iE - this.f25617b[0], bArr2, i11);
        k(iE2 - this.f25617b[1], bArr2, i11 + 4);
        return 8;
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10) + this.f25617b[0];
        int iE2 = e(bArr, i10 + 4) + this.f25617b[1];
        for (int i12 = 1; i12 <= this.f25616a; i12++) {
            int i13 = i12 * 2;
            iE = h(iE ^ iE2, iE2) + this.f25617b[i13];
            iE2 = h(iE2 ^ iE, iE) + this.f25617b[i13 + 1];
        }
        k(iE, bArr2, i11);
        k(iE2, bArr2, i11 + 4);
        return 8;
    }

    public final int h(int i10, int i11) {
        int i12 = i11 & 31;
        return (i10 >>> (32 - i12)) | (i10 << i12);
    }

    public final int i(int i10, int i11) {
        int i12 = i11 & 31;
        return (i10 << (32 - i12)) | (i10 >>> i12);
    }

    public final void j(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            int i11 = i10 / 4;
            iArr2[i11] = iArr2[i11] + ((bArr[i10] & 255) << ((i10 % 4) * 8));
        }
        int[] iArr3 = new int[(this.f25616a + 1) * 2];
        this.f25617b = iArr3;
        iArr3[0] = -1209970333;
        int i12 = 1;
        while (true) {
            iArr = this.f25617b;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = iArr[i12 - 1] - 1640531527;
            i12++;
        }
        int length2 = length > iArr.length ? length * 3 : iArr.length * 3;
        int length3 = 0;
        int iH = 0;
        int iH2 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length2; i14++) {
            int[] iArr4 = this.f25617b;
            iH = h(iArr4[length3] + iH + iH2, 3);
            iArr4[length3] = iH;
            iH2 = h(iArr2[i13] + iH + iH2, iH2 + iH);
            iArr2[i13] = iH2;
            length3 = (length3 + 1) % this.f25617b.length;
            i13 = (i13 + 1) % length;
        }
    }

    public final void k(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 3] = (byte) (i10 >> 24);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
