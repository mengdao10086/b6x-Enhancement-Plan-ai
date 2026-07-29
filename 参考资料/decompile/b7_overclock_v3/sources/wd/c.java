package wd;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.f;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c {
    @n0
    public static Rect a(@n0 Context context, @f int i10, int i11) {
        TypedArray typedArrayK = t.k(context, null, R.styleable.MaterialAlertDialog, i10, i11, new int[0]);
        int dimensionPixelSize = typedArrayK.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayK.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayK.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayK.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayK.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    @n0
    public static InsetDrawable b(@p0 Drawable drawable, @n0 Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
