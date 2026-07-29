package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends AlgorithmParameterGeneratorSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45051a = new org.bouncycastle.jcajce.util.b();

    public final AlgorithmParameters a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f45051a.t(str);
    }
}
