package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gm.y f58658c = new gm.y("1.3.6.1.5.5.7.48.2");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.y f58659d = new gm.y("1.3.6.1.5.5.7.48.1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f58660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f58661b;

    public a(gm.f0 f0Var) {
        this.f58660a = null;
        this.f58661b = null;
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("wrong number of elements in sequence");
        }
        this.f58660a = gm.y.N(f0Var.K(0));
        this.f58661b = b0.z(f0Var.K(1));
    }

    public a(gm.y yVar, b0 b0Var) {
        this.f58660a = yVar;
        this.f58661b = b0Var;
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58660a);
        iVar.a(this.f58661b);
        return new j2(iVar);
    }

    public String toString() {
        return "AccessDescription: Oid(" + this.f58660a.L() + ee.a.f26979d;
    }

    public b0 x() {
        return this.f58661b;
    }

    public gm.y y() {
        return this.f58660a;
    }
}
