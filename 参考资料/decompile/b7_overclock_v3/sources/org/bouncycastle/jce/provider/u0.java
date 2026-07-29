package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes5.dex */
public class u0 extends org.bouncycastle.x509.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ot.a f45512a;

    @Override // org.bouncycastle.x509.t
    public Collection a(org.bouncycastle.util.q qVar) throws StoreException {
        Collection collectionX;
        if (!(qVar instanceof org.bouncycastle.x509.o)) {
            return Collections.EMPTY_SET;
        }
        org.bouncycastle.x509.o oVar = (org.bouncycastle.x509.o) qVar;
        HashSet hashSet = new HashSet();
        if (oVar.getBasicConstraints() > 0) {
            hashSet.addAll(this.f45512a.q(oVar));
            collectionX = c(oVar);
        } else if (oVar.getBasicConstraints() == -2) {
            collectionX = this.f45512a.x(oVar);
        } else {
            hashSet.addAll(this.f45512a.x(oVar));
            hashSet.addAll(this.f45512a.q(oVar));
            collectionX = c(oVar);
        }
        hashSet.addAll(collectionX);
        return hashSet;
    }

    @Override // org.bouncycastle.x509.t
    public void b(org.bouncycastle.x509.s sVar) {
        if (sVar instanceof org.bouncycastle.jce.i) {
            this.f45512a = new ot.a((org.bouncycastle.jce.i) sVar);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + org.bouncycastle.jce.i.class.getName() + j3.b.f36044h);
    }

    public final Collection c(org.bouncycastle.x509.o oVar) throws StoreException {
        HashSet hashSet = new HashSet();
        org.bouncycastle.x509.n nVar = new org.bouncycastle.x509.n();
        nVar.e(oVar);
        nVar.f(new org.bouncycastle.x509.o());
        HashSet<org.bouncycastle.x509.p> hashSet2 = new HashSet(this.f45512a.t(nVar));
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (org.bouncycastle.x509.p pVar : hashSet2) {
            if (pVar.b() != null) {
                hashSet3.add(pVar.b());
            }
            if (pVar.c() != null) {
                hashSet4.add(pVar.c());
            }
        }
        hashSet.addAll(hashSet3);
        hashSet.addAll(hashSet4);
        return hashSet;
    }
}
