package cp;

/* JADX INFO: loaded from: classes5.dex */
public class p extends f1 {
    public p() {
    }

    public p(int i10) {
        super(i10);
    }

    public static void t(int i10, int[] iArr, int[] iArr2) {
        int i11 = 16;
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i10 % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        char c10 = 0;
        int i12 = iArr[0];
        int i13 = iArr[1];
        int i14 = iArr[2];
        int i15 = iArr[3];
        int i16 = iArr[4];
        int i17 = iArr[5];
        int i18 = iArr[6];
        int i19 = 7;
        int i20 = iArr[7];
        int i21 = 8;
        int i22 = iArr[8];
        int i23 = iArr[9];
        int i24 = iArr[10];
        int i25 = iArr[11];
        int i26 = 12;
        int i27 = iArr[12];
        int i28 = iArr[13];
        int i29 = iArr[14];
        int iE = iArr[15];
        int iE2 = i29;
        int iE3 = i28;
        int iE4 = i27;
        int i30 = i25;
        int i31 = i24;
        int i32 = i23;
        int i33 = i22;
        int iE5 = i20;
        int iE6 = i18;
        int iE7 = i17;
        int iE8 = i16;
        int i34 = i15;
        int i35 = i14;
        int i36 = i13;
        int i37 = i12;
        int i38 = i10;
        while (i38 > 0) {
            int i39 = i37 + iE8;
            int iE9 = org.bouncycastle.util.j.e(iE4 ^ i39, i11);
            int i40 = i33 + iE9;
            int iE10 = org.bouncycastle.util.j.e(iE8 ^ i40, i26);
            int i41 = i39 + iE10;
            int iE11 = org.bouncycastle.util.j.e(iE9 ^ i41, i21);
            int i42 = i40 + iE11;
            int iE12 = org.bouncycastle.util.j.e(iE10 ^ i42, i19);
            int i43 = i36 + iE7;
            int iE13 = org.bouncycastle.util.j.e(iE3 ^ i43, i11);
            int i44 = i32 + iE13;
            int iE14 = org.bouncycastle.util.j.e(iE7 ^ i44, i26);
            int i45 = i43 + iE14;
            int iE15 = org.bouncycastle.util.j.e(iE13 ^ i45, i21);
            int i46 = i44 + iE15;
            int iE16 = org.bouncycastle.util.j.e(iE14 ^ i46, i19);
            int i47 = i35 + iE6;
            int iE17 = org.bouncycastle.util.j.e(iE2 ^ i47, i11);
            int i48 = i31 + iE17;
            int iE18 = org.bouncycastle.util.j.e(iE6 ^ i48, i26);
            int i49 = i47 + iE18;
            int iE19 = org.bouncycastle.util.j.e(iE17 ^ i49, i21);
            int i50 = i48 + iE19;
            int iE20 = org.bouncycastle.util.j.e(iE18 ^ i50, i19);
            int i51 = i34 + iE5;
            int iE21 = org.bouncycastle.util.j.e(iE ^ i51, 16);
            int i52 = i30 + iE21;
            int iE22 = org.bouncycastle.util.j.e(iE5 ^ i52, i26);
            int i53 = i51 + iE22;
            int iE23 = org.bouncycastle.util.j.e(iE21 ^ i53, 8);
            int i54 = i52 + iE23;
            int iE24 = org.bouncycastle.util.j.e(iE22 ^ i54, 7);
            int i55 = i41 + iE16;
            int iE25 = org.bouncycastle.util.j.e(iE23 ^ i55, 16);
            int i56 = i50 + iE25;
            int iE26 = org.bouncycastle.util.j.e(iE16 ^ i56, 12);
            i37 = i55 + iE26;
            iE = org.bouncycastle.util.j.e(iE25 ^ i37, 8);
            i31 = i56 + iE;
            iE7 = org.bouncycastle.util.j.e(iE26 ^ i31, 7);
            int i57 = i45 + iE20;
            int iE27 = org.bouncycastle.util.j.e(iE11 ^ i57, 16);
            int i58 = i54 + iE27;
            int iE28 = org.bouncycastle.util.j.e(iE20 ^ i58, 12);
            i36 = i57 + iE28;
            iE4 = org.bouncycastle.util.j.e(iE27 ^ i36, 8);
            i30 = i58 + iE4;
            iE6 = org.bouncycastle.util.j.e(iE28 ^ i30, 7);
            int i59 = i49 + iE24;
            int iE29 = org.bouncycastle.util.j.e(iE15 ^ i59, 16);
            int i60 = i42 + iE29;
            int iE30 = org.bouncycastle.util.j.e(iE24 ^ i60, 12);
            i35 = i59 + iE30;
            iE3 = org.bouncycastle.util.j.e(iE29 ^ i35, 8);
            i33 = i60 + iE3;
            iE5 = org.bouncycastle.util.j.e(iE30 ^ i33, 7);
            int i61 = i53 + iE12;
            i11 = 16;
            int iE31 = org.bouncycastle.util.j.e(iE19 ^ i61, 16);
            int i62 = i46 + iE31;
            int iE32 = org.bouncycastle.util.j.e(iE12 ^ i62, 12);
            i34 = i61 + iE32;
            iE2 = org.bouncycastle.util.j.e(iE31 ^ i34, 8);
            i32 = i62 + iE2;
            iE8 = org.bouncycastle.util.j.e(iE32 ^ i32, 7);
            i38 -= 2;
            c10 = 0;
            i26 = 12;
            i21 = 8;
            i19 = 7;
        }
        iArr2[c10] = i37 + iArr[c10];
        iArr2[1] = i36 + iArr[1];
        iArr2[2] = i35 + iArr[2];
        iArr2[3] = i34 + iArr[3];
        iArr2[4] = iE8 + iArr[4];
        iArr2[5] = iE7 + iArr[5];
        iArr2[6] = iE6 + iArr[6];
        iArr2[7] = iE5 + iArr[7];
        iArr2[8] = i33 + iArr[8];
        iArr2[9] = i32 + iArr[9];
        iArr2[10] = i31 + iArr[10];
        iArr2[11] = i30 + iArr[11];
        iArr2[12] = iE4 + iArr[12];
        iArr2[13] = iE3 + iArr[13];
        iArr2[14] = iE2 + iArr[14];
        iArr2[15] = iE + iArr[15];
    }

    @Override // cp.f1, org.bouncycastle.crypto.k0
    public String b() {
        return "ChaCha" + this.f25290a;
    }

    @Override // cp.f1
    public void c() {
        int[] iArr = this.f25292c;
        int i10 = iArr[12] + 1;
        iArr[12] = i10;
        if (i10 == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    @Override // cp.f1
    public void d(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 > 0) {
            int[] iArr = this.f25292c;
            iArr[13] = iArr[13] + i10;
        }
        int[] iArr2 = this.f25292c;
        int i12 = iArr2[12];
        iArr2[12] = iArr2[12] + i11;
        if (i12 == 0 || iArr2[12] >= i12) {
            return;
        }
        iArr2[13] = iArr2[13] + 1;
    }

    @Override // cp.f1
    public void h(byte[] bArr) {
        t(this.f25290a, this.f25292c, this.f25293d);
        org.bouncycastle.util.o.o(this.f25293d, bArr, 0);
    }

    @Override // cp.f1
    public long i() {
        int[] iArr = this.f25292c;
        return (((long) iArr[13]) << 32) | (((long) iArr[12]) & 4294967295L);
    }

    @Override // cp.f1
    public void n() {
        int[] iArr = this.f25292c;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    @Override // cp.f1
    public void p() {
        int[] iArr = this.f25292c;
        if (iArr[12] == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i10 = iArr[12] - 1;
        iArr[12] = i10;
        if (i10 == -1) {
            iArr[13] = iArr[13] - 1;
        }
    }

    @Override // cp.f1
    public void q(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 != 0) {
            int[] iArr = this.f25292c;
            if ((((long) iArr[13]) & 4294967295L) < (((long) i10) & 4294967295L)) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr[13] = iArr[13] - i10;
        }
        int[] iArr2 = this.f25292c;
        if ((((long) iArr2[12]) & 4294967295L) >= (4294967295L & ((long) i11))) {
            iArr2[12] = iArr2[12] - i11;
        } else {
            if (iArr2[13] == 0) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr2[13] = iArr2[13] - 1;
            iArr2[12] = iArr2[12] - i11;
        }
    }

    @Override // cp.f1
    public void s(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(b() + " requires 128 bit or 256 bit key");
            }
            m(bArr.length, this.f25292c, 0);
            org.bouncycastle.util.o.t(bArr, 0, this.f25292c, 4, 4);
            org.bouncycastle.util.o.t(bArr, bArr.length - 16, this.f25292c, 8, 4);
        }
        org.bouncycastle.util.o.t(bArr2, 0, this.f25292c, 14, 2);
    }
}
