package com.omarea.ui.power;

import a.a42;
import a.b62;
import a.d72;
import a.f92;
import a.g82;
import a.g92;
import a.h42;
import a.k82;
import a.k92;
import a.m42;
import a.qc2;
import a.qe2;
import a.r62;
import a.ru0;
import a.u42;
import a.vj0;
import a.w21;
import a.wd2;
import a.x62;
import a.xd2;
import a.z32;
import a.z51;
import a.zy0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class PowerStatView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ru0 f5031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zy0 f5034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f5035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f5036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f5037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f5038a;
    public final Paint b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5039b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f5040b;
    public boolean c;

    @x62(c = "com.omarea.ui.power.PowerStatView$onDraw$1", f = "PowerStatView.kt", l = {}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8447a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = PowerStatView.this.new a(b62Var);
            aVar.f8447a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            PowerStatView.this.g();
            return m42.f6769a;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PowerStatView.this.invalidate();
        }
    }

    @x62(c = "com.omarea.ui.power.PowerStatView$update$3", f = "PowerStatView.kt", l = {}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8449a;
        public int b;

        public c(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = PowerStatView.this.new c(b62Var);
            cVar.f8449a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            if (PowerStatView.this.isAttachedToWindow()) {
                try {
                    PowerStatView.this.invalidate();
                } catch (Exception unused) {
                }
            }
            return m42.f6769a;
        }
    }

    public static final class d extends g92 implements g82<Float, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f8450a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k92 f5043a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Canvas f5044a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Path f5045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Canvas canvas, k92 k92Var, float f, Path path) {
            super(1);
            this.f5044a = canvas;
            this.f5043a = k92Var;
            this.f8450a = f;
            this.f5045a = path;
        }

        public final void a(float f) {
            this.f5044a.save();
            this.f5044a.clipRect(this.f5043a.f6587a, this.f8450a, f + 2.0f, PowerStatView.this.getHeight() - this.f8450a);
            this.f5044a.drawPath(this.f5045a, PowerStatView.this.f5037a);
            this.f5044a.restore();
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(Float f) {
            a(f.floatValue());
            return m42.f6769a;
        }
    }

    public static final class e extends g92 implements g82<Long, Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f8451a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ float f5047a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5048a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Long l, double d, float f) {
            super(1);
            this.f5048a = l;
            this.f8451a = d;
            this.f5047a = f;
        }

        public final float a(long j) {
            return ((float) (((double) ((j - this.f5048a.longValue()) / 60000.0f)) * this.f8451a)) + this.f5047a;
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ Float f(Long l) {
            return Float.valueOf(a(l.longValue()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerStatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f5034a = zy0.e();
        this.f5032a = new vj0();
        this.f5039b = true;
        this.f5037a = new Paint();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-3355444);
        paint.setAlpha(128);
        m42 m42Var = m42.f6769a;
        this.b = paint;
        this.f5036a = new DashPathEffect(new float[]{4.0f, 4.0f}, 2.0f);
        this.f5038a = new int[]{10, 15, 30, 45, 60, 90, 120, 150, 180, 240, 300, 360, 420, 480, 540, 600, 660, 720, 960, 1200, 1440};
        this.f5040b = new int[]{10, 6, 12, 9, 12, 9, 12, 10, 12, 12, 10, 12, 7, 8, 9, 10, 11, 12, 8, 12, 12};
        this.f5033a = a42.a(new z51(this));
        this.f5031a = new ru0(Scene.f4798a.c(), true, 0, 4, null);
        this.c = true;
        e(attributeSet, 0);
    }

    private final w21 getChartStyles() {
        return (w21) this.f5033a.getValue();
    }

    public final int b(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void c(Canvas canvas, Bitmap bitmap, float f, float f2) {
        RectF rectF = new RectF(f, f2, bitmap.getWidth() + f, bitmap.getHeight() + f2);
        canvas.drawBitmap(bitmap, f, f2, this.b);
        canvas.drawRoundRect(rectF, 8.0f, 8.0f, this.b);
    }

    public final int d(double d2) {
        int iY = u42.y(this.f5038a);
        if (d2 > iY) {
            do {
                iY += 720;
            } while (iY < d2);
            return iY;
        }
        for (int i : this.f5038a) {
            if (d2 <= i) {
                return i;
            }
        }
        return (int) d2;
    }

    public final void e(AttributeSet attributeSet, int i) {
        f();
    }

    public final void f() {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0451 A[LOOP:4: B:100:0x03fd->B:113:0x0451, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0354  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 1285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.power.PowerStatView.g():void");
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final boolean getLadder() {
        return this.f5039b;
    }

    public final int getSessionId() {
        return this.f8446a;
    }

    public final boolean getShowIcons() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "originCanvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f5035a;
        if (bitmap == null) {
            qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
            return;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        this.f5035a = null;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.f5035a = null;
            invalidate();
        }
    }

    public final void setLadder(boolean z) {
        if (this.f5039b != z) {
            this.f5039b = z;
            this.f5035a = null;
            invalidate();
        }
    }

    public final void setSessionId(int i) {
        if (this.f8446a != i) {
            this.f8446a = i;
            this.f5035a = null;
            post(new b());
        }
    }

    public final void setShowIcons(boolean z) {
        this.c = z;
    }
}
