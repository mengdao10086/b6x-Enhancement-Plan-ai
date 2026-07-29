package bo;

import gm.c0;
import gm.f0;
import gm.g;
import gm.i;
import gm.j2;
import gm.k0;
import gm.w;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.b f9501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.b f9502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f9503c;

    public a(f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        if (f0Var.K(0) instanceof k0) {
            this.f9502b = xn.b.y(f0Var.K(0));
            this.f9503c = f0.J(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad object encountered: " + f0Var.K(0).getClass());
        }
    }

    public a(String str) {
        this(new xn.b(str));
    }

    public a(xn.b bVar) {
        this.f9501a = bVar;
    }

    public a(xn.b bVar, f0 f0Var) {
        this.f9502b = bVar;
        this.f9503c = f0Var;
    }

    public static a y(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof k0) {
            return new a(xn.b.y(obj));
        }
        if (obj instanceof f0) {
            return new a((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public xn.b A() {
        return this.f9502b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        xn.b bVar = this.f9501a;
        if (bVar != null) {
            return bVar.b();
        }
        i iVar = new i(2);
        iVar.a(this.f9502b);
        iVar.a(this.f9503c);
        return new j2(iVar);
    }

    public xn.b[] x() {
        xn.b[] bVarArr = new xn.b[this.f9503c.size()];
        Enumeration enumerationL = this.f9503c.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            bVarArr[i10] = xn.b.y(enumerationL.nextElement());
            i10++;
        }
        return bVarArr;
    }

    public xn.b z() {
        return this.f9501a;
    }
}
