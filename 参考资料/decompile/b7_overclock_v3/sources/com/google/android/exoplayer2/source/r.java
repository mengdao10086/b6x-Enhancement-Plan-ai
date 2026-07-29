package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import g.i1;
import g.p0;
import hb.d0;
import hd.c0;
import hd.u0;
import java.io.IOException;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public class r implements d0 {

    @i1
    public static final int M = 1000;
    public static final String N = "SampleQueue";
    public boolean A;
    public boolean D;

    @p0
    public Format E;

    @p0
    public Format F;

    @p0
    public Format G;
    public int H;
    public boolean I;
    public boolean J;
    public long K;
    public boolean L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f18258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final com.google.android.exoplayer2.drm.c f18260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final b.a f18261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final Looper f18262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public b f18263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public Format f18264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public DrmSession f18265k;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18274t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f18277w;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f18259e = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18266l = 1000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f18267m = new int[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long[] f18268n = new long[1000];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long[] f18271q = new long[1000];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f18270p = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f18269o = new int[1000];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d0.a[] f18272r = new d0.a[1000];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Format[] f18273s = new Format[1000];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f18278x = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f18279y = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f18280z = Long.MIN_VALUE;
    public boolean C = true;
    public boolean B = true;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f18282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public d0.a f18283c;
    }

    public interface b {
        void a(Format format);
    }

    public r(ed.b bVar, @p0 Looper looper, @p0 com.google.android.exoplayer2.drm.c cVar, @p0 b.a aVar) {
        this.f18262h = looper;
        this.f18260f = cVar;
        this.f18261g = aVar;
        this.f18258d = new q(bVar);
    }

    public static r j(ed.b bVar, Looper looper, com.google.android.exoplayer2.drm.c cVar, b.a aVar) {
        return new r(bVar, (Looper) hd.a.g(looper), (com.google.android.exoplayer2.drm.c) hd.a.g(cVar), (b.a) hd.a.g(aVar));
    }

    public static r k(ed.b bVar) {
        return new r(bVar, null, null, null);
    }

    public final synchronized long A() {
        return Math.max(this.f18279y, B(this.f18277w));
    }

    public final long B(int i10) {
        long jMax = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int iD = D(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            jMax = Math.max(jMax, this.f18271q[iD]);
            if ((this.f18270p[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.f18266l - 1;
            }
        }
        return jMax;
    }

    public final int C() {
        return this.f18275u + this.f18277w;
    }

    public final int D(int i10) {
        int i11 = this.f18276v + i10;
        int i12 = this.f18266l;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public final synchronized int E(long j10, boolean z10) {
        int iD = D(this.f18277w);
        if (H() && j10 >= this.f18271q[iD]) {
            if (j10 > this.f18280z && z10) {
                return this.f18274t - this.f18277w;
            }
            int iV = v(iD, this.f18274t - this.f18277w, j10, true);
            if (iV == -1) {
                return 0;
            }
            return iV;
        }
        return 0;
    }

    @p0
    public final synchronized Format F() {
        return this.C ? null : this.F;
    }

    public final int G() {
        return this.f18275u + this.f18274t;
    }

    public final boolean H() {
        return this.f18277w != this.f18274t;
    }

    public final void I() {
        this.D = true;
    }

    public final synchronized boolean J() {
        return this.A;
    }

    @g.i
    public synchronized boolean K(boolean z10) {
        Format format;
        boolean z11 = true;
        if (H()) {
            int iD = D(this.f18277w);
            if (this.f18273s[iD] != this.f18264j) {
                return true;
            }
            return L(iD);
        }
        if (!z10 && !this.A && ((format = this.F) == null || format == this.f18264j)) {
            z11 = false;
        }
        return z11;
    }

    public final boolean L(int i10) {
        DrmSession drmSession = this.f18265k;
        return drmSession == null || drmSession.getState() == 4 || ((this.f18270p[i10] & 1073741824) == 0 && this.f18265k.h());
    }

    @g.i
    public void M() throws IOException {
        DrmSession drmSession = this.f18265k;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) hd.a.g(this.f18265k.d()));
        }
    }

    public final void N(Format format, s0 s0Var) {
        Format format2 = this.f18264j;
        boolean z10 = format2 == null;
        DrmInitData drmInitData = z10 ? null : format2.f16702o;
        this.f18264j = format;
        DrmInitData drmInitData2 = format.f16702o;
        com.google.android.exoplayer2.drm.c cVar = this.f18260f;
        s0Var.f57068b = cVar != null ? format.g(cVar.b(format)) : format;
        s0Var.f57067a = this.f18265k;
        if (this.f18260f == null) {
            return;
        }
        if (z10 || !u0.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f18265k;
            DrmSession drmSessionA = this.f18260f.a((Looper) hd.a.g(this.f18262h), this.f18261g, format);
            this.f18265k = drmSessionA;
            s0Var.f57067a = drmSessionA;
            if (drmSession != null) {
                drmSession.f(this.f18261g);
            }
        }
    }

    public final int O(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11) {
        int iP = P(s0Var, decoderInputBuffer, z10, z11, this.f18259e);
        if (iP == -4 && !decoderInputBuffer.m() && !decoderInputBuffer.t()) {
            this.f18258d.f(decoderInputBuffer, this.f18259e);
        }
        return iP;
    }

    public final synchronized int P(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11, a aVar) {
        decoderInputBuffer.f16961d = false;
        if (!H()) {
            if (!z11 && !this.A) {
                Format format = this.F;
                if (format == null || (!z10 && format == this.f18264j)) {
                    return -3;
                }
                N((Format) hd.a.g(format), s0Var);
                return -5;
            }
            decoderInputBuffer.o(4);
            return -4;
        }
        int iD = D(this.f18277w);
        if (!z10 && this.f18273s[iD] == this.f18264j) {
            if (!L(iD)) {
                decoderInputBuffer.f16961d = true;
                return -3;
            }
            decoderInputBuffer.o(this.f18270p[iD]);
            long j10 = this.f18271q[iD];
            decoderInputBuffer.f16962e = j10;
            if (j10 < this.f18278x) {
                decoderInputBuffer.g(Integer.MIN_VALUE);
            }
            aVar.f18281a = this.f18269o[iD];
            aVar.f18282b = this.f18268n[iD];
            aVar.f18283c = this.f18272r[iD];
            return -4;
        }
        N(this.f18273s[iD], s0Var);
        return -5;
    }

    public final synchronized int Q() {
        return H() ? this.f18267m[D(this.f18277w)] : this.H;
    }

    @g.i
    public void R() {
        q();
        U();
    }

    @g.i
    public int S(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11) {
        int iP = P(s0Var, decoderInputBuffer, z10, z11, this.f18259e);
        if (iP == -4 && !decoderInputBuffer.m() && !decoderInputBuffer.t()) {
            this.f18258d.m(decoderInputBuffer, this.f18259e);
            this.f18277w++;
        }
        return iP;
    }

    @g.i
    public void T() {
        W(true);
        U();
    }

    public final void U() {
        DrmSession drmSession = this.f18265k;
        if (drmSession != null) {
            drmSession.f(this.f18261g);
            this.f18265k = null;
            this.f18264j = null;
        }
    }

    public final void V() {
        W(false);
    }

    @g.i
    public void W(boolean z10) {
        this.f18258d.n();
        this.f18274t = 0;
        this.f18275u = 0;
        this.f18276v = 0;
        this.f18277w = 0;
        this.B = true;
        this.f18278x = Long.MIN_VALUE;
        this.f18279y = Long.MIN_VALUE;
        this.f18280z = Long.MIN_VALUE;
        this.A = false;
        this.G = null;
        if (z10) {
            this.E = null;
            this.F = null;
            this.C = true;
        }
    }

    public final synchronized void X() {
        this.f18277w = 0;
        this.f18258d.o();
    }

    public final synchronized boolean Y(int i10) {
        X();
        int i11 = this.f18275u;
        if (i10 >= i11 && i10 <= this.f18274t + i11) {
            this.f18278x = Long.MIN_VALUE;
            this.f18277w = i10 - i11;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j10, boolean z10) {
        X();
        int iD = D(this.f18277w);
        if (H() && j10 >= this.f18271q[iD] && (j10 <= this.f18280z || z10)) {
            int iV = v(iD, this.f18274t - this.f18277w, j10, true);
            if (iV == -1) {
                return false;
            }
            this.f18278x = j10;
            this.f18277w += iV;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    @Override // hb.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r12, int r14, int r15, int r16, @g.p0 hb.d0.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.D
            if (r0 == 0) goto L10
            com.google.android.exoplayer2.Format r0 = r8.E
            java.lang.Object r0 = hd.a.k(r0)
            com.google.android.exoplayer2.Format r0 = (com.google.android.exoplayer2.Format) r0
            r11.f(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = 1
            goto L19
        L18:
            r3 = 0
        L19:
            boolean r4 = r8.B
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.B = r1
        L22:
            long r4 = r8.K
            long r4 = r4 + r12
            boolean r6 = r8.I
            if (r6 == 0) goto L4b
            long r6 = r8.f18278x
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L4b
            boolean r0 = r8.J
            if (r0 != 0) goto L47
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            com.google.android.exoplayer2.Format r6 = r8.F
            r0.append(r6)
            r8.J = r2
        L47:
            r0 = r14 | 1
            r6 = r0
            goto L4c
        L4b:
            r6 = r14
        L4c:
            boolean r0 = r8.L
            if (r0 == 0) goto L5d
            if (r3 == 0) goto L5c
            boolean r0 = r11.g(r4)
            if (r0 != 0) goto L59
            goto L5c
        L59:
            r8.L = r1
            goto L5d
        L5c:
            return
        L5d:
            com.google.android.exoplayer2.source.q r0 = r8.f18258d
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.h(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.r.a(long, int, int, int, hb.d0$a):void");
    }

    public final void a0(long j10) {
        if (this.K != j10) {
            this.K = j10;
            I();
        }
    }

    @Override // hb.d0
    public final int b(ed.h hVar, int i10, boolean z10, int i11) throws IOException {
        return this.f18258d.p(hVar, i10, z10);
    }

    public final void b0(long j10) {
        this.f18278x = j10;
    }

    @Override // hb.d0
    public final void c(c0 c0Var, int i10, int i11) {
        this.f18258d.q(c0Var, i10);
    }

    public final synchronized boolean c0(Format format) {
        this.C = false;
        if (u0.c(format, this.F)) {
            return false;
        }
        if (u0.c(format, this.G)) {
            this.F = this.G;
        } else {
            this.F = format;
        }
        Format format2 = this.F;
        this.I = hd.w.a(format2.f16699l, format2.f16695i);
        this.J = false;
        return true;
    }

    @Override // hb.d0
    public /* synthetic */ void d(c0 c0Var, int i10) {
        hb.c0.b(this, c0Var, i10);
    }

    public final void d0(@p0 b bVar) {
        this.f18263i = bVar;
    }

    @Override // hb.d0
    public /* synthetic */ int e(ed.h hVar, int i10, boolean z10) {
        return hb.c0.a(this, hVar, i10, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void e0(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.f18277w     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f18274t     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            hd.a.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f18277w     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f18277w = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.r.e0(int):void");
    }

    @Override // hb.d0
    public final void f(Format format) {
        Format formatW = w(format);
        this.D = false;
        this.E = format;
        boolean zC0 = c0(formatW);
        b bVar = this.f18263i;
        if (bVar == null || !zC0) {
            return;
        }
        bVar.a(formatW);
    }

    public final void f0(int i10) {
        this.H = i10;
    }

    public final synchronized boolean g(long j10) {
        if (this.f18274t == 0) {
            return j10 > this.f18279y;
        }
        if (A() >= j10) {
            return false;
        }
        t(this.f18275u + i(j10));
        return true;
    }

    public final void g0() {
        this.L = true;
    }

    public final synchronized void h(long j10, int i10, long j11, int i11, @p0 d0.a aVar) {
        int i12 = this.f18274t;
        if (i12 > 0) {
            int iD = D(i12 - 1);
            hd.a.a(this.f18268n[iD] + ((long) this.f18269o[iD]) <= j11);
        }
        this.A = (536870912 & i10) != 0;
        this.f18280z = Math.max(this.f18280z, j10);
        int iD2 = D(this.f18274t);
        this.f18271q[iD2] = j10;
        long[] jArr = this.f18268n;
        jArr[iD2] = j11;
        this.f18269o[iD2] = i11;
        this.f18270p[iD2] = i10;
        this.f18272r[iD2] = aVar;
        Format[] formatArr = this.f18273s;
        Format format = this.F;
        formatArr[iD2] = format;
        this.f18267m[iD2] = this.H;
        this.G = format;
        int i13 = this.f18274t + 1;
        this.f18274t = i13;
        int i14 = this.f18266l;
        if (i13 == i14) {
            int i15 = i14 + 1000;
            int[] iArr = new int[i15];
            long[] jArr2 = new long[i15];
            long[] jArr3 = new long[i15];
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            d0.a[] aVarArr = new d0.a[i15];
            Format[] formatArr2 = new Format[i15];
            int i16 = this.f18276v;
            int i17 = i14 - i16;
            System.arraycopy(jArr, i16, jArr2, 0, i17);
            System.arraycopy(this.f18271q, this.f18276v, jArr3, 0, i17);
            System.arraycopy(this.f18270p, this.f18276v, iArr2, 0, i17);
            System.arraycopy(this.f18269o, this.f18276v, iArr3, 0, i17);
            System.arraycopy(this.f18272r, this.f18276v, aVarArr, 0, i17);
            System.arraycopy(this.f18273s, this.f18276v, formatArr2, 0, i17);
            System.arraycopy(this.f18267m, this.f18276v, iArr, 0, i17);
            int i18 = this.f18276v;
            System.arraycopy(this.f18268n, 0, jArr2, i17, i18);
            System.arraycopy(this.f18271q, 0, jArr3, i17, i18);
            System.arraycopy(this.f18270p, 0, iArr2, i17, i18);
            System.arraycopy(this.f18269o, 0, iArr3, i17, i18);
            System.arraycopy(this.f18272r, 0, aVarArr, i17, i18);
            System.arraycopy(this.f18273s, 0, formatArr2, i17, i18);
            System.arraycopy(this.f18267m, 0, iArr, i17, i18);
            this.f18268n = jArr2;
            this.f18271q = jArr3;
            this.f18270p = iArr2;
            this.f18269o = iArr3;
            this.f18272r = aVarArr;
            this.f18273s = formatArr2;
            this.f18267m = iArr;
            this.f18276v = 0;
            this.f18266l = i15;
        }
    }

    public final int i(long j10) {
        int i10 = this.f18274t;
        int iD = D(i10 - 1);
        while (i10 > this.f18277w && this.f18271q[iD] >= j10) {
            i10--;
            iD--;
            if (iD == -1) {
                iD = this.f18266l - 1;
            }
        }
        return i10;
    }

    public final synchronized long l(long j10, boolean z10, boolean z11) {
        int i10;
        int i11 = this.f18274t;
        if (i11 != 0) {
            long[] jArr = this.f18271q;
            int i12 = this.f18276v;
            if (j10 >= jArr[i12]) {
                if (z11 && (i10 = this.f18277w) != i11) {
                    i11 = i10 + 1;
                }
                int iV = v(i12, i11, j10, z10);
                if (iV == -1) {
                    return -1L;
                }
                return o(iV);
            }
        }
        return -1L;
    }

    public final synchronized long m() {
        int i10 = this.f18274t;
        if (i10 == 0) {
            return -1L;
        }
        return o(i10);
    }

    public synchronized long n() {
        int i10 = this.f18277w;
        if (i10 == 0) {
            return -1L;
        }
        return o(i10);
    }

    public final long o(int i10) {
        this.f18279y = Math.max(this.f18279y, B(i10));
        int i11 = this.f18274t - i10;
        this.f18274t = i11;
        this.f18275u += i10;
        int i12 = this.f18276v + i10;
        this.f18276v = i12;
        int i13 = this.f18266l;
        if (i12 >= i13) {
            this.f18276v = i12 - i13;
        }
        int i14 = this.f18277w - i10;
        this.f18277w = i14;
        if (i14 < 0) {
            this.f18277w = 0;
        }
        if (i11 != 0) {
            return this.f18268n[this.f18276v];
        }
        int i15 = this.f18276v;
        if (i15 != 0) {
            i13 = i15;
        }
        int i16 = i13 - 1;
        return this.f18268n[i16] + ((long) this.f18269o[i16]);
    }

    public final void p(long j10, boolean z10, boolean z11) {
        this.f18258d.b(l(j10, z10, z11));
    }

    public final void q() {
        this.f18258d.b(m());
    }

    public final void r() {
        this.f18258d.b(n());
    }

    public final void s(long j10) {
        if (this.f18274t == 0) {
            return;
        }
        hd.a.a(j10 > A());
        u(this.f18275u + i(j10));
    }

    public final long t(int i10) {
        int iG = G() - i10;
        boolean z10 = false;
        hd.a.a(iG >= 0 && iG <= this.f18274t - this.f18277w);
        int i11 = this.f18274t - iG;
        this.f18274t = i11;
        this.f18280z = Math.max(this.f18279y, B(i11));
        if (iG == 0 && this.A) {
            z10 = true;
        }
        this.A = z10;
        int i12 = this.f18274t;
        if (i12 == 0) {
            return 0L;
        }
        int iD = D(i12 - 1);
        return this.f18268n[iD] + ((long) this.f18269o[iD]);
    }

    public final void u(int i10) {
        this.f18258d.c(t(i10));
    }

    public final int v(int i10, int i11, long j10, boolean z10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            long[] jArr = this.f18271q;
            if (jArr[i10] > j10) {
                return i12;
            }
            if (!z10 || (this.f18270p[i10] & 1) != 0) {
                if (jArr[i10] == j10) {
                    return i13;
                }
                i12 = i13;
            }
            i10++;
            if (i10 == this.f18266l) {
                i10 = 0;
            }
        }
        return i12;
    }

    @g.i
    public Format w(Format format) {
        return (this.K == 0 || format.f16703p == Long.MAX_VALUE) ? format : format.a().i0(format.f16703p + this.K).E();
    }

    public final int x() {
        return this.f18275u;
    }

    public final synchronized long y() {
        return this.f18274t == 0 ? Long.MIN_VALUE : this.f18271q[this.f18276v];
    }

    public final synchronized long z() {
        return this.f18280z;
    }
}
