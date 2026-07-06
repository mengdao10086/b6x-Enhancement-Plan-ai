package a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ic0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cg0 f6397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WebView f1352a;

    @SuppressLint({"SetJavaScriptEnabled"})
    public ic0(WebView webView, cg0 cg0Var) {
        this.f1352a = webView;
        this.f1351a = webView.getContext();
        this.f6397a = cg0Var;
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    public void d(Activity activity, boolean z) {
        WebView webView = this.f1352a;
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(z);
            settings.setAllowUniversalAccessFromFileURLs(z);
            settings.setAllowFileAccessFromFileURLs(z);
            settings.setAllowContentAccess(true);
            settings.setUseWideViewPort(true);
            this.f1352a.addJavascriptInterface(new hc0(this, this.f1351a, null), "KrScriptCore");
            this.f1352a.setDownloadListener(new tb0(this, activity));
        }
    }
}
