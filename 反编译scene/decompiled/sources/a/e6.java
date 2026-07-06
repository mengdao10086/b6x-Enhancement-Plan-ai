package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e6 extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c6 f5969a;

    public e6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.ratingBarStyle);
    }

    public e6(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k8.a(this, getContext());
        c6 c6Var = new c6(this);
        this.f5969a = c6Var;
        c6Var.c(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapB = this.f5969a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
