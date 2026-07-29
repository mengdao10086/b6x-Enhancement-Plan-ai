package org.bouncycastle.jce.provider;

import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class q0 extends org.bouncycastle.x509.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.util.e f45499a;

    @Override // org.bouncycastle.x509.t
    public Collection a(org.bouncycastle.util.q qVar) {
        return this.f45499a.a(qVar);
    }

    @Override // org.bouncycastle.x509.t
    public void b(org.bouncycastle.x509.s sVar) {
        if (sVar instanceof org.bouncycastle.x509.q) {
            this.f45499a = new org.bouncycastle.util.e(((org.bouncycastle.x509.q) sVar).a());
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + org.bouncycastle.x509.q.class.getName() + j3.b.f36044h);
    }
}
