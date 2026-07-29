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
import rp.s;
import zo.q0;
import zo.z;

/* JADX INFO: loaded from: classes7.dex */
public class d extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f51584a;

    public static class a extends d {
        public a() {
            super(org.bouncycastle.crypto.util.f.b(), new x0());
        }
    }

    public static class b extends d {
        public b() {
            super(new z(), new x0());
        }
    }

    public static class c extends d {
        public c() {
            super(org.bouncycastle.crypto.util.f.c(), new x0());
        }
    }

    /* JADX INFO: renamed from: tq.d$d, reason: collision with other inner class name */
    public static class C0589d extends d {
        public C0589d() {
            super(org.bouncycastle.crypto.util.f.d(), new x0());
        }
    }

    public static class e extends d {
        public e() {
            super(org.bouncycastle.crypto.util.f.e(), new x0());
        }
    }

    public static class f extends d {
        public f() {
            super(org.bouncycastle.crypto.util.f.f(), new x0());
        }
    }

    public static class g extends d {
        public g() {
            super(org.bouncycastle.crypto.util.f.k(), new x0());
        }
    }

    public static class h extends d {
        public h() {
            super(org.bouncycastle.crypto.util.f.l(), new x0());
        }
    }

    public static class i extends d {
        public i() {
            super(org.bouncycastle.crypto.util.f.m(), new x0());
        }
    }

    public static class j extends d {
        public j() {
            super(new q0(), new x0());
        }
    }

    public d(org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.b bVar) {
        this.f51584a = new s(bVar, sVar, true);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.f51584a.a(true, tq.h.c((RSAPrivateKey) privateKey));
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.f51584a.a(false, tq.h.d((RSAPublicKey) publicKey));
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
            return this.f51584a.e();
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f51584a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f51584a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f51584a.d(bArr);
    }
}
