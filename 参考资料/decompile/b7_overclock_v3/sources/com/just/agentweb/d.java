package com.just.agentweb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.e;
import com.bumptech.glide.load.engine.GlideException;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class d extends xf.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.appcompat.app.e f21884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.appcompat.app.e f21885h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Activity f21889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.just.agentweb.i f21890m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ProgressDialog f21892o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JsPromptResult f21886i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JsResult f21887j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.appcompat.app.e f21888k = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.appcompat.app.e f21891n = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Resources f21893p = null;

    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            d dVar = d.this;
            dVar.A(dVar.f21886i);
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f21895a;

        public b(EditText editText) {
            this.f21895a = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d dVar = d.this;
            dVar.q(dVar.f21888k);
            if (d.this.f21886i != null) {
                d.this.f21886i.confirm(this.f21895a.getText().toString());
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d dVar = d.this;
            dVar.q(dVar.f21888k);
            d dVar2 = d.this;
            dVar2.A(dVar2.f21886i);
        }
    }

    /* JADX INFO: renamed from: com.just.agentweb.d$d, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0236d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21898a;

        public DialogInterfaceOnClickListenerC0236d(Handler.Callback callback) {
            this.f21898a = callback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Handler.Callback callback = this.f21898a;
            if (callback != null) {
                callback.handleMessage(Message.obtain((Handler) null, 1));
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21900a;

        public e(Handler.Callback callback) {
            this.f21900a = callback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Handler.Callback callback = this.f21900a;
            if (callback != null) {
                callback.handleMessage(Message.obtain((Handler) null, -1));
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    public class g implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21903a;

        public g(Handler.Callback callback) {
            this.f21903a = callback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Handler.Callback callback = this.f21903a;
            if (callback != null) {
                callback.handleMessage(Message.obtain());
            }
        }
    }

    public class h implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21905a;

        public h(Handler.Callback callback) {
            this.f21905a = callback;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            Handler.Callback callback = this.f21905a;
            if (callback != null) {
                callback.handleMessage(Message.obtain((Handler) null, -1));
            }
        }
    }

    public class i implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21907a;

        public i(Handler.Callback callback) {
            this.f21907a = callback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            c0.c(d.this.f55195e, "which:" + i10);
            if (this.f21907a != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i10;
                this.f21907a.handleMessage(messageObtain);
            }
        }
    }

    public class j implements DialogInterface.OnCancelListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            d dVar = d.this;
            dVar.A(dVar.f21887j);
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d dVar = d.this;
            dVar.q(dVar.f21885h);
            if (d.this.f21887j != null) {
                d.this.f21887j.confirm();
            }
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d dVar = d.this;
            dVar.q(dVar.f21885h);
            d dVar2 = d.this;
            dVar2.A(dVar2.f21887j);
        }
    }

    public final void A(JsResult jsResult) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }

    @Override // xf.b
    public void a(com.just.agentweb.i iVar, Activity activity) {
        this.f21889l = activity;
        this.f21890m = iVar;
        this.f21893p = activity.getResources();
    }

    @Override // xf.b
    public void e() {
        ProgressDialog progressDialog = this.f21892o;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f21892o.dismiss();
        }
        this.f21892o = null;
    }

    @Override // xf.b
    public void f(String str, Handler.Callback callback) {
        w(callback);
    }

    @Override // xf.b
    public void g(WebView webView, String str, String str2) {
        com.just.agentweb.a.Y(webView.getContext().getApplicationContext(), str2);
    }

    @Override // xf.b
    public void h(WebView webView, String str, String str2, JsResult jsResult) {
        x(str2, jsResult);
    }

    @Override // xf.b
    public void i(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        y(str2, str3, jsPromptResult);
    }

    @Override // xf.b
    public void j(String str) {
        if (this.f21892o == null) {
            this.f21892o = new ProgressDialog(this.f21889l);
        }
        this.f21892o.setCancelable(false);
        this.f21892o.setCanceledOnTouchOutside(false);
        this.f21892o.setMessage(str);
        this.f21892o.show();
    }

    @Override // xf.b
    public void k(WebView webView, int i10, String str, String str2) {
        c0.c(this.f55195e, "mWebParentLayout onMainFrameError:" + this.f21890m);
        com.just.agentweb.i iVar = this.f21890m;
        if (iVar != null) {
            iVar.h();
        }
    }

    @Override // xf.b
    public void l(WebView webView, String str, Handler.Callback callback) {
        c0.c(this.f55195e, "onOpenPagePrompt");
        if (this.f21891n == null) {
            this.f21891n = new e.a(this.f21889l).l(this.f21893p.getString(R.string.agentweb_leave_app_and_go_other_page, com.just.agentweb.a.q(this.f21889l))).setTitle(this.f21893p.getString(R.string.agentweb_tips)).setNegativeButton(android.R.string.cancel, new e(callback)).y(this.f21893p.getString(R.string.agentweb_leave), new DialogInterfaceOnClickListenerC0236d(callback)).create();
        }
        this.f21891n.show();
    }

    @Override // xf.b
    public void m(String[] strArr, String str, String str2) {
    }

    @Override // xf.b
    public void n(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        z(strArr, callback);
    }

    @Override // xf.b
    public void o() {
        com.just.agentweb.i iVar = this.f21890m;
        if (iVar != null) {
            iVar.e();
        }
    }

    @Override // xf.b
    public void p(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            com.just.agentweb.a.Y(this.f21889l.getApplicationContext(), str);
        }
    }

    public final void w(Handler.Callback callback) {
        Activity activity = this.f21889l;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        new e.a(activity).setTitle(this.f21893p.getString(R.string.agentweb_tips)).l(this.f21893p.getString(R.string.agentweb_honeycomblow)).p(this.f21893p.getString(R.string.agentweb_download), new g(callback)).y(this.f21893p.getString(R.string.agentweb_cancel), new f()).create().show();
    }

    public final void x(String str, JsResult jsResult) {
        c0.c(this.f55195e, "activity:" + this.f21889l.hashCode() + GlideException.a.f12263d);
        Activity activity = this.f21889l;
        if (activity == null || activity.isFinishing()) {
            A(jsResult);
            return;
        }
        if (this.f21885h == null) {
            this.f21885h = new e.a(activity).l(str).setNegativeButton(android.R.string.cancel, new l()).setPositiveButton(android.R.string.ok, new k()).u(new j()).create();
        }
        this.f21885h.x(str);
        this.f21887j = jsResult;
        this.f21885h.show();
    }

    public final void y(String str, String str2, JsPromptResult jsPromptResult) {
        Activity activity = this.f21889l;
        if (activity == null || activity.isFinishing()) {
            jsPromptResult.cancel();
            return;
        }
        if (this.f21888k == null) {
            EditText editText = new EditText(activity);
            editText.setText(str2);
            this.f21888k = new e.a(activity).setView(editText).setTitle(str).setNegativeButton(android.R.string.cancel, new c()).setPositiveButton(android.R.string.ok, new b(editText)).u(new a()).create();
        }
        this.f21886i = jsPromptResult;
        this.f21888k.show();
    }

    public final void z(String[] strArr, Handler.Callback callback) {
        androidx.appcompat.app.e eVarCreate = new e.a(this.f21889l).E(strArr, -1, new i(callback)).u(new h(callback)).create();
        this.f21884g = eVarCreate;
        eVarCreate.show();
    }
}
