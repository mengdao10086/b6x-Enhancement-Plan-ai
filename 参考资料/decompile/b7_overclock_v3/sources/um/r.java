package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.k0;
import java.util.Enumeration;
import zn.n0;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f52269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.u f52270b;

    public r(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.h hVar = (gm.h) enumerationL.nextElement();
            if ((hVar instanceof zn.u) || (hVar instanceof k0)) {
                this.f52270b = zn.u.y(hVar);
            } else {
                if (!(hVar instanceof n0) && !(hVar instanceof f0)) {
                    throw new IllegalArgumentException("Invalid element in 'SPUserNotice': " + hVar.getClass().getName());
                }
                this.f52269a = n0.y(hVar);
            }
        }
    }

    public r(n0 n0Var, zn.u uVar) {
        this.f52269a = n0Var;
        this.f52270b = uVar;
    }

    public static r y(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        n0 n0Var = this.f52269a;
        if (n0Var != null) {
            iVar.a(n0Var);
        }
        zn.u uVar = this.f52270b;
        if (uVar != null) {
            iVar.a(uVar);
        }
        return new j2(iVar);
    }

    public zn.u x() {
        return this.f52270b;
    }

    public n0 z() {
        return this.f52269a;
    }
}
