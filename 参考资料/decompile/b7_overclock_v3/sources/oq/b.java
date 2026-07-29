package oq;

import cr.g;
import fp.o;
import fp.p;
import gm.y;
import gr.e;
import ir.i;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import np.d0;
import np.g0;
import np.i0;
import np.l0;
import np.m0;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class b extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f44388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f44389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f44390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f44391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f44392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44393f;

    public b() {
        super("DSTU4145");
        this.f44388a = null;
        this.f44389b = new o();
        this.f44390c = "DSTU4145";
        this.f44392e = null;
        this.f44393f = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f44393f) {
            throw new IllegalStateException("DSTU Key Pair Generator not initialised");
        }
        org.bouncycastle.crypto.c cVarB = this.f44389b.b();
        m0 m0Var = (m0) cVarB.b();
        l0 l0Var = (l0) cVarB.a();
        Object obj = this.f44388a;
        if (obj instanceof e) {
            e eVar = (e) obj;
            BCDSTU4145PublicKey bCDSTU4145PublicKey = new BCDSTU4145PublicKey(this.f44390c, m0Var, eVar);
            return new KeyPair(bCDSTU4145PublicKey, new BCDSTU4145PrivateKey(this.f44390c, l0Var, bCDSTU4145PublicKey, eVar));
        }
        if (obj == null) {
            return new KeyPair(new BCDSTU4145PublicKey(this.f44390c, m0Var), new BCDSTU4145PrivateKey(this.f44390c, l0Var));
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        BCDSTU4145PublicKey bCDSTU4145PublicKey2 = new BCDSTU4145PublicKey(this.f44390c, m0Var, eCParameterSpec);
        return new KeyPair(bCDSTU4145PublicKey2, new BCDSTU4145PrivateKey(this.f44390c, l0Var, bCDSTU4145PublicKey2, eCParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        this.f44392e = secureRandom;
        Object obj = this.f44388a;
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
        if (!(algorithmParameterSpec instanceof e)) {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                this.f44388a = algorithmParameterSpec;
                ir.e eVarA = h.a(eCParameterSpec.getCurve());
                i iVarD = h.d(eVarA, eCParameterSpec.getGenerator());
                if (eCParameterSpec instanceof g) {
                    this.f44391d = new i0(new d0(new g0(eVarA, iVarD, eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), ((g) eCParameterSpec).a()), secureRandom);
                } else {
                    this.f44391d = new i0(new g0(eVarA, iVarD, eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                }
                this.f44389b.a(this.f44391d);
            } else {
                boolean z10 = algorithmParameterSpec instanceof ECGenParameterSpec;
                if (!z10 && !(algorithmParameterSpec instanceof gr.b)) {
                    if (algorithmParameterSpec == null) {
                        uq.c cVar = BouncyCastleProvider.f45330c;
                        if (cVar.b() != null) {
                            e eVarB = cVar.b();
                            this.f44388a = algorithmParameterSpec;
                            i0Var = new i0(new g0(eVarB.a(), eVarB.b(), eVarB.d(), eVarB.c()), secureRandom);
                        }
                    }
                    if (algorithmParameterSpec == null && BouncyCastleProvider.f45330c.b() == null) {
                        throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                    }
                    throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec: " + algorithmParameterSpec.getClass().getName());
                }
                String name = z10 ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : ((gr.b) algorithmParameterSpec).a();
                g0 g0VarA = vn.c.a(new y(name));
                if (g0VarA == null) {
                    throw new InvalidAlgorithmParameterException("unknown curve name: " + name);
                }
                gr.d dVar = new gr.d(name, g0VarA.a(), g0VarA.b(), g0VarA.e(), g0VarA.c(), g0VarA.f());
                this.f44388a = dVar;
                gr.d dVar2 = dVar;
                ir.e eVarA2 = h.a(dVar2.getCurve());
                i0 i0Var2 = new i0(new g0(eVarA2, h.d(eVarA2, dVar2.getGenerator()), dVar2.getOrder(), BigInteger.valueOf(dVar2.getCofactor())), secureRandom);
                this.f44391d = i0Var2;
                this.f44389b.a(i0Var2);
            }
            this.f44393f = true;
        }
        e eVar = (e) algorithmParameterSpec;
        this.f44388a = algorithmParameterSpec;
        i0Var = new i0(new g0(eVar.a(), eVar.b(), eVar.d(), eVar.c()), secureRandom);
        this.f44391d = i0Var;
        this.f44389b.a(i0Var);
        this.f44393f = true;
    }
}
