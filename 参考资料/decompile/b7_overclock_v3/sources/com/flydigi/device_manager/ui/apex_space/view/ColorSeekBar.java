package com.flydigi.device_manager.ui.apex_space.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.flydigi.device_manager.R;
import g.e;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import nk.d;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorSeekBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f14495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public int[] f14496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public RectF f14499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public Paint f14500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public Paint f14501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public Paint f14502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearGradient f14503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f14506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f14508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14509o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f14510p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f14511q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f14512r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f14513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f14514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @l
    public a f14515u;

    public interface a {
        void a(int i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorSeekBar(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorSeekBar(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ ColorSeekBar(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final int a(int i10, int i11) {
        return Math.abs(Color.red(i10) - Color.red(i11)) + Math.abs(Color.green(i10) - Color.green(i11)) + Math.abs(Color.blue(i10) - Color.blue(i11));
    }

    public final int[] b(@e int i10) {
        int i11 = 0;
        if (isInEditMode()) {
            String[] stringArray = getContext().getResources().getStringArray(i10);
            f0.o(stringArray, "context.resources.getStringArray(id)");
            int[] iArr = new int[stringArray.length];
            int length = stringArray.length;
            while (i11 < length) {
                iArr[i11] = Color.parseColor(stringArray[i11]);
                i11++;
            }
            return iArr;
        }
        TypedArray typedArrayObtainTypedArray = getContext().getResources().obtainTypedArray(i10);
        f0.o(typedArrayObtainTypedArray, "context.resources.obtainTypedArray(id)");
        int[] iArr2 = new int[typedArrayObtainTypedArray.length()];
        int length2 = typedArrayObtainTypedArray.length();
        while (i11 < length2) {
            iArr2[i11] = typedArrayObtainTypedArray.getColor(i11, -16777216);
            i11++;
        }
        typedArrayObtainTypedArray.recycle();
        return iArr2;
    }

    public final int c(int i10, int i11, float f10) {
        return i10 + d.L0(f10 * (i11 - i10));
    }

    public final int d(float f10, int i10) {
        float f11 = this.f14510p;
        float f12 = (f10 - f11) / (i10 - (f11 + this.f14511q));
        if (f12 <= 0.0d) {
            return this.f14496b[0];
        }
        if (f12 >= 1.0f) {
            return this.f14496b[r5.length - 1];
        }
        int[] iArr = this.f14496b;
        float length = f12 * (iArr.length - 1);
        int i11 = (int) length;
        float f13 = length - i11;
        int i12 = iArr[i11];
        int i13 = iArr[i11 + 1];
        return Color.rgb(c(Color.red(i12), Color.red(i13), f13), c(Color.green(i12), Color.green(i13), f13), c(Color.blue(i12), Color.blue(i13), f13));
    }

    public final int getColor() {
        return this.f14502h.getColor();
    }

    @Override // android.view.View
    public void onDraw(@l Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.f14510p;
        float width = getWidth() - this.f14511q;
        int i10 = this.f14497c;
        int i11 = this.f14498d;
        this.f14499e.set(f10, (i10 / 2) - (i11 / 2), width, (i10 / 2) + (i11 / 2));
        if (canvas != null) {
            RectF rectF = this.f14499e;
            float f11 = this.f14512r;
            canvas.drawRoundRect(rectF, f11, f11, this.f14500f);
        }
        float f12 = this.f14504j;
        if (f12 < f10) {
            this.f14504j = f10;
        } else if (f12 > width) {
            this.f14504j = width;
        }
        this.f14502h.setColor(d(this.f14504j, getWidth()));
        if (canvas != null) {
            canvas.drawCircle(this.f14504j, this.f14505k, this.f14508n, this.f14501g);
        }
        if (canvas != null) {
            canvas.drawCircle(this.f14504j, this.f14505k, this.f14507m, this.f14502h);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(i10, this.f14497c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, i10, 0.0f, this.f14496b, (float[]) null, Shader.TileMode.CLAMP);
        this.f14503i = linearGradient;
        this.f14500f.setShader(linearGradient);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@l MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.f14508n = (float) (((double) this.f14514t) * 1.5d);
            this.f14507m = (float) (((double) this.f14513s) * 1.5d);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f14504j = motionEvent.getX();
            invalidate();
            a aVar = this.f14515u;
            if (aVar != null) {
                aVar.a(getColor());
            }
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            this.f14508n = this.f14514t;
            this.f14507m = this.f14513s;
            invalidate();
        }
        return true;
    }

    public final void setColor(int i10) {
        int iL0 = d.L0(this.f14510p);
        int iL02 = d.L0(getWidth() - this.f14511q);
        int i11 = 0;
        if (iL0 <= iL02) {
            int i12 = Integer.MAX_VALUE;
            while (true) {
                int iA = a(d(iL0, getMeasuredWidth()), i10);
                if (i12 > iA) {
                    i11 = iL0;
                    i12 = iA;
                }
                if (iL0 == iL02) {
                    break;
                } else {
                    iL0++;
                }
            }
        }
        float f10 = i11;
        this.f14504j = f10;
        this.f14502h.setColor(d(f10, getMeasuredWidth()));
        invalidate();
    }

    public final void setOnColorChangeListener(@k a onColorChangeListener) {
        f0.p(onColorChangeListener, "onColorChangeListener");
        this.f14515u = onColorChangeListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public ColorSeekBar(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f14495a = 16.0f;
        this.f14496b = new int[]{Color.parseColor("#FF0000"), Color.parseColor("#FF3300"), Color.parseColor("#FF6600"), Color.parseColor("#FF9900"), Color.parseColor("#FFFF00"), Color.parseColor("#99FF00"), Color.parseColor("#00FF00"), Color.parseColor("#00FFFF"), Color.parseColor("#0000FF"), Color.parseColor("#6600FF"), Color.parseColor("#FF00FF"), Color.parseColor("#FF0066"), Color.parseColor("#FF0000")};
        this.f14497c = 60;
        this.f14498d = 20;
        this.f14499e = new RectF();
        this.f14500f = new Paint();
        this.f14501g = new Paint();
        this.f14502h = new Paint();
        this.f14504j = 24.0f;
        this.f14505k = this.f14497c / 2;
        this.f14506l = 4.0f;
        this.f14507m = 16.0f;
        float f10 = 16.0f + 4.0f;
        this.f14508n = f10;
        this.f14509o = -16777216;
        this.f14510p = 40.0f;
        this.f14511q = 40.0f;
        this.f14512r = 8.0f;
        this.f14513s = 16.0f;
        this.f14514t = f10;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSeekBar);
            f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.ColorSeekBar)");
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ColorSeekBar_colorSeeds, 0);
            if (resourceId != 0) {
                this.f14496b = b(resourceId);
            }
            this.f14512r = typedArrayObtainStyledAttributes.getDimension(R.styleable.ColorSeekBar_cornerRadius, 8.0f);
            this.f14498d = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ColorSeekBar_barHeight, 20.0f);
            this.f14506l = typedArrayObtainStyledAttributes.getDimension(R.styleable.ColorSeekBar_thumbBorder, 4.0f);
            this.f14509o = typedArrayObtainStyledAttributes.getColor(R.styleable.ColorSeekBar_thumbBorderColor, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f14500f.setAntiAlias(true);
        this.f14501g.setAntiAlias(true);
        this.f14501g.setColor(this.f14509o);
        this.f14502h.setAntiAlias(true);
        float f11 = this.f14498d * 2;
        this.f14507m = f11;
        float f12 = this.f14506l + f11;
        this.f14508n = f12;
        this.f14497c = (int) (3 * f12);
        this.f14505k = r11 / 2;
        this.f14513s = f11;
        this.f14514t = f12;
    }
}
