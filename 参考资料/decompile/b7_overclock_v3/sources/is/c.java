package is;

import ft.x;
import ft.y;
import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f35758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zn.b f35759f;

    public c(int i10, int i11, ft.h hVar, y yVar, x xVar, zn.b bVar) {
        this.f35754a = i10;
        this.f35755b = i11;
        this.f35756c = hVar.e();
        this.f35757d = yVar.o();
        this.f35758e = xVar.b();
        this.f35759f = bVar;
    }

    public c(f0 f0Var) {
        this.f35754a = ((t) f0Var.K(0)).Q();
        this.f35755b = ((t) f0Var.K(1)).Q();
        this.f35756c = ((z) f0Var.K(2)).J();
        this.f35757d = ((z) f0Var.K(3)).J();
        this.f35758e = ((z) f0Var.K(4)).J();
        this.f35759f = zn.b.z(f0Var.K(5));
    }

    public static c A(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    public int B() {
        return this.f35755b;
    }

    public int C() {
        return this.f35754a;
    }

    public x D() {
        return new x(this.f35758e);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f35754a));
        iVar.a(new t(this.f35755b));
        iVar.a(new f2(this.f35756c));
        iVar.a(new f2(this.f35757d));
        iVar.a(new f2(this.f35758e));
        iVar.a(this.f35759f);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f35759f;
    }

    public ft.h y() {
        return new ft.h(this.f35756c);
    }

    public y z() {
        return new y(y(), this.f35757d);
    }
}
