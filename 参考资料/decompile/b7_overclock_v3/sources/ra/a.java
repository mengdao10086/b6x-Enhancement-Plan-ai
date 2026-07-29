package ra;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import xa.h;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public class a extends b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static h<a> f47884m;

    static {
        h<a> hVarA = h.a(4, new a(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        f47884m = hVarA;
        hVarA.l(0.5f);
    }

    public a(l lVar, float f10, float f11, i iVar, View view, float f12, float f13, long j10) {
        super(lVar, f10, f11, iVar, view, f12, f13, j10);
    }

    public static a j(l lVar, float f10, float f11, i iVar, View view, float f12, float f13, long j10) {
        a aVar = (a) f47884m.b();
        aVar.f47899d = lVar;
        aVar.f47900e = f10;
        aVar.f47901f = f11;
        aVar.f47902g = iVar;
        aVar.f47903h = view;
        aVar.f47887k = f12;
        aVar.f47888l = f13;
        aVar.f47885i.setDuration(j10);
        return aVar;
    }

    public static void k(a aVar) {
        f47884m.h(aVar);
    }

    @Override // xa.h.a
    public h.a a() {
        return new a(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }

    @Override // ra.b
    public void g() {
        k(this);
    }

    @Override // ra.b, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.f47898c;
        float f10 = this.f47887k;
        float f11 = this.f47900e - f10;
        float f12 = this.f47886j;
        fArr[0] = f10 + (f11 * f12);
        float f13 = this.f47888l;
        fArr[1] = f13 + ((this.f47901f - f13) * f12);
        this.f47902g.o(fArr);
        this.f47899d.e(this.f47898c, this.f47903h);
    }
}
