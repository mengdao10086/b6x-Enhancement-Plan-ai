package wa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import qa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f54620a = new Path();

    @Override // wa.e
    public void a(Canvas canvas, k kVar, l lVar, float f10, float f11, Paint paint) {
        float fR0 = kVar.r0();
        float f12 = fR0 / 2.0f;
        float fE = (fR0 - (xa.k.e(kVar.q1()) * 2.0f)) / 2.0f;
        int iI0 = kVar.I0();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f54620a;
        path.reset();
        float f13 = f11 - f12;
        path.moveTo(f10, f13);
        float f14 = f10 + f12;
        float f15 = f11 + f12;
        path.lineTo(f14, f15);
        float f16 = f10 - f12;
        path.lineTo(f16, f15);
        double d10 = fR0;
        if (d10 > 0.0d) {
            path.lineTo(f10, f13);
            float f17 = f16 + fE;
            float f18 = f15 - fE;
            path.moveTo(f17, f18);
            path.lineTo(f14 - fE, f18);
            path.lineTo(f10, f13 + fE);
            path.lineTo(f17, f18);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d10 <= 0.0d || iI0 == 1122867) {
            return;
        }
        paint.setColor(iI0);
        path.moveTo(f10, f13 + fE);
        float f19 = f15 - fE;
        path.lineTo(f14 - fE, f19);
        path.lineTo(f16 + fE, f19);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
    }
}
