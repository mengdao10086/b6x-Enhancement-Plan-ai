package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.o;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import g.n0;
import g.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements ViewPager2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8246a;

    public e(@t0 int i10) {
        o.j(i10, "Margin must be non-negative");
        this.f8246a = i10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.m
    public void a(@n0 View view, float f10) {
        ViewPager2 viewPager2B = b(view);
        float f11 = this.f8246a * f10;
        if (viewPager2B.getOrientation() != 0) {
            view.setTranslationY(f11);
            return;
        }
        if (viewPager2B.k()) {
            f11 = -f11;
        }
        view.setTranslationX(f11);
    }

    public final ViewPager2 b(@n0 View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
