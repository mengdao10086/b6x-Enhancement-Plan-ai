package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.k;
import ec.d0;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.List;
import ya.s0;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public k.a f17563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a[] f17564c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f17565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f17566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f17567f;

    public final class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f17568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17569b;

        public a(d0 d0Var) {
            this.f17568a = d0Var;
        }

        @Override // ec.d0
        public void a() throws IOException {
            this.f17568a.a();
        }

        public void b() {
            this.f17569b = false;
        }

        @Override // ec.d0
        public boolean d() {
            return !b.this.h() && this.f17568a.d();
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            if (b.this.h()) {
                return -3;
            }
            if (this.f17569b) {
                decoderInputBuffer.o(4);
                return -4;
            }
            int iK = this.f17568a.k(s0Var, decoderInputBuffer, z10);
            if (iK == -5) {
                Format format = (Format) hd.a.g(s0Var.f57068b);
                int i10 = format.B;
                if (i10 != 0 || format.C != 0) {
                    b bVar = b.this;
                    if (bVar.f17566e != 0) {
                        i10 = 0;
                    }
                    s0Var.f57068b = format.a().M(i10).N(bVar.f17567f == Long.MIN_VALUE ? format.C : 0).E();
                }
                return -5;
            }
            b bVar2 = b.this;
            long j10 = bVar2.f17567f;
            if (j10 == Long.MIN_VALUE || ((iK != -4 || decoderInputBuffer.f16962e < j10) && !(iK == -3 && bVar2.f() == Long.MIN_VALUE && !decoderInputBuffer.f16961d))) {
                return iK;
            }
            decoderInputBuffer.h();
            decoderInputBuffer.o(4);
            this.f17569b = true;
            return -4;
        }

        @Override // ec.d0
        public int o(long j10) {
            if (b.this.h()) {
                return -3;
            }
            return this.f17568a.o(j10);
        }
    }

    public b(k kVar, boolean z10, long j10, long j11) {
        this.f17562a = kVar;
        this.f17565d = z10 ? j10 : ya.g.f56663b;
        this.f17566e = j10;
        this.f17567f = j11;
    }

    public static boolean t(long j10, com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        if (j10 != 0) {
            for (com.google.android.exoplayer2.trackselection.b bVar : bVarArr) {
                if (bVar != null) {
                    Format formatP = bVar.p();
                    if (!hd.w.a(formatP.f16699l, formatP.f16695i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        long jB = this.f17562a.b();
        if (jB != Long.MIN_VALUE) {
            long j10 = this.f17567f;
            if (j10 == Long.MIN_VALUE || jB < j10) {
                return jB;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        long j11 = this.f17566e;
        if (j10 == j11) {
            return j11;
        }
        return this.f17562a.c(j10, d(j10, t1Var));
    }

    public final t1 d(long j10, t1 t1Var) {
        long jU = u0.u(t1Var.f57075a, 0L, j10 - this.f17566e);
        long j11 = t1Var.f57076b;
        long j12 = this.f17567f;
        long jU2 = u0.u(j11, 0L, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j10);
        return (jU == t1Var.f57075a && jU2 == t1Var.f57076b) ? t1Var : new t1(jU, jU2);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        return this.f17562a.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        long jF = this.f17562a.f();
        if (jF != Long.MIN_VALUE) {
            long j10 = this.f17567f;
            if (j10 == Long.MIN_VALUE || jF < j10) {
                return jF;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        this.f17562a.g(j10);
    }

    public boolean h() {
        return this.f17565d != ya.g.f56663b;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f17562a.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public /* synthetic */ List j(List list) {
        return ec.m.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public void l(k kVar) {
        ((k.a) hd.a.g(this.f17563b)).l(this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        this.f17562a.m();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.google.android.exoplayer2.source.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long n(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f17565d = r0
            com.google.android.exoplayer2.source.b$a[] r0 = r6.f17564c
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.b()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.exoplayer2.source.k r0 = r6.f17562a
            long r0 = r0.n(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.f17566e
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.f17567f
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            hd.a.i(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.n(long):long");
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void i(k kVar) {
        ((k.a) hd.a.g(this.f17563b)).i(this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        if (h()) {
            long j10 = this.f17565d;
            this.f17565d = ya.g.f56663b;
            long jP = p();
            return jP != ya.g.f56663b ? jP : j10;
        }
        long jP2 = this.f17562a.p();
        if (jP2 == ya.g.f56663b) {
            return ya.g.f56663b;
        }
        boolean z10 = true;
        hd.a.i(jP2 >= this.f17566e);
        long j11 = this.f17567f;
        if (j11 != Long.MIN_VALUE && jP2 > j11) {
            z10 = false;
        }
        hd.a.i(z10);
        return jP2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f17563b = aVar;
        this.f17562a.q(this, j10);
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return this.f17562a.r();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    @Override // com.google.android.exoplayer2.source.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long s(com.google.android.exoplayer2.trackselection.b[] r13, boolean[] r14, ec.d0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.b$a[] r2 = new com.google.android.exoplayer2.source.b.a[r2]
            r0.f17564c = r2
            int r2 = r1.length
            ec.d0[] r9 = new ec.d0[r2]
            r10 = 0
            r2 = 0
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L25
            com.google.android.exoplayer2.source.b$a[] r3 = r0.f17564c
            r4 = r1[r2]
            com.google.android.exoplayer2.source.b$a r4 = (com.google.android.exoplayer2.source.b.a) r4
            r3[r2] = r4
            r4 = r3[r2]
            if (r4 == 0) goto L20
            r3 = r3[r2]
            ec.d0 r11 = r3.f17568a
        L20:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L25:
            com.google.android.exoplayer2.source.k r2 = r0.f17562a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.s(r3, r4, r5, r6, r7)
            boolean r4 = r12.h()
            if (r4 == 0) goto L47
            long r4 = r0.f17566e
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L47
            r6 = r13
            boolean r4 = t(r4, r13)
            if (r4 == 0) goto L47
            r4 = r2
            goto L4c
        L47:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L4c:
            r0.f17565d = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L67
            long r4 = r0.f17566e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L65
            long r4 = r0.f17567f
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L67
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L65
            goto L67
        L65:
            r4 = 0
            goto L68
        L67:
            r4 = 1
        L68:
            hd.a.i(r4)
        L6b:
            int r4 = r1.length
            if (r10 >= r4) goto L97
            r4 = r9[r10]
            if (r4 != 0) goto L77
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f17564c
            r4[r10] = r11
            goto L8e
        L77:
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f17564c
            r5 = r4[r10]
            if (r5 == 0) goto L85
            r5 = r4[r10]
            ec.d0 r5 = r5.f17568a
            r6 = r9[r10]
            if (r5 == r6) goto L8e
        L85:
            com.google.android.exoplayer2.source.b$a r5 = new com.google.android.exoplayer2.source.b$a
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L8e:
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f17564c
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L6b
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.s(com.google.android.exoplayer2.trackselection.b[], boolean[], ec.d0[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        this.f17562a.u(j10, z10);
    }

    public void v(long j10, long j11) {
        this.f17566e = j10;
        this.f17567f = j11;
    }
}
