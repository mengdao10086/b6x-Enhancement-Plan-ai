package wa;

import android.graphics.Canvas;
import android.graphics.Paint;
import qa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class c implements e {
    @Override // wa.e
    public void a(Canvas canvas, k kVar, l lVar, float f10, float f11, Paint paint) {
        float fR0 = kVar.r0();
        float f12 = fR0 / 2.0f;
        float fE = xa.k.e(kVar.q1());
        float f13 = (fR0 - (fE * 2.0f)) / 2.0f;
        float f14 = f13 / 2.0f;
        int iI0 = kVar.I0();
        if (fR0 <= 0.0d) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f10, f11, f12, paint);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f13);
        canvas.drawCircle(f10, f11, f14 + fE, paint);
        if (iI0 != 1122867) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(iI0);
            canvas.drawCircle(f10, f11, fE, paint);
        }
    }
}
