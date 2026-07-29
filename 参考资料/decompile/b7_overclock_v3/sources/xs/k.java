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
import ms.p;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes6.dex */
public class k extends ct.b implements s, z1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.s f56124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f56125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f56126g;

    public static class a extends k {
        public a() {
            super(org.bouncycastle.crypto.util.f.d(), new p());
        }
    }

    public static class b extends k {
        public b() {
            super(org.bouncycastle.crypto.util.f.e(), new p());
        }
    }

    public static class c extends k {
        public c() {
            super(org.bouncycastle.crypto.util.f.f(), new p());
        }
    }

    public static class d extends k {
        public d() {
            super(org.bouncycastle.crypto.util.f.k(), new p());
        }
    }

    public static class e extends k {
        public e() {
            super(org.bouncycastle.crypto.util.f.c(), new p());
        }
    }

    public k(org.bouncycastle.crypto.s sVar, p pVar) {
        this.f56126g = new ByteArrayOutputStream();
        this.f56124e = sVar;
        this.f56125f = pVar;
        this.f56126g = new ByteArrayOutputStream();
    }

    @Override // ct.b, ct.c
    public byte[] d(byte[] bArr, int i10, int i11) throws BadPaddingException {
        q(bArr, i10, i11);
        byte[] byteArray = this.f56126g.toByteArray();
        this.f56126g.reset();
        int i12 = this.f25915a;
        if (i12 == 1) {
            return this.f56125f.c(byteArray);
        }
        if (i12 != 2) {
            return null;
        }
        try {
            return this.f56125f.b(byteArray);
        } catch (InvalidCipherTextException e10) {
            throw new BadPaddingException(e10.getMessage());
        }
    }

    @Override // ct.c
    public int g(Key key) throws InvalidKeyException {
        return this.f56125f.f((ms.d) (key instanceof PublicKey ? xs.c.b((PublicKey) key) : xs.c.a((PrivateKey) key)));
    }

    @Override // ct.c
    public String h() {
        return "McEliecePointchevalCipher";
    }

    @Override // ct.b, ct.c
    public byte[] q(byte[] bArr, int i10, int i11) {
        this.f56126g.write(bArr, i10, i11);
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
        np.c cVarA = xs.c.a((PrivateKey) key);
        this.f56124e.reset();
        this.f56125f.a(false, cVarA);
    }

    @Override // ct.b
    public void u(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        w1 w1Var = new w1(xs.c.b((PublicKey) key), secureRandom);
        this.f56124e.reset();
        this.f56125f.a(true, w1Var);
    }
}
