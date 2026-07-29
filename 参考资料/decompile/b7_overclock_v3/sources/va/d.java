package va;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BubbleEntry;
import java.util.List;
import va.c;

/* JADX INFO: loaded from: classes3.dex */
public class d extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pa.c f52821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f52822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f52823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f52824k;

    public d(pa.c cVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52822i = new float[4];
        this.f52823j = new float[2];
        this.f52824k = new float[3];
        this.f52821h = cVar;
        this.f52836c.setStyle(Paint.Style.FILL);
        this.f52837d.setStyle(Paint.Style.STROKE);
        this.f52837d.setStrokeWidth(xa.k.e(1.5f));
    }

    @Override // va.g
    public void b(Canvas canvas) {
        for (T t10 : this.f52821h.getBubbleData().q()) {
            if (t10.isVisible()) {
                n(canvas, t10);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013c  */
    @Override // va.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.graphics.Canvas r18, oa.d[] r19) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.d.d(android.graphics.Canvas, oa.d[]):void");
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
        BubbleEntry bubbleEntry;
        float f10;
        float f11;
        la.g bubbleData = this.f52821h.getBubbleData();
        if (bubbleData != null && k(this.f52821h)) {
            List<T> listQ = bubbleData.q();
            float fA = xa.k.a(this.f52839f, "1");
            for (int i11 = 0; i11 < listQ.size(); i11++) {
                qa.c cVar = (qa.c) listQ.get(i11);
                if (m(cVar) && cVar.e1() >= 1) {
                    a(cVar);
                    float fMax = Math.max(0.0f, Math.min(1.0f, this.f52835b.h()));
                    float fI = this.f52835b.i();
                    this.f52816g.a(this.f52821h, cVar);
                    xa.i iVarA = this.f52821h.a(cVar.a1());
                    c.a aVar = this.f52816g;
                    float[] fArrA = iVarA.a(cVar, fI, aVar.f52817a, aVar.f52818b);
                    float f12 = fMax == 1.0f ? fI : fMax;
                    na.l lVarV = cVar.V();
                    xa.g gVarD = xa.g.d(cVar.f1());
                    gVarD.f54987c = xa.k.e(gVarD.f54987c);
                    gVarD.f54988d = xa.k.e(gVarD.f54988d);
                    for (int i12 = 0; i12 < fArrA.length; i12 = i10 + 2) {
                        int i13 = i12 / 2;
                        int iV0 = cVar.v0(this.f52816g.f52817a + i13);
                        int iArgb = Color.argb(Math.round(255.0f * f12), Color.red(iV0), Color.green(iV0), Color.blue(iV0));
                        float f13 = fArrA[i12];
                        float f14 = fArrA[i12 + 1];
                        if (!this.f52889a.J(f13)) {
                            break;
                        }
                        if (this.f52889a.I(f13) && this.f52889a.M(f14)) {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) cVar.Z(i13 + this.f52816g.f52817a);
                            if (cVar.V0()) {
                                bubbleEntry = bubbleEntry2;
                                f10 = f14;
                                f11 = f13;
                                i10 = i12;
                                e(canvas, lVarV.f(bubbleEntry2), f13, f14 + (0.5f * fA), iArgb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f10 = f14;
                                f11 = f13;
                                i10 = i12;
                            }
                            if (bubbleEntry.b() != null && cVar.C()) {
                                Drawable drawableB = bubbleEntry.b();
                                xa.k.k(canvas, drawableB, (int) (f11 + gVarD.f54987c), (int) (f10 + gVarD.f54988d), drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                            }
                        } else {
                            i10 = i12;
                        }
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
    public void n(Canvas canvas, qa.c cVar) {
        if (cVar.e1() < 1) {
            return;
        }
        xa.i iVarA = this.f52821h.a(cVar.a1());
        float fI = this.f52835b.i();
        this.f52816g.a(this.f52821h, cVar);
        float[] fArr = this.f52822i;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        iVarA.o(fArr);
        boolean zF = cVar.f();
        float[] fArr2 = this.f52822i;
        float fMin = Math.min(Math.abs(this.f52889a.f() - this.f52889a.j()), Math.abs(fArr2[2] - fArr2[0]));
        int i10 = this.f52816g.f52817a;
        while (true) {
            c.a aVar = this.f52816g;
            if (i10 > aVar.f52819c + aVar.f52817a) {
                return;
            }
            BubbleEntry bubbleEntry = (BubbleEntry) cVar.Z(i10);
            this.f52823j[0] = bubbleEntry.F();
            this.f52823j[1] = bubbleEntry.e() * fI;
            iVarA.o(this.f52823j);
            float fO = o(bubbleEntry.T(), cVar.a(), fMin, zF) / 2.0f;
            if (this.f52889a.K(this.f52823j[1] + fO) && this.f52889a.H(this.f52823j[1] - fO) && this.f52889a.I(this.f52823j[0] + fO)) {
                if (!this.f52889a.J(this.f52823j[0] - fO)) {
                    return;
                }
                this.f52836c.setColor(cVar.f0((int) bubbleEntry.F()));
                float[] fArr3 = this.f52823j;
                canvas.drawCircle(fArr3[0], fArr3[1], fO, this.f52836c);
            }
            i10++;
        }
    }

    public float o(float f10, float f11, float f12, boolean z10) {
        if (z10) {
            f10 = f11 == 0.0f ? 1.0f : (float) Math.sqrt(f10 / f11);
        }
        return f12 * f10;
    }
}
