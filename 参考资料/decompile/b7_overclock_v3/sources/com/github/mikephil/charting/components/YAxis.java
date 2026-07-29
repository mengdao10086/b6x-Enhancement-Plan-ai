package com.github.mikephil.charting.components;

import android.graphics.Paint;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class YAxis extends ka.a {
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public float Q;
    public float R;
    public float S;
    public YAxisLabelPosition T;
    public AxisDependency U;
    public float V;
    public float W;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = -7829368;
        this.Q = 1.0f;
        this.R = 10.0f;
        this.S = 10.0f;
        this.T = YAxisLabelPosition.OUTSIDE_CHART;
        this.V = 0.0f;
        this.W = Float.POSITIVE_INFINITY;
        this.U = AxisDependency.LEFT;
        this.f37109c = 0.0f;
    }

    public float A0(Paint paint) {
        paint.setTextSize(this.f37111e);
        float fD = k.d(paint, E()) + (d() * 2.0f);
        float fY0 = y0();
        float fX0 = x0();
        if (fY0 > 0.0f) {
            fY0 = k.e(fY0);
        }
        if (fX0 > 0.0f && fX0 != Float.POSITIVE_INFINITY) {
            fX0 = k.e(fX0);
        }
        if (fX0 <= 0.0d) {
            fX0 = fD;
        }
        return Math.max(fY0, Math.min(fD, fX0));
    }

    public float B0() {
        return this.S;
    }

    public float C0() {
        return this.R;
    }

    public int D0() {
        return this.P;
    }

    public float E0() {
        return this.Q;
    }

    public boolean F0() {
        return this.J;
    }

    public boolean G0() {
        return this.K;
    }

    public boolean H0() {
        return this.M;
    }

    public boolean I0() {
        return this.L;
    }

    @Deprecated
    public boolean J0() {
        return this.O;
    }

    @Deprecated
    public boolean K0() {
        return this.N;
    }

    public boolean L0() {
        return f() && P() && w0() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void M0(boolean z10) {
        this.K = z10;
    }

    public void N0(boolean z10) {
        this.M = z10;
    }

    public void O0(boolean z10) {
        this.L = z10;
    }

    public void P0(float f10) {
        this.W = f10;
    }

    public void Q0(float f10) {
        this.V = f10;
    }

    public void R0(YAxisLabelPosition yAxisLabelPosition) {
        this.T = yAxisLabelPosition;
    }

    public void S0(float f10) {
        this.S = f10;
    }

    public void T0(float f10) {
        this.R = f10;
    }

    @Deprecated
    public void U0(boolean z10) {
        if (z10) {
            e0(0.0f);
        } else {
            X();
        }
    }

    @Deprecated
    public void V0(boolean z10) {
        this.O = z10;
    }

    @Deprecated
    public void W0(boolean z10) {
        this.N = z10;
    }

    public void X0(int i10) {
        this.P = i10;
    }

    public void Y0(float f10) {
        this.Q = k.e(f10);
    }

    @Override // ka.a
    public void n(float f10, float f11) {
        if (Math.abs(f11 - f10) == 0.0f) {
            f11 += 1.0f;
            f10 -= 1.0f;
        }
        float fAbs = Math.abs(f11 - f10);
        this.H = this.E ? this.H : f10 - ((fAbs / 100.0f) * B0());
        float fC0 = this.F ? this.G : f11 + ((fAbs / 100.0f) * C0());
        this.G = fC0;
        this.I = Math.abs(this.H - fC0);
    }

    public AxisDependency v0() {
        return this.U;
    }

    public YAxisLabelPosition w0() {
        return this.T;
    }

    public float x0() {
        return this.W;
    }

    public float y0() {
        return this.V;
    }

    public float z0(Paint paint) {
        paint.setTextSize(this.f37111e);
        return k.a(paint, E()) + (e() * 2.0f);
    }

    public YAxis(AxisDependency axisDependency) {
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = -7829368;
        this.Q = 1.0f;
        this.R = 10.0f;
        this.S = 10.0f;
        this.T = YAxisLabelPosition.OUTSIDE_CHART;
        this.V = 0.0f;
        this.W = Float.POSITIVE_INFINITY;
        this.U = axisDependency;
        this.f37109c = 0.0f;
    }
}
