package com.flydigi.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.x0;
import com.flydigi.game.R;
import g.p0;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class TextProgressView extends View {
    public static final int A = 7;
    public static final int B = 8;
    public static final String C = "progress";
    public static final String D = "state";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f15994u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f15995v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f15996w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f15997x = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f15998y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f15999z = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f16010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f16012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f16014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RectF f16016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f16017r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f16018s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a f16019t;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void open();

        void pause();

        void resume();
    }

    public TextProgressView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        a aVar = this.f16019t;
        if (aVar != null) {
            switch (this.f16000a) {
                case 1:
                    aVar.b();
                    i(4, 0.0f);
                    break;
                case 2:
                    aVar.a();
                    i(4, this.f16017r);
                    break;
                case 3:
                    aVar.open();
                    break;
                case 4:
                    aVar.pause();
                    i(6, this.f16017r);
                    break;
                case 5:
                    aVar.c();
                    i(5, 1.0f);
                    break;
                case 6:
                    aVar.resume();
                    i(4, this.f16017r);
                    break;
                case 7:
                    aVar.d();
                    break;
            }
        }
    }

    private void setStateContinue(float f10) {
        this.f16000a = 6;
        p(getContext().getString(R.string.continue_), f10);
    }

    public final void b(Canvas canvas, int i10, int i11, int i12) {
        this.f16012m.setColor(i10);
        canvas.save();
        canvas.clipRect(i11, 0, i12, getMeasuredHeight());
        canvas.drawText(this.f16010k, this.f16008i, (getMeasuredHeight() / 2) - ((this.f16012m.descent() + this.f16012m.ascent()) / 2.0f), this.f16012m);
        canvas.restore();
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextProgressView);
        this.f16010k = d1.l(typedArrayObtainStyledAttributes.getString(R.styleable.TextProgressView_tpv_text));
        this.f16002c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TextProgressView_tpv_textSize, this.f16002c);
        int i10 = R.styleable.TextProgressView_tpv_color_origin;
        this.f16003d = typedArrayObtainStyledAttributes.getColor(i10, this.f16003d);
        int i11 = R.styleable.TextProgressView_tpv_color_progress;
        this.f16004e = typedArrayObtainStyledAttributes.getColor(i11, this.f16004e);
        this.f16005f = typedArrayObtainStyledAttributes.getColor(i10, this.f16005f);
        this.f16006g = typedArrayObtainStyledAttributes.getColor(i11, this.f16006g);
        this.f16011l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TextProgressView_tpv_stroke_width, this.f16011l);
        this.f16007h = typedArrayObtainStyledAttributes.getColor(R.styleable.TextProgressView_tpv_stroke_color, this.f16007h);
        this.f16017r = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextProgressView_tpv_progress, 0.0f);
        this.f16018s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TextProgressView_tpv_radius, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f16012m = paint;
        paint.setTextSize(this.f16002c);
        this.f16016q = new RectF();
        setOnClickListener(new View.OnClickListener() { // from class: z8.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57951a.d(view);
            }
        });
    }

    public final int e(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int paddingTop = (mode == Integer.MIN_VALUE || mode == 0) ? this.f16013n + getPaddingTop() + getPaddingBottom() : mode != 1073741824 ? 0 : size;
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public final void f() {
        Paint.FontMetrics fontMetrics = this.f16012m.getFontMetrics();
        this.f16013n = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
        Paint paint = this.f16012m;
        String str = this.f16010k;
        paint.getTextBounds(str, 0, str.length(), this.f16014o);
        this.f16013n = this.f16014o.height();
        int iMeasureText = (int) this.f16012m.measureText(this.f16010k);
        this.f16015p = iMeasureText;
        if (iMeasureText > x0.g()) {
            String strSubstring = this.f16010k.substring(0, (int) (((x0.g() - this.f16013n) / this.f16015p) * this.f16010k.length()));
            this.f16010k = strSubstring;
            this.f16015p = (int) this.f16012m.measureText(strSubstring);
        }
    }

    public final int g(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredHeight = (mode == Integer.MIN_VALUE || mode == 0) ? this.f16015p + getMeasuredHeight() + getPaddingLeft() + getPaddingRight() : mode != 1073741824 ? 0 : size;
        return mode == Integer.MIN_VALUE ? Math.min(measuredHeight, size) : measuredHeight;
    }

    public float getProgress() {
        return this.f16017r;
    }

    public final void h() {
        f();
        this.f16008i = (getMeasuredWidth() / 2) - (this.f16015p / 2);
        this.f16009j = (getMeasuredHeight() / 2) - (this.f16013n / 2);
    }

    public void i(int i10, float f10) {
        setEnabled(true);
        switch (i10) {
            case 1:
                j();
                break;
            case 2:
                o();
                break;
            case 3:
                l();
                break;
            case 4:
                setStateProgress(f10);
                break;
            case 5:
                k();
                break;
            case 6:
                setStateContinue(f10);
                break;
            case 7:
                m();
                break;
            case 8:
                n();
                break;
        }
    }

    public void j() {
        this.f16000a = 1;
        p(getContext().getString(R.string.download), 1.0f);
    }

    public final void k() {
        this.f16000a = 5;
        p(getContext().getString(R.string.install), 1.0f);
    }

    public void l() {
        this.f16000a = 3;
        p(getContext().getString(R.string.open), 1.0f);
    }

    public final void m() {
        this.f16000a = 7;
        p(getContext().getString(R.string.game_order), 1.0f);
    }

    public final void n() {
        this.f16000a = 8;
        p(getContext().getString(R.string.game_ordered), 1.0f);
        setEnabled(false);
    }

    public void o() {
        this.f16000a = 2;
        p(getContext().getString(R.string.update), 1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16012m.setColor(this.f16005f);
        if (this.f16011l > 0) {
            this.f16012m.setColor(this.f16007h);
            this.f16012m.setStyle(Paint.Style.STROKE);
            this.f16012m.setStrokeWidth(this.f16011l);
        } else {
            this.f16012m.setStyle(Paint.Style.FILL);
        }
        RectF rectF = this.f16016q;
        float f10 = this.f16018s;
        canvas.drawRoundRect(rectF, f10, f10, this.f16012m);
        if (isEnabled()) {
            canvas.save();
            this.f16012m.setStyle(Paint.Style.FILL);
            canvas.clipRect(0.0f, 0.0f, getMeasuredWidth() * this.f16017r, getMeasuredHeight());
            this.f16012m.setColor(this.f16006g);
            RectF rectF2 = this.f16016q;
            float f11 = this.f16018s;
            canvas.drawRoundRect(rectF2, f11, f11, this.f16012m);
            canvas.restore();
        }
        b(canvas, -1, 0, (int) (getMeasuredWidth() * this.f16017r));
        b(canvas, this.f16006g, (int) (getMeasuredWidth() * this.f16017r), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        isInEditMode();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        isInEditMode();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        f();
        setMeasuredDimension(g(i10), e(i11));
        this.f16008i = (getMeasuredWidth() / 2) - (this.f16015p / 2);
        this.f16009j = (getMeasuredHeight() / 2) - (this.f16013n / 2);
        RectF rectF = this.f16016q;
        int i12 = this.f16011l;
        rectF.left = i12;
        rectF.top = i12;
        rectF.right = getMeasuredWidth() - (this.f16011l * 2);
        this.f16016q.bottom = getMeasuredHeight() - (this.f16011l * 2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f16017r = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("state"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putFloat("progress", this.f16017r);
        bundle.putParcelable("state", super.onSaveInstanceState());
        return bundle;
    }

    public void p(String str, float f10) {
        this.f16010k = str;
        h();
        setProgress(f10);
    }

    public void setOnOperateListener(a aVar) {
        this.f16019t = aVar;
    }

    public void setProgress(float f10) {
        this.f16017r = f10;
        postInvalidate();
    }

    public void setStateProgress(float f10) {
        this.f16000a = 4;
        p(String.format(getContext().getString(R.string.game_downloading_percent), String.format(Locale.CHINA, "%.1f", Float.valueOf(100.0f * f10)) + i6.a.f31863g), f10);
    }

    public TextProgressView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextProgressView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16000a = 1;
        int iB = b1.b(1.0f);
        this.f16001b = iB;
        this.f16002c = 12;
        this.f16003d = -16777216;
        this.f16004e = -65536;
        this.f16005f = 268431360;
        this.f16006g = -65536;
        this.f16007h = -65536;
        this.f16010k = "";
        this.f16011l = iB;
        this.f16014o = new Rect();
        c(context, attributeSet);
    }

    @v0(api = 21)
    public TextProgressView(Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f16000a = 1;
        int iB = b1.b(1.0f);
        this.f16001b = iB;
        this.f16002c = 12;
        this.f16003d = -16777216;
        this.f16004e = -65536;
        this.f16005f = 268431360;
        this.f16006g = -65536;
        this.f16007h = -65536;
        this.f16010k = "";
        this.f16011l = iB;
        this.f16014o = new Rect();
        c(context, attributeSet);
    }
}
