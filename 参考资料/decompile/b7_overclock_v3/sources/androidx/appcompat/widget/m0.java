package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.view.menu.e f2587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.appcompat.view.menu.i f2589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f2590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f2591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnTouchListener f2592g;

    public class a implements e.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@g.n0 androidx.appcompat.view.menu.e eVar, @g.n0 MenuItem menuItem) {
            e eVar2 = m0.this.f2590e;
            if (eVar2 != null) {
                return eVar2.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@g.n0 androidx.appcompat.view.menu.e eVar) {
        }
    }

    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m0 m0Var = m0.this;
            d dVar = m0Var.f2591f;
            if (dVar != null) {
                dVar.a(m0Var);
            }
        }
    }

    public class c extends h0 {
        public c(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.h0
        public m.f b() {
            return m0.this.f2589d.e();
        }

        @Override // androidx.appcompat.widget.h0
        public boolean c() {
            m0.this.l();
            return true;
        }

        @Override // androidx.appcompat.widget.h0
        public boolean d() {
            m0.this.a();
            return true;
        }
    }

    public interface d {
        void a(m0 m0Var);
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public m0(@g.n0 Context context, @g.n0 View view) {
        this(context, view, 0);
    }

    public void a() {
        this.f2589d.dismiss();
    }

    @g.n0
    public View.OnTouchListener b() {
        if (this.f2592g == null) {
            this.f2592g = new c(this.f2588c);
        }
        return this.f2592g;
    }

    public int c() {
        return this.f2589d.c();
    }

    @g.n0
    public Menu d() {
        return this.f2587b;
    }

    @g.n0
    public MenuInflater e() {
        return new l.g(this.f2586a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ListView f() {
        if (this.f2589d.f()) {
            return this.f2589d.d();
        }
        return null;
    }

    public void g(@g.l0 int i10) {
        e().inflate(i10, this.f2587b);
    }

    public void h(boolean z10) {
        this.f2589d.i(z10);
    }

    public void i(int i10) {
        this.f2589d.j(i10);
    }

    public void j(@g.p0 d dVar) {
        this.f2591f = dVar;
    }

    public void k(@g.p0 e eVar) {
        this.f2590e = eVar;
    }

    public void l() {
        this.f2589d.l();
    }

    public m0(@g.n0 Context context, @g.n0 View view, int i10) {
        this(context, view, i10, R.attr.popupMenuStyle, 0);
    }

    public m0(@g.n0 Context context, @g.n0 View view, int i10, @g.f int i11, @g.d1 int i12) {
        this.f2586a = context;
        this.f2588c = view;
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        this.f2587b = eVar;
        eVar.X(new a());
        androidx.appcompat.view.menu.i iVar = new androidx.appcompat.view.menu.i(context, eVar, view, false, i11, i12);
        this.f2589d = iVar;
        iVar.j(i10);
        iVar.k(new b());
    }
}
