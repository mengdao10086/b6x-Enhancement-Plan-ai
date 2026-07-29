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
import org.bouncycastle.pqc.crypto.xmss.a0;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSMTPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.xmss.BCXMSSMTPublicKey;
import zo.e0;
import zo.h0;
import zo.j0;
import zo.w;

/* JADX INFO: loaded from: classes6.dex */
public class f extends Signature implements us.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f26521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f26522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f26523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f26524d;

    public static class a extends f {
        public a() {
            super("XMSSMT", new w(), new a0());
        }
    }

    public static class b extends f {
        public b() {
            super("XMSSMT-SHA256", new w(), new a0());
        }
    }

    public static class c extends f {
        public c() {
            super("SHA256withXMSSMT-SHA256", new e0(), new a0());
        }
    }

    public static class d extends f {
        public d() {
            super("XMSSMT-SHA512", new w(), new a0());
        }
    }

    public static class e extends f {
        public e() {
            super("SHA512withXMSSMT-SHA512", new h0(), new a0());
        }
    }

    /* JADX INFO: renamed from: dt.f$f, reason: collision with other inner class name */
    public static class C0301f extends f {
        public C0301f() {
            super("XMSSMT-SHAKE128", new w(), new a0());
        }
    }

    public static class g extends f {
        public g() {
            super("SHAKE128withXMSSMT-SHAKE128", new j0(128), new a0());
        }
    }

    public static class h extends f {
        public h() {
            super("XMSSMT-SHAKE256", new w(), new a0());
        }
    }

    public static class i extends f {
        public i() {
            super("SHAKE256withXMSSMT-SHAKE256", new j0(256), new a0());
        }
    }

    public f(String str) {
        super(str);
    }

    public f(String str, s sVar, a0 a0Var) {
        super(str);
        this.f26521a = sVar;
        this.f26522b = a0Var;
    }

    @Override // us.b
    public boolean a() {
        return (this.f26523c == null || this.f26522b.e() == 0) ? false : true;
    }

    @Override // us.b
    public PrivateKey c() {
        y yVar = this.f26523c;
        if (yVar == null) {
            throw new IllegalStateException("signature object not in a signing state");
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = new BCXMSSMTPrivateKey(yVar, (x) this.f26522b.c());
        this.f26523c = null;
        return bCXMSSMTPrivateKey;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCXMSSMTPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to XMSSMT");
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) privateKey;
        k kVarC = bCXMSSMTPrivateKey.c();
        this.f26523c = bCXMSSMTPrivateKey.d();
        SecureRandom secureRandom = this.f26524d;
        if (secureRandom != null) {
            kVarC = new w1(kVarC, secureRandom);
        }
        this.f26521a.reset();
        this.f26522b.a(true, kVarC);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f26524d = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCXMSSMTPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to XMSSMT");
        }
        k kVarC = ((BCXMSSMTPublicKey) publicKey).c();
        this.f26523c = null;
        this.f26521a.reset();
        this.f26522b.a(false, kVarC);
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
            return this.f26522b.b(dt.a.c(this.f26521a));
        } catch (Exception e10) {
            if (e10 instanceof IllegalStateException) {
                throw new SignatureException(e10.getMessage(), e10);
            }
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f26521a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f26521a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f26522b.d(dt.a.c(this.f26521a), bArr);
    }
}
