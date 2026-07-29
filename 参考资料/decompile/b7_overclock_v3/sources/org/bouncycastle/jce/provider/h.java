package org.bouncycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45453a = 15000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<URI, WeakReference<jq.d>> f45454b = Collections.synchronizedMap(new WeakHashMap());

    public static class a<T extends CRL> implements jq.d, org.bouncycastle.util.k<CRL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Collection<CRL> f45455a;

        public a(org.bouncycastle.util.s<CRL> sVar) {
            this.f45455a = new ArrayList(sVar.a(null));
        }

        @Override // jq.d, org.bouncycastle.util.s
        public Collection a(org.bouncycastle.util.q qVar) {
            if (qVar == null) {
                return new ArrayList(this.f45455a);
            }
            ArrayList arrayList = new ArrayList();
            for (CRL crl : this.f45455a) {
                if (qVar.M(crl)) {
                    arrayList.add(crl);
                }
            }
            return arrayList;
        }

        @Override // org.bouncycastle.util.k, java.lang.Iterable
        public Iterator<CRL> iterator() {
            return a(null).iterator();
        }
    }

    public static synchronized jq.d a(CertificateFactory certificateFactory, Date date, URI uri) throws IOException, CRLException {
        WeakReference<jq.d> weakReference = f45454b.get(uri);
        jq.d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar != null) {
            boolean z10 = false;
            Iterator it2 = dVar.a(null).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Date nextUpdate = ((X509CRL) it2.next()).getNextUpdate();
                if (nextUpdate != null && nextUpdate.before(date)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return dVar;
            }
        }
        a aVar = new a(new org.bouncycastle.util.e(uri.getScheme().equals("ldap") ? c(certificateFactory, uri) : b(certificateFactory, uri)));
        f45454b.put(uri, new WeakReference<>(aVar));
        return aVar;
    }

    public static Collection b(CertificateFactory certificateFactory, URI uri) throws IOException, CRLException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        InputStream inputStream = httpURLConnection.getInputStream();
        Collection<? extends CRL> collectionGenerateCRLs = certificateFactory.generateCRLs(inputStream);
        inputStream.close();
        return collectionGenerateCRLs;
    }

    public static Collection c(CertificateFactory certificateFactory, URI uri) throws IOException, CRLException {
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", uri.toString());
        try {
            byte[] bArr = (byte[]) new InitialDirContext(hashtable).getAttributes("").get("certificateRevocationList;binary").get();
            if (bArr != null && bArr.length != 0) {
                return certificateFactory.generateCRLs(new ByteArrayInputStream(bArr));
            }
            throw new CRLException("no CRL returned from: " + uri);
        } catch (NamingException e10) {
            throw new CRLException("issue connecting to: " + uri.toString(), e10);
        }
    }
}
