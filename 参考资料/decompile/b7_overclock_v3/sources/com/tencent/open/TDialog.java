package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TDialog extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FrameLayout.LayoutParams f22620c = new FrameLayout.LayoutParams(-1, -1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Toast f22621d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WeakReference<ProgressDialog> f22622f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f22623e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OnTimeListener f22625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IUiListener f22626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FrameLayout f22627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.tencent.open.c.b f22628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f22629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f22630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private QQToken f22631n;

    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f22628k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            TDialog.this.f22625h.onError(new UiError(i10, str, str2));
            if (TDialog.this.f22623e != null && TDialog.this.f22623e.get() != null) {
                Toast.makeText((Context) TDialog.this.f22623e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) TDialog.this.f22623e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f22625h.onComplete(k.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f22625h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(268435456);
                if (TDialog.this.f22623e != null && TDialog.this.f22623e.get() != null) {
                    ((Context) TDialog.this.f22623e.get()).startActivity(intent);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }
    }

    public class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f22629l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f22629l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f22629l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f22629l.obtainMessage(3, str).sendToTarget();
        }
    }

    public static class OnTimeListener extends DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f22637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IUiListener f22639e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f22637c = new WeakReference<>(context);
            this.f22638d = str;
            this.f22635a = str2;
            this.f22636b = str3;
            this.f22639e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f22639e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f22639e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.h.a().a(this.f22638d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(UMTencentSSOHandler.RET, -6), this.f22635a, false);
            IUiListener iUiListener = this.f22639e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f22639e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f22635a;
            } else {
                str = this.f22635a;
            }
            com.tencent.open.b.h hVarA = com.tencent.open.b.h.a();
            hVarA.a(this.f22638d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f22639e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f22639e = null;
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

    public class THandler extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private OnTimeListener f22641b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f22641b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f22641b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f22641b.onCancel();
                return;
            }
            if (i10 == 3) {
                if (TDialog.this.f22623e == null || TDialog.this.f22623e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f22623e.get(), (String) message.obj);
                return;
            }
            if (i10 != 5 || TDialog.this.f22623e == null || TDialog.this.f22623e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f22623e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f22630m = false;
        this.f22631n = null;
        this.f22623e = new WeakReference<>(context);
        this.f22624g = str2;
        this.f22625h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f22629l = new THandler(this.f22625h, context.getMainLooper());
        this.f22626i = iUiListener;
        this.f22631n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f22625h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject jSONObjectD = k.d(str);
            int i10 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i10 == 0) {
                Toast toast = f22621d;
                if (toast == null) {
                    f22621d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f22621d.setText(string);
                    f22621d.setDuration(0);
                }
                f22621d.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f22621d;
                if (toast2 == null) {
                    f22621d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f22621d.setText(string);
                    f22621d.setDuration(1);
                }
                f22621d.show();
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = k.d(str);
            int i10 = jSONObjectD.getInt("action");
            String string = jSONObjectD.getString("msg");
            if (i10 == 1) {
                WeakReference<ProgressDialog> weakReference = f22622f;
                if (weakReference == null || weakReference.get() == null) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f22622f = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else {
                    f22622f.get().setMessage(string);
                    if (!f22622f.get().isShowing()) {
                        f22622f.get().show();
                    }
                }
            } else if (i10 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f22622f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f22622f.get().isShowing()) {
                    f22622f.get().dismiss();
                    f22622f = null;
                }
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f22623e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f22623e.get());
        this.f22628k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f22623e.get());
        this.f22627j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f22627j.addView(this.f22628k);
        setContentView(this.f22627j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f22628k.setVerticalScrollBarEnabled(false);
        this.f22628k.setHorizontalScrollBarEnabled(false);
        this.f22628k.setWebViewClient(new FbWebViewClient());
        this.f22628k.setWebChromeClient(this.f22660b);
        this.f22628k.clearFormData();
        WebSettings settings = this.f22628k.getSettings();
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
        WeakReference<Context> weakReference = this.f22623e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f22623e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f22659a.a(new JsListener(), "sdk_js_if");
        this.f22628k.loadUrl(this.f22624g);
        this.f22628k.setLayoutParams(f22620c);
        this.f22628k.setVisibility(4);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f22659a.a(this.f22628k, str);
        } catch (Exception unused) {
        }
    }
}
