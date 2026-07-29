package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends ListView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f2420o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2421p = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f2422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Field f2428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f2429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.core.view.b1 f2433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.core.widget.m f2434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f2435n;

    @g.v0(21)
    public static class a {
        @g.u
        public static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    @g.v0(30)
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Method f2436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Method f2437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f2438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f2439d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f2436a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f2437b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f2438c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f2439d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        public static boolean a() {
            return f2439d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void b(e0 e0Var, int i10, View view) {
            try {
                f2436a.invoke(e0Var, Integer.valueOf(i10), view, Boolean.FALSE, -1, -1);
                f2437b.invoke(e0Var, Integer.valueOf(i10));
                f2438c.invoke(e0Var, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static class c extends androidx.appcompat.graphics.drawable.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2440b;

        public c(Drawable drawable) {
            super(drawable);
            this.f2440b = true;
        }

        public void c(boolean z10) {
            this.f2440b = z10;
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f2440b) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f2440b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f2440b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f2440b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f2440b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void a() {
            e0.this.post(this);
        }

        public void cancel() {
            e0 e0Var = e0.this;
            e0Var.f2435n = null;
            e0Var.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 e0Var = e0.this;
            e0Var.f2435n = null;
            e0Var.drawableStateChanged();
        }
    }

    public e0(@g.n0 Context context, boolean z10) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f2422a = new Rect();
        this.f2423b = 0;
        this.f2424c = 0;
        this.f2425d = 0;
        this.f2426e = 0;
        this.f2431j = z10;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2428g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z10) {
        c cVar = this.f2429h;
        if (cVar != null) {
            cVar.c(z10);
        }
    }

    public final void a() {
        this.f2432k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f2427f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.b1 b1Var = this.f2433l;
        if (b1Var != null) {
            b1Var.d();
            this.f2433l = null;
        }
    }

    public final void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f2422a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f2422a);
        selector.draw(canvas);
    }

    public int d(int i10, boolean z10) {
        int iMin;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z10) {
                    iMin = Math.max(0, i10);
                    while (iMin < count && !adapter.isEnabled(iMin)) {
                        iMin++;
                    }
                } else {
                    iMin = Math.min(i10, count - 1);
                    while (iMin >= 0 && !adapter.isEnabled(iMin)) {
                        iMin--;
                    }
                }
                if (iMin < 0 || iMin >= count) {
                    return -1;
                }
                return iMin;
            }
            if (i10 >= 0 && i10 < count) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f2435n != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        l();
    }

    public int e(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < count) {
            int itemViewType = adapter.getItemViewType(i15);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i15, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i18 = layoutParams.height;
            view.measure(i10, i18 > 0 ? View.MeasureSpec.makeMeasureSpec(i18, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i15 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i13) {
                return (i14 < 0 || i15 <= i14 || i17 <= 0 || measuredHeight == i13) ? i13 : i17;
            }
            if (i14 >= 0 && i15 >= i14) {
                i17 = measuredHeight;
            }
            i15++;
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.j(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.m r9 = r7.f2434m
            if (r9 != 0) goto L5a
            androidx.core.widget.m r9 = new androidx.core.widget.m
            r9.<init>(r7)
            r7.f2434m = r9
        L5a:
            androidx.core.widget.m r9 = r7.f2434m
            r9.o(r2)
            androidx.core.widget.m r9 = r7.f2434m
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.m r8 = r7.f2434m
            if (r8 == 0) goto L6c
            r8.o(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e0.f(android.view.MotionEvent, int):boolean");
    }

    public final void g(int i10, View view) {
        Rect rect = this.f2422a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2423b;
        rect.top -= this.f2424c;
        rect.right += this.f2425d;
        rect.bottom += this.f2426e;
        try {
            boolean z10 = this.f2428g.getBoolean(this);
            if (view.isEnabled() != z10) {
                this.f2428g.set(this, Boolean.valueOf(!z10));
                if (i10 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    public final void h(int i10, View view) {
        Drawable selector = getSelector();
        boolean z10 = (selector == null || i10 == -1) ? false : true;
        if (z10) {
            selector.setVisible(false, false);
        }
        g(i10, view);
        if (z10) {
            Rect rect = this.f2422a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            n0.c.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f2431j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f2431j || super.hasWindowFocus();
    }

    public final void i(int i10, View view, float f10, float f11) {
        h(i10, view);
        Drawable selector = getSelector();
        if (selector == null || i10 == -1) {
            return;
        }
        n0.c.k(selector, f10, f11);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f2431j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f2431j && this.f2430i) || super.isInTouchMode();
    }

    public final void j(View view, int i10, float f10, float f11) {
        View childAt;
        this.f2432k = true;
        a.a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.f2427f;
        if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f2427f = i10;
        a.a(view, f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        i(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public final boolean k() {
        return this.f2432k;
    }

    public final void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f2435n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@g.n0 MotionEvent motionEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f2435n == null) {
            d dVar = new d();
            this.f2435n = dVar;
            dVar.a();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2427f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        d dVar = this.f2435n;
        if (dVar != null) {
            dVar.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f2430i = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        c cVar = drawable != null ? new c(drawable) : null;
        this.f2429h = cVar;
        super.setSelector(cVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2423b = rect.left;
        this.f2424c = rect.top;
        this.f2425d = rect.right;
        this.f2426e = rect.bottom;
    }
}
