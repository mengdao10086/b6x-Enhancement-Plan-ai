package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13649j = 2000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13650k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13651l = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f13652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f13654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13656i;

    public b(int i10, int i11) {
        j(i10);
        i(i11);
        this.f13652e = new Handler(Looper.getMainLooper());
        this.f13653f = i10;
        this.f13656i = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(RecyclerView.o oVar) {
        int iC3 = ((ViewPagerLayoutManager) oVar).C3();
        this.f13657a.L1(this.f13656i == 2 ? iC3 + 1 : iC3 - 1);
        if (this.f13655h) {
            this.f13652e.postDelayed(this.f13654g, this.f13653f);
        }
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.c
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
            final RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewPagerLayoutManager) {
                f();
                this.f13658b = new Scroller(this.f13657a.getContext(), new DecelerateInterpolator());
                ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
                g(viewPagerLayoutManager, viewPagerLayoutManager.T7);
                viewPagerLayoutManager.a4(true);
                Runnable runnable = new Runnable() { // from class: com.flydigi.base.widget.recyclerview.layoutmanager.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13647a.k(layoutManager);
                    }
                };
                this.f13654g = runnable;
                this.f13652e.postDelayed(runnable, this.f13653f);
                this.f13655h = true;
            }
        }
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.c
    public void e() {
        super.e();
        if (this.f13655h) {
            this.f13652e.removeCallbacks(this.f13654g);
            this.f13655h = false;
        }
    }

    public final void i(int i10) {
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("direction should be one of left or right");
        }
    }

    public final void j(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("time interval should greater than 0");
        }
    }

    public void l() {
        if (this.f13655h) {
            this.f13652e.removeCallbacks(this.f13654g);
            this.f13655h = false;
        }
    }

    public void m(int i10) {
        i(i10);
        this.f13656i = i10;
    }

    public void n(int i10) {
        j(i10);
        this.f13653f = i10;
    }

    public void o() {
        if (this.f13655h) {
            return;
        }
        this.f13652e.postDelayed(this.f13654g, this.f13653f);
        this.f13655h = true;
    }
}
