package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f42247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f42248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f42249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f42250d;

    public b(f0 f0Var) {
        this.f42247a = zn.b.z(f0Var.K(0));
        this.f42248b = (z) f0Var.K(1);
        this.f42249c = (z) f0Var.K(2);
        this.f42250d = (t) f0Var.K(3);
    }

    public b(zn.b bVar, z zVar, z zVar2, t tVar) {
        this.f42247a = bVar;
        this.f42248b = zVar;
        this.f42249c = zVar2;
        this.f42250d = tVar;
    }

    public static b y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public z A() {
        return this.f42249c;
    }

    public z B() {
        return this.f42248b;
    }

    public t C() {
        return this.f42250d;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f42247a);
        iVar.a(this.f42248b);
        iVar.a(this.f42249c);
        iVar.a(this.f42250d);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f42247a;
    }
}
