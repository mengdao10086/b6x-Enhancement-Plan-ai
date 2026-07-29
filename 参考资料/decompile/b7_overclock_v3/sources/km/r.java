package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f37554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f37555b;

    public r(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("Sequence must be 2 elements.");
        }
        this.f37554a = gm.y.N(f0Var.K(0));
        this.f37555b = f0Var.K(1);
    }

    public r(gm.y yVar, gm.h hVar) {
        this.f37554a = yVar;
        this.f37555b = hVar;
    }

    public static r z(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (!(obj instanceof gm.h)) {
            if (obj instanceof byte[]) {
                return z(gm.f0.J(obj));
            }
            return null;
        }
        gm.c0 c0VarB = ((gm.h) obj).b();
        if (c0VarB instanceof gm.f0) {
            return new r((gm.f0) c0VarB);
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(new gm.h[]{this.f37554a, this.f37555b});
    }

    public gm.y x() {
        return this.f37554a;
    }

    public gm.h y() {
        return this.f37555b;
    }
}
