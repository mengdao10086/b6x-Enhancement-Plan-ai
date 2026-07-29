package jq;

import java.io.IOException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import org.bouncycastle.util.q;

/* JADX INFO: loaded from: classes7.dex */
public class i<T extends Certificate> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CertSelector f36855a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CertSelector f36856a;

        public b(CertSelector certSelector) {
            this.f36856a = (CertSelector) certSelector.clone();
        }

        public i<? extends Certificate> a() {
            return new i<>(this.f36856a);
        }
    }

    public static class c extends X509CertSelector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f36857a;

        public c(i iVar) {
            this.f36857a = iVar;
            if (iVar.f36855a instanceof X509CertSelector) {
                X509CertSelector x509CertSelector = (X509CertSelector) iVar.f36855a;
                setAuthorityKeyIdentifier(x509CertSelector.getAuthorityKeyIdentifier());
                setBasicConstraints(x509CertSelector.getBasicConstraints());
                setCertificate(x509CertSelector.getCertificate());
                setCertificateValid(x509CertSelector.getCertificateValid());
                setKeyUsage(x509CertSelector.getKeyUsage());
                setMatchAllSubjectAltNames(x509CertSelector.getMatchAllSubjectAltNames());
                setPrivateKeyValid(x509CertSelector.getPrivateKeyValid());
                setSerialNumber(x509CertSelector.getSerialNumber());
                setSubjectKeyIdentifier(x509CertSelector.getSubjectKeyIdentifier());
                setSubjectPublicKey(x509CertSelector.getSubjectPublicKey());
                try {
                    setExtendedKeyUsage(x509CertSelector.getExtendedKeyUsage());
                    setIssuer(x509CertSelector.getIssuerAsBytes());
                    setNameConstraints(x509CertSelector.getNameConstraints());
                    setPathToNames(x509CertSelector.getPathToNames());
                    setPolicy(x509CertSelector.getPolicy());
                    setSubject(x509CertSelector.getSubjectAsBytes());
                    setSubjectAlternativeNames(x509CertSelector.getSubjectAlternativeNames());
                    setSubjectPublicKeyAlgID(x509CertSelector.getSubjectPublicKeyAlgID());
                } catch (IOException e10) {
                    throw new IllegalStateException("base selector invalid: " + e10.getMessage(), e10);
                }
            }
        }

        @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
        public boolean match(Certificate certificate) {
            i iVar = this.f36857a;
            return iVar == null ? certificate != null : iVar.M(certificate);
        }
    }

    public i(CertSelector certSelector) {
        this.f36855a = certSelector;
    }

    public static Collection<? extends Certificate> c(i iVar, CertStore certStore) throws CertStoreException {
        return certStore.getCertificates(new c(iVar));
    }

    public Certificate b() {
        CertSelector certSelector = this.f36855a;
        if (certSelector instanceof X509CertSelector) {
            return ((X509CertSelector) certSelector).getCertificate();
        }
        return null;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new i(this.f36855a);
    }

    @Override // org.bouncycastle.util.q
    /* JADX INFO: renamed from: match, reason: merged with bridge method [inline-methods] */
    public boolean M(Certificate certificate) {
        return this.f36855a.match(certificate);
    }
}
