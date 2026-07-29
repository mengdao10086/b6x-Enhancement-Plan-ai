package es;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f27130a;

    static {
        HashMap map = new HashMap();
        f27130a = map;
        map.put(s.f46806g4, org.bouncycastle.util.j.g(20));
        map.put(s.f46812i4, org.bouncycastle.util.j.g(32));
        map.put(s.f46818k4, org.bouncycastle.util.j.g(64));
        map.put(s.f46809h4, org.bouncycastle.util.j.g(28));
        map.put(s.f46815j4, org.bouncycastle.util.j.g(48));
        map.put(kn.d.f37615o, org.bouncycastle.util.j.g(28));
        map.put(kn.d.f37616p, org.bouncycastle.util.j.g(32));
        map.put(kn.d.f37617q, org.bouncycastle.util.j.g(48));
        map.put(kn.d.f37618r, org.bouncycastle.util.j.g(64));
        map.put(qm.a.f47453c, org.bouncycastle.util.j.g(32));
    }

    public static int a(y yVar) {
        Map map = f27130a;
        if (map.containsKey(yVar)) {
            return ((Integer) map.get(yVar)).intValue();
        }
        throw new IllegalStateException("no salt size for algorithm: " + yVar);
    }
}
