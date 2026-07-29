package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.bumptech.glide.load.engine.GlideException;
import com.just.agentweb.ActionActivity;
import com.umeng.socialize.common.SocializeConstants;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import xf.c0;
import xf.d0;
import xf.g0;
import xf.s;
import xf.v;

/* JADX INFO: loaded from: classes7.dex */
public class b extends d0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f21854p = "android.webkit.WebChromeClient";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21855q = 24;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f21856r = 96;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f21857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebChromeClient f21859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f21861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g0 f21862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WebView f21863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f21864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GeolocationPermissions.Callback f21865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference<xf.b> f21866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v f21867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f21868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionActivity.b f21869o;

    public class a implements ActionActivity.b {
        public a() {
        }

        @Override // com.just.agentweb.ActionActivity.b
        public void a(@n0 String[] strArr, @n0 int[] iArr, Bundle bundle) {
            if (bundle.getInt(ActionActivity.f21733e) == 96) {
                boolean zH = com.just.agentweb.a.H((Context) b.this.f21857c.get(), strArr);
                if (b.this.f21865k != null) {
                    if (zH) {
                        b.this.f21865k.invoke(b.this.f21864j, true, false);
                    } else {
                        b.this.f21865k.invoke(b.this.f21864j, false, false);
                    }
                    b.this.f21865k = null;
                    b.this.f21864j = null;
                }
                if (zH || b.this.f21866l.get() == null) {
                    return;
                }
                ((xf.b) b.this.f21866l.get()).m(xf.e.f55217b, "Location", "Location");
            }
        }
    }

    public b(Activity activity, v vVar, WebChromeClient webChromeClient, @p0 s sVar, g0 g0Var, WebView webView) {
        super(webChromeClient);
        this.f21857c = null;
        this.f21858d = b.class.getSimpleName();
        this.f21860f = false;
        this.f21864j = null;
        this.f21865k = null;
        this.f21866l = null;
        this.f21869o = new a();
        this.f21867m = vVar;
        this.f21860f = webChromeClient != null;
        this.f21859e = webChromeClient;
        this.f21857c = new WeakReference<>(activity);
        this.f21861g = sVar;
        this.f21862h = g0Var;
        this.f21863i = webView;
        this.f21866l = new WeakReference<>(com.just.agentweb.a.p(webView));
    }

    @Override // xf.l0
    public void c(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f21859e;
        Class cls = Long.TYPE;
        if (com.just.agentweb.a.Q(webChromeClient, "onReachedMaxAppCacheSize", "android.webkit.WebChromeClient.onReachedMaxAppCacheSize", cls, cls, WebStorage.QuotaUpdater.class)) {
            super.c(j10, j11, quotaUpdater);
        } else {
            quotaUpdater.updateQuota(j10 * 2);
        }
    }

    @Override // xf.l0
    public void d(ValueCallback<Uri> valueCallback) {
        if (com.just.agentweb.a.Q(this.f21859e, "openFileChooser", "android.webkit.WebChromeClient.openFileChooser", ValueCallback.class)) {
            super.d(valueCallback);
        } else {
            p(valueCallback, "*/*");
        }
    }

    @Override // xf.l0
    public void e(ValueCallback valueCallback, String str) {
        if (com.just.agentweb.a.Q(this.f21859e, "openFileChooser", "android.webkit.WebChromeClient.openFileChooser", ValueCallback.class, String.class)) {
            super.e(valueCallback, str);
        } else {
            p(valueCallback, str);
        }
    }

    @Override // xf.l0
    public void f(ValueCallback<Uri> valueCallback, String str, String str2) {
        c0.c(this.f21858d, "openFileChooser>=4.1");
        if (com.just.agentweb.a.Q(this.f21859e, "openFileChooser", "android.webkit.WebChromeClient.openFileChooser", ValueCallback.class, String.class, String.class)) {
            super.f(valueCallback, str, str2);
        } else {
            p(valueCallback, str);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        return true;
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f21859e;
        Class cls = Long.TYPE;
        if (com.just.agentweb.a.Q(webChromeClient, "onExceededDatabaseQuota", "android.webkit.WebChromeClient.onExceededDatabaseQuota", String.class, String.class, cls, cls, cls, WebStorage.QuotaUpdater.class)) {
            super.onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        } else {
            quotaUpdater.updateQuota(j12 * 2);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (com.just.agentweb.a.Q(this.f21859e, "onGeolocationPermissionsShowPrompt", "public void android.webkit.WebChromeClient.onGeolocationPermissionsShowPrompt", String.class, GeolocationPermissions.Callback.class)) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            q(str, callback);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (com.just.agentweb.a.Q(this.f21859e, "onHideCustomView", "android.webkit.WebChromeClient.onHideCustomView", new Class[0])) {
            super.onHideCustomView();
            return;
        }
        s sVar = this.f21861g;
        if (sVar != null) {
            sVar.d();
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (com.just.agentweb.a.Q(this.f21859e, "onJsAlert", "public boolean android.webkit.WebChromeClient.onJsAlert", WebView.class, String.class, String.class, JsResult.class)) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        if (this.f21866l.get() != null) {
            this.f21866l.get().g(webView, str, str2);
        }
        jsResult.confirm();
        return true;
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (com.just.agentweb.a.Q(this.f21859e, "onJsConfirm", "public boolean android.webkit.WebChromeClient.onJsConfirm", WebView.class, String.class, String.class, JsResult.class)) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        if (this.f21866l.get() != null) {
            this.f21866l.get().h(webView, str, str2, jsResult);
        }
        return true;
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
        } catch (Exception e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
        }
        if (com.just.agentweb.a.Q(this.f21859e, "onJsPrompt", "public boolean android.webkit.WebChromeClient.onJsPrompt", WebView.class, String.class, String.class, String.class, JsPromptResult.class)) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        if (this.f21866l.get() != null) {
            this.f21866l.get().i(this.f21863i, str, str2, str3, jsPromptResult);
        }
        return true;
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        v vVar = this.f21867m;
        if (vVar != null) {
            vVar.b(webView, i10);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.f21860f) {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (com.just.agentweb.a.Q(this.f21859e, "onShowCustomView", "android.webkit.WebChromeClient.onShowCustomView", View.class, WebChromeClient.CustomViewCallback.class)) {
            super.onShowCustomView(view, customViewCallback);
            return;
        }
        s sVar = this.f21861g;
        if (sVar != null) {
            sVar.a(view, customViewCallback);
        }
    }

    @Override // xf.l0, android.webkit.WebChromeClient
    @v0(api = 21)
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        c0.c(this.f21858d, "openFileChooser>=5.0");
        return com.just.agentweb.a.Q(this.f21859e, "onShowFileChooser", "android.webkit.WebChromeClient.onShowFileChooser", WebView.class, ValueCallback.class, WebChromeClient.FileChooserParams.class) ? super.onShowFileChooser(webView, valueCallback, fileChooserParams) : r(webView, valueCallback, fileChooserParams);
    }

    public final void p(ValueCallback valueCallback, String str) {
        Activity activity = this.f21857c.get();
        if (activity == null || activity.isFinishing()) {
            valueCallback.onReceiveValue(new Object());
        } else {
            com.just.agentweb.a.X(activity, this.f21863i, null, null, this.f21862h, valueCallback, str, null);
        }
    }

    public final void q(String str, GeolocationPermissions.Callback callback) {
        g0 g0Var = this.f21862h;
        if (g0Var != null && g0Var.a(this.f21863i.getUrl(), xf.e.f55217b, SocializeConstants.KEY_LOCATION)) {
            callback.invoke(str, false, false);
            return;
        }
        Activity activity = this.f21857c.get();
        if (activity == null) {
            callback.invoke(str, false, false);
            return;
        }
        List<String> listU = com.just.agentweb.a.u(activity, xf.e.f55217b);
        if (listU.isEmpty()) {
            c0.c(this.f21858d, "onGeolocationPermissionsShowPromptInternal:true");
            callback.invoke(str, true, false);
            return;
        }
        Action actionA = Action.a((String[]) listU.toArray(new String[0]));
        actionA.s(96);
        ActionActivity.h(this.f21869o);
        this.f21865k = callback;
        this.f21864j = str;
        ActionActivity.i(activity, actionA);
    }

    public final boolean r(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        c0.c(this.f21858d, "fileChooserParams:" + fileChooserParams.getAcceptTypes() + "  getTitle:" + ((Object) fileChooserParams.getTitle()) + " accept:" + Arrays.toString(fileChooserParams.getAcceptTypes()) + " length:" + fileChooserParams.getAcceptTypes().length + "  :" + fileChooserParams.isCaptureEnabled() + GlideException.a.f12263d + fileChooserParams.getFilenameHint() + "  intent:" + fileChooserParams.createIntent().toString() + "   mode:" + fileChooserParams.getMode());
        Activity activity = this.f21857c.get();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return com.just.agentweb.a.X(activity, this.f21863i, valueCallback, fileChooserParams, this.f21862h, null, null, null);
    }
}
