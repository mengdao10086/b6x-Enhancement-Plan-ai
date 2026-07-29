package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.l0;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseCipherSpi extends CipherSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class[] f45037a = {IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45038b = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlgorithmParameters f45039c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f45040d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f45042f;

    public static final class a extends ByteArrayOutputStream {
        public void a() {
            org.bouncycastle.util.a.d0(((ByteArrayOutputStream) this).buf, (byte) 0);
            reset();
        }

        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public final AlgorithmParameters a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f45038b.t(str);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
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
    public Key engineUnwrap(byte[] bArr, String str, int i10) throws InvalidKeyException {
        try {
            l0 l0Var = this.f45040d;
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
                KeyFactory keyFactoryB = this.f45038b.b(str);
                if (i10 == 1) {
                    return keyFactoryB.generatePublic(new X509EncodedKeySpec(bArrEngineDoFinal));
                }
                if (i10 == 2) {
                    return keyFactoryB.generatePrivate(new PKCS8EncodedKeySpec(bArrEngineDoFinal));
                }
                throw new InvalidKeyException("Unknown key type " + i10);
            } catch (NoSuchAlgorithmException e10) {
                throw new InvalidKeyException("Unknown key type " + e10.getMessage());
            } catch (NoSuchProviderException e11) {
                throw new InvalidKeyException("Unknown key type " + e11.getMessage());
            } catch (InvalidKeySpecException e12) {
                throw new InvalidKeyException("Unknown key type " + e12.getMessage());
            }
        } catch (BadPaddingException e13) {
            throw new InvalidKeyException("unable to unwrap") { // from class: org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi.1
                @Override // java.lang.Throwable
                public synchronized Throwable getCause() {
                    return e13;
                }
            };
        } catch (IllegalBlockSizeException e14) {
            throw new InvalidKeyException(e14.getMessage());
        } catch (InvalidCipherTextException e15) {
            throw new InvalidKeyException(e15.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try {
            l0 l0Var = this.f45040d;
            return l0Var == null ? engineDoFinal(encoded, 0, encoded.length) : l0Var.d(encoded, 0, encoded.length);
        } catch (BadPaddingException e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }
}
