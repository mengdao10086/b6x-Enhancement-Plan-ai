package a;

import a.i4;
import a.v4;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s8 implements d7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n5 f2848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f2849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Window.Callback f2851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Toolbar f2852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2854a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f2855b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f2856b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f2857b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2858b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f2859c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f2860c;
    public Drawable d;

    public s8(Toolbar toolbar, boolean z) {
        this(toolbar, z, a0.abc_action_bar_up_description, x.abc_ic_ab_back_material);
    }

    public s8(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.b = 0;
        this.c = 0;
        this.f2852a = toolbar;
        this.f2853a = toolbar.getTitle();
        this.f2857b = toolbar.getSubtitle();
        this.f2854a = this.f2853a != null;
        this.f2859c = toolbar.getNavigationIcon();
        o8 o8VarV = o8.v(toolbar.getContext(), null, c0.ActionBar, t.actionBarStyle, 0);
        this.d = o8VarV.g(c0.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceP = o8VarV.p(c0.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                J(charSequenceP);
            }
            CharSequence charSequenceP2 = o8VarV.p(c0.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                I(charSequenceP2);
            }
            Drawable drawableG = o8VarV.g(c0.ActionBar_logo);
            if (drawableG != null) {
                E(drawableG);
            }
            Drawable drawableG2 = o8VarV.g(c0.ActionBar_icon);
            if (drawableG2 != null) {
                v(drawableG2);
            }
            if (this.f2859c == null && (drawable = this.d) != null) {
                H(drawable);
            }
            l(o8VarV.k(c0.ActionBar_displayOptions, 0));
            int iN = o8VarV.n(c0.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                C(LayoutInflater.from(this.f2852a.getContext()).inflate(iN, (ViewGroup) this.f2852a, false));
                l(this.f7372a | 16);
            }
            int iM = o8VarV.m(c0.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2852a.getLayoutParams();
                layoutParams.height = iM;
                this.f2852a.setLayoutParams(layoutParams);
            }
            int iE = o8VarV.e(c0.ActionBar_contentInsetStart, -1);
            int iE2 = o8VarV.e(c0.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f2852a.H(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = o8VarV.n(c0.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f2852a;
                toolbar2.L(toolbar2.getContext(), iN2);
            }
            int iN3 = o8VarV.n(c0.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f2852a;
                toolbar3.K(toolbar3.getContext(), iN3);
            }
            int iN4 = o8VarV.n(c0.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.f2852a.setPopupTheme(iN4);
            }
        } else {
            this.f7372a = B();
        }
        o8VarV.w();
        D(i);
        this.f2860c = this.f2852a.getNavigationContentDescription();
        this.f2852a.setNavigationOnClickListener(new q8(this));
    }

    @Override // a.d7
    public void A(g8 g8Var) {
        View view = this.f2850a;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2852a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2850a);
            }
        }
        this.f2850a = g8Var;
        if (g8Var == null || this.b != 2) {
            return;
        }
        this.f2852a.addView(g8Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f2850a.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f5842a = 8388691;
        g8Var.setAllowCollapse(true);
    }

    public final int B() {
        if (this.f2852a.getNavigationIcon() == null) {
            return 11;
        }
        this.d = this.f2852a.getNavigationIcon();
        return 15;
    }

    public void C(View view) {
        View view2 = this.f2856b;
        if (view2 != null && (this.f7372a & 16) != 0) {
            this.f2852a.removeView(view2);
        }
        this.f2856b = view;
        if (view == null || (this.f7372a & 16) == 0) {
            return;
        }
        this.f2852a.addView(view);
    }

    public void D(int i) {
        if (i == this.c) {
            return;
        }
        this.c = i;
        if (TextUtils.isEmpty(this.f2852a.getNavigationContentDescription())) {
            F(this.c);
        }
    }

    public void E(Drawable drawable) {
        this.f2855b = drawable;
        N();
    }

    public void F(int i) {
        G(i == 0 ? null : x().getString(i));
    }

    public void G(CharSequence charSequence) {
        this.f2860c = charSequence;
        L();
    }

    public void H(Drawable drawable) {
        this.f2859c = drawable;
        M();
    }

    public void I(CharSequence charSequence) {
        this.f2857b = charSequence;
        if ((this.f7372a & 8) != 0) {
            this.f2852a.setSubtitle(charSequence);
        }
    }

    public void J(CharSequence charSequence) {
        this.f2854a = true;
        K(charSequence);
    }

    public final void K(CharSequence charSequence) {
        this.f2853a = charSequence;
        if ((this.f7372a & 8) != 0) {
            this.f2852a.setTitle(charSequence);
        }
    }

    public final void L() {
        if ((this.f7372a & 4) != 0) {
            if (TextUtils.isEmpty(this.f2860c)) {
                this.f2852a.setNavigationContentDescription(this.c);
            } else {
                this.f2852a.setNavigationContentDescription(this.f2860c);
            }
        }
    }

    public final void M() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f7372a & 4) != 0) {
            toolbar = this.f2852a;
            drawable = this.f2859c;
            if (drawable == null) {
                drawable = this.d;
            }
        } else {
            toolbar = this.f2852a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void N() {
        Drawable drawable;
        int i = this.f7372a;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f2855b) == null) {
            drawable = this.f2849a;
        }
        this.f2852a.setLogo(drawable);
    }

    @Override // a.d7
    public void a() {
        this.f2858b = true;
    }

    @Override // a.d7
    public void b(Menu menu, v4.a aVar) {
        if (this.f2848a == null) {
            n5 n5Var = new n5(this.f2852a.getContext());
            this.f2848a = n5Var;
            n5Var.p(y.action_menu_presenter);
        }
        this.f2848a.g(aVar);
        this.f2852a.I((i4) menu, this.f2848a);
    }

    @Override // a.d7
    public boolean c() {
        return this.f2852a.d();
    }

    @Override // a.d7
    public boolean d() {
        return this.f2852a.A();
    }

    @Override // a.d7
    public boolean e() {
        return this.f2852a.w();
    }

    @Override // a.d7
    public boolean f() {
        return this.f2852a.O();
    }

    @Override // a.d7
    public boolean g() {
        return this.f2852a.z();
    }

    @Override // a.d7
    public CharSequence getTitle() {
        return this.f2852a.getTitle();
    }

    @Override // a.d7
    public void h(int i) {
        E(i != 0 ? r2.d(x(), i) : null);
    }

    @Override // a.d7
    public void i(v4.a aVar, i4.a aVar2) {
        this.f2852a.J(aVar, aVar2);
    }

    @Override // a.d7
    public boolean j() {
        return this.f2852a.v();
    }

    @Override // a.d7
    public void k() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.d7
    public void l(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f7372a ^ i;
        this.f7372a = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    L();
                }
                M();
            }
            if ((i2 & 3) != 0) {
                N();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2852a.setTitle(this.f2853a);
                    toolbar = this.f2852a;
                    charSequence = this.f2857b;
                } else {
                    charSequence = null;
                    this.f2852a.setTitle((CharSequence) null);
                    toolbar = this.f2852a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f2856b) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f2852a.addView(view);
            } else {
                this.f2852a.removeView(view);
            }
        }
    }

    @Override // a.d7
    public Menu m() {
        return this.f2852a.getMenu();
    }

    @Override // a.d7
    public void n() {
        this.f2852a.f();
    }

    @Override // a.d7
    public void o(boolean z) {
    }

    @Override // a.d7
    public void p() {
        this.f2852a.e();
    }

    @Override // a.d7
    public void q(int i) {
        this.f2852a.setVisibility(i);
    }

    @Override // a.d7
    public void r(int i) {
        v(i != 0 ? r2.d(x(), i) : null);
    }

    @Override // a.d7
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // a.d7
    public void setWindowCallback(Window.Callback callback) {
        this.f2851a = callback;
    }

    @Override // a.d7
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2854a) {
            return;
        }
        K(charSequence);
    }

    @Override // a.d7
    public int t() {
        return this.f7372a;
    }

    @Override // a.d7
    public void u(boolean z) {
        this.f2852a.setCollapsible(z);
    }

    @Override // a.d7
    public void v(Drawable drawable) {
        this.f2849a = drawable;
        N();
    }

    @Override // a.d7
    public lh w(int i, long j) {
        lh lhVarC = eh.c(this.f2852a);
        lhVarC.a(i == 0 ? 1.0f : 0.0f);
        lhVarC.d(j);
        lhVarC.f(new r8(this, i));
        return lhVarC;
    }

    @Override // a.d7
    public Context x() {
        return this.f2852a.getContext();
    }

    @Override // a.d7
    public int y() {
        return this.b;
    }

    @Override // a.d7
    public ViewGroup z() {
        return this.f2852a;
    }
}
