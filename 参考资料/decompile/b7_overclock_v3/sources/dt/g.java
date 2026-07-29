package dt;

import gm.y;
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
import org.bouncycastle.pqc.crypto.xmss.i0;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSPublicKey;
import zo.e0;
import zo.h0;
import zo.j0;
import zo.w;

/* JADX INFO: loaded from: classes6.dex */
public class g extends Signature implements us.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f26525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f26526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f26527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f26528d;

    public static class a extends g {
        public a() {
            super("XMSS", new w(), new i0());
        }
    }

    public static class b extends g {
        public b() {
            super("XMSS-SHA256", new w(), new i0());
        }
    }

    public static class c extends g {
        public c() {
            super("SHA256withXMSS-SHA256", new e0(), new i0());
        }
    }

    public static class d extends g {
        public d() {
            super("XMSS-SHA512", new w(), new i0());
        }
    }

    public static class e extends g {
        public e() {
            super("SHA512withXMSS-SHA512", new h0(), new i0());
        }
    }

    public static class f extends g {
        public f() {
            super("XMSS-SHAKE128", new w(), new i0());
        }
    }

    /* JADX INFO: renamed from: dt.g$g, reason: collision with other inner class name */
    public static class C0302g extends g {
        public C0302g() {
            super("SHAKE128withXMSSMT-SHAKE128", new j0(128), new i0());
        }
    }

    public static class h extends g {
        public h() {
            super("XMSS-SHAKE256", new w(), new i0());
        }
    }

    public static class i extends g {
        public i() {
            super("SHAKE256withXMSS-SHAKE256", new j0(256), new i0());
        }
    }

    public g(String str) {
        super(str);
    }

    public g(String str, s sVar, i0 i0Var) {
        super(str);
        this.f26525a = sVar;
        this.f26526b = i0Var;
    }

    @Override // us.b
    public boolean a() {
        return (this.f26528d == null || this.f26526b.e() == 0) ? false : true;
    }

    @Override // us.b
    public PrivateKey c() {
        y yVar = this.f26528d;
        if (yVar == null) {
            throw new IllegalStateException("signature object not in a signing state");
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = new BCXMSSPrivateKey(yVar, (org.bouncycastle.pqc.crypto.xmss.e0) this.f26526b.c());
        this.f26528d = null;
        return bCXMSSPrivateKey;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCXMSSPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to XMSS");
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) privateKey;
        k kVarB = bCXMSSPrivateKey.b();
        this.f26528d = bCXMSSPrivateKey.c();
        SecureRandom secureRandom = this.f26527c;
        if (secureRandom != null) {
            kVarB = new w1(kVarB, secureRandom);
        }
        this.f26525a.reset();
        this.f26526b.a(true, kVarB);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f26527c = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCXMSSPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to XMSS");
        }
        k kVarB = ((BCXMSSPublicKey) publicKey).b();
        this.f26528d = null;
        this.f26525a.reset();
        this.f26526b.a(false, kVarB);
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
            return this.f26526b.b(dt.a.c(this.f26525a));
        } catch (Exception e10) {
            if (e10 instanceof IllegalStateException) {
                throw new SignatureException(e10.getMessage(), e10);
            }
            throw new SignatureException(e10.toString(), e10);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f26525a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f26525a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f26526b.d(dt.a.c(this.f26525a), bArr);
    }
}
