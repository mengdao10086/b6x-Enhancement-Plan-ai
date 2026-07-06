package com.google.android.material.chip;

import a.a00;
import a.dy;
import a.eh;
import a.ek;
import a.gy;
import a.hv;
import a.hw;
import a.iv;
import a.jv;
import a.jz;
import a.ni;
import a.ny;
import a.nz;
import a.pv;
import a.qy;
import a.r20;
import a.r5;
import a.sy;
import a.wy;
import a.zu;
import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class Chip extends r5 implements hw.a, a00 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hw f4614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sy f4615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f4617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InsetDrawable f4618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RippleDrawable f4619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f4620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CompoundButton.OnCheckedChangeListener f4621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4622a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4623b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4624b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4625c;
    public boolean d;
    public boolean e;
    public boolean f;
    public static final int c = iv.Widget_MaterialComponents_Chip_Action;
    public static final Rect b = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8297a = {R.attr.state_selected};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f4612b = {R.attr.state_checkable};

    public class a extends sy {
        public a() {
        }

        @Override // a.sy
        public void a(int i) {
        }

        @Override // a.sy
        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.f4614a.G2() ? Chip.this.f4614a.c1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f4614a != null) {
                Chip.this.f4614a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public class c extends ek {
        public c(Chip chip) {
            super(chip);
        }

        @Override // a.ek
        public int B(float f, float f2) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
        }

        @Override // a.ek
        public void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f4620a != null) {
                list.add(1);
            }
        }

        @Override // a.ek
        public boolean J(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return Chip.this.performClick();
            }
            if (i == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // a.ek
        public void M(ni niVar) {
            niVar.Y(Chip.this.r());
            niVar.b0(Chip.this.isClickable());
            niVar.a0((Chip.this.r() || Chip.this.isClickable()) ? Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                niVar.A0(text);
            } else {
                niVar.e0(text);
            }
        }

        @Override // a.ek
        public void N(int i, ni niVar) {
            if (i != 1) {
                niVar.e0("");
                niVar.W(Chip.b);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i2 = hv.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                closeIconContentDescription = context.getString(i2, objArr).trim();
            }
            niVar.e0(closeIconContentDescription);
            niVar.W(Chip.this.getCloseIconTouchBoundsInt());
            niVar.b(ni.a.c);
            niVar.g0(Chip.this.isEnabled());
        }

        @Override // a.ek
        public void O(int i, boolean z) {
            if (i == 1) {
                Chip.this.e = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, c), attributeSet, i);
        this.f4616a = new Rect();
        this.f4617a = new RectF();
        this.f4615a = new a();
        Context context2 = getContext();
        C(attributeSet);
        hw hwVarS0 = hw.s0(context2, attributeSet, i, c);
        o(context2, attributeSet, i);
        setChipDrawable(hwVarS0);
        hwVarS0.T(eh.t(this));
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.Chip, i, c, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(ny.a(context2, typedArrayH, jv.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayH.hasValue(jv.Chip_shapeAppearance);
        typedArrayH.recycle();
        this.f4622a = new c(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f4624b);
        setText(hwVarS0.c1());
        setEllipsize(hwVarS0.W0());
        B();
        if (!this.f4614a.G2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.f4623b);
        }
        this.f4613a = eh.y(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f4617a.setEmpty();
        if (n()) {
            this.f4614a.V0(this.f4617a);
        }
        return this.f4617a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f4616a.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f4616a;
    }

    private qy getTextAppearance() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.d1();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.d != z) {
            this.d = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f4625c != z) {
            this.f4625c = z;
            refreshDrawableState();
        }
    }

    public final void A() {
        hw hwVar;
        if (TextUtils.isEmpty(getText()) || (hwVar = this.f4614a) == null) {
            return;
        }
        int iG0 = (int) (hwVar.G0() + this.f4614a.e1() + this.f4614a.n0());
        int iL0 = (int) (this.f4614a.L0() + this.f4614a.f1() + this.f4614a.j0());
        if (this.f4618a != null) {
            Rect rect = new Rect();
            this.f4618a.getPadding(rect);
            iL0 += rect.left;
            iG0 += rect.right;
        }
        eh.w0(this, iL0, getPaddingTop(), iG0, getPaddingBottom());
    }

    public final void B() {
        TextPaint paint = getPaint();
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            paint.drawableState = hwVar.getState();
        }
        qy textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i(getContext(), paint, this.f4615a);
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    @Override // a.hw.a
    public void a() {
        k(this.f4623b);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m(motionEvent) || this.f4622a.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f4622a.w(keyEvent) || this.f4622a.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // a.r5, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        hw hwVar = this.f4614a;
        if ((hwVar == null || !hwVar.k1()) ? false : this.f4614a.g2(j())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f4618a;
        return insetDrawable == null ? this.f4614a : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.C0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.D0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.E0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return Math.max(0.0f, hwVar.F0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f4614a;
    }

    public float getChipEndPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.G0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.H0();
        }
        return null;
    }

    public float getChipIconSize() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.I0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.J0();
        }
        return null;
    }

    public float getChipMinHeight() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.K0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.L0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.M0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.N0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.O0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.P0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.Q0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.R0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.S0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.U0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.W0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f4622a.A() == 1 || this.f4622a.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public pv getHideMotionSpec() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.X0();
        }
        return null;
    }

    public float getIconEndPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.Y0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.Z0();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.a1();
        }
        return null;
    }

    public nz getShapeAppearanceModel() {
        return this.f4614a.B();
    }

    public pv getShowMotionSpec() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.b1();
        }
        return null;
    }

    public float getTextEndPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.e1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            return hwVar.f1();
        }
        return 0.0f;
    }

    public final void i(hw hwVar) {
        hwVar.k2(this);
    }

    public final int[] j() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.e) {
            i2++;
        }
        if (this.d) {
            i2++;
        }
        if (this.f4625c) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.e) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.d) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.f4625c) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    public boolean k(int i) {
        this.f4623b = i;
        if (!v()) {
            if (this.f4618a != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i - this.f4614a.getIntrinsicHeight());
        int iMax2 = Math.max(0, i - this.f4614a.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f4618a != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.f4618a != null) {
            Rect rect = new Rect();
            this.f4618a.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                y();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i) {
                setMinHeight(i);
            }
            if (getMinWidth() != i) {
            }
            q(i2, i3, i2, i3);
            y();
            return true;
        }
        setMinHeight(i);
        setMinWidth(i);
        q(i2, i3, i2, i3);
        y();
        return true;
    }

    public final void l() {
        if (getBackgroundDrawable() == this.f4618a && this.f4614a.getCallback() == null) {
            this.f4614a.setCallback(this.f4618a);
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean m(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ek.class.getDeclaredField("c");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f4622a)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ek.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f4622a, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            }
        }
        return false;
    }

    public final boolean n() {
        hw hwVar = this.f4614a;
        return (hwVar == null || hwVar.O0() == null) ? false : true;
    }

    public final void o(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayH = dy.h(context, attributeSet, jv.Chip, i, c, new int[0]);
        this.f = typedArrayH.getBoolean(jv.Chip_ensureMinTouchTargetSize, false);
        this.f4623b = (int) Math.ceil(typedArrayH.getDimension(jv.Chip_chipMinTouchTargetSize, (float) Math.ceil(gy.b(getContext(), 48))));
        typedArrayH.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        jz.f(this, this.f4614a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f8297a);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f4612b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.f4622a.I(z, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean zContains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                zContains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(zContains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((r() || isClickable()) ? r() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            ni.D0(accessibilityNodeInfo).d0(ni.c.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.n(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.f4613a != i) {
            this.f4613a = i;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f4625c
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f4625c
            if (r0 == 0) goto L34
            r5.t()
            r0 = r3
            goto L35
        L34:
            r0 = r2
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = r3
            goto L41
        L40:
            r0 = r2
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = r3
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    public final void q(int i, int i2, int i3, int i4) {
        this.f4618a = new InsetDrawable((Drawable) this.f4614a, i, i2, i3, i4);
    }

    public boolean r() {
        hw hwVar = this.f4614a;
        return hwVar != null && hwVar.j1();
    }

    public boolean s() {
        hw hwVar = this.f4614a;
        return hwVar != null && hwVar.l1();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4619a) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // a.r5, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4619a) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // a.r5, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.s1(z);
        }
    }

    public void setCheckableResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.t1(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        hw hwVar = this.f4614a;
        if (hwVar == null) {
            this.f4624b = z;
            return;
        }
        if (hwVar.j1()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.f4621a) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.u1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.v1(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.w1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.x1(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.y1(i);
        }
    }

    public void setCheckedIconVisible(boolean z) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.z1(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.A1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.B1(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.C1(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.D1(i);
        }
    }

    public void setChipDrawable(hw hwVar) {
        hw hwVar2 = this.f4614a;
        if (hwVar2 != hwVar) {
            w(hwVar2);
            this.f4614a = hwVar;
            hwVar.v2(false);
            i(this.f4614a);
            k(this.f4623b);
        }
    }

    public void setChipEndPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.E1(f);
        }
    }

    public void setChipEndPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.F1(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.G1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.H1(i);
        }
    }

    public void setChipIconSize(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.I1(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.J1(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.K1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.L1(i);
        }
    }

    public void setChipIconVisible(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.M1(i);
        }
    }

    public void setChipIconVisible(boolean z) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.N1(z);
        }
    }

    public void setChipMinHeight(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.O1(f);
        }
    }

    public void setChipMinHeightResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.P1(i);
        }
    }

    public void setChipStartPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.Q1(f);
        }
    }

    public void setChipStartPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.R1(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.S1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.T1(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.U1(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.V1(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.X1(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.Y1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.Z1(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.a2(i);
        }
    }

    public void setCloseIconResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.b2(i);
        }
        x();
    }

    public void setCloseIconSize(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.c2(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.d2(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.e2(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.f2(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.h2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.i2(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.j2(z);
        }
        x();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.T(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f4614a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.l2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.f = z;
        k(this.f4623b);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(pv pvVar) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.m2(pvVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.n2(i);
        }
    }

    public void setIconEndPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.o2(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.p2(i);
        }
    }

    public void setIconStartPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.q2(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.r2(i);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f4614a != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.s2(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f4621a = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f4620a = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.t2(colorStateList);
        }
        if (this.f4614a.h1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.u2(i);
            if (this.f4614a.h1()) {
                return;
            }
            z();
        }
    }

    @Override // a.a00
    public void setShapeAppearanceModel(nz nzVar) {
        this.f4614a.setShapeAppearanceModel(nzVar);
    }

    public void setShowMotionSpec(pv pvVar) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.w2(pvVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.x2(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f4614a == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.f4614a.G2() ? null : charSequence, bufferType);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.y2(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.A2(i);
        }
        B();
    }

    public void setTextAppearance(qy qyVar) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.z2(qyVar);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.A2(i);
        }
        B();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.B2(f);
        }
    }

    public void setTextEndPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.C2(i);
        }
    }

    public void setTextStartPadding(float f) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.D2(f);
        }
    }

    public void setTextStartPaddingResource(int i) {
        hw hwVar = this.f4614a;
        if (hwVar != null) {
            hwVar.E2(i);
        }
    }

    public boolean t() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f4620a;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.f4622a.U(1, 1);
        return z;
    }

    public final void u() {
        if (this.f4618a != null) {
            this.f4618a = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    public boolean v() {
        return this.f;
    }

    public final void w(hw hwVar) {
        if (hwVar != null) {
            hwVar.k2(null);
        }
    }

    public final void x() {
        eh.k0(this, (n() && s() && this.f4620a != null) ? this.f4622a : null);
    }

    public final void y() {
        if (wy.f3492a) {
            z();
            return;
        }
        this.f4614a.F2(true);
        eh.m0(this, getBackgroundDrawable());
        A();
        l();
    }

    public final void z() {
        this.f4619a = new RippleDrawable(wy.d(this.f4614a.a1()), getBackgroundDrawable(), null);
        this.f4614a.F2(false);
        eh.m0(this, this.f4619a);
        A();
    }
}
