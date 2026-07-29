package ge;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends j<g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f29279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f29280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f29281f;

    public d(@n0 g gVar) {
        super(gVar);
        this.f29278c = 1;
    }

    @Override // ge.j
    public void a(@n0 Canvas canvas, @n0 Rect rect, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        float fWidth = rect.width() / e();
        float fHeight = rect.height() / d();
        S s10 = this.f29338a;
        float f11 = (((g) s10).f29308g / 2.0f) + ((g) s10).f29309h;
        canvas.translate((f11 * fWidth) + rect.left, (f11 * fHeight) + rect.top);
        canvas.scale(fWidth, fHeight);
        canvas.rotate(-90.0f);
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        this.f29278c = ((g) this.f29338a).f29310i == 0 ? 1 : -1;
        this.f29279d = ((g) r8).f29272a * f10;
        this.f29280e = ((g) r8).f29273b * f10;
        this.f29281f = (((g) r8).f29308g - ((g) r8).f29272a) / 2.0f;
        if ((this.f29339b.n() && ((g) this.f29338a).f29276e == 2) || (this.f29339b.m() && ((g) this.f29338a).f29277f == 1)) {
            this.f29281f += ((1.0f - f10) * ((g) this.f29338a).f29272a) / 2.0f;
        } else if ((this.f29339b.n() && ((g) this.f29338a).f29276e == 1) || (this.f29339b.m() && ((g) this.f29338a).f29277f == 2)) {
            this.f29281f -= ((1.0f - f10) * ((g) this.f29338a).f29272a) / 2.0f;
        }
    }

    @Override // ge.j
    public void b(@n0 Canvas canvas, @n0 Paint paint, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @g.l int i10) {
        if (f10 == f11) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.f29279d);
        int i11 = this.f29278c;
        float f12 = f10 * 360.0f * i11;
        float f13 = (f11 >= f10 ? f11 - f10 : (1.0f + f11) - f10) * 360.0f * i11;
        float f14 = this.f29281f;
        canvas.drawArc(new RectF(-f14, -f14, f14, f14), f12, f13, false, paint);
        if (this.f29280e <= 0.0f || Math.abs(f13) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        h(canvas, paint, this.f29279d, this.f29280e, f12);
        h(canvas, paint, this.f29279d, this.f29280e, f12 + f13);
    }

    @Override // ge.j
    public void c(@n0 Canvas canvas, @n0 Paint paint) {
        int iA = vd.m.a(((g) this.f29338a).f29275d, this.f29339b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        paint.setStrokeWidth(this.f29279d);
        float f10 = this.f29281f;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), 0.0f, 360.0f, false, paint);
    }

    @Override // ge.j
    public int d() {
        return i();
    }

    @Override // ge.j
    public int e() {
        return i();
    }

    public final void h(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        canvas.save();
        canvas.rotate(f12);
        float f13 = this.f29281f;
        float f14 = f10 / 2.0f;
        canvas.drawRoundRect(new RectF(f13 - f14, f11, f13 + f14, -f11), f11, f11, paint);
        canvas.restore();
    }

    public final int i() {
        S s10 = this.f29338a;
        return ((g) s10).f29308g + (((g) s10).f29309h * 2);
    }
}
