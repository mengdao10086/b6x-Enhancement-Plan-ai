package ws;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import js.f;
import org.bouncycastle.crypto.s;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.pqc.crypto.lms.n;
import org.bouncycastle.pqc.crypto.lms.o;
import org.bouncycastle.pqc.crypto.lms.p;
import org.bouncycastle.pqc.jcajce.provider.lms.BCLMSPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.lms.BCLMSPublicKey;
import zo.w;

/* JADX INFO: loaded from: classes6.dex */
public class d extends Signature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f54803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f54804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f54805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f54806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f54807e;

    public static class a extends d {
        public a() {
            super("LMS", new w());
        }
    }

    public d(String str) {
        super(str);
    }

    public d(String str, s sVar) {
        super(str);
        this.f54803a = sVar;
    }

    public final s a() throws SignatureException {
        try {
            return this.f54806d.W();
        } catch (ExhaustedPrivateKeyException e10) {
            throw new SignatureException(e10.getMessage(), e10);
        }
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCLMSPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to LMS");
        }
        o oVar = (o) ((BCLMSPrivateKey) privateKey).a();
        this.f54806d = oVar;
        if (oVar.V() == 0) {
            throw new InvalidKeyException("private key exhausted");
        }
        this.f54803a = null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f54805c = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCLMSPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to XMSS");
        }
        w wVar = new w();
        this.f54803a = wVar;
        wVar.reset();
        this.f54807e = (p) ((BCLMSPublicKey) publicKey).a();
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
        if (this.f54803a == null) {
            this.f54803a = a();
        }
        try {
            byte[] bArrX = this.f54806d.X((n) this.f54803a);
            this.f54803a = null;
            return bArrX;
        } catch (Exception e10) {
            if (e10 instanceof IllegalStateException) {
                throw new SignatureException(e10.getMessage(), e10);
            }
            throw new SignatureException(e10.toString(), e10);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        if (this.f54803a == null) {
            this.f54803a = a();
        }
        this.f54803a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        if (this.f54803a == null) {
            this.f54803a = a();
        }
        this.f54803a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        n nVarA = this.f54807e.a(bArr);
        byte[] bArrA = ws.a.a(this.f54803a);
        nVarA.update(bArrA, 0, bArrA.length);
        return this.f54807e.b(nVarA);
    }
}
