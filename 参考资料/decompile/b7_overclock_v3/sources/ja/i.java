package ja;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import la.q;
import va.n;
import va.s;
import va.v;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class i extends h<q> {
    public float I7;
    public float J7;
    public int K7;
    public int L7;
    public int M7;
    public boolean N7;
    public int O7;
    public YAxis P7;
    public v Q7;
    public s R7;

    public i(Context context) {
        super(context);
        this.I7 = 2.5f;
        this.J7 = 1.5f;
        this.K7 = Color.rgb(122, 122, 122);
        this.L7 = Color.rgb(122, 122, 122);
        this.M7 = 150;
        this.N7 = true;
        this.O7 = 0;
    }

    @Override // ja.h, ja.e
    public void H() {
        super.H();
        this.P7 = new YAxis(YAxis.AxisDependency.LEFT);
        this.I7 = k.e(1.5f);
        this.J7 = k.e(0.75f);
        this.f36264r = new n(this, this.f36267u, this.f36266t);
        this.Q7 = new v(this.f36266t, this.P7, this);
        this.R7 = new s(this.f36266t, this.f36254i, this);
        this.f36265s = new oa.i(this);
    }

    @Override // ja.h, ja.e
    public void O() {
        if (this.f36247b == 0) {
            return;
        }
        o();
        v vVar = this.Q7;
        YAxis yAxis = this.P7;
        vVar.a(yAxis.H, yAxis.G, yAxis.I0());
        s sVar = this.R7;
        XAxis xAxis = this.f36254i;
        sVar.a(xAxis.H, xAxis.G, false);
        Legend legend = this.f36258l;
        if (legend != null && !legend.I()) {
            this.f36263q.a(this.f36247b);
        }
        p();
    }

    @Override // ja.h
    public int b0(float f10) {
        float fZ = k.z(f10 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int iE1 = ((q) this.f36247b).w().e1();
        int i10 = 0;
        while (i10 < iE1) {
            int i11 = i10 + 1;
            if ((i11 * sliceAngle) - (sliceAngle / 2.0f) > fZ) {
                return i10;
            }
            i10 = i11;
        }
        return 0;
    }

    public float getFactor() {
        RectF rectFQ = this.f36266t.q();
        return Math.min(rectFQ.width() / 2.0f, rectFQ.height() / 2.0f) / this.P7.I;
    }

    @Override // ja.h
    public float getRadius() {
        RectF rectFQ = this.f36266t.q();
        return Math.min(rectFQ.width() / 2.0f, rectFQ.height() / 2.0f);
    }

    @Override // ja.h
    public float getRequiredBaseOffset() {
        return (this.f36254i.f() && this.f36254i.P()) ? this.f36254i.L : k.e(10.0f);
    }

    @Override // ja.h
    public float getRequiredLegendOffset() {
        return this.f36263q.e().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.O7;
    }

    public float getSliceAngle() {
        return 360.0f / ((q) this.f36247b).w().e1();
    }

    public int getWebAlpha() {
        return this.M7;
    }

    public int getWebColor() {
        return this.K7;
    }

    public int getWebColorInner() {
        return this.L7;
    }

    public float getWebLineWidth() {
        return this.I7;
    }

    public float getWebLineWidthInner() {
        return this.J7;
    }

    public YAxis getYAxis() {
        return this.P7;
    }

    @Override // ja.h, pa.e
    public float getYChartMax() {
        return this.P7.G;
    }

    @Override // ja.h, pa.e
    public float getYChartMin() {
        return this.P7.H;
    }

    public float getYRange() {
        return this.P7.I;
    }

    @Override // ja.h, ja.e
    public void o() {
        super.o();
        YAxis yAxis = this.P7;
        q qVar = (q) this.f36247b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(qVar.C(axisDependency), ((q) this.f36247b).A(axisDependency));
        this.f36254i.n(0.0f, ((q) this.f36247b).w().e1());
    }

    @Override // ja.e, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f36247b == 0) {
            return;
        }
        if (this.f36254i.f()) {
            s sVar = this.R7;
            XAxis xAxis = this.f36254i;
            sVar.a(xAxis.H, xAxis.G, false);
        }
        this.R7.g(canvas);
        if (this.N7) {
            this.f36264r.c(canvas);
        }
        if (this.P7.f() && this.P7.Q()) {
            this.Q7.j(canvas);
        }
        this.f36264r.b(canvas);
        if (Y()) {
            this.f36264r.d(canvas, this.A);
        }
        if (this.P7.f() && !this.P7.Q()) {
            this.Q7.j(canvas);
        }
        this.Q7.g(canvas);
        this.f36264r.f(canvas);
        this.f36263q.f(canvas);
        u(canvas);
        v(canvas);
    }

    public void setDrawWeb(boolean z10) {
        this.N7 = z10;
    }

    public void setSkipWebLineCount(int i10) {
        this.O7 = Math.max(0, i10);
    }

    public void setWebAlpha(int i10) {
        this.M7 = i10;
    }

    public void setWebColor(int i10) {
        this.K7 = i10;
    }

    public void setWebColorInner(int i10) {
        this.L7 = i10;
    }

    public void setWebLineWidth(float f10) {
        this.I7 = k.e(f10);
    }

    public void setWebLineWidthInner(float f10) {
        this.J7 = k.e(f10);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I7 = 2.5f;
        this.J7 = 1.5f;
        this.K7 = Color.rgb(122, 122, 122);
        this.L7 = Color.rgb(122, 122, 122);
        this.M7 = 150;
        this.N7 = true;
        this.O7 = 0;
    }

    public i(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.I7 = 2.5f;
        this.J7 = 1.5f;
        this.K7 = Color.rgb(122, 122, 122);
        this.L7 = Color.rgb(122, 122, 122);
        this.M7 = 150;
        this.N7 = true;
        this.O7 = 0;
    }
}
