package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ft.e f35762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f35763d;

    public d(int i10, int i11, ft.e eVar, zn.b bVar) {
        this.f35760a = i10;
        this.f35761b = i11;
        this.f35762c = new ft.e(eVar.b());
        this.f35763d = bVar;
    }

    public d(f0 f0Var) {
        this.f35760a = ((t) f0Var.K(0)).Q();
        this.f35761b = ((t) f0Var.K(1)).Q();
        this.f35762c = new ft.e(((z) f0Var.K(2)).J());
        this.f35763d = zn.b.z(f0Var.K(3));
    }

    public static d z(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f35760a;
    }

    public int B() {
        return this.f35761b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f35760a));
        iVar.a(new t(this.f35761b));
        iVar.a(new f2(this.f35762c.b()));
        iVar.a(this.f35763d);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f35763d;
    }

    public ft.e y() {
        return this.f35762c;
    }
}
