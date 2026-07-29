package pn;

import gm.f0;
import gm.h0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f46747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f46748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f46749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f46750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.z f46751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f46752g;

    public d0(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f46746a = (gm.t) enumerationL.nextElement();
        this.f46747b = l.y(enumerationL.nextElement());
        this.f46748c = zn.b.z(enumerationL.nextElement());
        Object objNextElement = enumerationL.nextElement();
        if (objNextElement instanceof n0) {
            this.f46749d = h0.H((n0) objNextElement, false);
            objNextElement = enumerationL.nextElement();
        } else {
            this.f46749d = null;
        }
        this.f46750e = zn.b.z(objNextElement);
        this.f46751f = gm.z.I(enumerationL.nextElement());
        if (enumerationL.hasMoreElements()) {
            this.f46752g = h0.H((n0) enumerationL.nextElement(), false);
        } else {
            this.f46752g = null;
        }
    }

    public d0(gm.t tVar, l lVar, zn.b bVar, h0 h0Var, zn.b bVar2, gm.z zVar, h0 h0Var2) {
        this.f46746a = tVar;
        this.f46747b = lVar;
        this.f46748c = bVar;
        this.f46749d = h0Var;
        this.f46750e = bVar2;
        this.f46751f = zVar;
        this.f46752g = h0Var2;
    }

    public static d0 B(Object obj) {
        if (obj instanceof d0) {
            return (d0) obj;
        }
        if (obj instanceof f0) {
            return new d0((f0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public gm.z A() {
        return this.f46751f;
    }

    public l C() {
        return this.f46747b;
    }

    public h0 D() {
        return this.f46752g;
    }

    public gm.t E() {
        return this.f46746a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(7);
        iVar.a(this.f46746a);
        iVar.a(this.f46747b);
        iVar.a(this.f46748c);
        h0 h0Var = this.f46749d;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        iVar.a(this.f46750e);
        iVar.a(this.f46751f);
        h0 h0Var2 = this.f46752g;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var2));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f46749d;
    }

    public zn.b y() {
        return this.f46748c;
    }

    public zn.b z() {
        return this.f46750e;
    }
}
