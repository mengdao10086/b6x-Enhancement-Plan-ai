package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.e51;
import a.f92;
import a.fg2;
import a.h42;
import a.h51;
import a.i52;
import a.k82;
import a.kl0;
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
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CpuFrequencyView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f4949a;
    public final ArrayList<Integer> b;
    public final ArrayList<Integer> c;

    @x62(c = "com.omarea.ui.fps.CpuFrequencyView$render$1", f = "CpuFrequencyView.kt", l = {265}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8424a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4951a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = CpuFrequencyView.this.new a(b62Var);
            aVar.f8424a = (wd2) obj;
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
                wd2 wd2Var = this.f8424a;
                CpuFrequencyView cpuFrequencyView = CpuFrequencyView.this;
                cpuFrequencyView.f4946a = Bitmap.createBitmap(cpuFrequencyView.getWidth(), CpuFrequencyView.this.getHeight(), Bitmap.Config.ARGB_8888);
                CpuFrequencyView cpuFrequencyView2 = CpuFrequencyView.this;
                Bitmap bitmap = CpuFrequencyView.this.f4946a;
                f92.b(bitmap);
                cpuFrequencyView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                h51 h51Var = new h51(this, null);
                this.f4951a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, h51Var, this) == objC) {
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
    public CpuFrequencyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4945a = new vj0();
        this.f4948a = new Paint();
        this.f4947a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4949a = new kl0().f();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayList2 = this.f4949a;
        f92.c(arrayList2, "clusters");
        for (String[] strArr : arrayList2) {
            if (strArr.length > 1) {
                int length = strArr.length;
                for (int i = 1; i < length; i++) {
                    String str = strArr[i];
                    f92.b(str);
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        }
        m42 m42Var = m42.f6769a;
        this.b = arrayList;
        this.c = new e51().a();
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
        float f3;
        float f4;
        ArrayList arrayListC;
        String str;
        float f5;
        int i;
        py0 py0Var = this.f4944a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<ArrayList<Integer>> arrayListY = py0Var.y(this.f8423a);
        if (arrayListY.size() < 1) {
            return;
        }
        this.f4948a.reset();
        this.f4948a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListY.size() - 1)) / 60.0d;
        Iterator<T> it = arrayListY.iterator();
        int iIntValue = 2100;
        while (it.hasNext()) {
            for (Integer num : (ArrayList) it.next()) {
                if (f92.e(num.intValue(), iIntValue) > 0) {
                    f92.c(num, "value");
                    iIntValue = num.intValue();
                }
            }
        }
        Context context = getContext();
        f92.c(context, "this.context");
        float fD = d(context, 1.0f);
        float f6 = fD * 8.5f;
        this.f4948a.setTextSize(f6);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(iIntValue).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f7 = fD * 4.0f;
        float fMeasureText = this.f4948a.measureText(sb.toString()) + f7;
        float f8 = fD * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f8)) * 1.0d) / size;
        float height = getHeight() - f8;
        this.f4948a.setTextAlign(Paint.Align.CENTER);
        float height2 = (float) ((((double) ((getHeight() - f8) - f7)) * 1.0d) / ((double) iIntValue));
        double d = size / ((double) 5);
        this.f4948a.setStrokeWidth(1.0f);
        this.f4948a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            f = height2;
            float f9 = ((int) (r1 * width)) + fMeasureText;
            int i4 = i3;
            this.f4948a.setColor(Color.parseColor("#888888"));
            canvas.drawText(this.f4945a.c(((double) i3) * d), f9, (getHeight() - f8) + f6 + (r15 * 2), this.f4948a);
            this.f4948a.setColor(Color.parseColor("#40888888"));
            double d2 = d;
            f2 = fMeasureText;
            f3 = f6;
            f4 = fD;
            canvas.drawLine(f9, f7, f9, getHeight() - f8, this.f4948a);
            if (i4 == 5) {
                break;
            }
            i3 = i4 + 1;
            fMeasureText = f2;
            f6 = f3;
            fD = f4;
            height2 = f;
            d = d2;
        }
        this.f4948a.setStrokeWidth(2.0f);
        this.f4948a.setPathEffect(this.f4947a);
        this.f4948a.setTextAlign(Paint.Align.RIGHT);
        if (iIntValue > 4400) {
            arrayListC = y42.c(0, 400, 800, 1200, 1600, 2000, 2400, 2800, 3200, 3600, 4000, 4400, Integer.valueOf(iIntValue));
        } else {
            Integer[] numArr = new Integer[12];
            if (iIntValue > 3300) {
                numArr[0] = 0;
                numArr[1] = 400;
                numArr[2] = 800;
                numArr[3] = 1200;
                numArr[4] = 1600;
                numArr[5] = 2000;
                numArr[6] = 2400;
                numArr[7] = 2800;
                numArr[8] = 3200;
                numArr[9] = 3600;
                numArr[10] = 4000;
                numArr[11] = 4400;
                arrayListC = y42.c(numArr);
            } else {
                numArr[0] = 0;
                numArr[1] = 300;
                numArr[2] = 600;
                numArr[3] = 900;
                numArr[4] = 1200;
                numArr[5] = 1500;
                numArr[6] = 1800;
                numArr[7] = 2100;
                numArr[8] = 2400;
                numArr[9] = 2700;
                numArr[10] = 3000;
                numArr[11] = 3300;
                arrayListC = y42.c(numArr);
            }
        }
        ArrayList arrayList = arrayListC;
        if (iIntValue >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (arrayList.contains(Integer.valueOf(i6)) || (i6 == iIntValue && i6 - i5 > 100)) {
                    this.f4948a.setColor(Color.parseColor("#888888"));
                    if (i6 > 0) {
                        canvas.drawText(String.valueOf(i6), f2 - (3.5f * f4), ((int) ((iIntValue - i6) * f)) + f7 + (f3 / 2.2f), this.f4948a);
                    }
                    this.f4948a.setStrokeWidth(i6 == 0 ? 4.0f : 2.0f);
                    this.f4948a.setColor(i6 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f10 = f7 + ((int) ((iIntValue - i6) * f));
                    f5 = f3;
                    i = i6;
                    canvas.drawLine(f2, f10, getWidth() - f8, f10, this.f4948a);
                    i5 = i;
                } else {
                    f5 = f3;
                    i = i6;
                }
                if (i == iIntValue) {
                    break;
                }
                i6 = i + 1;
                f3 = f5;
            }
        }
        this.f4948a.reset();
        this.f4948a.setColor(getColorAccent());
        this.f4948a.setAntiAlias(true);
        this.f4948a.setStrokeWidth(8.0f);
        this.f4948a.setStyle(Paint.Style.FILL);
        this.f4948a.setPathEffect(null);
        ArrayList arrayList2 = (ArrayList) i52.C(arrayListY);
        int size2 = arrayList2 != null ? arrayList2.size() : 0;
        if (size2 > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (int i7 = 0; i7 < size2; i7++) {
                Path path = new Path();
                f92.b(arrayList2);
                path.moveTo(f2, height - (((Number) arrayList2.get(i7)).floatValue() * f));
                m42 m42Var = m42.f6769a;
                arrayList3.add(path);
            }
            int i8 = 0;
            for (ArrayList<Integer> arrayList4 : arrayListY) {
                float f11 = ((float) (((double) (i8 / 60.0f)) * width)) + f2;
                int i9 = 0;
                while (i9 < size2) {
                    if (!this.b.contains(Integer.valueOf(i9))) {
                        f92.c(arrayList4.size() > i9 ? arrayList4.get(i9) : 0, "if (sample.size > i) {\n …                        }");
                        ((Path) arrayList3.get(i9)).lineTo(f11, height - (r12.intValue() * f));
                    }
                    i9++;
                }
                i8++;
            }
            this.f4948a.setStyle(Paint.Style.STROKE);
            this.f4948a.setStrokeWidth(3.0f);
            ArrayList<Integer> arrayList5 = this.c;
            int i10 = 0;
            for (Object obj : arrayList3) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    y42.l();
                    throw null;
                }
                Path path2 = (Path) obj;
                String strValueOf = String.valueOf(i10);
                ArrayList<String[]> arrayList6 = this.f4949a;
                f92.c(arrayList6, "clusters");
                int i12 = 0;
                int i13 = 0;
                for (Object obj2 : arrayList6) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        y42.l();
                        throw null;
                    }
                    String[] strArr = (String[]) obj2;
                    f92.c(strArr, "cluster");
                    int length2 = strArr.length;
                    int i15 = 0;
                    while (true) {
                        if (i15 >= length2) {
                            str = null;
                            break;
                        }
                        str = strArr[i15];
                        if (f92.a(str, strValueOf)) {
                            break;
                        } else {
                            i15++;
                        }
                    }
                    if (str != null) {
                        i12 = i13;
                    }
                    i13 = i14;
                }
                Paint paint = this.f4948a;
                Integer num2 = arrayList5.get(i12);
                f92.c(num2, "colors.get(colorIndex)");
                paint.setColor(num2.intValue());
                this.f4948a.setStrokeWidth(i12 + 1.0f);
                canvas.drawPath(path2, this.f4948a);
                i10 = i11;
            }
        }
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4944a = new py0(getContext());
    }

    public final void g() {
    }

    public final ArrayList<String[]> getClusters() {
        return this.f4949a;
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final ArrayList<Integer> getColors() {
        return this.c;
    }

    public final ArrayList<Integer> getExcludedCores() {
        return this.b;
    }

    public final long getSessionId() {
        return this.f8423a;
    }

    public final void h() {
        if (this.f8423a >= 1 && getWidth() > 0) {
            qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4946a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4946a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f8423a != j) {
            this.f8423a = j;
            this.f4946a = null;
            invalidate();
        }
    }
}
