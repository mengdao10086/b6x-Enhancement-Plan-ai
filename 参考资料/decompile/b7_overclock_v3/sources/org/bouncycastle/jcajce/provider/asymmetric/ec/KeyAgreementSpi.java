package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import np.p1;
import np.q1;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreementSpi extends org.bouncycastle.jcajce.provider.asymmetric.util.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final co.q f44923o = new co.q();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f44924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public np.g0 f44925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f44926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public cr.n f44927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public cr.f f44928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f44929n;

    public static class a extends KeyAgreementSpi {
        public a() {
            super("ECCDHwithSHA1KDF", new uo.f(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class a0 extends KeyAgreementSpi {
        public a0() {
            super("ECDHwithSHA512CKDF", new uo.f(), new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class b extends KeyAgreementSpi {
        public b() {
            super("ECCDHwithSHA224KDF", new uo.f(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class b0 extends KeyAgreementSpi {
        public b0() {
            super("ECDHwithSHA512KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class c extends KeyAgreementSpi {
        public c() {
            super("ECCDHwithSHA256KDF", new uo.f(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class c0 extends KeyAgreementSpi {
        public c0() {
            super("ECKAEGwithRIPEMD160KDF", new uo.e(), new fp.z(new zo.z()));
        }
    }

    public static class d extends KeyAgreementSpi {
        public d() {
            super("ECCDHwithSHA384KDF", new uo.f(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class d0 extends KeyAgreementSpi {
        public d0() {
            super("ECKAEGwithSHA1KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class e extends KeyAgreementSpi {
        public e() {
            super("ECCDHwithSHA512KDF", new uo.f(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class e0 extends KeyAgreementSpi {
        public e0() {
            super("ECKAEGwithSHA224KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class f extends KeyAgreementSpi {
        public f() {
            super("ECDH", new uo.e(), (org.bouncycastle.crypto.q) null);
        }
    }

    public static class f0 extends KeyAgreementSpi {
        public f0() {
            super("ECKAEGwithSHA256KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class g extends KeyAgreementSpi {
        public g() {
            super("ECDHC", new uo.f(), (org.bouncycastle.crypto.q) null);
        }
    }

    public static class g0 extends KeyAgreementSpi {
        public g0() {
            super("ECKAEGwithSHA384KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class h extends KeyAgreementSpi {
        public h() {
            super("ECCDHU", new uo.h(), (org.bouncycastle.crypto.q) null);
        }
    }

    public static class h0 extends KeyAgreementSpi {
        public h0() {
            super("ECKAEGwithSHA512KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class i extends KeyAgreementSpi {
        public i() {
            super("ECCDHUwithSHA1CKDF", new uo.h(), new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class i0 extends KeyAgreementSpi {
        public i0() {
            super("ECMQV", new uo.i(), (org.bouncycastle.crypto.q) null);
        }
    }

    public static class j extends KeyAgreementSpi {
        public j() {
            super("ECCDHUwithSHA1KDF", new uo.h(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class j0 extends KeyAgreementSpi {
        public j0() {
            super("ECMQVwithSHA1CKDF", new uo.i(), new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class k extends KeyAgreementSpi {
        public k() {
            super("ECCDHUwithSHA224CKDF", new uo.h(), new wo.a(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class k0 extends KeyAgreementSpi {
        public k0() {
            super("ECMQVwithSHA1KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class l extends KeyAgreementSpi {
        public l() {
            super("ECCDHUwithSHA224KDF", new uo.h(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class l0 extends KeyAgreementSpi {
        public l0() {
            super("ECMQVwithSHA1KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class m extends KeyAgreementSpi {
        public m() {
            super("ECCDHUwithSHA256CKDF", new uo.h(), new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class m0 extends KeyAgreementSpi {
        public m0() {
            super("ECMQVwithSHA224CKDF", new uo.i(), new wo.a(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class n extends KeyAgreementSpi {
        public n() {
            super("ECCDHUwithSHA256KDF", new uo.h(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class n0 extends KeyAgreementSpi {
        public n0() {
            super("ECMQVwithSHA224KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class o extends KeyAgreementSpi {
        public o() {
            super("ECCDHUwithSHA384CKDF", new uo.h(), new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class o0 extends KeyAgreementSpi {
        public o0() {
            super("ECMQVwithSHA224KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class p extends KeyAgreementSpi {
        public p() {
            super("ECCDHUwithSHA384KDF", new uo.h(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class p0 extends KeyAgreementSpi {
        public p0() {
            super("ECMQVwithSHA256CKDF", new uo.i(), new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class q extends KeyAgreementSpi {
        public q() {
            super("ECCDHUwithSHA512CKDF", new uo.h(), new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class q0 extends KeyAgreementSpi {
        public q0() {
            super("ECMQVwithSHA256KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class r extends KeyAgreementSpi {
        public r() {
            super("ECCDHUwithSHA512KDF", new uo.h(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class r0 extends KeyAgreementSpi {
        public r0() {
            super("ECMQVwithSHA256KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class s extends KeyAgreementSpi {
        public s() {
            super("ECDHwithSHA1CKDF", new uo.f(), new wo.a(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class s0 extends KeyAgreementSpi {
        public s0() {
            super("ECMQVwithSHA384CKDF", new uo.i(), new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class t extends KeyAgreementSpi {
        public t() {
            super("ECDHwithSHA1KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class t0 extends KeyAgreementSpi {
        public t0() {
            super("ECMQVwithSHA384KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class u extends KeyAgreementSpi {
        public u() {
            super("ECDHwithSHA1KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.c()));
        }
    }

    public static class u0 extends KeyAgreementSpi {
        public u0() {
            super("ECMQVwithSHA384KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class v extends KeyAgreementSpi {
        public v() {
            super("ECDHwithSHA224KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.d()));
        }
    }

    public static class v0 extends KeyAgreementSpi {
        public v0() {
            super("ECMQVwithSHA512CKDF", new uo.i(), new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class w extends KeyAgreementSpi {
        public w() {
            super("ECDHwithSHA256CKDF", new uo.f(), new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class w0 extends KeyAgreementSpi {
        public w0() {
            super("ECMQVwithSHA512KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class x extends KeyAgreementSpi {
        public x() {
            super("ECDHwithSHA256KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class x0 extends KeyAgreementSpi {
        public x0() {
            super("ECMQVwithSHA512KDF", new uo.i(), new fp.z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class y extends KeyAgreementSpi {
        public y() {
            super("ECDHwithSHA384CKDF", new uo.f(), new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class z extends KeyAgreementSpi {
        public z() {
            super("ECDHwithSHA384KDF", new uo.e(), new fp.z(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public KeyAgreementSpi(String str, org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f44924i = str;
        this.f44926k = eVar;
    }

    public KeyAgreementSpi(String str, uo.h hVar, org.bouncycastle.crypto.q qVar) {
        super(str, qVar);
        this.f44924i = str;
        this.f44926k = hVar;
    }

    public static String g(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a
    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f44929n);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z10) throws IllegalStateException, InvalidKeyException {
        org.bouncycastle.crypto.k kVarA;
        if (this.f44925j == null) {
            throw new IllegalStateException(this.f44924i + " not initialised.");
        }
        if (!z10) {
            throw new IllegalStateException(this.f44924i + " can only be between two parties.");
        }
        Object obj = this.f44926k;
        if (obj instanceof uo.i) {
            if (key instanceof MQVPublicKey) {
                MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                kVarA = new q1((np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(mQVPublicKey.k0()), (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(mQVPublicKey.H0()));
            } else {
                kVarA = new q1((np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a((PublicKey) key), (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(this.f44927l.c()));
            }
        } else if (obj instanceof uo.h) {
            kVarA = new np.f0((np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a((PublicKey) key), (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(this.f44928m.c()));
        } else {
            if (!(key instanceof PublicKey)) {
                throw new InvalidKeyException(this.f44924i + " key agreement requires " + g(ECPublicKey.class) + " for doPhase");
            }
            kVarA = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a((PublicKey) key);
        }
        try {
            Object obj2 = this.f44926k;
            if (obj2 instanceof org.bouncycastle.crypto.e) {
                this.f44929n = f(((org.bouncycastle.crypto.e) obj2).c(kVarA));
                return null;
            }
            this.f44929n = ((uo.h) obj2).a(kVarA);
            return null;
        } catch (Exception e10) {
            throw new InvalidKeyException("calculation failed: " + e10.getMessage()) { // from class: org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e10;
                }
            };
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            h(key, null);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyException(e10.getMessage());
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof cr.n) && !(algorithmParameterSpec instanceof cr.w) && !(algorithmParameterSpec instanceof cr.f)) {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }
        h(key, algorithmParameterSpec);
    }

    public byte[] f(BigInteger bigInteger) {
        co.q qVar = f44923o;
        return qVar.c(bigInteger, qVar.a(this.f44925j.a()));
    }

    public final void h(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        np.l0 l0Var;
        np.l0 l0Var2;
        Object obj = this.f44926k;
        np.m0 m0Var = null;
        if (obj instanceof uo.i) {
            this.f44927l = null;
            boolean z10 = key instanceof MQVPrivateKey;
            if (!z10 && !(algorithmParameterSpec instanceof cr.n)) {
                throw new InvalidAlgorithmParameterException(this.f44924i + " key agreement requires " + g(cr.n.class) + " for initialisation");
            }
            if (z10) {
                MQVPrivateKey mQVPrivateKey = (MQVPrivateKey) key;
                l0Var2 = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c(mQVPrivateKey.d0());
                l0Var = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c(mQVPrivateKey.i0());
                if (mQVPrivateKey.C0() != null) {
                    m0Var = (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(mQVPrivateKey.C0());
                }
            } else {
                cr.n nVar = (cr.n) algorithmParameterSpec;
                np.l0 l0Var3 = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c((PrivateKey) key);
                l0Var = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c(nVar.a());
                m0Var = nVar.b() != null ? (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(nVar.b()) : null;
                this.f44927l = nVar;
                this.f45050c = nVar.d();
                l0Var2 = l0Var3;
            }
            p1 p1Var = new p1(l0Var2, l0Var, m0Var);
            this.f44925j = l0Var2.d();
            ((uo.i) this.f44926k).a(p1Var);
            return;
        }
        if (!(algorithmParameterSpec instanceof cr.f)) {
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException(this.f44924i + " key agreement requires " + g(ECPrivateKey.class) + " for initialisation");
            }
            if (this.f45049b == null && (algorithmParameterSpec instanceof cr.w)) {
                throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
            }
            np.l0 l0Var4 = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c((PrivateKey) key);
            this.f44925j = l0Var4.d();
            this.f45050c = algorithmParameterSpec instanceof cr.w ? ((cr.w) algorithmParameterSpec).a() : null;
            ((org.bouncycastle.crypto.e) this.f44926k).a(l0Var4);
            return;
        }
        if (!(obj instanceof uo.h)) {
            throw new InvalidAlgorithmParameterException(this.f44924i + " key agreement cannot be used with " + g(cr.f.class));
        }
        cr.f fVar = (cr.f) algorithmParameterSpec;
        np.l0 l0Var5 = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c((PrivateKey) key);
        np.l0 l0Var6 = (np.l0) org.bouncycastle.jcajce.provider.asymmetric.util.i.c(fVar.a());
        np.m0 m0Var2 = fVar.b() != null ? (np.m0) org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(fVar.b()) : null;
        this.f44928m = fVar;
        this.f45050c = fVar.d();
        np.e0 e0Var = new np.e0(l0Var5, l0Var6, m0Var2);
        this.f44925j = l0Var5.d();
        ((uo.h) this.f44926k).c(e0Var);
    }
}
