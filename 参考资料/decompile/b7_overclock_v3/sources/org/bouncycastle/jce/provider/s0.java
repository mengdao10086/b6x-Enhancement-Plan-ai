package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes5.dex */
public class s0 extends org.bouncycastle.x509.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ot.a f45506a;

    @Override // org.bouncycastle.x509.t
    public Collection a(org.bouncycastle.util.q qVar) throws StoreException {
        Collection collectionS;
        if (!(qVar instanceof org.bouncycastle.x509.m)) {
            return Collections.EMPTY_SET;
        }
        org.bouncycastle.x509.m mVar = (org.bouncycastle.x509.m) qVar;
        HashSet hashSet = new HashSet();
        if (mVar.f()) {
            collectionS = this.f45506a.u(mVar);
        } else {
            hashSet.addAll(this.f45506a.u(mVar));
            hashSet.addAll(this.f45506a.l(mVar));
            hashSet.addAll(this.f45506a.n(mVar));
            hashSet.addAll(this.f45506a.p(mVar));
            collectionS = this.f45506a.s(mVar);
        }
        hashSet.addAll(collectionS);
        return hashSet;
    }

    @Override // org.bouncycastle.x509.t
    public void b(org.bouncycastle.x509.s sVar) {
        if (sVar instanceof org.bouncycastle.jce.i) {
            this.f45506a = new ot.a((org.bouncycastle.jce.i) sVar);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + org.bouncycastle.jce.i.class.getName() + j3.b.f36044h);
    }
}
