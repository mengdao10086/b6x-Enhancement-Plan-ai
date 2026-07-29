package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.b;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import ec.x;
import g.p0;
import hd.u0;
import java.util.Arrays;
import java.util.List;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements x {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17741l = "DefaultMediaSourceFactory";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0197a f17742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<x> f17743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f17744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public a f17745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public b.a f17746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.j f17747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f17748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f17749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f17751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f17752k;

    public interface a {
        @p0
        com.google.android.exoplayer2.source.ads.b a(v0.b bVar);
    }

    public e(Context context) {
        this(new com.google.android.exoplayer2.upstream.d(context));
    }

    public static SparseArray<x> j(a.InterfaceC0197a interfaceC0197a, hb.q qVar) {
        SparseArray<x> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (x) DashMediaSource.Factory.class.asSubclass(x.class).getConstructor(a.InterfaceC0197a.class).newInstance(interfaceC0197a));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (x) SsMediaSource.Factory.class.asSubclass(x.class).getConstructor(a.InterfaceC0197a.class).newInstance(interfaceC0197a));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (x) HlsMediaSource.Factory.class.asSubclass(x.class).getConstructor(a.InterfaceC0197a.class).newInstance(interfaceC0197a));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new p.b(interfaceC0197a, qVar));
        return sparseArray;
    }

    public static l k(v0 v0Var, l lVar) {
        v0.d dVar = v0Var.f57135e;
        long j10 = dVar.f57164a;
        if (j10 == 0 && dVar.f57165b == Long.MIN_VALUE && !dVar.f57167d) {
            return lVar;
        }
        long jC = ya.g.c(j10);
        long jC2 = ya.g.c(v0Var.f57135e.f57165b);
        v0.d dVar2 = v0Var.f57135e;
        return new ClippingMediaSource(lVar, jC, jC2, !dVar2.f57168e, dVar2.f57166c, dVar2.f57167d);
    }

    @Override // ec.x
    public l c(v0 v0Var) {
        hd.a.g(v0Var.f57132b);
        v0.g gVar = v0Var.f57132b;
        int iB0 = u0.B0(gVar.f57183a, gVar.f57184b);
        x xVar = this.f17743b.get(iB0);
        hd.a.h(xVar, "No suitable media source factory found for content type: " + iB0);
        v0.f fVar = v0Var.f57133c;
        if ((fVar.f57178a == ya.g.f56663b && this.f17748g != ya.g.f56663b) || ((fVar.f57181d == -3.4028235E38f && this.f17751j != -3.4028235E38f) || ((fVar.f57182e == -3.4028235E38f && this.f17752k != -3.4028235E38f) || ((fVar.f57179b == ya.g.f56663b && this.f17749h != ya.g.f56663b) || (fVar.f57180c == ya.g.f56663b && this.f17750i != ya.g.f56663b))))) {
            v0.c cVarA = v0Var.a();
            long j10 = v0Var.f57133c.f57178a;
            if (j10 == ya.g.f56663b) {
                j10 = this.f17748g;
            }
            v0.c cVarY = cVarA.y(j10);
            float f10 = v0Var.f57133c.f57181d;
            if (f10 == -3.4028235E38f) {
                f10 = this.f17751j;
            }
            v0.c cVarX = cVarY.x(f10);
            float f11 = v0Var.f57133c.f57182e;
            if (f11 == -3.4028235E38f) {
                f11 = this.f17752k;
            }
            v0.c cVarV = cVarX.v(f11);
            long j11 = v0Var.f57133c.f57179b;
            if (j11 == ya.g.f56663b) {
                j11 = this.f17749h;
            }
            v0.c cVarW = cVarV.w(j11);
            long j12 = v0Var.f57133c.f57180c;
            if (j12 == ya.g.f56663b) {
                j12 = this.f17750i;
            }
            v0Var = cVarW.u(j12).a();
        }
        l lVarC = xVar.c(v0Var);
        List<v0.h> list = ((v0.g) u0.k(v0Var.f57132b)).f57189g;
        if (!list.isEmpty()) {
            l[] lVarArr = new l[list.size() + 1];
            int i10 = 0;
            lVarArr[0] = lVarC;
            w.b bVarC = new w.b(this.f17742a).c(this.f17747f);
            while (i10 < list.size()) {
                int i11 = i10 + 1;
                lVarArr[i11] = bVarC.b(list.get(i10), ya.g.f56663b);
                i10 = i11;
            }
            lVarC = new MergingMediaSource(lVarArr);
        }
        return l(v0Var, k(v0Var, lVarC));
    }

    @Override // ec.x
    public int[] e() {
        int[] iArr = this.f17744c;
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // ec.x
    public /* synthetic */ l h(Uri uri) {
        return ec.w.a(this, uri);
    }

    public final l l(v0 v0Var, l lVar) {
        hd.a.g(v0Var.f57132b);
        v0.b bVar = v0Var.f57132b.f57186d;
        if (bVar == null) {
            return lVar;
        }
        a aVar = this.f17745d;
        b.a aVar2 = this.f17746e;
        if (aVar == null || aVar2 == null) {
            hd.t.n(f17741l, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return lVar;
        }
        com.google.android.exoplayer2.source.ads.b bVarA = aVar.a(bVar);
        if (bVarA == null) {
            hd.t.n(f17741l, "Playing media without ads, as no AdsLoader was provided.");
            return lVar;
        }
        com.google.android.exoplayer2.upstream.b bVar2 = new com.google.android.exoplayer2.upstream.b(bVar.f57136a);
        Object obj = bVar.f57137b;
        return new AdsMediaSource(lVar, bVar2, obj != null ? obj : Pair.create(v0Var.f57131a, bVar.f57136a), this, bVarA, aVar2);
    }

    public e m(@p0 b.a aVar) {
        this.f17746e = aVar;
        return this;
    }

    public e n(@p0 a aVar) {
        this.f17745d = aVar;
        return this;
    }

    @Override // ec.x
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e d(@p0 HttpDataSource.b bVar) {
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).d(bVar);
        }
        return this;
    }

    @Override // ec.x
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public e g(@p0 com.google.android.exoplayer2.drm.c cVar) {
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).g(cVar);
        }
        return this;
    }

    @Override // ec.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public e f(@p0 gb.r rVar) {
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).f(rVar);
        }
        return this;
    }

    @Override // ec.x
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e a(@p0 String str) {
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).a(str);
        }
        return this;
    }

    public e s(long j10) {
        this.f17750i = j10;
        return this;
    }

    public e t(float f10) {
        this.f17752k = f10;
        return this;
    }

    public e u(long j10) {
        this.f17749h = j10;
        return this;
    }

    public e v(float f10) {
        this.f17751j = f10;
        return this;
    }

    public e w(long j10) {
        this.f17748g = j10;
        return this;
    }

    @Override // ec.x
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public e i(@p0 com.google.android.exoplayer2.upstream.j jVar) {
        this.f17747f = jVar;
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).i(jVar);
        }
        return this;
    }

    @Override // ec.x
    @Deprecated
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public e b(@p0 List<StreamKey> list) {
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17743b.valueAt(i10).b(list);
        }
        return this;
    }

    public e(Context context, hb.q qVar) {
        this(new com.google.android.exoplayer2.upstream.d(context), qVar);
    }

    public e(a.InterfaceC0197a interfaceC0197a) {
        this(interfaceC0197a, new hb.h());
    }

    public e(a.InterfaceC0197a interfaceC0197a, hb.q qVar) {
        this.f17742a = interfaceC0197a;
        SparseArray<x> sparseArrayJ = j(interfaceC0197a, qVar);
        this.f17743b = sparseArrayJ;
        this.f17744c = new int[sparseArrayJ.size()];
        for (int i10 = 0; i10 < this.f17743b.size(); i10++) {
            this.f17744c[i10] = this.f17743b.keyAt(i10);
        }
        this.f17748g = ya.g.f56663b;
        this.f17749h = ya.g.f56663b;
        this.f17750i = ya.g.f56663b;
        this.f17751j = -3.4028235E38f;
        this.f17752k = -3.4028235E38f;
    }
}
