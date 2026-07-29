package ce;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.y0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.n0;
import g.p0;
import g.v;
import m0.g;
import n0.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends SwitchCompat {

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f10927f8 = R.style.Widget_Material3_CompoundButton_MaterialSwitch;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int[] f10928g8 = {R.attr.state_with_icon};

    @p0
    public Drawable T7;

    @p0
    public Drawable U7;

    @p0
    public Drawable V7;

    @p0
    public Drawable W7;

    @p0
    public ColorStateList X7;

    @p0
    public ColorStateList Y7;

    @n0
    public PorterDuff.Mode Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    @p0
    public ColorStateList f10929a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    @p0
    public ColorStateList f10930b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @n0
    public PorterDuff.Mode f10931c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public int[] f10932d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int[] f10933e8;

    public a(@n0 Context context) {
        this(context, null);
    }

    public static void u(@p0 Drawable drawable, @p0 ColorStateList colorStateList, @n0 int[] iArr, @n0 int[] iArr2, float f10) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        c.n(drawable, g.i(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f10));
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @p0
    public Drawable getThumbDrawable() {
        return this.T7;
    }

    @p0
    public Drawable getThumbIconDrawable() {
        return this.U7;
    }

    @p0
    public ColorStateList getThumbIconTintList() {
        return this.Y7;
    }

    @n0
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.Z7;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @p0
    public ColorStateList getThumbTintList() {
        return this.X7;
    }

    @p0
    public Drawable getTrackDecorationDrawable() {
        return this.W7;
    }

    @p0
    public ColorStateList getTrackDecorationTintList() {
        return this.f10930b8;
    }

    @n0
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f10931c8;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @p0
    public Drawable getTrackDrawable() {
        return this.V7;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @p0
    public ColorStateList getTrackTintList() {
        return this.f10929a8;
    }

    @Override // android.view.View
    public void invalidate() {
        v();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (this.U7 != null) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, f10928g8);
        }
        this.f10932d8 = yd.a.f(iArrOnCreateDrawableState);
        this.f10933e8 = yd.a.e(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    public final void s() {
        this.T7 = yd.a.b(this.T7, this.X7, getThumbTintMode());
        this.U7 = yd.a.b(this.U7, this.Y7, this.Z7);
        v();
        super.setThumbDrawable(yd.a.a(this.T7, this.U7));
        refreshDrawableState();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@p0 Drawable drawable) {
        this.T7 = drawable;
        s();
    }

    public void setThumbIconDrawable(@p0 Drawable drawable) {
        this.U7 = drawable;
        s();
    }

    public void setThumbIconResource(@v int i10) {
        setThumbIconDrawable(i.a.b(getContext(), i10));
    }

    public void setThumbIconTintList(@p0 ColorStateList colorStateList) {
        this.Y7 = colorStateList;
        s();
    }

    public void setThumbIconTintMode(@n0 PorterDuff.Mode mode) {
        this.Z7 = mode;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@p0 ColorStateList colorStateList) {
        this.X7 = colorStateList;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@p0 PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        s();
    }

    public void setTrackDecorationDrawable(@p0 Drawable drawable) {
        this.W7 = drawable;
        t();
    }

    public void setTrackDecorationResource(@v int i10) {
        setTrackDecorationDrawable(i.a.b(getContext(), i10));
    }

    public void setTrackDecorationTintList(@p0 ColorStateList colorStateList) {
        this.f10930b8 = colorStateList;
        t();
    }

    public void setTrackDecorationTintMode(@n0 PorterDuff.Mode mode) {
        this.f10931c8 = mode;
        t();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@p0 Drawable drawable) {
        this.V7 = drawable;
        t();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@p0 ColorStateList colorStateList) {
        this.f10929a8 = colorStateList;
        t();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@p0 PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        t();
    }

    public final void t() {
        this.V7 = yd.a.b(this.V7, this.f10929a8, getTrackTintMode());
        this.W7 = yd.a.b(this.W7, this.f10930b8, this.f10931c8);
        v();
        Drawable layerDrawable = this.V7;
        if (layerDrawable != null && this.W7 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.V7, this.W7});
        } else if (layerDrawable == null) {
            layerDrawable = this.W7;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    public final void v() {
        if (this.X7 == null && this.Y7 == null && this.f10929a8 == null && this.f10930b8 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.X7;
        if (colorStateList != null) {
            u(this.T7, colorStateList, this.f10932d8, this.f10933e8, thumbPosition);
        }
        ColorStateList colorStateList2 = this.Y7;
        if (colorStateList2 != null) {
            u(this.U7, colorStateList2, this.f10932d8, this.f10933e8, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f10929a8;
        if (colorStateList3 != null) {
            u(this.V7, colorStateList3, this.f10932d8, this.f10933e8, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f10930b8;
        if (colorStateList4 != null) {
            u(this.W7, colorStateList4, this.f10932d8, this.f10933e8, thumbPosition);
        }
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f10927f8;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.T7 = super.getThumbDrawable();
        this.X7 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.V7 = super.getTrackDrawable();
        this.f10929a8 = super.getTrackTintList();
        super.setTrackTintList(null);
        y0 y0VarL = t.l(context2, attributeSet, R.styleable.MaterialSwitch, i10, i11, new int[0]);
        this.U7 = y0VarL.h(R.styleable.MaterialSwitch_thumbIcon);
        this.Y7 = y0VarL.d(R.styleable.MaterialSwitch_thumbIconTint);
        this.Z7 = b0.m(y0VarL.o(R.styleable.MaterialSwitch_thumbIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.W7 = y0VarL.h(R.styleable.MaterialSwitch_trackDecoration);
        this.f10930b8 = y0VarL.d(R.styleable.MaterialSwitch_trackDecorationTint);
        this.f10931c8 = b0.m(y0VarL.o(R.styleable.MaterialSwitch_trackDecorationTintMode, -1), PorterDuff.Mode.SRC_IN);
        y0VarL.I();
        setEnforceSwitchWidth(false);
        s();
        t();
    }
}
