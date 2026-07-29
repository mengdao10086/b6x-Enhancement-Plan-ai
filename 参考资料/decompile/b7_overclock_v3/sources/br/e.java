package br;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.util.j;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f9583a;

    static {
        HashMap map = new HashMap();
        f9583a = map;
        map.put(s.Z3.L(), j.g(192));
        f9583a.put(kn.d.f37625y, j.g(128));
        f9583a.put(kn.d.G, j.g(192));
        f9583a.put(kn.d.O, j.g(256));
        f9583a.put(mn.a.f41443a, j.g(128));
        f9583a.put(mn.a.f41444b, j.g(192));
        f9583a.put(mn.a.f41445c, j.g(256));
    }

    public static int a(y yVar) {
        Integer num = (Integer) f9583a.get(yVar);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
