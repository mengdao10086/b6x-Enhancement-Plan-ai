package gs;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f30017a;

    static {
        HashMap map = new HashMap();
        f30017a = map;
        map.put(s.f46806g4, "PBKDF2withHMACSHA1");
        map.put(s.f46812i4, "PBKDF2withHMACSHA256");
        map.put(s.f46818k4, "PBKDF2withHMACSHA512");
        map.put(s.f46809h4, "PBKDF2withHMACSHA224");
        map.put(s.f46815j4, "PBKDF2withHMACSHA384");
        map.put(kn.d.f37615o, "PBKDF2withHMACSHA3-224");
        map.put(kn.d.f37616p, "PBKDF2withHMACSHA3-256");
        map.put(kn.d.f37617q, "PBKDF2withHMACSHA3-384");
        map.put(kn.d.f37618r, "PBKDF2withHMACSHA3-512");
        map.put(qm.a.f47453c, "PBKDF2withHMACGOST3411");
    }

    public static String a(y yVar) {
        Map map = f30017a;
        if (map.containsKey(yVar)) {
            return (String) map.get(yVar);
        }
        throw new IllegalStateException("no prf for algorithm: " + yVar);
    }
}
