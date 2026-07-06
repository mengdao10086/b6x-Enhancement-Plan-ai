package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.i52;
import a.k82;
import a.m42;
import a.n51;
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
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class FpsJankView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4990a;

    @x62(c = "com.omarea.ui.fps.FpsJankView$render$1", f = "FpsJankView.kt", l = {115}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8435a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4992a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = FpsJankView.this.new a(b62Var);
            aVar.f8435a = (wd2) obj;
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
                wd2 wd2Var = this.f8435a;
                FpsJankView fpsJankView = FpsJankView.this;
                fpsJankView.f4988a = Bitmap.createBitmap(fpsJankView.getWidth(), FpsJankView.this.getHeight(), Bitmap.Config.ARGB_8888);
                FpsJankView fpsJankView2 = FpsJankView.this;
                Bitmap bitmap = FpsJankView.this.f4988a;
                f92.b(bitmap);
                fpsJankView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                n51 n51Var = new n51(this, null);
                this.f4992a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, n51Var, this) == objC) {
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
    public FpsJankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4987a = new vj0();
        this.f4989a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4990a = new Paint();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Canvas canvas) {
        float f;
        float f2;
        ArrayList<Integer> arrayList;
        ArrayList arrayListC;
        String str;
        String str2;
        float f3;
        py0 py0Var = this.f4986a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Integer> arrayListU = py0Var.U(this.f8434a);
        py0 py0Var2 = this.f4986a;
        if (py0Var2 == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Integer> arrayListV = py0Var2.v(this.f8434a);
        if (arrayListU.size() < 1 || arrayListV.size() < 1) {
            return;
        }
        this.f4990a.reset();
        this.f4990a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListU.size() - 1)) / 60.0d;
        Object objL = i52.L(arrayListU);
        f92.b(objL);
        int iIntValue = ((Number) objL).intValue();
        int i = iIntValue > 3 ? iIntValue : 3;
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f4 = iD;
        float f5 = f4 * 8.5f;
        this.f4990a.setTextSize(f5);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(i).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f6 = f4 * 4.0f;
        float fMeasureText = this.f4990a.measureText(sb.toString()) + f6;
        float f7 = f4 * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f7)) * 1.0d) / size;
        float height = (float) ((((double) ((getHeight() - f7) - f6)) * 1.0d) / ((double) i));
        float height2 = getHeight() - f7;
        this.f4990a.setTextAlign(Paint.Align.CENTER);
        double d = size / ((double) 5);
        this.f4990a.setStrokeWidth(1.0f);
        this.f4990a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            f = f5;
            float f8 = ((int) (r1 * width)) + fMeasureText;
            this.f4990a.setColor(Color.parseColor("#888888"));
            f2 = iD * 2;
            canvas.drawText(this.f4987a.c(((double) i3) * d), f8, (getHeight() - f7) + f + f2, this.f4990a);
            this.f4990a.setColor(Color.parseColor("#40888888"));
            int i4 = iD;
            int i5 = i3;
            arrayList = arrayListV;
            canvas.drawLine(f8, f6, f8, getHeight() - f7, this.f4990a);
            if (i5 == 5) {
                break;
            }
            i3 = i5 + 1;
            f5 = f;
            iD = i4;
            arrayListV = arrayList;
        }
        this.f4990a.setStrokeWidth(2.0f);
        this.f4990a.setPathEffect(this.f4989a);
        this.f4990a.setTextAlign(Paint.Align.RIGHT);
        if (i > 5) {
            arrayListC = y42.c(0, 5, 10, 15, 20);
        } else {
            Integer[] numArr = new Integer[4];
            if (i > 3) {
                numArr[0] = 0;
                numArr[1] = 3;
                numArr[2] = 6;
                numArr[3] = 9;
                arrayListC = y42.c(numArr);
            } else {
                numArr[0] = 0;
                numArr[1] = 1;
                numArr[2] = 2;
                numArr[3] = 3;
                arrayListC = y42.c(numArr);
            }
        }
        ArrayList arrayList2 = arrayListC;
        if (i >= 0) {
            int i6 = 0;
            while (true) {
                this.f4990a.setColor(Color.parseColor("#888888"));
                if (arrayList2.contains(Integer.valueOf(i6))) {
                    if (i6 > 0) {
                        canvas.drawText(String.valueOf(i6), fMeasureText - f2, ((int) ((i - i6) * height)) + f6 + (f / 2.2f), this.f4990a);
                    }
                    this.f4990a.setStrokeWidth(i6 == 0 ? 4.0f : 2.0f);
                    this.f4990a.setColor(i6 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f9 = f6 + ((int) ((i - i6) * height));
                    canvas.drawLine(fMeasureText, f9, getWidth() - f7, f9, this.f4990a);
                }
                if (i6 == i) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        this.f4990a.reset();
        this.f4990a.setColor(Color.parseColor("#8087d3ff"));
        this.f4990a.setAntiAlias(true);
        this.f4990a.setStrokeWidth(8.0f);
        this.f4990a.setStyle(Paint.Style.FILL);
        this.f4990a.setPathEffect(null);
        Integer num = (Integer) i52.C(arrayListU);
        if (num == null || num.intValue() < 0) {
            num = 0;
        }
        Path path = new Path();
        path.moveTo(fMeasureText, height2 - (num.intValue() * height));
        this.f4990a.setStyle(Paint.Style.STROKE);
        this.f4990a.setStrokeWidth(2.0f);
        Iterator<Integer> it = arrayListU.iterator();
        int i7 = 0;
        while (true) {
            str = "if (sample < 0) 0 else sample";
            if (!it.hasNext()) {
                break;
            }
            Integer next = it.next();
            if (f92.e(next.intValue(), 0) < 0) {
                next = 0;
            }
            f92.c(next, "if (sample < 0) 0 else sample");
            int iIntValue2 = next.intValue();
            float f10 = (i7 > 0 ? (float) (((double) ((i7 - 1) / 60.0f)) * width) : 0.0f) + fMeasureText;
            float f11 = ((float) (((double) (i7 / 60.0f)) * width)) + fMeasureText;
            float f12 = height2 - (iIntValue2 * height);
            path.lineTo(f10, height2);
            path.lineTo(f10, f12);
            path.lineTo(f11, f12);
            path.lineTo(f11, height2);
            i7++;
        }
        canvas.drawPath(path, this.f4990a);
        path.reset();
        this.f4990a.setColor(Color.parseColor("#FDB6E2"));
        this.f4990a.setStyle(Paint.Style.STROKE);
        this.f4990a.setStrokeWidth(2.0f);
        path.moveTo(fMeasureText, height2 - (num.intValue() * height));
        int i8 = 0;
        for (Integer num2 : arrayList) {
            if (f92.e(num2.intValue(), 0) < 0) {
                num2 = 0;
            }
            f92.c(num2, str);
            int iIntValue3 = num2.intValue();
            if (i8 > 0) {
                str2 = str;
                f3 = (float) (((double) ((i8 - 1) / 60.0f)) * width);
            } else {
                str2 = str;
                f3 = 0.0f;
            }
            float f13 = f3 + fMeasureText;
            float f14 = ((float) (((double) (i8 / 60.0f)) * width)) + fMeasureText;
            float f15 = height2 - (iIntValue3 * height);
            path.lineTo(f13, height2);
            path.lineTo(f13, f15);
            path.lineTo(f14, f15);
            path.lineTo(f14, height2);
            i8++;
            str = str2;
        }
        canvas.drawPath(path, this.f4990a);
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4986a = new py0(getContext());
    }

    public final void g() {
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8434a;
    }

    public final void h() {
        if (this.f8434a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4988a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4988a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (j >= 1 && this.f8434a != j) {
            this.f8434a = j;
            this.f4988a = null;
        }
    }
}
