package com.just.agentweb;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import xf.c0;
import xf.e0;
import xf.g0;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultWebClient extends e0 {
    public static final int A = 250;
    public static final int B = 62;
    public static final String C = "sms:";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21809q = 7;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f21810r = "android.webkit.WebViewClient";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f21811s = "intent://";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f21812t = "weixin://wap/pay?";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f21813u = "alipays://";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f21814v = "http://";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f21815w = "https://";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f21816x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f21817y = DefaultWebClient.class.getSimpleName();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f21818z = 1001;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<Activity> f21819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WebViewClient f21820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<xf.b> f21824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebView f21825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Handler.Callback f21826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Method f21827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f21828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Set<String> f21829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Set<String> f21830p;

    public enum OpenOtherPageWays {
        DERECT(1001),
        ASK(250),
        DISALLOW(62);

        public int code;

        OpenOtherPageWays(int i10) {
            this.code = i10;
        }
    }

    public class a implements H5PayCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f21831a;

        /* JADX INFO: renamed from: com.just.agentweb.DefaultWebClient$a$a, reason: collision with other inner class name */
        public class RunnableC0234a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21833a;

            public RunnableC0234a(String str) {
                this.f21833a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f21831a.loadUrl(this.f21833a);
            }
        }

        public a(WebView webView) {
            this.f21831a = webView;
        }

        public void a(H5PayResultModel h5PayResultModel) {
            String returnUrl = h5PayResultModel.getReturnUrl();
            if (TextUtils.isEmpty(returnUrl)) {
                return;
            }
            com.just.agentweb.a.T(new RunnableC0234a(returnUrl));
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21835a;

        public b(String str) {
            this.f21835a = str;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return true;
            }
            DefaultWebClient.this.k(this.f21835a);
            return true;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f21837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WebViewClient f21838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g0 f21840d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WebView f21841e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f21842f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f21843g;

        public DefaultWebClient g() {
            return new DefaultWebClient(this);
        }

        public c h(Activity activity) {
            this.f21837a = activity;
            return this;
        }

        public c i(WebViewClient webViewClient) {
            this.f21838b = webViewClient;
            return this;
        }

        public c j(boolean z10) {
            this.f21842f = z10;
            return this;
        }

        public c k(g0 g0Var) {
            this.f21840d = g0Var;
            return this;
        }

        public c l(int i10) {
            this.f21843g = i10;
            return this;
        }

        public c m(boolean z10) {
            this.f21839c = z10;
            return this;
        }

        public c n(WebView webView) {
            this.f21841e = webView;
            return this;
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("com.alipay.sdk.app.PayTask");
            z10 = true;
        } catch (Throwable unused) {
            z10 = false;
        }
        f21816x = z10;
        c0.c(f21817y, "HAS_ALIPAY_LIB:" + z10);
    }

    public DefaultWebClient(c cVar) {
        super(cVar.f21838b);
        this.f21819e = null;
        this.f21821g = true;
        this.f21822h = 250;
        this.f21823i = true;
        this.f21824j = null;
        this.f21826l = null;
        this.f21827m = null;
        this.f21829o = new HashSet();
        this.f21830p = new HashSet();
        this.f21825k = cVar.f21841e;
        this.f21820f = cVar.f21838b;
        this.f21819e = new WeakReference<>(cVar.f21837a);
        this.f21821g = cVar.f21839c;
        this.f21824j = new WeakReference<>(com.just.agentweb.a.p(cVar.f21841e));
        this.f21823i = cVar.f21842f;
        if (cVar.f21843g <= 0) {
            this.f21822h = 250;
        } else {
            this.f21822h = cVar.f21843g;
        }
    }

    public static c f() {
        return new c();
    }

    public final Handler.Callback g(String str) {
        Handler.Callback callback = this.f21826l;
        if (callback != null) {
            return callback;
        }
        b bVar = new b(str);
        this.f21826l = bVar;
        return bVar;
    }

    public final boolean h(String str) {
        if (!str.startsWith("tel:") && !str.startsWith(C) && !str.startsWith(u0.c.f51788b) && !str.startsWith("geo:0,0?q=")) {
            return false;
        }
        try {
            Activity activity = this.f21819e.get();
            if (activity == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e10) {
            if (!xf.c.f55199d) {
                return true;
            }
            e10.printStackTrace();
            return true;
        }
    }

    public final void i(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(f21811s)) {
                k(str);
            }
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public final boolean j(WebView webView, String str) {
        try {
            Activity activity = this.f21819e.get();
            if (activity == null) {
                return false;
            }
            if (this.f21828n == null) {
                this.f21828n = Class.forName("com.alipay.sdk.app.PayTask").getConstructor(Activity.class).newInstance(activity);
            }
            boolean zPayInterceptorWithUrl = ((PayTask) this.f21828n).payInterceptorWithUrl(str, true, new a(webView));
            if (zPayInterceptorWithUrl) {
                c0.c(f21817y, "alipay-isIntercepted:" + zPayInterceptorWithUrl + "  url:" + str);
            }
            return zPayInterceptorWithUrl;
        } catch (Throwable th2) {
            if (xf.c.f55199d) {
                th2.printStackTrace();
            }
            return false;
        }
    }

    public final boolean k(String str) {
        try {
            Activity activity = this.f21819e.get();
            if (activity == null) {
                return true;
            }
            PackageManager packageManager = activity.getPackageManager();
            Intent uri = Intent.parseUri(str, 1);
            if (packageManager.resolveActivity(uri, 65536) == null) {
                return false;
            }
            activity.startActivity(uri);
            return true;
        } catch (Throwable th2) {
            if (!c0.d()) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r2 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.webkit.WebView r11, int r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.util.Set<java.lang.String> r1 = r10.f21829o
            r1.add(r14)
            android.webkit.WebViewClient r1 = r10.f21820f
            if (r1 == 0) goto L5c
            boolean r2 = r10.f21821g
            if (r2 == 0) goto L5c
            java.lang.reflect.Method r2 = r10.f21827m
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 5
            if (r2 != 0) goto L35
            java.lang.Class[] r2 = new java.lang.Class[r8]
            java.lang.Class<xf.b> r9 = xf.b.class
            r2[r7] = r9
            java.lang.Class<android.webkit.WebView> r9 = android.webkit.WebView.class
            r2[r6] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r2[r5] = r9
            r2[r4] = r0
            r2[r3] = r0
            java.lang.String r0 = "onMainFrameError"
            java.lang.reflect.Method r2 = com.just.agentweb.a.L(r1, r0, r2)
            r10.f21827m = r2
            if (r2 == 0) goto L5c
        L35:
            android.webkit.WebViewClient r0 = r10.f21820f     // Catch: java.lang.Throwable -> L51
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L51
            java.lang.ref.WeakReference<xf.b> r8 = r10.f21824j     // Catch: java.lang.Throwable -> L51
            java.lang.Object r8 = r8.get()     // Catch: java.lang.Throwable -> L51
            r1[r7] = r8     // Catch: java.lang.Throwable -> L51
            r1[r6] = r11     // Catch: java.lang.Throwable -> L51
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L51
            r1[r5] = r11     // Catch: java.lang.Throwable -> L51
            r1[r4] = r13     // Catch: java.lang.Throwable -> L51
            r1[r3] = r14     // Catch: java.lang.Throwable -> L51
            r2.invoke(r0, r1)     // Catch: java.lang.Throwable -> L51
            goto L5b
        L51:
            r11 = move-exception
            boolean r12 = xf.c0.d()
            if (r12 == 0) goto L5b
            r11.printStackTrace()
        L5b:
            return
        L5c:
            java.lang.ref.WeakReference<xf.b> r0 = r10.f21824j
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L6f
            java.lang.ref.WeakReference<xf.b> r0 = r10.f21824j
            java.lang.Object r0 = r0.get()
            xf.b r0 = (xf.b) r0
            r0.k(r11, r12, r13, r14)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.just.agentweb.DefaultWebClient.l(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
    }

    public final int m(String str) {
        try {
            if (this.f21819e.get() == null) {
                return 0;
            }
            List<ResolveInfo> listQueryIntentActivities = this.f21819e.get().getPackageManager().queryIntentActivities(Intent.parseUri(str, 1), 65536);
            if (listQueryIntentActivities == null) {
                return 0;
            }
            return listQueryIntentActivities.size();
        } catch (URISyntaxException e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
            return 0;
        }
    }

    public final void n(String str) {
        try {
            if (this.f21819e.get() == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f21819e.get().startActivity(intent);
        } catch (Exception e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
        }
    }

    public final boolean o(String str) {
        int i10 = this.f21822h;
        if (i10 != 250) {
            if (i10 != 1001) {
                return false;
            }
            k(str);
            return true;
        }
        if (this.f21824j.get() != null) {
            xf.b bVar = this.f21824j.get();
            WebView webView = this.f21825k;
            bVar.l(webView, webView.getUrl(), g(str));
        }
        return true;
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f21829o.contains(str) || !this.f21830p.contains(str)) {
            webView.setVisibility(0);
        } else if (this.f21824j.get() != null) {
            this.f21824j.get().o();
        }
        if (this.f21830p.contains(str)) {
            this.f21830p.remove(str);
        }
        if (!this.f21829o.isEmpty()) {
            this.f21829o.clear();
        }
        super.onPageFinished(webView, str);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!this.f21830p.contains(str)) {
            this.f21830p.add(str);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        if (com.just.agentweb.a.Q(this.f21820f, "onReceivedError", "android.webkit.WebViewClient.onReceivedError", WebView.class, Integer.TYPE, String.class, String.class)) {
            super.onReceivedError(webView, i10, str, str2);
        }
        c0.c(f21817y, "onReceivedError：" + str + "  CODE:" + i10);
        l(webView, i10, str, str2);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f10, float f11) {
        WebViewClient webViewClient = this.f21820f;
        Class cls = Float.TYPE;
        if (com.just.agentweb.a.Q(webViewClient, "onScaleChanged", "android.webkit.WebViewClient.onScaleChanged", WebView.class, cls, cls)) {
            super.onScaleChanged(webView, f10, f11);
            return;
        }
        c0.c(f21817y, "onScaleChanged:" + f10 + "   n:" + f11);
        if (f11 - f10 > 7.0f) {
            webView.setInitialScale((int) ((f10 / f11) * 100.0f));
        }
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        byte b10;
        if (!com.just.agentweb.a.Q(this.f21820f, "shouldOverrideUrlLoading", "android.webkit.WebViewClient.shouldOverrideUrlLoading", WebView.class, WebResourceRequest.class)) {
            b10 = -1;
        } else {
            if (super.shouldOverrideUrlLoading(webView, webResourceRequest)) {
                return true;
            }
            b10 = 1;
        }
        String string = webResourceRequest.getUrl().toString();
        if (string.startsWith(f21814v) || string.startsWith(f21815w)) {
            return this.f21821g && f21816x && j(webView, string);
        }
        if (!this.f21821g) {
            return false;
        }
        if (h(string)) {
            return true;
        }
        if (string.startsWith(f21811s)) {
            i(string);
            c0.c(f21817y, "intent url ");
            return true;
        }
        if (string.startsWith(f21812t)) {
            c0.c(f21817y, "lookup wechat to pay ~~");
            n(string);
            return true;
        }
        if (string.startsWith(f21813u) && k(string)) {
            c0.c(f21817y, "alipays url lookup alipay ~~ ");
            return true;
        }
        if (m(string) > 0 && o(string)) {
            c0.c(f21817y, "intercept url:" + string);
            return true;
        }
        if (!this.f21823i) {
            if (b10 > 0) {
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        c0.c(f21817y, "intercept mIsInterceptUnkownUrl :" + webResourceRequest.getUrl());
        return true;
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (com.just.agentweb.a.Q(this.f21820f, "onReceivedError", "android.webkit.WebViewClient.onReceivedError", WebView.class, WebResourceRequest.class, WebResourceError.class)) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
        if (webResourceRequest.isForMainFrame()) {
            l(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
        c0.c(f21817y, "onReceivedError:" + webResourceError.toString());
    }

    @Override // xf.r0, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        byte b10;
        if (!com.just.agentweb.a.Q(this.f21820f, "shouldOverrideUrlLoading", "android.webkit.WebViewClient.shouldOverrideUrlLoading", WebView.class, String.class)) {
            b10 = -1;
        } else {
            if (super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            b10 = 1;
        }
        if (str.startsWith(f21814v) || str.startsWith(f21815w)) {
            return this.f21821g && f21816x && j(webView, str);
        }
        if (!this.f21821g) {
            return false;
        }
        if (h(str)) {
            return true;
        }
        if (str.startsWith(f21811s)) {
            i(str);
            return true;
        }
        if (str.startsWith(f21812t)) {
            n(str);
            return true;
        }
        if (str.startsWith(f21813u) && k(str)) {
            return true;
        }
        if (m(str) > 0 && o(str)) {
            c0.c(f21817y, "intercept OtherAppScheme");
            return true;
        }
        if (!this.f21823i) {
            if (b10 > 0) {
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        c0.c(f21817y, "intercept InterceptUnkownScheme : " + str);
        return true;
    }
}
