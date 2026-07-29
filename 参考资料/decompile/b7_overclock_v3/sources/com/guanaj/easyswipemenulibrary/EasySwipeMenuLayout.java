package com.guanaj.easyswipemenulibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class EasySwipeMenuLayout extends ViewGroup {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f21689t = "EasySwipeMenuLayout";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static EasySwipeMenuLayout f21690u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static State f21691v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f21692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f21696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f21697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f21698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup.MarginLayoutParams f21699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PointF f21701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f21702k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f21703l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21704m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21705n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21706o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Scroller f21707p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f21708q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f21709r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public State f21710s;

    public EasySwipeMenuLayout(Context context) {
        this(context, null);
    }

    public static State getStateCache() {
        return f21691v;
    }

    public static EasySwipeMenuLayout getViewCache() {
        return f21690u;
    }

    public final void a(State state) {
        if (state == State.LEFTOPEN) {
            this.f21707p.startScroll(getScrollX(), 0, this.f21696e.getLeft() - getScrollX(), 0);
            f21690u = this;
            f21691v = state;
        } else if (state == State.RIGHTOPEN) {
            f21690u = this;
            this.f21707p.startScroll(getScrollX(), 0, ((this.f21697f.getRight() - this.f21698g.getRight()) - this.f21699h.rightMargin) - getScrollX(), 0);
            f21691v = state;
        } else {
            this.f21707p.startScroll(getScrollX(), 0, -getScrollX(), 0);
            f21690u = null;
            f21691v = null;
        }
        invalidate();
    }

    public final void b(Context context, AttributeSet attributeSet, int i10) {
        this.f21706o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f21707p = new Scroller(context);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.EasySwipeMenuLayout, i10, 0);
        try {
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i11 = 0; i11 < indexCount; i11++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i11);
                    int i12 = R.styleable.EasySwipeMenuLayout_leftMenuView;
                    if (index == i12) {
                        this.f21693b = typedArrayObtainStyledAttributes.getResourceId(i12, -1);
                    } else {
                        int i13 = R.styleable.EasySwipeMenuLayout_rightMenuView;
                        if (index == i13) {
                            this.f21694c = typedArrayObtainStyledAttributes.getResourceId(i13, -1);
                        } else {
                            int i14 = R.styleable.EasySwipeMenuLayout_contentView;
                            if (index == i14) {
                                this.f21695d = typedArrayObtainStyledAttributes.getResourceId(i14, -1);
                            } else {
                                int i15 = R.styleable.EasySwipeMenuLayout_canLeftSwipe;
                                if (index == i15) {
                                    this.f21704m = typedArrayObtainStyledAttributes.getBoolean(i15, true);
                                } else {
                                    int i16 = R.styleable.EasySwipeMenuLayout_canRightSwipe;
                                    if (index == i16) {
                                        this.f21705n = typedArrayObtainStyledAttributes.getBoolean(i16, true);
                                    } else {
                                        int i17 = R.styleable.EasySwipeMenuLayout_fraction;
                                        if (index == i17) {
                                            this.f21703l = typedArrayObtainStyledAttributes.getFloat(i17, 0.5f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public boolean c() {
        return this.f21704m;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f21707p.computeScrollOffset()) {
            scrollTo(this.f21707p.getCurrX(), this.f21707p.getCurrY());
            invalidate();
        }
    }

    public boolean d() {
        return this.f21705n;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean e() {
        return this.f21708q < 0.0f;
    }

    public final State f(int i10) {
        View view;
        View view2;
        if (this.f21706o >= Math.abs(this.f21709r)) {
            return f21691v;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">>>finalyDistanceX:");
        sb2.append(this.f21709r);
        float f10 = this.f21709r;
        if (f10 < 0.0f) {
            if (getScrollX() < 0 && (view2 = this.f21696e) != null && Math.abs(view2.getWidth() * this.f21703l) < Math.abs(getScrollX())) {
                return State.LEFTOPEN;
            }
            if (getScrollX() > 0 && this.f21697f != null) {
                return State.CLOSE;
            }
        } else if (f10 > 0.0f) {
            if (getScrollX() > 0 && (view = this.f21697f) != null && Math.abs(view.getWidth() * this.f21703l) < Math.abs(getScrollX())) {
                return State.RIGHTOPEN;
            }
            if (getScrollX() < 0 && this.f21696e != null) {
                return State.CLOSE;
            }
        }
        return State.CLOSE;
    }

    public void g() {
        State state;
        Scroller scroller;
        if (f21690u == null || (state = f21691v) == null || state == State.CLOSE || (scroller = this.f21707p) == null) {
            return;
        }
        scroller.startScroll(f21690u.getScrollX(), 0, -f21690u.getScrollX(), 0);
        f21690u.invalidate();
        f21690u = null;
        f21691v = null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public float getFraction() {
        return this.f21703l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EasySwipeMenuLayout easySwipeMenuLayout = f21690u;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(f21691v);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        EasySwipeMenuLayout easySwipeMenuLayout = f21690u;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(State.CLOSE);
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == r1) goto L1c
            r2 = 2
            if (r0 == r2) goto Le
            r2 = 3
            if (r0 == r2) goto L1c
            goto L27
        Le:
            float r0 = r3.f21709r
            float r0 = java.lang.Math.abs(r0)
            int r2 = r3.f21706o
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            return r1
        L1c:
            boolean r0 = r3.f21700i
            if (r0 == 0) goto L27
            r4 = 0
            r3.f21700i = r4
            r4 = 0
            r3.f21709r = r4
            return r1
        L27:
            boolean r4 = super.onInterceptTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        getPaddingLeft();
        int paddingTop = getPaddingTop() + 0;
        getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (this.f21696e == null && childAt.getId() == this.f21693b) {
                this.f21696e = childAt;
                childAt.setClickable(true);
            } else if (this.f21697f == null && childAt.getId() == this.f21694c) {
                this.f21697f = childAt;
                childAt.setClickable(true);
            } else if (this.f21698g == null && childAt.getId() == this.f21695d) {
                this.f21698g = childAt;
                childAt.setClickable(true);
            }
        }
        View view = this.f21698g;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            this.f21699h = marginLayoutParams;
            int i15 = marginLayoutParams.topMargin + paddingTop;
            int i16 = marginLayoutParams.leftMargin;
            this.f21698g.layout(paddingLeft + i16, i15, paddingLeft + i16 + this.f21698g.getMeasuredWidth(), this.f21698g.getMeasuredHeight() + i15);
        }
        View view2 = this.f21696e;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i17 = marginLayoutParams2.topMargin + paddingTop;
            int measuredWidth = (0 - this.f21696e.getMeasuredWidth()) + marginLayoutParams2.leftMargin;
            int i18 = marginLayoutParams2.rightMargin;
            this.f21696e.layout(measuredWidth + i18, i17, 0 - i18, this.f21696e.getMeasuredHeight() + i17);
        }
        View view3 = this.f21697f;
        if (view3 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            int i19 = paddingTop + marginLayoutParams3.topMargin;
            int right = this.f21698g.getRight() + this.f21699h.rightMargin + marginLayoutParams3.leftMargin;
            this.f21697f.layout(right, i19, this.f21697f.getMeasuredWidth() + right, this.f21697f.getMeasuredHeight() + i19);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setClickable(true);
        int childCount = getChildCount();
        boolean z10 = (View.MeasureSpec.getMode(i10) == 1073741824 && View.MeasureSpec.getMode(i11) == 1073741824) ? false : true;
        this.f21692a.clear();
        int iCombineMeasuredStates = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i10, 0, i11, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                iMax = Math.max(iMax, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                iCombineMeasuredStates = ViewGroup.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                if (z10 && (marginLayoutParams.width == -1 || marginLayoutParams.height == -1)) {
                    this.f21692a.add(childAt);
                }
            }
        }
        int i13 = iCombineMeasuredStates;
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(iMax, getSuggestedMinimumWidth()), i10, i13), ViewGroup.resolveSizeAndState(Math.max(iMax2, getSuggestedMinimumHeight()), i11, i13 << 16));
        int size = this.f21692a.size();
        if (size > 1) {
            for (int i14 = 0; i14 < size; i14++) {
                View view = this.f21692a.get(i14);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i15 = marginLayoutParams2.width;
                int iMakeMeasureSpec = i15 == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i10, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, i15);
                int i16 = marginLayoutParams2.height;
                view.measure(iMakeMeasureSpec, i16 == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i11, marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin, i16));
            }
        }
    }

    public void setCanLeftSwipe(boolean z10) {
        this.f21704m = z10;
    }

    public void setCanRightSwipe(boolean z10) {
        this.f21705n = z10;
    }

    public void setFraction(float f10) {
        this.f21703l = f10;
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21692a = new ArrayList<>(1);
        this.f21703l = 0.3f;
        this.f21704m = true;
        this.f21705n = true;
        b(context, attributeSet, i10);
    }
}
