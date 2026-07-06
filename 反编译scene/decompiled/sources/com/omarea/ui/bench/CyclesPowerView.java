package com.omarea.ui.bench;

import a.a41;
import a.b62;
import a.d72;
import a.e51;
import a.f92;
import a.fg2;
import a.h42;
import a.i52;
import a.k82;
import a.kl0;
import a.m42;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.qy0;
import a.r62;
import a.u42;
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
public final class CyclesPowerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f8409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f4900a;
    public final ArrayList<Integer> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4901b;
    public ArrayList<qy0> c;

    @x62(c = "com.omarea.ui.bench.CyclesPowerView$render$1", f = "CyclesPowerView.kt", l = {271}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8410a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4903a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4904b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = CyclesPowerView.this.new a(b62Var);
            aVar.f8410a = (wd2) obj;
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
                wd2 wd2Var = this.f8410a;
                CyclesPowerView cyclesPowerView = CyclesPowerView.this;
                cyclesPowerView.f8409a = Bitmap.createBitmap(cyclesPowerView.getWidth(), CyclesPowerView.this.getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap bitmap = CyclesPowerView.this.f8409a;
                f92.b(bitmap);
                Canvas canvas = new Canvas(bitmap);
                CyclesPowerView.this.f(canvas);
                fg2 fg2VarC = qe2.c();
                a41 a41Var = new a41(this, null);
                this.f4903a = wd2Var;
                this.f4904b = canvas;
                this.b = 1;
                if (oc2.g(fg2VarC, a41Var, this) == objC) {
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

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CyclesPowerView.this.i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CyclesPowerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4899a = new Paint();
        this.f4898a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4900a = new kl0().f();
        this.b = new e51().a();
        this.c = new ArrayList<>();
        g(attributeSet, 0);
    }

    public final int e(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void f(Canvas canvas) {
        Integer numValueOf;
        float f;
        ArrayList arrayListC;
        boolean z;
        String str;
        ArrayList<Integer> arrayListA;
        this.f4899a.reset();
        this.f4899a.setStrokeWidth(2.0f);
        kl0 kl0Var = new kl0();
        ArrayList<String[]> arrayListF = kl0Var.f();
        f92.c(arrayListF, "cpuUtils.clusterInfo");
        Object objJ = i52.J(arrayListF);
        f92.c(objJ, "cpuUtils.clusterInfo.last()");
        Object objZ = u42.z((Object[]) objJ);
        f92.c(objZ, "cpuUtils.clusterInfo.last().last()");
        double dL = ((double) (kl0Var.l(Integer.parseInt((String) objZ)) / 1000)) * 1.5d;
        Iterator<T> it = this.c.iterator();
        if (it.hasNext()) {
            numValueOf = Integer.valueOf(((qy0) it.next()).f());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((qy0) it.next()).f());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        Integer num = numValueOf;
        int iMax = Math.max(num != null ? num.intValue() : 0, 6000);
        int iIntValue = 2500;
        if (this.f4901b) {
            Iterator<T> it2 = this.c.iterator();
            while (it2.hasNext()) {
                for (Integer num2 : ((qy0) it2.next()).c()) {
                    if (f92.e(num2.intValue(), iIntValue) > 0) {
                        f92.c(num2, "value");
                        iIntValue = num2.intValue();
                    }
                }
            }
        } else {
            Iterator<T> it3 = this.c.iterator();
            while (it3.hasNext()) {
                for (Integer num3 : ((qy0) it3.next()).a()) {
                    if (f92.e(num3.intValue(), iIntValue) > 0 && Double.compare(num3.intValue(), dL) < 0) {
                        f92.c(num3, "value");
                        iIntValue = num3.intValue();
                    }
                }
            }
        }
        int i = iIntValue;
        Context context = getContext();
        f92.c(context, "this.context");
        float fE = e(context, 1.0f);
        float f2 = fE * 8.5f;
        this.f4899a.setTextSize(f2);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(i).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f3 = fE * 4.0f;
        float fMeasureText = this.f4899a.measureText(sb.toString()) + f3;
        float f4 = fE * 18.0f;
        double d = iMax;
        double width = (((double) ((getWidth() - fMeasureText) - f4)) * 1.0d) / d;
        float height = (float) ((((double) ((getHeight() - f4) - f3)) * 1.0d) / ((double) i));
        float height2 = getHeight() - f4;
        this.f4899a.setTextAlign(Paint.Align.CENTER);
        double d2 = d / ((double) 10);
        this.f4899a.setStrokeWidth(1.0f);
        this.f4899a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            float f5 = ((int) (r1 * width)) + fMeasureText;
            this.f4899a.setColor(Color.parseColor("#888888"));
            canvas.drawText(String.valueOf((int) (((double) i3) * d2)), f5, (getHeight() - f4) + f2 + (r14 * 2), this.f4899a);
            this.f4899a.setColor(Color.parseColor("#40888888"));
            double d3 = d2;
            f = f2;
            canvas.drawLine(f5, f3, f5, getHeight() - f4, this.f4899a);
            if (i3 == 10) {
                break;
            }
            i3++;
            f2 = f;
            d2 = d3;
        }
        this.f4899a.setStrokeWidth(2.0f);
        this.f4899a.setPathEffect(this.f4898a);
        this.f4899a.setTextAlign(Paint.Align.RIGHT);
        boolean z2 = true;
        if (i > 4400) {
            arrayListC = y42.c(0, 400, 800, 1200, 1600, 2000, 2400, 2800, 3200, 3600, 4000, 4400, Integer.valueOf(i));
        } else {
            Integer[] numArr = new Integer[12];
            if (i > 3300) {
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
        if (i >= 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (arrayList.contains(Integer.valueOf(i5)) || (i5 == i && i5 - i4 > 100)) {
                    this.f4899a.setColor(Color.parseColor("#888888"));
                    if (i5 > 0) {
                        canvas.drawText(String.valueOf(i5), fMeasureText - (3.5f * fE), f3 + ((int) ((i - i5) * height)) + (f / 2.2f), this.f4899a);
                    }
                    this.f4899a.setStrokeWidth(i5 == 0 ? 4.0f : 2.0f);
                    this.f4899a.setColor(i5 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f6 = f3 + ((int) ((i - i5) * height));
                    z = z2;
                    canvas.drawLine(fMeasureText, f6, getWidth() - f4, f6, this.f4899a);
                    i4 = i5;
                } else {
                    z = z2;
                }
                if (i5 == i) {
                    break;
                }
                i5++;
                z2 = z;
            }
        } else {
            z = true;
        }
        this.f4899a.reset();
        this.f4899a.setColor(getColorAccent());
        this.f4899a.setAntiAlias(z);
        this.f4899a.setStrokeWidth(8.0f);
        this.f4899a.setStyle(Paint.Style.FILL);
        this.f4899a.setPathEffect(null);
        qy0 qy0Var = (qy0) i52.C(this.c);
        int size = (qy0Var == null || (arrayListA = qy0Var.a()) == null) ? 0 : arrayListA.size();
        if (size > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i6 = 0; i6 < size; i6++) {
                arrayList2.add(new Path());
            }
            ArrayList<Integer> arrayList3 = this.b;
            int size2 = arrayList2.size();
            int[] iArr = new int[size2];
            for (int i7 = 0; i7 < size2; i7++) {
                iArr[i7] = 0;
            }
            Iterator it4 = arrayList2.iterator();
            int i8 = 0;
            while (it4.hasNext()) {
                Object next = it4.next();
                int i9 = i8 + 1;
                if (i8 < 0) {
                    y42.l();
                    throw null;
                }
                String strValueOf = String.valueOf(i8);
                ArrayList<String[]> arrayList4 = this.f4900a;
                f92.c(arrayList4, "clusters");
                int i10 = 0;
                int i11 = 0;
                for (Object obj : arrayList4) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        y42.l();
                        throw null;
                    }
                    String[] strArr = (String[]) obj;
                    Iterator it5 = it4;
                    f92.c(strArr, "cluster");
                    int length2 = strArr.length;
                    int i13 = i9;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length2) {
                            str = null;
                            break;
                        }
                        int i15 = length2;
                        str = strArr[i14];
                        if (f92.a(str, strValueOf)) {
                            break;
                        }
                        i14++;
                        length2 = i15;
                    }
                    if (str != null) {
                        i10 = i11;
                    }
                    i11 = i12;
                    it4 = it5;
                    i9 = i13;
                }
                Integer num4 = arrayList3.get(i10);
                f92.c(num4, "colors.get(colorIndex)");
                iArr[i8] = num4.intValue();
                it4 = it4;
                i8 = i9;
            }
            this.f4899a.setStyle(Paint.Style.FILL);
            this.f4899a.setAlpha(128);
            for (qy0 qy0Var2 : this.c) {
                int size3 = qy0Var2.a().size();
                for (int i16 = 0; i16 < size; i16++) {
                    Integer num5 = size3 > i16 ? (this.f4901b ? qy0Var2.c() : qy0Var2.a()).get(i16) : 0;
                    f92.c(num5, "if (valuesCount > i) {\n …  0\n                    }");
                    int iIntValue2 = num5.intValue();
                    float f7 = ((float) (((double) qy0Var2.f()) * width)) + fMeasureText;
                    if (iIntValue2 < dL && iIntValue2 >= 0) {
                        Object obj2 = arrayList2.get(i16);
                        f92.c(obj2, "paths[i]");
                        if (((Path) obj2).isEmpty()) {
                            ((Path) arrayList2.get(i16)).moveTo(f7, height2 - (iIntValue2 * height));
                        }
                        float f8 = height2 - (iIntValue2 * height);
                        ((Path) arrayList2.get(i16)).lineTo(f7, f8);
                        this.f4899a.setColor(iArr[i16]);
                        canvas.drawCircle(f7, f8, 6.0f, this.f4899a);
                    }
                }
            }
            this.f4899a.setAlpha(255);
            this.f4899a.setStyle(Paint.Style.STROKE);
            this.f4899a.setStrokeWidth(3.0f);
            int i17 = 0;
            for (Object obj3 : arrayList2) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    y42.l();
                    throw null;
                }
                this.f4899a.setColor(iArr[i17]);
                canvas.drawPath((Path) obj3, this.f4899a);
                i17 = i18;
            }
        }
    }

    public final void g(AttributeSet attributeSet, int i) {
        h();
        new py0(getContext());
    }

    public final ArrayList<String[]> getClusters() {
        return this.f4900a;
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final ArrayList<Integer> getColors() {
        return this.b;
    }

    public final boolean getShowFreq() {
        return this.f4901b;
    }

    public final void h() {
    }

    public final void i() {
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f8409a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f8409a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        i();
    }

    public final void setSamples(ArrayList<qy0> arrayList) {
        f92.d(arrayList, "samples");
        this.c = arrayList;
        post(new b());
    }

    public final void setShowFreq(boolean z) {
        this.f4901b = z;
        i();
    }
}
