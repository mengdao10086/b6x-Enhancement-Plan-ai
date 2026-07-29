package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.j;
import ec.y;
import ed.x;
import g.p0;
import hb.a0;
import hb.d0;
import hb.z;
import hd.c0;
import hd.u0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import ya.s0;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements k, hb.m, Loader.b<a>, Loader.f, r.b {
    public static final Map<String, String> E7 = K();
    public static final Format F7 = new Format.b().S("icy").e0(hd.w.A0).E();
    public static final long K2 = 10000;
    public boolean A;
    public boolean C;
    public boolean C1;
    public boolean C2;
    public boolean D;
    public int K1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f18170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f18171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f18172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f18173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m.a f18174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b.a f18175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f18176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ed.b f18177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final String f18178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18179j;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f18181k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public long f18182k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y f18183l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public k.a f18188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public IcyHeaders f18189r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f18192u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f18193v;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f18195v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f18196w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f18197x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a0 f18198y;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Loader f18180k = new Loader("Loader:ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final hd.f f18184m = new hd.f();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f18185n = new Runnable() { // from class: ec.z
        @Override // java.lang.Runnable
        public final void run() {
            this.f26886a.S();
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Runnable f18186o = new Runnable() { // from class: ec.a0
        @Override // java.lang.Runnable
        public final void run() {
            this.f26814a.Q();
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f18187p = u0.z();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d[] f18191t = new d[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public r[] f18190s = new r[0];

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public long f18194v1 = ya.g.f56663b;
    public long K0 = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f18199z = ya.g.f56663b;
    public int B = 1;

    public final class a implements Loader.e, g.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f18201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x f18202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final y f18203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final hb.m f18204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final hd.f f18205f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f18207h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f18209j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @p0
        public d0 f18212m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f18213n;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final z f18206g = new z();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f18208i = true;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f18211l = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18200a = ec.j.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.b f18210k = j(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.a aVar, y yVar, hb.m mVar, hd.f fVar) {
            this.f18201b = uri;
            this.f18202c = new x(aVar);
            this.f18203d = yVar;
            this.f18204e = mVar;
            this.f18205f = fVar;
        }

        @Override // com.google.android.exoplayer2.source.g.a
        public void a(c0 c0Var) {
            long jMax = !this.f18213n ? this.f18209j : Math.max(o.this.M(), this.f18209j);
            int iA = c0Var.a();
            d0 d0Var = (d0) hd.a.g(this.f18212m);
            d0Var.d(c0Var, iA);
            d0Var.a(jMax, 1, iA, 0, null);
            this.f18213n = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() throws IOException {
            int iF = 0;
            while (iF == 0 && !this.f18207h) {
                try {
                    long j10 = this.f18206g.f30930a;
                    com.google.android.exoplayer2.upstream.b bVarJ = j(j10);
                    this.f18210k = bVarJ;
                    long jA = this.f18202c.a(bVarJ);
                    this.f18211l = jA;
                    if (jA != -1) {
                        this.f18211l = jA + j10;
                    }
                    o.this.f18189r = IcyHeaders.a(this.f18202c.c());
                    ed.h gVar = this.f18202c;
                    if (o.this.f18189r != null && o.this.f18189r.f17272f != -1) {
                        gVar = new g(this.f18202c, o.this.f18189r.f17272f, this);
                        d0 d0VarN = o.this.N();
                        this.f18212m = d0VarN;
                        d0VarN.f(o.F7);
                    }
                    long jD = j10;
                    this.f18203d.c(gVar, this.f18201b, this.f18202c.c(), j10, this.f18211l, this.f18204e);
                    if (o.this.f18189r != null) {
                        this.f18203d.e();
                    }
                    if (this.f18208i) {
                        this.f18203d.b(jD, this.f18209j);
                        this.f18208i = false;
                    }
                    while (true) {
                        long j11 = jD;
                        while (iF == 0 && !this.f18207h) {
                            try {
                                this.f18205f.a();
                                iF = this.f18203d.f(this.f18206g);
                                jD = this.f18203d.d();
                                if (jD > o.this.f18179j + j11) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f18205f.d();
                        o.this.f18187p.post(o.this.f18186o);
                    }
                    if (iF == 1) {
                        iF = 0;
                    } else if (this.f18203d.d() != -1) {
                        this.f18206g.f30930a = this.f18203d.d();
                    }
                    u0.p(this.f18202c);
                } catch (Throwable th2) {
                    if (iF != 1 && this.f18203d.d() != -1) {
                        this.f18206g.f30930a = this.f18203d.d();
                    }
                    u0.p(this.f18202c);
                    throw th2;
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
            this.f18207h = true;
        }

        public final com.google.android.exoplayer2.upstream.b j(long j10) {
            return new b.C0198b().j(this.f18201b).i(j10).g(o.this.f18178i).c(6).f(o.E7).a();
        }

        public final void k(long j10, long j11) {
            this.f18206g.f30930a = j10;
            this.f18209j = j11;
            this.f18208i = true;
            this.f18213n = false;
        }
    }

    public interface b {
        void g(long j10, boolean z10, boolean z11);
    }

    public final class c implements ec.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18215a;

        public c(int i10) {
            this.f18215a = i10;
        }

        @Override // ec.d0
        public void a() throws IOException {
            o.this.W(this.f18215a);
        }

        @Override // ec.d0
        public boolean d() {
            return o.this.P(this.f18215a);
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            return o.this.b0(this.f18215a, s0Var, decoderInputBuffer, z10);
        }

        @Override // ec.d0
        public int o(long j10) {
            return o.this.f0(this.f18215a, j10);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18218b;

        public d(int i10, boolean z10) {
            this.f18217a = i10;
            this.f18218b = z10;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f18217a == dVar.f18217a && this.f18218b == dVar.f18218b;
        }

        public int hashCode() {
            return (this.f18217a * 31) + (this.f18218b ? 1 : 0);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackGroupArray f18219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f18220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f18221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f18222d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f18219a = trackGroupArray;
            this.f18220b = zArr;
            int i10 = trackGroupArray.f17502a;
            this.f18221c = new boolean[i10];
            this.f18222d = new boolean[i10];
        }
    }

    public o(Uri uri, com.google.android.exoplayer2.upstream.a aVar, hb.q qVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar2, com.google.android.exoplayer2.upstream.j jVar, m.a aVar3, b bVar, ed.b bVar2, @p0 String str, int i10) {
        this.f18170a = uri;
        this.f18171b = aVar;
        this.f18172c = cVar;
        this.f18175f = aVar2;
        this.f18173d = jVar;
        this.f18174e = aVar3;
        this.f18176g = bVar;
        this.f18177h = bVar2;
        this.f18178i = str;
        this.f18179j = i10;
        this.f18183l = new ec.a(qVar);
    }

    public static Map<String, String> K() {
        HashMap map = new HashMap();
        map.put(IcyHeaders.f17258g, "1");
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (this.C2) {
            return;
        }
        ((k.a) hd.a.g(this.f18188q)).i(this);
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void H() {
        hd.a.i(this.f18193v);
        hd.a.g(this.f18197x);
        hd.a.g(this.f18198y);
    }

    public final boolean I(a aVar, int i10) {
        a0 a0Var;
        if (this.K0 != -1 || ((a0Var = this.f18198y) != null && a0Var.h() != ya.g.f56663b)) {
            this.K1 = i10;
            return true;
        }
        if (this.f18193v && !h0()) {
            this.C1 = true;
            return false;
        }
        this.D = this.f18193v;
        this.f18182k1 = 0L;
        this.K1 = 0;
        for (r rVar : this.f18190s) {
            rVar.V();
        }
        aVar.k(0L, 0L);
        return true;
    }

    public final void J(a aVar) {
        if (this.K0 == -1) {
            this.K0 = aVar.f18211l;
        }
    }

    public final int L() {
        int iG = 0;
        for (r rVar : this.f18190s) {
            iG += rVar.G();
        }
        return iG;
    }

    public final long M() {
        long jMax = Long.MIN_VALUE;
        for (r rVar : this.f18190s) {
            jMax = Math.max(jMax, rVar.z());
        }
        return jMax;
    }

    public d0 N() {
        return a0(new d(0, true));
    }

    public final boolean O() {
        return this.f18194v1 != ya.g.f56663b;
    }

    public boolean P(int i10) {
        return !h0() && this.f18190s[i10].K(this.f18195v2);
    }

    public final void S() {
        if (this.C2 || this.f18193v || !this.f18192u || this.f18198y == null) {
            return;
        }
        for (r rVar : this.f18190s) {
            if (rVar.F() == null) {
                return;
            }
        }
        this.f18184m.d();
        int length = this.f18190s.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            Format formatE = (Format) hd.a.g(this.f18190s[i10].F());
            String str = formatE.f16699l;
            boolean zP = hd.w.p(str);
            boolean z10 = zP || hd.w.s(str);
            zArr[i10] = z10;
            this.f18196w = z10 | this.f18196w;
            IcyHeaders icyHeaders = this.f18189r;
            if (icyHeaders != null) {
                if (zP || this.f18191t[i10].f18218b) {
                    Metadata metadata = formatE.f16696j;
                    formatE = formatE.a().X(metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders)).E();
                }
                if (zP && formatE.f16692f == -1 && formatE.f16693g == -1 && icyHeaders.f17267a != -1) {
                    formatE = formatE.a().G(icyHeaders.f17267a).E();
                }
            }
            trackGroupArr[i10] = new TrackGroup(formatE.g(this.f18172c.b(formatE)));
        }
        this.f18197x = new e(new TrackGroupArray(trackGroupArr), zArr);
        this.f18193v = true;
        ((k.a) hd.a.g(this.f18188q)).l(this);
    }

    public final void T(int i10) {
        H();
        e eVar = this.f18197x;
        boolean[] zArr = eVar.f18222d;
        if (zArr[i10]) {
            return;
        }
        Format formatA = eVar.f18219a.a(i10).a(0);
        this.f18174e.i(hd.w.l(formatA.f16699l), formatA, 0, null, this.f18182k1);
        zArr[i10] = true;
    }

    public final void U(int i10) {
        H();
        boolean[] zArr = this.f18197x.f18220b;
        if (this.C1 && zArr[i10]) {
            if (this.f18190s[i10].K(false)) {
                return;
            }
            this.f18194v1 = 0L;
            this.C1 = false;
            this.D = true;
            this.f18182k1 = 0L;
            this.K1 = 0;
            for (r rVar : this.f18190s) {
                rVar.V();
            }
            ((k.a) hd.a.g(this.f18188q)).i(this);
        }
    }

    public void V() throws IOException {
        this.f18180k.b(this.f18173d.f(this.B));
    }

    public void W(int i10) throws IOException {
        this.f18190s[i10].M();
        V();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, long j10, long j11, boolean z10) {
        x xVar = aVar.f18202c;
        ec.j jVar = new ec.j(aVar.f18200a, aVar.f18210k, xVar.v(), xVar.w(), j10, j11, xVar.u());
        this.f18173d.d(aVar.f18200a);
        this.f18174e.r(jVar, 1, -1, null, 0, null, aVar.f18209j, this.f18199z);
        if (z10) {
            return;
        }
        J(aVar);
        for (r rVar : this.f18190s) {
            rVar.V();
        }
        if (this.f18181k0 > 0) {
            ((k.a) hd.a.g(this.f18188q)).i(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void l(a aVar, long j10, long j11) {
        a0 a0Var;
        if (this.f18199z == ya.g.f56663b && (a0Var = this.f18198y) != null) {
            boolean zE = a0Var.e();
            long jM = M();
            long j12 = jM == Long.MIN_VALUE ? 0L : jM + 10000;
            this.f18199z = j12;
            this.f18176g.g(j12, zE, this.A);
        }
        x xVar = aVar.f18202c;
        ec.j jVar = new ec.j(aVar.f18200a, aVar.f18210k, xVar.v(), xVar.w(), j10, j11, xVar.u());
        this.f18173d.d(aVar.f18200a);
        this.f18174e.u(jVar, 1, -1, null, 0, null, aVar.f18209j, this.f18199z);
        J(aVar);
        this.f18195v2 = true;
        ((k.a) hd.a.g(this.f18188q)).i(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public Loader.c t(a aVar, long j10, long j11, IOException iOException, int i10) {
        boolean z10;
        a aVar2;
        Loader.c cVarI;
        J(aVar);
        x xVar = aVar.f18202c;
        ec.j jVar = new ec.j(aVar.f18200a, aVar.f18210k, xVar.v(), xVar.w(), j10, j11, xVar.u());
        long jA = this.f18173d.a(new j.a(jVar, new ec.k(1, -1, null, 0, null, ya.g.d(aVar.f18209j), ya.g.d(this.f18199z)), iOException, i10));
        if (jA == ya.g.f56663b) {
            cVarI = Loader.f19042k;
        } else {
            int iL = L();
            if (iL > this.K1) {
                aVar2 = aVar;
                z10 = true;
            } else {
                z10 = false;
                aVar2 = aVar;
            }
            cVarI = I(aVar2, iL) ? Loader.i(z10, jA) : Loader.f19041j;
        }
        boolean z11 = !cVarI.c();
        this.f18174e.w(jVar, 1, -1, null, 0, null, aVar.f18209j, this.f18199z, iOException, z11);
        if (z11) {
            this.f18173d.d(aVar.f18200a);
        }
        return cVarI;
    }

    @Override // com.google.android.exoplayer2.source.r.b
    public void a(Format format) {
        this.f18187p.post(this.f18185n);
    }

    public final d0 a0(d dVar) {
        int length = this.f18190s.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (dVar.equals(this.f18191t[i10])) {
                return this.f18190s[i10];
            }
        }
        r rVarJ = r.j(this.f18177h, this.f18187p.getLooper(), this.f18172c, this.f18175f);
        rVarJ.d0(this);
        int i11 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f18191t, i11);
        dVarArr[length] = dVar;
        this.f18191t = (d[]) u0.l(dVarArr);
        r[] rVarArr = (r[]) Arrays.copyOf(this.f18190s, i11);
        rVarArr[length] = rVarJ;
        this.f18190s = (r[]) u0.l(rVarArr);
        return rVarJ;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        if (this.f18181k0 == 0) {
            return Long.MIN_VALUE;
        }
        return f();
    }

    public int b0(int i10, s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        if (h0()) {
            return -3;
        }
        T(i10);
        int iS = this.f18190s[i10].S(s0Var, decoderInputBuffer, z10, this.f18195v2);
        if (iS == -3) {
            U(i10);
        }
        return iS;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        H();
        if (!this.f18198y.e()) {
            return 0L;
        }
        a0.a aVarG = this.f18198y.g(j10);
        return t1Var.a(j10, aVarG.f30800a.f30805a, aVarG.f30801b.f30805a);
    }

    public void c0() {
        if (this.f18193v) {
            for (r rVar : this.f18190s) {
                rVar.R();
            }
        }
        this.f18180k.m(this);
        this.f18187p.removeCallbacksAndMessages(null);
        this.f18188q = null;
        this.C2 = true;
    }

    @Override // hb.m
    public d0 d(int i10, int i11) {
        return a0(new d(i10, false));
    }

    public final boolean d0(boolean[] zArr, long j10) {
        int length = this.f18190s.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.f18190s[i10].Z(j10, false) && (zArr[i10] || !this.f18196w)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        if (this.f18195v2 || this.f18180k.j() || this.C1) {
            return false;
        }
        if (this.f18193v && this.f18181k0 == 0) {
            return false;
        }
        boolean zF = this.f18184m.f();
        if (this.f18180k.k()) {
            return zF;
        }
        g0();
        return true;
    }

    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final void R(a0 a0Var) {
        this.f18198y = this.f18189r == null ? a0Var : new a0.b(ya.g.f56663b);
        this.f18199z = a0Var.h();
        boolean z10 = this.K0 == -1 && a0Var.h() == ya.g.f56663b;
        this.A = z10;
        this.B = z10 ? 7 : 1;
        this.f18176g.g(this.f18199z, a0Var.e(), this.A);
        if (this.f18193v) {
            return;
        }
        S();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        long jM;
        H();
        boolean[] zArr = this.f18197x.f18220b;
        if (this.f18195v2) {
            return Long.MIN_VALUE;
        }
        if (O()) {
            return this.f18194v1;
        }
        if (this.f18196w) {
            int length = this.f18190s.length;
            jM = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                if (zArr[i10] && !this.f18190s[i10].J()) {
                    jM = Math.min(jM, this.f18190s[i10].z());
                }
            }
        } else {
            jM = Long.MAX_VALUE;
        }
        if (jM == Long.MAX_VALUE) {
            jM = M();
        }
        return jM == Long.MIN_VALUE ? this.f18182k1 : jM;
    }

    public int f0(int i10, long j10) {
        if (h0()) {
            return 0;
        }
        T(i10);
        r rVar = this.f18190s[i10];
        int iE = rVar.E(j10, this.f18195v2);
        rVar.e0(iE);
        if (iE == 0) {
            U(i10);
        }
        return iE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
    }

    public final void g0() {
        a aVar = new a(this.f18170a, this.f18171b, this.f18183l, this, this.f18184m);
        if (this.f18193v) {
            hd.a.i(O());
            long j10 = this.f18199z;
            if (j10 != ya.g.f56663b && this.f18194v1 > j10) {
                this.f18195v2 = true;
                this.f18194v1 = ya.g.f56663b;
                return;
            }
            aVar.k(((a0) hd.a.g(this.f18198y)).g(this.f18194v1).f30800a.f30806b, this.f18194v1);
            for (r rVar : this.f18190s) {
                rVar.b0(this.f18194v1);
            }
            this.f18194v1 = ya.g.f56663b;
        }
        this.K1 = L();
        this.f18174e.A(new ec.j(aVar.f18200a, aVar.f18210k, this.f18180k.n(aVar, this, this.f18173d.f(this.B))), 1, -1, null, 0, null, aVar.f18209j, this.f18199z);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void h() {
        for (r rVar : this.f18190s) {
            rVar.T();
        }
        this.f18183l.release();
    }

    public final boolean h0() {
        return this.D || O();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f18180k.k() && this.f18184m.e();
    }

    @Override // com.google.android.exoplayer2.source.k
    public /* synthetic */ List j(List list) {
        return ec.m.a(this, list);
    }

    @Override // hb.m
    public void k() {
        this.f18192u = true;
        this.f18187p.post(this.f18185n);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        V();
        if (this.f18195v2 && !this.f18193v) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        H();
        boolean[] zArr = this.f18197x.f18220b;
        if (!this.f18198y.e()) {
            j10 = 0;
        }
        int i10 = 0;
        this.D = false;
        this.f18182k1 = j10;
        if (O()) {
            this.f18194v1 = j10;
            return j10;
        }
        if (this.B != 7 && d0(zArr, j10)) {
            return j10;
        }
        this.C1 = false;
        this.f18194v1 = j10;
        this.f18195v2 = false;
        if (this.f18180k.k()) {
            r[] rVarArr = this.f18190s;
            int length = rVarArr.length;
            while (i10 < length) {
                rVarArr[i10].q();
                i10++;
            }
            this.f18180k.g();
        } else {
            this.f18180k.h();
            r[] rVarArr2 = this.f18190s;
            int length2 = rVarArr2.length;
            while (i10 < length2) {
                rVarArr2[i10].V();
                i10++;
            }
        }
        return j10;
    }

    @Override // hb.m
    public void o(final a0 a0Var) {
        this.f18187p.post(new Runnable() { // from class: ec.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f26817a.R(a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        if (!this.D) {
            return ya.g.f56663b;
        }
        if (!this.f18195v2 && L() <= this.K1) {
            return ya.g.f56663b;
        }
        this.D = false;
        return this.f18182k1;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f18188q = aVar;
        this.f18184m.f();
        g0();
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        H();
        return this.f18197x.f18219a;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, ec.d0[] d0VarArr, boolean[] zArr2, long j10) {
        H();
        e eVar = this.f18197x;
        TrackGroupArray trackGroupArray = eVar.f18219a;
        boolean[] zArr3 = eVar.f18221c;
        int i10 = this.f18181k0;
        int i11 = 0;
        for (int i12 = 0; i12 < bVarArr.length; i12++) {
            if (d0VarArr[i12] != null && (bVarArr[i12] == null || !zArr[i12])) {
                int i13 = ((c) d0VarArr[i12]).f18215a;
                hd.a.i(zArr3[i13]);
                this.f18181k0--;
                zArr3[i13] = false;
                d0VarArr[i12] = null;
            }
        }
        boolean z10 = !this.C ? j10 == 0 : i10 != 0;
        for (int i14 = 0; i14 < bVarArr.length; i14++) {
            if (d0VarArr[i14] == null && bVarArr[i14] != null) {
                com.google.android.exoplayer2.trackselection.b bVar = bVarArr[i14];
                hd.a.i(bVar.length() == 1);
                hd.a.i(bVar.c(0) == 0);
                int iB = trackGroupArray.b(bVar.a());
                hd.a.i(!zArr3[iB]);
                this.f18181k0++;
                zArr3[iB] = true;
                d0VarArr[i14] = new c(iB);
                zArr2[i14] = true;
                if (!z10) {
                    r rVar = this.f18190s[iB];
                    z10 = (rVar.Z(j10, true) || rVar.C() == 0) ? false : true;
                }
            }
        }
        if (this.f18181k0 == 0) {
            this.C1 = false;
            this.D = false;
            if (this.f18180k.k()) {
                r[] rVarArr = this.f18190s;
                int length = rVarArr.length;
                while (i11 < length) {
                    rVarArr[i11].q();
                    i11++;
                }
                this.f18180k.g();
            } else {
                r[] rVarArr2 = this.f18190s;
                int length2 = rVarArr2.length;
                while (i11 < length2) {
                    rVarArr2[i11].V();
                    i11++;
                }
            }
        } else if (z10) {
            j10 = n(j10);
            while (i11 < d0VarArr.length) {
                if (d0VarArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.C = true;
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        H();
        if (O()) {
            return;
        }
        boolean[] zArr = this.f18197x.f18221c;
        int length = this.f18190s.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f18190s[i10].p(j10, z10, zArr[i10]);
        }
    }
}
