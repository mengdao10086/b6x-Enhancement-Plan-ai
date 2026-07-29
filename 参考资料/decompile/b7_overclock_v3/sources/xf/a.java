package xf;

import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.just.agentweb.AgentWeb;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements p, p0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f55184c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f55185d = " UCBrowser/11.6.4.950 ";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f55186e = " MQQBrowser/8.0 ";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f55187f = " agentweb/4.0.1 ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebSettings f55188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AgentWeb f55189b;

    public static a h() {
        return new f();
    }

    @Override // xf.p0
    public p0 a(WebView webView, WebChromeClient webChromeClient) {
        webView.setWebChromeClient(webChromeClient);
        return this;
    }

    @Override // xf.p0
    public p0 b(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
        return this;
    }

    @Override // xf.p
    public p c(WebView webView) {
        i(webView);
        return this;
    }

    @Override // xf.p
    public WebSettings d() {
        return this.f55188a;
    }

    @Override // xf.p0
    public p0 e(WebView webView, WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
        return this;
    }

    public final void f(AgentWeb agentWeb) {
        this.f55189b = agentWeb;
        g(agentWeb);
    }

    public abstract void g(AgentWeb agentWeb);

    public final void i(WebView webView) {
        WebSettings settings = webView.getSettings();
        this.f55188a = settings;
        settings.setJavaScriptEnabled(true);
        this.f55188a.setSupportZoom(true);
        this.f55188a.setBuiltInZoomControls(false);
        this.f55188a.setSavePassword(false);
        if (com.just.agentweb.a.a(webView.getContext())) {
            this.f55188a.setCacheMode(-1);
        } else {
            this.f55188a.setCacheMode(1);
        }
        this.f55188a.setMixedContentMode(0);
        webView.setLayerType(2, null);
        this.f55188a.setTextZoom(100);
        this.f55188a.setDatabaseEnabled(true);
        this.f55188a.setAppCacheEnabled(true);
        this.f55188a.setLoadsImagesAutomatically(true);
        this.f55188a.setSupportMultipleWindows(false);
        this.f55188a.setBlockNetworkImage(false);
        this.f55188a.setAllowFileAccess(true);
        this.f55188a.setAllowFileAccessFromFileURLs(false);
        this.f55188a.setAllowUniversalAccessFromFileURLs(false);
        this.f55188a.setJavaScriptCanOpenWindowsAutomatically(true);
        this.f55188a.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.f55188a.setLoadWithOverviewMode(false);
        this.f55188a.setUseWideViewPort(false);
        this.f55188a.setDomStorageEnabled(true);
        this.f55188a.setNeedInitialFocus(true);
        this.f55188a.setDefaultTextEncodingName("utf-8");
        this.f55188a.setDefaultFontSize(16);
        this.f55188a.setMinimumFontSize(12);
        this.f55188a.setGeolocationEnabled(true);
        String strE = c.e(webView.getContext());
        String str = f55184c;
        c0.c(str, "dir:" + strE + "   appcache:" + c.e(webView.getContext()));
        this.f55188a.setGeolocationDatabasePath(strE);
        this.f55188a.setDatabasePath(strE);
        this.f55188a.setAppCachePath(strE);
        this.f55188a.setAppCacheMaxSize(Long.MAX_VALUE);
        this.f55188a.setUserAgentString(d().getUserAgentString().concat(" agentweb/4.0.1 ").concat(f55186e));
        c0.c(str, "UserAgentString : " + this.f55188a.getUserAgentString());
    }
}
