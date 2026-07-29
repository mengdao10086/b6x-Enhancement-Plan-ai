package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.n0;
import g.p0;
import vd.m;
import zd.a;

/* JADX INFO: loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int X7 = R.style.Widget_MaterialComponents_CompoundButton_Switch;
    public static final int[][] Y7 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @n0
    public final a T7;

    @p0
    public ColorStateList U7;

    @p0
    public ColorStateList V7;
    public boolean W7;

    public SwitchMaterial(@n0 Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.U7 == null) {
            int iD = m.d(this, R.attr.colorSurface);
            int iD2 = m.d(this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.T7.l()) {
                dimension += b0.j(this);
            }
            int iE = this.T7.e(iD, dimension);
            int[][] iArr = Y7;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = m.n(iD, iD2, 1.0f);
            iArr2[1] = iE;
            iArr2[2] = m.n(iD, iD2, 0.38f);
            iArr2[3] = iE;
            this.U7 = new ColorStateList(iArr, iArr2);
        }
        return this.U7;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.V7 == null) {
            int[][] iArr = Y7;
            int[] iArr2 = new int[iArr.length];
            int iD = m.d(this, R.attr.colorSurface);
            int iD2 = m.d(this, R.attr.colorControlActivated);
            int iD3 = m.d(this, R.attr.colorOnSurface);
            iArr2[0] = m.n(iD, iD2, 0.54f);
            iArr2[1] = m.n(iD, iD3, 0.32f);
            iArr2[2] = m.n(iD, iD2, 0.12f);
            iArr2[3] = m.n(iD, iD3, 0.12f);
            this.V7 = new ColorStateList(iArr, iArr2);
        }
        return this.V7;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W7 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.W7 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public boolean s() {
        return this.W7;
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.W7 = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = X7;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.T7 = new a(context2);
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.SwitchMaterial, i10, i11, new int[0]);
        this.W7 = typedArrayK.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayK.recycle();
    }
}
