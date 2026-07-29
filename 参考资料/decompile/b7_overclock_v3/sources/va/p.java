package va;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes3.dex */
public class p extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public pa.h f52890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f52891j;

    public p(pa.h hVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52891j = new float[2];
        this.f52890i = hVar;
    }

    @Override // va.g
    public void b(Canvas canvas) {
        for (T t10 : this.f52890i.getScatterData().q()) {
            if (t10.isVisible()) {
                o(canvas, t10);
            }
        }
    }

    @Override // va.g
    public void c(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        la.s scatterData = this.f52890i.getScatterData();
        for (oa.d dVar : dVarArr) {
            qa.k kVar = (qa.k) scatterData.k(dVar.d());
            if (kVar != null && kVar.i1()) {
                ?? Y = kVar.y(dVar.h(), dVar.j());
                if (l(Y, kVar)) {
                    xa.f fVarF = this.f52890i.a(kVar.a1()).f(Y.F(), Y.e() * this.f52835b.i());
                    dVar.n((float) fVarF.f54983c, (float) fVarF.f54984d);
                    n(canvas, (float) fVarF.f54983c, (float) fVarF.f54984d, kVar);
                }
            }
        }
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    @Override // va.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: va.p.f(android.graphics.Canvas):void");
    }

    @Override // va.g
    public void j() {
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public void o(Canvas canvas, qa.k kVar) {
        int i10;
        if (kVar.e1() < 1) {
            return;
        }
        xa.l lVar = this.f52889a;
        xa.i iVarA = this.f52890i.a(kVar.a1());
        float fI = this.f52835b.i();
        wa.e eVarO0 = kVar.O0();
        if (eVarO0 == null) {
            return;
        }
        int iMin = (int) Math.min(Math.ceil(kVar.e1() * this.f52835b.h()), kVar.e1());
        int i11 = 0;
        while (i11 < iMin) {
            ?? Z = kVar.Z(i11);
            this.f52891j[0] = Z.F();
            this.f52891j[1] = Z.e() * fI;
            iVarA.o(this.f52891j);
            if (!lVar.J(this.f52891j[0])) {
                return;
            }
            if (lVar.I(this.f52891j[0]) && lVar.M(this.f52891j[1])) {
                this.f52836c.setColor(kVar.f0(i11 / 2));
                xa.l lVar2 = this.f52889a;
                float[] fArr = this.f52891j;
                i10 = i11;
                eVarO0.a(canvas, kVar, lVar2, fArr[0], fArr[1], this.f52836c);
            } else {
                i10 = i11;
            }
            i11 = i10 + 1;
        }
    }
}
