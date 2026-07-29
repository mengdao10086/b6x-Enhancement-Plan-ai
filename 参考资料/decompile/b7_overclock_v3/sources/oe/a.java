package oe;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import g.e1;
import g.n0;
import g.p0;
import ie.b;
import ie.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends AppCompatTextView {
    public a(@n0 Context context) {
        this(context, null);
    }

    public static boolean k(Context context) {
        return b.b(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    public static int l(@n0 Resources.Theme theme, @p0 AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int n(@n0 Context context, @n0 TypedArray typedArray, @e1 @n0 int... iArr) {
        int iD = -1;
        for (int i10 = 0; i10 < iArr.length && iD < 0; i10++) {
            iD = c.d(context, typedArray, iArr[i10], -1);
        }
        return iD;
    }

    public static boolean o(@n0 Context context, @n0 Resources.Theme theme, @p0 AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i10, i11);
        int iN = n(context, typedArrayObtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iN != -1;
    }

    public final void j(@n0 Resources.Theme theme, int i10) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, R.styleable.MaterialTextAppearance);
        int iN = n(getContext(), typedArrayObtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iN >= 0) {
            setLineHeight(iN);
        }
    }

    public final void m(@p0 AttributeSet attributeSet, int i10, int i11) {
        int iL;
        Context context = getContext();
        if (k(context)) {
            Resources.Theme theme = context.getTheme();
            if (o(context, theme, attributeSet, i10, i11) || (iL = l(theme, attributeSet, i10, i11)) == -1) {
                return;
            }
            j(theme, iL);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@n0 Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (k(context)) {
            j(context.getTheme(), i10);
        }
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(pe.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        m(attributeSet, i10, 0);
    }

    @Deprecated
    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        m(attributeSet, i10, i11);
    }
}
