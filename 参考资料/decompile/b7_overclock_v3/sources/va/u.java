package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class u extends t {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Path f52913r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Path f52914s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float[] f52915t;

    public u(xa.l lVar, YAxis yAxis, xa.i iVar) {
        super(lVar, yAxis, iVar);
        this.f52913r = new Path();
        this.f52914s = new Path();
        this.f52915t = new float[4];
        this.f52809g.setTextAlign(Paint.Align.LEFT);
    }

    @Override // va.a
    public void a(float f10, float f11, boolean z10) {
        float f12;
        double d10;
        if (this.f52889a.g() > 10.0f && !this.f52889a.E()) {
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

    @Override // va.t, va.a
    public void g(Canvas canvas) {
        float f10;
        if (this.f52903h.f() && this.f52903h.P()) {
            float[] fArrN = n();
            this.f52807e.setTypeface(this.f52903h.c());
            this.f52807e.setTextSize(this.f52903h.b());
            this.f52807e.setColor(this.f52903h.a());
            this.f52807e.setTextAlign(Paint.Align.CENTER);
            float fE = xa.k.e(2.5f);
            float fA = xa.k.a(this.f52807e, "Q");
            YAxis.AxisDependency axisDependencyV0 = this.f52903h.v0();
            YAxis.YAxisLabelPosition yAxisLabelPositionW0 = this.f52903h.w0();
            if (axisDependencyV0 == YAxis.AxisDependency.LEFT) {
                f10 = (yAxisLabelPositionW0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f52889a.j() : this.f52889a.j()) - fE;
            } else {
                f10 = (yAxisLabelPositionW0 == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f52889a.f() : this.f52889a.f()) + fA + fE;
            }
            k(canvas, f10, fArrN, this.f52903h.e());
        }
    }

    @Override // va.t, va.a
    public void h(Canvas canvas) {
        if (this.f52903h.f() && this.f52903h.M()) {
            this.f52808f.setColor(this.f52903h.s());
            this.f52808f.setStrokeWidth(this.f52903h.u());
            if (this.f52903h.v0() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f52889a.h(), this.f52889a.j(), this.f52889a.i(), this.f52889a.j(), this.f52808f);
            } else {
                canvas.drawLine(this.f52889a.h(), this.f52889a.f(), this.f52889a.i(), this.f52889a.f(), this.f52808f);
            }
        }
    }

    @Override // va.t, va.a
    public void j(Canvas canvas) {
        List<LimitLine> listD = this.f52903h.D();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        float[] fArr = this.f52915t;
        float f10 = 0.0f;
        fArr[0] = 0.0f;
        char c10 = 1;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.f52914s;
        path.reset();
        int i10 = 0;
        while (i10 < listD.size()) {
            LimitLine limitLine = listD.get(i10);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f52912q.set(this.f52889a.q());
                this.f52912q.inset(-limitLine.t(), f10);
                canvas.clipRect(this.f52912q);
                fArr[0] = limitLine.r();
                fArr[2] = limitLine.r();
                this.f52805c.o(fArr);
                fArr[c10] = this.f52889a.j();
                fArr[3] = this.f52889a.f();
                path.moveTo(fArr[0], fArr[c10]);
                path.lineTo(fArr[2], fArr[3]);
                this.f52809g.setStyle(Paint.Style.STROKE);
                this.f52809g.setColor(limitLine.s());
                this.f52809g.setPathEffect(limitLine.o());
                this.f52809g.setStrokeWidth(limitLine.t());
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
                    float fT = limitLine.t() + limitLine.d();
                    float fE = xa.k.e(2.0f) + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionQ = limitLine.q();
                    if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float fA = xa.k.a(this.f52809g, strP);
                        this.f52809g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strP, fArr[0] + fT, this.f52889a.j() + fE + fA, this.f52809g);
                    } else if (limitLabelPositionQ == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f52809g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strP, fArr[0] + fT, this.f52889a.f() - fE, this.f52809g);
                    } else if (limitLabelPositionQ == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f52809g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strP, fArr[0] - fT, this.f52889a.j() + fE + xa.k.a(this.f52809g, strP), this.f52809g);
                    } else {
                        this.f52809g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strP, fArr[0] - fT, this.f52889a.f() - fE, this.f52809g);
                    }
                }
                canvas.restoreToCount(iSave);
            }
            i10++;
            f10 = 0.0f;
            c10 = 1;
        }
    }

    @Override // va.t
    public void k(Canvas canvas, float f10, float[] fArr, float f11) {
        this.f52807e.setTypeface(this.f52903h.c());
        this.f52807e.setTextSize(this.f52903h.b());
        this.f52807e.setColor(this.f52903h.a());
        int i10 = this.f52903h.G0() ? this.f52903h.f37094n : this.f52903h.f37094n - 1;
        for (int i11 = !this.f52903h.F0() ? 1 : 0; i11 < i10; i11++) {
            canvas.drawText(this.f52903h.x(i11), fArr[i11 * 2], f10 - f11, this.f52807e);
        }
    }

    @Override // va.t
    public void l(Canvas canvas) {
        int iSave = canvas.save();
        this.f52909n.set(this.f52889a.q());
        this.f52909n.inset(-this.f52903h.E0(), 0.0f);
        canvas.clipRect(this.f52912q);
        xa.f fVarF = this.f52805c.f(0.0f, 0.0f);
        this.f52904i.setColor(this.f52903h.D0());
        this.f52904i.setStrokeWidth(this.f52903h.E0());
        Path path = this.f52913r;
        path.reset();
        path.moveTo(((float) fVarF.f54983c) - 1.0f, this.f52889a.j());
        path.lineTo(((float) fVarF.f54983c) - 1.0f, this.f52889a.f());
        canvas.drawPath(path, this.f52904i);
        canvas.restoreToCount(iSave);
    }

    @Override // va.t
    public RectF m() {
        this.f52906k.set(this.f52889a.q());
        this.f52906k.inset(-this.f52804b.B(), 0.0f);
        return this.f52906k;
    }

    @Override // va.t
    public float[] n() {
        int length = this.f52907l.length;
        int i10 = this.f52903h.f37094n;
        if (length != i10 * 2) {
            this.f52907l = new float[i10 * 2];
        }
        float[] fArr = this.f52907l;
        for (int i11 = 0; i11 < fArr.length; i11 += 2) {
            fArr[i11] = this.f52903h.f37092l[i11 / 2];
        }
        this.f52805c.o(fArr);
        return fArr;
    }

    @Override // va.t
    public Path o(Path path, int i10, float[] fArr) {
        path.moveTo(fArr[i10], this.f52889a.j());
        path.lineTo(fArr[i10], this.f52889a.f());
        return path;
    }
}
