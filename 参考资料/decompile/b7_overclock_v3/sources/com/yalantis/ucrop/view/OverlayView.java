package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import g.f0;
import g.l;
import g.n0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import jh.d;
import mh.g;

/* JADX INFO: loaded from: classes5.dex */
public class OverlayView extends View {
    public static final int C = 0;
    public static final int C1 = 0;
    public static final int D = 1;
    public static final boolean K0 = true;
    public static final int K1 = 2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f24987k0 = 2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final boolean f24988k1 = true;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final boolean f24989v1 = false;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f24990v2 = 2;
    public d A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f24991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f24992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f24995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f24996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f24998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f24999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f25000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f25002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f25003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f25004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f25005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f25006p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f25007q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f25008r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f25009s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f25010t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f25011u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f25012v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f25013w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f25014x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f25015y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f25016z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    public void a(@n0 Canvas canvas) {
        if (this.f25002l) {
            if (this.f25000j == null && !this.f24991a.isEmpty()) {
                this.f25000j = new float[(this.f24997g * 4) + (this.f24998h * 4)];
                int i10 = 0;
                for (int i11 = 0; i11 < this.f24997g; i11++) {
                    float[] fArr = this.f25000j;
                    int i12 = i10 + 1;
                    RectF rectF = this.f24991a;
                    fArr[i10] = rectF.left;
                    int i13 = i12 + 1;
                    float f10 = i11 + 1.0f;
                    float fHeight = rectF.height() * (f10 / (this.f24997g + 1));
                    RectF rectF2 = this.f24991a;
                    fArr[i12] = fHeight + rectF2.top;
                    float[] fArr2 = this.f25000j;
                    int i14 = i13 + 1;
                    fArr2[i13] = rectF2.right;
                    i10 = i14 + 1;
                    fArr2[i14] = (rectF2.height() * (f10 / (this.f24997g + 1))) + this.f24991a.top;
                }
                for (int i15 = 0; i15 < this.f24998h; i15++) {
                    float[] fArr3 = this.f25000j;
                    int i16 = i10 + 1;
                    float f11 = i15 + 1.0f;
                    float fWidth = this.f24991a.width() * (f11 / (this.f24998h + 1));
                    RectF rectF3 = this.f24991a;
                    fArr3[i10] = fWidth + rectF3.left;
                    float[] fArr4 = this.f25000j;
                    int i17 = i16 + 1;
                    fArr4[i16] = rectF3.top;
                    int i18 = i17 + 1;
                    float fWidth2 = rectF3.width() * (f11 / (this.f24998h + 1));
                    RectF rectF4 = this.f24991a;
                    fArr4[i17] = fWidth2 + rectF4.left;
                    i10 = i18 + 1;
                    this.f25000j[i18] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.f25000j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.f25007q);
            }
        }
        if (this.f25001k) {
            canvas.drawRect(this.f24991a, this.f25008r);
        }
        if (this.f25010t != 0) {
            canvas.save();
            this.f24992b.set(this.f24991a);
            this.f24992b.inset(this.f25016z, -r1);
            canvas.clipRect(this.f24992b, Region.Op.DIFFERENCE);
            this.f24992b.set(this.f24991a);
            this.f24992b.inset(-r1, this.f25016z);
            canvas.clipRect(this.f24992b, Region.Op.DIFFERENCE);
            canvas.drawRect(this.f24991a, this.f25009s);
            canvas.restore();
        }
    }

    public void b(@n0 Canvas canvas) {
        canvas.save();
        if (this.f25003m) {
            canvas.clipPath(this.f25005o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f24991a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.f25004n);
        canvas.restore();
        if (this.f25003m) {
            canvas.drawCircle(this.f24991a.centerX(), this.f24991a.centerY(), Math.min(this.f24991a.width(), this.f24991a.height()) / 2.0f, this.f25006p);
        }
    }

    public final int c(float f10, float f11) {
        double d10 = this.f25014x;
        int i10 = -1;
        for (int i11 = 0; i11 < 8; i11 += 2) {
            double dSqrt = Math.sqrt(Math.pow(f10 - this.f24995e[i11], 2.0d) + Math.pow(f11 - this.f24995e[i11 + 1], 2.0d));
            if (dSqrt < d10) {
                i10 = i11 / 2;
                d10 = dSqrt;
            }
        }
        if (this.f25010t == 1 && i10 < 0 && this.f24991a.contains(f10, f11)) {
            return 4;
        }
        return i10;
    }

    public void d() {
    }

    public final void e(@n0 TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.f25008r.setStrokeWidth(dimensionPixelSize);
        this.f25008r.setColor(color);
        this.f25008r.setStyle(Paint.Style.STROKE);
        this.f25009s.setStrokeWidth(dimensionPixelSize * 3);
        this.f25009s.setColor(color);
        this.f25009s.setStyle(Paint.Style.STROKE);
    }

    public final void f(@n0 TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.f25007q.setStrokeWidth(dimensionPixelSize);
        this.f25007q.setColor(color);
        this.f24997g = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.f24998h = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    @Deprecated
    public boolean g() {
        return this.f25010t == 1;
    }

    @n0
    public RectF getCropViewRect() {
        return this.f24991a;
    }

    public int getFreestyleCropMode() {
        return this.f25010t;
    }

    public d getOverlayViewChangeListener() {
        return this.A;
    }

    public void h(@n0 TypedArray typedArray) {
        this.f25003m = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.f25004n = color;
        this.f25006p.setColor(color);
        this.f25006p.setStyle(Paint.Style.STROKE);
        this.f25006p.setStrokeWidth(1.0f);
        e(typedArray);
        this.f25001k = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        f(typedArray);
        this.f25002l = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void i() {
        int i10 = this.f24993c;
        float f10 = this.f24999i;
        int i11 = (int) (i10 / f10);
        int i12 = this.f24994d;
        if (i11 > i12) {
            int i13 = (i10 - ((int) (i12 * f10))) / 2;
            this.f24991a.set(getPaddingLeft() + i13, getPaddingTop(), getPaddingLeft() + r1 + i13, getPaddingTop() + this.f24994d);
        } else {
            int i14 = (i12 - i11) / 2;
            this.f24991a.set(getPaddingLeft(), getPaddingTop() + i14, getPaddingLeft() + this.f24993c, getPaddingTop() + i11 + i14);
        }
        d dVar = this.A;
        if (dVar != null) {
            dVar.a(this.f24991a);
        }
        k();
    }

    public final void j(float f10, float f11) {
        this.f24992b.set(this.f24991a);
        int i10 = this.f25013w;
        if (i10 == 0) {
            RectF rectF = this.f24992b;
            RectF rectF2 = this.f24991a;
            rectF.set(f10, f11, rectF2.right, rectF2.bottom);
        } else if (i10 == 1) {
            RectF rectF3 = this.f24992b;
            RectF rectF4 = this.f24991a;
            rectF3.set(rectF4.left, f11, f10, rectF4.bottom);
        } else if (i10 == 2) {
            RectF rectF5 = this.f24992b;
            RectF rectF6 = this.f24991a;
            rectF5.set(rectF6.left, rectF6.top, f10, f11);
        } else if (i10 == 3) {
            RectF rectF7 = this.f24992b;
            RectF rectF8 = this.f24991a;
            rectF7.set(f10, rectF8.top, rectF8.right, f11);
        } else if (i10 == 4) {
            this.f24992b.offset(f10 - this.f25011u, f11 - this.f25012v);
            if (this.f24992b.left <= getLeft() || this.f24992b.top <= getTop() || this.f24992b.right >= getRight() || this.f24992b.bottom >= getBottom()) {
                return;
            }
            this.f24991a.set(this.f24992b);
            k();
            postInvalidate();
            return;
        }
        boolean z10 = this.f24992b.height() >= ((float) this.f25015y);
        boolean z11 = this.f24992b.width() >= ((float) this.f25015y);
        RectF rectF9 = this.f24991a;
        rectF9.set(z11 ? this.f24992b.left : rectF9.left, z10 ? this.f24992b.top : rectF9.top, z11 ? this.f24992b.right : rectF9.right, z10 ? this.f24992b.bottom : rectF9.bottom);
        if (z10 || z11) {
            k();
            postInvalidate();
        }
    }

    public final void k() {
        this.f24995e = g.b(this.f24991a);
        this.f24996f = g.a(this.f24991a);
        this.f25000j = null;
        this.f25005o.reset();
        this.f25005o.addCircle(this.f24991a.centerX(), this.f24991a.centerY(), Math.min(this.f24991a.width(), this.f24991a.height()) / 2.0f, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f24993c = width - paddingLeft;
            this.f24994d = height - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.f24999i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f24991a.isEmpty() && this.f25010t != 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int iC = c(x10, y10);
                this.f25013w = iC;
                boolean z10 = iC != -1;
                if (!z10) {
                    this.f25011u = -1.0f;
                    this.f25012v = -1.0f;
                } else if (this.f25011u < 0.0f) {
                    this.f25011u = x10;
                    this.f25012v = y10;
                }
                return z10;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.f25013w != -1) {
                float fMin = Math.min(Math.max(x10, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = Math.min(Math.max(y10, getPaddingTop()), getHeight() - getPaddingBottom());
                j(fMin, fMin2);
                this.f25011u = fMin;
                this.f25012v = fMin2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.f25011u = -1.0f;
                this.f25012v = -1.0f;
                this.f25013w = -1;
                d dVar = this.A;
                if (dVar != null) {
                    dVar.a(this.f24991a);
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z10) {
        this.f25003m = z10;
    }

    public void setCropFrameColor(@l int i10) {
        this.f25008r.setColor(i10);
    }

    public void setCropFrameStrokeWidth(@f0(from = 0) int i10) {
        this.f25008r.setStrokeWidth(i10);
    }

    public void setCropGridColor(@l int i10) {
        this.f25007q.setColor(i10);
    }

    public void setCropGridColumnCount(@f0(from = 0) int i10) {
        this.f24998h = i10;
        this.f25000j = null;
    }

    public void setCropGridRowCount(@f0(from = 0) int i10) {
        this.f24997g = i10;
        this.f25000j = null;
    }

    public void setCropGridStrokeWidth(@f0(from = 0) int i10) {
        this.f25007q.setStrokeWidth(i10);
    }

    public void setDimmedColor(@l int i10) {
        this.f25004n = i10;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z10) {
        this.f25010t = z10 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i10) {
        this.f25010t = i10;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.A = dVar;
    }

    public void setShowCropFrame(boolean z10) {
        this.f25001k = z10;
    }

    public void setShowCropGrid(boolean z10) {
        this.f25002l = z10;
    }

    public void setTargetAspectRatio(float f10) {
        this.f24999i = f10;
        if (this.f24993c <= 0) {
            this.B = true;
        } else {
            i();
            postInvalidate();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f24991a = new RectF();
        this.f24992b = new RectF();
        this.f25000j = null;
        this.f25005o = new Path();
        this.f25006p = new Paint(1);
        this.f25007q = new Paint(1);
        this.f25008r = new Paint(1);
        this.f25009s = new Paint(1);
        this.f25010t = 0;
        this.f25011u = -1.0f;
        this.f25012v = -1.0f;
        this.f25013w = -1;
        this.f25014x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.f25015y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.f25016z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        d();
    }
}
