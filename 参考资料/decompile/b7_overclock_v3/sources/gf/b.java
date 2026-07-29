package gf;

import af.d;
import com.google.zxing.FormatException;
import java.text.DecimalFormat;
import jt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f29380a = 65520;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f29381b = 65521;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f29382c = 65522;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f29383d = 65523;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f29384e = 65524;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char f29385f = 65525;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final char f29386g = 65526;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f29387h = 65527;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f29388i = 65528;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f29389j = 65529;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f29390k = 65530;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char f29391l = 65531;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char f29392m = 65532;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char f29393n = 28;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final char f29394o = 29;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final char f29395p = 30;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f29396q = {53, 54, rc.a.f48411c0, rc.a.f48412d0, rc.a.f48413e0, rc.a.f48414f0, 47, l.f36949q, rc.a.X, rc.a.Y};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f29397r = {55, 56, 57, 58, 59, 60, 49, 50, 51, 52};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f29398s = {rc.a.Z, 40, rc.a.f48409a0, 42, 31, 32};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f29399t = {rc.a.V, 34, 35, rc.a.W, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte[][] f29400u = {new byte[]{rc.a.Z, 40, rc.a.f48409a0, 42, 31, 32}, new byte[]{rc.a.V, 34, 35, rc.a.W, 25, 26}, new byte[]{27, 28, 29, 30, 19, 20}, new byte[]{21, 22, 23, 24, 13, 14}, new byte[]{15, 16, 17, 18, 7, 8}, new byte[]{9, 10, 11, 12, 1, 2}};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f29401v = {"\rABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001e\ufffbÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8"};

    public static d a(byte[] bArr, int i10) throws FormatException {
        String strH;
        StringBuilder sb2 = new StringBuilder(144);
        if (i10 == 2 || i10 == 3) {
            if (i10 == 2) {
                int iF = f(bArr);
                int iG = g(bArr);
                if (iG > 10) {
                    throw FormatException.b();
                }
                strH = new DecimalFormat("0000000000".substring(0, iG)).format(iF);
            } else {
                strH = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c(bArr));
            String str2 = decimalFormat.format(i(bArr));
            sb2.append(e(bArr, 10, 84));
            if (sb2.toString().startsWith("[)>\u001e01\u001d")) {
                sb2.insert(9, strH + f29394o + str + f29394o + str2 + f29394o);
            } else {
                sb2.insert(0, strH + f29394o + str + f29394o + str2 + f29394o);
            }
        } else if (i10 == 4) {
            sb2.append(e(bArr, 1, 93));
        } else if (i10 == 5) {
            sb2.append(e(bArr, 1, 77));
        }
        return new d(bArr, sb2.toString(), null, String.valueOf(i10));
    }

    public static int b(int i10, byte[] bArr) {
        int i11 = i10 - 1;
        return ((1 << (5 - (i11 % 6))) & bArr[i11 / 6]) == 0 ? 0 : 1;
    }

    public static int c(byte[] bArr) {
        return d(bArr, f29396q);
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        int iB = 0;
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            iB += b(bArr2[i10], bArr) << ((bArr2.length - i10) - 1);
        }
        return iB;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String e(byte[] bArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = i10;
        int i13 = 0;
        int i14 = -1;
        int i15 = 0;
        while (i12 < i10 + i11) {
            char cCharAt = f29401v[i13].charAt(bArr[i12]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i15 = i13;
                    i13 = cCharAt - f29380a;
                    i14 = 1;
                    break;
                case 65525:
                    i14 = 2;
                    i15 = i13;
                    i13 = 0;
                    break;
                case 65526:
                    i14 = 3;
                    i15 = i13;
                    i13 = 0;
                    break;
                case 65527:
                    i13 = 0;
                    i14 = -1;
                    break;
                case 65528:
                    i13 = 1;
                    i14 = -1;
                    break;
                case 65529:
                    i14 = -1;
                    break;
                case 65530:
                default:
                    sb2.append(cCharAt);
                    break;
                case 65531:
                    int i16 = i12 + 1;
                    int i17 = bArr[i16] << 24;
                    int i18 = i16 + 1;
                    int i19 = i17 + (bArr[i18] << 18);
                    int i20 = i18 + 1;
                    int i21 = i19 + (bArr[i20] << 12);
                    int i22 = i20 + 1;
                    int i23 = i21 + (bArr[i22] << 6);
                    i12 = i22 + 1;
                    sb2.append(new DecimalFormat("000000000").format(i23 + bArr[i12]));
                    break;
            }
            int i24 = i14 - 1;
            if (i14 == 0) {
                i13 = i15;
            }
            i12++;
            i14 = i24;
        }
        while (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == 65532) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, f29399t);
    }

    public static int g(byte[] bArr) {
        return d(bArr, f29398s);
    }

    public static String h(byte[] bArr) {
        byte[][] bArr2 = f29400u;
        StringBuilder sb2 = new StringBuilder(bArr2.length);
        for (byte[] bArr3 : bArr2) {
            sb2.append(f29401v[0].charAt(d(bArr, bArr3)));
        }
        return sb2.toString();
    }

    public static int i(byte[] bArr) {
        return d(bArr, f29397r);
    }
}
