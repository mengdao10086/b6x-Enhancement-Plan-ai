package com.omarea.ui.fps;

import a.b62;
import a.d51;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.i52;
import a.k82;
import a.m42;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
import a.y42;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BatteryIOView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4923a;

    @x62(c = "com.omarea.ui.fps.BatteryIOView$render$1", f = "BatteryIOView.kt", l = {93}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8417a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4925a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = BatteryIOView.this.new a(b62Var);
            aVar.f8417a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8417a;
                BatteryIOView batteryIOView = BatteryIOView.this;
                batteryIOView.f4921a = Bitmap.createBitmap(batteryIOView.getWidth(), BatteryIOView.this.getHeight(), Bitmap.Config.ARGB_8888);
                BatteryIOView batteryIOView2 = BatteryIOView.this;
                Bitmap bitmap = BatteryIOView.this.f4921a;
                f92.b(bitmap);
                batteryIOView2.f(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                d51 d51Var = new d51(this, null);
                this.f4925a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, d51Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryIOView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4920a = new vj0();
        this.f4922a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4923a = new Paint();
        g(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0141 A[LOOP:0: B:8:0x00c3->B:23:0x0141, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014e A[EDGE_INSN: B:31:0x014e->B:24:0x014e BREAK  A[LOOP:0: B:8:0x00c3->B:23:0x0141], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r29, float r30) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.BatteryIOView.e(android.graphics.Canvas, float):void");
    }

    public final void f(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        ArrayList arrayListC;
        int i;
        py0 py0Var = this.f4919a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Long> arrayListT = py0Var.t(this.f8416a);
        if (arrayListT.size() < 1) {
            return;
        }
        this.f4923a.reset();
        this.f4923a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListT.size() - 1)) / 60.0d;
        Object objL = i52.L(arrayListT);
        f92.b(objL);
        long jLongValue = ((Number) objL).longValue();
        int i2 = jLongValue > ((long) 4000) ? 5000 : jLongValue > ((long) 3000) ? 4000 : jLongValue > ((long) 2500) ? 3000 : jLongValue > ((long) 2000) ? 2500 : jLongValue > ((long) 1500) ? 2000 : jLongValue > ((long) 1000) ? 1500 : 1000;
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f5 = iD;
        float f6 = f5 * 8.5f;
        this.f4923a.setTextSize(f6);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(i2).length();
        for (int i3 = 0; i3 < length; i3++) {
            sb.append("9");
        }
        float f7 = f5 * 4.0f;
        float fMeasureText = this.f4923a.measureText(sb.toString()) + f7;
        float f8 = f5 * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f8)) * 1.0d) / size;
        float height = (float) ((((double) ((getHeight() - f8) - f7)) * 1.0d) / ((double) i2));
        float height2 = getHeight() - f8;
        this.f4923a.setTextAlign(Paint.Align.CENTER);
        double d = size / ((double) 5);
        this.f4923a.setStrokeWidth(1.0f);
        this.f4923a.setStyle(Paint.Style.FILL);
        int i4 = 0;
        while (true) {
            f = height;
            float f9 = ((int) (r1 * width)) + fMeasureText;
            this.f4923a.setColor(Color.parseColor("#888888"));
            f2 = iD * 2;
            canvas.drawText(this.f4920a.c(((double) i4) * d), f9, (getHeight() - f8) + f6 + f2, this.f4923a);
            this.f4923a.setColor(Color.parseColor("#40888888"));
            double d2 = d;
            int i5 = i4;
            int i6 = iD;
            f3 = f6;
            f4 = fMeasureText;
            canvas.drawLine(f9, f7, f9, getHeight() - f8, this.f4923a);
            if (i5 == 5) {
                break;
            }
            i4 = i5 + 1;
            f6 = f3;
            fMeasureText = f4;
            height = f;
            iD = i6;
            d = d2;
        }
        float f10 = 2.0f;
        this.f4923a.setStrokeWidth(2.0f);
        this.f4923a.setPathEffect(this.f4922a);
        this.f4923a.setTextAlign(Paint.Align.RIGHT);
        if (i2 > 4000) {
            arrayListC = y42.c(0, 1000, 2000, 3000, 4000, Integer.valueOf(i2));
        } else if (i2 > 3000) {
            arrayListC = y42.c(0, 500, 1000, 1500, 2000, 2500, 3000, 3500, Integer.valueOf(i2));
        } else if (i2 > 2500) {
            arrayListC = y42.c(0, 500, 1000, 1500, 2000, 2500, Integer.valueOf(i2));
        } else if (i2 > 2000) {
            arrayListC = y42.c(0, 400, 800, 1200, 1600, 2000, Integer.valueOf(i2));
        } else if (i2 > 1500) {
            arrayListC = y42.c(0, 400, 800, 1200, 1600, 2000);
        } else {
            Integer[] numArr = new Integer[6];
            if (i2 > 1000) {
                numArr[0] = 0;
                numArr[1] = 300;
                numArr[2] = 600;
                numArr[3] = 900;
                numArr[4] = 1200;
                numArr[5] = 1500;
                arrayListC = y42.c(numArr);
            } else {
                numArr[0] = 0;
                numArr[1] = 200;
                numArr[2] = 400;
                numArr[3] = 600;
                numArr[4] = 800;
                numArr[5] = 1000;
                arrayListC = y42.c(numArr);
            }
        }
        ArrayList arrayList = arrayListC;
        if (i2 >= 0) {
            int i7 = 0;
            while (true) {
                this.f4923a.setColor(Color.parseColor("#888888"));
                if (arrayList.contains(Integer.valueOf(i7))) {
                    if (i7 > 0) {
                        canvas.drawText(String.valueOf(i7), f4 - f2, ((int) ((i2 - i7) * f)) + f7 + (f3 / 2.2f), this.f4923a);
                    }
                    this.f4923a.setStrokeWidth(i7 == 0 ? 4.0f : f10);
                    this.f4923a.setColor(i7 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f11 = f7 + ((int) ((i2 - i7) * f));
                    i = i7;
                    canvas.drawLine(f4, f11, getWidth() - f8, f11, this.f4923a);
                } else {
                    i = i7;
                }
                if (i == i2) {
                    break;
                }
                i7 = i + 1;
                f10 = 2.0f;
            }
        }
        this.f4923a.reset();
        this.f4923a.setColor(Color.parseColor("#1474e4"));
        this.f4923a.setAntiAlias(true);
        this.f4923a.setStrokeWidth(8.0f);
        this.f4923a.setStyle(Paint.Style.FILL);
        this.f4923a.setPathEffect(null);
        Long l = (Long) i52.C(arrayListT);
        if (l == null || l.longValue() < 0) {
            l = 0L;
        }
        Path path = new Path();
        path.moveTo(f4, height2 - (l.longValue() * f));
        int i8 = 0;
        for (Long l2 : arrayListT) {
            if (l2.longValue() < 0) {
                l2 = 0L;
            }
            f92.c(l2, "if (sample < 0) 0 else sample");
            path.lineTo(((float) (((double) (i8 / 60.0f)) * width)) + f4, height2 - (l2.longValue() * f));
            i8++;
        }
        this.f4923a.setStyle(Paint.Style.STROKE);
        this.f4923a.setStrokeWidth(4.0f);
        canvas.drawPath(path, this.f4923a);
        e(canvas, f4);
    }

    public final void g(AttributeSet attributeSet, int i) {
        h();
        this.f4919a = new py0(getContext());
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8416a;
    }

    public final void h() {
    }

    public final void i() {
        if (this.f8416a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4921a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4921a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        i();
    }

    public final void setSessionId(long j) {
        if (this.f8416a != j) {
            this.f8416a = j;
            this.f4921a = null;
            invalidate();
        }
    }
}
