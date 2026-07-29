package xn;

import gm.c0;
import gm.d0;
import gm.g;
import gm.h;
import gm.k0;
import gm.l0;
import gm.n0;
import gm.p2;
import gm.r0;
import gm.s0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w implements g, k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f55654a;

    public b(gm.c cVar) {
        this.f55654a = cVar;
    }

    public b(d0 d0Var) {
        this.f55654a = d0Var;
    }

    public b(l0 l0Var) {
        this.f55654a = l0Var;
    }

    public b(r0 r0Var) {
        this.f55654a = r0Var;
    }

    public b(s0 s0Var) {
        this.f55654a = s0Var;
    }

    public b(String str) {
        this.f55654a = new p2(str);
    }

    public static b x(n0 n0Var, boolean z10) {
        if (z10) {
            return y(n0Var.U());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public static b y(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof l0) {
            return new b((l0) obj);
        }
        if (obj instanceof d0) {
            return new b((d0) obj);
        }
        if (obj instanceof s0) {
            return new b((s0) obj);
        }
        if (obj instanceof r0) {
            return new b((r0) obj);
        }
        if (obj instanceof gm.c) {
            return new b((gm.c) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return ((h) this.f55654a).b();
    }

    @Override // gm.k0
    public String d() {
        return this.f55654a.d();
    }

    public String toString() {
        return this.f55654a.d();
    }
}
