package bt;

import gm.y;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import kn.d;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.s;
import org.bouncycastle.pqc.jcajce.provider.sphincs.BCSphincs256PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.sphincs.BCSphincs256PublicKey;
import rs.g;
import zo.g0;
import zo.h0;
import zo.i0;

/* JADX INFO: loaded from: classes6.dex */
public class a extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f9639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f9640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f9641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f9642d;

    /* JADX INFO: renamed from: bt.a$a, reason: collision with other inner class name */
    public static class C0101a extends a {
        public C0101a() {
            super(new g0(512), d.f37606j, new g(new g0(256), new g0(512)));
        }
    }

    public static class b extends a {
        public b() {
            super(new h0(), d.f37602h, new g(new i0(256), new h0()));
        }
    }

    public a(s sVar, y yVar, g gVar) {
        this.f9640b = sVar;
        this.f9639a = yVar;
        this.f9641c = gVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCSphincs256PrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
        }
        BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) privateKey;
        if (this.f9639a.C(bCSphincs256PrivateKey.b())) {
            k kVarA = bCSphincs256PrivateKey.a();
            this.f9640b.reset();
            this.f9641c.a(true, kVarA);
        } else {
            throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + bCSphincs256PrivateKey.b());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f9642d = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCSphincs256PublicKey)) {
            throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) publicKey;
        if (this.f9639a.C(bCSphincs256PublicKey.b())) {
            k kVarA = bCSphincs256PublicKey.a();
            this.f9640b.reset();
            this.f9641c.a(false, kVarA);
        } else {
            throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + bCSphincs256PublicKey.b());
        }
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
        byte[] bArr = new byte[this.f9640b.h()];
        this.f9640b.c(bArr, 0);
        try {
            return this.f9641c.b(bArr);
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f9640b.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f9640b.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f9640b.h()];
        this.f9640b.c(bArr2, 0);
        return this.f9641c.d(bArr2, bArr);
    }
}
