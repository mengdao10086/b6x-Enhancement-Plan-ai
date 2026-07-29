package com.yalantis.ucrop.view.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.yalantis.ucrop.model.AspectRatio;
import g.l;
import g.n0;
import h0.d;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class AspectRatioTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f25021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f25022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f25023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f25025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f25026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f25027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f25028n;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    public final void j(@l int i10) {
        Paint paint = this.f25023i;
        if (paint != null) {
            paint.setColor(i10);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i10, d.f(getContext(), com.yalantis.ucrop.R.color.ucrop_color_widget)}));
    }

    public float k(boolean z10) {
        if (z10) {
            n();
            m();
        }
        return this.f25025k;
    }

    public final void l(@n0 TypedArray typedArray) {
        setGravity(1);
        this.f25026l = typedArray.getString(com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.f25027m = typedArray.getFloat(com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f10 = typedArray.getFloat(com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.f25028n = f10;
        float f11 = this.f25027m;
        if (f11 == 0.0f || f10 == 0.0f) {
            this.f25025k = 0.0f;
        } else {
            this.f25025k = f11 / f10;
        }
        this.f25024j = getContext().getResources().getDimensionPixelSize(com.yalantis.ucrop.R.dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.f25023i = paint;
        paint.setStyle(Paint.Style.FILL);
        m();
        j(getResources().getColor(com.yalantis.ucrop.R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    public final void m() {
        if (TextUtils.isEmpty(this.f25026l)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.f25027m), Integer.valueOf((int) this.f25028n)));
        } else {
            setText(this.f25026l);
        }
    }

    public final void n() {
        if (this.f25025k != 0.0f) {
            float f10 = this.f25027m;
            float f11 = this.f25028n;
            this.f25027m = f11;
            this.f25028n = f10;
            this.f25025k = f11 / f10;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f25022h);
            Rect rect = this.f25022h;
            float f10 = (rect.right - rect.left) / 2.0f;
            float f11 = rect.bottom - (rect.top / 2.0f);
            int i10 = this.f25024j;
            canvas.drawCircle(f10, f11 - (i10 * 1.5f), i10 / 2.0f, this.f25023i);
        }
    }

    public void setActiveColor(@l int i10) {
        j(i10);
        invalidate();
    }

    public void setAspectRatio(@n0 AspectRatio aspectRatio) {
        this.f25026l = aspectRatio.a();
        this.f25027m = aspectRatio.b();
        float fE = aspectRatio.e();
        this.f25028n = fE;
        float f10 = this.f25027m;
        if (f10 == 0.0f || fE == 0.0f) {
            this.f25025k = 0.0f;
        } else {
            this.f25025k = f10 / fE;
        }
        m();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f25021g = 1.5f;
        this.f25022h = new Rect();
        l(context.obtainStyledAttributes(attributeSet, com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f25021g = 1.5f;
        this.f25022h = new Rect();
        l(context.obtainStyledAttributes(attributeSet, com.yalantis.ucrop.R.styleable.ucrop_AspectRatioTextView));
    }
}
