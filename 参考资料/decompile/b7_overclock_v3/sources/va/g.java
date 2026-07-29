package va;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ha.a f52835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f52836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f52837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f52838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f52839f;

    public g(ha.a aVar, xa.l lVar) {
        super(lVar);
        this.f52835b = aVar;
        Paint paint = new Paint(1);
        this.f52836c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52838e = new Paint(4);
        Paint paint2 = new Paint(1);
        this.f52839f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f52839f.setTextAlign(Paint.Align.CENTER);
        this.f52839f.setTextSize(xa.k.e(9.0f));
        Paint paint3 = new Paint(1);
        this.f52837d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f52837d.setStrokeWidth(2.0f);
        this.f52837d.setColor(Color.rgb(255, mb.e.f41031i2, 115));
    }

    public void a(qa.e eVar) {
        this.f52839f.setTypeface(eVar.m0());
        this.f52839f.setTextSize(eVar.U());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public abstract void d(Canvas canvas, oa.d[] dVarArr);

    public abstract void e(Canvas canvas, String str, float f10, float f11, int i10);

    public abstract void f(Canvas canvas);

    public Paint g() {
        return this.f52837d;
    }

    public Paint h() {
        return this.f52836c;
    }

    public Paint i() {
        return this.f52839f;
    }

    public abstract void j();

    public boolean k(pa.e eVar) {
        return ((float) eVar.getData().r()) < ((float) eVar.getMaxVisibleCount()) * this.f52889a.w();
    }
}
