package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import g.c1;
import g.l;
import g.n0;
import g.p0;
import g.r;

/* JADX INFO: loaded from: classes3.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] M;
    public static final int[] N;

    @p0
    public final AccessibilityManager J;
    public boolean K;

    @p0
    public BaseTransientBottomBar.s<Snackbar> L;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.w {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@p0 Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@p0 Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@p0 ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@p0 PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@p0 View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class a extends BaseTransientBottomBar.s<Snackbar> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f20746f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f20747g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f20748h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f20749i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f20750j = 4;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Snackbar snackbar, int i10) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Snackbar snackbar) {
        }
    }

    static {
        int i10 = R.attr.snackbarButtonStyle;
        M = new int[]{i10};
        N = new int[]{i10, R.attr.snackbarTextViewStyle};
    }

    public Snackbar(@n0 Context context, @n0 ViewGroup viewGroup, @n0 View view, @n0 me.a aVar) {
        super(context, viewGroup, view, aVar);
        this.J = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @n0
    public static Snackbar A0(@n0 Context context, @n0 View view, @n0 CharSequence charSequence, int i10) {
        return D0(context, view, charSequence, i10);
    }

    @n0
    public static Snackbar B0(@n0 View view, @c1 int i10, int i11) {
        return C0(view, view.getResources().getText(i10), i11);
    }

    @n0
    public static Snackbar C0(@n0 View view, @n0 CharSequence charSequence, int i10) {
        return D0(null, view, charSequence, i10);
    }

    @n0
    public static Snackbar D0(@p0 Context context, @n0 View view, @n0 CharSequence charSequence, int i10) {
        ViewGroup viewGroupT0 = t0(view);
        if (viewGroupT0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupT0.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(y0(context) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroupT0, false);
        Snackbar snackbar = new Snackbar(context, viewGroupT0, snackbarContentLayout, snackbarContentLayout);
        snackbar.O0(charSequence);
        snackbar.f0(i10);
        return snackbar;
    }

    @p0
    public static ViewGroup t0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @Deprecated
    public static boolean x0(@n0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(M);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public static boolean y0(@n0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(N);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        y(1);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int E() {
        int iE = super.E();
        if (iE == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.J.getRecommendedTimeoutMillis(iE, (this.K ? 4 : 0) | 1 | 2);
        }
        if (this.K && this.J.isTouchExplorationEnabled()) {
            return -2;
        }
        return iE;
    }

    @n0
    public Snackbar E0(@c1 int i10, View.OnClickListener onClickListener) {
        return F0(D().getText(i10), onClickListener);
    }

    @n0
    public Snackbar F0(@p0 CharSequence charSequence, @p0 final View.OnClickListener onClickListener) {
        Button buttonU0 = u0();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            buttonU0.setVisibility(8);
            buttonU0.setOnClickListener(null);
            this.K = false;
        } else {
            this.K = true;
            buttonU0.setVisibility(0);
            buttonU0.setText(charSequence);
            buttonU0.setOnClickListener(new View.OnClickListener() { // from class: me.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41198a.z0(onClickListener, view);
                }
            });
        }
        return this;
    }

    @n0
    public Snackbar G0(@l int i10) {
        u0().setTextColor(i10);
        return this;
    }

    @n0
    public Snackbar H0(ColorStateList colorStateList) {
        u0().setTextColor(colorStateList);
        return this;
    }

    @n0
    public Snackbar I0(@l int i10) {
        return J0(ColorStateList.valueOf(i10));
    }

    @n0
    public Snackbar J0(@p0 ColorStateList colorStateList) {
        this.f20688c.setBackgroundTintList(colorStateList);
        return this;
    }

    @n0
    public Snackbar K0(@p0 PorterDuff.Mode mode) {
        this.f20688c.setBackgroundTintMode(mode);
        return this;
    }

    @n0
    @Deprecated
    public Snackbar L0(@p0 a aVar) {
        BaseTransientBottomBar.s<Snackbar> sVar = this.L;
        if (sVar != null) {
            Z(sVar);
        }
        if (aVar != null) {
            r(aVar);
        }
        this.L = aVar;
        return this;
    }

    @n0
    public Snackbar M0(@r int i10) {
        v0().setMaxInlineActionWidth(i10);
        return this;
    }

    @n0
    public Snackbar N0(@c1 int i10) {
        return O0(D().getText(i10));
    }

    @n0
    public Snackbar O0(@n0 CharSequence charSequence) {
        w0().setText(charSequence);
        return this;
    }

    @n0
    public Snackbar P0(@l int i10) {
        w0().setTextColor(i10);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean Q() {
        return super.Q();
    }

    @n0
    public Snackbar Q0(ColorStateList colorStateList) {
        w0().setTextColor(colorStateList);
        return this;
    }

    @n0
    public Snackbar R0(int i10) {
        w0().setMaxLines(i10);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void k0() {
        super.k0();
    }

    public final Button u0() {
        return v0().getActionView();
    }

    public final SnackbarContentLayout v0() {
        return (SnackbarContentLayout) this.f20688c.getChildAt(0);
    }

    public final TextView w0() {
        return v0().getMessageView();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void x() {
        super.x();
    }
}
