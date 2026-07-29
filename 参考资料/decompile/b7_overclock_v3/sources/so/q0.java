package so;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f50286a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f50287b = new HashMap();

    static {
        a(kn.d.X, "DSA");
        a(kn.d.Y, "DSA");
        a(kn.d.Z, "DSA");
        a(kn.d.f37589a0, "DSA");
        a(kn.d.f37591b0, "DSA");
        a(kn.d.f37593c0, "DSA");
        a(kn.d.f37595d0, "DSA");
        a(kn.d.f37597e0, "DSA");
        a(on.b.f44366j, "DSA");
        a(on.b.f44357a, "RSA");
        a(on.b.f44359c, "RSA");
        a(on.b.f44358b, "RSA");
        a(on.b.f44367k, "RSA");
        a(pn.s.f46857y3, "RSA");
        a(pn.s.f46860z3, "RSA");
        a(pn.s.A3, "RSA");
        a(pn.s.B3, "RSA");
        a(pn.s.K3, "RSA");
        a(pn.s.H3, "RSA");
        a(pn.s.I3, "RSA");
        a(pn.s.J3, "RSA");
        a(kn.d.f37607j0, "RSA");
        a(kn.d.f37609k0, "RSA");
        a(kn.d.f37611l0, "RSA");
        a(kn.d.f37613m0, "RSA");
        a(co.r.f11170i0, "ECDSA");
        a(co.r.f11178n0, "ECDSA");
        a(co.r.f11180o0, "ECDSA");
        a(co.r.f11182p0, "ECDSA");
        a(co.r.f11184q0, "ECDSA");
        a(kn.d.f37599f0, "ECDSA");
        a(kn.d.f37601g0, "ECDSA");
        a(kn.d.f37603h0, "ECDSA");
        a(kn.d.f37605i0, "ECDSA");
        a(co.r.X0, "DSA");
        a(sm.g.f49918s, "ECDSA");
        a(sm.g.f49919t, "ECDSA");
        a(sm.g.f49920u, "ECDSA");
        a(sm.g.f49921v, "ECDSA");
        a(sm.g.f49922w, "ECDSA");
        a(sm.g.f49911l, "RSA");
        a(sm.g.f49912m, "RSA");
        a(sm.g.f49913n, "RSAandMGF1");
        a(sm.g.f49914o, "RSAandMGF1");
        a(co.r.W0, "DSA");
        a(pn.s.f46854x3, "RSA");
        a(tn.b.f51363e, "RSA");
        a(zn.z1.f59124r7, "RSA");
        a(pn.s.G3, "RSAandMGF1");
        a(qm.a.f47462l, "GOST3410");
        a(qm.a.f47463m, "ECGOST3410");
        a(new gm.y("1.3.6.1.4.1.5849.1.6.2"), "ECGOST3410");
        a(new gm.y("1.3.6.1.4.1.5849.1.1.5"), "GOST3410");
        a(qn.a.f47517g, "ECGOST3410-2012-256");
        a(qn.a.f47518h, "ECGOST3410-2012-512");
        a(qm.a.f47465o, "ECGOST3410");
        a(qm.a.f47464n, "GOST3410");
        a(qn.a.f47519i, "ECGOST3410-2012-256");
        a(qn.a.f47520j, "ECGOST3410-2012-512");
    }

    public static void a(gm.y yVar, String str) {
        f50287b.put(yVar.L(), str);
    }

    public zn.b b(zn.b bVar, cs.n nVar) {
        gm.h hVarA = bVar.A();
        return (hVarA == null || gm.d2.f29657b.B(hVarA)) ? nVar.b(bVar.x()) : bVar;
    }

    public org.bouncycastle.util.s c(gm.h0 h0Var) {
        if (h0Var == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0Var.size());
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.n0) {
                arrayList.add(new X509AttributeCertificateHolder(zn.f.y(((gm.n0) c0VarB).U())));
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public org.bouncycastle.util.s d(gm.h0 h0Var) {
        if (h0Var == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0Var.size());
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.f0) {
                arrayList.add(new X509CRLHolder(zn.p.y(c0VarB)));
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public org.bouncycastle.util.s e(gm.h0 h0Var) {
        if (h0Var == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0Var.size());
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.f0) {
                arrayList.add(new X509CertificateHolder(zn.o.z(c0VarB)));
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public String f(String str) {
        String str2 = (String) f50287b.get(str);
        return str2 != null ? str2 : str;
    }

    public org.bouncycastle.util.s g(gm.y yVar, gm.h0 h0Var) {
        if (h0Var == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0Var.size());
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.n0) {
                gm.n0 n0VarT = gm.n0.T(c0VarB);
                if (n0VarT.q() == 1) {
                    mm.k0 k0VarZ = mm.k0.z(n0VarT, false);
                    if (yVar.C(k0VarZ.y())) {
                        arrayList.add(k0VarZ.x());
                    }
                }
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public void h(gm.y yVar, String str) {
        a(yVar, str);
    }
}
