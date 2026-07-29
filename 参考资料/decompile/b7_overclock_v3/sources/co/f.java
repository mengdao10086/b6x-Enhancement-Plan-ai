package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import gm.y;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f11102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f11103b;

    public f(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f11102a = (y) enumerationL.nextElement();
        this.f11103b = (z) enumerationL.nextElement();
    }

    public f(y yVar, z zVar) {
        this.f11102a = yVar;
        this.f11103b = zVar;
    }

    public static f z(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f11102a);
        iVar.a(this.f11103b);
        return new j2(iVar);
    }

    public y x() {
        return this.f11102a;
    }

    public z y() {
        return this.f11103b;
    }
}
