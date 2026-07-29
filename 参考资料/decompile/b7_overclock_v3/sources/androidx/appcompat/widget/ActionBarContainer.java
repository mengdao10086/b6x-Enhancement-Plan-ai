package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f2009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f2010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f2012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2015j;

    @g.v0(21)
    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
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
        Drawable drawable = this.f2010e;
        if (drawable != null && drawable.isStateful()) {
            this.f2010e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2011f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2011f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2012g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2012g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2007b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2010e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2011f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2012g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2008c = findViewById(R.id.action_bar);
        this.f2009d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2006a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f2007b;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f2013h) {
            Drawable drawable2 = this.f2012g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f2010e != null) {
                if (this.f2008c.getVisibility() == 0) {
                    this.f2010e.setBounds(this.f2008c.getLeft(), this.f2008c.getTop(), this.f2008c.getRight(), this.f2008c.getBottom());
                } else {
                    View view2 = this.f2009d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f2010e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2010e.setBounds(this.f2009d.getLeft(), this.f2009d.getTop(), this.f2009d.getRight(), this.f2009d.getBottom());
                    }
                }
                z12 = true;
            }
            this.f2014i = z13;
            if (!z13 || (drawable = this.f2011f) == null) {
                z11 = z12;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f2008c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f2015j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f2008c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f2007b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f2008c) ? a(this.f2008c) : !b(this.f2009d) ? a(this.f2009d) : 0) + a(this.f2007b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2010e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2010e);
        }
        this.f2010e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2008c;
            if (view != null) {
                this.f2010e.setBounds(view.getLeft(), this.f2008c.getTop(), this.f2008c.getRight(), this.f2008c.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f2013h ? this.f2010e != null || this.f2011f != null : this.f2012g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2012g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2012g);
        }
        this.f2012g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2013h && (drawable2 = this.f2012g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2013h ? !(this.f2010e != null || this.f2011f != null) : this.f2012g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2011f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2011f);
        }
        this.f2011f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2014i && (drawable2 = this.f2011f) != null) {
                drawable2.setBounds(this.f2007b.getLeft(), this.f2007b.getTop(), this.f2007b.getRight(), this.f2007b.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f2013h ? this.f2010e != null || this.f2011f != null : this.f2012g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(q0 q0Var) {
        View view = this.f2007b;
        if (view != null) {
            removeView(view);
        }
        this.f2007b = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f2006a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f2010e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f2011f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f2012g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2010e && !this.f2013h) || (drawable == this.f2011f && this.f2014i) || ((drawable == this.f2012g && this.f2013h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.view.u0.I1(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f2010e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f2011f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f2015j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R.id.split_action_bar) {
            this.f2013h = true;
            this.f2012g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2013h ? this.f2010e != null || this.f2011f != null : this.f2012g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }
}
