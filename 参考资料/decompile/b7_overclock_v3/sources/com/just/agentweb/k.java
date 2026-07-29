package com.just.agentweb;

import android.webkit.WebView;
import com.just.agentweb.AgentWeb;
import xf.q0;

/* JADX INFO: loaded from: classes7.dex */
public class k implements q0<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f22081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.collection.a<String, Object> f22082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AgentWeb.SecurityType f22083c;

    public k(WebView webView, androidx.collection.a<String, Object> aVar, AgentWeb.SecurityType securityType) {
        this.f22081a = webView;
        this.f22082b = aVar;
        this.f22083c = securityType;
    }

    @Override // xf.q0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(j jVar) {
        jVar.a(this.f22081a);
        androidx.collection.a<String, Object> aVar = this.f22082b;
        if (aVar == null || this.f22083c != AgentWeb.SecurityType.STRICT_CHECK || aVar.isEmpty()) {
            return;
        }
        jVar.b(this.f22082b, this.f22083c);
    }
}
