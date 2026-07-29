package ja;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import va.r;
import va.u;
import xa.j;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class f extends a {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RectF f36275q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public float[] f36276r8;

    public f(Context context) {
        super(context);
        this.f36275q8 = new RectF();
        this.f36276r8 = new float[2];
    }

    @Override // ja.a, ja.b, ja.e
    public void H() {
        this.f36266t = new xa.e();
        super.H();
        this.Z7 = new j(this.f36266t);
        this.f36223a8 = new j(this.f36266t);
        this.f36264r = new va.h(this, this.f36267u, this.f36266t);
        setHighlighter(new oa.e(this));
        this.X7 = new u(this.f36266t, this.V7, this.Z7);
        this.Y7 = new u(this.f36266t, this.W7, this.f36223a8);
        this.f36224b8 = new r(this.f36266t, this.f36254i, this.Z7, this);
    }

    @Override // ja.b
    public void H0() {
        xa.i iVar = this.f36223a8;
        YAxis yAxis = this.W7;
        float f10 = yAxis.H;
        float f11 = yAxis.I;
        XAxis xAxis = this.f36254i;
        iVar.q(f10, f11, xAxis.I, xAxis.H);
        xa.i iVar2 = this.Z7;
        YAxis yAxis2 = this.V7;
        float f12 = yAxis2.H;
        float f13 = yAxis2.I;
        XAxis xAxis2 = this.f36254i;
        iVar2.q(f12, f13, xAxis2.I, xAxis2.H);
    }

    @Override // ja.b
    public void N0(float f10, float f11) {
        float f12 = this.f36254i.I;
        this.f36266t.b0(f12 / f10, f12 / f11);
    }

    @Override // ja.b
    public void O0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        this.f36266t.a0(g0(axisDependency) / f10, g0(axisDependency) / f11);
    }

    @Override // ja.b
    public void P0(float f10, YAxis.AxisDependency axisDependency) {
        this.f36266t.c0(g0(axisDependency) / f10);
    }

    @Override // ja.b
    public void Q0(float f10, YAxis.AxisDependency axisDependency) {
        this.f36266t.Y(g0(axisDependency) / f10);
    }

    @Override // ja.a
    public void Y0(BarEntry barEntry, RectF rectF) {
        qa.a aVar = (qa.a) ((la.a) this.f36247b).n(barEntry);
        if (aVar == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float fE = barEntry.e();
        float F = barEntry.F();
        float fQ = ((la.a) this.f36247b).Q() / 2.0f;
        float f10 = F - fQ;
        float f11 = F + fQ;
        float f12 = fE >= 0.0f ? fE : 0.0f;
        if (fE > 0.0f) {
            fE = 0.0f;
        }
        rectF.set(f12, f10, fE, f11);
        a(aVar.a1()).t(rectF);
    }

    @Override // ja.b, pa.b
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.f36266t.h(), this.f36266t.j(), this.f36233k8);
        return (float) Math.min(this.f36254i.G, this.f36233k8.f54984d);
    }

    @Override // ja.b, pa.b
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.f36266t.h(), this.f36266t.f(), this.f36232j8);
        return (float) Math.max(this.f36254i.H, this.f36232j8.f54984d);
    }

    @Override // ja.b
    public xa.g k0(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.f36276r8;
        fArr[0] = entry.e();
        fArr[1] = entry.F();
        a(axisDependency).o(fArr);
        return xa.g.c(fArr[0], fArr[1]);
    }

    @Override // ja.b, ja.e
    public void p() {
        a0(this.f36275q8);
        RectF rectF = this.f36275q8;
        float f10 = rectF.left + 0.0f;
        float fZ0 = rectF.top + 0.0f;
        float f11 = rectF.right + 0.0f;
        float fZ02 = rectF.bottom + 0.0f;
        if (this.V7.L0()) {
            fZ0 += this.V7.z0(this.X7.c());
        }
        if (this.W7.L0()) {
            fZ02 += this.W7.z0(this.Y7.c());
        }
        XAxis xAxis = this.f36254i;
        float f12 = xAxis.L;
        if (xAxis.f()) {
            if (this.f36254i.w0() == XAxis.XAxisPosition.BOTTOM) {
                f10 += f12;
            } else if (this.f36254i.w0() == XAxis.XAxisPosition.TOP) {
                f11 += f12;
            } else if (this.f36254i.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                f10 += f12;
                f11 += f12;
            }
        }
        float extraTopOffset = fZ0 + getExtraTopOffset();
        float extraRightOffset = f11 + getExtraRightOffset();
        float extraBottomOffset = fZ02 + getExtraBottomOffset();
        float extraLeftOffset = f10 + getExtraLeftOffset();
        float fE = k.e(this.S7);
        this.f36266t.U(Math.max(fE, extraLeftOffset), Math.max(fE, extraTopOffset), Math.max(fE, extraRightOffset), Math.max(fE, extraBottomOffset));
        if (this.f36246a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("offsetLeft: ");
            sb2.append(extraLeftOffset);
            sb2.append(", offsetTop: ");
            sb2.append(extraTopOffset);
            sb2.append(", offsetRight: ");
            sb2.append(extraRightOffset);
            sb2.append(", offsetBottom: ");
            sb2.append(extraBottomOffset);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Content: ");
            sb3.append(this.f36266t.q().toString());
        }
        G0();
        H0();
    }

    @Override // ja.b
    public void setVisibleXRangeMaximum(float f10) {
        this.f36266t.d0(this.f36254i.I / f10);
    }

    @Override // ja.b
    public void setVisibleXRangeMinimum(float f10) {
        this.f36266t.Z(this.f36254i.I / f10);
    }

    @Override // ja.a, ja.e
    public oa.d x(float f10, float f11) {
        if (this.f36247b == 0) {
            return null;
        }
        return getHighlighter().a(f11, f10);
    }

    @Override // ja.e
    public float[] y(oa.d dVar) {
        return new float[]{dVar.f(), dVar.e()};
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36275q8 = new RectF();
        this.f36276r8 = new float[2];
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36275q8 = new RectF();
        this.f36276r8 = new float[2];
    }
}
