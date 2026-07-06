package a;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6567a;
    public boolean b;

    public interface a {
        boolean a(k3 k3Var, MenuItem menuItem);

        boolean b(k3 k3Var, Menu menu);

        void c(k3 k3Var);

        boolean d(k3 k3Var, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f6567a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f6567a = obj;
    }

    public abstract void q(int i);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z) {
        this.b = z;
    }
}
