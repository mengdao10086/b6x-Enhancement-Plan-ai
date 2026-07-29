package va;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f52840n;

    public h(pa.a aVar, ha.a aVar2, xa.l lVar) {
        super(aVar, aVar2, lVar);
        this.f52840n = new RectF();
        this.f52839f.setTextAlign(Paint.Align.LEFT);
    }

    @Override // va.b, va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.b, va.g
    public void f(Canvas canvas) {
        List list;
        int i10;
        xa.g gVar;
        int i11;
        float[] fArr;
        float f10;
        int i12;
        float[] fArr2;
        float f11;
        float f12;
        BarEntry barEntry;
        int i13;
        List list2;
        float f13;
        xa.g gVar2;
        na.l lVar;
        int i14;
        ia.b bVar;
        if (k(this.f52810h)) {
            List listQ = this.f52810h.getBarData().q();
            float fE = xa.k.e(5.0f);
            boolean zC = this.f52810h.c();
            int i15 = 0;
            while (i15 < this.f52810h.getBarData().m()) {
                qa.a aVar = (qa.a) listQ.get(i15);
                if (m(aVar)) {
                    boolean zF = this.f52810h.f(aVar.a1());
                    a(aVar);
                    float f14 = 2.0f;
                    float fA = xa.k.a(this.f52839f, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) / 2.0f;
                    na.l lVarV = aVar.V();
                    ia.b bVar2 = this.f52812j[i15];
                    float fI = this.f52835b.i();
                    xa.g gVarD = xa.g.d(aVar.f1());
                    gVarD.f54987c = xa.k.e(gVarD.f54987c);
                    gVarD.f54988d = xa.k.e(gVarD.f54988d);
                    if (aVar.U0()) {
                        list = listQ;
                        i10 = i15;
                        gVar = gVarD;
                        xa.i iVarA = this.f52810h.a(aVar.a1());
                        int i16 = 0;
                        int length = 0;
                        while (i16 < aVar.e1() * this.f52835b.h()) {
                            BarEntry barEntry2 = (BarEntry) aVar.Z(i16);
                            int iV0 = aVar.v0(i16);
                            float[] fArrB0 = barEntry2.b0();
                            if (fArrB0 == null) {
                                int i17 = length + 1;
                                if (!this.f52889a.K(bVar2.f31991b[i17])) {
                                    break;
                                }
                                if (this.f52889a.L(bVar2.f31991b[length]) && this.f52889a.H(bVar2.f31991b[i17])) {
                                    String strD = lVarV.d(barEntry2);
                                    float fD = xa.k.d(this.f52839f, strD);
                                    float f15 = zC ? fE : -(fD + fE);
                                    float f16 = zC ? -(fD + fE) : fE;
                                    if (zF) {
                                        f15 = (-f15) - fD;
                                        f16 = (-f16) - fD;
                                    }
                                    float f17 = f15;
                                    float f18 = f16;
                                    if (aVar.V0()) {
                                        i11 = i16;
                                        fArr = fArrB0;
                                        barEntry = barEntry2;
                                        e(canvas, strD, bVar2.f31991b[length + 2] + (barEntry2.e() >= 0.0f ? f17 : f18), bVar2.f31991b[i17] + fA, iV0);
                                    } else {
                                        barEntry = barEntry2;
                                        i11 = i16;
                                        fArr = fArrB0;
                                    }
                                    if (barEntry.b() != null && aVar.C()) {
                                        Drawable drawableB = barEntry.b();
                                        float f19 = bVar2.f31991b[length + 2];
                                        if (barEntry.e() < 0.0f) {
                                            f17 = f18;
                                        }
                                        xa.k.k(canvas, drawableB, (int) (f19 + f17 + gVar.f54987c), (int) (bVar2.f31991b[i17] + gVar.f54988d), drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i11 = i16;
                                fArr = fArrB0;
                                int length2 = fArr.length * 2;
                                float[] fArr3 = new float[length2];
                                float f20 = -barEntry2.X();
                                int i18 = 0;
                                int i19 = 0;
                                float f21 = 0.0f;
                                while (i18 < length2) {
                                    float f22 = fArr[i19];
                                    if (f22 == 0.0f && (f21 == 0.0f || f20 == 0.0f)) {
                                        float f23 = f20;
                                        f20 = f22;
                                        f12 = f23;
                                    } else if (f22 >= 0.0f) {
                                        f21 += f22;
                                        f12 = f20;
                                        f20 = f21;
                                    } else {
                                        f12 = f20 - f22;
                                    }
                                    fArr3[i18] = f20 * fI;
                                    i18 += 2;
                                    i19++;
                                    f20 = f12;
                                }
                                iVarA.o(fArr3);
                                int i20 = 0;
                                while (i20 < length2) {
                                    float f24 = fArr[i20 / 2];
                                    String strE = lVarV.e(f24, barEntry2);
                                    float fD2 = xa.k.d(this.f52839f, strE);
                                    float f25 = zC ? fE : -(fD2 + fE);
                                    int i21 = length2;
                                    float f26 = zC ? -(fD2 + fE) : fE;
                                    if (zF) {
                                        f25 = (-f25) - fD2;
                                        f26 = (-f26) - fD2;
                                    }
                                    boolean z10 = (f24 == 0.0f && f20 == 0.0f && f21 > 0.0f) || f24 < 0.0f;
                                    float f27 = fArr3[i20];
                                    if (z10) {
                                        f25 = f26;
                                    }
                                    float f28 = f27 + f25;
                                    float[] fArr4 = bVar2.f31991b;
                                    float f29 = (fArr4[length + 1] + fArr4[length + 3]) / 2.0f;
                                    if (!this.f52889a.K(f29)) {
                                        break;
                                    }
                                    if (this.f52889a.L(f28) && this.f52889a.H(f29)) {
                                        if (aVar.V0()) {
                                            f10 = f29;
                                            i12 = i20;
                                            fArr2 = fArr3;
                                            f11 = f28;
                                            e(canvas, strE, f28, f29 + fA, iV0);
                                        } else {
                                            f10 = f29;
                                            i12 = i20;
                                            fArr2 = fArr3;
                                            f11 = f28;
                                        }
                                        if (barEntry2.b() != null && aVar.C()) {
                                            Drawable drawableB2 = barEntry2.b();
                                            xa.k.k(canvas, drawableB2, (int) (f11 + gVar.f54987c), (int) (f10 + gVar.f54988d), drawableB2.getIntrinsicWidth(), drawableB2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i12 = i20;
                                        fArr2 = fArr3;
                                    }
                                    i20 = i12 + 2;
                                    length2 = i21;
                                    fArr3 = fArr2;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i16 = i11 + 1;
                        }
                    } else {
                        int i22 = 0;
                        while (i22 < bVar2.f31991b.length * this.f52835b.h()) {
                            float[] fArr5 = bVar2.f31991b;
                            int i23 = i22 + 1;
                            float f30 = (fArr5[i23] + fArr5[i22 + 3]) / f14;
                            if (!this.f52889a.K(fArr5[i23])) {
                                break;
                            }
                            if (this.f52889a.L(bVar2.f31991b[i22]) && this.f52889a.H(bVar2.f31991b[i23])) {
                                BarEntry barEntry3 = (BarEntry) aVar.Z(i22 / 4);
                                float fE2 = barEntry3.e();
                                String strD2 = lVarV.d(barEntry3);
                                float fD3 = xa.k.d(this.f52839f, strD2);
                                float f31 = zC ? fE : -(fD3 + fE);
                                xa.g gVar3 = gVarD;
                                float f32 = zC ? -(fD3 + fE) : fE;
                                if (zF) {
                                    f31 = (-f31) - fD3;
                                    f32 = (-f32) - fD3;
                                }
                                float f33 = f31;
                                float f34 = f32;
                                if (aVar.V0()) {
                                    i13 = i22;
                                    list2 = listQ;
                                    gVar2 = gVar3;
                                    i14 = i15;
                                    bVar = bVar2;
                                    f13 = fA;
                                    lVar = lVarV;
                                    e(canvas, strD2, bVar2.f31991b[i22 + 2] + (fE2 >= 0.0f ? f33 : f34), f30 + fA, aVar.v0(i22 / 2));
                                } else {
                                    i13 = i22;
                                    list2 = listQ;
                                    f13 = fA;
                                    gVar2 = gVar3;
                                    lVar = lVarV;
                                    i14 = i15;
                                    bVar = bVar2;
                                }
                                if (barEntry3.b() != null && aVar.C()) {
                                    Drawable drawableB3 = barEntry3.b();
                                    float f35 = bVar.f31991b[i13 + 2];
                                    if (fE2 < 0.0f) {
                                        f33 = f34;
                                    }
                                    xa.k.k(canvas, drawableB3, (int) (f35 + f33 + gVar2.f54987c), (int) (f30 + gVar2.f54988d), drawableB3.getIntrinsicWidth(), drawableB3.getIntrinsicHeight());
                                }
                            } else {
                                i13 = i22;
                                list2 = listQ;
                                i14 = i15;
                                f13 = fA;
                                gVar2 = gVarD;
                                bVar = bVar2;
                                lVar = lVarV;
                            }
                            i22 = i13 + 4;
                            gVarD = gVar2;
                            bVar2 = bVar;
                            lVarV = lVar;
                            listQ = list2;
                            i15 = i14;
                            fA = f13;
                            f14 = 2.0f;
                        }
                        list = listQ;
                        i10 = i15;
                        gVar = gVarD;
                    }
                    xa.g.h(gVar);
                } else {
                    list = listQ;
                    i10 = i15;
                }
                i15 = i10 + 1;
                listQ = list;
            }
        }
    }

    @Override // va.b, va.g
    public void j() {
        la.a barData = this.f52810h.getBarData();
        this.f52812j = new ia.c[barData.m()];
        for (int i10 = 0; i10 < this.f52812j.length; i10++) {
            qa.a aVar = (qa.a) barData.k(i10);
            this.f52812j[i10] = new ia.c(aVar.e1() * 4 * (aVar.U0() ? aVar.D0() : 1), barData.m(), aVar.U0());
        }
    }

    @Override // va.g
    public boolean k(pa.e eVar) {
        return ((float) eVar.getData().r()) < ((float) eVar.getMaxVisibleCount()) * this.f52889a.x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.b
    public void n(Canvas canvas, qa.a aVar, int i10) {
        xa.i iVarA = this.f52810h.a(aVar.a1());
        this.f52814l.setColor(aVar.w());
        this.f52814l.setStrokeWidth(xa.k.e(aVar.G()));
        boolean z10 = aVar.G() > 0.0f;
        float fH = this.f52835b.h();
        float fI = this.f52835b.i();
        if (this.f52810h.b()) {
            this.f52813k.setColor(aVar.n0());
            float fQ = this.f52810h.getBarData().Q() / 2.0f;
            int iMin = Math.min((int) Math.ceil(aVar.e1() * fH), aVar.e1());
            for (int i11 = 0; i11 < iMin; i11++) {
                float F = ((BarEntry) aVar.Z(i11)).F();
                RectF rectF = this.f52840n;
                rectF.top = F - fQ;
                rectF.bottom = F + fQ;
                iVarA.t(rectF);
                if (this.f52889a.K(this.f52840n.bottom)) {
                    if (!this.f52889a.H(this.f52840n.top)) {
                        break;
                    }
                    this.f52840n.left = this.f52889a.h();
                    this.f52840n.right = this.f52889a.i();
                    canvas.drawRect(this.f52840n, this.f52813k);
                }
            }
        }
        ia.b bVar = this.f52812j[i10];
        bVar.e(fH, fI);
        bVar.j(i10);
        bVar.k(this.f52810h.f(aVar.a1()));
        bVar.i(this.f52810h.getBarData().Q());
        bVar.a(aVar);
        iVarA.o(bVar.f31991b);
        boolean z11 = aVar.C0().size() == 1;
        if (z11) {
            this.f52836c.setColor(aVar.g1());
        }
        for (int i12 = 0; i12 < bVar.f(); i12 += 4) {
            int i13 = i12 + 3;
            if (!this.f52889a.K(bVar.f31991b[i13])) {
                return;
            }
            int i14 = i12 + 1;
            if (this.f52889a.H(bVar.f31991b[i14])) {
                if (!z11) {
                    this.f52836c.setColor(aVar.f0(i12 / 4));
                }
                float[] fArr = bVar.f31991b;
                int i15 = i12 + 2;
                canvas.drawRect(fArr[i12], fArr[i14], fArr[i15], fArr[i13], this.f52836c);
                if (z10) {
                    float[] fArr2 = bVar.f31991b;
                    canvas.drawRect(fArr2[i12], fArr2[i14], fArr2[i15], fArr2[i13], this.f52814l);
                }
            }
        }
    }

    @Override // va.b
    public void o(float f10, float f11, float f12, float f13, xa.i iVar) {
        this.f52811i.set(f11, f10 - f13, f12, f10 + f13);
        iVar.s(this.f52811i, this.f52835b.i());
    }

    @Override // va.b
    public void p(oa.d dVar, RectF rectF) {
        dVar.n(rectF.centerY(), rectF.right);
    }
}
