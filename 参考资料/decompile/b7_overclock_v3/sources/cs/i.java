package cs;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f25884a;

    static {
        HashMap map = new HashMap();
        f25884a = map;
        map.put(jm.a.f36499i, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(jm.a.f36494d, "SHA1WITHPLAIN-ECDSA");
        map.put(jm.a.f36495e, "SHA224WITHPLAIN-ECDSA");
        map.put(jm.a.f36496f, "SHA256WITHPLAIN-ECDSA");
        map.put(jm.a.f36497g, "SHA384WITHPLAIN-ECDSA");
        map.put(jm.a.f36498h, "SHA512WITHPLAIN-ECDSA");
        map.put(qm.a.f47465o, "GOST3411WITHECGOST3410-2001");
        map.put(qm.a.f47464n, "GOST3411WITHGOST3410-94");
        map.put(qm.a.f47452b, "GOST3411");
        map.put(qn.a.f47519i, "GOST3411WITHECGOST3410-2012-256");
        map.put(qn.a.f47520j, "GOST3411WITHECGOST3410-2012-512");
        map.put(sm.g.f49918s, "SHA1WITHCVC-ECDSA");
        map.put(sm.g.f49919t, "SHA224WITHCVC-ECDSA");
        map.put(sm.g.f49920u, "SHA256WITHCVC-ECDSA");
        map.put(sm.g.f49921v, "SHA384WITHCVC-ECDSA");
        map.put(sm.g.f49922w, "SHA512WITHCVC-ECDSA");
        map.put(kn.d.f37598f, "SHA224");
        map.put(kn.d.f37592c, "SHA256");
        map.put(kn.d.f37594d, "SHA384");
        map.put(kn.d.f37596e, "SHA512");
        map.put(kn.d.f37604i, "SHA3-224");
        map.put(kn.d.f37606j, "SHA3-256");
        map.put(kn.d.f37608k, "SHA3-384");
        map.put(kn.d.f37610l, "SHA3-512");
        map.put(on.b.f44366j, "SHA1WITHDSA");
        map.put(on.b.f44368l, "ELGAMAL");
        map.put(on.b.f44365i, "SHA1");
        map.put(on.b.f44358b, "MD5WITHRSA");
        map.put(on.b.f44367k, "SHA1WITHRSA");
        map.put(pn.s.D3, "RSAOAEP");
        map.put(pn.s.G3, "RSAPSS");
        map.put(pn.s.f46857y3, "MD2WITHRSA");
        map.put(pn.s.f46803f4, "MD5");
        map.put(pn.s.A3, "MD5WITHRSA");
        map.put(pn.s.f46854x3, "RSA");
        map.put(pn.s.B3, "SHA1WITHRSA");
        map.put(pn.s.K3, "SHA224WITHRSA");
        map.put(pn.s.H3, "SHA256WITHRSA");
        map.put(pn.s.I3, "SHA384WITHRSA");
        map.put(pn.s.J3, "SHA512WITHRSA");
        map.put(kn.d.f37607j0, "SHA3-224WITHRSA");
        map.put(kn.d.f37609k0, "SHA3-256WITHRSA");
        map.put(kn.d.f37611l0, "SHA3-384WITHRSA");
        map.put(kn.d.f37613m0, "SHA3-512WITHRSA");
        map.put(tn.b.f51361c, "RIPEMD128");
        map.put(tn.b.f51360b, "RIPEMD160");
        map.put(tn.b.f51362d, "RIPEMD256");
        map.put(tn.b.f51365g, "RIPEMD128WITHRSA");
        map.put(tn.b.f51364f, "RIPEMD160WITHRSA");
        map.put(tn.b.f51366h, "RIPEMD256WITHRSA");
        map.put(co.r.f11170i0, "ECDSAWITHSHA1");
        map.put(co.r.f11178n0, "SHA224WITHECDSA");
        map.put(co.r.f11180o0, "SHA256WITHECDSA");
        map.put(co.r.f11182p0, "SHA384WITHECDSA");
        map.put(co.r.f11184q0, "SHA512WITHECDSA");
        map.put(kn.d.f37599f0, "SHA3-224WITHECDSA");
        map.put(kn.d.f37601g0, "SHA3-256WITHECDSA");
        map.put(kn.d.f37603h0, "SHA3-384WITHECDSA");
        map.put(kn.d.f37605i0, "SHA3-512WITHECDSA");
        map.put(co.r.X0, "SHA1WITHDSA");
        map.put(kn.d.X, "SHA224WITHDSA");
        map.put(kn.d.Y, "SHA256WITHDSA");
        map.put(kn.d.Z, "SHA384WITHDSA");
        map.put(kn.d.f37589a0, "SHA512WITHDSA");
        map.put(kn.d.f37591b0, "SHA3-224WITHDSA");
        map.put(kn.d.f37593c0, "SHA3-256WITHDSA");
        map.put(kn.d.f37595d0, "SHA3-384WITHDSA");
        map.put(kn.d.f37597e0, "SHA3-512WITHDSA");
        map.put(ym.a.f57371g, "Tiger");
        map.put(pn.s.f46788a4, "RC2/CBC");
        map.put(pn.s.Z3, "DESEDE-3KEY/CBC");
        map.put(kn.d.f37624x, "AES-128/ECB");
        map.put(kn.d.F, "AES-192/ECB");
        map.put(kn.d.N, "AES-256/ECB");
        map.put(kn.d.f37625y, "AES-128/CBC");
        map.put(kn.d.G, "AES-192/CBC");
        map.put(kn.d.O, "AES-256/CBC");
        map.put(kn.d.A, "AES-128/CFB");
        map.put(kn.d.I, "AES-192/CFB");
        map.put(kn.d.Q, "AES-256/CFB");
        map.put(kn.d.f37626z, "AES-128/OFB");
        map.put(kn.d.H, "AES-192/OFB");
        map.put(kn.d.P, "AES-256/OFB");
        map.put(mn.a.f41443a, "CAMELLIA-128/CBC");
        map.put(mn.a.f41444b, "CAMELLIA-192/CBC");
        map.put(mn.a.f41445c, "CAMELLIA-256/CBC");
        map.put(gn.a.f29838a, "SEED/CBC");
        map.put(in.c.f32567w, "IDEA/CBC");
        map.put(in.c.f32565u, "CAST5/CBC");
        map.put(in.c.f32570z, "Blowfish/ECB");
        map.put(in.c.A, "Blowfish/CBC");
        map.put(in.c.B, "Blowfish/CFB");
        map.put(in.c.C, "Blowfish/OFB");
        map.put(ym.a.f57374j, "Serpent-128/ECB");
        map.put(ym.a.f57375k, "Serpent-128/CBC");
        map.put(ym.a.f57377m, "Serpent-128/CFB");
        map.put(ym.a.f57376l, "Serpent-128/OFB");
        map.put(ym.a.f57378n, "Serpent-192/ECB");
        map.put(ym.a.f57379o, "Serpent-192/CBC");
        map.put(ym.a.f57381q, "Serpent-192/CFB");
        map.put(ym.a.f57380p, "Serpent-192/OFB");
        map.put(ym.a.f57382r, "Serpent-256/ECB");
        map.put(ym.a.f57383s, "Serpent-256/CBC");
        map.put(ym.a.f57385u, "Serpent-256/CFB");
        map.put(ym.a.f57384t, "Serpent-256/OFB");
    }

    @Override // cs.b
    public boolean a(gm.y yVar) {
        return f25884a.containsKey(yVar);
    }

    @Override // cs.b
    public String b(zn.b bVar) {
        return c(bVar.x());
    }

    @Override // cs.b
    public String c(gm.y yVar) {
        String str = (String) f25884a.get(yVar);
        return str != null ? str : yVar.L();
    }
}
