package org.bouncycastle.crypto.util;

import gm.y;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import np.g0;
import np.k0;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class SSHNamedCurves {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, y> f44721b = Collections.unmodifiableMap(new HashMap<String, y>() { // from class: org.bouncycastle.crypto.util.SSHNamedCurves.1
        {
            put("nistp256", rn.d.H);
            put("nistp384", rn.d.A);
            put("nistp521", rn.d.B);
            put("nistk163", rn.d.f48940b);
            put("nistp192", rn.d.G);
            put("nistp224", rn.d.f48964z);
            put("nistk233", rn.d.f48957s);
            put("nistb233", rn.d.f48958t);
            put("nistk283", rn.d.f48951m);
            put("nistk409", rn.d.C);
            put("nistb409", rn.d.D);
            put("nistt571", rn.d.E);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f44722c = Collections.unmodifiableMap(new HashMap<String, String>() { // from class: org.bouncycastle.crypto.util.SSHNamedCurves.2
        {
            String[][] strArr = {new String[]{"secp256r1", "nistp256"}, new String[]{"secp384r1", "nistp384"}, new String[]{"secp521r1", "nistp521"}, new String[]{"sect163k1", "nistk163"}, new String[]{"secp192r1", "nistp192"}, new String[]{"secp224r1", "nistp224"}, new String[]{"sect233k1", "nistk233"}, new String[]{"sect233r1", "nistb233"}, new String[]{"sect283k1", "nistk283"}, new String[]{"sect409k1", "nistk409"}, new String[]{"sect409r1", "nistb409"}, new String[]{"sect571k1", "nistt571"}};
            for (int i10 = 0; i10 != 12; i10++) {
                String[] strArr2 = strArr[i10];
                put(strArr2[0], strArr2[1]);
            }
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<ir.e, String> f44723d = new HashMap<ir.e, String>() { // from class: org.bouncycastle.crypto.util.SSHNamedCurves.3
        {
            Enumeration enumerationM = ap.a.m();
            while (enumerationM.hasMoreElements()) {
                String str = (String) enumerationM.nextElement();
                put(ap.a.j(str).y(), str);
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<y, String> f44720a = Collections.unmodifiableMap(new HashMap<y, String>() { // from class: org.bouncycastle.crypto.util.SSHNamedCurves.4
        {
            for (String str : SSHNamedCurves.f44721b.keySet()) {
                put(SSHNamedCurves.f44721b.get(str), str);
            }
        }
    });

    public static y b(String str) {
        return f44721b.get(str);
    }

    public static String c(y yVar) {
        return f44720a.get(yVar);
    }

    public static String d(ir.e eVar) {
        return f44722c.get(f44723d.get(eVar));
    }

    public static String e(g0 g0Var) {
        return g0Var instanceof k0 ? c(((k0) g0Var).j()) : d(g0Var.a());
    }

    public static co.l f(y yVar) {
        return kn.c.c(yVar);
    }

    public static co.l g(String str) {
        return kn.c.c(f44721b.get(Strings.k(str)));
    }
}
