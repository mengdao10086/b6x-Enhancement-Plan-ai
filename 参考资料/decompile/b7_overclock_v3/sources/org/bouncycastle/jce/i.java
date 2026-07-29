package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.security.cert.LDAPCertStoreParameters;
import org.bouncycastle.x509.s;

/* JADX INFO: loaded from: classes5.dex */
public class i implements s, CertStoreParameters {
    public String A;
    public String B;
    public String C;
    public String C1;
    public String D;
    public String K0;
    public String K1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f45273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f45274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f45276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f45277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f45278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f45279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f45280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f45281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f45282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f45283k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f45284k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public String f45285k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f45286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f45287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f45288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f45289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f45290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f45291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f45292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f45293s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f45294t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f45295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f45296v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public String f45297v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f45298w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f45299x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f45300y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f45301z;

    public static class b {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String H;
        public String I;
        public String J;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f45302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f45303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f45304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f45305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f45306e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f45307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f45308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f45309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f45310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f45311j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f45312k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f45313l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f45314m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f45315n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f45316o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f45317p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f45318q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f45319r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f45320s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f45321t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f45322u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f45323v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f45324w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f45325x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f45326y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f45327z;

        public b() {
            this("ldap://localhost:389", "");
        }

        public b(String str, String str2) {
            this.f45302a = str;
            if (str2 == null) {
                this.f45303b = "";
            } else {
                this.f45303b = str2;
            }
            this.f45304c = "userCertificate";
            this.f45305d = "cACertificate";
            this.f45306e = "crossCertificatePair";
            this.f45307f = "certificateRevocationList";
            this.f45308g = "deltaRevocationList";
            this.f45309h = "authorityRevocationList";
            this.f45310i = "attributeCertificateAttribute";
            this.f45311j = "aACertificate";
            this.f45312k = "attributeDescriptorCertificate";
            this.f45313l = "attributeCertificateRevocationList";
            this.f45314m = "attributeAuthorityRevocationList";
            this.f45315n = "cn";
            this.f45316o = "cn ou o";
            this.f45317p = "cn ou o";
            this.f45318q = "cn ou o";
            this.f45319r = "cn ou o";
            this.f45320s = "cn ou o";
            this.f45321t = "cn";
            this.f45322u = "cn o ou";
            this.f45323v = "cn o ou";
            this.f45324w = "cn o ou";
            this.f45325x = "cn o ou";
            this.f45326y = "cn";
            this.f45327z = "o ou";
            this.A = "o ou";
            this.B = "o ou";
            this.C = "o ou";
            this.D = "o ou";
            this.E = "cn";
            this.F = "o ou";
            this.G = "o ou";
            this.H = "o ou";
            this.I = "o ou";
            this.J = "uid serialNumber cn";
        }

        public i K() {
            if (this.f45315n == null || this.f45316o == null || this.f45317p == null || this.f45318q == null || this.f45319r == null || this.f45320s == null || this.f45321t == null || this.f45322u == null || this.f45323v == null || this.f45324w == null || this.f45325x == null || this.f45326y == null || this.f45327z == null || this.A == null || this.B == null || this.C == null || this.D == null || this.E == null || this.F == null || this.G == null || this.H == null || this.I == null) {
                throw new IllegalArgumentException("Necessary parameters not specified.");
            }
            return new i(this);
        }

        public b L(String str) {
            this.f45311j = str;
            return this;
        }

        public b M(String str) {
            this.F = str;
            return this;
        }

        public b N(String str) {
            this.f45314m = str;
            return this;
        }

        public b O(String str) {
            this.I = str;
            return this;
        }

        public b P(String str) {
            this.f45310i = str;
            return this;
        }

        public b Q(String str) {
            this.E = str;
            return this;
        }

        public b R(String str) {
            this.f45313l = str;
            return this;
        }

        public b S(String str) {
            this.H = str;
            return this;
        }

        public b T(String str) {
            this.f45312k = str;
            return this;
        }

        public b U(String str) {
            this.G = str;
            return this;
        }

        public b V(String str) {
            this.f45309h = str;
            return this;
        }

        public b W(String str) {
            this.D = str;
            return this;
        }

        public b X(String str) {
            this.f45305d = str;
            return this;
        }

        public b Y(String str) {
            this.f45327z = str;
            return this;
        }

        public b Z(String str) {
            this.f45307f = str;
            return this;
        }

        public b a0(String str) {
            this.B = str;
            return this;
        }

        public b b0(String str) {
            this.f45306e = str;
            return this;
        }

        public b c0(String str) {
            this.A = str;
            return this;
        }

        public b d0(String str) {
            this.f45308g = str;
            return this;
        }

        public b e0(String str) {
            this.C = str;
            return this;
        }

        public b f0(String str) {
            this.f45322u = str;
            return this;
        }

        public b g0(String str) {
            this.f45325x = str;
            return this;
        }

        public b h0(String str) {
            this.f45321t = str;
            return this;
        }

        public b i0(String str) {
            this.f45324w = str;
            return this;
        }

        public b j0(String str) {
            this.f45323v = str;
            return this;
        }

        public b k0(String str) {
            this.f45320s = str;
            return this;
        }

        public b l0(String str) {
            this.f45316o = str;
            return this;
        }

        public b m0(String str) {
            this.f45318q = str;
            return this;
        }

        public b n0(String str) {
            this.f45317p = str;
            return this;
        }

        public b o0(String str) {
            this.f45319r = str;
            return this;
        }

        public b p0(String str) {
            this.f45315n = str;
            return this;
        }

        public b q0(String str) {
            this.J = str;
            return this;
        }

        public b r0(String str) {
            this.f45304c = str;
            return this;
        }

        public b s0(String str) {
            this.f45326y = str;
            return this;
        }
    }

    public i(b bVar) {
        this.f45273a = bVar.f45302a;
        this.f45274b = bVar.f45303b;
        this.f45275c = bVar.f45304c;
        this.f45276d = bVar.f45305d;
        this.f45277e = bVar.f45306e;
        this.f45278f = bVar.f45307f;
        this.f45279g = bVar.f45308g;
        this.f45280h = bVar.f45309h;
        this.f45281i = bVar.f45310i;
        this.f45282j = bVar.f45311j;
        this.f45283k = bVar.f45312k;
        this.f45286l = bVar.f45313l;
        this.f45287m = bVar.f45314m;
        this.f45288n = bVar.f45315n;
        this.f45289o = bVar.f45316o;
        this.f45290p = bVar.f45317p;
        this.f45291q = bVar.f45318q;
        this.f45292r = bVar.f45319r;
        this.f45293s = bVar.f45320s;
        this.f45294t = bVar.f45321t;
        this.f45295u = bVar.f45322u;
        this.f45296v = bVar.f45323v;
        this.f45298w = bVar.f45324w;
        this.f45299x = bVar.f45325x;
        this.f45300y = bVar.f45326y;
        this.f45301z = bVar.f45327z;
        this.A = bVar.A;
        this.B = bVar.B;
        this.C = bVar.C;
        this.D = bVar.D;
        this.f45284k0 = bVar.E;
        this.K0 = bVar.F;
        this.f45285k1 = bVar.G;
        this.f45297v1 = bVar.H;
        this.C1 = bVar.I;
        this.K1 = bVar.J;
    }

    public static i y(LDAPCertStoreParameters lDAPCertStoreParameters) {
        return new b("ldap://" + lDAPCertStoreParameters.getServerName() + ":" + lDAPCertStoreParameters.getPort(), "").K();
    }

    public String A() {
        return this.f45295u;
    }

    public String B() {
        return this.f45299x;
    }

    public String C() {
        return this.f45294t;
    }

    public String D() {
        return this.f45298w;
    }

    public String E() {
        return this.f45296v;
    }

    public String F() {
        return this.f45293s;
    }

    public String G() {
        return this.f45289o;
    }

    public String H() {
        return this.f45291q;
    }

    public String I() {
        return this.f45290p;
    }

    public String J() {
        return this.f45292r;
    }

    public String K() {
        return this.f45273a;
    }

    public String L() {
        return this.f45288n;
    }

    public String N() {
        return this.K1;
    }

    public String O() {
        return this.f45275c;
    }

    public String P() {
        return this.f45300y;
    }

    public final int a(int i10, Object obj) {
        return (i10 * 29) + (obj == null ? 0 : obj.hashCode());
    }

    public final boolean b(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public boolean c(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return b(this.f45273a, iVar.f45273a) && b(this.f45274b, iVar.f45274b) && b(this.f45275c, iVar.f45275c) && b(this.f45276d, iVar.f45276d) && b(this.f45277e, iVar.f45277e) && b(this.f45278f, iVar.f45278f) && b(this.f45279g, iVar.f45279g) && b(this.f45280h, iVar.f45280h) && b(this.f45281i, iVar.f45281i) && b(this.f45282j, iVar.f45282j) && b(this.f45283k, iVar.f45283k) && b(this.f45286l, iVar.f45286l) && b(this.f45287m, iVar.f45287m) && b(this.f45288n, iVar.f45288n) && b(this.f45289o, iVar.f45289o) && b(this.f45290p, iVar.f45290p) && b(this.f45291q, iVar.f45291q) && b(this.f45292r, iVar.f45292r) && b(this.f45293s, iVar.f45293s) && b(this.f45294t, iVar.f45294t) && b(this.f45295u, iVar.f45295u) && b(this.f45296v, iVar.f45296v) && b(this.f45298w, iVar.f45298w) && b(this.f45299x, iVar.f45299x) && b(this.f45300y, iVar.f45300y) && b(this.f45301z, iVar.f45301z) && b(this.A, iVar.A) && b(this.B, iVar.B) && b(this.C, iVar.C) && b(this.D, iVar.D) && b(this.f45284k0, iVar.f45284k0) && b(this.K0, iVar.K0) && b(this.f45285k1, iVar.f45285k1) && b(this.f45297v1, iVar.f45297v1) && b(this.C1, iVar.C1) && b(this.K1, iVar.K1);
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        return this;
    }

    public String d() {
        return this.f45282j;
    }

    public String e() {
        return this.K0;
    }

    public String f() {
        return this.f45287m;
    }

    public String g() {
        return this.C1;
    }

    public String h() {
        return this.f45281i;
    }

    public int hashCode() {
        return a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(0, this.f45275c), this.f45276d), this.f45277e), this.f45278f), this.f45279g), this.f45280h), this.f45281i), this.f45282j), this.f45283k), this.f45286l), this.f45287m), this.f45288n), this.f45289o), this.f45290p), this.f45291q), this.f45292r), this.f45293s), this.f45294t), this.f45295u), this.f45296v), this.f45298w), this.f45299x), this.f45300y), this.f45301z), this.A), this.B), this.C), this.D), this.f45284k0), this.K0), this.f45285k1), this.f45297v1), this.C1), this.K1);
    }

    public String i() {
        return this.f45284k0;
    }

    public String j() {
        return this.f45286l;
    }

    public String k() {
        return this.f45297v1;
    }

    public String l() {
        return this.f45283k;
    }

    public String m() {
        return this.f45285k1;
    }

    public String n() {
        return this.f45280h;
    }

    public String o() {
        return this.D;
    }

    public String p() {
        return this.f45274b;
    }

    public String q() {
        return this.f45276d;
    }

    public String r() {
        return this.f45301z;
    }

    public String s() {
        return this.f45278f;
    }

    public String t() {
        return this.B;
    }

    public String u() {
        return this.f45277e;
    }

    public String v() {
        return this.A;
    }

    public String w() {
        return this.f45279g;
    }

    public String x() {
        return this.C;
    }
}
