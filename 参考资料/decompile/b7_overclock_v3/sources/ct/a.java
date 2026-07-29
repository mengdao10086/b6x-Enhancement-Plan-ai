package ct;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlgorithmParameterSpec f25908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteArrayOutputStream f25909e = new ByteArrayOutputStream();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25911g;

    @Override // ct.c
    public final int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (bArr2.length < i(i11)) {
            throw new ShortBufferException("Output buffer too short.");
        }
        byte[] bArrD = d(bArr, i10, i11);
        System.arraycopy(bArrD, 0, bArr2, i12, bArrD.length);
        return bArrD.length;
    }

    @Override // ct.c
    public final byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        r(i11);
        q(bArr, i10, i11);
        byte[] byteArray = this.f25909e.toByteArray();
        this.f25909e.reset();
        int i12 = this.f25915a;
        if (i12 == 1) {
            return z(byteArray);
        }
        if (i12 != 2) {
            return null;
        }
        return y(byteArray);
    }

    @Override // ct.c
    public final int e() {
        return this.f25915a == 1 ? this.f25910f : this.f25911g;
    }

    @Override // ct.c
    public final byte[] f() {
        return null;
    }

    @Override // ct.c
    public final int i(int i10) {
        if (i10 + this.f25909e.size() > e()) {
            return 0;
        }
        return this.f25915a == 1 ? this.f25911g : this.f25910f;
    }

    @Override // ct.c
    public final AlgorithmParameterSpec j() {
        return this.f25908d;
    }

    @Override // ct.c
    public final void k(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f25915a = 2;
        s(key, algorithmParameterSpec);
    }

    @Override // ct.c
    public final void l(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f25915a = 1;
        t(key, algorithmParameterSpec, secureRandom);
    }

    @Override // ct.c
    public final void m(String str) {
    }

    @Override // ct.c
    public final void n(String str) {
    }

    @Override // ct.c
    public final int o(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        q(bArr, i10, i11);
        return 0;
    }

    @Override // ct.c
    public final byte[] q(byte[] bArr, int i10, int i11) {
        if (i11 != 0) {
            this.f25909e.write(bArr, i10, i11);
        }
        return new byte[0];
    }

    public void r(int i10) throws IllegalBlockSizeException {
        int size = i10 + this.f25909e.size();
        int i11 = this.f25915a;
        if (i11 == 1) {
            if (size <= this.f25910f) {
                return;
            }
            throw new IllegalBlockSizeException("The length of the plaintext (" + size + " bytes) is not supported by the cipher (max. " + this.f25910f + " bytes).");
        }
        if (i11 != 2 || size == this.f25911g) {
            return;
        }
        throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.f25911g + " bytes, was " + size + " bytes).");
    }

    public abstract void s(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void t(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void u(Key key) throws InvalidKeyException {
        try {
            k(key, null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void v(Key key) throws InvalidKeyException {
        try {
            l(key, null, n.f());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void w(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            l(key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void x(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        l(key, algorithmParameterSpec, n.f());
    }

    public abstract byte[] y(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException;

    public abstract byte[] z(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException;
}
