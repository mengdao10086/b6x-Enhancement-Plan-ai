package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.e51;
import a.f51;
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
import a.r62;
import a.u42;
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
public final class CpuCyclesView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f4931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f4932a;
    public final ArrayList<Integer> b;
    public final ArrayList<Integer> c;

    public enum a {
        /* JADX INFO: Fake field, exist only in values array */
        TEMPERATURE,
        /* JADX INFO: Fake field, exist only in values array */
        LOAD,
        /* JADX INFO: Fake field, exist only in values array */
        CAPACITY
    }

    @x62(c = "com.omarea.ui.fps.CpuCyclesView$render$1", f = "CpuCyclesView.kt", l = {368}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8420a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4934a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4935b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = CpuCyclesView.this.new b(b62Var);
            bVar.f8420a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8420a;
                CpuCyclesView cpuCyclesView = CpuCyclesView.this;
                cpuCyclesView.f4928a = Bitmap.createBitmap(cpuCyclesView.getWidth(), CpuCyclesView.this.getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap bitmap = CpuCyclesView.this.f4928a;
                f92.b(bitmap);
                Canvas canvas = new Canvas(bitmap);
                CpuCyclesView.this.g(canvas);
                CpuCyclesView.this.f(canvas);
                fg2 fg2VarC = qe2.c();
                f51 f51Var = new f51(this, null);
                this.f4934a = wd2Var;
                this.f4935b = canvas;
                this.b = 1;
                if (oc2.g(fg2VarC, f51Var, this) == objC) {
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
    public CpuCyclesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4927a = new vj0();
        this.f4930a = new Paint();
        this.f4929a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4931a = (a) u42.n(a.values());
        this.f4932a = new kl0().f();
        this.b = new ArrayList<>();
        this.c = new e51().a();
        h(attributeSet, 0);
    }

    public final int e(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01f2 A[LOOP:0: B:23:0x0166->B:39:0x01f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0204 A[EDGE_INSN: B:48:0x0204->B:41:0x0204 BREAK  A[LOOP:0: B:23:0x0166->B:39:0x01f2], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.graphics.Canvas r31) {
        /*
            Method dump skipped, instruction units count: 649
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.CpuCyclesView.f(android.graphics.Canvas):void");
    }

    public final void g(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        ArrayList arrayListC;
        String str;
        Integer num;
        float f5;
        int i;
        ArrayList<ArrayList<Integer>> arrayList;
        py0 py0Var = this.f4926a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<ArrayList<Integer>> arrayListX = py0Var.x(this.f8418a);
        if (arrayListX.size() < 1) {
            return;
        }
        this.f4930a.reset();
        this.f4930a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListX.size() - 1)) / 60.0d;
        kl0 kl0Var = new kl0();
        ArrayList<String[]> arrayListF = kl0Var.f();
        f92.c(arrayListF, "cpuFrequencyUtils.clusterInfo");
        Object objJ = i52.J(arrayListF);
        f92.c(objJ, "cpuFrequencyUtils.clusterInfo.last()");
        Object objZ = u42.z((Object[]) objJ);
        f92.c(objZ, "cpuFrequencyUtils.clusterInfo.last().last()");
        double dL = ((double) (kl0Var.l(Integer.parseInt((String) objZ)) / 1000)) * 1.5d;
        Iterator<T> it = arrayListX.iterator();
        int iIntValue = 2100;
        while (it.hasNext()) {
            for (Integer num2 : (ArrayList) it.next()) {
                if (f92.e(num2.intValue(), iIntValue) > 0) {
                    arrayList = arrayListX;
                    if (Double.compare(num2.intValue(), dL) < 0) {
                        f92.c(num2, "value");
                        iIntValue = num2.intValue();
                    }
                } else {
                    arrayList = arrayListX;
                }
                arrayListX = arrayList;
            }
        }
        ArrayList<ArrayList<Integer>> arrayList2 = arrayListX;
        Context context = getContext();
        f92.c(context, "this.context");
        float fE = e(context, 1.0f);
        float f6 = fE * 8.5f;
        this.f4930a.setTextSize(f6);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(iIntValue).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f7 = fE * 4.0f;
        float fMeasureText = this.f4930a.measureText(sb.toString()) + f7;
        float f8 = fE * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f8)) * 1.0d) / size;
        float height = getHeight() - f8;
        this.f4930a.setTextAlign(Paint.Align.CENTER);
        float height2 = (float) ((((double) ((getHeight() - f8) - f7)) * 1.0d) / ((double) iIntValue));
        double d = size / ((double) 5);
        this.f4930a.setStrokeWidth(1.0f);
        this.f4930a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            f = height2;
            float f9 = ((int) (r1 * width)) + fMeasureText;
            int i4 = i3;
            this.f4930a.setColor(Color.parseColor("#888888"));
            canvas.drawText(this.f4927a.c(((double) i3) * d), f9, (getHeight() - f8) + f6 + (r9 * 2), this.f4930a);
            this.f4930a.setColor(Color.parseColor("#40888888"));
            double d2 = d;
            f2 = fMeasureText;
            f3 = f6;
            f4 = fE;
            canvas.drawLine(f9, f7, f9, getHeight() - f8, this.f4930a);
            if (i4 == 5) {
                break;
            }
            i3 = i4 + 1;
            fMeasureText = f2;
            f6 = f3;
            fE = f4;
            height2 = f;
            d = d2;
        }
        this.f4930a.setStrokeWidth(2.0f);
        this.f4930a.setPathEffect(this.f4929a);
        this.f4930a.setTextAlign(Paint.Align.RIGHT);
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
        ArrayList arrayList3 = arrayListC;
        if (iIntValue >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (arrayList3.contains(Integer.valueOf(i6)) || (i6 == iIntValue && i6 - i5 > 100)) {
                    this.f4930a.setColor(Color.parseColor("#888888"));
                    if (i6 > 0) {
                        canvas.drawText(String.valueOf(i6), f2 - (3.5f * f4), ((int) ((iIntValue - i6) * f)) + f7 + (f3 / 2.2f), this.f4930a);
                    }
                    this.f4930a.setStrokeWidth(i6 == 0 ? 4.0f : 2.0f);
                    this.f4930a.setColor(i6 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f10 = f7 + ((int) ((iIntValue - i6) * f));
                    f5 = f3;
                    i = i6;
                    canvas.drawLine(f2, f10, getWidth() - f8, f10, this.f4930a);
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
        this.f4930a.reset();
        this.f4930a.setColor(getColorAccent());
        this.f4930a.setAntiAlias(true);
        this.f4930a.setStrokeWidth(8.0f);
        this.f4930a.setStyle(Paint.Style.FILL);
        this.f4930a.setPathEffect(null);
        ArrayList arrayList4 = (ArrayList) i52.C(arrayList2);
        int size2 = arrayList4 != null ? arrayList4.size() : 0;
        if (size2 > 0) {
            ArrayList arrayList5 = new ArrayList();
            for (int i7 = 0; i7 < size2; i7++) {
                Path path = new Path();
                f92.b(arrayList4);
                Object obj = arrayList4.get(i7);
                f92.b(obj);
                path.moveTo(f2, height - (((Number) obj).floatValue() * f));
                m42 m42Var = m42.f6769a;
                arrayList5.add(path);
            }
            Iterator<T> it2 = arrayList2.iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                ArrayList arrayList6 = (ArrayList) it2.next();
                int size3 = arrayList6.size();
                float f11 = ((float) (((double) (i8 / 60.0f)) * width)) + f2;
                for (int i9 = 0; i9 < size2; i9++) {
                    if (!this.b.contains(Integer.valueOf(i9))) {
                        if (size3 > i9) {
                            Object obj2 = arrayList6.get(i9);
                            f92.b(obj2);
                            num = (Integer) obj2;
                        } else {
                            num = 0;
                        }
                        f92.c(num, "if (valuesCount > i) {\n …                        }");
                        int iIntValue2 = num.intValue();
                        if (iIntValue2 < dL && iIntValue2 >= 0) {
                            ((Path) arrayList5.get(i9)).lineTo(f11, height - (iIntValue2 * f));
                        }
                    }
                }
                i8++;
            }
            this.f4930a.setStyle(Paint.Style.STROKE);
            this.f4930a.setStrokeWidth(3.0f);
            ArrayList<Integer> arrayList7 = this.c;
            int i10 = 0;
            for (Object obj3 : arrayList5) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    y42.l();
                    throw null;
                }
                Path path2 = (Path) obj3;
                String strValueOf = String.valueOf(i10);
                ArrayList<String[]> arrayList8 = this.f4932a;
                f92.c(arrayList8, "clusters");
                int i12 = 0;
                int i13 = 0;
                for (Object obj4 : arrayList8) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        y42.l();
                        throw null;
                    }
                    String[] strArr = (String[]) obj4;
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
                Paint paint = this.f4930a;
                Integer num3 = arrayList7.get(i12);
                f92.c(num3, "colors.get(colorIndex)");
                paint.setColor(num3.intValue());
                this.f4930a.setStrokeWidth(i12 + 1.0f);
                canvas.drawPath(path2, this.f4930a);
                i10 = i11;
            }
        }
    }

    public final ArrayList<String[]> getClusters() {
        return this.f4932a;
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

    public final a getRightDimension() {
        return this.f4931a;
    }

    public final long getSessionId() {
        return this.f8418a;
    }

    public final void h(AttributeSet attributeSet, int i) {
        i();
        this.f4926a = new py0(getContext());
    }

    public final void i() {
    }

    public final void j() {
        if (this.f8418a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new b(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4928a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4928a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        j();
    }

    public final void setRightDimension(a aVar) {
        f92.d(aVar, "rightDIMENSION");
        if (this.f4931a != aVar) {
            this.f4931a = aVar;
            this.f4928a = null;
            invalidate();
        }
    }

    public final void setSessionId(long j) {
        if (this.f8418a != j) {
            this.f8418a = j;
            this.f4928a = null;
            invalidate();
        }
    }
}
