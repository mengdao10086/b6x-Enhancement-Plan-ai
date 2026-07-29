package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4926b;

    public j0(@g.n0 ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4925a | this.f4926b;
    }

    public void b(@g.n0 View view, @g.n0 View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(@g.n0 View view, @g.n0 View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f4926b = i10;
        } else {
            this.f4925a = i10;
        }
    }

    public void d(@g.n0 View view) {
        e(view, 0);
    }

    public void e(@g.n0 View view, int i10) {
        if (i10 == 1) {
            this.f4926b = 0;
        } else {
            this.f4925a = 0;
        }
    }
}
