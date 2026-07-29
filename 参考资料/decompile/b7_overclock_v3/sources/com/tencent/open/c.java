package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0250a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Toast f22708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IUiListener f22710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0249c f22711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f22712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.tencent.open.c.a f22713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.tencent.open.c.b f22714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f22715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22716k;

    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f22714i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            c.this.f22711f.onError(new UiError(i10, str, str2));
            if (c.this.f22715j != null && c.this.f22715j.get() != null) {
                Toast.makeText((Context) c.this.f22715j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) c.this.f22715j.get(), "auth://tauth.qq.com/"))) {
                c.this.f22711f.onComplete(k.c(str));
                c.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f22711f.onCancel();
                c.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            c.this.dismiss();
            return true;
        }
    }

    public class b extends a.b {
        private b() {
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.c$c, reason: collision with other inner class name */
    public static class C0249c extends DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f22721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IUiListener f22723e;

        public C0249c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f22721c = new WeakReference<>(context);
            this.f22722d = str;
            this.f22719a = str2;
            this.f22720b = str3;
            this.f22723e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f22723e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f22723e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.h.a().a(this.f22722d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(UMTencentSSOHandler.RET, -6), this.f22719a, false);
            IUiListener iUiListener = this.f22723e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f22723e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f22719a;
            } else {
                str = this.f22719a;
            }
            com.tencent.open.b.h hVarA = com.tencent.open.b.h.a();
            hVarA.a(this.f22722d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f22723e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f22723e = null;
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

    public class d extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private C0249c f22725b;

        public d(C0249c c0249c, Looper looper) {
            super(looper);
            this.f22725b = c0249c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f22725b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f22725b.onCancel();
                return;
            }
            if (i10 == 3) {
                if (c.this.f22715j == null || c.this.f22715j.get() == null) {
                    return;
                }
                c.c((Context) c.this.f22715j.get(), (String) message.obj);
                return;
            }
            if (i10 != 5 || c.this.f22715j == null || c.this.f22715j.get() == null) {
                return;
            }
            c.d((Context) c.this.f22715j.get(), (String) message.obj);
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f22715j = new WeakReference<>(context);
        this.f22709d = str2;
        this.f22711f = new C0249c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f22712g = new d(this.f22711f, context.getMainLooper());
        this.f22710e = iUiListener;
        this.f22716k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f22716k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = k.d(str);
            jSONObjectD.getInt("action");
            jSONObjectD.getString("msg");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f22714i.setVerticalScrollBarEnabled(false);
        this.f22714i.setHorizontalScrollBarEnabled(false);
        this.f22714i.setWebViewClient(new a());
        this.f22714i.setWebChromeClient(this.f22660b);
        this.f22714i.clearFormData();
        WebSettings settings = this.f22714i.getSettings();
        if (settings == null) {
            return;
        }
        i.a(settings);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f22715j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f22715j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f22659a.a(new b(), "sdk_js_if");
        this.f22714i.clearView();
        this.f22714i.loadUrl(this.f22709d);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f22715j.get());
        this.f22713h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f22713h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f22715j.get());
        this.f22714i = bVar;
        bVar.setBackgroundColor(0);
        this.f22714i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f22714i, 1, new Paint());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f22716k);
        layoutParams.addRule(13, -1);
        this.f22714i.setLayoutParams(layoutParams);
        this.f22713h.addView(this.f22714i);
        this.f22713h.a(this);
        setContentView(this.f22713h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0250a
    public void a(int i10) {
        WeakReference<Context> weakReference = this.f22715j;
        if (weakReference != null && weakReference.get() != null) {
            if (i10 < this.f22716k && 2 == this.f22715j.get().getResources().getConfiguration().orientation) {
                this.f22714i.getLayoutParams().height = i10;
            } else {
                this.f22714i.getLayoutParams().height = this.f22716k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0250a
    public void a() {
        this.f22714i.getLayoutParams().height = this.f22716k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f22659a.a(this.f22714i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject jSONObjectD = k.d(str);
            int i10 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i10 == 0) {
                Toast toast = f22708c;
                if (toast == null) {
                    f22708c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f22708c.setText(string);
                    f22708c.setDuration(0);
                }
                f22708c.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f22708c;
                if (toast2 == null) {
                    f22708c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f22708c.setText(string);
                    f22708c.setDuration(1);
                }
                f22708c.show();
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
