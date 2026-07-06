package com.omarea.vtools.activities;

import a.a71;
import a.b60;
import a.b71;
import a.bc2;
import a.cg0;
import a.d0;
import a.eg0;
import a.f92;
import a.g91;
import a.ic0;
import a.n92;
import a.p80;
import a.sc0;
import a.t61;
import a.u61;
import a.u90;
import a.w61;
import a.x61;
import a.y61;
import a.z61;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActionPageOnline extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eg0 f5080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u90 f5081a = new u90(this, null, 2, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8460a = 65400;

    public static final class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            p80.b bVarD = p80.f2403a.d(new AlertDialog.Builder(ActionPageOnline.this).setMessage(str2).setPositiveButton(2131886519, w61.f7761a).setOnDismissListener(new x61(jsResult)).create());
            if (bVarD == null) {
                return true;
            }
            bVarD.i(false);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            p80.b bVarD = p80.f2403a.d(new AlertDialog.Builder(ActionPageOnline.this).setMessage(str2).setPositiveButton(2131886519, new y61(jsResult)).setNeutralButton(2131886518, new z61(jsResult)).create());
            if (bVarD == null) {
                return true;
            }
            bVarD.i(false);
            return true;
        }
    }

    public static final class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ActionPageOnline.this.f5081a.c();
            if (webView != null) {
                ActionPageOnline.this.setTitle(webView.getTitle());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            u90 u90Var = ActionPageOnline.this.f5081a;
            String string = ActionPageOnline.this.getString(u61.please_wait);
            f92.c(string, "getString(R.string.please_wait)");
            u90Var.d(string);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String scheme;
            if (webResourceRequest != null) {
                try {
                    url = webResourceRequest.getUrl();
                } catch (Exception unused) {
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
            } else {
                url = null;
            }
            if (url == null || ((scheme = url.getScheme()) != null && bc2.x(scheme, "http", false, 2, null))) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            ActionPageOnline.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url.toString())));
            return true;
        }
    }

    public static final class c implements cg0 {
        public c() {
        }

        @Override // a.cg0
        public boolean openFileChooser(eg0 eg0Var) {
            f92.d(eg0Var, "fileSelectedInterface");
            return ActionPageOnline.this.m(eg0Var);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionPageOnline.this.finish();
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object systemService = ActionPageOnline.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            TextView textView = (TextView) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_name);
            f92.c(textView, "kr_download_name");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", textView.getText().toString()));
            ActionPageOnline actionPageOnline = ActionPageOnline.this;
            Toast.makeText(actionPageOnline, actionPageOnline.getString(u61.copy_success), 0).show();
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object systemService = ActionPageOnline.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            TextView textView = (TextView) ActionPageOnline.this._$_findCachedViewById(t61.kr_download_url);
            f92.c(textView, "kr_download_url");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", textView.getText().toString()));
            ActionPageOnline actionPageOnline = ActionPageOnline.this;
            Toast.makeText(actionPageOnline, actionPageOnline.getString(u61.copy_success), 0).show();
        }
    }

    public static final class g extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8467a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ sc0 f5084a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DownloadManager.Query f5085a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DownloadManager f5086a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Handler f5087a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5089a;
        public final /* synthetic */ boolean b;

        public g(DownloadManager downloadManager, DownloadManager.Query query, Handler handler, sc0 sc0Var, String str, long j, boolean z) {
            this.f5086a = downloadManager;
            this.f5085a = query;
            this.f5087a = handler;
            this.f5084a = sc0Var;
            this.f5089a = str;
            this.f8467a = j;
            this.b = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.CharSequence, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws Throwable {
            Cursor cursorQuery = this.f5086a.query(this.f5085a);
            n92 n92Var = new n92();
            n92Var.f6891a = "";
            n92 n92Var2 = new n92();
            n92Var2.f6891a = "";
            if (cursorQuery.moveToFirst()) {
                int i = (int) ((cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("bytes_so_far")) * ((long) 100)) / cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("total_size")));
                boolean z = true;
                if (((String) n92Var.f6891a).length() == 0) {
                    try {
                        ?? string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
                        f92.c(string, "cursor.getString(nameColumn)");
                        n92Var.f6891a = string;
                        ?? F = new b60().f(ActionPageOnline.this, Uri.parse((String) n92Var.f6891a));
                        f92.c(F, "FilePathResolver().getPa…ine, Uri.parse(fileName))");
                        n92Var2.f6891a = F;
                        if (F.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            n92Var.f6891a = (String) n92Var2.f6891a;
                        }
                    } catch (Exception unused) {
                    }
                }
                this.f5087a.post(new a71(this, n92Var, i));
                if (i >= 100) {
                    this.f5084a.d(this.f8467a, (String) n92Var2.f6891a);
                    this.f5087a.post(new b71(this, n92Var2));
                }
            }
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5082a == null) {
            this.f5082a = new HashMap();
        }
        View view = (View) this.f5082a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5082a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean m(eg0 eg0Var) {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            Toast.makeText(this, getString(u61.kr_write_external_storage), 1).show();
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent, this.f8460a);
            this.f5080a = eg0Var;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String n(Uri uri) {
        try {
            return new b60().f(this, uri);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void o(String str) {
        WebView webView = (WebView) _$_findCachedViewById(t61.kr_online_webview);
        f92.c(webView, "kr_online_webview");
        webView.setVisibility(0);
        WebView webView2 = (WebView) _$_findCachedViewById(t61.kr_online_webview);
        f92.c(webView2, "kr_online_webview");
        webView2.setWebChromeClient(new a());
        WebView webView3 = (WebView) _$_findCachedViewById(t61.kr_online_webview);
        f92.c(webView3, "kr_online_webview");
        webView3.setWebViewClient(new b());
        ((WebView) _$_findCachedViewById(t61.kr_online_webview)).loadUrl(str);
        new ic0((WebView) _$_findCachedViewById(t61.kr_online_webview), new c()).d(this, bc2.x(str, "file:///android_asset", false, 2, null));
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.f8460a) {
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            eg0 eg0Var = this.f5080a;
            if (eg0Var != null) {
                if (data != null) {
                    String strN = n(data);
                    eg0 eg0Var2 = this.f5080a;
                    if (eg0Var2 != null) {
                        eg0Var2.d(strN);
                    }
                } else if (eg0Var != null) {
                    eg0Var.d(null);
                }
            }
            this.f5080a = null;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558429);
        View viewFindViewById = findViewById(t61.toolbar);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        Toolbar toolbar = (Toolbar) viewFindViewById;
        setSupportActionBar(toolbar);
        setTitle(u61.app_name);
        d0 supportActionBar = getSupportActionBar();
        f92.b(supportActionBar);
        supportActionBar.t(true);
        d0 supportActionBar2 = getSupportActionBar();
        f92.b(supportActionBar2);
        supportActionBar2.s(true);
        toolbar.setNavigationOnClickListener(new d());
        p();
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        r();
        super.onDestroy();
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !((WebView) _$_findCachedViewById(t61.kr_online_webview)).canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        ((WebView) _$_findCachedViewById(t61.kr_online_webview)).goBack();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActionPageOnline.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            r3 = this;
            android.view.Window r0 = r3.getWindow()
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.clearFlags(r1)
            java.lang.String r1 = "window"
            a.f92.c(r0, r1)
            android.view.View r1 = r0.getDecorView()
            java.lang.String r2 = "window.decorView"
            a.f92.c(r1, r2)
            r2 = 1280(0x500, float:1.794E-42)
            r1.setSystemUiVisibility(r2)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0.addFlags(r1)
            a.x90 r1 = r3.getThemeMode()
            boolean r1 = r1.a()
            if (r1 != 0) goto L42
            r1 = -1
            r0.setStatusBarColor(r1)
            r0.setNavigationBarColor(r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L3b
            r0 = 9232(0x2410, float:1.2937E-41)
            goto L44
        L3b:
            r1 = 23
            if (r0 < r1) goto L42
            r0 = 9216(0x2400, float:1.2914E-41)
            goto L44
        L42:
            r0 = 1024(0x400, float:1.435E-42)
        L44:
            android.view.Window r1 = r3.getWindow()
            java.lang.String r2 = "getWindow()"
            a.f92.c(r1, r2)
            android.view.View r1 = r1.getDecorView()
            java.lang.String r2 = "getWindow().decorView"
            a.f92.c(r1, r2)
            r1.setSystemUiVisibility(r0)
            int r0 = a.t61.kr_online_root
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            java.lang.String r1 = "kr_online_root"
            a.f92.c(r0, r1)
            r1 = 1
            r0.setFitsSystemWindows(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActionPageOnline.q():void");
    }

    public final void r() {
        Timer timer = this.f5083a;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            this.f5083a = null;
        }
    }

    public final void s(long j, boolean z, String str) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.kr_download_state);
        f92.c(linearLayout, "kr_download_state");
        linearLayout.setVisibility(0);
        Object systemService = getSystemService("download");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
        }
        DownloadManager.Query filterById = new DownloadManager.Query().setFilterById(j);
        ((ImageButton) _$_findCachedViewById(t61.kr_download_name_copy)).setOnClickListener(new e());
        ((ImageButton) _$_findCachedViewById(t61.kr_download_url_copy)).setOnClickListener(new f());
        Handler handler = new Handler(Looper.getMainLooper());
        sc0 sc0Var = new sc0(this, null, 2, null);
        Timer timer = new Timer("ProgressPolling");
        this.f5083a = timer;
        timer.schedule(new g((DownloadManager) systemService, filterById, handler, sc0Var, str, j, z), 200L, 500L);
    }
}
