package org.bouncycastle.est;

import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.util.s<X509CertificateHolder> f44842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f44843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f44844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f44845d;

    public p(org.bouncycastle.util.s<X509CertificateHolder> sVar, long j10, j jVar, s sVar2) {
        this.f44842a = sVar;
        this.f44843b = j10;
        this.f44844c = jVar;
        this.f44845d = sVar2;
    }

    public boolean a() {
        return this.f44843b < System.currentTimeMillis();
    }

    public long b() {
        return this.f44843b;
    }

    public j c() {
        return this.f44844c;
    }

    public Object d() {
        return this.f44845d.d();
    }

    public s e() {
        return this.f44845d;
    }

    public org.bouncycastle.util.s<X509CertificateHolder> f() {
        return this.f44842a;
    }

    public boolean g() {
        return this.f44844c == null;
    }
}
