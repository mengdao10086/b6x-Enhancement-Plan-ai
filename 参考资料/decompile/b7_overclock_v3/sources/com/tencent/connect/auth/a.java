package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f22409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IUiListener f22410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f22411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f22412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f22413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f22414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ProgressBar f22415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.c f22417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f22418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f22419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f22420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f22421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f22422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f22423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f22424q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f22425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HashMap<String, Runnable> f22426s;

    /* JADX INFO: renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    public class C0242a extends WebViewClient {
        private C0242a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f22414g.setVisibility(8);
            if (a.this.f22417j != null) {
                a.this.f22417j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f22411d.removeCallbacks((Runnable) a.this.f22426s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f22414g.setVisibility(0);
            a.this.f22424q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f22422o)) {
                a.this.f22411d.removeCallbacks((Runnable) a.this.f22426s.remove(a.this.f22422o));
            }
            a.this.f22422o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.f22422o);
            a.this.f22426s.put(str, dVar);
            a.this.f22411d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i10 + " | description: " + str);
            if (!k.b(a.this.f22418k)) {
                a.this.f22409b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.f22422o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                a.this.f22409b.onError(new UiError(i10, str, str2));
                a.this.dismiss();
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.f22424q;
            if (a.this.f22421n >= 1 || jElapsedRealtime >= a.this.f22425r) {
                a.this.f22417j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f22411d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f22417j.loadUrl(a.this.f22422o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject jSONObjectC = k.c(str);
                a aVar = a.this;
                aVar.f22420m = aVar.e();
                if (!a.this.f22420m) {
                    if (jSONObjectC.optString("fail_cb", null) != null) {
                        a.this.a(jSONObjectC.optString("fail_cb"), "");
                    } else if (jSONObjectC.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(a.this.f22408a);
                        sb2.append(a.this.f22408a.indexOf("?") > -1 ? "&" : "?");
                        aVar2.f22408a = sb2.toString();
                        a.this.f22408a = a.this.f22408a + "browser_error=1";
                        a.this.f22417j.loadUrl(a.this.f22408a);
                    } else {
                        String strOptString = jSONObjectC.optString("redir", null);
                        if (strOptString != null) {
                            a.this.f22417j.loadUrl(strOptString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f22409b.onComplete(k.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f22409b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(268435456);
                    a.this.f22418k.startActivity(intent);
                } catch (Exception e10) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e10);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments = Uri.parse(str).getPathSegments();
                        if (!pathSegments.isEmpty()) {
                            a.this.f22423p = pathSegments.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f22419l.a(a.this.f22417j, str)) {
                    return true;
                }
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                if (pathSegments2.isEmpty()) {
                    return true;
                }
                int iIntValue = Integer.valueOf(pathSegments2.get(0)).intValue();
                if (iIntValue == 0) {
                    a.this.f22414g.setVisibility(8);
                    a.this.f22417j.setVisibility(0);
                } else if (iIntValue == 1) {
                    a.this.f22414g.setVisibility(0);
                }
            } catch (Exception unused2) {
            }
            return true;
        }
    }

    public class b extends DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22434b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IUiListener f22437e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f22436d = str;
            this.f22433a = str2;
            this.f22434b = str3;
            this.f22437e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f22437e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f22437e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f22436d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(UMTencentSSOHandler.RET, -6), this.f22433a, false);
            IUiListener iUiListener = this.f22437e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f22437e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f22433a;
            } else {
                str = this.f22433a;
            }
            h.a().a(this.f22436d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f22437e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f22437e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(k.d(str));
            } catch (JSONException e10) {
                e10.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f22439b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f22439b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                this.f22439b.a((String) message.obj);
            } else if (i10 == 2) {
                this.f22439b.onCancel();
            } else {
                if (i10 != 3) {
                    return;
                }
                a.b(a.this.f22418k, (String) message.obj);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22440a;

        public d(String str) {
            this.f22440a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f22440a + " | mRetryUrl: " + a.this.f22422o);
            if (this.f22440a.equals(a.this.f22422o)) {
                a.this.f22409b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.f22422o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f22420m = false;
        this.f22424q = 0L;
        this.f22425r = 30000L;
        this.f22418k = context;
        this.f22408a = str2;
        this.f22409b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f22411d = new c(this.f22409b, context.getMainLooper());
        this.f22410c = iUiListener;
        this.f22416i = str;
        this.f22419l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i10 = aVar.f22421n;
        aVar.f22421n = i10 + 1;
        return i10;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f22426s.clear();
        this.f22411d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f22418k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e10);
        }
        com.tencent.open.c.c cVar = this.f22417j;
        if (cVar != null) {
            cVar.destroy();
            this.f22417j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f22420m) {
            this.f22409b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        b();
        d();
        this.f22426s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b bVarA = com.tencent.connect.auth.b.a();
        String strC = bVarA.c();
        b.a aVar = new b.a();
        aVar.f22447a = this.f22410c;
        aVar.f22448b = this;
        aVar.f22449c = strC;
        String strA = bVarA.a(aVar);
        String str = this.f22408a;
        String strSubstring = str.substring(0, str.indexOf("?"));
        Bundle bundleB = k.b(this.f22408a);
        bundleB.putString("token_key", strC);
        bundleB.putString("serial", strA);
        bundleB.putString("browser", "1");
        String str2 = strSubstring + "?" + HttpUtils.encodeUrl(bundleB);
        this.f22408a = str2;
        return k.a(this.f22418k, str2);
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f22418k);
        this.f22417j = cVar;
        cVar.setLayerType(1, null);
        this.f22417j.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f22418k);
        this.f22412e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f22412e.addView(this.f22417j);
        this.f22412e.addView(this.f22414g);
        String string = k.b(this.f22408a).getString("style");
        if (string != null && "qr".equals(string)) {
            a(this.f22412e);
        }
        setContentView(this.f22412e);
    }

    private void c() {
        TextView textView;
        this.f22415h = new ProgressBar(this.f22418k);
        this.f22415h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f22413f = new LinearLayout(this.f22418k);
        if (this.f22416i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f22418k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f22413f.setLayoutParams(layoutParams2);
        this.f22413f.addView(this.f22415h);
        if (textView != null) {
            this.f22413f.addView(textView);
        }
        this.f22414g = new FrameLayout(this.f22418k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f22414g.setLayoutParams(layoutParams3);
        this.f22414g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f22414g.addView(this.f22413f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f22417j.setVerticalScrollBarEnabled(false);
        this.f22417j.setHorizontalScrollBarEnabled(false);
        this.f22417j.setWebViewClient(new C0242a());
        this.f22417j.setWebChromeClient(new WebChromeClient());
        this.f22417j.clearFormData();
        this.f22417j.clearSslPreferences();
        this.f22417j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f22417j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f22417j.getSettings();
        i.a(settings);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f22418k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f22408a);
        String str = this.f22408a;
        this.f22422o = str;
        this.f22417j.loadUrl(str);
        this.f22417j.setVisibility(4);
        this.f22419l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f22423p) && this.f22423p.length() >= 4) {
            String str2 = this.f22423p;
            String strSubstring = str2.substring(str2.length() - 4);
            sb2.append("_u_");
            sb2.append(strSubstring);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f22408a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f22418k);
        int iA = com.tencent.connect.avatar.a.a(this.f22418k, 15.6f);
        int iA2 = com.tencent.connect.avatar.a.a(this.f22418k, 25.2f);
        int iA3 = com.tencent.connect.avatar.a.a(this.f22418k, 10.0f);
        int i10 = iA3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA + i10, iA2 + i10);
        layoutParams.leftMargin = iA3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(iA3, iA3, iA3, iA3);
        imageView.setImageDrawable(k.a("h5_qr_back.png", this.f22418k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f22420m || a.this.f22409b == null) {
                    return;
                }
                a.this.f22409b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject jSONObjectD = k.d(str);
            int i10 = jSONObjectD.getInt("type");
            Toast.makeText(context.getApplicationContext(), jSONObjectD.getString("msg"), i10).show();
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f22417j.loadUrl("javascript:" + str + ee.a.f26978c + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
