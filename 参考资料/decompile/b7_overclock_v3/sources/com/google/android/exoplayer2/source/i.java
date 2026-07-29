package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import ec.d0;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.List;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l.a f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ed.b f18131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f18132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f18133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public k.a f18134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public a f18135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18137i = ya.g.f56663b;

    public interface a {
        void a(l.a aVar);

        void b(l.a aVar, IOException iOException);
    }

    public i(l.a aVar, ed.b bVar, long j10) {
        this.f18129a = aVar;
        this.f18131c = bVar;
        this.f18130b = j10;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return ((k) u0.k(this.f18133e)).b();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        return ((k) u0.k(this.f18133e)).c(j10, t1Var);
    }

    public void d(l.a aVar) {
        long jT = t(this.f18130b);
        k kVarA = ((l) hd.a.g(this.f18132d)).a(aVar, this.f18131c, jT);
        this.f18133e = kVarA;
        if (this.f18134f != null) {
            kVarA.q(this, jT);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        k kVar = this.f18133e;
        return kVar != null && kVar.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return ((k) u0.k(this.f18133e)).f();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        ((k) u0.k(this.f18133e)).g(j10);
    }

    public long h() {
        return this.f18137i;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        k kVar = this.f18133e;
        return kVar != null && kVar.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public /* synthetic */ List j(List list) {
        return ec.m.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public void l(k kVar) {
        ((k.a) u0.k(this.f18134f)).l(this);
        a aVar = this.f18135g;
        if (aVar != null) {
            aVar.a(this.f18129a);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        try {
            k kVar = this.f18133e;
            if (kVar != null) {
                kVar.m();
            } else {
                l lVar = this.f18132d;
                if (lVar != null) {
                    lVar.n();
                }
            }
        } catch (IOException e10) {
            a aVar = this.f18135g;
            if (aVar == null) {
                throw e10;
            }
            if (this.f18136h) {
                return;
            }
            this.f18136h = true;
            aVar.b(this.f18129a, e10);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        return ((k) u0.k(this.f18133e)).n(j10);
    }

    public long o() {
        return this.f18130b;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        return ((k) u0.k(this.f18133e)).p();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f18134f = aVar;
        k kVar = this.f18133e;
        if (kVar != null) {
            kVar.q(this, t(this.f18130b));
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return ((k) u0.k(this.f18133e)).r();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
        long j11;
        long j12 = this.f18137i;
        if (j12 == ya.g.f56663b || j10 != this.f18130b) {
            j11 = j10;
        } else {
            this.f18137i = ya.g.f56663b;
            j11 = j12;
        }
        return ((k) u0.k(this.f18133e)).s(bVarArr, zArr, d0VarArr, zArr2, j11);
    }

    public final long t(long j10) {
        long j11 = this.f18137i;
        return j11 != ya.g.f56663b ? j11 : j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        ((k) u0.k(this.f18133e)).u(j10, z10);
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void i(k kVar) {
        ((k.a) u0.k(this.f18134f)).i(this);
    }

    public void w(long j10) {
        this.f18137i = j10;
    }

    public void x() {
        if (this.f18133e != null) {
            ((l) hd.a.g(this.f18132d)).p(this.f18133e);
        }
    }

    public void y(l lVar) {
        hd.a.i(this.f18132d == null);
        this.f18132d = lVar;
    }

    public void z(a aVar) {
        this.f18135g = aVar;
    }
}
