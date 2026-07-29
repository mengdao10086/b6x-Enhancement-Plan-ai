package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.m;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.t0;
import g.v;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import le.k;
import le.o;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, s {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f19817s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f19818t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f19819u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f19820v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19821w = 16;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19822x = 32;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f19823y = "MaterialButton";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final com.google.android.material.button.a f19825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinkedHashSet<b> f19826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public c f19827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public PorterDuff.Mode f19828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public ColorStateList f19829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public Drawable f19830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @t0
    public int f19831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @t0
    public int f19832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @t0
    public int f19833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @t0
    public int f19834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f19815q = {R.attr.state_checkable};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f19816r = {R.attr.state_checked};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19824z = com.google.android.material.R.style.Widget_MaterialComponents_Button;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19838c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void b(@n0 Parcel parcel) {
            this.f19838c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19838c ? 1 : 0);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            b(parcel);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public interface c {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(@n0 Context context) {
        this(context, null);
    }

    @n0
    private String getA11yClassName() {
        return (f() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & m.f5027d;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        int iMax = 0;
        for (int i10 = 0; i10 < lineCount; i10++) {
            iMax = Math.max(iMax, e(d(i10)));
        }
        return iMax;
    }

    private boolean j() {
        return u0.Z(this) == 1;
    }

    public void a(@n0 b bVar) {
        this.f19826e.add(bVar);
    }

    public void c() {
        this.f19826e.clear();
    }

    public final CharSequence d(int i10) {
        return getText().subSequence(getLayout().getLineStart(i10), getLayout().getLineEnd(i10));
    }

    public final int e(CharSequence charSequence) {
        TextPaint paint = getPaint();
        String string = charSequence.toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    public boolean f() {
        com.google.android.material.button.a aVar = this.f19825d;
        return aVar != null && aVar.p();
    }

    public final boolean g() {
        int i10 = this.f19837p;
        return i10 == 3 || i10 == 4;
    }

    @Override // android.view.View
    @p0
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @p0
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @t0
    public int getCornerRadius() {
        if (l()) {
            return this.f19825d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f19830i;
    }

    public int getIconGravity() {
        return this.f19837p;
    }

    @t0
    public int getIconPadding() {
        return this.f19834m;
    }

    @t0
    public int getIconSize() {
        return this.f19831j;
    }

    public ColorStateList getIconTint() {
        return this.f19829h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f19828g;
    }

    @r
    public int getInsetBottom() {
        return this.f19825d.c();
    }

    @r
    public int getInsetTop() {
        return this.f19825d.d();
    }

    @p0
    public ColorStateList getRippleColor() {
        if (l()) {
            return this.f19825d.h();
        }
        return null;
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        if (l()) {
            return this.f19825d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (l()) {
            return this.f19825d.j();
        }
        return null;
    }

    @t0
    public int getStrokeWidth() {
        if (l()) {
            return this.f19825d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.r0
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return l() ? this.f19825d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.r0
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return l() ? this.f19825d.m() : super.getSupportBackgroundTintMode();
    }

    public final boolean h() {
        int i10 = this.f19837p;
        return i10 == 1 || i10 == 2;
    }

    public final boolean i() {
        int i10 = this.f19837p;
        return i10 == 16 || i10 == 32;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f19835n;
    }

    public boolean k() {
        return this.f19825d.q();
    }

    public final boolean l() {
        com.google.android.material.button.a aVar = this.f19825d;
        return (aVar == null || aVar.o()) ? false : true;
    }

    public void m(@n0 b bVar) {
        this.f19826e.remove(bVar);
    }

    public final void n() {
        if (h()) {
            androidx.core.widget.r.w(this, this.f19830i, null, null, null);
        } else if (g()) {
            androidx.core.widget.r.w(this, null, null, this.f19830i, null);
        } else if (i()) {
            androidx.core.widget.r.w(this, null, this.f19830i, null, null);
        }
    }

    public final void o(boolean z10) {
        Drawable drawable = this.f19830i;
        boolean z11 = true;
        if (drawable != null) {
            Drawable drawableMutate = n0.c.r(drawable).mutate();
            this.f19830i = drawableMutate;
            n0.c.o(drawableMutate, this.f19829h);
            PorterDuff.Mode mode = this.f19828g;
            if (mode != null) {
                n0.c.p(this.f19830i, mode);
            }
            int intrinsicWidth = this.f19831j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f19830i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f19831j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f19830i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f19830i;
            int i10 = this.f19832k;
            int i11 = this.f19833l;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f19830i.setVisible(true, z10);
        }
        if (z10) {
            n();
            return;
        }
        Drawable[] drawableArrH = androidx.core.widget.r.h(this);
        Drawable drawable3 = drawableArrH[0];
        Drawable drawable4 = drawableArrH[1];
        Drawable drawable5 = drawableArrH[2];
        if ((!h() || drawable3 == this.f19830i) && ((!g() || drawable5 == this.f19830i) && (!i() || drawable4 == this.f19830i))) {
            z11 = false;
        }
        if (z11) {
            n();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (l()) {
            k.f(this, this.f19825d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (f()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f19815q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f19816r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@n0 AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        com.google.android.material.button.a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f19825d) != null) {
            aVar.J(i13 - i11, i12 - i10);
        }
        p(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@p0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f19838c);
    }

    @Override // android.widget.TextView, android.view.View
    @n0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19838c = this.f19835n;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        p(getMeasuredWidth(), getMeasuredHeight());
    }

    public final void p(int i10, int i11) {
        if (this.f19830i == null || getLayout() == null) {
            return;
        }
        if (!h() && !g()) {
            if (i()) {
                this.f19832k = 0;
                if (this.f19837p == 16) {
                    this.f19833l = 0;
                    o(false);
                    return;
                }
                int intrinsicHeight = this.f19831j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f19830i.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f19834m) - getPaddingBottom()) / 2);
                if (this.f19833l != iMax) {
                    this.f19833l = iMax;
                    o(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f19833l = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.f19837p;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f19832k = 0;
            o(false);
            return;
        }
        int intrinsicWidth = this.f19831j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f19830i.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - u0.j0(this)) - intrinsicWidth) - this.f19834m) - u0.k0(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (j() != (this.f19837p == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f19832k != textLayoutWidth) {
            this.f19832k = textLayoutWidth;
            o(false);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f19825d.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f19830i != null) {
            if (this.f19830i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(@n0 Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@l int i10) {
        if (l()) {
            this.f19825d.s(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@n0 Drawable drawable) {
        if (!l()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
        } else {
            this.f19825d.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@v int i10) {
        setBackgroundDrawable(i10 != 0 ? i.a.b(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@p0 ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@p0 PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (l()) {
            this.f19825d.u(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (f() && isEnabled() && this.f19835n != z10) {
            this.f19835n = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).p(this, this.f19835n);
            }
            if (this.f19836o) {
                return;
            }
            this.f19836o = true;
            Iterator<b> it2 = this.f19826e.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.f19835n);
            }
            this.f19836o = false;
        }
    }

    public void setCornerRadius(@t0 int i10) {
        if (l()) {
            this.f19825d.v(i10);
        }
    }

    public void setCornerRadiusResource(@q int i10) {
        if (l()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (l()) {
            this.f19825d.f().n0(f10);
        }
    }

    public void setIcon(@p0 Drawable drawable) {
        if (this.f19830i != drawable) {
            this.f19830i = drawable;
            o(true);
            p(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f19837p != i10) {
            this.f19837p = i10;
            p(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@t0 int i10) {
        if (this.f19834m != i10) {
            this.f19834m = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(@v int i10) {
        setIcon(i10 != 0 ? i.a.b(getContext(), i10) : null);
    }

    public void setIconSize(@t0 int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f19831j != i10) {
            this.f19831j = i10;
            o(true);
        }
    }

    public void setIconTint(@p0 ColorStateList colorStateList) {
        if (this.f19829h != colorStateList) {
            this.f19829h = colorStateList;
            o(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f19828g != mode) {
            this.f19828g = mode;
            o(false);
        }
    }

    public void setIconTintResource(@n int i10) {
        setIconTint(i.a.a(getContext(), i10));
    }

    public void setInsetBottom(@r int i10) {
        this.f19825d.w(i10);
    }

    public void setInsetTop(@r int i10) {
        this.f19825d.x(i10);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@p0 c cVar) {
        this.f19827f = cVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        c cVar = this.f19827f;
        if (cVar != null) {
            cVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(@p0 ColorStateList colorStateList) {
        if (l()) {
            this.f19825d.y(colorStateList);
        }
    }

    public void setRippleColorResource(@n int i10) {
        if (l()) {
            setRippleColor(i.a.a(getContext(), i10));
        }
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        if (!l()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f19825d.z(oVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (l()) {
            this.f19825d.A(z10);
        }
    }

    public void setStrokeColor(@p0 ColorStateList colorStateList) {
        if (l()) {
            this.f19825d.B(colorStateList);
        }
    }

    public void setStrokeColorResource(@n int i10) {
        if (l()) {
            setStrokeColor(i.a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(@t0 int i10) {
        if (l()) {
            this.f19825d.C(i10);
        }
    }

    public void setStrokeWidthResource(@q int i10) {
        if (l()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@p0 ColorStateList colorStateList) {
        if (l()) {
            this.f19825d.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@p0 PorterDuff.Mode mode) {
        if (l()) {
            this.f19825d.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    @v0(17)
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        p(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f19825d.F(z10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f19835n);
    }

    public MaterialButton(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f19824z;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19826e = new LinkedHashSet<>();
        this.f19835n = false;
        this.f19836o = false;
        Context context2 = getContext();
        TypedArray typedArrayK = t.k(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i10, i11, new int[0]);
        this.f19834m = typedArrayK.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.f19828g = b0.m(typedArrayK.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f19829h = ie.c.a(getContext(), typedArrayK, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.f19830i = ie.c.e(getContext(), typedArrayK, com.google.android.material.R.styleable.MaterialButton_icon);
        this.f19837p = typedArrayK.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.f19831j = typedArrayK.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, o.e(context2, attributeSet, i10, i11).m());
        this.f19825d = aVar;
        aVar.r(typedArrayK);
        typedArrayK.recycle();
        setCompoundDrawablePadding(this.f19834m);
        o(this.f19830i != null);
    }
}
