package om;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f44303a;

    public i(f0 f0Var) {
        this.f44303a = f0Var;
    }

    public i(a aVar) {
        this.f44303a = new j2(aVar);
    }

    public i(a[] aVarArr) {
        this.f44303a = new j2(aVarArr);
    }

    public static i x(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f44303a;
    }

    public a[] y() {
        int size = this.f44303a.size();
        a[] aVarArr = new a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = a.x(this.f44303a.K(i10));
        }
        return aVarArr;
    }
}
