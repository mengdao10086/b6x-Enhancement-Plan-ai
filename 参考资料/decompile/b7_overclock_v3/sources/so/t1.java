package so;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class t1 extends x1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map f50320i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Map f50321j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mm.l0 f50322h;

    static {
        HashMap map = new HashMap();
        f50321j = map;
        gm.y yVar = c.f50085b;
        map.put(yVar, org.bouncycastle.util.j.g(8));
        Map map2 = f50321j;
        gm.y yVar2 = c.f50093f;
        map2.put(yVar2, org.bouncycastle.util.j.g(16));
        Map map3 = f50321j;
        gm.y yVar3 = c.f50095g;
        map3.put(yVar3, org.bouncycastle.util.j.g(16));
        Map map4 = f50321j;
        gm.y yVar4 = c.f50097h;
        map4.put(yVar4, org.bouncycastle.util.j.g(16));
        f50320i.put(yVar, org.bouncycastle.util.j.g(192));
        f50320i.put(yVar2, org.bouncycastle.util.j.g(128));
        f50320i.put(yVar3, org.bouncycastle.util.j.g(192));
        f50320i.put(yVar4, org.bouncycastle.util.j.g(256));
    }

    public t1(mm.l0 l0Var, zn.b bVar, i0 i0Var, a aVar) {
        super(l0Var.B(), bVar, i0Var, aVar);
        this.f50322h = l0Var;
        this.f50340a = new r1();
    }

    @Override // so.x1
    public z1 k(u1 u1Var) throws CMSException, IOException {
        q1 q1Var = (q1) u1Var;
        zn.b bVarZ = zn.b.z(zn.b.z(this.f50322h.B()).A());
        return q1Var.e(bVarZ, this.f50342c, q1Var.b(q1Var.d(), n(), ((Integer) f50320i.get(bVarZ.x())).intValue()), this.f50322h.x().J());
    }

    public String l() {
        if (this.f50322h.A() != null) {
            return this.f50322h.A().x().L();
        }
        return null;
    }

    public byte[] m() {
        gm.h hVarA;
        try {
            if (this.f50322h.A() == null || (hVarA = this.f50322h.A().A()) == null) {
                return null;
            }
            return hVarA.b().getEncoded();
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public zn.b n() {
        return this.f50322h.A();
    }
}
