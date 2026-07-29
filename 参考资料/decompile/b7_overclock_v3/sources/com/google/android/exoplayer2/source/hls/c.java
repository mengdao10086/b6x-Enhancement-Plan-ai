package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import g.i1;
import hb.z;
import hd.p0;
import java.io.IOException;
import rb.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z f17824d = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @i1
    public final hb.k f17825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format f17826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0 f17827c;

    public c(hb.k kVar, Format format, p0 p0Var) {
        this.f17825a = kVar;
        this.f17826b = format;
        this.f17827c = p0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean a(hb.l lVar) throws IOException {
        return this.f17825a.f(lVar, f17824d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public void c(hb.m mVar) {
        this.f17825a.c(mVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public void d() {
        this.f17825a.b(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean e() {
        hb.k kVar = this.f17825a;
        return (kVar instanceof rb.h) || (kVar instanceof rb.b) || (kVar instanceof rb.e) || (kVar instanceof nb.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public boolean f() {
        hb.k kVar = this.f17825a;
        return (kVar instanceof h0) || (kVar instanceof ob.g);
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public k g() {
        hb.k fVar;
        hd.a.i(!f());
        hb.k kVar = this.f17825a;
        if (kVar instanceof w) {
            fVar = new w(this.f17826b.f16689c, this.f17827c);
        } else if (kVar instanceof rb.h) {
            fVar = new rb.h();
        } else if (kVar instanceof rb.b) {
            fVar = new rb.b();
        } else if (kVar instanceof rb.e) {
            fVar = new rb.e();
        } else {
            if (!(kVar instanceof nb.f)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f17825a.getClass().getSimpleName());
            }
            fVar = new nb.f();
        }
        return new c(fVar, this.f17826b, this.f17827c);
    }
}
