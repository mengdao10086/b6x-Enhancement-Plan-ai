package ao;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import gm.y;
import java.util.Enumeration;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f8785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0[] f8786b;

    public g(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        if (f0Var.size() < 1) {
            throw new IllegalArgumentException("no objects in SemanticsInformation");
        }
        Object objNextElement = enumerationL.nextElement();
        if (objNextElement instanceof y) {
            this.f8785a = y.N(objNextElement);
            objNextElement = enumerationL.hasMoreElements() ? enumerationL.nextElement() : null;
        }
        if (objNextElement != null) {
            f0 f0VarJ = f0.J(objNextElement);
            this.f8786b = new b0[f0VarJ.size()];
            for (int i10 = 0; i10 < f0VarJ.size(); i10++) {
                this.f8786b[i10] = b0.z(f0VarJ.K(i10));
            }
        }
    }

    public g(y yVar) {
        this.f8785a = yVar;
        this.f8786b = null;
    }

    public g(y yVar, b0[] b0VarArr) {
        this.f8785a = yVar;
        this.f8786b = x(b0VarArr);
    }

    public g(b0[] b0VarArr) {
        this.f8785a = null;
        this.f8786b = x(b0VarArr);
    }

    public static b0[] x(b0[] b0VarArr) {
        if (b0VarArr == null) {
            return null;
        }
        b0[] b0VarArr2 = new b0[b0VarArr.length];
        System.arraycopy(b0VarArr, 0, b0VarArr2, 0, b0VarArr.length);
        return b0VarArr2;
    }

    public static g y(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public y A() {
        return this.f8785a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        y yVar = this.f8785a;
        if (yVar != null) {
            iVar.a(yVar);
        }
        if (this.f8786b != null) {
            iVar.a(new j2(this.f8786b));
        }
        return new j2(iVar);
    }

    public b0[] z() {
        return x(this.f8786b);
    }
}
