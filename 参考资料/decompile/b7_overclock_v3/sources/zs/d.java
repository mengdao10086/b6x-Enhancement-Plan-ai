package zs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import np.w1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.s;
import org.bouncycastle.pqc.jcajce.provider.qtesla.BCqTESLAPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.qtesla.BCqTESLAPublicKey;
import os.g;
import os.h;
import zo.w;

/* JADX INFO: loaded from: classes6.dex */
public class d extends Signature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f59721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f59722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f59723c;

    public static class a extends d {
        public a() {
            super(g.a(5), new w(), new h());
        }
    }

    public static class b extends d {
        public b() {
            super(g.a(6), new w(), new h());
        }
    }

    public static class c extends d {
        public c() {
            super("qTESLA", new w(), new h());
        }
    }

    public d(String str) {
        super(str);
    }

    public d(String str, s sVar, h hVar) {
        super(str);
        this.f59721a = sVar;
        this.f59722b = hVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCqTESLAPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to qTESLA");
        }
        k kVarA = ((BCqTESLAPrivateKey) privateKey).a();
        SecureRandom secureRandom = this.f59723c;
        if (secureRandom != null) {
            kVarA = new w1(kVarA, secureRandom);
        }
        this.f59722b.a(true, kVarA);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f59723c = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCqTESLAPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to qTESLA");
        }
        k kVarA = ((BCqTESLAPublicKey) publicKey).a();
        this.f59721a.reset();
        this.f59722b.a(false, kVarA);
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
        try {
            return this.f59722b.b(zs.a.b(this.f59721a));
        } catch (Exception e10) {
            if (e10 instanceof IllegalStateException) {
                throw new SignatureException(e10.getMessage());
            }
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f59721a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f59721a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f59722b.d(zs.a.b(this.f59721a), bArr);
    }
}
