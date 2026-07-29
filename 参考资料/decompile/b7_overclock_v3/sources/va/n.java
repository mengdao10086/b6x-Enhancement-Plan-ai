package va;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.RadarEntry;

/* JADX INFO: loaded from: classes3.dex */
public class n extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ja.i f52884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f52885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f52886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f52887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Path f52888m;

    public n(ja.i iVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52887l = new Path();
        this.f52888m = new Path();
        this.f52884i = iVar;
        Paint paint = new Paint(1);
        this.f52837d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f52837d.setStrokeWidth(2.0f);
        this.f52837d.setColor(Color.rgb(255, mb.e.f41031i2, 115));
        Paint paint2 = new Paint(1);
        this.f52885j = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f52886k = new Paint(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void b(Canvas canvas) {
        la.q qVar = (la.q) this.f52884i.getData();
        int iE1 = qVar.w().e1();
        for (qa.j jVar : qVar.q()) {
            if (jVar.isVisible()) {
                r(canvas, jVar, iE1);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
        t(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e7  */
    @Override // va.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.graphics.Canvas r20, oa.d[] r21) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.n.d(android.graphics.Canvas, oa.d[]):void");
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void f(Canvas canvas) {
        int i10;
        float f10;
        RadarEntry radarEntry;
        int i11;
        qa.j jVar;
        int i12;
        float f11;
        xa.g gVar;
        na.l lVar;
        float fH = this.f52835b.h();
        float fI = this.f52835b.i();
        float sliceAngle = this.f52884i.getSliceAngle();
        float factor = this.f52884i.getFactor();
        xa.g centerOffsets = this.f52884i.getCenterOffsets();
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        xa.g gVarC2 = xa.g.c(0.0f, 0.0f);
        float fE = xa.k.e(5.0f);
        int i13 = 0;
        while (i13 < ((la.q) this.f52884i.getData()).m()) {
            qa.j jVarK = ((la.q) this.f52884i.getData()).k(i13);
            if (m(jVarK)) {
                a(jVarK);
                na.l lVarV = jVarK.V();
                xa.g gVarD = xa.g.d(jVarK.f1());
                gVarD.f54987c = xa.k.e(gVarD.f54987c);
                gVarD.f54988d = xa.k.e(gVarD.f54988d);
                int i14 = 0;
                while (i14 < jVarK.e1()) {
                    RadarEntry radarEntry2 = (RadarEntry) jVarK.Z(i14);
                    xa.g gVar2 = gVarD;
                    float f12 = i14 * sliceAngle * fH;
                    xa.k.B(centerOffsets, (radarEntry2.e() - this.f52884i.getYChartMin()) * factor * fI, f12 + this.f52884i.getRotationAngle(), gVarC);
                    if (jVarK.V0()) {
                        radarEntry = radarEntry2;
                        i11 = i14;
                        f11 = fH;
                        gVar = gVar2;
                        lVar = lVarV;
                        jVar = jVarK;
                        i12 = i13;
                        e(canvas, lVarV.k(radarEntry2), gVarC.f54987c, gVarC.f54988d - fE, jVarK.v0(i14));
                    } else {
                        radarEntry = radarEntry2;
                        i11 = i14;
                        jVar = jVarK;
                        i12 = i13;
                        f11 = fH;
                        gVar = gVar2;
                        lVar = lVarV;
                    }
                    if (radarEntry.b() != null && jVar.C()) {
                        Drawable drawableB = radarEntry.b();
                        xa.k.B(centerOffsets, (radarEntry.e() * factor * fI) + gVar.f54988d, f12 + this.f52884i.getRotationAngle(), gVarC2);
                        float f13 = gVarC2.f54988d + gVar.f54987c;
                        gVarC2.f54988d = f13;
                        xa.k.k(canvas, drawableB, (int) gVarC2.f54987c, (int) f13, drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                    }
                    i14 = i11 + 1;
                    gVarD = gVar;
                    jVarK = jVar;
                    lVarV = lVar;
                    i13 = i12;
                    fH = f11;
                }
                i10 = i13;
                f10 = fH;
                xa.g.h(gVarD);
            } else {
                i10 = i13;
                f10 = fH;
            }
            i13 = i10 + 1;
            fH = f10;
        }
        xa.g.h(centerOffsets);
        xa.g.h(gVarC);
        xa.g.h(gVarC2);
    }

    @Override // va.g
    public void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(Canvas canvas, qa.j jVar, int i10) {
        float fH = this.f52835b.h();
        float fI = this.f52835b.i();
        float sliceAngle = this.f52884i.getSliceAngle();
        float factor = this.f52884i.getFactor();
        xa.g centerOffsets = this.f52884i.getCenterOffsets();
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        Path path = this.f52887l;
        path.reset();
        boolean z10 = false;
        for (int i11 = 0; i11 < jVar.e1(); i11++) {
            this.f52836c.setColor(jVar.f0(i11));
            xa.k.B(centerOffsets, (((RadarEntry) jVar.Z(i11)).e() - this.f52884i.getYChartMin()) * factor * fI, (i11 * sliceAngle * fH) + this.f52884i.getRotationAngle(), gVarC);
            if (!Float.isNaN(gVarC.f54987c)) {
                if (z10) {
                    path.lineTo(gVarC.f54987c, gVarC.f54988d);
                } else {
                    path.moveTo(gVarC.f54987c, gVarC.f54988d);
                    z10 = true;
                }
            }
        }
        if (jVar.e1() > i10) {
            path.lineTo(centerOffsets.f54987c, centerOffsets.f54988d);
        }
        path.close();
        if (jVar.b0()) {
            Drawable drawableS = jVar.S();
            if (drawableS != null) {
                q(canvas, path, drawableS);
            } else {
                p(canvas, path, jVar.h(), jVar.m());
            }
        }
        this.f52836c.setStrokeWidth(jVar.v());
        this.f52836c.setStyle(Paint.Style.STROKE);
        if (!jVar.b0() || jVar.m() < 255) {
            canvas.drawPath(path, this.f52836c);
        }
        xa.g.h(centerOffsets);
        xa.g.h(gVarC);
    }

    public void s(Canvas canvas, xa.g gVar, float f10, float f11, int i10, int i11, float f12) {
        canvas.save();
        float fE = xa.k.e(f11);
        float fE2 = xa.k.e(f10);
        if (i10 != 1122867) {
            Path path = this.f52888m;
            path.reset();
            path.addCircle(gVar.f54987c, gVar.f54988d, fE, Path.Direction.CW);
            if (fE2 > 0.0f) {
                path.addCircle(gVar.f54987c, gVar.f54988d, fE2, Path.Direction.CCW);
            }
            this.f52886k.setColor(i10);
            this.f52886k.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f52886k);
        }
        if (i11 != 1122867) {
            this.f52886k.setColor(i11);
            this.f52886k.setStyle(Paint.Style.STROKE);
            this.f52886k.setStrokeWidth(xa.k.e(f12));
            canvas.drawCircle(gVar.f54987c, gVar.f54988d, fE, this.f52886k);
        }
        canvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(Canvas canvas) {
        float sliceAngle = this.f52884i.getSliceAngle();
        float factor = this.f52884i.getFactor();
        float rotationAngle = this.f52884i.getRotationAngle();
        xa.g centerOffsets = this.f52884i.getCenterOffsets();
        this.f52885j.setStrokeWidth(this.f52884i.getWebLineWidth());
        this.f52885j.setColor(this.f52884i.getWebColor());
        this.f52885j.setAlpha(this.f52884i.getWebAlpha());
        int skipWebLineCount = this.f52884i.getSkipWebLineCount() + 1;
        int iE1 = ((la.q) this.f52884i.getData()).w().e1();
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        for (int i10 = 0; i10 < iE1; i10 += skipWebLineCount) {
            xa.k.B(centerOffsets, this.f52884i.getYRange() * factor, (i10 * sliceAngle) + rotationAngle, gVarC);
            canvas.drawLine(centerOffsets.f54987c, centerOffsets.f54988d, gVarC.f54987c, gVarC.f54988d, this.f52885j);
        }
        xa.g.h(gVarC);
        this.f52885j.setStrokeWidth(this.f52884i.getWebLineWidthInner());
        this.f52885j.setColor(this.f52884i.getWebColorInner());
        this.f52885j.setAlpha(this.f52884i.getWebAlpha());
        int i11 = this.f52884i.getYAxis().f37094n;
        xa.g gVarC2 = xa.g.c(0.0f, 0.0f);
        xa.g gVarC3 = xa.g.c(0.0f, 0.0f);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (i13 < ((la.q) this.f52884i.getData()).r()) {
                float yChartMin = (this.f52884i.getYAxis().f37092l[i12] - this.f52884i.getYChartMin()) * factor;
                xa.k.B(centerOffsets, yChartMin, (i13 * sliceAngle) + rotationAngle, gVarC2);
                i13++;
                xa.k.B(centerOffsets, yChartMin, (i13 * sliceAngle) + rotationAngle, gVarC3);
                canvas.drawLine(gVarC2.f54987c, gVarC2.f54988d, gVarC3.f54987c, gVarC3.f54988d, this.f52885j);
            }
        }
        xa.g.h(gVarC2);
        xa.g.h(gVarC3);
    }

    public Paint u() {
        return this.f52885j;
    }
}
