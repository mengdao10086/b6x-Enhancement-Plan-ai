package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a1 implements c0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f2338s = "ToolbarWidgetWrapper";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2339t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f2340u = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f2341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spinner f2344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f2345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f2347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f2348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f2350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f2352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Window.Callback f2353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionMenuPresenter f2355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2356p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2357q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f2358r;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m.a f2359a;

        public a() {
            this.f2359a = new m.a(a1.this.f2341a.getContext(), 0, 16908332, 0, 0, a1.this.f2350j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a1 a1Var = a1.this;
            Window.Callback callback = a1Var.f2353m;
            if (callback == null || !a1Var.f2354n) {
                return;
            }
            callback.onMenuItemSelected(0, this.f2359a);
        }
    }

    public class b extends androidx.core.view.d1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2361a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2362b;

        public b(int i10) {
            this.f2362b = i10;
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void a(View view) {
            this.f2361a = true;
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void b(View view) {
            if (this.f2361a) {
                return;
            }
            a1.this.f2341a.setVisibility(this.f2362b);
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void c(View view) {
            a1.this.f2341a.setVisibility(0);
        }
    }

    public a1(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    @Override // androidx.appcompat.widget.c0
    public boolean A() {
        return this.f2343c != null;
    }

    @Override // androidx.appcompat.widget.c0
    public int B() {
        return this.f2356p;
    }

    @Override // androidx.appcompat.widget.c0
    public void C(int i10) {
        androidx.core.view.b1 b1VarD = D(i10, 200L);
        if (b1VarD != null) {
            b1VarD.y();
        }
    }

    @Override // androidx.appcompat.widget.c0
    public androidx.core.view.b1 D(int i10, long j10) {
        return androidx.core.view.u0.g(this.f2341a).b(i10 == 0 ? 1.0f : 0.0f).s(j10).u(new b(i10));
    }

    @Override // androidx.appcompat.widget.c0
    public void E(int i10) {
        View view;
        int i11 = this.f2356p;
        if (i10 != i11) {
            if (i11 == 1) {
                Spinner spinner = this.f2344d;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f2341a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f2344d);
                    }
                }
            } else if (i11 == 2 && (view = this.f2343c) != null) {
                ViewParent parent2 = view.getParent();
                Toolbar toolbar2 = this.f2341a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f2343c);
                }
            }
            this.f2356p = i10;
            if (i10 != 0) {
                if (i10 == 1) {
                    W();
                    this.f2341a.addView(this.f2344d, 0);
                    return;
                }
                if (i10 != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i10);
                }
                View view2 = this.f2343c;
                if (view2 != null) {
                    this.f2341a.addView(view2, 0);
                    Toolbar.e eVar = (Toolbar.e) this.f2343c.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) eVar).width = -2;
                    ((ViewGroup.MarginLayoutParams) eVar).height = -2;
                    eVar.f1604a = 8388691;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void F(int i10) {
        T(i10 != 0 ? i.a.b(b(), i10) : null);
    }

    @Override // androidx.appcompat.widget.c0
    public void G(j.a aVar, e.a aVar2) {
        this.f2341a.O(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.c0
    public ViewGroup H() {
        return this.f2341a;
    }

    @Override // androidx.appcompat.widget.c0
    public void I(boolean z10) {
    }

    @Override // androidx.appcompat.widget.c0
    public void J(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        W();
        this.f2344d.setAdapter(spinnerAdapter);
        this.f2344d.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.widget.c0
    public void K(SparseArray<Parcelable> sparseArray) {
        this.f2341a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.c0
    public CharSequence L() {
        return this.f2341a.getSubtitle();
    }

    @Override // androidx.appcompat.widget.c0
    public int M() {
        return this.f2342b;
    }

    @Override // androidx.appcompat.widget.c0
    public int N() {
        Spinner spinner = this.f2344d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.c0
    public void O(int i10) {
        u(i10 == 0 ? null : b().getString(i10));
    }

    @Override // androidx.appcompat.widget.c0
    public void P(View view) {
        View view2 = this.f2345e;
        if (view2 != null && (this.f2342b & 16) != 0) {
            this.f2341a.removeView(view2);
        }
        this.f2345e = view;
        if (view == null || (this.f2342b & 16) == 0) {
            return;
        }
        this.f2341a.addView(view);
    }

    @Override // androidx.appcompat.widget.c0
    public void Q() {
    }

    @Override // androidx.appcompat.widget.c0
    public int R() {
        Spinner spinner = this.f2344d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.c0
    public void S() {
    }

    @Override // androidx.appcompat.widget.c0
    public void T(Drawable drawable) {
        this.f2348h = drawable;
        Z();
    }

    @Override // androidx.appcompat.widget.c0
    public void U(boolean z10) {
        this.f2341a.setCollapsible(z10);
    }

    public final int V() {
        if (this.f2341a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2358r = this.f2341a.getNavigationIcon();
        return 15;
    }

    public final void W() {
        if (this.f2344d == null) {
            this.f2344d = new AppCompatSpinner(b(), null, R.attr.actionDropDownStyle);
            this.f2344d.setLayoutParams(new Toolbar.e(-2, -2, 8388627));
        }
    }

    public final void X(CharSequence charSequence) {
        this.f2350j = charSequence;
        if ((this.f2342b & 8) != 0) {
            this.f2341a.setTitle(charSequence);
            if (this.f2349i) {
                androidx.core.view.u0.E1(this.f2341a.getRootView(), charSequence);
            }
        }
    }

    public final void Y() {
        if ((this.f2342b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2352l)) {
                this.f2341a.setNavigationContentDescription(this.f2357q);
            } else {
                this.f2341a.setNavigationContentDescription(this.f2352l);
            }
        }
    }

    public final void Z() {
        if ((this.f2342b & 4) == 0) {
            this.f2341a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f2341a;
        Drawable drawable = this.f2348h;
        if (drawable == null) {
            drawable = this.f2358r;
        }
        toolbar.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.c0
    public void a(Menu menu, j.a aVar) {
        if (this.f2355o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f2341a.getContext());
            this.f2355o = actionMenuPresenter;
            actionMenuPresenter.s(R.id.action_menu_presenter);
        }
        this.f2355o.h(aVar);
        this.f2341a.N((androidx.appcompat.view.menu.e) menu, this.f2355o);
    }

    public final void a0() {
        Drawable drawable;
        int i10 = this.f2342b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f2347g) == null) {
            drawable = this.f2346f;
        }
        this.f2341a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.c0
    public Context b() {
        return this.f2341a.getContext();
    }

    @Override // androidx.appcompat.widget.c0
    public void c(Drawable drawable) {
        androidx.core.view.u0.I1(this.f2341a, drawable);
    }

    @Override // androidx.appcompat.widget.c0
    public void collapseActionView() {
        this.f2341a.e();
    }

    @Override // androidx.appcompat.widget.c0
    public int d() {
        return this.f2341a.getVisibility();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean e() {
        return this.f2341a.B();
    }

    @Override // androidx.appcompat.widget.c0
    public void f() {
        this.f2354n = true;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean g() {
        return this.f2346f != null;
    }

    @Override // androidx.appcompat.widget.c0
    public int getHeight() {
        return this.f2341a.getHeight();
    }

    @Override // androidx.appcompat.widget.c0
    public CharSequence getTitle() {
        return this.f2341a.getTitle();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean h() {
        return this.f2341a.d();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean i() {
        return this.f2347g != null;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean j() {
        return this.f2341a.A();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean k() {
        return this.f2341a.x();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean l() {
        return this.f2341a.U();
    }

    @Override // androidx.appcompat.widget.c0
    public void m(int i10) {
        if (i10 == this.f2357q) {
            return;
        }
        this.f2357q = i10;
        if (TextUtils.isEmpty(this.f2341a.getNavigationContentDescription())) {
            O(this.f2357q);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void n() {
        this.f2341a.f();
    }

    @Override // androidx.appcompat.widget.c0
    public View o() {
        return this.f2345e;
    }

    @Override // androidx.appcompat.widget.c0
    public void p(q0 q0Var) {
        View view = this.f2343c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2341a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2343c);
            }
        }
        this.f2343c = q0Var;
        if (q0Var == null || this.f2356p != 2) {
            return;
        }
        this.f2341a.addView(q0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f2343c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f1604a = 8388691;
        q0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.c0
    public void q(Drawable drawable) {
        this.f2347g = drawable;
        a0();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean r() {
        return this.f2341a.w();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean s() {
        return this.f2341a.C();
    }

    @Override // androidx.appcompat.widget.c0
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? i.a.b(b(), i10) : null);
    }

    @Override // androidx.appcompat.widget.c0
    public void setLogo(int i10) {
        q(i10 != 0 ? i.a.b(b(), i10) : null);
    }

    @Override // androidx.appcompat.widget.c0
    public void setTitle(CharSequence charSequence) {
        this.f2349i = true;
        X(charSequence);
    }

    @Override // androidx.appcompat.widget.c0
    public void setVisibility(int i10) {
        this.f2341a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowCallback(Window.Callback callback) {
        this.f2353m = callback;
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2349i) {
            return;
        }
        X(charSequence);
    }

    @Override // androidx.appcompat.widget.c0
    public void t(int i10) {
        View view;
        int i11 = this.f2342b ^ i10;
        this.f2342b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    Y();
                }
                Z();
            }
            if ((i11 & 3) != 0) {
                a0();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f2341a.setTitle(this.f2350j);
                    this.f2341a.setSubtitle(this.f2351k);
                } else {
                    this.f2341a.setTitle((CharSequence) null);
                    this.f2341a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f2345e) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f2341a.addView(view);
            } else {
                this.f2341a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void u(CharSequence charSequence) {
        this.f2352l = charSequence;
        Y();
    }

    @Override // androidx.appcompat.widget.c0
    public void v(CharSequence charSequence) {
        this.f2351k = charSequence;
        if ((this.f2342b & 8) != 0) {
            this.f2341a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void w(Drawable drawable) {
        if (this.f2358r != drawable) {
            this.f2358r = drawable;
            Z();
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void x(SparseArray<Parcelable> sparseArray) {
        this.f2341a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.c0
    public void y(int i10) {
        Spinner spinner = this.f2344d;
        if (spinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        spinner.setSelection(i10);
    }

    @Override // androidx.appcompat.widget.c0
    public Menu z() {
        return this.f2341a.getMenu();
    }

    public a1(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f2356p = 0;
        this.f2357q = 0;
        this.f2341a = toolbar;
        this.f2350j = toolbar.getTitle();
        this.f2351k = toolbar.getSubtitle();
        this.f2349i = this.f2350j != null;
        this.f2348h = toolbar.getNavigationIcon();
        y0 y0VarG = y0.G(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f2358r = y0VarG.h(R.styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence charSequenceX = y0VarG.x(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceX)) {
                setTitle(charSequenceX);
            }
            CharSequence charSequenceX2 = y0VarG.x(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceX2)) {
                v(charSequenceX2);
            }
            Drawable drawableH = y0VarG.h(R.styleable.ActionBar_logo);
            if (drawableH != null) {
                q(drawableH);
            }
            Drawable drawableH2 = y0VarG.h(R.styleable.ActionBar_icon);
            if (drawableH2 != null) {
                setIcon(drawableH2);
            }
            if (this.f2348h == null && (drawable = this.f2358r) != null) {
                T(drawable);
            }
            t(y0VarG.o(R.styleable.ActionBar_displayOptions, 0));
            int iU = y0VarG.u(R.styleable.ActionBar_customNavigationLayout, 0);
            if (iU != 0) {
                P(LayoutInflater.from(this.f2341a.getContext()).inflate(iU, (ViewGroup) this.f2341a, false));
                t(this.f2342b | 16);
            }
            int iQ = y0VarG.q(R.styleable.ActionBar_height, 0);
            if (iQ > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2341a.getLayoutParams();
                layoutParams.height = iQ;
                this.f2341a.setLayoutParams(layoutParams);
            }
            int iF = y0VarG.f(R.styleable.ActionBar_contentInsetStart, -1);
            int iF2 = y0VarG.f(R.styleable.ActionBar_contentInsetEnd, -1);
            if (iF >= 0 || iF2 >= 0) {
                this.f2341a.M(Math.max(iF, 0), Math.max(iF2, 0));
            }
            int iU2 = y0VarG.u(R.styleable.ActionBar_titleTextStyle, 0);
            if (iU2 != 0) {
                Toolbar toolbar2 = this.f2341a;
                toolbar2.R(toolbar2.getContext(), iU2);
            }
            int iU3 = y0VarG.u(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iU3 != 0) {
                Toolbar toolbar3 = this.f2341a;
                toolbar3.P(toolbar3.getContext(), iU3);
            }
            int iU4 = y0VarG.u(R.styleable.ActionBar_popupTheme, 0);
            if (iU4 != 0) {
                this.f2341a.setPopupTheme(iU4);
            }
        } else {
            this.f2342b = V();
        }
        y0VarG.I();
        m(i10);
        this.f2352l = this.f2341a.getNavigationContentDescription();
        this.f2341a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.c0
    public void setIcon(Drawable drawable) {
        this.f2346f = drawable;
        a0();
    }
}
