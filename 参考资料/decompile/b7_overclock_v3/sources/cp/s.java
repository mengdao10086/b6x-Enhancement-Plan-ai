package cp;

import android.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kg.c;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class s implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25627b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short[] f25628c = {c.a.Z4, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f25629d = {8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f25630e = {56, jt.l.f36949q, 40, 32, 24, 16, 8, 0, 57, 49, rc.a.f48409a0, rc.a.V, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, rc.a.f48411c0, 35, 62, 54, rc.a.f48414f0, rc.a.Y, 30, 22, 14, 6, 61, 53, rc.a.f48413e0, rc.a.X, 29, 21, 13, 5, 60, 52, rc.a.f48412d0, rc.a.W, 28, 20, 12, 4, 27, 19, 11, 3};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f25631f = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f25632g = {13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, rc.a.W, rc.a.f48414f0, 54, 29, rc.a.Z, 50, rc.a.f48412d0, 32, 47, rc.a.f48411c0, jt.l.f36949q, rc.a.Y, 55, rc.a.V, 52, rc.a.f48413e0, rc.a.f48409a0, 49, 35, 28, 31};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f25633h = {R.attr.transitionName, 0, 65536, R.attr.fillColor, R.attr.manageSpaceActivity, 66564, 4, 65536, 1024, R.attr.transitionName, R.attr.fillColor, 1024, 16778244, R.attr.manageSpaceActivity, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, R.attr.theme, R.attr.theme, 16778244, androidx.core.view.n.f5044o, 16777220, 16777220, androidx.core.view.n.f5044o, 0, 1028, 66564, 16777216, 65536, R.attr.fillColor, 4, R.attr.theme, R.attr.transitionName, 16777216, 16777216, 1024, R.attr.manageSpaceActivity, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, R.attr.fillColor, androidx.core.view.n.f5044o, R.attr.theme, 16778244, 16777220, 1028, 66564, R.attr.transitionName, 1028, 16778240, 16778240, 0, androidx.core.view.n.f5044o, 66560, 0, R.attr.manageSpaceActivity};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f25634i = {-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, com.umeng.commonsdk.internal.a.B, -2146402304, -2146435072, com.umeng.commonsdk.internal.a.B, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, com.umeng.commonsdk.internal.a.B, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, com.umeng.commonsdk.internal.a.B, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f25635j = {gg.b.f29446i0, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, gg.b.f29446i0, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, gg.b.f29446i0, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, gg.b.f29446i0, 134348800, 131592, 8, 134348808, 131584};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f25636k = {8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f25637l = {256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, CommonNetImpl.FLAG_SHARE_JUMP, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, CommonNetImpl.FLAG_SHARE_JUMP, 1107296256, 524544, 524288, 1107296512, 256, CommonNetImpl.FLAG_SHARE_JUMP, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, CommonNetImpl.FLAG_SHARE_JUMP, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f25638m = {536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f25639n = {2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, com.umeng.analytics.pro.i.f23599b, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, com.umeng.analytics.pro.i.f23599b, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, com.umeng.analytics.pro.i.f23599b, 2099202, 69208064, com.umeng.analytics.pro.i.f23599b, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f25640o = {268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25641a = null;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to DES init - " + kVar.getClass().getName());
        }
        np.n1 n1Var = (np.n1) kVar;
        if (n1Var.a().length > 8) {
            throw new IllegalArgumentException("DES key too long - should be 8 bytes");
        }
        this.f25641a = f(z10, n1Var.a());
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "DES";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.f25641a;
        if (iArr == null) {
            throw new IllegalStateException("DES engine not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        e(iArr, bArr, i10, bArr2, i11);
        return 8;
    }

    public void e(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iA = org.bouncycastle.util.o.a(bArr, i10);
        int iA2 = org.bouncycastle.util.o.a(bArr, i10 + 4);
        int i12 = ((iA >>> 4) ^ iA2) & 252645135;
        int i13 = iA2 ^ i12;
        int i14 = iA ^ (i12 << 4);
        int i15 = ((i14 >>> 16) ^ i13) & 65535;
        int i16 = i13 ^ i15;
        int i17 = i14 ^ (i15 << 16);
        int i18 = ((i16 >>> 2) ^ i17) & 858993459;
        int i19 = i17 ^ i18;
        int i20 = i16 ^ (i18 << 2);
        int i21 = ((i20 >>> 8) ^ i19) & 16711935;
        int i22 = i19 ^ i21;
        int i23 = i20 ^ (i21 << 8);
        int i24 = (i23 >>> 31) | (i23 << 1);
        int i25 = (i22 ^ i24) & (-1431655766);
        int i26 = i22 ^ i25;
        int i27 = i24 ^ i25;
        int i28 = (i26 >>> 31) | (i26 << 1);
        for (int i29 = 0; i29 < 8; i29++) {
            int i30 = i29 * 4;
            int i31 = ((i27 << 28) | (i27 >>> 4)) ^ iArr[i30 + 0];
            int[] iArr2 = f25639n;
            int i32 = iArr2[i31 & 63];
            int[] iArr3 = f25637l;
            int i33 = i32 | iArr3[(i31 >>> 8) & 63];
            int[] iArr4 = f25635j;
            int i34 = i33 | iArr4[(i31 >>> 16) & 63];
            int[] iArr5 = f25633h;
            int i35 = iArr5[(i31 >>> 24) & 63] | i34;
            int i36 = iArr[i30 + 1] ^ i27;
            int[] iArr6 = f25640o;
            int i37 = i35 | iArr6[i36 & 63];
            int[] iArr7 = f25638m;
            int i38 = i37 | iArr7[(i36 >>> 8) & 63];
            int[] iArr8 = f25636k;
            int i39 = i38 | iArr8[(i36 >>> 16) & 63];
            int[] iArr9 = f25634i;
            i28 ^= i39 | iArr9[(i36 >>> 24) & 63];
            int i40 = ((i28 << 28) | (i28 >>> 4)) ^ iArr[i30 + 2];
            int i41 = iArr5[(i40 >>> 24) & 63] | iArr2[i40 & 63] | iArr3[(i40 >>> 8) & 63] | iArr4[(i40 >>> 16) & 63];
            int i42 = iArr[i30 + 3] ^ i28;
            i27 ^= (((i41 | iArr6[i42 & 63]) | iArr7[(i42 >>> 8) & 63]) | iArr8[(i42 >>> 16) & 63]) | iArr9[(i42 >>> 24) & 63];
        }
        int i43 = (i27 >>> 1) | (i27 << 31);
        int i44 = (i28 ^ i43) & (-1431655766);
        int i45 = i28 ^ i44;
        int i46 = i43 ^ i44;
        int i47 = (i45 >>> 1) | (i45 << 31);
        int i48 = ((i47 >>> 8) ^ i46) & 16711935;
        int i49 = i46 ^ i48;
        int i50 = i47 ^ (i48 << 8);
        int i51 = ((i50 >>> 2) ^ i49) & 858993459;
        int i52 = i49 ^ i51;
        int i53 = i50 ^ (i51 << 2);
        int i54 = ((i52 >>> 16) ^ i53) & 65535;
        int i55 = i53 ^ i54;
        int i56 = i52 ^ (i54 << 16);
        int i57 = ((i56 >>> 4) ^ i55) & 252645135;
        org.bouncycastle.util.o.h(i56 ^ (i57 << 4), bArr2, i11);
        org.bouncycastle.util.o.h(i55 ^ i57, bArr2, i11 + 4);
    }

    public int[] f(boolean z10, byte[] bArr) {
        int i10;
        int[] iArr = new int[32];
        boolean[] zArr = new boolean[56];
        boolean[] zArr2 = new boolean[56];
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= 56) {
                break;
            }
            byte b10 = f25630e[i11];
            if ((f25628c[b10 & 7] & bArr[b10 >>> 3]) == 0) {
                z11 = false;
            }
            zArr[i11] = z11;
            i11++;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = z10 ? i12 << 1 : (15 - i12) << 1;
            int i14 = i13 + 1;
            iArr[i14] = 0;
            iArr[i13] = 0;
            int i15 = 0;
            while (true) {
                if (i15 >= 28) {
                    break;
                }
                int i16 = f25631f[i12] + i15;
                if (i16 < 28) {
                    zArr2[i15] = zArr[i16];
                } else {
                    zArr2[i15] = zArr[i16 - 28];
                }
                i15++;
            }
            for (i10 = 28; i10 < 56; i10++) {
                int i17 = f25631f[i12] + i10;
                if (i17 < 56) {
                    zArr2[i10] = zArr[i17];
                } else {
                    zArr2[i10] = zArr[i17 - 28];
                }
            }
            for (int i18 = 0; i18 < 24; i18++) {
                byte[] bArr2 = f25632g;
                if (zArr2[bArr2[i18]]) {
                    iArr[i13] = iArr[i13] | f25629d[i18];
                }
                if (zArr2[bArr2[i18 + 24]]) {
                    iArr[i14] = iArr[i14] | f25629d[i18];
                }
            }
        }
        for (int i19 = 0; i19 != 32; i19 += 2) {
            int i20 = iArr[i19];
            int i21 = i19 + 1;
            int i22 = iArr[i21];
            iArr[i19] = ((16515072 & i22) >>> 10) | ((i20 & 16515072) << 6) | ((i20 & 4032) << 10) | ((i22 & 4032) >>> 6);
            iArr[i21] = ((i20 & 63) << 16) | ((i20 & 258048) << 12) | ((258048 & i22) >>> 4) | (i22 & 63);
        }
        return iArr;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
