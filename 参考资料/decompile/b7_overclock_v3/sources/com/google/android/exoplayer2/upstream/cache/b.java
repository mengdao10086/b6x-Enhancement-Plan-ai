package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.a;
import ed.j;
import fd.f;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class b implements a.InterfaceC0197a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f19185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.InterfaceC0197a f19186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0197a f19187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final j.a f19189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final a.c f19190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final f f19191g;

    public b(Cache cache, a.InterfaceC0197a interfaceC0197a) {
        this(cache, interfaceC0197a, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a a() {
        Cache cache = this.f19185a;
        com.google.android.exoplayer2.upstream.a aVarA = this.f19186b.a();
        com.google.android.exoplayer2.upstream.a aVarA2 = this.f19187c.a();
        j.a aVar = this.f19189e;
        return new a(cache, aVarA, aVarA2, aVar == null ? null : aVar.a(), this.f19188d, this.f19190f, this.f19191g);
    }

    public b(Cache cache, a.InterfaceC0197a interfaceC0197a, int i10) {
        this(cache, interfaceC0197a, new FileDataSource.a(), new CacheDataSink.a().c(cache), i10, null);
    }

    public b(Cache cache, a.InterfaceC0197a interfaceC0197a, a.InterfaceC0197a interfaceC0197a2, @p0 j.a aVar, int i10, @p0 a.c cVar) {
        this(cache, interfaceC0197a, interfaceC0197a2, aVar, i10, cVar, null);
    }

    public b(Cache cache, a.InterfaceC0197a interfaceC0197a, a.InterfaceC0197a interfaceC0197a2, @p0 j.a aVar, int i10, @p0 a.c cVar, @p0 f fVar) {
        this.f19185a = cache;
        this.f19186b = interfaceC0197a;
        this.f19187c = interfaceC0197a2;
        this.f19189e = aVar;
        this.f19188d = i10;
        this.f19190f = cVar;
        this.f19191g = fVar;
    }
}
