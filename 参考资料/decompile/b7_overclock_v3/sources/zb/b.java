package zb;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import g.p0;
import hd.b0;
import hd.c0;
import hd.t;
import hd.u0;
import hd.w;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import ub.d;
import ub.f;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f58295b = new a() { // from class: zb.a
        @Override // zb.b.a
        public final boolean a(int i10, int i11, int i12, int i13, int i14) {
            return b.z(i10, i11, i12, i13, i14);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f58296c = "Id3Decoder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58297d = 4801587;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58298e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58299f = 128;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58300g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58301h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f58302i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58303j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f58304k = 64;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f58305l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f58306m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f58307n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f58308o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f58309p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f58310q = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final a f58311a;

    public interface a {
        boolean a(int i10, int i11, int i12, int i13, int i14);
    }

    /* JADX INFO: renamed from: zb.b$b, reason: collision with other inner class name */
    public static final class C0685b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f58313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f58314c;

        public C0685b(int i10, boolean z10, int i11) {
            this.f58312a = i10;
            this.f58313b = z10;
            this.f58314c = i11;
        }
    }

    public b() {
        this(null);
    }

    public static int A(c0 c0Var, int i10) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int i11 = iE;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= iE + i10) {
                return i10;
            }
            if ((bArrD[i11] & 255) == 255 && bArrD[i12] == 0) {
                System.arraycopy(bArrD, i11 + 2, bArrD, i12, (i10 - (i11 - iE)) - 2);
                i10--;
            }
            i11 = i12;
        }
    }

    public static boolean B(c0 c0Var, int i10, int i11, boolean z10) {
        int iJ;
        long J;
        int iM;
        int i12;
        int iE = c0Var.e();
        while (true) {
            try {
                boolean z11 = true;
                if (c0Var.a() < i11) {
                    return true;
                }
                if (i10 >= 3) {
                    iJ = c0Var.o();
                    J = c0Var.I();
                    iM = c0Var.M();
                } else {
                    iJ = c0Var.J();
                    J = c0Var.J();
                    iM = 0;
                }
                if (iJ == 0 && J == 0 && iM == 0) {
                    return true;
                }
                if (i10 == 4 && !z10) {
                    if ((8421504 & J) != 0) {
                        return false;
                    }
                    J = (((J >> 24) & 255) << 21) | (J & 255) | (((J >> 8) & 255) << 7) | (((J >> 16) & 255) << 14);
                }
                if (i10 == 4) {
                    i12 = (iM & 64) != 0 ? 1 : 0;
                    if ((iM & 1) == 0) {
                        z11 = false;
                    }
                } else {
                    if (i10 == 3) {
                        i12 = (iM & 32) != 0 ? 1 : 0;
                        if ((iM & 128) == 0) {
                        }
                    } else {
                        i12 = 0;
                    }
                    z11 = false;
                }
                if (z11) {
                    i12 += 4;
                }
                if (J < i12) {
                    return false;
                }
                if (c0Var.a() < J) {
                    return false;
                }
                c0Var.T((int) J);
            } finally {
                c0Var.S(iE);
            }
        }
    }

    public static byte[] d(byte[] bArr, int i10, int i11) {
        return i11 <= i10 ? u0.f31159f : Arrays.copyOfRange(bArr, i10, i11);
    }

    public static ApicFrame f(c0 c0Var, int i10, int i11) throws UnsupportedEncodingException {
        int iY;
        String str;
        int iG = c0Var.G();
        String strV = v(iG);
        int i12 = i10 - 1;
        byte[] bArr = new byte[i12];
        c0Var.k(bArr, 0, i12);
        if (i11 == 2) {
            str = "image/" + u0.w1(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = w.C0;
            }
            iY = 2;
        } else {
            iY = y(bArr, 0);
            String strW1 = u0.w1(new String(bArr, 0, iY, "ISO-8859-1"));
            if (strW1.indexOf(47) == -1) {
                str = "image/" + strW1;
            } else {
                str = strW1;
            }
        }
        int i13 = bArr[iY + 1] & 255;
        int i14 = iY + 2;
        int iX = x(bArr, i14, iG);
        return new ApicFrame(str, new String(bArr, i14, iX - i14, strV), i13, d(bArr, iX + u(iG), i12));
    }

    public static BinaryFrame g(c0 c0Var, int i10, String str) {
        byte[] bArr = new byte[i10];
        c0Var.k(bArr, 0, i10);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame h(c0 c0Var, int i10, int i11, boolean z10, int i12, @p0 a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.S(iY + 1);
        int iO = c0Var.o();
        int iO2 = c0Var.o();
        long jI = c0Var.I();
        long j10 = jI == 4294967295L ? -1L : jI;
        long jI2 = c0Var.I();
        long j11 = jI2 == 4294967295L ? -1L : jI2;
        ArrayList arrayList = new ArrayList();
        int i13 = iE + i10;
        while (c0Var.e() < i13) {
            Id3Frame id3FrameK = k(i11, c0Var, z10, i12, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iO, iO2, j10, j11, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame i(c0 c0Var, int i10, int i11, boolean z10, int i12, @p0 a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.S(iY + 1);
        int iG = c0Var.G();
        boolean z11 = (iG & 2) != 0;
        boolean z12 = (iG & 1) != 0;
        int iG2 = c0Var.G();
        String[] strArr = new String[iG2];
        for (int i13 = 0; i13 < iG2; i13++) {
            int iE2 = c0Var.e();
            int iY2 = y(c0Var.d(), iE2);
            strArr[i13] = new String(c0Var.d(), iE2, iY2 - iE2, "ISO-8859-1");
            c0Var.S(iY2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i14 = iE + i10;
        while (c0Var.e() < i14) {
            Id3Frame id3FrameK = k(i11, c0Var, z10, i12, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z11, z12, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @p0
    public static CommentFrame j(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 4) {
            return null;
        }
        int iG = c0Var.G();
        String strV = v(iG);
        byte[] bArr = new byte[3];
        c0Var.k(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        c0Var.k(bArr2, 0, i11);
        int iX = x(bArr2, 0, iG);
        String str2 = new String(bArr2, 0, iX, strV);
        int iU = iX + u(iG);
        return new CommentFrame(str, str2, p(bArr2, iU, x(bArr2, iU, iG), strV));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea A[Catch: all -> 0x012e, UnsupportedEncodingException -> 0x0218, TryCatch #0 {UnsupportedEncodingException -> 0x0218, blocks: (B:91:0x011c, B:159:0x01f4, B:93:0x0124, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112, outer: #1 }] */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame k(int r19, hd.c0 r20, boolean r21, int r22, @g.p0 zb.b.a r23) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.b.k(int, hd.c0, boolean, int, zb.b$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    public static GeobFrame l(c0 c0Var, int i10) throws UnsupportedEncodingException {
        int iG = c0Var.G();
        String strV = v(iG);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        int iY = y(bArr, 0);
        String str = new String(bArr, 0, iY, "ISO-8859-1");
        int i12 = iY + 1;
        int iX = x(bArr, i12, iG);
        String strP = p(bArr, i12, iX, strV);
        int iU = iX + u(iG);
        int iX2 = x(bArr, iU, iG);
        return new GeobFrame(str, strP, p(bArr, iU, iX2, strV), d(bArr, iX2 + u(iG), i11));
    }

    @p0
    public static C0685b m(c0 c0Var) {
        if (c0Var.a() < 10) {
            t.n(f58296c, "Data too short to be an ID3 tag");
            return null;
        }
        int iJ = c0Var.J();
        boolean z10 = false;
        if (iJ != 4801587) {
            t.n(f58296c, "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iJ)));
            return null;
        }
        int iG = c0Var.G();
        c0Var.T(1);
        int iG2 = c0Var.G();
        int iF = c0Var.F();
        if (iG == 2) {
            if ((iG2 & 64) != 0) {
                t.n(f58296c, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iG == 3) {
            if ((iG2 & 64) != 0) {
                int iO = c0Var.o();
                c0Var.T(iO);
                iF -= iO + 4;
            }
        } else {
            if (iG != 4) {
                t.n(f58296c, "Skipped ID3 tag with unsupported majorVersion=" + iG);
                return null;
            }
            if ((iG2 & 64) != 0) {
                int iF2 = c0Var.F();
                c0Var.T(iF2 - 4);
                iF -= iF2;
            }
            if ((iG2 & 16) != 0) {
                iF -= 10;
            }
        }
        if (iG < 4 && (iG2 & 128) != 0) {
            z10 = true;
        }
        return new C0685b(iG, z10, iF);
    }

    public static MlltFrame n(c0 c0Var, int i10) {
        int iM = c0Var.M();
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        int iG = c0Var.G();
        int iG2 = c0Var.G();
        b0 b0Var = new b0();
        b0Var.n(c0Var);
        int i11 = ((i10 - 10) * 8) / (iG + iG2);
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int iH = b0Var.h(iG);
            int iH2 = b0Var.h(iG2);
            iArr[i12] = iH;
            iArr2[i12] = iH2;
        }
        return new MlltFrame(iM, iJ, iJ2, iArr, iArr2);
    }

    public static PrivFrame o(c0 c0Var, int i10) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        c0Var.k(bArr, 0, i10);
        int iY = y(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iY, "ISO-8859-1"), d(bArr, iY + 1, i10));
    }

    public static String p(byte[] bArr, int i10, int i11, String str) throws UnsupportedEncodingException {
        return (i11 <= i10 || i11 > bArr.length) ? "" : new String(bArr, i10, i11 - i10, str);
    }

    @p0
    public static TextInformationFrame q(c0 c0Var, int i10, String str) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iG = c0Var.G();
        String strV = v(iG);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        return new TextInformationFrame(str, null, new String(bArr, 0, x(bArr, 0, iG), strV));
    }

    @p0
    public static TextInformationFrame r(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iG = c0Var.G();
        String strV = v(iG);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        int iX = x(bArr, 0, iG);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iG);
        return new TextInformationFrame("TXXX", str, p(bArr, iU, x(bArr, iU, iG), strV));
    }

    public static UrlLinkFrame s(c0 c0Var, int i10, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        c0Var.k(bArr, 0, i10);
        return new UrlLinkFrame(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    @p0
    public static UrlLinkFrame t(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iG = c0Var.G();
        String strV = v(iG);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        int iX = x(bArr, 0, iG);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iG);
        return new UrlLinkFrame("WXXX", str, p(bArr, iU, y(bArr, iU), "ISO-8859-1"));
    }

    public static int u(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    public static String v(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : g.f56719p;
    }

    public static String w(int i10, int i11, int i12, int i13, int i14) {
        return i10 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public static int x(byte[] bArr, int i10, int i11) {
        int iY = y(bArr, i10);
        if (i11 == 0 || i11 == 3) {
            return iY;
        }
        while (iY < bArr.length - 1) {
            if (iY % 2 == 0 && bArr[iY + 1] == 0) {
                return iY;
            }
            iY = y(bArr, iY + 1);
        }
        return bArr.length;
    }

    public static int y(byte[] bArr, int i10) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    public static /* synthetic */ boolean z(int i10, int i11, int i12, int i13, int i14) {
        return false;
    }

    @Override // ub.f
    @p0
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @p0
    public Metadata e(byte[] bArr, int i10) {
        ArrayList arrayList = new ArrayList();
        c0 c0Var = new c0(bArr, i10);
        C0685b c0685bM = m(c0Var);
        if (c0685bM == null) {
            return null;
        }
        int iE = c0Var.e();
        int i11 = c0685bM.f58312a == 2 ? 6 : 10;
        int iA = c0685bM.f58314c;
        if (c0685bM.f58313b) {
            iA = A(c0Var, c0685bM.f58314c);
        }
        c0Var.R(iE + iA);
        boolean z10 = false;
        if (!B(c0Var, c0685bM.f58312a, i11, false)) {
            if (c0685bM.f58312a != 4 || !B(c0Var, 4, i11, true)) {
                t.n(f58296c, "Failed to validate ID3 tag with majorVersion=" + c0685bM.f58312a);
                return null;
            }
            z10 = true;
        }
        while (c0Var.a() >= i11) {
            Id3Frame id3FrameK = k(c0685bM.f58312a, c0Var, z10, i11, this.f58311a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }

    public b(@p0 a aVar) {
        this.f58311a = aVar;
    }
}
