package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.e51;
import a.f92;
import a.fg2;
import a.g51;
import a.h42;
import a.i52;
import a.k82;
import a.kl0;
import a.m42;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
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
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CpuFrequencyStat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f4936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f4941a;
    public final ArrayList<Integer> b;
    public final ArrayList<Integer> c;

    @x62(c = "com.omarea.ui.fps.CpuFrequencyStat$render$1", f = "CpuFrequencyStat.kt", l = {260}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8422a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4943a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = CpuFrequencyStat.this.new a(b62Var);
            aVar.f8422a = (wd2) obj;
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
                wd2 wd2Var = this.f8422a;
                CpuFrequencyStat cpuFrequencyStat = CpuFrequencyStat.this;
                cpuFrequencyStat.f4938a = Bitmap.createBitmap(cpuFrequencyStat.getWidth(), CpuFrequencyStat.this.getHeight(), Bitmap.Config.ARGB_8888);
                CpuFrequencyStat cpuFrequencyStat2 = CpuFrequencyStat.this;
                Bitmap bitmap = CpuFrequencyStat.this.f4938a;
                f92.b(bitmap);
                cpuFrequencyStat2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                g51 g51Var = new g51(this, null);
                this.f4943a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, g51Var, this) == objC) {
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
    public CpuFrequencyStat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4940a = new Paint();
        this.f4939a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        kl0 kl0Var = new kl0();
        this.f4936a = kl0Var;
        this.f4941a = kl0Var.f();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayList2 = this.f4941a;
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
        ArrayList arrayListC;
        float f;
        float f2;
        int i;
        float f3;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        py0 py0Var = this.f4937a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<ArrayList<Integer>> arrayListY = py0Var.y(this.f8421a);
        if (arrayListY.size() < 1) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) i52.C(arrayListY);
        int size = arrayList2 != null ? arrayList2.size() : 0;
        ArrayList arrayList3 = new ArrayList();
        ArrayList<String[]> arrayListF = new kl0().f();
        f92.c(arrayListF, "CPUUtils().clusterInfo");
        int i5 = 0;
        for (Object obj : arrayListF) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                y42.l();
                throw null;
            }
            HashMap map = new HashMap();
            String str = ((String[]) obj)[0];
            f92.c(str, "cluster[0]");
            int i7 = Integer.parseInt(str);
            Iterator<T> it = arrayListY.iterator();
            while (it.hasNext()) {
                Object obj2 = ((ArrayList) it.next()).get(i7);
                f92.c(obj2, "it[cpu]");
                int iIntValue = ((Number) obj2).intValue();
                Integer numValueOf = Integer.valueOf(iIntValue);
                Integer num = (Integer) map.get(Integer.valueOf(iIntValue));
                if (num == null) {
                    num = 0;
                }
                map.put(numValueOf, Integer.valueOf(num.intValue() + 1));
            }
            arrayList3.add(i5, map);
            i5 = i6;
        }
        this.f4940a.reset();
        this.f4940a.setStrokeWidth(2.0f);
        arrayListY.size();
        Iterator<T> it2 = arrayListY.iterator();
        int iIntValue2 = 2100;
        while (it2.hasNext()) {
            for (Integer num2 : (ArrayList) it2.next()) {
                if (f92.e(num2.intValue(), iIntValue2) > 0) {
                    f92.c(num2, "value");
                    iIntValue2 = num2.intValue();
                }
            }
        }
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f4 = iD;
        float f5 = f4 * 8.5f;
        this.f4940a.setTextSize(f5);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(iIntValue2).length();
        for (int i8 = 0; i8 < length; i8++) {
            sb.append("9");
        }
        float f6 = f4 * 4.0f;
        float fMeasureText = this.f4940a.measureText(sb.toString()) + f6;
        float f7 = f4 * 18.0f;
        getWidth();
        float height = (float) ((((double) ((getHeight() - f7) - f6)) * 1.0d) / ((double) 100));
        float f8 = f5;
        double width = (((double) ((getWidth() - fMeasureText) - f7)) * 1.0d) / ((double) iIntValue2);
        getHeight();
        this.f4940a.setStyle(Paint.Style.FILL);
        this.f4940a.setStrokeWidth(2.0f);
        this.f4940a.setPathEffect(this.f4939a);
        if (iIntValue2 > 4400) {
            arrayListC = y42.c(0, 400, 800, 1200, 1600, 2000, 2400, 2800, 3200, 3600, 4000, 4400, Integer.valueOf(iIntValue2));
        } else {
            Integer[] numArr = new Integer[12];
            if (iIntValue2 > 3300) {
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
        ArrayList arrayList4 = arrayListC;
        this.f4940a.setTextAlign(Paint.Align.CENTER);
        int i9 = iIntValue2 / 50;
        if (i9 >= 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = i11 * 50;
                i = size;
                float f9 = ((int) (((double) i12) * width)) + fMeasureText;
                if (arrayList4.contains(Integer.valueOf(i12)) || (i12 == iIntValue2 && i12 - i10 > 100)) {
                    this.f4940a.setColor(Color.parseColor("#888888"));
                    canvas.drawText(String.valueOf(i12), f9, (getHeight() - f7) + f8 + (iD * 2), this.f4940a);
                    this.f4940a.setColor(Color.parseColor("#aa888888"));
                    float f10 = f8;
                    arrayList = arrayList4;
                    i2 = i11;
                    i3 = i9;
                    f2 = f10;
                    f = f4;
                    i4 = iD;
                    canvas.drawLine(f9, getHeight() - f7, f9, f6, this.f4940a);
                    i10 = i12;
                } else {
                    f = f4;
                    i4 = iD;
                    f2 = f8;
                    arrayList = arrayList4;
                    i2 = i11;
                    i3 = i9;
                }
                if (i2 == i3) {
                    break;
                }
                i11 = i2 + 1;
                f8 = f2;
                f4 = f;
                i9 = i3;
                arrayList4 = arrayList;
                size = i;
                iD = i4;
            }
        } else {
            f = f4;
            f2 = f8;
            i = size;
        }
        this.f4940a.setTextAlign(Paint.Align.RIGHT);
        int i13 = 0;
        for (int i14 = 100; i13 <= i14; i14 = 100) {
            if (i13 % 10 == 0) {
                this.f4940a.setColor(Color.parseColor("#888888"));
                if (i13 <= 0 || i13 % 20 != 0) {
                    f3 = 2.0f;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i13);
                    sb2.append('%');
                    f3 = 2.0f;
                    canvas.drawText(sb2.toString(), fMeasureText - (f * 2.0f), f6 + ((int) ((100 - i13) * height)) + (f2 / 2.2f), this.f4940a);
                }
                this.f4940a.setStrokeWidth(i13 == 0 ? 4.0f : f3);
                this.f4940a.setColor(i13 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                float f11 = f6 + ((int) ((100 - i13) * height));
                canvas.drawLine(fMeasureText, f11, getWidth() - f7, f11, this.f4940a);
            }
            i13++;
        }
        this.f4940a.reset();
        this.f4940a.setColor(getColorAccent());
        this.f4940a.setAntiAlias(true);
        this.f4940a.setStrokeWidth(8.0f);
        this.f4940a.setStyle(Paint.Style.FILL);
        this.f4940a.setPathEffect(null);
        if (i > 0) {
            float size2 = arrayListY.size();
            ArrayList<Integer> arrayList5 = this.c;
            this.f4940a.setStrokeWidth(5.0f);
            int i15 = 0;
            for (Object obj3 : arrayList3) {
                int i16 = i15 + 1;
                if (i15 < 0) {
                    y42.l();
                    throw null;
                }
                HashMap map2 = (HashMap) obj3;
                Paint paint = this.f4940a;
                Integer num3 = arrayList5.get(i15);
                f92.c(num3, "colors.get(i)");
                paint.setColor(num3.intValue());
                int size3 = arrayList3.size();
                Iterator it3 = map2.keySet().iterator();
                while (it3.hasNext()) {
                    float fIntValue = ((int) (((double) r1.intValue()) * width)) + fMeasureText + (((i15 * 2) - size3) * 5.0f);
                    Integer num4 = (Integer) map2.get((Integer) it3.next());
                    if (num4 == null) {
                        num4 = 0;
                    }
                    float fIntValue2 = (num4.intValue() / size2) * 100;
                    if (fIntValue2 < 1) {
                        fIntValue2 = 1.0f;
                    }
                    canvas.drawLine(fIntValue, getHeight() - f7, fIntValue, (getHeight() - f7) - (fIntValue2 * height), this.f4940a);
                    map2 = map2;
                }
                i15 = i16;
            }
        }
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4937a = new py0(getContext());
    }

    public final void g() {
    }

    public final ArrayList<String[]> getClusters() {
        return this.f4941a;
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final ArrayList<Integer> getColors() {
        return this.c;
    }

    public final kl0 getCpuUtils() {
        return this.f4936a;
    }

    public final ArrayList<Integer> getExcludedCores() {
        return this.b;
    }

    public final long getSessionId() {
        return this.f8421a;
    }

    public final void h() {
        if (this.f8421a >= 1 && getWidth() > 0) {
            qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4938a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4938a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f8421a != j) {
            this.f8421a = j;
            this.f4938a = null;
            invalidate();
        }
    }
}
