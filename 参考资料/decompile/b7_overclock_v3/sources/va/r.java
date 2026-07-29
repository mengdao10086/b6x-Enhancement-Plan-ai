package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class r extends q {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ja.a f52900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f52901q;

    public r(xa.l lVar, XAxis xAxis, xa.i iVar, ja.a aVar) {
        super(lVar, xAxis, iVar);
        this.f52901q = new Path();
        this.f52900p = aVar;
    }

    @Override // va.q, va.a
    public void a(float f10, float f11, boolean z10) {
        float f12;
        double d10;
        if (this.f52889a.k() > 10.0f && !this.f52889a.F()) {
            xa.f fVarJ = this.f52805c.j(this.f52889a.h(), this.f52889a.f());
            xa.f fVarJ2 = this.f52805c.j(this.f52889a.h(), this.f52889a.j());
            if (z10) {
                f12 = (float) fVarJ2.f54984d;
                d10 = fVarJ.f54984d;
            } else {
                f12 = (float) fVarJ.f54984d;
                d10 = fVarJ2.f54984d;
            }
            xa.f.c(fVarJ);
            xa.f.c(fVarJ2);
            f10 = f12;
            f11 = (float) d10;
        }
        b(f10, f11);
    }

    @Override // va.q, va.a
    public void g(Canvas canvas) {
        if (this.f52892h.f() && this.f52892h.P()) {
            float fD = this.f52892h.d();
            this.f52807e.setTypeface(this.f52892h.c());
            this.f52807e.setTextSize(this.f52892h.b());
            this.f52807e.setColor(this.f52892h.a());
            xa.g gVarC = xa.g.c(0.0f, 0.0f);
            if (this.f52892h.w0() == XAxis.XAxisPosition.TOP) {
                gVarC.f54987c = 0.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.i() + fD, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.TOP_INSIDE) {
                gVarC.f54987c = 1.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.i() - fD, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM) {
                gVarC.f54987c = 1.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.h() - fD, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                gVarC.f54987c = 1.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.h() + fD, gVarC);
            } else {
                gVarC.f54987c = 0.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.i() + fD, gVarC);
                gVarC.f54987c = 1.0f;
                gVarC.f54988d = 0.5f;
                n(canvas, this.f52889a.h() - fD, gVarC);
            }
            xa.g.h(gVarC);
        }
    }

    @Override // va.q, va.a
    public void h(Canvas canvas) {
        if (this.f52892h.M() && this.f52892h.f()) {
            this.f52808f.setColor(this.f52892h.s());
            this.f52808f.setStrokeWidth(this.f52892h.u());
            if (this.f52892h.w0() == XAxis.XAxisPosition.TOP || this.f52892h.w0() == XAxis.XAxisPosition.TOP_INSIDE || this.f52892h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f52889a.i(), this.f52889a.j(), this.f52889a.i(), this.f52889a.f(), this.f52808f);
            }
            if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM || this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f52892h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f52889a.h(), this.f52889a.j(), this.f52889a.h(), this.f52889a.f(), this.f52808f);
            }
        }
    }

    @Override // va.q, va.a
    public void j(Canvas canvas) {
        List<LimitLine> listD = this.f52892h.D();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        float[] fArr = this.f52896l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.f52901q;
        path.reset();
        for (int i10 = 0; i10 < listD.size(); i10++) {
            LimitLine limitLine = listD.get(i10);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f52897m.set(this.f52889a.q());
                this.f52897m.inset(0.0f, -limitLine.t());
                canvas.clipRect(this.f52897m);
                this.f52809g.setStyle(Paint.Style.STROKE);
                this.f52809g.setColor(limitLine.s());
                this.f52809g.setStrokeWidth(limitLine.t());
                this.f52809g.setPathEffect(limitLine.o());
                fArr[1] = limitLine.r();
                this.f52805c.o(fArr);
                path.moveTo(this.f52889a.h(), fArr[1]);
                path.lineTo(this.f52889a.i(), fArr[1]);
                canvas.drawPath(path, this.f52809g);
                path.reset();
                String strP = limitLine.p();
                if (strP != null && !strP.equals("")) {
                    this.f52809g.setStyle(limitLine.u());
                    this.f52809g.setPathEffect(null);
                    this.f52809g.setColor(limitLine.a());
                    this.f52809g.setStrokeWidth(0.5f);
                    this.f52809g.setTextSize(limitLine.b());
                    float fA = xa.k.a(this.f52809g, strP);
                    float fE = xa.k.e(4.0f) + limitLine.d();
                    float fT = limitLine.t() + fA + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionQ = limitLine.q();
                    if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.f52809g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strP, this.f52889a.i() - fE, (fArr[1] - fT) + fA, this.f52809g);
                    } else if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f52809g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strP, this.f52889a.i() - fE, fArr[1] + fT, this.f52809g);
                    } else if (limitLabelPositionQ == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f52809g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strP, this.f52889a.h() + fE, (fArr[1] - fT) + fA, this.f52809g);
                    } else {
                        this.f52809g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strP, this.f52889a.P() + fE, fArr[1] + fT, this.f52809g);
                    }
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // va.q
    public void k() {
        this.f52807e.setTypeface(this.f52892h.c());
        this.f52807e.setTextSize(this.f52892h.b());
        xa.c cVarB = xa.k.b(this.f52807e, this.f52892h.E());
        float fD = (int) (cVarB.f54979c + (this.f52892h.d() * 3.5f));
        float f10 = cVarB.f54980d;
        xa.c cVarD = xa.k.D(cVarB.f54979c, f10, this.f52892h.v0());
        this.f52892h.J = Math.round(fD);
        this.f52892h.K = Math.round(f10);
        XAxis xAxis = this.f52892h;
        xAxis.L = (int) (cVarD.f54979c + (xAxis.d() * 3.5f));
        this.f52892h.M = Math.round(cVarD.f54980d);
        xa.c.c(cVarD);
    }

    @Override // va.q
    public void l(Canvas canvas, float f10, float f11, Path path) {
        path.moveTo(this.f52889a.i(), f11);
        path.lineTo(this.f52889a.h(), f11);
        canvas.drawPath(path, this.f52806d);
        path.reset();
    }

    @Override // va.q
    public void n(Canvas canvas, float f10, xa.g gVar) {
        float fV0 = this.f52892h.v0();
        boolean zL = this.f52892h.L();
        int i10 = this.f52892h.f37094n * 2;
        float[] fArr = new float[i10];
        for (int i11 = 0; i11 < i10; i11 += 2) {
            if (zL) {
                fArr[i11 + 1] = this.f52892h.f37093m[i11 / 2];
            } else {
                fArr[i11 + 1] = this.f52892h.f37092l[i11 / 2];
            }
        }
        this.f52805c.o(fArr);
        for (int i12 = 0; i12 < i10; i12 += 2) {
            float f11 = fArr[i12 + 1];
            if (this.f52889a.M(f11)) {
                na.l lVarH = this.f52892h.H();
                XAxis xAxis = this.f52892h;
                m(canvas, lVarH.c(xAxis.f37092l[i12 / 2], xAxis), f10, f11, gVar, fV0);
            }
        }
    }

    @Override // va.q
    public RectF o() {
        this.f52895k.set(this.f52889a.q());
        this.f52895k.inset(0.0f, -this.f52804b.B());
        return this.f52895k;
    }
}
