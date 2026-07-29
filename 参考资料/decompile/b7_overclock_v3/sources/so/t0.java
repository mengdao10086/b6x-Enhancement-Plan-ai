package so;

import gm.b3;
import gm.l2;
import gm.n2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f50316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f50317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f50318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f50319d;

    static {
        HashSet hashSet = new HashSet();
        f50316a = hashSet;
        HashSet hashSet2 = new HashSet();
        f50317b = hashSet2;
        HashSet hashSet3 = new HashSet();
        f50318c = hashSet3;
        HashSet hashSet4 = new HashSet();
        f50319d = hashSet4;
        hashSet.add("DES");
        hashSet.add("DESEDE");
        hashSet.add(on.b.f44361e.L());
        hashSet.add(pn.s.Z3.L());
        hashSet.add(pn.s.f46835p6.L());
        hashSet2.add(co.r.f11157b1);
        hashSet2.add(rn.d.R);
        hashSet2.add(rn.d.S);
        hashSet2.add(rn.d.T);
        hashSet2.add(rn.d.U);
        hashSet3.add(co.r.f11155a1);
        hashSet3.add(co.r.Z0);
        hashSet3.add(rn.d.N);
        hashSet3.add(rn.d.J);
        hashSet3.add(rn.d.O);
        hashSet3.add(rn.d.K);
        hashSet3.add(rn.d.P);
        hashSet3.add(rn.d.L);
        hashSet3.add(rn.d.Q);
        hashSet3.add(rn.d.M);
        hashSet4.add(qm.a.E);
        hashSet4.add(qn.a.f47522l);
        hashSet4.add(qn.a.f47523m);
    }

    public static void a(Set<zn.b> set, d2 d2Var, cs.n nVar) {
        set.add(q0.f50286a.b(d2Var.i(), nVar));
        Iterator<d2> it2 = d2Var.f().iterator();
        while (it2.hasNext()) {
            set.add(q0.f50286a.b(it2.next().i(), nVar));
        }
    }

    public static InputStream b(Collection collection, InputStream inputStream) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            inputStream = new kt.d(inputStream, ((cs.o) it2.next()).b());
        }
        return inputStream;
    }

    public static OutputStream c(Collection collection, OutputStream outputStream) {
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            outputStream = m(outputStream, ((b2) it2.next()).f());
        }
        return outputStream;
    }

    public static gm.h0 d(Set<zn.b> set) {
        return new b3((zn.b[]) set.toArray(new zn.b[set.size()]));
    }

    public static OutputStream e(OutputStream outputStream, int i10, boolean z10, int i11) throws IOException {
        gm.f1 f1Var = new gm.f1(outputStream, i10, z10);
        return i11 != 0 ? f1Var.f(new byte[i11]) : f1Var.e();
    }

    public static gm.h0 f(List list) {
        gm.i iVar = new gm.i();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iVar.a((gm.h) it2.next());
        }
        return new gm.l1(iVar);
    }

    public static gm.h0 g(List list) {
        gm.i iVar = new gm.i();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iVar.a((gm.h) it2.next());
        }
        return new l2(iVar);
    }

    public static List h(org.bouncycastle.util.s sVar) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it2 = sVar.a(null).iterator();
            while (it2.hasNext()) {
                arrayList.add(new n2(false, 2, (gm.h) ((X509AttributeCertificateHolder) it2.next()).z()));
            }
            return arrayList;
        } catch (ClassCastException e10) {
            throw new CMSException("error processing certs", e10);
        }
    }

    public static List i(org.bouncycastle.util.s sVar) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (Object objT : sVar.a(null)) {
                if (objT instanceof X509CRLHolder) {
                    objT = ((X509CRLHolder) objT).t();
                } else if (objT instanceof mm.k0) {
                    mm.k0 k0VarA = mm.k0.A(objT);
                    y(k0VarA);
                    arrayList.add(new n2(false, 1, (gm.h) k0VarA));
                } else if (objT instanceof gm.n0) {
                }
                arrayList.add(objT);
            }
            return arrayList;
        } catch (ClassCastException e10) {
            throw new CMSException("error processing certs", e10);
        }
    }

    public static List j(org.bouncycastle.util.s sVar) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it2 = sVar.a(null).iterator();
            while (it2.hasNext()) {
                arrayList.add(((X509CertificateHolder) it2.next()).y());
            }
            return arrayList;
        } catch (ClassCastException e10) {
            throw new CMSException("error processing certs", e10);
        }
    }

    public static Collection k(gm.y yVar, org.bouncycastle.util.s sVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = sVar.a(null).iterator();
        while (it2.hasNext()) {
            mm.k0 k0Var = new mm.k0(yVar, (gm.h) it2.next());
            y(k0Var);
            arrayList.add(new n2(false, 1, (gm.h) k0Var));
        }
        return arrayList;
    }

    public static OutputStream l(OutputStream outputStream) {
        return outputStream == null ? new k1() : outputStream;
    }

    public static OutputStream m(OutputStream outputStream, OutputStream outputStream2) {
        return outputStream == null ? l(outputStream2) : outputStream2 == null ? l(outputStream) : new kt.e(outputStream, outputStream2);
    }

    public static boolean n(String str) {
        return f50316a.contains(Strings.o(str));
    }

    public static boolean o(gm.y yVar) {
        return f50318c.contains(yVar);
    }

    public static boolean p(zn.b bVar, zn.b bVar2) {
        if (bVar == null || bVar2 == null || !bVar.x().C(bVar2.x())) {
            return false;
        }
        gm.h hVarA = bVar.A();
        gm.h hVarA2 = bVar2.A();
        return hVarA != null ? hVarA.equals(hVarA2) || (hVarA.equals(gm.d2.f29657b) && hVarA2 == null) : hVarA2 == null || hVarA2.equals(gm.d2.f29657b);
    }

    public static boolean q(gm.y yVar) {
        return f50319d.contains(yVar);
    }

    public static boolean r(gm.y yVar) {
        return f50317b.contains(yVar);
    }

    public static boolean s(gm.y yVar) {
        return yVar.C(pn.s.f46841r6) || yVar.C(pn.s.f46844s6);
    }

    public static mm.n t(gm.s sVar) throws CMSException {
        try {
            mm.n nVarA = mm.n.A(sVar.n());
            if (nVarA != null) {
                return nVarA;
            }
            throw new CMSException("No content found.");
        } catch (IOException e10) {
            throw new CMSException("IOException reading content.", e10);
        } catch (ClassCastException e11) {
            throw new CMSException("Malformed content.", e11);
        } catch (IllegalArgumentException e12) {
            throw new CMSException("Malformed content.", e12);
        }
    }

    public static mm.n u(InputStream inputStream) throws CMSException {
        return t(new gm.s(inputStream));
    }

    public static mm.n v(byte[] bArr) throws CMSException {
        return t(new gm.s(bArr));
    }

    public static byte[] w(InputStream inputStream) throws IOException {
        return kt.c.e(inputStream);
    }

    public static byte[] x(InputStream inputStream, int i10) throws IOException {
        return kt.c.f(inputStream, i10);
    }

    public static void y(mm.k0 k0Var) {
        if (mm.k.U2.C(k0Var.y()) && nn.g.y(k0Var.x()).A().y() != 0) {
            throw new IllegalArgumentException("cannot add unsuccessful OCSP response to CMS SignedData");
        }
    }
}
