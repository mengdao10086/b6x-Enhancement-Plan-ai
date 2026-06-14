package androidx.appcompat.widget;

import a.c0;
import a.eh;
import a.f5;
import a.g8;
import a.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4013a;
    public Drawable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f4014b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4015b;
    public Drawable c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public View f4016c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4017c;
    public boolean d;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eh.m0(this, new f5(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.ActionBar);
        this.f4012a = typedArrayObtainStyledAttributes.getDrawable(c0.ActionBar_background);
        this.b = typedArrayObtainStyledAttributes.getDrawable(c0.ActionBar_backgroundStacked);
        this.f8143a = typedArrayObtainStyledAttributes.getDimensionPixelSize(c0.ActionBar_height, -1);
        boolean z = true;
        if (getId() == y.split_action_bar) {
            this.f4017c = true;
            this.c = typedArrayObtainStyledAttributes.getDrawable(c0.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f4017c ? this.f4012a != null || this.b != null : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4012a;
        if (drawable != null && drawable.isStateful()) {
            this.f4012a.setState(getDrawableState());
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.b.setState(getDrawableState());
        }
        Drawable drawable3 = this.c;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.c.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f4013a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4012a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f4014b = findViewById(y.action_bar);
        this.f4016c = findViewById(y.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4015b || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
  0x0048: PHI (r0v9 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:32:0x009d, B:34:0x00a1, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f4013a
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L13
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L13
            r1 = r9
            goto L14
        L13:
            r1 = r0
        L14:
            if (r5 == 0) goto L33
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L33
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L33:
            boolean r6 = r4.f4017c
            if (r6 == 0) goto L4a
            android.graphics.drawable.Drawable r5 = r4.c
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lb6
        L48:
            r9 = r0
            goto Lb6
        L4a:
            android.graphics.drawable.Drawable r6 = r4.f4012a
            if (r6 == 0) goto L9b
            android.view.View r6 = r4.f4014b
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L74
            android.graphics.drawable.Drawable r6 = r4.f4012a
            android.view.View r7 = r4.f4014b
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f4014b
            int r8 = r8.getTop()
            android.view.View r0 = r4.f4014b
            int r0 = r0.getRight()
            android.view.View r2 = r4.f4014b
        L6c:
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L9a
        L74:
            android.view.View r6 = r4.f4016c
            if (r6 == 0) goto L95
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L95
            android.graphics.drawable.Drawable r6 = r4.f4012a
            android.view.View r7 = r4.f4016c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f4016c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f4016c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f4016c
            goto L6c
        L95:
            android.graphics.drawable.Drawable r6 = r4.f4012a
            r6.setBounds(r0, r0, r0, r0)
        L9a:
            r0 = r9
        L9b:
            r4.d = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.b
            if (r6 == 0) goto L48
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        Lb6:
            if (r9 == 0) goto Lbb
            r4.invalidate()
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f4014b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1c
            int r0 = r3.f8143a
            if (r0 < 0) goto L1c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f4014b
            if (r4 != 0) goto L24
            return
        L24:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f4013a
            if (r0 == 0) goto L6f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L6f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L6f
            android.view.View r0 = r3.f4014b
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L47
            android.view.View r0 = r3.f4014b
        L42:
            int r0 = r3.a(r0)
            goto L53
        L47:
            android.view.View r0 = r3.f4016c
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L52
            android.view.View r0 = r3.f4016c
            goto L42
        L52:
            r0 = 0
        L53:
            if (r4 != r1) goto L5a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L5d
        L5a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L5d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f4013a
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f4012a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f4012a);
        }
        this.f4012a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f4014b;
            if (view != null) {
                this.f4012a.setBounds(view.getLeft(), this.f4014b.getTop(), this.f4014b.getRight(), this.f4014b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f4017c ? this.f4012a != null || this.b != null : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f4017c && (drawable2 = this.c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f4017c ? !(this.f4012a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && (drawable2 = this.b) != null) {
                drawable2.setBounds(this.f4013a.getLeft(), this.f4013a.getTop(), this.f4013a.getRight(), this.f4013a.getBottom());
            }
        }
        boolean z = true;
        if (!this.f4017c ? this.f4012a != null || this.b != null : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(g8 g8Var) {
        View view = this.f4013a;
        if (view != null) {
            removeView(view);
        }
        this.f4013a = g8Var;
        if (g8Var != null) {
            addView(g8Var);
            ViewGroup.LayoutParams layoutParams = g8Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            g8Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f4015b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f4012a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f4012a && !this.f4017c) || (drawable == this.b && this.d) || ((drawable == this.c && this.f4017c) || super.verifyDrawable(drawable));
    }
}
