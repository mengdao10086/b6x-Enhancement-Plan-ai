package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import cr.l;
import fp.p;
import gm.y;
import gr.d;
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
public class b extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f44979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f44980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f44981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f44982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f44983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SecureRandom f44984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f44985g;

    public b() {
        super("ECGOST3410");
        this.f44979a = null;
        this.f44980b = new p();
        this.f44981c = "ECGOST3410";
        this.f44983e = 239;
        this.f44984f = null;
        this.f44985g = false;
    }

    public final void a(l lVar, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        y yVarE = lVar.e();
        co.l lVarG = qm.b.g(yVarE);
        if (lVarG == null) {
            throw new InvalidAlgorithmParameterException("unknown curve: " + yVarE);
        }
        this.f44979a = new d(qm.b.h(yVarE), lVarG.y(), lVarG.B(), lVarG.E(), lVarG.C(), lVarG.F());
        i0 i0Var = new i0(new h0(new k0(yVarE, lVarG), yVarE, lVar.b(), lVar.c()), secureRandom);
        this.f44982d = i0Var;
        this.f44980b.a(i0Var);
        this.f44985g = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f44985g) {
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
        org.bouncycastle.crypto.c cVarB = this.f44980b.b();
        m0 m0Var = (m0) cVarB.b();
        l0 l0Var = (l0) cVarB.a();
        Object obj = this.f44979a;
        if (obj instanceof e) {
            e eVar = (e) obj;
            BCECGOST3410PublicKey bCECGOST3410PublicKey = new BCECGOST3410PublicKey(this.f44981c, m0Var, eVar);
            return new KeyPair(bCECGOST3410PublicKey, new BCECGOST3410PrivateKey(this.f44981c, l0Var, bCECGOST3410PublicKey, eVar));
        }
        if (obj == null) {
            return new KeyPair(new BCECGOST3410PublicKey(this.f44981c, m0Var), new BCECGOST3410PrivateKey(this.f44981c, l0Var));
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        BCECGOST3410PublicKey bCECGOST3410PublicKey2 = new BCECGOST3410PublicKey(this.f44981c, m0Var, eCParameterSpec);
        return new KeyPair(bCECGOST3410PublicKey2, new BCECGOST3410PrivateKey(this.f44981c, l0Var, bCECGOST3410PublicKey2, eCParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f44983e = i10;
        this.f44984f = secureRandom;
        Object obj = this.f44979a;
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
                this.f44979a = algorithmParameterSpec;
                ir.e eVarA = h.a(eCParameterSpec.getCurve());
                i0 i0Var2 = new i0(new g0(eVarA, h.d(eVarA, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                this.f44982d = i0Var2;
                this.f44980b.a(i0Var2);
                this.f44985g = true;
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
                    this.f44979a = algorithmParameterSpec;
                    i0Var = new i0(new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c()), secureRandom);
                }
            }
            if (algorithmParameterSpec == null && BouncyCastleProvider.f45330c.b() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            }
            throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec: " + algorithmParameterSpec.getClass().getName());
        }
        e eVar = (e) algorithmParameterSpec;
        this.f44979a = algorithmParameterSpec;
        i0Var = new i0(new g0(eVar.a(), eVar.b(), eVar.d(), eVar.c()), secureRandom);
        this.f44982d = i0Var;
        this.f44980b.a(i0Var);
        this.f44985g = true;
    }
}
