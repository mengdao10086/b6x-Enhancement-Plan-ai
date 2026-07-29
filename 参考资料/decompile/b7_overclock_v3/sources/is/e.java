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
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f35768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f35770g;

    public e(int i10, int i11, ft.h hVar, y yVar, x xVar, x xVar2, ft.e eVar) {
        this.f35764a = i10;
        this.f35765b = i11;
        this.f35766c = hVar.e();
        this.f35767d = yVar.o();
        this.f35768e = eVar.b();
        this.f35769f = xVar.b();
        this.f35770g = xVar2.b();
    }

    public e(f0 f0Var) {
        this.f35764a = ((t) f0Var.K(0)).Q();
        this.f35765b = ((t) f0Var.K(1)).Q();
        this.f35766c = ((z) f0Var.K(2)).J();
        this.f35767d = ((z) f0Var.K(3)).J();
        this.f35769f = ((z) f0Var.K(4)).J();
        this.f35770g = ((z) f0Var.K(5)).J();
        this.f35768e = ((z) f0Var.K(6)).J();
    }

    public static e z(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f35765b;
    }

    public int B() {
        return this.f35764a;
    }

    public x C() {
        return new x(this.f35769f);
    }

    public x D() {
        return new x(this.f35770g);
    }

    public ft.e E() {
        return new ft.e(this.f35768e);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f35764a));
        iVar.a(new t(this.f35765b));
        iVar.a(new f2(this.f35766c));
        iVar.a(new f2(this.f35767d));
        iVar.a(new f2(this.f35769f));
        iVar.a(new f2(this.f35770g));
        iVar.a(new f2(this.f35768e));
        return new j2(iVar);
    }

    public ft.h x() {
        return new ft.h(this.f35766c);
    }

    public y y() {
        return new y(x(), this.f35767d);
    }
}
