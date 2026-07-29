package com.google.zxing.qrcode.decoder;

import af.o;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f21598a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21599b = 1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21600a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21600a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21600a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21600a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21600a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21600a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21600a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21600a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21600a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21600a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21600a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117 A[LOOP:0: B:63:0x0022->B:60:0x0117, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static af.d a(byte[] r22, com.google.zxing.qrcode.decoder.g r23, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r24, java.util.Map<com.google.zxing.DecodeHintType, ?> r25) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.a(byte[], com.google.zxing.qrcode.decoder.g, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):af.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(af.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.d(r2)
            int r2 = r1 / 45
            char r2 = h(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = h(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.b()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.d(r2)
            char r3 = h(r3)
            r4.append(r3)
            goto L47
        L42:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.b()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.b(af.c, java.lang.StringBuilder, int, boolean):void");
    }

    public static void c(af.c cVar, StringBuilder sb2, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i10 * 8 > cVar.a()) {
            throw FormatException.b();
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) cVar.d(8);
        }
        sb2.append(new String(bArr, characterSetECI == null ? o.a(bArr, map) : characterSetECI.getCharset()));
        collection.add(bArr);
    }

    public static void d(af.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (o.f640c == null) {
            throw FormatException.b();
        }
        if (i10 * 13 > cVar.a()) {
            throw FormatException.b();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iD = cVar.d(13);
            int i12 = (iD % 96) | ((iD / 96) << 8);
            int i13 = i12 + (i12 < 2560 ? 41377 : 42657);
            bArr[i11] = (byte) ((i13 >> 8) & 255);
            bArr[i11 + 1] = (byte) (i13 & 255);
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, o.f640c));
    }

    public static void e(af.c cVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 > cVar.a()) {
            throw FormatException.b();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int iD = cVar.d(13);
            int i12 = (iD % 192) | ((iD / 192) << 8);
            int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        sb2.append(new String(bArr, o.f639b));
    }

    public static void f(af.c cVar, StringBuilder sb2, int i10) throws FormatException {
        while (i10 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.b();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw FormatException.b();
            }
            sb2.append(h(iD / 100));
            sb2.append(h((iD / 10) % 10));
            sb2.append(h(iD % 10));
            i10 -= 3;
        }
        if (i10 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.b();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw FormatException.b();
            }
            sb2.append(h(iD2 / 10));
            sb2.append(h(iD2 % 10));
            return;
        }
        if (i10 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.b();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw FormatException.b();
            }
            sb2.append(h(iD3));
        }
    }

    public static int g(af.c cVar) throws FormatException {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.b();
    }

    public static char h(int i10) throws FormatException {
        char[] cArr = f21598a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.b();
    }
}
