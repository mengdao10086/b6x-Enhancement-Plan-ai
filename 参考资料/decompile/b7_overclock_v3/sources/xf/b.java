package xf;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f55190f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f55191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.just.agentweb.i f55192b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f55194d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f55193c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f55195e = getClass().getSimpleName();

    static {
        try {
            Class.forName("com.google.android.material.snackbar.Snackbar");
            Class.forName("com.google.android.material.bottomsheet.a");
            f55190f = true;
        } catch (Throwable unused) {
            f55190f = false;
        }
    }

    public abstract void a(com.just.agentweb.i iVar, Activity activity);

    public final synchronized void b(com.just.agentweb.i iVar, Activity activity) {
        if (!this.f55193c) {
            this.f55193c = true;
            this.f55192b = iVar;
            this.f55191a = activity;
            a(iVar, activity);
        }
    }

    public b c() {
        return f55190f ? new com.just.agentweb.c() : new com.just.agentweb.d();
    }

    public b d() {
        b bVar = this.f55194d;
        if (bVar != null) {
            return bVar;
        }
        b bVarC = c();
        this.f55194d = bVarC;
        return bVarC;
    }

    public abstract void e();

    public abstract void f(String str, Handler.Callback callback);

    public abstract void g(WebView webView, String str, String str2);

    public abstract void h(WebView webView, String str, String str2, JsResult jsResult);

    public abstract void i(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

    public abstract void j(String str);

    public abstract void k(WebView webView, int i10, String str, String str2);

    public abstract void l(WebView webView, String str, Handler.Callback callback);

    public abstract void m(String[] strArr, String str, String str2);

    public abstract void n(WebView webView, String str, String[] strArr, Handler.Callback callback);

    public abstract void o();

    public abstract void p(String str, String str2);

    public void q(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }

    public void r(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }
}
