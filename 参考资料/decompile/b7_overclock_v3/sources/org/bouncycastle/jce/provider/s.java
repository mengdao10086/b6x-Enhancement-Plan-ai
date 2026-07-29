package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import jq.j;
import jq.k;

/* JADX INFO: loaded from: classes5.dex */
public class s extends CertPathBuilderSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f45504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Exception f45505c;

    public s() {
        this(false);
    }

    public s(boolean z10) {
        this.f45503a = new org.bouncycastle.jcajce.util.b();
        this.f45504b = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.security.cert.CertPathBuilderResult a(java.security.cert.X509Certificate r6, jq.j r7, java.util.List r8) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.s.a(java.security.cert.X509Certificate, jq.j, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new a0(this.f45503a);
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        jq.j jVarE;
        Exception exc;
        j.b bVar;
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            k.b bVar2 = new k.b(pKIXBuilderParameters);
            if (certPathParameters instanceof org.bouncycastle.x509.f) {
                org.bouncycastle.x509.e eVar = (org.bouncycastle.x509.e) certPathParameters;
                Iterator it2 = eVar.d().iterator();
                while (it2.hasNext()) {
                    bVar2.n((jq.h) it2.next());
                }
                bVar = new j.b(bVar2.q());
                bVar.d(eVar.y());
                bVar.f(eVar.A());
            } else {
                bVar = new j.b(pKIXBuilderParameters);
            }
            jVarE = bVar.e();
        } else {
            if (!(certPathParameters instanceof jq.j)) {
                throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + jq.j.class.getName() + j3.b.f36044h);
            }
            jVarE = (jq.j) certPathParameters;
        }
        ArrayList arrayList = new ArrayList();
        CertPathBuilderResult certPathBuilderResultA = null;
        Iterator it3 = e.d(jVarE).iterator();
        while (it3.hasNext() && certPathBuilderResultA == null) {
            certPathBuilderResultA = a((X509Certificate) it3.next(), jVarE, arrayList);
        }
        if (certPathBuilderResultA == null && (exc = this.f45505c) != null) {
            if (exc instanceof AnnotatedException) {
                throw new CertPathBuilderException(this.f45505c.getMessage(), this.f45505c.getCause());
            }
            throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.f45505c);
        }
        if (certPathBuilderResultA == null && this.f45505c == null) {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        }
        return certPathBuilderResultA;
    }
}
