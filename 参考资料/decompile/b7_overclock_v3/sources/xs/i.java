package xs;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import ms.n;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes6.dex */
public class i extends ct.b implements s, z1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.s f56120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f56121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f56122g;

    public static class a extends i {
        public a() {
            super(org.bouncycastle.crypto.util.f.d(), new n());
        }
    }

    public static class b extends i {
        public b() {
            super(org.bouncycastle.crypto.util.f.e(), new n());
        }
    }

    public static class c extends i {
        public c() {
            super(org.bouncycastle.crypto.util.f.f(), new n());
        }
    }

    public static class d extends i {
        public d() {
            super(org.bouncycastle.crypto.util.f.k(), new n());
        }
    }

    public static class e extends i {
        public e() {
            super(org.bouncycastle.crypto.util.f.c(), new n());
        }
    }

    public i() {
        this.f56122g = new ByteArrayOutputStream();
        this.f56122g = new ByteArrayOutputStream();
    }

    public i(org.bouncycastle.crypto.s sVar, n nVar) {
        this.f56122g = new ByteArrayOutputStream();
        this.f56120e = sVar;
        this.f56121f = nVar;
        this.f56122g = new ByteArrayOutputStream();
    }

    public final byte[] A(byte[] bArr) throws BadPaddingException {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        if (bArr[length] != 1) {
            throw new BadPaddingException("invalid ciphertext");
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // ct.b, ct.c
    public byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException {
        q(bArr, i10, i11);
        int i12 = this.f25915a;
        if (i12 == 1) {
            return this.f56121f.c(z());
        }
        if (i12 != 2) {
            throw new IllegalStateException("unknown mode in doFinal");
        }
        try {
            byte[] byteArray = this.f56122g.toByteArray();
            this.f56122g.reset();
            return A(this.f56121f.b(byteArray));
        } catch (InvalidCipherTextException e10) {
            throw new BadPaddingException(e10.getMessage());
        }
    }

    @Override // ct.c
    public int g(Key key) throws InvalidKeyException {
        np.c cVarA;
        if (key instanceof PublicKey) {
            cVarA = xs.c.b((PublicKey) key);
        } else {
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException();
            }
            cVarA = xs.c.a((PrivateKey) key);
        }
        return this.f56121f.d((ms.d) cVarA);
    }

    @Override // ct.c
    public String h() {
        return "McElieceKobaraImaiCipher";
    }

    @Override // ct.b, ct.c
    public byte[] q(byte[] bArr, int i10, int i11) {
        this.f56122g.write(bArr, i10, i11);
        return new byte[0];
    }

    @Override // ct.b
    public int r(int i10) {
        return 0;
    }

    @Override // ct.b
    public int s(int i10) {
        return 0;
    }

    @Override // ct.b
    public void t(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f56122g.reset();
        np.c cVarA = xs.c.a((PrivateKey) key);
        this.f56120e.reset();
        this.f56121f.a(false, cVarA);
    }

    @Override // ct.b
    public void u(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f56122g.reset();
        w1 w1Var = new w1(xs.c.b((PublicKey) key), secureRandom);
        this.f56120e.reset();
        this.f56121f.a(true, w1Var);
    }

    public final byte[] z() {
        this.f56122g.write(1);
        byte[] byteArray = this.f56122g.toByteArray();
        this.f56122g.reset();
        return byteArray;
    }
}
