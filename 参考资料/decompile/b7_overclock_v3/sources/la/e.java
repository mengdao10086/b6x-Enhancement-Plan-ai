package la;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<T extends Entry> implements qa.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f39482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ua.a f39483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<ua.a> f39484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f39485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f39486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public YAxis.AxisDependency f39487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f39488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient na.l f39489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Typeface f39490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Legend.LegendForm f39491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f39492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f39493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DashPathEffect f39494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f39495n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f39496o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public xa.g f39497p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f39498q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f39499r;

    public e() {
        this.f39482a = null;
        this.f39483b = null;
        this.f39484c = null;
        this.f39485d = null;
        this.f39486e = "DataSet";
        this.f39487f = YAxis.AxisDependency.LEFT;
        this.f39488g = true;
        this.f39491j = Legend.LegendForm.DEFAULT;
        this.f39492k = Float.NaN;
        this.f39493l = Float.NaN;
        this.f39494m = null;
        this.f39495n = true;
        this.f39496o = true;
        this.f39497p = new xa.g();
        this.f39498q = 17.0f;
        this.f39499r = true;
        this.f39482a = new ArrayList();
        this.f39485d = new ArrayList();
        this.f39482a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f39485d.add(-16777216);
    }

    @Override // qa.e
    public void A0(float f10) {
        this.f39498q = xa.k.e(f10);
    }

    public void A1(List<Integer> list) {
        this.f39482a = list;
    }

    public void B1(int... iArr) {
        this.f39482a = xa.a.c(iArr);
    }

    @Override // qa.e
    public boolean C() {
        return this.f39496o;
    }

    @Override // qa.e
    public List<Integer> C0() {
        return this.f39482a;
    }

    public void C1(int[] iArr, int i10) {
        x1();
        for (int i11 : iArr) {
            t1(Color.argb(i10, Color.red(i11), Color.green(i11), Color.blue(i11)));
        }
    }

    @Override // qa.e
    public Legend.LegendForm D() {
        return this.f39491j;
    }

    public void D1(int[] iArr, Context context) {
        if (this.f39482a == null) {
            this.f39482a = new ArrayList();
        }
        this.f39482a.clear();
        for (int i10 : iArr) {
            this.f39482a.add(Integer.valueOf(context.getResources().getColor(i10)));
        }
    }

    @Override // qa.e
    public void E(Typeface typeface) {
        this.f39490i = typeface;
    }

    public void E1(Legend.LegendForm legendForm) {
        this.f39491j = legendForm;
    }

    public void F1(DashPathEffect dashPathEffect) {
        this.f39494m = dashPathEffect;
    }

    public void G1(float f10) {
        this.f39493l = f10;
    }

    @Override // qa.e
    public int H() {
        return this.f39485d.get(0).intValue();
    }

    @Override // qa.e
    public void H0(List<Integer> list) {
        this.f39485d = list;
    }

    public void H1(float f10) {
        this.f39492k = f10;
    }

    @Override // qa.e
    public void I(na.l lVar) {
        if (lVar == null) {
            return;
        }
        this.f39489h = lVar;
    }

    public void I1(int i10, int i11) {
        this.f39483b = new ua.a(i10, i11);
    }

    @Override // qa.e
    public String J() {
        return this.f39486e;
    }

    public void J1(List<ua.a> list) {
        this.f39484c = list;
    }

    @Override // qa.e
    public List<ua.a> N0() {
        return this.f39484c;
    }

    @Override // qa.e
    public ua.a O() {
        return this.f39483b;
    }

    @Override // qa.e
    public int P(int i10) {
        for (int i11 = 0; i11 < e1(); i11++) {
            if (i10 == Z(i11).F()) {
                return i11;
            }
        }
        return -1;
    }

    @Override // qa.e
    public void R(int i10) {
        this.f39485d.clear();
        this.f39485d.add(Integer.valueOf(i10));
    }

    @Override // qa.e
    public float U() {
        return this.f39498q;
    }

    @Override // qa.e
    public na.l V() {
        return o0() ? xa.k.s() : this.f39489h;
    }

    @Override // qa.e
    public boolean V0() {
        return this.f39495n;
    }

    @Override // qa.e
    public float Y() {
        return this.f39493l;
    }

    @Override // qa.e
    public YAxis.AxisDependency a1() {
        return this.f39487f;
    }

    @Override // qa.e
    public void b(xa.g gVar) {
        xa.g gVar2 = this.f39497p;
        gVar2.f54987c = gVar.f54987c;
        gVar2.f54988d = gVar.f54988d;
    }

    @Override // qa.e
    public boolean b1(int i10) {
        return p0(Z(i10));
    }

    @Override // qa.e
    public void c(boolean z10) {
        this.f39488g = z10;
    }

    @Override // qa.e
    public void c1(boolean z10) {
        this.f39495n = z10;
    }

    @Override // qa.e
    public float d0() {
        return this.f39492k;
    }

    @Override // qa.e
    public int f0(int i10) {
        List<Integer> list = this.f39482a;
        return list.get(i10 % list.size()).intValue();
    }

    @Override // qa.e
    public xa.g f1() {
        return this.f39497p;
    }

    @Override // qa.e
    public int g1() {
        return this.f39482a.get(0).intValue();
    }

    @Override // qa.e
    public boolean i1() {
        return this.f39488g;
    }

    @Override // qa.e
    public boolean isVisible() {
        return this.f39499r;
    }

    @Override // qa.e
    public void k0(boolean z10) {
        this.f39496o = z10;
    }

    @Override // qa.e
    public void l(YAxis.AxisDependency axisDependency) {
        this.f39487f = axisDependency;
    }

    @Override // qa.e
    public Typeface m0() {
        return this.f39490i;
    }

    @Override // qa.e
    public ua.a m1(int i10) {
        List<ua.a> list = this.f39484c;
        return list.get(i10 % list.size());
    }

    @Override // qa.e
    public boolean o0() {
        return this.f39489h == null;
    }

    @Override // qa.e
    public void o1(String str) {
        this.f39486e = str;
    }

    @Override // qa.e
    public boolean r(float f10) {
        return p0(y(f10, Float.NaN));
    }

    @Override // qa.e
    public boolean removeFirst() {
        if (e1() > 0) {
            return p0(Z(0));
        }
        return false;
    }

    @Override // qa.e
    public boolean removeLast() {
        if (e1() > 0) {
            return p0(Z(e1() - 1));
        }
        return false;
    }

    @Override // qa.e
    public void setVisible(boolean z10) {
        this.f39499r = z10;
    }

    public void t1(int i10) {
        if (this.f39482a == null) {
            this.f39482a = new ArrayList();
        }
        this.f39482a.add(Integer.valueOf(i10));
    }

    public void u1(e eVar) {
        eVar.f39487f = this.f39487f;
        eVar.f39482a = this.f39482a;
        eVar.f39496o = this.f39496o;
        eVar.f39495n = this.f39495n;
        eVar.f39491j = this.f39491j;
        eVar.f39494m = this.f39494m;
        eVar.f39493l = this.f39493l;
        eVar.f39492k = this.f39492k;
        eVar.f39483b = this.f39483b;
        eVar.f39484c = this.f39484c;
        eVar.f39488g = this.f39488g;
        eVar.f39497p = this.f39497p;
        eVar.f39485d = this.f39485d;
        eVar.f39489h = this.f39489h;
        eVar.f39485d = this.f39485d;
        eVar.f39498q = this.f39498q;
        eVar.f39499r = this.f39499r;
    }

    @Override // qa.e
    public int v0(int i10) {
        List<Integer> list = this.f39485d;
        return list.get(i10 % list.size()).intValue();
    }

    public List<Integer> v1() {
        return this.f39485d;
    }

    public void w1() {
        K0();
    }

    @Override // qa.e
    public DashPathEffect x() {
        return this.f39494m;
    }

    public void x1() {
        if (this.f39482a == null) {
            this.f39482a = new ArrayList();
        }
        this.f39482a.clear();
    }

    @Override // qa.e
    public boolean y0(T t10) {
        for (int i10 = 0; i10 < e1(); i10++) {
            if (Z(i10).equals(t10)) {
                return true;
            }
        }
        return false;
    }

    public void y1(int i10) {
        x1();
        this.f39482a.add(Integer.valueOf(i10));
    }

    public void z1(int i10, int i11) {
        y1(Color.argb(i11, Color.red(i10), Color.green(i10), Color.blue(i10)));
    }

    public e(String str) {
        this();
        this.f39486e = str;
    }
}
