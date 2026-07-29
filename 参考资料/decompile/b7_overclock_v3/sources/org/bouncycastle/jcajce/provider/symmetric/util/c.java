package org.bouncycastle.jcajce.provider.symmetric.util;

import ar.i;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.k0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.d;

/* JADX INFO: loaded from: classes5.dex */
public class c extends BaseWrapCipher implements d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Class[] f45217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k0 f45218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f45219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f45220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v1 f45221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f45222r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PBEParameterSpec f45223s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f45224t;

    public c(k0 k0Var, int i10) {
        this(k0Var, i10, -1, -1);
    }

    public c(k0 k0Var, int i10, int i11) {
        this(k0Var, i10, i11, -1);
    }

    public c(k0 k0Var, int i10, int i11, int i12) {
        this.f45217m = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f45223s = null;
        this.f45224t = null;
        this.f45218n = k0Var;
        this.f45222r = i10;
        this.f45219o = i11;
        this.f45220p = i12;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (i12 + i11 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        if (i11 != 0) {
            this.f45218n.e(bArr, i10, i11, bArr2, i12);
        }
        this.f45218n.reset();
        return i11;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            this.f45218n.reset();
            return new byte[0];
        }
        byte[] bArrEngineUpdate = engineUpdate(bArr, i10, i11);
        this.f45218n.reset();
        return bArrEngineUpdate;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        v1 v1Var = this.f45221q;
        if (v1Var != null) {
            return v1Var.a();
        }
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        return i10;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f45186f == null) {
            if (this.f45223s != null) {
                try {
                    AlgorithmParameters algorithmParametersA = a(this.f45224t);
                    algorithmParametersA.init(this.f45223s);
                    return algorithmParametersA;
                } catch (Exception unused) {
                    return null;
                }
            }
            if (this.f45221q != null) {
                String strB = this.f45218n.b();
                if (strB.indexOf(47) >= 0) {
                    strB = strB.substring(0, strB.indexOf(47));
                }
                if (strB.startsWith("ChaCha7539")) {
                    strB = "ChaCha7539";
                } else if (strB.startsWith("Grain")) {
                    strB = "Grainv1";
                } else if (strB.startsWith("HC")) {
                    int iIndexOf = strB.indexOf(45);
                    strB = strB.substring(0, iIndexOf) + strB.substring(iIndexOf + 1);
                }
                try {
                    AlgorithmParameters algorithmParametersA2 = a(strB);
                    this.f45186f = algorithmParametersA2;
                    algorithmParametersA2.init(new IvParameterSpec(this.f45221q.a()));
                } catch (Exception e10) {
                    throw new RuntimeException(e10.toString());
                }
            }
        }
        return this.f45186f;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecA;
        if (algorithmParameters != null) {
            algorithmParameterSpecA = i.a(algorithmParameters, this.f45217m);
            if (algorithmParameterSpecA == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpecA = null;
        }
        engineInit(i10, key, algorithmParameterSpecA, secureRandom);
        this.f45186f = algorithmParameters;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        k kVarH;
        k n1Var;
        this.f45223s = null;
        this.f45224t = null;
        this.f45186f = null;
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
        }
        if (key instanceof PKCS12Key) {
            PKCS12Key pKCS12Key = (PKCS12Key) key;
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            this.f45223s = pBEParameterSpec;
            if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                this.f45223s = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
            }
            kVarH = d.a.h(pKCS12Key.getEncoded(), 2, this.f45220p, this.f45219o, this.f45222r * 8, this.f45223s, this.f45218n.b());
        } else {
            if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                this.f45224t = bCPBEKey.f() != null ? bCPBEKey.f().L() : bCPBEKey.getAlgorithm();
                if (bCPBEKey.h() != null) {
                    n1Var = bCPBEKey.h();
                    this.f45223s = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                } else {
                    if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    k kVarG = d.a.g(bCPBEKey, algorithmParameterSpec, this.f45218n.b());
                    this.f45223s = (PBEParameterSpec) algorithmParameterSpec;
                    n1Var = kVarG;
                }
                if (bCPBEKey.c() != 0) {
                    this.f45221q = (v1) n1Var;
                }
            } else if (algorithmParameterSpec == null) {
                if (this.f45220p > 0) {
                    throw new InvalidKeyException("Algorithm requires a PBE key");
                }
                n1Var = new n1(key.getEncoded());
            } else {
                if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                v1 v1Var = new v1(new n1(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.f45221q = v1Var;
                kVarH = v1Var;
            }
            kVarH = n1Var;
        }
        if (this.f45222r != 0 && !(kVarH instanceof v1)) {
            if (secureRandom == null) {
                secureRandom = n.f();
            }
            if (i10 != 1 && i10 != 3) {
                throw new InvalidAlgorithmParameterException("no IV set when one expected");
            }
            byte[] bArr = new byte[this.f45222r];
            secureRandom.nextBytes(bArr);
            v1 v1Var2 = new v1(kVarH, bArr);
            this.f45221q = v1Var2;
            kVarH = v1Var2;
        }
        try {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new InvalidParameterException("unknown opmode " + i10 + " passed");
                        }
                    }
                }
                this.f45218n.a(false, kVarH);
                return;
            }
            this.f45218n.a(true, kVarH);
        } catch (Exception e10) {
            throw new InvalidKeyException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (str.equalsIgnoreCase("ECB") || str.equals(HlsPlaylistParser.M)) {
            return;
        }
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (str.equalsIgnoreCase("NoPadding")) {
            return;
        }
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (i12 + i11 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        try {
            this.f45218n.e(bArr, i10, i11, bArr2, i12);
            return i11;
        } catch (DataLengthException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f45218n.e(bArr, i10, i11, bArr2, 0);
        return bArr2;
    }
}
