package la;

import android.graphics.Color;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b extends d<BarEntry> implements qa.a {
    public float A;
    public int B;
    public int C;
    public int D;
    public String[] E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f39479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f39480z;

    public b(List<BarEntry> list, String str) {
        super(list, str);
        this.f39479y = 1;
        this.f39480z = Color.rgb(mb.e.f41076x1, mb.e.f41076x1, mb.e.f41076x1);
        this.A = 0.0f;
        this.B = -16777216;
        this.C = 120;
        this.D = 0;
        this.E = new String[]{"Stack"};
        this.f39481x = Color.rgb(0, 0, 0);
        W1(list);
        U1(list);
    }

    @Override // qa.a
    public int D0() {
        return this.f39479y;
    }

    @Override // qa.a
    public float G() {
        return this.A;
    }

    @Override // qa.a
    public int M0() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f16633s.size(); i10++) {
            arrayList.add(((BarEntry) this.f16633s.get(i10)).z());
        }
        b bVar = new b(arrayList, J());
        X1(bVar);
        return bVar;
    }

    @Override // qa.a
    public boolean U0() {
        return this.f39479y > 1;
    }

    public final void U1(List<BarEntry> list) {
        this.D = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            float[] fArrB0 = list.get(i10).b0();
            if (fArrB0 == null) {
                this.D++;
            } else {
                this.D += fArrB0.length;
            }
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public void K1(BarEntry barEntry) {
        if (barEntry == null || Float.isNaN(barEntry.e())) {
            return;
        }
        if (barEntry.b0() == null) {
            if (barEntry.e() < this.f16635u) {
                this.f16635u = barEntry.e();
            }
            if (barEntry.e() > this.f16634t) {
                this.f16634t = barEntry.e();
            }
        } else {
            if ((-barEntry.X()) < this.f16635u) {
                this.f16635u = -barEntry.X();
            }
            if (barEntry.Y() > this.f16634t) {
                this.f16634t = barEntry.Y();
            }
        }
        L1(barEntry);
    }

    @Override // qa.a
    public String[] W0() {
        return this.E;
    }

    public final void W1(List<BarEntry> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            float[] fArrB0 = list.get(i10).b0();
            if (fArrB0 != null && fArrB0.length > this.f39479y) {
                this.f39479y = fArrB0.length;
            }
        }
    }

    public void X1(b bVar) {
        super.S1(bVar);
        bVar.f39479y = this.f39479y;
        bVar.f39480z = this.f39480z;
        bVar.A = this.A;
        bVar.E = this.E;
        bVar.C = this.C;
    }

    public int Y1() {
        return this.D;
    }

    public void Z1(int i10) {
        this.B = i10;
    }

    public void a2(float f10) {
        this.A = f10;
    }

    public void b2(int i10) {
        this.f39480z = i10;
    }

    public void c2(int i10) {
        this.C = i10;
    }

    public void d2(String[] strArr) {
        this.E = strArr;
    }

    @Override // qa.a
    public int n0() {
        return this.f39480z;
    }

    @Override // qa.a
    public int w() {
        return this.B;
    }
}
