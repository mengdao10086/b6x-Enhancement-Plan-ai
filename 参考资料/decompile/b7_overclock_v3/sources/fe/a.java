package fe;

import android.content.Context;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.i0;
import g.n0;
import g.q;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends com.google.android.material.navigation.a {
    public a(@n0 Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.a
    @q
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.a
    @i0
    public int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i11)), i11, 0));
        }
    }
}
