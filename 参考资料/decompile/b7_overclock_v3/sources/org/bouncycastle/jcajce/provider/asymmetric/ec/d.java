package org.bouncycastle.jcajce.provider.asymmetric.ec;

import cr.s;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import np.u1;
import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import rp.y;
import zo.e0;

/* JADX INFO: loaded from: classes7.dex */
public class d extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f44938a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlgorithmParameters f44939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f44940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f44941d;

    public static class a extends d {
        public a() {
            super(new y(new e0()));
        }
    }

    public static class b extends d {
        public b() {
            super(new y());
        }
    }

    public d(y yVar) {
        this.f44941d = yVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f44939b == null && this.f44940c != null) {
            try {
                AlgorithmParameters algorithmParametersT = this.f44938a.t("PSS");
                this.f44939b = algorithmParametersT;
                algorithmParametersT.init(this.f44940c);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f44939b;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        k kVarC = i.c(privateKey);
        SecureRandom secureRandom = ((SignatureSpi) this).appRandom;
        if (secureRandom != null) {
            kVarC = new w1(kVarC, secureRandom);
        }
        s sVar = this.f44940c;
        if (sVar != null) {
            this.f44941d.a(true, new u1(kVarC, sVar.a()));
        } else {
            this.f44941d.a(true, kVarC);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        k kVarA = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(publicKey);
        s sVar = this.f44940c;
        if (sVar != null) {
            kVarA = new u1(kVarA, sVar.a());
        }
        this.f44941d.a(false, kVarA);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof s)) {
            throw new InvalidAlgorithmParameterException("only SM2ParameterSpec supported");
        }
        this.f44940c = (s) algorithmParameterSpec;
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f44941d.e();
        } catch (CryptoException e10) {
            throw new SignatureException("unable to create signature: " + e10.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f44941d.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f44941d.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f44941d.d(bArr);
    }
}
