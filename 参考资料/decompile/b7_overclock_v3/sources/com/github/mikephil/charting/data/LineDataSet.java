package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import java.util.ArrayList;
import java.util.List;
import la.n;
import na.c;
import qa.f;
import xa.a;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class LineDataSet extends n<Entry> implements f {
    public Mode H;
    public List<Integer> I;
    public int J;
    public float K;
    public float L;
    public float M;
    public DashPathEffect N;
    public na.f O;
    public boolean P;
    public boolean Q;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.H = Mode.LINEAR;
        this.I = null;
        this.J = -1;
        this.K = 8.0f;
        this.L = 4.0f;
        this.M = 0.2f;
        this.N = null;
        this.O = new c();
        this.P = true;
        this.Q = true;
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
        this.I.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // qa.f
    public boolean B() {
        return this.N != null;
    }

    @Override // qa.f
    public int F() {
        return this.J;
    }

    @Override // qa.f
    public float N() {
        return this.M;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((Entry) this.f16633s.get(i10)).z());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, J());
        h2(lineDataSet);
        return lineDataSet;
    }

    @Override // qa.f
    public DashPathEffect Q() {
        return this.N;
    }

    @Override // qa.f
    public int Z0(int i10) {
        return this.I.get(i10).intValue();
    }

    @Override // qa.f
    public float a0() {
        return this.K;
    }

    @Override // qa.f
    public Mode e0() {
        return this.H;
    }

    @Override // qa.f
    public int g() {
        return this.I.size();
    }

    @Override // qa.f
    public boolean h1() {
        return this.P;
    }

    public void h2(LineDataSet lineDataSet) {
        super.c2(lineDataSet);
        lineDataSet.I = this.I;
        lineDataSet.J = this.J;
        lineDataSet.L = this.L;
        lineDataSet.K = this.K;
        lineDataSet.M = this.M;
        lineDataSet.N = this.N;
        lineDataSet.Q = this.Q;
        lineDataSet.P = this.Q;
        lineDataSet.O = this.O;
        lineDataSet.H = this.H;
    }

    public void i2() {
        this.N = null;
    }

    public void j2(float f10, float f11, float f12) {
        this.N = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    @Override // qa.f
    public float k1() {
        return this.L;
    }

    public List<Integer> k2() {
        return this.I;
    }

    @Deprecated
    public float l2() {
        return a0();
    }

    public void m2() {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
    }

    public void n2(int i10) {
        m2();
        this.I.add(Integer.valueOf(i10));
    }

    public void o2(List<Integer> list) {
        this.I = list;
    }

    @Override // qa.f
    public na.f p() {
        return this.O;
    }

    public void p2(int... iArr) {
        this.I = a.c(iArr);
    }

    public void q2(int[] iArr, Context context) {
        List<Integer> arrayList = this.I;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.clear();
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(context.getResources().getColor(i10)));
        }
        this.I = arrayList;
    }

    @Override // qa.f
    public boolean r1() {
        return this.Q;
    }

    public void r2(int i10) {
        this.J = i10;
    }

    @Override // qa.f
    @Deprecated
    public boolean s1() {
        return this.H == Mode.STEPPED;
    }

    public void s2(float f10) {
        if (f10 >= 0.5f) {
            this.L = k.e(f10);
        }
    }

    public void t2(float f10) {
        if (f10 >= 1.0f) {
            this.K = k.e(f10);
        }
    }

    @Deprecated
    public void u2(float f10) {
        t2(f10);
    }

    public void v2(float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (f10 < 0.05f) {
            f10 = 0.05f;
        }
        this.M = f10;
    }

    public void w2(boolean z10) {
        this.Q = z10;
    }

    public void x2(boolean z10) {
        this.P = z10;
    }

    public void y2(na.f fVar) {
        if (fVar == null) {
            this.O = new c();
        } else {
            this.O = fVar;
        }
    }

    @Override // qa.f
    @Deprecated
    public boolean z() {
        return this.H == Mode.CUBIC_BEZIER;
    }

    public void z2(Mode mode) {
        this.H = mode;
    }
}
