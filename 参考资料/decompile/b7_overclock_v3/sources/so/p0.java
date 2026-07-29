package so;

import gm.n2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class p0 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final Set E;
    public static final Map F;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f50259g = mm.k.I2.L();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f50260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f50261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f50262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f50263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f50264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f50265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f50266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f50267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f50268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f50269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f50270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f50271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f50272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f50273u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f50274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f50275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f50276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f50277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f50278z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f50279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f50280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f50281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f50282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f50283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cs.n f50284f;

    static {
        String strL = on.b.f44365i.L();
        f50260h = strL;
        String strL2 = kn.d.f37598f.L();
        f50261i = strL2;
        String strL3 = kn.d.f37592c.L();
        f50262j = strL3;
        String strL4 = kn.d.f37594d.L();
        f50263k = strL4;
        String strL5 = kn.d.f37596e.L();
        f50264l = strL5;
        f50265m = pn.s.f46803f4.L();
        f50266n = qm.a.f47452b.L();
        f50267o = tn.b.f51361c.L();
        f50268p = tn.b.f51360b.L();
        f50269q = tn.b.f51362d.L();
        f50270r = pn.s.f46854x3.L();
        String strL6 = co.r.X0.L();
        f50271s = strL6;
        gm.y yVar = co.r.f11170i0;
        String strL7 = yVar.L();
        f50272t = strL7;
        f50273u = pn.s.G3.L();
        f50274v = qm.a.f47462l.L();
        f50275w = qm.a.f47463m.L();
        f50276x = qn.a.f47517g.L();
        f50277y = qn.a.f47518h.L();
        String strL8 = yVar.L();
        f50278z = strL8;
        String strL9 = co.r.f11178n0.L();
        A = strL9;
        String strL10 = co.r.f11180o0.L();
        B = strL10;
        String strL11 = co.r.f11182p0.L();
        C = strL11;
        String strL12 = co.r.f11184q0.L();
        D = strL12;
        HashSet hashSet = new HashSet();
        E = hashSet;
        HashMap map = new HashMap();
        F = map;
        hashSet.add(strL6);
        hashSet.add(strL7);
        hashSet.add(strL8);
        hashSet.add(strL9);
        hashSet.add(strL10);
        hashSet.add(strL11);
        hashSet.add(strL12);
        map.put(strL, strL8);
        map.put(strL2, strL9);
        map.put(strL3, strL10);
        map.put(strL4, strL11);
        map.put(strL5, strL12);
    }

    public p0() {
        this(new cs.j());
    }

    public p0(cs.n nVar) {
        this.f50279a = new ArrayList();
        this.f50280b = new ArrayList();
        this.f50281c = new ArrayList();
        this.f50282d = new ArrayList();
        this.f50283e = new HashMap();
        this.f50284f = nVar;
    }

    public void a(X509AttributeCertificateHolder x509AttributeCertificateHolder) throws CMSException {
        this.f50279a.add(new n2(false, 2, (gm.h) x509AttributeCertificateHolder.z()));
    }

    public void b(org.bouncycastle.util.s sVar) throws CMSException {
        this.f50279a.addAll(t0.h(sVar));
    }

    public void c(X509CRLHolder x509CRLHolder) {
        this.f50280b.add(x509CRLHolder.t());
    }

    public void d(org.bouncycastle.util.s sVar) throws CMSException {
        this.f50280b.addAll(t0.i(sVar));
    }

    public void e(X509CertificateHolder x509CertificateHolder) throws CMSException {
        this.f50279a.add(x509CertificateHolder.y());
    }

    public void f(org.bouncycastle.util.s sVar) throws CMSException {
        this.f50279a.addAll(t0.j(sVar));
    }

    public void g(gm.y yVar, gm.h hVar) {
        this.f50280b.add(new n2(false, 1, (gm.h) new mm.k0(yVar, hVar)));
    }

    public void h(gm.y yVar, org.bouncycastle.util.s sVar) {
        this.f50280b.addAll(t0.k(yVar, sVar));
    }

    public void i(b2 b2Var) {
        this.f50282d.add(b2Var);
    }

    public void j(e2 e2Var) {
        Iterator<d2> it2 = e2Var.b().iterator();
        while (it2.hasNext()) {
            this.f50281c.add(it2.next());
        }
    }

    public Map k(gm.y yVar, zn.b bVar, byte[] bArr) {
        HashMap map = new HashMap();
        map.put(d.f50127a, yVar);
        map.put(d.f50130d, bVar);
        map.put(d.f50128b, org.bouncycastle.util.a.p(bArr));
        return map;
    }

    public Map l() {
        return new HashMap(this.f50283e);
    }
}
