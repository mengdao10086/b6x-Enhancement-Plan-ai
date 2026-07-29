package zn;

import gm.j2;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class z extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f59108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f59109b;

    public z(gm.f0 f0Var) {
        this.f59108a = new Hashtable();
        this.f59109b = new Vector();
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            y yVarB = y.B(enumerationL.nextElement());
            if (this.f59108a.containsKey(yVarB.z())) {
                throw new IllegalArgumentException("repeated extension found: " + yVarB.z());
            }
            this.f59108a.put(yVarB.z(), yVarB);
            this.f59109b.addElement(yVarB.z());
        }
    }

    public z(y yVar) {
        this.f59108a = new Hashtable();
        Vector vector = new Vector();
        this.f59109b = vector;
        vector.addElement(yVar.z());
        this.f59108a.put(yVar.z(), yVar);
    }

    public z(y[] yVarArr) {
        this.f59108a = new Hashtable();
        this.f59109b = new Vector();
        for (int i10 = 0; i10 != yVarArr.length; i10++) {
            y yVar = yVarArr[i10];
            this.f59109b.addElement(yVar.z());
            this.f59108a.put(yVar.z(), yVar);
        }
    }

    public static y A(z zVar, gm.y yVar) {
        if (zVar == null) {
            return null;
        }
        return zVar.z(yVar);
    }

    public static gm.h E(z zVar, gm.y yVar) {
        if (zVar == null) {
            return null;
        }
        return zVar.D(yVar);
    }

    public static z F(gm.n0 n0Var, boolean z10) {
        return G(gm.f0.I(n0Var, z10));
    }

    public static z G(Object obj) {
        if (obj instanceof z) {
            return (z) obj;
        }
        if (obj != null) {
            return new z(gm.f0.J(obj));
        }
        return null;
    }

    public gm.y[] B() {
        return J(this.f59109b);
    }

    public final gm.y[] C(boolean z10) {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f59109b.size(); i10++) {
            Object objElementAt = this.f59109b.elementAt(i10);
            if (((y) this.f59108a.get(objElementAt)).D() == z10) {
                vector.addElement(objElementAt);
            }
        }
        return J(vector);
    }

    public gm.h D(gm.y yVar) {
        y yVarZ = z(yVar);
        if (yVarZ != null) {
            return yVarZ.C();
        }
        return null;
    }

    public gm.y[] H() {
        return C(false);
    }

    public Enumeration I() {
        return this.f59109b.elements();
    }

    public final gm.y[] J(Vector vector) {
        int size = vector.size();
        gm.y[] yVarArr = new gm.y[size];
        for (int i10 = 0; i10 != size; i10++) {
            yVarArr[i10] = (gm.y) vector.elementAt(i10);
        }
        return yVarArr;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(this.f59109b.size());
        Enumeration enumerationElements = this.f59109b.elements();
        while (enumerationElements.hasMoreElements()) {
            iVar.a((y) this.f59108a.get((gm.y) enumerationElements.nextElement()));
        }
        return new j2(iVar);
    }

    public boolean x(z zVar) {
        if (this.f59108a.size() != zVar.f59108a.size()) {
            return false;
        }
        Enumeration enumerationKeys = this.f59108a.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            if (!this.f59108a.get(objNextElement).equals(zVar.f59108a.get(objNextElement))) {
                return false;
            }
        }
        return true;
    }

    public gm.y[] y() {
        return C(true);
    }

    public y z(gm.y yVar) {
        return (y) this.f59108a.get(yVar);
    }
}
