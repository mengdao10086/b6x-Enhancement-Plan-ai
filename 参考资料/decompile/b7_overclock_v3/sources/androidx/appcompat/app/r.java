package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.q0;
import androidx.core.view.b1;
import androidx.core.view.c1;
import androidx.core.view.d1;
import androidx.core.view.e1;
import androidx.core.view.u0;
import androidx.fragment.app.g0;
import com.blankj.utilcode.util.i0;
import g.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class r extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    public static final String N = "WindowDecorActionBar";
    public static final Interpolator O = new AccelerateInterpolator();
    public static final Interpolator P = new DecelerateInterpolator();
    public static final int Q = -1;
    public static final long R = 100;
    public static final long S = 200;
    public boolean A;
    public boolean D;
    public boolean E;
    public boolean F;
    public l.h H;
    public boolean I;
    public boolean J;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f1720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f1721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Activity f1722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ActionBarOverlayLayout f1723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ActionBarContainer f1724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c0 f1725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionBarContextView f1726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public q0 f1728q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f1730s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d f1733v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public l.b f1734w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b.a f1735x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1736y;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<e> f1729r = new ArrayList<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1731t = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList<a.d> f1737z = new ArrayList<>();
    public int B = 0;
    public boolean C = true;
    public boolean G = true;
    public final c1 K = new a();
    public final c1 L = new b();
    public final e1 M = new c();

    public class a extends d1 {
        public a() {
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void b(View view) {
            View view2;
            r rVar = r.this;
            if (rVar.C && (view2 = rVar.f1727p) != null) {
                view2.setTranslationY(0.0f);
                r.this.f1724m.setTranslationY(0.0f);
            }
            r.this.f1724m.setVisibility(8);
            r.this.f1724m.setTransitioning(false);
            r rVar2 = r.this;
            rVar2.H = null;
            rVar2.H0();
            ActionBarOverlayLayout actionBarOverlayLayout = r.this.f1723l;
            if (actionBarOverlayLayout != null) {
                u0.v1(actionBarOverlayLayout);
            }
        }
    }

    public class b extends d1 {
        public b() {
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void b(View view) {
            r rVar = r.this;
            rVar.H = null;
            rVar.f1724m.requestLayout();
        }
    }

    public class c implements e1 {
        public c() {
        }

        @Override // androidx.core.view.e1
        public void a(View view) {
            ((View) r.this.f1724m.getParent()).invalidate();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class d extends l.b implements e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f1741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f1742d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b.a f1743e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WeakReference<View> f1744f;

        public d(Context context, b.a aVar) {
            this.f1741c = context;
            this.f1743e = aVar;
            androidx.appcompat.view.menu.e eVarZ = new androidx.appcompat.view.menu.e(context).Z(1);
            this.f1742d = eVarZ;
            eVarZ.X(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
            b.a aVar = this.f1743e;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@n0 androidx.appcompat.view.menu.e eVar) {
            if (this.f1743e == null) {
                return;
            }
            k();
            r.this.f1726o.o();
        }

        @Override // l.b
        public void c() {
            r rVar = r.this;
            if (rVar.f1733v != this) {
                return;
            }
            if (r.F0(rVar.D, rVar.E, false)) {
                this.f1743e.c(this);
            } else {
                r rVar2 = r.this;
                rVar2.f1734w = this;
                rVar2.f1735x = this.f1743e;
            }
            this.f1743e = null;
            r.this.E0(false);
            r.this.f1726o.p();
            r rVar3 = r.this;
            rVar3.f1723l.setHideOnContentScrollEnabled(rVar3.J);
            r.this.f1733v = null;
        }

        @Override // l.b
        public View d() {
            WeakReference<View> weakReference = this.f1744f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // l.b
        public Menu e() {
            return this.f1742d;
        }

        @Override // l.b
        public MenuInflater f() {
            return new l.g(this.f1741c);
        }

        @Override // l.b
        public CharSequence g() {
            return r.this.f1726o.getSubtitle();
        }

        @Override // l.b
        public CharSequence i() {
            return r.this.f1726o.getTitle();
        }

        @Override // l.b
        public void k() {
            if (r.this.f1733v != this) {
                return;
            }
            this.f1742d.m0();
            try {
                this.f1743e.b(this, this.f1742d);
            } finally {
                this.f1742d.l0();
            }
        }

        @Override // l.b
        public boolean l() {
            return r.this.f1726o.s();
        }

        @Override // l.b
        public void n(View view) {
            r.this.f1726o.setCustomView(view);
            this.f1744f = new WeakReference<>(view);
        }

        @Override // l.b
        public void o(int i10) {
            p(r.this.f1720i.getResources().getString(i10));
        }

        @Override // l.b
        public void p(CharSequence charSequence) {
            r.this.f1726o.setSubtitle(charSequence);
        }

        @Override // l.b
        public void r(int i10) {
            s(r.this.f1720i.getResources().getString(i10));
        }

        @Override // l.b
        public void s(CharSequence charSequence) {
            r.this.f1726o.setTitle(charSequence);
        }

        @Override // l.b
        public void t(boolean z10) {
            super.t(z10);
            r.this.f1726o.setTitleOptional(z10);
        }

        public boolean u() {
            this.f1742d.m0();
            try {
                return this.f1743e.a(this, this.f1742d);
            } finally {
                this.f1742d.l0();
            }
        }

        public void v(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        public void w(androidx.appcompat.view.menu.m mVar) {
        }

        public boolean x(androidx.appcompat.view.menu.m mVar) {
            if (this.f1743e == null) {
                return false;
            }
            if (!mVar.hasVisibleItems()) {
                return true;
            }
            new androidx.appcompat.view.menu.i(r.this.A(), mVar).l();
            return true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class e extends a.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a.g f1746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f1747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f1748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f1749e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f1750f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1751g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f1752h;

        public e() {
        }

        @Override // androidx.appcompat.app.a.f
        public CharSequence a() {
            return this.f1750f;
        }

        @Override // androidx.appcompat.app.a.f
        public View b() {
            return this.f1752h;
        }

        @Override // androidx.appcompat.app.a.f
        public Drawable c() {
            return this.f1748d;
        }

        @Override // androidx.appcompat.app.a.f
        public int d() {
            return this.f1751g;
        }

        @Override // androidx.appcompat.app.a.f
        public Object e() {
            return this.f1747c;
        }

        @Override // androidx.appcompat.app.a.f
        public CharSequence f() {
            return this.f1749e;
        }

        @Override // androidx.appcompat.app.a.f
        public void g() {
            r.this.S(this);
        }

        @Override // androidx.appcompat.app.a.f
        public a.f h(int i10) {
            return i(r.this.f1720i.getResources().getText(i10));
        }

        @Override // androidx.appcompat.app.a.f
        public a.f i(CharSequence charSequence) {
            this.f1750f = charSequence;
            int i10 = this.f1751g;
            if (i10 >= 0) {
                r.this.f1728q.m(i10);
            }
            return this;
        }

        @Override // androidx.appcompat.app.a.f
        public a.f j(int i10) {
            return k(LayoutInflater.from(r.this.A()).inflate(i10, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.a.f
        public a.f k(View view) {
            this.f1752h = view;
            int i10 = this.f1751g;
            if (i10 >= 0) {
                r.this.f1728q.m(i10);
            }
            return this;
        }

        @Override // androidx.appcompat.app.a.f
        public a.f l(int i10) {
            return m(i.a.b(r.this.f1720i, i10));
        }

        @Override // androidx.appcompat.app.a.f
        public a.f m(Drawable drawable) {
            this.f1748d = drawable;
            int i10 = this.f1751g;
            if (i10 >= 0) {
                r.this.f1728q.m(i10);
            }
            return this;
        }

        @Override // androidx.appcompat.app.a.f
        public a.f n(a.g gVar) {
            this.f1746b = gVar;
            return this;
        }

        @Override // androidx.appcompat.app.a.f
        public a.f o(Object obj) {
            this.f1747c = obj;
            return this;
        }

        @Override // androidx.appcompat.app.a.f
        public a.f p(int i10) {
            return q(r.this.f1720i.getResources().getText(i10));
        }

        @Override // androidx.appcompat.app.a.f
        public a.f q(CharSequence charSequence) {
            this.f1749e = charSequence;
            int i10 = this.f1751g;
            if (i10 >= 0) {
                r.this.f1728q.m(i10);
            }
            return this;
        }

        public a.g r() {
            return this.f1746b;
        }

        public void s(int i10) {
            this.f1751g = i10;
        }
    }

    public r(Activity activity, boolean z10) {
        this.f1722k = activity;
        View decorView = activity.getWindow().getDecorView();
        Q0(decorView);
        if (z10) {
            return;
        }
        this.f1727p = decorView.findViewById(R.id.content);
    }

    public static boolean F0(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    @Override // androidx.appcompat.app.a
    public Context A() {
        if (this.f1721j == null) {
            TypedValue typedValue = new TypedValue();
            this.f1720i.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f1721j = new ContextThemeWrapper(this.f1720i, i10);
            } else {
                this.f1721j = this.f1720i;
            }
        }
        return this.f1721j;
    }

    @Override // androidx.appcompat.app.a
    public void A0(CharSequence charSequence) {
        this.f1725n.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public CharSequence B() {
        return this.f1725n.getTitle();
    }

    @Override // androidx.appcompat.app.a
    public void B0(CharSequence charSequence) {
        this.f1725n.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void C() {
        if (this.D) {
            return;
        }
        this.D = true;
        U0(false);
    }

    @Override // androidx.appcompat.app.a
    public void C0() {
        if (this.D) {
            this.D = false;
            U0(false);
        }
    }

    @Override // androidx.appcompat.app.a
    public l.b D0(b.a aVar) {
        d dVar = this.f1733v;
        if (dVar != null) {
            dVar.c();
        }
        this.f1723l.setHideOnContentScrollEnabled(false);
        this.f1726o.t();
        d dVar2 = new d(this.f1726o.getContext(), aVar);
        if (!dVar2.u()) {
            return null;
        }
        this.f1733v = dVar2;
        dVar2.k();
        this.f1726o.q(dVar2);
        E0(true);
        return dVar2;
    }

    @Override // androidx.appcompat.app.a
    public boolean E() {
        return this.f1723l.u();
    }

    public void E0(boolean z10) {
        b1 b1VarD;
        b1 b1VarN;
        if (z10) {
            T0();
        } else {
            P0();
        }
        if (!S0()) {
            if (z10) {
                this.f1725n.setVisibility(4);
                this.f1726o.setVisibility(0);
                return;
            } else {
                this.f1725n.setVisibility(0);
                this.f1726o.setVisibility(8);
                return;
            }
        }
        if (z10) {
            b1VarN = this.f1725n.D(4, 100L);
            b1VarD = this.f1726o.n(0, 200L);
        } else {
            b1VarD = this.f1725n.D(0, 200L);
            b1VarN = this.f1726o.n(8, 100L);
        }
        l.h hVar = new l.h();
        hVar.d(b1VarN, b1VarD);
        hVar.h();
    }

    @Override // androidx.appcompat.app.a
    public boolean F() {
        int iR = r();
        return this.G && (iR == 0 || s() < iR);
    }

    @Override // androidx.appcompat.app.a
    public boolean G() {
        c0 c0Var = this.f1725n;
        return c0Var != null && c0Var.s();
    }

    public final void G0() {
        if (this.f1730s != null) {
            S(null);
        }
        this.f1729r.clear();
        q0 q0Var = this.f1728q;
        if (q0Var != null) {
            q0Var.k();
        }
        this.f1731t = -1;
    }

    @Override // androidx.appcompat.app.a
    public a.f H() {
        return new e();
    }

    public void H0() {
        b.a aVar = this.f1735x;
        if (aVar != null) {
            aVar.c(this.f1734w);
            this.f1734w = null;
            this.f1735x = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public void I(Configuration configuration) {
        R0(l.a.b(this.f1720i).g());
    }

    public final void I0(a.f fVar, int i10) {
        e eVar = (e) fVar;
        if (eVar.r() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        eVar.s(i10);
        this.f1729r.add(i10, eVar);
        int size = this.f1729r.size();
        while (true) {
            i10++;
            if (i10 >= size) {
                return;
            } else {
                this.f1729r.get(i10).s(i10);
            }
        }
    }

    public void J0(boolean z10) {
        View view;
        l.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
        }
        if (this.B != 0 || (!this.I && !z10)) {
            this.K.b(null);
            return;
        }
        this.f1724m.setAlpha(1.0f);
        this.f1724m.setTransitioning(true);
        l.h hVar2 = new l.h();
        float f10 = -this.f1724m.getHeight();
        if (z10) {
            this.f1724m.getLocationInWindow(new int[]{0, 0});
            f10 -= r5[1];
        }
        b1 b1VarB = u0.g(this.f1724m).B(f10);
        b1VarB.x(this.M);
        hVar2.c(b1VarB);
        if (this.C && (view = this.f1727p) != null) {
            hVar2.c(u0.g(view).B(f10));
        }
        hVar2.f(O);
        hVar2.e(250L);
        hVar2.g(this.K);
        this.H = hVar2;
        hVar2.h();
    }

    @Override // androidx.appcompat.app.a
    public boolean K(int i10, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f1733v;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i10, keyEvent, 0);
    }

    public void K0(boolean z10) {
        View view;
        View view2;
        l.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
        }
        this.f1724m.setVisibility(0);
        if (this.B == 0 && (this.I || z10)) {
            this.f1724m.setTranslationY(0.0f);
            float f10 = -this.f1724m.getHeight();
            if (z10) {
                this.f1724m.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f1724m.setTranslationY(f10);
            l.h hVar2 = new l.h();
            b1 b1VarB = u0.g(this.f1724m).B(0.0f);
            b1VarB.x(this.M);
            hVar2.c(b1VarB);
            if (this.C && (view2 = this.f1727p) != null) {
                view2.setTranslationY(f10);
                hVar2.c(u0.g(this.f1727p).B(0.0f));
            }
            hVar2.f(P);
            hVar2.e(250L);
            hVar2.g(this.L);
            this.H = hVar2;
            hVar2.h();
        } else {
            this.f1724m.setAlpha(1.0f);
            this.f1724m.setTranslationY(0.0f);
            if (this.C && (view = this.f1727p) != null) {
                view.setTranslationY(0.0f);
            }
            this.L.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1723l;
        if (actionBarOverlayLayout != null) {
            u0.v1(actionBarOverlayLayout);
        }
    }

    public final void L0() {
        if (this.f1728q != null) {
            return;
        }
        q0 q0Var = new q0(this.f1720i);
        if (this.A) {
            q0Var.setVisibility(0);
            this.f1725n.p(q0Var);
        } else {
            if (u() == 2) {
                q0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1723l;
                if (actionBarOverlayLayout != null) {
                    u0.v1(actionBarOverlayLayout);
                }
            } else {
                q0Var.setVisibility(8);
            }
            this.f1724m.setTabContainer(q0Var);
        }
        this.f1728q = q0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c0 M0(View view) {
        if (view instanceof c0) {
            return (c0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : i0.f11859x);
        throw new IllegalStateException(sb2.toString());
    }

    @Override // androidx.appcompat.app.a
    public void N() {
        G0();
    }

    public boolean N0() {
        return this.f1725n.g();
    }

    @Override // androidx.appcompat.app.a
    public void O(a.d dVar) {
        this.f1737z.remove(dVar);
    }

    public boolean O0() {
        return this.f1725n.i();
    }

    @Override // androidx.appcompat.app.a
    public void P(a.f fVar) {
        Q(fVar.d());
    }

    public final void P0() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1723l;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            U0(false);
        }
    }

    @Override // androidx.appcompat.app.a
    public void Q(int i10) {
        if (this.f1728q == null) {
            return;
        }
        e eVar = this.f1730s;
        int iD = eVar != null ? eVar.d() : this.f1731t;
        this.f1728q.l(i10);
        e eVarRemove = this.f1729r.remove(i10);
        if (eVarRemove != null) {
            eVarRemove.s(-1);
        }
        int size = this.f1729r.size();
        for (int i11 = i10; i11 < size; i11++) {
            this.f1729r.get(i11).s(i11);
        }
        if (iD == i10) {
            S(this.f1729r.isEmpty() ? null : this.f1729r.get(Math.max(0, i10 - 1)));
        }
    }

    public final void Q0(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f1723l = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1725n = M0(view.findViewById(androidx.appcompat.R.id.action_bar));
        this.f1726o = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f1724m = actionBarContainer;
        c0 c0Var = this.f1725n;
        if (c0Var == null || this.f1726o == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1720i = c0Var.b();
        boolean z10 = (this.f1725n.M() & 4) != 0;
        if (z10) {
            this.f1732u = true;
        }
        l.a aVarB = l.a.b(this.f1720i);
        m0(aVarB.a() || z10);
        R0(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f1720i.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            h0(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            f0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.app.a
    public boolean R() {
        ViewGroup viewGroupH = this.f1725n.H();
        if (viewGroupH == null || viewGroupH.hasFocus()) {
            return false;
        }
        viewGroupH.requestFocus();
        return true;
    }

    public final void R0(boolean z10) {
        this.A = z10;
        if (z10) {
            this.f1724m.setTabContainer(null);
            this.f1725n.p(this.f1728q);
        } else {
            this.f1725n.p(null);
            this.f1724m.setTabContainer(this.f1728q);
        }
        boolean z11 = u() == 2;
        q0 q0Var = this.f1728q;
        if (q0Var != null) {
            if (z11) {
                q0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1723l;
                if (actionBarOverlayLayout != null) {
                    u0.v1(actionBarOverlayLayout);
                }
            } else {
                q0Var.setVisibility(8);
            }
        }
        this.f1725n.U(!this.A && z11);
        this.f1723l.setHasNonEmbeddedTabs(!this.A && z11);
    }

    @Override // androidx.appcompat.app.a
    public void S(a.f fVar) {
        if (u() != 2) {
            this.f1731t = fVar != null ? fVar.d() : -1;
            return;
        }
        g0 g0VarW = (!(this.f1722k instanceof androidx.fragment.app.g) || this.f1725n.H().isInEditMode()) ? null : ((androidx.fragment.app.g) this.f1722k).n3().u().w();
        e eVar = this.f1730s;
        if (eVar != fVar) {
            this.f1728q.setTabSelected(fVar != null ? fVar.d() : -1);
            e eVar2 = this.f1730s;
            if (eVar2 != null) {
                eVar2.r().b(this.f1730s, g0VarW);
            }
            e eVar3 = (e) fVar;
            this.f1730s = eVar3;
            if (eVar3 != null) {
                eVar3.r().a(this.f1730s, g0VarW);
            }
        } else if (eVar != null) {
            eVar.r().c(this.f1730s, g0VarW);
            this.f1728q.c(fVar.d());
        }
        if (g0VarW == null || g0VarW.A()) {
            return;
        }
        g0VarW.q();
    }

    public final boolean S0() {
        return u0.U0(this.f1724m);
    }

    @Override // androidx.appcompat.app.a
    public void T(Drawable drawable) {
        this.f1724m.setPrimaryBackground(drawable);
    }

    public final void T0() {
        if (this.F) {
            return;
        }
        this.F = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1723l;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        U0(false);
    }

    @Override // androidx.appcompat.app.a
    public void U(int i10) {
        V(LayoutInflater.from(A()).inflate(i10, this.f1725n.H(), false));
    }

    public final void U0(boolean z10) {
        if (F0(this.D, this.E, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            K0(z10);
            return;
        }
        if (this.G) {
            this.G = false;
            J0(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void V(View view) {
        this.f1725n.P(view);
    }

    @Override // androidx.appcompat.app.a
    public void W(View view, a.b bVar) {
        view.setLayoutParams(bVar);
        this.f1725n.P(view);
    }

    @Override // androidx.appcompat.app.a
    public void X(boolean z10) {
        if (this.f1732u) {
            return;
        }
        Y(z10);
    }

    @Override // androidx.appcompat.app.a
    public void Y(boolean z10) {
        a0(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void Z(int i10) {
        if ((i10 & 4) != 0) {
            this.f1732u = true;
        }
        this.f1725n.t(i10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.E) {
            this.E = false;
            U0(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public void a0(int i10, int i11) {
        int iM = this.f1725n.M();
        if ((i11 & 4) != 0) {
            this.f1732u = true;
        }
        this.f1725n.t((i10 & i11) | ((~i11) & iM));
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.app.a
    public void b0(boolean z10) {
        a0(z10 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z10) {
        this.C = z10;
    }

    @Override // androidx.appcompat.app.a
    public void c0(boolean z10) {
        a0(z10 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.E) {
            return;
        }
        this.E = true;
        U0(true);
    }

    @Override // androidx.appcompat.app.a
    public void d0(boolean z10) {
        a0(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        l.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
            this.H = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public void e0(boolean z10) {
        a0(z10 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i10) {
        this.B = i10;
    }

    @Override // androidx.appcompat.app.a
    public void f0(float f10) {
        u0.N1(this.f1724m, f10);
    }

    @Override // androidx.appcompat.app.a
    public void g(a.d dVar) {
        this.f1737z.add(dVar);
    }

    @Override // androidx.appcompat.app.a
    public void g0(int i10) {
        if (i10 != 0 && !this.f1723l.v()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.f1723l.setActionBarHideOffset(i10);
    }

    @Override // androidx.appcompat.app.a
    public void h(a.f fVar) {
        k(fVar, this.f1729r.isEmpty());
    }

    @Override // androidx.appcompat.app.a
    public void h0(boolean z10) {
        if (z10 && !this.f1723l.v()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.J = z10;
        this.f1723l.setHideOnContentScrollEnabled(z10);
    }

    @Override // androidx.appcompat.app.a
    public void i(a.f fVar, int i10) {
        j(fVar, i10, this.f1729r.isEmpty());
    }

    @Override // androidx.appcompat.app.a
    public void i0(int i10) {
        this.f1725n.O(i10);
    }

    @Override // androidx.appcompat.app.a
    public void j(a.f fVar, int i10, boolean z10) {
        L0();
        this.f1728q.a(fVar, i10, z10);
        I0(fVar, i10);
        if (z10) {
            S(fVar);
        }
    }

    @Override // androidx.appcompat.app.a
    public void j0(CharSequence charSequence) {
        this.f1725n.u(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void k(a.f fVar, boolean z10) {
        L0();
        this.f1728q.b(fVar, z10);
        I0(fVar, this.f1729r.size());
        if (z10) {
            S(fVar);
        }
    }

    @Override // androidx.appcompat.app.a
    public void k0(int i10) {
        this.f1725n.F(i10);
    }

    @Override // androidx.appcompat.app.a
    public void l0(Drawable drawable) {
        this.f1725n.T(drawable);
    }

    @Override // androidx.appcompat.app.a
    public boolean m() {
        c0 c0Var = this.f1725n;
        if (c0Var == null || !c0Var.r()) {
            return false;
        }
        this.f1725n.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m0(boolean z10) {
        this.f1725n.I(z10);
    }

    @Override // androidx.appcompat.app.a
    public void n(boolean z10) {
        if (z10 == this.f1736y) {
            return;
        }
        this.f1736y = z10;
        int size = this.f1737z.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1737z.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void n0(int i10) {
        this.f1725n.setIcon(i10);
    }

    @Override // androidx.appcompat.app.a
    public View o() {
        return this.f1725n.o();
    }

    @Override // androidx.appcompat.app.a
    public void o0(Drawable drawable) {
        this.f1725n.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.a
    public int p() {
        return this.f1725n.M();
    }

    @Override // androidx.appcompat.app.a
    public void p0(SpinnerAdapter spinnerAdapter, a.e eVar) {
        this.f1725n.J(spinnerAdapter, new m(eVar));
    }

    @Override // androidx.appcompat.app.a
    public float q() {
        return u0.R(this.f1724m);
    }

    @Override // androidx.appcompat.app.a
    public void q0(int i10) {
        this.f1725n.setLogo(i10);
    }

    @Override // androidx.appcompat.app.a
    public int r() {
        return this.f1724m.getHeight();
    }

    @Override // androidx.appcompat.app.a
    public void r0(Drawable drawable) {
        this.f1725n.q(drawable);
    }

    @Override // androidx.appcompat.app.a
    public int s() {
        return this.f1723l.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.a
    public void s0(int i10) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int iB = this.f1725n.B();
        if (iB == 2) {
            this.f1731t = v();
            S(null);
            this.f1728q.setVisibility(8);
        }
        if (iB != i10 && !this.A && (actionBarOverlayLayout = this.f1723l) != null) {
            u0.v1(actionBarOverlayLayout);
        }
        this.f1725n.E(i10);
        boolean z10 = false;
        if (i10 == 2) {
            L0();
            this.f1728q.setVisibility(0);
            int i11 = this.f1731t;
            if (i11 != -1) {
                t0(i11);
                this.f1731t = -1;
            }
        }
        this.f1725n.U(i10 == 2 && !this.A);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f1723l;
        if (i10 == 2 && !this.A) {
            z10 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z10);
    }

    @Override // androidx.appcompat.app.a
    public int t() {
        int iB = this.f1725n.B();
        if (iB == 1) {
            return this.f1725n.R();
        }
        if (iB != 2) {
            return 0;
        }
        return this.f1729r.size();
    }

    @Override // androidx.appcompat.app.a
    public void t0(int i10) {
        int iB = this.f1725n.B();
        if (iB == 1) {
            this.f1725n.y(i10);
        } else {
            if (iB != 2) {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            S(this.f1729r.get(i10));
        }
    }

    @Override // androidx.appcompat.app.a
    public int u() {
        return this.f1725n.B();
    }

    @Override // androidx.appcompat.app.a
    public void u0(boolean z10) {
        l.h hVar;
        this.I = z10;
        if (z10 || (hVar = this.H) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public int v() {
        e eVar;
        int iB = this.f1725n.B();
        if (iB == 1) {
            return this.f1725n.N();
        }
        if (iB == 2 && (eVar = this.f1730s) != null) {
            return eVar.d();
        }
        return -1;
    }

    @Override // androidx.appcompat.app.a
    public void v0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.a
    public a.f w() {
        return this.f1730s;
    }

    @Override // androidx.appcompat.app.a
    public void w0(Drawable drawable) {
        this.f1724m.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.a
    public CharSequence x() {
        return this.f1725n.L();
    }

    @Override // androidx.appcompat.app.a
    public void x0(int i10) {
        y0(this.f1720i.getString(i10));
    }

    @Override // androidx.appcompat.app.a
    public a.f y(int i10) {
        return this.f1729r.get(i10);
    }

    @Override // androidx.appcompat.app.a
    public void y0(CharSequence charSequence) {
        this.f1725n.v(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public int z() {
        return this.f1729r.size();
    }

    @Override // androidx.appcompat.app.a
    public void z0(int i10) {
        A0(this.f1720i.getString(i10));
    }

    public r(Dialog dialog) {
        Q0(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public r(View view) {
        Q0(view);
    }
}
