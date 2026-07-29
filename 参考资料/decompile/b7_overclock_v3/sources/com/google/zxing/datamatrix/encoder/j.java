package com.google.zxing.datamatrix.encoder;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f21333a = 129;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f21334b = 230;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f21335c = 231;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f21336d = 235;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f21337e = 236;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char f21338f = 237;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char f21339g = 238;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f21340h = 239;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f21341i = 240;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f21342j = 254;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f21343k = 254;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f21344l = "[)>\u001e05\u001d";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f21345m = "[)>\u001e06\u001d";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f21346n = "\u001e\u0004";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f21347o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f21348p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21349q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f21350r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f21351s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f21352t = 5;

    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = i10;
        while (i11 < length && h(charSequence.charAt(i11))) {
            i11++;
        }
        return i11 - i10;
    }

    public static String b(String str) {
        return d(str, SymbolShapeHint.FORCE_NONE, null, null, false);
    }

    public static String c(String str, SymbolShapeHint symbolShapeHint, ve.c cVar, ve.c cVar2) {
        return d(str, symbolShapeHint, cVar, cVar2, false);
    }

    public static String d(String str, SymbolShapeHint symbolShapeHint, ve.c cVar, ve.c cVar2, boolean z10) {
        c cVar3 = new c();
        int iF = 0;
        g[] gVarArr = {new a(), cVar3, new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.o(symbolShapeHint);
        hVar.m(cVar, cVar2);
        if (str.startsWith(f21344l) && str.endsWith(f21346n)) {
            hVar.s(f21337e);
            hVar.n(2);
            hVar.f21324f += 7;
        } else if (str.startsWith(f21345m) && str.endsWith(f21346n)) {
            hVar.s(f21338f);
            hVar.n(2);
            hVar.f21324f += 7;
        }
        if (z10) {
            cVar3.e(hVar);
            iF = hVar.f();
            hVar.k();
        }
        while (hVar.j()) {
            gVarArr[iF].b(hVar);
            if (hVar.f() >= 0) {
                iF = hVar.f();
                hVar.k();
            }
        }
        int iA = hVar.a();
        hVar.q();
        int iB = hVar.h().b();
        if (iA < iB && iF != 0 && iF != 5 && iF != 4) {
            hVar.s((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iB) {
            sbB.append(f21333a);
        }
        while (sbB.length() < iB) {
            sbB.append(t(sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    public static int e(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        for (int i11 = 0; i11 < 6; i11++) {
            int iCeil = (int) Math.ceil(fArr[i11]);
            iArr[i11] = iCeil;
            if (i10 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i10 = iCeil;
            }
            if (i10 == iCeil) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    public static int f(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    public static void g(char c10) {
        String hexString = Integer.toHexString(c10);
        throw new IllegalArgumentException("Illegal character: " + c10 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean h(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public static boolean i(char c10) {
        return c10 >= 128 && c10 <= 255;
    }

    public static boolean j(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    public static boolean k(char c10) {
        return c10 >= ' ' && c10 <= '^';
    }

    public static boolean l(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'a' && c10 <= 'z');
    }

    public static boolean m(char c10) {
        return o(c10) || c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    public static boolean n(char c10) {
        return false;
    }

    public static boolean o(char c10) {
        return c10 == '\r' || c10 == '*' || c10 == '>';
    }

    public static int p(CharSequence charSequence, int i10, int i11) {
        int iQ = q(charSequence, i10, i11);
        if (i11 == 3 && iQ == 3) {
            int iMin = Math.min(i10 + 3, charSequence.length());
            while (i10 < iMin) {
                if (!m(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        } else if (i11 == 4 && iQ == 4) {
            int iMin2 = Math.min(i10 + 4, charSequence.length());
            while (i10 < iMin2) {
                if (!k(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        }
        return iQ;
    }

    public static int q(CharSequence charSequence, int i10, int i11) {
        float[] fArr;
        char c10;
        if (i10 >= charSequence.length()) {
            return i11;
        }
        if (i11 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i11] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        byte b10 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i10 + i12;
            if (i13 == charSequence.length()) {
                Arrays.fill(bArr, b10);
                Arrays.fill(iArr, (int) b10);
                int iE = e(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iF = f(bArr);
                if (iArr[b10] == iE) {
                    return b10;
                }
                if (iF == 1) {
                    if (bArr[5] > 0) {
                        return 5;
                    }
                    if (bArr[4] > 0) {
                        return 4;
                    }
                    if (bArr[2] > 0) {
                        return 2;
                    }
                    if (bArr[3] > 0) {
                        return 3;
                    }
                }
                return 1;
            }
            char cCharAt = charSequence.charAt(i13);
            i12++;
            if (h(cCharAt)) {
                fArr[b10] = fArr[b10] + 0.5f;
            } else if (i(cCharAt)) {
                fArr[b10] = (float) Math.ceil(fArr[b10]);
                fArr[b10] = fArr[b10] + 2.0f;
            } else {
                fArr[b10] = (float) Math.ceil(fArr[b10]);
                fArr[b10] = fArr[b10] + 1.0f;
            }
            if (j(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (l(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (m(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (k(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (i(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (n(cCharAt)) {
                c10 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c10 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i12 >= 4) {
                Arrays.fill(bArr, b10);
                Arrays.fill(iArr, (int) b10);
                e(fArr, iArr, Integer.MAX_VALUE, bArr);
                if (iArr[b10] < s(iArr[c10], iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return b10;
                }
                if (iArr[c10] < iArr[b10] || iArr[c10] + 1 < r(iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return 5;
                }
                if (iArr[4] + 1 < s(iArr[c10], iArr[1], iArr[2], iArr[3], iArr[0])) {
                    return 4;
                }
                if (iArr[2] + 1 < s(iArr[c10], iArr[1], iArr[4], iArr[3], iArr[0])) {
                    return 2;
                }
                if (iArr[3] + 1 < s(iArr[c10], iArr[1], iArr[4], iArr[2], iArr[0])) {
                    return 3;
                }
                if (iArr[1] + 1 >= r(iArr[0], iArr[c10], iArr[4], iArr[2])) {
                    continue;
                } else {
                    if (iArr[1] < iArr[3]) {
                        return 1;
                    }
                    if (iArr[1] == iArr[3]) {
                        for (int i14 = i10 + i12 + 1; i14 < charSequence.length(); i14++) {
                            char cCharAt2 = charSequence.charAt(i14);
                            if (o(cCharAt2)) {
                                return 3;
                            }
                            if (!m(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            b10 = 0;
        }
    }

    public static int r(int i10, int i11, int i12, int i13) {
        return Math.min(i10, Math.min(i11, Math.min(i12, i13)));
    }

    public static int s(int i10, int i11, int i12, int i13, int i14) {
        return Math.min(r(i10, i11, i12, i13), i14);
    }

    public static char t(int i10) {
        int i11 = ((i10 * WaspWingInfo.COLD_LEVEL_STANDARD_B7) % 253) + 1 + 129;
        if (i11 > 254) {
            i11 -= 254;
        }
        return (char) i11;
    }
}
