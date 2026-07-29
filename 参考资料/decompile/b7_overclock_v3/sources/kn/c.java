package kn;

import co.l;
import gm.y;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f37586a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Hashtable f37587b = new Hashtable();

    static {
        a("B-571", rn.d.F);
        a("B-409", rn.d.D);
        a("B-283", rn.d.f48952n);
        a("B-233", rn.d.f48958t);
        a("B-163", rn.d.f48950l);
        a("K-571", rn.d.E);
        a("K-409", rn.d.C);
        a("K-283", rn.d.f48951m);
        a("K-233", rn.d.f48957s);
        a("K-163", rn.d.f48940b);
        a("P-521", rn.d.B);
        a("P-384", rn.d.A);
        a("P-256", rn.d.H);
        a("P-224", rn.d.f48964z);
        a("P-192", rn.d.G);
    }

    public static void a(String str, y yVar) {
        f37586a.put(str, yVar);
        f37587b.put(yVar, str);
    }

    public static l b(String str) {
        y yVar = (y) f37586a.get(Strings.o(str));
        if (yVar != null) {
            return c(yVar);
        }
        return null;
    }

    public static l c(y yVar) {
        return rn.c.k(yVar);
    }

    public static String d(y yVar) {
        return (String) f37587b.get(yVar);
    }

    public static Enumeration e() {
        return f37586a.keys();
    }

    public static y f(String str) {
        return (y) f37586a.get(Strings.o(str));
    }
}
