package org.bouncycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public class l0 extends CertStoreSpi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f45478b = "com.sun.jndi.ldap.LdapCtxFactory";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f45479c = "ignore";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f45480d = "none";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f45481e = "com.sun.jndi.url";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jce.i f45482a;

    public l0(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof org.bouncycastle.jce.i) {
            this.f45482a = (org.bouncycastle.jce.i) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException(l0.class.getName() + ": parameter must be a " + org.bouncycastle.jce.i.class.getName() + " object\n" + certStoreParameters.toString());
    }

    public final Set a(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) throws CertStoreException {
        String name;
        String string;
        Set setG;
        HashSet hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() != null || x509CertSelector.getSubjectAsString() != null || x509CertSelector.getCertificate() != null) {
                if (x509CertSelector.getCertificate() != null) {
                    name = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                    string = x509CertSelector.getCertificate().getSerialNumber().toString();
                } else {
                    name = x509CertSelector.getSubjectAsBytes() != null ? new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779") : x509CertSelector.getSubjectAsString();
                    string = null;
                }
                hashSet.addAll(g(str, "*" + f(name, str2) + "*", strArr));
                if (string != null && this.f45482a.N() != null) {
                    setG = g(this.f45482a.N(), "*" + string + "*", strArr);
                }
                return hashSet;
            }
            setG = g(str, "*", strArr);
            hashSet.addAll(setG);
            return hashSet;
        } catch (IOException e10) {
            throw new CertStoreException("exception processing selector: " + e10);
        }
    }

    public final DirContext b() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", f45478b);
        properties.setProperty("java.naming.batchsize", "0");
        properties.setProperty("java.naming.provider.url", this.f45482a.K());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", f45479c);
        properties.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(properties);
    }

    public final Set c(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.f45482a.q()};
        Set setA = a(x509CertSelector, strArr, this.f45482a.G(), this.f45482a.r());
        if (setA.isEmpty()) {
            setA.addAll(g(null, "*", strArr));
        }
        return setA;
    }

    public final Set d(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.f45482a.u()};
        Set setA = a(x509CertSelector, strArr, this.f45482a.I(), this.f45482a.v());
        if (setA.isEmpty()) {
            setA.addAll(g(null, "*", strArr));
        }
        return setA;
    }

    public final Set e(X509CertSelector x509CertSelector) throws CertStoreException {
        return a(x509CertSelector, new String[]{this.f45482a.O()}, this.f45482a.L(), this.f45482a.P());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        String strT;
        String name;
        String[] strArr = {this.f45482a.s()};
        if (!(cRLSelector instanceof X509CRLSelector)) {
            throw new CertStoreException("selector is not a X509CRLSelector");
        }
        X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
        HashSet hashSet = new HashSet();
        String strH = this.f45482a.H();
        HashSet hashSet2 = new HashSet();
        if (x509CRLSelector.getIssuerNames() != null) {
            for (Object obj : x509CRLSelector.getIssuerNames()) {
                if (obj instanceof String) {
                    strT = this.f45482a.t();
                    name = (String) obj;
                } else {
                    strT = this.f45482a.t();
                    name = new X500Principal((byte[]) obj).getName("RFC1779");
                }
                hashSet2.addAll(g(strH, "*" + f(name, strT) + "*", strArr));
            }
        } else {
            hashSet2.addAll(g(strH, "*", strArr));
        }
        hashSet2.addAll(g(null, "*", strArr));
        Iterator it2 = hashSet2.iterator();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", BouncyCastleProvider.f45329b);
            while (it2.hasNext()) {
                CRL crlGenerateCRL = certificateFactory.generateCRL(new ByteArrayInputStream((byte[]) it2.next()));
                if (x509CRLSelector.match(crlGenerateCRL)) {
                    hashSet.add(crlGenerateCRL);
                }
            }
            return hashSet;
        } catch (Exception e10) {
            throw new CertStoreException("CRL cannot be constructed from LDAP result " + e10);
        }
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        if (!(certSelector instanceof X509CertSelector)) {
            throw new CertStoreException("selector is not a X509CertSelector");
        }
        X509CertSelector x509CertSelector = (X509CertSelector) certSelector;
        HashSet hashSet = new HashSet();
        Set<byte[]> setE = e(x509CertSelector);
        setE.addAll(c(x509CertSelector));
        setE.addAll(d(x509CertSelector));
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", BouncyCastleProvider.f45329b);
            for (byte[] bArr : setE) {
                if (bArr != null && bArr.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bArr);
                    try {
                        zn.q qVarY = zn.q.y(new gm.s(bArr).n());
                        arrayList.clear();
                        if (qVarY.x() != null) {
                            arrayList.add(qVarY.x().getEncoded());
                        }
                        if (qVarY.z() != null) {
                            arrayList.add(qVarY.z().getEncoded());
                        }
                    } catch (IOException | IllegalArgumentException unused) {
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        try {
                            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream((byte[]) it2.next()));
                            if (x509CertSelector.match(certificateGenerateCertificate)) {
                                hashSet.add(certificateGenerateCertificate);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            return hashSet;
        } catch (Exception e10) {
            throw new CertStoreException("certificate cannot be constructed from LDAP result: " + e10);
        }
    }

    public final String f(String str, String str2) {
        String strSubstring = str.substring(str.toLowerCase().indexOf(str2.toLowerCase()) + str2.length());
        int iIndexOf = strSubstring.indexOf(44);
        if (iIndexOf == -1) {
            iIndexOf = strSubstring.length();
        }
        while (strSubstring.charAt(iIndexOf - 1) == '\\') {
            iIndexOf = strSubstring.indexOf(44, iIndexOf + 1);
            if (iIndexOf == -1) {
                iIndexOf = strSubstring.length();
            }
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf);
        String strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(61) + 1);
        if (strSubstring3.charAt(0) == ' ') {
            strSubstring3 = strSubstring3.substring(1);
        }
        if (strSubstring3.startsWith("\"")) {
            strSubstring3 = strSubstring3.substring(1);
        }
        return strSubstring3.endsWith("\"") ? strSubstring3.substring(0, strSubstring3.length() - 1) : strSubstring3;
    }

    public final Set g(String str, String str2, String[] strArr) throws CertStoreException {
        String str3 = str + hb.u.f30904o + str2;
        DirContext dirContextB = null;
        if (str == null) {
            str3 = null;
        }
        HashSet hashSet = new HashSet();
        try {
            try {
                dirContextB = b();
                SearchControls searchControls = new SearchControls();
                searchControls.setSearchScope(2);
                searchControls.setCountLimit(0L);
                for (String str4 : strArr) {
                    String[] strArr2 = {str4};
                    searchControls.setReturningAttributes(strArr2);
                    String str5 = "(&(" + str3 + ")(" + strArr2[0] + "=*))";
                    if (str3 == null) {
                        str5 = ee.a.f26978c + strArr2[0] + "=*)";
                    }
                    NamingEnumeration namingEnumerationSearch = dirContextB.search(this.f45482a.p(), str5, searchControls);
                    while (namingEnumerationSearch.hasMoreElements()) {
                        NamingEnumeration all = ((Attribute) ((SearchResult) namingEnumerationSearch.next()).getAttributes().getAll().next()).getAll();
                        while (all.hasMore()) {
                            hashSet.add(all.next());
                        }
                    }
                }
                if (dirContextB != null) {
                    try {
                        dirContextB.close();
                    } catch (Exception unused) {
                    }
                }
                return hashSet;
            } catch (Exception e10) {
                throw new CertStoreException("Error getting results from LDAP directory " + e10);
            }
        } catch (Throwable th2) {
            if (dirContextB != null) {
                try {
                    dirContextB.close();
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }
}
