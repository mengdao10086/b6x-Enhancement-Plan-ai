package com.just.agentweb;

import android.webkit.WebView;
import com.just.agentweb.AgentWeb;
import java.util.Map;
import xf.a0;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class h extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f22067d = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f22068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AgentWeb.SecurityType f22069c;

    public h(WebView webView, AgentWeb.SecurityType securityType) {
        super(securityType);
        this.f22068b = webView;
        this.f22069c = securityType;
    }

    public static h f(WebView webView, AgentWeb.SecurityType securityType) {
        return new h(webView, securityType);
    }

    @Override // xf.a0
    public a0 a(String str, Object obj) {
        if (!d()) {
            return this;
        }
        if (!b(obj)) {
            throw new JsInterfaceObjectException("this object has not offer method javascript to call , please check addJavascriptInterface annotation was be added");
        }
        e(str, obj);
        return this;
    }

    @Override // xf.a0
    public a0 c(Map<String, Object> map) {
        if (!d()) {
            c0.a(f22067d, "The injected object is not safe, give up injection");
            return this;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (!b(value)) {
                throw new JsInterfaceObjectException("This object has not offer method javascript to call ,please check addJavascriptInterface annotation was be added");
            }
            e(entry.getKey(), value);
        }
        return this;
    }

    public final a0 e(String str, Object obj) {
        c0.c(f22067d, "k:" + str + "  v:" + obj);
        this.f22068b.addJavascriptInterface(obj, str);
        return this;
    }
}
