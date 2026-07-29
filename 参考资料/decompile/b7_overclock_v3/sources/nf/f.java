package nf;

import af.h;
import af.m;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.encoder.Compaction;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import jt.l;
import okio.w0;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42105a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42106b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42107c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42108d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42109e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42110f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42111g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f42112h = 900;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f42113i = 901;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f42114j = 902;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f42115k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f42116l = 924;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f42117m = 925;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f42118n = 926;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f42119o = 927;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f42122r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ boolean f42125u = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f42120p = {l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57, rc.a.Y, 13, 9, rc.a.f48412d0, 58, 35, rc.a.f48413e0, rc.a.f48414f0, rc.a.W, 47, rc.a.f48411c0, rc.a.X, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f42121q = {59, 60, 62, 64, 91, 92, 93, 95, l.f36952t, 126, rc.a.V, 13, 9, rc.a.f48412d0, 58, 10, rc.a.f48413e0, rc.a.f48414f0, rc.a.W, 47, 34, 124, 42, 40, rc.a.f48409a0, w0.f44229a, 123, 125, rc.a.Z, 0};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte[] f42123s = new byte[128];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Charset f42124t = StandardCharsets.ISO_8859_1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42126a;

        static {
            int[] iArr = new int[Compaction.values().length];
            f42126a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42126a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42126a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f42127a;

        public /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // af.h
        public int a(int i10) {
            return -1;
        }

        @Override // af.h
        public boolean b(int i10) {
            return false;
        }

        @Override // af.h
        public boolean c(int i10, int i11) {
            return i10 + i11 <= this.f42127a.length();
        }

        @Override // af.h
        public char charAt(int i10) {
            return this.f42127a.charAt(i10);
        }

        @Override // af.h
        public int length() {
            return this.f42127a.length();
        }

        @Override // af.h
        public CharSequence subSequence(int i10, int i11) {
            return this.f42127a.subSequence(i10, i11);
        }

        public String toString() {
            return this.f42127a;
        }

        public b(String str) {
            this.f42127a = str;
        }
    }

    static {
        byte[] bArr = new byte[128];
        f42122r = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f42120p;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f42122r[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f42123s, (byte) -1);
        while (true) {
            byte[] bArr3 = f42121q;
            if (i10 >= bArr3.length) {
                return;
            }
            byte b11 = bArr3[i10];
            if (b11 > 0) {
                f42123s[b11] = (byte) i10;
            }
            i10++;
        }
    }

    public static int a(h hVar, int i10, Charset charset) throws WriterException {
        CharsetEncoder charsetEncoderNewEncoder = charset == null ? null : charset.newEncoder();
        int length = hVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            int i13 = i11;
            while (i12 < 13 && !hVar.b(i13) && l(hVar.charAt(i13)) && (i13 = i11 + (i12 = i12 + 1)) < length) {
            }
            if (i12 >= 13) {
                return i11 - i10;
            }
            if (charsetEncoderNewEncoder != null && !charsetEncoderNewEncoder.canEncode(hVar.charAt(i11))) {
                char cCharAt = hVar.charAt(i11);
                throw new WriterException("Non-encodable character detected: " + cCharAt + " (Unicode: " + ((int) cCharAt) + ')');
            }
            i11++;
        }
        return i11 - i10;
    }

    public static int b(h hVar, int i10) {
        int length = hVar.length();
        int i11 = 0;
        if (i10 < length) {
            while (i10 < length && !hVar.b(i10) && l(hVar.charAt(i10))) {
                i11++;
                i10++;
            }
        }
        return i11;
    }

    public static int c(h hVar, int i10) {
        int length = hVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            while (i12 < 13 && i11 < length && !hVar.b(i11) && l(hVar.charAt(i11))) {
                i12++;
                i11++;
            }
            if (i12 >= 13) {
                return (i11 - i10) - i12;
            }
            if (i12 <= 0) {
                if (hVar.b(i11) || !o(hVar.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    public static void d(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + ((long) (bArr[i13 + i14] & 255));
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    public static String e(String str, Compaction compaction, Charset charset, boolean z10) throws WriterException {
        h bVar;
        CharacterSetECI characterSetECI;
        if (str.isEmpty()) {
            throw new WriterException("Empty message not allowed");
        }
        if (charset == null && !z10) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                if (str.charAt(i10) > 255) {
                    throw new WriterException("Non-encodable character detected: " + str.charAt(i10) + " (Unicode: " + ((int) str.charAt(i10)) + "). Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET.");
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        a aVar = null;
        if (z10) {
            bVar = new m(str, charset, -1);
        } else {
            bVar = new b(str, aVar);
            if (charset == null) {
                charset = f42124t;
            } else if (!f42124t.equals(charset) && (characterSetECI = CharacterSetECI.getCharacterSetECI(charset)) != null) {
                i(characterSetECI.getValue(), sb2);
            }
        }
        int length = bVar.length();
        int i11 = a.f42126a[compaction.ordinal()];
        if (i11 == 1) {
            h(bVar, 0, length, sb2, 0);
        } else if (i11 != 2) {
            if (i11 != 3) {
                int i12 = 0;
                int iH = 0;
                int i13 = 0;
                while (i12 < length) {
                    while (i12 < length && bVar.b(i12)) {
                        i(bVar.a(i12), sb2);
                        i12++;
                    }
                    if (i12 >= length) {
                        break;
                    }
                    int iB = b(bVar, i12);
                    if (iB >= 13) {
                        sb2.append((char) 902);
                        g(bVar, i12, iB, sb2);
                        i12 += iB;
                        iH = 0;
                        i13 = 2;
                    } else {
                        int iC = c(bVar, i12);
                        if (iC >= 5 || iB == length) {
                            if (i13 != 0) {
                                sb2.append((char) 900);
                                iH = 0;
                                i13 = 0;
                            }
                            iH = h(bVar, i12, iC, sb2, iH);
                            i12 += iC;
                        } else {
                            int iA = a(bVar, i12, z10 ? null : charset);
                            if (iA == 0) {
                                iA = 1;
                            }
                            byte[] bytes = z10 ? null : bVar.subSequence(i12, i12 + iA).toString().getBytes(charset);
                            if ((!(bytes == null && iA == 1) && (bytes == null || bytes.length != 1)) || i13 != 0) {
                                if (z10) {
                                    f(bVar, i12, i12 + iA, i13, sb2);
                                } else {
                                    d(bytes, 0, bytes.length, i13, sb2);
                                }
                                iH = 0;
                                i13 = 1;
                            } else if (z10) {
                                f(bVar, i12, 1, 0, sb2);
                            } else {
                                d(bytes, 0, 1, 0, sb2);
                            }
                            i12 += iA;
                        }
                    }
                }
            } else {
                sb2.append((char) 902);
                g(bVar, 0, length, sb2);
            }
        } else if (z10) {
            f(bVar, 0, bVar.length(), 0, sb2);
        } else {
            byte[] bytes2 = bVar.toString().getBytes(charset);
            d(bytes2, 0, bytes2.length, 1, sb2);
        }
        return sb2.toString();
    }

    public static void f(h hVar, int i10, int i11, int i12, StringBuilder sb2) throws WriterException {
        int iMin = Math.min(i11 + i10, hVar.length());
        int i13 = i10;
        while (true) {
            if (i13 >= iMin || !hVar.b(i13)) {
                int i14 = i13;
                while (i14 < iMin && !hVar.b(i14)) {
                    i14++;
                }
                int i15 = i14 - i13;
                if (i15 <= 0) {
                    return;
                }
                d(p(hVar, i13, i14), 0, i15, i13 == i10 ? i12 : 1, sb2);
                i13 = i14;
            } else {
                i(hVar.a(i13), sb2);
                i13++;
            }
        }
    }

    public static void g(h hVar, int i10, int i11, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int iMin = Math.min(44, i11 - i12);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1");
            int i13 = i10 + i12;
            sb4.append((Object) hVar.subSequence(i13, i13 + iMin));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i12 += iMin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010c A[EDGE_INSN: B:83:0x010c->B:60:0x010c BREAK  A[LOOP:0: B:3:0x0011->B:101:0x0011], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int h(af.h r16, int r17, int r18, java.lang.StringBuilder r19, int r20) throws com.google.zxing.WriterException {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nf.f.h(af.h, int, int, java.lang.StringBuilder, int):int");
    }

    public static void i(int i10, StringBuilder sb2) throws WriterException {
        if (i10 >= 0 && i10 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i10);
            return;
        }
        if (i10 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }

    public static boolean j(char c10) {
        return c10 == ' ' || (c10 >= 'a' && c10 <= 'z');
    }

    public static boolean k(char c10) {
        return c10 == ' ' || (c10 >= 'A' && c10 <= 'Z');
    }

    public static boolean l(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public static boolean m(char c10) {
        return f42122r[c10] != -1;
    }

    public static boolean n(char c10) {
        return f42123s[c10] != -1;
    }

    public static boolean o(char c10) {
        return c10 == '\t' || c10 == '\n' || c10 == '\r' || (c10 >= ' ' && c10 <= '~');
    }

    public static byte[] p(h hVar, int i10, int i11) {
        byte[] bArr = new byte[i11 - i10];
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12 - i10] = (byte) (hVar.charAt(i12) & 255);
        }
        return bArr;
    }
}
