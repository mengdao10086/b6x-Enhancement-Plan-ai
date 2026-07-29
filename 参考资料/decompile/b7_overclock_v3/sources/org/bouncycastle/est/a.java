package org.bouncycastle.est;

import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.util.s<X509CertificateHolder> f44775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.util.s<X509CRLHolder> f44776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f44777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f44778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f44779e;

    public a(org.bouncycastle.util.s<X509CertificateHolder> sVar, org.bouncycastle.util.s<X509CRLHolder> sVar2, j jVar, s sVar3, boolean z10) {
        this.f44775a = sVar;
        this.f44777c = jVar;
        this.f44778d = sVar3;
        this.f44779e = z10;
        this.f44776b = sVar2;
    }

    public org.bouncycastle.util.s<X509CertificateHolder> a() {
        org.bouncycastle.util.s<X509CertificateHolder> sVar = this.f44775a;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Response has no certificates.");
    }

    public org.bouncycastle.util.s<X509CRLHolder> b() {
        org.bouncycastle.util.s<X509CRLHolder> sVar = this.f44776b;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Response has no CRLs.");
    }

    public j c() {
        return this.f44777c;
    }

    public Object d() {
        return this.f44778d.d();
    }

    public boolean e() {
        return this.f44776b != null;
    }

    public boolean f() {
        return this.f44775a != null;
    }

    public boolean g() {
        return this.f44779e;
    }
}
