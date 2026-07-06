package a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class io {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f1392a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ho f6430a = new ho();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<View> f1393a = new ArrayList();

    public interface a {
        View a(int i);

        void b(View view, int i, ViewGroup.LayoutParams layoutParams);

        void c(int i);

        int d(View view);

        void e(int i);

        int f();

        void g();

        RecyclerView.d0 h(View view);

        void i(View view);

        void j(View view);

        void k(View view, int i);
    }

    public io(a aVar) {
        this.f1392a = aVar;
    }

    public void a(View view, int i, boolean z) {
        int iF = i < 0 ? this.f1392a.f() : h(i);
        this.f6430a.e(iF, z);
        if (z) {
            l(view);
        }
        this.f1392a.k(view, iF);
    }

    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iF = i < 0 ? this.f1392a.f() : h(i);
        this.f6430a.e(iF, z);
        if (z) {
            l(view);
        }
        this.f1392a.b(view, iF, layoutParams);
    }

    public void d(int i) {
        int iH = h(i);
        this.f6430a.f(iH);
        this.f1392a.e(iH);
    }

    public View e(int i) {
        int size = this.f1393a.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f1393a.get(i2);
            RecyclerView.d0 d0VarH = this.f1392a.h(view);
            if (d0VarH.m() == i && !d0VarH.t() && !d0VarH.v()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i) {
        return this.f1392a.a(h(i));
    }

    public int g() {
        return this.f1392a.f() - this.f1393a.size();
    }

    public final int h(int i) {
        if (i < 0) {
            return -1;
        }
        int iF = this.f1392a.f();
        int i2 = i;
        while (i2 < iF) {
            int iB = i - (i2 - this.f6430a.b(i2));
            if (iB == 0) {
                while (this.f6430a.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public View i(int i) {
        return this.f1392a.a(i);
    }

    public int j() {
        return this.f1392a.f();
    }

    public void k(View view) {
        int iD = this.f1392a.d(view);
        if (iD >= 0) {
            this.f6430a.h(iD);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f1393a.add(view);
        this.f1392a.i(view);
    }

    public int m(View view) {
        int iD = this.f1392a.d(view);
        if (iD == -1 || this.f6430a.d(iD)) {
            return -1;
        }
        return iD - this.f6430a.b(iD);
    }

    public boolean n(View view) {
        return this.f1393a.contains(view);
    }

    public void o() {
        this.f6430a.g();
        for (int size = this.f1393a.size() - 1; size >= 0; size--) {
            this.f1392a.j(this.f1393a.get(size));
            this.f1393a.remove(size);
        }
        this.f1392a.g();
    }

    public void p(View view) {
        int iD = this.f1392a.d(view);
        if (iD < 0) {
            return;
        }
        if (this.f6430a.f(iD)) {
            t(view);
        }
        this.f1392a.c(iD);
    }

    public void q(int i) {
        int iH = h(i);
        View viewA = this.f1392a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f6430a.f(iH)) {
            t(viewA);
        }
        this.f1392a.c(iH);
    }

    public boolean r(View view) {
        int iD = this.f1392a.d(view);
        if (iD == -1) {
            t(view);
            return true;
        }
        if (!this.f6430a.d(iD)) {
            return false;
        }
        this.f6430a.f(iD);
        t(view);
        this.f1392a.c(iD);
        return true;
    }

    public void s(View view) {
        int iD = this.f1392a.d(view);
        if (iD < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f6430a.d(iD)) {
            this.f6430a.a(iD);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f1393a.remove(view)) {
            return false;
        }
        this.f1392a.j(view);
        return true;
    }

    public String toString() {
        return this.f6430a.toString() + ", hidden list:" + this.f1393a.size();
    }
}
