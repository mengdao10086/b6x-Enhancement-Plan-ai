package la;

import android.graphics.Paint;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class j extends o<CandleEntry> implements qa.d {
    public float C;
    public boolean D;
    public float E;
    public boolean F;
    public Paint.Style G;
    public Paint.Style H;
    public int I;
    public int J;
    public int K;
    public int L;

    public j(List<CandleEntry> list, String str) {
        super(list, str);
        this.C = 3.0f;
        this.D = true;
        this.E = 0.1f;
        this.F = false;
        this.G = Paint.Style.STROKE;
        this.H = Paint.Style.FILL;
        this.I = xa.a.f54971b;
        this.J = xa.a.f54971b;
        this.K = xa.a.f54971b;
        this.L = xa.a.f54971b;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<CandleEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((CandleEntry) this.f16633s.get(i10)).z());
        }
        j jVar = new j(arrayList, J());
        e2(jVar);
        return jVar;
    }

    @Override // qa.d
    public int Q0() {
        return this.L;
    }

    @Override // qa.d
    public Paint.Style T() {
        return this.H;
    }

    @Override // qa.d
    public float X() {
        return this.E;
    }

    @Override // qa.d
    public int X0() {
        return this.J;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public void K1(CandleEntry candleEntry) {
        if (candleEntry.W() < this.f16635u) {
            this.f16635u = candleEntry.W();
        }
        if (candleEntry.V() > this.f16634t) {
            this.f16634t = candleEntry.V();
        }
        L1(candleEntry);
    }

    @Override // qa.d
    public boolean d1() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public void M1(CandleEntry candleEntry) {
        if (candleEntry.V() < this.f16635u) {
            this.f16635u = candleEntry.V();
        }
        if (candleEntry.V() > this.f16634t) {
            this.f16634t = candleEntry.V();
        }
        if (candleEntry.W() < this.f16635u) {
            this.f16635u = candleEntry.W();
        }
        if (candleEntry.W() > this.f16634t) {
            this.f16634t = candleEntry.W();
        }
    }

    @Override // qa.d
    public int e() {
        return this.I;
    }

    public void e2(j jVar) {
        super.U1(jVar);
        jVar.C = this.C;
        jVar.D = this.D;
        jVar.E = this.E;
        jVar.F = this.F;
        jVar.f39481x = this.f39481x;
        jVar.G = this.G;
        jVar.H = this.H;
        jVar.I = this.I;
        jVar.J = this.J;
        jVar.K = this.K;
        jVar.L = this.L;
    }

    public void f2(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 0.45f) {
            f10 = 0.45f;
        }
        this.E = f10;
    }

    public void g2(int i10) {
        this.K = i10;
    }

    public void h2(Paint.Style style) {
        this.H = style;
    }

    public void i2(int i10) {
        this.J = i10;
    }

    public void j2(Paint.Style style) {
        this.G = style;
    }

    public void k2(int i10) {
        this.I = i10;
    }

    @Override // qa.d
    public Paint.Style l0() {
        return this.G;
    }

    public void l2(int i10) {
        this.L = i10;
    }

    public void m2(boolean z10) {
        this.F = z10;
    }

    public void n2(float f10) {
        this.C = xa.k.e(f10);
    }

    public void o2(boolean z10) {
        this.D = z10;
    }

    @Override // qa.d
    public int p1() {
        return this.K;
    }

    @Override // qa.d
    public float s() {
        return this.C;
    }

    @Override // qa.d
    public boolean z0() {
        return this.F;
    }
}
