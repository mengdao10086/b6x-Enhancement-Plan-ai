package com.efs.sdk.base.core.c;

import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.d.b f12825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f12826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12827c;

    public e(com.efs.sdk.base.core.d.b bVar, c cVar, String str) {
        this.f12825a = bVar;
        this.f12826b = cVar;
        this.f12827c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        com.efs.sdk.base.core.d.b bVar = this.f12825a;
        HttpResponse httpResponse = (bVar == null || (cVar = this.f12826b) == null) ? new HttpResponse() : cVar.a(bVar, true);
        d.a().a(this.f12827c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.f12827c = null;
        this.f12826b = null;
    }
}
