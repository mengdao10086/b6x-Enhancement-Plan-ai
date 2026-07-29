package la;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.RadarEntry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class r extends n<RadarEntry> implements qa.j {
    public boolean H;
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public float N;

    public r(List<RadarEntry> list, String str) {
        super(list, str);
        this.H = false;
        this.I = -1;
        this.J = xa.a.f54970a;
        this.K = 76;
        this.L = 3.0f;
        this.M = 4.0f;
        this.N = 2.0f;
    }

    @Override // qa.j
    public boolean A() {
        return this.H;
    }

    @Override // qa.j
    public void G0(boolean z10) {
        this.H = z10;
    }

    @Override // qa.j
    public float M() {
        return this.M;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<RadarEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((RadarEntry) this.f16633s.get(i10)).z());
        }
        r rVar = new r(arrayList, J());
        h2(rVar);
        return rVar;
    }

    @Override // qa.j
    public float d() {
        return this.N;
    }

    public void h2(r rVar) {
        super.c2(rVar);
        rVar.H = this.H;
        rVar.I = this.I;
        rVar.L = this.L;
        rVar.K = this.K;
        rVar.J = this.J;
        rVar.N = this.N;
    }

    @Override // qa.j
    public int i() {
        return this.I;
    }

    public void i2(int i10) {
        this.I = i10;
    }

    public void j2(float f10) {
        this.L = f10;
    }

    @Override // qa.j
    public float k() {
        return this.L;
    }

    public void k2(float f10) {
        this.M = f10;
    }

    public void l2(int i10) {
        this.K = i10;
    }

    public void m2(int i10) {
        this.J = i10;
    }

    @Override // qa.j
    public int n() {
        return this.K;
    }

    public void n2(float f10) {
        this.N = f10;
    }

    @Override // qa.j
    public int u() {
        return this.J;
    }
}
