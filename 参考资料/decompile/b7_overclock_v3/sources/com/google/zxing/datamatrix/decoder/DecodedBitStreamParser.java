package com.google.zxing.datamatrix.decoder;

import af.i;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.common.base.Ascii;
import com.google.zxing.FormatException;
import com.google.zxing.datamatrix.encoder.j;
import ft.w;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import kotlin.text.y;
import mb.e;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import zc.f;

/* JADX INFO: loaded from: classes7.dex */
public final class DecodedBitStreamParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f21275a = {'*', '*', '*', f.f58383m, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', w.f28816e, 'M', 'N', 'O', 'P', 'Q', w.f28818g, 'S', 'T', w.f28817f, 'V', 'W', 'X', 'Y', w.f28814c};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f21276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f21277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f21278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f21279e;

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21280a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21280a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21280a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21280a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21280a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21280a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21280a[Mode.ECI_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        char[] cArr = {PublicSuffixDatabase.f43873i, y.f38188b, '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', f.f58380j, ':', f.f58382l, '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f21276b = cArr;
        f21277c = new char[]{'*', '*', '*', f.f58383m, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f21278d = cArr;
        f21279e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', w.f28816e, 'M', 'N', 'O', 'P', 'Q', w.f28818g, 'S', 'T', w.f28817f, 'V', 'W', 'X', 'Y', w.f28814c, '{', '|', '}', '~', Ascii.MAX};
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static af.d a(byte[] r13) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.a(byte[]):af.d");
    }

    public static void b(af.c cVar, i iVar) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    iVar.b('\r');
                } else if (i11 == 1) {
                    iVar.b('*');
                } else if (i11 == 2) {
                    iVar.b('>');
                } else if (i11 == 3) {
                    iVar.b(f.f58383m);
                } else if (i11 < 14) {
                    iVar.b((char) (i11 + 44));
                } else {
                    if (i11 >= 40) {
                        throw FormatException.b();
                    }
                    iVar.b((char) (i11 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static Mode c(af.c cVar, i iVar, StringBuilder sb2, Set<Integer> set) throws FormatException {
        boolean z10 = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw FormatException.b();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL /* 230 */:
                                return Mode.C40_ENCODE;
                            case e.f41040l1 /* 231 */:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b(gf.b.f29394o);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z10 = true;
                                break;
                            case 236:
                                iVar.d(j.f21344l);
                                sb2.insert(0, j.f21346n);
                                break;
                            case 237:
                                iVar.d(j.f21345m);
                                sb2.insert(0, j.f21346n);
                                break;
                            case e.f41061s1 /* 238 */:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            case 241:
                                return Mode.ECI_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw FormatException.b();
                                }
                                break;
                        }
                    } else {
                        int i10 = iD - 130;
                        if (i10 < 10) {
                            iVar.b('0');
                        }
                        iVar.c(i10);
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z10) {
                    iD += 128;
                }
                iVar.b((char) (iD - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    public static void d(af.c cVar, i iVar, Collection<byte[]> collection) throws FormatException {
        int iC = cVar.c() + 1;
        int i10 = iC + 1;
        int iJ = j(cVar.d(8), iC);
        if (iJ == 0) {
            iJ = cVar.a() / 8;
        } else if (iJ >= 250) {
            iJ = ((iJ - 249) * 250) + j(cVar.d(8), i10);
            i10++;
        }
        if (iJ < 0) {
            throw FormatException.b();
        }
        byte[] bArr = new byte[iJ];
        int i11 = 0;
        while (i11 < iJ) {
            if (cVar.a() < 8) {
                throw FormatException.b();
            }
            bArr[i11] = (byte) j(cVar.d(8), i10);
            i11++;
            i10++;
        }
        collection.add(bArr);
        iVar.d(new String(bArr, StandardCharsets.ISO_8859_1));
    }

    public static void e(af.c cVar, i iVar, Set<Integer> set) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f21276b;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    iVar.b((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    iVar.b(c10);
                                }
                            } else if (i12 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b(gf.b.f29394o);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.b();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.b();
                            }
                            if (z10) {
                                iVar.b((char) (i12 + 224));
                                z10 = false;
                                i10 = 0;
                            } else {
                                iVar.b((char) (i12 + 96));
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        iVar.b((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        iVar.b((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = f21275a;
                    if (i12 >= cArr2.length) {
                        throw FormatException.b();
                    }
                    char c11 = cArr2[i12];
                    if (z10) {
                        iVar.b((char) (c11 + 128));
                        z10 = false;
                    } else {
                        iVar.b(c11);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void f(af.c cVar, i iVar) throws FormatException {
        if (cVar.a() < 8) {
            throw FormatException.b();
        }
        int iD = cVar.d(8);
        if (iD <= 127) {
            iVar.f(iD - 1);
        }
    }

    public static void g(af.c cVar, i iVar) {
        while (cVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                iVar.b((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void h(af.c cVar, i iVar, Set<Integer> set) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f21278d;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    iVar.b((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    iVar.b(c10);
                                }
                            } else if (i12 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b(gf.b.f29394o);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.b();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.b();
                            }
                            char[] cArr2 = f21279e;
                            if (i12 >= cArr2.length) {
                                throw FormatException.b();
                            }
                            char c11 = cArr2[i12];
                            if (z10) {
                                iVar.b((char) (c11 + 128));
                                z10 = false;
                                i10 = 0;
                            } else {
                                iVar.b(c11);
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        iVar.b((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        iVar.b((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = f21277c;
                    if (i12 >= cArr3.length) {
                        throw FormatException.b();
                    }
                    char c12 = cArr3[i12];
                    if (z10) {
                        iVar.b((char) (c12 + 128));
                        z10 = false;
                    } else {
                        iVar.b(c12);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void i(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    public static int j(int i10, int i11) {
        int i12 = i10 - (((i11 * WaspWingInfo.COLD_LEVEL_STANDARD_B7) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
