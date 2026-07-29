package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.c0;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class o extends androidx.appcompat.app.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0 f1678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Window.Callback f1679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AppCompatDelegateImpl.i f1680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<a.d> f1684o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f1685p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Toolbar.f f1686q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.F0();
        }
    }

    public class b implements Toolbar.f {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return o.this.f1679j.onMenuItemSelected(0, menuItem);
        }
    }

    public final class c implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1689a;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(@n0 androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (this.f1689a) {
                return;
            }
            this.f1689a = true;
            o.this.f1678i.n();
            o.this.f1679j.onPanelClosed(108, eVar);
            this.f1689a = false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(@n0 androidx.appcompat.view.menu.e eVar) {
            o.this.f1679j.onMenuOpened(108, eVar);
            return true;
        }
    }

    public final class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@n0 androidx.appcompat.view.menu.e eVar) {
            if (o.this.f1678i.e()) {
                o.this.f1679j.onPanelClosed(108, eVar);
            } else if (o.this.f1679j.onPreparePanel(0, null, eVar)) {
                o.this.f1679j.onMenuOpened(108, eVar);
            }
        }
    }

    public class e implements AppCompatDelegateImpl.i {
        public e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public boolean a(int i10) {
            if (i10 != 0) {
                return false;
            }
            o oVar = o.this;
            if (oVar.f1681l) {
                return false;
            }
            oVar.f1678i.f();
            o.this.f1681l = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(o.this.f1678i.b());
            }
            return null;
        }
    }

    public o(@n0 Toolbar toolbar, @p0 CharSequence charSequence, @n0 Window.Callback callback) {
        b bVar = new b();
        this.f1686q = bVar;
        androidx.core.util.o.l(toolbar);
        a1 a1Var = new a1(toolbar, false);
        this.f1678i = a1Var;
        this.f1679j = (Window.Callback) androidx.core.util.o.l(callback);
        a1Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        a1Var.setWindowTitle(charSequence);
        this.f1680k = new e();
    }

    @Override // androidx.appcompat.app.a
    public Context A() {
        return this.f1678i.b();
    }

    @Override // androidx.appcompat.app.a
    public void A0(CharSequence charSequence) {
        this.f1678i.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public CharSequence B() {
        return this.f1678i.getTitle();
    }

    @Override // androidx.appcompat.app.a
    public void B0(CharSequence charSequence) {
        this.f1678i.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void C() {
        this.f1678i.setVisibility(8);
    }

    @Override // androidx.appcompat.app.a
    public void C0() {
        this.f1678i.setVisibility(0);
    }

    @Override // androidx.appcompat.app.a
    public boolean D() {
        this.f1678i.H().removeCallbacks(this.f1685p);
        u0.p1(this.f1678i.H(), this.f1685p);
        return true;
    }

    public final Menu E0() {
        if (!this.f1682m) {
            this.f1678i.G(new c(), new d());
            this.f1682m = true;
        }
        return this.f1678i.z();
    }

    @Override // androidx.appcompat.app.a
    public boolean F() {
        return this.f1678i.d() == 0;
    }

    public void F0() {
        Menu menuE0 = E0();
        androidx.appcompat.view.menu.e eVar = menuE0 instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menuE0 : null;
        if (eVar != null) {
            eVar.m0();
        }
        try {
            menuE0.clear();
            if (!this.f1679j.onCreatePanelMenu(0, menuE0) || !this.f1679j.onPreparePanel(0, null, menuE0)) {
                menuE0.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.l0();
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean G() {
        return super.G();
    }

    @Override // androidx.appcompat.app.a
    public a.f H() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void I(Configuration configuration) {
        super.I(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void J() {
        this.f1678i.H().removeCallbacks(this.f1685p);
    }

    @Override // androidx.appcompat.app.a
    public boolean K(int i10, KeyEvent keyEvent) {
        Menu menuE0 = E0();
        if (menuE0 == null) {
            return false;
        }
        menuE0.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE0.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean L(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            M();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean M() {
        return this.f1678i.l();
    }

    @Override // androidx.appcompat.app.a
    public void N() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void O(a.d dVar) {
        this.f1684o.remove(dVar);
    }

    @Override // androidx.appcompat.app.a
    public void P(a.f fVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void Q(int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public boolean R() {
        ViewGroup viewGroupH = this.f1678i.H();
        if (viewGroupH == null || viewGroupH.hasFocus()) {
            return false;
        }
        viewGroupH.requestFocus();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void S(a.f fVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void T(@p0 Drawable drawable) {
        this.f1678i.c(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void U(int i10) {
        V(LayoutInflater.from(this.f1678i.b()).inflate(i10, this.f1678i.H(), false));
    }

    @Override // androidx.appcompat.app.a
    public void V(View view) {
        W(view, new a.b(-2, -2));
    }

    @Override // androidx.appcompat.app.a
    public void W(View view, a.b bVar) {
        if (view != null) {
            view.setLayoutParams(bVar);
        }
        this.f1678i.P(view);
    }

    @Override // androidx.appcompat.app.a
    public void X(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void Y(boolean z10) {
        a0(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    @SuppressLint({"WrongConstant"})
    public void Z(int i10) {
        a0(i10, -1);
    }

    @Override // androidx.appcompat.app.a
    public void a0(int i10, int i11) {
        this.f1678i.t((i10 & i11) | ((~i11) & this.f1678i.M()));
    }

    @Override // androidx.appcompat.app.a
    public void b0(boolean z10) {
        a0(z10 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.a
    public void c0(boolean z10) {
        a0(z10 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void d0(boolean z10) {
        a0(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void e0(boolean z10) {
        a0(z10 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.a
    public void f0(float f10) {
        u0.N1(this.f1678i.H(), f10);
    }

    @Override // androidx.appcompat.app.a
    public void g(a.d dVar) {
        this.f1684o.add(dVar);
    }

    @Override // androidx.appcompat.app.a
    public void h(a.f fVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void i(a.f fVar, int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void i0(int i10) {
        this.f1678i.O(i10);
    }

    @Override // androidx.appcompat.app.a
    public void j(a.f fVar, int i10, boolean z10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void j0(CharSequence charSequence) {
        this.f1678i.u(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void k(a.f fVar, boolean z10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void k0(int i10) {
        this.f1678i.F(i10);
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        return this.f1678i.k();
    }

    @Override // androidx.appcompat.app.a
    public void l0(Drawable drawable) {
        this.f1678i.T(drawable);
    }

    @Override // androidx.appcompat.app.a
    public boolean m() {
        if (!this.f1678i.r()) {
            return false;
        }
        this.f1678i.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m0(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void n(boolean z10) {
        if (z10 == this.f1683n) {
            return;
        }
        this.f1683n = z10;
        int size = this.f1684o.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1684o.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void n0(int i10) {
        this.f1678i.setIcon(i10);
    }

    @Override // androidx.appcompat.app.a
    public View o() {
        return this.f1678i.o();
    }

    @Override // androidx.appcompat.app.a
    public void o0(Drawable drawable) {
        this.f1678i.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.a
    public int p() {
        return this.f1678i.M();
    }

    @Override // androidx.appcompat.app.a
    public void p0(SpinnerAdapter spinnerAdapter, a.e eVar) {
        this.f1678i.J(spinnerAdapter, new m(eVar));
    }

    @Override // androidx.appcompat.app.a
    public float q() {
        return u0.R(this.f1678i.H());
    }

    @Override // androidx.appcompat.app.a
    public void q0(int i10) {
        this.f1678i.setLogo(i10);
    }

    @Override // androidx.appcompat.app.a
    public int r() {
        return this.f1678i.getHeight();
    }

    @Override // androidx.appcompat.app.a
    public void r0(Drawable drawable) {
        this.f1678i.q(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void s0(int i10) {
        if (i10 == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.f1678i.E(i10);
    }

    @Override // androidx.appcompat.app.a
    public int t() {
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void t0(int i10) {
        if (this.f1678i.B() != 1) {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
        this.f1678i.y(i10);
    }

    @Override // androidx.appcompat.app.a
    public int u() {
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void u0(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public int v() {
        return -1;
    }

    @Override // androidx.appcompat.app.a
    public void v0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.a
    public a.f w() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void w0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.a
    public CharSequence x() {
        return this.f1678i.L();
    }

    @Override // androidx.appcompat.app.a
    public void x0(int i10) {
        c0 c0Var = this.f1678i;
        c0Var.v(i10 != 0 ? c0Var.b().getText(i10) : null);
    }

    @Override // androidx.appcompat.app.a
    public a.f y(int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.a
    public void y0(CharSequence charSequence) {
        this.f1678i.v(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public int z() {
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void z0(int i10) {
        c0 c0Var = this.f1678i;
        c0Var.setTitle(i10 != 0 ? c0Var.b().getText(i10) : null);
    }
}
