package o1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a extends View {
    @Deprecated
    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    public static int a(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i10 : size : Math.min(i10, size);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    @Deprecated
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i10), a(getSuggestedMinimumHeight(), i11));
    }

    @Deprecated
    public a(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public a(@n0 Context context) {
        this(context, null);
    }
}
