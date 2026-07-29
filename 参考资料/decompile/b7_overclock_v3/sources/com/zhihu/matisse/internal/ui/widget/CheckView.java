package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.zhihu.matisse.R;
import j0.i;

/* JADX INFO: loaded from: classes5.dex */
public class CheckView extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25117l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f25118m = 3.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f25119n = 6.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25120o = 48;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f25121p = 11.5f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f25122q = 11.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f25123r = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f25127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f25128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextPaint f25129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f25130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f25131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f25132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f25133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25134k;

    public CheckView(Context context) {
        super(context);
        this.f25134k = true;
        a(context);
    }

    private Rect getCheckRect() {
        if (this.f25133j == null) {
            float f10 = this.f25132i;
            int i10 = (int) (((f10 * 48.0f) / 2.0f) - ((f10 * 16.0f) / 2.0f));
            float f11 = this.f25132i;
            float f12 = i10;
            this.f25133j = new Rect(i10, i10, (int) ((f11 * 48.0f) - f12), (int) ((f11 * 48.0f) - f12));
        }
        return this.f25133j;
    }

    public final void a(Context context) {
        this.f25132i = context.getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f25127d = paint;
        paint.setAntiAlias(true);
        this.f25127d.setStyle(Paint.Style.STROKE);
        this.f25127d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.f25127d.setStrokeWidth(this.f25132i * 3.0f);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.item_checkCircle_borderColor});
        int color = typedArrayObtainStyledAttributes.getColor(0, i.e(getResources(), R.color.zhihu_item_checkCircle_borderColor, getContext().getTheme()));
        typedArrayObtainStyledAttributes.recycle();
        this.f25127d.setColor(color);
        this.f25131h = i.g(context.getResources(), R.drawable.ic_check_white_18dp, context.getTheme());
    }

    public final void b() {
        if (this.f25128e == null) {
            Paint paint = new Paint();
            this.f25128e = paint;
            paint.setAntiAlias(true);
            this.f25128e.setStyle(Paint.Style.FILL);
            TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.item_checkCircle_backgroundColor});
            int color = typedArrayObtainStyledAttributes.getColor(0, i.e(getResources(), R.color.zhihu_item_checkCircle_backgroundColor, getContext().getTheme()));
            typedArrayObtainStyledAttributes.recycle();
            this.f25128e.setColor(color);
        }
    }

    public final void c() {
        if (this.f25130g == null) {
            Paint paint = new Paint();
            this.f25130g = paint;
            paint.setAntiAlias(true);
            Paint paint2 = this.f25130g;
            float f10 = this.f25132i;
            paint2.setShader(new RadialGradient((f10 * 48.0f) / 2.0f, (48.0f * f10) / 2.0f, 19.0f * f10, new int[]{Color.parseColor("#00000000"), Color.parseColor("#0D000000"), Color.parseColor("#0D000000"), Color.parseColor("#00000000")}, new float[]{0.21052632f, 0.5263158f, 0.68421054f, 1.0f}, Shader.TileMode.CLAMP));
        }
    }

    public final void d() {
        if (this.f25129f == null) {
            TextPaint textPaint = new TextPaint();
            this.f25129f = textPaint;
            textPaint.setAntiAlias(true);
            this.f25129f.setColor(-1);
            this.f25129f.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            this.f25129f.setTextSize(this.f25132i * 12.0f);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c();
        float f10 = this.f25132i;
        canvas.drawCircle((f10 * 48.0f) / 2.0f, (f10 * 48.0f) / 2.0f, f10 * 19.0f, this.f25130g);
        float f11 = this.f25132i;
        canvas.drawCircle((f11 * 48.0f) / 2.0f, (f11 * 48.0f) / 2.0f, f11 * 11.5f, this.f25127d);
        if (this.f25124a) {
            if (this.f25126c != Integer.MIN_VALUE) {
                b();
                float f12 = this.f25132i;
                canvas.drawCircle((f12 * 48.0f) / 2.0f, (48.0f * f12) / 2.0f, f12 * 11.0f, this.f25128e);
                d();
                canvas.drawText(String.valueOf(this.f25126c), ((int) (canvas.getWidth() - this.f25129f.measureText(r0))) / 2, ((int) ((canvas.getHeight() - this.f25129f.descent()) - this.f25129f.ascent())) / 2, this.f25129f);
            }
        } else if (this.f25125b) {
            b();
            float f13 = this.f25132i;
            canvas.drawCircle((f13 * 48.0f) / 2.0f, (48.0f * f13) / 2.0f, f13 * 11.0f, this.f25128e);
            this.f25131h.setBounds(getCheckRect());
            this.f25131h.draw(canvas);
        }
        setAlpha(this.f25134k ? 1.0f : 0.5f);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (this.f25132i * 48.0f), 1073741824);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public void setChecked(boolean z10) {
        if (this.f25124a) {
            throw new IllegalStateException("CheckView is countable, call setCheckedNum() instead.");
        }
        this.f25125b = z10;
        invalidate();
    }

    public void setCheckedNum(int i10) {
        if (!this.f25124a) {
            throw new IllegalStateException("CheckView is not countable, call setChecked() instead.");
        }
        if (i10 != Integer.MIN_VALUE && i10 <= 0) {
            throw new IllegalArgumentException("checked num can't be negative.");
        }
        this.f25126c = i10;
        invalidate();
    }

    public void setCountable(boolean z10) {
        this.f25124a = z10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (this.f25134k != z10) {
            this.f25134k = z10;
            invalidate();
        }
    }

    public CheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25134k = true;
        a(context);
    }

    public CheckView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f25134k = true;
        a(context);
    }
}
