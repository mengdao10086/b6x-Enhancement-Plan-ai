package wa;

import android.graphics.Canvas;
import android.graphics.Paint;
import qa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class d implements e {
    @Override // wa.e
    public void a(Canvas canvas, k kVar, l lVar, float f10, float f11, Paint paint) {
        float fR0 = kVar.r0() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(xa.k.e(1.0f));
        canvas.drawLine(f10 - fR0, f11, f10 + fR0, f11, paint);
        canvas.drawLine(f10, f11 - fR0, f10, f11 + fR0, paint);
    }
}
