package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class f extends PKIXParameters {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f46097k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f46098l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f46099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.util.q f46100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f46101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f46102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f46103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f46104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f46105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f46106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f46107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f46108j;

    public f(Set set) throws InvalidAlgorithmParameterException {
        super((Set<TrustAnchor>) set);
        this.f46107i = 0;
        this.f46108j = false;
        this.f46099a = new ArrayList();
        this.f46102d = new ArrayList();
        this.f46103e = new HashSet();
        this.f46104f = new HashSet();
        this.f46105g = new HashSet();
        this.f46106h = new HashSet();
    }

    public static f f(PKIXParameters pKIXParameters) {
        try {
            f fVar = new f(pKIXParameters.getTrustAnchors());
            fVar.r(pKIXParameters);
            return fVar;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public void a(org.bouncycastle.util.s sVar) {
        b(sVar);
    }

    public void b(org.bouncycastle.util.s sVar) {
        if (sVar != null) {
            this.f46102d.add(sVar);
        }
    }

    public void c(org.bouncycastle.util.s sVar) {
        if (sVar != null) {
            this.f46099a.add(sVar);
        }
    }

    @Override // java.security.cert.PKIXParameters, java.security.cert.CertPathParameters
    public Object clone() {
        try {
            f fVar = new f(getTrustAnchors());
            fVar.r(this);
            return fVar;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public List d() {
        return Collections.unmodifiableList(this.f46102d);
    }

    public Set e() {
        return Collections.unmodifiableSet(this.f46106h);
    }

    public Set g() {
        return Collections.unmodifiableSet(this.f46104f);
    }

    public Set h() {
        return Collections.unmodifiableSet(this.f46105g);
    }

    public List i() {
        return Collections.unmodifiableList(new ArrayList(this.f46099a));
    }

    public org.bouncycastle.util.q j() {
        org.bouncycastle.util.q qVar = this.f46100b;
        if (qVar != null) {
            return (org.bouncycastle.util.q) qVar.clone();
        }
        return null;
    }

    public Set k() {
        return Collections.unmodifiableSet(this.f46103e);
    }

    public int l() {
        return this.f46107i;
    }

    public boolean m() {
        return this.f46101c;
    }

    public boolean n() {
        return this.f46108j;
    }

    public void o(boolean z10) {
        this.f46101c = z10;
    }

    public void p(Set set) {
        if (set == null) {
            this.f46106h.clear();
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof g)) {
                throw new ClassCastException("All elements of set must be of type " + g.class.getName() + j3.b.f36044h);
            }
        }
        this.f46106h.clear();
        this.f46106h.addAll(set);
    }

    public void q(Set set) {
        if (set == null) {
            this.f46104f.clear();
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof String)) {
                throw new ClassCastException("All elements of set must be of type String.");
            }
        }
        this.f46104f.clear();
        this.f46104f.addAll(set);
    }

    public void r(PKIXParameters pKIXParameters) {
        setDate(pKIXParameters.getDate());
        setCertPathCheckers(pKIXParameters.getCertPathCheckers());
        setCertStores(pKIXParameters.getCertStores());
        setAnyPolicyInhibited(pKIXParameters.isAnyPolicyInhibited());
        setExplicitPolicyRequired(pKIXParameters.isExplicitPolicyRequired());
        setPolicyMappingInhibited(pKIXParameters.isPolicyMappingInhibited());
        setRevocationEnabled(pKIXParameters.isRevocationEnabled());
        setInitialPolicies(pKIXParameters.getInitialPolicies());
        setPolicyQualifiersRejected(pKIXParameters.getPolicyQualifiersRejected());
        setSigProvider(pKIXParameters.getSigProvider());
        setTargetCertConstraints(pKIXParameters.getTargetCertConstraints());
        try {
            setTrustAnchors(pKIXParameters.getTrustAnchors());
            if (pKIXParameters instanceof f) {
                f fVar = (f) pKIXParameters;
                this.f46107i = fVar.f46107i;
                this.f46108j = fVar.f46108j;
                this.f46101c = fVar.f46101c;
                org.bouncycastle.util.q qVar = fVar.f46100b;
                this.f46100b = qVar == null ? null : (org.bouncycastle.util.q) qVar.clone();
                this.f46099a = new ArrayList(fVar.f46099a);
                this.f46102d = new ArrayList(fVar.f46102d);
                this.f46103e = new HashSet(fVar.f46103e);
                this.f46105g = new HashSet(fVar.f46105g);
                this.f46104f = new HashSet(fVar.f46104f);
                this.f46106h = new HashSet(fVar.f46106h);
            }
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public void s(Set set) {
        if (set == null) {
            this.f46105g.clear();
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof String)) {
                throw new ClassCastException("All elements of set must be of type String.");
            }
        }
        this.f46105g.clear();
        this.f46105g.addAll(set);
    }

    @Override // java.security.cert.PKIXParameters
    public void setCertStores(List list) {
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                addCertStore((CertStore) it2.next());
            }
        }
    }

    @Override // java.security.cert.PKIXParameters
    public void setTargetCertConstraints(CertSelector certSelector) {
        super.setTargetCertConstraints(certSelector);
        this.f46100b = certSelector != null ? o.a((X509CertSelector) certSelector) : null;
    }

    public void t(List list) {
        if (list == null) {
            this.f46099a = new ArrayList();
            return;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof org.bouncycastle.util.s)) {
                throw new ClassCastException("All elements of list must be of type org.bouncycastle.util.Store.");
            }
        }
        this.f46099a = new ArrayList(list);
    }

    public void u(org.bouncycastle.util.q qVar) {
        this.f46100b = qVar != null ? (org.bouncycastle.util.q) qVar.clone() : null;
    }

    public void v(Set set) {
        if (set == null) {
            this.f46103e.clear();
            return;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof TrustAnchor)) {
                throw new ClassCastException("All elements of set must be of type " + TrustAnchor.class.getName() + j3.b.f36044h);
            }
        }
        this.f46103e.clear();
        this.f46103e.addAll(set);
    }

    public void w(boolean z10) {
        this.f46108j = z10;
    }

    public void x(int i10) {
        this.f46107i = i10;
    }
}
