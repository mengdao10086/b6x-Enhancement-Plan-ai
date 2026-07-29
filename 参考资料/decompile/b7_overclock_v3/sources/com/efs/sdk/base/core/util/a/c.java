package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.HttpResponse;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12940a;

    public c(@n0 b bVar) {
        super(bVar);
        this.f12940a = bVar;
    }

    @n0
    public final HttpResponse b() {
        this.f12940a.f12937e = "post";
        return a();
    }
}
