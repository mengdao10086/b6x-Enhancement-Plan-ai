package com.google.android.material.chip;

import a1.d;
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
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.chip.a;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.j;
import com.google.android.material.internal.t;
import f0.v;
import g.c1;
import g.d1;
import g.i;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.t0;
import g.v0;
import ie.f;
import java.util.List;
import kd.h;
import le.k;
import le.o;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0204a, s, j<Chip> {
    public static final int A = 1;
    public static final String C1 = "android.view.View";
    public static final int K0 = 48;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f19922k0 = "http://schemas.android.com/apk/res/android";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f19923k1 = "android.widget.Button";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final String f19924v1 = "android.widget.RadioButton";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f19925x = "Chip";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19927z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public com.google.android.material.chip.a f19928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public InsetDrawable f19929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public RippleDrawable f19930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public View.OnClickListener f19931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public CompoundButton.OnCheckedChangeListener f19932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public j.a<Chip> f19933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19937n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19938o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19939p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @r(unit = 1)
    public int f19940q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public CharSequence f19941r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final c f19942s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19943t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f19944u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f19945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f19946w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f19926y = R.style.Widget_MaterialComponents_Chip_Action;
    public static final Rect B = new Rect();
    public static final int[] C = {android.R.attr.state_selected};
    public static final int[] D = {android.R.attr.state_checkable};

    public class a extends f {
        public a() {
        }

        @Override // ie.f
        public void a(int i10) {
        }

        @Override // ie.f
        public void b(@n0 Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f19928e.K3() ? Chip.this.f19928e.P1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @n0 Outline outline) {
            if (Chip.this.f19928e != null) {
                Chip.this.f19928e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public class c extends e1.a {
        public c(Chip chip) {
            super(chip);
        }

        @Override // e1.a
        public int C(float f10, float f11) {
            return (Chip.this.o() && Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 1 : 0;
        }

        @Override // e1.a
        public void D(@n0 List<Integer> list) {
            list.add(0);
            if (Chip.this.o() && Chip.this.y() && Chip.this.f19931h != null) {
                list.add(1);
            }
        }

        @Override // e1.a
        public boolean N(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.A();
            }
            return false;
        }

        @Override // e1.a
        public void Q(@n0 d dVar) {
            dVar.Z0(Chip.this.s());
            dVar.c1(Chip.this.isClickable());
            dVar.b1(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                dVar.S1(text);
            } else {
                dVar.f1(text);
            }
        }

        @Override // e1.a
        public void R(int i10, @n0 d dVar) {
            if (i10 != 1) {
                dVar.f1("");
                dVar.W0(Chip.B);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                dVar.f1(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i11 = R.string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                dVar.f1(context.getString(i11, objArr).trim());
            }
            dVar.W0(Chip.this.getCloseIconTouchBoundsInt());
            dVar.b(d.a.f110j);
            dVar.l1(Chip.this.isEnabled());
        }

        @Override // e1.a
        public void S(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f19937n = z10;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @n0
    public RectF getCloseIconTouchBounds() {
        this.f19945v.setEmpty();
        if (o() && this.f19931h != null) {
            this.f19928e.F1(this.f19945v);
        }
        return this.f19945v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @n0
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f19944u.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f19944u;
    }

    @p0
    private ie.d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.Q1();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f19936m != z10) {
            this.f19936m = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f19935l != z10) {
            this.f19935l = z10;
            refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(CompoundButton compoundButton, boolean z10) {
        j.a<Chip> aVar = this.f19933j;
        if (aVar != null) {
            aVar.a(this, z10);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f19932i;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    @i
    public boolean A() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f19931h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f19943t) {
            this.f19942s.Y(1, 1);
        }
        return z10;
    }

    public final void B() {
        if (this.f19929f != null) {
            this.f19929f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            F();
        }
    }

    public boolean C() {
        return this.f19938o;
    }

    public final void D(@p0 com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.k3(null);
        }
    }

    public final void E() {
        if (o() && y() && this.f19931h != null) {
            u0.B1(this, this.f19942s);
            this.f19943t = true;
        } else {
            u0.B1(this, null);
            this.f19943t = false;
        }
    }

    public final void F() {
        if (je.b.f36351a) {
            G();
            return;
        }
        this.f19928e.J3(true);
        u0.I1(this, getBackgroundDrawable());
        H();
        n();
    }

    public final void G() {
        this.f19930g = new RippleDrawable(je.b.e(this.f19928e.N1()), getBackgroundDrawable(), null);
        this.f19928e.J3(false);
        u0.I1(this, this.f19930g);
        H();
    }

    public final void H() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f19928e) == null) {
            return;
        }
        int iP1 = (int) (aVar.p1() + this.f19928e.R1() + this.f19928e.V0());
        int iU1 = (int) (this.f19928e.u1() + this.f19928e.S1() + this.f19928e.R0());
        if (this.f19929f != null) {
            Rect rect = new Rect();
            this.f19929f.getPadding(rect);
            iU1 += rect.left;
            iP1 += rect.right;
        }
        u0.d2(this, iU1, getPaddingTop(), iP1, getPaddingBottom());
    }

    public final void I() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        ie.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f19946w);
        }
    }

    public final void J(@p0 AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", v.z.C);
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
        attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", v.z.I, 8388627);
    }

    @Override // com.google.android.material.chip.a.InterfaceC0204a
    public void a() {
        m(this.f19940q);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@n0 MotionEvent motionEvent) {
        return !this.f19943t ? super.dispatchHoverEvent(motionEvent) : this.f19942s.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f19943t) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f19942s.w(keyEvent) || this.f19942s.B() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f19928e;
        if ((aVar == null || !aVar.c2()) ? false : this.f19928e.f3(l())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @n0
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f19941r)) {
            return this.f19941r;
        }
        if (!s()) {
            return isClickable() ? f19923k1 : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof rd.b) && ((rd.b) parent).l()) ? f19924v1 : f19923k1;
    }

    @p0
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f19929f;
        return insetDrawable == null ? this.f19928e : insetDrawable;
    }

    @p0
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.l1();
        }
        return null;
    }

    @p0
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.m1();
        }
        return null;
    }

    @p0
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.n1();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.o1());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f19928e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.p1();
        }
        return 0.0f;
    }

    @p0
    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.q1();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.r1();
        }
        return 0.0f;
    }

    @p0
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.s1();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.t1();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.u1();
        }
        return 0.0f;
    }

    @p0
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.v1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.w1();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @p0
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.y1();
        }
        return null;
    }

    @p0
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.z1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.A1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.B1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.C1();
        }
        return 0.0f;
    }

    @p0
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.E1();
        }
        return null;
    }

    @Override // android.widget.TextView
    @p0
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.I1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@n0 Rect rect) {
        if (this.f19943t && (this.f19942s.B() == 1 || this.f19942s.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @p0
    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.J1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.K1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.L1();
        }
        return 0.0f;
    }

    @p0
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.N1();
        }
        return null;
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        return this.f19928e.getShapeAppearanceModel();
    }

    @p0
    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.O1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.R1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            return aVar.S1();
        }
        return 0.0f;
    }

    public final void k(@n0 com.google.android.material.chip.a aVar) {
        aVar.k3(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @n0
    public final int[] l() {
        ?? IsEnabled = isEnabled();
        int i10 = IsEnabled;
        if (this.f19937n) {
            i10 = IsEnabled + 1;
        }
        int i11 = i10;
        if (this.f19936m) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f19935l) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f19937n) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f19936m) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f19935l) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    public boolean m(@r int i10) {
        this.f19940q = i10;
        if (!C()) {
            if (this.f19929f != null) {
                B();
            } else {
                F();
            }
            return false;
        }
        int iMax = Math.max(0, i10 - this.f19928e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i10 - this.f19928e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f19929f != null) {
                B();
            } else {
                F();
            }
            return false;
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.f19929f != null) {
            Rect rect = new Rect();
            this.f19929f.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                F();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        r(i11, i12, i11, i12);
        F();
        return true;
    }

    public final void n() {
        if (getBackgroundDrawable() == this.f19929f && this.f19928e.getCallback() == null) {
            this.f19928e.setCallback(this.f19929f);
        }
    }

    public final boolean o() {
        com.google.android.material.chip.a aVar = this.f19928e;
        return (aVar == null || aVar.y1() == null) ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.f19928e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        if (s()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f19943t) {
            this.f19942s.M(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@n0 MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof rd.b) {
            rd.b bVar = (rd.b) getParent();
            d.g2(accessibilityNodeInfo).e1(d.e.h(bVar.b(this), 1, bVar.c() ? bVar.i(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @p0
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@n0 MotionEvent motionEvent, int i10) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f19939p != i10) {
            this.f19939p = i10;
            H();
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
    public boolean onTouchEvent(@g.n0 android.view.MotionEvent r6) {
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
            boolean r0 = r5.f19935l
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f19935l
            if (r0 == 0) goto L34
            r5.A()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(Context context, @p0 AttributeSet attributeSet, int i10) {
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.Chip, i10, f19926y, new int[0]);
        this.f19938o = typedArrayK.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f19940q = (int) Math.ceil(typedArrayK.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(b0.e(getContext(), 48))));
        typedArrayK.recycle();
    }

    public final void q() {
        setOutlineProvider(new b());
    }

    public final void r(int i10, int i11, int i12, int i13) {
        this.f19929f = new InsetDrawable((Drawable) this.f19928e, i10, i11, i12, i13);
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f19928e;
        return aVar != null && aVar.W1();
    }

    public void setAccessibilityClassName(@p0 CharSequence charSequence) {
        this.f19941r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f19930g) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f19930g) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i10) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@p0 ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@p0 PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.l2(z10);
        }
    }

    public void setCheckableResource(@g.h int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.m2(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar == null) {
            this.f19934k = z10;
        } else if (aVar.W1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(@p0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.n2(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@g.h int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(@g.v int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.q2(i10);
        }
    }

    public void setCheckedIconTint(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.r2(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.s2(i10);
        }
    }

    public void setCheckedIconVisible(@g.h int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.t2(i10);
        }
    }

    public void setChipBackgroundColor(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.v2(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.w2(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.x2(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.y2(i10);
        }
    }

    public void setChipDrawable(@n0 com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f19928e;
        if (aVar2 != aVar) {
            D(aVar2);
            this.f19928e = aVar;
            aVar.v3(false);
            k(this.f19928e);
            m(this.f19940q);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.z2(f10);
        }
    }

    public void setChipEndPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.A2(i10);
        }
    }

    public void setChipIcon(@p0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.B2(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@g.h int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(@g.v int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.E2(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.F2(f10);
        }
    }

    public void setChipIconSizeResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.G2(i10);
        }
    }

    public void setChipIconTint(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.H2(colorStateList);
        }
    }

    public void setChipIconTintResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.I2(i10);
        }
    }

    public void setChipIconVisible(@g.h int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.J2(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.L2(f10);
        }
    }

    public void setChipMinHeightResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.M2(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.N2(f10);
        }
    }

    public void setChipStartPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.O2(i10);
        }
    }

    public void setChipStrokeColor(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.P2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.Q2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.R2(f10);
        }
    }

    public void setChipStrokeWidthResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.S2(i10);
        }
    }

    @Deprecated
    public void setChipText(@p0 CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@c1 int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(@p0 Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.U2(drawable);
        }
        E();
    }

    public void setCloseIconContentDescription(@p0 CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.V2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@g.h int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.Y2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.Z2(i10);
        }
    }

    public void setCloseIconResource(@g.v int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.a3(i10);
        }
        E();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.b3(f10);
        }
    }

    public void setCloseIconSizeResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.c3(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.d3(f10);
        }
    }

    public void setCloseIconStartPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.e3(i10);
        }
    }

    public void setCloseIconTint(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.g3(colorStateList);
        }
    }

    public void setCloseIconTintResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.h3(i10);
        }
    }

    public void setCloseIconVisible(@g.h int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    @v0(17)
    public void setCompoundDrawablesRelative(@p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.n0(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f19928e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.l3(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f19938o = z10;
        m(this.f19940q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            return;
        }
        super.setGravity(i10);
    }

    public void setHideMotionSpec(@p0 h hVar) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.m3(hVar);
        }
    }

    public void setHideMotionSpecResource(@g.b int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.n3(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.o3(f10);
        }
    }

    public void setIconEndPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.p3(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.q3(f10);
        }
    }

    public void setIconStartPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.r3(i10);
        }
    }

    @Override // com.google.android.material.internal.j
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@p0 j.a<Chip> aVar) {
        this.f19933j = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f19928e == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@t0 int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.s3(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@p0 CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f19932i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f19931h = onClickListener;
        E();
    }

    public void setRippleColor(@p0 ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.t3(colorStateList);
        }
        if (this.f19928e.U1()) {
            return;
        }
        G();
    }

    public void setRippleColorResource(@n int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.u3(i10);
            if (this.f19928e.U1()) {
                return;
            }
            G();
        }
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        this.f19928e.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(@p0 h hVar) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.w3(hVar);
        }
    }

    public void setShowMotionSpecResource(@g.b int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.x3(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.K3() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f19928e;
        if (aVar2 != null) {
            aVar2.y3(charSequence);
        }
    }

    public void setTextAppearance(@p0 ie.d dVar) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.z3(dVar);
        }
        I();
    }

    public void setTextAppearanceResource(@d1 int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.D3(f10);
        }
    }

    public void setTextEndPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.E3(i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.G3(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        I();
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.H3(f10);
        }
    }

    public void setTextStartPaddingResource(@q int i10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.I3(i10);
        }
    }

    @Deprecated
    public boolean t() {
        return u();
    }

    public boolean u() {
        com.google.android.material.chip.a aVar = this.f19928e;
        return aVar != null && aVar.Y1();
    }

    @Deprecated
    public boolean v() {
        return w();
    }

    public boolean w() {
        com.google.android.material.chip.a aVar = this.f19928e;
        return aVar != null && aVar.a2();
    }

    @Deprecated
    public boolean x() {
        return y();
    }

    public boolean y() {
        com.google.android.material.chip.a aVar = this.f19928e;
        return aVar != null && aVar.d2();
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.j3(z10);
        }
        E();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f19926y;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19944u = new Rect();
        this.f19945v = new RectF();
        this.f19946w = new a();
        Context context2 = getContext();
        J(attributeSet);
        com.google.android.material.chip.a aVarA1 = com.google.android.material.chip.a.a1(context2, attributeSet, i10, i11);
        p(context2, attributeSet, i10);
        setChipDrawable(aVarA1);
        aVarA1.n0(u0.R(this));
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.Chip, i10, i11, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(ie.c.a(context2, typedArrayK, R.styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayK.hasValue(R.styleable.Chip_shapeAppearance);
        typedArrayK.recycle();
        this.f19942s = new c(this);
        E();
        if (!zHasValue) {
            q();
        }
        setChecked(this.f19934k);
        setText(aVarA1.P1());
        setEllipsize(aVarA1.I1());
        I();
        if (!this.f19928e.K3()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        H();
        if (C()) {
            setMinHeight(this.f19940q);
        }
        this.f19939p = u0.Z(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: rd.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f48545a.z(compoundButton, z10);
            }
        });
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.u2(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.K2(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.A3(i10);
        }
        I();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f19928e;
        if (aVar != null) {
            aVar.A3(i10);
        }
        I();
    }
}
