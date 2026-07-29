package la;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends c<qa.a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f39478j;

    public a() {
        this.f39478j = 0.85f;
    }

    public float Q() {
        return this.f39478j;
    }

    public float R(float f10, float f11) {
        return (this.f39513i.size() * (this.f39478j + f11)) + f10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S(float f10, float f11, float f12) {
        BarEntry barEntry;
        if (this.f39513i.size() <= 1) {
            throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
        }
        int iE1 = ((qa.a) w()).e1();
        float f13 = f11 / 2.0f;
        float f14 = f12 / 2.0f;
        float f15 = this.f39478j / 2.0f;
        float fR = R(f11, f12);
        for (int i10 = 0; i10 < iE1; i10++) {
            float f16 = f10 + f13;
            for (T t10 : this.f39513i) {
                float f17 = f16 + f14 + f15;
                if (i10 < t10.e1() && (barEntry = (BarEntry) t10.Z(i10)) != null) {
                    barEntry.M(f17);
                }
                f16 = f17 + f15 + f14;
            }
            float f18 = f16 + f13;
            float f19 = fR - (f18 - f10);
            if (f19 > 0.0f || f19 < 0.0f) {
                f18 += f19;
            }
            f10 = f18;
        }
        E();
    }

    public void T(float f10) {
        this.f39478j = f10;
    }

    public a(qa.a... aVarArr) {
        super(aVarArr);
        this.f39478j = 0.85f;
    }

    public a(List<qa.a> list) {
        super(list);
        this.f39478j = 0.85f;
    }
}
