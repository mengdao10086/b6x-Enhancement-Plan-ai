package tq;

import cp.x0;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.s;
import rp.a0;
import zo.q0;
import zo.y;
import zo.z;

/* JADX INFO: loaded from: classes7.dex */
public class i extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f51610a;

    public static class a extends i {
        public a() {
            super(new y(), new x0());
        }
    }

    public static class b extends i {
        public b() {
            super(new z(), new x0());
        }
    }

    public static class c extends i {
        public c() {
            super(org.bouncycastle.crypto.util.f.c(), new x0());
        }
    }

    public static class d extends i {
        public d() {
            super(org.bouncycastle.crypto.util.f.d(), new x0());
        }
    }

    public static class e extends i {
        public e() {
            super(org.bouncycastle.crypto.util.f.e(), new x0());
        }
    }

    public static class f extends i {
        public f() {
            super(org.bouncycastle.crypto.util.f.f(), new x0());
        }
    }

    public static class g extends i {
        public g() {
            super(org.bouncycastle.crypto.util.f.k(), new x0());
        }
    }

    public static class h extends i {
        public h() {
            super(org.bouncycastle.crypto.util.f.l(), new x0());
        }
    }

    /* JADX INFO: renamed from: tq.i$i, reason: collision with other inner class name */
    public static class C0591i extends i {
        public C0591i() {
            super(org.bouncycastle.crypto.util.f.m(), new x0());
        }
    }

    public static class j extends i {
        public j() {
            super(new q0(), new x0());
        }
    }

    public i(s sVar, org.bouncycastle.crypto.b bVar) {
        this.f51610a = new a0(bVar, sVar);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.f51610a.a(true, tq.h.c((RSAPrivateKey) privateKey));
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.f51610a.a(false, tq.h.d((RSAPublicKey) publicKey));
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f51610a.e();
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f51610a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f51610a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f51610a.d(bArr);
    }
}
