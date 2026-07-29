package pq;

import cr.w;
import cr.x;
import fp.z;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import np.m2;
import np.p2;
import np.r2;
import np.s2;
import org.bouncycastle.crypto.d0;
import org.bouncycastle.crypto.q;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.edec.BCXDHPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d0 f46984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public cr.f f46985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f46986k;

    /* JADX INFO: renamed from: pq.a$a, reason: collision with other inner class name */
    public static final class C0534a extends a {
        public C0534a() {
            super(x.f25873b);
        }
    }

    public static class b extends a {
        public b() {
            super("X25519UwithSHA256CKDF", new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class c extends a {
        public c() {
            super("X25519UwithSHA256KDF", new z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static final class d extends a {
        public d() {
            super("X25519withSHA256CKDF", new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static final class e extends a {
        public e() {
            super("X25519withSHA256KDF", new z(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class f extends a {
        public f() {
            super("X25519withSHA384CKDF", new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static class g extends a {
        public g() {
            super("X25519withSHA512CKDF", new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static final class h extends a {
        public h() {
            super(x.f25874c);
        }
    }

    public static class i extends a {
        public i() {
            super("X448UwithSHA512CKDF", new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static class j extends a {
        public j() {
            super("X448UwithSHA512KDF", new z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static final class k extends a {
        public k() {
            super("X448withSHA256CKDF", new wo.a(org.bouncycastle.crypto.util.f.e()));
        }
    }

    public static class l extends a {
        public l() {
            super("X448withSHA384CKDF", new wo.a(org.bouncycastle.crypto.util.f.f()));
        }
    }

    public static final class m extends a {
        public m() {
            super("X448withSHA512CKDF", new wo.a(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static final class n extends a {
        public n() {
            super("X448withSHA512KDF", new z(org.bouncycastle.crypto.util.f.k()));
        }
    }

    public static final class o extends a {
        public o() {
            super("XDH");
        }
    }

    public a(String str) {
        super(str, null);
    }

    public a(String str, q qVar) {
        super(str, qVar);
    }

    public static np.c g(Key key) throws InvalidKeyException {
        if (key instanceof BCXDHPrivateKey) {
            return ((BCXDHPrivateKey) key).a();
        }
        throw new InvalidKeyException("cannot identify XDH private key");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a
    public byte[] a() {
        return this.f46986k;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z10) throws IllegalStateException, InvalidKeyException {
        if (this.f46984i == null) {
            throw new IllegalStateException(this.f45048a + " not initialised.");
        }
        if (!z10) {
            throw new IllegalStateException(this.f45048a + " can only be between two parties.");
        }
        np.c cVarH = h(key);
        byte[] bArr = new byte[this.f46984i.c()];
        this.f46986k = bArr;
        cr.f fVar = this.f46985j;
        if (fVar != null) {
            this.f46984i.b(new s2(cVarH, ((BCXDHPublicKey) fVar.c()).a()), this.f46986k, 0);
            return null;
        }
        this.f46984i.b(cVarH, bArr, 0);
        return null;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        String str;
        np.c cVarG = g(key);
        if (cVarG instanceof m2) {
            str = x.f25873b;
        } else {
            if (!(cVarG instanceof p2)) {
                throw new IllegalStateException("unsupported private key type");
            }
            str = x.f25874c;
        }
        this.f46984i = f(str);
        this.f46984i.a(cVarG);
        if (this.f45049b != null) {
            this.f45050c = new byte[0];
        } else {
            this.f45050c = null;
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        np.c cVarG = g(key);
        if (cVarG instanceof m2) {
            str = x.f25873b;
        } else {
            if (!(cVarG instanceof p2)) {
                throw new IllegalStateException("unsupported private key type");
            }
            str = x.f25874c;
        }
        this.f46984i = f(str);
        this.f45050c = null;
        if (!(algorithmParameterSpec instanceof cr.f)) {
            this.f46984i.a(cVarG);
            if (!(algorithmParameterSpec instanceof w)) {
                throw new InvalidAlgorithmParameterException("unknown ParameterSpec");
            }
            if (this.f45049b == null) {
                throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
            }
            this.f45050c = ((w) algorithmParameterSpec).a();
        } else {
            if (this.f45048a.indexOf(85) < 0) {
                throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
            }
            cr.f fVar = (cr.f) algorithmParameterSpec;
            this.f46985j = fVar;
            this.f45050c = fVar.d();
            this.f46984i.a(new r2(cVarG, ((BCXDHPrivateKey) this.f46985j.a()).a(), ((BCXDHPublicKey) this.f46985j.b()).a()));
        }
        if (this.f45049b == null || this.f45050c != null) {
            return;
        }
        this.f45050c = new byte[0];
    }

    public final d0 f(String str) throws InvalidKeyException {
        if (this.f45048a.equals("XDH") || this.f45048a.startsWith(str)) {
            int iIndexOf = this.f45048a.indexOf(85);
            boolean zStartsWith = str.startsWith(x.f25874c);
            return iIndexOf > 0 ? zStartsWith ? new uo.o(new uo.n()) : new uo.o(new uo.m()) : zStartsWith ? new uo.n() : new uo.m();
        }
        throw new InvalidKeyException("inappropriate key for " + this.f45048a);
    }

    public final np.c h(Key key) throws InvalidKeyException {
        if (key instanceof BCXDHPublicKey) {
            return ((BCXDHPublicKey) key).a();
        }
        throw new InvalidKeyException("cannot identify XDH public key");
    }
}
