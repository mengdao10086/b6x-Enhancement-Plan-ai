package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends l {
    public k(ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
    }

    public final boolean o() {
        return xa.k.C() >= 18;
    }

    public void p(Canvas canvas, Path path, int i10, int i11) {
        int i12 = (i10 & 16777215) | (i11 << 24);
        if (o()) {
            int iSave = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i12);
            canvas.restoreToCount(iSave);
            return;
        }
        Paint.Style style = this.f52836c.getStyle();
        int color = this.f52836c.getColor();
        this.f52836c.setStyle(Paint.Style.FILL);
        this.f52836c.setColor(i12);
        canvas.drawPath(path, this.f52836c);
        this.f52836c.setColor(color);
        this.f52836c.setStyle(style);
    }

    public void q(Canvas canvas, Path path, Drawable drawable) {
        if (!o()) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + xa.k.C() + j3.b.f36044h);
        }
        int iSave = canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.f52889a.h(), (int) this.f52889a.j(), (int) this.f52889a.i(), (int) this.f52889a.f());
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
