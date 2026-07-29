package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;
import va.c;

/* JADX INFO: loaded from: classes3.dex */
public class e extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public pa.d f52825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f52826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f52827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f52828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float[] f52829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f52830n;

    public e(pa.d dVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52826j = new float[8];
        this.f52827k = new float[4];
        this.f52828l = new float[4];
        this.f52829m = new float[4];
        this.f52830n = new float[4];
        this.f52825i = dVar;
    }

    @Override // va.g
    public void b(Canvas canvas) {
        for (T t10 : this.f52825i.getCandleData().q()) {
            if (t10.isVisible()) {
                o(canvas, t10);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        la.i candleData = this.f52825i.getCandleData();
        for (oa.d dVar : dVarArr) {
            qa.h hVar = (qa.d) candleData.k(dVar.d());
            if (hVar != null && hVar.i1()) {
                CandleEntry candleEntry = (CandleEntry) hVar.y(dVar.h(), dVar.j());
                if (l(candleEntry, hVar)) {
                    xa.f fVarF = this.f52825i.a(hVar.a1()).f(candleEntry.F(), ((candleEntry.W() * this.f52835b.i()) + (candleEntry.V() * this.f52835b.i())) / 2.0f);
                    dVar.n((float) fVarF.f54983c, (float) fVarF.f54984d);
                    n(canvas, (float) fVarF.f54983c, (float) fVarF.f54984d, hVar);
                }
            }
        }
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void f(Canvas canvas) {
        qa.d dVar;
        CandleEntry candleEntry;
        float f10;
        if (k(this.f52825i)) {
            List<T> listQ = this.f52825i.getCandleData().q();
            for (int i10 = 0; i10 < listQ.size(); i10++) {
                qa.d dVar2 = (qa.d) listQ.get(i10);
                if (m(dVar2) && dVar2.e1() >= 1) {
                    a(dVar2);
                    xa.i iVarA = this.f52825i.a(dVar2.a1());
                    this.f52816g.a(this.f52825i, dVar2);
                    float fH = this.f52835b.h();
                    float fI = this.f52835b.i();
                    c.a aVar = this.f52816g;
                    float[] fArrB = iVarA.b(dVar2, fH, fI, aVar.f52817a, aVar.f52818b);
                    float fE = xa.k.e(5.0f);
                    na.l lVarV = dVar2.V();
                    xa.g gVarD = xa.g.d(dVar2.f1());
                    gVarD.f54987c = xa.k.e(gVarD.f54987c);
                    gVarD.f54988d = xa.k.e(gVarD.f54988d);
                    int i11 = 0;
                    while (i11 < fArrB.length) {
                        float f11 = fArrB[i11];
                        float f12 = fArrB[i11 + 1];
                        if (!this.f52889a.J(f11)) {
                            break;
                        }
                        if (this.f52889a.I(f11) && this.f52889a.M(f12)) {
                            int i12 = i11 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) dVar2.Z(this.f52816g.f52817a + i12);
                            if (dVar2.V0()) {
                                candleEntry = candleEntry2;
                                f10 = f12;
                                dVar = dVar2;
                                e(canvas, lVarV.g(candleEntry2), f11, f12 - fE, dVar2.v0(i12));
                            } else {
                                candleEntry = candleEntry2;
                                f10 = f12;
                                dVar = dVar2;
                            }
                            if (candleEntry.b() != null && dVar.C()) {
                                Drawable drawableB = candleEntry.b();
                                xa.k.k(canvas, drawableB, (int) (f11 + gVarD.f54987c), (int) (f10 + gVarD.f54988d), drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                            }
                        } else {
                            dVar = dVar2;
                        }
                        i11 += 2;
                        dVar2 = dVar;
                    }
                    xa.g.h(gVarD);
                }
            }
        }
    }

    @Override // va.g
    public void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(Canvas canvas, qa.d dVar) {
        xa.i iVarA = this.f52825i.a(dVar.a1());
        float fI = this.f52835b.i();
        float fX = dVar.X();
        boolean zD1 = dVar.d1();
        this.f52816g.a(this.f52825i, dVar);
        this.f52836c.setStrokeWidth(dVar.s());
        int i10 = this.f52816g.f52817a;
        while (true) {
            c.a aVar = this.f52816g;
            if (i10 > aVar.f52819c + aVar.f52817a) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) dVar.Z(i10);
            if (candleEntry != null) {
                float F = candleEntry.F();
                float fX2 = candleEntry.X();
                float fU = candleEntry.U();
                float fV = candleEntry.V();
                float fW = candleEntry.W();
                if (zD1) {
                    float[] fArr = this.f52826j;
                    fArr[0] = F;
                    fArr[2] = F;
                    fArr[4] = F;
                    fArr[6] = F;
                    if (fX2 > fU) {
                        fArr[1] = fV * fI;
                        fArr[3] = fX2 * fI;
                        fArr[5] = fW * fI;
                        fArr[7] = fU * fI;
                    } else if (fX2 < fU) {
                        fArr[1] = fV * fI;
                        fArr[3] = fU * fI;
                        fArr[5] = fW * fI;
                        fArr[7] = fX2 * fI;
                    } else {
                        fArr[1] = fV * fI;
                        fArr[3] = fX2 * fI;
                        fArr[5] = fW * fI;
                        fArr[7] = fArr[3];
                    }
                    iVarA.o(fArr);
                    if (!dVar.z0()) {
                        this.f52836c.setColor(dVar.Q0() == 1122867 ? dVar.f0(i10) : dVar.Q0());
                    } else if (fX2 > fU) {
                        this.f52836c.setColor(dVar.p1() == 1122867 ? dVar.f0(i10) : dVar.p1());
                    } else if (fX2 < fU) {
                        this.f52836c.setColor(dVar.X0() == 1122867 ? dVar.f0(i10) : dVar.X0());
                    } else {
                        this.f52836c.setColor(dVar.e() == 1122867 ? dVar.f0(i10) : dVar.e());
                    }
                    this.f52836c.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.f52826j, this.f52836c);
                    float[] fArr2 = this.f52827k;
                    fArr2[0] = (F - 0.5f) + fX;
                    fArr2[1] = fU * fI;
                    fArr2[2] = (F + 0.5f) - fX;
                    fArr2[3] = fX2 * fI;
                    iVarA.o(fArr2);
                    if (fX2 > fU) {
                        if (dVar.p1() == 1122867) {
                            this.f52836c.setColor(dVar.f0(i10));
                        } else {
                            this.f52836c.setColor(dVar.p1());
                        }
                        this.f52836c.setStyle(dVar.T());
                        float[] fArr3 = this.f52827k;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.f52836c);
                    } else if (fX2 < fU) {
                        if (dVar.X0() == 1122867) {
                            this.f52836c.setColor(dVar.f0(i10));
                        } else {
                            this.f52836c.setColor(dVar.X0());
                        }
                        this.f52836c.setStyle(dVar.l0());
                        float[] fArr4 = this.f52827k;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.f52836c);
                    } else {
                        if (dVar.e() == 1122867) {
                            this.f52836c.setColor(dVar.f0(i10));
                        } else {
                            this.f52836c.setColor(dVar.e());
                        }
                        float[] fArr5 = this.f52827k;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.f52836c);
                    }
                } else {
                    float[] fArr6 = this.f52828l;
                    fArr6[0] = F;
                    fArr6[1] = fV * fI;
                    fArr6[2] = F;
                    fArr6[3] = fW * fI;
                    float[] fArr7 = this.f52829m;
                    fArr7[0] = (F - 0.5f) + fX;
                    float f10 = fX2 * fI;
                    fArr7[1] = f10;
                    fArr7[2] = F;
                    fArr7[3] = f10;
                    float[] fArr8 = this.f52830n;
                    fArr8[0] = (0.5f + F) - fX;
                    float f11 = fU * fI;
                    fArr8[1] = f11;
                    fArr8[2] = F;
                    fArr8[3] = f11;
                    iVarA.o(fArr6);
                    iVarA.o(this.f52829m);
                    iVarA.o(this.f52830n);
                    this.f52836c.setColor(fX2 > fU ? dVar.p1() == 1122867 ? dVar.f0(i10) : dVar.p1() : fX2 < fU ? dVar.X0() == 1122867 ? dVar.f0(i10) : dVar.X0() : dVar.e() == 1122867 ? dVar.f0(i10) : dVar.e());
                    float[] fArr9 = this.f52828l;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.f52836c);
                    float[] fArr10 = this.f52829m;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.f52836c);
                    float[] fArr11 = this.f52830n;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.f52836c);
                }
            }
            i10++;
        }
    }
}
