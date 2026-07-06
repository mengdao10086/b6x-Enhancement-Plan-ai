package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.k82;
import a.m42;
import a.oc2;
import a.p51;
import a.py0;
import a.q92;
import a.qc2;
import a.qe2;
import a.r62;
import a.u42;
import a.wd2;
import a.x62;
import a.xd2;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class FrameTimeView2 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f8438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f5000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Double f5001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Double> f5002a;

    @x62(c = "com.omarea.ui.fps.FrameTimeView2$render$1", f = "FrameTimeView2.kt", l = {79}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8439a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5004a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = FrameTimeView2.this.new a(b62Var);
            aVar.f8439a = (wd2) obj;
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
                wd2 wd2Var = this.f8439a;
                FrameTimeView2 frameTimeView2 = FrameTimeView2.this;
                frameTimeView2.f8438a = Bitmap.createBitmap(frameTimeView2.getWidth(), FrameTimeView2.this.getHeight(), Bitmap.Config.ARGB_8888);
                FrameTimeView2 frameTimeView22 = FrameTimeView2.this;
                Bitmap bitmap = FrameTimeView2.this.f8438a;
                f92.b(bitmap);
                frameTimeView22.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                p51 p51Var = new p51(this, null);
                this.f5004a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, p51Var, this) == objC) {
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
    public FrameTimeView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f5002a = new ArrayList<>();
        this.f5001a = Double.valueOf(0.0d);
        this.f5000a = new Paint();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Canvas canvas) {
        ArrayList<Double> arrayList = this.f5002a;
        int size = arrayList.size();
        if (arrayList.size() < 1) {
            return;
        }
        this.f5000a.reset();
        this.f5000a.setStrokeWidth(2.0f);
        Integer[] numArr = size >= 127 ? new Integer[]{0, 7, 14, 21, 28} : size >= 100 ? new Integer[]{0, 8, 16, 25, 33} : size >= 70 ? new Integer[]{0, 11, 22, 33, 44} : new Integer[]{0, 8, 16, 25, 33, 41};
        Context context = getContext();
        f92.c(context, "this.context");
        float fD = d(context, 1.0f);
        float f = fD * 8.5f;
        this.f5000a.setTextSize(f);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(50).length();
        for (int i = 0; i < length; i++) {
            sb.append("9");
        }
        float f2 = fD * 4.0f;
        float fMeasureText = this.f5000a.measureText(sb.toString()) + f2;
        float f3 = fD * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f3)) * 1.0d) / ((double) 1000000000);
        float height = (float) ((((double) ((getHeight() - f3) - f2)) * 1.0d) / ((double) 50));
        float height2 = getHeight() - f3;
        this.f5000a.setTextAlign(Paint.Align.CENTER);
        this.f5000a.setStrokeWidth(1.0f);
        this.f5000a.setStyle(Paint.Style.FILL);
        this.f5000a.setColor(Color.parseColor("#55ffffff"));
        int i2 = 10;
        int i3 = 0;
        while (i3 <= i2) {
            float f4 = height;
            float f5 = ((int) (((double) i3) * width * ((double) 100000000))) + fMeasureText;
            canvas.drawText(i3 == 0 ? "0ms" : String.valueOf(i3 * 100), f5, (getHeight() - f3) + f + (r15 * 2), this.f5000a);
            canvas.drawLine(f5, f2, f5, getHeight() - f3, this.f5000a);
            i3++;
            fMeasureText = fMeasureText;
            f = f;
            i2 = 10;
            height = f4;
            width = width;
        }
        double d = width;
        float f6 = height;
        float f7 = fMeasureText;
        float f8 = f;
        this.f5000a.setStrokeWidth(2.0f);
        this.f5000a.setTextAlign(Paint.Align.RIGHT);
        int i4 = 0;
        while (true) {
            if (u42.k(numArr, Integer.valueOf(i4))) {
                if (i4 > 0) {
                    this.f5000a.setColor(Color.parseColor("#ffffff"));
                    canvas.drawText(String.valueOf(i4), f7 - (r15 * 2), f2 + ((int) ((50 - i4) * f6)) + (f8 / 2.2f), this.f5000a);
                }
                this.f5000a.setStrokeWidth(2.0f);
                if (i4 != 0) {
                    this.f5000a.setColor(Color.parseColor("#55ffffff"));
                }
                float f9 = f2 + ((int) ((50 - i4) * f6));
                canvas.drawLine(f7, f9, getWidth() - f3, f9, this.f5000a);
            }
            if (i4 == 50) {
                break;
            } else {
                i4++;
            }
        }
        this.f5000a.reset();
        this.f5000a.setPathEffect(null);
        Path path = new Path();
        path.moveTo(f7, height2);
        path.setFillType(Path.FillType.WINDING);
        this.f5000a.setAntiAlias(true);
        this.f5000a.setColor(Color.parseColor("#8887d3ff"));
        this.f5000a.setStyle(Paint.Style.FILL);
        float f10 = f7;
        for (Double d2 : arrayList) {
            f92.c(d2, "sample");
            float fDoubleValue = (float) (((double) f10) + (d2.doubleValue() * d));
            float fDoubleValue2 = height2 - ((((float) d2.doubleValue()) / 1000000) * f6);
            path.lineTo(f10, height2);
            path.lineTo(f10, fDoubleValue2);
            path.lineTo(fDoubleValue, fDoubleValue2);
            path.lineTo(fDoubleValue, height2);
            f10 = fDoubleValue;
        }
        path.moveTo(f7, height2);
        path.close();
        this.f5000a.setColor(Color.parseColor("#83d81e06"));
        this.f5000a.setStyle(Paint.Style.FILL);
        this.f5000a.setStrokeWidth(0.0f);
        canvas.drawPath(path, this.f5000a);
        this.f5000a.setColor(Color.parseColor("#B3d81e06"));
        this.f5000a.setStyle(Paint.Style.STROKE);
        this.f5000a.setStrokeWidth(2.0f);
        canvas.drawPath(path, this.f5000a);
        this.f5000a.setTextSize(f8);
        this.f5000a.setColor(Color.parseColor("#d81e06"));
        this.f5000a.setTextAlign(Paint.Align.CENTER);
        q92 q92Var = q92.f7191a;
        String str = String.format("FPS: %.1f", Arrays.copyOf(new Object[]{this.f5001a}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        canvas.drawText(str, getWidth() / 2.0f, f8, this.f5000a);
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        new py0(getContext());
    }

    public final void g() {
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final void h() {
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    public final void i(double d, Integer[] numArr) {
        f92.d(numArr, "frameSequence");
        this.f5001a = Double.valueOf(d);
        ArrayList arrayList = new ArrayList(numArr.length);
        for (Integer num : numArr) {
            arrayList.add(Double.valueOf(num.intValue()));
        }
        this.f5002a = new ArrayList<>(arrayList);
        this.f8438a = null;
        h();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f8438a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f8438a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }
}
