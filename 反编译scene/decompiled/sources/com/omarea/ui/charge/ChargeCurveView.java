package com.omarea.ui.charge;

import a.a42;
import a.b62;
import a.bc2;
import a.d72;
import a.f41;
import a.f92;
import a.fg2;
import a.g41;
import a.h42;
import a.i52;
import a.j41;
import a.k41;
import a.k82;
import a.m42;
import a.oc2;
import a.qc2;
import a.qe2;
import a.qx0;
import a.r62;
import a.u42;
import a.w21;
import a.wd2;
import a.x62;
import a.xd2;
import a.z32;
import a.z42;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.omarea.model.ChargeStatRecord;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ChargeCurveView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k41 f4905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f4906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f4907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4909a;
    public boolean b;

    @x62(c = "com.omarea.ui.charge.ChargeCurveView$update$1", f = "ChargeCurveView.kt", l = {92}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8413a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4911a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4912b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ChargeCurveView.this.new a(b62Var);
            aVar.f8413a = (wd2) obj;
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
                wd2 wd2Var = this.f8413a;
                Bitmap bitmap = ChargeCurveView.this.f4908a;
                f92.b(bitmap);
                Canvas canvas = new Canvas(bitmap);
                if (ChargeCurveView.this.b) {
                    ChargeCurveView.this.g(canvas);
                } else {
                    ChargeCurveView.this.f(canvas);
                }
                fg2 fg2VarC = qe2.c();
                g41 g41Var = new g41(this, null);
                this.f4911a = wd2Var;
                this.f4912b = canvas;
                this.b = 1;
                if (oc2.g(fg2VarC, g41Var, this) == objC) {
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
    public ChargeCurveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4906a = qx0.d();
        this.f4909a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4907a = a42.a(new f41(this));
        this.b = true;
        this.f4905a = new k41();
        i(attributeSet, 0);
    }

    private final w21 getChartStyles() {
        return (w21) this.f4907a.getValue();
    }

    public final int e(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void f(Canvas canvas) {
        Path path;
        float f;
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<ChargeStatRecord> arrayListO = this.f4906a.o(this.f8412a);
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        Context context = getContext();
        f92.c(context, "this.context");
        int iE = e(context, 1.0f);
        float fH = getChartStyles().h();
        f92.c(arrayListO, "samples");
        ArrayList arrayList = new ArrayList(z42.m(arrayListO, 10));
        Iterator<T> it = arrayListO.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ChargeStatRecord) it.next()).current));
        }
        Long l = (Long) i52.L(arrayList);
        long jLongValue = l != null ? (l.longValue() / ((long) 1000)) + 1 : 10L;
        if (jLongValue < 3) {
            jLongValue = 3;
        } else if (jLongValue < 6) {
            jLongValue = 6;
        }
        int i = jLongValue < ((long) 7) ? 2 : 1;
        float height = (float) ((((double) ((getHeight() - fH) - fH)) * 1.0d) / jLongValue);
        float height2 = getHeight() - fH;
        Path path2 = new Path();
        double dH = h(arrayListO, fH, canvas, paint);
        float f2 = iE * 8.5f;
        long j = ((long) i) * jLongValue;
        paint.setPathEffect(this.f4909a);
        if (0 <= j) {
            Path path3 = path2;
            long j2 = 0;
            while (true) {
                double d = (j2 / 1.0d) / ((double) i);
                getChartStyles().l(paint);
                long j3 = j;
                if (j2 <= 0 || j2 % ((long) 2) != 0) {
                    z2 = true;
                    z3 = false;
                    getChartStyles().a((int) j2, false, paint);
                } else {
                    canvas.drawText(bc2.t(String.valueOf(d) + "A", ".0A", "A", false, 4, null), fH - (getChartStyles().f() * 4), ((int) (((double) height) * (r11 - d))) + fH + (f2 / 2.2f), paint);
                    z2 = true;
                    getChartStyles().a((int) j2, true, paint);
                    z3 = false;
                }
                float f3 = fH + ((int) ((r11 - d) * ((double) height)));
                long j4 = j2;
                z = z3;
                path = path3;
                f = height;
                canvas.drawLine(fH, f3, getWidth() - fH, f3, paint);
                if (j4 == j3) {
                    break;
                }
                j2 = j4 + 1;
                path3 = path;
                height = f;
                j = j3;
            }
        } else {
            path = path2;
            f = height;
            z = false;
            z2 = true;
        }
        ChargeStatRecord chargeStatRecord = (ChargeStatRecord) i52.C(arrayListO);
        long j5 = chargeStatRecord != null ? chargeStatRecord.time : 0L;
        Iterator<ChargeStatRecord> it2 = arrayListO.iterator();
        while (it2.hasNext()) {
            float f4 = ((float) (((double) ((r4.time - j5) / 60000.0f)) * dH)) + fH;
            long j6 = it2.next().current;
            float f5 = height2 - ((j6 < 0 ? 0.0f : j6 / 1000.0f) * f);
            if (z2) {
                path.moveTo(f4, f5);
                z2 = z;
            } else {
                path.lineTo(f4, f5);
            }
        }
        getChartStyles().b(paint);
        canvas.drawPath(path, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6 A[LOOP:1: B:55:0x00f4->B:56:0x00f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(android.graphics.Canvas r27) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.charge.ChargeCurveView.g(android.graphics.Canvas):int");
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final double h(ArrayList<ChargeStatRecord> arrayList, float f, Canvas canvas, Paint paint) {
        char c;
        char c2;
        char c3;
        ChargeCurveView chargeCurveView = this;
        Context context = getContext();
        f92.c(context, "this.context");
        float fE = chargeCurveView.e(context, 1.0f) * 8.5f;
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(fE);
        boolean z = false;
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        ChargeStatRecord chargeStatRecord = (ChargeStatRecord) i52.C(arrayList);
        Long lValueOf = chargeStatRecord != null ? Long.valueOf(chargeStatRecord.time) : null;
        ChargeStatRecord chargeStatRecord2 = (ChargeStatRecord) i52.K(arrayList);
        j41 j41VarB = chargeCurveView.f4905a.b((lValueOf == null || (chargeStatRecord2 != null ? Long.valueOf(chargeStatRecord2.time) : null) == null) ? 5.0d : (r2.longValue() - lValueOf.longValue()) / 60000.0d);
        double dC = ((double) j41VarB.c()) / ((double) j41VarB.a());
        double width = (((double) ((getWidth() - f) - f)) * 1.0d) / ((double) j41VarB.c());
        int iA = j41VarB.a();
        if (iA >= 0) {
            int i = 0;
            while (true) {
                double d = ((double) i) * dC;
                float f2 = ((int) (d * width)) + f;
                if (i % j41VarB.d() == 0) {
                    getChartStyles().k(paint);
                    canvas.drawText(chargeCurveView.f4905a.a().c(d), f2, (getHeight() - f) + fE + (r9 * 2), paint);
                }
                getChartStyles().a(i, i % j41VarB.b() == 0 ? true : z, paint);
                int i2 = i;
                int i3 = iA;
                canvas.drawLine(f2, f, f2, getHeight() - f, paint);
                if (i2 == i3) {
                    break;
                }
                i = i2 + 1;
                z = false;
                iA = i3;
                chargeCurveView = this;
            }
        }
        paint.setTextAlign(Paint.Align.CENTER);
        if (lValueOf != null) {
            float height = getHeight() - f;
            float height2 = (float) ((((double) ((getHeight() - f) - f)) * 1.0d) / ((double) 101));
            ChargeStatRecord chargeStatRecord3 = (ChargeStatRecord) i52.A(arrayList);
            ChargeStatRecord chargeStatRecord4 = (ChargeStatRecord) i52.J(arrayList);
            float fLongValue = ((float) (((double) ((chargeStatRecord4.time - lValueOf.longValue()) / 60000.0f)) * width)) + f;
            Path path = new Path();
            path.moveTo(((float) (((double) ((chargeStatRecord3.time - lValueOf.longValue()) / 60000.0f)) * width)) + f, height - (chargeStatRecord3.capacity * height2));
            int i4 = 4;
            Integer[] numArr = {20, 40, 60, 80};
            int i5 = 0;
            for (ChargeStatRecord chargeStatRecord5 : arrayList) {
                float fLongValue2 = ((float) (((double) ((chargeStatRecord5.time - lValueOf.longValue()) / 60000.0f)) * width)) + f;
                float f3 = height - (chargeStatRecord5.capacity * height2);
                path.lineTo(fLongValue2, f3);
                int i6 = chargeStatRecord5.capacity;
                if (i5 != i6) {
                    if (u42.k(numArr, Integer.valueOf(i6))) {
                        Integer[] numArr2 = new Integer[i4];
                        c = 20;
                        numArr2[0] = 20;
                        c3 = '(';
                        numArr2[1] = 40;
                        c2 = '<';
                        numArr2[2] = 60;
                        numArr2[3] = 80;
                        if (u42.k(numArr2, Integer.valueOf(i6))) {
                            canvas.drawCircle(fLongValue2, f3, 4.0f, paint);
                            StringBuilder sb = new StringBuilder();
                            sb.append(i6);
                            sb.append('%');
                            canvas.drawText(sb.toString(), fLongValue2, f3, paint);
                        }
                    } else {
                        c = 20;
                        c2 = '<';
                        c3 = '(';
                    }
                    i5 = i6;
                } else {
                    c = 20;
                    c2 = '<';
                    c3 = '(';
                }
                i4 = 4;
            }
            path.lineTo(fLongValue, height - (chargeStatRecord4.capacity * height2));
            getChartStyles().c(paint);
            canvas.drawPath(path, paint);
        }
        paint.reset();
        return width;
    }

    public final void i(AttributeSet attributeSet, int i) {
        j();
    }

    public final void j() {
    }

    public final boolean k() {
        boolean z = !this.b;
        this.b = z;
        return z;
    }

    public final void l(int i) {
        if (getWidth() < 1 || getHeight() < 1) {
            return;
        }
        this.f8412a = i;
        Bitmap bitmap = this.f4908a;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f4908a = null;
        this.f4908a = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        f92.d(canvas, "originCanvas");
        super.onDraw(canvas);
        if (getHeight() < 0 || getWidth() < 0 || (bitmap = this.f4908a) == null) {
            return;
        }
        f92.b(bitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }
}
