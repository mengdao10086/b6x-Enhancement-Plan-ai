package a;

import a.k3;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p2 extends d0 implements ActionBarOverlayLayout.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f7075a = new AccelerateInterpolator();
    public static final Interpolator b = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d7 f2357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g8 f2358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k3.a f2359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k3 f2360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mh f2361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public o2 f2362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final oh f2363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u3 f2364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarContainer f2367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarContextView f2368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarOverlayLayout f2369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<e0> f2370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2371a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final mh f2372b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Context f2373b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2374b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public p2(Activity activity, boolean z) {
        new ArrayList();
        this.f2370a = new ArrayList<>();
        this.f2356a = 0;
        this.d = true;
        this.h = true;
        this.f2361a = new l2(this);
        this.f2372b = new m2(this);
        this.f2363a = new n2(this);
        View decorView = activity.getWindow().getDecorView();
        F(decorView);
        if (z) {
            return;
        }
        this.f2366a = decorView.findViewById(R.id.content);
    }

    public p2(Dialog dialog) {
        new ArrayList();
        this.f2370a = new ArrayList<>();
        this.f2356a = 0;
        this.d = true;
        this.h = true;
        this.f2361a = new l2(this);
        this.f2372b = new m2(this);
        this.f2363a = new n2(this);
        F(dialog.getWindow().getDecorView());
    }

    public static boolean y(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public void A(boolean z) {
        View view;
        u3 u3Var = this.f2364a;
        if (u3Var != null) {
            u3Var.a();
        }
        if (this.f2356a != 0 || (!this.i && !z)) {
            this.f2361a.a(null);
            return;
        }
        this.f2367a.setAlpha(1.0f);
        this.f2367a.setTransitioning(true);
        u3 u3Var2 = new u3();
        float f = -this.f2367a.getHeight();
        if (z) {
            this.f2367a.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        lh lhVarC = eh.c(this.f2367a);
        lhVarC.k(f);
        lhVarC.i(this.f2363a);
        u3Var2.c(lhVarC);
        if (this.d && (view = this.f2366a) != null) {
            lh lhVarC2 = eh.c(view);
            lhVarC2.k(f);
            u3Var2.c(lhVarC2);
        }
        u3Var2.f(f7075a);
        u3Var2.e(250L);
        u3Var2.g(this.f2361a);
        this.f2364a = u3Var2;
        u3Var2.h();
    }

    public void B(boolean z) {
        View view;
        View view2;
        u3 u3Var = this.f2364a;
        if (u3Var != null) {
            u3Var.a();
        }
        this.f2367a.setVisibility(0);
        if (this.f2356a == 0 && (this.i || z)) {
            this.f2367a.setTranslationY(0.0f);
            float f = -this.f2367a.getHeight();
            if (z) {
                this.f2367a.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.f2367a.setTranslationY(f);
            u3 u3Var2 = new u3();
            lh lhVarC = eh.c(this.f2367a);
            lhVarC.k(0.0f);
            lhVarC.i(this.f2363a);
            u3Var2.c(lhVarC);
            if (this.d && (view2 = this.f2366a) != null) {
                view2.setTranslationY(f);
                lh lhVarC2 = eh.c(this.f2366a);
                lhVarC2.k(0.0f);
                u3Var2.c(lhVarC2);
            }
            u3Var2.f(b);
            u3Var2.e(250L);
            u3Var2.g(this.f2372b);
            this.f2364a = u3Var2;
            u3Var2.h();
        } else {
            this.f2367a.setAlpha(1.0f);
            this.f2367a.setTranslationY(0.0f);
            if (this.d && (view = this.f2366a) != null) {
                view.setTranslationY(0.0f);
            }
            this.f2372b.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2369a;
        if (actionBarOverlayLayout != null) {
            eh.h0(actionBarOverlayLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d7 C(View view) {
        if (view instanceof d7) {
            return (d7) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public int D() {
        return this.f2357a.y();
    }

    public final void E() {
        if (this.g) {
            this.g = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2369a;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    public final void F(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(y.decor_content_parent);
        this.f2369a = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2357a = C(view.findViewById(y.action_bar));
        this.f2368a = (ActionBarContextView) view.findViewById(y.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(y.action_bar_container);
        this.f2367a = actionBarContainer;
        d7 d7Var = this.f2357a;
        if (d7Var == null || this.f2368a == null || actionBarContainer == null) {
            throw new IllegalStateException(p2.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f2365a = d7Var.x();
        boolean z = (this.f2357a.t() & 4) != 0;
        if (z) {
            this.f2371a = true;
        }
        j3 j3VarB = j3.b(this.f2365a);
        t(j3VarB.a() || z);
        I(j3VarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.f2365a.obtainStyledAttributes(null, c0.ActionBar, t.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(c0.ActionBar_hideOnContentScroll, false)) {
            J(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(c0.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void G(int i, int i2) {
        int iT = this.f2357a.t();
        if ((i2 & 4) != 0) {
            this.f2371a = true;
        }
        this.f2357a.l((i & i2) | ((~i2) & iT));
    }

    public void H(float f) {
        eh.q0(this.f2367a, f);
    }

    public final void I(boolean z) {
        this.c = z;
        if (z) {
            this.f2367a.setTabContainer(null);
            this.f2357a.A(this.f2358a);
        } else {
            this.f2357a.A(null);
            this.f2367a.setTabContainer(this.f2358a);
        }
        boolean z2 = D() == 2;
        g8 g8Var = this.f2358a;
        if (g8Var != null) {
            if (z2) {
                g8Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2369a;
                if (actionBarOverlayLayout != null) {
                    eh.h0(actionBarOverlayLayout);
                }
            } else {
                g8Var.setVisibility(8);
            }
        }
        this.f2357a.u(!this.c && z2);
        this.f2369a.setHasNonEmbeddedTabs(!this.c && z2);
    }

    public void J(boolean z) {
        if (z && !this.f2369a.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.j = z;
        this.f2369a.setHideOnContentScrollEnabled(z);
    }

    public final boolean K() {
        return eh.Q(this.f2367a);
    }

    public final void L() {
        if (this.g) {
            return;
        }
        this.g = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2369a;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    public final void M(boolean z) {
        if (y(this.e, this.f, this.g)) {
            if (this.h) {
                return;
            }
            this.h = true;
            B(z);
            return;
        }
        if (this.h) {
            this.h = false;
            A(z);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        u3 u3Var = this.f2364a;
        if (u3Var != null) {
            u3Var.a();
            this.f2364a = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f) {
            this.f = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.f) {
            return;
        }
        this.f = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(int i) {
        this.f2356a = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(boolean z) {
        this.d = z;
    }

    @Override // a.d0
    public boolean h() {
        d7 d7Var = this.f2357a;
        if (d7Var == null || !d7Var.j()) {
            return false;
        }
        this.f2357a.p();
        return true;
    }

    @Override // a.d0
    public void i(boolean z) {
        if (z == this.f2374b) {
            return;
        }
        this.f2374b = z;
        int size = this.f2370a.size();
        for (int i = 0; i < size; i++) {
            this.f2370a.get(i).a(z);
        }
    }

    @Override // a.d0
    public int j() {
        return this.f2357a.t();
    }

    @Override // a.d0
    public Context k() {
        if (this.f2373b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2365a.getTheme().resolveAttribute(t.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f2373b = new ContextThemeWrapper(this.f2365a, i);
            } else {
                this.f2373b = this.f2365a;
            }
        }
        return this.f2373b;
    }

    @Override // a.d0
    public void m(Configuration configuration) {
        I(j3.b(this.f2365a).e());
    }

    @Override // a.d0
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuE;
        o2 o2Var = this.f2362a;
        if (o2Var == null || (menuE = o2Var.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i, keyEvent, 0);
    }

    @Override // a.d0
    public void r(boolean z) {
        if (this.f2371a) {
            return;
        }
        s(z);
    }

    @Override // a.d0
    public void s(boolean z) {
        G(z ? 4 : 0, 4);
    }

    @Override // a.d0
    public void t(boolean z) {
        this.f2357a.o(z);
    }

    @Override // a.d0
    public void u(boolean z) {
        u3 u3Var;
        this.i = z;
        if (z || (u3Var = this.f2364a) == null) {
            return;
        }
        u3Var.a();
    }

    @Override // a.d0
    public void v(CharSequence charSequence) {
        this.f2357a.setWindowTitle(charSequence);
    }

    @Override // a.d0
    public k3 w(k3.a aVar) {
        o2 o2Var = this.f2362a;
        if (o2Var != null) {
            o2Var.c();
        }
        this.f2369a.setHideOnContentScrollEnabled(false);
        this.f2368a.k();
        o2 o2Var2 = new o2(this, this.f2368a.getContext(), aVar);
        if (!o2Var2.t()) {
            return null;
        }
        this.f2362a = o2Var2;
        o2Var2.k();
        this.f2368a.h(o2Var2);
        x(true);
        this.f2368a.sendAccessibilityEvent(32);
        return o2Var2;
    }

    public void x(boolean z) {
        lh lhVarW;
        lh lhVarF;
        if (z) {
            L();
        } else {
            E();
        }
        if (!K()) {
            if (z) {
                this.f2357a.q(4);
                this.f2368a.setVisibility(0);
                return;
            } else {
                this.f2357a.q(0);
                this.f2368a.setVisibility(8);
                return;
            }
        }
        if (z) {
            lhVarF = this.f2357a.w(4, 100L);
            lhVarW = this.f2368a.f(0, 200L);
        } else {
            lhVarW = this.f2357a.w(0, 200L);
            lhVarF = this.f2368a.f(8, 100L);
        }
        u3 u3Var = new u3();
        u3Var.d(lhVarF, lhVarW);
        u3Var.h();
    }

    public void z() {
        k3.a aVar = this.f2359a;
        if (aVar != null) {
            aVar.c(this.f2360a);
            this.f2360a = null;
            this.f2359a = null;
        }
    }
}
