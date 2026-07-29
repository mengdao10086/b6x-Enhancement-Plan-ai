package d6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends GridView {
    public b(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @v0(api = 21)
    public b(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
