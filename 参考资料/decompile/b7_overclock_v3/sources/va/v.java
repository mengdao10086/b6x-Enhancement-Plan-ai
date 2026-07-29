package va;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class v extends t {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ja.i f52916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Path f52917s;

    public v(xa.l lVar, YAxis yAxis, ja.i iVar) {
        super(lVar, yAxis, null);
        this.f52917s = new Path();
        this.f52916r = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // va.a
    public void b(float f10, float f11) {
        ?? r52;
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
        boolean zL = this.f52804b.L();
        if (this.f52804b.R()) {
            float f13 = ((float) dAbs) / (iC - 1);
            ka.a aVar2 = this.f52804b;
            aVar2.f37094n = iC;
            if (aVar2.f37092l.length < iC) {
                aVar2.f37092l = new float[iC];
            }
            for (int i10 = 0; i10 < iC; i10++) {
                this.f52804b.f37092l[i10] = f12;
                f12 += f13;
            }
        } else {
            double dCeil = dL == 0.0d ? 0.0d : Math.ceil(((double) f12) / dL) * dL;
            if (zL) {
                dCeil -= dL;
            }
            double dJ = dL == 0.0d ? 0.0d : xa.k.J(Math.floor(((double) f11) / dL) * dL);
            if (dL != 0.0d) {
                double d10 = dCeil;
                r52 = zL;
                while (d10 <= dJ) {
                    d10 += dL;
                    r52 = (r52 == true ? 1 : 0) + 1;
                }
            } else {
                r52 = zL;
            }
            int i11 = r52 + 1;
            ka.a aVar3 = this.f52804b;
            aVar3.f37094n = i11;
            if (aVar3.f37092l.length < i11) {
                aVar3.f37092l = new float[i11];
            }
            for (int i12 = 0; i12 < i11; i12++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.f52804b.f37092l[i12] = (float) dCeil;
                dCeil += dL;
            }
            iC = i11;
        }
        if (dL < 1.0d) {
            this.f52804b.f37095o = (int) Math.ceil(-Math.log10(dL));
        } else {
            this.f52804b.f37095o = 0;
        }
        if (zL) {
            ka.a aVar4 = this.f52804b;
            if (aVar4.f37093m.length < iC) {
                aVar4.f37093m = new float[iC];
            }
            float[] fArr = aVar4.f37092l;
            float f14 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i13 = 0; i13 < iC; i13++) {
                ka.a aVar5 = this.f52804b;
                aVar5.f37093m[i13] = aVar5.f37092l[i13] + f14;
            }
        }
        ka.a aVar6 = this.f52804b;
        float[] fArr2 = aVar6.f37092l;
        float f15 = fArr2[0];
        aVar6.H = f15;
        float f16 = fArr2[iC - 1];
        aVar6.G = f16;
        aVar6.I = Math.abs(f16 - f15);
    }

    @Override // va.t, va.a
    public void g(Canvas canvas) {
        if (this.f52903h.f() && this.f52903h.P()) {
            this.f52807e.setTypeface(this.f52903h.c());
            this.f52807e.setTextSize(this.f52903h.b());
            this.f52807e.setColor(this.f52903h.a());
            xa.g centerOffsets = this.f52916r.getCenterOffsets();
            xa.g gVarC = xa.g.c(0.0f, 0.0f);
            float factor = this.f52916r.getFactor();
            int i10 = this.f52903h.G0() ? this.f52903h.f37094n : this.f52903h.f37094n - 1;
            for (int i11 = !this.f52903h.F0() ? 1 : 0; i11 < i10; i11++) {
                YAxis yAxis = this.f52903h;
                xa.k.B(centerOffsets, (yAxis.f37092l[i11] - yAxis.H) * factor, this.f52916r.getRotationAngle(), gVarC);
                canvas.drawText(this.f52903h.x(i11), gVarC.f54987c + 10.0f, gVarC.f54988d, this.f52807e);
            }
            xa.g.h(centerOffsets);
            xa.g.h(gVarC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.t, va.a
    public void j(Canvas canvas) {
        List<LimitLine> listD = this.f52903h.D();
        if (listD == null) {
            return;
        }
        float sliceAngle = this.f52916r.getSliceAngle();
        float factor = this.f52916r.getFactor();
        xa.g centerOffsets = this.f52916r.getCenterOffsets();
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        for (int i10 = 0; i10 < listD.size(); i10++) {
            LimitLine limitLine = listD.get(i10);
            if (limitLine.f()) {
                this.f52809g.setColor(limitLine.s());
                this.f52809g.setPathEffect(limitLine.o());
                this.f52809g.setStrokeWidth(limitLine.t());
                float fR = (limitLine.r() - this.f52916r.getYChartMin()) * factor;
                Path path = this.f52917s;
                path.reset();
                for (int i11 = 0; i11 < ((la.q) this.f52916r.getData()).w().e1(); i11++) {
                    xa.k.B(centerOffsets, fR, (i11 * sliceAngle) + this.f52916r.getRotationAngle(), gVarC);
                    if (i11 == 0) {
                        path.moveTo(gVarC.f54987c, gVarC.f54988d);
                    } else {
                        path.lineTo(gVarC.f54987c, gVarC.f54988d);
                    }
                }
                path.close();
                canvas.drawPath(path, this.f52809g);
            }
        }
        xa.g.h(centerOffsets);
        xa.g.h(gVarC);
    }
}
