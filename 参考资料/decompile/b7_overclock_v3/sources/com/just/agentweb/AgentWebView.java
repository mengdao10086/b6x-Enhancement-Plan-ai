package com.just.agentweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JsPromptResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import xf.c0;
import xf.d0;
import xf.e0;
import xf.z;

/* JADX INFO: loaded from: classes7.dex */
public class AgentWebView extends WebView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21799f = AgentWebView.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, z> f21800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f21801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f21802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f21804e;

    public static class b extends d0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AgentWebView f21805c;

        @Override // xf.l0, android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            z zVar;
            String unused = AgentWebView.f21799f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onJsPrompt:");
            sb2.append(str);
            sb2.append("  message:");
            sb2.append(str2);
            sb2.append("  d:");
            sb2.append(str3);
            sb2.append(GlideException.a.f12263d);
            if (this.f21805c.f21800a == null || !z.g(str2)) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            JSONObject jSONObjectD = z.d(str2);
            String strC = z.c(jSONObjectD);
            if (strC == null || (zVar = (z) this.f21805c.f21800a.get(strC)) == null) {
                return true;
            }
            jsPromptResult.confirm(zVar.a(webView, jSONObjectD));
            return true;
        }

        @Override // xf.l0, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (this.f21805c.f21800a != null) {
                this.f21805c.u();
                if (c0.d()) {
                    String unused = AgentWebView.f21799f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("injectJavaScript, onProgressChanged.newProgress = ");
                    sb2.append(i10);
                    sb2.append(", url = ");
                    sb2.append(webView.getUrl());
                }
            }
            if (this.f21805c.f21801b != null) {
                this.f21805c.t();
            }
            super.onProgressChanged(webView, i10);
        }

        @Override // xf.l0, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            this.f21805c.f21802c.c();
            super.onReceivedTitle(webView, str);
        }

        public b(AgentWebView agentWebView) {
            this.f21805c = agentWebView;
        }
    }

    public static class c extends e0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AgentWebView f21806e;

        @Override // xf.r0, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f21806e.f21802c.a(webView);
            if (c0.d()) {
                String unused = AgentWebView.f21799f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onPageFinished.url = ");
                sb2.append(webView.getUrl());
            }
        }

        @Override // xf.r0, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f21806e.f21800a != null) {
                this.f21806e.u();
                if (c0.d()) {
                    String unused = AgentWebView.f21799f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("injectJavaScript, onPageStarted.url = ");
                    sb2.append(webView.getUrl());
                }
            }
            if (this.f21806e.f21801b != null) {
                this.f21806e.t();
            }
            this.f21806e.f21802c.b();
            this.f21806e.r(str);
        }

        public c(AgentWebView agentWebView) {
            this.f21806e = agentWebView;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WebChromeClient f21807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21808b;

        public d() {
        }

        public void a(WebView webView) {
            if (this.f21808b || this.f21807a == null) {
                return;
            }
            WebBackForwardList webBackForwardListCopyBackForwardList = null;
            try {
                webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            } catch (NullPointerException e10) {
                if (c0.d()) {
                    e10.printStackTrace();
                }
            }
            if (webBackForwardListCopyBackForwardList == null || webBackForwardListCopyBackForwardList.getSize() <= 0 || webBackForwardListCopyBackForwardList.getCurrentIndex() < 0 || webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()) == null) {
                return;
            }
            this.f21807a.onReceivedTitle(webView, webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getTitle());
        }

        public void b() {
            this.f21808b = false;
        }

        public void c() {
            this.f21808b = true;
        }

        public void d(WebChromeClient webChromeClient) {
            this.f21807a = webChromeClient;
        }
    }

    public AgentWebView(Context context) {
        this(context, null);
    }

    private void setAccessibilityEnabled(boolean z10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setAccessibilityState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(accessibilityManager, Boolean.valueOf(z10));
            declaredMethod.setAccessible(false);
        } catch (Throwable th2) {
            if (c0.d()) {
                c0.b(f21799f, "setAccessibilityEnabled", th2);
            }
        }
    }

    private boolean v() {
        return ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
    }

    public static Pair<Boolean, String> w(Throwable th2) {
        String string = th2.getCause() == null ? th2.toString() : th2.getCause().toString();
        String stackTraceString = Log.getStackTraceString(th2);
        if (!stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") && !stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") && !stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
            return new Pair<>(Boolean.FALSE, string);
        }
        c0.e(f21799f, "isWebViewPackageException", th2);
        return new Pair<>(Boolean.TRUE, "WebView load failed, " + string);
    }

    @TargetApi(19)
    public void A() {
        if (c0.d()) {
            try {
                WebView.class.getMethod("setWebContentsDebuggingEnabled", Boolean.TYPE).invoke(null, Boolean.TRUE);
            } catch (Throwable th2) {
                if (c0.d()) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.webkit.WebView
    @Deprecated
    public final void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        if (this.f21803d) {
            super.clearHistory();
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        setVisibility(8);
        Map<String, z> map = this.f21800a;
        if (map != null) {
            map.clear();
        }
        Map<String, String> map2 = this.f21801b;
        if (map2 != null) {
            map2.clear();
        }
        removeAllViewsInLayout();
        s();
        x();
        if (this.f21803d) {
            z();
            c0.c(f21799f, "destroy web");
            super.destroy();
        }
    }

    @Override // android.webkit.WebView
    public boolean isPrivateBrowsingEnabled() {
        return super.isPrivateBrowsingEnabled();
    }

    public void m(String str) {
        if (this.f21801b == null) {
            this.f21801b = new HashMap();
        }
        this.f21801b.put(String.valueOf(str.hashCode()), str);
        t();
    }

    public void n(Object obj, String str) {
    }

    public String o(String str, String str2) {
        String str3 = String.format("__injectFlag_%1$s__", str);
        return "javascript:try{(function(){if(window." + str3 + "){console.log('" + str3 + " has been injected');return;}window." + str3 + "=true;" + str2 + "}())}catch(e){console.warn(e)}";
    }

    public String p(String str) {
        return "javascript:try{" + str + "}catch(e){console.warn(e)}";
    }

    public void q() {
    }

    public void r(String str) {
    }

    public final void s() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeAllViewsInLayout();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i10) {
        try {
            super.setOverScrollMode(i10);
        } catch (Throwable th2) {
            Pair<Boolean, String> pairW = w(th2);
            if (!((Boolean) pairW.first).booleanValue()) {
                throw th2;
            }
            Toast.makeText(getContext(), (CharSequence) pairW.second, 0).show();
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        b bVar = new b();
        bVar.g(webChromeClient);
        this.f21802c.d(webChromeClient);
        super.setWebChromeClient(bVar);
        setWebChromeClientSupport(bVar);
    }

    public final void setWebChromeClientSupport(WebChromeClient webChromeClient) {
    }

    @Override // android.webkit.WebView
    public final void setWebViewClient(WebViewClient webViewClient) {
        c cVar = new c();
        cVar.b(webViewClient);
        super.setWebViewClient(cVar);
        setWebViewClientSupport(cVar);
    }

    public final void setWebViewClientSupport(WebViewClient webViewClient) {
    }

    public final void t() {
        for (Map.Entry<String, String> entry : this.f21801b.entrySet()) {
            loadUrl(o(entry.getKey(), entry.getValue()));
        }
    }

    public final void u() {
        for (Map.Entry<String, z> entry : this.f21800a.entrySet()) {
            loadUrl(o(entry.getKey(), entry.getValue().e()));
        }
    }

    public final void x() {
    }

    @TargetApi(11)
    public boolean y() {
        return false;
    }

    public final void z() {
        Boolean bool = this.f21804e;
        if (bool != null) {
            setAccessibilityEnabled(bool.booleanValue());
        }
    }

    public AgentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y();
        this.f21803d = true;
        this.f21802c = new d();
    }
}
