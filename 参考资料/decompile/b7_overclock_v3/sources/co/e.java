package co;

import gm.y;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static void a(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static l b(String str) {
        l lVarH = i.h(str);
        if (lVarH == null) {
            lVarH = rn.c.j(str);
        }
        if (lVarH == null) {
            lVarH = kn.c.b(str);
        }
        if (lVarH == null) {
            lVarH = tn.a.h(str);
        }
        if (lVarH == null) {
            lVarH = hm.a.h(str);
        }
        if (lVarH == null) {
            lVarH = qm.b.e(str);
        }
        return lVarH == null ? xm.a.h(str) : lVarH;
    }

    public static l c(y yVar) {
        l lVarI = i.i(yVar);
        if (lVarI == null) {
            lVarI = rn.c.k(yVar);
        }
        if (lVarI == null) {
            lVarI = tn.a.i(yVar);
        }
        if (lVarI == null) {
            lVarI = hm.a.i(yVar);
        }
        if (lVarI == null) {
            lVarI = qm.b.g(yVar);
        }
        return lVarI == null ? xm.a.i(yVar) : lVarI;
    }

    public static String d(y yVar) {
        String strJ = i.j(yVar);
        if (strJ == null) {
            strJ = rn.c.l(yVar);
        }
        if (strJ == null) {
            strJ = kn.c.d(yVar);
        }
        if (strJ == null) {
            strJ = tn.a.j(yVar);
        }
        if (strJ == null) {
            strJ = hm.a.j(yVar);
        }
        if (strJ == null) {
            strJ = qm.b.h(yVar);
        }
        if (strJ == null) {
            strJ = xm.a.j(yVar);
        }
        return strJ == null ? ap.a.l(yVar) : strJ;
    }

    public static Enumeration e() {
        Vector vector = new Vector();
        a(vector, i.k());
        a(vector, rn.c.m());
        a(vector, kn.c.e());
        a(vector, tn.a.k());
        a(vector, hm.a.k());
        a(vector, qm.b.i());
        a(vector, xm.a.k());
        return vector.elements();
    }

    public static y f(String str) {
        y yVarL = i.l(str);
        if (yVarL == null) {
            yVarL = rn.c.n(str);
        }
        if (yVarL == null) {
            yVarL = kn.c.f(str);
        }
        if (yVarL == null) {
            yVarL = tn.a.l(str);
        }
        if (yVarL == null) {
            yVarL = hm.a.l(str);
        }
        if (yVarL == null) {
            yVarL = qm.b.j(str);
        }
        if (yVarL == null) {
            yVarL = xm.a.l(str);
        }
        return (yVarL == null && str.equals("curve25519")) ? pm.a.f46720c : yVarL;
    }
}
