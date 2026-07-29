package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39886a;

    public d(gm.f0 f0Var) {
        this.f39886a = f0Var;
    }

    public d(zn.p pVar) {
        this.f39886a = new j2(pVar);
    }

    public static d y(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39886a;
    }

    public zn.p[] x() {
        int size = this.f39886a.size();
        zn.p[] pVarArr = new zn.p[size];
        for (int i10 = 0; i10 != size; i10++) {
            pVarArr[i10] = zn.p.y(this.f39886a.K(i10));
        }
        return pVarArr;
    }
}
