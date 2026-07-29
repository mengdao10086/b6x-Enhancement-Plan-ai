package com.just.agentweb;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.just.agentweb.AgentWeb;

/* JADX INFO: loaded from: classes7.dex */
public class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22084a = getClass().getSimpleName();

    public static l c() {
        return new l();
    }

    @Override // com.just.agentweb.j
    @TargetApi(11)
    public void a(WebView webView) {
    }

    @Override // com.just.agentweb.j
    public void b(androidx.collection.a<String, Object> aVar, AgentWeb.SecurityType securityType) {
        if (securityType == AgentWeb.SecurityType.STRICT_CHECK) {
            int i10 = xf.c.f55204i;
        }
    }
}
