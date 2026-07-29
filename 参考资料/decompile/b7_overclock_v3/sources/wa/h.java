package wa;

import android.graphics.Canvas;
import android.graphics.Paint;
import qa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class h implements e {
    @Override // wa.e
    public void a(Canvas canvas, k kVar, l lVar, float f10, float f11, Paint paint) {
        float fR0 = kVar.r0() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(xa.k.e(1.0f));
        float f12 = f10 - fR0;
        float f13 = f11 - fR0;
        float f14 = f10 + fR0;
        float f15 = fR0 + f11;
        canvas.drawLine(f12, f13, f14, f15, paint);
        canvas.drawLine(f14, f13, f12, f15, paint);
    }
}
