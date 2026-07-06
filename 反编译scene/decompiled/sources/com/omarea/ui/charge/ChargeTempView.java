package com.omarea.ui.charge;

import a.a42;
import a.f92;
import a.h41;
import a.i52;
import a.j41;
import a.k41;
import a.qx0;
import a.w21;
import a.z32;
import a.z42;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.omarea.model.ChargeStatRecord;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ChargeTempView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k41 f4913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f4914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f4915a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChargeTempView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4914a = qx0.d();
        this.f4915a = a42.a(new h41(this));
        this.f4913a = new k41();
        b(attributeSet, 0);
    }

    private final w21 getChartStyles() {
        return (w21) this.f4915a.getValue();
    }

    public final int a(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void b(AttributeSet attributeSet, int i) {
        c();
    }

    public final void c() {
    }

    public final void d(int i) {
        this.f8414a = i;
        invalidate();
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        ArrayList<ChargeStatRecord> arrayList;
        Path path;
        Canvas canvas2;
        boolean z;
        boolean z2;
        Path path2;
        boolean z3;
        Canvas canvas3;
        ChargeTempView chargeTempView = this;
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        ArrayList<ChargeStatRecord> arrayListJ = chargeTempView.f4914a.j(chargeTempView.f8414a);
        Paint paint = new Paint();
        Context context = getContext();
        f92.c(context, "this.context");
        int iA = chargeTempView.a(context, 1.0f);
        Path path3 = new Path();
        float fG = getChartStyles().g();
        f92.c(arrayListJ, "samples");
        ArrayList arrayList2 = new ArrayList(z42.m(arrayListJ, 10));
        Iterator<T> it = arrayListJ.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(((ChargeStatRecord) it.next()).temperature));
        }
        i52.P(arrayList2);
        ArrayList arrayList3 = new ArrayList(z42.m(arrayListJ, 10));
        Iterator<T> it2 = arrayListJ.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(((ChargeStatRecord) it2.next()).temperature));
        }
        Float fN = i52.N(arrayList3);
        ChargeStatRecord chargeStatRecord = (ChargeStatRecord) i52.C(arrayListJ);
        Long lValueOf = chargeStatRecord != null ? Long.valueOf(chargeStatRecord.time) : null;
        ChargeStatRecord chargeStatRecord2 = (ChargeStatRecord) i52.K(arrayListJ);
        j41 j41VarB = chargeTempView.f4913a.b((lValueOf == null || (chargeStatRecord2 != null ? Long.valueOf(chargeStatRecord2.time) : null) == null) ? 5.0d : (r3.longValue() - lValueOf.longValue()) / 60000.0d);
        float fH = getChartStyles().h();
        float fMeasureText = paint.measureText(String.valueOf(fN) + "℃");
        int iFloatValue = (fN == null || fN.floatValue() <= ((float) 50)) ? 51 : ((int) fN.floatValue()) + 2;
        double width = (((double) ((getWidth() - fH) - fH)) * 1.0d) / ((double) j41VarB.c());
        int i2 = iFloatValue - 25;
        float height = (float) ((((double) ((getHeight() - fH) - fH)) * 1.0d) / ((double) i2));
        float height2 = getHeight() - fH;
        double dC = ((double) j41VarB.c()) / ((double) j41VarB.a());
        int iA2 = j41VarB.a();
        if (iA2 >= 0) {
            int i3 = 0;
            while (true) {
                double d = ((double) i3) * dC;
                int i4 = i2;
                int i5 = iA2;
                float f = ((int) (d * width)) + fH;
                if (i3 % j41VarB.d() == 0) {
                    getChartStyles().k(paint);
                    canvas3 = canvas;
                    canvas3.drawText(chargeTempView.f4913a.a().c(d), f, (getHeight() - fH) + fG + (iA * 2), paint);
                } else {
                    canvas3 = canvas;
                }
                getChartStyles().a(i3, i3 % j41VarB.b() == 0, paint);
                int i6 = i3;
                j41 j41Var = j41VarB;
                i = i4;
                arrayList = arrayListJ;
                path = path3;
                canvas2 = canvas3;
                canvas.drawLine(f, fH, f, getHeight() - fH, paint);
                if (i6 == i5) {
                    break;
                }
                i3 = i6 + 1;
                chargeTempView = this;
                iA2 = i5;
                i2 = i;
                arrayListJ = arrayList;
                j41VarB = j41Var;
                path3 = path;
            }
        } else {
            i = i2;
            arrayList = arrayListJ;
            path = path3;
            canvas2 = canvas;
        }
        if (i >= 0) {
            int i7 = 0;
            while (true) {
                float f2 = fH + ((int) ((i - i7) * height));
                if (i7 % 5 == 0) {
                    if (i7 > 0) {
                        getChartStyles().l(paint);
                        StringBuilder sb = new StringBuilder();
                        sb.append(i7 + 25);
                        sb.append((char) 8451);
                        canvas2.drawText(sb.toString(), fH - (iA * 4), (fG / 2.0f) + f2, paint);
                    }
                    z = true;
                    getChartStyles().a(i7, true, paint);
                    z3 = false;
                } else {
                    z = true;
                    z3 = false;
                    getChartStyles().a(i7, false, paint);
                }
                z2 = z3;
                canvas.drawLine(fMeasureText, f2, getWidth() - fH, f2, paint);
                if (i7 == i) {
                    break;
                } else {
                    i7++;
                }
            }
        } else {
            z = true;
            z2 = false;
        }
        if (lValueOf != null) {
            Iterator<ChargeStatRecord> it3 = arrayList.iterator();
            boolean z4 = z;
            while (it3.hasNext()) {
                float fLongValue = ((float) (((double) ((r1.time - lValueOf.longValue()) / 60000.0f)) * width)) + fH;
                float f3 = it3.next().temperature;
                float f4 = 25;
                float f5 = f3 > f4 ? f3 - f4 : 0.0f;
                if (z4) {
                    path2 = path;
                    path2.moveTo(fLongValue, height2 - (f5 * height));
                    z4 = z2;
                } else {
                    path2 = path;
                    path2.lineTo(fLongValue, height2 - (f5 * height));
                }
                path = path2;
            }
        }
        getChartStyles().b(paint);
        canvas2.drawPath(path, paint);
    }
}
