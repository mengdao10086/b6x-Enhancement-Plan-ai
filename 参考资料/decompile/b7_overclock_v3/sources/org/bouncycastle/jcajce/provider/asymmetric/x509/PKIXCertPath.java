package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.c0;
import gm.f0;
import gm.h;
import gm.j;
import gm.j2;
import gm.l2;
import gm.s;
import gm.t;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import zr.i;

/* JADX INFO: loaded from: classes7.dex */
public class PKIXCertPath extends CertPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f45070a;
    private List certificates;
    private final org.bouncycastle.jcajce.util.d helper;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("PkiPath");
        arrayList.add("PEM");
        arrayList.add(i.f59664j);
        f45070a = Collections.unmodifiableList(arrayList);
    }

    public PKIXCertPath(InputStream inputStream, String str) throws CertificateException {
        super("X.509");
        org.bouncycastle.jcajce.util.b bVar = new org.bouncycastle.jcajce.util.b();
        this.helper = bVar;
        try {
            if (!str.equalsIgnoreCase("PkiPath")) {
                if (!str.equalsIgnoreCase(i.f59664j) && !str.equalsIgnoreCase("PEM")) {
                    throw new CertificateException("unsupported encoding: " + str);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                this.certificates = new ArrayList();
                java.security.cert.CertificateFactory certificateFactoryS = bVar.s("X.509");
                while (true) {
                    Certificate certificateGenerateCertificate = certificateFactoryS.generateCertificate(bufferedInputStream);
                    if (certificateGenerateCertificate == null) {
                        break;
                    } else {
                        this.certificates.add(certificateGenerateCertificate);
                    }
                }
            } else {
                c0 c0VarN = new s(inputStream).n();
                if (!(c0VarN instanceof f0)) {
                    throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
                }
                Enumeration enumerationL = ((f0) c0VarN).L();
                this.certificates = new ArrayList();
                java.security.cert.CertificateFactory certificateFactoryS2 = bVar.s("X.509");
                while (enumerationL.hasMoreElements()) {
                    this.certificates.add(0, certificateFactoryS2.generateCertificate(new ByteArrayInputStream(((h) enumerationL.nextElement()).b().v(j.f29713a))));
                }
            }
            this.certificates = a(this.certificates);
        } catch (IOException e10) {
            throw new CertificateException("IOException throw while decoding CertPath:\n" + e10.toString());
        } catch (NoSuchProviderException e11) {
            throw new CertificateException("BouncyCastle provider not found while trying to get a CertificateFactory:\n" + e11.toString());
        }
    }

    public PKIXCertPath(List list) {
        super("X.509");
        this.helper = new org.bouncycastle.jcajce.util.b();
        this.certificates = a(new ArrayList(list));
    }

    public final List a(List list) {
        boolean z10;
        boolean z11;
        if (list.size() < 2) {
            return list;
        }
        X500Principal issuerX500Principal = ((X509Certificate) list.get(0)).getIssuerX500Principal();
        int i10 = 1;
        while (true) {
            if (i10 == list.size()) {
                z10 = true;
                break;
            }
            if (!issuerX500Principal.equals(((X509Certificate) list.get(i10)).getSubjectX500Principal())) {
                z10 = false;
                break;
            }
            issuerX500Principal = ((X509Certificate) list.get(i10)).getIssuerX500Principal();
            i10++;
        }
        if (z10) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list);
        for (int i11 = 0; i11 < list.size(); i11++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i11);
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            int i12 = 0;
            while (true) {
                if (i12 == list.size()) {
                    z11 = false;
                    break;
                }
                if (((X509Certificate) list.get(i12)).getIssuerX500Principal().equals(subjectX500Principal)) {
                    z11 = true;
                    break;
                }
                i12++;
            }
            if (!z11) {
                arrayList.add(x509Certificate);
                list.remove(i11);
            }
        }
        if (arrayList.size() > 1) {
            return arrayList2;
        }
        for (int i13 = 0; i13 != arrayList.size(); i13++) {
            X500Principal issuerX500Principal2 = ((X509Certificate) arrayList.get(i13)).getIssuerX500Principal();
            int i14 = 0;
            while (true) {
                if (i14 < list.size()) {
                    X509Certificate x509Certificate2 = (X509Certificate) list.get(i14);
                    if (issuerX500Principal2.equals(x509Certificate2.getSubjectX500Principal())) {
                        arrayList.add(x509Certificate2);
                        list.remove(i14);
                        break;
                    }
                    i14++;
                }
            }
        }
        return list.size() > 0 ? arrayList2 : arrayList;
    }

    public final c0 b(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new s(x509Certificate.getEncoded()).n();
        } catch (Exception e10) {
            throw new CertificateEncodingException("Exception while encoding certificate: " + e10.toString());
        }
    }

    public final byte[] c(h hVar) throws CertificateEncodingException {
        try {
            return hVar.b().v(j.f29713a);
        } catch (IOException e10) {
            throw new CertificateEncodingException("Exception thrown: " + e10);
        }
    }

    @Override // java.security.cert.CertPath
    public List getCertificates() {
        return Collections.unmodifiableList(new ArrayList(this.certificates));
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() throws CertificateEncodingException {
        Iterator encodings = getEncodings();
        if (!encodings.hasNext()) {
            return null;
        }
        Object next = encodings.next();
        if (next instanceof String) {
            return getEncoded((String) next);
        }
        return null;
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String str) throws CertificateEncodingException {
        if (str.equalsIgnoreCase("PkiPath")) {
            gm.i iVar = new gm.i();
            List list = this.certificates;
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                iVar.a(b((X509Certificate) listIterator.previous()));
            }
            return c(new j2(iVar));
        }
        int i10 = 0;
        if (str.equalsIgnoreCase(i.f59664j)) {
            pn.g gVar = new pn.g(pn.s.f46830o4, null);
            gm.i iVar2 = new gm.i();
            while (i10 != this.certificates.size()) {
                iVar2.a(b((X509Certificate) this.certificates.get(i10)));
                i10++;
            }
            return c(new pn.g(pn.s.f46833p4, new pn.c0(new t(1L), new l2(), gVar, new l2(iVar2), null, new l2())));
        }
        if (!str.equalsIgnoreCase("PEM")) {
            throw new CertificateEncodingException("unsupported encoding: " + str);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        lt.f fVar = new lt.f(new OutputStreamWriter(byteArrayOutputStream));
        while (i10 != this.certificates.size()) {
            try {
                fVar.d(new lt.b(i.f59660f, ((X509Certificate) this.certificates.get(i10)).getEncoded()));
                i10++;
            } catch (Exception unused) {
                throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
            }
        }
        fVar.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override // java.security.cert.CertPath
    public Iterator getEncodings() {
        return f45070a.iterator();
    }
}
