package hb;

import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30842a = "VorbisUtil";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f30844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f30845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f30846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f30847e;

        public a(int i10, int i11, long[] jArr, int i12, boolean z10) {
            this.f30843a = i10;
            this.f30844b = i11;
            this.f30845c = jArr;
            this.f30846d = i12;
            this.f30847e = z10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f30849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f30850c;

        public b(String str, String[] strArr, int i10) {
            this.f30848a = str;
            this.f30849b = strArr;
            this.f30850c = i10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f30851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f30852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f30853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f30854d;

        public c(boolean z10, int i10, int i11, int i12) {
            this.f30851a = z10;
            this.f30852b = i10;
            this.f30853c = i11;
            this.f30854d = i12;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f30856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f30857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f30858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f30859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f30860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f30861g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f30862h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f30863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f30864j;

        public d(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10, byte[] bArr) {
            this.f30855a = i10;
            this.f30856b = i11;
            this.f30857c = i12;
            this.f30858d = i13;
            this.f30859e = i14;
            this.f30860f = i15;
            this.f30861g = i16;
            this.f30862h = i17;
            this.f30863i = z10;
            this.f30864j = bArr;
        }
    }

    public static int a(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static long b(long j10, long j11) {
        return (long) Math.floor(Math.pow(j10, 1.0d / j11));
    }

    public static a c(e0 e0Var) throws ParserException {
        if (e0Var.e(24) != 5653314) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + e0Var.c());
        }
        int iE = e0Var.e(16);
        int iE2 = e0Var.e(24);
        long[] jArr = new long[iE2];
        boolean zD = e0Var.d();
        long jB = 0;
        if (zD) {
            int iE3 = e0Var.e(5) + 1;
            int i10 = 0;
            while (i10 < iE2) {
                int iE4 = e0Var.e(a(iE2 - i10));
                for (int i11 = 0; i11 < iE4 && i10 < iE2; i11++) {
                    jArr[i10] = iE3;
                    i10++;
                }
                iE3++;
            }
        } else {
            boolean zD2 = e0Var.d();
            for (int i12 = 0; i12 < iE2; i12++) {
                if (!zD2) {
                    jArr[i12] = e0Var.e(5) + 1;
                } else if (e0Var.d()) {
                    jArr[i12] = e0Var.e(5) + 1;
                } else {
                    jArr[i12] = 0;
                }
            }
        }
        int iE5 = e0Var.e(4);
        if (iE5 > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + iE5);
        }
        if (iE5 == 1 || iE5 == 2) {
            e0Var.h(32);
            e0Var.h(32);
            int iE6 = e0Var.e(4) + 1;
            e0Var.h(1);
            if (iE5 != 1) {
                jB = ((long) iE2) * ((long) iE);
            } else if (iE != 0) {
                jB = b(iE2, iE);
            }
            e0Var.h((int) (jB * ((long) iE6)));
        }
        return new a(iE, iE2, jArr, iE5, zD);
    }

    public static void d(e0 e0Var) throws ParserException {
        int iE = e0Var.e(6) + 1;
        for (int i10 = 0; i10 < iE; i10++) {
            int iE2 = e0Var.e(16);
            if (iE2 == 0) {
                e0Var.h(8);
                e0Var.h(16);
                e0Var.h(16);
                e0Var.h(6);
                e0Var.h(8);
                int iE3 = e0Var.e(4) + 1;
                for (int i11 = 0; i11 < iE3; i11++) {
                    e0Var.h(8);
                }
            } else {
                if (iE2 != 1) {
                    throw new ParserException("floor type greater than 1 not decodable: " + iE2);
                }
                int iE4 = e0Var.e(5);
                int i12 = -1;
                int[] iArr = new int[iE4];
                for (int i13 = 0; i13 < iE4; i13++) {
                    iArr[i13] = e0Var.e(4);
                    if (iArr[i13] > i12) {
                        i12 = iArr[i13];
                    }
                }
                int i14 = i12 + 1;
                int[] iArr2 = new int[i14];
                for (int i15 = 0; i15 < i14; i15++) {
                    iArr2[i15] = e0Var.e(3) + 1;
                    int iE5 = e0Var.e(2);
                    if (iE5 > 0) {
                        e0Var.h(8);
                    }
                    for (int i16 = 0; i16 < (1 << iE5); i16++) {
                        e0Var.h(8);
                    }
                }
                e0Var.h(2);
                int iE6 = e0Var.e(4);
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < iE4; i19++) {
                    i17 += iArr2[iArr[i19]];
                    while (i18 < i17) {
                        e0Var.h(iE6);
                        i18++;
                    }
                }
            }
        }
    }

    public static void e(int i10, e0 e0Var) throws ParserException {
        int iE = e0Var.e(6) + 1;
        for (int i11 = 0; i11 < iE; i11++) {
            int iE2 = e0Var.e(16);
            if (iE2 != 0) {
                hd.t.d(f30842a, "mapping type other than 0 not supported: " + iE2);
            } else {
                int iE3 = e0Var.d() ? e0Var.e(4) + 1 : 1;
                if (e0Var.d()) {
                    int iE4 = e0Var.e(8) + 1;
                    for (int i12 = 0; i12 < iE4; i12++) {
                        int i13 = i10 - 1;
                        e0Var.h(a(i13));
                        e0Var.h(a(i13));
                    }
                }
                if (e0Var.e(2) != 0) {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
                if (iE3 > 1) {
                    for (int i14 = 0; i14 < i10; i14++) {
                        e0Var.h(4);
                    }
                }
                for (int i15 = 0; i15 < iE3; i15++) {
                    e0Var.h(8);
                    e0Var.h(8);
                    e0Var.h(8);
                }
            }
        }
    }

    public static c[] f(e0 e0Var) {
        int iE = e0Var.e(6) + 1;
        c[] cVarArr = new c[iE];
        for (int i10 = 0; i10 < iE; i10++) {
            cVarArr[i10] = new c(e0Var.d(), e0Var.e(16), e0Var.e(16), e0Var.e(8));
        }
        return cVarArr;
    }

    public static void g(e0 e0Var) throws ParserException {
        int iE = e0Var.e(6) + 1;
        for (int i10 = 0; i10 < iE; i10++) {
            if (e0Var.e(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            e0Var.h(24);
            e0Var.h(24);
            e0Var.h(24);
            int iE2 = e0Var.e(6) + 1;
            e0Var.h(8);
            int[] iArr = new int[iE2];
            for (int i11 = 0; i11 < iE2; i11++) {
                iArr[i11] = ((e0Var.d() ? e0Var.e(5) : 0) * 8) + e0Var.e(3);
            }
            for (int i12 = 0; i12 < iE2; i12++) {
                for (int i13 = 0; i13 < 8; i13++) {
                    if ((iArr[i12] & (1 << i13)) != 0) {
                        e0Var.h(8);
                    }
                }
            }
        }
    }

    public static b h(hd.c0 c0Var) throws ParserException {
        return i(c0Var, true, true);
    }

    public static b i(hd.c0 c0Var, boolean z10, boolean z11) throws ParserException {
        if (z10) {
            l(3, c0Var, false);
        }
        String strD = c0Var.D((int) c0Var.v());
        int length = 11 + strD.length();
        long jV = c0Var.v();
        String[] strArr = new String[(int) jV];
        int length2 = length + 4;
        for (int i10 = 0; i10 < jV; i10++) {
            strArr[i10] = c0Var.D((int) c0Var.v());
            length2 = length2 + 4 + strArr[i10].length();
        }
        if (z11 && (c0Var.G() & 1) == 0) {
            throw new ParserException("framing bit expected to be set");
        }
        return new b(strD, strArr, length2 + 1);
    }

    public static d j(hd.c0 c0Var) throws ParserException {
        l(1, c0Var, false);
        int iX = c0Var.x();
        int iG = c0Var.G();
        int iX2 = c0Var.x();
        int iR = c0Var.r();
        if (iR <= 0) {
            iR = -1;
        }
        int iR2 = c0Var.r();
        if (iR2 <= 0) {
            iR2 = -1;
        }
        int iR3 = c0Var.r();
        if (iR3 <= 0) {
            iR3 = -1;
        }
        int iG2 = c0Var.G();
        return new d(iX, iG, iX2, iR, iR2, iR3, (int) Math.pow(2.0d, iG2 & 15), (int) Math.pow(2.0d, (iG2 & 240) >> 4), (c0Var.G() & 1) > 0, Arrays.copyOf(c0Var.d(), c0Var.f()));
    }

    public static c[] k(hd.c0 c0Var, int i10) throws ParserException {
        l(5, c0Var, false);
        int iG = c0Var.G() + 1;
        e0 e0Var = new e0(c0Var.d());
        e0Var.h(c0Var.e() * 8);
        for (int i11 = 0; i11 < iG; i11++) {
            c(e0Var);
        }
        int iE = e0Var.e(6) + 1;
        for (int i12 = 0; i12 < iE; i12++) {
            if (e0Var.e(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        d(e0Var);
        g(e0Var);
        e(i10, e0Var);
        c[] cVarArrF = f(e0Var);
        if (e0Var.d()) {
            return cVarArrF;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    public static boolean l(int i10, hd.c0 c0Var, boolean z10) throws ParserException {
        if (c0Var.a() < 7) {
            if (z10) {
                return false;
            }
            throw new ParserException("too short header: " + c0Var.a());
        }
        if (c0Var.G() != i10) {
            if (z10) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i10));
        }
        if (c0Var.G() == 118 && c0Var.G() == 111 && c0Var.G() == 114 && c0Var.G() == 98 && c0Var.G() == 105 && c0Var.G() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw new ParserException("expected characters 'vorbis'");
    }
}
