package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f11104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f11105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f11106c;

    public g(f fVar, z zVar, z zVar2) {
        this.f11104a = fVar;
        this.f11105b = zVar;
        this.f11106c = zVar2;
    }

    public g(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f11104a = f.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            if (n0Var.q() == 0) {
                this.f11105b = (z) n0Var.U();
            } else if (n0Var.q() == 2) {
                this.f11106c = (z) n0Var.U();
            }
        }
    }

    public static g x(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public z A() {
        return this.f11106c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f11104a);
        z zVar = this.f11105b;
        if (zVar != null) {
            iVar.a(new n2(0, zVar));
        }
        iVar.a(new n2(2, this.f11106c));
        return new j2(iVar);
    }

    public f y() {
        return this.f11104a;
    }

    public z z() {
        return this.f11105b;
    }
}
