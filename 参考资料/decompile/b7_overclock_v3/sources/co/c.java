package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.u1;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.d f11095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f11096b;

    public c(gm.d dVar, t tVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("'pgenCounter' cannot be null");
        }
        this.f11095a = dVar;
        this.f11096b = tVar;
    }

    public c(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f11095a = u1.S(f0Var.K(0));
            this.f11096b = t.I(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public static c x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static c y(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    public gm.d A() {
        return this.f11095a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f11095a);
        iVar.a(this.f11096b);
        return new j2(iVar);
    }

    public t z() {
        return this.f11096b;
    }
}
