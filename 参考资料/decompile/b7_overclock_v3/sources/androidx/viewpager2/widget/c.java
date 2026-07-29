package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ViewPager2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ViewPager2.m> f8237a = new ArrayList();

    @Override // androidx.viewpager2.widget.ViewPager2.m
    public void a(@n0 View view, float f10) {
        Iterator<ViewPager2.m> it2 = this.f8237a.iterator();
        while (it2.hasNext()) {
            it2.next().a(view, f10);
        }
    }

    public void b(@n0 ViewPager2.m mVar) {
        this.f8237a.add(mVar);
    }

    public void c(@n0 ViewPager2.m mVar) {
        this.f8237a.remove(mVar);
    }
}
