package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f39899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f39900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f39901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f39902d;

    public h(gm.f0 f0Var) {
        gm.h hVarK;
        this.f39899a = gm.t.I(f0Var.K(0));
        this.f39900b = b0.z(f0Var.K(1));
        if (f0Var.size() >= 3) {
            if (f0Var.size() == 3) {
                hVarK = f0Var.K(2);
                if (!(hVarK instanceof gm.z)) {
                    this.f39901c = j.y(hVarK);
                    return;
                }
            } else {
                this.f39901c = j.y(f0Var.K(2));
                hVarK = f0Var.K(3);
            }
            this.f39902d = gm.z.I(hVarK);
        }
    }

    public h(gm.t tVar, b0 b0Var) {
        this(tVar, b0Var, null, null);
    }

    public h(gm.t tVar, b0 b0Var, j jVar, gm.z zVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("'certReqId' cannot be null");
        }
        if (b0Var == null) {
            throw new IllegalArgumentException("'status' cannot be null");
        }
        this.f39899a = tVar;
        this.f39900b = b0Var;
        this.f39901c = jVar;
        this.f39902d = zVar;
    }

    public static h z(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(gm.f0.J(obj));
        }
        return null;
    }

    public b0 A() {
        return this.f39900b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f39899a);
        iVar.a(this.f39900b);
        j jVar = this.f39901c;
        if (jVar != null) {
            iVar.a(jVar);
        }
        gm.z zVar = this.f39902d;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public gm.t x() {
        return this.f39899a;
    }

    public j y() {
        return this.f39901c;
    }
}
