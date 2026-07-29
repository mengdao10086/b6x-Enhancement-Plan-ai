package ar;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends AlgorithmParameterGeneratorSpi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f8855b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f8854a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8856c = 1024;

    public final AlgorithmParameters a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f8854a.t(str);
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        this.f8856c = i10;
        this.f8855b = secureRandom;
    }
}
