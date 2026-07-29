package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.e;
import com.google.common.primitives.Ints;
import g.b0;
import g.p0;
import gb.r;
import hd.u0;
import java.util.Map;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17047a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0("lock")
    public v0.e f17048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("lock")
    public c f17049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public HttpDataSource.b f17050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public String f17051e;

    @Override // gb.r
    public c a(v0 v0Var) {
        c cVar;
        hd.a.g(v0Var.f57132b);
        v0.e eVar = v0Var.f57132b.f57185c;
        if (eVar == null || u0.f31154a < 18) {
            return c.f17057a;
        }
        synchronized (this.f17047a) {
            if (!u0.c(eVar, this.f17048b)) {
                this.f17048b = eVar;
                this.f17049c = b(eVar);
            }
            cVar = (c) hd.a.g(this.f17049c);
        }
        return cVar;
    }

    @g.v0(18)
    public final c b(v0.e eVar) {
        HttpDataSource.b bVarK = this.f17050d;
        if (bVarK == null) {
            bVarK = new e.b().k(this.f17051e);
        }
        Uri uri = eVar.f57170b;
        h hVar = new h(uri == null ? null : uri.toString(), eVar.f57174f, bVarK);
        for (Map.Entry<String, String> entry : eVar.f57171c.entrySet()) {
            hVar.g(entry.getKey(), entry.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().h(eVar.f57169a, g.f17081k).d(eVar.f57172d).e(eVar.f57173e).g(Ints.toArray(eVar.f57175g)).a(hVar);
        defaultDrmSessionManagerA.t(0, eVar.a());
        return defaultDrmSessionManagerA;
    }

    public void c(@p0 HttpDataSource.b bVar) {
        this.f17050d = bVar;
    }

    public void d(@p0 String str) {
        this.f17051e = str;
    }
}
