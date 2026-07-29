package ld;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import com.google.android.material.internal.u;
import g.l;
import g.n0;
import g.p0;
import g.v0;
import le.j;
import le.k;

/* JADX INFO: loaded from: classes3.dex */
public class c extends Toolbar {
    public static final int O7 = R.style.Widget_MaterialComponents_Toolbar;
    public static final ImageView.ScaleType[] P7 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    @p0
    public Integer J7;
    public boolean K7;
    public boolean L7;

    @p0
    public ImageView.ScaleType M7;

    @p0
    public Boolean N7;

    public c(@n0 Context context) {
        this(context, null);
    }

    public final Pair<Integer, Integer> V(@p0 TextView textView, @p0 TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    public void W() {
        this.J7 = null;
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            n0.c.o(n0.c.r(navigationIcon.mutate()), null);
            setNavigationIcon(navigationIcon);
        }
    }

    public final void X(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            j jVar = new j();
            jVar.o0(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            jVar.Z(context);
            jVar.n0(u0.R(this));
            u0.I1(this, jVar);
        }
    }

    public boolean Y() {
        Boolean bool = this.N7;
        return bool != null && bool.booleanValue();
    }

    public boolean Z() {
        return this.L7;
    }

    public boolean a0() {
        return this.K7;
    }

    public final void b0(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i10 += iMax;
            i11 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    public final void c0() {
        if (this.K7 || this.L7) {
            TextView textViewI = u.i(this);
            TextView textViewG = u.g(this);
            if (textViewI == null && textViewG == null) {
                return;
            }
            Pair<Integer, Integer> pairV = V(textViewI, textViewG);
            if (this.K7 && textViewI != null) {
                b0(textViewI, pairV);
            }
            if (!this.L7 || textViewG == null) {
                return;
            }
            b0(textViewG, pairV);
        }
    }

    @p0
    public final Drawable d0(@p0 Drawable drawable) {
        if (drawable == null || this.J7 == null) {
            return drawable;
        }
        Drawable drawableR = n0.c.r(drawable.mutate());
        n0.c.n(drawableR, this.J7.intValue());
        return drawableR;
    }

    public final void e0() {
        ImageView imageViewD = u.d(this);
        if (imageViewD != null) {
            Boolean bool = this.N7;
            if (bool != null) {
                imageViewD.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.M7;
            if (scaleType != null) {
                imageViewD.setScaleType(scaleType);
            }
        }
    }

    @p0
    public ImageView.ScaleType getLogoScaleType() {
        return this.M7;
    }

    @l
    @p0
    public Integer getNavigationIconTint() {
        return this.J7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        c0();
        e0();
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        k.d(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.N7;
        if (bool == null || bool.booleanValue() != z10) {
            this.N7 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(@n0 ImageView.ScaleType scaleType) {
        if (this.M7 != scaleType) {
            this.M7 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@p0 Drawable drawable) {
        super.setNavigationIcon(d0(drawable));
    }

    public void setNavigationIconTint(@l int i10) {
        this.J7 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.L7 != z10) {
            this.L7 = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.K7 != z10) {
            this.K7 = z10;
            requestLayout();
        }
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = O7;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.MaterialToolbar, i10, i11, new int[0]);
        int i12 = R.styleable.MaterialToolbar_navigationIconTint;
        if (typedArrayK.hasValue(i12)) {
            setNavigationIconTint(typedArrayK.getColor(i12, -1));
        }
        this.K7 = typedArrayK.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.L7 = typedArrayK.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        int i13 = typedArrayK.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = P7;
            if (i13 < scaleTypeArr.length) {
                this.M7 = scaleTypeArr[i13];
            }
        }
        int i14 = R.styleable.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayK.hasValue(i14)) {
            this.N7 = Boolean.valueOf(typedArrayK.getBoolean(i14, false));
        }
        typedArrayK.recycle();
        X(context2);
    }
}
