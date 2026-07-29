package org.bouncycastle.cms.jcajce;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f44583a = new c(new b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f44584b;

    public AlgorithmParameters a(zn.b bVar) throws CMSException {
        if (bVar.A() == null) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParametersC = this.f44583a.c(bVar.x());
            a.k(algorithmParametersC, bVar.A());
            return algorithmParametersC;
        } catch (NoSuchAlgorithmException e10) {
            throw new CMSException("can't find parameters for algorithm", e10);
        } catch (NoSuchProviderException e11) {
            throw new CMSException("can't find provider for algorithm", e11);
        }
    }

    public m b(String str) {
        this.f44583a = new c(new m0(str));
        return this;
    }

    public m c(Provider provider) {
        this.f44583a = new c(new n0(provider));
        return this;
    }
}
