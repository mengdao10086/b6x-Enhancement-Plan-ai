package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class q extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public XAxis f52892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f52893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f52894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f52895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f52896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f52897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f52898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f52899o;

    public q(xa.l lVar, XAxis xAxis, xa.i iVar) {
        super(lVar, iVar, xAxis);
        this.f52893i = new Path();
        this.f52894j = new float[2];
        this.f52895k = new RectF();
        this.f52896l = new float[2];
        this.f52897m = new RectF();
        this.f52898n = new float[4];
        this.f52899o = new Path();
        this.f52892h = xAxis;
        this.f52807e.setColor(-16777216);
        this.f52807e.setTextAlign(Paint.Align.CENTER);
        this.f52807e.setTextSize(xa.k.e(10.0f));
    }

    @Override // va.a
    public void a(float f10, float f11, boolean z10) {
        float f12;
        double d10;
        if (this.f52889a.k() > 10.0f && !this.f52889a.E()) {
            xa.f fVarJ = this.f52805c.j(this.f52889a.h(), this.f52889a.j());
            xa.f fVarJ2 = this.f52805c.j(this.f52889a.i(), this.f52889a.j());
            if (z10) {
                f12 = (float) fVarJ2.f54983c;
                d10 = fVarJ.f54983c;
            } else {
                f12 = (float) fVarJ.f54983c;
                d10 = fVarJ2.f54983c;
            }
            xa.f.c(fVarJ);
            xa.f.c(fVarJ2);
            f10 = f12;
            f11 = (float) d10;
        }
        b(f10, f11);
    }

    @Override // va.a
    public void b(float f10, float f11) {
        super.b(f10, f11);
        k();
    }

    @Override // va.a
    public void g(Canvas canvas) {
        if (this.f52892h.f() && this.f52892h.P()) {
            float fE = this.f52892h.e();
            this.f52807e.setTypeface(this.f52892h.c());
            this.f52807e.setTextSize(this.f52892h.b());
            this.f52807e.setColor(this.f52892h.a());
            xa.g gVarC = xa.g.c(0.0f, 0.0f);
            if (this.f52892h.w0() == XAxis.XAxisPosition.TOP) {
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 1.0f;
                n(canvas, this.f52889a.j() - fE, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.TOP_INSIDE) {
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 1.0f;
                n(canvas, this.f52889a.j() + fE + this.f52892h.M, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM) {
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 0.0f;
                n(canvas, this.f52889a.f() + fE, gVarC);
            } else if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 0.0f;
                n(canvas, (this.f52889a.f() - fE) - this.f52892h.M, gVarC);
            } else {
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 1.0f;
                n(canvas, this.f52889a.j() - fE, gVarC);
                gVarC.f54987c = 0.5f;
                gVarC.f54988d = 0.0f;
                n(canvas, this.f52889a.f() + fE, gVarC);
            }
            xa.g.h(gVarC);
        }
    }

    @Override // va.a
    public void h(Canvas canvas) {
        if (this.f52892h.M() && this.f52892h.f()) {
            this.f52808f.setColor(this.f52892h.s());
            this.f52808f.setStrokeWidth(this.f52892h.u());
            this.f52808f.setPathEffect(this.f52892h.t());
            if (this.f52892h.w0() == XAxis.XAxisPosition.TOP || this.f52892h.w0() == XAxis.XAxisPosition.TOP_INSIDE || this.f52892h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f52889a.h(), this.f52889a.j(), this.f52889a.i(), this.f52889a.j(), this.f52808f);
            }
            if (this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM || this.f52892h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f52892h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f52889a.h(), this.f52889a.f(), this.f52889a.i(), this.f52889a.f(), this.f52808f);
            }
        }
    }

    @Override // va.a
    public void i(Canvas canvas) {
        if (this.f52892h.O() && this.f52892h.f()) {
            int iSave = canvas.save();
            canvas.clipRect(o());
            if (this.f52894j.length != this.f52804b.f37094n * 2) {
                this.f52894j = new float[this.f52892h.f37094n * 2];
            }
            float[] fArr = this.f52894j;
            for (int i10 = 0; i10 < fArr.length; i10 += 2) {
                float[] fArr2 = this.f52892h.f37092l;
                int i11 = i10 / 2;
                fArr[i10] = fArr2[i11];
                fArr[i10 + 1] = fArr2[i11];
            }
            this.f52805c.o(fArr);
            r();
            Path path = this.f52893i;
            path.reset();
            for (int i12 = 0; i12 < fArr.length; i12 += 2) {
                l(canvas, fArr[i12], fArr[i12 + 1], path);
            }
            canvas.restoreToCount(iSave);
        }
    }

    @Override // va.a
    public void j(Canvas canvas) {
        List<LimitLine> listD = this.f52892h.D();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        float[] fArr = this.f52896l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i10 = 0; i10 < listD.size(); i10++) {
            LimitLine limitLine = listD.get(i10);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f52897m.set(this.f52889a.q());
                this.f52897m.inset(-limitLine.t(), 0.0f);
                canvas.clipRect(this.f52897m);
                fArr[0] = limitLine.r();
                fArr[1] = 0.0f;
                this.f52805c.o(fArr);
                q(canvas, limitLine, fArr);
                p(canvas, limitLine, fArr, limitLine.e() + 2.0f);
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void k() {
        String strE = this.f52892h.E();
        this.f52807e.setTypeface(this.f52892h.c());
        this.f52807e.setTextSize(this.f52892h.b());
        xa.c cVarB = xa.k.b(this.f52807e, strE);
        float f10 = cVarB.f54979c;
        float fA = xa.k.a(this.f52807e, "Q");
        xa.c cVarD = xa.k.D(f10, fA, this.f52892h.v0());
        this.f52892h.J = Math.round(f10);
        this.f52892h.K = Math.round(fA);
        this.f52892h.L = Math.round(cVarD.f54979c);
        this.f52892h.M = Math.round(cVarD.f54980d);
        xa.c.c(cVarD);
        xa.c.c(cVarB);
    }

    public void l(Canvas canvas, float f10, float f11, Path path) {
        path.moveTo(f10, this.f52889a.f());
        path.lineTo(f10, this.f52889a.j());
        canvas.drawPath(path, this.f52806d);
        path.reset();
    }

    public void m(Canvas canvas, String str, float f10, float f11, xa.g gVar, float f12) {
        xa.k.n(canvas, str, f10, f11, this.f52807e, gVar, f12);
    }

    public void n(Canvas canvas, float f10, xa.g gVar) {
        float fV0 = this.f52892h.v0();
        boolean zL = this.f52892h.L();
        int i10 = this.f52892h.f37094n * 2;
        float[] fArr = new float[i10];
        for (int i11 = 0; i11 < i10; i11 += 2) {
            if (zL) {
                fArr[i11] = this.f52892h.f37093m[i11 / 2];
            } else {
                fArr[i11] = this.f52892h.f37092l[i11 / 2];
            }
        }
        this.f52805c.o(fArr);
        for (int i12 = 0; i12 < i10; i12 += 2) {
            float fD = fArr[i12];
            if (this.f52889a.L(fD)) {
                na.l lVarH = this.f52892h.H();
                XAxis xAxis = this.f52892h;
                int i13 = i12 / 2;
                String strC = lVarH.c(xAxis.f37092l[i13], xAxis);
                if (this.f52892h.x0()) {
                    int i14 = this.f52892h.f37094n;
                    if (i13 == i14 - 1 && i14 > 1) {
                        float fD2 = xa.k.d(this.f52807e, strC);
                        if (fD2 > this.f52889a.Q() * 2.0f && fD + fD2 > this.f52889a.o()) {
                            fD -= fD2 / 2.0f;
                        }
                    } else if (i12 == 0) {
                        fD += xa.k.d(this.f52807e, strC) / 2.0f;
                    }
                }
                m(canvas, strC, fD, f10, gVar, fV0);
            }
        }
    }

    public RectF o() {
        this.f52895k.set(this.f52889a.q());
        this.f52895k.inset(-this.f52804b.B(), 0.0f);
        return this.f52895k;
    }

    public void p(Canvas canvas, LimitLine limitLine, float[] fArr, float f10) {
        String strP = limitLine.p();
        if (strP == null || strP.equals("")) {
            return;
        }
        this.f52809g.setStyle(limitLine.u());
        this.f52809g.setPathEffect(null);
        this.f52809g.setColor(limitLine.a());
        this.f52809g.setStrokeWidth(0.5f);
        this.f52809g.setTextSize(limitLine.b());
        float fT = limitLine.t() + limitLine.d();
        LimitLine.LimitLabelPosition limitLabelPositionQ = limitLine.q();
        if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
            float fA = xa.k.a(this.f52809g, strP);
            this.f52809g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strP, fArr[0] + fT, this.f52889a.j() + f10 + fA, this.f52809g);
        } else if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
            this.f52809g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strP, fArr[0] + fT, this.f52889a.f() - f10, this.f52809g);
        } else if (limitLabelPositionQ != LimitLine.LimitLabelPosition.LEFT_TOP) {
            this.f52809g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strP, fArr[0] - fT, this.f52889a.f() - f10, this.f52809g);
        } else {
            this.f52809g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strP, fArr[0] - fT, this.f52889a.j() + f10 + xa.k.a(this.f52809g, strP), this.f52809g);
        }
    }

    public void q(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f52898n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f52889a.j();
        float[] fArr3 = this.f52898n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f52889a.f();
        this.f52899o.reset();
        Path path = this.f52899o;
        float[] fArr4 = this.f52898n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.f52899o;
        float[] fArr5 = this.f52898n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f52809g.setStyle(Paint.Style.STROKE);
        this.f52809g.setColor(limitLine.s());
        this.f52809g.setStrokeWidth(limitLine.t());
        this.f52809g.setPathEffect(limitLine.o());
        canvas.drawPath(this.f52899o, this.f52809g);
    }

    public void r() {
        this.f52806d.setColor(this.f52892h.z());
        this.f52806d.setStrokeWidth(this.f52892h.B());
        this.f52806d.setPathEffect(this.f52892h.A());
    }
}
