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
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes6.dex */
public class e extends ct.b implements s, z1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.s f56115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ms.j f56116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f56117g = new ByteArrayOutputStream();

    public static class a extends e {
        public a() {
            super(org.bouncycastle.crypto.util.f.c(), new ms.j());
        }
    }

    public e(org.bouncycastle.crypto.s sVar, ms.j jVar) {
        this.f56115e = sVar;
        this.f56116f = jVar;
    }

    @Override // ct.b, ct.c
    public byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException {
        q(bArr, i10, i11);
        byte[] byteArray = this.f56117g.toByteArray();
        this.f56117g.reset();
        int i12 = this.f25915a;
        if (i12 == 1) {
            return this.f56116f.c(byteArray);
        }
        if (i12 != 2) {
            throw new IllegalStateException("unknown mode in doFinal");
        }
        try {
            return this.f56116f.b(byteArray);
        } catch (InvalidCipherTextException e10) {
            throw new BadPaddingException(e10.getMessage());
        }
    }

    @Override // ct.c
    public int g(Key key) throws InvalidKeyException {
        return this.f56116f.d((ms.d) (key instanceof PublicKey ? c.b((PublicKey) key) : c.a((PrivateKey) key)));
    }

    @Override // ct.c
    public String h() {
        return "McElieceFujisakiCipher";
    }

    @Override // ct.b, ct.c
    public byte[] q(byte[] bArr, int i10, int i11) {
        this.f56117g.write(bArr, i10, i11);
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
        np.c cVarA = c.a((PrivateKey) key);
        this.f56115e.reset();
        this.f56116f.a(false, cVarA);
    }

    @Override // ct.b
    public void u(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        w1 w1Var = new w1(c.b((PublicKey) key), secureRandom);
        this.f56115e.reset();
        this.f56116f.a(true, w1Var);
    }
}
