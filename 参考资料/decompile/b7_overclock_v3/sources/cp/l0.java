package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class l0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25442d = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f25443e = {-128, 27, 54, 108, i1.a.f31659n7, -85, 77, -102, 47, 94, rp.u.f49086t, 99, i1.a.f31707t7, -105, 53, 106, -44};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f25444a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25445b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25446c;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to Noekeon init - " + kVar.getClass().getName());
        }
        byte[] bArrA = ((np.n1) kVar).a();
        if (bArrA.length != 16) {
            throw new IllegalArgumentException("Key length not 128 bits.");
        }
        org.bouncycastle.util.o.c(bArrA, 0, this.f25444a, 0, 4);
        if (!z10) {
            int[] iArr = this.f25444a;
            int i10 = iArr[0];
            int i11 = iArr[1];
            int i12 = iArr[2];
            int i13 = iArr[3];
            int i14 = i10 ^ i12;
            int iE = i14 ^ (org.bouncycastle.util.j.e(i14, 8) ^ org.bouncycastle.util.j.e(i14, 24));
            int i15 = i11 ^ i13;
            int iE2 = (org.bouncycastle.util.j.e(i15, 8) ^ org.bouncycastle.util.j.e(i15, 24)) ^ i15;
            int i16 = i11 ^ iE;
            int i17 = i13 ^ iE;
            int[] iArr2 = this.f25444a;
            iArr2[0] = i10 ^ iE2;
            iArr2[1] = i16;
            iArr2[2] = i12 ^ iE2;
            iArr2[3] = i17;
        }
        this.f25446c = z10;
        this.f25445b = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Noekeon";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (!this.f25445b) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 <= bArr2.length - 16) {
            return this.f25446c ? f(bArr, i10, bArr2, i11) : e(bArr, i10, bArr2, i11);
        }
        throw new OutputLengthException("output buffer too short");
    }

    public final int e(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iA = org.bouncycastle.util.o.a(bArr, i10);
        int iA2 = org.bouncycastle.util.o.a(bArr, i10 + 4);
        int iA3 = org.bouncycastle.util.o.a(bArr, i10 + 8);
        int iA4 = org.bouncycastle.util.o.a(bArr, i10 + 12);
        int[] iArr = this.f25444a;
        int i12 = iArr[0];
        int i13 = iArr[1];
        int i14 = iArr[2];
        int i15 = iArr[3];
        int i16 = 16;
        while (true) {
            int i17 = iA ^ iA3;
            int iE = i17 ^ (org.bouncycastle.util.j.e(i17, 8) ^ org.bouncycastle.util.j.e(i17, 24));
            int i18 = iA2 ^ i13;
            int i19 = iA4 ^ i15;
            int i20 = i18 ^ i19;
            int iE2 = (org.bouncycastle.util.j.e(i20, 24) ^ org.bouncycastle.util.j.e(i20, 8)) ^ i20;
            int i21 = i18 ^ iE;
            int i22 = (iA3 ^ i14) ^ iE2;
            int i23 = i19 ^ iE;
            int i24 = ((iA ^ i12) ^ iE2) ^ (f25443e[i16] & 255);
            i16--;
            if (i16 < 0) {
                org.bouncycastle.util.o.h(i24, bArr2, i11);
                org.bouncycastle.util.o.h(i21, bArr2, i11 + 4);
                org.bouncycastle.util.o.h(i22, bArr2, i11 + 8);
                org.bouncycastle.util.o.h(i23, bArr2, i11 + 12);
                return 16;
            }
            int iE3 = org.bouncycastle.util.j.e(i21, 1);
            int iE4 = org.bouncycastle.util.j.e(i22, 5);
            int iE5 = org.bouncycastle.util.j.e(i23, 2);
            int i25 = iE3 ^ (iE5 | iE4);
            int i26 = ~i25;
            int i27 = i24 ^ (iE4 & i26);
            int i28 = (iE4 ^ (i26 ^ iE5)) ^ i27;
            int i29 = i25 ^ (i27 | i28);
            int i30 = iE5 ^ (i28 & i29);
            iA2 = org.bouncycastle.util.j.e(i29, 31);
            iA3 = org.bouncycastle.util.j.e(i28, 27);
            int iE6 = org.bouncycastle.util.j.e(i27, 30);
            iA = i30;
            iA4 = iE6;
        }
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iA = org.bouncycastle.util.o.a(bArr, i10);
        int iA2 = org.bouncycastle.util.o.a(bArr, i10 + 4);
        int iA3 = org.bouncycastle.util.o.a(bArr, i10 + 8);
        int iA4 = org.bouncycastle.util.o.a(bArr, i10 + 12);
        int[] iArr = this.f25444a;
        int i12 = 0;
        int i13 = iArr[0];
        int i14 = iArr[1];
        int i15 = iArr[2];
        int i16 = iArr[3];
        while (true) {
            int i17 = iA ^ (f25443e[i12] & 255);
            int i18 = i17 ^ iA3;
            int iE = i18 ^ (org.bouncycastle.util.j.e(i18, 8) ^ org.bouncycastle.util.j.e(i18, 24));
            int i19 = iA2 ^ i14;
            int i20 = iA4 ^ i16;
            int i21 = i19 ^ i20;
            int iE2 = i21 ^ (org.bouncycastle.util.j.e(i21, 24) ^ org.bouncycastle.util.j.e(i21, 8));
            int i22 = (i17 ^ i13) ^ iE2;
            int i23 = i19 ^ iE;
            int i24 = (iA3 ^ i15) ^ iE2;
            int i25 = i20 ^ iE;
            i12++;
            if (i12 > 16) {
                org.bouncycastle.util.o.h(i22, bArr2, i11);
                org.bouncycastle.util.o.h(i23, bArr2, i11 + 4);
                org.bouncycastle.util.o.h(i24, bArr2, i11 + 8);
                org.bouncycastle.util.o.h(i25, bArr2, i11 + 12);
                return 16;
            }
            int iE3 = org.bouncycastle.util.j.e(i23, 1);
            int iE4 = org.bouncycastle.util.j.e(i24, 5);
            int iE5 = org.bouncycastle.util.j.e(i25, 2);
            int i26 = iE3 ^ (iE5 | iE4);
            int i27 = ~i26;
            int i28 = i22 ^ (iE4 & i27);
            int i29 = (iE4 ^ (i27 ^ iE5)) ^ i28;
            int i30 = i26 ^ (i28 | i29);
            int i31 = iE5 ^ (i29 & i30);
            iA2 = org.bouncycastle.util.j.e(i30, 31);
            iA3 = org.bouncycastle.util.j.e(i29, 27);
            int iE6 = org.bouncycastle.util.j.e(i28, 30);
            iA = i31;
            iA4 = iE6;
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
