package so;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class w0 implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f50337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f50338b;

    static {
        HashSet hashSet = new HashSet();
        f50337a = hashSet;
        HashMap map = new HashMap();
        f50338b = map;
        hashSet.add(pn.s.f46857y3);
        hashSet.add(pn.s.f46860z3);
        hashSet.add(pn.s.A3);
        hashSet.add(pn.s.B3);
        hashSet.add(on.b.f44359c);
        hashSet.add(on.b.f44357a);
        hashSet.add(on.b.f44358b);
        hashSet.add(on.b.f44367k);
        hashSet.add(tn.b.f51365g);
        hashSet.add(tn.b.f51364f);
        hashSet.add(tn.b.f51366h);
        gm.y yVar = qm.a.f47465o;
        gm.y yVar2 = qm.a.f47463m;
        gm.d2 d2Var = gm.d2.f29657b;
        map.put(yVar, new zn.b(yVar2, d2Var));
        map.put(qn.a.f47519i, new zn.b(qn.a.f47517g, d2Var));
        map.put(qn.a.f47520j, new zn.b(qn.a.f47518h, d2Var));
    }

    @Override // so.k0
    public zn.b a(zn.b bVar) {
        if (f50337a.contains(bVar.x())) {
            return new zn.b(pn.s.f46854x3, gm.d2.f29657b);
        }
        Map map = f50338b;
        return map.containsKey(bVar.x()) ? (zn.b) map.get(bVar.x()) : bVar;
    }
}
