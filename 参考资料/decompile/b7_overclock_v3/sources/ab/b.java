package ab;

import android.support.v4.media.session.MediaSessionCompat;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import g.p0;
import hd.c0;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import okio.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f382a = 80000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f383b = 768000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f384c = 3062500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f385d = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f386e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f387f = 256;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f388g = 1536;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f389h = {1, 2, 3, 6};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f390i = {y.f524a, com.google.android.exoplayer2.source.u.f18441j, 32000};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f391j = {24000, 22050, 16000};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f392k = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f393l = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.M, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f394m = {69, 87, 104, 121, 139, mb.e.f41073w1, 208, 243, gg.b.P, 348, gg.b.T, 487, gg.b.f29439g1, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: ab.b$b, reason: collision with other inner class name */
    public static final class C0011b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f395g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f396h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f397i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f398j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final String f399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f404f;

        /* JADX INFO: renamed from: ab.b$b$a */
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public C0011b(@p0 String str, int i10, int i11, int i12, int i13, int i14) {
            this.f399a = str;
            this.f400b = i10;
            this.f402d = i11;
            this.f401c = i12;
            this.f403e = i13;
            this.f404f = i14;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i10 = iPosition; i10 <= iLimit; i10++) {
            if ((u0.P(byteBuffer, i10 + 4) & (-2)) == -126718022) {
                return i10 - iPosition;
            }
        }
        return -1;
    }

    public static int b(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0) {
            return -1;
        }
        int[] iArr = f390i;
        if (i10 >= iArr.length || i11 < 0) {
            return -1;
        }
        int[] iArr2 = f394m;
        if (i12 >= iArr2.length) {
            return -1;
        }
        int i13 = iArr[i10];
        if (i13 == 44100) {
            return (iArr2[i12] + (i11 % 2)) * 2;
        }
        int i14 = f393l[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static Format c(c0 c0Var, String str, String str2, @p0 DrmInitData drmInitData) {
        int i10 = f390i[(c0Var.G() & 192) >> 6];
        int iG = c0Var.G();
        int i11 = f392k[(iG & 56) >> 3];
        if ((iG & 4) != 0) {
            i11++;
        }
        return new Format.b().S(str).e0(hd.w.J).H(i11).f0(i10).L(drmInitData).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & ThreadUtils.f11619i) >> 3) > 10) {
            return f389h[((byteBuffer.get(byteBuffer.position() + 4) & i1.a.f31667o7) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & jt.l.f36949q) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0011b e(hd.b0 b0Var) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iH;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iE = b0Var.e();
        b0Var.s(40);
        boolean z10 = b0Var.h(5) > 10;
        b0Var.q(iE);
        int i20 = -1;
        if (z10) {
            b0Var.s(16);
            int iH2 = b0Var.h(2);
            if (iH2 == 0) {
                i20 = 0;
            } else if (iH2 == 1) {
                i20 = 1;
            } else if (iH2 == 2) {
                i20 = 2;
            }
            b0Var.s(3);
            int iH3 = (b0Var.h(11) + 1) * 2;
            int iH4 = b0Var.h(2);
            if (iH4 == 3) {
                i16 = f391j[b0Var.h(2)];
                iH = 3;
                i15 = 6;
            } else {
                iH = b0Var.h(2);
                i15 = f389h[iH];
                i16 = f390i[iH4];
            }
            int i21 = i15 * 256;
            int iH5 = b0Var.h(3);
            boolean zG = b0Var.g();
            int i22 = f392k[iH5] + (zG ? 1 : 0);
            b0Var.s(10);
            if (b0Var.g()) {
                b0Var.s(8);
            }
            if (iH5 == 0) {
                b0Var.s(5);
                if (b0Var.g()) {
                    b0Var.s(8);
                }
            }
            if (i20 == 1 && b0Var.g()) {
                b0Var.s(16);
            }
            if (b0Var.g()) {
                if (iH5 > 2) {
                    b0Var.s(2);
                }
                if ((iH5 & 1) == 0 || iH5 <= 2) {
                    i18 = 6;
                } else {
                    i18 = 6;
                    b0Var.s(6);
                }
                if ((iH5 & 4) != 0) {
                    b0Var.s(i18);
                }
                if (zG && b0Var.g()) {
                    b0Var.s(5);
                }
                if (i20 == 0) {
                    if (b0Var.g()) {
                        i19 = 6;
                        b0Var.s(6);
                    } else {
                        i19 = 6;
                    }
                    if (iH5 == 0 && b0Var.g()) {
                        b0Var.s(i19);
                    }
                    if (b0Var.g()) {
                        b0Var.s(i19);
                    }
                    int iH6 = b0Var.h(2);
                    if (iH6 == 1) {
                        b0Var.s(5);
                    } else if (iH6 == 2) {
                        b0Var.s(12);
                    } else if (iH6 == 3) {
                        int iH7 = b0Var.h(5);
                        if (b0Var.g()) {
                            b0Var.s(5);
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                b0Var.s(4);
                            }
                            if (b0Var.g()) {
                                if (b0Var.g()) {
                                    b0Var.s(4);
                                }
                                if (b0Var.g()) {
                                    b0Var.s(4);
                                }
                            }
                        }
                        if (b0Var.g()) {
                            b0Var.s(5);
                            if (b0Var.g()) {
                                b0Var.s(7);
                                if (b0Var.g()) {
                                    b0Var.s(8);
                                }
                            }
                        }
                        b0Var.s((iH7 + 2) * 8);
                        b0Var.c();
                    }
                    if (iH5 < 2) {
                        if (b0Var.g()) {
                            b0Var.s(14);
                        }
                        if (iH5 == 0 && b0Var.g()) {
                            b0Var.s(14);
                        }
                    }
                    if (b0Var.g()) {
                        if (iH == 0) {
                            b0Var.s(5);
                        } else {
                            for (int i23 = 0; i23 < i15; i23++) {
                                if (b0Var.g()) {
                                    b0Var.s(5);
                                }
                            }
                        }
                    }
                }
            }
            if (b0Var.g()) {
                b0Var.s(5);
                if (iH5 == 2) {
                    b0Var.s(4);
                }
                if (iH5 >= 6) {
                    b0Var.s(2);
                }
                if (b0Var.g()) {
                    b0Var.s(8);
                }
                if (iH5 == 0 && b0Var.g()) {
                    b0Var.s(8);
                }
                if (iH4 < 3) {
                    b0Var.r();
                }
            }
            if (i20 == 0 && iH != 3) {
                b0Var.r();
            }
            if (i20 == 2 && (iH == 3 || b0Var.g())) {
                i17 = 6;
                b0Var.s(6);
            } else {
                i17 = 6;
            }
            str = (b0Var.g() && b0Var.h(i17) == 1 && b0Var.h(8) == 1) ? hd.w.L : hd.w.K;
            i13 = i20;
            i14 = i21;
            i10 = iH3;
            i11 = i16;
            i12 = i22;
        } else {
            b0Var.s(32);
            int iH8 = b0Var.h(2);
            String str2 = iH8 == 3 ? null : hd.w.J;
            int iB = b(iH8, b0Var.h(6));
            b0Var.s(8);
            int iH9 = b0Var.h(3);
            if ((iH9 & 1) != 0 && iH9 != 1) {
                b0Var.s(2);
            }
            if ((iH9 & 4) != 0) {
                b0Var.s(2);
            }
            if (iH9 == 2) {
                b0Var.s(2);
            }
            int[] iArr = f390i;
            str = str2;
            i10 = iB;
            i11 = iH8 < iArr.length ? iArr[iH8] : -1;
            i12 = f392k[iH9] + (b0Var.g() ? 1 : 0);
            i13 = -1;
            i14 = 1536;
        }
        return new C0011b(str, i13, i12, i11, i10, i14);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & ThreadUtils.f11619i) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        return b((bArr[4] & i1.a.f31667o7) >> 6, bArr[4] & w0.f44229a);
    }

    public static Format g(c0 c0Var, String str, String str2, @p0 DrmInitData drmInitData) {
        c0Var.T(2);
        int i10 = f390i[(c0Var.G() & 192) >> 6];
        int iG = c0Var.G();
        int i11 = f392k[(iG & 14) >> 1];
        if ((iG & 1) != 0) {
            i11++;
        }
        if (((c0Var.G() & 30) >> 1) > 0 && (2 & c0Var.G()) != 0) {
            i11 += 2;
        }
        return new Format.b().S(str).e0((c0Var.a() <= 0 || (c0Var.G() & 1) == 0) ? hd.w.K : hd.w.L).H(i11).f0(i10).L(drmInitData).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i10) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i10) + ((byteBuffer.get((byteBuffer.position() + i10) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            return 40 << ((bArr[(bArr[7] & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
        }
        return 0;
    }
}
