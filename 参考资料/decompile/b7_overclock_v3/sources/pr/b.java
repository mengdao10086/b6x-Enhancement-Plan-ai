package pr;

import co.e;
import co.l;
import ir.f;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static ArrayList a(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static void b(l lVar) {
        f fVarN = lVar.y().n(BigInteger.valueOf(2L));
        f fVarO = fVarN.o();
        System.out.println(fVarO.v().toString(16).toUpperCase());
        if (!fVarO.p().equals(fVarN)) {
            throw new IllegalStateException("Optimized-sqrt sanity check failed");
        }
    }

    public static void c(String[] strArr) {
        TreeSet<String> treeSet = new TreeSet(a(e.e()));
        treeSet.addAll(a(ap.a.m()));
        for (String str : treeSet) {
            l lVarJ = ap.a.j(str);
            if (lVarJ == null) {
                lVarJ = e.b(str);
            }
            if (lVarJ != null && ir.c.m(lVarJ.y())) {
                System.out.print(str + ":");
                b(lVarJ);
            }
        }
    }

    public static void d(l lVar) {
        if (!ir.c.m(lVar.y())) {
            throw new IllegalArgumentException("Sqrt optimization only defined over characteristic-2 fields");
        }
        b(lVar);
    }
}
