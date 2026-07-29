package pn;

import gm.f0;
import gm.i1;
import gm.n0;
import gm.n1;
import gm.z2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f46760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f46761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f46762c;

    public g(f0 f0Var) {
        this.f46762c = true;
        Enumeration enumerationL = f0Var.L();
        this.f46760a = (gm.y) enumerationL.nextElement();
        if (enumerationL.hasMoreElements()) {
            this.f46761b = ((n0) enumerationL.nextElement()).U();
        }
        this.f46762c = f0Var instanceof i1;
    }

    public g(gm.y yVar, gm.h hVar) {
        this.f46762c = true;
        this.f46760a = yVar;
        this.f46761b = hVar;
    }

    public static g z(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46760a);
        gm.h hVar = this.f46761b;
        if (hVar != null) {
            iVar.a(new n1(true, 0, hVar));
        }
        return this.f46762c ? new i1(iVar) : new z2(iVar);
    }

    public gm.h x() {
        return this.f46761b;
    }

    public gm.y y() {
        return this.f46760a;
    }
}
