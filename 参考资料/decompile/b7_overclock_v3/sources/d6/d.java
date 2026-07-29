package d6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends RecyclerView {
    public d(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public d(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public d(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
