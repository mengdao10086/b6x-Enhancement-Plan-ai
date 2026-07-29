package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import g.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> f12942b;

    public d(@n0 String str) {
        b bVar = new b();
        this.f12941a = bVar;
        bVar.f12933a = str;
    }

    public final d a(@n0 Map<String, String> map) {
        this.f12941a.f12934b = map;
        return this;
    }

    public final d a(String str, String str2) {
        b bVar = this.f12941a;
        if (bVar.f12938f == null) {
            bVar.f12938f = new HashMap(5);
        }
        this.f12941a.f12938f.put(str, str2);
        return this;
    }

    public final d a(@n0 AbsHttpListener absHttpListener) {
        if (this.f12942b == null) {
            this.f12942b = new ArrayList(5);
        }
        this.f12942b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.f12941a);
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> list = this.f12942b;
        if (list != null && list.size() > 0) {
            cVar.a(this.f12942b);
        }
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
