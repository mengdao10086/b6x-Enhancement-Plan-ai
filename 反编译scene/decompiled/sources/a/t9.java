package a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t9 implements y9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u9 f7478a;

    public t9(u9 u9Var) {
        this.f7478a = u9Var;
    }

    @Override // a.y9
    public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
        float f2 = 2.0f * f;
        float fWidth = (rectF.width() - f2) - 1.0f;
        float fHeight = (rectF.height() - f2) - 1.0f;
        if (f >= 1.0f) {
            float f3 = f + 0.5f;
            float f4 = -f3;
            this.f7478a.f7576a.set(f4, f4, f3, f3);
            int iSave = canvas.save();
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawArc(this.f7478a.f7576a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f7478a.f7576a, 180.0f, 90.0f, true, paint);
            canvas.translate(fHeight, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f7478a.f7576a, 180.0f, 90.0f, true, paint);
            canvas.translate(fWidth, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.f7478a.f7576a, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(iSave);
            float f5 = (rectF.left + f3) - 1.0f;
            float f6 = rectF.top;
            canvas.drawRect(f5, f6, (rectF.right - f3) + 1.0f, f6 + f3, paint);
            float f7 = (rectF.left + f3) - 1.0f;
            float f8 = rectF.bottom;
            canvas.drawRect(f7, f8 - f3, (rectF.right - f3) + 1.0f, f8, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
    }
}
