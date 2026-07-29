package ra;

import android.view.View;
import xa.h;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class d extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static h<d> f47897i;

    static {
        h<d> hVarA = h.a(2, new d(null, 0.0f, 0.0f, null, null));
        f47897i = hVarA;
        hVarA.l(0.5f);
    }

    public d(l lVar, float f10, float f11, i iVar, View view) {
        super(lVar, f10, f11, iVar, view);
    }

    public static d d(l lVar, float f10, float f11, i iVar, View view) {
        d dVar = (d) f47897i.b();
        dVar.f47899d = lVar;
        dVar.f47900e = f10;
        dVar.f47901f = f11;
        dVar.f47902g = iVar;
        dVar.f47903h = view;
        return dVar;
    }

    public static void e(d dVar) {
        f47897i.h(dVar);
    }

    @Override // xa.h.a
    public h.a a() {
        return new d(this.f47899d, this.f47900e, this.f47901f, this.f47902g, this.f47903h);
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = this.f47898c;
        fArr[0] = this.f47900e;
        fArr[1] = this.f47901f;
        this.f47902g.o(fArr);
        this.f47899d.e(this.f47898c, this.f47903h);
        e(this);
    }
}
