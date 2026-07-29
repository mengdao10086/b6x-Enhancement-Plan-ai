package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.p;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes7.dex */
public abstract class f extends SignatureSpi implements s, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f45053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f45054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rp.b f45055c;

    public f(org.bouncycastle.crypto.s sVar, p pVar, rp.b bVar) {
        this.f45053a = sVar;
        this.f45054b = pVar;
        this.f45055c = bVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f45053a.h()];
        this.f45053a.c(bArr, 0);
        try {
            BigInteger[] bigIntegerArrB = this.f45054b.b(bArr);
            return this.f45055c.b(this.f45054b.getOrder(), bigIntegerArrB[0], bigIntegerArrB[1]);
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f45053a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f45053a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f45053a.h()];
        this.f45053a.c(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrA = this.f45055c.a(this.f45054b.getOrder(), bArr);
            return this.f45054b.c(bArr2, bigIntegerArrA[0], bigIntegerArrA[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
