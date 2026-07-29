package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jq.k;

/* JADX INFO: loaded from: classes5.dex */
public class p extends CertPathValidatorSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45497a = new org.bouncycastle.jcajce.util.b();

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        jq.k kVarQ;
        boolean z10 = certPathParameters instanceof org.bouncycastle.x509.f;
        if (!z10 && !(certPathParameters instanceof jq.k)) {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + org.bouncycastle.x509.f.class.getName() + " instance.");
        }
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        Set hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        if (certPathParameters instanceof PKIXParameters) {
            k.b bVar = new k.b((PKIXParameters) certPathParameters);
            if (z10) {
                org.bouncycastle.x509.f fVar = (org.bouncycastle.x509.f) certPathParameters;
                bVar.v(fVar.n());
                bVar.w(fVar.l());
                hashSet = fVar.e();
                hashSet2 = fVar.h();
                hashSet3 = fVar.g();
            }
            kVarQ = bVar.q();
        } else {
            kVarQ = (jq.k) certPathParameters;
        }
        jq.k kVar = kVarQ;
        Date date = new Date();
        Date dateT = e.t(kVar, date);
        org.bouncycastle.util.q qVarU = kVar.u();
        if (!(qVarU instanceof org.bouncycastle.x509.k)) {
            throw new InvalidAlgorithmParameterException("TargetConstraints must be an instance of " + org.bouncycastle.x509.k.class.getName() + " for " + getClass().getName() + " class.");
        }
        org.bouncycastle.x509.l lVarF = ((org.bouncycastle.x509.k) qVarU).f();
        CertPath certPathD = c0.d(lVarF, kVar);
        CertPathValidatorResult certPathValidatorResultE = c0.e(certPath, kVar);
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(0);
        c0.f(x509Certificate, kVar);
        c0.g(x509Certificate, hashSet4);
        c0.h(lVarF, dateT);
        c0.i(lVarF, certPath, certPathD, kVar, hashSet);
        c0.a(lVarF, hashSet2, hashSet3);
        c0.c(lVarF, kVar, date, dateT, x509Certificate, certPath.getCertificates(), this.f45497a);
        return certPathValidatorResultE;
    }
}
