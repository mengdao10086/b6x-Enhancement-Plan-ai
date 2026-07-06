package com.google.android.material.snackbar;

import a.fv;
import a.x00;
import a.zu;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] b = {zu.snackbarButtonStyle, zu.snackbarTextViewStyle};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AccessibilityManager f4674b;
    public boolean c;

    public static final class SnackbarLayout extends BaseTransientBottomBar.b {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public Snackbar(ViewGroup viewGroup, View view, x00 x00Var) {
        super(viewGroup, view, x00Var);
        this.f4674b = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static ViewGroup U(View view) {
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

    public static boolean V(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(b);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public static Snackbar W(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupU = U(view);
        if (viewGroupU == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(viewGroupU.getContext()).inflate(V(viewGroupU.getContext()) ? fv.mtrl_layout_snackbar_include : fv.design_layout_snackbar_include, viewGroupU, false);
        Snackbar snackbar = new Snackbar(viewGroupU, snackbarContentLayout, snackbarContentLayout);
        snackbar.X(charSequence);
        snackbar.I(i);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void M() {
        super.M();
    }

    public Snackbar X(CharSequence charSequence) {
        ((SnackbarContentLayout) ((BaseTransientBottomBar) this).f4663a.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void s() {
        super.s();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int v() {
        int iV = super.v();
        if (iV == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f4674b.getRecommendedTimeoutMillis(iV, (this.c ? 4 : 0) | 1 | 2);
        }
        if (this.c && this.f4674b.isTouchExplorationEnabled()) {
            return -2;
        }
        return iV;
    }
}
