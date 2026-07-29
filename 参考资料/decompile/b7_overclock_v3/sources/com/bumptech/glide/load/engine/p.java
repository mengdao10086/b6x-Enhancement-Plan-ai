package com.bumptech.glide.load.engine;

import g.i1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c4.b, j<?>> f12460a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c4.b, j<?>> f12461b = new HashMap();

    public j<?> a(c4.b bVar, boolean z10) {
        return c(z10).get(bVar);
    }

    @i1
    public Map<c4.b, j<?>> b() {
        return Collections.unmodifiableMap(this.f12460a);
    }

    public final Map<c4.b, j<?>> c(boolean z10) {
        return z10 ? this.f12461b : this.f12460a;
    }

    public void d(c4.b bVar, j<?> jVar) {
        c(jVar.q()).put(bVar, jVar);
    }

    public void e(c4.b bVar, j<?> jVar) {
        Map<c4.b, j<?>> mapC = c(jVar.q());
        if (jVar.equals(mapC.get(bVar))) {
            mapC.remove(bVar);
        }
    }
}
