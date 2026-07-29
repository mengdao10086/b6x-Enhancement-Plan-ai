package va;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class m extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ja.g f52867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f52868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f52869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f52870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextPaint f52871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f52872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public StaticLayout f52873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f52874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RectF f52875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RectF[] f52876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<Bitmap> f52877q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Canvas f52878r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Path f52879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f52880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Path f52881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Path f52882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f52883w;

    public m(ja.g gVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52875o = new RectF();
        this.f52876p = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f52879s = new Path();
        this.f52880t = new RectF();
        this.f52881u = new Path();
        this.f52882v = new Path();
        this.f52883w = new RectF();
        this.f52867g = gVar;
        Paint paint = new Paint(1);
        this.f52868h = paint;
        paint.setColor(-1);
        this.f52868h.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f52869i = paint2;
        paint2.setColor(-1);
        this.f52869i.setStyle(Paint.Style.FILL);
        this.f52869i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f52871k = textPaint;
        textPaint.setColor(-16777216);
        this.f52871k.setTextSize(xa.k.e(12.0f));
        this.f52839f.setTextSize(xa.k.e(13.0f));
        this.f52839f.setColor(-1);
        this.f52839f.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.f52872l = paint3;
        paint3.setColor(-1);
        this.f52872l.setTextAlign(Paint.Align.CENTER);
        this.f52872l.setTextSize(xa.k.e(13.0f));
        Paint paint4 = new Paint(1);
        this.f52870j = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void b(Canvas canvas) {
        int iO = (int) this.f52889a.o();
        int iN = (int) this.f52889a.n();
        WeakReference<Bitmap> weakReference = this.f52877q;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iO || bitmapCreateBitmap.getHeight() != iN) {
            if (iO <= 0 || iN <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iO, iN, Bitmap.Config.ARGB_4444);
            this.f52877q = new WeakReference<>(bitmapCreateBitmap);
            this.f52878r = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (qa.i iVar : ((la.p) this.f52867g.getData()).q()) {
            if (iVar.isVisible() && iVar.e1() > 0) {
                n(canvas, iVar);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
        p(canvas);
        canvas.drawBitmap(this.f52877q.get(), 0.0f, 0.0f, (Paint) null);
        m(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        int i10;
        RectF rectF;
        float f10;
        float[] fArr;
        boolean z10;
        float f11;
        float f12;
        xa.g gVar;
        qa.i iVarK;
        float f13;
        int i11;
        float[] fArr2;
        float f14;
        int i12;
        float fL;
        float fMax;
        oa.d[] dVarArr2 = dVarArr;
        boolean z11 = this.f52867g.n0() && !this.f52867g.p0();
        if (z11 && this.f52867g.o0()) {
            return;
        }
        float fH = this.f52835b.h();
        float fI = this.f52835b.i();
        float rotationAngle = this.f52867g.getRotationAngle();
        float[] drawAngles = this.f52867g.getDrawAngles();
        float[] absoluteAngles = this.f52867g.getAbsoluteAngles();
        xa.g centerCircleBox = this.f52867g.getCenterCircleBox();
        float radius = this.f52867g.getRadius();
        float holeRadius = z11 ? (this.f52867g.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.f52883w;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i13 = 0;
        while (i13 < dVarArr2.length) {
            int iH = (int) dVarArr2[i13].h();
            if (iH < drawAngles.length && (iVarK = ((la.p) this.f52867g.getData()).k(dVarArr2[i13].d())) != null && iVarK.i1()) {
                int iE1 = iVarK.e1();
                int i14 = 0;
                for (int i15 = 0; i15 < iE1; i15++) {
                    if (Math.abs(iVarK.Z(i15).e()) > xa.k.f55015g) {
                        i14++;
                    }
                }
                if (iH == 0) {
                    i11 = 1;
                    f13 = 0.0f;
                } else {
                    f13 = absoluteAngles[iH - 1] * fH;
                    i11 = 1;
                }
                float fJ = i14 <= i11 ? 0.0f : iVarK.j();
                float f15 = drawAngles[iH];
                float fP0 = iVarK.P0();
                int i16 = i13;
                float f16 = radius + fP0;
                float f17 = holeRadius;
                rectF2.set(this.f52867g.getCircleBox());
                float f18 = -fP0;
                rectF2.inset(f18, f18);
                boolean z12 = fJ > 0.0f && f15 <= 180.0f;
                this.f52836c.setColor(iVarK.f0(iH));
                float f19 = i14 == 1 ? 0.0f : fJ / (radius * 0.017453292f);
                float f20 = i14 == 1 ? 0.0f : fJ / (f16 * 0.017453292f);
                float f21 = rotationAngle + (((f19 / 2.0f) + f13) * fI);
                float f22 = (f15 - f19) * fI;
                float f23 = f22 < 0.0f ? 0.0f : f22;
                float f24 = (((f20 / 2.0f) + f13) * fI) + rotationAngle;
                float f25 = (f15 - f20) * fI;
                if (f25 < 0.0f) {
                    f25 = 0.0f;
                }
                this.f52879s.reset();
                if (f23 < 360.0f || f23 % 360.0f > xa.k.f55015g) {
                    fArr2 = drawAngles;
                    f14 = f13;
                    double d10 = f24 * 0.017453292f;
                    i12 = i14;
                    z10 = z11;
                    this.f52879s.moveTo(centerCircleBox.f54987c + (((float) Math.cos(d10)) * f16), centerCircleBox.f54988d + (f16 * ((float) Math.sin(d10))));
                    this.f52879s.arcTo(rectF2, f24, f25);
                } else {
                    this.f52879s.addCircle(centerCircleBox.f54987c, centerCircleBox.f54988d, f16, Path.Direction.CW);
                    fArr2 = drawAngles;
                    f14 = f13;
                    i12 = i14;
                    z10 = z11;
                }
                if (z12) {
                    double d11 = f21 * 0.017453292f;
                    i10 = i16;
                    rectF = rectF2;
                    f10 = f17;
                    gVar = centerCircleBox;
                    fArr = fArr2;
                    fL = l(centerCircleBox, radius, f15 * fI, (((float) Math.cos(d11)) * radius) + centerCircleBox.f54987c, centerCircleBox.f54988d + (((float) Math.sin(d11)) * radius), f21, f23);
                } else {
                    rectF = rectF2;
                    gVar = centerCircleBox;
                    i10 = i16;
                    f10 = f17;
                    fArr = fArr2;
                    fL = 0.0f;
                }
                RectF rectF3 = this.f52880t;
                float f26 = gVar.f54987c;
                float f27 = gVar.f54988d;
                rectF3.set(f26 - f10, f27 - f10, f26 + f10, f27 + f10);
                if (!z10 || (f10 <= 0.0f && !z12)) {
                    f11 = fH;
                    f12 = fI;
                    if (f23 % 360.0f > xa.k.f55015g) {
                        if (z12) {
                            double d12 = (f21 + (f23 / 2.0f)) * 0.017453292f;
                            this.f52879s.lineTo(gVar.f54987c + (((float) Math.cos(d12)) * fL), gVar.f54988d + (fL * ((float) Math.sin(d12))));
                        } else {
                            this.f52879s.lineTo(gVar.f54987c, gVar.f54988d);
                        }
                    }
                } else {
                    if (z12) {
                        if (fL < 0.0f) {
                            fL = -fL;
                        }
                        fMax = Math.max(f10, fL);
                    } else {
                        fMax = f10;
                    }
                    float f28 = (i12 == 1 || fMax == 0.0f) ? 0.0f : fJ / (fMax * 0.017453292f);
                    float f29 = ((f14 + (f28 / 2.0f)) * fI) + rotationAngle;
                    float f30 = (f15 - f28) * fI;
                    if (f30 < 0.0f) {
                        f30 = 0.0f;
                    }
                    float f31 = f29 + f30;
                    if (f23 < 360.0f || f23 % 360.0f > xa.k.f55015g) {
                        double d13 = f31 * 0.017453292f;
                        f11 = fH;
                        f12 = fI;
                        this.f52879s.lineTo(gVar.f54987c + (((float) Math.cos(d13)) * fMax), gVar.f54988d + (fMax * ((float) Math.sin(d13))));
                        this.f52879s.arcTo(this.f52880t, f31, -f30);
                    } else {
                        this.f52879s.addCircle(gVar.f54987c, gVar.f54988d, fMax, Path.Direction.CCW);
                        f11 = fH;
                        f12 = fI;
                    }
                }
                this.f52879s.close();
                this.f52878r.drawPath(this.f52879s, this.f52836c);
            } else {
                i10 = i13;
                rectF = rectF2;
                f10 = holeRadius;
                fArr = drawAngles;
                z10 = z11;
                f11 = fH;
                f12 = fI;
                gVar = centerCircleBox;
            }
            i13 = i10 + 1;
            fH = f11;
            rectF2 = rectF;
            holeRadius = f10;
            centerCircleBox = gVar;
            fI = f12;
            drawAngles = fArr;
            z11 = z10;
            dVarArr2 = dVarArr;
        }
        xa.g.h(centerCircleBox);
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03db  */
    @Override // va.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.graphics.Canvas r54) {
        /*
            Method dump skipped, instruction units count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.m.f(android.graphics.Canvas):void");
    }

    @Override // va.g
    public void j() {
    }

    public float l(xa.g gVar, float f10, float f11, float f12, float f13, float f14, float f15) {
        double d10 = (f14 + f15) * 0.017453292f;
        float fCos = gVar.f54987c + (((float) Math.cos(d10)) * f10);
        float fSin = gVar.f54988d + (((float) Math.sin(d10)) * f10);
        double d11 = (f14 + (f15 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f10 - ((float) ((Math.sqrt(Math.pow(fCos - f12, 2.0d) + Math.pow(fSin - f13, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f11)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((gVar.f54987c + (((float) Math.cos(d11)) * f10)) - ((fCos + f12) / 2.0f), 2.0d) + Math.pow((gVar.f54988d + (((float) Math.sin(d11)) * f10)) - ((fSin + f13) / 2.0f), 2.0d)));
    }

    public void m(Canvas canvas) {
        xa.g gVar;
        CharSequence centerText = this.f52867g.getCenterText();
        if (!this.f52867g.k0() || centerText == null) {
            return;
        }
        xa.g centerCircleBox = this.f52867g.getCenterCircleBox();
        xa.g centerTextOffset = this.f52867g.getCenterTextOffset();
        float f10 = centerCircleBox.f54987c + centerTextOffset.f54987c;
        float f11 = centerCircleBox.f54988d + centerTextOffset.f54988d;
        float radius = (!this.f52867g.n0() || this.f52867g.p0()) ? this.f52867g.getRadius() : this.f52867g.getRadius() * (this.f52867g.getHoleRadius() / 100.0f);
        RectF[] rectFArr = this.f52876p;
        RectF rectF = rectFArr[0];
        rectF.left = f10 - radius;
        rectF.top = f11 - radius;
        rectF.right = f10 + radius;
        rectF.bottom = f11 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.f52867g.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.f52874n) && rectF2.equals(this.f52875o)) {
            gVar = centerTextOffset;
        } else {
            this.f52875o.set(rectF2);
            this.f52874n = centerText;
            gVar = centerTextOffset;
            this.f52873m = new StaticLayout(centerText, 0, centerText.length(), this.f52871k, (int) Math.max(Math.ceil(this.f52875o.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.f52873m.getHeight();
        canvas.save();
        Path path = this.f52882v;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.f52873m.draw(canvas);
        canvas.restore();
        xa.g.h(centerCircleBox);
        xa.g.h(gVar);
    }

    public void n(Canvas canvas, qa.i iVar) {
        int i10;
        int i11;
        int i12;
        float[] fArr;
        float f10;
        float f11;
        float f12;
        float f13;
        xa.g gVar;
        RectF rectF;
        int i13;
        float f14;
        RectF rectF2;
        float f15;
        RectF rectF3;
        RectF rectF4;
        xa.g gVar2;
        float f16;
        int i14;
        m mVar = this;
        qa.i iVar2 = iVar;
        float rotationAngle = mVar.f52867g.getRotationAngle();
        float fH = mVar.f52835b.h();
        float fI = mVar.f52835b.i();
        RectF circleBox = mVar.f52867g.getCircleBox();
        int iE1 = iVar.e1();
        float[] drawAngles = mVar.f52867g.getDrawAngles();
        xa.g centerCircleBox = mVar.f52867g.getCenterCircleBox();
        float radius = mVar.f52867g.getRadius();
        boolean z10 = mVar.f52867g.n0() && !mVar.f52867g.p0();
        float holeRadius = z10 ? (mVar.f52867g.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((mVar.f52867g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF5 = new RectF();
        boolean z11 = z10 && mVar.f52867g.o0();
        int i15 = 0;
        for (int i16 = 0; i16 < iE1; i16++) {
            if (Math.abs(iVar2.Z(i16).e()) > xa.k.f55015g) {
                i15++;
            }
        }
        float fV = i15 <= 1 ? 0.0f : mVar.v(iVar2);
        int i17 = 0;
        float f17 = 0.0f;
        while (i17 < iE1) {
            float f18 = drawAngles[i17];
            float fAbs = Math.abs(iVar2.Z(i17).e());
            float f19 = xa.k.f55015g;
            if (fAbs > f19 && (!mVar.f52867g.r0(i17) || z11)) {
                boolean z12 = fV > 0.0f && f18 <= 180.0f;
                mVar.f52836c.setColor(iVar2.f0(i17));
                float f20 = i15 == 1 ? 0.0f : fV / (radius * 0.017453292f);
                float f21 = rotationAngle + ((f17 + (f20 / 2.0f)) * fI);
                float f22 = (f18 - f20) * fI;
                if (f22 < 0.0f) {
                    f22 = 0.0f;
                }
                mVar.f52879s.reset();
                if (z11) {
                    float f23 = radius - holeRadius2;
                    i10 = i17;
                    i11 = i15;
                    double d10 = f21 * 0.017453292f;
                    i12 = iE1;
                    fArr = drawAngles;
                    float fCos = centerCircleBox.f54987c + (((float) Math.cos(d10)) * f23);
                    float fSin = centerCircleBox.f54988d + (f23 * ((float) Math.sin(d10)));
                    rectF5.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i10 = i17;
                    i11 = i15;
                    i12 = iE1;
                    fArr = drawAngles;
                }
                double d11 = f21 * 0.017453292f;
                f10 = rotationAngle;
                f11 = fH;
                float fCos2 = centerCircleBox.f54987c + (((float) Math.cos(d11)) * radius);
                float fSin2 = centerCircleBox.f54988d + (((float) Math.sin(d11)) * radius);
                if (f22 < 360.0f || f22 % 360.0f > f19) {
                    if (z11) {
                        mVar.f52879s.arcTo(rectF5, f21 + 180.0f, -180.0f);
                    }
                    mVar.f52879s.arcTo(circleBox, f21, f22);
                } else {
                    mVar.f52879s.addCircle(centerCircleBox.f54987c, centerCircleBox.f54988d, radius, Path.Direction.CW);
                }
                RectF rectF6 = mVar.f52880t;
                float f24 = centerCircleBox.f54987c;
                float f25 = centerCircleBox.f54988d;
                float f26 = f22;
                rectF6.set(f24 - holeRadius, f25 - holeRadius, f24 + holeRadius, f25 + holeRadius);
                if (!z10) {
                    f12 = holeRadius;
                    f13 = radius;
                    gVar = centerCircleBox;
                    rectF = circleBox;
                    i13 = i11;
                    f14 = f26;
                    rectF2 = rectF5;
                    f15 = 360.0f;
                } else if (holeRadius > 0.0f || z12) {
                    if (z12) {
                        f16 = f26;
                        rectF = circleBox;
                        i13 = i11;
                        rectF4 = rectF5;
                        f12 = holeRadius;
                        i14 = 1;
                        f13 = radius;
                        gVar2 = centerCircleBox;
                        float fL = l(centerCircleBox, radius, f18 * fI, fCos2, fSin2, f21, f16);
                        if (fL < 0.0f) {
                            fL = -fL;
                        }
                        holeRadius = Math.max(f12, fL);
                    } else {
                        rectF4 = rectF5;
                        f12 = holeRadius;
                        f13 = radius;
                        gVar2 = centerCircleBox;
                        rectF = circleBox;
                        i13 = i11;
                        f16 = f26;
                        i14 = 1;
                    }
                    float f27 = (i13 == i14 || holeRadius == 0.0f) ? 0.0f : fV / (holeRadius * 0.017453292f);
                    float f28 = f10 + ((f17 + (f27 / 2.0f)) * fI);
                    float f29 = (f18 - f27) * fI;
                    if (f29 < 0.0f) {
                        f29 = 0.0f;
                    }
                    float f30 = f28 + f29;
                    if (f22 < 360.0f || f16 % 360.0f > f19) {
                        mVar = this;
                        if (z11) {
                            float f31 = f13 - holeRadius2;
                            double d12 = f30 * 0.017453292f;
                            float fCos3 = gVar2.f54987c + (((float) Math.cos(d12)) * f31);
                            float fSin3 = gVar2.f54988d + (f31 * ((float) Math.sin(d12)));
                            rectF2 = rectF4;
                            rectF2.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            mVar.f52879s.arcTo(rectF2, f30, 180.0f);
                        } else {
                            rectF2 = rectF4;
                            double d13 = f30 * 0.017453292f;
                            mVar.f52879s.lineTo(gVar2.f54987c + (((float) Math.cos(d13)) * holeRadius), gVar2.f54988d + (holeRadius * ((float) Math.sin(d13))));
                        }
                        mVar.f52879s.arcTo(mVar.f52880t, f30, -f29);
                    } else {
                        mVar = this;
                        mVar.f52879s.addCircle(gVar2.f54987c, gVar2.f54988d, holeRadius, Path.Direction.CCW);
                        rectF2 = rectF4;
                    }
                    gVar = gVar2;
                    rectF3 = rectF2;
                    mVar.f52879s.close();
                    mVar.f52878r.drawPath(mVar.f52879s, mVar.f52836c);
                    f17 += f18 * f11;
                } else {
                    f12 = holeRadius;
                    f13 = radius;
                    gVar = centerCircleBox;
                    rectF = circleBox;
                    i13 = i11;
                    f14 = f26;
                    f15 = 360.0f;
                    rectF2 = rectF5;
                }
                if (f14 % f15 <= f19) {
                    rectF3 = rectF2;
                } else if (z12) {
                    float f32 = f21 + (f14 / 2.0f);
                    rectF3 = rectF2;
                    float fL2 = l(gVar, f13, f18 * fI, fCos2, fSin2, f21, f14);
                    double d14 = f32 * 0.017453292f;
                    mVar.f52879s.lineTo(gVar.f54987c + (((float) Math.cos(d14)) * fL2), gVar.f54988d + (fL2 * ((float) Math.sin(d14))));
                } else {
                    rectF3 = rectF2;
                    mVar.f52879s.lineTo(gVar.f54987c, gVar.f54988d);
                }
                mVar.f52879s.close();
                mVar.f52878r.drawPath(mVar.f52879s, mVar.f52836c);
                f17 += f18 * f11;
            } else {
                f17 += f18 * fH;
                i10 = i17;
                rectF3 = rectF5;
                f13 = radius;
                f10 = rotationAngle;
                f11 = fH;
                rectF = circleBox;
                i12 = iE1;
                fArr = drawAngles;
                i13 = i15;
                f12 = holeRadius;
                gVar = centerCircleBox;
            }
            i17 = i10 + 1;
            rectF5 = rectF3;
            holeRadius = f12;
            i15 = i13;
            centerCircleBox = gVar;
            radius = f13;
            rotationAngle = f10;
            iE1 = i12;
            drawAngles = fArr;
            fH = f11;
            circleBox = rectF;
            iVar2 = iVar;
        }
        xa.g.h(centerCircleBox);
    }

    public void o(Canvas canvas, String str, float f10, float f11) {
        canvas.drawText(str, f10, f11, this.f52872l);
    }

    public void p(Canvas canvas) {
        if (!this.f52867g.n0() || this.f52878r == null) {
            return;
        }
        float radius = this.f52867g.getRadius();
        float holeRadius = (this.f52867g.getHoleRadius() / 100.0f) * radius;
        xa.g centerCircleBox = this.f52867g.getCenterCircleBox();
        if (Color.alpha(this.f52868h.getColor()) > 0) {
            this.f52878r.drawCircle(centerCircleBox.f54987c, centerCircleBox.f54988d, holeRadius, this.f52868h);
        }
        if (Color.alpha(this.f52869i.getColor()) > 0 && this.f52867g.getTransparentCircleRadius() > this.f52867g.getHoleRadius()) {
            int alpha = this.f52869i.getAlpha();
            float transparentCircleRadius = radius * (this.f52867g.getTransparentCircleRadius() / 100.0f);
            this.f52869i.setAlpha((int) (alpha * this.f52835b.h() * this.f52835b.i()));
            this.f52881u.reset();
            this.f52881u.addCircle(centerCircleBox.f54987c, centerCircleBox.f54988d, transparentCircleRadius, Path.Direction.CW);
            this.f52881u.addCircle(centerCircleBox.f54987c, centerCircleBox.f54988d, holeRadius, Path.Direction.CCW);
            this.f52878r.drawPath(this.f52881u, this.f52869i);
            this.f52869i.setAlpha(alpha);
        }
        xa.g.h(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(Canvas canvas) {
        float f10;
        float[] fArr;
        float f11;
        if (this.f52867g.o0()) {
            qa.i iVarQ = ((la.p) this.f52867g.getData()).Q();
            if (iVarQ.isVisible()) {
                float fH = this.f52835b.h();
                float fI = this.f52835b.i();
                xa.g centerCircleBox = this.f52867g.getCenterCircleBox();
                float radius = this.f52867g.getRadius();
                float holeRadius = (radius - ((this.f52867g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.f52867g.getDrawAngles();
                float rotationAngle = this.f52867g.getRotationAngle();
                int i10 = 0;
                while (i10 < iVarQ.e1()) {
                    float f12 = drawAngles[i10];
                    if (Math.abs(iVarQ.Z(i10).e()) > xa.k.f55015g) {
                        double d10 = radius - holeRadius;
                        double d11 = (rotationAngle + f12) * fI;
                        f10 = fI;
                        fArr = drawAngles;
                        f11 = rotationAngle;
                        float fCos = (float) (((double) centerCircleBox.f54987c) + (Math.cos(Math.toRadians(d11)) * d10));
                        float fSin = (float) ((d10 * Math.sin(Math.toRadians(d11))) + ((double) centerCircleBox.f54988d));
                        this.f52836c.setColor(iVarQ.f0(i10));
                        this.f52878r.drawCircle(fCos, fSin, holeRadius, this.f52836c);
                    } else {
                        f10 = fI;
                        fArr = drawAngles;
                        f11 = rotationAngle;
                    }
                    rotationAngle = f11 + (f12 * fH);
                    i10++;
                    fI = f10;
                    drawAngles = fArr;
                }
                xa.g.h(centerCircleBox);
            }
        }
    }

    public TextPaint r() {
        return this.f52871k;
    }

    public Paint s() {
        return this.f52872l;
    }

    public Paint t() {
        return this.f52868h;
    }

    public Paint u() {
        return this.f52869i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float v(qa.i iVar) {
        if (!iVar.W()) {
            return iVar.j();
        }
        if (iVar.j() / this.f52889a.y() > (iVar.L() / ((la.p) this.f52867g.getData()).T()) * 2.0f) {
            return 0.0f;
        }
        return iVar.j();
    }

    public void w() {
        Canvas canvas = this.f52878r;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f52878r = null;
        }
        WeakReference<Bitmap> weakReference = this.f52877q;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f52877q.clear();
            this.f52877q = null;
        }
    }
}
