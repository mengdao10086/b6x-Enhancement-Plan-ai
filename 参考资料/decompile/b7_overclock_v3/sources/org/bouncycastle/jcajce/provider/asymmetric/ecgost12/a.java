package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import np.j0;
import np.w1;
import org.bouncycastle.crypto.p;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.s;
import rp.h;
import zn.c1;
import zn.z1;
import zo.j;

/* JADX INFO: loaded from: classes7.dex */
public class a extends SignatureSpi implements s, z1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45003c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45004d = 64 / 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f45001a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f45002b = new h();

    public static np.c a(PublicKey publicKey) throws InvalidKeyException {
        return publicKey instanceof BCECGOST3410_2012PublicKey ? ((BCECGOST3410_2012PublicKey) publicKey).d() : i.d(publicKey);
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
        if (!(privateKey instanceof er.b)) {
            throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
        }
        j0 j0Var = (j0) i.c(privateKey);
        if (j0Var.d().e().bitLength() > 256) {
            throw new InvalidKeyException("key out of range for ECGOST-2012-256");
        }
        this.f45001a.reset();
        SecureRandom secureRandom = ((SignatureSpi) this).appRandom;
        if (secureRandom != null) {
            this.f45002b.a(true, new w1(j0Var, secureRandom));
        } else {
            this.f45002b.a(true, j0Var);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        j0 j0Var;
        if (publicKey instanceof ECPublicKey) {
            j0Var = (j0) a(publicKey);
        } else {
            try {
                j0Var = (j0) i.d(BouncyCastleProvider.p(c1.A(publicKey.getEncoded())));
            } catch (Exception unused) {
                throw new InvalidKeyException("cannot recognise key type in ECGOST-2012-256 signer");
            }
        }
        if (j0Var.d().e().bitLength() > 256) {
            throw new InvalidKeyException("key out of range for ECGOST-2012-256");
        }
        this.f45001a.reset();
        this.f45002b.a(false, j0Var);
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
        byte[] bArr = new byte[this.f45001a.h()];
        this.f45001a.c(bArr, 0);
        try {
            byte[] bArr2 = new byte[this.f45003c];
            BigInteger[] bigIntegerArrB = this.f45002b.b(bArr);
            byte[] byteArray = bigIntegerArrB[0].toByteArray();
            byte[] byteArray2 = bigIntegerArrB[1].toByteArray();
            if (byteArray2[0] != 0) {
                System.arraycopy(byteArray2, 0, bArr2, this.f45004d - byteArray2.length, byteArray2.length);
            } else {
                System.arraycopy(byteArray2, 1, bArr2, this.f45004d - (byteArray2.length - 1), byteArray2.length - 1);
            }
            if (byteArray[0] != 0) {
                System.arraycopy(byteArray, 0, bArr2, this.f45003c - byteArray.length, byteArray.length);
            } else {
                System.arraycopy(byteArray, 1, bArr2, this.f45003c - (byteArray.length - 1), byteArray.length - 1);
            }
            return bArr2;
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f45001a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f45001a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f45001a.h()];
        this.f45001a.c(bArr2, 0);
        try {
            int i10 = this.f45004d;
            byte[] bArr3 = new byte[i10];
            byte[] bArr4 = new byte[i10];
            System.arraycopy(bArr, 0, bArr4, 0, i10);
            int i11 = this.f45004d;
            System.arraycopy(bArr, i11, bArr3, 0, i11);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f45002b.c(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
