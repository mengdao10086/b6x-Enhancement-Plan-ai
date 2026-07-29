package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class t extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public YAxis f52903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f52904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Path f52905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f52906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f52907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Path f52908m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f52909n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f52910o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f52911p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RectF f52912q;

    public t(xa.l lVar, YAxis yAxis, xa.i iVar) {
        super(lVar, iVar, yAxis);
        this.f52905j = new Path();
        this.f52906k = new RectF();
        this.f52907l = new float[2];
        this.f52908m = new Path();
        this.f52909n = new RectF();
        this.f52910o = new Path();
        this.f52911p = new float[2];
        this.f52912q = new RectF();
        this.f52903h = yAxis;
        if (this.f52889a != null) {
            this.f52807e.setColor(-16777216);
            this.f52807e.setTextSize(xa.k.e(10.0f));
            Paint paint = new Paint(1);
            this.f52904i = paint;
            paint.setColor(-7829368);
            this.f52904i.setStrokeWidth(1.0f);
            this.f52904i.setStyle(Paint.Style.STROKE);
        }
    }

    @Override // va.a
    public void g(Canvas canvas) {
        float fI;
        float fI2;
        float f10;
        if (this.f52903h.f() && this.f52903h.P()) {
            float[] fArrN = n();
            this.f52807e.setTypeface(this.f52903h.c());
            this.f52807e.setTextSize(this.f52903h.b());
            this.f52807e.setColor(this.f52903h.a());
            float fD = this.f52903h.d();
            float fA = (xa.k.a(this.f52807e, i1.a.W4) / 2.5f) + this.f52903h.e();
            YAxis.AxisDependency axisDependencyV0 = this.f52903h.v0();
            YAxis.YAxisLabelPosition yAxisLabelPositionW0 = this.f52903h.w0();
            if (axisDependencyV0 == YAxis.AxisDependency.LEFT) {
                if (yAxisLabelPositionW0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f52807e.setTextAlign(Paint.Align.RIGHT);
                    fI = this.f52889a.P();
                    f10 = fI - fD;
                } else {
                    this.f52807e.setTextAlign(Paint.Align.LEFT);
                    fI2 = this.f52889a.P();
                    f10 = fI2 + fD;
                }
            } else if (yAxisLabelPositionW0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f52807e.setTextAlign(Paint.Align.LEFT);
                fI2 = this.f52889a.i();
                f10 = fI2 + fD;
            } else {
                this.f52807e.setTextAlign(Paint.Align.RIGHT);
                fI = this.f52889a.i();
                f10 = fI - fD;
            }
            k(canvas, f10, fArrN, fA);
        }
    }

    @Override // va.a
    public void h(Canvas canvas) {
        if (this.f52903h.f() && this.f52903h.M()) {
            this.f52808f.setColor(this.f52903h.s());
            this.f52808f.setStrokeWidth(this.f52903h.u());
            if (this.f52903h.v0() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f52889a.h(), this.f52889a.j(), this.f52889a.h(), this.f52889a.f(), this.f52808f);
            } else {
                canvas.drawLine(this.f52889a.i(), this.f52889a.j(), this.f52889a.i(), this.f52889a.f(), this.f52808f);
            }
        }
    }

    @Override // va.a
    public void i(Canvas canvas) {
        if (this.f52903h.f()) {
            if (this.f52903h.O()) {
                int iSave = canvas.save();
                canvas.clipRect(m());
                float[] fArrN = n();
                this.f52806d.setColor(this.f52903h.z());
                this.f52806d.setStrokeWidth(this.f52903h.B());
                this.f52806d.setPathEffect(this.f52903h.A());
                Path path = this.f52905j;
                path.reset();
                for (int i10 = 0; i10 < fArrN.length; i10 += 2) {
                    canvas.drawPath(o(path, i10, fArrN), this.f52806d);
                    path.reset();
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f52903h.H0()) {
                l(canvas);
            }
        }
    }

    @Override // va.a
    public void j(Canvas canvas) {
        List<LimitLine> listD = this.f52903h.D();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        float[] fArr = this.f52911p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.f52910o;
        path.reset();
        for (int i10 = 0; i10 < listD.size(); i10++) {
            LimitLine limitLine = listD.get(i10);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f52912q.set(this.f52889a.q());
                this.f52912q.inset(0.0f, -limitLine.t());
                canvas.clipRect(this.f52912q);
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
                    this.f52809g.setTypeface(limitLine.c());
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

    public void k(Canvas canvas, float f10, float[] fArr, float f11) {
        int i10 = this.f52903h.G0() ? this.f52903h.f37094n : this.f52903h.f37094n - 1;
        for (int i11 = !this.f52903h.F0() ? 1 : 0; i11 < i10; i11++) {
            canvas.drawText(this.f52903h.x(i11), f10, fArr[(i11 * 2) + 1] + f11, this.f52807e);
        }
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        this.f52909n.set(this.f52889a.q());
        this.f52909n.inset(0.0f, -this.f52903h.E0());
        canvas.clipRect(this.f52909n);
        xa.f fVarF = this.f52805c.f(0.0f, 0.0f);
        this.f52904i.setColor(this.f52903h.D0());
        this.f52904i.setStrokeWidth(this.f52903h.E0());
        Path path = this.f52908m;
        path.reset();
        path.moveTo(this.f52889a.h(), (float) fVarF.f54984d);
        path.lineTo(this.f52889a.i(), (float) fVarF.f54984d);
        canvas.drawPath(path, this.f52904i);
        canvas.restoreToCount(iSave);
    }

    public RectF m() {
        this.f52906k.set(this.f52889a.q());
        this.f52906k.inset(0.0f, -this.f52804b.B());
        return this.f52906k;
    }

    public float[] n() {
        int length = this.f52907l.length;
        int i10 = this.f52903h.f37094n;
        if (length != i10 * 2) {
            this.f52907l = new float[i10 * 2];
        }
        float[] fArr = this.f52907l;
        for (int i11 = 0; i11 < fArr.length; i11 += 2) {
            fArr[i11 + 1] = this.f52903h.f37092l[i11 / 2];
        }
        this.f52805c.o(fArr);
        return fArr;
    }

    public Path o(Path path, int i10, float[] fArr) {
        int i11 = i10 + 1;
        path.moveTo(this.f52889a.P(), fArr[i11]);
        path.lineTo(this.f52889a.i(), fArr[i11]);
        return path;
    }
}
