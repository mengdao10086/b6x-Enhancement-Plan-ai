package ot;

import gm.s;
import hb.u;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.i;
import org.bouncycastle.jce.provider.f0;
import org.bouncycastle.jce.provider.i0;
import org.bouncycastle.jce.provider.j0;
import org.bouncycastle.jce.provider.k0;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.k;
import org.bouncycastle.x509.l;
import org.bouncycastle.x509.m;
import org.bouncycastle.x509.n;
import org.bouncycastle.x509.o;
import org.bouncycastle.x509.p;
import org.bouncycastle.x509.util.StreamParsingException;
import zn.q;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f46287c = "com.sun.jndi.ldap.LdapCtxFactory";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f46288d = "ignore";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f46289e = "none";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f46290f = "com.sun.jndi.url";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f46291g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f46292h = 60000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f46293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f46294b = new HashMap(f46291g);

    public a(i iVar) {
        this.f46293a = iVar;
    }

    public final String[] A(String str) {
        return str.split("\\s+");
    }

    public final synchronized void a(String str, List list) {
        Date date = new Date(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        arrayList.add(date);
        arrayList.add(list);
        if (!this.f46294b.containsKey(str) && this.f46294b.size() >= f46291g) {
            long time = date.getTime();
            Object key = null;
            for (Map.Entry entry : this.f46294b.entrySet()) {
                long time2 = ((Date) ((List) entry.getValue()).get(0)).getTime();
                if (time2 < time) {
                    key = entry.getKey();
                    time = time2;
                }
            }
            this.f46294b.remove(key);
        }
        Map map = this.f46294b;
        map.put(str, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b(org.bouncycastle.x509.k r7, java.lang.String[] r8, java.lang.String[] r9, java.lang.String[] r10) throws org.bouncycastle.util.StoreException {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ot.a.b(org.bouncycastle.x509.k, java.lang.String[], java.lang.String[], java.lang.String[]):java.util.List");
    }

    public final List c(m mVar, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (mVar.getIssuers() != null) {
            hashSet.addAll(mVar.getIssuers());
        }
        if (mVar.getCertificateChecking() != null) {
            hashSet.add(r(mVar.getCertificateChecking()));
        }
        if (mVar.a() != null) {
            Principal[] principalArrB = mVar.a().m().b();
            for (int i10 = 0; i10 < principalArrB.length; i10++) {
                if (principalArrB[i10] instanceof X500Principal) {
                    hashSet.add(principalArrB[i10]);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        String name = null;
        while (it2.hasNext()) {
            name = ((X500Principal) it2.next()).getName("RFC1779");
            for (String str : strArr3) {
                arrayList.addAll(z(strArr2, "*" + y(name, str) + "*", strArr));
            }
        }
        if (name == null) {
            arrayList.addAll(z(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public final List d(o oVar, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        String strW = w(oVar);
        String string = oVar.getSerialNumber() != null ? oVar.getSerialNumber().toString() : null;
        if (oVar.getCertificate() != null) {
            strW = oVar.getCertificate().getSubjectX500Principal().getName("RFC1779");
            string = oVar.getCertificate().getSerialNumber().toString();
        }
        if (strW != null) {
            for (String str : strArr3) {
                arrayList.addAll(z(strArr2, "*" + y(strW, str) + "*", strArr));
            }
        }
        if (string != null && this.f46293a.N() != null) {
            arrayList.addAll(z(A(this.f46293a.N()), string, strArr));
        }
        if (string == null && strW == null) {
            arrayList.addAll(z(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public final DirContext e() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", f46287c);
        properties.setProperty("java.naming.batchsize", "0");
        properties.setProperty("java.naming.provider.url", this.f46293a.K());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", f46288d);
        properties.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(properties);
    }

    public final Set f(List list, k kVar) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it2 = list.iterator();
        f0 f0Var = new f0();
        while (it2.hasNext()) {
            try {
                f0Var.a(new ByteArrayInputStream((byte[]) it2.next()));
                l lVar = (l) f0Var.b();
                if (kVar.M(lVar)) {
                    hashSet.add(lVar);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    public final Set g(List list, m mVar) throws StoreException {
        HashSet hashSet = new HashSet();
        i0 i0Var = new i0();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                i0Var.a(new ByteArrayInputStream((byte[]) it2.next()));
                X509CRL x509crl = (X509CRL) i0Var.b();
                if (mVar.M(x509crl)) {
                    hashSet.add(x509crl);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    public final Set h(List list, o oVar) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it2 = list.iterator();
        k0 k0Var = new k0();
        while (it2.hasNext()) {
            try {
                k0Var.a(new ByteArrayInputStream((byte[]) it2.next()));
                X509Certificate x509Certificate = (X509Certificate) k0Var.b();
                if (oVar.M(x509Certificate)) {
                    hashSet.add(x509Certificate);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    public final Set i(List list, n nVar) throws StoreException {
        p pVar;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < list.size()) {
            try {
                try {
                    j0 j0Var = new j0();
                    j0Var.a(new ByteArrayInputStream((byte[]) list.get(i10)));
                    pVar = (p) j0Var.b();
                } catch (IOException | CertificateParsingException unused) {
                }
            } catch (StreamParsingException unused2) {
                int i11 = i10 + 1;
                i10 = i11;
                pVar = new p(new q(zn.o.z(new s((byte[]) list.get(i10)).n()), zn.o.z(new s((byte[]) list.get(i11)).n())));
            }
            if (nVar.M(pVar)) {
                hashSet.add(pVar);
            }
            i10++;
        }
        return hashSet;
    }

    public final List j(n nVar, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        String strW = nVar.b() != null ? w(nVar.b()) : null;
        if (nVar.a() != null && nVar.a().b() != null) {
            strW = nVar.a().b().getSubjectX500Principal().getName("RFC1779");
        }
        if (strW != null) {
            for (String str : strArr3) {
                arrayList.addAll(z(strArr2, "*" + y(strW, str) + "*", strArr));
            }
        }
        if (strW == null) {
            arrayList.addAll(z(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public Collection k(k kVar) throws StoreException {
        String[] strArrA = A(this.f46293a.d());
        String[] strArrA2 = A(this.f46293a.A());
        String[] strArrA3 = A(this.f46293a.e());
        Set setF = f(b(kVar, strArrA, strArrA2, strArrA3), kVar);
        if (setF.size() == 0) {
            setF.addAll(f(b(new k(), strArrA, strArrA2, strArrA3), kVar));
        }
        return setF;
    }

    public Collection l(m mVar) throws StoreException {
        String[] strArrA = A(this.f46293a.f());
        String[] strArrA2 = A(this.f46293a.B());
        String[] strArrA3 = A(this.f46293a.g());
        Set setG = g(c(mVar, strArrA, strArrA2, strArrA3), mVar);
        if (setG.size() == 0) {
            setG.addAll(g(c(new m(), strArrA, strArrA2, strArrA3), mVar));
        }
        return setG;
    }

    public Collection m(k kVar) throws StoreException {
        String[] strArrA = A(this.f46293a.h());
        String[] strArrA2 = A(this.f46293a.C());
        String[] strArrA3 = A(this.f46293a.i());
        Set setF = f(b(kVar, strArrA, strArrA2, strArrA3), kVar);
        if (setF.size() == 0) {
            setF.addAll(f(b(new k(), strArrA, strArrA2, strArrA3), kVar));
        }
        return setF;
    }

    public Collection n(m mVar) throws StoreException {
        String[] strArrA = A(this.f46293a.j());
        String[] strArrA2 = A(this.f46293a.D());
        String[] strArrA3 = A(this.f46293a.k());
        Set setG = g(c(mVar, strArrA, strArrA2, strArrA3), mVar);
        if (setG.size() == 0) {
            setG.addAll(g(c(new m(), strArrA, strArrA2, strArrA3), mVar));
        }
        return setG;
    }

    public Collection o(k kVar) throws StoreException {
        String[] strArrA = A(this.f46293a.l());
        String[] strArrA2 = A(this.f46293a.E());
        String[] strArrA3 = A(this.f46293a.m());
        Set setF = f(b(kVar, strArrA, strArrA2, strArrA3), kVar);
        if (setF.size() == 0) {
            setF.addAll(f(b(new k(), strArrA, strArrA2, strArrA3), kVar));
        }
        return setF;
    }

    public Collection p(m mVar) throws StoreException {
        String[] strArrA = A(this.f46293a.n());
        String[] strArrA2 = A(this.f46293a.F());
        String[] strArrA3 = A(this.f46293a.o());
        Set setG = g(c(mVar, strArrA, strArrA2, strArrA3), mVar);
        if (setG.size() == 0) {
            setG.addAll(g(c(new m(), strArrA, strArrA2, strArrA3), mVar));
        }
        return setG;
    }

    public Collection q(o oVar) throws StoreException {
        String[] strArrA = A(this.f46293a.q());
        String[] strArrA2 = A(this.f46293a.G());
        String[] strArrA3 = A(this.f46293a.r());
        Set setH = h(d(oVar, strArrA, strArrA2, strArrA3), oVar);
        if (setH.size() == 0) {
            setH.addAll(h(d(new o(), strArrA, strArrA2, strArrA3), oVar));
        }
        return setH;
    }

    public final X500Principal r(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal();
    }

    public Collection s(m mVar) throws StoreException {
        String[] strArrA = A(this.f46293a.s());
        String[] strArrA2 = A(this.f46293a.H());
        String[] strArrA3 = A(this.f46293a.t());
        Set setG = g(c(mVar, strArrA, strArrA2, strArrA3), mVar);
        if (setG.size() == 0) {
            setG.addAll(g(c(new m(), strArrA, strArrA2, strArrA3), mVar));
        }
        return setG;
    }

    public Collection t(n nVar) throws StoreException {
        String[] strArrA = A(this.f46293a.u());
        String[] strArrA2 = A(this.f46293a.I());
        String[] strArrA3 = A(this.f46293a.v());
        Set setI = i(j(nVar, strArrA, strArrA2, strArrA3), nVar);
        if (setI.size() == 0) {
            o oVar = new o();
            n nVar2 = new n();
            nVar2.e(oVar);
            nVar2.f(oVar);
            setI.addAll(i(j(nVar2, strArrA, strArrA2, strArrA3), nVar));
        }
        return setI;
    }

    public Collection u(m mVar) throws StoreException {
        String[] strArrA = A(this.f46293a.w());
        String[] strArrA2 = A(this.f46293a.J());
        String[] strArrA3 = A(this.f46293a.x());
        Set setG = g(c(mVar, strArrA, strArrA2, strArrA3), mVar);
        if (setG.size() == 0) {
            setG.addAll(g(c(new m(), strArrA, strArrA2, strArrA3), mVar));
        }
        return setG;
    }

    public final List v(String str) {
        List list = (List) this.f46294b.get(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list == null || ((Date) list.get(0)).getTime() < jCurrentTimeMillis - f46292h) {
            return null;
        }
        return (List) list.get(1);
    }

    public final String w(o oVar) {
        try {
            byte[] subjectAsBytes = oVar.getSubjectAsBytes();
            if (subjectAsBytes != null) {
                return new X500Principal(subjectAsBytes).getName("RFC1779");
            }
            return null;
        } catch (IOException e10) {
            throw new StoreException("exception processing name: " + e10.getMessage(), e10);
        }
    }

    public Collection x(o oVar) throws StoreException {
        String[] strArrA = A(this.f46293a.O());
        String[] strArrA2 = A(this.f46293a.L());
        String[] strArrA3 = A(this.f46293a.P());
        Set setH = h(d(oVar, strArrA, strArrA2, strArrA3), oVar);
        if (setH.size() == 0) {
            setH.addAll(h(d(new o(), strArrA, strArrA2, strArrA3), oVar));
        }
        return setH;
    }

    public final String y(String str, String str2) {
        int iIndexOf = str.toLowerCase().indexOf(str2.toLowerCase() + u.f30904o);
        if (iIndexOf == -1) {
            return "";
        }
        String strSubstring = str.substring(iIndexOf + str2.length());
        int iIndexOf2 = strSubstring.indexOf(44);
        if (iIndexOf2 == -1) {
            iIndexOf2 = strSubstring.length();
        }
        while (strSubstring.charAt(iIndexOf2 - 1) == '\\') {
            iIndexOf2 = strSubstring.indexOf(44, iIndexOf2 + 1);
            if (iIndexOf2 == -1) {
                iIndexOf2 = strSubstring.length();
            }
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf2);
        String strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(61) + 1);
        if (strSubstring3.charAt(0) == ' ') {
            strSubstring3 = strSubstring3.substring(1);
        }
        if (strSubstring3.startsWith("\"")) {
            strSubstring3 = strSubstring3.substring(1);
        }
        return strSubstring3.endsWith("\"") ? strSubstring3.substring(0, strSubstring3.length() - 1) : strSubstring3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:24|(5:48|25|(4:28|(2:31|29)|52|26)|51|32)|44|33|41) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List z(java.lang.String[] r10, java.lang.String r11, java.lang.String[] r12) throws org.bouncycastle.util.StoreException {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ot.a.z(java.lang.String[], java.lang.String, java.lang.String[]):java.util.List");
    }
}
