package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class k1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f58814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f58815b;

    public k1(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f58814a = n0.y(f0Var.K(0));
            this.f58815b = u.y(f0Var.K(1));
            return;
        }
        if (f0Var.size() == 1) {
            boolean z10 = f0Var.K(0).b() instanceof gm.f0;
            gm.h hVarK = f0Var.K(0);
            if (!z10) {
                this.f58815b = u.y(hVarK);
                this.f58814a = null;
                return;
            }
            this.f58814a = n0.y(hVarK);
        } else {
            if (f0Var.size() != 0) {
                throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
            }
            this.f58814a = null;
        }
        this.f58815b = null;
    }

    public k1(n0 n0Var, String str) {
        this(n0Var, new u(str));
    }

    public k1(n0 n0Var, u uVar) {
        this.f58814a = n0Var;
        this.f58815b = uVar;
    }

    public static k1 y(Object obj) {
        if (obj instanceof k1) {
            return (k1) obj;
        }
        if (obj != null) {
            return new k1(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        n0 n0Var = this.f58814a;
        if (n0Var != null) {
            iVar.a(n0Var);
        }
        u uVar = this.f58815b;
        if (uVar != null) {
            iVar.a(uVar);
        }
        return new j2(iVar);
    }

    public u x() {
        return this.f58815b;
    }

    public n0 z() {
        return this.f58814a;
    }
}
