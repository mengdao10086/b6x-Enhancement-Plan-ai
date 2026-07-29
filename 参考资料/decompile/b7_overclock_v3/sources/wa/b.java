package wa;

import android.graphics.Canvas;
import android.graphics.Paint;
import qa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class b implements e {
    @Override // wa.e
    public void a(Canvas canvas, k kVar, l lVar, float f10, float f11, Paint paint) {
        float fR0 = kVar.r0() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(xa.k.e(1.0f));
        float f12 = fR0 * 2.0f;
        float f13 = f11 - f12;
        canvas.drawLine(f10, f13, f10 + f12, f11, paint);
        canvas.drawLine(f10, f13, f10 - f12, f11, paint);
    }
}
