package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class e0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t[] f39889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t[] f39890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v[] f39891c;

    public e0(gm.f0 f0Var) {
        this.f39889a = new gm.t[f0Var.size()];
        this.f39890b = new gm.t[f0Var.size()];
        this.f39891c = new v[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.f0 f0VarJ = gm.f0.J(f0Var.K(i10));
            this.f39889a[i10] = gm.t.I(f0VarJ.K(0));
            this.f39890b[i10] = gm.t.I(f0VarJ.K(1));
            if (f0VarJ.size() > 2) {
                this.f39891c[i10] = v.y(f0VarJ.K(2));
            }
        }
    }

    public e0(gm.t tVar, gm.t tVar2) {
        this(tVar, tVar2, null);
    }

    public e0(gm.t tVar, gm.t tVar2, v vVar) {
        this.f39889a = new gm.t[]{tVar};
        this.f39890b = new gm.t[]{tVar2};
        this.f39891c = new v[]{vVar};
    }

    public static e0 z(Object obj) {
        if (obj instanceof e0) {
            return (e0) obj;
        }
        if (obj != null) {
            return new e0(gm.f0.J(obj));
        }
        return null;
    }

    public v A(int i10) {
        return this.f39891c[i10];
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(this.f39889a.length);
        for (int i10 = 0; i10 != this.f39889a.length; i10++) {
            gm.i iVar2 = new gm.i(3);
            iVar2.a(this.f39889a[i10]);
            iVar2.a(this.f39890b[i10]);
            v[] vVarArr = this.f39891c;
            if (vVarArr[i10] != null) {
                iVar2.a(vVarArr[i10]);
            }
            iVar.a(new j2(iVar2));
        }
        return new j2(iVar);
    }

    public int size() {
        return this.f39889a.length;
    }

    public gm.t x(int i10) {
        return this.f39889a[i10];
    }

    public gm.t y(int i10) {
        return this.f39890b[i10];
    }
}
