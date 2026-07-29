package mm;

import gm.j2;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class v0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u0 f41419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f41420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.h0 f41421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f41422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.z f41423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.h0 f41424g;

    public v0(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f41418a = (gm.t) enumerationL.nextElement();
        this.f41419b = u0.y(enumerationL.nextElement());
        this.f41420c = zn.b.z(enumerationL.nextElement());
        Object objNextElement = enumerationL.nextElement();
        if (objNextElement instanceof gm.n0) {
            this.f41421d = gm.h0.H((gm.n0) objNextElement, false);
            objNextElement = enumerationL.nextElement();
        } else {
            this.f41421d = null;
        }
        this.f41422e = zn.b.z(objNextElement);
        this.f41423f = gm.z.I(enumerationL.nextElement());
        if (enumerationL.hasMoreElements()) {
            this.f41424g = gm.h0.H((gm.n0) enumerationL.nextElement(), false);
        } else {
            this.f41424g = null;
        }
    }

    public v0(u0 u0Var, zn.b bVar, gm.h0 h0Var, zn.b bVar2, gm.z zVar, gm.h0 h0Var2) {
        this.f41418a = u0Var.z() ? new gm.t(3L) : new gm.t(1L);
        this.f41419b = u0Var;
        this.f41420c = bVar;
        this.f41421d = h0Var;
        this.f41422e = bVar2;
        this.f41423f = zVar;
        this.f41424g = h0Var2;
    }

    public v0(u0 u0Var, zn.b bVar, c cVar, zn.b bVar2, gm.z zVar, c cVar2) {
        this.f41418a = u0Var.z() ? new gm.t(3L) : new gm.t(1L);
        this.f41419b = u0Var;
        this.f41420c = bVar;
        this.f41421d = gm.h0.I(cVar);
        this.f41422e = bVar2;
        this.f41423f = zVar;
        this.f41424g = gm.h0.I(cVar2);
    }

    public static v0 B(Object obj) throws IllegalArgumentException {
        if (obj instanceof v0) {
            return (v0) obj;
        }
        if (obj != null) {
            return new v0(gm.f0.J(obj));
        }
        return null;
    }

    public gm.z A() {
        return this.f41423f;
    }

    public u0 C() {
        return this.f41419b;
    }

    public gm.h0 D() {
        return this.f41424g;
    }

    public gm.t E() {
        return this.f41418a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(7);
        iVar.a(this.f41418a);
        iVar.a(this.f41419b);
        iVar.a(this.f41420c);
        gm.h0 h0Var = this.f41421d;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        iVar.a(this.f41422e);
        iVar.a(this.f41423f);
        gm.h0 h0Var2 = this.f41424g;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var2));
        }
        return new j2(iVar);
    }

    public gm.h0 x() {
        return this.f41421d;
    }

    public zn.b y() {
        return this.f41420c;
    }

    public zn.b z() {
        return this.f41422e;
    }
}
