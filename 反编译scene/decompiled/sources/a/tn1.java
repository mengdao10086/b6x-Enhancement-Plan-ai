package a;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tn1 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f7516a;

    public tn1(jo1 jo1Var, String str) {
        this.f7516a = jo1Var;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string;
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (string = url.toString()) == null) {
            string = "";
        }
        f92.c(string, "request?.url?.toString()?:\"\"");
        if (!bc2.x(string, "https://www.paypal.", false, 2, null) && !bc2.x(string, "mailto:", false, 2, null)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        this.f7516a.l(string);
        return true;
    }
}
