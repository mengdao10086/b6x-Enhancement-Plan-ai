package com.google.android.material.chip;

import a.dy;
import a.eh;
import a.iv;
import a.jv;
import a.ni;
import a.r20;
import a.sx;
import a.zu;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ChipGroup extends sx {
    public static final int g = iv.Widget_MaterialComponents_ChipGroup;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f4627a;
    public boolean c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4628d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4629e;
    public int f;

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.f4629e) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f4628d) {
                ChipGroup.this.q(compoundButton.getId(), true);
                ChipGroup.this.p(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z) {
                if (ChipGroup.this.f == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.f != -1 && ChipGroup.this.f != id && ChipGroup.this.c) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.q(chipGroup.f, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface d {
        void a(ChipGroup chipGroup, int i);
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f8303a;

        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : view2.hashCode());
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f8301a);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8303a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f8303a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, g), attributeSet, i);
        this.f8301a = new b();
        this.f4627a = new e();
        this.f = -1;
        this.f4629e = false;
        TypedArray typedArrayH = dy.h(getContext(), attributeSet, jv.ChipGroup, i, g, new int[0]);
        int dimensionPixelOffset = typedArrayH.getDimensionPixelOffset(jv.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayH.getDimensionPixelOffset(jv.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayH.getDimensionPixelOffset(jv.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayH.getBoolean(jv.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayH.getBoolean(jv.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayH.getBoolean(jv.ChipGroup_selectionRequired, false));
        int resourceId = typedArrayH.getResourceId(jv.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.f = resourceId;
        }
        typedArrayH.recycle();
        super.setOnHierarchyChangeListener(this.f4627a);
        eh.t0(this, 1);
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        p(i, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.f;
                if (i2 != -1 && this.c) {
                    q(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // a.sx
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCheckedChipId() {
        if (this.c) {
            return this.f;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.c) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.d;
    }

    public int getChipSpacingVertical() {
        return this.e;
    }

    public void m() {
        this.f4629e = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f4629e = false;
        setCheckedId(-1);
    }

    public int n(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                if (((Chip) getChildAt(i2)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public boolean o() {
        return this.c;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f;
        if (i != -1) {
            q(i, true);
            setCheckedId(this.f);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ni.D0(accessibilityNodeInfo).c0(ni.b.a(getRowCount(), c() ? getChipCount() : -1, false, o() ? 1 : 2));
    }

    public final void p(int i, boolean z) {
        this.f = i;
        d dVar = this.f4626a;
        if (dVar != null && this.c && z) {
            dVar.a(this, i);
        }
    }

    public final void q(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof Chip) {
            this.f4629e = true;
            ((Chip) viewFindViewById).setChecked(z);
            this.f4629e = false;
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.d != i) {
            this.d = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.e != i) {
            this.e = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f4626a = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4627a.f8303a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f4628d = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // a.sx
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.c != z) {
            this.c = z;
            m();
        }
    }
}
