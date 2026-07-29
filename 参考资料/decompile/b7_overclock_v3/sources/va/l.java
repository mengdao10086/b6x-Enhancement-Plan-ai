package va;

import android.graphics.Canvas;
import android.graphics.Path;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f52866h;

    public l(ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52866h = new Path();
    }

    public void n(Canvas canvas, float f10, float f11, qa.h hVar) {
        this.f52837d.setColor(hVar.Y0());
        this.f52837d.setStrokeWidth(hVar.K());
        this.f52837d.setPathEffect(hVar.w0());
        if (hVar.j1()) {
            this.f52866h.reset();
            this.f52866h.moveTo(f10, this.f52889a.j());
            this.f52866h.lineTo(f10, this.f52889a.f());
            canvas.drawPath(this.f52866h, this.f52837d);
        }
        if (hVar.n1()) {
            this.f52866h.reset();
            this.f52866h.moveTo(this.f52889a.h(), f11);
            this.f52866h.lineTo(this.f52889a.i(), f11);
            canvas.drawPath(this.f52866h, this.f52837d);
        }
    }
}
