package org.bouncycastle.jcajce.provider.symmetric.util;

import ar.i;
import cr.k;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import np.n1;
import np.v1;
import np.w1;
import np.x1;
import np.z1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.l0;
import org.bouncycastle.jcajce.provider.symmetric.util.d;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseWrapCipher extends CipherSpi implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class[] f45181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlgorithmParameters f45186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l0 f45187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f45188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f45189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f45190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f45191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45192l;

    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        public InvalidKeyOrParametersException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public static final class a extends ByteArrayOutputStream {
        public void a() {
            org.bouncycastle.util.a.d0(((ByteArrayOutputStream) this).buf, (byte) 0);
            reset();
        }

        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public BaseWrapCipher() {
        this.f45181a = new Class[]{k.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.f45182b = 2;
        this.f45183c = 1;
        this.f45186f = null;
        this.f45187g = null;
        this.f45190j = null;
        this.f45192l = new org.bouncycastle.jcajce.util.b();
    }

    public BaseWrapCipher(l0 l0Var) {
        this(l0Var, 0);
    }

    public BaseWrapCipher(l0 l0Var, int i10) {
        this.f45181a = new Class[]{k.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.f45182b = 2;
        this.f45183c = 1;
        this.f45186f = null;
        this.f45187g = null;
        this.f45190j = null;
        this.f45192l = new org.bouncycastle.jcajce.util.b();
        this.f45187g = l0Var;
        this.f45188h = i10;
    }

    public final AlgorithmParameters a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f45192l.t(str);
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArrC;
        a aVar = this.f45190j;
        if (aVar == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        aVar.write(bArr, i10, i11);
        try {
            if (this.f45191k) {
                try {
                    bArrC = this.f45187g.d(this.f45190j.c(), 0, this.f45190j.size());
                } catch (Exception e10) {
                    throw new IllegalBlockSizeException(e10.getMessage());
                }
            } else {
                try {
                    bArrC = this.f45187g.c(this.f45190j.c(), 0, this.f45190j.size());
                } catch (InvalidCipherTextException e11) {
                    throw new BadPaddingException(e11.getMessage());
                }
            }
            if (bArrC.length + i12 > bArr2.length) {
                throw new ShortBufferException("output buffer too short for input.");
            }
            System.arraycopy(bArrC, 0, bArr2, i12, bArrC.length);
            return bArrC.length;
        } finally {
            this.f45190j.a();
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrC;
        a aVar = this.f45190j;
        if (aVar == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        if (bArr != null) {
            aVar.write(bArr, i10, i11);
        }
        try {
            if (this.f45191k) {
                try {
                    bArrC = this.f45187g.d(this.f45190j.c(), 0, this.f45190j.size());
                } catch (Exception e10) {
                    throw new IllegalBlockSizeException(e10.getMessage());
                }
            } else {
                try {
                    bArrC = this.f45187g.c(this.f45190j.c(), 0, this.f45190j.size());
                } catch (InvalidCipherTextException e11) {
                    throw new BadPaddingException(e11.getMessage());
                }
            }
            return bArrC;
        } finally {
            this.f45190j.a();
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return org.bouncycastle.util.a.p(this.f45189i);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f45186f == null && this.f45189i != null) {
            String strB = this.f45187g.b();
            if (strB.indexOf(47) >= 0) {
                strB = strB.substring(0, strB.indexOf(47));
            }
            try {
                AlgorithmParameters algorithmParametersA = a(strB);
                this.f45186f = algorithmParametersA;
                algorithmParametersA.init(new IvParameterSpec(this.f45189i));
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f45186f;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecA;
        if (algorithmParameters != null) {
            algorithmParameterSpecA = i.a(algorithmParameters, this.f45181a);
            if (algorithmParameterSpecA == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpecA = null;
        }
        this.f45186f = algorithmParameters;
        engineInit(i10, key, algorithmParameterSpecA, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyOrParametersException(e10.getMessage(), e10);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        org.bouncycastle.crypto.k n1Var;
        int i11;
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                n1Var = d.a.g(bCPBEKey, algorithmParameterSpec, this.f45187g.b());
            } else {
                if (bCPBEKey.h() == null) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                n1Var = bCPBEKey.h();
            }
        } else {
            n1Var = new n1(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            byte[] iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            this.f45189i = iv;
            n1Var = new v1(n1Var, iv);
        }
        if (algorithmParameterSpec instanceof k) {
            k kVar = (k) algorithmParameterSpec;
            byte[] bArrB = kVar.b();
            if (bArrB != null) {
                n1Var = new x1(n1Var, bArrB);
            }
            n1Var = new z1(n1Var, kVar.c());
        }
        if ((n1Var instanceof n1) && (i11 = this.f45188h) != 0 && (i10 == 3 || i10 == 1)) {
            byte[] bArr = new byte[i11];
            this.f45189i = bArr;
            secureRandom.nextBytes(bArr);
            n1Var = new v1(n1Var, this.f45189i);
        }
        if (secureRandom != null) {
            n1Var = new w1(n1Var, secureRandom);
        }
        try {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f45187g.a(false, n1Var);
                    this.f45190j = new a();
                } else if (i10 == 3) {
                    this.f45187g.a(true, n1Var);
                    this.f45190j = null;
                } else {
                    if (i10 != 4) {
                        throw new InvalidParameterException("Unknown mode parameter passed to init.");
                    }
                    this.f45187g.a(false, n1Var);
                    this.f45190j = null;
                }
                this.f45191k = false;
                return;
            }
            this.f45187g.a(true, n1Var);
            this.f45190j = new a();
            this.f45191k = true;
        } catch (Exception e10) {
            throw new InvalidKeyOrParametersException(e10.getMessage(), e10);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i10) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            l0 l0Var = this.f45187g;
            byte[] bArrEngineDoFinal = l0Var == null ? engineDoFinal(bArr, 0, bArr.length) : l0Var.c(bArr, 0, bArr.length);
            if (i10 == 3) {
                return new SecretKeySpec(bArrEngineDoFinal, str);
            }
            if (str.equals("") && i10 == 2) {
                try {
                    u uVarZ = u.z(bArrEngineDoFinal);
                    PrivateKey privateKeyO = BouncyCastleProvider.o(uVarZ);
                    if (privateKeyO != null) {
                        return privateKeyO;
                    }
                    throw new InvalidKeyException("algorithm " + uVarZ.B().x() + " not supported");
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
            try {
                KeyFactory keyFactoryB = this.f45192l.b(str);
                if (i10 == 1) {
                    return keyFactoryB.generatePublic(new X509EncodedKeySpec(bArrEngineDoFinal));
                }
                if (i10 == 2) {
                    return keyFactoryB.generatePrivate(new PKCS8EncodedKeySpec(bArrEngineDoFinal));
                }
                throw new InvalidKeyException("Unknown key type " + i10);
            } catch (NoSuchProviderException e10) {
                throw new InvalidKeyException("Unknown key type " + e10.getMessage());
            } catch (InvalidKeySpecException e11) {
                throw new InvalidKeyException("Unknown key type " + e11.getMessage());
            }
        } catch (BadPaddingException e12) {
            throw new InvalidKeyException(e12.getMessage());
        } catch (IllegalBlockSizeException e13) {
            throw new InvalidKeyException(e13.getMessage());
        } catch (InvalidCipherTextException e14) {
            throw new InvalidKeyException(e14.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        a aVar = this.f45190j;
        if (aVar == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        aVar.write(bArr, i10, i11);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        a aVar = this.f45190j;
        if (aVar == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        aVar.write(bArr, i10, i11);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try {
            l0 l0Var = this.f45187g;
            return l0Var == null ? engineDoFinal(encoded, 0, encoded.length) : l0Var.d(encoded, 0, encoded.length);
        } catch (BadPaddingException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }
}
