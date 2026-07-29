package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class t0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25664c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25665d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25666e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25667f = -1209970333;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25668g = -1640531527;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25669h = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25671b;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25671b = z10;
            j(((np.n1) kVar).a());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC6 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "RC6";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iC = c();
        if (this.f25670a == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        }
        if (i10 + iC > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (iC + i11 <= bArr2.length) {
            return this.f25671b ? g(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11);
        }
        throw new OutputLengthException("output buffer too short");
    }

    public final int e(byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 3; i12 >= 0; i12--) {
            i11 = (i11 << 8) + (bArr[i12 + i10] & 255);
        }
        return i11;
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        int iE3 = e(bArr, i10 + 8);
        int iE4 = e(bArr, i10 + 12);
        int[] iArr = this.f25670a;
        int i12 = iE3 - iArr[43];
        int i13 = iE - iArr[42];
        int i14 = 20;
        while (i14 >= 1) {
            int iH = h(((i13 * 2) + 1) * i13, 5);
            int iH2 = h(((i12 * 2) + 1) * i12, 5);
            int i15 = i14 * 2;
            int i16 = i(iE2 - this.f25670a[i15 + 1], iH) ^ iH2;
            i14--;
            int i17 = i13;
            i13 = i(iE4 - this.f25670a[i15], iH2) ^ iH;
            iE4 = i12;
            i12 = i16;
            iE2 = i17;
        }
        int[] iArr2 = this.f25670a;
        int i18 = iE4 - iArr2[1];
        int i19 = iE2 - iArr2[0];
        k(i13, bArr2, i11);
        k(i19, bArr2, i11 + 4);
        k(i12, bArr2, i11 + 8);
        k(i18, bArr2, i11 + 12);
        return 16;
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        int iE3 = e(bArr, i10 + 8);
        int iE4 = e(bArr, i10 + 12);
        int[] iArr = this.f25670a;
        int i12 = iE2 + iArr[0];
        int i13 = iE4 + iArr[1];
        int i14 = 1;
        while (i14 <= 20) {
            int iH = h(((i12 * 2) + 1) * i12, 5);
            int iH2 = h(((i13 * 2) + 1) * i13, 5);
            int i15 = i14 * 2;
            int iH3 = h(iE ^ iH, iH2) + this.f25670a[i15];
            int iH4 = h(iE3 ^ iH2, iH) + this.f25670a[i15 + 1];
            i14++;
            iE3 = i13;
            i13 = iH3;
            iE = i12;
            i12 = iH4;
        }
        int[] iArr2 = this.f25670a;
        int i16 = iE + iArr2[42];
        int i17 = iE3 + iArr2[43];
        k(i16, bArr2, i11);
        k(i12, bArr2, i11 + 4);
        k(i17, bArr2, i11 + 8);
        k(i13, bArr2, i11 + 12);
        return 16;
    }

    public final int h(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    public final int i(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    public final void j(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int length2 = ((bArr.length + 4) - 1) / 4;
        int[] iArr2 = new int[length2];
        for (int length3 = bArr.length - 1; length3 >= 0; length3--) {
            int i10 = length3 / 4;
            iArr2[i10] = (iArr2[i10] << 8) + (bArr[length3] & 255);
        }
        int[] iArr3 = new int[44];
        this.f25670a = iArr3;
        iArr3[0] = -1209970333;
        int i11 = 1;
        while (true) {
            iArr = this.f25670a;
            if (i11 >= iArr.length) {
                break;
            }
            iArr[i11] = iArr[i11 - 1] - 1640531527;
            i11++;
        }
        int length4 = length2 > iArr.length ? length2 * 3 : iArr.length * 3;
        int length5 = 0;
        int iH = 0;
        int iH2 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length4; i13++) {
            int[] iArr4 = this.f25670a;
            iH = h(iArr4[length5] + iH + iH2, 3);
            iArr4[length5] = iH;
            iH2 = h(iArr2[i12] + iH + iH2, iH2 + iH);
            iArr2[i12] = iH2;
            length5 = (length5 + 1) % this.f25670a.length;
            i12 = (i12 + 1) % length2;
        }
    }

    public final void k(int i10, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i12 + i11] = (byte) i10;
            i10 >>>= 8;
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
