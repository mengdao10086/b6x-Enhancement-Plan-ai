package com.just.agentweb;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class c extends d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f21871u = 4097;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f21872q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Activity f21873r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public i f21874s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LayoutInflater f21875t;

    public class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21876a;

        public a(Handler.Callback callback) {
            this.f21876a = callback;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Handler.Callback callback = this.f21876a;
            if (callback != null) {
                callback.handleMessage(Message.obtain((Handler) null, -1));
            }
        }
    }

    public class b extends RecyclerView.g<C0235c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f21878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler.Callback f21879b;

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f21881a;

            public a(int i10) {
                this.f21881a = i10;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f21872q != null && c.this.f21872q.isShowing()) {
                    c.this.f21872q.dismiss();
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = this.f21881a;
                b.this.f21879b.handleMessage(messageObtain);
            }
        }

        public b(String[] strArr, Handler.Callback callback) {
            this.f21878a = strArr;
            this.f21879b = callback;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f21878a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0235c c0235c, int i10) {
            TypedValue typedValue = new TypedValue();
            c.this.f21873r.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
            c0235c.f21883a.setBackgroundResource(typedValue.resourceId);
            c0235c.f21883a.setText(this.f21878a[i10]);
            c0235c.f21883a.setOnClickListener(new a(i10));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public C0235c onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new C0235c(c.this.f21875t.inflate(android.R.layout.simple_list_item_1, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: com.just.agentweb.c$c, reason: collision with other inner class name */
    public static class C0235c extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f21883a;

        public C0235c(View view) {
            super(view);
            this.f21883a = (TextView) view.findViewById(android.R.id.text1);
        }
    }

    public final RecyclerView.g E(String[] strArr, Handler.Callback callback) {
        return new b(strArr, callback);
    }

    public final void F(WebView webView, String str) {
        Activity activity = this.f21873r;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            com.just.agentweb.a.W(webView, str, -1, -1, activity.getResources().getColor(R.color.black), null, -1, null);
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public final void G(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        c0.c(this.f55195e, "url:" + str + "  ways:" + strArr[0]);
        if (this.f21872q == null) {
            this.f21872q = new com.google.android.material.bottomsheet.a(this.f21873r);
            RecyclerView recyclerView = new RecyclerView(this.f21873r);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f21873r));
            recyclerView.setId(4097);
            this.f21872q.setContentView(recyclerView);
        }
        ((RecyclerView) this.f21872q.g().n(4097)).setAdapter(E(strArr, callback));
        this.f21872q.setOnCancelListener(new a(callback));
        this.f21872q.show();
    }

    @Override // com.just.agentweb.d, xf.b
    public void a(i iVar, Activity activity) {
        super.a(iVar, activity);
        this.f21873r = activity;
        this.f21874s = iVar;
        this.f21875t = LayoutInflater.from(activity);
    }

    @Override // com.just.agentweb.d, xf.b
    public void f(String str, Handler.Callback callback) {
        super.f(str, callback);
    }

    @Override // com.just.agentweb.d, xf.b
    public void g(WebView webView, String str, String str2) {
        F(webView, str2);
    }

    @Override // com.just.agentweb.d, xf.b
    public void h(WebView webView, String str, String str2, JsResult jsResult) {
        super.h(webView, str, str2, jsResult);
    }

    @Override // com.just.agentweb.d, xf.b
    public void i(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        super.i(webView, str, str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.d, xf.b
    public void n(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        G(webView, str, strArr, callback);
    }

    @Override // com.just.agentweb.d, xf.b
    public void p(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            F(this.f21874s.getWebView(), str);
        }
    }
}
