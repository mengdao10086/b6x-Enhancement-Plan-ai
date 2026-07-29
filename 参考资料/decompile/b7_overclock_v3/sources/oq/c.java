package oq;

import gm.c0;
import gm.f2;
import gm.z;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.p;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import pn.s;
import rp.e;
import zn.z1;
import zo.h;

/* JADX INFO: loaded from: classes7.dex */
public class c extends SignatureSpi implements s, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f44394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f44395b = new e();

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = i10 * 2;
            bArr2[i11] = (byte) ((bArr[i10] >> 4) & 15);
            bArr2[i11 + 1] = (byte) (bArr[i10] & 15);
        }
        return bArr2;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    @Override // java.security.SignatureSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineInitSign(java.security.PrivateKey r5) throws java.security.InvalidKeyException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey
            if (r0 == 0) goto L18
            np.c r5 = org.bouncycastle.jcajce.provider.asymmetric.util.i.c(r5)
            zo.h r0 = new zo.h
            byte[] r1 = vn.d.y()
            byte[] r1 = r4.a(r1)
            r0.<init>(r1)
        L15:
            r4.f44394a = r0
            goto L2f
        L18:
            boolean r0 = r5 instanceof er.b
            if (r0 == 0) goto L2e
            np.c r5 = org.bouncycastle.jcajce.provider.asymmetric.util.i.c(r5)
            zo.h r0 = new zo.h
            byte[] r1 = vn.d.y()
            byte[] r1 = r4.a(r1)
            r0.<init>(r1)
            goto L15
        L2e:
            r5 = 0
        L2f:
            java.security.SecureRandom r0 = r4.appRandom
            r1 = 1
            if (r0 == 0) goto L3f
            org.bouncycastle.crypto.p r2 = r4.f44395b
            np.w1 r3 = new np.w1
            r3.<init>(r5, r0)
            r2.a(r1, r3)
            goto L44
        L3f:
            org.bouncycastle.crypto.p r0 = r4.f44395b
            r0.a(r1, r5)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: oq.c.engineInitSign(java.security.PrivateKey):void");
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        k kVarD;
        if (publicKey instanceof BCDSTU4145PublicKey) {
            BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) publicKey;
            kVarD = bCDSTU4145PublicKey.d();
            this.f44394a = new h(a(bCDSTU4145PublicKey.h()));
        } else {
            kVarD = i.d(publicKey);
            this.f44394a = new h(a(vn.d.y()));
        }
        this.f44395b.a(false, kVarD);
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
        byte[] bArr = new byte[this.f44394a.h()];
        this.f44394a.c(bArr, 0);
        try {
            BigInteger[] bigIntegerArrB = this.f44395b.b(bArr);
            byte[] byteArray = bigIntegerArrB[0].toByteArray();
            byte[] byteArray2 = bigIntegerArrB[1].toByteArray();
            int length = (byteArray.length > byteArray2.length ? byteArray.length : byteArray2.length) * 2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(byteArray2, 0, bArr2, (length / 2) - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr2, length - byteArray.length, byteArray.length);
            return new f2(bArr2).getEncoded();
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f44394a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f44394a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f44394a.h()];
        this.f44394a.c(bArr2, 0);
        try {
            byte[] bArrJ = ((z) c0.D(bArr)).J();
            byte[] bArr3 = new byte[bArrJ.length / 2];
            byte[] bArr4 = new byte[bArrJ.length / 2];
            System.arraycopy(bArrJ, 0, bArr4, 0, bArrJ.length / 2);
            System.arraycopy(bArrJ, bArrJ.length / 2, bArr3, 0, bArrJ.length / 2);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f44395b.c(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
