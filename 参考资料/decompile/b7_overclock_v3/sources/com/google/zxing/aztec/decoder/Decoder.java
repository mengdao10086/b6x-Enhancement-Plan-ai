package com.google.zxing.aztec.decoder;

import af.d;
import ag.c;
import com.blankj.utilcode.util.i0;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.an;
import hb.u;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes7.dex */
public final class Decoder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f21265b = {"CTRL_PS", i0.f11861z, i1.a.W4, "B", "C", "D", i1.a.S4, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", i1.a.R4, i1.a.f31577d5, "U", i1.a.X4, i1.a.T4, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f21266c = {"CTRL_PS", i0.f11861z, "a", "b", "c", "d", "e", "f", "g", "h", "i", j.f55230b, "k", l.f16298a, k.f40564b, "n", "o", "p", "q", SsManifestParser.e.J, an.aB, "t", "u", "v", "w", "x", "y", an.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f21267d = {"CTRL_PS", i0.f11861z, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f21268e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", i6.a.f31863g, "&", "'", ee.a.f26978c, ee.a.f26979d, "*", com.google.android.material.badge.a.f19590u, c.f654g, "-", j3.b.f36044h, fh.a.f28350w, ":", ";", "<", u.f30904o, ">", "?", "[", "]", zc.a.f58316d, zc.a.f58317e, "CTRL_UL"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f21269f = {"CTRL_PS", i0.f11861z, "0", "1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, c.f654g, j3.b.f36044h, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f21270g = StandardCharsets.ISO_8859_1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public we.a f21271a;

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21272a;

        static {
            int[] iArr = new int[Table.values().length];
            f21272a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21272a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21272a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21272a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21272a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f21273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21274b;

        public b(boolean[] zArr, int i10) {
            this.f21273a = zArr;
            this.f21274b = i10;
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = i(zArr, i10 * 8);
        }
        return bArr;
    }

    public static String e(Table table, int i10) {
        int i11 = a.f21272a[table.ordinal()];
        if (i11 == 1) {
            return f21265b[i10];
        }
        if (i11 == 2) {
            return f21266c[i10];
        }
        if (i11 == 3) {
            return f21267d[i10];
        }
        if (i11 == 4) {
            return f21268e[i10];
        }
        if (i11 == 5) {
            return f21269f[i10];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String f(boolean[] zArr) throws FormatException {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb2 = new StringBuilder((zArr.length - 5) / 4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = f21270g;
        int i10 = 0;
        Table tableG = table;
        loop0: while (i10 < length) {
            if (table != Table.BINARY) {
                int i11 = table == Table.DIGIT ? 4 : 5;
                if (length - i10 >= i11) {
                    int iJ = j(zArr, i10, i11);
                    i10 += i11;
                    String strE = e(table, iJ);
                    if ("FLG(n)".equals(strE)) {
                        if (length - i10 >= 3) {
                            int iJ2 = j(zArr, i10, 3);
                            i10 += 3;
                            try {
                                sb2.append(byteArrayOutputStream.toString(charset.name()));
                                byteArrayOutputStream.reset();
                                if (iJ2 == 0) {
                                    sb2.append(gf.b.f29394o);
                                } else {
                                    if (iJ2 == 7) {
                                        throw FormatException.b();
                                    }
                                    if (length - i10 >= iJ2 * 4) {
                                        int i12 = 0;
                                        while (true) {
                                            int i13 = iJ2 - 1;
                                            if (iJ2 > 0) {
                                                int iJ3 = j(zArr, i10, 4);
                                                i10 += 4;
                                                if (iJ3 < 2 || iJ3 > 11) {
                                                    break loop0;
                                                }
                                                i12 = (i12 * 10) + (iJ3 - 2);
                                                iJ2 = i13;
                                            } else {
                                                CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i12);
                                                if (characterSetECIByValue == null) {
                                                    throw FormatException.b();
                                                }
                                                charset = characterSetECIByValue.getCharset();
                                            }
                                        }
                                        throw FormatException.b();
                                    }
                                }
                            } catch (UnsupportedEncodingException e10) {
                                throw new IllegalStateException(e10);
                            }
                        }
                    } else if (strE.startsWith("CTRL_")) {
                        tableG = g(strE.charAt(5));
                        if (strE.charAt(6) != 'L') {
                            tableG = table;
                            table = tableG;
                        }
                    } else {
                        byte[] bytes = strE.getBytes(StandardCharsets.US_ASCII);
                        byteArrayOutputStream.write(bytes, 0, bytes.length);
                    }
                    table = tableG;
                }
            } else if (length - i10 >= 5) {
                int iJ4 = j(zArr, i10, 5);
                i10 += 5;
                if (iJ4 == 0) {
                    if (length - i10 >= 11) {
                        iJ4 = j(zArr, i10, 11) + 31;
                        i10 += 11;
                    }
                }
                int i14 = 0;
                while (true) {
                    if (i14 >= iJ4) {
                        break;
                    }
                    if (length - i10 < 8) {
                        i10 = length;
                        break;
                    }
                    byteArrayOutputStream.write((byte) j(zArr, i10, 8));
                    i10 += 8;
                    i14++;
                }
                table = tableG;
            }
        }
        try {
            sb2.append(byteArrayOutputStream.toString(charset.name()));
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static Table g(char c10) {
        return c10 != 'B' ? c10 != 'D' ? c10 != 'P' ? c10 != 'L' ? c10 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String h(boolean[] zArr) throws FormatException {
        return f(zArr);
    }

    public static byte i(boolean[] zArr, int i10) {
        int length = zArr.length - i10;
        return (byte) (length >= 8 ? j(zArr, i10, 8) : j(zArr, i10, length) << (8 - length));
    }

    public static int j(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    public static int k(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    public final b b(boolean[] zArr) throws FormatException {
        cf.a aVar;
        int i10 = 8;
        if (this.f21271a.d() <= 2) {
            i10 = 6;
            aVar = cf.a.f10936j;
        } else if (this.f21271a.d() <= 8) {
            aVar = cf.a.f10940n;
        } else if (this.f21271a.d() <= 22) {
            i10 = 10;
            aVar = cf.a.f10935i;
        } else {
            i10 = 12;
            aVar = cf.a.f10934h;
        }
        int iC = this.f21271a.c();
        int length = zArr.length / i10;
        if (length < iC) {
            throw FormatException.b();
        }
        int length2 = zArr.length % i10;
        int[] iArr = new int[length];
        int i11 = 0;
        while (i11 < length) {
            iArr[i11] = j(zArr, length2, i10);
            i11++;
            length2 += i10;
        }
        try {
            cf.c cVar = new cf.c(aVar);
            int i12 = length - iC;
            cVar.a(iArr, i12);
            int i13 = (1 << i10) - 1;
            int i14 = 0;
            for (int i15 = 0; i15 < iC; i15++) {
                int i16 = iArr[i15];
                if (i16 == 0 || i16 == i13) {
                    throw FormatException.b();
                }
                if (i16 == 1 || i16 == i13 - 1) {
                    i14++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i10) - i14];
            int i17 = 0;
            for (int i18 = 0; i18 < iC; i18++) {
                int i19 = iArr[i18];
                if (i19 == 1 || i19 == i13 - 1) {
                    Arrays.fill(zArr2, i17, (i17 + i10) - 1, i19 > 1);
                    i17 += i10 - 1;
                } else {
                    int i20 = i10 - 1;
                    while (i20 >= 0) {
                        int i21 = i17 + 1;
                        zArr2[i17] = ((1 << i20) & i19) != 0;
                        i20--;
                        i17 = i21;
                    }
                }
            }
            return new b(zArr2, (i12 * 100) / length);
        } catch (ReedSolomonException e10) {
            throw FormatException.c(e10);
        }
    }

    public d c(we.a aVar) throws FormatException {
        this.f21271a = aVar;
        b bVarB = b(d(aVar.a()));
        d dVar = new d(a(bVarB.f21273a), f(bVarB.f21273a), null, String.format("%d%%", Integer.valueOf(bVarB.f21274b)));
        dVar.o(bVarB.f21273a.length);
        return dVar;
    }

    public final boolean[] d(af.b bVar) {
        boolean zE = this.f21271a.e();
        int iD = this.f21271a.d();
        int i10 = (zE ? 11 : 14) + (iD * 4);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[k(iD, zE)];
        int i11 = 2;
        if (zE) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                iArr[(i13 - i15) - 1] = (i14 - r12) - 1;
                iArr[i13 + i15] = (i15 / 15) + i15 + i14 + 1;
            }
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < iD) {
            int i18 = ((iD - i16) * 4) + (zE ? 9 : 12);
            int i19 = i16 * 2;
            int i20 = (i10 - 1) - i19;
            int i21 = 0;
            while (i21 < i18) {
                int i22 = i21 * 2;
                int i23 = 0;
                while (i23 < i11) {
                    int i24 = i19 + i23;
                    int i25 = i19 + i21;
                    zArr[i17 + i22 + i23] = bVar.f(iArr[i24], iArr[i25]);
                    int i26 = iArr[i25];
                    int i27 = i20 - i23;
                    zArr[(i18 * 2) + i17 + i22 + i23] = bVar.f(i26, iArr[i27]);
                    int i28 = i20 - i21;
                    zArr[(i18 * 4) + i17 + i22 + i23] = bVar.f(iArr[i27], iArr[i28]);
                    zArr[(i18 * 6) + i17 + i22 + i23] = bVar.f(iArr[i28], iArr[i24]);
                    i23++;
                    iD = iD;
                    zE = zE;
                    i11 = 2;
                }
                i21++;
                i11 = 2;
            }
            i17 += i18 * 8;
            i16++;
            i11 = 2;
        }
        return zArr;
    }
}
