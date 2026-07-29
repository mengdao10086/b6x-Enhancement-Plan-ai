package ab;

import com.google.android.exoplayer2.ParserException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f347a = "AacUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f348b = 1024;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f349c = 1024;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f350d = 2048;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f351e = 512;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f352f = 100000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f353g = 16000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f354h = 7000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f355i = 256000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f356j = 8000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f357k = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f359m = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f361o = "mp4a.40.";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f362p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f363q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f364r = 22;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f365s = 23;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f366t = 29;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f367u = 31;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f368v = 42;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f358l = {96000, 88200, 64000, y.f524a, com.google.android.exoplayer2.source.u.f18441j, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f360n = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f371c;

        public c(int i10, int i11, String str) {
            this.f369a = i10;
            this.f370b = i11;
            this.f371c = str;
        }
    }

    public static byte[] a(int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
        while (true) {
            int[] iArr = f358l;
            if (i13 >= iArr.length) {
                break;
            }
            if (i10 == iArr[i13]) {
                i14 = i13;
            }
            i13++;
        }
        int i15 = -1;
        while (true) {
            int[] iArr2 = f360n;
            if (i12 >= iArr2.length) {
                break;
            }
            if (i11 == iArr2[i12]) {
                i15 = i12;
            }
            i12++;
        }
        if (i10 != -1 && i15 != -1) {
            return b(2, i14, i15);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i10 + ", " + i11);
    }

    public static byte[] b(int i10, int i11, int i12) {
        return new byte[]{(byte) (((i10 << 3) & 248) | ((i11 >> 1) & 7)), (byte) (((i11 << 7) & 128) | ((i12 << 3) & 120))};
    }

    public static int c(hd.b0 b0Var) {
        int iH = b0Var.h(5);
        return iH == 31 ? b0Var.h(6) + 32 : iH;
    }

    public static int d(int i10) {
        if (i10 == 2) {
            return 10;
        }
        if (i10 == 5) {
            return 11;
        }
        if (i10 == 29) {
            return 12;
        }
        if (i10 == 42) {
            return 16;
        }
        if (i10 != 22) {
            return i10 != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public static int e(hd.b0 b0Var) throws ParserException {
        int iH = b0Var.h(4);
        if (iH == 15) {
            return b0Var.h(24);
        }
        if (iH < 13) {
            return f358l[iH];
        }
        throw new ParserException();
    }

    public static c f(hd.b0 b0Var, boolean z10) throws ParserException {
        int iC = c(b0Var);
        int iE = e(b0Var);
        int iH = b0Var.h(4);
        String str = f361o + iC;
        if (iC == 5 || iC == 29) {
            iE = e(b0Var);
            iC = c(b0Var);
            if (iC == 22) {
                iH = b0Var.h(4);
            }
        }
        if (z10) {
            if (iC != 1 && iC != 2 && iC != 3 && iC != 4 && iC != 6 && iC != 7 && iC != 17) {
                switch (iC) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + iC);
                }
            }
            h(b0Var, iC, iH);
            switch (iC) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = b0Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i10 = f360n[iH];
        if (i10 != -1) {
            return new c(iE, i10, str);
        }
        throw new ParserException();
    }

    public static c g(byte[] bArr) throws ParserException {
        return f(new hd.b0(bArr), false);
    }

    public static void h(hd.b0 b0Var, int i10, int i11) {
        if (b0Var.g()) {
            hd.t.n(f347a, "Unexpected frameLengthFlag = 1");
        }
        if (b0Var.g()) {
            b0Var.s(14);
        }
        boolean zG = b0Var.g();
        if (i11 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i10 == 6 || i10 == 20) {
            b0Var.s(3);
        }
        if (zG) {
            if (i10 == 22) {
                b0Var.s(16);
            }
            if (i10 == 17 || i10 == 19 || i10 == 20 || i10 == 23) {
                b0Var.s(3);
            }
            b0Var.s(1);
        }
    }
}
