package jq;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jq.k;

/* JADX INFO: loaded from: classes7.dex */
public class j implements CertPathParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f36858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<X509Certificate> f36859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36860c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f36861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<X509Certificate> f36863c;

        public b(PKIXBuilderParameters pKIXBuilderParameters) {
            this.f36862b = 5;
            this.f36863c = new HashSet();
            this.f36861a = new k.b(pKIXBuilderParameters).q();
            this.f36862b = pKIXBuilderParameters.getMaxPathLength();
        }

        public b(k kVar) {
            this.f36862b = 5;
            this.f36863c = new HashSet();
            this.f36861a = kVar;
        }

        public b d(Set<X509Certificate> set) {
            this.f36863c.addAll(set);
            return this;
        }

        public j e() {
            return new j(this);
        }

        public b f(int i10) {
            if (i10 < -1) {
                throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
            }
            this.f36862b = i10;
            return this;
        }
    }

    public j(b bVar) {
        this.f36858a = bVar.f36861a;
        this.f36859b = Collections.unmodifiableSet(bVar.f36863c);
        this.f36860c = bVar.f36862b;
    }

    public k a() {
        return this.f36858a;
    }

    public Set b() {
        return this.f36859b;
    }

    public int c() {
        return this.f36860c;
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }
}
