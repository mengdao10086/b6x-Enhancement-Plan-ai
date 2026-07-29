package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class t extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2699a;

    public t(@g.n0 Context context) {
        this(context, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap bitmapB = this.f2699a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public t(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public t(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t0.a(this, getContext());
        r rVar = new r(this);
        this.f2699a = rVar;
        rVar.c(attributeSet, i10);
    }
}
