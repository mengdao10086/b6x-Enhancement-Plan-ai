package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import fp.m;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;
import np.a0;
import np.b0;
import np.w;
import np.y;
import np.z;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.j;
import org.bouncycastle.util.p;
import zo.e0;

/* JADX INFO: loaded from: classes7.dex */
public class e extends KeyPairGenerator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Hashtable f44901f = new Hashtable();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Object f44902g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f44903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f44904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f44906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f44907e;

    public e() {
        super("DSA");
        this.f44904b = new m();
        this.f44905c = 2048;
        this.f44906d = n.f();
        this.f44907e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        fp.n nVar;
        int i10;
        SecureRandom secureRandom;
        if (!this.f44907e) {
            Integer numG = j.g(this.f44905c);
            if (f44901f.containsKey(numG)) {
                this.f44903a = (w) f44901f.get(numG);
            } else {
                synchronized (f44902g) {
                    if (f44901f.containsKey(numG)) {
                        this.f44903a = (w) f44901f.get(numG);
                    } else {
                        int iA = org.bouncycastle.jcajce.provider.asymmetric.util.n.a(this.f44905c);
                        int i11 = this.f44905c;
                        if (i11 == 1024) {
                            nVar = new fp.n();
                            if (p.d("org.bouncycastle.dsa.FIPS186-2for1024bits")) {
                                i10 = this.f44905c;
                                secureRandom = this.f44906d;
                                nVar.k(i10, iA, secureRandom);
                                w wVar = new w(this.f44906d, nVar.d());
                                this.f44903a = wVar;
                                f44901f.put(numG, wVar);
                            } else {
                                nVar.l(new y(1024, 160, iA, this.f44906d));
                                w wVar2 = new w(this.f44906d, nVar.d());
                                this.f44903a = wVar2;
                                f44901f.put(numG, wVar2);
                            }
                        } else if (i11 > 1024) {
                            y yVar = new y(i11, 256, iA, this.f44906d);
                            nVar = new fp.n(new e0());
                            nVar.l(yVar);
                            w wVar22 = new w(this.f44906d, nVar.d());
                            this.f44903a = wVar22;
                            f44901f.put(numG, wVar22);
                        } else {
                            nVar = new fp.n();
                            i10 = this.f44905c;
                            secureRandom = this.f44906d;
                            nVar.k(i10, iA, secureRandom);
                            w wVar222 = new w(this.f44906d, nVar.d());
                            this.f44903a = wVar222;
                            f44901f.put(numG, wVar222);
                        }
                    }
                }
            }
            this.f44904b.a(this.f44903a);
            this.f44907e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f44904b.b();
        return new KeyPair(new BCDSAPublicKey((b0) cVarB.b()), new BCDSAPrivateKey((a0) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        boolean z10;
        if (i10 < 512 || i10 > 4096 || ((i10 < 1024 && i10 % 64 != 0) || (i10 >= 1024 && i10 % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        DSAParameterSpec dSAParameterSpecD = BouncyCastleProvider.f45330c.d(i10);
        if (dSAParameterSpecD != null) {
            w wVar = new w(secureRandom, new z(dSAParameterSpecD.getP(), dSAParameterSpecD.getQ(), dSAParameterSpecD.getG()));
            this.f44903a = wVar;
            this.f44904b.a(wVar);
            z10 = true;
        } else {
            this.f44905c = i10;
            this.f44906d = secureRandom;
            z10 = false;
        }
        this.f44907e = z10;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
        }
        DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
        w wVar = new w(secureRandom, new z(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
        this.f44903a = wVar;
        this.f44904b.a(wVar);
        this.f44907e = true;
    }
}
