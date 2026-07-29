package cp;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class j0 implements org.bouncycastle.crypto.f {
    public static final int[] A = {-1007687205, 1147300610, 2044886154, 2027892972, 1902027934, -947529206, -531697110, -440137385};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25373e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25374f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25375g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25376h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25377i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25378j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25379k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25380l = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25381m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25382n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25383o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f25384p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f25385q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f25386r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f25387s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f25388t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f25389u = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f25390v = 6;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f25391w = 9;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f25392x = 11;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f25393y = 13;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f25394z = 17;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f25395a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[][] f25397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25398d;

    public static int e(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static void f(byte[] bArr, int i10, boolean z10) {
        int iE = e(bArr);
        int i11 = i10 + 16;
        if ((i10 < 0 || i11 < 0) || i11 > iE) {
            if (!z10) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    public static int o(int i10) {
        if (i10 == 0) {
            return 3;
        }
        return i10 - 1;
    }

    public static int p(int i10) {
        if (i10 == 3) {
            return 0;
        }
        return i10 + 1;
    }

    public static int q(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public static int r(int i10, int i11) {
        return (i10 << (32 - i11)) | (i10 >>> i11);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("Invalid parameter passed to LEA init - " + kVar.getClass().getName());
        }
        byte[] bArrA = ((np.n1) kVar).a();
        int length = bArrA.length;
        if ((length << 1) % 16 != 0 || length < 16 || length > 32) {
            throw new IllegalArgumentException("KeyBitSize must be 128, 192 or 256");
        }
        this.f25398d = z10;
        n(bArrA);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "LEA";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        f(bArr, i10, false);
        f(bArr2, i11, true);
        return this.f25398d ? i(bArr, i10, bArr2, i11) : g(bArr, i10, bArr2, i11);
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        org.bouncycastle.util.o.t(bArr, i10, this.f25395a, 0, 4);
        for (int i12 = this.f25396b - 1; i12 >= 0; i12--) {
            h(i12);
        }
        org.bouncycastle.util.o.o(this.f25395a, bArr2, i11);
        return 16;
    }

    public final void h(int i10) {
        int[] iArr = this.f25397c[i10];
        int i11 = i10 % 4;
        int iP = p(i11);
        int[] iArr2 = this.f25395a;
        iArr2[iP] = iArr[1] ^ (r(iArr2[iP], 9) - (this.f25395a[i11] ^ iArr[0]));
        int iP2 = p(iP);
        int[] iArr3 = this.f25395a;
        iArr3[iP2] = (q(iArr3[iP2], 5) - (this.f25395a[iP] ^ iArr[2])) ^ iArr[3];
        int iP3 = p(iP2);
        int[] iArr4 = this.f25395a;
        iArr4[iP3] = iArr[5] ^ (q(iArr4[iP3], 3) - (this.f25395a[iP2] ^ iArr[4]));
    }

    public final int i(byte[] bArr, int i10, byte[] bArr2, int i11) {
        org.bouncycastle.util.o.t(bArr, i10, this.f25395a, 0, 4);
        for (int i12 = 0; i12 < this.f25396b; i12++) {
            j(i12);
        }
        org.bouncycastle.util.o.o(this.f25395a, bArr2, i11);
        return 16;
    }

    public final void j(int i10) {
        int[] iArr = this.f25397c[i10];
        int i11 = (i10 + 3) % 4;
        int iO = o(i11);
        int[] iArr2 = this.f25395a;
        iArr2[i11] = r((iArr[4] ^ iArr2[iO]) + (iArr2[i11] ^ iArr[5]), 3);
        int iO2 = o(iO);
        int[] iArr3 = this.f25395a;
        iArr3[iO] = r((iArr3[iO2] ^ iArr[2]) + (iArr[3] ^ iArr3[iO]), 5);
        int iO3 = o(iO2);
        int[] iArr4 = this.f25395a;
        iArr4[iO2] = q((iArr4[iO3] ^ iArr[0]) + (iArr[1] ^ iArr4[iO2]), 9);
    }

    public final void k(int[] iArr) {
        for (int i10 = 0; i10 < this.f25396b; i10++) {
            int iQ = q(A[i10 & 3], i10);
            iArr[0] = q(iArr[0] + iQ, 1);
            iArr[1] = q(iArr[1] + q(iQ, 1), 3);
            iArr[2] = q(iArr[2] + q(iQ, 2), 6);
            iArr[3] = q(iArr[3] + q(iQ, 3), 11);
            int[] iArr2 = this.f25397c[i10];
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
            iArr2[2] = iArr[2];
            iArr2[3] = iArr[1];
            iArr2[4] = iArr[3];
            iArr2[5] = iArr[1];
        }
    }

    public final void l(int[] iArr) {
        for (int i10 = 0; i10 < this.f25396b; i10++) {
            int iQ = q(A[i10 % 6], i10);
            iArr[0] = q(iArr[0] + q(iQ, 0), 1);
            iArr[1] = q(iArr[1] + q(iQ, 1), 3);
            iArr[2] = q(iArr[2] + q(iQ, 2), 6);
            iArr[3] = q(iArr[3] + q(iQ, 3), 11);
            iArr[4] = q(iArr[4] + q(iQ, 4), 13);
            iArr[5] = q(iArr[5] + q(iQ, 5), 17);
            System.arraycopy(iArr, 0, this.f25397c[i10], 0, 6);
        }
    }

    public final void m(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f25396b; i11++) {
            int iQ = q(A[i11 & 7], i11);
            int[] iArr2 = this.f25397c[i11];
            int i12 = i10 & 7;
            iArr2[0] = q(iArr[i12] + iQ, 1);
            int i13 = i10 + 1;
            iArr[i12] = iArr2[0];
            int i14 = i13 & 7;
            iArr2[1] = q(iArr[i14] + q(iQ, 1), 3);
            int i15 = i13 + 1;
            iArr[i14] = iArr2[1];
            int i16 = i15 & 7;
            iArr2[2] = q(iArr[i16] + q(iQ, 2), 6);
            int i17 = i15 + 1;
            iArr[i16] = iArr2[2];
            int i18 = i17 & 7;
            iArr2[3] = q(iArr[i18] + q(iQ, 3), 11);
            int i19 = i17 + 1;
            iArr[i18] = iArr2[3];
            int i20 = i19 & 7;
            iArr2[4] = q(iArr[i20] + q(iQ, 4), 13);
            int i21 = i19 + 1;
            iArr[i20] = iArr2[4];
            int i22 = i21 & 7;
            iArr2[5] = q(iArr[i22] + q(iQ, 5), 17);
            i10 = i21 + 1;
            iArr[i22] = iArr2[5];
        }
    }

    public final void n(byte[] bArr) {
        int length = (bArr.length >> 1) + 16;
        this.f25396b = length;
        this.f25397c = (int[][]) Array.newInstance((Class<?>) int.class, length, 6);
        int length2 = bArr.length / 4;
        int[] iArr = new int[length2];
        org.bouncycastle.util.o.t(bArr, 0, iArr, 0, length2);
        if (length2 == 4) {
            k(iArr);
        } else if (length2 != 6) {
            m(iArr);
        } else {
            l(iArr);
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
