package com.tmall.ultraviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tmall.ultraviewpager.c;
import com.tmall.ultraviewpager.e;

/* JADX INFO: loaded from: classes5.dex */
public class UltraViewPager extends RelativeLayout implements com.tmall.ultraviewpager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Point f22847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Point f22848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f22849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f22852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f22853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f22854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.a f22855i;

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum ScrollDirection {
        NONE(0),
        BACKWARD(1),
        FORWARD(2);


        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public int f22856id;

        ScrollDirection(int i10) {
            this.f22856id = i10;
        }

        public static ScrollDirection getScrollDirection(int i10) {
            for (ScrollDirection scrollDirection : values()) {
                if (scrollDirection.f22856id == i10) {
                    return scrollDirection;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public enum ScrollMode {
        HORIZONTAL(0),
        VERTICAL(1);


        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public int f22857id;

        ScrollMode(int i10) {
            this.f22857id = i10;
        }

        public static ScrollMode getScrollMode(int i10) {
            for (ScrollMode scrollMode : values()) {
                if (scrollMode.f22857id == i10) {
                    return scrollMode;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public class a implements e.a {
        public a() {
        }

        @Override // com.tmall.ultraviewpager.e.a
        public void a() {
            UltraViewPager ultraViewPager = UltraViewPager.this;
            ultraViewPager.removeView(ultraViewPager.f22853g);
            UltraViewPager ultraViewPager2 = UltraViewPager.this;
            ultraViewPager2.addView(ultraViewPager2.f22853g, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public class b implements c.a {
        public b() {
        }

        @Override // com.tmall.ultraviewpager.c.a
        public int a() {
            return UltraViewPager.this.getNextItem();
        }

        @Override // com.tmall.ultraviewpager.c.a
        public void b() {
            UltraViewPager.this.k();
        }
    }

    public UltraViewPager(Context context) {
        super(context);
        this.f22849c = Float.NaN;
        this.f22850d = -1;
        this.f22851e = -1;
        this.f22855i = new b();
        this.f22847a = new Point();
        this.f22848b = new Point();
        p();
    }

    @Override // com.tmall.ultraviewpager.b
    public void a(int i10, SparseIntArray sparseIntArray) {
        if (i10 == 0) {
            return;
        }
        if (this.f22854h != null) {
            e();
        }
        c cVar = new c(this.f22855i, i10);
        this.f22854h = cVar;
        cVar.f22861a = sparseIntArray;
        u();
    }

    @Override // com.tmall.ultraviewpager.b
    public com.tmall.ultraviewpager.a b(int i10, int i11, int i12, int i13, int i14, int i15) {
        return j().m(i10).setNormalColor(i11).c(i13).b(i12).i(i14).e(i15);
    }

    @Override // com.tmall.ultraviewpager.b
    public void c(int i10, int i11) {
        this.f22852f.setPadding(i10, 0, i11, 0);
    }

    @Override // com.tmall.ultraviewpager.b
    public com.tmall.ultraviewpager.a d(Bitmap bitmap, Bitmap bitmap2, int i10) {
        return j().j(bitmap).l(bitmap2).e(i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f22854h != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                v();
            }
            if (action == 1 || action == 3) {
                u();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tmall.ultraviewpager.b
    public void e() {
        v();
        this.f22854h = null;
    }

    @Override // com.tmall.ultraviewpager.b
    public void f() {
        e eVar = this.f22853g;
        if (eVar != null) {
            removeView(eVar);
            this.f22853g = null;
        }
    }

    @Override // com.tmall.ultraviewpager.b
    public com.tmall.ultraviewpager.a g(int i10, int i11, int i12, int i13) {
        return j().m(i10).setNormalColor(i11).i(i12).e(i13);
    }

    public k2.a getAdapter() {
        if (this.f22852f.getAdapter() == null) {
            return null;
        }
        return ((d) this.f22852f.getAdapter()).a();
    }

    public int getCurrentItem() {
        return this.f22852f.getCurrentItem();
    }

    public com.tmall.ultraviewpager.a getIndicator() {
        return this.f22853g;
    }

    public int getNextItem() {
        return this.f22852f.getNextItem();
    }

    public ViewPager getViewPager() {
        return this.f22852f;
    }

    public k2.a getWrapAdapter() {
        return this.f22852f.getAdapter();
    }

    @Override // com.tmall.ultraviewpager.b
    public com.tmall.ultraviewpager.a h(int i10, int i11, int i12) {
        return j().f(i10).d(i11).e(i12);
    }

    @Override // com.tmall.ultraviewpager.b
    public void i(ScrollDirection scrollDirection) {
    }

    @Override // com.tmall.ultraviewpager.b
    public com.tmall.ultraviewpager.a j() {
        f();
        e eVar = new e(getContext());
        this.f22853g = eVar;
        eVar.setViewPager(this.f22852f);
        this.f22853g.setIndicatorBuildListener(new a());
        return this.f22853g;
    }

    @Override // com.tmall.ultraviewpager.b
    public boolean k() {
        boolean z10;
        f fVar = this.f22852f;
        int i10 = 0;
        if (fVar == null || fVar.getAdapter() == null || this.f22852f.getAdapter().getCount() <= 0) {
            return false;
        }
        int currentItemFake = this.f22852f.getCurrentItemFake();
        if (currentItemFake < this.f22852f.getAdapter().getCount() - 1) {
            i10 = currentItemFake + 1;
            z10 = true;
        } else {
            z10 = false;
        }
        this.f22852f.f0(i10, true);
        return z10;
    }

    @Override // com.tmall.ultraviewpager.b
    public boolean l() {
        boolean z10;
        f fVar = this.f22852f;
        int i10 = 0;
        if (fVar == null || fVar.getAdapter() == null || this.f22852f.getAdapter().getCount() <= 0) {
            return false;
        }
        int currentItemFake = this.f22852f.getCurrentItemFake();
        if (currentItemFake > 0) {
            i10 = currentItemFake - 1;
            z10 = true;
        } else {
            z10 = false;
        }
        this.f22852f.f0(i10, true);
        return z10;
    }

    @Override // com.tmall.ultraviewpager.b
    public void m(int i10, int i11, int i12, int i13) {
        this.f22852f.g0(i10, i11, i12, i13);
    }

    public final void o(Point point, Point point2) {
        int i10 = point2.x;
        if (i10 >= 0 && point.x > i10) {
            point.x = i10;
        }
        int i11 = point2.y;
        if (i11 < 0 || point.y <= i11) {
            return;
        }
        point.y = i11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        u();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!Float.isNaN(this.f22849c)) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) / this.f22849c), 1073741824);
        }
        this.f22847a.set(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        int i12 = this.f22850d;
        if (i12 >= 0 || this.f22851e >= 0) {
            this.f22848b.set(i12, this.f22851e);
            o(this.f22847a, this.f22848b);
            i10 = View.MeasureSpec.makeMeasureSpec(this.f22847a.x, 1073741824);
            i11 = View.MeasureSpec.makeMeasureSpec(this.f22847a.y, 1073741824);
        }
        if (this.f22852f.getConstrainLength() <= 0) {
            super.onMeasure(i10, i11);
            return;
        }
        if (this.f22852f.getConstrainLength() == i11) {
            this.f22852f.measure(i10, i11);
            Point point = this.f22847a;
            setMeasuredDimension(point.x, point.y);
        } else if (this.f22852f.getScrollMode() == ScrollMode.HORIZONTAL) {
            super.onMeasure(i10, this.f22852f.getConstrainLength());
        } else {
            super.onMeasure(this.f22852f.getConstrainLength(), i11);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        v();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            u();
        } else {
            v();
        }
    }

    public final void p() {
        f fVar = new f(getContext());
        this.f22852f = fVar;
        fVar.setId(View.generateViewId());
        addView(this.f22852f, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void q(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UltraViewPager);
        setAutoScroll(typedArrayObtainStyledAttributes.getInt(R.styleable.UltraViewPager_upv_autoscroll, 0));
        setInfiniteLoop(typedArrayObtainStyledAttributes.getBoolean(R.styleable.UltraViewPager_upv_infiniteloop, false));
        setRatio(typedArrayObtainStyledAttributes.getFloat(R.styleable.UltraViewPager_upv_ratio, Float.NaN));
        setScrollMode(ScrollMode.getScrollMode(typedArrayObtainStyledAttributes.getInt(R.styleable.UltraViewPager_upv_scrollmode, 0)));
        i(ScrollDirection.getScrollDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.UltraViewPager_upv_disablescroll, 0)));
        setMultiScreen(typedArrayObtainStyledAttributes.getFloat(R.styleable.UltraViewPager_upv_multiscreen, 1.0f));
        setAutoMeasureHeight(typedArrayObtainStyledAttributes.getBoolean(R.styleable.UltraViewPager_upv_automeasure, false));
        setItemRatio(typedArrayObtainStyledAttributes.getFloat(R.styleable.UltraViewPager_upv_itemratio, Float.NaN));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void r() {
        if (this.f22852f.getAdapter() != null) {
            this.f22852f.getAdapter().notifyDataSetChanged();
        }
    }

    public void s(int i10, boolean z10) {
        this.f22852f.U(i10, z10);
    }

    public void setAdapter(k2.a aVar) {
        this.f22852f.setAdapter(aVar);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setAutoMeasureHeight(boolean z10) {
        this.f22852f.setAutoMeasureHeight(z10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setAutoScroll(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f22854h != null) {
            e();
        }
        this.f22854h = new c(this.f22855i, i10);
        u();
    }

    public void setCurrentItem(int i10) {
        this.f22852f.setCurrentItem(i10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setHGap(int i10) {
        this.f22852f.setMultiScreen((r0 - i10) / getContext().getResources().getDisplayMetrics().widthPixels);
        this.f22852f.setPageMargin(i10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setInfiniteLoop(boolean z10) {
        this.f22852f.setEnableLoop(z10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setInfiniteRatio(int i10) {
        if (this.f22852f.getAdapter() == null || !(this.f22852f.getAdapter() instanceof d)) {
            return;
        }
        ((d) this.f22852f.getAdapter()).h(i10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setItemRatio(double d10) {
        this.f22852f.setItemRatio(d10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setMaxHeight(int i10) {
        this.f22851e = i10;
    }

    @Override // com.tmall.ultraviewpager.b
    public void setMaxWidth(int i10) {
        this.f22850d = i10;
    }

    @Override // com.tmall.ultraviewpager.b
    public void setMultiScreen(float f10) {
        if (f10 <= 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("");
        }
        if (f10 <= 1.0f) {
            this.f22852f.setMultiScreen(f10);
        }
    }

    public void setOffscreenPageLimit(int i10) {
        this.f22852f.setOffscreenPageLimit(i10);
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        e eVar = this.f22853g;
        if (eVar != null) {
            eVar.setPageChangeListener(jVar);
        } else {
            this.f22852f.Q(jVar);
            this.f22852f.e(jVar);
        }
    }

    @Override // com.tmall.ultraviewpager.b
    public void setRatio(float f10) {
        this.f22849c = f10;
        this.f22852f.setRatio(f10);
    }

    @Override // com.tmall.ultraviewpager.b
    public void setScrollMode(ScrollMode scrollMode) {
        this.f22852f.setScrollMode(scrollMode);
    }

    public void t(boolean z10, ViewPager.k kVar) {
        this.f22852f.Y(z10, kVar);
    }

    public final void u() {
        c cVar = this.f22854h;
        if (cVar == null || this.f22852f == null || !cVar.f22863c) {
            return;
        }
        cVar.f22864d = this.f22855i;
        cVar.removeCallbacksAndMessages(null);
        this.f22854h.f(0);
        this.f22854h.f22863c = false;
    }

    public final void v() {
        c cVar = this.f22854h;
        if (cVar == null || this.f22852f == null || cVar.f22863c) {
            return;
        }
        cVar.removeCallbacksAndMessages(null);
        c cVar2 = this.f22854h;
        cVar2.f22864d = null;
        cVar2.f22863c = true;
    }

    public UltraViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22849c = Float.NaN;
        this.f22850d = -1;
        this.f22851e = -1;
        this.f22855i = new b();
        this.f22847a = new Point();
        this.f22848b = new Point();
        p();
        q(context, attributeSet);
    }

    public UltraViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22849c = Float.NaN;
        this.f22850d = -1;
        this.f22851e = -1;
        this.f22855i = new b();
        this.f22847a = new Point();
        this.f22848b = new Point();
        p();
    }
}
