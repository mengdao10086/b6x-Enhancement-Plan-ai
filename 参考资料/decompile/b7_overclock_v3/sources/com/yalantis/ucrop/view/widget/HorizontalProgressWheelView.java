package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import g.l;
import h0.d;

/* JADX INFO: loaded from: classes5.dex */
public class HorizontalProgressWheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f25029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f25030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f25031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f25032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f25033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f25038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25039k;

    public interface a {
        void a();

        void b(float f10, float f11);

        void c();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f25039k = d.f(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.f25034f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f25035g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f25036h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f25032d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f25032d.setStrokeWidth(this.f25034f);
        this.f25032d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f25032d);
        this.f25033e = paint2;
        paint2.setColor(this.f25039k);
        this.f25033e.setStrokeCap(Paint.Cap.ROUND);
        this.f25033e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    public final void b(MotionEvent motionEvent, float f10) {
        this.f25038j -= f10;
        postInvalidate();
        this.f25031c = motionEvent.getX();
        a aVar = this.f25030b;
        if (aVar != null) {
            aVar.b(-f10, this.f25038j);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f25029a);
        int iWidth = this.f25029a.width() / (this.f25034f + this.f25036h);
        float f10 = this.f25038j % (r2 + r1);
        for (int i10 = 0; i10 < iWidth; i10++) {
            int i11 = iWidth / 4;
            if (i10 < i11) {
                this.f25032d.setAlpha((int) ((i10 / i11) * 255.0f));
            } else if (i10 > (iWidth * 3) / 4) {
                this.f25032d.setAlpha((int) (((iWidth - i10) / i11) * 255.0f));
            } else {
                this.f25032d.setAlpha(255);
            }
            float f11 = -f10;
            Rect rect = this.f25029a;
            float f12 = rect.left + f11 + ((this.f25034f + this.f25036h) * i10);
            float fCenterY = rect.centerY() - (this.f25035g / 4.0f);
            Rect rect2 = this.f25029a;
            canvas.drawLine(f12, fCenterY, f11 + rect2.left + ((this.f25034f + this.f25036h) * i10), rect2.centerY() + (this.f25035g / 4.0f), this.f25032d);
        }
        canvas.drawLine(this.f25029a.centerX(), this.f25029a.centerY() - (this.f25035g / 2.0f), this.f25029a.centerX(), (this.f25035g / 2.0f) + this.f25029a.centerY(), this.f25033e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f25031c = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.f25030b;
            if (aVar != null) {
                this.f25037i = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x10 = motionEvent.getX() - this.f25031c;
            if (x10 != 0.0f) {
                if (!this.f25037i) {
                    this.f25037i = true;
                    a aVar2 = this.f25030b;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                b(motionEvent, x10);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@l int i10) {
        this.f25039k = i10;
        this.f25033e.setColor(i10);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.f25030b = aVar;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f25029a = new Rect();
        a();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f25029a = new Rect();
    }
}
