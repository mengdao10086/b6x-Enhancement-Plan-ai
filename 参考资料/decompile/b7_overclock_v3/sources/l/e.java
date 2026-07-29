package l;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import g.n0;
import java.lang.ref.WeakReference;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e extends b implements e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f39272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContextView f39273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.a f39274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<View> f39275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f39276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f39277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f39278i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f39272c = context;
        this.f39273d = actionBarContextView;
        this.f39274e = aVar;
        androidx.appcompat.view.menu.e eVarZ = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).Z(1);
        this.f39278i = eVarZ;
        eVarZ.X(this);
        this.f39277h = z10;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
        return this.f39274e.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(@n0 androidx.appcompat.view.menu.e eVar) {
        k();
        this.f39273d.o();
    }

    @Override // l.b
    public void c() {
        if (this.f39276g) {
            return;
        }
        this.f39276g = true;
        this.f39274e.c(this);
    }

    @Override // l.b
    public View d() {
        WeakReference<View> weakReference = this.f39275f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // l.b
    public Menu e() {
        return this.f39278i;
    }

    @Override // l.b
    public MenuInflater f() {
        return new g(this.f39273d.getContext());
    }

    @Override // l.b
    public CharSequence g() {
        return this.f39273d.getSubtitle();
    }

    @Override // l.b
    public CharSequence i() {
        return this.f39273d.getTitle();
    }

    @Override // l.b
    public void k() {
        this.f39274e.b(this, this.f39278i);
    }

    @Override // l.b
    public boolean l() {
        return this.f39273d.s();
    }

    @Override // l.b
    public boolean m() {
        return this.f39277h;
    }

    @Override // l.b
    public void n(View view) {
        this.f39273d.setCustomView(view);
        this.f39275f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // l.b
    public void o(int i10) {
        p(this.f39272c.getString(i10));
    }

    @Override // l.b
    public void p(CharSequence charSequence) {
        this.f39273d.setSubtitle(charSequence);
    }

    @Override // l.b
    public void r(int i10) {
        s(this.f39272c.getString(i10));
    }

    @Override // l.b
    public void s(CharSequence charSequence) {
        this.f39273d.setTitle(charSequence);
    }

    @Override // l.b
    public void t(boolean z10) {
        super.t(z10);
        this.f39273d.setTitleOptional(z10);
    }

    public void u(androidx.appcompat.view.menu.e eVar, boolean z10) {
    }

    public void v(m mVar) {
    }

    public boolean w(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return true;
        }
        new androidx.appcompat.view.menu.i(this.f39273d.getContext(), mVar).l();
        return true;
    }
}
