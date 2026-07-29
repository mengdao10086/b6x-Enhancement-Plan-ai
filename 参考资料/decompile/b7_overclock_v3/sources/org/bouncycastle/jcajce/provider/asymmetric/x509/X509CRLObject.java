package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.h;
import gm.j;
import java.io.IOException;
import java.security.cert.CRLException;
import zn.i0;
import zn.p;
import zn.y;

/* JADX INFO: loaded from: classes7.dex */
public class X509CRLObject extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f45071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f45072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f45073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f45074i;

    public static class X509CRLException extends CRLException {
        private final Throwable cause;

        public X509CRLException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        public X509CRLException(Throwable th2) {
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public X509CRLObject(org.bouncycastle.jcajce.util.d dVar, p pVar) throws CRLException {
        super(dVar, pVar, h(pVar), j(pVar), n(pVar));
        this.f45071f = new Object();
    }

    public static String h(p pVar) throws CRLException {
        try {
            return g.c(pVar.E());
        } catch (Exception e10) {
            throw new X509CRLException("CRL contents invalid: " + e10.getMessage(), e10);
        }
    }

    public static byte[] j(p pVar) throws CRLException {
        try {
            h hVarA = pVar.E().A();
            if (hVarA == null) {
                return null;
            }
            return hVarA.b().v(j.f29713a);
        } catch (Exception e10) {
            throw new CRLException("CRL contents invalid: " + e10);
        }
    }

    public static boolean n(p pVar) throws CRLException {
        try {
            byte[] bArrE = e.e(pVar, y.f59071p.L());
            if (bArrE == null) {
                return false;
            }
            return i0.B(bArrE).D();
        } catch (Exception e10) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e10);
        }
    }

    @Override // java.security.cert.X509CRL
    public boolean equals(Object obj) throws IOException {
        f fVarL;
        gm.d dVarD;
        if (this == obj) {
            return true;
        }
        if (obj instanceof X509CRLObject) {
            X509CRLObject x509CRLObject = (X509CRLObject) obj;
            if (this.f45073h && x509CRLObject.f45073h) {
                if (this.f45074i != x509CRLObject.f45074i) {
                    return false;
                }
            } else if ((this.f45072g == null || x509CRLObject.f45072g == null) && (dVarD = this.f45090b.D()) != null && !dVarD.C(x509CRLObject.f45090b.D())) {
                return false;
            }
            fVarL = l();
            obj = x509CRLObject.l();
        } else {
            fVarL = l();
        }
        return fVarL.equals(obj);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        return org.bouncycastle.util.a.p(l().getEncoded());
    }

    @Override // java.security.cert.X509CRL
    public int hashCode() {
        if (!this.f45073h) {
            this.f45074i = l().hashCode();
            this.f45073h = true;
        }
        return this.f45074i;
    }

    public final f l() throws IOException {
        byte[] bArrV;
        X509CRLException x509CRLException;
        f fVar;
        synchronized (this.f45071f) {
            f fVar2 = this.f45072g;
            if (fVar2 != null) {
                return fVar2;
            }
            try {
                x509CRLException = null;
                bArrV = this.f45090b.v(j.f29713a);
            } catch (IOException e10) {
                bArrV = null;
                x509CRLException = new X509CRLException(e10);
            }
            f fVar3 = new f(this.f45089a, this.f45090b, this.f45091c, this.f45092d, this.f45093e, bArrV, x509CRLException);
            synchronized (this.f45071f) {
                if (this.f45072g == null) {
                    this.f45072g = fVar3;
                }
                fVar = this.f45072g;
            }
            return fVar;
        }
    }
}
