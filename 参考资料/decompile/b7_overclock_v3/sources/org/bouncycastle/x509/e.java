package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class e extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f46095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Set f46096n;

    public e(Set set, org.bouncycastle.util.q qVar) throws InvalidAlgorithmParameterException {
        super(set);
        this.f46095m = 5;
        this.f46096n = Collections.EMPTY_SET;
        u(qVar);
    }

    public static f f(PKIXParameters pKIXParameters) {
        try {
            e eVar = new e(pKIXParameters.getTrustAnchors(), o.a((X509CertSelector) pKIXParameters.getTargetCertConstraints()));
            eVar.r(pKIXParameters);
            return eVar;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public int A() {
        return this.f46095m;
    }

    public void B(Set set) {
        if (set == null) {
            Set set2 = Collections.EMPTY_SET;
        } else {
            this.f46096n = new HashSet(set);
        }
    }

    public void C(int i10) {
        if (i10 < -1) {
            throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
        }
        this.f46095m = i10;
    }

    @Override // org.bouncycastle.x509.f, java.security.cert.PKIXParameters, java.security.cert.CertPathParameters
    public Object clone() {
        try {
            e eVar = new e(getTrustAnchors(), j());
            eVar.r(this);
            return eVar;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.x509.f
    public void r(PKIXParameters pKIXParameters) {
        super.r(pKIXParameters);
        if (pKIXParameters instanceof e) {
            e eVar = (e) pKIXParameters;
            this.f46095m = eVar.f46095m;
            this.f46096n = new HashSet(eVar.f46096n);
        }
        if (pKIXParameters instanceof PKIXBuilderParameters) {
            this.f46095m = ((PKIXBuilderParameters) pKIXParameters).getMaxPathLength();
        }
    }

    public Set y() {
        return Collections.unmodifiableSet(this.f46096n);
    }
}
