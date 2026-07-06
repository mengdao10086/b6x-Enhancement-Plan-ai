package a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class vv<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wv f3308a;
    public int b;

    public vv() {
        this.f7727a = 0;
        this.b = 0;
    }

    public vv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7727a = 0;
        this.b = 0;
    }

    public int E() {
        wv wvVar = this.f3308a;
        if (wvVar != null) {
            return wvVar.b();
        }
        return 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.I(v, i);
    }

    public boolean G(int i) {
        wv wvVar = this.f3308a;
        if (wvVar != null) {
            return wvVar.e(i);
        }
        this.f7727a = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        F(coordinatorLayout, v, i);
        if (this.f3308a == null) {
            this.f3308a = new wv(v);
        }
        this.f3308a.c();
        this.f3308a.a();
        int i2 = this.f7727a;
        if (i2 != 0) {
            this.f3308a.e(i2);
            this.f7727a = 0;
        }
        int i3 = this.b;
        if (i3 == 0) {
            return true;
        }
        this.f3308a.d(i3);
        this.b = 0;
        return true;
    }
}
