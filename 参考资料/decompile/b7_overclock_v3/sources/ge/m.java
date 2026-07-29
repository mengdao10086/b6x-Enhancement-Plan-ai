package ge;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends j<q> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f29345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f29346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f29347e;

    public m(@n0 q qVar) {
        super(qVar);
        this.f29345c = 300.0f;
    }

    @Override // ge.j
    public void a(@n0 Canvas canvas, @n0 Rect rect, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f29345c = rect.width();
        float f11 = ((q) this.f29338a).f29272a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - ((q) this.f29338a).f29272a) / 2.0f));
        if (((q) this.f29338a).f29377i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f29339b.n() && ((q) this.f29338a).f29276e == 1) || (this.f29339b.m() && ((q) this.f29338a).f29277f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f29339b.n() || this.f29339b.m()) {
            canvas.translate(0.0f, (((q) this.f29338a).f29272a * (f10 - 1.0f)) / 2.0f);
        }
        float f12 = this.f29345c;
        canvas.clipRect((-f12) / 2.0f, (-f11) / 2.0f, f12 / 2.0f, f11 / 2.0f);
        S s10 = this.f29338a;
        this.f29346d = ((q) s10).f29272a * f10;
        this.f29347e = ((q) s10).f29273b * f10;
    }

    @Override // ge.j
    public void b(@n0 Canvas canvas, @n0 Paint paint, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @g.l int i10) {
        if (f10 == f11) {
            return;
        }
        float f12 = this.f29345c;
        float f13 = this.f29347e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i10);
        float f14 = this.f29346d;
        RectF rectF = new RectF(((-f12) / 2.0f) + (f10 * (f12 - (f13 * 2.0f))), (-f14) / 2.0f, ((-f12) / 2.0f) + (f11 * (f12 - (f13 * 2.0f))) + (f13 * 2.0f), f14 / 2.0f);
        float f15 = this.f29347e;
        canvas.drawRoundRect(rectF, f15, f15, paint);
    }

    @Override // ge.j
    public void c(@n0 Canvas canvas, @n0 Paint paint) {
        int iA = vd.m.a(((q) this.f29338a).f29275d, this.f29339b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        float f10 = this.f29345c;
        float f11 = this.f29346d;
        RectF rectF = new RectF((-f10) / 2.0f, (-f11) / 2.0f, f10 / 2.0f, f11 / 2.0f);
        float f12 = this.f29347e;
        canvas.drawRoundRect(rectF, f12, f12, paint);
    }

    @Override // ge.j
    public int d() {
        return ((q) this.f29338a).f29272a;
    }

    @Override // ge.j
    public int e() {
        return -1;
    }
}
