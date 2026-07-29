package zn;

import gm.j2;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class u1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f59008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f59009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gm.y f58982c = new gm.y("2.5.29.9");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.y f58983d = new gm.y("2.5.29.14");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gm.y f58984e = new gm.y("2.5.29.15");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final gm.y f58985f = new gm.y("2.5.29.16");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gm.y f58986g = new gm.y("2.5.29.17");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.y f58987h = new gm.y("2.5.29.18");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final gm.y f58988i = new gm.y("2.5.29.19");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gm.y f58989j = new gm.y("2.5.29.20");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gm.y f58990k = new gm.y("2.5.29.21");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gm.y f58993l = new gm.y("2.5.29.23");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final gm.y f58994m = new gm.y("2.5.29.24");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final gm.y f58995n = new gm.y("2.5.29.27");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final gm.y f58996o = new gm.y("2.5.29.28");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final gm.y f58997p = new gm.y("2.5.29.29");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final gm.y f58998q = new gm.y("2.5.29.30");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final gm.y f58999r = new gm.y("2.5.29.31");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final gm.y f59000s = new gm.y("2.5.29.32");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final gm.y f59001t = new gm.y("2.5.29.33");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final gm.y f59002u = new gm.y("2.5.29.35");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final gm.y f59003v = new gm.y("2.5.29.36");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final gm.y f59004w = new gm.y("2.5.29.37");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final gm.y f59005x = new gm.y("2.5.29.46");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final gm.y f59006y = new gm.y("2.5.29.54");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final gm.y f59007z = new gm.y("1.3.6.1.5.5.7.1.1");
    public static final gm.y A = new gm.y("1.3.6.1.5.5.7.1.11");
    public static final gm.y B = new gm.y("1.3.6.1.5.5.7.1.12");
    public static final gm.y C = new gm.y("1.3.6.1.5.5.7.1.2");
    public static final gm.y D = new gm.y("1.3.6.1.5.5.7.1.3");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final gm.y f58991k0 = new gm.y("1.3.6.1.5.5.7.1.4");
    public static final gm.y K0 = new gm.y("2.5.29.56");

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final gm.y f58992k1 = new gm.y("2.5.29.55");

    public u1(gm.f0 f0Var) {
        this.f59008a = new Hashtable();
        this.f59009b = new Vector();
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.f0 f0VarJ = gm.f0.J(enumerationL.nextElement());
            if (f0VarJ.size() == 3) {
                this.f59008a.put(f0VarJ.K(0), new t1(gm.f.J(f0VarJ.K(1)), gm.z.I(f0VarJ.K(2))));
            } else {
                if (f0VarJ.size() != 2) {
                    throw new IllegalArgumentException("Bad sequence size: " + f0VarJ.size());
                }
                this.f59008a.put(f0VarJ.K(0), new t1(false, gm.z.I(f0VarJ.K(1))));
            }
            this.f59009b.addElement(f0VarJ.K(0));
        }
    }

    public u1(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public u1(Vector vector, Hashtable hashtable) {
        this.f59008a = new Hashtable();
        this.f59009b = new Vector();
        Enumeration enumerationKeys = vector == null ? hashtable.keys() : vector.elements();
        while (enumerationKeys.hasMoreElements()) {
            this.f59009b.addElement(gm.y.N(enumerationKeys.nextElement()));
        }
        Enumeration enumerationElements = this.f59009b.elements();
        while (enumerationElements.hasMoreElements()) {
            gm.y yVarN = gm.y.N(enumerationElements.nextElement());
            this.f59008a.put(yVarN, (t1) hashtable.get(yVarN));
        }
    }

    public u1(Vector vector, Vector vector2) {
        this.f59008a = new Hashtable();
        this.f59009b = new Vector();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            this.f59009b.addElement(enumerationElements.nextElement());
        }
        int i10 = 0;
        Enumeration enumerationElements2 = this.f59009b.elements();
        while (enumerationElements2.hasMoreElements()) {
            this.f59008a.put((gm.y) enumerationElements2.nextElement(), (t1) vector2.elementAt(i10));
            i10++;
        }
    }

    public static u1 C(gm.n0 n0Var, boolean z10) {
        return D(gm.f0.I(n0Var, z10));
    }

    public static u1 D(Object obj) {
        if (obj == null || (obj instanceof u1)) {
            return (u1) obj;
        }
        if (obj instanceof gm.f0) {
            return new u1((gm.f0) obj);
        }
        if (obj instanceof z) {
            return new u1((gm.f0) ((z) obj).b());
        }
        if (obj instanceof gm.n0) {
            return D(((gm.n0) obj).U());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public gm.y[] A() {
        return G(this.f59009b);
    }

    public final gm.y[] B(boolean z10) {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != this.f59009b.size(); i10++) {
            Object objElementAt = this.f59009b.elementAt(i10);
            if (((t1) this.f59008a.get(objElementAt)).d() == z10) {
                vector.addElement(objElementAt);
            }
        }
        return G(vector);
    }

    public gm.y[] E() {
        return B(false);
    }

    public Enumeration F() {
        return this.f59009b.elements();
    }

    public final gm.y[] G(Vector vector) {
        int size = vector.size();
        gm.y[] yVarArr = new gm.y[size];
        for (int i10 = 0; i10 != size; i10++) {
            yVarArr[i10] = (gm.y) vector.elementAt(i10);
        }
        return yVarArr;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(this.f59009b.size());
        Enumeration enumerationElements = this.f59009b.elements();
        while (enumerationElements.hasMoreElements()) {
            gm.i iVar2 = new gm.i(3);
            gm.y yVar = (gm.y) enumerationElements.nextElement();
            t1 t1Var = (t1) this.f59008a.get(yVar);
            iVar2.a(yVar);
            if (t1Var.d()) {
                iVar2.a(gm.f.f29675f);
            }
            iVar2.a(t1Var.c());
            iVar.a(new j2(iVar2));
        }
        return new j2(iVar);
    }

    public boolean x(u1 u1Var) {
        if (this.f59008a.size() != u1Var.f59008a.size()) {
            return false;
        }
        Enumeration enumerationKeys = this.f59008a.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            if (!this.f59008a.get(objNextElement).equals(u1Var.f59008a.get(objNextElement))) {
                return false;
            }
        }
        return true;
    }

    public gm.y[] y() {
        return B(true);
    }

    public t1 z(gm.y yVar) {
        return (t1) this.f59008a.get(yVar);
    }
}
