package androidx.appcompat.widget;

import a.c0;
import a.e5;
import a.eh;
import a.k3;
import a.n5;
import a.o8;
import a.t;
import a.y;
import a.z;
import a.z8;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ActionBarContextView extends e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f8144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f4018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f4020a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f4021b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f4022b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f4023b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4024d;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k3 f8145a;

        public a(ActionBarContextView actionBarContextView, k3 k3Var) {
            this.f8145a = k3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f8145a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        o8 o8VarV = o8.v(context, attributeSet, c0.ActionMode, i, 0);
        eh.m0(this, o8VarV.g(c0.ActionMode_background));
        this.b = o8VarV.n(c0.ActionMode_titleTextStyle, 0);
        this.c = o8VarV.n(c0.ActionMode_subtitleTextStyle, 0);
        ((e5) this).f5966a = o8VarV.m(c0.ActionMode_height, 0);
        this.d = o8VarV.n(c0.ActionMode_closeItemLayout, z.abc_action_mode_close_item_material);
        o8VarV.w();
    }

    public void g() {
        if (this.f8144a == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // a.e5
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // a.e5
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f4023b;
    }

    public CharSequence getTitle() {
        return this.f4020a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(a.k3 r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f8144a
            if (r0 != 0) goto L19
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.d
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f8144a = r0
        L15:
            r3.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r3.f8144a
            goto L15
        L22:
            android.view.View r0 = r3.f8144a
            int r1 = a.y.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r3, r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            a.i4 r4 = (a.i4) r4
            a.n5 r0 = r3.f674a
            if (r0 == 0) goto L3f
            r0.y()
        L3f:
            a.n5 r0 = new a.n5
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f674a = r0
            r1 = 1
            r0.J(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            a.n5 r1 = r3.f674a
            android.content.Context r2 = r3.f675a
            r4.c(r1, r2)
            a.n5 r4 = r3.f674a
            a.w4 r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f676a = r4
            r1 = 0
            a.eh.m0(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f676a
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(a.k3):void");
    }

    public final void i() {
        if (this.f4018a == null) {
            LayoutInflater.from(getContext()).inflate(z.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f4018a = linearLayout;
            this.f4019a = (TextView) linearLayout.findViewById(y.action_bar_title);
            this.f4022b = (TextView) this.f4018a.findViewById(y.action_bar_subtitle);
            if (this.b != 0) {
                this.f4019a.setTextAppearance(getContext(), this.b);
            }
            if (this.c != 0) {
                this.f4022b.setTextAppearance(getContext(), this.c);
            }
        }
        this.f4019a.setText(this.f4020a);
        this.f4022b.setText(this.f4023b);
        boolean z = !TextUtils.isEmpty(this.f4020a);
        boolean z2 = !TextUtils.isEmpty(this.f4023b);
        int i = 0;
        this.f4022b.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.f4018a;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.f4018a.getParent() == null) {
            addView(this.f4018a);
        }
    }

    public boolean j() {
        return this.f4024d;
    }

    public void k() {
        removeAllViews();
        this.f4021b = null;
        ((e5) this).f676a = null;
    }

    public boolean l() {
        n5 n5Var = ((e5) this).f674a;
        if (n5Var != null) {
            return n5Var.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n5 n5Var = ((e5) this).f674a;
        if (n5Var != null) {
            n5Var.B();
            ((e5) this).f674a.C();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(ActionBarContextView.class.getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f4020a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean zB = z8.b(this);
        int paddingRight = zB ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f8144a;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8144a.getLayoutParams();
            int i5 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = e5.d(paddingRight, i5, zB);
            paddingRight = e5.d(iD + e(this.f8144a, iD, paddingTop, paddingTop2, zB), i6, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f4018a;
        if (linearLayout != null && this.f4021b == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f4018a, iE, paddingTop, paddingTop2, zB);
        }
        int i7 = iE;
        View view2 = this.f4021b;
        if (view2 != null) {
            e(view2, i7, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = ((e5) this).f676a;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = ((e5) this).f5966a;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f8144a;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8144a.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = ((e5) this).f676a;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(((e5) this).f676a, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f4018a;
        if (linearLayout != null && this.f4021b == null) {
            if (this.f4024d) {
                this.f4018a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f4018a.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f4018a.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f4021b;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            int i4 = layoutParams.width;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i5 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
            int i6 = layoutParams.height;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f4021b.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(iMin, i5));
        }
        if (((e5) this).f5966a > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // a.e5
    public void setContentHeight(int i) {
        ((e5) this).f5966a = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f4021b;
        if (view2 != null) {
            removeView(view2);
        }
        this.f4021b = view;
        if (view != null && (linearLayout = this.f4018a) != null) {
            removeView(linearLayout);
            this.f4018a = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4023b = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f4020a = charSequence;
        i();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f4024d) {
            requestLayout();
        }
        this.f4024d = z;
    }

    @Override // a.e5, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
