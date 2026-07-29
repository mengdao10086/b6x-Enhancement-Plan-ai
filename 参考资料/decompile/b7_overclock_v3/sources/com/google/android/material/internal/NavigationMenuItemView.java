package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.i0;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends h implements k.a {
    public static final int[] I7 = {R.attr.state_checked};
    public boolean C1;
    public FrameLayout C2;
    public ColorStateList E7;
    public boolean F7;
    public Drawable G7;
    public final androidx.core.view.a H7;
    public boolean K1;
    public androidx.appcompat.view.menu.h K2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f20313v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final CheckedTextView f20314v2;

    public class a extends androidx.core.view.a {
        public a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.Z0(NavigationMenuItemView.this.K1);
        }
    }

    public NavigationMenuItemView(@n0 Context context) {
        this(context, null);
    }

    private void setActionView(@p0 View view) {
        if (view != null) {
            if (this.C2 == null) {
                this.C2 = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.C2.removeAllViews();
            this.C2.addView(view);
        }
    }

    public final void F() {
        if (I()) {
            this.f20314v2.setVisibility(8);
            FrameLayout frameLayout = this.C2;
            if (frameLayout != null) {
                i0.b bVar = (i0.b) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) bVar).width = -1;
                this.C2.setLayoutParams(bVar);
                return;
            }
            return;
        }
        this.f20314v2.setVisibility(0);
        FrameLayout frameLayout2 = this.C2;
        if (frameLayout2 != null) {
            i0.b bVar2 = (i0.b) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) bVar2).width = -2;
            this.C2.setLayoutParams(bVar2);
        }
    }

    @p0
    public final StateListDrawable G() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(I7, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public void H() {
        FrameLayout frameLayout = this.C2;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f20314v2.setCompoundDrawables(null, null, null, null);
    }

    public final boolean I() {
        return this.K2.getTitle() == null && this.K2.getIcon() == null && this.K2.getActionView() != null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(boolean z10, char c10) {
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean g() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.h getItemData() {
        return this.K2;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void h(@n0 androidx.appcompat.view.menu.h hVar, int i10) {
        this.K2 = hVar;
        if (hVar.getItemId() > 0) {
            setId(hVar.getItemId());
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            u0.I1(this, G());
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.getTitle());
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
        setContentDescription(hVar.getContentDescription());
        b1.a(this, hVar.getTooltipText());
        F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        androidx.appcompat.view.menu.h hVar = this.K2;
        if (hVar != null && hVar.isCheckable() && this.K2.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, I7);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.K1 != z10) {
            this.K1 = z10;
            this.H7.l(this.f20314v2, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.f20314v2.setChecked(z10);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setIcon(@p0 Drawable drawable) {
        if (drawable != null) {
            if (this.F7) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = n0.c.r(drawable).mutate();
                n0.c.o(drawable, this.E7);
            }
            int i10 = this.f20313v1;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.C1) {
            if (this.G7 == null) {
                Drawable drawableG = j0.i.g(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.G7 = drawableG;
                if (drawableG != null) {
                    int i11 = this.f20313v1;
                    drawableG.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.G7;
        }
        androidx.core.widget.r.w(this.f20314v2, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f20314v2.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(@g.r int i10) {
        this.f20313v1 = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.E7 = colorStateList;
        this.F7 = colorStateList != null;
        androidx.appcompat.view.menu.h hVar = this.K2;
        if (hVar != null) {
            setIcon(hVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f20314v2.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.C1 = z10;
    }

    public void setTextAppearance(int i10) {
        androidx.core.widget.r.E(this.f20314v2, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f20314v2.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setTitle(CharSequence charSequence) {
        this.f20314v2.setText(charSequence);
    }

    public NavigationMenuItemView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a aVar = new a();
        this.H7 = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.f20314v2 = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        u0.B1(checkedTextView, aVar);
    }
}
