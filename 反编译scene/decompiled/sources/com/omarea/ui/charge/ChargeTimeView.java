package com.omarea.ui.charge;

import a.a42;
import a.f92;
import a.i41;
import a.i52;
import a.j41;
import a.k41;
import a.qx0;
import a.w21;
import a.z32;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.omarea.model.ChargeStatTime;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ChargeTimeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k41 f4916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f4917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f4918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChargeTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4917a = qx0.d();
        this.f4918a = a42.a(new i41(this));
        this.f4916a = new k41();
        a(attributeSet, 0);
    }

    private final w21 getChartStyles() {
        return (w21) this.f4918a.getValue();
    }

    public final void a(AttributeSet attributeSet, int i) {
        b();
    }

    public final void b() {
    }

    public final void c(int i) {
        this.f8415a = i;
        invalidate();
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path path;
        float f;
        boolean z;
        ChargeTimeView chargeTimeView = this;
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        ArrayList<ChargeStatTime> arrayListB = chargeTimeView.f4917a.b(chargeTimeView.f8415a);
        Paint paint = new Paint();
        int iF = getChartStyles().f();
        float fH = getChartStyles().h();
        f92.c(arrayListB, "samples");
        ChargeStatTime chargeStatTime = (ChargeStatTime) i52.C(arrayListB);
        Long lValueOf = chargeStatTime != null ? Long.valueOf(chargeStatTime.startTime) : null;
        ChargeStatTime chargeStatTime2 = (ChargeStatTime) i52.K(arrayListB);
        j41 j41VarB = chargeTimeView.f4916a.b((lValueOf == null || (chargeStatTime2 != null ? Long.valueOf(chargeStatTime2.endTime) : null) == null) ? 5.0d : (r2.longValue() - lValueOf.longValue()) / 60000.0d);
        double width = (((double) ((getWidth() - fH) - fH)) * 1.0d) / ((double) j41VarB.c());
        float height = (float) ((((double) ((getHeight() - fH) - fH)) * 1.0d) / ((double) 101));
        float height2 = getHeight() - fH;
        Path path2 = new Path();
        double dC = ((double) j41VarB.c()) / ((double) j41VarB.a());
        int iA = j41VarB.a();
        if (iA >= 0) {
            int i = 0;
            while (true) {
                double d = ((double) i) * dC;
                int i2 = iA;
                Path path3 = path2;
                float f2 = ((int) (d * width)) + fH;
                if (i % j41VarB.d() == 0) {
                    getChartStyles().k(paint);
                    canvas.drawText(chargeTimeView.f4916a.a().c(d), f2, (getHeight() - fH) + getChartStyles().g() + (iF * 2), paint);
                }
                getChartStyles().a(i, i % j41VarB.b() == 0, paint);
                int i3 = i;
                j41 j41Var = j41VarB;
                path = path3;
                f = height;
                canvas.drawLine(f2, fH, f2, getHeight() - fH, paint);
                if (i3 == i2) {
                    break;
                }
                i = i3 + 1;
                iA = i2;
                path2 = path;
                height = f;
                j41VarB = j41Var;
                chargeTimeView = this;
            }
        } else {
            path = path2;
            f = height;
        }
        int i4 = 0;
        while (true) {
            if (i4 % 20 == 0) {
                if (i4 > 0) {
                    getChartStyles().l(paint);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    sb.append('%');
                    canvas.drawText(sb.toString(), fH - (iF * 4), ((int) ((101 - i4) * f)) + fH + (getChartStyles().g() / 2.2f), paint);
                }
                getChartStyles().a(i4, true, paint);
                z = false;
            } else {
                z = false;
                getChartStyles().a(i4, false, paint);
            }
            if (i4 % 10 == 0) {
                float f3 = fH + ((int) ((101 - i4) * f));
                canvas.drawLine(fH, f3, getWidth() - fH, f3, paint);
            }
            if (i4 == 101) {
                break;
            } else {
                i4++;
            }
        }
        if (lValueOf != null) {
            ChargeStatTime chargeStatTime3 = (ChargeStatTime) i52.A(arrayListB);
            ChargeStatTime chargeStatTime4 = (ChargeStatTime) i52.J(arrayListB);
            float fLongValue = ((float) (((double) ((chargeStatTime4.endTime - lValueOf.longValue()) / 60000.0f)) * width)) + fH;
            path.moveTo(((float) (((double) ((chargeStatTime3.startTime - lValueOf.longValue()) / 60000.0f)) * width)) + fH, height2 - (chargeStatTime3.capacity * f));
            for (ChargeStatTime chargeStatTime5 : arrayListB) {
                path.lineTo(((float) (((double) ((chargeStatTime5.startTime - lValueOf.longValue()) / 60000.0f)) * width)) + fH, height2 - (chargeStatTime5.capacity * f));
            }
            path.lineTo(fLongValue, height2 - (chargeStatTime4.capacity * f));
        }
        getChartStyles().b(paint);
        canvas.drawPath(path, paint);
    }
}
