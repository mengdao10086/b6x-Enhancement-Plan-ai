package zn;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f58680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.c0 f58681b;

    public c(c0 c0Var) {
        this.f58680a = c0Var;
        this.f58681b = c0Var.b();
    }

    public c(n1 n1Var) {
        this.f58680a = n1Var;
        this.f58681b = new n2(false, 0, (gm.h) n1Var);
    }

    public static c x(gm.n0 n0Var, boolean z10) {
        return y(n0Var.U());
    }

    public static c y(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof n1) {
            return new c(n1.z(obj));
        }
        if (obj instanceof c0) {
            return new c((c0) obj);
        }
        if (obj instanceof gm.n0) {
            return new c(n1.y((gm.n0) obj, false));
        }
        if (obj instanceof gm.f0) {
            return new c(c0.A(obj));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58681b;
    }

    public gm.h z() {
        return this.f58680a;
    }
}
