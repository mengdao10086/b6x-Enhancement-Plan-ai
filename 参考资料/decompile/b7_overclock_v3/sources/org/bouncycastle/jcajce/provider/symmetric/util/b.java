package org.bouncycastle.jcajce.provider.symmetric.util;

import ar.f;
import ar.g;
import cr.u;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import np.a2;
import np.j2;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.a0;
import org.bouncycastle.crypto.k;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.provider.symmetric.util.d;

/* JADX INFO: loaded from: classes5.dex */
public class b extends MacSpi implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class f45212e = f.a(b.class, "javax.crypto.spec.GCMParameterSpec");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f45213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45216d;

    public b(a0 a0Var) {
        this.f45214b = 2;
        this.f45215c = 1;
        this.f45216d = 160;
        this.f45213a = a0Var;
    }

    public b(a0 a0Var, int i10, int i11, int i12) {
        this.f45213a = a0Var;
        this.f45214b = i10;
        this.f45215c = i11;
        this.f45216d = i12;
    }

    public static Hashtable a(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object obj : map.keySet()) {
            hashtable.put(obj, map.get(obj));
        }
        return hashtable;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.f45213a.c(bArr, 0);
        return bArr;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.f45213a.d();
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        k kVarC;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key instanceof PKCS12Key) {
            try {
                SecretKey secretKey = (SecretKey) key;
                try {
                    PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                    if ((secretKey instanceof PBEKey) && pBEParameterSpec == null) {
                        PBEKey pBEKey = (PBEKey) secretKey;
                        pBEParameterSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                    }
                    int i10 = 1;
                    int i11 = 256;
                    if (this.f45213a.b().startsWith("GOST")) {
                        i10 = 6;
                    } else {
                        a0 a0Var = this.f45213a;
                        if (!(a0Var instanceof ip.k) || a0Var.b().startsWith(et.e.f27137f)) {
                            i11 = 160;
                        } else if (this.f45213a.b().startsWith(et.e.f27138g)) {
                            i10 = 7;
                            i11 = 224;
                        } else if (this.f45213a.b().startsWith("SHA-256")) {
                            i10 = 4;
                        } else if (this.f45213a.b().startsWith(et.e.f27140i)) {
                            i10 = 8;
                            i11 = 384;
                        } else if (this.f45213a.b().startsWith("SHA-512")) {
                            i10 = 9;
                            i11 = 512;
                        } else {
                            if (!this.f45213a.b().startsWith("RIPEMD160")) {
                                throw new InvalidAlgorithmParameterException("no PKCS12 mapping for HMAC: " + this.f45213a.b());
                            }
                            i10 = 2;
                            i11 = 160;
                        }
                    }
                    kVarC = d.a.c(secretKey, 2, i10, i11, pBEParameterSpec);
                } catch (Exception unused) {
                    throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
                }
            } catch (Exception unused2) {
                throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
            }
        } else if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (bCPBEKey.h() != null) {
                kVarC = bCPBEKey.h();
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                kVarC = d.a.e(bCPBEKey, algorithmParameterSpec);
            }
        } else {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                throw new InvalidAlgorithmParameterException("inappropriate parameter type: " + algorithmParameterSpec.getClass().getName());
            }
            kVarC = new n1(key.getEncoded());
        }
        n1 n1Var = kVarC instanceof v1 ? (n1) ((v1) kVarC).b() : (n1) kVarC;
        if (algorithmParameterSpec instanceof cr.a) {
            cr.a aVar = (cr.a) algorithmParameterSpec;
            kVarC = new np.a(n1Var, aVar.b(), aVar.c(), aVar.a());
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            kVarC = new v1(n1Var, ((IvParameterSpec) algorithmParameterSpec).getIV());
        } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
            RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
            kVarC = new v1(new a2(n1Var.a(), rC2ParameterSpec.getEffectiveKeyBits()), rC2ParameterSpec.getIV());
        } else if (algorithmParameterSpec instanceof u) {
            kVarC = new j2.b(a(((u) algorithmParameterSpec).e())).c(n1Var.a()).a();
        } else if (algorithmParameterSpec == null) {
            kVarC = new n1(key.getEncoded());
        } else {
            Class cls = f45212e;
            if (cls != null && cls.isAssignableFrom(algorithmParameterSpec.getClass())) {
                kVarC = g.a(n1Var, algorithmParameterSpec);
            } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidAlgorithmParameterException("unknown parameter type: " + algorithmParameterSpec.getClass().getName());
            }
        }
        try {
            this.f45213a.a(kVarC);
        } catch (Exception e10) {
            throw new InvalidAlgorithmParameterException("cannot initialize MAC: " + e10.getMessage());
        }
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        this.f45213a.reset();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b10) {
        this.f45213a.update(b10);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) {
        this.f45213a.update(bArr, i10, i11);
    }
}
