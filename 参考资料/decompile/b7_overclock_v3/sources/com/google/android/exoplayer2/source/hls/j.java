package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableList;
import g.p0;
import hd.c0;
import hd.s0;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends gc.m {
    public static final String L = "com.apple.streaming.transportStreamTimestamp";
    public static final AtomicInteger M = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public k C;
    public s D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public ImmutableList<Integer> I;
    public boolean J;
    public boolean K;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f17870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f17871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f17872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f17873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public final com.google.android.exoplayer2.upstream.a f17874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public final com.google.android.exoplayer2.upstream.b f17875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public final k f17876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f17877s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f17878t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hd.p0 f17879u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f17880v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public final List<Format> f17881w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public final DrmInitData f17882x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final zb.b f17883y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c0 f17884z;

    public j(h hVar, com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, boolean z10, @p0 com.google.android.exoplayer2.upstream.a aVar2, @p0 com.google.android.exoplayer2.upstream.b bVar2, boolean z11, Uri uri, @p0 List<Format> list, int i10, @p0 Object obj, long j10, long j11, long j12, int i11, boolean z12, int i12, boolean z13, boolean z14, hd.p0 p0Var, @p0 DrmInitData drmInitData, @p0 k kVar, zb.b bVar3, c0 c0Var, boolean z15) {
        super(aVar, bVar, format, i10, obj, j10, j11, j12);
        this.A = z10;
        this.f17873o = i11;
        this.K = z12;
        this.f17870l = i12;
        this.f17875q = bVar2;
        this.f17874p = aVar2;
        this.F = bVar2 != null;
        this.B = z11;
        this.f17871m = uri;
        this.f17877s = z14;
        this.f17879u = p0Var;
        this.f17878t = z13;
        this.f17880v = hVar;
        this.f17881w = list;
        this.f17882x = drmInitData;
        this.f17876r = kVar;
        this.f17883y = bVar3;
        this.f17884z = c0Var;
        this.f17872n = z15;
        this.I = ImmutableList.of();
        this.f17869k = M.getAndIncrement();
    }

    public static com.google.android.exoplayer2.upstream.a i(com.google.android.exoplayer2.upstream.a aVar, @p0 byte[] bArr, @p0 byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        hd.a.g(bArr2);
        return new a(aVar, bArr, bArr2);
    }

    public static j j(h hVar, com.google.android.exoplayer2.upstream.a aVar, Format format, long j10, com.google.android.exoplayer2.source.hls.playlist.c cVar, f.e eVar, Uri uri, @p0 List<Format> list, int i10, @p0 Object obj, boolean z10, v vVar, @p0 j jVar, @p0 byte[] bArr, @p0 byte[] bArr2) {
        boolean z11;
        com.google.android.exoplayer2.upstream.a aVarI;
        com.google.android.exoplayer2.upstream.b bVar;
        boolean z12;
        int i11;
        zb.b bVar2;
        c0 c0Var;
        k kVar;
        boolean z13;
        c.f fVar = eVar.f17862a;
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0198b().j(s0.e(cVar.f39566a, fVar.f18051a)).i(fVar.f18059i).h(fVar.f18060j).c(eVar.f17865d ? 8 : 0).a();
        boolean z14 = bArr != null;
        com.google.android.exoplayer2.upstream.a aVarI2 = i(aVar, bArr, z14 ? l((String) hd.a.g(fVar.f18058h)) : null);
        c.e eVar2 = fVar.f18052b;
        if (eVar2 != null) {
            boolean z15 = bArr2 != null;
            byte[] bArrL = z15 ? l((String) hd.a.g(eVar2.f18058h)) : null;
            z11 = z14;
            bVar = new com.google.android.exoplayer2.upstream.b(s0.e(cVar.f39566a, eVar2.f18051a), eVar2.f18059i, eVar2.f18060j);
            aVarI = i(aVar, bArr2, bArrL);
            z12 = z15;
        } else {
            z11 = z14;
            aVarI = null;
            bVar = null;
            z12 = false;
        }
        long j11 = j10 + fVar.f18055e;
        long j12 = j11 + fVar.f18053c;
        int i12 = cVar.f18031h + fVar.f18054d;
        if (jVar != null) {
            boolean z16 = uri.equals(jVar.f17871m) && jVar.H;
            zb.b bVar3 = jVar.f17883y;
            c0 c0Var2 = jVar.f17884z;
            boolean z17 = !(z16 || (p(eVar, cVar) && j11 >= jVar.f29170h));
            if (!z16 || jVar.J) {
                i11 = i12;
            } else {
                i11 = i12;
                k kVar2 = jVar.f17870l == i11 ? jVar.C : null;
                z13 = z17;
                kVar = kVar2;
                bVar2 = bVar3;
                c0Var = c0Var2;
            }
            z13 = z17;
            kVar = kVar2;
            bVar2 = bVar3;
            c0Var = c0Var2;
        } else {
            i11 = i12;
            bVar2 = new zb.b();
            c0Var = new c0(10);
            kVar = null;
            z13 = false;
        }
        return new j(hVar, aVarI2, bVarA, format, z11, aVarI, bVar, z12, uri, list, i10, obj, j11, j12, eVar.f17863b, eVar.f17864c, !eVar.f17865d, i11, fVar.f18061k, z10, vVar.a(i11), fVar.f18056f, kVar, bVar2, c0Var, z13);
    }

    public static byte[] l(String str) {
        if (u0.w1(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean p(f.e eVar, com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        c.f fVar = eVar.f17862a;
        return fVar instanceof c.b ? ((c.b) fVar).f18044l || (eVar.f17864c == 0 && cVar.f39568c) : cVar.f39568c;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() throws IOException {
        k kVar;
        hd.a.g(this.D);
        if (this.C == null && (kVar = this.f17876r) != null && kVar.f()) {
            this.C = this.f17876r;
            this.F = false;
        }
        s();
        if (this.G) {
            return;
        }
        if (!this.f17878t) {
            r();
        }
        this.H = !this.G;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
        this.G = true;
    }

    @Override // gc.m
    public boolean h() {
        return this.H;
    }

    @RequiresNonNull({"output"})
    public final void k(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) throws IOException {
        com.google.android.exoplayer2.upstream.b bVarE;
        long position;
        long j10;
        if (z10) {
            z = this.E != 0;
            bVarE = bVar;
        } else {
            bVarE = bVar.e(this.E);
        }
        try {
            hb.g gVarU = u(aVar, bVarE);
            if (z) {
                gVarU.o(this.E);
            }
            while (!this.G && this.C.a(gVarU)) {
                try {
                    try {
                    } catch (EOFException e10) {
                        if ((this.f29166d.f16691e & 16384) == 0) {
                            throw e10;
                        }
                        this.C.d();
                        position = gVarU.getPosition();
                        j10 = bVar.f19098g;
                    }
                } catch (Throwable th2) {
                    this.E = (int) (gVarU.getPosition() - bVar.f19098g);
                    throw th2;
                }
            }
            position = gVarU.getPosition();
            j10 = bVar.f19098g;
            this.E = (int) (position - j10);
        } finally {
            u0.p(aVar);
        }
    }

    public int m(int i10) {
        hd.a.i(!this.f17872n);
        if (i10 >= this.I.size()) {
            return 0;
        }
        return this.I.get(i10).intValue();
    }

    public void n(s sVar, ImmutableList<Integer> immutableList) {
        this.D = sVar;
        this.I = immutableList;
    }

    public void o() {
        this.J = true;
    }

    public boolean q() {
        return this.K;
    }

    @RequiresNonNull({"output"})
    public final void r() throws IOException {
        try {
            this.f17879u.h(this.f17877s, this.f29169g);
            k(this.f29171i, this.f29164b, this.A);
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    @RequiresNonNull({"output"})
    public final void s() throws IOException {
        if (this.F) {
            hd.a.g(this.f17874p);
            hd.a.g(this.f17875q);
            k(this.f17874p, this.f17875q, this.B);
            this.E = 0;
            this.F = false;
        }
    }

    public final long t(hb.l lVar) throws IOException {
        lVar.n();
        try {
            this.f17884z.O(10);
            lVar.t(this.f17884z.d(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f17884z.J() != 4801587) {
            return ya.g.f56663b;
        }
        this.f17884z.T(3);
        int iF = this.f17884z.F();
        int i10 = iF + 10;
        if (i10 > this.f17884z.b()) {
            byte[] bArrD = this.f17884z.d();
            this.f17884z.O(i10);
            System.arraycopy(bArrD, 0, this.f17884z.d(), 0, 10);
        }
        lVar.t(this.f17884z.d(), 10, iF);
        Metadata metadataE = this.f17883y.e(this.f17884z.d(), iF);
        if (metadataE == null) {
            return ya.g.f56663b;
        }
        int iG = metadataE.g();
        for (int i11 = 0; i11 < iG; i11++) {
            Metadata.Entry entryE = metadataE.e(i11);
            if (entryE instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entryE;
                if (L.equals(privFrame.f17316b)) {
                    System.arraycopy(privFrame.f17317c, 0, this.f17884z.d(), 0, 8);
                    this.f17884z.S(0);
                    this.f17884z.R(8);
                    return this.f17884z.z() & 8589934591L;
                }
            }
        }
        return ya.g.f56663b;
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({"output"})
    public final hb.g u(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        hb.g gVar = new hb.g(aVar, bVar.f19098g, aVar.a(bVar));
        if (this.C == null) {
            long jT = t(gVar);
            gVar.n();
            k kVar = this.f17876r;
            k kVarG = kVar != null ? kVar.g() : this.f17880v.a(bVar.f19092a, this.f29166d, this.f17881w, this.f17879u, aVar.c(), gVar);
            this.C = kVarG;
            if (kVarG.e()) {
                this.D.n0(jT != ya.g.f56663b ? this.f17879u.b(jT) : this.f29169g);
            } else {
                this.D.n0(0L);
            }
            this.D.Z();
            this.C.c(this.D);
        }
        this.D.k0(this.f17882x);
        return gVar;
    }

    public void v() {
        this.K = true;
    }
}
