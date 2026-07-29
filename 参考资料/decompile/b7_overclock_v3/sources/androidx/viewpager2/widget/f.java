package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import g.p0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends ViewPager2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f8247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager2.m f8248b;

    public f(LinearLayoutManager linearLayoutManager) {
        this.f8247a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void a(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void b(int i10, float f10, int i11) {
        if (this.f8248b == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.f8247a.Y(); i12++) {
            View viewX = this.f8247a.X(i12);
            if (viewX == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.f8247a.Y())));
            }
            this.f8248b.a(viewX, (this.f8247a.u0(viewX) - i10) + f11);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void c(int i10) {
    }

    public ViewPager2.m d() {
        return this.f8248b;
    }

    public void e(@p0 ViewPager2.m mVar) {
        this.f8248b = mVar;
    }
}
