package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes5.dex */
public class RoundedRectangleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f25147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f25148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f25149f;

    public RoundedRectangleImageView(Context context) {
        super(context);
        b(context);
    }

    public final void b(Context context) {
        this.f25147d = context.getResources().getDisplayMetrics().density * 2.0f;
        this.f25148e = new Path();
        this.f25149f = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.clipPath(this.f25148e);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f25149f.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Path path = this.f25148e;
        RectF rectF = this.f25149f;
        float f10 = this.f25147d;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    public RoundedRectangleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public RoundedRectangleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context);
    }
}
