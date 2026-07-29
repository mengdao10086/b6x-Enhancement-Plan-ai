package va;

import android.graphics.Canvas;
import com.github.mikephil.charting.components.XAxis;

/* JADX INFO: loaded from: classes3.dex */
public class s extends q {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ja.i f52902p;

    public s(xa.l lVar, XAxis xAxis, ja.i iVar) {
        super(lVar, xAxis, null);
        this.f52902p = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // va.q, va.a
    public void g(Canvas canvas) {
        if (this.f52892h.f() && this.f52892h.P()) {
            float fV0 = this.f52892h.v0();
            xa.g gVarC = xa.g.c(0.5f, 0.25f);
            this.f52807e.setTypeface(this.f52892h.c());
            this.f52807e.setTextSize(this.f52892h.b());
            this.f52807e.setColor(this.f52892h.a());
            float sliceAngle = this.f52902p.getSliceAngle();
            float factor = this.f52902p.getFactor();
            xa.g centerOffsets = this.f52902p.getCenterOffsets();
            xa.g gVarC2 = xa.g.c(0.0f, 0.0f);
            for (int i10 = 0; i10 < ((la.q) this.f52902p.getData()).w().e1(); i10++) {
                float f10 = i10;
                String strC = this.f52892h.H().c(f10, this.f52892h);
                xa.k.B(centerOffsets, (this.f52902p.getYRange() * factor) + (this.f52892h.L / 2.0f), ((f10 * sliceAngle) + this.f52902p.getRotationAngle()) % 360.0f, gVarC2);
                m(canvas, strC, gVarC2.f54987c, gVarC2.f54988d - (this.f52892h.M / 2.0f), gVarC, fV0);
            }
            xa.g.h(centerOffsets);
            xa.g.h(gVarC2);
            xa.g.h(gVarC);
        }
    }

    @Override // va.q, va.a
    public void j(Canvas canvas) {
    }
}
