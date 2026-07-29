package ja;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b<la.a> implements pa.a {

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public boolean f36219m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public boolean f36220n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f36221o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f36222p8;

    public a(Context context) {
        super(context);
        this.f36219m8 = false;
        this.f36220n8 = true;
        this.f36221o8 = false;
        this.f36222p8 = false;
    }

    @Override // ja.b, ja.e
    public void H() {
        super.H();
        this.f36264r = new va.b(this, this.f36267u, this.f36266t);
        setHighlighter(new oa.a(this));
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    public RectF X0(BarEntry barEntry) {
        RectF rectF = new RectF();
        Y0(barEntry, rectF);
        return rectF;
    }

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
        rectF.set(f10, f12, f11, fE);
        a(aVar.a1()).t(rectF);
    }

    public void Z0(float f10, float f11, float f12) {
        if (getBarData() == null) {
            throw new RuntimeException("You need to set data for the chart before grouping bars.");
        }
        getBarData().S(f10, f11, f12);
        O();
    }

    public void a1(float f10, int i10, int i11) {
        F(new oa.d(f10, i10, i11), false);
    }

    @Override // pa.a
    public boolean b() {
        return this.f36221o8;
    }

    @Override // pa.a
    public boolean c() {
        return this.f36220n8;
    }

    @Override // pa.a
    public boolean d() {
        return this.f36219m8;
    }

    @Override // pa.a
    public la.a getBarData() {
        return (la.a) this.f36247b;
    }

    @Override // ja.b, ja.e
    public void o() {
        if (this.f36222p8) {
            this.f36254i.n(((la.a) this.f36247b).y() - (((la.a) this.f36247b).Q() / 2.0f), ((la.a) this.f36247b).x() + (((la.a) this.f36247b).Q() / 2.0f));
        } else {
            this.f36254i.n(((la.a) this.f36247b).y(), ((la.a) this.f36247b).x());
        }
        YAxis yAxis = this.V7;
        la.a aVar = (la.a) this.f36247b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(aVar.C(axisDependency), ((la.a) this.f36247b).A(axisDependency));
        YAxis yAxis2 = this.W7;
        la.a aVar2 = (la.a) this.f36247b;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.n(aVar2.C(axisDependency2), ((la.a) this.f36247b).A(axisDependency2));
    }

    public void setDrawBarShadow(boolean z10) {
        this.f36221o8 = z10;
    }

    public void setDrawValueAboveBar(boolean z10) {
        this.f36220n8 = z10;
    }

    public void setFitBars(boolean z10) {
        this.f36222p8 = z10;
    }

    public void setHighlightFullBarEnabled(boolean z10) {
        this.f36219m8 = z10;
    }

    @Override // ja.e
    public oa.d x(float f10, float f11) {
        if (this.f36247b == 0) {
            return null;
        }
        oa.d dVarA = getHighlighter().a(f10, f11);
        return (dVarA == null || !d()) ? dVarA : new oa.d(dVarA.h(), dVarA.j(), dVarA.i(), dVarA.k(), dVarA.d(), -1, dVarA.b());
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36219m8 = false;
        this.f36220n8 = true;
        this.f36221o8 = false;
        this.f36222p8 = false;
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36219m8 = false;
        this.f36220n8 = true;
        this.f36221o8 = false;
        this.f36222p8 = false;
    }
}
