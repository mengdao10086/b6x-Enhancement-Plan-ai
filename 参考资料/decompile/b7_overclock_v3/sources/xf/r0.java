package xf;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes7.dex */
public class r0 extends WebViewClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f55294b = r0.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewClient f55295a;

    public r0(WebViewClient webViewClient) {
        this.f55295a = webViewClient;
    }

    public WebViewClient a() {
        return this.f55295a;
    }

    public void b(WebViewClient webViewClient) {
        this.f55295a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z10) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z10);
        } else {
            super.doUpdateVisitedHistory(webView, str, z10);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        } else {
            super.onPageCommitVisible(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        } else {
            super.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i10, str, str2);
        } else {
            super.onReceivedError(webView, i10, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f10, float f11) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f10, f11);
        } else {
            super.onScaleChanged(webView, f10, f11);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClient webViewClient = this.f55295a;
        return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f55295a;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.f55295a;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f55295a;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
