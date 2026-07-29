package xf;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public class l implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f55269a;

    public l(WebView webView) {
        this.f55269a = webView;
    }

    @Override // xf.o0
    public void a() {
        WebView webView = this.f55269a;
        if (webView != null) {
            webView.resumeTimers();
        }
        com.just.agentweb.a.g(this.f55269a);
    }

    @Override // xf.o0
    public void b() {
        WebView webView = this.f55269a;
        if (webView != null) {
            webView.onPause();
            this.f55269a.pauseTimers();
        }
    }

    @Override // xf.o0
    public void d() {
        WebView webView = this.f55269a;
        if (webView != null) {
            webView.onResume();
            this.f55269a.resumeTimers();
        }
    }
}
