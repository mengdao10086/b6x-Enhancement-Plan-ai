package jq;

import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.Date;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f36849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Date f36850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CertPath f36851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X509Certificate f36853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublicKey f36854f;

    public g(k kVar, Date date, CertPath certPath, int i10, X509Certificate x509Certificate, PublicKey publicKey) {
        this.f36849a = kVar;
        this.f36850b = date;
        this.f36851c = certPath;
        this.f36852d = i10;
        this.f36853e = x509Certificate;
        this.f36854f = publicKey;
    }

    public CertPath a() {
        return this.f36851c;
    }

    public int b() {
        return this.f36852d;
    }

    public k c() {
        return this.f36849a;
    }

    public X509Certificate d() {
        return this.f36853e;
    }

    public Date e() {
        return new Date(this.f36850b.getTime());
    }

    public PublicKey f() {
        return this.f36854f;
    }
}
