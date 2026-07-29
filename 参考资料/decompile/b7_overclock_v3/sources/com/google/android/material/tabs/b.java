package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final TabLayout f20847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ViewPager2 f20848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f20849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC0211b f20851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public RecyclerView.g<?> f20852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public c f20854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public TabLayout.f f20855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public RecyclerView.i f20856j;

    public class a extends RecyclerView.i {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            b.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11) {
            b.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i10, int i11, @p0 Object obj) {
            b.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            b.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            b.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            b.this.d();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.b$b, reason: collision with other inner class name */
    public interface InterfaceC0211b {
        void a(@n0 TabLayout.i iVar, int i10);
    }

    public static class c extends ViewPager2.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final WeakReference<TabLayout> f20858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20860c;

        public c(TabLayout tabLayout) {
            this.f20858a = new WeakReference<>(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void a(int i10) {
            this.f20859b = this.f20860c;
            this.f20860c = i10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void b(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f20858a.get();
            if (tabLayout != null) {
                int i12 = this.f20860c;
                tabLayout.Q(i10, f10, i12 != 2 || this.f20859b == 1, (i12 == 2 && this.f20859b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i10) {
            TabLayout tabLayout = this.f20858a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f20860c;
            tabLayout.N(tabLayout.y(i10), i11 == 0 || (i11 == 2 && this.f20859b == 0));
        }

        public void d() {
            this.f20860c = 0;
            this.f20859b = 0;
        }
    }

    public static class d implements TabLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager2 f20861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20862b;

        public d(ViewPager2 viewPager2, boolean z10) {
            this.f20861a = viewPager2;
            this.f20862b = z10;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@n0 TabLayout.i iVar) {
            this.f20861a.s(iVar.k(), this.f20862b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.i iVar) {
        }
    }

    public b(@n0 TabLayout tabLayout, @n0 ViewPager2 viewPager2, @n0 InterfaceC0211b interfaceC0211b) {
        this(tabLayout, viewPager2, true, interfaceC0211b);
    }

    public void a() {
        if (this.f20853g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.g<?> adapter = this.f20848b.getAdapter();
        this.f20852f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f20853g = true;
        c cVar = new c(this.f20847a);
        this.f20854h = cVar;
        this.f20848b.n(cVar);
        d dVar = new d(this.f20848b, this.f20850d);
        this.f20855i = dVar;
        this.f20847a.c(dVar);
        if (this.f20849c) {
            a aVar = new a();
            this.f20856j = aVar;
            this.f20852f.registerAdapterDataObserver(aVar);
        }
        d();
        this.f20847a.P(this.f20848b.getCurrentItem(), 0.0f, true);
    }

    public void b() {
        RecyclerView.g<?> gVar;
        if (this.f20849c && (gVar = this.f20852f) != null) {
            gVar.unregisterAdapterDataObserver(this.f20856j);
            this.f20856j = null;
        }
        this.f20847a.I(this.f20855i);
        this.f20848b.x(this.f20854h);
        this.f20855i = null;
        this.f20854h = null;
        this.f20852f = null;
        this.f20853g = false;
    }

    public boolean c() {
        return this.f20853g;
    }

    public void d() {
        this.f20847a.G();
        RecyclerView.g<?> gVar = this.f20852f;
        if (gVar != null) {
            int itemCount = gVar.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                TabLayout.i iVarD = this.f20847a.D();
                this.f20851e.a(iVarD, i10);
                this.f20847a.g(iVarD, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.f20848b.getCurrentItem(), this.f20847a.getTabCount() - 1);
                if (iMin != this.f20847a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f20847a;
                    tabLayout.M(tabLayout.y(iMin));
                }
            }
        }
    }

    public b(@n0 TabLayout tabLayout, @n0 ViewPager2 viewPager2, boolean z10, @n0 InterfaceC0211b interfaceC0211b) {
        this(tabLayout, viewPager2, z10, true, interfaceC0211b);
    }

    public b(@n0 TabLayout tabLayout, @n0 ViewPager2 viewPager2, boolean z10, boolean z11, @n0 InterfaceC0211b interfaceC0211b) {
        this.f20847a = tabLayout;
        this.f20848b = viewPager2;
        this.f20849c = z10;
        this.f20850d = z11;
        this.f20851e = interfaceC0211b;
    }
}
