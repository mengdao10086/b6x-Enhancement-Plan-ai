package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f44276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f44277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f44278c;

    public e(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f44276a = f.A(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            Object objNextElement = enumerationL.nextElement();
            if ((objNextElement instanceof n0) || (objNextElement instanceof u)) {
                this.f44277b = u.x(objNextElement);
            } else {
                this.f44278c = f0.J(objNextElement);
            }
        }
    }

    public e(f fVar, u uVar, a[] aVarArr) {
        if (fVar == null) {
            throw new IllegalArgumentException("'certReq' cannot be null");
        }
        this.f44276a = fVar;
        this.f44277b = uVar;
        if (aVarArr != null) {
            this.f44278c = new j2(aVarArr);
        }
    }

    public static e A(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    public static e z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    public u B() {
        return this.f44277b;
    }

    public u C() {
        return this.f44277b;
    }

    public a[] D() {
        f0 f0Var = this.f44278c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        a[] aVarArr = new a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = a.x(this.f44278c.K(i10));
        }
        return aVarArr;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f44276a);
        x(iVar, this.f44277b);
        x(iVar, this.f44278c);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, gm.h hVar) {
        if (hVar != null) {
            iVar.a(hVar);
        }
    }

    public f y() {
        return this.f44276a;
    }
}
