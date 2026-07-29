package pq;

import cr.h;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import np.o0;
import np.p0;
import np.r0;
import np.s0;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCEdDSAPublicKey;
import rp.j;
import rp.m;

/* JADX INFO: loaded from: classes7.dex */
public class d extends SignatureSpi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f47008c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f47010b;

    public static final class a extends d {
        public a() {
            super(h.f25815b);
        }
    }

    public static final class b extends d {
        public b() {
            super(h.f25816c);
        }
    }

    public static final class c extends d {
        public c() {
            super(null);
        }
    }

    public d(String str) {
        this.f47009a = str;
    }

    public static np.c a(Key key) throws InvalidKeyException {
        if (key instanceof BCEdDSAPrivateKey) {
            return ((BCEdDSAPrivateKey) key).a();
        }
        throw new InvalidKeyException("cannot identify EdDSA private key");
    }

    public static np.c b(Key key) throws InvalidKeyException {
        if (key instanceof BCEdDSAPublicKey) {
            return ((BCEdDSAPublicKey) key).a();
        }
        throw new InvalidKeyException("cannot identify EdDSA public key");
    }

    public final e0 c(String str) throws InvalidKeyException {
        String str2 = this.f47009a;
        if (str2 == null || str.equals(str2)) {
            return str.equals(h.f25816c) ? new m(f47008c) : new j();
        }
        throw new InvalidKeyException("inappropriate key for " + this.f47009a);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        String str;
        np.c cVarA = a(privateKey);
        if (cVarA instanceof o0) {
            str = h.f25815b;
        } else {
            if (!(cVarA instanceof r0)) {
                throw new IllegalStateException("unsupported private key type");
            }
            str = h.f25816c;
        }
        this.f47010b = c(str);
        this.f47010b.a(true, cVarA);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        String str;
        np.c cVarB = b(publicKey);
        if (cVarB instanceof p0) {
            str = h.f25815b;
        } else {
            if (!(cVarB instanceof s0)) {
                throw new IllegalStateException("unsupported public key type");
            }
            str = h.f25816c;
        }
        this.f47010b = c(str);
        this.f47010b.a(false, cVarB);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f47010b.e();
        } catch (CryptoException e10) {
            throw new SignatureException(e10.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f47010b.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f47010b.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.f47010b.d(bArr);
    }
}
