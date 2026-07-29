package pn;

import gm.f0;
import gm.h0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f46721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f46722b;

    public a(f0 f0Var) {
        this.f46721a = (gm.y) f0Var.K(0);
        this.f46722b = (h0) f0Var.K(1);
    }

    public a(gm.y yVar, h0 h0Var) {
        this.f46721a = yVar;
        this.f46722b = h0Var;
    }

    public static a A(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof f0) {
            return new a((f0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46721a);
        iVar.a(this.f46722b);
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f46721a;
    }

    public h0 y() {
        return this.f46722b;
    }

    public gm.h[] z() {
        return this.f46722b.O();
    }
}
