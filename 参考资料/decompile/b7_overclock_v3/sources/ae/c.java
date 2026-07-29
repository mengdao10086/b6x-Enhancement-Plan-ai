package ae;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import g.d0;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final View f575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f576b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d0
    public int f577c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f575a = (View) bVar;
    }

    public final void a() {
        ViewParent parent = this.f575a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).j(this.f575a);
        }
    }

    @d0
    public int b() {
        return this.f577c;
    }

    public boolean c() {
        return this.f576b;
    }

    public void d(@n0 Bundle bundle) {
        this.f576b = bundle.getBoolean("expanded", false);
        this.f577c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f576b) {
            a();
        }
    }

    @n0
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f576b);
        bundle.putInt("expandedComponentIdHint", this.f577c);
        return bundle;
    }

    public boolean f(boolean z10) {
        if (this.f576b == z10) {
            return false;
        }
        this.f576b = z10;
        a();
        return true;
    }

    public void g(@d0 int i10) {
        this.f577c = i10;
    }
}
