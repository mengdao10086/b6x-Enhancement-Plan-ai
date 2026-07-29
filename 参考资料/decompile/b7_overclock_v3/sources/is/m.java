package is;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes6.dex */
public class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f35823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f35826d;

    public m(int i10, int i11, zn.b bVar) {
        this.f35823a = new t(0L);
        this.f35824b = i10;
        this.f35825c = i11;
        this.f35826d = bVar;
    }

    public m(f0 f0Var) {
        this.f35823a = t.I(f0Var.K(0));
        this.f35824b = t.I(f0Var.K(1)).Q();
        this.f35825c = t.I(f0Var.K(2)).Q();
        this.f35826d = zn.b.z(f0Var.K(3));
    }

    public static m y(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f35826d;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35823a);
        iVar.a(new t(this.f35824b));
        iVar.a(new t(this.f35825c));
        iVar.a(this.f35826d);
        return new j2(iVar);
    }

    public int x() {
        return this.f35824b;
    }

    public int z() {
        return this.f35825c;
    }
}
