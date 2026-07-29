package org.bouncycastle.jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class y implements jq.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jq.g f45522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f45523c = null;

    public y(org.bouncycastle.jcajce.util.d dVar) {
        this.f45521a = dVar;
    }

    @Override // jq.f
    public void a(String str, Object obj) {
    }

    @Override // jq.f
    public void b(jq.g gVar) {
        this.f45522b = gVar;
        this.f45523c = new Date();
    }

    public void c(boolean z10) throws CertPathValidatorException {
        if (z10) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.f45522b = null;
        this.f45523c = new Date();
    }

    @Override // jq.f
    public void check(Certificate certificate) throws CertPathValidatorException {
        try {
            jq.g gVar = this.f45522b;
            b0.b(gVar, gVar.c(), this.f45523c, this.f45522b.e(), (X509Certificate) certificate, this.f45522b.d(), this.f45522b.f(), this.f45522b.a().getCertificates(), this.f45521a);
        } catch (AnnotatedException e10) {
            throw new CertPathValidatorException(e10.getMessage(), e10.getCause() != null ? e10.getCause() : e10, this.f45522b.a(), this.f45522b.b());
        }
    }
}
