package com.flydigi.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.flydigi.base.R;
import g.l;
import g.p0;
import g.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IndicatorView extends View {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13495m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13496n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f13497o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f13498p = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f13499q = 20;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f13500r = 10;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13501s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f13502t = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public int f13505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public int f13506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @r
    public int f13507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @r
    public int f13509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @r
    public int f13510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @r
    public int f13511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @r
    public int f13512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<a> f13513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f13514l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13516b;
    }

    public IndicatorView(Context context) {
        this(context, null);
    }

    public final void a() {
        if (isInEditMode()) {
            if (this.f13503a == 0) {
                this.f13503a = 4;
            }
            setStepsNumber(this.f13503a);
        }
    }

    public final void b(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView, i10, 0);
        this.f13508f = typedArrayObtainStyledAttributes.getInt(R.styleable.IndicatorView_type, 1);
        this.f13503a = typedArrayObtainStyledAttributes.getInteger(R.styleable.IndicatorView_stepsNumber, 5);
        this.f13505c = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorView_defaultColor, getResources().getColor(android.R.color.darker_gray));
        this.f13506d = typedArrayObtainStyledAttributes.getColor(R.styleable.IndicatorView_currentColor, getResources().getColor(R.color.colorPrimary));
        this.f13507e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_space, 10);
        this.f13512j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_strokeWidth, 1);
        this.f13509g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_radius, 10);
        this.f13510h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_width, 20);
        this.f13511i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_height, 10);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f13514l = paint;
        paint.setDither(true);
        this.f13514l.setAntiAlias(true);
        this.f13514l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13514l.setStrokeWidth(this.f13512j);
        this.f13513k = new ArrayList();
        a();
    }

    public final void c() {
        int i10;
        int i11;
        this.f13513k.clear();
        float f10 = 0.0f;
        for (int i12 = 0; i12 < this.f13503a; i12++) {
            a aVar = new a();
            if (this.f13508f == 1) {
                if (i12 == 0) {
                    f10 = this.f13509g + this.f13512j;
                } else {
                    i10 = (this.f13509g + this.f13512j) * 2;
                    i11 = this.f13507e;
                    f10 += i10 + i11;
                }
            } else if (i12 == 0) {
                f10 = (this.f13510h + this.f13512j) / 2.0f;
            } else {
                i10 = this.f13510h + this.f13512j;
                i11 = this.f13507e;
                f10 += i10 + i11;
            }
            aVar.f13515a = f10;
            aVar.f13516b = getMeasuredHeight() / 2.0f;
            this.f13513k.add(aVar);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f13513k.size(); i10++) {
            a aVar = this.f13513k.get(i10);
            float f10 = aVar.f13515a;
            float f11 = aVar.f13516b;
            if (this.f13504b == i10) {
                this.f13514l.setStyle(Paint.Style.FILL);
                this.f13514l.setColor(this.f13506d);
            } else {
                this.f13514l.setColor(this.f13505c);
                this.f13514l.setStyle(Paint.Style.FILL);
            }
            int i11 = this.f13508f;
            if (i11 == 1) {
                canvas.drawCircle(f10, f11, this.f13509g, this.f13514l);
            } else if (i11 == 2) {
                if (this.f13509g <= 0) {
                    int i12 = this.f13510h;
                    int i13 = this.f13511i;
                    canvas.drawRect(f10 - (i12 / 2.0f), f11 - (i13 / 2.0f), f10 + (i12 / 2.0f), f11 + (i13 / 2.0f), this.f13514l);
                } else {
                    int i14 = this.f13510h;
                    int i15 = this.f13511i;
                    RectF rectF = new RectF(f10 - (i14 / 2.0f), f11 - (i15 / 2.0f), f10 + (i14 / 2.0f), f11 + (i15 / 2.0f));
                    int i16 = this.f13509g;
                    canvas.drawRoundRect(rectF, i16, i16, this.f13514l);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        if (this.f13508f == 1) {
            int i14 = this.f13509g;
            int i15 = (this.f13512j + i14) * 2;
            int i16 = this.f13503a;
            int i17 = this.f13507e;
            i12 = (i15 * i16) + ((i16 - 1) * i17);
            i13 = (i14 * 2) + (i17 * 2);
        } else {
            int i18 = this.f13510h + this.f13512j;
            int i19 = this.f13503a;
            int i20 = this.f13507e;
            i12 = ((i19 - 1) * i20) + (i18 * i19);
            i13 = this.f13511i + (i20 * 2);
        }
        setMeasuredDimension(i12, i13);
        c();
    }

    public void setCurrentColor(int i10) {
        this.f13506d = i10;
        invalidate();
    }

    public void setCurrentStep(int i10) {
        this.f13504b = i10;
        invalidate();
    }

    public void setDefaultColor(int i10) {
        this.f13505c = i10;
        invalidate();
    }

    public void setRadius(int i10) {
        this.f13509g = i10;
        invalidate();
    }

    public void setSpace(int i10) {
        this.f13507e = i10;
        invalidate();
    }

    public void setStepsNumber(int i10) {
        this.f13503a = i10;
        invalidate();
    }

    public IndicatorView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13503a = 5;
        this.f13508f = 1;
        b(context, attributeSet, i10);
    }
}
