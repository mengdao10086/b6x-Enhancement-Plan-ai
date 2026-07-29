package org.bouncycastle.cms.jcajce;

import gm.f2;
import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import so.i1;

/* JADX INFO: loaded from: classes5.dex */
public class JceKTSKeyTransRecipientInfoGenerator extends i1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f44497d = jt.h.b("0c14416e6f6e796d6f75732053656e64657220202020");

    public JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, String str, int i10) throws CertificateEncodingException {
        this(x509Certificate, new mm.y(new JcaX509CertificateHolder(x509Certificate).y()), str, i10);
    }

    public JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, mm.y yVar, String str, int i10) throws CertificateEncodingException {
        super(yVar, new org.bouncycastle.operator.jcajce.j(x509Certificate, str, i10, f44497d, b(yVar)));
    }

    public JceKTSKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, zn.b bVar) throws CertificateEncodingException {
        super(new mm.y(new JcaX509CertificateHolder(x509Certificate).y()), new org.bouncycastle.operator.jcajce.f(bVar, x509Certificate.getPublicKey()));
    }

    public JceKTSKeyTransRecipientInfoGenerator(byte[] bArr, PublicKey publicKey, String str, int i10) {
        super(bArr, new org.bouncycastle.operator.jcajce.j(publicKey, str, i10, f44497d, c(bArr)));
    }

    public JceKTSKeyTransRecipientInfoGenerator(byte[] bArr, zn.b bVar, PublicKey publicKey) {
        super(bArr, new org.bouncycastle.operator.jcajce.f(bVar, publicKey));
    }

    public static byte[] b(mm.y yVar) throws CertificateEncodingException {
        try {
            return yVar.v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CertificateEncodingException("Cannot process extracted IssuerAndSerialNumber: " + e10.getMessage()) { // from class: org.bouncycastle.cms.jcajce.JceKTSKeyTransRecipientInfoGenerator.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e10;
                }
            };
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            return new f2(bArr).getEncoded();
        } catch (IOException e10) {
            throw new IllegalArgumentException("Cannot process subject key identifier: " + e10.getMessage()) { // from class: org.bouncycastle.cms.jcajce.JceKTSKeyTransRecipientInfoGenerator.2
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e10;
                }
            };
        }
    }

    public JceKTSKeyTransRecipientInfoGenerator d(String str) {
        ((org.bouncycastle.operator.jcajce.j) this.f50190a).c(str);
        return this;
    }

    public JceKTSKeyTransRecipientInfoGenerator e(Provider provider) {
        ((org.bouncycastle.operator.jcajce.j) this.f50190a).d(provider);
        return this;
    }
}
