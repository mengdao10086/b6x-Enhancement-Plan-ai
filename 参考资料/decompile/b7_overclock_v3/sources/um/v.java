package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f52276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f52277c;

    public v(f0 f0Var) {
        if (f0Var.size() != 2 && f0Var.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f52275a = gm.y.N(f0Var.K(0));
        this.f52276b = n.z(f0Var.K(1));
        if (f0Var.size() == 3) {
            this.f52277c = u.y(f0Var.K(2));
        }
    }

    public v(gm.y yVar, n nVar) {
        this(yVar, nVar, null);
    }

    public v(gm.y yVar, n nVar, u uVar) {
        this.f52275a = yVar;
        this.f52276b = nVar;
        this.f52277c = uVar;
    }

    public static v x(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj != null) {
            return new v(f0.J(obj));
        }
        return null;
    }

    public u A() {
        return this.f52277c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f52275a);
        iVar.a(this.f52276b);
        u uVar = this.f52277c;
        if (uVar != null) {
            iVar.a(uVar);
        }
        return new j2(iVar);
    }

    public n y() {
        return this.f52276b;
    }

    public gm.y z() {
        return new gm.y(this.f52275a.L());
    }
}
