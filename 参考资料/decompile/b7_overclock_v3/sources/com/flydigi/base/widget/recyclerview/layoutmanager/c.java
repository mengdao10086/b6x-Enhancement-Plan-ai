package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.layoutmanager.ViewPagerLayoutManager;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f13657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f13658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13659c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.t f13660d = new a();

    public class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13661a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) recyclerView.getLayoutManager();
            ViewPagerLayoutManager.a aVar = viewPagerLayoutManager.T7;
            if (aVar != null) {
                aVar.onPageScrollStateChanged(i10);
            }
            if (i10 == 0 && this.f13661a) {
                this.f13661a = false;
                if (c.this.f13659c) {
                    c.this.f13659c = false;
                } else {
                    c.this.f13659c = true;
                    c.this.g(viewPagerLayoutManager, aVar);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f13661a = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) this.f13657a.getLayoutManager();
        if (viewPagerLayoutManager == null || this.f13657a.getAdapter() == null) {
            return false;
        }
        if (!viewPagerLayoutManager.H3() && (viewPagerLayoutManager.L7 == viewPagerLayoutManager.I3() || viewPagerLayoutManager.L7 == viewPagerLayoutManager.L3())) {
            return false;
        }
        int minFlingVelocity = this.f13657a.getMinFlingVelocity();
        this.f13658b.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (viewPagerLayoutManager.I7 == 1 && Math.abs(i11) > minFlingVelocity) {
            int iC3 = viewPagerLayoutManager.C3();
            int finalY = (int) ((this.f13658b.getFinalY() / viewPagerLayoutManager.S7) / viewPagerLayoutManager.E3());
            this.f13657a.L1(viewPagerLayoutManager.S2() ? iC3 - finalY : iC3 + finalY);
            return true;
        }
        if (viewPagerLayoutManager.I7 == 0 && Math.abs(i10) > minFlingVelocity) {
            int iC32 = viewPagerLayoutManager.C3();
            int finalX = (int) ((this.f13658b.getFinalX() / viewPagerLayoutManager.S7) / viewPagerLayoutManager.E3());
            this.f13657a.L1(viewPagerLayoutManager.S2() ? iC32 - finalX : iC32 + finalX);
        }
        return true;
    }

    public void d(@p0 RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f13657a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.f13657a = recyclerView;
        if (recyclerView != null) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewPagerLayoutManager) {
                f();
                this.f13658b = new Scroller(this.f13657a.getContext(), new DecelerateInterpolator());
                ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
                g(viewPagerLayoutManager, viewPagerLayoutManager.T7);
            }
        }
    }

    public void e() {
        this.f13657a.u1(this.f13660d);
        this.f13657a.setOnFlingListener(null);
    }

    public void f() throws IllegalStateException {
        if (this.f13657a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f13657a.r(this.f13660d);
        this.f13657a.setOnFlingListener(this);
    }

    public void g(ViewPagerLayoutManager viewPagerLayoutManager, ViewPagerLayoutManager.a aVar) {
        int iO3 = viewPagerLayoutManager.O3();
        if (iO3 == 0) {
            this.f13659c = false;
        } else if (viewPagerLayoutManager.Q2() == 1) {
            this.f13657a.H1(0, iO3);
        } else {
            this.f13657a.H1(iO3, 0);
        }
        if (aVar != null) {
            aVar.onPageSelected(viewPagerLayoutManager.C3());
        }
    }
}
