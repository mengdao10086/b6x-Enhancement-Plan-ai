package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import er.e;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import np.w1;
import org.bouncycastle.crypto.p;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jcajce.provider.asymmetric.util.j;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.s;
import rp.g;
import zn.c1;
import zn.z1;
import zo.h;

/* JADX INFO: loaded from: classes7.dex */
public class c extends SignatureSpi implements s, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f44986a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f44987b = new g();

    public static np.c a(PublicKey publicKey) throws InvalidKeyException {
        return publicKey instanceof BCECGOST3410PublicKey ? ((BCECGOST3410PublicKey) publicKey).d() : i.d(publicKey);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        np.c cVarC = privateKey instanceof er.b ? i.c(privateKey) : j.a(privateKey);
        this.f44986a.reset();
        SecureRandom secureRandom = ((SignatureSpi) this).appRandom;
        if (secureRandom != null) {
            this.f44987b.a(true, new w1(cVarC, secureRandom));
        } else {
            this.f44987b.a(true, cVarC);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        np.c cVarD;
        if (publicKey instanceof ECPublicKey) {
            cVarD = a(publicKey);
        } else if (publicKey instanceof e) {
            cVarD = j.b(publicKey);
        } else {
            try {
                cVarD = i.d(BouncyCastleProvider.p(c1.A(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("can't recognise key type in DSA based signer");
            }
        }
        this.f44986a.reset();
        this.f44987b.a(false, cVarD);
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
        byte[] bArr = new byte[this.f44986a.h()];
        this.f44986a.c(bArr, 0);
        try {
            byte[] bArr2 = new byte[64];
            BigInteger[] bigIntegerArrB = this.f44987b.b(bArr);
            byte[] byteArray = bigIntegerArrB[0].toByteArray();
            byte[] byteArray2 = bigIntegerArrB[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, 32 - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, 32 - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, 64 - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, 64 - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f44986a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f44986a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f44986a.h()];
        this.f44986a.c(bArr2, 0);
        try {
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 0, bArr4, 0, 32);
            System.arraycopy(bArr, 32, bArr3, 0, 32);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f44987b.c(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
