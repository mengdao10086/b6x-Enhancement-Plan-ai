package va;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pa.a f52810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f52811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ia.b[] f52812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f52813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f52814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f52815m;

    public b(pa.a aVar, ha.a aVar2, xa.l lVar) {
        super(aVar2, lVar);
        this.f52811i = new RectF();
        this.f52815m = new RectF();
        this.f52810h = aVar;
        Paint paint = new Paint(1);
        this.f52837d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52837d.setColor(Color.rgb(0, 0, 0));
        this.f52837d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f52813k = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f52814l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // va.g
    public void b(Canvas canvas) {
        la.a barData = this.f52810h.getBarData();
        for (int i10 = 0; i10 < barData.m(); i10++) {
            qa.a aVar = (qa.a) barData.k(i10);
            if (aVar.isVisible()) {
                n(canvas, aVar, i10);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        float fE;
        float f10;
        la.a barData = this.f52810h.getBarData();
        for (oa.d dVar : dVarArr) {
            qa.a aVar = (qa.a) barData.k(dVar.d());
            if (aVar != null && aVar.i1()) {
                BarEntry barEntry = (BarEntry) aVar.y(dVar.h(), dVar.j());
                if (l(barEntry, aVar)) {
                    xa.i iVarA = this.f52810h.a(aVar.a1());
                    this.f52837d.setColor(aVar.Y0());
                    this.f52837d.setAlpha(aVar.M0());
                    if (!(dVar.g() >= 0 && barEntry.c0())) {
                        fE = barEntry.e();
                        f10 = 0.0f;
                    } else if (this.f52810h.d()) {
                        float fY = barEntry.Y();
                        f10 = -barEntry.X();
                        fE = fY;
                    } else {
                        oa.j jVar = barEntry.Z()[dVar.g()];
                        fE = jVar.f43025a;
                        f10 = jVar.f43026b;
                    }
                    o(barEntry.F(), fE, f10, barData.Q() / 2.0f, iVarA);
                    p(dVar, this.f52811i);
                    canvas.drawRect(this.f52811i, this.f52837d);
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
        List list;
        xa.g gVar;
        int i10;
        float f10;
        boolean z10;
        float[] fArr;
        xa.i iVar;
        int i11;
        float f11;
        int i12;
        BarEntry barEntry;
        float[] fArr2;
        float f12;
        float f13;
        float f14;
        BarEntry barEntry2;
        float f15;
        boolean z11;
        int i13;
        na.l lVar;
        List list2;
        xa.g gVar2;
        BarEntry barEntry3;
        float f16;
        if (k(this.f52810h)) {
            List listQ = this.f52810h.getBarData().q();
            float fE = xa.k.e(4.5f);
            boolean zC = this.f52810h.c();
            int i14 = 0;
            while (i14 < this.f52810h.getBarData().m()) {
                qa.a aVar = (qa.a) listQ.get(i14);
                if (m(aVar)) {
                    a(aVar);
                    boolean zF = this.f52810h.f(aVar.a1());
                    float fA = xa.k.a(this.f52839f, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                    float f17 = zC ? -fE : fA + fE;
                    float f18 = zC ? fA + fE : -fE;
                    if (zF) {
                        f17 = (-f17) - fA;
                        f18 = (-f18) - fA;
                    }
                    float f19 = f17;
                    float f20 = f18;
                    ia.b bVar = this.f52812j[i14];
                    float fI = this.f52835b.i();
                    na.l lVarV = aVar.V();
                    xa.g gVarD = xa.g.d(aVar.f1());
                    gVarD.f54987c = xa.k.e(gVarD.f54987c);
                    gVarD.f54988d = xa.k.e(gVarD.f54988d);
                    if (aVar.U0()) {
                        list = listQ;
                        gVar = gVarD;
                        xa.i iVarA = this.f52810h.a(aVar.a1());
                        int i15 = 0;
                        int length = 0;
                        while (i15 < aVar.e1() * this.f52835b.h()) {
                            BarEntry barEntry4 = (BarEntry) aVar.Z(i15);
                            float[] fArrB0 = barEntry4.b0();
                            float[] fArr3 = bVar.f31991b;
                            float f21 = (fArr3[length] + fArr3[length + 2]) / 2.0f;
                            int iV0 = aVar.v0(i15);
                            if (fArrB0 != null) {
                                BarEntry barEntry5 = barEntry4;
                                i10 = i15;
                                f10 = fE;
                                z10 = zC;
                                fArr = fArrB0;
                                iVar = iVarA;
                                float f22 = f21;
                                int length2 = fArr.length * 2;
                                float[] fArr4 = new float[length2];
                                float f23 = -barEntry5.X();
                                int i16 = 0;
                                int i17 = 0;
                                float f24 = 0.0f;
                                while (i16 < length2) {
                                    float f25 = fArr[i17];
                                    if (f25 == 0.0f && (f24 == 0.0f || f23 == 0.0f)) {
                                        float f26 = f23;
                                        f23 = f25;
                                        f13 = f26;
                                    } else if (f25 >= 0.0f) {
                                        f24 += f25;
                                        f13 = f23;
                                        f23 = f24;
                                    } else {
                                        f13 = f23 - f25;
                                    }
                                    fArr4[i16 + 1] = f23 * fI;
                                    i16 += 2;
                                    i17++;
                                    f23 = f13;
                                }
                                iVar.o(fArr4);
                                int i18 = 0;
                                while (i18 < length2) {
                                    float f27 = fArr[i18 / 2];
                                    float f28 = fArr4[i18 + 1] + (((f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1)) == 0 && (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f24 > 0.0f ? 1 : (f24 == 0.0f ? 0 : -1)) > 0) || (f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1)) < 0 ? f20 : f19);
                                    int i19 = i18;
                                    if (!this.f52889a.J(f22)) {
                                        break;
                                    }
                                    if (this.f52889a.M(f28) && this.f52889a.I(f22)) {
                                        if (aVar.V0()) {
                                            BarEntry barEntry6 = barEntry5;
                                            f12 = f28;
                                            i12 = i19;
                                            barEntry = barEntry6;
                                            fArr2 = fArr4;
                                            i11 = length2;
                                            f11 = f22;
                                            e(canvas, lVarV.e(f27, barEntry6), f22, f12, iV0);
                                        } else {
                                            f12 = f28;
                                            i11 = length2;
                                            f11 = f22;
                                            i12 = i19;
                                            barEntry = barEntry5;
                                            fArr2 = fArr4;
                                        }
                                        if (barEntry.b() != null && aVar.C()) {
                                            Drawable drawableB = barEntry.b();
                                            xa.k.k(canvas, drawableB, (int) (f11 + gVar.f54987c), (int) (f12 + gVar.f54988d), drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                                        }
                                    } else {
                                        i11 = length2;
                                        f11 = f22;
                                        i12 = i19;
                                        barEntry = barEntry5;
                                        fArr2 = fArr4;
                                    }
                                    i18 = i12 + 2;
                                    fArr4 = fArr2;
                                    barEntry5 = barEntry;
                                    length2 = i11;
                                    f22 = f11;
                                }
                            } else {
                                if (!this.f52889a.J(f21)) {
                                    break;
                                }
                                int i20 = length + 1;
                                if (this.f52889a.M(bVar.f31991b[i20]) && this.f52889a.I(f21)) {
                                    if (aVar.V0()) {
                                        f14 = f21;
                                        f10 = fE;
                                        fArr = fArrB0;
                                        barEntry2 = barEntry4;
                                        i10 = i15;
                                        z10 = zC;
                                        iVar = iVarA;
                                        e(canvas, lVarV.d(barEntry4), f14, bVar.f31991b[i20] + (barEntry4.e() >= 0.0f ? f19 : f20), iV0);
                                    } else {
                                        f14 = f21;
                                        i10 = i15;
                                        f10 = fE;
                                        z10 = zC;
                                        fArr = fArrB0;
                                        barEntry2 = barEntry4;
                                        iVar = iVarA;
                                    }
                                    if (barEntry2.b() != null && aVar.C()) {
                                        Drawable drawableB2 = barEntry2.b();
                                        xa.k.k(canvas, drawableB2, (int) (gVar.f54987c + f14), (int) (bVar.f31991b[i20] + (barEntry2.e() >= 0.0f ? f19 : f20) + gVar.f54988d), drawableB2.getIntrinsicWidth(), drawableB2.getIntrinsicHeight());
                                    }
                                } else {
                                    iVarA = iVarA;
                                    zC = zC;
                                    fE = fE;
                                    i15 = i15;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i15 = i10 + 1;
                            iVarA = iVar;
                            zC = z10;
                            fE = f10;
                        }
                    } else {
                        int i21 = 0;
                        while (i21 < bVar.f31991b.length * this.f52835b.h()) {
                            float[] fArr5 = bVar.f31991b;
                            float f29 = (fArr5[i21] + fArr5[i21 + 2]) / 2.0f;
                            if (!this.f52889a.J(f29)) {
                                break;
                            }
                            int i22 = i21 + 1;
                            if (this.f52889a.M(bVar.f31991b[i22]) && this.f52889a.I(f29)) {
                                int i23 = i21 / 4;
                                BarEntry barEntry7 = (BarEntry) aVar.Z(i23);
                                float fE2 = barEntry7.e();
                                if (aVar.V0()) {
                                    String strD = lVarV.d(barEntry7);
                                    float[] fArr6 = bVar.f31991b;
                                    barEntry3 = barEntry7;
                                    f16 = f29;
                                    i13 = i21;
                                    list2 = listQ;
                                    gVar2 = gVarD;
                                    float f30 = fE2 >= 0.0f ? fArr6[i22] + f19 : fArr6[i21 + 3] + f20;
                                    lVar = lVarV;
                                    e(canvas, strD, f16, f30, aVar.v0(i23));
                                } else {
                                    barEntry3 = barEntry7;
                                    f16 = f29;
                                    i13 = i21;
                                    lVar = lVarV;
                                    list2 = listQ;
                                    gVar2 = gVarD;
                                }
                                if (barEntry3.b() != null && aVar.C()) {
                                    Drawable drawableB3 = barEntry3.b();
                                    xa.k.k(canvas, drawableB3, (int) (f16 + gVar2.f54987c), (int) ((fE2 >= 0.0f ? bVar.f31991b[i22] + f19 : bVar.f31991b[i13 + 3] + f20) + gVar2.f54988d), drawableB3.getIntrinsicWidth(), drawableB3.getIntrinsicHeight());
                                }
                            } else {
                                i13 = i21;
                                lVar = lVarV;
                                list2 = listQ;
                                gVar2 = gVarD;
                            }
                            i21 = i13 + 4;
                            gVarD = gVar2;
                            lVarV = lVar;
                            listQ = list2;
                        }
                        list = listQ;
                        gVar = gVarD;
                    }
                    f15 = fE;
                    z11 = zC;
                    xa.g.h(gVar);
                } else {
                    list = listQ;
                    f15 = fE;
                    z11 = zC;
                }
                i14++;
                zC = z11;
                listQ = list;
                fE = f15;
            }
        }
    }

    @Override // va.g
    public void j() {
        la.a barData = this.f52810h.getBarData();
        this.f52812j = new ia.b[barData.m()];
        for (int i10 = 0; i10 < this.f52812j.length; i10++) {
            qa.a aVar = (qa.a) barData.k(i10);
            this.f52812j[i10] = new ia.b(aVar.e1() * 4 * (aVar.U0() ? aVar.D0() : 1), barData.m(), aVar.U0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
                RectF rectF = this.f52815m;
                rectF.left = F - fQ;
                rectF.right = F + fQ;
                iVarA.t(rectF);
                if (this.f52889a.I(this.f52815m.right)) {
                    if (!this.f52889a.J(this.f52815m.left)) {
                        break;
                    }
                    this.f52815m.top = this.f52889a.j();
                    this.f52815m.bottom = this.f52889a.f();
                    canvas.drawRect(this.f52815m, this.f52813k);
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
            int i13 = i12 + 2;
            if (this.f52889a.I(bVar.f31991b[i13])) {
                if (!this.f52889a.J(bVar.f31991b[i12])) {
                    return;
                }
                if (!z11) {
                    this.f52836c.setColor(aVar.f0(i12 / 4));
                }
                if (aVar.O() != null) {
                    ua.a aVarO = aVar.O();
                    Paint paint = this.f52836c;
                    float[] fArr = bVar.f31991b;
                    paint.setShader(new LinearGradient(fArr[i12], fArr[i12 + 3], fArr[i12], fArr[i12 + 1], aVarO.b(), aVarO.a(), Shader.TileMode.MIRROR));
                }
                if (aVar.N0() != null) {
                    Paint paint2 = this.f52836c;
                    float[] fArr2 = bVar.f31991b;
                    float f10 = fArr2[i12];
                    float f11 = fArr2[i12 + 3];
                    float f12 = fArr2[i12];
                    float f13 = fArr2[i12 + 1];
                    int i14 = i12 / 4;
                    paint2.setShader(new LinearGradient(f10, f11, f12, f13, aVar.m1(i14).b(), aVar.m1(i14).a(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = bVar.f31991b;
                int i15 = i12 + 1;
                int i16 = i12 + 3;
                canvas.drawRect(fArr3[i12], fArr3[i15], fArr3[i13], fArr3[i16], this.f52836c);
                if (z10) {
                    float[] fArr4 = bVar.f31991b;
                    canvas.drawRect(fArr4[i12], fArr4[i15], fArr4[i13], fArr4[i16], this.f52814l);
                }
            }
        }
    }

    public void o(float f10, float f11, float f12, float f13, xa.i iVar) {
        this.f52811i.set(f10 - f13, f11, f10 + f13, f12);
        iVar.r(this.f52811i, this.f52835b.i());
    }

    public void p(oa.d dVar, RectF rectF) {
        dVar.n(rectF.centerX(), rectF.top);
    }
}
