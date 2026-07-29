package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import cr.l;
import fp.p;
import gr.e;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import np.g0;
import np.h0;
import np.i0;
import np.k0;
import np.l0;
import np.m0;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class d extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f45009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f45010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f45012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SecureRandom f45014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45015g;

    public d() {
        super("ECGOST3410-2012");
        this.f45009a = null;
        this.f45010b = new p();
        this.f45011c = "ECGOST3410-2012";
        this.f45013e = 239;
        this.f45014f = null;
        this.f45015g = false;
    }

    public final void a(l lVar, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        co.l lVarG = qm.b.g(lVar.e());
        if (lVarG == null) {
            throw new InvalidAlgorithmParameterException("unknown curve: " + lVar.e());
        }
        this.f45009a = new gr.d(qm.b.h(lVar.e()), lVarG.y(), lVarG.B(), lVarG.E(), lVarG.C(), lVarG.F());
        i0 i0Var = new i0(new h0(new k0(lVar.e(), lVarG), lVar.e(), lVar.b(), lVar.c()), secureRandom);
        this.f45012d = i0Var;
        this.f45010b.a(i0Var);
        this.f45015g = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f45015g) {
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
        org.bouncycastle.crypto.c cVarB = this.f45010b.b();
        m0 m0Var = (m0) cVarB.b();
        l0 l0Var = (l0) cVarB.a();
        Object obj = this.f45009a;
        if (obj instanceof e) {
            e eVar = (e) obj;
            BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = new BCECGOST3410_2012PublicKey(this.f45011c, m0Var, eVar);
            return new KeyPair(bCECGOST3410_2012PublicKey, new BCECGOST3410_2012PrivateKey(this.f45011c, l0Var, bCECGOST3410_2012PublicKey, eVar));
        }
        if (obj == null) {
            return new KeyPair(new BCECGOST3410_2012PublicKey(this.f45011c, m0Var), new BCECGOST3410_2012PrivateKey(this.f45011c, l0Var));
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey2 = new BCECGOST3410_2012PublicKey(this.f45011c, m0Var, eCParameterSpec);
        return new KeyPair(bCECGOST3410_2012PublicKey2, new BCECGOST3410_2012PrivateKey(this.f45011c, l0Var, bCECGOST3410_2012PublicKey2, eCParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f45013e = i10;
        this.f45014f = secureRandom;
        Object obj = this.f45009a;
        if (obj == null) {
            throw new InvalidParameterException("unknown key size.");
        }
        try {
            initialize((ECGenParameterSpec) obj, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("key size not configurable.");
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        i0 i0Var;
        if (algorithmParameterSpec instanceof l) {
            a((l) algorithmParameterSpec, secureRandom);
            return;
        }
        if (!(algorithmParameterSpec instanceof e)) {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                this.f45009a = algorithmParameterSpec;
                ir.e eVarA = h.a(eCParameterSpec.getCurve());
                i0 i0Var2 = new i0(new g0(eVarA, h.d(eVarA, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                this.f45012d = i0Var2;
                this.f45010b.a(i0Var2);
                this.f45015g = true;
            }
            boolean z10 = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z10 || (algorithmParameterSpec instanceof gr.b)) {
                a(new l(z10 ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : ((gr.b) algorithmParameterSpec).a()), secureRandom);
                return;
            }
            if (algorithmParameterSpec == null) {
                uq.c cVar = BouncyCastleProvider.f45330c;
                if (cVar.b() != null) {
                    e eVarB = cVar.b();
                    this.f45009a = algorithmParameterSpec;
                    i0Var = new i0(new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c()), secureRandom);
                }
            }
            if (algorithmParameterSpec == null && BouncyCastleProvider.f45330c.b() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec: " + algorithmParameterSpec.getClass().getName());
        }
        e eVar = (e) algorithmParameterSpec;
        this.f45009a = algorithmParameterSpec;
        i0Var = new i0(new g0(eVar.a(), eVar.b(), eVar.d(), eVar.c()), secureRandom);
        this.f45012d = i0Var;
        this.f45010b.a(i0Var);
        this.f45015g = true;
    }
}
