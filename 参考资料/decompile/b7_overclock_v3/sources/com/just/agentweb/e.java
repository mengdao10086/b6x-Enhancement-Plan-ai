package com.just.agentweb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import g.n0;
import g.p0;
import xf.c0;
import xf.m0;
import xf.u;

/* JADX INFO: loaded from: classes7.dex */
public class e implements m0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f22002o = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f22004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xf.i f22007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup.LayoutParams f22008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u f22012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xf.h f22013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WebView f22014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f22015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f22016n;

    public e(@n0 Activity activity, @p0 ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i10, int i11, int i12, WebView webView, u uVar) {
        this.f22011i = false;
        this.f22015m = null;
        this.f22003a = activity;
        this.f22004b = viewGroup;
        this.f22005c = true;
        this.f22006d = i10;
        this.f22009g = i11;
        this.f22008f = layoutParams;
        this.f22010h = i12;
        this.f22014l = webView;
        this.f22012j = uVar;
    }

    @Override // xf.m0
    public WebView a() {
        return this.f22014l;
    }

    @Override // xf.t
    public xf.h b() {
        return this.f22013k;
    }

    @Override // xf.m0
    public FrameLayout c() {
        return this.f22015m;
    }

    @Override // xf.m0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e create() {
        if (this.f22011i) {
            return this;
        }
        this.f22011i = true;
        ViewGroup viewGroup = this.f22004b;
        if (viewGroup == null) {
            FrameLayout frameLayout = (FrameLayout) e();
            this.f22015m = frameLayout;
            this.f22003a.setContentView(frameLayout);
        } else if (this.f22006d == -1) {
            FrameLayout frameLayout2 = (FrameLayout) e();
            this.f22015m = frameLayout2;
            viewGroup.addView(frameLayout2, this.f22008f);
        } else {
            FrameLayout frameLayout3 = (FrameLayout) e();
            this.f22015m = frameLayout3;
            viewGroup.addView(frameLayout3, this.f22006d, this.f22008f);
        }
        return this;
    }

    public final ViewGroup e() {
        WebView webViewK;
        xf.i iVar;
        Activity activity = this.f22003a;
        i iVar2 = new i(activity);
        iVar2.setId(R.id.web_parent_layout_id);
        iVar2.setBackgroundColor(-1);
        if (this.f22012j == null) {
            WebView webViewF = f();
            this.f22014l = webViewF;
            webViewK = webViewF;
        } else {
            webViewK = k();
        }
        iVar2.addView(webViewK, new FrameLayout.LayoutParams(-1, -1));
        iVar2.c(this.f22014l);
        c0.c(f22002o, "  instanceof  AgentWebView:" + (this.f22014l instanceof AgentWebView));
        if (this.f22014l instanceof AgentWebView) {
            xf.c.f55204i = 2;
        }
        ViewStub viewStub = new ViewStub(activity);
        viewStub.setId(R.id.mainframe_error_viewsub_id);
        iVar2.addView(viewStub, new FrameLayout.LayoutParams(-1, -1));
        boolean z10 = this.f22005c;
        if (z10) {
            xf.n0 n0Var = new xf.n0(activity);
            FrameLayout.LayoutParams layoutParams = this.f22010h > 0 ? new FrameLayout.LayoutParams(-2, a.n(activity, this.f22010h)) : n0Var.b();
            int i10 = this.f22009g;
            if (i10 != -1) {
                n0Var.setColor(i10);
            }
            layoutParams.gravity = 48;
            this.f22013k = n0Var;
            iVar2.addView(n0Var, layoutParams);
            n0Var.setVisibility(8);
        } else if (!z10 && (iVar = this.f22007e) != null) {
            this.f22013k = iVar;
            iVar2.addView(iVar, iVar.b());
            this.f22007e.setVisibility(8);
        }
        return iVar2;
    }

    public final WebView f() {
        WebView webView = this.f22014l;
        if (webView != null) {
            xf.c.f55204i = 3;
            return webView;
        }
        if (xf.c.f55200e) {
            AgentWebView agentWebView = new AgentWebView(this.f22003a);
            xf.c.f55204i = 2;
            return agentWebView;
        }
        WebView webView2 = new WebView(this.f22003a);
        xf.c.f55204i = 1;
        return webView2;
    }

    public FrameLayout g() {
        return this.f22015m;
    }

    public View h() {
        return this.f22016n;
    }

    public void i(View view) {
        this.f22016n = view;
    }

    public void j(WebView webView) {
        this.f22014l = webView;
    }

    public final View k() {
        WebView webViewA = this.f22012j.a();
        if (webViewA == null) {
            webViewA = f();
            this.f22012j.getLayout().addView(webViewA, -1, -1);
            c0.c(f22002o, "add webview");
        } else {
            xf.c.f55204i = 3;
        }
        this.f22014l = webViewA;
        return this.f22012j.getLayout();
    }

    public e(@n0 Activity activity, @p0 ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i10, @p0 WebView webView, u uVar) {
        this.f22009g = -1;
        this.f22011i = false;
        this.f22015m = null;
        this.f22003a = activity;
        this.f22004b = viewGroup;
        this.f22005c = false;
        this.f22006d = i10;
        this.f22008f = layoutParams;
        this.f22014l = webView;
        this.f22012j = uVar;
    }

    public e(@n0 Activity activity, @p0 ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i10, xf.i iVar, WebView webView, u uVar) {
        this.f22009g = -1;
        this.f22011i = false;
        this.f22015m = null;
        this.f22003a = activity;
        this.f22004b = viewGroup;
        this.f22005c = false;
        this.f22006d = i10;
        this.f22008f = layoutParams;
        this.f22007e = iVar;
        this.f22014l = webView;
        this.f22012j = uVar;
    }
}
