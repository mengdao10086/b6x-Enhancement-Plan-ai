package l;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f39264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f39265b;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, Menu menu);

        void c(b bVar);

        boolean d(b bVar, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f39264a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f39265b;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return true;
    }

    public abstract void n(View view);

    public abstract void o(int i10);

    public abstract void p(CharSequence charSequence);

    public void q(Object obj) {
        this.f39264a = obj;
    }

    public abstract void r(int i10);

    public abstract void s(CharSequence charSequence);

    public void t(boolean z10) {
        this.f39265b = z10;
    }
}
