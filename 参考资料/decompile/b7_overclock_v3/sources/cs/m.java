package cs;

import gm.d2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f25904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f25905b;

    static {
        HashMap map = new HashMap();
        f25904a = map;
        HashMap map2 = new HashMap();
        f25905b = map2;
        map.put(pn.s.G3, "RSASSA-PSS");
        map.put(tm.a.f51340d, "ED25519");
        map.put(tm.a.f51341e, "ED448");
        map.put(new gm.y("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        map.put(pn.s.K3, "SHA224WITHRSA");
        map.put(pn.s.H3, "SHA256WITHRSA");
        map.put(pn.s.I3, "SHA384WITHRSA");
        map.put(pn.s.J3, "SHA512WITHRSA");
        map.put(mm.k.X2, "SHAKE128WITHRSAPSS");
        map.put(mm.k.Y2, "SHAKE256WITHRSAPSS");
        map.put(qm.a.f47464n, "GOST3411WITHGOST3410");
        map.put(qm.a.f47465o, "GOST3411WITHECGOST3410");
        map.put(qn.a.f47519i, "GOST3411-2012-256WITHECGOST3410-2012-256");
        map.put(qn.a.f47520j, "GOST3411-2012-512WITHECGOST3410-2012-512");
        map.put(jm.a.f36494d, "SHA1WITHPLAIN-ECDSA");
        map.put(jm.a.f36495e, "SHA224WITHPLAIN-ECDSA");
        map.put(jm.a.f36496f, "SHA256WITHPLAIN-ECDSA");
        map.put(jm.a.f36497g, "SHA384WITHPLAIN-ECDSA");
        map.put(jm.a.f36498h, "SHA512WITHPLAIN-ECDSA");
        map.put(jm.a.f36500j, "SHA3-224WITHPLAIN-ECDSA");
        map.put(jm.a.f36501k, "SHA3-256WITHPLAIN-ECDSA");
        map.put(jm.a.f36502l, "SHA3-384WITHPLAIN-ECDSA");
        map.put(jm.a.f36503m, "SHA3-512WITHPLAIN-ECDSA");
        map.put(jm.a.f36499i, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(sm.g.f49918s, "SHA1WITHCVC-ECDSA");
        map.put(sm.g.f49919t, "SHA224WITHCVC-ECDSA");
        map.put(sm.g.f49920u, "SHA256WITHCVC-ECDSA");
        map.put(sm.g.f49921v, "SHA384WITHCVC-ECDSA");
        map.put(sm.g.f49922w, "SHA512WITHCVC-ECDSA");
        map.put(bn.a.f9499a, "XMSS");
        map.put(bn.a.f9500b, "XMSSMT");
        map.put(tn.b.f51365g, "RIPEMD128WITHRSA");
        map.put(tn.b.f51364f, "RIPEMD160WITHRSA");
        map.put(tn.b.f51366h, "RIPEMD256WITHRSA");
        map.put(new gm.y("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        map.put(new gm.y("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        map.put(new gm.y("1.2.840.10040.4.3"), "SHA1WITHDSA");
        map.put(co.r.f11170i0, "SHA1WITHECDSA");
        map.put(co.r.f11178n0, "SHA224WITHECDSA");
        map.put(co.r.f11180o0, "SHA256WITHECDSA");
        map.put(co.r.f11182p0, "SHA384WITHECDSA");
        map.put(co.r.f11184q0, "SHA512WITHECDSA");
        map.put(mm.k.Z2, "SHAKE128WITHECDSA");
        map.put(mm.k.f41347a3, "SHAKE256WITHECDSA");
        map.put(on.b.f44367k, "SHA1WITHRSA");
        map.put(on.b.f44366j, "SHA1WITHDSA");
        map.put(kn.d.X, "SHA224WITHDSA");
        map.put(kn.d.Y, "SHA256WITHDSA");
        map2.put(on.b.f44365i, "SHA1");
        map2.put(kn.d.f37598f, "SHA224");
        map2.put(kn.d.f37592c, "SHA256");
        map2.put(kn.d.f37594d, "SHA384");
        map2.put(kn.d.f37596e, "SHA512");
        map2.put(kn.d.f37604i, "SHA3-224");
        map2.put(kn.d.f37606j, "SHA3-256");
        map2.put(kn.d.f37608k, "SHA3-384");
        map2.put(kn.d.f37610l, "SHA3-512");
        map2.put(tn.b.f51361c, "RIPEMD128");
        map2.put(tn.b.f51360b, "RIPEMD160");
        map2.put(tn.b.f51362d, "RIPEMD256");
    }

    public static String d(gm.y yVar) {
        String str = (String) f25905b.get(yVar);
        return str != null ? str : yVar.L();
    }

    @Override // cs.b
    public boolean a(gm.y yVar) {
        return f25904a.containsKey(yVar);
    }

    @Override // cs.b
    public String b(zn.b bVar) {
        gm.h hVarA = bVar.A();
        if (hVarA == null || d2.f29657b.B(hVarA) || !bVar.x().C(pn.s.G3)) {
            Map map = f25904a;
            boolean zContainsKey = map.containsKey(bVar.x());
            gm.y yVarX = bVar.x();
            return zContainsKey ? (String) map.get(yVarX) : yVarX.L();
        }
        pn.a0 a0VarY = pn.a0.y(hVarA);
        zn.b bVarZ = a0VarY.z();
        if (!bVarZ.x().C(pn.s.E3)) {
            return d(a0VarY.x().x()) + "WITHRSAAND" + bVarZ.x().L();
        }
        zn.b bVarX = a0VarY.x();
        gm.y yVarX2 = zn.b.z(bVarZ.A()).x();
        if (yVarX2.C(bVarX.x())) {
            return d(bVarX.x()) + "WITHRSAANDMGF1";
        }
        return d(bVarX.x()) + "WITHRSAANDMGF1USING" + d(yVarX2);
    }

    @Override // cs.b
    public String c(gm.y yVar) {
        String str = (String) f25904a.get(yVar);
        return str != null ? str : yVar.L();
    }
}
