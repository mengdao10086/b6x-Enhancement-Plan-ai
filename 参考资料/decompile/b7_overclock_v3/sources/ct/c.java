package ct;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends CipherSpi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25913b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25914c = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25915a;

    public abstract int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException;

    public final byte[] b() throws BadPaddingException, IllegalBlockSizeException {
        return d(null, 0, 0);
    }

    public final byte[] c(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        return d(bArr, 0, bArr.length);
    }

    public abstract byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException;

    public abstract int e();

    @Override // javax.crypto.CipherSpi
    public final int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        return a(bArr, i10, i11, bArr2, i12);
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        return d(bArr, i10, i11);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetBlockSize() {
        return e();
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineGetIV() {
        return f();
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof Key) {
            return g(key);
        }
        throw new InvalidKeyException("Unsupported key.");
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetOutputSize(int i10) {
        return i(i10);
    }

    @Override // javax.crypto.CipherSpi
    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i10, key, secureRandom);
        } else {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        }
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidParameterException(e10.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key == null) {
            throw new InvalidKeyException();
        }
        this.f25915a = i10;
        if (i10 == 1) {
            l(key, algorithmParameterSpec, secureRandom);
        } else if (i10 == 2) {
            k(key, algorithmParameterSpec);
        }
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        m(str);
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        n(str);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        return o(bArr, i10, i11, bArr2, i12);
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        return q(bArr, i10, i11);
    }

    public abstract byte[] f();

    public abstract int g(Key key) throws InvalidKeyException;

    public abstract String h();

    public abstract int i(int i10);

    public abstract AlgorithmParameterSpec j();

    public abstract void k(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void l(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void m(String str) throws NoSuchAlgorithmException;

    public abstract void n(String str) throws NoSuchPaddingException;

    public abstract int o(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException;

    public final byte[] p(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    public abstract byte[] q(byte[] bArr, int i10, int i11);
}
