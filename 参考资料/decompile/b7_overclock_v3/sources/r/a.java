package r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import g.v0;
import r.g;

/* JADX INFO: loaded from: classes2.dex */
@v0(17)
public class a extends c {

    /* JADX INFO: renamed from: r.a$a, reason: collision with other inner class name */
    public class C0548a implements g.a {
        public C0548a() {
        }

        @Override // r.g.a
        public void a(Canvas canvas, RectF rectF, float f10, Paint paint) {
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
    }

    @Override // r.c, r.e
    public void l() {
        g.f47661s = new C0548a();
    }
}
