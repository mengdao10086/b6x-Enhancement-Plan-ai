package jt;

import okio.w0;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f36933a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f36934b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f36935c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f36936d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f36937e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f36938f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f36939g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f36940h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f36941i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f36942j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f36943k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f36944l = -2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f36945m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f36946n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f36947o = 16;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f36948p = 32;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte f36949q = 48;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte f36950r = 64;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte f36951s = 80;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f36952t = 96;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final short[] f36953u = new short[128];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte[] f36954v;

    static {
        byte[] bArr = new byte[112];
        f36954v = bArr;
        byte[] bArr2 = new byte[128];
        a(bArr2, 0, 15, (byte) 1);
        a(bArr2, 16, 31, (byte) 2);
        a(bArr2, 32, 63, (byte) 3);
        a(bArr2, 64, 65, (byte) 0);
        a(bArr2, 66, 95, (byte) 4);
        a(bArr2, 96, 96, (byte) 5);
        a(bArr2, 97, 108, (byte) 6);
        a(bArr2, 109, 109, (byte) 7);
        a(bArr2, 110, 111, (byte) 6);
        a(bArr2, 112, 112, (byte) 8);
        a(bArr2, 113, 115, (byte) 9);
        a(bArr2, 116, 116, (byte) 10);
        a(bArr2, 117, 127, (byte) 0);
        a(bArr, 0, bArr.length - 1, (byte) -2);
        a(bArr, 8, 11, (byte) -1);
        a(bArr, 24, 27, (byte) 0);
        a(bArr, 40, 43, (byte) 16);
        a(bArr, 58, 59, (byte) 0);
        a(bArr, 72, 73, (byte) 0);
        a(bArr, 89, 91, (byte) 16);
        a(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, f36949q, 16, 64, f36951s, 32, f36952t};
        for (int i10 = 0; i10 < 128; i10++) {
            byte b10 = bArr2[i10];
            f36953u[i10] = (short) (bArr4[b10] | ((bArr3[b10] & i10) << 8));
        }
    }

    public static void a(byte[] bArr, int i10, int i11, byte b10) {
        while (i10 <= i11) {
            bArr[i10] = b10;
            i10++;
        }
    }

    public static int b(byte[] bArr, char[] cArr) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 < 0) {
                short s10 = f36953u[b10 & 127];
                int i13 = s10 >>> 8;
                byte b11 = (byte) s10;
                while (b11 >= 0) {
                    if (i12 >= bArr.length) {
                        return -1;
                    }
                    int i14 = i12 + 1;
                    byte b12 = bArr[i12];
                    i13 = (i13 << 6) | (b12 & w0.f44229a);
                    b11 = f36954v[b11 + ((b12 & 255) >>> 4)];
                    i12 = i14;
                }
                if (b11 == -2) {
                    return -1;
                }
                if (i13 <= 65535) {
                    if (i11 >= cArr.length) {
                        return -1;
                    }
                    cArr[i11] = (char) i13;
                    i11++;
                } else {
                    if (i11 >= cArr.length - 1) {
                        return -1;
                    }
                    int i15 = i11 + 1;
                    cArr[i11] = (char) ((i13 >>> 10) + w0.f44232d);
                    i11 = i15 + 1;
                    cArr[i15] = (char) (56320 | (i13 & 1023));
                }
                i10 = i12;
            } else {
                if (i11 >= cArr.length) {
                    return -1;
                }
                cArr[i11] = (char) b10;
                i10 = i12;
                i11++;
            }
        }
        return i11;
    }
}
