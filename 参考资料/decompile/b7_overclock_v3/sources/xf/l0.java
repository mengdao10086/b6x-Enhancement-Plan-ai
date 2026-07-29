package xf;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
public class l0 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebChromeClient f55270a;

    public l0(WebChromeClient webChromeClient) {
        this.f55270a = webChromeClient;
    }

    public final void a(WebChromeClient webChromeClient, String str, Object[] objArr, Class... clsArr) {
        if (webChromeClient == null) {
            return;
        }
        try {
            webChromeClient.getClass().getMethod(str, clsArr).invoke(webChromeClient, objArr);
        } catch (Exception e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
        }
    }

    public WebChromeClient b() {
        return this.f55270a;
    }

    @Deprecated
    public void c(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        }
    }

    public void d(ValueCallback<Uri> valueCallback) {
        a(this.f55270a, "openFileChooser", new Object[]{valueCallback}, ValueCallback.class);
    }

    public void e(ValueCallback valueCallback, String str) {
        a(this.f55270a, "openFileChooser", new Object[]{valueCallback, str}, ValueCallback.class, String.class);
    }

    public void f(ValueCallback<Uri> valueCallback, String str, String str2) {
        a(this.f55270a, "openFileChooser", new Object[]{valueCallback, str, str2}, ValueCallback.class, String.class, String.class);
    }

    public void g(WebChromeClient webChromeClient) {
        this.f55270a = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i10, String str2) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(str, i10, str2);
        } else {
            super.onConsoleMessage(str, i10, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z10, z11, message) : super.onCreateWindow(webView, z10, z11, message);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @v0(api = 21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequest(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    @v0(api = 21)
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i10);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z10) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z10);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z10);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    @v0(api = 21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WebChromeClient webChromeClient = this.f55270a;
        return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.f55270a;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i10, customViewCallback);
        } else {
            super.onShowCustomView(view, i10, customViewCallback);
        }
    }
}
