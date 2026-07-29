package nq;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class e extends org.bouncycastle.jcajce.provider.asymmetric.util.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f42602q = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f42603r = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final uo.d f42604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final org.bouncycastle.crypto.e f42605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public cr.f f42606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public cr.n f42607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BigInteger f42608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BigInteger f42609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BigInteger f42610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f42611p;

    public static class a extends e {
        public a() {
            super("DHUwithSHA1CKDF", new uo.d(), new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class a0 extends e {
        public a0() {
            super("MQVwithSHA256KDF", new uo.k(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class b extends e {
        public b() {
            super("DHUwithSHA1KDF", new uo.d(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class b0 extends e {
        public b0() {
            super("MQVwithSHA384CKDF", new uo.k(), new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class c extends e {
        public c() {
            super("DHUwithSHA224CKDF", new uo.d(), new wo.a(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class c0 extends e {
        public c0() {
            super("MQVwithSHA384KDF", new uo.k(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class d extends e {
        public d() {
            super("DHUwithSHA224KDF", new uo.d(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class d0 extends e {
        public d0() {
            super("MQVwithSHA512CKDF", new uo.k(), new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    /* JADX INFO: renamed from: nq.e$e, reason: collision with other inner class name */
    public static class C0479e extends e {
        public C0479e() {
            super("DHUwithSHA256CKDF", new uo.d(), new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class e0 extends e {
        public e0() {
            super("MQVwithSHA512KDF", new uo.k(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class f extends e {
        public f() {
            super("DHUwithSHA256KDF", new uo.d(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class g extends e {
        public g() {
            super("DHUwithSHA384CKDF", new uo.d(), new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class h extends e {
        public h() {
            super("DHUwithSHA384KDF", new uo.d(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class i extends e {
        public i() {
            super("DHUwithSHA512CKDF", new uo.d(), new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class j extends e {
        public j() {
            super("DHUwithSHA512KDF", new uo.d(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class k extends e {
        public k() {
            super("DHwithRFC2631KDF", new wo.c(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class l extends e {
        public l() {
            super("DHwithSHA1CKDF", new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class m extends e {
        public m() {
            super("DHwithSHA1CKDF", new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class n extends e {
        public n() {
            super("DHwithSHA224CKDF", new wo.a(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class o extends e {
        public o() {
            super("DHwithSHA224CKDF", new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class p extends e {
        public p() {
            super("DHwithSHA256CKDF", new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class q extends e {
        public q() {
            super("DHwithSHA256CKDF", new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class r extends e {
        public r() {
            super("DHwithSHA384CKDF", new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class s extends e {
        public s() {
            super("DHwithSHA384KDF", new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class t extends e {
        public t() {
            super("DHwithSHA512CKDF", new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class u extends e {
        public u() {
            super("DHwithSHA512KDF", new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class v extends e {
        public v() {
            super("MQVwithSHA1CKDF", new uo.k(), new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class w extends e {
        public w() {
            super("MQVwithSHA1KDF", new uo.k(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class x extends e {
        public x() {
            super("MQVwithSHA224CKDF", new uo.k(), new wo.a(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class y extends e {
        public y() {
            super("MQVwithSHA224KDF", new uo.k(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class z extends e {
        public z() {
            super("MQVwithSHA256CKDF", new uo.k(), new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public e() {
        this("Diffie-Hellman", null);
    }

    public e(String str, org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f42604i = null;
        this.f42605j = eVar;
    }

    public e(String str, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f42604i = null;
        this.f42605j = null;
    }

    public e(String str, uo.d dVar, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f42604i = dVar;
        this.f42605j = null;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a
    public byte[] a() {
        return this.f42611p;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z10) throws IllegalStateException, InvalidKeyException {
        if (this.f42608m == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (!(key instanceof DHPublicKey)) {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        DHPublicKey dHPublicKey = (DHPublicKey) key;
        if (!dHPublicKey.getParams().getG().equals(this.f42610o) || !dHPublicKey.getParams().getP().equals(this.f42609n)) {
            throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
        }
        BigInteger y10 = dHPublicKey.getY();
        if (y10 != null && y10.compareTo(f42603r) >= 0) {
            BigInteger bigInteger = this.f42609n;
            BigInteger bigInteger2 = f42602q;
            if (y10.compareTo(bigInteger.subtract(bigInteger2)) < 0) {
                if (this.f42604i != null) {
                    if (!z10) {
                        throw new IllegalStateException("unified Diffie-Hellman can use only two key pairs");
                    }
                    this.f42611p = this.f42604i.a(new np.u(h((PublicKey) key), h(this.f42606k.c())));
                    return null;
                }
                if (this.f42605j != null) {
                    if (!z10) {
                        throw new IllegalStateException("MQV Diffie-Hellman can use only two key pairs");
                    }
                    this.f42611p = f(this.f42605j.c(new np.p(h((PublicKey) key), h(this.f42607l.c()))));
                    return null;
                }
                BigInteger bigIntegerModPow = y10.modPow(this.f42608m, this.f42609n);
                if (bigIntegerModPow.compareTo(bigInteger2) == 0) {
                    throw new InvalidKeyException("Shared key can't be 1");
                }
                this.f42611p = f(bigIntegerModPow);
                if (z10) {
                    return null;
                }
                return new BCDHPublicKey(bigIntegerModPow, dHPublicKey.getParams());
            }
        }
        throw new InvalidKeyException("Invalid DH PublicKey");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i10) throws IllegalStateException, ShortBufferException {
        if (this.f42608m != null) {
            return super.engineGenerateSecret(bArr, i10);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a, javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        if (this.f42608m != null) {
            return str.equals("TlsPremasterSecret") ? new SecretKeySpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(this.f42611p), str) : super.engineGenerateSecret(str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f42608m != null) {
            return super.engineGenerateSecret();
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
        this.f42609n = dHPrivateKey.getParams().getP();
        this.f42610o = dHPrivateKey.getParams().getG();
        BigInteger x10 = dHPrivateKey.getX();
        this.f42608m = x10;
        this.f42611p = f(x10);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        org.bouncycastle.crypto.e eVar;
        np.o oVar;
        uo.d dVar;
        np.t tVar;
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
        if (algorithmParameterSpec == null) {
            this.f42609n = dHPrivateKey.getParams().getP();
            this.f42610o = dHPrivateKey.getParams().getG();
        } else if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.f42609n = dHParameterSpec.getP();
            this.f42610o = dHParameterSpec.getG();
            this.f42606k = null;
            this.f45050c = null;
        } else if (algorithmParameterSpec instanceof cr.f) {
            if (this.f42604i == null) {
                throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
            }
            this.f42609n = dHPrivateKey.getParams().getP();
            this.f42610o = dHPrivateKey.getParams().getG();
            cr.f fVar = (cr.f) algorithmParameterSpec;
            this.f42606k = fVar;
            this.f45050c = fVar.d();
            if (this.f42606k.b() != null) {
                dVar = this.f42604i;
                tVar = new np.t(g(dHPrivateKey), g(this.f42606k.a()), h(this.f42606k.b()));
            } else {
                dVar = this.f42604i;
                tVar = new np.t(g(dHPrivateKey), g(this.f42606k.a()));
            }
            dVar.c(tVar);
        } else if (algorithmParameterSpec instanceof cr.n) {
            if (this.f42605j == null) {
                throw new InvalidAlgorithmParameterException("agreement algorithm not MQV based");
            }
            this.f42609n = dHPrivateKey.getParams().getP();
            this.f42610o = dHPrivateKey.getParams().getG();
            cr.n nVar = (cr.n) algorithmParameterSpec;
            this.f42607l = nVar;
            this.f45050c = nVar.d();
            if (this.f42607l.b() != null) {
                eVar = this.f42605j;
                oVar = new np.o(g(dHPrivateKey), g(this.f42607l.a()), h(this.f42607l.b()));
            } else {
                eVar = this.f42605j;
                oVar = new np.o(g(dHPrivateKey), g(this.f42607l.a()));
            }
            eVar.a(oVar);
        } else {
            if (!(algorithmParameterSpec instanceof cr.w)) {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            if (this.f45049b == null) {
                throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
            }
            this.f42609n = dHPrivateKey.getParams().getP();
            this.f42610o = dHPrivateKey.getParams().getG();
            this.f42606k = null;
            this.f45050c = ((cr.w) algorithmParameterSpec).a();
        }
        BigInteger x10 = dHPrivateKey.getX();
        this.f42608m = x10;
        this.f42611p = f(x10);
    }

    public byte[] f(BigInteger bigInteger) {
        int iBitLength = (this.f42609n.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == iBitLength) {
            return byteArray;
        }
        if (byteArray[0] != 0 || byteArray.length != iBitLength + 1) {
            byte[] bArr = new byte[iBitLength];
            System.arraycopy(byteArray, 0, bArr, iBitLength - byteArray.length, byteArray.length);
            return bArr;
        }
        int length = byteArray.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(byteArray, 1, bArr2, 0, length);
        return bArr2;
    }

    public final np.r g(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof DHPrivateKey)) {
            throw new InvalidKeyException("private key not a DHPrivateKey");
        }
        if (privateKey instanceof BCDHPrivateKey) {
            return ((BCDHPrivateKey) privateKey).a();
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
        DHParameterSpec params = dHPrivateKey.getParams();
        return new np.r(dHPrivateKey.getX(), new np.q(params.getP(), params.getG(), null, params.getL()));
    }

    public final np.s h(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof DHPublicKey)) {
            throw new InvalidKeyException("public key not a DHPublicKey");
        }
        if (publicKey instanceof BCDHPublicKey) {
            return ((BCDHPublicKey) publicKey).a();
        }
        DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
        DHParameterSpec params = dHPublicKey.getParams();
        return params instanceof cr.c ? new np.s(dHPublicKey.getY(), ((cr.c) params).a()) : new np.s(dHPublicKey.getY(), new np.q(params.getP(), params.getG(), null, params.getL()));
    }
}
