package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import ja.b;
import la.s;
import pa.h;
import va.p;

/* JADX INFO: loaded from: classes3.dex */
public class ScatterChart extends b<s> implements h {

    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");

        private final String shapeIdentifier;

        ScatterShape(String str) {
            this.shapeIdentifier = str;
        }

        public static ScatterShape[] getAllDefaultShapes() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.shapeIdentifier;
        }
    }

    public ScatterChart(Context context) {
        super(context);
    }

    @Override // ja.b, ja.e
    public void H() {
        super.H();
        this.f36264r = new p(this, this.f36267u, this.f36266t);
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    @Override // pa.h
    public s getScatterData() {
        return (s) this.f36247b;
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
