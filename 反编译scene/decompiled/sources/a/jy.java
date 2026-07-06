package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jy extends d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6553a = iv.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f1583a = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1584a;
    public boolean b;

    public jy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.radioButtonStyle);
    }

    public jy(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, f6553a), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.MaterialRadioButton, i, f6553a, new int[0]);
        if (typedArrayH.hasValue(jv.MaterialRadioButton_buttonTint)) {
            gj.c(this, ny.a(context2, typedArrayH, jv.MaterialRadioButton_buttonTint));
        }
        this.b = typedArrayH.getBoolean(jv.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayH.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f1584a == null) {
            int iC = iw.c(this, zu.colorControlActivated);
            int iC2 = iw.c(this, zu.colorOnSurface);
            int iC3 = iw.c(this, zu.colorSurface);
            int[] iArr = new int[f1583a.length];
            iArr[0] = iw.f(iC3, iC, 1.0f);
            iArr[1] = iw.f(iC3, iC2, 0.54f);
            iArr[2] = iw.f(iC3, iC2, 0.38f);
            iArr[3] = iw.f(iC3, iC2, 0.38f);
            this.f1584a = new ColorStateList(f1583a, iArr);
        }
        return this.f1584a;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && gj.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.b = z;
        gj.c(this, z ? getMaterialThemeColorsTintList() : null);
    }
}
