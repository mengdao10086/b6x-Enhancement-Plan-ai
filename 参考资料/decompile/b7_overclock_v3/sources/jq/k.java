package jq;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.i;
import zn.b0;

/* JADX INFO: loaded from: classes7.dex */
public class k implements CertPathParameters {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36864m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36865n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PKIXParameters f36866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f36867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Date f36868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f36869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<h> f36870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<b0, h> f36871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f36872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<b0, d> f36873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f36874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f36875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f36876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<TrustAnchor> f36877l;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PKIXParameters f36878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Date f36879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Date f36880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f36881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<h> f36882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<b0, h> f36883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<d> f36884g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map<b0, d> f36885h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f36886i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f36887j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f36888k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Set<TrustAnchor> f36889l;

        public b(PKIXParameters pKIXParameters) {
            this.f36882e = new ArrayList();
            this.f36883f = new HashMap();
            this.f36884g = new ArrayList();
            this.f36885h = new HashMap();
            this.f36887j = 0;
            this.f36888k = false;
            this.f36878a = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.f36881d = new i.b(targetCertConstraints).a();
            }
            Date date = pKIXParameters.getDate();
            this.f36879b = date;
            this.f36880c = date == null ? new Date() : date;
            this.f36886i = pKIXParameters.isRevocationEnabled();
            this.f36889l = pKIXParameters.getTrustAnchors();
        }

        public b(k kVar) {
            this.f36882e = new ArrayList();
            this.f36883f = new HashMap();
            this.f36884g = new ArrayList();
            this.f36885h = new HashMap();
            this.f36887j = 0;
            this.f36888k = false;
            this.f36878a = kVar.f36866a;
            this.f36879b = kVar.f36868c;
            this.f36880c = kVar.f36869d;
            this.f36881d = kVar.f36867b;
            this.f36882e = new ArrayList(kVar.f36870e);
            this.f36883f = new HashMap(kVar.f36871f);
            this.f36884g = new ArrayList(kVar.f36872g);
            this.f36885h = new HashMap(kVar.f36873h);
            this.f36888k = kVar.f36875j;
            this.f36887j = kVar.f36876k;
            this.f36886i = kVar.C();
            this.f36889l = kVar.v();
        }

        public b m(d dVar) {
            this.f36884g.add(dVar);
            return this;
        }

        public b n(h hVar) {
            this.f36882e.add(hVar);
            return this;
        }

        public b o(b0 b0Var, d dVar) {
            this.f36885h.put(b0Var, dVar);
            return this;
        }

        public b p(b0 b0Var, h hVar) {
            this.f36883f.put(b0Var, hVar);
            return this;
        }

        public k q() {
            return new k(this);
        }

        public void r(boolean z10) {
            this.f36886i = z10;
        }

        public b s(i iVar) {
            this.f36881d = iVar;
            return this;
        }

        public b t(TrustAnchor trustAnchor) {
            this.f36889l = Collections.singleton(trustAnchor);
            return this;
        }

        public b u(Set<TrustAnchor> set) {
            this.f36889l = set;
            return this;
        }

        public b v(boolean z10) {
            this.f36888k = z10;
            return this;
        }

        public b w(int i10) {
            this.f36887j = i10;
            return this;
        }
    }

    public k(b bVar) {
        this.f36866a = bVar.f36878a;
        this.f36868c = bVar.f36879b;
        this.f36869d = bVar.f36880c;
        this.f36870e = Collections.unmodifiableList(bVar.f36882e);
        this.f36871f = Collections.unmodifiableMap(new HashMap(bVar.f36883f));
        this.f36872g = Collections.unmodifiableList(bVar.f36884g);
        this.f36873h = Collections.unmodifiableMap(new HashMap(bVar.f36885h));
        this.f36867b = bVar.f36881d;
        this.f36874i = bVar.f36886i;
        this.f36875j = bVar.f36888k;
        this.f36876k = bVar.f36887j;
        this.f36877l = Collections.unmodifiableSet(bVar.f36889l);
    }

    public boolean A() {
        return this.f36866a.isExplicitPolicyRequired();
    }

    public boolean B() {
        return this.f36866a.isPolicyMappingInhibited();
    }

    public boolean C() {
        return this.f36874i;
    }

    public boolean D() {
        return this.f36875j;
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }

    public List<d> k() {
        return this.f36872g;
    }

    public List l() {
        return this.f36866a.getCertPathCheckers();
    }

    public List<CertStore> m() {
        return this.f36866a.getCertStores();
    }

    public List<h> n() {
        return this.f36870e;
    }

    public Date o() {
        return new Date(this.f36869d.getTime());
    }

    public Set p() {
        return this.f36866a.getInitialPolicies();
    }

    public Map<b0, d> q() {
        return this.f36873h;
    }

    public Map<b0, h> r() {
        return this.f36871f;
    }

    public boolean s() {
        return this.f36866a.getPolicyQualifiersRejected();
    }

    public String t() {
        return this.f36866a.getSigProvider();
    }

    public i u() {
        return this.f36867b;
    }

    public Set v() {
        return this.f36877l;
    }

    public Date w() {
        if (this.f36868c == null) {
            return null;
        }
        return new Date(this.f36868c.getTime());
    }

    public int x() {
        return this.f36876k;
    }

    public boolean y() {
        return this.f36866a.isAnyPolicyInhibited();
    }
}
