package ia;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b {
    public c(int i10, int i11, boolean z10) {
        super(i10, i11, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.a
    /* JADX INFO: renamed from: h */
    public void a(qa.a aVar) {
        float f10;
        float fAbs;
        float fAbs2;
        float f11;
        float fE1 = aVar.e1() * this.f31992c;
        float f12 = this.f32000k / 2.0f;
        for (int i10 = 0; i10 < fE1; i10++) {
            BarEntry barEntry = (BarEntry) aVar.Z(i10);
            if (barEntry != null) {
                float F = barEntry.F();
                float fE = barEntry.e();
                float[] fArrB0 = barEntry.b0();
                if (!this.f31998i || fArrB0 == null) {
                    float f13 = F - f12;
                    float f14 = F + f12;
                    if (this.f31999j) {
                        f10 = fE >= 0.0f ? fE : 0.0f;
                        if (fE > 0.0f) {
                            fE = 0.0f;
                        }
                    } else {
                        float f15 = fE >= 0.0f ? fE : 0.0f;
                        if (fE > 0.0f) {
                            fE = 0.0f;
                        }
                        float f16 = fE;
                        fE = f15;
                        f10 = f16;
                    }
                    if (fE > 0.0f) {
                        fE *= this.f31993d;
                    } else {
                        f10 *= this.f31993d;
                    }
                    g(f10, f14, fE, f13);
                } else {
                    float f17 = -barEntry.X();
                    int i11 = 0;
                    float f18 = 0.0f;
                    while (i11 < fArrB0.length) {
                        float f19 = fArrB0[i11];
                        if (f19 >= 0.0f) {
                            fAbs = f19 + f18;
                            fAbs2 = f17;
                            f17 = f18;
                            f18 = fAbs;
                        } else {
                            fAbs = Math.abs(f19) + f17;
                            fAbs2 = Math.abs(f19) + f17;
                        }
                        float f20 = F - f12;
                        float f21 = F + f12;
                        if (this.f31999j) {
                            f11 = f17 >= fAbs ? f17 : fAbs;
                            if (f17 > fAbs) {
                                f17 = fAbs;
                            }
                        } else {
                            float f22 = f17 >= fAbs ? f17 : fAbs;
                            if (f17 > fAbs) {
                                f17 = fAbs;
                            }
                            float f23 = f17;
                            f17 = f22;
                            f11 = f23;
                        }
                        float f24 = this.f31993d;
                        g(f11 * f24, f21, f17 * f24, f20);
                        i11++;
                        f17 = fAbs2;
                    }
                }
            }
        }
        d();
    }
}
