package org.bouncycastle.jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;

/* JADX INFO: loaded from: classes5.dex */
public class e0 implements jq.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PKIXCertPathChecker f45439a;

    public e0(PKIXCertPathChecker pKIXCertPathChecker) {
        this.f45439a = pKIXCertPathChecker;
    }

    @Override // jq.f
    public void a(String str, Object obj) {
    }

    @Override // jq.f
    public void b(jq.g gVar) throws CertPathValidatorException {
        this.f45439a.init(false);
    }

    @Override // jq.f
    public void check(Certificate certificate) throws CertPathValidatorException {
        this.f45439a.check(certificate);
    }
}
