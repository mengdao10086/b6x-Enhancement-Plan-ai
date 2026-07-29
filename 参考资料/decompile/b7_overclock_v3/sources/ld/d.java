package ld;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class d<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f39584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39586c;

    public d() {
        this.f39585b = 0;
        this.f39586c = 0;
    }

    public int G() {
        e eVar = this.f39584a;
        if (eVar != null) {
            return eVar.d();
        }
        return 0;
    }

    public int H() {
        e eVar = this.f39584a;
        if (eVar != null) {
            return eVar.e();
        }
        return 0;
    }

    public boolean I() {
        e eVar = this.f39584a;
        return eVar != null && eVar.f();
    }

    public boolean J() {
        e eVar = this.f39584a;
        return eVar != null && eVar.g();
    }

    public void K(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
        coordinatorLayout.N(v10, i10);
    }

    public void L(boolean z10) {
        e eVar = this.f39584a;
        if (eVar != null) {
            eVar.i(z10);
        }
    }

    public boolean M(int i10) {
        e eVar = this.f39584a;
        if (eVar != null) {
            return eVar.j(i10);
        }
        this.f39586c = i10;
        return false;
    }

    public boolean N(int i10) {
        e eVar = this.f39584a;
        if (eVar != null) {
            return eVar.k(i10);
        }
        this.f39585b = i10;
        return false;
    }

    public void O(boolean z10) {
        e eVar = this.f39584a;
        if (eVar != null) {
            eVar.l(z10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
        K(coordinatorLayout, v10, i10);
        if (this.f39584a == null) {
            this.f39584a = new e(v10);
        }
        this.f39584a.h();
        this.f39584a.a();
        int i11 = this.f39585b;
        if (i11 != 0) {
            this.f39584a.k(i11);
            this.f39585b = 0;
        }
        int i12 = this.f39586c;
        if (i12 == 0) {
            return true;
        }
        this.f39584a.j(i12);
        this.f39586c = 0;
        return true;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39585b = 0;
        this.f39586c = 0;
    }
}
