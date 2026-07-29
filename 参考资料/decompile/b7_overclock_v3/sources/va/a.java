package va;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ka.a f52804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xa.i f52805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f52806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f52807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f52808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f52809g;

    public a(xa.l lVar, xa.i iVar, ka.a aVar) {
        super(lVar);
        this.f52805c = iVar;
        this.f52804b = aVar;
        if (this.f52889a != null) {
            this.f52807e = new Paint(1);
            Paint paint = new Paint();
            this.f52806d = paint;
            paint.setColor(-7829368);
            this.f52806d.setStrokeWidth(1.0f);
            this.f52806d.setStyle(Paint.Style.STROKE);
            this.f52806d.setAlpha(90);
            Paint paint2 = new Paint();
            this.f52808f = paint2;
            paint2.setColor(-16777216);
            this.f52808f.setStrokeWidth(1.0f);
            this.f52808f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.f52809g = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void a(float f10, float f11, boolean z10) {
        float f12;
        double d10;
        xa.l lVar = this.f52889a;
        if (lVar != null && lVar.k() > 10.0f && !this.f52889a.F()) {
            xa.f fVarJ = this.f52805c.j(this.f52889a.h(), this.f52889a.j());
            xa.f fVarJ2 = this.f52805c.j(this.f52889a.h(), this.f52889a.f());
            if (z10) {
                f12 = (float) fVarJ.f54984d;
                d10 = fVarJ2.f54984d;
            } else {
                f12 = (float) fVarJ2.f54984d;
                d10 = fVarJ.f54984d;
            }
            xa.f.c(fVarJ);
            xa.f.c(fVarJ2);
            f10 = f12;
            f11 = (float) d10;
        }
        b(f10, f11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void b(float f10, float f11) {
        float f12 = f10;
        int iC = this.f52804b.C();
        double dAbs = Math.abs(f11 - f12);
        if (iC == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            ka.a aVar = this.f52804b;
            aVar.f37092l = new float[0];
            aVar.f37093m = new float[0];
            aVar.f37094n = 0;
            return;
        }
        double dL = xa.k.L(dAbs / ((double) iC));
        if (this.f52804b.S() && dL < this.f52804b.y()) {
            dL = this.f52804b.y();
        }
        double dL2 = xa.k.L(Math.pow(10.0d, (int) Math.log10(dL)));
        if (((int) (dL / dL2)) > 5) {
            dL = Math.floor(dL2 * 10.0d);
        }
        int iL = this.f52804b.L();
        if (this.f52804b.R()) {
            dL = ((float) dAbs) / (iC - 1);
            ka.a aVar2 = this.f52804b;
            aVar2.f37094n = iC;
            if (aVar2.f37092l.length < iC) {
                aVar2.f37092l = new float[iC];
            }
            for (int i10 = 0; i10 < iC; i10++) {
                this.f52804b.f37092l[i10] = f12;
                f12 = (float) (((double) f12) + dL);
            }
        } else {
            double dCeil = dL == 0.0d ? 0.0d : Math.ceil(((double) f12) / dL) * dL;
            if (this.f52804b.L()) {
                dCeil -= dL;
            }
            double dJ = dL == 0.0d ? 0.0d : xa.k.J(Math.floor(((double) f11) / dL) * dL);
            if (dL != 0.0d) {
                double d10 = dCeil;
                iL = iL;
                while (d10 <= dJ) {
                    d10 += dL;
                    iL++;
                }
            }
            ka.a aVar3 = this.f52804b;
            aVar3.f37094n = iL;
            if (aVar3.f37092l.length < iL) {
                aVar3.f37092l = new float[iL];
            }
            for (int i11 = 0; i11 < iL; i11++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.f52804b.f37092l[i11] = (float) dCeil;
                dCeil += dL;
            }
            iC = iL;
        }
        if (dL < 1.0d) {
            this.f52804b.f37095o = (int) Math.ceil(-Math.log10(dL));
        } else {
            this.f52804b.f37095o = 0;
        }
        if (this.f52804b.L()) {
            ka.a aVar4 = this.f52804b;
            if (aVar4.f37093m.length < iC) {
                aVar4.f37093m = new float[iC];
            }
            float f13 = ((float) dL) / 2.0f;
            for (int i12 = 0; i12 < iC; i12++) {
                ka.a aVar5 = this.f52804b;
                aVar5.f37093m[i12] = aVar5.f37092l[i12] + f13;
            }
        }
    }

    public Paint c() {
        return this.f52807e;
    }

    public Paint d() {
        return this.f52808f;
    }

    public Paint e() {
        return this.f52806d;
    }

    public xa.i f() {
        return this.f52805c;
    }

    public abstract void g(Canvas canvas);

    public abstract void h(Canvas canvas);

    public abstract void i(Canvas canvas);

    public abstract void j(Canvas canvas);
}
