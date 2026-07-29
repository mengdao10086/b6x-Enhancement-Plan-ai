package he;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.s;
import androidx.core.widget.d;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.n0;
import g.p0;
import ie.c;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class a extends s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31255g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[][] f31256h = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public ColorStateList f31257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31258f;

    public a(@n0 Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f31257e == null) {
            int iD = m.d(this, R.attr.colorControlActivated);
            int iD2 = m.d(this, R.attr.colorOnSurface);
            int iD3 = m.d(this, R.attr.colorSurface);
            int[][] iArr = f31256h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = m.n(iD3, iD, 1.0f);
            iArr2[1] = m.n(iD3, iD2, 0.54f);
            iArr2[2] = m.n(iD3, iD2, 0.38f);
            iArr2[3] = m.n(iD3, iD2, 0.38f);
            this.f31257e = new ColorStateList(iArr, iArr2);
        }
        return this.f31257e;
    }

    public boolean a() {
        return this.f31258f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f31258f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f31258f = z10;
        if (z10) {
            d.d(this, getMaterialThemeColorsTintList());
        } else {
            d.d(this, null);
        }
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f31255g;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.MaterialRadioButton, i10, i11, new int[0]);
        int i12 = R.styleable.MaterialRadioButton_buttonTint;
        if (typedArrayK.hasValue(i12)) {
            d.d(this, c.a(context2, typedArrayK, i12));
        }
        this.f31258f = typedArrayK.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayK.recycle();
    }
}
