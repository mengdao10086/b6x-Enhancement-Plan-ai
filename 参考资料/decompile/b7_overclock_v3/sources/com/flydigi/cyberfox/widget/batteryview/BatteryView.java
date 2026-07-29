package com.flydigi.cyberfox.widget.batteryview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class BatteryView extends View implements x {
    public Lifecycle A;
    public t6.a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BatteryViewOrientation f14288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f14292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f14293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f14300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14304q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f14305r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Runnable f14306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f14307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Paint f14308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint f14309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f14310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RectF f14311x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f14312y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14313z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BatteryView.j(BatteryView.this, 100);
            BatteryView batteryView = BatteryView.this;
            batteryView.setPower(batteryView.f14313z);
            BatteryView batteryView2 = BatteryView.this;
            BatteryView.i(batteryView2, batteryView2.f14302o);
            BatteryView.this.f14305r.postDelayed(this, 200L);
        }
    }

    public BatteryView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int i(BatteryView batteryView, int i10) {
        int i11 = batteryView.f14313z + i10;
        batteryView.f14313z = i11;
        return i11;
    }

    public static /* synthetic */ int j(BatteryView batteryView, int i10) {
        int i11 = batteryView.f14313z % i10;
        batteryView.f14313z = i11;
        return i11;
    }

    public final void m(Canvas canvas) {
        if (this.f14310w == null) {
            float f10 = this.f14293f + this.f14289b;
            float f11 = this.f14290c;
            this.f14310w = new RectF(f10 + f11, f11, this.f14303p - f11, this.f14304q - f11);
        }
        RectF rectF = this.f14310w;
        float f12 = this.f14292e;
        canvas.drawRoundRect(rectF, f12, f12, this.f14307t);
        if (this.f14311x == null) {
            setPower(60);
        }
        RectF rectF2 = this.f14311x;
        float f13 = this.f14292e;
        canvas.drawRoundRect(rectF2, f13, f13, this.f14308u);
        if (this.f14312y == null) {
            float f14 = this.f14304q / 3.0f;
            this.f14312y = new RectF(0.0f, f14, this.f14293f, 2.0f * f14);
        }
        RectF rectF3 = this.f14312y;
        float f15 = this.f14292e;
        canvas.drawRoundRect(rectF3, f15, f15, this.f14309v);
    }

    public final void n(Canvas canvas) {
        if (this.f14310w == null) {
            float f10 = this.f14290c;
            this.f14310w = new RectF(f10, f10, ((this.f14303p - f10) - this.f14289b) - this.f14293f, this.f14304q - f10);
        }
        RectF rectF = this.f14310w;
        float f11 = this.f14292e;
        canvas.drawRoundRect(rectF, f11, f11, this.f14307t);
        if (this.f14311x == null) {
            setPower(60);
        }
        RectF rectF2 = this.f14311x;
        float f12 = this.f14292e;
        canvas.drawRoundRect(rectF2, f12, f12, this.f14308u);
        if (this.f14312y == null) {
            float f13 = this.f14304q / 3.0f;
            int i10 = this.f14303p;
            this.f14312y = new RectF(i10 - this.f14293f, f13, i10, 2.0f * f13);
        }
        RectF rectF3 = this.f14312y;
        float f14 = this.f14292e;
        canvas.drawRoundRect(rectF3, f14, f14, this.f14309v);
    }

    public final void o(Canvas canvas) {
        if (this.f14310w == null) {
            float f10 = this.f14290c;
            this.f14310w = new RectF(f10, f10, this.f14303p - f10, ((this.f14304q - this.f14293f) - this.f14289b) - f10);
        }
        RectF rectF = this.f14310w;
        float f11 = this.f14292e;
        canvas.drawRoundRect(rectF, f11, f11, this.f14307t);
        if (this.f14311x == null) {
            setPower(60);
        }
        RectF rectF2 = this.f14311x;
        float f12 = this.f14292e;
        canvas.drawRoundRect(rectF2, f12, f12, this.f14308u);
        if (this.f14312y == null) {
            float f13 = this.f14303p / 3.0f;
            int i10 = this.f14304q;
            this.f14312y = new RectF(f13, i10 - this.f14293f, 2.0f * f13, i10);
        }
        RectF rectF3 = this.f14312y;
        float f14 = this.f14292e;
        canvas.drawRoundRect(rectF3, f14, f14, this.f14309v);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        BatteryViewOrientation batteryViewOrientation = this.f14288a;
        if (batteryViewOrientation == BatteryViewOrientation.HORIZONTAL_LEFT) {
            m(canvas);
            return;
        }
        if (batteryViewOrientation == BatteryViewOrientation.HORIZONTAL_RIGHT) {
            n(canvas);
        } else if (batteryViewOrientation == BatteryViewOrientation.VERTICAL_TOP) {
            p(canvas);
        } else if (batteryViewOrientation == BatteryViewOrientation.VERTICAL_BOTTOM) {
            o(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f14303p = getMeasuredWidth();
        this.f14304q = getMeasuredHeight();
    }

    public final void p(Canvas canvas) {
        if (this.f14310w == null) {
            float f10 = this.f14290c;
            this.f14310w = new RectF(f10, this.f14293f + this.f14289b + f10, this.f14303p - f10, this.f14304q - f10);
        }
        RectF rectF = this.f14310w;
        float f11 = this.f14292e;
        canvas.drawRoundRect(rectF, f11, f11, this.f14307t);
        if (this.f14311x == null) {
            setPower(60);
        }
        RectF rectF2 = this.f14311x;
        float f12 = this.f14292e;
        canvas.drawRoundRect(rectF2, f12, f12, this.f14308u);
        if (this.f14312y == null) {
            float f13 = this.f14303p / 3.0f;
            this.f14312y = new RectF(f13, 0.0f, 2.0f * f13, this.f14293f);
        }
        RectF rectF3 = this.f14312y;
        float f14 = this.f14292e;
        canvas.drawRoundRect(rectF3, f14, f14, this.f14309v);
    }

    public final void q(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BatteryView);
        int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.BatteryView_bv_orientation, 1);
        if (i10 == 0) {
            this.f14288a = BatteryViewOrientation.HORIZONTAL_LEFT;
        } else if (i10 == 1) {
            this.f14288a = BatteryViewOrientation.HORIZONTAL_RIGHT;
        } else if (i10 == 2) {
            this.f14288a = BatteryViewOrientation.VERTICAL_TOP;
        } else if (i10 == 3) {
            this.f14288a = BatteryViewOrientation.VERTICAL_BOTTOM;
        }
        this.f14289b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BatteryView_bv_border_padding, 2);
        this.f14290c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BatteryView_bv_border_width, 2);
        this.f14293f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BatteryView_bv_header_width, 10);
        this.f14292e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BatteryView_bv_radis, 2);
        this.f14291d = typedArrayObtainStyledAttributes.getColor(R.styleable.BatteryView_bv_border_color, -1);
        int i11 = R.styleable.BatteryView_bv_power_color_low;
        Resources resources = getContext().getResources();
        int i12 = R.color.black;
        this.f14294g = typedArrayObtainStyledAttributes.getColor(i11, resources.getColor(i12));
        this.f14295h = typedArrayObtainStyledAttributes.getInt(R.styleable.BatteryView_bv_power_value_low, 10);
        this.f14296i = typedArrayObtainStyledAttributes.getColor(R.styleable.BatteryView_bv_power_color_medium, getContext().getResources().getColor(i12));
        this.f14297j = typedArrayObtainStyledAttributes.getInt(R.styleable.BatteryView_bv_power_value_medium, 20);
        this.f14298k = typedArrayObtainStyledAttributes.getColor(R.styleable.BatteryView_bv_power_color_high, getContext().getResources().getColor(i12));
        this.f14299l = typedArrayObtainStyledAttributes.getColor(R.styleable.BatteryView_bv_header_color, -1);
        this.f14301n = typedArrayObtainStyledAttributes.getColor(R.styleable.BatteryView_bv_no_charging_color_high, getContext().getResources().getColor(i12));
        int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.BatteryView_bv_charging_speed, 2) % 10;
        this.f14302o = i13;
        if (i13 == 0) {
            this.f14302o = 1;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final float r(int i10) {
        float f10 = this.f14303p - (this.f14290c * 2.0f);
        float f11 = this.f14289b;
        return ((((f10 - (2.0f * f11)) - f11) - this.f14293f) * i10) / 100.0f;
    }

    public final float s(int i10) {
        return ((((this.f14304q - (this.f14290c * 2.0f)) - (this.f14289b * 3.0f)) - this.f14293f) * i10) / 100.0f;
    }

    public void setChargingSpeed(int i10) {
        this.f14302o = i10;
    }

    public void setLifecycleOwner(@n0 y yVar) {
        Lifecycle lifecycle = this.A;
        if (lifecycle != null) {
            lifecycle.d(this);
        }
        Lifecycle lifecycleE = yVar.e();
        this.A = lifecycleE;
        lifecycleE.a(this);
    }

    public void setOnBatteryPowerListener(t6.a aVar) {
        this.B = aVar;
    }

    public void setPower(int i10) {
        t6.a aVar = this.B;
        if (aVar != null) {
            aVar.a(60);
        }
        if (i10 <= this.f14295h) {
            this.f14308u.setColor(this.f14294g);
        } else if (i10 < this.f14297j) {
            this.f14308u.setColor(this.f14296i);
        } else if (this.f14306s == null) {
            this.f14308u.setColor(this.f14301n);
        } else {
            this.f14308u.setColor(this.f14298k);
        }
        BatteryViewOrientation batteryViewOrientation = this.f14288a;
        if (batteryViewOrientation == BatteryViewOrientation.HORIZONTAL_RIGHT) {
            float fR = r(i10);
            float f10 = this.f14290c;
            float f11 = this.f14289b;
            this.f14311x = new RectF(f10 + f11, f10 + f11, f10 + f11 + fR, (this.f14304q - f10) - f11);
            postInvalidate();
            return;
        }
        if (batteryViewOrientation == BatteryViewOrientation.HORIZONTAL_LEFT) {
            float fR2 = r(i10);
            int i11 = this.f14303p;
            float f12 = this.f14290c;
            float f13 = this.f14289b;
            this.f14311x = new RectF(((i11 - f12) - f13) - fR2, f12 + f13, (i11 - f12) - f13, (this.f14304q - f12) - f13);
            postInvalidate();
            return;
        }
        if (batteryViewOrientation == BatteryViewOrientation.VERTICAL_TOP) {
            float fS = s(i10);
            float f14 = this.f14290c;
            float f15 = this.f14289b;
            int i12 = this.f14304q;
            this.f14311x = new RectF(f14 + f15, ((i12 - f14) - f15) - fS, (this.f14303p - f14) - f15, (i12 - f14) - f15);
            postInvalidate();
            return;
        }
        if (batteryViewOrientation == BatteryViewOrientation.VERTICAL_BOTTOM) {
            float fS2 = s(i10);
            float f16 = this.f14290c;
            float f17 = this.f14289b;
            this.f14311x = new RectF(f16 + f17, f16 + f17, (this.f14303p - f16) - f17, f16 + f17 + fS2);
            postInvalidate();
        }
    }

    public final void t() {
        Paint paint = new Paint();
        this.f14307t = paint;
        paint.setAntiAlias(true);
        this.f14307t.setStyle(Paint.Style.STROKE);
        this.f14307t.setColor(this.f14291d);
        this.f14307t.setStrokeWidth(this.f14290c);
        Paint paint2 = new Paint();
        this.f14308u = paint2;
        paint2.setAntiAlias(true);
        this.f14308u.setStyle(Paint.Style.FILL);
        this.f14308u.setColor(this.f14298k);
        this.f14308u.setStrokeWidth(0.0f);
        Paint paint3 = new Paint();
        this.f14309v = paint3;
        paint3.setAntiAlias(true);
        this.f14309v.setStyle(Paint.Style.FILL);
        this.f14309v.setColor(this.f14299l);
        this.f14309v.setStrokeWidth(0.0f);
    }

    public void u() {
        this.B = null;
    }

    public final void v() {
        if (this.f14306s != null) {
            return;
        }
        this.f14313z = 60;
        a aVar = new a();
        this.f14306s = aVar;
        this.f14305r.post(aVar);
    }

    public final void w() {
        Runnable runnable = this.f14306s;
        if (runnable != null) {
            this.f14305r.removeCallbacks(runnable);
            this.f14306s = null;
        }
    }

    public BatteryView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f14300m = 60;
        this.f14305r = new Handler();
        q(context, attributeSet);
        t();
    }
}
