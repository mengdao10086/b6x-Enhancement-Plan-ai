package la;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class t extends o<Entry> implements qa.k {
    public float C;
    public wa.e D;
    public float E;
    public int F;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39522a;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            f39522a = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39522a[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public t(List<Entry> list, String str) {
        super(list, str);
        this.C = 15.0f;
        this.D = new wa.f();
        this.E = 0.0f;
        this.F = xa.a.f54970a;
    }

    public static wa.e d2(ScatterChart.ScatterShape scatterShape) {
        switch (a.f39522a[scatterShape.ordinal()]) {
            case 1:
                return new wa.f();
            case 2:
                return new wa.c();
            case 3:
                return new wa.g();
            case 4:
                return new wa.d();
            case 5:
                return new wa.h();
            case 6:
                return new wa.b();
            case 7:
                return new wa.a();
            default:
                return null;
        }
    }

    @Override // qa.k
    public int I0() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((Entry) this.f16633s.get(i10)).z());
        }
        t tVar = new t(arrayList, J());
        c2(tVar);
        return tVar;
    }

    @Override // qa.k
    public wa.e O0() {
        return this.D;
    }

    public void c2(t tVar) {
        super.U1(tVar);
        tVar.C = this.C;
        tVar.D = this.D;
        tVar.E = this.E;
        tVar.F = this.F;
    }

    public void e2(ScatterChart.ScatterShape scatterShape) {
        this.D = d2(scatterShape);
    }

    public void f2(int i10) {
        this.F = i10;
    }

    public void g2(float f10) {
        this.E = f10;
    }

    public void h2(float f10) {
        this.C = f10;
    }

    public void i2(wa.e eVar) {
        this.D = eVar;
    }

    @Override // qa.k
    public float q1() {
        return this.E;
    }

    @Override // qa.k
    public float r0() {
        return this.C;
    }
}
