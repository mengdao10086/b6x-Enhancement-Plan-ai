package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.c0;
import gm.h;
import gm.u1;
import gm.y;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import zn.j;
import zn.o;

/* JADX INFO: loaded from: classes7.dex */
class X509CertificateObject extends X509CertificateImpl implements er.g {
    private er.g attrCarrier;
    private final Object cacheLock;
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CertificateInternal internalCertificateValue;
    private X500Principal issuerValue;
    private PublicKey publicKeyValue;
    private X500Principal subjectValue;
    private long[] validityValues;

    public static class X509CertificateEncodingException extends CertificateEncodingException {
        private final Throwable cause;

        public X509CertificateEncodingException(Throwable th2) {
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public X509CertificateObject(org.bouncycastle.jcajce.util.d dVar, o oVar) throws CertificateParsingException {
        super(dVar, oVar, u(oVar), v(oVar), w(oVar), x(oVar));
        this.cacheLock = new Object();
        this.attrCarrier = new m();
    }

    public static j u(o oVar) throws CertificateParsingException {
        try {
            byte[] bArrQ = X509CertificateImpl.q(oVar, "2.5.29.19");
            if (bArrQ == null) {
                return null;
            }
            return j.z(c0.D(bArrQ));
        } catch (Exception e10) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e10);
        }
    }

    public static boolean[] v(o oVar) throws CertificateParsingException {
        try {
            byte[] bArrQ = X509CertificateImpl.q(oVar, "2.5.29.15");
            if (bArrQ == null) {
                return null;
            }
            u1 u1VarS = u1.S(c0.D(bArrQ));
            byte[] bArrH = u1VarS.H();
            int length = (bArrH.length * 8) - u1VarS.m();
            int i10 = 9;
            if (length >= 9) {
                i10 = length;
            }
            boolean[] zArr = new boolean[i10];
            for (int i11 = 0; i11 != length; i11++) {
                zArr[i11] = (bArrH[i11 / 8] & (128 >>> (i11 % 8))) != 0;
            }
            return zArr;
        } catch (Exception e10) {
            throw new CertificateParsingException("cannot construct KeyUsage: " + e10);
        }
    }

    public static String w(o oVar) throws CertificateParsingException {
        try {
            return g.c(oVar.D());
        } catch (Exception e10) {
            throw new CertificateParsingException("cannot construct SigAlgName: " + e10);
        }
    }

    public static byte[] x(o oVar) throws CertificateParsingException {
        try {
            h hVarA = oVar.D().A();
            if (hVarA == null) {
                return null;
            }
            return hVarA.b().v(gm.j.f29713a);
        } catch (Exception e10) {
            throw new CertificateParsingException("cannot construct SigAlgParams: " + e10);
        }
    }

    public int A() {
        try {
            byte[] encoded = y().getEncoded();
            int i10 = 0;
            for (int i11 = 1; i11 < encoded.length; i11++) {
                i10 += encoded[i11] * i11;
            }
            return i10;
        } catch (CertificateEncodingException unused) {
            return 0;
        }
    }

    @Override // er.g
    public h c(y yVar) {
        return this.attrCarrier.c(yVar);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        long time = date.getTime();
        long[] jArrZ = z();
        if (time > jArrZ[1]) {
            throw new CertificateExpiredException("certificate expired on " + this.f45075c.x().A());
        }
        if (time >= jArrZ[0]) {
            return;
        }
        throw new CertificateNotYetValidException("certificate not valid till " + this.f45075c.E().A());
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) throws IOException {
        X509CertificateInternal x509CertificateInternalY;
        gm.d dVarC;
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CertificateObject) {
            X509CertificateObject x509CertificateObject = (X509CertificateObject) obj;
            if (this.hashValueSet && x509CertificateObject.hashValueSet) {
                if (this.hashValue != x509CertificateObject.hashValue) {
                    return false;
                }
            } else if ((this.internalCertificateValue == null || x509CertificateObject.internalCertificateValue == null) && (dVarC = this.f45075c.C()) != null && !dVarC.C(x509CertificateObject.f45075c.C())) {
                return false;
            }
            x509CertificateInternalY = y();
            obj = x509CertificateObject.y();
        } else {
            x509CertificateInternalY = y();
        }
        return x509CertificateInternalY.equals(obj);
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return org.bouncycastle.util.a.p(y().getEncoded());
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        X500Principal x500Principal;
        synchronized (this.cacheLock) {
            X500Principal x500Principal2 = this.issuerValue;
            if (x500Principal2 != null) {
                return x500Principal2;
            }
            X500Principal issuerX500Principal = super.getIssuerX500Principal();
            synchronized (this.cacheLock) {
                if (this.issuerValue == null) {
                    this.issuerValue = issuerX500Principal;
                }
                x500Principal = this.issuerValue;
            }
            return x500Principal;
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public PublicKey getPublicKey() {
        PublicKey publicKey;
        synchronized (this.cacheLock) {
            PublicKey publicKey2 = this.publicKeyValue;
            if (publicKey2 != null) {
                return publicKey2;
            }
            PublicKey publicKey3 = super.getPublicKey();
            if (publicKey3 == null) {
                return null;
            }
            synchronized (this.cacheLock) {
                if (this.publicKeyValue == null) {
                    this.publicKeyValue = publicKey3;
                }
                publicKey = this.publicKeyValue;
            }
            return publicKey;
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        X500Principal x500Principal;
        synchronized (this.cacheLock) {
            X500Principal x500Principal2 = this.subjectValue;
            if (x500Principal2 != null) {
                return x500Principal2;
            }
            X500Principal subjectX500Principal = super.getSubjectX500Principal();
            synchronized (this.cacheLock) {
                if (this.subjectValue == null) {
                    this.subjectValue = subjectX500Principal;
                }
                x500Principal = this.subjectValue;
            }
            return x500Principal;
        }
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = y().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    public final X509CertificateInternal y() throws IOException {
        byte[] bArrV;
        X509CertificateEncodingException x509CertificateEncodingException;
        X509CertificateInternal x509CertificateInternal;
        synchronized (this.cacheLock) {
            X509CertificateInternal x509CertificateInternal2 = this.internalCertificateValue;
            if (x509CertificateInternal2 != null) {
                return x509CertificateInternal2;
            }
            try {
                x509CertificateEncodingException = null;
                bArrV = this.f45075c.v(gm.j.f29713a);
            } catch (IOException e10) {
                bArrV = null;
                x509CertificateEncodingException = new X509CertificateEncodingException(e10);
            }
            X509CertificateInternal x509CertificateInternal3 = new X509CertificateInternal(this.bcHelper, this.f45075c, this.basicConstraints, this.keyUsage, this.sigAlgName, this.sigAlgParams, bArrV, x509CertificateEncodingException);
            synchronized (this.cacheLock) {
                if (this.internalCertificateValue == null) {
                    this.internalCertificateValue = x509CertificateInternal3;
                }
                x509CertificateInternal = this.internalCertificateValue;
            }
            return x509CertificateInternal;
        }
    }

    public long[] z() {
        long[] jArr;
        synchronized (this.cacheLock) {
            long[] jArr2 = this.validityValues;
            if (jArr2 != null) {
                return jArr2;
            }
            long[] jArr3 = {super.getNotBefore().getTime(), super.getNotAfter().getTime()};
            synchronized (this.cacheLock) {
                if (this.validityValues == null) {
                    this.validityValues = jArr3;
                }
                jArr = this.validityValues;
            }
            return jArr;
        }
    }
}
