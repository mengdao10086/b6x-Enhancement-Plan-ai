package tq;

import cp.x0;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import np.e2;
import np.w1;
import org.bouncycastle.crypto.CryptoException;

/* JADX INFO: loaded from: classes7.dex */
public class g extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f51591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlgorithmParameters f51592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PSSParameterSpec f51593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PSSParameterSpec f51594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.b f51595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public org.bouncycastle.crypto.s f51596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f51597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f51599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f51600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e2 f51601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SecureRandom f51602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public rp.u f51603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f51604n;

    public class a implements org.bouncycastle.crypto.s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public org.bouncycastle.crypto.s f51606b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteArrayOutputStream f51605a = new ByteArrayOutputStream();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51607c = true;

        public a(org.bouncycastle.crypto.s sVar) {
            this.f51606b = sVar;
        }

        @Override // org.bouncycastle.crypto.s
        public String b() {
            return "NULL";
        }

        @Override // org.bouncycastle.crypto.s
        public int c(byte[] bArr, int i10) {
            byte[] byteArray = this.f51605a.toByteArray();
            if (this.f51607c) {
                System.arraycopy(byteArray, 0, bArr, i10, byteArray.length);
            } else {
                this.f51606b.update(byteArray, 0, byteArray.length);
                this.f51606b.c(bArr, i10);
            }
            reset();
            this.f51607c = !this.f51607c;
            return byteArray.length;
        }

        public int g() {
            return 0;
        }

        @Override // org.bouncycastle.crypto.s
        public int h() {
            return this.f51606b.h();
        }

        @Override // org.bouncycastle.crypto.s
        public void reset() {
            this.f51605a.reset();
            this.f51606b.reset();
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte b10) {
            this.f51605a.write(b10);
        }

        @Override // org.bouncycastle.crypto.s
        public void update(byte[] bArr, int i10, int i11) {
            this.f51605a.write(bArr, i10, i11);
        }
    }

    public static class a0 extends g {
        public a0() {
            super(new x0(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class b extends g {
        public b() {
            super(new x0(), null);
        }
    }

    public static class b0 extends g {
        public b0() {
            super(new x0(), new PSSParameterSpec("SHA-512(224)", "SHAKE128", null, 28, 1));
        }
    }

    public static class c extends g {
        public c() {
            super(new x0(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class c0 extends g {
        public c0() {
            super(new x0(), new PSSParameterSpec("SHA-512(224)", "SHAKE256", null, 28, 1));
        }
    }

    public static class d extends g {
        public d() {
            super(new x0(), new PSSParameterSpec("SHA1", "SHAKE128", null, 20, 1));
        }
    }

    public static class d0 extends g {
        public d0() {
            super(new x0(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class e extends g {
        public e() {
            super(new x0(), new PSSParameterSpec("SHA1", "SHAKE256", null, 20, 1));
        }
    }

    public static class e0 extends g {
        public e0() {
            super(new x0(), new PSSParameterSpec("SHA-512(256)", "SHAKE128", null, 32, 1));
        }
    }

    public static class f extends g {
        public f() {
            super(new x0(), new PSSParameterSpec(et.e.f27138g, "MGF1", new MGF1ParameterSpec(et.e.f27138g), 28, 1));
        }
    }

    public static class f0 extends g {
        public f0() {
            super(new x0(), new PSSParameterSpec("SHA-512(256)", "SHAKE256", null, 32, 1));
        }
    }

    /* JADX INFO: renamed from: tq.g$g, reason: collision with other inner class name */
    public static class C0590g extends g {
        public C0590g() {
            super(new x0(), new PSSParameterSpec(et.e.f27138g, "SHAKE128", null, 28, 1));
        }
    }

    public static class g0 extends g {
        public g0() {
            super(new x0(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class h extends g {
        public h() {
            super(new x0(), new PSSParameterSpec(et.e.f27138g, "SHAKE256", null, 28, 1));
        }
    }

    public static class h0 extends g {
        public h0() {
            super(new x0(), new PSSParameterSpec("SHA-512", "SHAKE128", null, 64, 1));
        }
    }

    public static class i extends g {
        public i() {
            super(new x0(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class i0 extends g {
        public i0() {
            super(new x0(), new PSSParameterSpec("SHA-512", "SHAKE256", null, 64, 1));
        }
    }

    public static class j extends g {
        public j() {
            super(new x0(), new PSSParameterSpec("SHA-256", "SHAKE128", null, 32, 1));
        }
    }

    public static class j0 extends g {
        public j0() {
            super(new x0(), new PSSParameterSpec("SHAKE128", "SHAKE128", null, 32, 1));
        }
    }

    public static class k extends g {
        public k() {
            super(new x0(), new PSSParameterSpec("SHA-256", "SHAKE256", null, 32, 1));
        }
    }

    public static class k0 extends g {
        public k0() {
            super(new x0(), new PSSParameterSpec("SHAKE256", "SHAKE256", null, 64, 1));
        }
    }

    public static class l extends g {
        public l() {
            super(new x0(), new PSSParameterSpec(et.e.f27140i, "MGF1", new MGF1ParameterSpec(et.e.f27140i), 48, 1));
        }
    }

    public static class l0 extends g {
        public l0() {
            super(new x0(), null, true);
        }
    }

    public static class m extends g {
        public m() {
            super(new x0(), new PSSParameterSpec(et.e.f27140i, "SHAKE128", null, 48, 1));
        }
    }

    public static class n extends g {
        public n() {
            super(new x0(), new PSSParameterSpec(et.e.f27140i, "SHAKE256", null, 48, 1));
        }
    }

    public static class o extends g {
        public o() {
            super(new x0(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class p extends g {
        public p() {
            super(new x0(), new PSSParameterSpec("SHA3-224", "SHAKE128", null, 28, 1));
        }
    }

    public static class q extends g {
        public q() {
            super(new x0(), new PSSParameterSpec("SHA3-224", "SHAKE256", null, 28, 1));
        }
    }

    public static class r extends g {
        public r() {
            super(new x0(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class s extends g {
        public s() {
            super(new x0(), new PSSParameterSpec("SHA3-256", "SHAKE128", null, 32, 1));
        }
    }

    public static class t extends g {
        public t() {
            super(new x0(), new PSSParameterSpec("SHA3-256", "SHAKE256", null, 32, 1));
        }
    }

    public static class u extends g {
        public u() {
            super(new x0(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class v extends g {
        public v() {
            super(new x0(), new PSSParameterSpec("SHA3-384", "SHAKE128", null, 48, 1));
        }
    }

    public static class w extends g {
        public w() {
            super(new x0(), new PSSParameterSpec("SHA3-384", "SHAKE256", null, 48, 1));
        }
    }

    public static class x extends g {
        public x() {
            super(new x0(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class y extends g {
        public y() {
            super(new x0(), new PSSParameterSpec("SHA3-512", "SHAKE128", null, 64, 1));
        }
    }

    public static class z extends g {
        public z() {
            super(new x0(), new PSSParameterSpec("SHA3-512", "SHAKE256", null, 64, 1));
        }
    }

    public g(org.bouncycastle.crypto.b bVar, PSSParameterSpec pSSParameterSpec) {
        this(bVar, pSSParameterSpec, false);
    }

    public g(org.bouncycastle.crypto.b bVar, PSSParameterSpec pSSParameterSpec, boolean z10) {
        this.f51591a = new org.bouncycastle.jcajce.util.b();
        this.f51604n = true;
        this.f51595e = bVar;
        this.f51594d = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.f51593c = PSSParameterSpec.DEFAULT;
        } else {
            this.f51593c = pSSParameterSpec;
        }
        this.f51597g = br.d.a("MGF1".equals(this.f51593c.getMGFAlgorithm()) ? this.f51593c.getDigestAlgorithm() : this.f51593c.getMGFAlgorithm());
        this.f51598h = this.f51593c.getSaltLength();
        this.f51599i = a(this.f51593c.getTrailerField());
        this.f51600j = z10;
        b();
    }

    public final byte a(int i10) {
        if (i10 == 1) {
            return rp.u.f49086t;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    public final void b() {
        this.f51596f = this.f51600j ? new a(this.f51597g) : br.d.a(this.f51593c.getDigestAlgorithm());
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        PSSParameterSpec pSSParameterSpec;
        if (this.f51592b == null && (pSSParameterSpec = this.f51593c) != null) {
            if (pSSParameterSpec.getDigestAlgorithm().equals(this.f51593c.getMGFAlgorithm()) && this.f51593c.getMGFParameters() == null) {
                return null;
            }
            try {
                AlgorithmParameters algorithmParametersT = this.f51591a.t("PSS");
                this.f51592b = algorithmParametersT;
                algorithmParametersT.init(this.f51593c);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f51592b;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof RSAPrivateKey)) {
            throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
        }
        this.f51601k = tq.h.c((RSAPrivateKey) privateKey);
        rp.u uVar = new rp.u(this.f51595e, this.f51596f, this.f51597g, this.f51598h, this.f51599i);
        this.f51603m = uVar;
        SecureRandom secureRandom = this.f51602l;
        if (secureRandom != null) {
            uVar.a(true, new w1(this.f51601k, secureRandom));
        } else {
            uVar.a(true, this.f51601k);
        }
        this.f51604n = true;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f51602l = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof RSAPublicKey)) {
            throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
        }
        this.f51601k = tq.h.d((RSAPublicKey) publicKey);
        rp.u uVar = new rp.u(this.f51595e, this.f51596f, this.f51597g, this.f51598h, this.f51599i);
        this.f51603m = uVar;
        uVar.a(false, this.f51601k);
        this.f51604n = true;
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        String digestAlgorithm;
        rp.u uVar;
        boolean z10;
        if (algorithmParameterSpec == null && (algorithmParameterSpec = this.f51594d) == null) {
            return;
        }
        if (!this.f51604n) {
            throw new ProviderException("cannot call setParameter in the middle of update");
        }
        if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
        }
        PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
        PSSParameterSpec pSSParameterSpec2 = this.f51594d;
        if (pSSParameterSpec2 != null && !br.d.c(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
            throw new InvalidAlgorithmParameterException("parameter must be using " + this.f51594d.getDigestAlgorithm());
        }
        if (pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") || pSSParameterSpec.getMGFAlgorithm().equals(pn.s.E3.L())) {
            if (!(pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec)) {
                throw new InvalidAlgorithmParameterException("unknown MGF parameters");
            }
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
            if (!br.d.c(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
            }
            digestAlgorithm = mGF1ParameterSpec.getDigestAlgorithm();
        } else {
            if (!pSSParameterSpec.getMGFAlgorithm().equals("SHAKE128") && !pSSParameterSpec.getMGFAlgorithm().equals("SHAKE256")) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            }
            digestAlgorithm = pSSParameterSpec.getMGFAlgorithm();
        }
        org.bouncycastle.crypto.s sVarA = br.d.a(digestAlgorithm);
        if (sVarA == null) {
            throw new InvalidAlgorithmParameterException("no match on MGF algorithm: " + pSSParameterSpec.getMGFAlgorithm());
        }
        this.f51592b = null;
        this.f51593c = pSSParameterSpec;
        this.f51597g = sVarA;
        this.f51598h = pSSParameterSpec.getSaltLength();
        this.f51599i = a(this.f51593c.getTrailerField());
        b();
        if (this.f51601k != null) {
            this.f51603m = new rp.u(this.f51595e, this.f51596f, sVarA, this.f51598h, this.f51599i);
            if (this.f51601k.c()) {
                uVar = this.f51603m;
                z10 = true;
            } else {
                uVar = this.f51603m;
                z10 = false;
            }
            uVar.a(z10, this.f51601k);
        }
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        this.f51604n = true;
        try {
            return this.f51603m.e();
        } catch (CryptoException e10) {
            throw new SignatureException(e10.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f51603m.update(b10);
        this.f51604n = false;
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f51603m.update(bArr, i10, i11);
        this.f51604n = false;
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        this.f51604n = true;
        return this.f51603m.d(bArr);
    }
}
