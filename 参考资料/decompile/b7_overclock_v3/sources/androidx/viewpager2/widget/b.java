package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import g.n0;
import g.t0;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ViewPager2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final List<ViewPager2.j> f8236a;

    public b(int i10) {
        this.f8236a = new ArrayList(i10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void a(int i10) {
        try {
            Iterator<ViewPager2.j> it2 = this.f8236a.iterator();
            while (it2.hasNext()) {
                it2.next().a(i10);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void b(int i10, float f10, @t0 int i11) {
        try {
            Iterator<ViewPager2.j> it2 = this.f8236a.iterator();
            while (it2.hasNext()) {
                it2.next().b(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void c(int i10) {
        try {
            Iterator<ViewPager2.j> it2 = this.f8236a.iterator();
            while (it2.hasNext()) {
                it2.next().c(i10);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    public void d(ViewPager2.j jVar) {
        this.f8236a.add(jVar);
    }

    public void e(ViewPager2.j jVar) {
        this.f8236a.remove(jVar);
    }

    public final void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
