package com.google.zxing.qrcode.encoder;

import af.g;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f21645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorCorrectionLevel f21646d;

    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21648b;

        static {
            int[] iArr = new int[Mode.values().length];
            f21648b = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21648b[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21648b[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21648b[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21648b[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VersionSize.values().length];
            f21647a = iArr2;
            try {
                iArr2[VersionSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21647a[VersionSize.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21647a[VersionSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Mode f21649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f21653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f21654f;

        public /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i10, int i11, int i12, b bVar, com.google.zxing.qrcode.decoder.g gVar, a aVar) {
            this(mode, i10, i11, i12, bVar, gVar);
        }

        public b(Mode mode, int i10, int i11, int i12, b bVar, com.google.zxing.qrcode.decoder.g gVar) {
            this.f21649a = mode;
            this.f21650b = i10;
            Mode mode2 = Mode.BYTE;
            int i13 = (mode == mode2 || bVar == null) ? i11 : bVar.f21651c;
            this.f21651c = i13;
            this.f21652d = i12;
            this.f21653e = bVar;
            boolean z10 = false;
            int characterCountBits = bVar != null ? bVar.f21654f : 0;
            if ((mode == mode2 && bVar == null && i13 != 0) || (bVar != null && i13 != bVar.f21651c)) {
                z10 = true;
            }
            characterCountBits = (bVar == null || mode != bVar.f21649a || z10) ? characterCountBits + mode.getCharacterCountBits(gVar) + 4 : characterCountBits;
            int i14 = a.f21648b[mode.ordinal()];
            if (i14 == 1) {
                characterCountBits += 13;
            } else if (i14 == 2) {
                characterCountBits += i12 == 1 ? 6 : 11;
            } else if (i14 == 3) {
                characterCountBits += i12 != 1 ? i12 == 2 ? 7 : 10 : 4;
            } else if (i14 == 4) {
                characterCountBits += MinimalEncoder.this.f21645c.c(MinimalEncoder.this.f21643a.substring(i10, i12 + i10), i11).length * 8;
                if (z10) {
                    characterCountBits += 12;
                }
            }
            this.f21654f = characterCountBits;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f21656a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.zxing.qrcode.decoder.g f21657b;

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Mode f21659a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f21660b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f21661c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f21662d;

            public a(Mode mode, int i10, int i11, int i12) {
                this.f21659a = mode;
                this.f21660b = i10;
                this.f21661c = i11;
                this.f21662d = i12;
            }

            public final void d(af.a aVar) throws WriterException {
                aVar.c(this.f21659a.getBits(), 4);
                if (this.f21662d > 0) {
                    aVar.c(e(), this.f21659a.getCharacterCountBits(c.this.f21657b));
                }
                if (this.f21659a == Mode.ECI) {
                    aVar.c(MinimalEncoder.this.f21645c.f(this.f21661c), 8);
                } else if (this.f21662d > 0) {
                    String str = MinimalEncoder.this.f21643a;
                    int i10 = this.f21660b;
                    com.google.zxing.qrcode.encoder.c.c(str.substring(i10, this.f21662d + i10), this.f21659a, aVar, MinimalEncoder.this.f21645c.d(this.f21661c));
                }
            }

            public final int e() {
                if (this.f21659a != Mode.BYTE) {
                    return this.f21662d;
                }
                g gVar = MinimalEncoder.this.f21645c;
                String str = MinimalEncoder.this.f21643a;
                int i10 = this.f21660b;
                return gVar.c(str.substring(i10, this.f21662d + i10), this.f21661c).length;
            }

            public final int f(com.google.zxing.qrcode.decoder.g gVar) {
                int iE = 4;
                int characterCountBits = this.f21659a.getCharacterCountBits(gVar) + 4;
                int i10 = a.f21648b[this.f21659a.ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        int i11 = this.f21662d;
                        return characterCountBits + ((i11 / 2) * 11) + (i11 % 2 == 1 ? 6 : 0);
                    }
                    if (i10 == 3) {
                        int i12 = this.f21662d;
                        characterCountBits += (i12 / 3) * 10;
                        int i13 = i12 % 3;
                        if (i13 != 1) {
                            iE = i13 == 2 ? 7 : 0;
                        }
                    } else {
                        if (i10 != 4) {
                            return i10 != 5 ? characterCountBits : characterCountBits + 8;
                        }
                        iE = e() * 8;
                    }
                } else {
                    iE = this.f21662d * 13;
                }
                return characterCountBits + iE;
            }

            public final String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < str.length(); i10++) {
                    if (str.charAt(i10) < ' ' || str.charAt(i10) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i10));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f21659a);
                sb2.append('(');
                if (this.f21659a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f21645c.d(this.f21661c).displayName());
                } else {
                    String str = MinimalEncoder.this.f21643a;
                    int i10 = this.f21660b;
                    sb2.append(g(str.substring(i10, this.f21662d + i10)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        public c(com.google.zxing.qrcode.decoder.g gVar, b bVar) {
            int i10;
            int i11;
            int i12 = 0;
            boolean z10 = false;
            while (true) {
                i10 = 1;
                if (bVar == null) {
                    break;
                }
                int i13 = i12 + bVar.f21652d;
                b bVar2 = bVar.f21653e;
                boolean z11 = (bVar.f21649a == Mode.BYTE && bVar2 == null && bVar.f21651c != 0) || !(bVar2 == null || bVar.f21651c == bVar2.f21651c);
                z10 = z11 ? true : z10;
                if (bVar2 == null || bVar2.f21649a != bVar.f21649a || z11) {
                    this.f21656a.add(0, new a(bVar.f21649a, bVar.f21650b, bVar.f21651c, i13));
                    i13 = 0;
                }
                if (z11) {
                    this.f21656a.add(0, new a(Mode.ECI, bVar.f21650b, bVar.f21651c, 0));
                }
                bVar = bVar2;
                i12 = i13;
            }
            if (MinimalEncoder.this.f21644b) {
                a aVar = this.f21656a.get(0);
                if (aVar != null) {
                    Mode mode = aVar.f21659a;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && z10) {
                        this.f21656a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f21656a.add(this.f21656a.get(0).f21659a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iJ = gVar.j();
            int i14 = a.f21647a[MinimalEncoder.m(gVar).ordinal()];
            if (i14 == 1) {
                i11 = 9;
            } else if (i14 != 2) {
                i10 = 27;
                i11 = 40;
            } else {
                i10 = 10;
                i11 = 26;
            }
            int iD = d(gVar);
            while (iJ < i11 && !com.google.zxing.qrcode.encoder.c.x(iD, com.google.zxing.qrcode.decoder.g.i(iJ), MinimalEncoder.this.f21646d)) {
                iJ++;
            }
            while (iJ > i10 && com.google.zxing.qrcode.encoder.c.x(iD, com.google.zxing.qrcode.decoder.g.i(iJ - 1), MinimalEncoder.this.f21646d)) {
                iJ--;
            }
            this.f21657b = com.google.zxing.qrcode.decoder.g.i(iJ);
        }

        public void b(af.a aVar) throws WriterException {
            Iterator<a> it2 = this.f21656a.iterator();
            while (it2.hasNext()) {
                it2.next().d(aVar);
            }
        }

        public int c() {
            return d(this.f21657b);
        }

        public final int d(com.google.zxing.qrcode.decoder.g gVar) {
            Iterator<a> it2 = this.f21656a.iterator();
            int iF = 0;
            while (it2.hasNext()) {
                iF += it2.next().f(gVar);
            }
            return iF;
        }

        public com.google.zxing.qrcode.decoder.g e() {
            return this.f21657b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f21656a) {
                if (aVar != null) {
                    sb2.append(ag.c.f654g);
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    public MinimalEncoder(String str, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f21643a = str;
        this.f21644b = z10;
        this.f21645c = new g(str, charset, -1);
        this.f21646d = errorCorrectionLevel;
    }

    public static c i(String str, com.google.zxing.qrcode.decoder.g gVar, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return new MinimalEncoder(str, charset, z10, errorCorrectionLevel).h(gVar);
    }

    public static int k(Mode mode) {
        int i10;
        if (mode == null || (i10 = a.f21648b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    public static com.google.zxing.qrcode.decoder.g l(VersionSize versionSize) {
        int i10 = a.f21647a[versionSize.ordinal()];
        return i10 != 1 ? i10 != 2 ? com.google.zxing.qrcode.decoder.g.i(40) : com.google.zxing.qrcode.decoder.g.i(26) : com.google.zxing.qrcode.decoder.g.i(9);
    }

    public static VersionSize m(com.google.zxing.qrcode.decoder.g gVar) {
        return gVar.j() <= 9 ? VersionSize.SMALL : gVar.j() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    public static boolean n(char c10) {
        return com.google.zxing.qrcode.encoder.c.r(c10) != -1;
    }

    public static boolean o(char c10) {
        return com.google.zxing.qrcode.encoder.c.u(String.valueOf(c10));
    }

    public static boolean p(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public void e(b[][][] bVarArr, int i10, b bVar) {
        b[] bVarArr2 = bVarArr[i10 + bVar.f21652d][bVar.f21651c];
        int iK = k(bVar.f21649a);
        if (bVarArr2[iK] == null || bVarArr2[iK].f21654f > bVar.f21654f) {
            bVarArr2[iK] = bVar;
        }
    }

    public void f(com.google.zxing.qrcode.decoder.g gVar, b[][][] bVarArr, int i10, b bVar) {
        int i11;
        int iH = this.f21645c.h();
        int iG = this.f21645c.g();
        if (iG < 0 || !this.f21645c.a(this.f21643a.charAt(i10), iG)) {
            iG = 0;
        } else {
            iH = iG + 1;
        }
        int i12 = iH;
        for (int i13 = iG; i13 < i12; i13++) {
            if (this.f21645c.a(this.f21643a.charAt(i10), i13)) {
                e(bVarArr, i10, new b(this, Mode.BYTE, i10, i13, 1, bVar, gVar, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f21643a.charAt(i10))) {
            e(bVarArr, i10, new b(this, mode, i10, 0, 1, bVar, gVar, null));
        }
        int length = this.f21643a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f21643a.charAt(i10))) {
            int i14 = i10 + 1;
            e(bVarArr, i10, new b(this, mode2, i10, 0, (i14 >= length || !g(mode2, this.f21643a.charAt(i14))) ? 1 : 2, bVar, gVar, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f21643a.charAt(i10))) {
            int i15 = 0;
            int i16 = i10 + 1;
            if (i16 >= length || !g(mode3, this.f21643a.charAt(i16))) {
                i11 = 1;
            } else {
                int i17 = i10 + 2;
                i11 = (i17 >= length || !g(mode3, this.f21643a.charAt(i17))) ? 2 : 3;
            }
            e(bVarArr, i10, new b(this, mode3, i10, i15, i11, bVar, gVar, null));
        }
    }

    public boolean g(Mode mode, char c10) {
        int i10 = a.f21648b[mode.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 == 4 : p(c10) : n(c10) : o(c10);
    }

    public c h(com.google.zxing.qrcode.decoder.g gVar) throws WriterException {
        if (gVar != null) {
            c cVarJ = j(gVar);
            if (com.google.zxing.qrcode.encoder.c.x(cVarJ.c(), l(m(cVarJ.e())), this.f21646d)) {
                return cVarJ;
            }
            throw new WriterException("Data too big for version" + gVar);
        }
        com.google.zxing.qrcode.decoder.g[] gVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(gVarArr[0]), j(gVarArr[1]), j(gVarArr[2])};
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 3; i12++) {
            int iC = cVarArr[i12].c();
            if (com.google.zxing.qrcode.encoder.c.x(iC, gVarArr[i12], this.f21646d) && iC < i10) {
                i11 = i12;
                i10 = iC;
            }
        }
        if (i11 >= 0) {
            return cVarArr[i11];
        }
        throw new WriterException("Data too big for any version");
    }

    public c j(com.google.zxing.qrcode.decoder.g gVar) throws WriterException {
        int length = this.f21643a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f21645c.h(), 4);
        f(gVar, bVarArr, 0, null);
        for (int i10 = 1; i10 <= length; i10++) {
            for (int i11 = 0; i11 < this.f21645c.h(); i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    if (bVarArr[i10][i11][i12] != null && i10 < length) {
                        f(gVar, bVarArr, i10, bVarArr[i10][i11][i12]);
                    }
                }
            }
        }
        int i13 = Integer.MAX_VALUE;
        int i14 = -1;
        int i15 = -1;
        for (int i16 = 0; i16 < this.f21645c.h(); i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                if (bVarArr[length][i16][i17] != null) {
                    b bVar = bVarArr[length][i16][i17];
                    if (bVar.f21654f < i13) {
                        i13 = bVar.f21654f;
                        i14 = i16;
                        i15 = i17;
                    }
                }
            }
        }
        if (i14 >= 0) {
            return new c(gVar, bVarArr[length][i14][i15]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f21643a + "\"");
    }
}
