package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.k82;
import a.m42;
import a.o51;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
import a.u42;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
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
public final class FrameTimeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vj0 f4994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4997a;

    @x62(c = "com.omarea.ui.fps.FrameTimeView$render$1", f = "FrameTimeView.kt", l = {91}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8437a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4999a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = FrameTimeView.this.new a(b62Var);
            aVar.f8437a = (wd2) obj;
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
                wd2 wd2Var = this.f8437a;
                FrameTimeView frameTimeView = FrameTimeView.this;
                frameTimeView.f4995a = Bitmap.createBitmap(frameTimeView.getWidth(), FrameTimeView.this.getHeight(), Bitmap.Config.ARGB_8888);
                FrameTimeView frameTimeView2 = FrameTimeView.this;
                Bitmap bitmap = FrameTimeView.this.f4995a;
                f92.b(bitmap);
                frameTimeView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                o51 o51Var = new o51(this, null);
                this.f4999a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, o51Var, this) == objC) {
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
    public FrameTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4994a = new vj0();
        this.f4996a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4997a = new Paint();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Canvas canvas) {
        float f;
        ArrayList<Double> arrayList;
        py0 py0Var = this.f4993a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Double> arrayListJ = py0Var.J(this.f8436a);
        if (arrayListJ.isEmpty()) {
            return;
        }
        this.f4997a.reset();
        this.f4997a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListJ.size() - 1)) / 60.0d;
        Integer[] numArr = {0, 8, 16, 25, 33, 41, 50, 58, 66, 75, 83, 91, 100};
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f2 = iD;
        float f3 = f2 * 8.5f;
        this.f4997a.setTextSize(f3);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(100).length();
        for (int i = 0; i < length; i++) {
            sb.append("9");
        }
        float fMeasureText = this.f4997a.measureText(sb.toString());
        float f4 = f2 * 4.0f;
        float f5 = fMeasureText + f4;
        float f6 = 18.0f * f2;
        double width = (((double) ((getWidth() - f5) - f6)) * 1.0d) / size;
        float height = (float) ((((double) ((getHeight() - f6) - f4)) * 1.0d) / ((double) 100));
        float height2 = getHeight() - f6;
        this.f4997a.setTextAlign(Paint.Align.CENTER);
        double d = size / ((double) 5);
        this.f4997a.setStrokeWidth(1.0f);
        this.f4997a.setStyle(Paint.Style.FILL);
        int i2 = 0;
        while (true) {
            float f7 = ((int) (r1 * width)) + f5;
            this.f4997a.setColor(Color.parseColor("#888888"));
            f = iD * 2;
            canvas.drawText(this.f4994a.c(((double) i2) * d), f7, (getHeight() - f6) + f3 + f, this.f4997a);
            this.f4997a.setColor(Color.parseColor("#40888888"));
            int i3 = i2;
            arrayList = arrayListJ;
            canvas.drawLine(f7, f4, f7, getHeight() - f6, this.f4997a);
            if (i3 == 5) {
                break;
            }
            i2 = i3 + 1;
            arrayListJ = arrayList;
        }
        this.f4997a.setStrokeWidth(2.0f);
        this.f4997a.setPathEffect(this.f4996a);
        this.f4997a.setTextAlign(Paint.Align.RIGHT);
        int i4 = 0;
        while (true) {
            this.f4997a.setColor(Color.parseColor("#888888"));
            if (u42.k(numArr, Integer.valueOf(i4))) {
                if (i4 > 0) {
                    canvas.drawText(String.valueOf(i4), f5 - f, f4 + ((int) ((100 - i4) * height)) + (f3 / 2.2f), this.f4997a);
                }
                this.f4997a.setStrokeWidth(i4 == 0 ? 4.0f : 2.0f);
                this.f4997a.setColor(i4 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                float f8 = f4 + ((int) ((100 - i4) * height));
                canvas.drawLine(f5, f8, getWidth() - f6, f8, this.f4997a);
            }
            if (i4 == 100) {
                break;
            } else {
                i4++;
            }
        }
        this.f4997a.reset();
        this.f4997a.setPathEffect(null);
        Path path = new Path();
        path.moveTo(f5, height2);
        this.f4997a.setAntiAlias(true);
        this.f4997a.setColor(Color.parseColor("#87d3ff"));
        this.f4997a.setStyle(Paint.Style.STROKE);
        this.f4997a.setStrokeWidth(2.0f);
        int i5 = 0;
        for (Double d2 : arrayList) {
            float f9 = (i5 > 0 ? (float) (((double) ((i5 - 1) / 60.0f)) * width) : 0.0f) + f5;
            float f10 = ((float) (((double) (i5 / 60.0f)) * width)) + f5;
            float fDoubleValue = height2 - (((float) d2.doubleValue()) * height);
            path.lineTo(f9, height2);
            path.lineTo(f9, fDoubleValue);
            path.lineTo(f10, fDoubleValue);
            path.lineTo(f10, height2);
            i5++;
        }
        path.moveTo(f5, height2);
        canvas.drawPath(path, this.f4997a);
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4993a = new py0(getContext());
    }

    public final void g() {
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8436a;
    }

    public final void h() {
        if (this.f8436a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4995a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4995a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f8436a != j) {
            this.f8436a = j;
            this.f4995a = null;
            invalidate();
        }
    }
}
