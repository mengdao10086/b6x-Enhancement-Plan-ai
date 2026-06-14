package com.omarea.ui.fps;

import a.b62;
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
import a.r51;
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
public final class PowerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f5013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f5015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f5016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f5017a;

    @x62(c = "com.omarea.ui.fps.PowerView$render$1", f = "PowerView.kt", l = {91}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8443a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5019a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = PowerView.this.new a(b62Var);
            aVar.f8443a = (wd2) obj;
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
                wd2 wd2Var = this.f8443a;
                PowerView powerView = PowerView.this;
                powerView.f5015a = Bitmap.createBitmap(powerView.getWidth(), PowerView.this.getHeight(), Bitmap.Config.ARGB_8888);
                PowerView powerView2 = PowerView.this;
                Bitmap bitmap = PowerView.this.f5015a;
                f92.b(bitmap);
                powerView2.f(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                r51 r51Var = new r51(this, null);
                this.f5019a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, r51Var, this) == objC) {
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
    public PowerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f5014a = new vj0();
        this.f5016a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f5017a = new Paint();
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
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.PowerView.e(android.graphics.Canvas, float):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Double, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r4v32, types: [java.lang.Integer] */
    public final void f(Canvas canvas) {
        float f;
        float f2;
        py0 py0Var = this.f5013a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Double> arrayListW = py0Var.W(this.f8442a);
        if (arrayListW.size() < 1) {
            return;
        }
        this.f5017a.reset();
        this.f5017a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListW.size() - 1)) / 60.0d;
        Double dM = i52.M(arrayListW);
        f92.b(dM);
        double dDoubleValue = dM.doubleValue();
        int i = dDoubleValue > ((double) 25) ? 30 : dDoubleValue > ((double) 20) ? 25 : dDoubleValue > ((double) 15) ? 20 : dDoubleValue > ((double) 10) ? 15 : dDoubleValue > ((double) 8) ? 10 : dDoubleValue > ((double) 7) ? 8 : dDoubleValue > ((double) 6) ? 7 : dDoubleValue > ((double) 5) ? 6 : 5;
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f3 = iD;
        float f4 = 8.5f * f3;
        this.f5017a.setTextSize(f4);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(i).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f5 = f3 * 4.0f;
        float fMeasureText = this.f5017a.measureText(sb.toString()) + f5;
        float f6 = f3 * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f6)) * 1.0d) / size;
        float f7 = f4;
        float height = (float) ((((double) ((getHeight() - f6) - f5)) * 1.0d) / ((double) i));
        float height2 = getHeight() - f6;
        this.f5017a.setTextAlign(Paint.Align.CENTER);
        double d = size / ((double) 5);
        this.f5017a.setStrokeWidth(1.0f);
        this.f5017a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            double d2 = ((double) i3) * d;
            float f8 = ((int) (d2 * width)) + fMeasureText;
            int i4 = i3;
            this.f5017a.setColor(Color.parseColor("#888888"));
            f = iD * 2;
            canvas.drawText(this.f5014a.c(d2), f8, (getHeight() - f6) + f7 + f, this.f5017a);
            this.f5017a.setColor(Color.parseColor("#40888888"));
            f2 = f7;
            int i5 = iD;
            canvas.drawLine(f8, f5, f8, getHeight() - f6, this.f5017a);
            if (i4 == 5) {
                break;
            }
            i3 = i4 + 1;
            f7 = f2;
            iD = i5;
        }
        this.f5017a.setStrokeWidth(2.0f);
        this.f5017a.setPathEffect(this.f5016a);
        this.f5017a.setTextAlign(Paint.Align.RIGHT);
        ArrayList arrayListC = i > 20 ? y42.c(0, 5, 10, 15, 20, 25, 30, 35) : i > 15 ? y42.c(0, 3, 6, 9, 12, 15, 18, 21) : i > 10 ? y42.c(0, 2, 4, 6, 8, 10, 12, 14) : i > 8 ? y42.c(0, 2, 4, 6, 8, 10) : i > 7 ? y42.c(0, 1, 2, 3, 4, 5, 6, 7, 8) : y42.c(0, 1, 2, 3, 4, 5, 6, 7);
        if (i >= 0) {
            int i6 = 0;
            while (true) {
                this.f5017a.setColor(Color.parseColor("#888888"));
                if (arrayListC.contains(Integer.valueOf(i6))) {
                    if (i6 > 0) {
                        canvas.drawText(String.valueOf(i6), fMeasureText - f, ((int) ((i - i6) * height)) + f5 + (f2 / 2.2f), this.f5017a);
                    }
                    this.f5017a.setStrokeWidth(i6 == 0 ? 4.0f : 2.0f);
                    this.f5017a.setColor(i6 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f9 = f5 + ((int) ((i - i6) * height));
                    canvas.drawLine(fMeasureText, f9, getWidth() - f6, f9, this.f5017a);
                }
                if (i6 == i) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        this.f5017a.reset();
        this.f5017a.setColor(Color.parseColor("#1474e4"));
        this.f5017a.setAntiAlias(true);
        this.f5017a.setStrokeWidth(8.0f);
        this.f5017a.setStyle(Paint.Style.FILL);
        this.f5017a.setPathEffect(null);
        Double dValueOf = (Double) i52.C(arrayListW);
        if (dValueOf == null || dValueOf.doubleValue() < 0) {
            dValueOf = Double.valueOf(0.0d);
        }
        Path path = new Path();
        path.moveTo(fMeasureText, height2 - ((float) (dValueOf.doubleValue() * ((double) height))));
        int i7 = 0;
        for (Double d3 : arrayListW) {
            if (Double.compare(d3.doubleValue(), 0) < 0) {
                d3 = 0;
            } else {
                f92.c(d3, "sample");
            }
            path.lineTo(((float) (((double) (i7 / 60.0f)) * width)) + fMeasureText, height2 - (d3.floatValue() * height));
            i7++;
        }
        this.f5017a.setStyle(Paint.Style.STROKE);
        this.f5017a.setStrokeWidth(4.0f);
        canvas.drawPath(path, this.f5017a);
        e(canvas, fMeasureText);
    }

    public final void g(AttributeSet attributeSet, int i) {
        h();
        this.f5013a = new py0(getContext());
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8442a;
    }

    public final void h() {
    }

    public final void i() {
        if (this.f8442a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f5015a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f5015a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        i();
    }

    public final void setSessionId(long j) {
        if (this.f8442a != j) {
            this.f8442a = j;
            this.f5015a = null;
            invalidate();
        }
    }
}
