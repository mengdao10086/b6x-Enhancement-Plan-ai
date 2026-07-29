package com.just.agentweb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.just.agentweb.DefaultWebClient;
import g.i0;
import g.n0;
import java.lang.ref.WeakReference;
import java.util.Objects;
import xf.a0;
import xf.c0;
import xf.d0;
import xf.e0;
import xf.g0;
import xf.j0;
import xf.k0;
import xf.m;
import xf.m0;
import xf.n;
import xf.o;
import xf.o0;
import xf.p;
import xf.p0;
import xf.q;
import xf.q0;
import xf.r;
import xf.s;
import xf.u;
import xf.v;
import xf.w;
import xf.x;
import xf.y;

/* JADX INFO: loaded from: classes7.dex */
public final class AgentWeb {
    public static final String E = "AgentWeb";
    public static final int F = 0;
    public static final int G = 1;
    public e0 A;
    public d0 B;
    public n C;
    public a0 D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f21742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f21743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m0 f21744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f21745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AgentWeb f21746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v f21747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebChromeClient f21748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebViewClient f21749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f21751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.collection.a<String, Object> f21752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p0 f21754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q0<j> f21755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f21756o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WebChromeClient f21757p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SecurityType f21758q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public xf.d f21759r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public x f21760s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public r f21761t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public o0 f21762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public s f21763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f21764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g0 f21765x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21766y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21767z;

    public enum SecurityType {
        DEFAULT_CHECK,
        STRICT_CHECK
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f21794a;

        public c(b bVar) {
            this.f21794a = bVar;
        }

        public c a(@n0 String str, @n0 Object obj) {
            this.f21794a.i0(str, obj);
            return this;
        }

        public c b(String str, String str2) {
            this.f21794a.h0(str, str2);
            return this;
        }

        public c c() {
            this.f21794a.f21788u = false;
            return this;
        }

        public f d() {
            return this.f21794a.j0();
        }

        public c e() {
            this.f21794a.f21793z = true;
            return this;
        }

        public c f(@g.p0 xf.g gVar) {
            this.f21794a.f21791x = gVar;
            return this;
        }

        public c g(@g.p0 p pVar) {
            this.f21794a.f21780m = pVar;
            return this;
        }

        public c h(@g.p0 q qVar) {
            this.f21794a.f21783p = qVar;
            return this;
        }

        public c i(@i0 int i10, @g.d0 int i11) {
            this.f21794a.F = i10;
            this.f21794a.G = i11;
            return this;
        }

        public c j(@n0 View view) {
            this.f21794a.E = view;
            return this;
        }

        public c k(@g.p0 DefaultWebClient.OpenOtherPageWays openOtherPageWays) {
            this.f21794a.f21792y = openOtherPageWays;
            return this;
        }

        public c l(@g.p0 g0 g0Var) {
            this.f21794a.f21790w = g0Var;
            return this;
        }

        public c m(@n0 SecurityType securityType) {
            this.f21794a.f21786s = securityType;
            return this;
        }

        public c n(@g.p0 WebChromeClient webChromeClient) {
            this.f21794a.f21778k = webChromeClient;
            return this;
        }

        public c o(@g.p0 u uVar) {
            this.f21794a.f21789v = uVar;
            return this;
        }

        public c p(@g.p0 WebView webView) {
            this.f21794a.f21787t = webView;
            return this;
        }

        public c q(@g.p0 WebViewClient webViewClient) {
            this.f21794a.f21777j = webViewClient;
            return this;
        }

        public c r(@n0 d0 d0Var) {
            if (d0Var == null) {
                return this;
            }
            if (this.f21794a.C == null) {
                b bVar = this.f21794a;
                bVar.C = bVar.D = d0Var;
            } else {
                this.f21794a.D.h(d0Var);
                this.f21794a.D = d0Var;
            }
            return this;
        }

        public c s(@n0 e0 e0Var) {
            if (e0Var == null) {
                return this;
            }
            if (this.f21794a.A == null) {
                b bVar = this.f21794a;
                bVar.A = bVar.B = e0Var;
            } else {
                this.f21794a.B.c(e0Var);
                this.f21794a.B = e0Var;
            }
            return this;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f21795a;

        public d(b bVar) {
            this.f21795a = bVar;
        }

        public c a() {
            this.f21795a.f21775h = false;
            this.f21795a.f21779l = -1;
            this.f21795a.f21784q = -1;
            return new c(this.f21795a);
        }

        public c b(@n0 xf.i iVar) {
            if (iVar != null) {
                this.f21795a.f21775h = true;
                this.f21795a.f21773f = iVar;
                this.f21795a.f21771d = false;
            } else {
                this.f21795a.f21775h = true;
                this.f21795a.f21771d = true;
            }
            return new c(this.f21795a);
        }

        public c c() {
            this.f21795a.f21775h = true;
            return new c(this.f21795a);
        }

        public c d(int i10) {
            this.f21795a.f21775h = true;
            this.f21795a.f21779l = i10;
            return new c(this.f21795a);
        }

        public c e(@g.l int i10, int i11) {
            this.f21795a.f21779l = i10;
            this.f21795a.f21784q = i11;
            return new c(this.f21795a);
        }
    }

    public static final class e implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<g0> f21796a;

        @Override // xf.g0
        public boolean a(String str, String[] strArr, String str2) {
            if (this.f21796a.get() == null) {
                return false;
            }
            return this.f21796a.get().a(str, strArr, str2);
        }

        public e(g0 g0Var) {
            this.f21796a = new WeakReference<>(g0Var);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AgentWeb f21797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21798b = false;

        public f(AgentWeb agentWeb) {
            this.f21797a = agentWeb;
        }

        public AgentWeb a(@g.p0 String str) {
            if (!this.f21798b) {
                b();
            }
            return this.f21797a.v(str);
        }

        public f b() {
            if (!this.f21798b) {
                this.f21797a.y();
                this.f21798b = true;
            }
            return this;
        }
    }

    public static b A(@n0 Fragment fragment) {
        androidx.fragment.app.g gVarW1 = fragment.w1();
        Objects.requireNonNull(gVarW1, "activity can not be null .");
        return new b(gVarW1, fragment);
    }

    public static b z(@n0 Activity activity) {
        Objects.requireNonNull(activity, "activity can not be null .");
        return new b(activity);
    }

    public boolean c() {
        if (this.f21751j == null) {
            this.f21751j = m.b(this.f21744c.a(), n());
        }
        return this.f21751j.a();
    }

    public AgentWeb d() {
        if (s().a() != null) {
            com.just.agentweb.a.i(this.f21742a, s().a());
        } else {
            com.just.agentweb.a.h(this.f21742a);
        }
        return this;
    }

    public final m0 e(xf.i iVar, int i10, ViewGroup.LayoutParams layoutParams, int i11, int i12, WebView webView, u uVar) {
        return (iVar == null || !this.f21750i) ? this.f21750i ? new com.just.agentweb.e(this.f21742a, this.f21743b, layoutParams, i10, i11, i12, webView, uVar) : new com.just.agentweb.e(this.f21742a, this.f21743b, layoutParams, i10, webView, uVar) : new com.just.agentweb.e(this.f21742a, this.f21743b, layoutParams, i10, iVar, webView, uVar);
    }

    public void f() {
        this.f21762u.a();
    }

    public final void g() {
        androidx.collection.a<String, Object> aVar = this.f21752k;
        xf.d dVar = new xf.d(this, this.f21742a);
        this.f21759r = dVar;
        aVar.put("agentWeb", dVar);
    }

    public final void h() {
        j jVarC = this.f21756o;
        if (jVarC == null) {
            jVarC = l.c();
            this.f21756o = jVarC;
        }
        this.f21755n.a(jVarC);
    }

    public p i() {
        return this.f21745d;
    }

    public final WebChromeClient j() {
        v vVarE = this.f21747f;
        if (vVarE == null) {
            vVarE = w.d().e(this.f21744c.b());
        }
        v vVar = vVarE;
        Activity activity = this.f21742a;
        this.f21747f = vVar;
        WebChromeClient webChromeClient = this.f21748g;
        s sVarL = l();
        this.f21763v = sVarL;
        com.just.agentweb.b bVar = new com.just.agentweb.b(activity, vVar, webChromeClient, sVarL, this.f21765x, this.f21744c.a());
        c0.c(E, "WebChromeClient:" + this.f21748g);
        d0 d0Var = this.B;
        if (d0Var == null) {
            this.f21757p = bVar;
            return bVar;
        }
        int i10 = 1;
        d0 d0VarI = d0Var;
        while (d0VarI.i() != null) {
            d0VarI = d0VarI.i();
            i10++;
        }
        c0.c(E, "MiddlewareWebClientBase middleware count:" + i10);
        d0VarI.g(bVar);
        this.f21757p = d0Var;
        return d0Var;
    }

    public q k() {
        q qVar = this.f21751j;
        if (qVar != null) {
            return qVar;
        }
        m mVarB = m.b(this.f21744c.a(), n());
        this.f21751j = mVarB;
        return mVarB;
    }

    public final s l() {
        s sVar = this.f21763v;
        return sVar == null ? new k0(this.f21742a, this.f21744c.a()) : sVar;
    }

    public v m() {
        return this.f21747f;
    }

    public final n n() {
        n nVar = this.C;
        if (nVar != null) {
            return nVar;
        }
        s sVar = this.f21763v;
        if (!(sVar instanceof k0)) {
            return null;
        }
        n nVar2 = (n) sVar;
        this.C = nVar2;
        return nVar2;
    }

    public x o() {
        x xVar = this.f21760s;
        if (xVar != null) {
            return xVar;
        }
        y yVarJ = y.j(this.f21744c.a());
        this.f21760s = yVarJ;
        return yVarJ;
    }

    public a0 p() {
        return this.D;
    }

    public g0 q() {
        return this.f21765x;
    }

    public r r() {
        return this.f21761t;
    }

    public m0 s() {
        return this.f21744c;
    }

    public o0 t() {
        return this.f21762u;
    }

    public final WebViewClient u() {
        c0.c(E, "getDelegate:" + this.A);
        DefaultWebClient defaultWebClientG = DefaultWebClient.f().h(this.f21742a).i(this.f21749h).m(this.f21764w).k(this.f21765x).n(this.f21744c.a()).j(this.f21766y).l(this.f21767z).g();
        e0 e0Var = this.A;
        if (e0Var == null) {
            return defaultWebClientG;
        }
        int i10 = 1;
        e0 e0VarD = e0Var;
        while (e0VarD.d() != null) {
            e0VarD = e0VarD.d();
            i10++;
        }
        c0.c(E, "MiddlewareWebClientBase middleware count:" + i10);
        e0VarD.b(defaultWebClientG);
        return e0Var;
    }

    public final AgentWeb v(String str) {
        v vVarM;
        r().g(str);
        if (!TextUtils.isEmpty(str) && (vVarM = m()) != null && vVarM.c() != null) {
            m().c().a();
        }
        return this;
    }

    public boolean w(int i10, KeyEvent keyEvent) {
        if (this.f21751j == null) {
            this.f21751j = m.b(this.f21744c.a(), n());
        }
        return this.f21751j.onKeyDown(i10, keyEvent);
    }

    public final void x() {
        g();
        h();
    }

    public final AgentWeb y() {
        xf.c.j(this.f21742a.getApplicationContext());
        p pVarH = this.f21745d;
        if (pVarH == null) {
            pVarH = xf.a.h();
            this.f21745d = pVarH;
        }
        boolean z10 = pVarH instanceof xf.a;
        if (z10) {
            ((xf.a) pVarH).f(this);
        }
        if (this.f21754m == null && z10) {
            this.f21754m = (p0) pVarH;
        }
        pVarH.c(this.f21744c.a());
        if (this.D == null) {
            this.D = h.f(this.f21744c.a(), this.f21758q);
        }
        c0.c(E, "mJavaObjects:" + this.f21752k.size());
        androidx.collection.a<String, Object> aVar = this.f21752k;
        if (aVar != null && !aVar.isEmpty()) {
            this.D.c(this.f21752k);
        }
        p0 p0Var = this.f21754m;
        if (p0Var != null) {
            p0Var.b(this.f21744c.a(), null);
            this.f21754m.a(this.f21744c.a(), j());
            this.f21754m.e(this.f21744c.a(), u());
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgentWeb(b bVar) {
        Object[] objArr = 0;
        this.f21746e = null;
        this.f21752k = new androidx.collection.a<>();
        this.f21753l = 0;
        this.f21755n = null;
        this.f21756o = null;
        this.f21758q = SecurityType.DEFAULT_CHECK;
        this.f21759r = null;
        this.f21760s = null;
        this.f21761t = null;
        this.f21763v = null;
        this.f21764w = true;
        this.f21766y = false;
        this.f21767z = -1;
        this.D = null;
        this.f21753l = bVar.H;
        this.f21742a = bVar.f21768a;
        this.f21743b = bVar.f21770c;
        this.f21751j = bVar.f21783p;
        this.f21750i = bVar.f21775h;
        this.f21744c = bVar.f21781n == null ? e(bVar.f21773f, bVar.f21772e, bVar.f21776i, bVar.f21779l, bVar.f21784q, bVar.f21787t, bVar.f21789v) : bVar.f21781n;
        this.f21747f = bVar.f21774g;
        this.f21748g = bVar.f21778k;
        this.f21749h = bVar.f21777j;
        this.f21746e = this;
        this.f21745d = bVar.f21780m;
        if (bVar.f21785r != null && !bVar.f21785r.isEmpty()) {
            this.f21752k.putAll(bVar.f21785r);
            c0.c(E, "mJavaObject size:" + this.f21752k.size());
        }
        this.f21765x = bVar.f21790w != null ? new e(bVar.f21790w) : null;
        this.f21758q = bVar.f21786s;
        this.f21761t = new j0(this.f21744c.create().a(), bVar.f21782o);
        if (this.f21744c.c() instanceof i) {
            i iVar = (i) this.f21744c.c();
            iVar.b(bVar.f21791x == null ? xf.g.s() : bVar.f21791x);
            iVar.g(bVar.F, bVar.G);
            iVar.setErrorView(bVar.E);
        }
        this.f21762u = new xf.l(this.f21744c.a());
        this.f21755n = new k(this.f21744c.a(), this.f21746e.f21752k, this.f21758q);
        this.f21764w = bVar.f21788u;
        this.f21766y = bVar.f21793z;
        if (bVar.f21792y != null) {
            this.f21767z = bVar.f21792y.code;
        }
        this.A = bVar.A;
        this.B = bVar.C;
        x();
    }

    public static final class b {
        public e0 A;
        public e0 B;
        public View E;
        public int F;
        public int G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f21768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f21769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ViewGroup f21770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f21771d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public xf.i f21773f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public WebViewClient f21777j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public WebChromeClient f21778k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public p f21780m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public m0 f21781n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public q f21783p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public androidx.collection.a<String, Object> f21785r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public WebView f21787t;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public xf.b f21791x;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f21772e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public v f21774g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f21775h = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ViewGroup.LayoutParams f21776i = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f21779l = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public o f21782o = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f21784q = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public SecurityType f21786s = SecurityType.DEFAULT_CHECK;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f21788u = true;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public u f21789v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public g0 f21790w = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public DefaultWebClient.OpenOtherPageWays f21792y = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f21793z = false;
        public d0 C = null;
        public d0 D = null;
        public int H = 0;

        public b(@n0 Activity activity, @n0 Fragment fragment) {
            this.f21768a = activity;
            this.f21769b = fragment;
        }

        public final void h0(String str, String str2) {
            if (this.f21782o == null) {
                this.f21782o = o.b();
            }
            this.f21782o.a(str, str2);
        }

        public final void i0(String str, Object obj) {
            if (this.f21785r == null) {
                this.f21785r = new androidx.collection.a<>();
            }
            this.f21785r.put(str, obj);
        }

        public final f j0() {
            if (this.H == 1) {
                Objects.requireNonNull(this.f21770c, "ViewGroup is null,Please check your parameters .");
            }
            return new f(com.just.agentweb.f.a(new AgentWeb(this), this));
        }

        public d k0(@n0 ViewGroup viewGroup, int i10, @n0 ViewGroup.LayoutParams layoutParams) {
            this.f21770c = viewGroup;
            this.f21776i = layoutParams;
            this.f21772e = i10;
            return new d(this);
        }

        public d l0(@n0 ViewGroup viewGroup, @n0 ViewGroup.LayoutParams layoutParams) {
            this.f21770c = viewGroup;
            this.f21776i = layoutParams;
            return new d(this);
        }

        public b(@n0 Activity activity) {
            this.f21768a = activity;
        }
    }
}
