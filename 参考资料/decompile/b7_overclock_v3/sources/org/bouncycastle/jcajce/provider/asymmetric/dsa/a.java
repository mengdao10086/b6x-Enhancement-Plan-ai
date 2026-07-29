package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import fp.n;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import np.y;
import np.z;
import zo.e0;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f44892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44893c = 2048;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f44894d;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        n nVar = this.f44893c <= 1024 ? new n() : new n(new e0());
        if (this.f44892b == null) {
            this.f44892b = org.bouncycastle.crypto.n.f();
        }
        int iA = org.bouncycastle.jcajce.provider.asymmetric.util.n.a(this.f44893c);
        int i10 = this.f44893c;
        if (i10 == 1024) {
            y yVar = new y(1024, 160, iA, this.f44892b);
            this.f44894d = yVar;
            nVar.l(yVar);
        } else if (i10 > 1024) {
            y yVar2 = new y(i10, 256, iA, this.f44892b);
            this.f44894d = yVar2;
            nVar.l(yVar2);
        } else {
            nVar.k(i10, iA, this.f44892b);
        }
        z zVarD = nVar.d();
        try {
            AlgorithmParameters algorithmParametersA = a("DSA");
            algorithmParametersA.init(new DSAParameterSpec(zVarD.b(), zVarD.c(), zVarD.a()));
            return algorithmParametersA;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        if (i10 < 512 || i10 > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        }
        if (i10 <= 1024 && i10 % 64 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        }
        if (i10 > 1024 && i10 % 1024 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        }
        this.f44893c = i10;
        this.f44892b = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
