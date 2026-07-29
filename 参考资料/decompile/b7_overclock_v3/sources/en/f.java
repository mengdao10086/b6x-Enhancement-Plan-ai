package en;

import gm.c0;
import gm.c2;
import gm.f0;
import gm.j2;
import gm.k0;
import gm.n0;
import gm.r;
import gm.w;
import gm.y;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f27050d = new y(cn.a.f10981o + ".1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f27051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f27052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xn.b f27053c;

    public f(f0 f0Var) {
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        if (enumerationL.hasMoreElements()) {
            gm.h hVar = (gm.h) enumerationL.nextElement();
            if (hVar instanceof y) {
                this.f27051a = (y) hVar;
            } else if (hVar instanceof r) {
                this.f27052b = r.I(hVar).d();
            } else {
                if (!(hVar instanceof k0)) {
                    throw new IllegalArgumentException("Bad object encountered: " + hVar.getClass());
                }
                this.f27053c = xn.b.y(hVar);
            }
        }
        if (enumerationL.hasMoreElements()) {
            gm.h hVar2 = (gm.h) enumerationL.nextElement();
            if (hVar2 instanceof r) {
                this.f27052b = r.I(hVar2).d();
            } else {
                if (!(hVar2 instanceof k0)) {
                    throw new IllegalArgumentException("Bad object encountered: " + hVar2.getClass());
                }
                this.f27053c = xn.b.y(hVar2);
            }
        }
        if (enumerationL.hasMoreElements()) {
            gm.h hVar3 = (gm.h) enumerationL.nextElement();
            if (hVar3 instanceof k0) {
                this.f27053c = xn.b.y(hVar3);
                return;
            }
            throw new IllegalArgumentException("Bad object encountered: " + hVar3.getClass());
        }
    }

    public f(y yVar, String str, xn.b bVar) {
        this.f27051a = yVar;
        this.f27052b = str;
        this.f27053c = bVar;
    }

    public static f x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static f y(Object obj) {
        if (obj == null || (obj instanceof f)) {
            return (f) obj;
        }
        if (obj instanceof f0) {
            return new f((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public xn.b A() {
        return this.f27053c;
    }

    public String B() {
        return this.f27052b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        y yVar = this.f27051a;
        if (yVar != null) {
            iVar.a(yVar);
        }
        if (this.f27052b != null) {
            iVar.a(new c2(this.f27052b, true));
        }
        xn.b bVar = this.f27053c;
        if (bVar != null) {
            iVar.a(bVar);
        }
        return new j2(iVar);
    }

    public y z() {
        return this.f27051a;
    }
}
