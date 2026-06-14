package a;

import a.i4;
import a.k3;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o2 extends k3 implements i4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f6972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k3.a f2184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p2 f2185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<View> f2187a;

    public o2(p2 p2Var, Context context, k3.a aVar) {
        this.f2185a = p2Var;
        this.f2186a = context;
        this.f2184a = aVar;
        i4 i4Var = new i4(context);
        i4Var.S(1);
        this.f6972a = i4Var;
        i4Var.R(this);
    }

    @Override // a.i4.a
    public void a(i4 i4Var) {
        if (this.f2184a == null) {
            return;
        }
        k();
        this.f2185a.f2368a.l();
    }

    @Override // a.i4.a
    public boolean b(i4 i4Var, MenuItem menuItem) {
        k3.a aVar = this.f2184a;
        if (aVar != null) {
            return aVar.a(this, menuItem);
        }
        return false;
    }

    @Override // a.k3
    public void c() {
        p2 p2Var = this.f2185a;
        if (p2Var.f2362a != this) {
            return;
        }
        if (p2.y(p2Var.e, p2Var.f, false)) {
            this.f2184a.c(this);
        } else {
            p2 p2Var2 = this.f2185a;
            p2Var2.f2360a = this;
            p2Var2.f2359a = this.f2184a;
        }
        this.f2184a = null;
        this.f2185a.x(false);
        this.f2185a.f2368a.g();
        this.f2185a.f2357a.z().sendAccessibilityEvent(32);
        p2 p2Var3 = this.f2185a;
        p2Var3.f2369a.setHideOnContentScrollEnabled(p2Var3.j);
        this.f2185a.f2362a = null;
    }

    @Override // a.k3
    public View d() {
        WeakReference<View> weakReference = this.f2187a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.k3
    public Menu e() {
        return this.f6972a;
    }

    @Override // a.k3
    public MenuInflater f() {
        return new s3(this.f2186a);
    }

    @Override // a.k3
    public CharSequence g() {
        return this.f2185a.f2368a.getSubtitle();
    }

    @Override // a.k3
    public CharSequence i() {
        return this.f2185a.f2368a.getTitle();
    }

    @Override // a.k3
    public void k() {
        if (this.f2185a.f2362a != this) {
            return;
        }
        this.f6972a.d0();
        try {
            this.f2184a.d(this, this.f6972a);
        } finally {
            this.f6972a.c0();
        }
    }

    @Override // a.k3
    public boolean l() {
        return this.f2185a.f2368a.j();
    }

    @Override // a.k3
    public void m(View view) {
        this.f2185a.f2368a.setCustomView(view);
        this.f2187a = new WeakReference<>(view);
    }

    @Override // a.k3
    public void n(int i) {
        o(this.f2185a.f2365a.getResources().getString(i));
    }

    @Override // a.k3
    public void o(CharSequence charSequence) {
        this.f2185a.f2368a.setSubtitle(charSequence);
    }

    @Override // a.k3
    public void q(int i) {
        r(this.f2185a.f2365a.getResources().getString(i));
    }

    @Override // a.k3
    public void r(CharSequence charSequence) {
        this.f2185a.f2368a.setTitle(charSequence);
    }

    @Override // a.k3
    public void s(boolean z) {
        super.s(z);
        this.f2185a.f2368a.setTitleOptional(z);
    }

    public boolean t() {
        this.f6972a.d0();
        try {
            return this.f2184a.b(this, this.f6972a);
        } finally {
            this.f6972a.c0();
        }
    }
}
