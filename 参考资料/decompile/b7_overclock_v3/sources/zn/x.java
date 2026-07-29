package zn;

import gm.j2;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f59053a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f0 f59054b;

    public x(gm.f0 f0Var) {
        this.f59054b = f0Var;
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.h hVar = (gm.h) enumerationL.nextElement();
            if (!(hVar.b() instanceof gm.y)) {
                throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
            }
            this.f59053a.put(hVar, hVar);
        }
    }

    public x(Vector vector) {
        gm.i iVar = new gm.i(vector.size());
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            j0 j0VarY = j0.y(enumerationElements.nextElement());
            iVar.a(j0VarY);
            this.f59053a.put(j0VarY, j0VarY);
        }
        this.f59054b = new j2(iVar);
    }

    public x(j0 j0Var) {
        this.f59054b = new j2(j0Var);
        this.f59053a.put(j0Var, j0Var);
    }

    public x(j0[] j0VarArr) {
        gm.i iVar = new gm.i(j0VarArr.length);
        for (int i10 = 0; i10 != j0VarArr.length; i10++) {
            iVar.a(j0VarArr[i10]);
            this.f59053a.put(j0VarArr[i10], j0VarArr[i10]);
        }
        this.f59054b = new j2(iVar);
    }

    public static x x(z zVar) {
        return z(z.E(zVar, y.f59080x));
    }

    public static x y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static x z(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(gm.f0.J(obj));
        }
        return null;
    }

    public j0[] A() {
        j0[] j0VarArr = new j0[this.f59054b.size()];
        Enumeration enumerationL = this.f59054b.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            j0VarArr[i10] = j0.y(enumerationL.nextElement());
            i10++;
        }
        return j0VarArr;
    }

    public boolean B(j0 j0Var) {
        return this.f59053a.get(j0Var) != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f59054b;
    }

    public int size() {
        return this.f59053a.size();
    }
}
