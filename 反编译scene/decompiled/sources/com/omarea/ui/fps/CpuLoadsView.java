package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.e51;
import a.f92;
import a.fg2;
import a.h42;
import a.i51;
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
public final class CpuLoadsView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f4958a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<Integer> f4959b;
    public final ArrayList<Integer> c;

    @x62(c = "com.omarea.ui.fps.CpuLoadsView$render$1", f = "CpuLoadsView.kt", l = {258}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8426a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4961a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = CpuLoadsView.this.new a(b62Var);
            aVar.f8426a = (wd2) obj;
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
                wd2 wd2Var = this.f8426a;
                CpuLoadsView cpuLoadsView = CpuLoadsView.this;
                cpuLoadsView.f4955a = Bitmap.createBitmap(cpuLoadsView.getWidth(), CpuLoadsView.this.getHeight(), Bitmap.Config.ARGB_8888);
                CpuLoadsView cpuLoadsView2 = CpuLoadsView.this;
                Bitmap bitmap = CpuLoadsView.this.f4955a;
                f92.b(bitmap);
                cpuLoadsView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                i51 i51Var = new i51(this, null);
                this.f4961a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, i51Var, this) == objC) {
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
    public CpuLoadsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4954a = new vj0();
        this.f4957a = new Paint();
        this.f4956a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4958a = new kl0().f();
        this.f8425a = new kl0().h();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        m42 m42Var = m42.f6769a;
        this.f4959b = arrayList;
        this.b = Color.parseColor("#87d3ff");
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
        String str;
        Float fValueOf;
        py0 py0Var = this.f4953a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<ArrayList<Float>> arrayListA = py0Var.A(this.f4952a);
        if (arrayListA.size() < 1) {
            return;
        }
        this.f4957a.reset();
        this.f4957a.setStrokeWidth(2.0f);
        Context context = getContext();
        f92.c(context, "this.context");
        float fD = d(context, 1.0f);
        float f2 = fD * 18.0f;
        float f3 = fD * 4.0f;
        double size = ((double) (arrayListA.size() - 1)) / 60.0d;
        double width = (((double) ((getWidth() - f2) - f2)) * 1.0d) / size;
        float height = (float) ((((double) ((getHeight() - f2) - f3)) * 1.0d) / ((double) 100));
        float height2 = getHeight() - f2;
        float f4 = fD * 8.5f;
        this.f4957a.setTextSize(f4);
        this.f4957a.setTextAlign(Paint.Align.CENTER);
        double d = size / ((double) 5);
        this.f4957a.setStrokeWidth(1.0f);
        this.f4957a.setStyle(Paint.Style.FILL);
        int i = 0;
        while (true) {
            float f5 = ((int) (r1 * width)) + f2;
            this.f4957a.setColor(Color.parseColor("#888888"));
            canvas.drawText(this.f4954a.c(((double) i) * d), f5, (getHeight() - f2) + f4 + (r13 * 2), this.f4957a);
            this.f4957a.setColor(Color.parseColor("#40888888"));
            int i2 = i;
            f = f4;
            canvas.drawLine(f5, f3, f5, getHeight() - f2, this.f4957a);
            if (i2 == 5) {
                break;
            }
            i = i2 + 1;
            f4 = f;
        }
        this.f4957a.setStrokeWidth(2.0f);
        this.f4957a.setPathEffect(this.f4956a);
        this.f4957a.setTextAlign(Paint.Align.RIGHT);
        int i3 = 0;
        while (true) {
            this.f4957a.setColor(Color.parseColor("#888888"));
            if (i3 % 10 == 0) {
                if (i3 > 0) {
                    canvas.drawText(String.valueOf(i3), f2 - (r13 * 4), f3 + ((int) ((100 - i3) * height)) + (f / 2.2f), this.f4957a);
                }
                this.f4957a.setStrokeWidth(i3 == 0 ? 4.0f : 2.0f);
                this.f4957a.setColor(i3 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                float f6 = f3 + ((int) ((100 - i3) * height));
                canvas.drawLine(f2, f6, getWidth() - f2, f6, this.f4957a);
            }
            if (i3 == 100) {
                break;
            } else {
                i3++;
            }
        }
        this.f4957a.reset();
        this.f4957a.setColor(getColorAccent());
        Iterator it = ((Iterable) i52.A(arrayListA)).iterator();
        double dFloatValue = 0.0d;
        while (it.hasNext()) {
            dFloatValue += (double) ((Number) it.next()).floatValue();
        }
        float f7 = height2 - (((float) dFloatValue) * height);
        this.f4957a.setAntiAlias(true);
        this.f4957a.setStrokeWidth(6.0f);
        this.f4957a.setStyle(Paint.Style.FILL);
        this.f4957a.setPathEffect(null);
        if (!this.f4959b.contains(-1)) {
            this.f4957a.setColor(this.b);
            float f8 = f7;
            float f9 = f2;
            int i4 = 0;
            for (ArrayList<Float> arrayList : arrayListA) {
                float f10 = ((float) (((double) (i4 / 60.0f)) * width)) + f2;
                f92.c(arrayList, "sample");
                Iterator<T> it2 = arrayList.iterator();
                double dFloatValue2 = 0.0d;
                while (it2.hasNext()) {
                    dFloatValue2 += (double) ((Number) it2.next()).floatValue();
                }
                float size2 = height2 - ((float) ((dFloatValue2 / ((double) arrayList.size())) * ((double) height)));
                canvas.drawLine(f9, f8, f10, size2, this.f4957a);
                i4++;
                f8 = size2;
                f9 = f10;
            }
        }
        ArrayList arrayList2 = (ArrayList) i52.C(arrayListA);
        int size3 = (arrayList2 != null ? arrayList2.size() : 0) + 1;
        if (size3 > 0) {
            ArrayList arrayList3 = new ArrayList();
            int i5 = size3 - 1;
            for (int i6 = 0; i6 < i5; i6++) {
                Path path = new Path();
                if (arrayList2 == null || (fValueOf = (Float) arrayList2.get(i6)) == null) {
                    fValueOf = Float.valueOf(0.0f);
                }
                f92.c(fValueOf, "firstSample?.get(i)?:0F");
                path.moveTo(f2, height2 - (fValueOf.floatValue() * height));
                m42 m42Var = m42.f6769a;
                arrayList3.add(path);
            }
            int i7 = 0;
            for (ArrayList<Float> arrayList4 : arrayListA) {
                float f11 = ((float) (((double) (i7 / 60.0f)) * width)) + f2;
                for (int i8 = 0; i8 < i5; i8++) {
                    if (!this.f4959b.contains(Integer.valueOf(i8))) {
                        Float f12 = arrayList4.get(i8);
                        f92.c(f12, "sample[i]");
                        ((Path) arrayList3.get(i8)).lineTo(f11, height2 - (f12.floatValue() * height));
                    }
                }
                i7++;
            }
            this.f4957a.setStyle(Paint.Style.STROKE);
            this.f4957a.setStrokeWidth(3.0f);
            ArrayList<Integer> arrayList5 = this.c;
            int i9 = 0;
            for (Object obj : arrayList3) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    y42.l();
                    throw null;
                }
                Path path2 = (Path) obj;
                String strValueOf = String.valueOf(i9);
                ArrayList<String[]> arrayList6 = this.f4958a;
                f92.c(arrayList6, "clusters");
                int i11 = 0;
                int i12 = 0;
                for (Object obj2 : arrayList6) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        y42.l();
                        throw null;
                    }
                    String[] strArr = (String[]) obj2;
                    f92.c(strArr, "cluster");
                    int length = strArr.length;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            str = null;
                            break;
                        }
                        str = strArr[i14];
                        if (f92.a(str, strValueOf)) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (str != null) {
                        i11 = i12;
                    }
                    i12 = i13;
                }
                Paint paint = this.f4957a;
                Integer num = arrayList5.get(i11);
                f92.c(num, "colors.get(colorIndex)");
                paint.setColor(num.intValue());
                this.f4957a.setStrokeWidth(i11 + 1.0f);
                canvas.drawPath(path2, this.f4957a);
                i9 = i10;
            }
        }
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4953a = new py0(getContext());
    }

    public final void g() {
    }

    public final ArrayList<String[]> getClusters() {
        return this.f4958a;
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final ArrayList<Integer> getColors() {
        return this.c;
    }

    public final int getCoreCount() {
        return this.f8425a;
    }

    public final ArrayList<Integer> getExcludedCores() {
        return this.f4959b;
    }

    public final int getMainColor() {
        return this.b;
    }

    public final long getSessionId() {
        return this.f4952a;
    }

    public final void h() {
        if (this.f4952a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4955a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4955a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f4952a != j) {
            this.f4952a = j;
            this.f4955a = null;
            invalidate();
        }
    }
}
