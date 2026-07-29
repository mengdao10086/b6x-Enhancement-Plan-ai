package com.github.mikephil.charting.components;

import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class XAxis extends ka.a {
    public int J = 1;
    public int K = 1;
    public int L = 1;
    public int M = 1;
    public float N = 0.0f;
    public boolean O = false;
    public XAxisPosition P = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f37109c = k.e(4.0f);
    }

    public void A0(XAxisPosition xAxisPosition) {
        this.P = xAxisPosition;
    }

    public float v0() {
        return this.N;
    }

    public XAxisPosition w0() {
        return this.P;
    }

    public boolean x0() {
        return this.O;
    }

    public void y0(boolean z10) {
        this.O = z10;
    }

    public void z0(float f10) {
        this.N = f10;
    }
}
