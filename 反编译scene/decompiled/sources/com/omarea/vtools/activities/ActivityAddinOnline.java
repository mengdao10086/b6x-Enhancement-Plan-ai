package com.omarea.vtools.activities;

import a.b60;
import a.bc2;
import a.cg0;
import a.eg0;
import a.f92;
import a.g91;
import a.ic0;
import a.o71;
import a.p71;
import a.p80;
import a.q71;
import a.r71;
import a.s71;
import a.t61;
import a.t71;
import a.u61;
import a.u71;
import a.u90;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAddinOnline extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8478a = 65400;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eg0 f5103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5104a;

    public static final class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            p80.b bVarD = p80.f2403a.d(new AlertDialog.Builder(ActivityAddinOnline.this).setMessage(str2).setPositiveButton(2131886519, o71.f6992a).setOnDismissListener(new p71(jsResult)).create());
            if (bVarD == null) {
                return true;
            }
            bVarD.i(false);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            p80.b bVarD = p80.f2403a.d(new AlertDialog.Builder(ActivityAddinOnline.this).setMessage(str2).setPositiveButton(2131886519, new q71(jsResult)).setNeutralButton(2131886518, new r71(jsResult)).create());
            if (bVarD == null) {
                return true;
            }
            bVarD.i(false);
            return true;
        }
    }

    public static final class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u90 f8480a;

        public b(u90 u90Var) {
            this.f8480a = u90Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f8480a.c();
            if (webView != null) {
                ActivityAddinOnline.this.setTitle(webView.getTitle());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            u90 u90Var = this.f8480a;
            String string = ActivityAddinOnline.this.getString(u61.please_wait);
            f92.c(string, "getString(R.string.please_wait)");
            u90Var.d(string);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }
    }

    public static final class c implements cg0 {
        public c() {
        }

        @Override // a.cg0
        public boolean openFileChooser(eg0 eg0Var) {
            f92.d(eg0Var, "fileSelectedInterface");
            return ActivityAddinOnline.this.k(eg0Var);
        }
    }

    public static final class d {
        public final /* synthetic */ ActivityAddinOnline b;

        public d(ActivityAddinOnline activityAddinOnline) {
            this.b = activityAddinOnline;
        }

        @JavascriptInterface
        public final boolean setNavigationBarColor(String str) {
            f92.d(str, "colorStr");
            try {
                ((WebView) ActivityAddinOnline.this._$_findCachedViewById(t61.vtools_online)).post(new s71(this, Color.parseColor(str)));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @JavascriptInterface
        public final boolean setStatusBarColor(String str) {
            f92.d(str, "colorStr");
            try {
                ((WebView) ActivityAddinOnline.this._$_findCachedViewById(t61.vtools_online)).post(new t71(this, Color.parseColor(str)));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @JavascriptInterface
        public final void showToast(String str) {
            f92.d(str, "str");
            try {
                ((WebView) ActivityAddinOnline.this._$_findCachedViewById(t61.vtools_online)).post(new u71(this, str));
            } catch (Exception unused) {
            }
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5104a == null) {
            this.f5104a = new HashMap();
        }
        View view = (View) this.f5104a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5104a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean k(eg0 eg0Var) {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            Toast.makeText(this, getString(u61.kr_write_external_storage), 1).show();
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent, this.f8478a);
            this.f5103a = eg0Var;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String l(Uri uri) {
        try {
            return new b60().f(this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.f8478a) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            eg0 eg0Var = this.f5103a;
            if (eg0Var != null) {
                if (data != null) {
                    String strL = l(data);
                    eg0 eg0Var2 = this.f5103a;
                    if (eg0Var2 != null) {
                        eg0Var2.d(strL);
                    }
                } else if (eg0Var != null) {
                    eg0Var.d(null);
                }
            }
            this.f5103a = null;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        View decorView;
        int i;
        super.onCreate(bundle);
        setContentView(2131558431);
        getWindow().clearFlags(67108864);
        Window window = getWindow();
        f92.c(window, "window");
        View decorView2 = window.getDecorView();
        f92.c(decorView2, "window.decorView");
        decorView2.setSystemUiVisibility(1280);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window window2 = getWindow();
        f92.c(window2, "window");
        window2.setStatusBarColor(-1);
        Window window3 = getWindow();
        f92.c(window3, "window");
        window3.setNavigationBarColor(-1);
        if (Build.VERSION.SDK_INT >= 26) {
            Window window4 = getWindow();
            f92.c(window4, "window");
            decorView = window4.getDecorView();
            f92.c(decorView, "window.decorView");
            i = 9232;
        } else {
            Window window5 = getWindow();
            f92.c(window5, "window");
            decorView = window5.getDecorView();
            f92.c(decorView, "window.decorView");
            i = 9216;
        }
        decorView.setSystemUiVisibility(i);
        Intent intent = getIntent();
        f92.c(intent, "this.intent");
        if (intent.getExtras() != null) {
            Intent intent2 = getIntent();
            f92.c(intent2, "intent");
            Bundle extras = intent2.getExtras();
            if (extras != null && extras.containsKey("url")) {
                WebView webView = (WebView) _$_findCachedViewById(t61.vtools_online);
                String string = extras.getString("url");
                f92.b(string);
                webView.loadUrl(string);
            }
        }
        u90 u90Var = new u90(this, null, 2, null);
        WebView webView2 = (WebView) _$_findCachedViewById(t61.vtools_online);
        f92.c(webView2, "vtools_online");
        webView2.setWebChromeClient(new a());
        ((WebView) _$_findCachedViewById(t61.vtools_online)).setWebViewClient(new b(u90Var));
        WebView webView3 = (WebView) _$_findCachedViewById(t61.vtools_online);
        f92.c(webView3, "vtools_online");
        WebSettings settings = webView3.getSettings();
        f92.c(settings, "vtools_online.settings");
        settings.setJavaScriptEnabled(true);
        WebView webView4 = (WebView) _$_findCachedViewById(t61.vtools_online);
        f92.c(webView4, "vtools_online");
        webView4.getSettings().setLoadWithOverviewMode(true);
        WebView webView5 = (WebView) _$_findCachedViewById(t61.vtools_online);
        f92.c(webView5, "vtools_online");
        webView5.getSettings().setUseWideViewPort(true);
        WebView webView6 = (WebView) _$_findCachedViewById(t61.vtools_online);
        f92.c(webView6, "vtools_online");
        String url = webView6.getUrl();
        if (url != null && (bc2.x(url, "https://vtools.oss-cn-beijing.aliyuncs.com/", false, 2, null) || bc2.x(url, "https://vtools.omarea.com/", false, 2, null))) {
            new ic0((WebView) _$_findCachedViewById(t61.vtools_online), new c()).d(this, false);
        }
        ((WebView) _$_findCachedViewById(t61.vtools_online)).addJavascriptInterface(new d(this), "SceneUI");
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        ((WebView) _$_findCachedViewById(t61.vtools_online)).clearCache(true);
        ((WebView) _$_findCachedViewById(t61.vtools_online)).removeAllViews();
        ((WebView) _$_findCachedViewById(t61.vtools_online)).destroy();
        super.onDestroy();
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !((WebView) _$_findCachedViewById(t61.vtools_online)).canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        ((WebView) _$_findCachedViewById(t61.vtools_online)).goBack();
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }
}
