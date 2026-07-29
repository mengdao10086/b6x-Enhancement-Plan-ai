package xs;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import ms.m;
import np.w1;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes6.dex */
public class j extends ct.a implements s, z1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ms.i f56123h;

    public static class a extends j {
        public a() {
            super(new ms.i());
        }
    }

    public j(ms.i iVar) {
        this.f56123h = iVar;
    }

    @Override // ct.c
    public int g(Key key) throws InvalidKeyException {
        return this.f56123h.f((m) (key instanceof PublicKey ? h.b((PublicKey) key) : h.a((PrivateKey) key)));
    }

    @Override // ct.c
    public String h() {
        return "McEliecePKCS";
    }

    @Override // ct.a
    public void s(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f56123h.a(false, h.a((PrivateKey) key));
        ms.i iVar = this.f56123h;
        this.f25910f = iVar.f41623e;
        this.f25911g = iVar.f41624f;
    }

    @Override // ct.a
    public void t(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f56123h.a(true, new w1(h.b((PublicKey) key), secureRandom));
        ms.i iVar = this.f56123h;
        this.f25910f = iVar.f41623e;
        this.f25911g = iVar.f41624f;
    }

    @Override // ct.a
    public byte[] y(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        try {
            return this.f56123h.b(bArr);
        } catch (Exception e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }

    @Override // ct.a
    public byte[] z(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        try {
            return this.f56123h.c(bArr);
        } catch (Exception e10) {
            throw new IllegalBlockSizeException(e10.getMessage());
        }
    }
}
