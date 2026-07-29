package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.j;
import ec.d;
import ec.d0;
import ed.u;
import ed.z;
import g.p0;
import gc.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ya.g;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements k, s.a<h<b>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f18325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final z f18326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f18327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f18328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b.a f18329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f18330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m.a f18331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ed.b f18332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TrackGroupArray f18333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f18334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public k.a f18335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f18336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h<b>[] f18337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s f18338n;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, @p0 z zVar, d dVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar3, j jVar, m.a aVar4, u uVar, ed.b bVar) {
        this.f18336l = aVar;
        this.f18325a = aVar2;
        this.f18326b = zVar;
        this.f18327c = uVar;
        this.f18328d = cVar;
        this.f18329e = aVar3;
        this.f18330f = jVar;
        this.f18331g = aVar4;
        this.f18332h = bVar;
        this.f18334j = dVar;
        this.f18333i = h(aVar, cVar);
        h<b>[] hVarArrO = o(0);
        this.f18337m = hVarArrO;
        this.f18338n = dVar.a(hVarArrO);
    }

    public static TrackGroupArray h(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, com.google.android.exoplayer2.drm.c cVar) {
        TrackGroup[] trackGroupArr = new TrackGroup[aVar.f18410f.length];
        int i10 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f18410f;
            if (i10 >= bVarArr.length) {
                return new TrackGroupArray(trackGroupArr);
            }
            Format[] formatArr = bVarArr[i10].f18429j;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i11 = 0; i11 < formatArr.length; i11++) {
                Format format = formatArr[i11];
                formatArr2[i11] = format.g(cVar.b(format));
            }
            trackGroupArr[i10] = new TrackGroup(formatArr2);
            i10++;
        }
    }

    public static h<b>[] o(int i10) {
        return new h[i10];
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return this.f18338n.b();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        for (h<b> hVar : this.f18337m) {
            if (hVar.f29175a == 2) {
                return hVar.c(j10, t1Var);
            }
        }
        return j10;
    }

    public final h<b> d(com.google.android.exoplayer2.trackselection.b bVar, long j10) {
        int iB = this.f18333i.b(bVar.a());
        return new h<>(this.f18336l.f18410f[iB].f18420a, null, null, this.f18325a.a(this.f18327c, this.f18336l, iB, bVar, this.f18326b), this, this.f18332h, j10, this.f18328d, this.f18329e, this.f18330f, this.f18331g);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        return this.f18338n.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return this.f18338n.f();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        this.f18338n.g(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f18338n.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public List<StreamKey> j(List<com.google.android.exoplayer2.trackselection.b> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.google.android.exoplayer2.trackselection.b bVar = list.get(i10);
            int iB = this.f18333i.b(bVar.a());
            for (int i11 = 0; i11 < bVar.length(); i11++) {
                arrayList.add(new StreamKey(iB, bVar.c(i11)));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        this.f18327c.a();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        for (h<b> hVar : this.f18337m) {
            hVar.S(j10);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        return g.f56663b;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f18335k = aVar;
        aVar.l(this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return this.f18333i;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (d0VarArr[i10] != null) {
                h hVar = (h) d0VarArr[i10];
                if (bVarArr[i10] == null || !zArr[i10]) {
                    hVar.P();
                    d0VarArr[i10] = null;
                } else {
                    ((b) hVar.E()).b(bVarArr[i10]);
                    arrayList.add(hVar);
                }
            }
            if (d0VarArr[i10] == null && bVarArr[i10] != null) {
                h<b> hVarD = d(bVarArr[i10], j10);
                arrayList.add(hVarD);
                d0VarArr[i10] = hVarD;
                zArr2[i10] = true;
            }
        }
        h<b>[] hVarArrO = o(arrayList.size());
        this.f18337m = hVarArrO;
        arrayList.toArray(hVarArrO);
        this.f18338n = this.f18334j.a(this.f18337m);
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void i(h<b> hVar) {
        this.f18335k.i(this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        for (h<b> hVar : this.f18337m) {
            hVar.u(j10, z10);
        }
    }

    public void v() {
        for (h<b> hVar : this.f18337m) {
            hVar.P();
        }
        this.f18335k = null;
    }

    public void w(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f18336l = aVar;
        for (h<b> hVar : this.f18337m) {
            ((b) hVar.E()).f(aVar);
        }
        this.f18335k.i(this);
    }
}
