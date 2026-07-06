package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h7 extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f7 f1125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g7 f1126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jj f1127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lh f1128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Field f1130a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1131b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1132c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1133d;
    public int e;

    public h7(Context context, boolean z) {
        super(context, null, t.dropDownListViewStyle);
        this.f1129a = new Rect();
        this.f6282a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f1132c = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1130a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public final void a() {
        this.f1133d = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.e - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        lh lhVar = this.f1128a;
        if (lhVar != null) {
            lhVar.b();
            this.f1128a = null;
        }
    }

    public final void b(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f1129a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1129a);
        selector.draw(canvas);
    }

    public int d(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        View view = null;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i6 <= i5 || i8 <= 0 || measuredHeight == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i6 >= i5) {
                i8 = measuredHeight;
            }
            i6++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1126a != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
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
            r9 = r1
            r3 = r2
            goto L46
        L11:
            r9 = r1
            r3 = r9
            goto L46
        L14:
            r3 = r2
            goto L17
        L16:
            r3 = r1
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
            r9 = r2
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
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
            a.jj r9 = r7.f1127a
            if (r9 != 0) goto L5a
            a.jj r9 = new a.jj
            r9.<init>(r7)
            r7.f1127a = r9
        L5a:
            a.jj r9 = r7.f1127a
            r9.m(r2)
            a.jj r9 = r7.f1127a
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            a.jj r8 = r7.f1127a
            if (r8 == 0) goto L6c
            r8.m(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h7.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i, View view) {
        Rect rect = this.f1129a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f6282a;
        rect.top -= this.b;
        rect.right += this.c;
        rect.bottom += this.d;
        try {
            boolean z = this.f1130a.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1130a.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final void g(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        f(i, view);
        if (z) {
            Rect rect = this.f1129a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            kd.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void h(int i, View view, float f, float f2) {
        g(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        kd.k(selector, f, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1132c || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1132c || super.hasWindowFocus();
    }

    public final void i(View view, int i, float f, float f2) {
        View childAt;
        this.f1133d = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.e;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.e = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i, view, f, f2);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1132c || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1132c && this.f1131b) || super.isInTouchMode();
    }

    public final void j(boolean z) {
        f7 f7Var = this.f1125a;
        if (f7Var != null) {
            f7Var.c(z);
        }
    }

    public final boolean k() {
        return this.f1133d;
    }

    public final void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1126a = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1126a == null) {
            g7 g7Var = new g7(this);
            this.f1126a = g7Var;
            g7Var.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
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
            this.e = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        g7 g7Var = this.f1126a;
        if (g7Var != null) {
            g7Var.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f1131b = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        f7 f7Var = drawable != null ? new f7(drawable) : null;
        this.f1125a = f7Var;
        super.setSelector(f7Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f6282a = rect.left;
        this.b = rect.top;
        this.c = rect.right;
        this.d = rect.bottom;
    }
}
