package ja;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;
import la.p;
import va.m;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class g extends h<p> {
    public RectF I7;
    public boolean J7;
    public float[] K7;
    public float[] L7;
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;
    public CharSequence Q7;
    public xa.g R7;
    public float S7;
    public float T7;
    public boolean U7;
    public float V7;
    public float W7;
    public float X7;

    public g(Context context) {
        super(context);
        this.I7 = new RectF();
        this.J7 = true;
        this.K7 = new float[1];
        this.L7 = new float[1];
        this.M7 = true;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = "";
        this.R7 = xa.g.c(0.0f, 0.0f);
        this.S7 = 50.0f;
        this.T7 = 55.0f;
        this.U7 = true;
        this.V7 = 100.0f;
        this.W7 = 360.0f;
        this.X7 = 0.0f;
    }

    @Override // ja.h, ja.e
    public void H() {
        super.H();
        this.f36264r = new m(this, this.f36267u, this.f36266t);
        this.f36254i = null;
        this.f36265s = new oa.g(this);
    }

    @Override // ja.h
    public int b0(float f10) {
        float fZ = k.z(f10 - getRotationAngle());
        int i10 = 0;
        while (true) {
            float[] fArr = this.L7;
            if (i10 >= fArr.length) {
                return -1;
            }
            if (fArr[i10] > fZ) {
                return i10;
            }
            i10++;
        }
    }

    public final float g0(float f10) {
        return h0(f10, ((p) this.f36247b).T());
    }

    public float[] getAbsoluteAngles() {
        return this.L7;
    }

    public xa.g getCenterCircleBox() {
        return xa.g.c(this.I7.centerX(), this.I7.centerY());
    }

    public CharSequence getCenterText() {
        return this.Q7;
    }

    public xa.g getCenterTextOffset() {
        xa.g gVar = this.R7;
        return xa.g.c(gVar.f54987c, gVar.f54988d);
    }

    public float getCenterTextRadiusPercent() {
        return this.V7;
    }

    public RectF getCircleBox() {
        return this.I7;
    }

    public float[] getDrawAngles() {
        return this.K7;
    }

    public float getHoleRadius() {
        return this.S7;
    }

    public float getMaxAngle() {
        return this.W7;
    }

    public float getMinAngleForSlices() {
        return this.X7;
    }

    @Override // ja.h
    public float getRadius() {
        RectF rectF = this.I7;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.I7.height() / 2.0f);
    }

    @Override // ja.h
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // ja.h
    public float getRequiredLegendOffset() {
        return this.f36263q.e().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.T7;
    }

    @Override // ja.e
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public final float h0(float f10, float f11) {
        return (f10 / f11) * this.W7;
    }

    public final void i0() {
        int iR = ((p) this.f36247b).r();
        if (this.K7.length != iR) {
            this.K7 = new float[iR];
        } else {
            for (int i10 = 0; i10 < iR; i10++) {
                this.K7[i10] = 0.0f;
            }
        }
        if (this.L7.length != iR) {
            this.L7 = new float[iR];
        } else {
            for (int i11 = 0; i11 < iR; i11++) {
                this.L7[i11] = 0.0f;
            }
        }
        float fT = ((p) this.f36247b).T();
        List<qa.i> listQ = ((p) this.f36247b).q();
        float f10 = this.X7;
        boolean z10 = f10 != 0.0f && ((float) iR) * f10 <= this.W7;
        float[] fArr = new float[iR];
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < ((p) this.f36247b).m(); i13++) {
            qa.i iVar = listQ.get(i13);
            for (int i14 = 0; i14 < iVar.e1(); i14++) {
                float fH0 = h0(Math.abs(iVar.Z(i14).e()), fT);
                if (z10) {
                    float f13 = this.X7;
                    float f14 = fH0 - f13;
                    if (f14 <= 0.0f) {
                        fArr[i12] = f13;
                        f11 += -f14;
                    } else {
                        fArr[i12] = fH0;
                        f12 += f14;
                    }
                }
                float[] fArr2 = this.K7;
                fArr2[i12] = fH0;
                if (i12 == 0) {
                    this.L7[i12] = fArr2[i12];
                } else {
                    float[] fArr3 = this.L7;
                    fArr3[i12] = fArr3[i12 - 1] + fArr2[i12];
                }
                i12++;
            }
        }
        if (z10) {
            for (int i15 = 0; i15 < iR; i15++) {
                fArr[i15] = fArr[i15] - (((fArr[i15] - this.X7) / f12) * f11);
                if (i15 == 0) {
                    this.L7[0] = fArr[0];
                } else {
                    float[] fArr4 = this.L7;
                    fArr4[i15] = fArr4[i15 - 1] + fArr[i15];
                }
            }
            this.K7 = fArr;
        }
    }

    public int j0(int i10) {
        List<qa.i> listQ = ((p) this.f36247b).q();
        for (int i11 = 0; i11 < listQ.size(); i11++) {
            if (listQ.get(i11).y(i10, Float.NaN) != null) {
                return i11;
            }
        }
        return -1;
    }

    public boolean k0() {
        return this.U7;
    }

    public boolean m0() {
        return this.J7;
    }

    public boolean n0() {
        return this.M7;
    }

    @Override // ja.h, ja.e
    public void o() {
        i0();
    }

    public boolean o0() {
        return this.P7;
    }

    @Override // ja.e, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        va.g gVar = this.f36264r;
        if (gVar != null && (gVar instanceof m)) {
            ((m) gVar).w();
        }
        super.onDetachedFromWindow();
    }

    @Override // ja.e, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f36247b == 0) {
            return;
        }
        this.f36264r.b(canvas);
        if (Y()) {
            this.f36264r.d(canvas, this.A);
        }
        this.f36264r.c(canvas);
        this.f36264r.f(canvas);
        this.f36263q.f(canvas);
        u(canvas);
        v(canvas);
    }

    @Override // ja.h, ja.e
    public void p() {
        super.p();
        if (this.f36247b == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        xa.g centerOffsets = getCenterOffsets();
        float fP0 = ((p) this.f36247b).Q().P0();
        RectF rectF = this.I7;
        float f10 = centerOffsets.f54987c;
        float f11 = centerOffsets.f54988d;
        rectF.set((f10 - diameter) + fP0, (f11 - diameter) + fP0, (f10 + diameter) - fP0, (f11 + diameter) - fP0);
        xa.g.h(centerOffsets);
    }

    public boolean p0() {
        return this.N7;
    }

    public boolean q0() {
        return this.O7;
    }

    public boolean r0(int i10) {
        if (!Y()) {
            return false;
        }
        int i11 = 0;
        while (true) {
            oa.d[] dVarArr = this.A;
            if (i11 >= dVarArr.length) {
                return false;
            }
            if (((int) dVarArr[i11].h()) == i10) {
                return true;
            }
            i11++;
        }
    }

    public void s0(float f10, float f11) {
        this.R7.f54987c = k.e(f10);
        this.R7.f54988d = k.e(f11);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.Q7 = "";
        } else {
            this.Q7 = charSequence;
        }
    }

    public void setCenterTextColor(int i10) {
        ((m) this.f36264r).r().setColor(i10);
    }

    public void setCenterTextRadiusPercent(float f10) {
        this.V7 = f10;
    }

    public void setCenterTextSize(float f10) {
        ((m) this.f36264r).r().setTextSize(k.e(f10));
    }

    public void setCenterTextSizePixels(float f10) {
        ((m) this.f36264r).r().setTextSize(f10);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((m) this.f36264r).r().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z10) {
        this.U7 = z10;
    }

    public void setDrawEntryLabels(boolean z10) {
        this.J7 = z10;
    }

    public void setDrawHoleEnabled(boolean z10) {
        this.M7 = z10;
    }

    public void setDrawRoundedSlices(boolean z10) {
        this.P7 = z10;
    }

    @Deprecated
    public void setDrawSliceText(boolean z10) {
        this.J7 = z10;
    }

    public void setDrawSlicesUnderHole(boolean z10) {
        this.N7 = z10;
    }

    public void setEntryLabelColor(int i10) {
        ((m) this.f36264r).s().setColor(i10);
    }

    public void setEntryLabelTextSize(float f10) {
        ((m) this.f36264r).s().setTextSize(k.e(f10));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((m) this.f36264r).s().setTypeface(typeface);
    }

    public void setHoleColor(int i10) {
        ((m) this.f36264r).t().setColor(i10);
    }

    public void setHoleRadius(float f10) {
        this.S7 = f10;
    }

    public void setMaxAngle(float f10) {
        if (f10 > 360.0f) {
            f10 = 360.0f;
        }
        if (f10 < 90.0f) {
            f10 = 90.0f;
        }
        this.W7 = f10;
    }

    public void setMinAngleForSlices(float f10) {
        float f11 = this.W7;
        if (f10 > f11 / 2.0f) {
            f10 = f11 / 2.0f;
        } else if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.X7 = f10;
    }

    public void setTransparentCircleAlpha(int i10) {
        ((m) this.f36264r).u().setAlpha(i10);
    }

    public void setTransparentCircleColor(int i10) {
        Paint paintU = ((m) this.f36264r).u();
        int alpha = paintU.getAlpha();
        paintU.setColor(i10);
        paintU.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f10) {
        this.T7 = f10;
    }

    public void setUsePercentValues(boolean z10) {
        this.O7 = z10;
    }

    @Override // ja.e
    public float[] y(oa.d dVar) {
        xa.g centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (n0()) {
            holeRadius = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f10 = radius - holeRadius;
        float rotationAngle = getRotationAngle();
        float f11 = this.K7[(int) dVar.h()] / 2.0f;
        double d10 = f10;
        float fCos = (float) ((Math.cos(Math.toRadians(((this.L7[r11] + rotationAngle) - f11) * this.f36267u.i())) * d10) + ((double) centerCircleBox.f54987c));
        float fSin = (float) ((d10 * Math.sin(Math.toRadians(((rotationAngle + this.L7[r11]) - f11) * this.f36267u.i()))) + ((double) centerCircleBox.f54988d));
        xa.g.h(centerCircleBox);
        return new float[]{fCos, fSin};
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I7 = new RectF();
        this.J7 = true;
        this.K7 = new float[1];
        this.L7 = new float[1];
        this.M7 = true;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = "";
        this.R7 = xa.g.c(0.0f, 0.0f);
        this.S7 = 50.0f;
        this.T7 = 55.0f;
        this.U7 = true;
        this.V7 = 100.0f;
        this.W7 = 360.0f;
        this.X7 = 0.0f;
    }

    public g(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.I7 = new RectF();
        this.J7 = true;
        this.K7 = new float[1];
        this.L7 = new float[1];
        this.M7 = true;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = "";
        this.R7 = xa.g.c(0.0f, 0.0f);
        this.S7 = 50.0f;
        this.T7 = 55.0f;
        this.U7 = true;
        this.V7 = 100.0f;
        this.W7 = 360.0f;
        this.X7 = 0.0f;
    }
}
