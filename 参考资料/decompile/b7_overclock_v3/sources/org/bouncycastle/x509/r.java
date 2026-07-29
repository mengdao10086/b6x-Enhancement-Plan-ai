package org.bouncycastle.x509;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.x509.w;

/* JADX INFO: loaded from: classes6.dex */
public class r implements org.bouncycastle.util.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider f46141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f46142b;

    public r(Provider provider, t tVar) {
        this.f46141a = provider;
        this.f46142b = tVar;
    }

    public static r b(w.a aVar, s sVar) {
        t tVar = (t) aVar.a();
        tVar.b(sVar);
        return new r(aVar.b(), tVar);
    }

    public static r c(String str, s sVar) throws NoSuchStoreException {
        try {
            return b(w.g("X509Store", str), sVar);
        } catch (NoSuchAlgorithmException e10) {
            throw new NoSuchStoreException(e10.getMessage());
        }
    }

    public static r d(String str, s sVar, String str2) throws NoSuchStoreException, NoSuchProviderException {
        return e(str, sVar, w.i(str2));
    }

    public static r e(String str, s sVar, Provider provider) throws NoSuchStoreException {
        try {
            return b(w.h("X509Store", str, provider), sVar);
        } catch (NoSuchAlgorithmException e10) {
            throw new NoSuchStoreException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.util.s
    public Collection a(org.bouncycastle.util.q qVar) {
        return this.f46142b.a(qVar);
    }

    public Provider f() {
        return this.f46141a;
    }
}
