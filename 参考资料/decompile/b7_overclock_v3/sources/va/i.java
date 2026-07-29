package va;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f52841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f52842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Legend f52843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.github.mikephil.charting.components.a> f52844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint.FontMetrics f52845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f52846g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f52848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f52849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f52850d;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            f52850d = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52850d[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52850d[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52850d[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52850d[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52850d[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            f52849c = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f52849c[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f52848b = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f52848b[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f52848b[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f52847a = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f52847a[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f52847a[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public i(xa.l lVar, Legend legend) {
        super(lVar);
        this.f52844e = new ArrayList(16);
        this.f52845f = new Paint.FontMetrics();
        this.f52846g = new Path();
        this.f52843d = legend;
        Paint paint = new Paint(1);
        this.f52841b = paint;
        paint.setTextSize(xa.k.e(9.0f));
        this.f52841b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f52842c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(la.k<?> r19) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.i.a(la.k):void");
    }

    public void b(Canvas canvas, float f10, float f11, com.github.mikephil.charting.components.a aVar, Legend legend) {
        int i10 = aVar.f16623f;
        if (i10 == 1122868 || i10 == 1122867 || i10 == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm legendFormT = aVar.f16619b;
        if (legendFormT == Legend.LegendForm.DEFAULT) {
            legendFormT = legend.t();
        }
        this.f52842c.setColor(aVar.f16623f);
        float fE = xa.k.e(Float.isNaN(aVar.f16620c) ? legend.w() : aVar.f16620c);
        float f12 = fE / 2.0f;
        int i11 = a.f52850d[legendFormT.ordinal()];
        if (i11 == 3 || i11 == 4) {
            this.f52842c.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f10 + f12, f11, f12, this.f52842c);
        } else if (i11 == 5) {
            this.f52842c.setStyle(Paint.Style.FILL);
            canvas.drawRect(f10, f11 - f12, f10 + fE, f11 + f12, this.f52842c);
        } else if (i11 == 6) {
            float fE2 = xa.k.e(Float.isNaN(aVar.f16621d) ? legend.v() : aVar.f16621d);
            DashPathEffect dashPathEffectU = aVar.f16622e;
            if (dashPathEffectU == null) {
                dashPathEffectU = legend.u();
            }
            this.f52842c.setStyle(Paint.Style.STROKE);
            this.f52842c.setStrokeWidth(fE2);
            this.f52842c.setPathEffect(dashPathEffectU);
            this.f52846g.reset();
            this.f52846g.moveTo(f10, f11);
            this.f52846g.lineTo(f10 + fE, f11);
            canvas.drawPath(this.f52846g, this.f52842c);
        }
        canvas.restoreToCount(iSave);
    }

    public void c(Canvas canvas, float f10, float f11, String str) {
        canvas.drawText(str, f10, f11, this.f52841b);
    }

    public Paint d() {
        return this.f52842c;
    }

    public Paint e() {
        return this.f52841b;
    }

    public void f(Canvas canvas) {
        float f10;
        float f11;
        float fO;
        float f12;
        float f13;
        List<Boolean> list;
        List<xa.c> list2;
        int i10;
        float f14;
        float f15;
        float f16;
        float f17;
        float fJ;
        float f18;
        float f19;
        float f20;
        Legend.LegendDirection legendDirection;
        com.github.mikephil.charting.components.a aVar;
        float fD;
        double d10;
        if (this.f52843d.f()) {
            Typeface typefaceC = this.f52843d.c();
            if (typefaceC != null) {
                this.f52841b.setTypeface(typefaceC);
            }
            this.f52841b.setTextSize(this.f52843d.b());
            this.f52841b.setColor(this.f52843d.a());
            float fU = xa.k.u(this.f52841b, this.f52845f);
            float fW = xa.k.w(this.f52841b, this.f52845f) + xa.k.e(this.f52843d.G());
            float fA = fU - (xa.k.a(this.f52841b, "ABC") / 2.0f);
            com.github.mikephil.charting.components.a[] aVarArrR = this.f52843d.r();
            float fE = xa.k.e(this.f52843d.x());
            float fE2 = xa.k.e(this.f52843d.F());
            Legend.LegendOrientation legendOrientationC = this.f52843d.C();
            Legend.LegendHorizontalAlignment legendHorizontalAlignmentY = this.f52843d.y();
            Legend.LegendVerticalAlignment legendVerticalAlignmentE = this.f52843d.E();
            Legend.LegendDirection legendDirectionQ = this.f52843d.q();
            float fE3 = xa.k.e(this.f52843d.w());
            float fE4 = xa.k.e(this.f52843d.D());
            float fE5 = this.f52843d.e();
            float fD2 = this.f52843d.d();
            int i11 = a.f52847a[legendHorizontalAlignmentY.ordinal()];
            float f21 = fE4;
            float f22 = fE2;
            if (i11 == 1) {
                f10 = fU;
                f11 = fW;
                if (legendOrientationC != Legend.LegendOrientation.VERTICAL) {
                    fD2 += this.f52889a.h();
                }
                fO = legendDirectionQ == Legend.LegendDirection.RIGHT_TO_LEFT ? fD2 + this.f52843d.f16607x : fD2;
            } else if (i11 == 2) {
                f10 = fU;
                f11 = fW;
                fO = (legendOrientationC == Legend.LegendOrientation.VERTICAL ? this.f52889a.o() : this.f52889a.i()) - fD2;
                if (legendDirectionQ == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    fO -= this.f52843d.f16607x;
                }
            } else if (i11 != 3) {
                f10 = fU;
                f11 = fW;
                fO = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float fO2 = legendOrientationC == legendOrientation ? this.f52889a.o() / 2.0f : this.f52889a.h() + (this.f52889a.k() / 2.0f);
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f11 = fW;
                fO = fO2 + (legendDirectionQ == legendDirection2 ? fD2 : -fD2);
                if (legendOrientationC == legendOrientation) {
                    double d11 = fO;
                    if (legendDirectionQ == legendDirection2) {
                        f10 = fU;
                        d10 = (((double) (-this.f52843d.f16607x)) / 2.0d) + ((double) fD2);
                    } else {
                        f10 = fU;
                        d10 = (((double) this.f52843d.f16607x) / 2.0d) - ((double) fD2);
                    }
                    fO = (float) (d11 + d10);
                } else {
                    f10 = fU;
                }
            }
            int i12 = a.f52849c[legendOrientationC.ordinal()];
            if (i12 != 1) {
                if (i12 != 2) {
                    return;
                }
                int i13 = a.f52848b[legendVerticalAlignmentE.ordinal()];
                if (i13 == 1) {
                    fJ = (legendHorizontalAlignmentY == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.f52889a.j()) + fE5;
                } else if (i13 == 2) {
                    fJ = (legendHorizontalAlignmentY == Legend.LegendHorizontalAlignment.CENTER ? this.f52889a.n() : this.f52889a.f()) - (this.f52843d.f16608y + fE5);
                } else if (i13 != 3) {
                    fJ = 0.0f;
                } else {
                    float fN = this.f52889a.n() / 2.0f;
                    Legend legend = this.f52843d;
                    fJ = (fN - (legend.f16608y / 2.0f)) + legend.e();
                }
                float f23 = fJ;
                boolean z10 = false;
                int i14 = 0;
                float f24 = 0.0f;
                while (i14 < aVarArrR.length) {
                    com.github.mikephil.charting.components.a aVar2 = aVarArrR[i14];
                    boolean z11 = aVar2.f16619b != Legend.LegendForm.NONE;
                    float fE6 = Float.isNaN(aVar2.f16620c) ? fE3 : xa.k.e(aVar2.f16620c);
                    if (z11) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        fD = legendDirectionQ == legendDirection3 ? fO + f24 : fO - (fE6 - f24);
                        f19 = fA;
                        f20 = f21;
                        f18 = fO;
                        legendDirection = legendDirectionQ;
                        b(canvas, fD, f23 + fA, aVar2, this.f52843d);
                        if (legendDirection == legendDirection3) {
                            fD += fE6;
                        }
                        aVar = aVar2;
                    } else {
                        f18 = fO;
                        f19 = fA;
                        f20 = f21;
                        legendDirection = legendDirectionQ;
                        aVar = aVar2;
                        fD = f18;
                    }
                    if (aVar.f16618a != null) {
                        if (z11 && !z10) {
                            fD += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? fE : -fE;
                        } else if (z10) {
                            fD = f18;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fD -= xa.k.d(this.f52841b, r1);
                        }
                        float f25 = fD;
                        if (z10) {
                            f23 += f10 + f11;
                            c(canvas, f25, f23 + f10, aVar.f16618a);
                        } else {
                            c(canvas, f25, f23 + f10, aVar.f16618a);
                        }
                        f23 += f10 + f11;
                        f24 = 0.0f;
                    } else {
                        f24 += fE6 + f20;
                        z10 = true;
                    }
                    i14++;
                    legendDirectionQ = legendDirection;
                    f21 = f20;
                    fA = f19;
                    fO = f18;
                }
                return;
            }
            float f26 = fO;
            float f27 = f21;
            List<xa.c> listP = this.f52843d.p();
            List<xa.c> listO = this.f52843d.o();
            List<Boolean> listN = this.f52843d.n();
            int i15 = a.f52848b[legendVerticalAlignmentE.ordinal()];
            if (i15 != 1) {
                fE5 = i15 != 2 ? i15 != 3 ? 0.0f : fE5 + ((this.f52889a.n() - this.f52843d.f16608y) / 2.0f) : (this.f52889a.n() - fE5) - this.f52843d.f16608y;
            }
            int length = aVarArrR.length;
            float f28 = f26;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                float f29 = f27;
                com.github.mikephil.charting.components.a aVar3 = aVarArrR[i16];
                float f30 = f28;
                int i18 = length;
                boolean z12 = aVar3.f16619b != Legend.LegendForm.NONE;
                float fE7 = Float.isNaN(aVar3.f16620c) ? fE3 : xa.k.e(aVar3.f16620c);
                if (i16 >= listN.size() || !listN.get(i16).booleanValue()) {
                    f12 = f30;
                    f13 = fE5;
                } else {
                    f13 = fE5 + f10 + f11;
                    f12 = f26;
                }
                if (f12 == f26 && legendHorizontalAlignmentY == Legend.LegendHorizontalAlignment.CENTER && i17 < listP.size()) {
                    f12 += (legendDirectionQ == Legend.LegendDirection.RIGHT_TO_LEFT ? listP.get(i17).f54979c : -listP.get(i17).f54979c) / 2.0f;
                    i17++;
                }
                int i19 = i17;
                boolean z13 = aVar3.f16618a == null;
                if (z12) {
                    if (legendDirectionQ == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f12 -= fE7;
                    }
                    float f31 = f12;
                    list2 = listP;
                    i10 = i16;
                    list = listN;
                    b(canvas, f31, f13 + fA, aVar3, this.f52843d);
                    f12 = legendDirectionQ == Legend.LegendDirection.LEFT_TO_RIGHT ? f31 + fE7 : f31;
                } else {
                    list = listN;
                    list2 = listP;
                    i10 = i16;
                }
                if (z13) {
                    f14 = f22;
                    if (legendDirectionQ == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f15 = f29;
                        f16 = -f15;
                    } else {
                        f15 = f29;
                        f16 = f15;
                    }
                    f28 = f12 + f16;
                } else {
                    if (z12) {
                        f12 += legendDirectionQ == Legend.LegendDirection.RIGHT_TO_LEFT ? -fE : fE;
                    }
                    Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (legendDirectionQ == legendDirection4) {
                        f12 -= listO.get(i10).f54979c;
                    }
                    c(canvas, f12, f13 + f10, aVar3.f16618a);
                    if (legendDirectionQ == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f12 += listO.get(i10).f54979c;
                    }
                    if (legendDirectionQ == legendDirection4) {
                        f14 = f22;
                        f17 = -f14;
                    } else {
                        f14 = f22;
                        f17 = f14;
                    }
                    f28 = f12 + f17;
                    f15 = f29;
                }
                f22 = f14;
                f27 = f15;
                i16 = i10 + 1;
                fE5 = f13;
                length = i18;
                i17 = i19;
                listP = list2;
                listN = list;
            }
        }
    }
}
