package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class l0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39928a;

    public l0(gm.f0 f0Var) {
        this.f39928a = f0Var;
    }

    public l0(i0 i0Var) {
        this.f39928a = new j2(i0Var);
    }

    public l0(i0[] i0VarArr) {
        this.f39928a = new j2(i0VarArr);
    }

    public static l0 x(Object obj) {
        if (obj instanceof l0) {
            return (l0) obj;
        }
        if (obj != null) {
            return new l0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39928a;
    }

    public i0[] y() {
        int size = this.f39928a.size();
        i0[] i0VarArr = new i0[size];
        for (int i10 = 0; i10 != size; i10++) {
            i0VarArr[i10] = i0.z(this.f39928a.K(i10));
        }
        return i0VarArr;
    }
}
