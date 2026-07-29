package com.efs.sdk.base.http;

import com.efs.sdk.base.core.util.concurrent.b;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsHttpListener implements b<HttpResponse> {
    public abstract void onError(@p0 HttpResponse httpResponse);

    public abstract void onSuccess(@n0 HttpResponse httpResponse);

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public void result(@p0 HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ) {
            onError(httpResponse);
        } else {
            onSuccess(httpResponse);
        }
    }
}
