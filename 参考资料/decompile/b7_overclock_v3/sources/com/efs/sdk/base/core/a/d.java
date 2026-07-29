package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import g.n0;
import g.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AbsHttpListener {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f12796a = new d(0);
    }

    public /* synthetic */ d(byte b10) {
        this();
    }

    private static void b(HttpResponse httpResponse) {
        f.a.f12921a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    private static void c(HttpResponse httpResponse) {
        int i10;
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str) && (i10 = Integer.parseInt(str)) > com.efs.sdk.base.core.config.a.c.a().f12860d.f12850a) {
                com.efs.sdk.base.core.config.a.c.a().a(i10);
            }
        }
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* synthetic */ void a(@n0 com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, @p0 HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((Map) httpResponse2.extra).putAll(bVar.f12938f);
            bVar.f12938f.clear();
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@p0 HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        b(httpResponse);
        c(httpResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    @Override // com.efs.sdk.base.http.AbsHttpListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSuccess(@g.n0 com.efs.sdk.base.http.HttpResponse r6) {
        /*
            r5 = this;
            T r0 = r6.extra
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "flow_limit"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L20
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.String r0 = r0.toString()
            T r2 = r6.extra
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r1 = r2.get(r1)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L6d
        L20:
            T r0 = r6.extra
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "type"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L37
            T r0 = r6.extra
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L39
        L37:
            java.lang.String r0 = ""
        L39:
            T r1 = r6.extra
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "size"
            boolean r1 = r1.containsKey(r2)
            r3 = 0
            if (r1 == 0) goto L5b
            T r1 = r6.extra
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L5b
            int r1 = java.lang.Integer.parseInt(r1)
            goto L5c
        L5b:
            r1 = 0
        L5c:
            com.efs.sdk.base.core.c.b r2 = com.efs.sdk.base.core.c.b.a()
            android.os.Message r4 = android.os.Message.obtain()
            r4.what = r3
            r4.obj = r0
            r4.arg1 = r1
            r2.sendMessage(r4)
        L6d:
            b(r6)
            com.efs.sdk.base.core.f.f r0 = com.efs.sdk.base.core.f.f.a.a()
            com.efs.sdk.base.core.f.d r0 = r0.f12919c
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f12912b
            r0.incrementAndGet()
            c(r6)
            a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.a.d.onSuccess(com.efs.sdk.base.http.HttpResponse):void");
    }

    private d() {
    }

    public static d a() {
        return a.f12796a;
    }

    private static void a(@p0 HttpResponse httpResponse) {
        String str;
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                str = "upload result : false";
            } else {
                str = "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString();
            }
            Log.i("efs.px.api", str);
        }
    }
}
