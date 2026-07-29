package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.j;
import ec.d0;
import ed.x;
import ed.z;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ya.s0;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements k, Loader.b<c> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f18457o = "SingleSampleMediaPeriod";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f18458p = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f18459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.InterfaceC0197a f18460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final z f18461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f18462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m.a f18463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TrackGroupArray f18464f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18466h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Format f18468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f18469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f18471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f18472n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<b> f18465g = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Loader f18467i = new Loader("Loader:SingleSampleMediaPeriod");

    public final class b implements d0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f18473d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f18474e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f18475f = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18477b;

        public b() {
        }

        @Override // ec.d0
        public void a() throws IOException {
            v vVar = v.this;
            if (vVar.f18469k) {
                return;
            }
            vVar.f18467i.a();
        }

        public final void b() {
            if (this.f18477b) {
                return;
            }
            v.this.f18463e.i(hd.w.l(v.this.f18468j.f16699l), v.this.f18468j, 0, null, 0L);
            this.f18477b = true;
        }

        public void c() {
            if (this.f18476a == 2) {
                this.f18476a = 1;
            }
        }

        @Override // ec.d0
        public boolean d() {
            return v.this.f18470l;
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            b();
            int i10 = this.f18476a;
            if (i10 == 2) {
                decoderInputBuffer.g(4);
                return -4;
            }
            if (z10 || i10 == 0) {
                s0Var.f57068b = v.this.f18468j;
                this.f18476a = 1;
                return -5;
            }
            v vVar = v.this;
            if (!vVar.f18470l) {
                return -3;
            }
            if (vVar.f18471m != null) {
                decoderInputBuffer.g(1);
                decoderInputBuffer.f16962e = 0L;
                if (decoderInputBuffer.t()) {
                    return -4;
                }
                decoderInputBuffer.q(v.this.f18472n);
                ByteBuffer byteBuffer = decoderInputBuffer.f16960c;
                v vVar2 = v.this;
                byteBuffer.put(vVar2.f18471m, 0, vVar2.f18472n);
            } else {
                decoderInputBuffer.g(4);
            }
            this.f18476a = 2;
            return -4;
        }

        @Override // ec.d0
        public int o(long j10) {
            b();
            if (j10 <= 0 || this.f18476a == 2) {
                return 0;
            }
            this.f18476a = 2;
            return 1;
        }
    }

    public static final class c implements Loader.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18479a = ec.j.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.b f18480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x f18481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public byte[] f18482d;

        public c(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.upstream.a aVar) {
            this.f18480b = bVar;
            this.f18481c = new x(aVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() throws IOException {
            this.f18481c.x();
            try {
                this.f18481c.a(this.f18480b);
                int i10 = 0;
                while (i10 != -1) {
                    int iU = (int) this.f18481c.u();
                    byte[] bArr = this.f18482d;
                    if (bArr == null) {
                        this.f18482d = new byte[1024];
                    } else if (iU == bArr.length) {
                        this.f18482d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    x xVar = this.f18481c;
                    byte[] bArr2 = this.f18482d;
                    i10 = xVar.read(bArr2, iU, bArr2.length - iU);
                }
            } finally {
                u0.p(this.f18481c);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
        }
    }

    public v(com.google.android.exoplayer2.upstream.b bVar, a.InterfaceC0197a interfaceC0197a, @p0 z zVar, Format format, long j10, com.google.android.exoplayer2.upstream.j jVar, m.a aVar, boolean z10) {
        this.f18459a = bVar;
        this.f18460b = interfaceC0197a;
        this.f18461c = zVar;
        this.f18468j = format;
        this.f18466h = j10;
        this.f18462d = jVar;
        this.f18463e = aVar;
        this.f18469k = z10;
        this.f18464f = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return (this.f18470l || this.f18467i.k()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        return j10;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void i(c cVar, long j10, long j11, boolean z10) {
        x xVar = cVar.f18481c;
        ec.j jVar = new ec.j(cVar.f18479a, cVar.f18480b, xVar.v(), xVar.w(), j10, j11, xVar.u());
        this.f18462d.d(cVar.f18479a);
        this.f18463e.r(jVar, 1, -1, null, 0, null, 0L, this.f18466h);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        if (this.f18470l || this.f18467i.k() || this.f18467i.j()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.a aVarA = this.f18460b.a();
        z zVar = this.f18461c;
        if (zVar != null) {
            aVarA.d(zVar);
        }
        c cVar = new c(this.f18459a, aVarA);
        this.f18463e.A(new ec.j(cVar.f18479a, this.f18459a, this.f18467i.n(cVar, this, this.f18462d.f(1))), 1, -1, this.f18468j, 0, null, 0L, this.f18466h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return this.f18470l ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void l(c cVar, long j10, long j11) {
        this.f18472n = (int) cVar.f18481c.u();
        this.f18471m = (byte[]) hd.a.g(cVar.f18482d);
        this.f18470l = true;
        x xVar = cVar.f18481c;
        ec.j jVar = new ec.j(cVar.f18479a, cVar.f18480b, xVar.v(), xVar.w(), j10, j11, this.f18472n);
        this.f18462d.d(cVar.f18479a);
        this.f18463e.u(jVar, 1, -1, this.f18468j, 0, null, 0L, this.f18466h);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f18467i.k();
    }

    @Override // com.google.android.exoplayer2.source.k
    public /* synthetic */ List j(List list) {
        return ec.m.a(this, list);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Loader.c t(c cVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c cVarI;
        x xVar = cVar.f18481c;
        ec.j jVar = new ec.j(cVar.f18479a, cVar.f18480b, xVar.v(), xVar.w(), j10, j11, xVar.u());
        long jA = this.f18462d.a(new j.a(jVar, new ec.k(1, -1, this.f18468j, 0, null, 0L, ya.g.d(this.f18466h)), iOException, i10));
        boolean z10 = jA == ya.g.f56663b || i10 >= this.f18462d.f(1);
        if (this.f18469k && z10) {
            hd.t.o(f18457o, "Loading failed, treating as end-of-stream.", iOException);
            this.f18470l = true;
            cVarI = Loader.f19041j;
        } else {
            cVarI = jA != ya.g.f56663b ? Loader.i(false, jA) : Loader.f19042k;
        }
        Loader.c cVar2 = cVarI;
        boolean z11 = !cVar2.c();
        this.f18463e.w(jVar, 1, -1, this.f18468j, 0, null, 0L, this.f18466h, iOException, z11);
        if (z11) {
            this.f18462d.d(cVar.f18479a);
        }
        return cVar2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() {
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        for (int i10 = 0; i10 < this.f18465g.size(); i10++) {
            this.f18465g.get(i10).c();
        }
        return j10;
    }

    public void o() {
        this.f18467i.l();
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
        return this.f18464f;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (d0VarArr[i10] != null && (bVarArr[i10] == null || !zArr[i10])) {
                this.f18465g.remove(d0VarArr[i10]);
                d0VarArr[i10] = null;
            }
            if (d0VarArr[i10] == null && bVarArr[i10] != null) {
                b bVar = new b();
                this.f18465g.add(bVar);
                d0VarArr[i10] = bVar;
                zArr2[i10] = true;
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
    }
}
