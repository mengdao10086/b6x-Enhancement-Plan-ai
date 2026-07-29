package r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class b implements e {
    @Override // r.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        dVar.c(new f(colorStateList, f10));
        View viewG = dVar.g();
        viewG.setClipToOutline(true);
        viewG.setElevation(f11);
        n(dVar, f12);
    }

    @Override // r.e
    public float b(d dVar) {
        return k(dVar) * 2.0f;
    }

    @Override // r.e
    public ColorStateList c(d dVar) {
        return p(dVar).b();
    }

    @Override // r.e
    public float d(d dVar) {
        return dVar.g().getElevation();
    }

    @Override // r.e
    public void e(d dVar, float f10) {
        dVar.g().setElevation(f10);
    }

    @Override // r.e
    public void f(d dVar) {
        n(dVar, g(dVar));
    }

    @Override // r.e
    public float g(d dVar) {
        return p(dVar).c();
    }

    @Override // r.e
    public float h(d dVar) {
        return k(dVar) * 2.0f;
    }

    @Override // r.e
    public void i(d dVar) {
        n(dVar, g(dVar));
    }

    @Override // r.e
    public void j(d dVar, float f10) {
        p(dVar).h(f10);
    }

    @Override // r.e
    public float k(d dVar) {
        return p(dVar).d();
    }

    @Override // r.e
    public void l() {
    }

    @Override // r.e
    public void m(d dVar) {
        if (!dVar.e()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float fG = g(dVar);
        float fK = k(dVar);
        int iCeil = (int) Math.ceil(g.c(fG, fK, dVar.d()));
        int iCeil2 = (int) Math.ceil(g.d(fG, fK, dVar.d()));
        dVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // r.e
    public void n(d dVar, float f10) {
        p(dVar).g(f10, dVar.e(), dVar.d());
        m(dVar);
    }

    @Override // r.e
    public void o(d dVar, @p0 ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    public final f p(d dVar) {
        return (f) dVar.f();
    }
}
