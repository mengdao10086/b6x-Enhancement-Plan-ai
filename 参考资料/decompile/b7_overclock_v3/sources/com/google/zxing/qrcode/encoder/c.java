package com.google.zxing.qrcode.encoder;

import af.o;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f21669a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f21670b = StandardCharsets.ISO_8859_1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21671a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21671a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21671a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21671a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21671a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, af.a aVar, Charset charset) {
        for (byte b10 : str.getBytes(charset)) {
            aVar.c(b10, 8);
        }
    }

    public static void b(CharSequence charSequence, af.a aVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iR = r(charSequence.charAt(i10));
            if (iR == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int iR2 = r(charSequence.charAt(i11));
                if (iR2 == -1) {
                    throw new WriterException();
                }
                aVar.c((iR * 45) + iR2, 11);
                i10 += 2;
            } else {
                aVar.c(iR, 6);
                i10 = i11;
            }
        }
    }

    public static void c(String str, Mode mode, af.a aVar, Charset charset) throws WriterException {
        int i10 = a.f21671a[mode.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
            return;
        }
        if (i10 == 2) {
            b(str, aVar);
            return;
        }
        if (i10 == 3) {
            a(str, aVar, charset);
        } else {
            if (i10 == 4) {
                e(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, af.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    public static void e(String str, af.a aVar) throws WriterException {
        int i10;
        byte[] bytes = str.getBytes(o.f639b);
        if (bytes.length % 2 != 0) {
            throw new WriterException("Kanji byte size not even");
        }
        int length = bytes.length - 1;
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = ((bytes[i11] & 255) << 8) | (bytes[i11 + 1] & 255);
            int i13 = 33088;
            if (i12 >= 33088 && i12 <= 40956) {
                i10 = i12 - i13;
            } else if (i12 < 57408 || i12 > 60351) {
                i10 = -1;
            } else {
                i13 = 49472;
                i10 = i12 - i13;
            }
            if (i10 == -1) {
                throw new WriterException("Invalid byte sequence");
            }
            aVar.c(((i10 >> 8) * 192) + (i10 & 255), 13);
        }
    }

    public static void f(int i10, g gVar, Mode mode, af.a aVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(gVar);
        int i11 = 1 << characterCountBits;
        if (i10 < i11) {
            aVar.c(i10, characterCountBits);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void g(Mode mode, af.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, af.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int iCharAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((iCharAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((iCharAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(iCharAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, af.a aVar, af.a aVar2, g gVar) {
        return aVar.l() + mode.getCharacterCountBits(gVar) + aVar2.l();
    }

    public static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    public static int k(af.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, b bVar) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            e.a(aVar, errorCorrectionLevel, gVar, i12, bVar);
            int iJ = j(bVar);
            if (iJ < i10) {
                i11 = i12;
                i10 = iJ;
            }
        }
        return i11;
    }

    public static Mode l(String str) {
        return m(str, null);
    }

    public static Mode m(String str, Charset charset) {
        if (o.f639b.equals(charset) && u(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z11 = true;
            } else {
                if (r(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static g n(int i10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            g gVarI = g.i(i11);
            if (x(i10, gVarI, errorCorrectionLevel)) {
                return gVarI;
            }
        }
        throw new WriterException("Data too big");
    }

    public static f o(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return p(str, errorCorrectionLevel, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.qrcode.encoder.f p(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) throws com.google.zxing.WriterException {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.c.p(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.f");
    }

    public static byte[] q(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new cf.d(cf.a.f10938l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int r(int i10) {
        int[] iArr = f21669a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void s(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 >= i12) {
            throw new WriterException("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    public static af.a t(af.a aVar, int i10, int i11, int i12) throws WriterException {
        if (aVar.m() != i11) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            s(i10, i11, i12, i14, iArr, iArr2);
            int i15 = iArr[0];
            byte[] bArr = new byte[i15];
            aVar.t(i13 * 8, bArr, 0, i15);
            byte[] bArrQ = q(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.qrcode.encoder.a(bArr, bArrQ));
            iMax = Math.max(iMax, i15);
            iMax2 = Math.max(iMax2, bArrQ.length);
            i13 += iArr[0];
        }
        if (i11 != i13) {
            throw new WriterException("Data bytes does not match offset");
        }
        af.a aVar2 = new af.a();
        for (int i16 = 0; i16 < iMax; i16++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrA = ((com.google.zxing.qrcode.encoder.a) it2.next()).a();
                if (i16 < bArrA.length) {
                    aVar2.c(bArrA[i16], 8);
                }
            }
        }
        for (int i17 = 0; i17 < iMax2; i17++) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                byte[] bArrB = ((com.google.zxing.qrcode.encoder.a) it3.next()).b();
                if (i17 < bArrB.length) {
                    aVar2.c(bArrB[i17], 8);
                }
            }
        }
        if (i10 == aVar2.m()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i10 + " and " + aVar2.m() + " differ.");
    }

    public static boolean u(String str) {
        byte[] bytes = str.getBytes(o.f639b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10 += 2) {
            int i11 = bytes[i10] & 255;
            if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                return false;
            }
        }
        return true;
    }

    public static g v(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, af.a aVar, af.a aVar2) throws WriterException {
        return n(i(mode, aVar, aVar2, n(i(mode, aVar, aVar2, g.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void w(int i10, af.a aVar) throws WriterException {
        int i11 = i10 * 8;
        if (aVar.l() > i11) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.l() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && aVar.l() < i11; i12++) {
            aVar.a(false);
        }
        int iL = aVar.l() & 7;
        if (iL > 0) {
            while (iL < 8) {
                aVar.a(false);
                iL++;
            }
        }
        int iM = i10 - aVar.m();
        for (int i13 = 0; i13 < iM; i13++) {
            aVar.c((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.l() != i11) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static boolean x(int i10, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return gVar.h() - gVar.f(errorCorrectionLevel).d() >= (i10 + 7) / 8;
    }
}
