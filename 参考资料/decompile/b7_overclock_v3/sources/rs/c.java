package rs;

import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49151a = 12;

    public static void b(int i10, int[] iArr) {
        int i11 = 16;
        if (iArr.length != 16) {
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
        int i26 = iArr[12];
        int i27 = iArr[13];
        int i28 = iArr[14];
        int iC = iArr[15];
        int iC2 = i28;
        int iC3 = i27;
        int iC4 = i26;
        int i29 = i25;
        int i30 = i24;
        int i31 = i23;
        int i32 = i22;
        int iC5 = i20;
        int iC6 = i18;
        int iC7 = i17;
        int iC8 = i16;
        int i33 = i15;
        int i34 = i14;
        int i35 = i13;
        int i36 = i12;
        int i37 = i10;
        while (i37 > 0) {
            int i38 = i36 + iC8;
            int iC9 = c(iC4 ^ i38, i11);
            int i39 = i32 + iC9;
            int iC10 = c(iC8 ^ i39, 12);
            int i40 = i38 + iC10;
            int iC11 = c(iC9 ^ i40, i21);
            int i41 = i39 + iC11;
            int iC12 = c(iC10 ^ i41, i19);
            int i42 = i35 + iC7;
            int iC13 = c(iC3 ^ i42, i11);
            int i43 = i31 + iC13;
            int iC14 = c(iC7 ^ i43, 12);
            int i44 = i42 + iC14;
            int iC15 = c(iC13 ^ i44, i21);
            int i45 = i43 + iC15;
            int iC16 = c(iC14 ^ i45, i19);
            int i46 = i34 + iC6;
            int iC17 = c(iC2 ^ i46, i11);
            int i47 = i30 + iC17;
            int iC18 = c(iC6 ^ i47, 12);
            int i48 = i46 + iC18;
            int iC19 = c(iC17 ^ i48, i21);
            int i49 = i47 + iC19;
            int iC20 = c(iC18 ^ i49, i19);
            int i50 = i33 + iC5;
            int iC21 = c(iC ^ i50, i11);
            int i51 = i29 + iC21;
            int iC22 = c(iC5 ^ i51, 12);
            int i52 = i50 + iC22;
            int iC23 = c(iC21 ^ i52, i21);
            int i53 = i51 + iC23;
            int iC24 = c(iC22 ^ i53, 7);
            int i54 = i40 + iC16;
            int iC25 = c(iC23 ^ i54, 16);
            int i55 = i49 + iC25;
            int iC26 = c(iC16 ^ i55, 12);
            i36 = i54 + iC26;
            iC = c(iC25 ^ i36, 8);
            i30 = i55 + iC;
            iC7 = c(iC26 ^ i30, 7);
            int i56 = i44 + iC20;
            int iC27 = c(iC11 ^ i56, 16);
            int i57 = i53 + iC27;
            int iC28 = c(iC20 ^ i57, 12);
            i35 = i56 + iC28;
            iC4 = c(iC27 ^ i35, 8);
            i29 = i57 + iC4;
            iC6 = c(iC28 ^ i29, 7);
            int i58 = i48 + iC24;
            int iC29 = c(iC15 ^ i58, 16);
            int i59 = i41 + iC29;
            int iC30 = c(iC24 ^ i59, 12);
            i34 = i58 + iC30;
            iC3 = c(iC29 ^ i34, 8);
            i32 = i59 + iC3;
            iC5 = c(iC30 ^ i32, 7);
            int i60 = i52 + iC12;
            i11 = 16;
            int iC31 = c(iC19 ^ i60, 16);
            int i61 = i45 + iC31;
            int iC32 = c(iC12 ^ i61, 12);
            i33 = i60 + iC32;
            iC2 = c(iC31 ^ i33, 8);
            i31 = i61 + iC2;
            iC8 = c(iC32 ^ i31, 7);
            i37 -= 2;
            c10 = 0;
            i21 = 8;
            i19 = 7;
        }
        iArr[c10] = i36;
        iArr[1] = i35;
        iArr[2] = i34;
        iArr[3] = i33;
        iArr[4] = iC8;
        iArr[5] = iC7;
        iArr[6] = iC6;
        iArr[7] = iC5;
        iArr[8] = i32;
        iArr[9] = i31;
        iArr[10] = i30;
        iArr[11] = i29;
        iArr[12] = iC4;
        iArr[13] = iC3;
        iArr[14] = iC2;
        iArr[15] = iC;
    }

    public static int c(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    public void a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[16];
        for (int i10 = 0; i10 < 16; i10++) {
            iArr[i10] = o.r(bArr2, i10 * 4);
        }
        b(12, iArr);
        for (int i11 = 0; i11 < 16; i11++) {
            o.m(iArr[i11], bArr, i11 * 4);
        }
    }
}
