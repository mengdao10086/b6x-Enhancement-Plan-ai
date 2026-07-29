package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.Entry;
import ja.b;
import la.a;
import la.g;
import la.i;
import la.l;
import la.m;
import la.s;
import oa.c;
import oa.d;
import pa.f;

/* JADX INFO: loaded from: classes3.dex */
public class CombinedChart extends b<l> implements f {

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public boolean f16586m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public boolean f16587n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f16588o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public DrawOrder[] f16589p8;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.f16586m8 = true;
        this.f16587n8 = false;
        this.f16588o8 = false;
    }

    @Override // ja.b, ja.e
    public void H() {
        super.H();
        this.f16589p8 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new c(this, this));
        setHighlightFullBarEnabled(true);
        this.f36264r = new va.f(this, this.f36267u, this.f36266t);
    }

    @Override // pa.a
    public boolean b() {
        return this.f16588o8;
    }

    @Override // pa.a
    public boolean c() {
        return this.f16586m8;
    }

    @Override // pa.a
    public boolean d() {
        return this.f16587n8;
    }

    @Override // pa.a
    public a getBarData() {
        T t10 = this.f36247b;
        if (t10 == 0) {
            return null;
        }
        return ((l) t10).R();
    }

    @Override // pa.c
    public g getBubbleData() {
        T t10 = this.f36247b;
        if (t10 == 0) {
            return null;
        }
        return ((l) t10).S();
    }

    @Override // pa.d
    public i getCandleData() {
        T t10 = this.f36247b;
        if (t10 == 0) {
            return null;
        }
        return ((l) t10).T();
    }

    @Override // pa.f
    public l getCombinedData() {
        return (l) this.f36247b;
    }

    public DrawOrder[] getDrawOrder() {
        return this.f16589p8;
    }

    @Override // pa.g
    public m getLineData() {
        T t10 = this.f36247b;
        if (t10 == 0) {
            return null;
        }
        return ((l) t10).X();
    }

    @Override // pa.h
    public s getScatterData() {
        T t10 = this.f36247b;
        if (t10 == 0) {
            return null;
        }
        return ((l) t10).Y();
    }

    public void setDrawBarShadow(boolean z10) {
        this.f16588o8 = z10;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.f16589p8 = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z10) {
        this.f16586m8 = z10;
    }

    public void setHighlightFullBarEnabled(boolean z10) {
        this.f16587n8 = z10;
    }

    @Override // ja.e
    public void v(Canvas canvas) {
        if (this.D == null || !K() || !Y()) {
            return;
        }
        int i10 = 0;
        while (true) {
            d[] dVarArr = this.A;
            if (i10 >= dVarArr.length) {
                return;
            }
            d dVar = dVarArr[i10];
            qa.b<? extends Entry> bVarW = ((l) this.f36247b).W(dVar);
            Entry entryS = ((l) this.f36247b).s(dVar);
            if (entryS != null && bVarW.t(entryS) <= bVarW.e1() * this.f36267u.h()) {
                float[] fArrY = y(dVar);
                if (this.f36266t.G(fArrY[0], fArrY[1])) {
                    this.D.c(entryS, dVar);
                    this.D.a(canvas, fArrY[0], fArrY[1]);
                }
            }
            i10++;
        }
    }

    @Override // ja.e
    public d x(float f10, float f11) {
        if (this.f36247b == 0) {
            return null;
        }
        d dVarA = getHighlighter().a(f10, f11);
        return (dVarA == null || !d()) ? dVarA : new d(dVarA.h(), dVarA.j(), dVarA.i(), dVarA.k(), dVarA.d(), -1, dVarA.b());
    }

    @Override // ja.e
    public void setData(l lVar) {
        super.setData(lVar);
        setHighlighter(new c(this, this));
        ((va.f) this.f36264r).l();
        this.f36264r.j();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16586m8 = true;
        this.f16587n8 = false;
        this.f16588o8 = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16586m8 = true;
        this.f16587n8 = false;
        this.f16588o8 = false;
    }
}
