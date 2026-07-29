package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f58700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h0 f58701b;

    public e(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f58700a = gm.y.N(f0Var.K(0));
            this.f58701b = gm.h0.I(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public e(gm.y yVar, gm.h0 h0Var) {
        this.f58700a = yVar;
        this.f58701b = h0Var;
    }

    public static e A(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58700a);
        iVar.a(this.f58701b);
        return new j2(iVar);
    }

    public gm.y x() {
        return new gm.y(this.f58700a.L());
    }

    public gm.h0 y() {
        return this.f58701b;
    }

    public gm.h[] z() {
        return this.f58701b.O();
    }
}
