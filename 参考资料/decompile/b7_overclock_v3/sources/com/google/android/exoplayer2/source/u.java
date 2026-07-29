package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import ec.d0;
import ec.e0;
import ed.z;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.List;
import ya.s0;
import ya.t1;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends com.google.android.exoplayer2.source.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f18440i = "SilenceMediaSource";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f18441j = 44100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f18442k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f18443l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Format f18444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v0 f18445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f18446o;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f18447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v0 f18448h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f18449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Object f18450b;

        public u a() {
            hd.a.i(this.f18449a > 0);
            return new u(this.f18449a, u.f18445n.a().E(this.f18450b).a());
        }

        public b b(long j10) {
            this.f18449a = j10;
            return this;
        }

        public b c(@p0 Object obj) {
            this.f18450b = obj;
            return this;
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final TrackGroupArray f18451c = new TrackGroupArray(new TrackGroup(u.f18444m));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<d0> f18453b = new ArrayList<>();

        public c(long j10) {
            this.f18452a = j10;
        }

        public final long a(long j10) {
            return u0.u(j10, 0L, this.f18452a);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public long b() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.k
        public long c(long j10, t1 t1Var) {
            return a(j10);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public boolean e(long j10) {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public long f() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public void g(long j10) {
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.k
        public /* synthetic */ List j(List list) {
            return ec.m.a(this, list);
        }

        @Override // com.google.android.exoplayer2.source.k
        public void m() {
        }

        @Override // com.google.android.exoplayer2.source.k
        public long n(long j10) {
            long jA = a(j10);
            for (int i10 = 0; i10 < this.f18453b.size(); i10++) {
                ((d) this.f18453b.get(i10)).b(jA);
            }
            return jA;
        }

        @Override // com.google.android.exoplayer2.source.k
        public long p() {
            return ya.g.f56663b;
        }

        @Override // com.google.android.exoplayer2.source.k
        public void q(k.a aVar, long j10) {
            aVar.l(this);
        }

        @Override // com.google.android.exoplayer2.source.k
        public TrackGroupArray r() {
            return f18451c;
        }

        @Override // com.google.android.exoplayer2.source.k
        public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
            long jA = a(j10);
            for (int i10 = 0; i10 < bVarArr.length; i10++) {
                if (d0VarArr[i10] != null && (bVarArr[i10] == null || !zArr[i10])) {
                    this.f18453b.remove(d0VarArr[i10]);
                    d0VarArr[i10] = null;
                }
                if (d0VarArr[i10] == null && bVarArr[i10] != null) {
                    d dVar = new d(this.f18452a);
                    dVar.b(jA);
                    this.f18453b.add(dVar);
                    d0VarArr[i10] = dVar;
                    zArr2[i10] = true;
                }
            }
            return jA;
        }

        @Override // com.google.android.exoplayer2.source.k
        public void u(long j10, boolean z10) {
        }
    }

    public static final class d implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18456c;

        public d(long j10) {
            this.f18454a = u.K(j10);
            b(0L);
        }

        @Override // ec.d0
        public void a() {
        }

        public void b(long j10) {
            this.f18456c = u0.u(u.K(j10), 0L, this.f18454a);
        }

        @Override // ec.d0
        public boolean d() {
            return true;
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            if (!this.f18455b || z10) {
                s0Var.f57068b = u.f18444m;
                this.f18455b = true;
                return -5;
            }
            long j10 = this.f18454a;
            long j11 = this.f18456c;
            long j12 = j10 - j11;
            if (j12 == 0) {
                decoderInputBuffer.g(4);
                return -4;
            }
            decoderInputBuffer.f16962e = u.L(j11);
            decoderInputBuffer.g(1);
            if (decoderInputBuffer.t()) {
                return -4;
            }
            int iMin = (int) Math.min(u.f18446o.length, j12);
            decoderInputBuffer.q(iMin);
            decoderInputBuffer.f16960c.put(u.f18446o, 0, iMin);
            this.f18456c += (long) iMin;
            return -4;
        }

        @Override // ec.d0
        public int o(long j10) {
            long j11 = this.f18456c;
            b(j10);
            return (int) ((this.f18456c - j11) / ((long) u.f18446o.length));
        }
    }

    static {
        Format formatE = new Format.b().e0(hd.w.G).H(2).f0(f18441j).Y(2).E();
        f18444m = formatE;
        f18445n = new v0.c().z(f18440i).F(Uri.EMPTY).B(formatE.f16699l).a();
        f18446o = new byte[u0.m0(2, 2) * 1024];
    }

    public static long K(long j10) {
        return ((long) u0.m0(2, 2)) * ((j10 * 44100) / 1000000);
    }

    public static long L(long j10) {
        return ((j10 / ((long) u0.m0(2, 2))) * 1000000) / 44100;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        D(new e0(this.f18447g, true, false, false, (Object) null, this.f18448h));
    }

    @Override // com.google.android.exoplayer2.source.a
    public void E() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        return new c(this.f18447g);
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        return ((v0.g) hd.a.g(this.f18448h.f57132b)).f57190h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        return this.f18448h;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
    }

    public u(long j10) {
        this(j10, f18445n);
    }

    public u(long j10, v0 v0Var) {
        hd.a.a(j10 >= 0);
        this.f18447g = j10;
        this.f18448h = v0Var;
    }
}
