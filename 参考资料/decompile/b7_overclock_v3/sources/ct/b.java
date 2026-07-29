package ct;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlgorithmParameterSpec f25912d;

    @Override // ct.c
    public final int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, ShortBufferException {
        if (bArr2.length < i(i11)) {
            throw new ShortBufferException("Output buffer too short.");
        }
        byte[] bArrD = d(bArr, i10, i11);
        System.arraycopy(bArrD, 0, bArr2, i12, bArrD.length);
        return bArrD.length;
    }

    @Override // ct.c
    public abstract byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException;

    @Override // ct.c
    public final int e() {
        return 0;
    }

    @Override // ct.c
    public final byte[] f() {
        return null;
    }

    @Override // ct.c
    public final int i(int i10) {
        return this.f25915a == 1 ? s(i10) : r(i10);
    }

    @Override // ct.c
    public final AlgorithmParameterSpec j() {
        return this.f25912d;
    }

    @Override // ct.c
    public final void k(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f25915a = 2;
        t(key, algorithmParameterSpec);
    }

    @Override // ct.c
    public final void l(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f25915a = 1;
        u(key, algorithmParameterSpec, secureRandom);
    }

    @Override // ct.c
    public final void m(String str) {
    }

    @Override // ct.c
    public final void n(String str) {
    }

    @Override // ct.c
    public final int o(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        if (bArr2.length < i(i11)) {
            throw new ShortBufferException("output");
        }
        byte[] bArrQ = q(bArr, i10, i11);
        System.arraycopy(bArrQ, 0, bArr2, i12, bArrQ.length);
        return bArrQ.length;
    }

    @Override // ct.c
    public abstract byte[] q(byte[] bArr, int i10, int i11);

    public abstract int r(int i10);

    public abstract int s(int i10);

    public abstract void t(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void u(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void v(Key key) throws InvalidKeyException {
        try {
            k(key, null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void w(Key key) throws InvalidKeyException {
        try {
            l(key, null, n.f());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void x(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            l(key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void y(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        l(key, algorithmParameterSpec, n.f());
    }
}
