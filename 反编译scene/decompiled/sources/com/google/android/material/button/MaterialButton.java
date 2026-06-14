package com.google.android.material.button;

import a.a00;
import a.ak;
import a.dw;
import a.dy;
import a.eh;
import a.ew;
import a.gy;
import a.iv;
import a.jv;
import a.jz;
import a.kd;
import a.ny;
import a.nz;
import a.oj;
import a.q5;
import a.r2;
import a.r20;
import a.zu;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MaterialButton extends q5 implements Checkable, a00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8296a = {R.attr.state_checkable};
    public static final int[] b = {R.attr.state_checked};
    public static final int e = iv.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ew f4603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f4605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f4607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedHashSet<a> f4608a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4609b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4610b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4611c;
    public int d;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public static class c extends ak {
        public static final Parcelable.Creator<c> CREATOR = new dw();
        public boolean b;

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            r(parcel);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        public final void r(Parcel parcel) {
            this.b = parcel.readInt() == 1;
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, e), attributeSet, i);
        this.f4608a = new LinkedHashSet<>();
        this.f4610b = false;
        this.f4611c = false;
        Context context2 = getContext();
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.MaterialButton, i, e, new int[0]);
        this.c = typedArrayH.getDimensionPixelSize(jv.MaterialButton_iconPadding, 0);
        this.f4605a = gy.e(typedArrayH.getInt(jv.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f4604a = ny.a(getContext(), typedArrayH, jv.MaterialButton_iconTint);
        this.f4606a = ny.d(getContext(), typedArrayH, jv.MaterialButton_icon);
        this.d = typedArrayH.getInteger(jv.MaterialButton_iconGravity, 1);
        this.f4602a = typedArrayH.getDimensionPixelSize(jv.MaterialButton_iconSize, 0);
        ew ewVar = new ew(this, nz.c(context2, attributeSet, i, e).m());
        this.f4603a = ewVar;
        ewVar.o(typedArrayH);
        typedArrayH.recycle();
        setCompoundDrawablePadding(this.c);
        e(this.f4606a != null);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        ew ewVar = this.f4603a;
        return ewVar != null && ewVar.n();
    }

    public final boolean b() {
        return eh.y(this) == 1;
    }

    public final boolean c() {
        ew ewVar = this.f4603a;
        return (ewVar == null || ewVar.m()) ? false : true;
    }

    public final void d(boolean z) {
        if (z) {
            oj.l(this, this.f4606a, null, null, null);
        } else {
            oj.l(this, null, null, this.f4606a, null);
        }
    }

    public final void e(boolean z) {
        Drawable drawable = this.f4606a;
        boolean z2 = false;
        if (drawable != null) {
            Drawable drawableMutate = kd.r(drawable).mutate();
            this.f4606a = drawableMutate;
            kd.o(drawableMutate, this.f4604a);
            PorterDuff.Mode mode = this.f4605a;
            if (mode != null) {
                kd.p(this.f4606a, mode);
            }
            int intrinsicWidth = this.f4602a;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f4606a.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f4602a;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f4606a.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f4606a;
            int i = this.f4609b;
            drawable2.setBounds(i, 0, intrinsicWidth + i, intrinsicHeight);
        }
        int i2 = this.d;
        boolean z3 = i2 == 1 || i2 == 2;
        if (z) {
            d(z3);
            return;
        }
        Drawable[] drawableArrA = oj.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[2];
        if ((z3 && drawable3 != this.f4606a) || (!z3 && drawable4 != this.f4606a)) {
            z2 = true;
        }
        if (z2) {
            d(z3);
        }
    }

    public final void f() {
        if (this.f4606a == null || getLayout() == null) {
            return;
        }
        int i = this.d;
        if (i == 1 || i == 3) {
            this.f4609b = 0;
            e(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.f4602a;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f4606a.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - eh.C(this)) - intrinsicWidth) - this.c) - eh.D(this)) / 2;
        if (b() != (this.d == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.f4609b != measuredWidth) {
            this.f4609b = measuredWidth;
            e(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f4603a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f4606a;
    }

    public int getIconGravity() {
        return this.d;
    }

    public int getIconPadding() {
        return this.c;
    }

    public int getIconSize() {
        return this.f4602a;
    }

    public ColorStateList getIconTint() {
        return this.f4604a;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4605a;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f4603a.f();
        }
        return null;
    }

    public nz getShapeAppearanceModel() {
        if (c()) {
            return this.f4603a.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f4603a.h();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f4603a.i();
        }
        return 0;
    }

    @Override // a.q5, a.qg
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.f4603a.j() : super.getSupportBackgroundTintList();
    }

    @Override // a.q5, a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.f4603a.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f4610b;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (c()) {
            jz.f(this, this.f4603a.d());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f8296a);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // a.q5, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // a.q5, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // a.q5, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ew ewVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (ewVar = this.f4603a) == null) {
            return;
        }
        ewVar.B(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.q());
        setChecked(cVar.b);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.b = this.f4610b;
        return cVar;
    }

    @Override // a.q5, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        f();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (c()) {
            this.f4603a.p(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // a.q5, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (c()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
                this.f4603a.q();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // a.q5, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? r2.d(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.f4603a.r(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.f4610b != z) {
            this.f4610b = z;
            refreshDrawableState();
            if (this.f4611c) {
                return;
            }
            this.f4611c = true;
            Iterator<a> it = this.f4608a.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f4610b);
            }
            this.f4611c = false;
        }
    }

    public void setCornerRadius(int i) {
        if (c()) {
            this.f4603a.s(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (c()) {
            this.f4603a.d().T(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f4606a != drawable) {
            this.f4606a = drawable;
            e(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.d != i) {
            this.d = i;
            f();
        }
    }

    public void setIconPadding(int i) {
        if (this.c != i) {
            this.c = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? r2.d(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f4602a != i) {
            this.f4602a = i;
            e(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f4604a != colorStateList) {
            this.f4604a = colorStateList;
            e(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f4605a != mode) {
            this.f4605a = mode;
            e(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(r2.c(getContext(), i));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f4607a = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f4607a;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f4603a.t(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (c()) {
            setRippleColor(r2.c(getContext(), i));
        }
    }

    @Override // a.a00
    public void setShapeAppearanceModel(nz nzVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f4603a.u(nzVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.f4603a.v(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f4603a.w(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (c()) {
            setStrokeColor(r2.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (c()) {
            this.f4603a.x(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // a.q5, a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f4603a.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // a.q5, a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f4603a.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f4610b);
    }
}
