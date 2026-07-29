package at;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import np.w1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.s;
import ps.h;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.h0;

/* JADX INFO: loaded from: classes6.dex */
public class d extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f8884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f8885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f8886c;

    public static class a extends d {
        public a() {
            super(new d0(), new h());
        }
    }

    public static class b extends d {
        public b() {
            super(new e0(), new h());
        }
    }

    public static class c extends d {
        public c() {
            super(new f0(), new h());
        }
    }

    /* JADX INFO: renamed from: at.d$d, reason: collision with other inner class name */
    public static class C0092d extends d {
        public C0092d() {
            super(new h0(), new h());
        }
    }

    public d(s sVar, h hVar) {
        this.f8884a = sVar;
        this.f8885b = hVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        k kVarA = at.c.a(privateKey);
        SecureRandom secureRandom = this.f8886c;
        if (secureRandom != null) {
            kVarA = new w1(kVarA, secureRandom);
        }
        this.f8884a.reset();
        this.f8885b.a(true, kVarA);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f8886c = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        np.c cVarB = at.c.b(publicKey);
        this.f8884a.reset();
        this.f8885b.a(false, cVarB);
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
        byte[] bArr = new byte[this.f8884a.h()];
        this.f8884a.c(bArr, 0);
        try {
            return this.f8885b.b(bArr);
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f8884a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f8884a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f8884a.h()];
        this.f8884a.c(bArr2, 0);
        return this.f8885b.d(bArr2, bArr);
    }
}
