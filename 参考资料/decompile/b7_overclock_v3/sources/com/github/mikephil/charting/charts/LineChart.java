package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import ja.b;
import la.m;
import pa.g;
import va.j;

/* JADX INFO: loaded from: classes3.dex */
public class LineChart extends b<m> implements g {
    public LineChart(Context context) {
        super(context);
    }

    @Override // ja.b, ja.e
    public void H() {
        super.H();
        this.f36264r = new j(this, this.f36267u, this.f36266t);
    }

    @Override // pa.g
    public m getLineData() {
        return (m) this.f36247b;
    }

    @Override // ja.e, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        va.g gVar = this.f36264r;
        if (gVar != null && (gVar instanceof j)) {
            ((j) gVar).A();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
