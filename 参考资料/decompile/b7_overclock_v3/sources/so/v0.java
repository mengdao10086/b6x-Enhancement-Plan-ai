package so;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class v0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f50325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f50326b;

    public v0() {
        HashMap map = new HashMap();
        this.f50325a = map;
        HashMap map2 = new HashMap();
        this.f50326b = map2;
        b(kn.d.X, "SHA224", "DSA");
        b(kn.d.Y, "SHA256", "DSA");
        b(kn.d.Z, "SHA384", "DSA");
        b(kn.d.f37589a0, "SHA512", "DSA");
        b(kn.d.f37591b0, "SHA3-224", "DSA");
        b(kn.d.f37593c0, "SHA3-256", "DSA");
        b(kn.d.f37595d0, "SHA3-384", "DSA");
        b(kn.d.f37597e0, "SHA3-512", "DSA");
        gm.y yVar = kn.d.f37607j0;
        b(yVar, "SHA3-224", "RSA");
        gm.y yVar2 = kn.d.f37609k0;
        b(yVar2, "SHA3-256", "RSA");
        gm.y yVar3 = kn.d.f37611l0;
        b(yVar3, "SHA3-384", "RSA");
        gm.y yVar4 = kn.d.f37613m0;
        b(yVar4, "SHA3-512", "RSA");
        b(kn.d.f37599f0, "SHA3-224", "ECDSA");
        b(kn.d.f37601g0, "SHA3-256", "ECDSA");
        b(kn.d.f37603h0, "SHA3-384", "ECDSA");
        b(kn.d.f37605i0, "SHA3-512", "ECDSA");
        b(on.b.f44366j, "SHA1", "DSA");
        b(on.b.f44357a, "MD4", "RSA");
        b(on.b.f44359c, "MD4", "RSA");
        b(on.b.f44358b, "MD5", "RSA");
        b(on.b.f44367k, "SHA1", "RSA");
        b(pn.s.f46857y3, "MD2", "RSA");
        b(pn.s.f46860z3, "MD4", "RSA");
        b(pn.s.A3, "MD5", "RSA");
        b(pn.s.B3, "SHA1", "RSA");
        b(pn.s.K3, "SHA224", "RSA");
        b(pn.s.H3, "SHA256", "RSA");
        b(pn.s.I3, "SHA384", "RSA");
        b(pn.s.J3, "SHA512", "RSA");
        b(pn.s.L3, "SHA512(224)", "RSA");
        b(pn.s.M3, "SHA512(256)", "RSA");
        b(yVar, "SHA3-224", "RSA");
        b(yVar2, "SHA3-256", "RSA");
        b(yVar3, "SHA3-384", "RSA");
        b(yVar4, "SHA3-512", "RSA");
        b(mm.k.X2, "SHAKE128", "RSAPSS");
        b(mm.k.Y2, "SHAKE256", "RSAPSS");
        b(tn.b.f51365g, "RIPEMD128", "RSA");
        b(tn.b.f51364f, "RIPEMD160", "RSA");
        b(tn.b.f51366h, "RIPEMD256", "RSA");
        b(co.r.f11170i0, "SHA1", "ECDSA");
        b(co.r.f11178n0, "SHA224", "ECDSA");
        b(co.r.f11180o0, "SHA256", "ECDSA");
        b(co.r.f11182p0, "SHA384", "ECDSA");
        b(co.r.f11184q0, "SHA512", "ECDSA");
        b(mm.k.Z2, "SHAKE128", "ECDSA");
        b(mm.k.f41347a3, "SHAKE256", "ECDSA");
        b(co.r.X0, "SHA1", "DSA");
        b(sm.g.f49918s, "SHA1", "ECDSA");
        b(sm.g.f49919t, "SHA224", "ECDSA");
        b(sm.g.f49920u, "SHA256", "ECDSA");
        b(sm.g.f49921v, "SHA384", "ECDSA");
        b(sm.g.f49922w, "SHA512", "ECDSA");
        b(sm.g.f49911l, "SHA1", "RSA");
        b(sm.g.f49912m, "SHA256", "RSA");
        b(sm.g.f49913n, "SHA1", "RSAandMGF1");
        b(sm.g.f49914o, "SHA256", "RSAandMGF1");
        b(jm.a.f36494d, "SHA1", "PLAIN-ECDSA");
        b(jm.a.f36495e, "SHA224", "PLAIN-ECDSA");
        b(jm.a.f36496f, "SHA256", "PLAIN-ECDSA");
        b(jm.a.f36497g, "SHA384", "PLAIN-ECDSA");
        b(jm.a.f36498h, "SHA512", "PLAIN-ECDSA");
        b(jm.a.f36499i, "RIPEMD160", "PLAIN-ECDSA");
        b(jm.a.f36500j, "SHA3-224", "PLAIN-ECDSA");
        b(jm.a.f36501k, "SHA3-256", "PLAIN-ECDSA");
        b(jm.a.f36502l, "SHA3-384", "PLAIN-ECDSA");
        b(jm.a.f36503m, "SHA3-512", "PLAIN-ECDSA");
        b(xm.b.f55624f0, "SHA256", "SM2");
        b(xm.b.f55620d0, "SM3", "SM2");
        b(im.a.f32499u, "SHA512", "SPHINCS256");
        b(im.a.f32500v, "SHA3-512", "SPHINCS256");
        map.put(co.r.W0, "DSA");
        map.put(pn.s.f46854x3, "RSA");
        map.put(tn.b.f51363e, "RSA");
        map.put(zn.z1.f59124r7, "RSA");
        map.put(pn.s.G3, "RSAandMGF1");
        map.put(qm.a.f47462l, "GOST3410");
        map.put(qm.a.f47463m, "ECGOST3410");
        map.put(new gm.y("1.3.6.1.4.1.5849.1.6.2"), "ECGOST3410");
        map.put(new gm.y("1.3.6.1.4.1.5849.1.1.5"), "GOST3410");
        map.put(qn.a.f47517g, "ECGOST3410-2012-256");
        map.put(qn.a.f47518h, "ECGOST3410-2012-512");
        map.put(qm.a.f47465o, "ECGOST3410");
        map.put(qm.a.f47464n, "GOST3410");
        map.put(qn.a.f47519i, "ECGOST3410-2012-256");
        map.put(qn.a.f47520j, "ECGOST3410-2012-512");
        map2.put(pn.s.f46797d4, "MD2");
        map2.put(pn.s.f46800e4, "MD4");
        map2.put(pn.s.f46803f4, "MD5");
        map2.put(on.b.f44365i, "SHA1");
        map2.put(kn.d.f37598f, "SHA224");
        map2.put(kn.d.f37592c, "SHA256");
        map2.put(kn.d.f37594d, "SHA384");
        map2.put(kn.d.f37596e, "SHA512");
        map2.put(kn.d.f37600g, "SHA512(224)");
        map2.put(kn.d.f37602h, "SHA512(256)");
        map2.put(kn.d.f37612m, "SHAKE128");
        map2.put(kn.d.f37614n, "SHAKE256");
        map2.put(kn.d.f37604i, "SHA3-224");
        map2.put(kn.d.f37606j, "SHA3-256");
        map2.put(kn.d.f37608k, "SHA3-384");
        map2.put(kn.d.f37610l, "SHA3-512");
        map2.put(tn.b.f51361c, "RIPEMD128");
        map2.put(tn.b.f51360b, "RIPEMD160");
        map2.put(tn.b.f51362d, "RIPEMD256");
        map2.put(qm.a.f47452b, "GOST3411");
        map2.put(new gm.y("1.3.6.1.4.1.5849.1.2.1"), "GOST3411");
        map2.put(qn.a.f47513c, "GOST3411-2012-256");
        map2.put(qn.a.f47514d, "GOST3411-2012-512");
        map2.put(xm.b.f55616b0, "SM3");
    }

    @Override // so.j0
    public String a(zn.b bVar, zn.b bVar2) {
        gm.y yVarX = bVar2.x();
        if (tm.a.f51340d.C(yVarX)) {
            return cr.h.f25815b;
        }
        if (tm.a.f51341e.C(yVarX)) {
            return cr.h.f25816c;
        }
        if (pn.s.f46801e5.C(yVarX)) {
            return "LMS";
        }
        String strC = c(yVarX);
        if (strC.equals(yVarX.L())) {
            return c(bVar.x()) + "with" + d(yVarX);
        }
        return strC + "with" + d(yVarX);
    }

    public final void b(gm.y yVar, String str, String str2) {
        this.f50326b.put(yVar, str);
        this.f50325a.put(yVar, str2);
    }

    public final String c(gm.y yVar) {
        String str = (String) this.f50326b.get(yVar);
        return str != null ? str : yVar.L();
    }

    public final String d(gm.y yVar) {
        String str = (String) this.f50325a.get(yVar);
        return str != null ? str : yVar.L();
    }

    public void e(gm.y yVar, String str) {
        this.f50326b.put(yVar, str);
    }

    public void f(gm.y yVar, String str) {
        this.f50325a.put(yVar, str);
    }
}
