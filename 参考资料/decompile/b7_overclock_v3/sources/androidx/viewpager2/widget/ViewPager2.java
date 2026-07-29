package androidx.viewpager2.widget;

import a1.d;
import a1.g;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;
import g.f0;
import g.n0;
import g.p0;
import g.t0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2 extends ViewGroup {
    public static boolean A = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f8188u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f8189v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f8190w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f8191x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f8192y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f8193z = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f8194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f8195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.viewpager2.widget.b f8196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.i f8199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f8200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Parcelable f8202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f8203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public x f8204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.viewpager2.widget.g f8205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.viewpager2.widget.b f8206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.viewpager2.widget.d f8207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.viewpager2.widget.f f8208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView.l f8209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8211r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8212s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f8213t;

    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f8198e = true;
            viewPager2.f8205l.n();
        }
    }

    public class b extends j {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void a(int i10) {
            if (i10 == 0) {
                ViewPager2.this.y();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f8197d != i10) {
                viewPager2.f8197d = i10;
                viewPager2.f8213t.q();
            }
        }
    }

    public class c extends j {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f8203j.requestFocus(2);
            }
        }
    }

    public class d implements RecyclerView.q {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(@n0 View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(@n0 View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width != -1 || ((ViewGroup.MarginLayoutParams) pVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    public abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int i10) {
            return false;
        }

        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public void e(@p0 RecyclerView.g<?> gVar) {
        }

        public void f(@p0 RecyclerView.g<?> gVar) {
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public void h(@n0 androidx.viewpager2.widget.b bVar, @n0 RecyclerView recyclerView) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(@n0 a1.d dVar) {
        }

        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void m() {
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        public void o(@n0 AccessibilityEvent accessibilityEvent) {
        }

        public void p() {
        }

        public void q() {
        }

        public void r() {
        }

        public void s() {
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    public class f extends e {
        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.l();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(@n0 a1.d dVar) {
            if (ViewPager2.this.l()) {
                return;
            }
            dVar.P0(d.a.f119s);
            dVar.P0(d.a.f118r);
            dVar.M1(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class g extends RecyclerView.i {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i10, int i11, @p0 Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void f(int i10, int i11) {
            a();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean A1(@n0 RecyclerView.w wVar, @n0 RecyclerView.b0 b0Var, int i10, @p0 Bundle bundle) {
            return ViewPager2.this.f8213t.b(i10) ? ViewPager2.this.f8213t.k(i10) : super.A1(wVar, b0Var, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean M1(@n0 RecyclerView recyclerView, @n0 View view, @n0 Rect rect, boolean z10, boolean z11) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g1(@n0 RecyclerView.w wVar, @n0 RecyclerView.b0 b0Var, @n0 a1.d dVar) {
            super.g1(wVar, b0Var, dVar);
            ViewPager2.this.f8213t.j(dVar);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void k2(@n0 RecyclerView.b0 b0Var, @n0 int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.k2(b0Var, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @f0(from = 1)
    public @interface i {
    }

    public static abstract class j {
        public void a(int i10) {
        }

        public void b(int i10, float f10, @t0 int i11) {
        }

        public void c(int i10) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface k {
    }

    public class l extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a1.g f8223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a1.g f8224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView.i f8225d;

        public class a implements a1.g {
            public a() {
            }

            @Override // a1.g
            public boolean a(@n0 View view, @p0 g.a aVar) {
                l.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements a1.g {
            public b() {
            }

            @Override // a1.g
            public boolean a(@n0 View view, @p0 g.a aVar) {
                l.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends g {
            public c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                l.this.w();
            }
        }

        public l() {
            super(ViewPager2.this, null);
            this.f8223b = new a();
            this.f8224c = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(@p0 RecyclerView.g<?> gVar) {
            w();
            if (gVar != null) {
                gVar.registerAdapterDataObserver(this.f8225d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(@p0 RecyclerView.g<?> gVar) {
            if (gVar != null) {
                gVar.unregisterAdapterDataObserver(this.f8225d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(@n0 androidx.viewpager2.widget.b bVar, @n0 RecyclerView recyclerView) {
            u0.R1(recyclerView, 2);
            this.f8225d = new c();
            if (u0.V(ViewPager2.this) == 0) {
                u0.R1(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i10, Bundle bundle) {
            if (!c(i10, bundle)) {
                throw new IllegalStateException();
            }
            v(i10 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(@n0 AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        public final void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
            } else {
                if (ViewPager2.this.getOrientation() != 1) {
                    itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                    itemCount = 0;
                    a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(itemCount, itemCount2, false, 0));
                }
                itemCount = ViewPager2.this.getAdapter().getItemCount();
            }
            itemCount2 = 0;
            a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(itemCount, itemCount2, false, 0));
        }

        public final void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.g adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.l()) {
                return;
            }
            if (ViewPager2.this.f8197d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f8197d < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        public void v(int i10) {
            if (ViewPager2.this.l()) {
                ViewPager2.this.t(i10, true);
            }
        }

        public void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = R.id.accessibilityActionPageLeft;
            u0.r1(viewPager2, R.id.accessibilityActionPageLeft);
            u0.r1(viewPager2, R.id.accessibilityActionPageRight);
            u0.r1(viewPager2, R.id.accessibilityActionPageUp);
            u0.r1(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.l()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f8197d < itemCount - 1) {
                    u0.u1(viewPager2, new d.a(R.id.accessibilityActionPageDown, null), null, this.f8223b);
                }
                if (ViewPager2.this.f8197d > 0) {
                    u0.u1(viewPager2, new d.a(R.id.accessibilityActionPageUp, null), null, this.f8224c);
                    return;
                }
                return;
            }
            boolean zK = ViewPager2.this.k();
            int i11 = zK ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zK) {
                i10 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f8197d < itemCount - 1) {
                u0.u1(viewPager2, new d.a(i11, null), null, this.f8223b);
            }
            if (ViewPager2.this.f8197d > 0) {
                u0.u1(viewPager2, new d.a(i10, null), null, this.f8224c);
            }
        }
    }

    public interface m {
        void a(@n0 View view, float f10);
    }

    public class n extends x {
        public n() {
        }

        @Override // androidx.recyclerview.widget.x, androidx.recyclerview.widget.b0
        @p0
        public View h(RecyclerView.o oVar) {
            if (ViewPager2.this.j()) {
                return null;
            }
            return super.h(oVar);
        }
    }

    public class o extends RecyclerView {
        public o(@n0 Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @v0(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f8213t.d() ? ViewPager2.this.f8213t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@n0 AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f8197d);
            accessibilityEvent.setToIndex(ViewPager2.this.f8197d);
            ViewPager2.this.f8213t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface p {
    }

    public static class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView f8232b;

        public q(int i10, RecyclerView recyclerView) {
            this.f8231a = i10;
            this.f8232b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8232b.L1(this.f8231a);
        }
    }

    public ViewPager2(@n0 Context context) {
        super(context);
        this.f8194a = new Rect();
        this.f8195b = new Rect();
        this.f8196c = new androidx.viewpager2.widget.b(3);
        this.f8198e = false;
        this.f8199f = new a();
        this.f8201h = -1;
        this.f8209p = null;
        this.f8210q = false;
        this.f8211r = true;
        this.f8212s = -1;
        h(context, null);
    }

    public void a(@n0 RecyclerView.n nVar) {
        this.f8203j.n(nVar);
    }

    public void b(@n0 RecyclerView.n nVar, int i10) {
        this.f8203j.o(nVar, i10);
    }

    public boolean c() {
        return this.f8207n.b();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f8203j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f8203j.canScrollVertically(i10);
    }

    public boolean d() {
        return this.f8207n.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f8214a;
            sparseArray.put(this.f8203j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        r();
    }

    public final RecyclerView.q e() {
        return new d();
    }

    public boolean f(@t0 @SuppressLint({"SupportAnnotationUsage"}) float f10) {
        return this.f8207n.e(f10);
    }

    @n0
    public RecyclerView.n g(int i10) {
        return this.f8203j.A0(i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    @v0(23)
    public CharSequence getAccessibilityClassName() {
        return this.f8213t.a() ? this.f8213t.g() : super.getAccessibilityClassName();
    }

    @p0
    public RecyclerView.g getAdapter() {
        return this.f8203j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f8197d;
    }

    public int getItemDecorationCount() {
        return this.f8203j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f8212s;
    }

    public int getOrientation() {
        return this.f8200g.Q2();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f8203j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f8205l.h();
    }

    public final void h(Context context, AttributeSet attributeSet) {
        this.f8213t = A ? new l() : new f();
        o oVar = new o(context);
        this.f8203j = oVar;
        oVar.setId(u0.D());
        this.f8203j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f8200g = hVar;
        this.f8203j.setLayoutManager(hVar);
        this.f8203j.setScrollingTouchSlop(1);
        u(context, attributeSet);
        this.f8203j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f8203j.p(e());
        androidx.viewpager2.widget.g gVar = new androidx.viewpager2.widget.g(this);
        this.f8205l = gVar;
        this.f8207n = new androidx.viewpager2.widget.d(this, gVar, this.f8203j);
        n nVar = new n();
        this.f8204k = nVar;
        nVar.b(this.f8203j);
        this.f8203j.r(this.f8205l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f8206m = bVar;
        this.f8205l.r(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f8206m.d(bVar2);
        this.f8206m.d(cVar);
        this.f8213t.h(this.f8206m, this.f8203j);
        this.f8206m.d(this.f8196c);
        androidx.viewpager2.widget.f fVar = new androidx.viewpager2.widget.f(this.f8200g);
        this.f8208o = fVar;
        this.f8206m.d(fVar);
        RecyclerView recyclerView = this.f8203j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void i() {
        this.f8203j.K0();
    }

    public boolean j() {
        return this.f8207n.f();
    }

    public boolean k() {
        return this.f8200g.q0() == 1;
    }

    public boolean l() {
        return this.f8211r;
    }

    public final void m(@p0 RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.f8199f);
        }
    }

    public void n(@n0 j jVar) {
        this.f8196c.d(jVar);
    }

    public void o(@n0 RecyclerView.n nVar) {
        this.f8203j.q1(nVar);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f8213t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f8203j.getMeasuredWidth();
        int measuredHeight = this.f8203j.getMeasuredHeight();
        this.f8194a.left = getPaddingLeft();
        this.f8194a.right = (i12 - i10) - getPaddingRight();
        this.f8194a.top = getPaddingTop();
        this.f8194a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f8194a, this.f8195b);
        RecyclerView recyclerView = this.f8203j;
        Rect rect = this.f8195b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f8198e) {
            y();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f8203j, i10, i11);
        int measuredWidth = this.f8203j.getMeasuredWidth();
        int measuredHeight = this.f8203j.getMeasuredHeight();
        int measuredState = this.f8203j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8201h = savedState.f8215b;
        this.f8202i = savedState.f8216c;
    }

    @Override // android.view.View
    @p0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8214a = this.f8203j.getId();
        int i10 = this.f8201h;
        if (i10 == -1) {
            i10 = this.f8197d;
        }
        savedState.f8215b = i10;
        Parcelable parcelable = this.f8202i;
        if (parcelable != null) {
            savedState.f8216c = parcelable;
        } else {
            Object adapter = this.f8203j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                savedState.f8216c = ((androidx.viewpager2.adapter.b) adapter).a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public void p(int i10) {
        this.f8203j.r1(i10);
    }

    @Override // android.view.View
    @v0(16)
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.f8213t.c(i10, bundle) ? this.f8213t.l(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void q() {
        if (this.f8208o.d() == null) {
            return;
        }
        double dG = this.f8205l.g();
        int i10 = (int) dG;
        float f10 = (float) (dG - ((double) i10));
        this.f8208o.b(i10, f10, Math.round(getPageSize() * f10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        RecyclerView.g adapter;
        if (this.f8201h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f8202i;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                ((androidx.viewpager2.adapter.b) adapter).d(parcelable);
            }
            this.f8202i = null;
        }
        int iMax = Math.max(0, Math.min(this.f8201h, adapter.getItemCount() - 1));
        this.f8197d = iMax;
        this.f8201h = -1;
        this.f8203j.D1(iMax);
        this.f8213t.m();
    }

    public void s(int i10, boolean z10) {
        if (j()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        t(i10, z10);
    }

    public void setAdapter(@p0 RecyclerView.g gVar) {
        RecyclerView.g adapter = this.f8203j.getAdapter();
        this.f8213t.f(adapter);
        w(adapter);
        this.f8203j.setAdapter(gVar);
        this.f8197d = 0;
        r();
        this.f8213t.e(gVar);
        m(gVar);
    }

    public void setCurrentItem(int i10) {
        s(i10, true);
    }

    @Override // android.view.View
    @v0(17)
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f8213t.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f8212s = i10;
        this.f8203j.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f8200g.j3(i10);
        this.f8213t.r();
    }

    public void setPageTransformer(@p0 m mVar) {
        if (mVar != null) {
            if (!this.f8210q) {
                this.f8209p = this.f8203j.getItemAnimator();
                this.f8210q = true;
            }
            this.f8203j.setItemAnimator(null);
        } else if (this.f8210q) {
            this.f8203j.setItemAnimator(this.f8209p);
            this.f8209p = null;
            this.f8210q = false;
        }
        if (mVar == this.f8208o.d()) {
            return;
        }
        this.f8208o.e(mVar);
        q();
    }

    public void setUserInputEnabled(boolean z10) {
        this.f8211r = z10;
        this.f8213t.s();
    }

    public void t(int i10, boolean z10) {
        RecyclerView.g adapter = getAdapter();
        if (adapter == null) {
            if (this.f8201h != -1) {
                this.f8201h = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
        if (iMin == this.f8197d && this.f8205l.k()) {
            return;
        }
        int i11 = this.f8197d;
        if (iMin == i11 && z10) {
            return;
        }
        double dG = i11;
        this.f8197d = iMin;
        this.f8213t.q();
        if (!this.f8205l.k()) {
            dG = this.f8205l.g();
        }
        this.f8205l.p(iMin, z10);
        if (!z10) {
            this.f8203j.D1(iMin);
            return;
        }
        double d10 = iMin;
        if (Math.abs(d10 - dG) <= 3.0d) {
            this.f8203j.L1(iMin);
            return;
        }
        this.f8203j.D1(d10 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f8203j;
        recyclerView.post(new q(iMin, recyclerView));
    }

    public final void u(Context context, AttributeSet attributeSet) {
        int[] iArr = androidx.viewpager2.R.styleable.ViewPager2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void v() {
        View viewH = this.f8204k.h(this.f8200g);
        if (viewH == null) {
            return;
        }
        int[] iArrC = this.f8204k.c(this.f8200g, viewH);
        if (iArrC[0] == 0 && iArrC[1] == 0) {
            return;
        }
        this.f8203j.H1(iArrC[0], iArrC[1]);
    }

    public final void w(@p0 RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.unregisterAdapterDataObserver(this.f8199f);
        }
    }

    public void x(@n0 j jVar) {
        this.f8196c.e(jVar);
    }

    public void y() {
        x xVar = this.f8204k;
        if (xVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewH = xVar.h(this.f8200g);
        if (viewH == null) {
            return;
        }
        int iU0 = this.f8200g.u0(viewH);
        if (iU0 != this.f8197d && getScrollState() == 0) {
            this.f8206m.c(iU0);
        }
        this.f8198e = false;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f8216c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @v0(24)
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f8214a = parcel.readInt();
            this.f8215b = parcel.readInt();
            this.f8216c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8214a);
            parcel.writeInt(this.f8215b);
            parcel.writeParcelable(this.f8216c, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8194a = new Rect();
        this.f8195b = new Rect();
        this.f8196c = new androidx.viewpager2.widget.b(3);
        this.f8198e = false;
        this.f8199f = new a();
        this.f8201h = -1;
        this.f8209p = null;
        this.f8210q = false;
        this.f8211r = true;
        this.f8212s = -1;
        h(context, attributeSet);
    }

    public ViewPager2(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8194a = new Rect();
        this.f8195b = new Rect();
        this.f8196c = new androidx.viewpager2.widget.b(3);
        this.f8198e = false;
        this.f8199f = new a();
        this.f8201h = -1;
        this.f8209p = null;
        this.f8210q = false;
        this.f8211r = true;
        this.f8212s = -1;
        h(context, attributeSet);
    }

    @v0(21)
    public ViewPager2(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f8194a = new Rect();
        this.f8195b = new Rect();
        this.f8196c = new androidx.viewpager2.widget.b(3);
        this.f8198e = false;
        this.f8199f = new a();
        this.f8201h = -1;
        this.f8209p = null;
        this.f8210q = false;
        this.f8211r = true;
        this.f8212s = -1;
        h(context, attributeSet);
    }
}
