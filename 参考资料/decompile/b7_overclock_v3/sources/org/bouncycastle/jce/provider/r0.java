package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes5.dex */
public class r0 extends org.bouncycastle.x509.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ot.a f45502a;

    @Override // org.bouncycastle.x509.t
    public Collection a(org.bouncycastle.util.q qVar) throws StoreException {
        if (!(qVar instanceof org.bouncycastle.x509.k)) {
            return Collections.EMPTY_SET;
        }
        org.bouncycastle.x509.k kVar = (org.bouncycastle.x509.k) qVar;
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f45502a.k(kVar));
        hashSet.addAll(this.f45502a.m(kVar));
        hashSet.addAll(this.f45502a.o(kVar));
        return hashSet;
    }

    @Override // org.bouncycastle.x509.t
    public void b(org.bouncycastle.x509.s sVar) {
        if (sVar instanceof org.bouncycastle.jce.i) {
            this.f45502a = new ot.a((org.bouncycastle.jce.i) sVar);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + org.bouncycastle.jce.i.class.getName() + j3.b.f36044h);
    }
}
