package lm;

import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f0 f39896b;

    public g(gm.f0 f0Var) {
        int i10 = 1;
        if (f0Var.size() > 1) {
            this.f39895a = gm.f0.I((n0) f0Var.K(0), true);
        } else {
            i10 = 0;
        }
        this.f39896b = gm.f0.J(f0Var.K(i10));
    }

    public g(b[] bVarArr, h[] hVarArr) {
        if (hVarArr == null) {
            throw new IllegalArgumentException("'response' cannot be null");
        }
        if (bVarArr != null) {
            this.f39895a = new j2(bVarArr);
        }
        this.f39896b = new j2(hVarArr);
    }

    public static g y(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        gm.f0 f0Var = this.f39895a;
        if (f0Var != null) {
            iVar.a(new n2(true, 1, (gm.h) f0Var));
        }
        iVar.a(this.f39896b);
        return new j2(iVar);
    }

    public b[] x() {
        gm.f0 f0Var = this.f39895a;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        b[] bVarArr = new b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = b.x(this.f39895a.K(i10));
        }
        return bVarArr;
    }

    public h[] z() {
        int size = this.f39896b.size();
        h[] hVarArr = new h[size];
        for (int i10 = 0; i10 != size; i10++) {
            hVarArr[i10] = h.z(this.f39896b.K(i10));
        }
        return hVarArr;
    }
}
