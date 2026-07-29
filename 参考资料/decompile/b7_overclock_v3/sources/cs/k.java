package cs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class k implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f25889a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f25890b;

    static {
        HashMap map = new HashMap();
        map.put(new gm.y(so.a0.f50038g), org.bouncycastle.util.j.g(128));
        map.put(pn.s.Z3, org.bouncycastle.util.j.g(192));
        map.put(pn.s.f46835p6, org.bouncycastle.util.j.g(192));
        map.put(pn.s.U3, org.bouncycastle.util.j.g(64));
        map.put(pn.s.S3, org.bouncycastle.util.j.g(64));
        map.put(kn.d.f37625y, org.bouncycastle.util.j.g(128));
        map.put(kn.d.G, org.bouncycastle.util.j.g(192));
        map.put(kn.d.O, org.bouncycastle.util.j.g(256));
        map.put(kn.d.C, org.bouncycastle.util.j.g(128));
        map.put(kn.d.K, org.bouncycastle.util.j.g(192));
        map.put(kn.d.S, org.bouncycastle.util.j.g(256));
        map.put(kn.d.D, org.bouncycastle.util.j.g(128));
        map.put(kn.d.L, org.bouncycastle.util.j.g(192));
        map.put(kn.d.T, org.bouncycastle.util.j.g(256));
        map.put(kn.d.B, org.bouncycastle.util.j.g(128));
        map.put(kn.d.J, org.bouncycastle.util.j.g(192));
        map.put(kn.d.R, org.bouncycastle.util.j.g(256));
        map.put(kn.d.E, org.bouncycastle.util.j.g(128));
        map.put(kn.d.M, org.bouncycastle.util.j.g(192));
        map.put(kn.d.U, org.bouncycastle.util.j.g(256));
        map.put(mn.a.f41443a, org.bouncycastle.util.j.g(128));
        map.put(mn.a.f41444b, org.bouncycastle.util.j.g(192));
        map.put(mn.a.f41445c, org.bouncycastle.util.j.g(256));
        map.put(mn.a.f41446d, org.bouncycastle.util.j.g(128));
        map.put(mn.a.f41447e, org.bouncycastle.util.j.g(192));
        map.put(mn.a.f41448f, org.bouncycastle.util.j.g(256));
        map.put(gn.a.f29838a, org.bouncycastle.util.j.g(128));
        map.put(on.b.f44361e, org.bouncycastle.util.j.g(64));
        map.put(qm.a.f47456f, org.bouncycastle.util.j.g(256));
        f25890b = Collections.unmodifiableMap(map);
    }

    @Override // cs.f0
    public int a(zn.b bVar) {
        int iB = b(bVar.x());
        if (iB > 0) {
            return iB;
        }
        return -1;
    }

    @Override // cs.f0
    public int b(gm.y yVar) {
        Integer num = (Integer) f25890b.get(yVar);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
