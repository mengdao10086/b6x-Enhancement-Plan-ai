package androidx.appcompat.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import g.c1;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class c implements DrawerLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawerLayout f1607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.appcompat.graphics.drawable.d f1608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnClickListener f1615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1616k;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            if (cVar.f1611f) {
                cVar.v();
                return;
            }
            View.OnClickListener onClickListener = cVar.f1615j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface b {
        void a(Drawable drawable, @c1 int i10);

        Drawable b();

        void c(@c1 int i10);

        boolean d();

        Context e();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.c$c, reason: collision with other inner class name */
    public interface InterfaceC0029c {
        @p0
        b g();
    }

    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f1618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d.a f1619b;

        @v0(18)
        public static class a {
            @u
            public static void a(ActionBar actionBar, int i10) {
                actionBar.setHomeActionContentDescription(i10);
            }

            @u
            public static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        public d(Activity activity) {
            this.f1618a = activity;
        }

        @Override // androidx.appcompat.app.c.b
        public void a(Drawable drawable, int i10) {
            ActionBar actionBar = this.f1618a.getActionBar();
            if (actionBar != null) {
                a.b(actionBar, drawable);
                a.a(actionBar, i10);
            }
        }

        @Override // androidx.appcompat.app.c.b
        public Drawable b() {
            TypedArray typedArrayObtainStyledAttributes = e().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.c.b
        public void c(int i10) {
            ActionBar actionBar = this.f1618a.getActionBar();
            if (actionBar != null) {
                a.a(actionBar, i10);
            }
        }

        @Override // androidx.appcompat.app.c.b
        public boolean d() {
            ActionBar actionBar = this.f1618a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.c.b
        public Context e() {
            ActionBar actionBar = this.f1618a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1618a;
        }
    }

    public static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Toolbar f1620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f1621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f1622c;

        public e(Toolbar toolbar) {
            this.f1620a = toolbar;
            this.f1621b = toolbar.getNavigationIcon();
            this.f1622c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.c.b
        public void a(Drawable drawable, @c1 int i10) {
            this.f1620a.setNavigationIcon(drawable);
            c(i10);
        }

        @Override // androidx.appcompat.app.c.b
        public Drawable b() {
            return this.f1621b;
        }

        @Override // androidx.appcompat.app.c.b
        public void c(@c1 int i10) {
            if (i10 == 0) {
                this.f1620a.setNavigationContentDescription(this.f1622c);
            } else {
                this.f1620a.setNavigationContentDescription(i10);
            }
        }

        @Override // androidx.appcompat.app.c.b
        public boolean d() {
            return true;
        }

        @Override // androidx.appcompat.app.c.b
        public Context e() {
            return this.f1620a.getContext();
        }
    }

    public c(Activity activity, DrawerLayout drawerLayout, @c1 int i10, @c1 int i11) {
        this(activity, null, drawerLayout, null, i10, i11);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void a(View view) {
        s(1.0f);
        if (this.f1611f) {
            l(this.f1614i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void b(View view) {
        s(0.0f);
        if (this.f1611f) {
            l(this.f1613h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void c(int i10) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void d(View view, float f10) {
        if (this.f1609d) {
            s(Math.min(1.0f, Math.max(0.0f, f10)));
        } else {
            s(0.0f);
        }
    }

    @n0
    public androidx.appcompat.graphics.drawable.d e() {
        return this.f1608c;
    }

    public Drawable f() {
        return this.f1606a.b();
    }

    public View.OnClickListener g() {
        return this.f1615j;
    }

    public boolean h() {
        return this.f1611f;
    }

    public boolean i() {
        return this.f1609d;
    }

    public void j(Configuration configuration) {
        if (!this.f1612g) {
            this.f1610e = f();
        }
        u();
    }

    public boolean k(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f1611f) {
            return false;
        }
        v();
        return true;
    }

    public void l(int i10) {
        this.f1606a.c(i10);
    }

    public void m(Drawable drawable, int i10) {
        if (!this.f1616k && !this.f1606a.d()) {
            this.f1616k = true;
        }
        this.f1606a.a(drawable, i10);
    }

    public void n(@n0 androidx.appcompat.graphics.drawable.d dVar) {
        this.f1608c = dVar;
        u();
    }

    public void o(boolean z10) {
        if (z10 != this.f1611f) {
            if (z10) {
                m(this.f1608c, this.f1607b.C(androidx.core.view.m.f5025b) ? this.f1614i : this.f1613h);
            } else {
                m(this.f1610e, 0);
            }
            this.f1611f = z10;
        }
    }

    public void p(boolean z10) {
        this.f1609d = z10;
        if (z10) {
            return;
        }
        s(0.0f);
    }

    public void q(int i10) {
        r(i10 != 0 ? this.f1607b.getResources().getDrawable(i10) : null);
    }

    public void r(Drawable drawable) {
        if (drawable == null) {
            this.f1610e = f();
            this.f1612g = false;
        } else {
            this.f1610e = drawable;
            this.f1612g = true;
        }
        if (this.f1611f) {
            return;
        }
        m(this.f1610e, 0);
    }

    public final void s(float f10) {
        if (f10 == 1.0f) {
            this.f1608c.u(true);
        } else if (f10 == 0.0f) {
            this.f1608c.u(false);
        }
        this.f1608c.s(f10);
    }

    public void t(View.OnClickListener onClickListener) {
        this.f1615j = onClickListener;
    }

    public void u() {
        if (this.f1607b.C(androidx.core.view.m.f5025b)) {
            s(1.0f);
        } else {
            s(0.0f);
        }
        if (this.f1611f) {
            m(this.f1608c, this.f1607b.C(androidx.core.view.m.f5025b) ? this.f1614i : this.f1613h);
        }
    }

    public void v() {
        int iQ = this.f1607b.q(androidx.core.view.m.f5025b);
        if (this.f1607b.F(androidx.core.view.m.f5025b) && iQ != 2) {
            this.f1607b.d(androidx.core.view.m.f5025b);
        } else if (iQ != 1) {
            this.f1607b.K(androidx.core.view.m.f5025b);
        }
    }

    public c(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @c1 int i10, @c1 int i11) {
        this(activity, toolbar, drawerLayout, null, i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, androidx.appcompat.graphics.drawable.d dVar, @c1 int i10, @c1 int i11) {
        this.f1609d = true;
        this.f1611f = true;
        this.f1616k = false;
        if (toolbar != null) {
            this.f1606a = new e(toolbar);
            toolbar.setNavigationOnClickListener(new a());
        } else if (activity instanceof InterfaceC0029c) {
            this.f1606a = ((InterfaceC0029c) activity).g();
        } else {
            this.f1606a = new d(activity);
        }
        this.f1607b = drawerLayout;
        this.f1613h = i10;
        this.f1614i = i11;
        if (dVar == null) {
            this.f1608c = new androidx.appcompat.graphics.drawable.d(this.f1606a.e());
        } else {
            this.f1608c = dVar;
        }
        this.f1610e = f();
    }
}
