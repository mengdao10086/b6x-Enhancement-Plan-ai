package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.y0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.c1;
import g.n0;
import g.p0;
import g.v;
import g.v0;
import h2.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import l4.f;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int A = 1;
    public static final int B = 2;
    public static final int[] D;

    @SuppressLint({"DiscouragedApi"})
    public static final int K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int[][] f19896k0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19898z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinkedHashSet<d> f19899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinkedHashSet<c> f19900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public ColorStateList f19901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public CharSequence f19905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public Drawable f19906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public Drawable f19907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public ColorStateList f19909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public ColorStateList f19910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public PorterDuff.Mode f19911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19912r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f19913s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19914t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public CharSequence f19915u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public CompoundButton.OnCheckedChangeListener f19916v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public final h2.c f19917w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.a f19918x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f19897y = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[] C = {R.attr.state_indeterminate};

    public static class SavedState extends View.BaseSavedState {

        @n0
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19919a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @n0
        public final String a() {
            int i10 = this.f19919a;
            return i10 != 1 ? i10 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        @n0
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + zc.a.f58317e;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f19919a));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f19919a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    public class a extends b.a {
        public a() {
        }

        @Override // h2.b.a
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f19909o;
            if (colorStateList != null) {
                n0.c.o(drawable, colorStateList);
            }
        }

        @Override // h2.b.a
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f19909o;
            if (colorStateList != null) {
                n0.c.n(drawable, colorStateList.getColorForState(materialCheckBox.f19913s, MaterialCheckBox.this.f19909o.getDefaultColor()));
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface b {
    }

    public interface c {
        void a(@n0 MaterialCheckBox materialCheckBox, int i10);
    }

    public interface d {
        void a(@n0 MaterialCheckBox materialCheckBox, boolean z10);
    }

    static {
        int i10 = R.attr.state_error;
        D = new int[]{i10};
        f19896k0 = new int[][]{new int[]{android.R.attr.state_enabled, i10}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        K0 = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", f.f39447b);
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    @n0
    private String getButtonStateDescription() {
        int i10 = this.f19912r;
        return i10 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i10 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f19901g == null) {
            int[][] iArr = f19896k0;
            int[] iArr2 = new int[iArr.length];
            int iD = m.d(this, R.attr.colorControlActivated);
            int iD2 = m.d(this, R.attr.colorError);
            int iD3 = m.d(this, R.attr.colorSurface);
            int iD4 = m.d(this, R.attr.colorOnSurface);
            iArr2[0] = m.n(iD3, iD2, 1.0f);
            iArr2[1] = m.n(iD3, iD, 1.0f);
            iArr2[2] = m.n(iD3, iD4, 0.54f);
            iArr2[3] = m.n(iD3, iD4, 0.38f);
            iArr2[4] = m.n(iD3, iD4, 0.38f);
            this.f19901g = new ColorStateList(iArr, iArr2);
        }
        return this.f19901g;
    }

    @p0
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f19909o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f19907m.jumpToCurrentState();
    }

    public void e(@n0 c cVar) {
        this.f19900f.add(cVar);
    }

    public void f(@n0 d dVar) {
        this.f19899e.add(dVar);
    }

    public void g() {
        this.f19900f.clear();
    }

    @Override // android.widget.CompoundButton
    @p0
    public Drawable getButtonDrawable() {
        return this.f19906l;
    }

    @p0
    public Drawable getButtonIconDrawable() {
        return this.f19907m;
    }

    @p0
    public ColorStateList getButtonIconTintList() {
        return this.f19910p;
    }

    @n0
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f19911q;
    }

    @Override // android.widget.CompoundButton
    @p0
    public ColorStateList getButtonTintList() {
        return this.f19909o;
    }

    public int getCheckedState() {
        return this.f19912r;
    }

    @p0
    public CharSequence getErrorAccessibilityLabel() {
        return this.f19905k;
    }

    public void h() {
        this.f19899e.clear();
    }

    public final boolean i(y0 y0Var) {
        return y0Var.u(R.styleable.MaterialCheckBox_android_button, 0) == K0 && y0Var.u(R.styleable.MaterialCheckBox_buttonCompat, 0) == 0;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f19912r == 1;
    }

    public boolean j() {
        return this.f19903i;
    }

    public boolean k() {
        return this.f19904j;
    }

    public boolean l() {
        return this.f19902h;
    }

    public final void n() {
        this.f19906l = yd.a.c(this.f19906l, this.f19909o, androidx.core.widget.d.c(this));
        this.f19907m = yd.a.c(this.f19907m, this.f19910p, this.f19911q);
        r();
        s();
        super.setButtonDrawable(yd.a.a(this.f19906l, this.f19907m));
        refreshDrawableState();
    }

    public void o(@n0 c cVar) {
        this.f19900f.remove(cVar);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19902h && this.f19909o == null && this.f19910p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        if (k()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        this.f19913s = yd.a.e(iArrOnCreateDrawableState);
        t();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f19903i || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.d.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (b0.l(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            n0.c.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@p0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && k()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f19905k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@p0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f19919a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    @p0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19919a = getCheckedState();
        return savedState;
    }

    public void p(@n0 d dVar) {
        this.f19899e.remove(dVar);
    }

    public final void q() {
        if (Build.VERSION.SDK_INT < 30 || this.f19915u != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    public final void r() {
        h2.c cVar;
        if (this.f19908n) {
            h2.c cVar2 = this.f19917w;
            if (cVar2 != null) {
                cVar2.b(this.f19918x);
                this.f19917w.c(this.f19918x);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f19906l;
                if (!(drawable instanceof AnimatedStateListDrawable) || (cVar = this.f19917w) == null) {
                    return;
                }
                int i10 = R.id.checked;
                int i11 = R.id.unchecked;
                ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, cVar, false);
                ((AnimatedStateListDrawable) this.f19906l).addTransition(R.id.indeterminate, i11, this.f19917w, false);
            }
        }
    }

    public final void s() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f19906l;
        if (drawable != null && (colorStateList2 = this.f19909o) != null) {
            n0.c.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f19907m;
        if (drawable2 == null || (colorStateList = this.f19910p) == null) {
            return;
        }
        n0.c.o(drawable2, colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@v int i10) {
        setButtonDrawable(i.a.b(getContext(), i10));
    }

    public void setButtonIconDrawable(@p0 Drawable drawable) {
        this.f19907m = drawable;
        n();
    }

    public void setButtonIconDrawableResource(@v int i10) {
        setButtonIconDrawable(i.a.b(getContext(), i10));
    }

    public void setButtonIconTintList(@p0 ColorStateList colorStateList) {
        if (this.f19910p == colorStateList) {
            return;
        }
        this.f19910p = colorStateList;
        n();
    }

    public void setButtonIconTintMode(@n0 PorterDuff.Mode mode) {
        if (this.f19911q == mode) {
            return;
        }
        this.f19911q = mode;
        n();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@p0 ColorStateList colorStateList) {
        if (this.f19909o == colorStateList) {
            return;
        }
        this.f19909o = colorStateList;
        n();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@p0 PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        n();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f19903i = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f19912r != i10) {
            this.f19912r = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            q();
            if (this.f19914t) {
                return;
            }
            this.f19914t = true;
            LinkedHashSet<c> linkedHashSet = this.f19900f;
            if (linkedHashSet != null) {
                Iterator<c> it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.f19912r);
                }
            }
            if (this.f19912r != 2 && (onCheckedChangeListener = this.f19916v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f19914t = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        t();
    }

    public void setErrorAccessibilityLabel(@p0 CharSequence charSequence) {
        this.f19905k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@c1 int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f19904j == z10) {
            return;
        }
        this.f19904j = z10;
        refreshDrawableState();
        Iterator<d> it2 = this.f19899e.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, this.f19904j);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@p0 CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f19916v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @v0(30)
    public void setStateDescription(@p0 CharSequence charSequence) {
        this.f19915u = charSequence;
        if (charSequence == null) {
            q();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f19902h = z10;
        if (z10) {
            androidx.core.widget.d.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.d.d(this, null);
        }
    }

    public final void t() {
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@p0 Drawable drawable) {
        this.f19906l = drawable;
        this.f19908n = false;
        n();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f19897y;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19899e = new LinkedHashSet<>();
        this.f19900f = new LinkedHashSet<>();
        this.f19917w = h2.c.e(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.f19918x = new a();
        Context context2 = getContext();
        this.f19906l = androidx.core.widget.d.a(this);
        this.f19909o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        y0 y0VarL = t.l(context2, attributeSet, R.styleable.MaterialCheckBox, i10, i11, new int[0]);
        this.f19907m = y0VarL.h(R.styleable.MaterialCheckBox_buttonIcon);
        if (this.f19906l != null && t.h(context2) && i(y0VarL)) {
            super.setButtonDrawable((Drawable) null);
            this.f19906l = i.a.b(context2, R.drawable.mtrl_checkbox_button);
            this.f19908n = true;
            if (this.f19907m == null) {
                this.f19907m = i.a.b(context2, R.drawable.mtrl_checkbox_button_icon);
            }
        }
        this.f19910p = ie.c.b(context2, y0VarL, R.styleable.MaterialCheckBox_buttonIconTint);
        this.f19911q = b0.m(y0VarL.o(R.styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f19902h = y0VarL.a(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f19903i = y0VarL.a(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f19904j = y0VarL.a(R.styleable.MaterialCheckBox_errorShown, false);
        this.f19905k = y0VarL.x(R.styleable.MaterialCheckBox_errorAccessibilityLabel);
        int i12 = R.styleable.MaterialCheckBox_checkedState;
        if (y0VarL.C(i12)) {
            setCheckedState(y0VarL.o(i12, 0));
        }
        y0VarL.I();
        n();
    }
}
