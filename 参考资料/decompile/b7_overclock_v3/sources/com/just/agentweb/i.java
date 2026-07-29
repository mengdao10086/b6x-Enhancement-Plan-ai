package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import g.d0;
import g.i0;
import g.n0;
import g.p0;
import xf.c0;
import xf.h0;

/* JADX INFO: loaded from: classes7.dex */
public class i extends FrameLayout implements h0<xf.b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f22070g = i.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xf.b f22071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i0
    public int f22072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d0
    public int f22073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f22074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WebView f22075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f22076f;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22077a;

        public a(View view) {
            this.f22077a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.getWebView() != null) {
                this.f22077a.setClickable(false);
                i.this.getWebView().reload();
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f22079a;

        public b(FrameLayout frameLayout) {
            this.f22079a = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.getWebView() != null) {
                this.f22079a.setClickable(false);
                i.this.getWebView().reload();
            }
        }
    }

    public i(@n0 Context context) {
        this(context, null);
        c0.c(f22070g, "WebParentLayout");
    }

    public void b(xf.b bVar) {
        this.f22071a = bVar;
        bVar.b(this, (Activity) getContext());
    }

    public void c(WebView webView) {
        if (this.f22075e == null) {
            this.f22075e = webView;
        }
    }

    public final void d() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setId(R.id.mainframe_error_container_id);
        View view = this.f22074d;
        if (view == null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            c0.c(f22070g, "mErrorLayoutRes:" + this.f22072b);
            layoutInflaterFrom.inflate(this.f22072b, (ViewGroup) frameLayout, true);
        } else {
            frameLayout.addView(view);
        }
        View view2 = (ViewStub) findViewById(R.id.mainframe_error_viewsub_id);
        int iIndexOfChild = indexOfChild(view2);
        removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.f22076f = frameLayout;
            addView(frameLayout, iIndexOfChild, layoutParams);
        } else {
            this.f22076f = frameLayout;
            addView(frameLayout, iIndexOfChild);
        }
        frameLayout.setVisibility(0);
        int i10 = this.f22073c;
        if (i10 != -1) {
            View viewFindViewById = frameLayout.findViewById(i10);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new a(viewFindViewById));
                return;
            } else if (c0.d()) {
                c0.a(f22070g, "ClickView is null , cannot bind accurate view to refresh or reload .");
            }
        }
        frameLayout.setOnClickListener(new b(frameLayout));
    }

    public void e() {
        View viewFindViewById = findViewById(R.id.mainframe_error_container_id);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // xf.h0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public xf.b a() {
        return this.f22071a;
    }

    public void g(@i0 int i10, @d0 int i11) {
        this.f22073c = i11;
        if (i11 <= 0) {
            this.f22073c = -1;
        }
        this.f22072b = i10;
        if (i10 <= 0) {
            this.f22072b = R.layout.agentweb_error_page;
        }
    }

    public WebView getWebView() {
        return this.f22075e;
    }

    public void h() {
        View viewFindViewById;
        FrameLayout frameLayout = this.f22076f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        } else {
            d();
            frameLayout = this.f22076f;
        }
        int i10 = this.f22073c;
        if (i10 == -1 || (viewFindViewById = frameLayout.findViewById(i10)) == null) {
            frameLayout.setClickable(true);
        } else {
            viewFindViewById.setClickable(true);
        }
    }

    public void setErrorView(@n0 View view) {
        this.f22074d = view;
    }

    public i(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public i(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22071a = null;
        this.f22073c = -1;
        this.f22076f = null;
        if (context instanceof Activity) {
            this.f22072b = R.layout.agentweb_error_page;
            return;
        }
        throw new IllegalArgumentException("WebParentLayout context must be activity or activity sub class .");
    }
}
