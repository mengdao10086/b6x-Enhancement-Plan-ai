package ia;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a<qa.a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f31996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f31997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f32000k;

    public b(int i10, int i11, boolean z10) {
        super(i10);
        this.f31996g = 0;
        this.f31999j = false;
        this.f32000k = 1.0f;
        this.f31997h = i11;
        this.f31998i = z10;
    }

    public void g(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f31991b;
        int i10 = this.f31990a;
        int i11 = i10 + 1;
        this.f31990a = i11;
        fArr[i10] = f10;
        int i12 = i11 + 1;
        this.f31990a = i12;
        fArr[i11] = f11;
        int i13 = i12 + 1;
        this.f31990a = i13;
        fArr[i12] = f12;
        this.f31990a = i13 + 1;
        fArr[i13] = f13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
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
                    g(f13, fE, f14, f10);
                } else {
                    float f17 = -barEntry.X();
                    int i11 = 0;
                    float f18 = 0.0f;
                    while (i11 < fArrB0.length) {
                        float f19 = fArrB0[i11];
                        if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                            fAbs = f19;
                            fAbs2 = f17;
                            f17 = fAbs;
                        } else if (f19 >= 0.0f) {
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
                        g(f20, f17 * f24, f21, f11 * f24);
                        i11++;
                        f17 = fAbs2;
                    }
                }
            }
        }
        d();
    }

    public void i(float f10) {
        this.f32000k = f10;
    }

    public void j(int i10) {
        this.f31996g = i10;
    }

    public void k(boolean z10) {
        this.f31999j = z10;
    }
}
