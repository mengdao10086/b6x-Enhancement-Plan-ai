package com.google.android.material.internal;

import a.bv;
import a.cv;
import a.dv;
import a.eh;
import a.fv;
import a.kd;
import a.l4;
import a.m7;
import a.ni;
import a.oj;
import a.rc;
import a.rf;
import a.t;
import a.t8;
import a.tx;
import a.w4;
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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class NavigationMenuItemView extends tx implements w4.a {
    public static final int[] c = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l4 f8314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rf f4647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CheckedTextView f4649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f4650a;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f4651c;
    public boolean f;
    public boolean g;
    public boolean h;
    public int k;

    public class a extends rf {
        public a() {
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            niVar.Y(NavigationMenuItemView.this.g);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4647a = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(fv.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(bv.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(dv.design_menu_item_text);
        this.f4649a = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        eh.k0(this.f4649a, this.f4647a);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f4650a == null) {
                this.f4650a = (FrameLayout) ((ViewStub) findViewById(dv.design_menu_item_action_area_stub)).inflate();
            }
            this.f4650a.removeAllViews();
            this.f4650a.addView(view);
        }
    }

    public final void B() {
        m7.a aVar;
        int i;
        if (D()) {
            this.f4649a.setVisibility(8);
            FrameLayout frameLayout = this.f4650a;
            if (frameLayout == null) {
                return;
            }
            aVar = (m7.a) frameLayout.getLayoutParams();
            i = -1;
        } else {
            this.f4649a.setVisibility(0);
            FrameLayout frameLayout2 = this.f4650a;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (m7.a) frameLayout2.getLayoutParams();
            i = -2;
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i;
        this.f4650a.setLayoutParams(aVar);
    }

    public final StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(t.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public final boolean D() {
        return this.f8314a.getTitle() == null && this.f8314a.getIcon() == null && this.f8314a.getActionView() != null;
    }

    @Override // a.w4.a
    public boolean a() {
        return false;
    }

    @Override // a.w4.a
    public void e(l4 l4Var, int i) {
        this.f8314a = l4Var;
        if (l4Var.getItemId() > 0) {
            setId(l4Var.getItemId());
        }
        setVisibility(l4Var.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            eh.m0(this, C());
        }
        setCheckable(l4Var.isCheckable());
        setChecked(l4Var.isChecked());
        setEnabled(l4Var.isEnabled());
        setTitle(l4Var.getTitle());
        setIcon(l4Var.getIcon());
        setActionView(l4Var.getActionView());
        setContentDescription(l4Var.getContentDescription());
        t8.a(this, l4Var.getTooltipText());
        B();
    }

    @Override // a.w4.a
    public l4 getItemData() {
        return this.f8314a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        l4 l4Var = this.f8314a;
        if (l4Var != null && l4Var.isCheckable() && this.f8314a.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, c);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.g != z) {
            this.g = z;
            this.f4647a.l(this.f4649a, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f4649a.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.h) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = kd.r(drawable).mutate();
                kd.o(drawable, this.f4648a);
            }
            int i = this.k;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f) {
            if (this.f4651c == null) {
                Drawable drawableA = rc.a(getResources(), cv.navigation_empty_icon, getContext().getTheme());
                this.f4651c = drawableA;
                if (drawableA != null) {
                    int i2 = this.k;
                    drawableA.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.f4651c;
        }
        oj.l(this.f4649a, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f4649a.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.k = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f4648a = colorStateList;
        this.h = colorStateList != null;
        l4 l4Var = this.f8314a;
        if (l4Var != null) {
            setIcon(l4Var.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f4649a.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f = z;
    }

    public void setTextAppearance(int i) {
        oj.q(this.f4649a, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f4649a.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f4649a.setText(charSequence);
    }
}
