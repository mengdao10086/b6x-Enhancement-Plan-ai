package org.bouncycastle.jcajce.util;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<y, String> f45253a;

    static {
        HashMap map = new HashMap();
        f45253a = map;
        map.put(s.f46797d4, "MD2");
        f45253a.put(s.f46800e4, "MD4");
        f45253a.put(s.f46803f4, "MD5");
        f45253a.put(on.b.f44365i, et.e.f27137f);
        f45253a.put(kn.d.f37598f, et.e.f27138g);
        f45253a.put(kn.d.f37592c, "SHA-256");
        f45253a.put(kn.d.f37594d, et.e.f27140i);
        f45253a.put(kn.d.f37596e, "SHA-512");
        f45253a.put(kn.d.f37600g, "SHA-512(224)");
        f45253a.put(kn.d.f37602h, "SHA-512(256)");
        f45253a.put(tn.b.f51361c, "RIPEMD-128");
        f45253a.put(tn.b.f51360b, "RIPEMD-160");
        f45253a.put(tn.b.f51362d, "RIPEMD-128");
        f45253a.put(fn.a.f28524d, "RIPEMD-128");
        f45253a.put(fn.a.f28523c, "RIPEMD-160");
        f45253a.put(qm.a.f47452b, "GOST3411");
        f45253a.put(ym.a.f57371g, "Tiger");
        f45253a.put(fn.a.f28525e, "Whirlpool");
        f45253a.put(kn.d.f37604i, "SHA3-224");
        f45253a.put(kn.d.f37606j, "SHA3-256");
        f45253a.put(kn.d.f37608k, "SHA3-384");
        f45253a.put(kn.d.f37610l, "SHA3-512");
        f45253a.put(kn.d.f37612m, "SHAKE128");
        f45253a.put(kn.d.f37614n, "SHAKE256");
        f45253a.put(xm.b.f55616b0, "SM3");
    }

    public static String a(y yVar) {
        String str = f45253a.get(yVar);
        return str != null ? str : yVar.L();
    }
}
