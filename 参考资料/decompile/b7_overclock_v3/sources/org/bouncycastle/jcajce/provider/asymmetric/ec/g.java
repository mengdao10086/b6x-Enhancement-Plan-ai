package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.l;
import fp.p;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Hashtable;
import np.g0;
import np.i0;
import np.l0;
import np.m0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes7.dex */
public abstract class g extends KeyPairGenerator {

    public static class a extends g {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Hashtable f44957i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i0 f44958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f44959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f44960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f44961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public SecureRandom f44962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f44963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f44964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public uq.c f44965h;

        static {
            Hashtable hashtable = new Hashtable();
            f44957i = hashtable;
            hashtable.put(j.g(192), new ECGenParameterSpec("prime192v1"));
            f44957i.put(j.g(239), new ECGenParameterSpec("prime239v1"));
            f44957i.put(j.g(256), new ECGenParameterSpec("prime256v1"));
            f44957i.put(j.g(224), new ECGenParameterSpec("P-224"));
            f44957i.put(j.g(384), new ECGenParameterSpec("P-384"));
            f44957i.put(j.g(gg.b.f29450j0), new ECGenParameterSpec("P-521"));
        }

        public a() {
            super("EC");
            this.f44959b = new p();
            this.f44960c = null;
            this.f44961d = 239;
            this.f44962e = n.f();
            this.f44963f = false;
            this.f44964g = "EC";
            this.f44965h = BouncyCastleProvider.f45330c;
        }

        public a(String str, uq.c cVar) {
            super(str);
            this.f44959b = new p();
            this.f44960c = null;
            this.f44961d = 239;
            this.f44962e = n.f();
            this.f44963f = false;
            this.f44964g = str;
            this.f44965h = cVar;
        }

        public i0 a(gr.e eVar, SecureRandom secureRandom) {
            return new i0(new g0(eVar.a(), eVar.b(), eVar.d(), eVar.c()), secureRandom);
        }

        public i0 b(l lVar, SecureRandom secureRandom) {
            return new i0(new g0(lVar.y(), lVar.B(), lVar.E(), lVar.C()), secureRandom);
        }

        public i0 c(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            l lVarD;
            if ((eCParameterSpec instanceof gr.d) && (lVarD = org.bouncycastle.jcajce.provider.asymmetric.ec.b.d(((gr.d) eCParameterSpec).c(), this.f44965h)) != null) {
                return b(lVarD, secureRandom);
            }
            ir.e eVarA = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec.getCurve());
            return new i0(new g0(eVarA, org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
        }

        public void d(String str, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            l lVarD = org.bouncycastle.jcajce.provider.asymmetric.ec.b.d(str, this.f44965h);
            if (lVarD != null) {
                this.f44960c = new gr.d(str, lVarD.y(), lVarD.B(), lVarD.E(), lVarD.C(), null);
                this.f44958a = b(lVarD, secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("unknown curve name: " + str);
            }
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (!this.f44963f) {
                initialize(this.f44961d, new SecureRandom());
            }
            org.bouncycastle.crypto.c cVarB = this.f44959b.b();
            m0 m0Var = (m0) cVarB.b();
            l0 l0Var = (l0) cVarB.a();
            Object obj = this.f44960c;
            if (obj instanceof gr.e) {
                gr.e eVar = (gr.e) obj;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.f44964g, m0Var, eVar, this.f44965h);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.f44964g, l0Var, bCECPublicKey, eVar, this.f44965h));
            }
            if (obj == null) {
                return new KeyPair(new BCECPublicKey(this.f44964g, m0Var, this.f44965h), new BCECPrivateKey(this.f44964g, l0Var, this.f44965h));
            }
            ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
            BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.f44964g, m0Var, eCParameterSpec, this.f44965h);
            return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.f44964g, l0Var, bCECPublicKey2, eCParameterSpec, this.f44965h));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i10, SecureRandom secureRandom) {
            this.f44961d = i10;
            this.f44962e = secureRandom;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) f44957i.get(j.g(i10));
            if (eCGenParameterSpec == null) {
                throw new InvalidParameterException("unknown key size.");
            }
            try {
                initialize(eCGenParameterSpec, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            String strA;
            i0 i0VarC;
            gr.e eVarB;
            if (algorithmParameterSpec == null) {
                eVarB = this.f44965h.b();
                if (eVarB == null) {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
                this.f44960c = null;
            } else {
                if (!(algorithmParameterSpec instanceof gr.e)) {
                    if (algorithmParameterSpec instanceof ECParameterSpec) {
                        this.f44960c = algorithmParameterSpec;
                        i0VarC = c((ECParameterSpec) algorithmParameterSpec, secureRandom);
                        this.f44958a = i0VarC;
                        this.f44959b.a(this.f44958a);
                        this.f44963f = true;
                    }
                    if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                        strA = ((ECGenParameterSpec) algorithmParameterSpec).getName();
                    } else {
                        if (!(algorithmParameterSpec instanceof gr.b)) {
                            String strH = i.h(algorithmParameterSpec);
                            if (strH != null) {
                                d(strH, secureRandom);
                                this.f44959b.a(this.f44958a);
                                this.f44963f = true;
                            } else {
                                throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
                            }
                        }
                        strA = ((gr.b) algorithmParameterSpec).a();
                    }
                    d(strA, secureRandom);
                    this.f44959b.a(this.f44958a);
                    this.f44963f = true;
                }
                this.f44960c = algorithmParameterSpec;
                eVarB = (gr.e) algorithmParameterSpec;
            }
            i0VarC = a(eVarB, secureRandom);
            this.f44958a = i0VarC;
            this.f44959b.a(this.f44958a);
            this.f44963f = true;
        }
    }

    public static class b extends a {
        public b() {
            super("ECDH", BouncyCastleProvider.f45330c);
        }
    }

    public static class c extends a {
        public c() {
            super("ECDHC", BouncyCastleProvider.f45330c);
        }
    }

    public static class d extends a {
        public d() {
            super("ECDSA", BouncyCastleProvider.f45330c);
        }
    }

    public static class e extends a {
        public e() {
            super("ECMQV", BouncyCastleProvider.f45330c);
        }
    }

    public g(String str) {
        super(str);
    }
}
