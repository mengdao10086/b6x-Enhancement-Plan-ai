package sb;

import ab.a0;
import android.net.Uri;
import android.util.Pair;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import hb.d0;
import hb.k;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.z;
import hd.c0;
import hd.u0;
import hd.w;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f49543i = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final q f49544j = new q() { // from class: sb.a
        @Override // hb.q
        public final k[] a() {
            return b.e();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f49545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d0 f49546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC0569b f49547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49548g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f49549h = -1;

    public static final class a implements InterfaceC0569b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int[] f49550m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int[] f49551n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 190, 209, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 253, 279, 307, 337, 371, 408, 449, 494, gg.b.O0, 598, gg.b.f29494u0, 724, 796, 876, 963, 1060, 1166, gg.b.f29507x1, gg.b.f29515z1, gg.b.I1, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, gg.b.f29413a};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f49552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f49553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final sb.c f49554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f49555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f49556e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f49557f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f49558g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Format f49559h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f49560i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f49561j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f49562k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f49563l;

        public a(m mVar, d0 d0Var, sb.c cVar) throws ParserException {
            this.f49552a = mVar;
            this.f49553b = d0Var;
            this.f49554c = cVar;
            int iMax = Math.max(1, cVar.f49574c / 10);
            this.f49558g = iMax;
            c0 c0Var = new c0(cVar.f49578g);
            c0Var.y();
            int iY = c0Var.y();
            this.f49555d = iY;
            int i10 = cVar.f49573b;
            int i11 = (((cVar.f49576e - (i10 * 4)) * 8) / (cVar.f49577f * i10)) + 1;
            if (iY == i11) {
                int iM = u0.m(iMax, iY);
                this.f49556e = new byte[cVar.f49576e * iM];
                this.f49557f = new c0(iM * h(iY, i10));
                int i12 = ((cVar.f49574c * cVar.f49576e) * 8) / iY;
                this.f49559h = new Format.b().e0(w.G).G(i12).Z(i12).W(h(iMax, i10)).H(cVar.f49573b).f0(cVar.f49574c).Y(2).E();
                return;
            }
            throw new ParserException("Expected frames per block: " + i11 + "; got: " + iY);
        }

        public static int h(int i10, int i11) {
            return i10 * 2 * i11;
        }

        @Override // sb.b.InterfaceC0569b
        public void a(long j10) {
            this.f49560i = 0;
            this.f49561j = j10;
            this.f49562k = 0;
            this.f49563l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please report as a decompilation issue!!! */
        @Override // sb.b.InterfaceC0569b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(hb.l r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f49558g
                int r1 = r6.f49562k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f49555d
                int r0 = hd.u0.m(r0, r1)
                sb.c r1 = r6.f49554c
                int r1 = r1.f49576e
                int r0 = r0 * r1
                r1 = 1
                r2 = 0
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r2 = 1
                goto L1f
            L1e:
                r2 = 0
            L1f:
                if (r2 != 0) goto L3f
                int r3 = r6.f49560i
                if (r3 >= r0) goto L3f
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r4 = (int) r3
                byte[] r3 = r6.f49556e
                int r5 = r6.f49560i
                int r3 = r7.read(r3, r5, r4)
                r4 = -1
                if (r3 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f49560i
                int r4 = r4 + r3
                r6.f49560i = r4
                goto L1f
            L3f:
                int r7 = r6.f49560i
                sb.c r8 = r6.f49554c
                int r8 = r8.f49576e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f49556e
                hd.c0 r9 = r6.f49557f
                r6.d(r8, r7, r9)
                int r8 = r6.f49560i
                sb.c r9 = r6.f49554c
                int r9 = r9.f49576e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f49560i = r8
                hd.c0 r7 = r6.f49557f
                int r7 = r7.f()
                hb.d0 r8 = r6.f49553b
                hd.c0 r9 = r6.f49557f
                r8.d(r9, r7)
                int r8 = r6.f49562k
                int r8 = r8 + r7
                r6.f49562k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f49558g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r2 == 0) goto L84
                int r7 = r6.f49562k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: sb.b.a.b(hb.l, long):boolean");
        }

        @Override // sb.b.InterfaceC0569b
        public void c(int i10, long j10) {
            this.f49552a.o(new e(this.f49554c, this.f49555d, i10, j10));
            this.f49553b.f(this.f49559h);
        }

        public final void d(byte[] bArr, int i10, c0 c0Var) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < this.f49554c.f49573b; i12++) {
                    e(bArr, i11, i12, c0Var.d());
                }
            }
            int iG = g(this.f49555d * i10);
            c0Var.S(0);
            c0Var.R(iG);
        }

        public final void e(byte[] bArr, int i10, int i11, byte[] bArr2) {
            sb.c cVar = this.f49554c;
            int i12 = cVar.f49576e;
            int i13 = cVar.f49573b;
            int i14 = (i10 * i12) + (i11 * 4);
            int i15 = (i13 * 4) + i14;
            int i16 = (i12 / i13) - 4;
            int iT = (short) (((bArr[i14 + 1] & 255) << 8) | (bArr[i14] & 255));
            int iMin = Math.min(bArr[i14 + 2] & 255, 88);
            int i17 = f49551n[iMin];
            int i18 = ((i10 * this.f49555d * i13) + i11) * 2;
            bArr2[i18] = (byte) (iT & 255);
            bArr2[i18 + 1] = (byte) (iT >> 8);
            for (int i19 = 0; i19 < i16 * 2; i19++) {
                int i20 = bArr[((i19 / 8) * i13 * 4) + i15 + ((i19 / 2) % 4)] & 255;
                int i21 = i19 % 2 == 0 ? i20 & 15 : i20 >> 4;
                int i22 = ((((i21 & 7) * 2) + 1) * i17) >> 3;
                if ((i21 & 8) != 0) {
                    i22 = -i22;
                }
                iT = u0.t(iT + i22, -32768, gg.b.f29413a);
                i18 += i13 * 2;
                bArr2[i18] = (byte) (iT & 255);
                bArr2[i18 + 1] = (byte) (iT >> 8);
                int i23 = iMin + f49550m[i21];
                int[] iArr = f49551n;
                iMin = u0.t(i23, 0, iArr.length - 1);
                i17 = iArr[iMin];
            }
        }

        public final int f(int i10) {
            return i10 / (this.f49554c.f49573b * 2);
        }

        public final int g(int i10) {
            return h(i10, this.f49554c.f49573b);
        }

        public final void i(int i10) {
            long jH1 = this.f49561j + u0.h1(this.f49563l, 1000000L, this.f49554c.f49574c);
            int iG = g(i10);
            this.f49553b.a(jH1, 1, iG, this.f49562k - iG, null);
            this.f49563l += (long) i10;
            this.f49562k -= iG;
        }
    }

    /* JADX INFO: renamed from: sb.b$b, reason: collision with other inner class name */
    public interface InterfaceC0569b {
        void a(long j10);

        boolean b(l lVar, long j10) throws IOException;

        void c(int i10, long j10) throws ParserException;
    }

    public static final class c implements InterfaceC0569b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f49564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d0 f49565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final sb.c f49566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Format f49567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f49568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f49569f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f49570g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f49571h;

        public c(m mVar, d0 d0Var, sb.c cVar, String str, int i10) throws ParserException {
            this.f49564a = mVar;
            this.f49565b = d0Var;
            this.f49566c = cVar;
            int i11 = (cVar.f49573b * cVar.f49577f) / 8;
            if (cVar.f49576e == i11) {
                int i12 = cVar.f49574c;
                int i13 = i12 * i11 * 8;
                int iMax = Math.max(i11, (i12 * i11) / 10);
                this.f49568e = iMax;
                this.f49567d = new Format.b().e0(str).G(i13).Z(i13).W(iMax).H(cVar.f49573b).f0(cVar.f49574c).Y(i10).E();
                return;
            }
            throw new ParserException("Expected block size: " + i11 + "; got: " + cVar.f49576e);
        }

        @Override // sb.b.InterfaceC0569b
        public void a(long j10) {
            this.f49569f = j10;
            this.f49570g = 0;
            this.f49571h = 0L;
        }

        @Override // sb.b.InterfaceC0569b
        public boolean b(l lVar, long j10) throws IOException {
            int i10;
            int i11;
            long j11 = j10;
            while (j11 > 0 && (i10 = this.f49570g) < (i11 = this.f49568e)) {
                int iE = this.f49565b.e(lVar, (int) Math.min(i11 - i10, j11), true);
                if (iE == -1) {
                    j11 = 0;
                } else {
                    this.f49570g += iE;
                    j11 -= (long) iE;
                }
            }
            int i12 = this.f49566c.f49576e;
            int i13 = this.f49570g / i12;
            if (i13 > 0) {
                long jH1 = this.f49569f + u0.h1(this.f49571h, 1000000L, r1.f49574c);
                int i14 = i13 * i12;
                int i15 = this.f49570g - i14;
                this.f49565b.a(jH1, 1, i14, i15, null);
                this.f49571h += (long) i13;
                this.f49570g = i15;
            }
            return j11 <= 0;
        }

        @Override // sb.b.InterfaceC0569b
        public void c(int i10, long j10) {
            this.f49564a.o(new e(this.f49566c, 1, i10, j10));
            this.f49565b.f(this.f49567d);
        }
    }

    public static /* synthetic */ k[] e() {
        return new k[]{new b()};
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        InterfaceC0569b interfaceC0569b = this.f49547f;
        if (interfaceC0569b != null) {
            interfaceC0569b.a(j11);
        }
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f49545d = mVar;
        this.f49546e = mVar.d(0, 1);
        mVar.k();
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void d() {
        hd.a.k(this.f49546e);
        u0.k(this.f49545d);
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        d();
        if (this.f49547f == null) {
            sb.c cVarA = d.a(lVar);
            if (cVarA == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            int i10 = cVarA.f49572a;
            if (i10 == 17) {
                this.f49547f = new a(this.f49545d, this.f49546e, cVarA);
            } else if (i10 == 6) {
                this.f49547f = new c(this.f49545d, this.f49546e, cVarA, w.H, -1);
            } else if (i10 == 7) {
                this.f49547f = new c(this.f49545d, this.f49546e, cVarA, w.I, -1);
            } else {
                int iA = a0.a(i10, cVarA.f49577f);
                if (iA == 0) {
                    throw new ParserException("Unsupported WAV format type: " + cVarA.f49572a);
                }
                this.f49547f = new c(this.f49545d, this.f49546e, cVarA, w.G, iA);
            }
        }
        if (this.f49548g == -1) {
            Pair<Long, Long> pairB = d.b(lVar);
            this.f49548g = ((Long) pairB.first).intValue();
            long jLongValue = ((Long) pairB.second).longValue();
            this.f49549h = jLongValue;
            this.f49547f.c(this.f49548g, jLongValue);
        } else if (lVar.getPosition() == 0) {
            lVar.o(this.f49548g);
        }
        hd.a.i(this.f49549h != -1);
        return this.f49547f.b(lVar, this.f49549h - lVar.getPosition()) ? -1 : 0;
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        return d.a(lVar) != null;
    }

    @Override // hb.k
    public void release() {
    }
}
