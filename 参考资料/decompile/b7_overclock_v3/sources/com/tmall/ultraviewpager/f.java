package com.tmall.ultraviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.d;

/* JADX INFO: loaded from: classes5.dex */
public class f extends ViewPager implements d.a {
    public int A8;
    public float B8;
    public UltraViewPager.ScrollMode C8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public d f22896q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f22897r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public float f22898s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public boolean f22899t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public boolean f22900u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public double f22901v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public int f22902w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int f22903x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public int f22904y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public int f22905z8;

    public f(Context context) {
        super(context);
        this.f22898s8 = Float.NaN;
        this.f22901v8 = Double.NaN;
        this.B8 = Float.NaN;
        this.C8 = UltraViewPager.ScrollMode.HORIZONTAL;
        d0(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void U(int i10, boolean z10) {
        if (this.f22896q8.getCount() != 0 && this.f22896q8.d()) {
            i10 = (i10 % this.f22896q8.b()) + (this.f22896q8.getCount() / 2);
        }
        super.U(i10, z10);
    }

    @Override // com.tmall.ultraviewpager.d.a
    public void a() {
        setCurrentItem(getCurrentItem());
    }

    @Override // com.tmall.ultraviewpager.d.a
    public void b() {
        setCurrentItem(0);
    }

    public final void d0(Context context, AttributeSet attributeSet) {
        setClipChildren(false);
        setOverScrollMode(2);
    }

    public void e0(int i10, int i11) {
        d dVar = this.f22896q8;
        if (dVar == null) {
            return;
        }
        View viewC = dVar.c(getCurrentItem());
        if (viewC == null) {
            viewC = getChildAt(0);
        }
        if (viewC == null) {
            return;
        }
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getPaddingLeft() != this.f22903x8 || childAt.getPaddingTop() != this.f22904y8 || childAt.getPaddingRight() != this.f22905z8 || childAt.getPaddingBottom() != this.A8) {
                childAt.setPadding(this.f22903x8, this.f22904y8, this.f22905z8, this.A8);
            }
        }
        ViewGroup.LayoutParams layoutParams = viewC.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, 0, layoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, 0, layoutParams.height);
        int size = (int) (((View.MeasureSpec.getSize(childMeasureSpec) - getPaddingLeft()) - getPaddingRight()) * this.f22896q8.getPageWidth(getCurrentItem()));
        int size2 = (View.MeasureSpec.getSize(childMeasureSpec2) - getPaddingTop()) - getPaddingBottom();
        if (this.f22897r8) {
            if (size == 0 && size2 == 0) {
                return;
            }
            if (Double.isNaN(this.f22901v8)) {
                int childCount = getChildCount();
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = getChildAt(i13);
                    if (this.f22896q8.getPageWidth(getCurrentItem()) != 1.0f) {
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    } else {
                        childAt2.measure(childMeasureSpec, childMeasureSpec2);
                    }
                }
            } else {
                int i14 = (int) (((double) size) / this.f22901v8);
                int childCount2 = getChildCount();
                for (int i15 = 0; i15 < childCount2; i15++) {
                    getChildAt(i15).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
                }
            }
            boolean z10 = this.C8 == UltraViewPager.ScrollMode.HORIZONTAL;
            int measuredWidth = this.f22903x8 + viewC.getMeasuredWidth() + this.f22905z8;
            int measuredHeight = this.f22904y8 + viewC.getMeasuredHeight() + this.A8;
            if (!Float.isNaN(this.B8)) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() / this.B8), 1073741824);
                setMeasuredDimension(i10, iMakeMeasureSpec);
                int childCount3 = getChildCount();
                for (int i16 = 0; i16 < childCount3; i16++) {
                    getChildAt(i16).measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), iMakeMeasureSpec);
                }
            } else if (this.f22900u8) {
                if (z10) {
                    this.f22902w8 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                } else {
                    this.f22902w8 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                    setMeasuredDimension(measuredWidth, getMeasuredHeight());
                }
                this.f22897r8 = measuredHeight == this.f22904y8 + this.A8;
            }
            if (this.f22896q8.e()) {
                int measuredWidth2 = z10 ? getMeasuredWidth() : getMeasuredHeight();
                int measuredWidth3 = z10 ? viewC.getMeasuredWidth() : viewC.getMeasuredHeight();
                if (measuredWidth3 > 0) {
                    this.f22897r8 = false;
                    int i17 = measuredWidth2 - measuredWidth3;
                    if (getPageMargin() == 0) {
                        setPageMargin(-i17);
                    }
                    setOffscreenPageLimit(((int) Math.ceil(measuredWidth2 / measuredWidth3)) + 1);
                    requestLayout();
                }
            }
        }
    }

    public void f0(int i10, boolean z10) {
        super.U(i10, z10);
    }

    public void g0(int i10, int i11, int i12, int i13) {
        this.f22903x8 = i10;
        this.f22904y8 = i11;
        this.f22905z8 = i12;
        this.A8 = i13;
    }

    public int getConstrainLength() {
        return this.f22902w8;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        d dVar = this.f22896q8;
        return (dVar == null || dVar.getCount() == 0) ? super.getCurrentItem() : super.getCurrentItem() % this.f22896q8.b();
    }

    public int getCurrentItemFake() {
        return super.getCurrentItem();
    }

    public int getNextItem() {
        if (this.f22896q8.getCount() != 0) {
            return (super.getCurrentItem() + 1) % this.f22896q8.b();
        }
        return 0;
    }

    public float getRatio() {
        return this.B8;
    }

    public UltraViewPager.ScrollMode getScrollMode() {
        return this.C8;
    }

    public final MotionEvent h0(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.C8 != UltraViewPager.ScrollMode.VERTICAL) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(h0(motionEvent));
        h0(motionEvent);
        return zOnInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        e0(i10, i11);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f22897r8 = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.C8 == UltraViewPager.ScrollMode.VERTICAL ? super.onTouchEvent(h0(motionEvent)) : super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(k2.a aVar) {
        if (aVar == null) {
            super.setAdapter(aVar);
            return;
        }
        d dVar = this.f22896q8;
        if (dVar == null || dVar.a() != aVar) {
            d dVar2 = new d(aVar);
            this.f22896q8 = dVar2;
            dVar2.f(this);
            this.f22896q8.g(this.f22899t8);
            this.f22896q8.i(this.f22898s8);
            this.f22897r8 = true;
            this.f22902w8 = 0;
            super.setAdapter(this.f22896q8);
        }
    }

    public void setAutoMeasureHeight(boolean z10) {
        this.f22900u8 = z10;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10) {
        U(i10, false);
    }

    public void setEnableLoop(boolean z10) {
        this.f22899t8 = z10;
        d dVar = this.f22896q8;
        if (dVar != null) {
            dVar.g(z10);
        }
    }

    public void setItemRatio(double d10) {
        this.f22901v8 = d10;
    }

    public void setMultiScreen(float f10) {
        this.f22898s8 = f10;
        d dVar = this.f22896q8;
        if (dVar != null) {
            dVar.i(f10);
            this.f22897r8 = true;
        }
        float f11 = (1.0f - f10) * getResources().getDisplayMetrics().widthPixels;
        if (this.C8 == UltraViewPager.ScrollMode.VERTICAL) {
            setPageMargin((int) f11);
        } else {
            setPageMargin((int) (-f11));
        }
    }

    public void setRatio(float f10) {
        this.B8 = f10;
    }

    public void setScrollMode(UltraViewPager.ScrollMode scrollMode) {
        this.C8 = scrollMode;
        if (scrollMode == UltraViewPager.ScrollMode.VERTICAL) {
            Y(false, new yg.c());
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22898s8 = Float.NaN;
        this.f22901v8 = Double.NaN;
        this.B8 = Float.NaN;
        this.C8 = UltraViewPager.ScrollMode.HORIZONTAL;
        d0(context, attributeSet);
    }
}
