package a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uw {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f3217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3218a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7637a = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public uw(tw twVar) {
        this.f3217a = (View) twVar;
    }

    public final void a() {
        ViewParent parent = this.f3217a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.f3217a);
        }
    }

    public int b() {
        return this.f7637a;
    }

    public boolean c() {
        return this.f3218a;
    }

    public void d(Bundle bundle) {
        this.f3218a = bundle.getBoolean("expanded", false);
        this.f7637a = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f3218a) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f3218a);
        bundle.putInt("expandedComponentIdHint", this.f7637a);
        return bundle;
    }

    public void f(int i) {
        this.f7637a = i;
    }
}
